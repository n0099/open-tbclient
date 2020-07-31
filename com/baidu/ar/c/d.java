package com.baidu.ar.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private e J;
    private List<k> N;
    private Looper lF;
    private Handler lG;
    private ArrayList<c> lI = new ArrayList<>();
    private HashMap<String, Boolean> lJ = new HashMap<>();
    private HashMap<String, Boolean> lK = new HashMap<>();
    private long lL = 0;
    private int lH = 180;

    /* loaded from: classes11.dex */
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
                    d.this.T();
                    return;
                default:
                    return;
            }
        }
    }

    public d(Looper looper) {
        this.lF = looper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        cH();
        this.lG.removeCallbacksAndMessages(null);
        this.lG = null;
    }

    private void a(c cVar) {
        boolean z;
        if (cVar == null || this.lI == null || this.lI.size() == 0 || this.N == null || this.N.size() == 0 || this.J == null) {
            return;
        }
        Iterator<k> it = this.N.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (!cVar.T(it.next().getName())) {
                z = false;
                break;
            }
        }
        if (!z || cVar.getTimestamp() == this.lL) {
            return;
        }
        this.J.a(cVar);
        this.lL = cVar.getTimestamp();
        this.lI.subList(0, this.lI.indexOf(cVar)).clear();
    }

    private void cH() {
        if (this.N != null) {
            this.N.clear();
        }
        if (this.lI != null) {
            this.lI.clear();
        }
        if (this.lJ != null) {
            this.lJ.clear();
        }
        if (this.lK != null) {
            this.lK.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l lVar) {
        boolean z = false;
        this.lJ.put(lVar.cD(), Boolean.valueOf(lVar.isSuccess()));
        Iterator<k> it = this.N.iterator();
        boolean z2 = true;
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            k next = it.next();
            if (this.lJ.get(next.getName()) == null) {
                break;
            }
            z2 = !this.lJ.get(next.getName()).booleanValue() ? false : z2;
        }
        if (this.J != null) {
            this.J.a(lVar);
            if (z) {
                this.J.a(new l("DetectorGroup", z2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(b bVar) {
        if (this.lI == null || this.lJ == null || this.lJ.isEmpty()) {
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
        this.lK.put(lVar.cD(), Boolean.valueOf(lVar.isSuccess()));
        Iterator<k> it = this.N.iterator();
        boolean z2 = true;
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            k next = it.next();
            if (this.lK.get(next.getName()) == null) {
                break;
            }
            z2 = !this.lK.get(next.getName()).booleanValue() ? false : z2;
        }
        if (this.J != null) {
            this.J.b(lVar);
            if (z) {
                this.J.b(new l("DetectorGroup", z2));
                cH();
            }
        }
    }

    private c g(b bVar) {
        Iterator<c> it = this.lI.iterator();
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
        if (this.lI.size() >= this.lH) {
            com.baidu.ar.f.b.b("DetectResultSync", "add2NewDetectResultGroup detectResult list for sync is fulllll!!!");
            return null;
        }
        c cVar = new c();
        cVar.setTimestamp(bVar.getTimestamp());
        cVar.c(bVar);
        this.lI.add(cVar);
        return cVar;
    }

    public void a(List<k> list, e eVar) {
        this.N = list;
        this.J = eVar;
        if (this.lG != null || this.lF == null) {
            return;
        }
        this.lG = new a(this.lF);
    }

    public synchronized void c(l lVar) {
        com.baidu.ar.f.b.c("DetectResultSync", "DetectorGroup onDetectorSetup result = " + lVar.cD());
        if (this.lG != null) {
            this.lG.sendMessage(this.lG.obtainMessage(1001, lVar));
        }
    }

    public synchronized void d(b bVar) {
        if (this.lG != null) {
            this.lG.sendMessage(this.lG.obtainMessage(1002, bVar));
        }
    }

    public synchronized void d(l lVar) {
        com.baidu.ar.f.b.c("DetectResultSync", "DetectorGroup onDetectorRelease result = " + lVar.cD());
        if (this.lG != null) {
            this.lG.sendMessage(this.lG.obtainMessage(1003, lVar));
        }
    }

    public synchronized boolean e(b bVar) {
        boolean z;
        if (this.lI.size() != 0) {
            z = this.lI.get(0).getTimestamp() >= bVar.getTimestamp();
        }
        return z;
    }

    public void release() {
        if (this.lG != null) {
            this.lG.sendMessage(this.lG.obtainMessage(1004));
        }
    }
}
