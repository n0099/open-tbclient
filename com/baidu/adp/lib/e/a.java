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
    private static a nG = null;
    public long nE = 10000;
    public long nF = 0;
    private long nH = 300000;
    private boolean nI = false;
    private boolean nJ = false;
    private boolean nK = false;
    private int errorCode = 4;
    private Address nL = null;
    private ArrayList<SoftReference<InterfaceC0005a>> nM = null;
    private ArrayList<d> nN = new ArrayList<>();
    private Handler handler = null;
    private b nO = new com.baidu.adp.lib.e.b(this);

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
        if (nG == null) {
            synchronized (a.class) {
                if (nG == null) {
                    nG = new a();
                }
            }
        }
        return nG;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.nN) {
                if (!this.nN.contains(dVar)) {
                    dVar.a(this.nO);
                    this.nN.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.nN) {
                dVar.destroy();
                this.nN.remove(dVar);
            }
        }
    }

    public void initial() {
        this.nM = new ArrayList<>();
        dV();
    }

    private void dV() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public long dW() {
        return this.nE;
    }

    public Address B(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.nF > this.nH) {
            this.nL = null;
        }
        if (this.nL != null && !z && ((z2 && this.nI) || !z2)) {
            return this.nL;
        }
        this.nL = null;
        if (!this.nK) {
            C(z2);
            return null;
        } else if (this.nK && z2 && !this.nJ) {
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
        if (System.currentTimeMillis() - this.nF > this.nH) {
            this.nL = null;
        }
        if (this.nL != null && !z && ((z2 && this.nI) || !z2)) {
            if (interfaceC0005a != null) {
                interfaceC0005a.b(0, "", this.nL);
            }
            return this.nL;
        }
        if (interfaceC0005a != null) {
            synchronized (this.nM) {
                int i = 0;
                while (true) {
                    if (i < this.nM.size()) {
                        SoftReference<InterfaceC0005a> softReference = this.nM.get(i);
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
                    if (this.nM.size() >= 100) {
                        this.nM.remove(0);
                    }
                    this.nM.add(new SoftReference<>(interfaceC0005a));
                }
            }
            if (!this.nK) {
                C(z2);
                return null;
            } else if (this.nK && z2 && !this.nJ) {
                dX();
                C(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0005a interfaceC0005a) {
        InterfaceC0005a interfaceC0005a2;
        synchronized (this.nM) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.nM.size()) {
                    break;
                }
                SoftReference<InterfaceC0005a> softReference = this.nM.get(i2);
                if (softReference == null || (interfaceC0005a2 = softReference.get()) == null || !interfaceC0005a2.equals(interfaceC0005a)) {
                    i = i2 + 1;
                } else {
                    this.nM.remove(softReference);
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
        this.nK = false;
        Iterator<d> it = this.nN.iterator();
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
        this.nJ = z;
        this.nK = true;
        if (this.nN == null || this.nN.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<d> it = this.nN.iterator();
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
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.nE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0005a interfaceC0005a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.nM != null) {
            synchronized (this.nM) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.nM.size()) {
                        SoftReference<InterfaceC0005a> softReference = this.nM.get(i3);
                        if (softReference != null && (interfaceC0005a = softReference.get()) != null) {
                            interfaceC0005a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.nM.clear();
                    }
                }
            }
        }
    }
}
