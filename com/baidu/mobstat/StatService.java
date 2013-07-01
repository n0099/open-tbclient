package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
/* loaded from: classes.dex */
public class StatService {
    public static final int EXCEPTION_LOG = 1;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f571a = false;

    private static void a(Context context) {
        if (a(context, "onError(...)")) {
            e.a().a(context.getApplicationContext());
            g.a().a(true, context.getApplicationContext());
        }
    }

    private static boolean a() {
        return f571a;
    }

    private static boolean a(Context context, String str) {
        if (context == null) {
            com.baidu.mobstat.a.b.b("stat", str + ":context=null");
            return false;
        }
        return true;
    }

    private static boolean a(Class cls, String str) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        com.baidu.mobstat.a.b.a("isCalledBy", Integer.valueOf(stackTrace.length), cls, str);
        if (stackTrace.length >= 2) {
            for (int i = 2; i < stackTrace.length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                if (stackTraceElement.getMethodName().equals(str)) {
                    try {
                        Class<?> cls2 = Class.forName(stackTraceElement.getClassName());
                        com.baidu.mobstat.a.b.a("isCalledBy", cls2);
                        while (cls2.getSuperclass() != null && cls2.getSuperclass() != cls) {
                            cls2 = cls2.getSuperclass();
                            com.baidu.mobstat.a.b.a("isCalledBy", cls2);
                        }
                        if (cls2.getSuperclass() == cls) {
                            com.baidu.mobstat.a.b.a("isCalledBy hit!", cls2.getSuperclass(), cls);
                            return true;
                        }
                        continue;
                    } catch (Exception e) {
                        com.baidu.mobstat.a.b.a(e);
                    }
                }
            }
        }
        return false;
    }

    private static void b() {
        f571a = true;
    }

    public static void onEvent(Context context, String str, String str2) {
        onEvent(context, str, str2, 1);
    }

    public static void onEvent(Context context, String str, String str2, int i) {
        if (!a(context, "onEvent(...)") || str == null || str.equals("")) {
            return;
        }
        if (!f.a().b()) {
            f.a().a(context.getApplicationContext());
        }
        c.a().a(context.getApplicationContext(), str, str2, i);
    }

    public static synchronized void onPause(Context context) {
        synchronized (StatService.class) {
            if (a(context, "onPause(...)")) {
                if (!a(Activity.class, "onPause")) {
                    throw new SecurityException("onPause(Context context)不在Activity.onPause()中被调用||onPause(Context context)is not called in Activity.onPause().");
                }
                m.a().b(context, System.currentTimeMillis());
            }
        }
    }

    public static synchronized void onResume(Context context) {
        synchronized (StatService.class) {
            if (a(context, "onResume(...)")) {
                if (!a(Activity.class, "onResume")) {
                    throw new SecurityException("onResume(Context context)不在Activity.onResume()中被调用||onResume(Context context)is not called in Activity.onResume().");
                }
                if (!f.a().b()) {
                    f.a().a(context.getApplicationContext());
                }
                m.a().a(context, System.currentTimeMillis());
            }
        }
    }

    public static void setAppChannel(String str) {
        b.a().b(str);
    }

    public static void setAppKey(String str) {
        b.a().a(str);
    }

    public static void setLogSenderDelayed(int i) {
        g.a().a(i);
    }

    public static void setOn(Context context, int i) {
        if (a(context, "setOn(...)")) {
            if (!a(Activity.class, "onCreate")) {
                throw new SecurityException("setOn()没有在Activity.onCreate()内被调用||setOn()is not called in Activity.onCreate().");
            }
            if (a()) {
                return;
            }
            b();
            if ((i & 1) != 0) {
                a(context);
            }
        }
    }

    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i) {
        setSendLogStrategy(context, sendStrategyEnum, i, false);
    }

    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i, boolean z) {
        if (a(context, "setSendLogStrategy(...)")) {
            if (!f.a().b()) {
                f.a().a(context.getApplicationContext());
            }
            g.a().a(context.getApplicationContext(), sendStrategyEnum, i, z);
        }
    }
}
