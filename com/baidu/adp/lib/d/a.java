package com.baidu.adp.lib.d;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a Ch = null;
    public long Cf = 10000;
    public long Cg = 0;
    private long Ci = ReportUserInfoModel.TIME_INTERVAL;
    private boolean Cj = false;
    private boolean Ck = false;
    private boolean Cl = false;
    private int errorCode = 4;
    private Address Cm = null;
    private ArrayList<SoftReference<InterfaceC0015a>> Cn = null;
    private ArrayList<com.baidu.adp.lib.d.b> Co = new ArrayList<>();
    private Handler handler = null;
    private b Cp = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.Cg = j;
            a.this.Cm = address;
            a.this.Cj = z;
            a.this.errorCode = i;
            a.this.iZ();
            switch (i) {
                case 1:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                        break;
                    }
                    break;
                case 2:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                        break;
                    }
                    break;
                case 3:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                        break;
                    }
                    break;
                case 4:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                        break;
                    }
                    break;
            }
            a.this.a(i, str, address);
        }
    };

    /* renamed from: com.baidu.adp.lib.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0015a {
        void b(int i, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, Address address, long j, boolean z);
    }

    private a() {
    }

    public static a iW() {
        if (Ch == null) {
            synchronized (a.class) {
                if (Ch == null) {
                    Ch = new a();
                }
            }
        }
        return Ch;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.Co) {
                if (!this.Co.contains(bVar)) {
                    bVar.a(this.Cp);
                    this.Co.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.Co) {
                bVar.destroy();
                this.Co.remove(bVar);
            }
        }
    }

    public void initial() {
        this.Cn = new ArrayList<>();
        iX();
    }

    private void iX() {
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.adp.lib.d.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.iZ();
                        String str = "";
                        switch (a.this.errorCode) {
                            case 1:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                                break;
                            case 2:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                                break;
                            case 3:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                                break;
                            case 4:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                                break;
                            case 6:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                                break;
                        }
                        a.this.a(a.this.errorCode, str, (Address) null);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    public long iY() {
        return this.Cf;
    }

    public Address af(boolean z) {
        return d(z, false);
    }

    public Address d(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.Cg > this.Ci) {
            this.Cm = null;
        }
        if (this.Cm != null && !z && ((z2 && this.Cj) || !z2)) {
            return this.Cm;
        }
        this.Cm = null;
        if (!this.Cl) {
            ag(z2);
            return null;
        } else if (this.Cl && z2 && !this.Ck) {
            iZ();
            ag(z2);
            return null;
        } else {
            return null;
        }
    }

    public Address a(boolean z, InterfaceC0015a interfaceC0015a) {
        return a(z, false, interfaceC0015a);
    }

    public Address a(boolean z, boolean z2, InterfaceC0015a interfaceC0015a) {
        boolean z3;
        InterfaceC0015a interfaceC0015a2;
        if (System.currentTimeMillis() - this.Cg > this.Ci) {
            this.Cm = null;
        }
        if (this.Cm != null && !z && ((z2 && this.Cj) || !z2)) {
            if (interfaceC0015a != null) {
                interfaceC0015a.b(0, "", this.Cm);
            }
            return this.Cm;
        }
        if (interfaceC0015a != null) {
            synchronized (this.Cn) {
                int i = 0;
                while (true) {
                    if (i >= this.Cn.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0015a> softReference = this.Cn.get(i);
                    if (softReference == null || (interfaceC0015a2 = softReference.get()) == null || !interfaceC0015a2.equals(interfaceC0015a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.Cn.size() >= 100) {
                        this.Cn.remove(0);
                    }
                    this.Cn.add(new SoftReference<>(interfaceC0015a));
                }
            }
            if (!this.Cl) {
                ag(z2);
                return null;
            } else if (this.Cl && z2 && !this.Ck) {
                iZ();
                ag(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0015a interfaceC0015a) {
        InterfaceC0015a interfaceC0015a2;
        synchronized (this.Cn) {
            int i = 0;
            while (true) {
                if (i < this.Cn.size()) {
                    SoftReference<InterfaceC0015a> softReference = this.Cn.get(i);
                    if (softReference == null || (interfaceC0015a2 = softReference.get()) == null || !interfaceC0015a2.equals(interfaceC0015a)) {
                        i++;
                    } else {
                        this.Cn.remove(softReference);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iZ() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.Cl = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.Co.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.ja();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void ag(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.Ck = z;
        this.Cl = true;
        if (this.Co == null || this.Co.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.Co.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.ah(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.Cf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0015a interfaceC0015a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.Cn != null) {
            synchronized (this.Cn) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.Cn.size()) {
                        SoftReference<InterfaceC0015a> softReference = this.Cn.get(i3);
                        if (softReference != null && (interfaceC0015a = softReference.get()) != null) {
                            interfaceC0015a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.Cn.clear();
                    }
                }
            }
        }
    }
}
