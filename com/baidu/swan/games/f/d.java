package com.baidu.swan.games.f;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes10.dex */
public final class d {
    private static volatile d dNP;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<j> mListeners = new ArrayList<>();

    private d() {
    }

    public static d aSv() {
        if (dNP == null) {
            synchronized (d.class) {
                if (dNP == null) {
                    dNP = new d();
                }
            }
        }
        return dNP;
    }

    private Object[] aSw() {
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
        Object[] aSw = aSw();
        if (aSw != null) {
            for (Object obj : aSw) {
                ((j) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] aSw = aSw();
        if (aSw != null) {
            for (Object obj : aSw) {
                ((j) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] aSw = aSw();
        if (aSw != null) {
            for (Object obj : aSw) {
                ((j) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] aSw = aSw();
        if (aSw != null) {
            for (Object obj : aSw) {
                ((j) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] aSw = aSw();
        if (aSw != null) {
            for (Object obj : aSw) {
                ((j) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] aSw = aSw();
        if (aSw != null) {
            for (Object obj : aSw) {
                ((j) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] aSw = aSw();
        if (aSw != null) {
            for (Object obj : aSw) {
                ((j) obj).t(aVar);
            }
        }
    }
}
