package com.baidu.live.alablmsdk.a;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes10.dex */
public class c extends Handler {
    private static final c axR = new c();

    private c() {
        super(Looper.getMainLooper());
    }

    public static final c xr() {
        return axR;
    }
}
