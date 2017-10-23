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
    private static a uv = null;
    public long ut = 10000;
    public long uu = 0;
    private long uw = ReportUserInfoModel.TIME_INTERVAL;
    private boolean ux = false;
    private boolean uy = false;
    private boolean uz = false;
    private int errorCode = 4;
    private Address uA = null;
    private ArrayList<SoftReference<InterfaceC0004a>> uB = null;
    private ArrayList<com.baidu.adp.lib.d.b> uC = new ArrayList<>();
    private Handler handler = null;
    private b uD = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.uu = j;
            a.this.uA = address;
            a.this.ux = z;
            a.this.errorCode = i;
            a.this.ff();
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
    public interface InterfaceC0004a {
        void b(int i, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, Address address, long j, boolean z);
    }

    private a() {
    }

    public static a fc() {
        if (uv == null) {
            synchronized (a.class) {
                if (uv == null) {
                    uv = new a();
                }
            }
        }
        return uv;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.uC) {
                if (!this.uC.contains(bVar)) {
                    bVar.a(this.uD);
                    this.uC.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.uC) {
                bVar.destroy();
                this.uC.remove(bVar);
            }
        }
    }

    public void initial() {
        this.uB = new ArrayList<>();
        fd();
    }

    private void fd() {
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.adp.lib.d.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.ff();
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

    public long fe() {
        return this.ut;
    }

    public Address D(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.uu > this.uw) {
            this.uA = null;
        }
        if (this.uA != null && !z && ((z2 && this.ux) || !z2)) {
            return this.uA;
        }
        this.uA = null;
        if (!this.uz) {
            E(z2);
            return null;
        } else if (this.uz && z2 && !this.uy) {
            ff();
            E(z2);
            return null;
        } else {
            return null;
        }
    }

    public Address a(boolean z, InterfaceC0004a interfaceC0004a) {
        return a(z, false, interfaceC0004a);
    }

    public Address a(boolean z, boolean z2, InterfaceC0004a interfaceC0004a) {
        boolean z3;
        InterfaceC0004a interfaceC0004a2;
        if (System.currentTimeMillis() - this.uu > this.uw) {
            this.uA = null;
        }
        if (this.uA != null && !z && ((z2 && this.ux) || !z2)) {
            if (interfaceC0004a != null) {
                interfaceC0004a.b(0, "", this.uA);
            }
            return this.uA;
        }
        if (interfaceC0004a != null) {
            synchronized (this.uB) {
                int i = 0;
                while (true) {
                    if (i >= this.uB.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0004a> softReference = this.uB.get(i);
                    if (softReference == null || (interfaceC0004a2 = softReference.get()) == null || !interfaceC0004a2.equals(interfaceC0004a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.uB.size() >= 100) {
                        this.uB.remove(0);
                    }
                    this.uB.add(new SoftReference<>(interfaceC0004a));
                }
            }
            if (!this.uz) {
                E(z2);
                return null;
            } else if (this.uz && z2 && !this.uy) {
                ff();
                E(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0004a interfaceC0004a) {
        InterfaceC0004a interfaceC0004a2;
        synchronized (this.uB) {
            int i = 0;
            while (true) {
                if (i < this.uB.size()) {
                    SoftReference<InterfaceC0004a> softReference = this.uB.get(i);
                    if (softReference == null || (interfaceC0004a2 = softReference.get()) == null || !interfaceC0004a2.equals(interfaceC0004a)) {
                        i++;
                    } else {
                        this.uB.remove(softReference);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ff() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.uz = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.uC.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.fg();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void E(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.uy = z;
        this.uz = true;
        if (this.uC == null || this.uC.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.uC.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.F(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.ut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0004a interfaceC0004a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.uB != null) {
            synchronized (this.uB) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.uB.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.uB.get(i3);
                        if (softReference != null && (interfaceC0004a = softReference.get()) != null) {
                            interfaceC0004a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.uB.clear();
                    }
                }
            }
        }
    }
}
