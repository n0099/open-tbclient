package com.baidu.adp.lib.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class h extends Handler {
    private static final h vT = new h();

    private h() {
        super(Looper.getMainLooper());
    }

    public static final h hi() {
        return vT;
    }
}
