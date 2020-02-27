package com.baidu.mobads.utils;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public class b {
    private static Context a;
    private static File e;
    private static String b = null;
    private static String c = "galaxy_sdk_dex.jar";
    private static String d = null;
    private static DexClassLoader f = null;

    public static String a(Context context) {
        Class b2 = b(context);
        if (b2 != null) {
            try {
                Method declaredMethod = b2.getDeclaredMethod("getCUID", Context.class);
                declaredMethod.setAccessible(true);
                String str = (String) declaredMethod.invoke(null, context.getApplicationContext());
                if (TextUtils.isEmpty(str)) {
                    return "null";
                }
                return str;
            } catch (Exception e2) {
                return "null";
            }
        }
        return "null";
    }

    private static Class b(Context context) {
        Class cls = null;
        try {
            return Class.forName("com.baidu.android.common.util.CommonParam");
        } catch (Exception e2) {
            if (0 != 0) {
                return null;
            }
            try {
                if (f != null) {
                    cls = f.loadClass("com.baidu.android.common.util.CommonParam");
                } else {
                    c(context);
                    a();
                    if (f != null) {
                        cls = f.loadClass("com.baidu.android.common.util.CommonParam");
                    }
                }
                return cls;
            } catch (Exception e3) {
                e3.printStackTrace();
                return cls;
            }
        }
    }

    private static void c(Context context) {
        a = context.getApplicationContext();
        d = a.getFilesDir().getAbsolutePath();
        d(context);
        e = new File(b + c);
    }

    private static void d(Context context) {
        if (TextUtils.isEmpty(b)) {
            b = a.getDir("baidu_ad_sdk", 0).getAbsolutePath() + "/";
        }
    }

    private static void a() {
        try {
            synchronized (b.class) {
                String absolutePath = e.getAbsolutePath();
                if (new File(absolutePath).exists()) {
                    f = new DexClassLoader(absolutePath, d, null, a.getClass().getClassLoader());
                } else {
                    f = null;
                }
            }
        } catch (Exception e2) {
            f = null;
        }
    }
}
