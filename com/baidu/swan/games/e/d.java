package com.baidu.swan.games.e;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d byS;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<i> mListeners = new ArrayList<>();

    private d() {
    }

    public static d WG() {
        if (byS == null) {
            synchronized (d.class) {
                if (byS == null) {
                    byS = new d();
                }
            }
        }
        return byS;
    }

    private Object[] WH() {
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
        Object[] WH = WH();
        if (WH != null) {
            for (Object obj : WH) {
                ((i) obj).o(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(a aVar) {
        Object[] WH = WH();
        if (WH != null) {
            for (Object obj : WH) {
                ((i) obj).c(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        Object[] WH = WH();
        if (WH != null) {
            for (Object obj : WH) {
                ((i) obj).p(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        Object[] WH = WH();
        if (WH != null) {
            for (Object obj : WH) {
                ((i) obj).q(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        Object[] WH = WH();
        if (WH != null) {
            for (Object obj : WH) {
                ((i) obj).r(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        Object[] WH = WH();
        if (WH != null) {
            for (Object obj : WH) {
                ((i) obj).s(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(a aVar) {
        Object[] WH = WH();
        if (WH != null) {
            for (Object obj : WH) {
                ((i) obj).t(aVar);
            }
        }
    }
}
