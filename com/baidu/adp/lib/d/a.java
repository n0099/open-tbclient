package com.baidu.adp.lib.d;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.util.BdLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    public static long us = 10000;
    private static a uu = null;
    private static long uv = 300000;
    public long ut = 0;
    private boolean uw = false;
    private boolean ux = false;
    private boolean uy = false;
    private int errorCode = 4;
    private Address uz = null;
    private ArrayList<SoftReference<InterfaceC0003a>> uA = null;
    private ArrayList<d> uB = new ArrayList<>();
    private Handler handler = null;
    private b uC = new com.baidu.adp.lib.d.b(this);

    /* renamed from: com.baidu.adp.lib.d.a$a  reason: collision with other inner class name */
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

    public static a gF() {
        if (uu == null) {
            synchronized (a.class) {
                if (uu == null) {
                    uu = new a();
                }
            }
        }
        return uu;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.uB) {
                if (!this.uB.contains(dVar)) {
                    dVar.a(this.uC);
                    this.uB.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.uB) {
                dVar.destroy();
                this.uB.remove(dVar);
            }
        }
    }

    public void initial() {
        this.uA = new ArrayList<>();
        gG();
    }

    private void gG() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public Address y(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.ut > uv) {
            this.uz = null;
        }
        if (this.uz != null && !z && ((z2 && this.uw) || !z2)) {
            return this.uz;
        }
        this.uz = null;
        if (!this.uy) {
            z(z2);
            return null;
        } else if (this.uy && z2 && !this.ux) {
            gH();
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
        if (System.currentTimeMillis() - this.ut > uv) {
            this.uz = null;
        }
        if (this.uz != null && !z && ((z2 && this.uw) || !z2)) {
            if (interfaceC0003a != null) {
                interfaceC0003a.b(0, "", this.uz);
            }
            return this.uz;
        }
        if (interfaceC0003a != null) {
            synchronized (this.uA) {
                int i = 0;
                while (true) {
                    if (i < this.uA.size()) {
                        SoftReference<InterfaceC0003a> softReference = this.uA.get(i);
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
                    if (this.uA.size() >= 100) {
                        this.uA.remove(0);
                    }
                    this.uA.add(new SoftReference<>(interfaceC0003a));
                }
            }
            if (!this.uy) {
                z(z2);
                return null;
            } else if (this.uy && z2 && !this.ux) {
                gH();
                z(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0003a interfaceC0003a) {
        InterfaceC0003a interfaceC0003a2;
        synchronized (this.uA) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.uA.size()) {
                    break;
                }
                SoftReference<InterfaceC0003a> softReference = this.uA.get(i2);
                if (softReference == null || (interfaceC0003a2 = softReference.get()) == null || !interfaceC0003a2.equals(interfaceC0003a)) {
                    i = i2 + 1;
                } else {
                    this.uA.remove(softReference);
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gH() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.uy = false;
        Iterator<d> it = this.uB.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.gI();
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
        this.ux = z;
        this.uy = true;
        if (this.uB == null || this.uB.isEmpty()) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), us);
            return;
        }
        Iterator<d> it = this.uB.iterator();
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
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), us);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0003a interfaceC0003a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.uA != null) {
            synchronized (this.uA) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.uA.size()) {
                        SoftReference<InterfaceC0003a> softReference = this.uA.get(i3);
                        if (softReference != null && (interfaceC0003a = softReference.get()) != null) {
                            interfaceC0003a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.uA.clear();
                    }
                }
            }
        }
    }
}
