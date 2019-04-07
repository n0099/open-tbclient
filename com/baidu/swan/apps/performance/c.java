package com.baidu.swan.apps.performance;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class c {
    private final Object aEd = new Object();
    private List<Runnable> aEe;

    public c f(Runnable runnable) {
        synchronized (this.aEd) {
            FL().add(runnable);
        }
        return this;
    }

    public void FK() {
        synchronized (this.aEd) {
            this.aEe = null;
        }
    }

    public List<Runnable> FL() {
        List<Runnable> list;
        synchronized (this.aEd) {
            if (this.aEe == null) {
                this.aEe = new ArrayList();
            }
            list = this.aEe;
        }
        return list;
    }

    public List<Runnable> FM() {
        List<Runnable> FL = FL();
        FK();
        return FL;
    }

    public int size() {
        if (this.aEe == null) {
            return 0;
        }
        return this.aEe.size();
    }

    public c FN() {
        for (Runnable runnable : FM()) {
            runnable.run();
        }
        return this;
    }
}
