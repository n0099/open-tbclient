package com.baidu.live.alablmsdk.a;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public class d extends Handler {
    private static final d ayI = new d();

    private d() {
        super(Looper.getMainLooper());
    }

    public static final d Ay() {
        return ayI;
    }
}
