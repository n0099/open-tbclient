package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes.dex */
class c {
    private static Handler b;

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f962a = new HandlerThread("EventHandleThread");
    private static c c = new c();

    private c() {
        f962a.start();
        b = new Handler(f962a.getLooper());
    }

    public static c a() {
        return c;
    }

    public void a(Context context, String str, String str2, int i) {
        b.post(new d(this, str, str2, i, context));
    }
}
