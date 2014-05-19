package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
/* loaded from: classes.dex */
public class StatService {
    public static final int EXCEPTION_LOG = 1;
    private static boolean a = false;

    private static void a(Context context) {
        if (a(context, "onError(...)")) {
            i.a().a(context.getApplicationContext());
            k.a().a(true, context.getApplicationContext());
        }
    }

    private static boolean a() {
        return a;
    }

    private static boolean a(Context context, String str) {
        if (context == null) {
            com.baidu.mobstat.a.e.c("statsdk", str + ":context=null");
            return false;
        }
        return true;
    }

    static boolean a(Class<?> cls, String str) {
        boolean z = false;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        com.baidu.mobstat.a.e.a("isCalledBy", Integer.valueOf(stackTrace.length), cls, str);
        if (stackTrace.length >= 2) {
            for (int i = 2; i < stackTrace.length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                if (stackTraceElement.getMethodName().equals(str)) {
                    try {
                        Class<?> cls2 = Class.forName(stackTraceElement.getClassName());
                        com.baidu.mobstat.a.e.a("isCalledBy", cls2);
                        while (cls2.getSuperclass() != null && cls2.getSuperclass() != cls) {
                            cls2 = cls2.getSuperclass();
                            com.baidu.mobstat.a.e.a("isCalledBy", cls2);
                        }
                        z = true;
                    } catch (Exception e) {
                        com.baidu.mobstat.a.e.a(e);
                    }
                }
            }
        }
        return z;
    }

    private static void b() {
        a = true;
    }

    private static void b(Context context) {
        if (j.a().b()) {
            return;
        }
        j.a().a(context.getApplicationContext());
    }

    public static String getCuid(Context context) {
        return CooperService.getCUID(context, false);
    }

    public static void onEvent(Context context, String str, String str2) {
        onEvent(context, str, str2, 1);
    }

    public static void onEvent(Context context, String str, String str2, int i) {
        if (!a(context, "onEvent(...)") || str == null || str.equals("")) {
            return;
        }
        b(context);
        c.a().a(context.getApplicationContext(), str, str2, i, System.currentTimeMillis());
    }

    public static void onEventDuration(Context context, String str, String str2, long j) {
        if (!a(context, "onEventDuration(...)") || str == null || str.equals("")) {
            return;
        }
        if (j <= 0) {
            com.baidu.mobstat.a.e.b("statsdk", "onEventDuration: duration must be greater than zero");
            return;
        }
        b(context);
        c.a().c(context.getApplicationContext(), str, str2, j);
    }

    public static void onEventEnd(Context context, String str, String str2) {
        if (!a(context, "onEventEnd(...)") || str == null || str.equals("")) {
            return;
        }
        b(context);
        c.a().b(context.getApplicationContext(), str, str2, System.currentTimeMillis());
    }

    public static void onEventStart(Context context, String str, String str2) {
        if (!a(context, "onEventStart(...)") || str == null || str.equals("")) {
            return;
        }
        b(context);
        c.a().a(context.getApplicationContext(), str, str2, System.currentTimeMillis());
    }

    public static synchronized void onPageEnd(Context context, String str) {
        synchronized (StatService.class) {
            if (context != null && str != null) {
                if (!str.equals("")) {
                    com.baidu.mobstat.a.e.a("sdkstat", "*******onPageEnd=" + str);
                    q.b().b(context, System.currentTimeMillis(), str);
                }
            }
            com.baidu.mobstat.a.e.c("statsdk", "onPageEnd :parame=null || empty");
        }
    }

    public static synchronized void onPageStart(Context context, String str) {
        synchronized (StatService.class) {
            if (context != null && str != null) {
                if (!str.equals("")) {
                    com.baidu.mobstat.a.e.a("sdkstat", "*******onPageStart=" + str);
                    b(context);
                    q.b().a(context, System.currentTimeMillis(), str);
                }
            }
            com.baidu.mobstat.a.e.c("statsdk", "onPageStart :parame=null || empty");
        }
    }

    public static synchronized void onPause(Context context) {
        synchronized (StatService.class) {
            if (a(context, "onPause(...)")) {
                if (!a(Activity.class, "onPause")) {
                    throw new SecurityException("onPause(Context context)不在Activity.onPause()中被调用||onPause(Context context)is not called in Activity.onPause().");
                }
                q.b().b(context, System.currentTimeMillis());
            }
        }
    }

    public static synchronized void onPause(Fragment fragment) {
        synchronized (StatService.class) {
            if (fragment == null) {
                com.baidu.mobstat.a.e.c("statsdk", "onResume :parame=null");
            } else if (!a(Fragment.class, "onPause")) {
                throw new SecurityException("Fragment onPause(Context context)不在Fragment.onPause()中被调用||onPause(Context context)is not called in Fragment.onPause().");
            } else {
                q.b().b(fragment, System.currentTimeMillis());
            }
        }
    }

    public static synchronized void onPause(Object obj) {
        synchronized (StatService.class) {
            if (obj == null) {
                com.baidu.mobstat.a.e.c("statsdk", "android.app.Fragment onResume :parame=null");
            } else if (!a(obj.getClass(), "onPause")) {
                throw new SecurityException("android.app.Fragment onPause(Context context)不在android.app.Fragment.onPause()中被调用||onPause(Context context)is not called in android.app.Fragment.onPause().");
            } else {
                q.b().b(obj, System.currentTimeMillis());
            }
        }
    }

    public static synchronized void onResume(Context context) {
        synchronized (StatService.class) {
            if (a(context, "onResume(...)")) {
                if (!a(Activity.class, "onResume")) {
                    throw new SecurityException("onResume(Context context)不在Activity.onResume()中被调用||onResume(Context context)is not called in Activity.onResume().");
                }
                b(context);
                q.b().a(context, System.currentTimeMillis());
            }
        }
    }

    public static synchronized void onResume(Fragment fragment) {
        synchronized (StatService.class) {
            if (fragment == null) {
                com.baidu.mobstat.a.e.c("statsdk", "onResume :parame=null");
            } else if (!a(Fragment.class, "onResume")) {
                throw new SecurityException("onResume(Context context)不在Activity.onResume()中被调用||onResume(Context context)is not called in Activity.onResume().");
            } else {
                b(fragment.getActivity());
                q.b().a(fragment, System.currentTimeMillis());
            }
        }
    }

    public static synchronized void onResume(Object obj) {
        synchronized (StatService.class) {
            if (obj == null) {
                com.baidu.mobstat.a.e.c("statsdk", "onResume :parame=null");
            } else if (!a(obj.getClass(), "onResume")) {
                throw new SecurityException("onResume(Context context)不在Activity.onResume()中被调用||onResume(Context context)is not called in Activity.onResume().");
            } else {
                b(q.a(obj));
                q.b().a(obj, System.currentTimeMillis());
            }
        }
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        DataCore.getInstance().setAppChannel(context, str, z);
    }

    public static void setAppChannel(String str) {
        DataCore.getInstance().setAppChannel(str);
    }

    public static void setAppKey(String str) {
        DataCore.getInstance().setAppKey(str);
    }

    public static void setDebugOn(boolean z) {
        if (z) {
            com.baidu.mobstat.a.b.a = 2;
        } else {
            com.baidu.mobstat.a.b.a = 7;
        }
    }

    public static void setLogSenderDelayed(int i) {
        k.a().a(i);
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
            b(context);
            k.a().a(context.getApplicationContext(), sendStrategyEnum, i, z);
        }
    }

    public static void setSessionTimeOut(int i) {
        if (i <= 0) {
            com.baidu.mobstat.a.e.b("SessionTimeOut is between 1 and 600. Default value[30] is used");
        } else if (i <= 600) {
            q.b().a(i);
        } else {
            com.baidu.mobstat.a.e.b("SessionTimeOut is between 1 and 600. Value[600] is used");
            q.b().a(i);
        }
    }
}
