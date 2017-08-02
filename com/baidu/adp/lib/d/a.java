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
    private static a uX = null;
    public long uV = 10000;
    public long uW = 0;
    private long uY = ReportUserInfoModel.TIME_INTERVAL;
    private boolean uZ = false;
    private boolean va = false;
    private boolean vb = false;
    private int errorCode = 4;
    private Address vc = null;
    private ArrayList<SoftReference<InterfaceC0005a>> vd = null;
    private ArrayList<com.baidu.adp.lib.d.b> ve = new ArrayList<>();
    private Handler handler = null;
    private b vf = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.uW = j;
            a.this.vc = address;
            a.this.uZ = z;
            a.this.errorCode = i;
            a.this.fg();
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
    public interface InterfaceC0005a {
        void b(int i, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, Address address, long j, boolean z);
    }

    private a() {
    }

    public static a fd() {
        if (uX == null) {
            synchronized (a.class) {
                if (uX == null) {
                    uX = new a();
                }
            }
        }
        return uX;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.ve) {
                if (!this.ve.contains(bVar)) {
                    bVar.a(this.vf);
                    this.ve.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.ve) {
                bVar.destroy();
                this.ve.remove(bVar);
            }
        }
    }

    public void initial() {
        this.vd = new ArrayList<>();
        fe();
    }

    private void fe() {
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.adp.lib.d.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.fg();
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

    public long ff() {
        return this.uV;
    }

    public Address C(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.uW > this.uY) {
            this.vc = null;
        }
        if (this.vc != null && !z && ((z2 && this.uZ) || !z2)) {
            return this.vc;
        }
        this.vc = null;
        if (!this.vb) {
            D(z2);
            return null;
        } else if (this.vb && z2 && !this.va) {
            fg();
            D(z2);
            return null;
        } else {
            return null;
        }
    }

    public Address a(boolean z, InterfaceC0005a interfaceC0005a) {
        return a(z, false, interfaceC0005a);
    }

    public Address a(boolean z, boolean z2, InterfaceC0005a interfaceC0005a) {
        boolean z3;
        InterfaceC0005a interfaceC0005a2;
        if (System.currentTimeMillis() - this.uW > this.uY) {
            this.vc = null;
        }
        if (this.vc != null && !z && ((z2 && this.uZ) || !z2)) {
            if (interfaceC0005a != null) {
                interfaceC0005a.b(0, "", this.vc);
            }
            return this.vc;
        }
        if (interfaceC0005a != null) {
            synchronized (this.vd) {
                int i = 0;
                while (true) {
                    if (i >= this.vd.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0005a> softReference = this.vd.get(i);
                    if (softReference == null || (interfaceC0005a2 = softReference.get()) == null || !interfaceC0005a2.equals(interfaceC0005a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.vd.size() >= 100) {
                        this.vd.remove(0);
                    }
                    this.vd.add(new SoftReference<>(interfaceC0005a));
                }
            }
            if (!this.vb) {
                D(z2);
                return null;
            } else if (this.vb && z2 && !this.va) {
                fg();
                D(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0005a interfaceC0005a) {
        InterfaceC0005a interfaceC0005a2;
        synchronized (this.vd) {
            int i = 0;
            while (true) {
                if (i < this.vd.size()) {
                    SoftReference<InterfaceC0005a> softReference = this.vd.get(i);
                    if (softReference == null || (interfaceC0005a2 = softReference.get()) == null || !interfaceC0005a2.equals(interfaceC0005a)) {
                        i++;
                    } else {
                        this.vd.remove(softReference);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.vb = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.ve.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.fh();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void D(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.va = z;
        this.vb = true;
        if (this.ve == null || this.ve.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.ve.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.E(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.uV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0005a interfaceC0005a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.vd != null) {
            synchronized (this.vd) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.vd.size()) {
                        SoftReference<InterfaceC0005a> softReference = this.vd.get(i3);
                        if (softReference != null && (interfaceC0005a = softReference.get()) != null) {
                            interfaceC0005a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.vd.clear();
                    }
                }
            }
        }
    }
}
