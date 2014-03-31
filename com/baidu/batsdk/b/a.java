package com.baidu.batsdk.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.baidu.batsdk.ui.BatsdkService;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public final class a {
    private static Activity a;
    private static com.baidu.batsdk.f.c<String> b = new com.baidu.batsdk.f.c<>(com.baidu.batsdk.a.n);
    private static long c;

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        c = System.currentTimeMillis();
        if (b.h() >= 14) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.baidu.batsdk.b.a.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    com.baidu.batsdk.f.a.a("onActivityCreated " + activity.getClass().getName());
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityDestroyed(Activity activity) {
                    com.baidu.batsdk.f.a.a("onActivityDestroyed " + activity.getClass().getName());
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPaused(Activity activity) {
                    com.baidu.batsdk.f.a.a("onActivityPaused " + activity.getClass().getName());
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityResumed(Activity activity) {
                    com.baidu.batsdk.f.a.a("onActivityResumed " + activity.getClass().getName());
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStarted(Activity activity) {
                    com.baidu.batsdk.f.a.a("onActivityStarted " + activity.getClass().getName());
                    a.c(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStopped(Activity activity) {
                    com.baidu.batsdk.f.a.a("onActivityStopped " + activity.getClass().getName());
                    BatsdkService.c();
                }
            });
        } else {
            com.baidu.batsdk.f.a.c("ActivityCollector: API < 14, so this will make a mirracle.");
        }
    }

    public static long a() {
        return c;
    }

    public static String b() {
        StringBuilder sb = new StringBuilder();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            sb.append("[").append(i).append(": ").append(b.get((size - i) - 1)).append("]\n");
        }
        return sb.toString();
    }

    public static String c() {
        return a == null ? "N/A" : a.getClass().getName();
    }

    public static byte[] d() {
        if (a == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = a.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, com.baidu.batsdk.a.r, byteArrayOutputStream);
            } else {
                com.baidu.batsdk.f.a.c("getScreenshot failed, curActivity " + a.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.batsdk.f.a.b("getScreenshot failed, curActivity " + a.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void a(Activity activity) {
        if (b.h() < 14) {
            com.baidu.batsdk.f.a.a("whenActivityStart " + activity.getClass().getName());
            c(activity);
        }
    }

    public static void b(Activity activity) {
        if (b.h() < 14) {
            com.baidu.batsdk.f.a.a("whenActivityStop " + activity.getClass().getName());
            BatsdkService.c();
        }
    }

    public static void c(Activity activity) {
        a = activity;
        b.add(activity.getClass().getName());
        BatsdkService.b();
        Context baseContext = activity.getBaseContext();
        if (!"startApp".equals(b.r(baseContext))) {
            com.baidu.batsdk.e.b.a(baseContext);
        }
        com.baidu.batsdk.e.a.a(activity);
    }
}
