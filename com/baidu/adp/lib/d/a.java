package com.baidu.adp.lib.d;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a Ce = null;
    public long Cc = ErrDef.Feature.WEIGHT;
    public long Cd = 0;
    private long Cf = ReportUserInfoModel.TIME_INTERVAL;
    private boolean Cg = false;
    private boolean Ch = false;
    private boolean Ci = false;
    private int errorCode = 4;
    private Address Cj = null;
    private ArrayList<SoftReference<InterfaceC0017a>> Ck = null;
    private ArrayList<com.baidu.adp.lib.d.b> Cl = new ArrayList<>();
    private Handler handler = null;
    private b Cm = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.Cd = j;
            a.this.Cj = address;
            a.this.Cg = z;
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
    public interface InterfaceC0017a {
        void b(int i, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, Address address, long j, boolean z);
    }

    private a() {
    }

    public static a iX() {
        if (Ce == null) {
            synchronized (a.class) {
                if (Ce == null) {
                    Ce = new a();
                }
            }
        }
        return Ce;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.Cl) {
                if (!this.Cl.contains(bVar)) {
                    bVar.a(this.Cm);
                    this.Cl.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.Cl) {
                bVar.destroy();
                this.Cl.remove(bVar);
            }
        }
    }

    public void initial() {
        this.Ck = new ArrayList<>();
        initHandler();
    }

    private void initHandler() {
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
        return this.Cc;
    }

    public Address R(boolean z) {
        return d(z, false);
    }

    public Address d(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.Cd > this.Cf) {
            this.Cj = null;
        }
        if (this.Cj != null && !z && ((z2 && this.Cg) || !z2)) {
            return this.Cj;
        }
        this.Cj = null;
        if (!this.Ci) {
            S(z2);
            return null;
        } else if (this.Ci && z2 && !this.Ch) {
            iZ();
            S(z2);
            return null;
        } else {
            return null;
        }
    }

    public Address a(boolean z, InterfaceC0017a interfaceC0017a) {
        return a(z, false, interfaceC0017a);
    }

    public Address a(boolean z, boolean z2, InterfaceC0017a interfaceC0017a) {
        boolean z3;
        InterfaceC0017a interfaceC0017a2;
        if (System.currentTimeMillis() - this.Cd > this.Cf) {
            this.Cj = null;
        }
        if (this.Cj != null && !z && ((z2 && this.Cg) || !z2)) {
            if (interfaceC0017a != null) {
                interfaceC0017a.b(0, "", this.Cj);
            }
            return this.Cj;
        }
        if (interfaceC0017a != null) {
            synchronized (this.Ck) {
                int i = 0;
                while (true) {
                    if (i >= this.Ck.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0017a> softReference = this.Ck.get(i);
                    if (softReference == null || (interfaceC0017a2 = softReference.get()) == null || !interfaceC0017a2.equals(interfaceC0017a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.Ck.size() >= 100) {
                        this.Ck.remove(0);
                    }
                    this.Ck.add(new SoftReference<>(interfaceC0017a));
                }
            }
            if (!this.Ci) {
                S(z2);
                return null;
            } else if (this.Ci && z2 && !this.Ch) {
                iZ();
                S(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0017a interfaceC0017a) {
        InterfaceC0017a interfaceC0017a2;
        synchronized (this.Ck) {
            int i = 0;
            while (true) {
                if (i < this.Ck.size()) {
                    SoftReference<InterfaceC0017a> softReference = this.Ck.get(i);
                    if (softReference == null || (interfaceC0017a2 = softReference.get()) == null || !interfaceC0017a2.equals(interfaceC0017a)) {
                        i++;
                    } else {
                        this.Ck.remove(softReference);
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
        this.Ci = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.Cl.iterator();
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

    private void S(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.Ch = z;
        this.Ci = true;
        if (this.Cl == null || this.Cl.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.Cl.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.T(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.Cc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0017a interfaceC0017a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.Ck != null) {
            synchronized (this.Ck) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.Ck.size()) {
                        SoftReference<InterfaceC0017a> softReference = this.Ck.get(i3);
                        if (softReference != null && (interfaceC0017a = softReference.get()) != null) {
                            interfaceC0017a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.Ck.clear();
                    }
                }
            }
        }
    }
}
