package com.baidu.swan.apps.performance;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class c {
    private final Object aEa = new Object();
    private List<Runnable> aEb;

    public c f(Runnable runnable) {
        synchronized (this.aEa) {
            FN().add(runnable);
        }
        return this;
    }

    public void FM() {
        synchronized (this.aEa) {
            this.aEb = null;
        }
    }

    public List<Runnable> FN() {
        List<Runnable> list;
        synchronized (this.aEa) {
            if (this.aEb == null) {
                this.aEb = new ArrayList();
            }
            list = this.aEb;
        }
        return list;
    }

    public List<Runnable> FO() {
        List<Runnable> FN = FN();
        FM();
        return FN;
    }

    public int size() {
        if (this.aEb == null) {
            return 0;
        }
        return this.aEb.size();
    }

    public c FP() {
        for (Runnable runnable : FO()) {
            runnable.run();
        }
        return this;
    }
}
