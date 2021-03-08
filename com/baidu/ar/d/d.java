package com.baidu.ar.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private e K;
    private List<k> O;
    private Looper mC;
    private Handler mD;
    private ArrayList<c> mF = new ArrayList<>();
    private HashMap<String, Boolean> mG = new HashMap<>();
    private HashMap<String, Boolean> mH = new HashMap<>();
    private long mI = 0;
    private int mE = 180;

    /* loaded from: classes3.dex */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    d.this.e((l) message.obj);
                    return;
                case 1002:
                    d.this.f((b) message.obj);
                    return;
                case 1003:
                    d.this.f((l) message.obj);
                    return;
                case 1004:
                    d.this.V();
                    return;
                default:
                    return;
            }
        }
    }

    public d(Looper looper) {
        this.mC = looper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        dg();
        this.mD.removeCallbacksAndMessages(null);
        this.mD = null;
    }

    private void a(c cVar) {
        boolean z;
        if (cVar == null || this.mF == null || this.mF.size() == 0 || this.O == null || this.O.size() == 0 || this.K == null) {
            return;
        }
        Iterator<k> it = this.O.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (!cVar.X(it.next().getName())) {
                z = false;
                break;
            }
        }
        if (!z || cVar.getTimestamp() == this.mI) {
            return;
        }
        this.K.a(cVar);
        this.mI = cVar.getTimestamp();
        this.mF.subList(0, this.mF.indexOf(cVar)).clear();
    }

    private void dg() {
        if (this.O != null) {
            this.O.clear();
        }
        if (this.mF != null) {
            this.mF.clear();
        }
        if (this.mG != null) {
            this.mG.clear();
        }
        if (this.mH != null) {
            this.mH.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l lVar) {
        boolean z = false;
        this.mG.put(lVar.dc(), Boolean.valueOf(lVar.isSuccess()));
        Iterator<k> it = this.O.iterator();
        boolean z2 = true;
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            k next = it.next();
            if (this.mG.get(next.getName()) == null) {
                break;
            }
            z2 = !this.mG.get(next.getName()).booleanValue() ? false : z2;
        }
        if (this.K != null) {
            this.K.a(lVar);
            if (z) {
                this.K.a(new l("DetectorGroup", z2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(b bVar) {
        if (this.mF == null || this.mG == null || this.mG.isEmpty()) {
            return;
        }
        c g = g(bVar);
        if (g == null) {
            g = h(bVar);
        }
        a(g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(l lVar) {
        boolean z = false;
        this.mH.put(lVar.dc(), Boolean.valueOf(lVar.isSuccess()));
        Iterator<k> it = this.O.iterator();
        boolean z2 = true;
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            k next = it.next();
            if (this.mH.get(next.getName()) == null) {
                break;
            }
            z2 = !this.mH.get(next.getName()).booleanValue() ? false : z2;
        }
        if (this.K != null) {
            this.K.b(lVar);
            if (z) {
                this.K.b(new l("DetectorGroup", z2));
                dg();
            }
        }
    }

    private c g(b bVar) {
        Iterator<c> it = this.mF.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.getTimestamp() == bVar.getTimestamp()) {
                next.c(bVar);
                return next;
            }
        }
        return null;
    }

    private c h(b bVar) {
        if (this.mF.size() >= this.mE) {
            com.baidu.ar.h.b.b("DetectResultSync", "add2NewDetectResultGroup detectResult list for sync is fulllll!!!");
            return null;
        }
        c cVar = new c();
        cVar.setTimestamp(bVar.getTimestamp());
        cVar.c(bVar);
        this.mF.add(cVar);
        return cVar;
    }

    public void a(List<k> list, e eVar) {
        this.O = list;
        this.K = eVar;
        if (this.mD != null || this.mC == null) {
            return;
        }
        this.mD = new a(this.mC);
    }

    public synchronized void c(l lVar) {
        com.baidu.ar.h.b.c("DetectResultSync", "DetectorGroup onDetectorSetup result = " + lVar.dc());
        if (this.mD != null) {
            this.mD.sendMessage(this.mD.obtainMessage(1001, lVar));
        }
    }

    public synchronized void d(b bVar) {
        if (this.mD != null) {
            this.mD.sendMessage(this.mD.obtainMessage(1002, bVar));
        }
    }

    public synchronized void d(l lVar) {
        com.baidu.ar.h.b.c("DetectResultSync", "DetectorGroup onDetectorRelease result = " + lVar.dc());
        if (this.mD != null) {
            this.mD.sendMessage(this.mD.obtainMessage(1003, lVar));
        }
    }

    public synchronized boolean e(b bVar) {
        boolean z;
        if (this.mF.size() != 0) {
            z = this.mF.get(0).getTimestamp() >= bVar.getTimestamp();
        }
        return z;
    }

    public void release() {
        if (this.mD != null) {
            this.mD.sendMessage(this.mD.obtainMessage(1004));
        }
    }
}
