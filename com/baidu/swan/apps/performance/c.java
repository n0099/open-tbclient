package com.baidu.swan.apps.performance;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class c {
    private final Object aGE = new Object();
    private List<Runnable> aGF;

    public c f(Runnable runnable) {
        synchronized (this.aGE) {
            IG().add(runnable);
        }
        return this;
    }

    public void IF() {
        synchronized (this.aGE) {
            this.aGF = null;
        }
    }

    public List<Runnable> IG() {
        List<Runnable> list;
        synchronized (this.aGE) {
            if (this.aGF == null) {
                this.aGF = new ArrayList();
            }
            list = this.aGF;
        }
        return list;
    }

    public List<Runnable> IH() {
        List<Runnable> IG = IG();
        IF();
        return IG;
    }

    public int size() {
        if (this.aGF == null) {
            return 0;
        }
        return this.aGF.size();
    }

    public c II() {
        for (Runnable runnable : IH()) {
            runnable.run();
        }
        return this;
    }
}
