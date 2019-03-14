package com.baidu.swan.games.e;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d bbB;
    private final Lock mLock = new ReentrantLock();
    private ArrayList<i> mListeners = new ArrayList<>();

    private d() {
    }

    public static d Ob() {
        if (bbB == null) {
            synchronized (d.class) {
                if (bbB == null) {
                    bbB = new d();
                }
            }
        }
        return bbB;
    }

    private Object[] Oc() {
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
        Object[] Oc = Oc();
        if (Oc != null) {
            for (Object obj : Oc) {
                ((i) obj).h(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(a aVar) {
        Object[] Oc = Oc();
        if (Oc != null) {
            for (Object obj : Oc) {
                ((i) obj).i(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(a aVar) {
        Object[] Oc = Oc();
        if (Oc != null) {
            for (Object obj : Oc) {
                ((i) obj).j(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(a aVar) {
        Object[] Oc = Oc();
        if (Oc != null) {
            for (Object obj : Oc) {
                ((i) obj).k(aVar);
            }
        }
    }
}
