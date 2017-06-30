package com.baidu.adp.lib.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class h extends Handler {
    private static final h wH = new h();

    private h() {
        super(Looper.getMainLooper());
    }

    public static final h fR() {
        return wH;
    }
}
