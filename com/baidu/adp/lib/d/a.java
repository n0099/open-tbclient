package com.baidu.adp.lib.d;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.util.BdLog;
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
    private ArrayList<SoftReference<InterfaceC0004a>> vd = null;
    private ArrayList<d> ve = new ArrayList<>();
    private Handler handler = null;
    private b vf = new com.baidu.adp.lib.d.b(this);

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

    public static a fg() {
        if (uX == null) {
            synchronized (a.class) {
                if (uX == null) {
                    uX = new a();
                }
            }
        }
        return uX;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.ve) {
                if (!this.ve.contains(dVar)) {
                    dVar.a(this.vf);
                    this.ve.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.ve) {
                dVar.destroy();
                this.ve.remove(dVar);
            }
        }
    }

    public void initial() {
        this.vd = new ArrayList<>();
        fh();
    }

    private void fh() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public long fi() {
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
            fj();
            D(z2);
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
        if (System.currentTimeMillis() - this.uW > this.uY) {
            this.vc = null;
        }
        if (this.vc != null && !z && ((z2 && this.uZ) || !z2)) {
            if (interfaceC0004a != null) {
                interfaceC0004a.b(0, "", this.vc);
            }
            return this.vc;
        }
        if (interfaceC0004a != null) {
            synchronized (this.vd) {
                int i = 0;
                while (true) {
                    if (i < this.vd.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.vd.get(i);
                        if (softReference == null || (interfaceC0004a2 = softReference.get()) == null || !interfaceC0004a2.equals(interfaceC0004a)) {
                            i++;
                        } else {
                            z3 = true;
                            break;
                        }
                    } else {
                        z3 = false;
                        break;
                    }
                }
                if (!z3) {
                    if (this.vd.size() >= 100) {
                        this.vd.remove(0);
                    }
                    this.vd.add(new SoftReference<>(interfaceC0004a));
                }
            }
            if (!this.vb) {
                D(z2);
                return null;
            } else if (this.vb && z2 && !this.va) {
                fj();
                D(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0004a interfaceC0004a) {
        InterfaceC0004a interfaceC0004a2;
        synchronized (this.vd) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.vd.size()) {
                    break;
                }
                SoftReference<InterfaceC0004a> softReference = this.vd.get(i2);
                if (softReference == null || (interfaceC0004a2 = softReference.get()) == null || !interfaceC0004a2.equals(interfaceC0004a)) {
                    i = i2 + 1;
                } else {
                    this.vd.remove(softReference);
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fj() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.vb = false;
        Iterator<d> it = this.ve.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.fk();
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
        Iterator<d> it = this.ve.iterator();
        while (it.hasNext()) {
            d next = it.next();
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
        InterfaceC0004a interfaceC0004a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.vd != null) {
            synchronized (this.vd) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.vd.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.vd.get(i3);
                        if (softReference != null && (interfaceC0004a = softReference.get()) != null) {
                            interfaceC0004a.b(i, str, address);
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
