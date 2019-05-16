package com.baidu.swan.games.e;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d bfG;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<i> mListeners = new ArrayList<>();

    private d() {
    }

    public static d QU() {
        if (bfG == null) {
            synchronized (d.class) {
                if (bfG == null) {
                    bfG = new d();
                }
            }
        }
        return bfG;
    }

    private Object[] QV() {
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
        Object[] QV = QV();
        if (QV != null) {
            for (Object obj : QV) {
                ((i) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] QV = QV();
        if (QV != null) {
            for (Object obj : QV) {
                ((i) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] QV = QV();
        if (QV != null) {
            for (Object obj : QV) {
                ((i) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] QV = QV();
        if (QV != null) {
            for (Object obj : QV) {
                ((i) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] QV = QV();
        if (QV != null) {
            for (Object obj : QV) {
                ((i) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] QV = QV();
        if (QV != null) {
            for (Object obj : QV) {
                ((i) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] QV = QV();
        if (QV != null) {
            for (Object obj : QV) {
                ((i) obj).t(aVar);
            }
        }
    }
}
