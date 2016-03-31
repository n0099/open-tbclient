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
    private static a uS = null;
    public long uQ = 10000;
    public long uR = 0;
    private long uT = 300000;
    private boolean uU = false;
    private boolean uV = false;
    private boolean uW = false;
    private int errorCode = 4;
    private Address uX = null;
    private ArrayList<SoftReference<InterfaceC0005a>> uY = null;
    private ArrayList<d> uZ = new ArrayList<>();
    private Handler handler = null;
    private b va = new com.baidu.adp.lib.e.b(this);

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

    public static a gL() {
        if (uS == null) {
            synchronized (a.class) {
                if (uS == null) {
                    uS = new a();
                }
            }
        }
        return uS;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.uZ) {
                if (!this.uZ.contains(dVar)) {
                    dVar.a(this.va);
                    this.uZ.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.uZ) {
                dVar.destroy();
                this.uZ.remove(dVar);
            }
        }
    }

    public void initial() {
        this.uY = new ArrayList<>();
        gM();
    }

    private void gM() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public long gN() {
        return this.uQ;
    }

    public Address x(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.uR > this.uT) {
            this.uX = null;
        }
        if (this.uX != null && !z && ((z2 && this.uU) || !z2)) {
            return this.uX;
        }
        this.uX = null;
        if (!this.uW) {
            y(z2);
            return null;
        } else if (this.uW && z2 && !this.uV) {
            gO();
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
        if (System.currentTimeMillis() - this.uR > this.uT) {
            this.uX = null;
        }
        if (this.uX != null && !z && ((z2 && this.uU) || !z2)) {
            if (interfaceC0005a != null) {
                interfaceC0005a.b(0, "", this.uX);
            }
            return this.uX;
        }
        if (interfaceC0005a != null) {
            synchronized (this.uY) {
                int i = 0;
                while (true) {
                    if (i < this.uY.size()) {
                        SoftReference<InterfaceC0005a> softReference = this.uY.get(i);
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
                    if (this.uY.size() >= 100) {
                        this.uY.remove(0);
                    }
                    this.uY.add(new SoftReference<>(interfaceC0005a));
                }
            }
            if (!this.uW) {
                y(z2);
                return null;
            } else if (this.uW && z2 && !this.uV) {
                gO();
                y(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0005a interfaceC0005a) {
        InterfaceC0005a interfaceC0005a2;
        synchronized (this.uY) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.uY.size()) {
                    break;
                }
                SoftReference<InterfaceC0005a> softReference = this.uY.get(i2);
                if (softReference == null || (interfaceC0005a2 = softReference.get()) == null || !interfaceC0005a2.equals(interfaceC0005a)) {
                    i = i2 + 1;
                } else {
                    this.uY.remove(softReference);
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
        this.uW = false;
        Iterator<d> it = this.uZ.iterator();
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

    private void y(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.uV = z;
        this.uW = true;
        if (this.uZ == null || this.uZ.isEmpty()) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.uQ);
            return;
        }
        Iterator<d> it = this.uZ.iterator();
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
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.uQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0005a interfaceC0005a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.uY != null) {
            synchronized (this.uY) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.uY.size()) {
                        SoftReference<InterfaceC0005a> softReference = this.uY.get(i3);
                        if (softReference != null && (interfaceC0005a = softReference.get()) != null) {
                            interfaceC0005a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.uY.clear();
                    }
                }
            }
        }
    }
}
