package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.idl.license.License;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class SoUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f9588a = {"bd_idl_pass_token", License.LICENSE_DEFAULT_FILE_NAME, "FaceSDK"};

    public static String a(Context context, String str) {
        Object invoke;
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            try {
                Method method = classLoader.getClass().getMethod("findLibrary", String.class);
                if (method != null && (invoke = method.invoke(classLoader, str)) != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            } catch (Exception e2) {
                Log.e("findLibrary1", e2.toString());
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
                if (declaredMethod != null) {
                    if (!declaredMethod.isAccessible()) {
                        declaredMethod.setAccessible(true);
                    }
                    Object invoke = declaredMethod.invoke(classLoader, str);
                    if (invoke != null && (invoke instanceof String)) {
                        return (String) invoke;
                    }
                }
            } catch (Exception e2) {
                Log.e("findLibrary2", e2.toString());
                return "catch Exception";
            }
        }
        return null;
    }

    public static void load(Context context) {
        String[] strArr;
        String b2;
        for (String str : f9588a) {
            if (Build.VERSION.SDK_INT > 8) {
                b2 = a(context, str);
            } else {
                b2 = b(context, str);
            }
            if (TextUtils.isEmpty(b2)) {
                Log.e("CheckDefaultSoExist", str + " so is not exist ,please put the " + str + " so file in the right folder");
            }
            System.loadLibrary(str);
        }
    }
}
