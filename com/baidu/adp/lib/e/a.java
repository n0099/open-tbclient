package com.baidu.adp.lib.e;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.util.BdLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a nF = null;
    public long nD = 10000;
    public long nE = 0;
    private long nG = 300000;
    private boolean nH = false;
    private boolean nI = false;
    private boolean nJ = false;
    private int errorCode = 4;
    private Address nK = null;
    private ArrayList<SoftReference<InterfaceC0005a>> nL = null;
    private ArrayList<d> nM = new ArrayList<>();
    private Handler handler = null;
    private b nN = new com.baidu.adp.lib.e.b(this);

    /* renamed from: com.baidu.adp.lib.e.a$a  reason: collision with other inner class name */
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

    public static a dU() {
        if (nF == null) {
            synchronized (a.class) {
                if (nF == null) {
                    nF = new a();
                }
            }
        }
        return nF;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.nM) {
                if (!this.nM.contains(dVar)) {
                    dVar.a(this.nN);
                    this.nM.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.nM) {
                dVar.destroy();
                this.nM.remove(dVar);
            }
        }
    }

    public void initial() {
        this.nL = new ArrayList<>();
        dV();
    }

    private void dV() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public long dW() {
        return this.nD;
    }

    public Address B(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.nE > this.nG) {
            this.nK = null;
        }
        if (this.nK != null && !z && ((z2 && this.nH) || !z2)) {
            return this.nK;
        }
        this.nK = null;
        if (!this.nJ) {
            C(z2);
            return null;
        } else if (this.nJ && z2 && !this.nI) {
            dX();
            C(z2);
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
        if (System.currentTimeMillis() - this.nE > this.nG) {
            this.nK = null;
        }
        if (this.nK != null && !z && ((z2 && this.nH) || !z2)) {
            if (interfaceC0005a != null) {
                interfaceC0005a.b(0, "", this.nK);
            }
            return this.nK;
        }
        if (interfaceC0005a != null) {
            synchronized (this.nL) {
                int i = 0;
                while (true) {
                    if (i < this.nL.size()) {
                        SoftReference<InterfaceC0005a> softReference = this.nL.get(i);
                        if (softReference == null || (interfaceC0005a2 = softReference.get()) == null || !interfaceC0005a2.equals(interfaceC0005a)) {
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
                    if (this.nL.size() >= 100) {
                        this.nL.remove(0);
                    }
                    this.nL.add(new SoftReference<>(interfaceC0005a));
                }
            }
            if (!this.nJ) {
                C(z2);
                return null;
            } else if (this.nJ && z2 && !this.nI) {
                dX();
                C(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0005a interfaceC0005a) {
        InterfaceC0005a interfaceC0005a2;
        synchronized (this.nL) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.nL.size()) {
                    break;
                }
                SoftReference<InterfaceC0005a> softReference = this.nL.get(i2);
                if (softReference == null || (interfaceC0005a2 = softReference.get()) == null || !interfaceC0005a2.equals(interfaceC0005a)) {
                    i = i2 + 1;
                } else {
                    this.nL.remove(softReference);
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dX() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.nJ = false;
        Iterator<d> it = this.nM.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.dY();
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
        this.nI = z;
        this.nJ = true;
        if (this.nM == null || this.nM.isEmpty()) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.nD);
            return;
        }
        Iterator<d> it = this.nM.iterator();
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
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.nD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0005a interfaceC0005a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.nL != null) {
            synchronized (this.nL) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.nL.size()) {
                        SoftReference<InterfaceC0005a> softReference = this.nL.get(i3);
                        if (softReference != null && (interfaceC0005a = softReference.get()) != null) {
                            interfaceC0005a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.nL.clear();
                    }
                }
            }
        }
    }
}
