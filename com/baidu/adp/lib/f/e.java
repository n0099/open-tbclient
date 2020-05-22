package com.baidu.adp.lib.f;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class e extends Handler {
    private static final e LB = new e();

    private e() {
        super(Looper.getMainLooper());
    }

    public static final e ld() {
        return LB;
    }
}
