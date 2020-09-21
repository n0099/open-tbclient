package com.baidu.swan.games.f;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public final class d {
    private static volatile d dtq;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<j> mListeners = new ArrayList<>();

    private d() {
    }

    public static d aNS() {
        if (dtq == null) {
            synchronized (d.class) {
                if (dtq == null) {
                    dtq = new d();
                }
            }
        }
        return dtq;
    }

    private Object[] aNT() {
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
        Object[] aNT = aNT();
        if (aNT != null) {
            for (Object obj : aNT) {
                ((j) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] aNT = aNT();
        if (aNT != null) {
            for (Object obj : aNT) {
                ((j) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] aNT = aNT();
        if (aNT != null) {
            for (Object obj : aNT) {
                ((j) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] aNT = aNT();
        if (aNT != null) {
            for (Object obj : aNT) {
                ((j) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] aNT = aNT();
        if (aNT != null) {
            for (Object obj : aNT) {
                ((j) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] aNT = aNT();
        if (aNT != null) {
            for (Object obj : aNT) {
                ((j) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] aNT = aNT();
        if (aNT != null) {
            for (Object obj : aNT) {
                ((j) obj).t(aVar);
            }
        }
    }
}
