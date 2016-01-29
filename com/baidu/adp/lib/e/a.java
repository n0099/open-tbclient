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
    private static a uJ = null;
    public long uH = 10000;
    public long uI = 0;
    private long uK = 300000;
    private boolean uL = false;
    private boolean uM = false;
    private boolean uN = false;
    private int errorCode = 4;
    private Address uO = null;
    private ArrayList<SoftReference<InterfaceC0004a>> uP = null;
    private ArrayList<d> uQ = new ArrayList<>();
    private Handler handler = null;
    private b uR = new com.baidu.adp.lib.e.b(this);

    /* renamed from: com.baidu.adp.lib.e.a$a  reason: collision with other inner class name */
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

    public static a gL() {
        if (uJ == null) {
            synchronized (a.class) {
                if (uJ == null) {
                    uJ = new a();
                }
            }
        }
        return uJ;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.uQ) {
                if (!this.uQ.contains(dVar)) {
                    dVar.a(this.uR);
                    this.uQ.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.uQ) {
                dVar.destroy();
                this.uQ.remove(dVar);
            }
        }
    }

    public void initial() {
        this.uP = new ArrayList<>();
        gM();
    }

    private void gM() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public long gN() {
        return this.uH;
    }

    public Address y(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.uI > this.uK) {
            this.uO = null;
        }
        if (this.uO != null && !z && ((z2 && this.uL) || !z2)) {
            return this.uO;
        }
        this.uO = null;
        if (!this.uN) {
            z(z2);
            return null;
        } else if (this.uN && z2 && !this.uM) {
            gO();
            z(z2);
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
        if (System.currentTimeMillis() - this.uI > this.uK) {
            this.uO = null;
        }
        if (this.uO != null && !z && ((z2 && this.uL) || !z2)) {
            if (interfaceC0004a != null) {
                interfaceC0004a.b(0, "", this.uO);
            }
            return this.uO;
        }
        if (interfaceC0004a != null) {
            synchronized (this.uP) {
                int i = 0;
                while (true) {
                    if (i < this.uP.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.uP.get(i);
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
                    if (this.uP.size() >= 100) {
                        this.uP.remove(0);
                    }
                    this.uP.add(new SoftReference<>(interfaceC0004a));
                }
            }
            if (!this.uN) {
                z(z2);
                return null;
            } else if (this.uN && z2 && !this.uM) {
                gO();
                z(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0004a interfaceC0004a) {
        InterfaceC0004a interfaceC0004a2;
        synchronized (this.uP) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.uP.size()) {
                    break;
                }
                SoftReference<InterfaceC0004a> softReference = this.uP.get(i2);
                if (softReference == null || (interfaceC0004a2 = softReference.get()) == null || !interfaceC0004a2.equals(interfaceC0004a)) {
                    i = i2 + 1;
                } else {
                    this.uP.remove(softReference);
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.uN = false;
        Iterator<d> it = this.uQ.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.gP();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void z(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.uM = z;
        this.uN = true;
        if (this.uQ == null || this.uQ.isEmpty()) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.uH);
            return;
        }
        Iterator<d> it = this.uQ.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.A(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.uH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0004a interfaceC0004a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.uP != null) {
            synchronized (this.uP) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.uP.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.uP.get(i3);
                        if (softReference != null && (interfaceC0004a = softReference.get()) != null) {
                            interfaceC0004a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.uP.clear();
                    }
                }
            }
        }
    }
}
