package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private static Handler d;
    HashMap<String, h> a = new HashMap<>();
    public final String b = "$|$";
    private static HandlerThread c = new HandlerThread("EventHandleThread");
    private static c e = new c();

    private c() {
        c.start();
        c.setPriority(10);
        d = new Handler(c.getLooper());
    }

    public static c a() {
        return e;
    }

    public String a(String str, String str2) {
        return "__sdk_" + str + "$|$" + str2;
    }

    public void a(Context context, String str, String str2, int i, long j) {
        d.post(new d(this, str, str2, i, j, context));
    }

    public void a(Context context, String str, String str2, long j) {
        d.post(new e(this, j, str, str2));
    }

    public void b(Context context, String str, String str2, long j) {
        d.post(new f(this, str, str2, j, context));
    }

    public void c(Context context, String str, String str2, long j) {
        d.post(new g(this, j, str, str2, context));
    }
}
