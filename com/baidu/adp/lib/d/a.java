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
    public static long uq = 10000;
    private static a us = null;
    private static long ut = 300000;
    public long ur = 0;
    private boolean uu = false;
    private boolean uv = false;
    private boolean uw = false;
    private int errorCode = 4;
    private Address ux = null;
    private ArrayList<SoftReference<InterfaceC0003a>> uy = null;
    private ArrayList<d> uz = new ArrayList<>();
    private Handler handler = null;
    private b uA = new com.baidu.adp.lib.d.b(this);

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

    public static a gC() {
        if (us == null) {
            synchronized (a.class) {
                if (us == null) {
                    us = new a();
                }
            }
        }
        return us;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.uz) {
                if (!this.uz.contains(dVar)) {
                    dVar.a(this.uA);
                    this.uz.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.uz) {
                dVar.destroy();
                this.uz.remove(dVar);
            }
        }
    }

    public void initial() {
        this.uy = new ArrayList<>();
        gD();
    }

    private void gD() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public Address y(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.ur > ut) {
            this.ux = null;
        }
        if (this.ux != null && !z && ((z2 && this.uu) || !z2)) {
            return this.ux;
        }
        this.ux = null;
        if (!this.uw) {
            z(z2);
            return null;
        } else if (this.uw && z2 && !this.uv) {
            gE();
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
        if (System.currentTimeMillis() - this.ur > ut) {
            this.ux = null;
        }
        if (this.ux != null && !z && ((z2 && this.uu) || !z2)) {
            if (interfaceC0003a != null) {
                interfaceC0003a.b(0, "", this.ux);
            }
            return this.ux;
        }
        if (interfaceC0003a != null) {
            synchronized (this.uy) {
                int i = 0;
                while (true) {
                    if (i < this.uy.size()) {
                        SoftReference<InterfaceC0003a> softReference = this.uy.get(i);
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
                    if (this.uy.size() >= 100) {
                        this.uy.remove(0);
                    }
                    this.uy.add(new SoftReference<>(interfaceC0003a));
                }
            }
            if (!this.uw) {
                z(z2);
                return null;
            } else if (this.uw && z2 && !this.uv) {
                gE();
                z(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0003a interfaceC0003a) {
        InterfaceC0003a interfaceC0003a2;
        synchronized (this.uy) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.uy.size()) {
                    break;
                }
                SoftReference<InterfaceC0003a> softReference = this.uy.get(i2);
                if (softReference == null || (interfaceC0003a2 = softReference.get()) == null || !interfaceC0003a2.equals(interfaceC0003a)) {
                    i = i2 + 1;
                } else {
                    this.uy.remove(softReference);
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.uw = false;
        Iterator<d> it = this.uz.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.gF();
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
        this.uv = z;
        this.uw = true;
        if (this.uz == null || this.uz.isEmpty()) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), uq);
            return;
        }
        Iterator<d> it = this.uz.iterator();
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
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), uq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0003a interfaceC0003a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.uy != null) {
            synchronized (this.uy) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.uy.size()) {
                        SoftReference<InterfaceC0003a> softReference = this.uy.get(i3);
                        if (softReference != null && (interfaceC0003a = softReference.get()) != null) {
                            interfaceC0003a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.uy.clear();
                    }
                }
            }
        }
    }
}
