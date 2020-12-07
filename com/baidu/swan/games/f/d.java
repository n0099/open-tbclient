package com.baidu.swan.games.f;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes25.dex */
public final class d {
    private static volatile d dYX;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<j> mListeners = new ArrayList<>();

    private d() {
    }

    public static d aXs() {
        if (dYX == null) {
            synchronized (d.class) {
                if (dYX == null) {
                    dYX = new d();
                }
            }
        }
        return dYX;
    }

    private Object[] aXt() {
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
        Object[] aXt = aXt();
        if (aXt != null) {
            for (Object obj : aXt) {
                ((j) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] aXt = aXt();
        if (aXt != null) {
            for (Object obj : aXt) {
                ((j) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] aXt = aXt();
        if (aXt != null) {
            for (Object obj : aXt) {
                ((j) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] aXt = aXt();
        if (aXt != null) {
            for (Object obj : aXt) {
                ((j) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] aXt = aXt();
        if (aXt != null) {
            for (Object obj : aXt) {
                ((j) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] aXt = aXt();
        if (aXt != null) {
            for (Object obj : aXt) {
                ((j) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] aXt = aXt();
        if (aXt != null) {
            for (Object obj : aXt) {
                ((j) obj).t(aVar);
            }
        }
    }
}
