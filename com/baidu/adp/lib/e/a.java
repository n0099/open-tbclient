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
    private static a uA = null;
    public long uy = 10000;
    public long uz = 0;
    private long uB = 300000;
    private boolean uC = false;
    private boolean uD = false;
    private boolean uE = false;
    private int errorCode = 4;
    private Address uF = null;
    private ArrayList<SoftReference<InterfaceC0004a>> uG = null;
    private ArrayList<d> uH = new ArrayList<>();
    private Handler handler = null;
    private b uI = new com.baidu.adp.lib.e.b(this);

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

    public static a gD() {
        if (uA == null) {
            synchronized (a.class) {
                if (uA == null) {
                    uA = new a();
                }
            }
        }
        return uA;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.uH) {
                if (!this.uH.contains(dVar)) {
                    dVar.a(this.uI);
                    this.uH.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.uH) {
                dVar.destroy();
                this.uH.remove(dVar);
            }
        }
    }

    public void initial() {
        this.uG = new ArrayList<>();
        gE();
    }

    private void gE() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public long gF() {
        return this.uy;
    }

    public Address y(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.uz > this.uB) {
            this.uF = null;
        }
        if (this.uF != null && !z && ((z2 && this.uC) || !z2)) {
            return this.uF;
        }
        this.uF = null;
        if (!this.uE) {
            z(z2);
            return null;
        } else if (this.uE && z2 && !this.uD) {
            gG();
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
        if (System.currentTimeMillis() - this.uz > this.uB) {
            this.uF = null;
        }
        if (this.uF != null && !z && ((z2 && this.uC) || !z2)) {
            if (interfaceC0004a != null) {
                interfaceC0004a.b(0, "", this.uF);
            }
            return this.uF;
        }
        if (interfaceC0004a != null) {
            synchronized (this.uG) {
                int i = 0;
                while (true) {
                    if (i < this.uG.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.uG.get(i);
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
                    if (this.uG.size() >= 100) {
                        this.uG.remove(0);
                    }
                    this.uG.add(new SoftReference<>(interfaceC0004a));
                }
            }
            if (!this.uE) {
                z(z2);
                return null;
            } else if (this.uE && z2 && !this.uD) {
                gG();
                z(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0004a interfaceC0004a) {
        InterfaceC0004a interfaceC0004a2;
        synchronized (this.uG) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.uG.size()) {
                    break;
                }
                SoftReference<InterfaceC0004a> softReference = this.uG.get(i2);
                if (softReference == null || (interfaceC0004a2 = softReference.get()) == null || !interfaceC0004a2.equals(interfaceC0004a)) {
                    i = i2 + 1;
                } else {
                    this.uG.remove(softReference);
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.uE = false;
        Iterator<d> it = this.uH.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.gH();
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
        this.uD = z;
        this.uE = true;
        if (this.uH == null || this.uH.isEmpty()) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.uy);
            return;
        }
        Iterator<d> it = this.uH.iterator();
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
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.uy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0004a interfaceC0004a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.uG != null) {
            synchronized (this.uG) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.uG.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.uG.get(i3);
                        if (softReference != null && (interfaceC0004a = softReference.get()) != null) {
                            interfaceC0004a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.uG.clear();
                    }
                }
            }
        }
    }
}
