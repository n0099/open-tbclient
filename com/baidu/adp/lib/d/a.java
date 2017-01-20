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
    private static a nz = null;
    public long nx = 10000;
    public long ny = 0;
    private long nA = ReportUserInfoModel.TIME_INTERVAL;
    private boolean nB = false;
    private boolean nC = false;
    private boolean nD = false;
    private int errorCode = 4;
    private Address nE = null;
    private ArrayList<SoftReference<InterfaceC0004a>> nF = null;
    private ArrayList<d> nG = new ArrayList<>();
    private Handler handler = null;
    private b nH = new com.baidu.adp.lib.d.b(this);

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

    public static a dS() {
        if (nz == null) {
            synchronized (a.class) {
                if (nz == null) {
                    nz = new a();
                }
            }
        }
        return nz;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.nG) {
                if (!this.nG.contains(dVar)) {
                    dVar.a(this.nH);
                    this.nG.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.nG) {
                dVar.destroy();
                this.nG.remove(dVar);
            }
        }
    }

    public void initial() {
        this.nF = new ArrayList<>();
        dT();
    }

    private void dT() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public long dU() {
        return this.nx;
    }

    public Address B(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.ny > this.nA) {
            this.nE = null;
        }
        if (this.nE != null && !z && ((z2 && this.nB) || !z2)) {
            return this.nE;
        }
        this.nE = null;
        if (!this.nD) {
            C(z2);
            return null;
        } else if (this.nD && z2 && !this.nC) {
            dV();
            C(z2);
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
        if (System.currentTimeMillis() - this.ny > this.nA) {
            this.nE = null;
        }
        if (this.nE != null && !z && ((z2 && this.nB) || !z2)) {
            if (interfaceC0004a != null) {
                interfaceC0004a.b(0, "", this.nE);
            }
            return this.nE;
        }
        if (interfaceC0004a != null) {
            synchronized (this.nF) {
                int i = 0;
                while (true) {
                    if (i < this.nF.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.nF.get(i);
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
                    if (this.nF.size() >= 100) {
                        this.nF.remove(0);
                    }
                    this.nF.add(new SoftReference<>(interfaceC0004a));
                }
            }
            if (!this.nD) {
                C(z2);
                return null;
            } else if (this.nD && z2 && !this.nC) {
                dV();
                C(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0004a interfaceC0004a) {
        InterfaceC0004a interfaceC0004a2;
        synchronized (this.nF) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.nF.size()) {
                    break;
                }
                SoftReference<InterfaceC0004a> softReference = this.nF.get(i2);
                if (softReference == null || (interfaceC0004a2 = softReference.get()) == null || !interfaceC0004a2.equals(interfaceC0004a)) {
                    i = i2 + 1;
                } else {
                    this.nF.remove(softReference);
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dV() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.nD = false;
        Iterator<d> it = this.nG.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.dW();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void C(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.nC = z;
        this.nD = true;
        if (this.nG == null || this.nG.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<d> it = this.nG.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.D(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.nx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0004a interfaceC0004a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.nF != null) {
            synchronized (this.nF) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.nF.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.nF.get(i3);
                        if (softReference != null && (interfaceC0004a = softReference.get()) != null) {
                            interfaceC0004a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.nF.clear();
                    }
                }
            }
        }
    }
}
