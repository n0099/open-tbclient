package com.baidu.swan.games.f;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes10.dex */
public final class d {
    private static volatile d dTH;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<j> mListeners = new ArrayList<>();

    private d() {
    }

    public static d aUV() {
        if (dTH == null) {
            synchronized (d.class) {
                if (dTH == null) {
                    dTH = new d();
                }
            }
        }
        return dTH;
    }

    private Object[] aUW() {
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
        Object[] aUW = aUW();
        if (aUW != null) {
            for (Object obj : aUW) {
                ((j) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] aUW = aUW();
        if (aUW != null) {
            for (Object obj : aUW) {
                ((j) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] aUW = aUW();
        if (aUW != null) {
            for (Object obj : aUW) {
                ((j) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] aUW = aUW();
        if (aUW != null) {
            for (Object obj : aUW) {
                ((j) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] aUW = aUW();
        if (aUW != null) {
            for (Object obj : aUW) {
                ((j) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] aUW = aUW();
        if (aUW != null) {
            for (Object obj : aUW) {
                ((j) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] aUW = aUW();
        if (aUW != null) {
            for (Object obj : aUW) {
                ((j) obj).t(aVar);
            }
        }
    }
}
