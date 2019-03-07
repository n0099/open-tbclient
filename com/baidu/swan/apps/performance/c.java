package com.baidu.swan.apps.performance;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class c {
    private final Object aDZ = new Object();
    private List<Runnable> aEa;

    public c f(Runnable runnable) {
        synchronized (this.aDZ) {
            FN().add(runnable);
        }
        return this;
    }

    public void FM() {
        synchronized (this.aDZ) {
            this.aEa = null;
        }
    }

    public List<Runnable> FN() {
        List<Runnable> list;
        synchronized (this.aDZ) {
            if (this.aEa == null) {
                this.aEa = new ArrayList();
            }
            list = this.aEa;
        }
        return list;
    }

    public List<Runnable> FO() {
        List<Runnable> FN = FN();
        FM();
        return FN;
    }

    public int size() {
        if (this.aEa == null) {
            return 0;
        }
        return this.aEa.size();
    }

    public c FP() {
        for (Runnable runnable : FO()) {
            runnable.run();
        }
        return this;
    }
}
