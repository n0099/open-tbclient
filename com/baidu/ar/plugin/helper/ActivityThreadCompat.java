package com.baidu.ar.plugin.helper;

import android.app.Instrumentation;
import android.os.Handler;
import android.os.Looper;
import com.baidu.ar.plugin.reflect.MethodUtils;
/* loaded from: classes.dex */
public class ActivityThreadCompat {
    public static Object sActivityThread;
    public static Class sClass;

    public static final Class activityThreadClass() {
        if (sClass == null) {
            sClass = Class.forName("android.app.ActivityThread");
        }
        return sClass;
    }

    public static final synchronized Object currentActivityThread() {
        Object obj;
        synchronized (ActivityThreadCompat.class) {
            if (sActivityThread == null) {
                Object invokeStaticMethod = MethodUtils.invokeStaticMethod(activityThreadClass(), "currentActivityThread", new Object[0]);
                sActivityThread = invokeStaticMethod;
                if (invokeStaticMethod == null) {
                    sActivityThread = currentActivityThread2();
                }
            }
            obj = sActivityThread;
        }
        return obj;
    }

    public static Object currentActivityThread2() {
        Handler handler = new Handler(Looper.getMainLooper());
        final Object obj = new Object();
        handler.post(new Runnable() { // from class: com.baidu.ar.plugin.helper.ActivityThreadCompat.1
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        Object unused = ActivityThreadCompat.sActivityThread = MethodUtils.invokeStaticMethod(ActivityThreadCompat.activityThreadClass(), "currentActivityThread", new Object[0]);
                        synchronized (obj) {
                            obj.notifyAll();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        synchronized (obj) {
                            obj.notifyAll();
                        }
                    }
                } catch (Throwable th) {
                    synchronized (obj) {
                        obj.notifyAll();
                        throw th;
                    }
                }
            }
        });
        if (sActivityThread != null || Looper.getMainLooper() == Looper.myLooper()) {
            return null;
        }
        synchronized (obj) {
            try {
                obj.wait(300L);
            } catch (InterruptedException unused) {
            }
        }
        return null;
    }

    public static Instrumentation getInstrumentation() {
        return (Instrumentation) MethodUtils.invokeMethod(currentActivityThread(), "getInstrumentation", new Object[0]);
    }
}
