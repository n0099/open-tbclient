package com.baidu.adp.lib.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class h extends Handler {
    private static final h vS = new h();

    private h() {
        super(Looper.getMainLooper());
    }

    public static final h hh() {
        return vS;
    }
}
