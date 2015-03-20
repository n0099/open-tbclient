package com.baidu.adp.lib.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i extends Handler {
    private static final i wU = new i();

    private i() {
        super(Looper.getMainLooper());
    }

    public static final i hI() {
        return wU;
    }
}
