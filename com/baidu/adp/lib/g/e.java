package com.baidu.adp.lib.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class e extends Handler {
    private static final e pI = new e();

    private e() {
        super(Looper.getMainLooper());
    }

    public static final e fZ() {
        return pI;
    }
}
