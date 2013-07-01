package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private static Handler b;

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f576a = new HandlerThread("EventHandleThread");
    private static c c = new c();

    private c() {
        f576a.start();
        b = new Handler(f576a.getLooper());
    }

    public static c a() {
        return c;
    }

    public void a(Context context, String str, String str2, int i) {
        b.post(new d(this, str, str2, i, context));
    }
}
