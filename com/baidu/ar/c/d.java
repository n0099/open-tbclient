package com.baidu.ar.c;

import android.os.Handler;
import android.os.HandlerThread;
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
    private HandlerThread li;
    private Handler lj;
    private ArrayList<c> ll = new ArrayList<>();
    private HashMap<String, Boolean> lm = new HashMap<>();
    private HashMap<String, Boolean> ln = new HashMap<>();
    private long lo = 0;
    private int lk = 180;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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
                    d.this.cq();
                    return;
                default:
                    return;
            }
        }
    }

    private void a(c cVar) {
        boolean z;
        if (cVar == null || this.ll == null || this.ll.size() == 0 || this.O == null || this.O.size() == 0 || this.K == null) {
            return;
        }
        Iterator<k> it = this.O.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (!cVar.T(it.next().getName())) {
                z = false;
                break;
            }
        }
        if (!z || cVar.getTimestamp() == this.lo) {
            return;
        }
        this.K.a(cVar);
        this.lo = cVar.getTimestamp();
        this.ll.subList(0, this.ll.indexOf(cVar)).clear();
    }

    private void cp() {
        this.li = new HandlerThread("DetectResultSync");
        this.li.start();
        this.lj = new a(this.li.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq() {
        cr();
        if (this.li != null) {
            this.li.quit();
            this.li = null;
        }
        this.lj = null;
    }

    private void cr() {
        if (this.O != null) {
            this.O.clear();
        }
        if (this.ll != null) {
            this.ll.clear();
        }
        if (this.lm != null) {
            this.lm.clear();
        }
        if (this.ln != null) {
            this.ln.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l lVar) {
        boolean z = false;
        this.lm.put(lVar.cl(), Boolean.valueOf(lVar.isSuccess()));
        Iterator<k> it = this.O.iterator();
        boolean z2 = true;
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            k next = it.next();
            if (this.lm.get(next.getName()) == null) {
                break;
            }
            z2 = !this.lm.get(next.getName()).booleanValue() ? false : z2;
        }
        if (z) {
            this.K.a(new l("DetectorGroup", z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(b bVar) {
        if (this.ll == null || this.lm == null || this.lm.isEmpty()) {
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
        this.ln.put(lVar.cl(), Boolean.valueOf(lVar.isSuccess()));
        Iterator<k> it = this.O.iterator();
        boolean z2 = true;
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            k next = it.next();
            if (this.ln.get(next.getName()) == null) {
                break;
            }
            z2 = !this.ln.get(next.getName()).booleanValue() ? false : z2;
        }
        if (z) {
            if (this.K != null) {
                this.K.b(new l("DetectorGroup", z2));
            }
            cr();
        }
    }

    private c g(b bVar) {
        Iterator<c> it = this.ll.iterator();
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
        if (this.ll.size() >= this.lk) {
            com.baidu.ar.f.b.b("DetectResultSync", "add2NewDetectResultGroup detectResult list for sync is fulllll!!!");
            return null;
        }
        c cVar = new c();
        cVar.setTimestamp(bVar.getTimestamp());
        cVar.c(bVar);
        this.ll.add(cVar);
        return cVar;
    }

    public void a(List<k> list, e eVar) {
        this.O = list;
        this.K = eVar;
        cp();
    }

    public synchronized void c(l lVar) {
        com.baidu.ar.f.b.c("DetectResultSync", "DetectorGroup onDetectorSetup result = " + lVar.cl());
        if (this.lj != null) {
            this.lj.sendMessage(this.lj.obtainMessage(1001, lVar));
        }
    }

    public synchronized void d(b bVar) {
        if (this.lj != null) {
            this.lj.sendMessage(this.lj.obtainMessage(1002, bVar));
        }
    }

    public synchronized void d(l lVar) {
        com.baidu.ar.f.b.c("DetectResultSync", "DetectorGroup onDetectorRelease result = " + lVar.cl());
        if (this.lj != null) {
            this.lj.sendMessage(this.lj.obtainMessage(1003, lVar));
        }
    }

    public synchronized boolean e(b bVar) {
        boolean z;
        if (this.ll.size() != 0) {
            z = this.ll.get(0).getTimestamp() >= bVar.getTimestamp();
        }
        return z;
    }

    public void release() {
        if (this.lj != null) {
            this.lj.sendMessage(this.lj.obtainMessage(1004));
        }
    }
}
