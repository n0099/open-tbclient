package com.baidu.ar.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public e K;
    public List<k> O;
    public Looper mC;
    public Handler mD;
    public ArrayList<c> mF = new ArrayList<>();
    public HashMap<String, Boolean> mG = new HashMap<>();
    public HashMap<String, Boolean> mH = new HashMap<>();
    public long mI = 0;
    public int mE = 180;

    /* loaded from: classes.dex */
    public class a extends Handler {
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
        ArrayList<c> arrayList;
        List<k> list;
        if (cVar == null || (arrayList = this.mF) == null || arrayList.size() == 0 || (list = this.O) == null || list.size() == 0 || this.K == null) {
            return;
        }
        boolean z = true;
        Iterator<k> it = this.O.iterator();
        while (true) {
            if (!it.hasNext()) {
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
        ArrayList<c> arrayList2 = this.mF;
        arrayList2.subList(0, arrayList2.indexOf(cVar)).clear();
    }

    private void dg() {
        List<k> list = this.O;
        if (list != null) {
            list.clear();
        }
        ArrayList<c> arrayList = this.mF;
        if (arrayList != null) {
            arrayList.clear();
        }
        HashMap<String, Boolean> hashMap = this.mG;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, Boolean> hashMap2 = this.mH;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l lVar) {
        this.mG.put(lVar.dc(), Boolean.valueOf(lVar.isSuccess()));
        Iterator<k> it = this.O.iterator();
        boolean z = true;
        boolean z2 = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            k next = it.next();
            if (this.mG.get(next.getName()) == null) {
                z = false;
                break;
            } else if (!this.mG.get(next.getName()).booleanValue()) {
                z2 = false;
            }
        }
        e eVar = this.K;
        if (eVar != null) {
            eVar.a(lVar);
            if (z) {
                this.K.a(new l("DetectorGroup", z2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(b bVar) {
        HashMap<String, Boolean> hashMap;
        if (this.mF == null || (hashMap = this.mG) == null || hashMap.isEmpty()) {
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
        this.mH.put(lVar.dc(), Boolean.valueOf(lVar.isSuccess()));
        Iterator<k> it = this.O.iterator();
        boolean z = true;
        boolean z2 = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            k next = it.next();
            if (this.mH.get(next.getName()) == null) {
                z = false;
                break;
            } else if (!this.mH.get(next.getName()).booleanValue()) {
                z2 = false;
            }
        }
        e eVar = this.K;
        if (eVar != null) {
            eVar.b(lVar);
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
        if (this.mF.size() != 0) {
            if (this.mF.get(0).getTimestamp() < bVar.getTimestamp()) {
                return false;
            }
        }
        return true;
    }

    public void release() {
        Handler handler = this.mD;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1004));
        }
    }
}
