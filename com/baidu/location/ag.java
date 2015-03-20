package com.baidu.location;

import android.os.Handler;
/* loaded from: classes.dex */
class ag implements a0, n {
    private static ag hm;
    public Handler hl;

    private ag() {
        this.hl = null;
        this.hl = new Handler();
    }

    public static ag bz() {
        if (hm == null) {
            hm = new ag();
        }
        return hm;
    }

    public boolean bA() {
        return false;
    }

    public synchronized void bB() {
    }

    public boolean bC() {
        return false;
    }

    public synchronized void bD() {
    }
}
