package com.baidu.mobads.container.util;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.fastjson.asm.Label;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class ActivityUtils {
    public static void changeOrientation(Activity activity) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    public static Boolean isFullScreen(Activity activity) {
        try {
            if (activity != null) {
                return Boolean.valueOf((activity.getWindow().getAttributes().flags & 1024) == 1024);
            }
            return Boolean.FALSE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    public static void runOnUiThread(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.mobads.container.util.ActivityUtils.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }
                });
            }
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2);
        }
    }

    public static void startAppPriActivity(Context context, Intent intent) {
        Class<?> shellActivityClass = AppUtils.getShellActivityClass();
        intent.putExtra("activityImplName", IReflectionInfo.APP_PRI_ACTIVITY);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.setClass(context, shellActivityClass);
        context.startActivity(intent);
    }

    public static void translucentActivity(Activity activity) {
        Class<?>[] declaredClasses;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                activity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                activity.getWindow().getDecorView().setBackground(null);
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
            } catch (Throwable unused) {
            }
        }
    }
}
