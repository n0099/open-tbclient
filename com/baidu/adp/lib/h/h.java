package com.baidu.adp.lib.h;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class h extends Handler {
    private static final h wB = new h();

    private h() {
        super(Looper.getMainLooper());
    }

    public static final h hx() {
        return wB;
    }
}
