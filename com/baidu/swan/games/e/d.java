package com.baidu.swan.games.e;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes11.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d cmQ;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<j> mListeners = new ArrayList<>();

    private d() {
    }

    public static d anF() {
        if (cmQ == null) {
            synchronized (d.class) {
                if (cmQ == null) {
                    cmQ = new d();
                }
            }
        }
        return cmQ;
    }

    private Object[] anG() {
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
        Object[] anG = anG();
        if (anG != null) {
            for (Object obj : anG) {
                ((j) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] anG = anG();
        if (anG != null) {
            for (Object obj : anG) {
                ((j) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] anG = anG();
        if (anG != null) {
            for (Object obj : anG) {
                ((j) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] anG = anG();
        if (anG != null) {
            for (Object obj : anG) {
                ((j) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] anG = anG();
        if (anG != null) {
            for (Object obj : anG) {
                ((j) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] anG = anG();
        if (anG != null) {
            for (Object obj : anG) {
                ((j) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] anG = anG();
        if (anG != null) {
            for (Object obj : anG) {
                ((j) obj).t(aVar);
            }
        }
    }
}
