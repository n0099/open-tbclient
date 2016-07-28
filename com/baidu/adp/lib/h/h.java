package com.baidu.adp.lib.h;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class h extends Handler {
    private static final h nd = new h();

    private h() {
        super(Looper.getMainLooper());
    }

    public static final h dL() {
        return nd;
    }
}
