package com.baidu.adp.lib.d;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a uR = null;
    public long uP = 10000;
    public long uQ = 0;
    private long uS = ReportUserInfoModel.TIME_INTERVAL;
    private boolean uT = false;
    private boolean uU = false;
    private boolean uV = false;
    private int errorCode = 4;
    private Address uW = null;
    private ArrayList<SoftReference<InterfaceC0004a>> uX = null;
    private ArrayList<d> uY = new ArrayList<>();
    private Handler handler = null;
    private b uZ = new com.baidu.adp.lib.d.b(this);

    /* renamed from: com.baidu.adp.lib.d.a$a  reason: collision with other inner class name */
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

    public static a ff() {
        if (uR == null) {
            synchronized (a.class) {
                if (uR == null) {
                    uR = new a();
                }
            }
        }
        return uR;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.uY) {
                if (!this.uY.contains(dVar)) {
                    dVar.a(this.uZ);
                    this.uY.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.uY) {
                dVar.destroy();
                this.uY.remove(dVar);
            }
        }
    }

    public void initial() {
        this.uX = new ArrayList<>();
        fg();
    }

    private void fg() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public long fh() {
        return this.uP;
    }

    public Address C(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.uQ > this.uS) {
            this.uW = null;
        }
        if (this.uW != null && !z && ((z2 && this.uT) || !z2)) {
            return this.uW;
        }
        this.uW = null;
        if (!this.uV) {
            D(z2);
            return null;
        } else if (this.uV && z2 && !this.uU) {
            fi();
            D(z2);
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
        if (System.currentTimeMillis() - this.uQ > this.uS) {
            this.uW = null;
        }
        if (this.uW != null && !z && ((z2 && this.uT) || !z2)) {
            if (interfaceC0004a != null) {
                interfaceC0004a.b(0, "", this.uW);
            }
            return this.uW;
        }
        if (interfaceC0004a != null) {
            synchronized (this.uX) {
                int i = 0;
                while (true) {
                    if (i < this.uX.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.uX.get(i);
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
                    if (this.uX.size() >= 100) {
                        this.uX.remove(0);
                    }
                    this.uX.add(new SoftReference<>(interfaceC0004a));
                }
            }
            if (!this.uV) {
                D(z2);
                return null;
            } else if (this.uV && z2 && !this.uU) {
                fi();
                D(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0004a interfaceC0004a) {
        InterfaceC0004a interfaceC0004a2;
        synchronized (this.uX) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.uX.size()) {
                    break;
                }
                SoftReference<InterfaceC0004a> softReference = this.uX.get(i2);
                if (softReference == null || (interfaceC0004a2 = softReference.get()) == null || !interfaceC0004a2.equals(interfaceC0004a)) {
                    i = i2 + 1;
                } else {
                    this.uX.remove(softReference);
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.uV = false;
        Iterator<d> it = this.uY.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.fj();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void D(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.uU = z;
        this.uV = true;
        if (this.uY == null || this.uY.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<d> it = this.uY.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.E(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.uP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0004a interfaceC0004a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.uX != null) {
            synchronized (this.uX) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.uX.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.uX.get(i3);
                        if (softReference != null && (interfaceC0004a = softReference.get()) != null) {
                            interfaceC0004a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.uX.clear();
                    }
                }
            }
        }
    }
}
