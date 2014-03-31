package com.baidu.batsdk.a;

import android.content.Context;
import com.baidu.batsdk.b.e;
/* loaded from: classes.dex */
public final class a extends Thread {
    private static Context a;
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static a e;

    private a() {
    }

    private static a b() {
        if (e == null) {
            a aVar = new a();
            e = aVar;
            aVar.setName("BatSDK.BackendThread");
            e.setPriority(1);
        }
        return e;
    }

    public static void a(Context context) {
        a = context;
        if (!b().isAlive()) {
            b().start();
        }
    }

    public static void a() {
        b().interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            com.baidu.batsdk.f.a.b(String.valueOf(e.a()) + "'s BackendThread is running.");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                com.baidu.batsdk.f.a.b("Interrupted!", e2);
            }
            d.a(a);
            b.a(a);
            c.a(a);
            try {
                Thread.sleep(com.baidu.batsdk.a.v);
            } catch (InterruptedException e3) {
                com.baidu.batsdk.f.a.b("Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
