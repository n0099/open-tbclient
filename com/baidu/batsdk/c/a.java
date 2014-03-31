package com.baidu.batsdk.c;

import android.app.Application;
import android.os.Looper;
import android.os.Process;
import com.baidu.batsdk.b.b;
import com.baidu.batsdk.b.g;
import java.lang.Thread;
/* loaded from: classes.dex */
public final class a implements Thread.UncaughtExceptionHandler {
    private final Application a;
    private Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();

    public a(Application application) {
        this.a = application;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* JADX WARN: Type inference failed for: r0v22, types: [com.baidu.batsdk.c.a$1] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            com.baidu.batsdk.f.a.d("BatSDK caught a " + th.getClass().getName() + " from " + this.a.getPackageName() + ".");
            if (thread == null || th == null) {
                com.baidu.batsdk.f.a.d("WHY! handleException got a null Throwable.");
            }
            if (com.baidu.batsdk.a.s != null && com.baidu.batsdk.a.s.length() > 0) {
                new Thread() { // from class: com.baidu.batsdk.c.a.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        Looper.prepare();
                        b.a(a.this.a, com.baidu.batsdk.a.s, 1);
                        Looper.loop();
                    }
                }.start();
            }
            b.a(this.a, b.a(b.a(this.a, th)));
            g.f();
            com.baidu.batsdk.a.a.a();
            if (this.b != null) {
                this.b.uncaughtException(thread, th);
                return;
            }
            com.baidu.batsdk.f.a.c("why app not exit?");
            Process.killProcess(Process.myPid());
            System.exit(10);
            com.baidu.batsdk.f.a.c("WHY!!!!!!!!!");
        } catch (Throwable th2) {
            if (this.b != null) {
                this.b.uncaughtException(thread, th);
            }
        }
    }
}
