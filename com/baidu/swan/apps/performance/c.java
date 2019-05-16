package com.baidu.swan.apps.performance;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class c {
    private final Object aFW = new Object();
    private List<Runnable> aFX;

    public c f(Runnable runnable) {
        synchronized (this.aFW) {
            HT().add(runnable);
        }
        return this;
    }

    public void HS() {
        synchronized (this.aFW) {
            this.aFX = null;
        }
    }

    public List<Runnable> HT() {
        List<Runnable> list;
        synchronized (this.aFW) {
            if (this.aFX == null) {
                this.aFX = new ArrayList();
            }
            list = this.aFX;
        }
        return list;
    }

    public List<Runnable> HU() {
        List<Runnable> HT = HT();
        HS();
        return HT;
    }

    public int size() {
        if (this.aFX == null) {
            return 0;
        }
        return this.aFX.size();
    }

    public c HV() {
        for (Runnable runnable : HU()) {
            runnable.run();
        }
        return this;
    }
}
