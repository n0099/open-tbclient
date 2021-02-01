package com.baidu.swan.games.f;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes9.dex */
public final class d {
    private static volatile d efo;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<j> mListeners = new ArrayList<>();

    private d() {
    }

    public static d aWf() {
        if (efo == null) {
            synchronized (d.class) {
                if (efo == null) {
                    efo = new d();
                }
            }
        }
        return efo;
    }

    private Object[] aWg() {
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
        Object[] aWg = aWg();
        if (aWg != null) {
            for (Object obj : aWg) {
                ((j) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] aWg = aWg();
        if (aWg != null) {
            for (Object obj : aWg) {
                ((j) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] aWg = aWg();
        if (aWg != null) {
            for (Object obj : aWg) {
                ((j) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] aWg = aWg();
        if (aWg != null) {
            for (Object obj : aWg) {
                ((j) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] aWg = aWg();
        if (aWg != null) {
            for (Object obj : aWg) {
                ((j) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] aWg = aWg();
        if (aWg != null) {
            for (Object obj : aWg) {
                ((j) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] aWg = aWg();
        if (aWg != null) {
            for (Object obj : aWg) {
                ((j) obj).t(aVar);
            }
        }
    }
}
