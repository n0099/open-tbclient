package com.baidu.adp.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class a {
    public static void j(@NonNull Activity activity) {
        if (k(activity)) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                ActivityInfo activityInfo = (ActivityInfo) declaredField.get(activity);
                if (Z(activityInfo.screenOrientation)) {
                    activityInfo.screenOrientation = -1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isTranslucentOrFloating(Activity activity) {
        try {
            Field declaredField = Class.forName("com.android.internal.R$styleable").getDeclaredField("Window");
            declaredField.setAccessible(true);
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) declaredField.get(null));
            Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isTranslucentOrFloating", TypedArray.class);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(null, obtainStyledAttributes)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean k(Activity activity) {
        return Build.VERSION.SDK_INT == 26 && isTranslucentOrFloating(activity);
    }

    public static boolean Z(int i) {
        switch (i) {
            case 0:
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
            case 11:
            case 12:
                return true;
            case 2:
            case 3:
            case 4:
            case 5:
            case 10:
            default:
                return false;
        }
    }
}
