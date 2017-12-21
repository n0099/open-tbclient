package com.baidu.sofire.rp.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public final class c {
    private static final c QT = new c();
    private HandlerThread a = new HandlerThread("rp_th", 10);
    private Handler b;

    private c() {
        this.a.start();
        this.b = new Handler(this.a.getLooper());
    }

    public static Looper np() {
        return QT.b.getLooper();
    }
}
