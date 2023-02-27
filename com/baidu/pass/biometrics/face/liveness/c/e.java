package com.baidu.pass.biometrics.face.liveness.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import java.io.File;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class e {
    public static String a(Context context, String str) {
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            try {
                Object invoke = classLoader.getClass().getMethod("findLibrary", String.class).invoke(classLoader, str);
                if (invoke instanceof String) {
                    return (String) invoke;
                }
            } catch (Exception e) {
                Log.e("findLibrary1", e.toString());
                return "catch Exception";
            }
        }
        return null;
    }

    public static String b(Context context, String str) {
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            try {
                Method declaredMethod = classLoader.getClass().getDeclaredMethod("findLibrary", String.class);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                Object invoke = declaredMethod.invoke(classLoader, str);
                if (invoke instanceof String) {
                    return (String) invoke;
                }
            } catch (Exception e) {
                Log.e("findLibrary2", e.toString());
                return "catch Exception";
            }
        }
        return null;
    }

    public static boolean a(Context context) {
        if (b(context)) {
            return true;
        }
        return c(context);
    }

    public static boolean b(Context context) {
        String b;
        try {
            if (Build.VERSION.SDK_INT > 8) {
                b = a(context, "mml_framework");
            } else {
                b = b(context, "mml_framework");
            }
            if (TextUtils.isEmpty(b)) {
                Log.e("CheckDefaultSoExist", "mml_framework so is not exist ,please put the mml_framework so file in the right folder");
                return false;
            }
            System.loadLibrary("mml_framework");
            return true;
        } catch (Throwable unused) {
            Log.e("mml_framework.so is not exist in general dirs", new Object[0]);
            return false;
        }
    }

    public static boolean c(Context context) {
        try {
            System.load((context.getFilesDir() + File.separator + "ai_model" + File.separator) + ("box.ai.library.mmlnative" + File.separator) + "libmml_framework.so");
            return true;
        } catch (Throwable unused) {
            Log.e("mml_framework.so is not exist in searchbox dirs", new Object[0]);
            return false;
        }
    }
}
