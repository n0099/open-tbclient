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
    private static a lk = null;
    public long li = 10000;
    public long lj = 0;
    private long ll = 300000;
    private boolean lm = false;
    private boolean ln = false;
    private boolean lo = false;
    private int errorCode = 4;
    private Address lp = null;
    private ArrayList<SoftReference<InterfaceC0005a>> lq = null;
    private ArrayList<d> lr = new ArrayList<>();
    private Handler handler = null;
    private b ls = new com.baidu.adp.lib.e.b(this);

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
        if (lk == null) {
            synchronized (a.class) {
                if (lk == null) {
                    lk = new a();
                }
            }
        }
        return lk;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.lr) {
                if (!this.lr.contains(dVar)) {
                    dVar.a(this.ls);
                    this.lr.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.lr) {
                dVar.destroy();
                this.lr.remove(dVar);
            }
        }
    }

    public void initial() {
        this.lq = new ArrayList<>();
        da();
    }

    private void da() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public long db() {
        return this.li;
    }

    public Address z(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.lj > this.ll) {
            this.lp = null;
        }
        if (this.lp != null && !z && ((z2 && this.lm) || !z2)) {
            return this.lp;
        }
        this.lp = null;
        if (!this.lo) {
            A(z2);
            return null;
        } else if (this.lo && z2 && !this.ln) {
            dc();
            A(z2);
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
        if (System.currentTimeMillis() - this.lj > this.ll) {
            this.lp = null;
        }
        if (this.lp != null && !z && ((z2 && this.lm) || !z2)) {
            if (interfaceC0005a != null) {
                interfaceC0005a.b(0, "", this.lp);
            }
            return this.lp;
        }
        if (interfaceC0005a != null) {
            synchronized (this.lq) {
                int i = 0;
                while (true) {
                    if (i < this.lq.size()) {
                        SoftReference<InterfaceC0005a> softReference = this.lq.get(i);
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
                    if (this.lq.size() >= 100) {
                        this.lq.remove(0);
                    }
                    this.lq.add(new SoftReference<>(interfaceC0005a));
                }
            }
            if (!this.lo) {
                A(z2);
                return null;
            } else if (this.lo && z2 && !this.ln) {
                dc();
                A(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0005a interfaceC0005a) {
        InterfaceC0005a interfaceC0005a2;
        synchronized (this.lq) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lq.size()) {
                    break;
                }
                SoftReference<InterfaceC0005a> softReference = this.lq.get(i2);
                if (softReference == null || (interfaceC0005a2 = softReference.get()) == null || !interfaceC0005a2.equals(interfaceC0005a)) {
                    i = i2 + 1;
                } else {
                    this.lq.remove(softReference);
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
        this.lo = false;
        Iterator<d> it = this.lr.iterator();
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

    private void A(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.ln = z;
        this.lo = true;
        if (this.lr == null || this.lr.isEmpty()) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.li);
            return;
        }
        Iterator<d> it = this.lr.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.B(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.li);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0005a interfaceC0005a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.lq != null) {
            synchronized (this.lq) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.lq.size()) {
                        SoftReference<InterfaceC0005a> softReference = this.lq.get(i3);
                        if (softReference != null && (interfaceC0005a = softReference.get()) != null) {
                            interfaceC0005a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.lq.clear();
                    }
                }
            }
        }
    }
}
