package com.baidu.mobads.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.lang.Thread;
/* loaded from: classes14.dex */
public class q implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static String f3347a = "";

    /* renamed from: b  reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f3348b;
    private static volatile q c;
    private Context d;
    private a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public interface a {
        void a(String str);
    }

    public static q a(Context context) {
        if (c == null) {
            synchronized (q.class) {
                if (c == null) {
                    c = new q(context);
                }
            }
        }
        return c;
    }

    private q(Context context) {
        this.d = context.getApplicationContext();
        f3348b = Thread.getDefaultUncaughtExceptionHandler();
        new Thread(new r(this)).start();
    }

    public void a() {
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof q)) {
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a2 = a(th);
            if (a2 != null) {
                a(a2, Log.getStackTraceString(th));
                th.printStackTrace();
                if (this.e != null) {
                    this.e.a(a2);
                }
            }
            if (f3348b != null) {
                f3348b.uncaughtException(thread, th);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void b() {
        this.e = null;
    }

    private String a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
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
                if (className.startsWith("com.baidu.mobads_vr")) {
                    return "vr";
                }
                if (className.startsWith("com.baidu.mobads")) {
                    return IMTrack.AckBuilder.PROXY_TYPE;
                }
            }
        }
        return null;
    }

    private SharedPreferences c() {
        return this.d.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private SharedPreferences.Editor d() {
        return c().edit();
    }

    private void a(String str, String str2) {
        SharedPreferences.Editor d = d();
        d.putString("key_crash_source", str);
        d.putString("key_crash_trace", str2);
        d.putString("key_crash_ad", f3347a);
        if (Build.VERSION.SDK_INT >= 9) {
            d.apply();
        } else {
            d.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return c().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        SharedPreferences.Editor d = d();
        d.clear();
        if (Build.VERSION.SDK_INT >= 9) {
            d.apply();
        } else {
            d.commit();
        }
    }
}
