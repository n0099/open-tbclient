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
    private static a kH = null;
    public long kF = 10000;
    public long kG = 0;
    private long kI = 300000;
    private boolean kJ = false;
    private boolean kK = false;
    private boolean kL = false;
    private int errorCode = 4;
    private Address kM = null;
    private ArrayList<SoftReference<InterfaceC0005a>> kN = null;
    private ArrayList<d> kO = new ArrayList<>();
    private Handler handler = null;
    private b kP = new com.baidu.adp.lib.e.b(this);

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

    public static a da() {
        if (kH == null) {
            synchronized (a.class) {
                if (kH == null) {
                    kH = new a();
                }
            }
        }
        return kH;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.kO) {
                if (!this.kO.contains(dVar)) {
                    dVar.a(this.kP);
                    this.kO.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.kO) {
                dVar.destroy();
                this.kO.remove(dVar);
            }
        }
    }

    public void initial() {
        this.kN = new ArrayList<>();
        db();
    }

    private void db() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public long dc() {
        return this.kF;
    }

    public Address x(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.kG > this.kI) {
            this.kM = null;
        }
        if (this.kM != null && !z && ((z2 && this.kJ) || !z2)) {
            return this.kM;
        }
        this.kM = null;
        if (!this.kL) {
            y(z2);
            return null;
        } else if (this.kL && z2 && !this.kK) {
            dd();
            y(z2);
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
        if (System.currentTimeMillis() - this.kG > this.kI) {
            this.kM = null;
        }
        if (this.kM != null && !z && ((z2 && this.kJ) || !z2)) {
            if (interfaceC0005a != null) {
                interfaceC0005a.b(0, "", this.kM);
            }
            return this.kM;
        }
        if (interfaceC0005a != null) {
            synchronized (this.kN) {
                int i = 0;
                while (true) {
                    if (i < this.kN.size()) {
                        SoftReference<InterfaceC0005a> softReference = this.kN.get(i);
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
                    if (this.kN.size() >= 100) {
                        this.kN.remove(0);
                    }
                    this.kN.add(new SoftReference<>(interfaceC0005a));
                }
            }
            if (!this.kL) {
                y(z2);
                return null;
            } else if (this.kL && z2 && !this.kK) {
                dd();
                y(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0005a interfaceC0005a) {
        InterfaceC0005a interfaceC0005a2;
        synchronized (this.kN) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kN.size()) {
                    break;
                }
                SoftReference<InterfaceC0005a> softReference = this.kN.get(i2);
                if (softReference == null || (interfaceC0005a2 = softReference.get()) == null || !interfaceC0005a2.equals(interfaceC0005a)) {
                    i = i2 + 1;
                } else {
                    this.kN.remove(softReference);
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.kL = false;
        Iterator<d> it = this.kO.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.de();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void y(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.kK = z;
        this.kL = true;
        if (this.kO == null || this.kO.isEmpty()) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.kF);
            return;
        }
        Iterator<d> it = this.kO.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.z(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.kF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0005a interfaceC0005a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.kN != null) {
            synchronized (this.kN) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.kN.size()) {
                        SoftReference<InterfaceC0005a> softReference = this.kN.get(i3);
                        if (softReference != null && (interfaceC0005a = softReference.get()) != null) {
                            interfaceC0005a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.kN.clear();
                    }
                }
            }
        }
    }
}
