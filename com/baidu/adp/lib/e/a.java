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
    private static a kJ = null;
    public long kH = 10000;
    public long kI = 0;
    private long kK = 300000;
    private boolean kL = false;
    private boolean kM = false;
    private boolean kN = false;
    private int errorCode = 4;
    private Address kO = null;
    private ArrayList<SoftReference<InterfaceC0005a>> kP = null;
    private ArrayList<d> kQ = new ArrayList<>();
    private Handler handler = null;
    private b kR = new com.baidu.adp.lib.e.b(this);

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

    public static a cZ() {
        if (kJ == null) {
            synchronized (a.class) {
                if (kJ == null) {
                    kJ = new a();
                }
            }
        }
        return kJ;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.kQ) {
                if (!this.kQ.contains(dVar)) {
                    dVar.a(this.kR);
                    this.kQ.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.kQ) {
                dVar.destroy();
                this.kQ.remove(dVar);
            }
        }
    }

    public void initial() {
        this.kP = new ArrayList<>();
        da();
    }

    private void da() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public long db() {
        return this.kH;
    }

    public Address x(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.kI > this.kK) {
            this.kO = null;
        }
        if (this.kO != null && !z && ((z2 && this.kL) || !z2)) {
            return this.kO;
        }
        this.kO = null;
        if (!this.kN) {
            y(z2);
            return null;
        } else if (this.kN && z2 && !this.kM) {
            dc();
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
        if (System.currentTimeMillis() - this.kI > this.kK) {
            this.kO = null;
        }
        if (this.kO != null && !z && ((z2 && this.kL) || !z2)) {
            if (interfaceC0005a != null) {
                interfaceC0005a.b(0, "", this.kO);
            }
            return this.kO;
        }
        if (interfaceC0005a != null) {
            synchronized (this.kP) {
                int i = 0;
                while (true) {
                    if (i < this.kP.size()) {
                        SoftReference<InterfaceC0005a> softReference = this.kP.get(i);
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
                    if (this.kP.size() >= 100) {
                        this.kP.remove(0);
                    }
                    this.kP.add(new SoftReference<>(interfaceC0005a));
                }
            }
            if (!this.kN) {
                y(z2);
                return null;
            } else if (this.kN && z2 && !this.kM) {
                dc();
                y(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0005a interfaceC0005a) {
        InterfaceC0005a interfaceC0005a2;
        synchronized (this.kP) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kP.size()) {
                    break;
                }
                SoftReference<InterfaceC0005a> softReference = this.kP.get(i2);
                if (softReference == null || (interfaceC0005a2 = softReference.get()) == null || !interfaceC0005a2.equals(interfaceC0005a)) {
                    i = i2 + 1;
                } else {
                    this.kP.remove(softReference);
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.kN = false;
        Iterator<d> it = this.kQ.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.dd();
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
        this.kM = z;
        this.kN = true;
        if (this.kQ == null || this.kQ.isEmpty()) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.kH);
            return;
        }
        Iterator<d> it = this.kQ.iterator();
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
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.kH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0005a interfaceC0005a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.kP != null) {
            synchronized (this.kP) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.kP.size()) {
                        SoftReference<InterfaceC0005a> softReference = this.kP.get(i3);
                        if (softReference != null && (interfaceC0005a = softReference.get()) != null) {
                            interfaceC0005a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.kP.clear();
                    }
                }
            }
        }
    }
}
