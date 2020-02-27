package com.baidu.searchbox.process.ipc.util;

import android.app.Activity;
import android.app.ActivityOptions;
import java.lang.reflect.Method;
/* loaded from: classes11.dex */
public class TranslucentUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "TranslucentUtils";

    public static void convertFromTranslucent(Activity activity) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
        } catch (Exception e) {
        }
    }

    public static void convertToTranslucent(Activity activity) {
        Class<?> cls = null;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activity, new Object[0]);
            Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
            int length = declaredClasses.length;
            int i = 0;
            while (i < length) {
                Class<?> cls2 = declaredClasses[i];
                if (!cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls2 = cls;
                }
                i++;
                cls = cls2;
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, invoke);
        } catch (Exception e) {
        }
    }
}
