package com.baidu.live.alablmsdk.a;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes11.dex */
public class c extends Handler {
    private static final c aBp = new c();

    private c() {
        super(Looper.getMainLooper());
    }

    public static final c Bj() {
        return aBp;
    }
}
