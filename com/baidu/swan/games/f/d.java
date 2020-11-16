package com.baidu.swan.games.f;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class d {
    private static volatile d dRZ;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<j> mListeners = new ArrayList<>();

    private d() {
    }

    public static d aUn() {
        if (dRZ == null) {
            synchronized (d.class) {
                if (dRZ == null) {
                    dRZ = new d();
                }
            }
        }
        return dRZ;
    }

    private Object[] aUo() {
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
        Object[] aUo = aUo();
        if (aUo != null) {
            for (Object obj : aUo) {
                ((j) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] aUo = aUo();
        if (aUo != null) {
            for (Object obj : aUo) {
                ((j) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] aUo = aUo();
        if (aUo != null) {
            for (Object obj : aUo) {
                ((j) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] aUo = aUo();
        if (aUo != null) {
            for (Object obj : aUo) {
                ((j) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] aUo = aUo();
        if (aUo != null) {
            for (Object obj : aUo) {
                ((j) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] aUo = aUo();
        if (aUo != null) {
            for (Object obj : aUo) {
                ((j) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] aUo = aUo();
        if (aUo != null) {
            for (Object obj : aUo) {
                ((j) obj).t(aVar);
            }
        }
    }
}
