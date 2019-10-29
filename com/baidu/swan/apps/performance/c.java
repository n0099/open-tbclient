package com.baidu.swan.apps.performance;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class c {
    private final Object bar = new Object();
    private List<Runnable> bas;

    public c d(Runnable runnable) {
        synchronized (this.bar) {
            NE().add(runnable);
        }
        return this;
    }

    public void ND() {
        synchronized (this.bar) {
            this.bas = null;
        }
    }

    public List<Runnable> NE() {
        List<Runnable> list;
        synchronized (this.bar) {
            if (this.bas == null) {
                this.bas = new ArrayList();
            }
            list = this.bas;
        }
        return list;
    }

    public List<Runnable> NF() {
        List<Runnable> NE = NE();
        ND();
        return NE;
    }

    public int size() {
        if (this.bas == null) {
            return 0;
        }
        return this.bas.size();
    }

    public c NG() {
        for (Runnable runnable : NF()) {
            runnable.run();
        }
        return this;
    }
}
