package com.baidu.swan.apps.performance;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class c {
    private final Object aZZ = new Object();
    private List<Runnable> baa;

    public c d(Runnable runnable) {
        synchronized (this.aZZ) {
            NF().add(runnable);
        }
        return this;
    }

    public void NE() {
        synchronized (this.aZZ) {
            this.baa = null;
        }
    }

    public List<Runnable> NF() {
        List<Runnable> list;
        synchronized (this.aZZ) {
            if (this.baa == null) {
                this.baa = new ArrayList();
            }
            list = this.baa;
        }
        return list;
    }

    public List<Runnable> NG() {
        List<Runnable> NF = NF();
        NE();
        return NF;
    }

    public int size() {
        if (this.baa == null) {
            return 0;
        }
        return this.baa.size();
    }

    public c NH() {
        for (Runnable runnable : NG()) {
            runnable.run();
        }
        return this;
    }
}
