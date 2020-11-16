package com.baidu.ar.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes12.dex */
public class d {
    private e J;
    private List<k> N;
    private Looper mn;
    private Handler mo;
    private ArrayList<c> mq = new ArrayList<>();
    private HashMap<String, Boolean> mr = new HashMap<>();
    private HashMap<String, Boolean> ms = new HashMap<>();
    private long mt = 0;
    private int mp = 180;

    /* loaded from: classes12.dex */
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
        this.mn = looper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        dh();
        this.mo.removeCallbacksAndMessages(null);
        this.mo = null;
    }

    private void a(c cVar) {
        boolean z;
        if (cVar == null || this.mq == null || this.mq.size() == 0 || this.N == null || this.N.size() == 0 || this.J == null) {
            return;
        }
        Iterator<k> it = this.N.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (!cVar.U(it.next().getName())) {
                z = false;
                break;
            }
        }
        if (!z || cVar.getTimestamp() == this.mt) {
            return;
        }
        this.J.a(cVar);
        this.mt = cVar.getTimestamp();
        this.mq.subList(0, this.mq.indexOf(cVar)).clear();
    }

    private void dh() {
        if (this.N != null) {
            this.N.clear();
        }
        if (this.mq != null) {
            this.mq.clear();
        }
        if (this.mr != null) {
            this.mr.clear();
        }
        if (this.ms != null) {
            this.ms.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l lVar) {
        boolean z = false;
        this.mr.put(lVar.dd(), Boolean.valueOf(lVar.isSuccess()));
        Iterator<k> it = this.N.iterator();
        boolean z2 = true;
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            k next = it.next();
            if (this.mr.get(next.getName()) == null) {
                break;
            }
            z2 = !this.mr.get(next.getName()).booleanValue() ? false : z2;
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
        if (this.mq == null || this.mr == null || this.mr.isEmpty()) {
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
        this.ms.put(lVar.dd(), Boolean.valueOf(lVar.isSuccess()));
        Iterator<k> it = this.N.iterator();
        boolean z2 = true;
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            k next = it.next();
            if (this.ms.get(next.getName()) == null) {
                break;
            }
            z2 = !this.ms.get(next.getName()).booleanValue() ? false : z2;
        }
        if (this.J != null) {
            this.J.b(lVar);
            if (z) {
                this.J.b(new l("DetectorGroup", z2));
                dh();
            }
        }
    }

    private c g(b bVar) {
        Iterator<c> it = this.mq.iterator();
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
        if (this.mq.size() >= this.mp) {
            com.baidu.ar.g.b.b("DetectResultSync", "add2NewDetectResultGroup detectResult list for sync is fulllll!!!");
            return null;
        }
        c cVar = new c();
        cVar.setTimestamp(bVar.getTimestamp());
        cVar.c(bVar);
        this.mq.add(cVar);
        return cVar;
    }

    public void a(List<k> list, e eVar) {
        this.N = list;
        this.J = eVar;
        if (this.mo != null || this.mn == null) {
            return;
        }
        this.mo = new a(this.mn);
    }

    public synchronized void c(l lVar) {
        com.baidu.ar.g.b.c("DetectResultSync", "DetectorGroup onDetectorSetup result = " + lVar.dd());
        if (this.mo != null) {
            this.mo.sendMessage(this.mo.obtainMessage(1001, lVar));
        }
    }

    public synchronized void d(b bVar) {
        if (this.mo != null) {
            this.mo.sendMessage(this.mo.obtainMessage(1002, bVar));
        }
    }

    public synchronized void d(l lVar) {
        com.baidu.ar.g.b.c("DetectResultSync", "DetectorGroup onDetectorRelease result = " + lVar.dd());
        if (this.mo != null) {
            this.mo.sendMessage(this.mo.obtainMessage(1003, lVar));
        }
    }

    public synchronized boolean e(b bVar) {
        boolean z;
        if (this.mq.size() != 0) {
            z = this.mq.get(0).getTimestamp() >= bVar.getTimestamp();
        }
        return z;
    }

    public void release() {
        if (this.mo != null) {
            this.mo.sendMessage(this.mo.obtainMessage(1004));
        }
    }
}
