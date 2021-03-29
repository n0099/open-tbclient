package com.baidu.searchbox.process.ipc.util;

import android.app.Activity;
import android.app.ActivityOptions;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class TranslucentUtils {
    public static final boolean DEBUG = false;
    public static final String TAG = "TranslucentUtils";

    public static void convertFromTranslucent(Activity activity) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static void convertToTranslucent(Activity activity) {
        Class<?>[] declaredClasses;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activity, new Object[0]);
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, invoke);
        } catch (Exception unused) {
        }
    }
}
