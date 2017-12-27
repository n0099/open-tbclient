package com.baidu.adp.lib.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class e extends Handler {
    private static final e ako = new e();

    private e() {
        super(Looper.getMainLooper());
    }

    public static final e nr() {
        return ako;
    }
}
