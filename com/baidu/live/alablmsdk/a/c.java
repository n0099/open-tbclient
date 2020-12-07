package com.baidu.live.alablmsdk.a;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public class c extends Handler {
    private static final c aAY = new c();

    private c() {
        super(Looper.getMainLooper());
    }

    public static final c BS() {
        return aAY;
    }
}
