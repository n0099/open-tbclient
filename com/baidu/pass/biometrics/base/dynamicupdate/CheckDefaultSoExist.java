package com.baidu.pass.biometrics.base.dynamicupdate;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class CheckDefaultSoExist {
    public static void isExist(Context context) {
        String[] strArr;
        String findLibrary2;
        for (String str : LoadSo.SO_NAME_ARRAY) {
            if (Build.VERSION.SDK_INT > 8) {
                findLibrary2 = findLibrary1(context, str);
            } else {
                findLibrary2 = findLibrary2(context, str);
            }
            if (TextUtils.isEmpty(findLibrary2)) {
                Log.e("CheckDefaultSoExist", str + " so is not exist ,please put the " + str + " so file in the right folder");
            }
        }
    }

    private static String findLibrary1(Context context, String str) {
        Object invoke;
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            try {
                Method method = classLoader.getClass().getMethod("findLibrary", String.class);
                if (method != null && (invoke = method.invoke(classLoader, str)) != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            } catch (Exception e) {
                Log.e("findLibrary1", e.toString());
                return "catch Exception";
            }
        }
        return null;
    }

    private static String findLibrary2(Context context, String str) {
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            try {
                Method declaredMethod = classLoader.getClass().getDeclaredMethod("findLibrary", String.class);
                if (declaredMethod != null) {
                    if (!declaredMethod.isAccessible()) {
                        declaredMethod.setAccessible(true);
                    }
                    Object invoke = declaredMethod.invoke(classLoader, str);
                    if (invoke != null && (invoke instanceof String)) {
                        return (String) invoke;
                    }
                }
            } catch (Exception e) {
                Log.e("findLibrary2", e.toString());
                return "catch Exception";
            }
        }
        return null;
    }
}
