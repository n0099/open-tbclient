package com.baidu.swan.games.e;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d bbE;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<i> mListeners = new ArrayList<>();

    private d() {
    }

    public static d NZ() {
        if (bbE == null) {
            synchronized (d.class) {
                if (bbE == null) {
                    bbE = new d();
                }
            }
        }
        return bbE;
    }

    private Object[] Oa() {
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
    public void d(a aVar) {
        Object[] Oa = Oa();
        if (Oa != null) {
            for (Object obj : Oa) {
                ((i) obj).h(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(a aVar) {
        Object[] Oa = Oa();
        if (Oa != null) {
            for (Object obj : Oa) {
                ((i) obj).i(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(a aVar) {
        Object[] Oa = Oa();
        if (Oa != null) {
            for (Object obj : Oa) {
                ((i) obj).j(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(a aVar) {
        Object[] Oa = Oa();
        if (Oa != null) {
            for (Object obj : Oa) {
                ((i) obj).k(aVar);
            }
        }
    }
}
