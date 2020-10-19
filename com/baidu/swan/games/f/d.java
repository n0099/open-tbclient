package com.baidu.swan.games.f;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes10.dex */
public final class d {
    private static volatile d dFs;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<j> mListeners = new ArrayList<>();

    private d() {
    }

    public static d aQB() {
        if (dFs == null) {
            synchronized (d.class) {
                if (dFs == null) {
                    dFs = new d();
                }
            }
        }
        return dFs;
    }

    private Object[] aQC() {
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
        Object[] aQC = aQC();
        if (aQC != null) {
            for (Object obj : aQC) {
                ((j) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] aQC = aQC();
        if (aQC != null) {
            for (Object obj : aQC) {
                ((j) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] aQC = aQC();
        if (aQC != null) {
            for (Object obj : aQC) {
                ((j) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] aQC = aQC();
        if (aQC != null) {
            for (Object obj : aQC) {
                ((j) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] aQC = aQC();
        if (aQC != null) {
            for (Object obj : aQC) {
                ((j) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] aQC = aQC();
        if (aQC != null) {
            for (Object obj : aQC) {
                ((j) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] aQC = aQC();
        if (aQC != null) {
            for (Object obj : aQC) {
                ((j) obj).t(aVar);
            }
        }
    }
}
