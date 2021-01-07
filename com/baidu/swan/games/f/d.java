package com.baidu.swan.games.f;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes9.dex */
public final class d {
    private static volatile d ehU;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<j> mListeners = new ArrayList<>();

    private d() {
    }

    public static d aZN() {
        if (ehU == null) {
            synchronized (d.class) {
                if (ehU == null) {
                    ehU = new d();
                }
            }
        }
        return ehU;
    }

    private Object[] aZO() {
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
        Object[] aZO = aZO();
        if (aZO != null) {
            for (Object obj : aZO) {
                ((j) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] aZO = aZO();
        if (aZO != null) {
            for (Object obj : aZO) {
                ((j) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] aZO = aZO();
        if (aZO != null) {
            for (Object obj : aZO) {
                ((j) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] aZO = aZO();
        if (aZO != null) {
            for (Object obj : aZO) {
                ((j) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] aZO = aZO();
        if (aZO != null) {
            for (Object obj : aZO) {
                ((j) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] aZO = aZO();
        if (aZO != null) {
            for (Object obj : aZO) {
                ((j) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] aZO = aZO();
        if (aZO != null) {
            for (Object obj : aZO) {
                ((j) obj).t(aVar);
            }
        }
    }
}
