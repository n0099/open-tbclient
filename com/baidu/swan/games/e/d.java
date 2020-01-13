package com.baidu.swan.games.e;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes10.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d ciz;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<j> mListeners = new ArrayList<>();

    private d() {
    }

    public static d aln() {
        if (ciz == null) {
            synchronized (d.class) {
                if (ciz == null) {
                    ciz = new d();
                }
            }
        }
        return ciz;
    }

    private Object[] alo() {
        Object[] objArr = null;
        try {
            this.mLock.lock();
            if (this.mListeners.size() > 0) {
                objArr = this.mListeners.toArray();
            }
            return objArr;
        } finally {
            this.mLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(a aVar) {
        Object[] alo = alo();
        if (alo != null) {
            for (Object obj : alo) {
                ((j) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] alo = alo();
        if (alo != null) {
            for (Object obj : alo) {
                ((j) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] alo = alo();
        if (alo != null) {
            for (Object obj : alo) {
                ((j) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] alo = alo();
        if (alo != null) {
            for (Object obj : alo) {
                ((j) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] alo = alo();
        if (alo != null) {
            for (Object obj : alo) {
                ((j) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] alo = alo();
        if (alo != null) {
            for (Object obj : alo) {
                ((j) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] alo = alo();
        if (alo != null) {
            for (Object obj : alo) {
                ((j) obj).t(aVar);
            }
        }
    }
}
