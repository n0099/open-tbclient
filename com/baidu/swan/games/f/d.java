package com.baidu.swan.games.f;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class d {
    private static volatile d dha;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<j> mListeners = new ArrayList<>();

    private d() {
    }

    public static d aEs() {
        if (dha == null) {
            synchronized (d.class) {
                if (dha == null) {
                    dha = new d();
                }
            }
        }
        return dha;
    }

    private Object[] aEt() {
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
        Object[] aEt = aEt();
        if (aEt != null) {
            for (Object obj : aEt) {
                ((j) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] aEt = aEt();
        if (aEt != null) {
            for (Object obj : aEt) {
                ((j) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] aEt = aEt();
        if (aEt != null) {
            for (Object obj : aEt) {
                ((j) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] aEt = aEt();
        if (aEt != null) {
            for (Object obj : aEt) {
                ((j) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] aEt = aEt();
        if (aEt != null) {
            for (Object obj : aEt) {
                ((j) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] aEt = aEt();
        if (aEt != null) {
            for (Object obj : aEt) {
                ((j) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] aEt = aEt();
        if (aEt != null) {
            for (Object obj : aEt) {
                ((j) obj).t(aVar);
            }
        }
    }
}
