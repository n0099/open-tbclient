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
    private static a zO = null;
    public long zM = 10000;
    public long zN = 0;
    private long zP = ReportUserInfoModel.TIME_INTERVAL;
    private boolean zQ = false;
    private boolean zR = false;
    private boolean zS = false;
    private int errorCode = 4;
    private Address zT = null;
    private ArrayList<SoftReference<InterfaceC0015a>> zU = null;
    private ArrayList<com.baidu.adp.lib.d.b> zV = new ArrayList<>();
    private Handler handler = null;
    private b zW = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.zN = j;
            a.this.zT = address;
            a.this.zQ = z;
            a.this.errorCode = i;
            a.this.hR();
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

    public static a hO() {
        if (zO == null) {
            synchronized (a.class) {
                if (zO == null) {
                    zO = new a();
                }
            }
        }
        return zO;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.zV) {
                if (!this.zV.contains(bVar)) {
                    bVar.a(this.zW);
                    this.zV.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.zV) {
                bVar.destroy();
                this.zV.remove(bVar);
            }
        }
    }

    public void initial() {
        this.zU = new ArrayList<>();
        hP();
    }

    private void hP() {
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.adp.lib.d.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.hR();
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

    public long hQ() {
        return this.zM;
    }

    public Address X(boolean z) {
        return c(z, false);
    }

    public Address c(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.zN > this.zP) {
            this.zT = null;
        }
        if (this.zT != null && !z && ((z2 && this.zQ) || !z2)) {
            return this.zT;
        }
        this.zT = null;
        if (!this.zS) {
            Y(z2);
            return null;
        } else if (this.zS && z2 && !this.zR) {
            hR();
            Y(z2);
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
        if (System.currentTimeMillis() - this.zN > this.zP) {
            this.zT = null;
        }
        if (this.zT != null && !z && ((z2 && this.zQ) || !z2)) {
            if (interfaceC0015a != null) {
                interfaceC0015a.b(0, "", this.zT);
            }
            return this.zT;
        }
        if (interfaceC0015a != null) {
            synchronized (this.zU) {
                int i = 0;
                while (true) {
                    if (i >= this.zU.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0015a> softReference = this.zU.get(i);
                    if (softReference == null || (interfaceC0015a2 = softReference.get()) == null || !interfaceC0015a2.equals(interfaceC0015a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.zU.size() >= 100) {
                        this.zU.remove(0);
                    }
                    this.zU.add(new SoftReference<>(interfaceC0015a));
                }
            }
            if (!this.zS) {
                Y(z2);
                return null;
            } else if (this.zS && z2 && !this.zR) {
                hR();
                Y(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0015a interfaceC0015a) {
        InterfaceC0015a interfaceC0015a2;
        synchronized (this.zU) {
            int i = 0;
            while (true) {
                if (i < this.zU.size()) {
                    SoftReference<InterfaceC0015a> softReference = this.zU.get(i);
                    if (softReference == null || (interfaceC0015a2 = softReference.get()) == null || !interfaceC0015a2.equals(interfaceC0015a)) {
                        i++;
                    } else {
                        this.zU.remove(softReference);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hR() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.zS = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.zV.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.hS();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void Y(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.zR = z;
        this.zS = true;
        if (this.zV == null || this.zV.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.zV.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.Z(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.zM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0015a interfaceC0015a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.zU != null) {
            synchronized (this.zU) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.zU.size()) {
                        SoftReference<InterfaceC0015a> softReference = this.zU.get(i3);
                        if (softReference != null && (interfaceC0015a = softReference.get()) != null) {
                            interfaceC0015a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.zU.clear();
                    }
                }
            }
        }
    }
}
