package com.baidu.adp.lib.f;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class e extends Handler {
    private static final e MX = new e();

    private e() {
        super(Looper.getMainLooper());
    }

    public static final e mX() {
        return MX;
    }
}
