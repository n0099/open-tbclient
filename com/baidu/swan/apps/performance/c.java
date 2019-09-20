package com.baidu.swan.apps.performance;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class c {
    private final Object aHc = new Object();
    private List<Runnable> aHd;

    public c f(Runnable runnable) {
        synchronized (this.aHc) {
            IK().add(runnable);
        }
        return this;
    }

    public void IJ() {
        synchronized (this.aHc) {
            this.aHd = null;
        }
    }

    public List<Runnable> IK() {
        List<Runnable> list;
        synchronized (this.aHc) {
            if (this.aHd == null) {
                this.aHd = new ArrayList();
            }
            list = this.aHd;
        }
        return list;
    }

    public List<Runnable> IL() {
        List<Runnable> IK = IK();
        IJ();
        return IK;
    }

    public int size() {
        if (this.aHd == null) {
            return 0;
        }
        return this.aHd.size();
    }

    public c IM() {
        for (Runnable runnable : IL()) {
            runnable.run();
        }
        return this;
    }
}
