package com.baidu.ar.plugin.helper;

import android.app.Instrumentation;
import android.os.Handler;
import android.os.Looper;
import com.baidu.ar.plugin.reflect.MethodUtils;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes20.dex */
public class ActivityThreadCompat {
    private static Object sActivityThread;
    private static Class sClass = null;

    public static final synchronized Object currentActivityThread() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object obj;
        synchronized (ActivityThreadCompat.class) {
            if (sActivityThread == null) {
                sActivityThread = MethodUtils.invokeStaticMethod(activityThreadClass(), "currentActivityThread", new Object[0]);
                if (sActivityThread == null) {
                    sActivityThread = currentActivityThread2();
                }
            }
            obj = sActivityThread;
        }
        return obj;
    }

    public static final Class activityThreadClass() throws ClassNotFoundException {
        if (sClass == null) {
            sClass = Class.forName("android.app.ActivityThread");
        }
        return sClass;
    }

    private static Object currentActivityThread2() {
        Handler handler = new Handler(Looper.getMainLooper());
        final Object obj = new Object();
        handler.post(new Runnable() { // from class: com.baidu.ar.plugin.helper.ActivityThreadCompat.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [47=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        Object unused = ActivityThreadCompat.sActivityThread = MethodUtils.invokeStaticMethod(ActivityThreadCompat.activityThreadClass(), "currentActivityThread", new Object[0]);
                        synchronized (obj) {
                            obj.notifyAll();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
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
        if (sActivityThread == null && Looper.getMainLooper() != Looper.myLooper()) {
            synchronized (obj) {
                try {
                    obj.wait(300L);
                } catch (InterruptedException e) {
                }
            }
            return null;
        }
        return null;
    }

    public static Instrumentation getInstrumentation() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        return (Instrumentation) MethodUtils.invokeMethod(currentActivityThread(), "getInstrumentation", new Object[0]);
    }
}
