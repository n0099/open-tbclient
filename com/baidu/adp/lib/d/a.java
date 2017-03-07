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
    private static a vo = null;
    public long vm = 10000;
    public long vn = 0;
    private long vp = ReportUserInfoModel.TIME_INTERVAL;
    private boolean vq = false;
    private boolean vr = false;
    private boolean vs = false;
    private int errorCode = 4;
    private Address vt = null;
    private ArrayList<SoftReference<InterfaceC0004a>> vu = null;
    private ArrayList<d> vv = new ArrayList<>();
    private Handler handler = null;
    private b vw = new com.baidu.adp.lib.d.b(this);

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

    public static a fa() {
        if (vo == null) {
            synchronized (a.class) {
                if (vo == null) {
                    vo = new a();
                }
            }
        }
        return vo;
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.vv) {
                if (!this.vv.contains(dVar)) {
                    dVar.a(this.vw);
                    this.vv.add(dVar);
                }
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            synchronized (this.vv) {
                dVar.destroy();
                this.vv.remove(dVar);
            }
        }
    }

    public void initial() {
        this.vu = new ArrayList<>();
        fb();
    }

    private void fb() {
        this.handler = new Handler(Looper.getMainLooper(), new c(this));
    }

    public long fc() {
        return this.vm;
    }

    public Address C(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.vn > this.vp) {
            this.vt = null;
        }
        if (this.vt != null && !z && ((z2 && this.vq) || !z2)) {
            return this.vt;
        }
        this.vt = null;
        if (!this.vs) {
            D(z2);
            return null;
        } else if (this.vs && z2 && !this.vr) {
            fd();
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
        if (System.currentTimeMillis() - this.vn > this.vp) {
            this.vt = null;
        }
        if (this.vt != null && !z && ((z2 && this.vq) || !z2)) {
            if (interfaceC0004a != null) {
                interfaceC0004a.b(0, "", this.vt);
            }
            return this.vt;
        }
        if (interfaceC0004a != null) {
            synchronized (this.vu) {
                int i = 0;
                while (true) {
                    if (i < this.vu.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.vu.get(i);
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
                    if (this.vu.size() >= 100) {
                        this.vu.remove(0);
                    }
                    this.vu.add(new SoftReference<>(interfaceC0004a));
                }
            }
            if (!this.vs) {
                D(z2);
                return null;
            } else if (this.vs && z2 && !this.vr) {
                fd();
                D(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0004a interfaceC0004a) {
        InterfaceC0004a interfaceC0004a2;
        synchronized (this.vu) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.vu.size()) {
                    break;
                }
                SoftReference<InterfaceC0004a> softReference = this.vu.get(i2);
                if (softReference == null || (interfaceC0004a2 = softReference.get()) == null || !interfaceC0004a2.equals(interfaceC0004a)) {
                    i = i2 + 1;
                } else {
                    this.vu.remove(softReference);
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.vs = false;
        Iterator<d> it = this.vv.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                try {
                    next.fe();
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
        this.vr = z;
        this.vs = true;
        if (this.vv == null || this.vv.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<d> it = this.vv.iterator();
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
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.vm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0004a interfaceC0004a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.vu != null) {
            synchronized (this.vu) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.vu.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.vu.get(i3);
                        if (softReference != null && (interfaceC0004a = softReference.get()) != null) {
                            interfaceC0004a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.vu.clear();
                    }
                }
            }
        }
    }
}
