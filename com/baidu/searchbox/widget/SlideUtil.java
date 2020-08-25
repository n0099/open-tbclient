package com.baidu.searchbox.widget;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes4.dex */
public class SlideUtil {
    public static void convertToTranslucent(Activity activity, OnTranslucentListener onTranslucentListener) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                convertActivityToTranslucentAfterL(activity, onTranslucentListener);
            } else {
                convertActivityToTranslucentBeforeL(activity, onTranslucentListener);
            }
        } catch (Throwable th) {
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(false);
            }
        }
    }

    public static void convertFromTranslucent(Activity activity, OnTranslucentListener onTranslucentListener) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(false);
            }
        } catch (Throwable th) {
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(true);
            }
            th.printStackTrace();
        }
    }

    private static void convertActivityToTranslucentBeforeL(Activity activity, OnTranslucentListener onTranslucentListener) {
        Class<?> cls = null;
        try {
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
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, null);
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(true);
            }
        } catch (Throwable th) {
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(false);
            }
        }
    }

    private static void convertActivityToTranslucentAfterL(Activity activity, OnTranslucentListener onTranslucentListener) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activity, new Object[0]);
            Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
            Class<?> cls = null;
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
            Object newProxyInstance = Proxy.newProxyInstance(Activity.class.getClassLoader(), new Class[]{cls}, new TranslucentInvocationHandler(onTranslucentListener));
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, newProxyInstance, invoke);
        } catch (Throwable th) {
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(false);
            }
        }
    }

    public static Drawable getImageFromFile(Context context, String str) {
        Bitmap decodeFile;
        Drawable bitmapDrawable;
        if (context == null || TextUtils.isEmpty(str) || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
            return null;
        }
        byte[] ninePatchChunk = decodeFile.getNinePatchChunk();
        if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
            bitmapDrawable = new NinePatchDrawable(context.getResources(), decodeFile, ninePatchChunk, new Rect(), null);
        } else {
            bitmapDrawable = new BitmapDrawable(context.getResources(), decodeFile);
        }
        return bitmapDrawable;
    }
}
