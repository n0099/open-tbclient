package com.baidu.swan.games.f;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes11.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dbr;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<j> mListeners = new ArrayList<>();

    private d() {
    }

    public static d aAN() {
        if (dbr == null) {
            synchronized (d.class) {
                if (dbr == null) {
                    dbr = new d();
                }
            }
        }
        return dbr;
    }

    private Object[] aAO() {
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
        Object[] aAO = aAO();
        if (aAO != null) {
            for (Object obj : aAO) {
                ((j) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] aAO = aAO();
        if (aAO != null) {
            for (Object obj : aAO) {
                ((j) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] aAO = aAO();
        if (aAO != null) {
            for (Object obj : aAO) {
                ((j) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] aAO = aAO();
        if (aAO != null) {
            for (Object obj : aAO) {
                ((j) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] aAO = aAO();
        if (aAO != null) {
            for (Object obj : aAO) {
                ((j) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] aAO = aAO();
        if (aAO != null) {
            for (Object obj : aAO) {
                ((j) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] aAO = aAO();
        if (aAO != null) {
            for (Object obj : aAO) {
                ((j) obj).t(aVar);
            }
        }
    }
}
