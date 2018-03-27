package com.baidu.sofire.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public final class j {
    private static final j aGl = new j();
    private HandlerThread a = new HandlerThread("rp_th", 10);
    private Handler b;

    private j() {
        this.a.start();
        this.b = new Handler(this.a.getLooper());
    }

    public static Looper vC() {
        return aGl.b.getLooper();
    }
}
