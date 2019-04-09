package com.baidu.swan.apps.performance;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class c {
    private final Object aEe = new Object();
    private List<Runnable> aEf;

    public c f(Runnable runnable) {
        synchronized (this.aEe) {
            FL().add(runnable);
        }
        return this;
    }

    public void FK() {
        synchronized (this.aEe) {
            this.aEf = null;
        }
    }

    public List<Runnable> FL() {
        List<Runnable> list;
        synchronized (this.aEe) {
            if (this.aEf == null) {
                this.aEf = new ArrayList();
            }
            list = this.aEf;
        }
        return list;
    }

    public List<Runnable> FM() {
        List<Runnable> FL = FL();
        FK();
        return FL;
    }

    public int size() {
        if (this.aEf == null) {
            return 0;
        }
        return this.aEf.size();
    }

    public c FN() {
        for (Runnable runnable : FM()) {
            runnable.run();
        }
        return this;
    }
}
