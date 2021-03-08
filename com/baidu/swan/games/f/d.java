package com.baidu.swan.games.f;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes8.dex */
public final class d {
    private static volatile d egQ;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<j> mListeners = new ArrayList<>();

    private d() {
    }

    public static d aWi() {
        if (egQ == null) {
            synchronized (d.class) {
                if (egQ == null) {
                    egQ = new d();
                }
            }
        }
        return egQ;
    }

    private Object[] aWj() {
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
        Object[] aWj = aWj();
        if (aWj != null) {
            for (Object obj : aWj) {
                ((j) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] aWj = aWj();
        if (aWj != null) {
            for (Object obj : aWj) {
                ((j) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] aWj = aWj();
        if (aWj != null) {
            for (Object obj : aWj) {
                ((j) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] aWj = aWj();
        if (aWj != null) {
            for (Object obj : aWj) {
                ((j) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] aWj = aWj();
        if (aWj != null) {
            for (Object obj : aWj) {
                ((j) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] aWj = aWj();
        if (aWj != null) {
            for (Object obj : aWj) {
                ((j) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] aWj = aWj();
        if (aWj != null) {
            for (Object obj : aWj) {
                ((j) obj).t(aVar);
            }
        }
    }
}
