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
    private static a uy = null;
    public long uw = 10000;
    public long ux = 0;
    private long uz = 300000;
    private boolean uA = false;
    private boolean uB = false;
    private boolean uC = false;
    private int errorCode = 4;
    private Address uD = null;
    private ArrayList<SoftReference<InterfaceC0003a>> uE = null;
    private ArrayList<d> uF = new ArrayList<>();
    private Handler handler = null;
    private b uG = new com.baidu.adp.lib.e.b(this);

    /* renamed from: com.baidu.adp.lib.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0003a {
        void b(int i, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, Address address, long j, boolean z);
    }

    private a() {
    }

    public static a gD() {
        if (uy == null) {
            synchronized (a.class) {
                if (uy == null) {
                    uy = new a();
                }
            }
        }
        return uy;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.uF) {
                if (!this.uF.contains(dVar)) {
                    dVar.a(this.uG);
                    this.uF.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.uF) {
                dVar.destroy();
                this.uF.remove(dVar);
            }
        }
    }

    public void initial() {
        this.uE = new ArrayList<>();
        gE();
    }

    private void gE() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public long gF() {
        return this.uw;
    }

    public Address y(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.ux > this.uz) {
            this.uD = null;
        }
        if (this.uD != null && !z && ((z2 && this.uA) || !z2)) {
            return this.uD;
        }
        this.uD = null;
        if (!this.uC) {
            z(z2);
            return null;
        } else if (this.uC && z2 && !this.uB) {
            gG();
            z(z2);
            return null;
        } else {
            return null;
        }
    }

    public Address a(boolean z, InterfaceC0003a interfaceC0003a) {
        return a(z, false, interfaceC0003a);
    }

    public Address a(boolean z, boolean z2, InterfaceC0003a interfaceC0003a) {
        boolean z3;
        InterfaceC0003a interfaceC0003a2;
        if (System.currentTimeMillis() - this.ux > this.uz) {
            this.uD = null;
        }
        if (this.uD != null && !z && ((z2 && this.uA) || !z2)) {
            if (interfaceC0003a != null) {
                interfaceC0003a.b(0, "", this.uD);
            }
            return this.uD;
        }
        if (interfaceC0003a != null) {
            synchronized (this.uE) {
                int i = 0;
                while (true) {
                    if (i < this.uE.size()) {
                        SoftReference<InterfaceC0003a> softReference = this.uE.get(i);
                        if (softReference == null || (interfaceC0003a2 = softReference.get()) == null || !interfaceC0003a2.equals(interfaceC0003a)) {
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
                    if (this.uE.size() >= 100) {
                        this.uE.remove(0);
                    }
                    this.uE.add(new SoftReference<>(interfaceC0003a));
                }
            }
            if (!this.uC) {
                z(z2);
                return null;
            } else if (this.uC && z2 && !this.uB) {
                gG();
                z(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0003a interfaceC0003a) {
        InterfaceC0003a interfaceC0003a2;
        synchronized (this.uE) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.uE.size()) {
                    break;
                }
                SoftReference<InterfaceC0003a> softReference = this.uE.get(i2);
                if (softReference == null || (interfaceC0003a2 = softReference.get()) == null || !interfaceC0003a2.equals(interfaceC0003a)) {
                    i = i2 + 1;
                } else {
                    this.uE.remove(softReference);
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
        this.uC = false;
        Iterator<d> it = this.uF.iterator();
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
        this.uB = z;
        this.uC = true;
        if (this.uF == null || this.uF.isEmpty()) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.uw);
            return;
        }
        Iterator<d> it = this.uF.iterator();
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
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.uw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0003a interfaceC0003a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.uE != null) {
            synchronized (this.uE) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.uE.size()) {
                        SoftReference<InterfaceC0003a> softReference = this.uE.get(i3);
                        if (softReference != null && (interfaceC0003a = softReference.get()) != null) {
                            interfaceC0003a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.uE.clear();
                    }
                }
            }
        }
    }
}
