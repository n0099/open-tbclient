package com.baidu.pass.biometrics.base.dynamicupdate;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class CheckDefaultSoExist {
    private static String a(Context context, String str) {
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

    private static String b(Context context, String str) {
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

    public static void isExist(Context context) {
        String[] strArr;
        String b;
        for (String str : LoadSo.b) {
            if (Build.VERSION.SDK_INT > 8) {
                b = a(context, str);
            } else {
                b = b(context, str);
            }
            if (TextUtils.isEmpty(b)) {
                Log.e("CheckDefaultSoExist", str + " so is not exist ,please put the " + str + " so file in the right folder");
            }
        }
    }
}
