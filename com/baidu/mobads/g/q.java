package com.baidu.mobads.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.mobads.BuildConfig;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class q implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static String f8306a = "";

    /* renamed from: b  reason: collision with root package name */
    public static Thread.UncaughtExceptionHandler f8307b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile q f8308c;

    /* renamed from: d  reason: collision with root package name */
    public Context f8309d;

    /* renamed from: e  reason: collision with root package name */
    public a f8310e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);
    }

    public q(Context context) {
        this.f8309d = context.getApplicationContext();
        f8307b = Thread.getDefaultUncaughtExceptionHandler();
        com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new r(this));
    }

    private SharedPreferences c() {
        return this.f8309d.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private SharedPreferences.Editor d() {
        return c().edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        SharedPreferences.Editor d2 = d();
        d2.clear();
        if (Build.VERSION.SDK_INT >= 9) {
            d2.apply();
        } else {
            d2.commit();
        }
    }

    public void b() {
        this.f8310e = null;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a2 = a(th);
            if (a2 != null) {
                a(a2, Log.getStackTraceString(th));
                if (this.f8310e != null) {
                    this.f8310e.a(a2);
                }
            }
            if (f8307b != null) {
                f8307b.uncaughtException(thread, th);
            }
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e2);
        }
    }

    public static q a(Context context) {
        if (f8308c == null) {
            synchronized (q.class) {
                if (f8308c == null) {
                    f8308c = new q(context);
                }
            }
        }
        return f8308c;
    }

    public void a() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof q) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void a(a aVar) {
        this.f8310e = aVar;
    }

    private String a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className.startsWith("junit.framework")) {
                return null;
            }
            if (className.startsWith("com.baidu.mobads.container")) {
                return "remote";
            }
            if (className.startsWith("com.baidu.mobads.loader")) {
                return "loader";
            }
            if (className.startsWith(BuildConfig.APPLICATION_ID)) {
                return IMTrack.AckBuilder.PROXY_TYPE;
            }
            if (className.startsWith("com.baidu.mobstat.forbes")) {
                return "third-mtj";
            }
        }
        return null;
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor d2 = d();
        d2.putString("key_crash_source", str);
        d2.putString("key_crash_trace", ("crashtime:" + System.currentTimeMillis() + " ") + str2);
        d2.putString("key_crash_ad", f8306a);
        if (Build.VERSION.SDK_INT >= 9) {
            d2.apply();
        } else {
            d2.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return c().getString(str, "");
    }
}
