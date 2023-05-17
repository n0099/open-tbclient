package com.baidu.mobstat;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class cc {
    public static Object a;
    public static Class<?> b;
    public static Method c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            a = cls.newInstance();
            c = b.getMethod("getOAID", Context.class);
        } catch (Exception unused) {
        }
    }

    public static String a(Context context) {
        return a(context, c);
    }

    public static String a(Context context, Method method) {
        Object obj = a;
        if (obj != null && method != null) {
            try {
                Object invoke = method.invoke(obj, context);
                if (invoke != null) {
                    return (String) invoke;
                }
                return null;
            } catch (Exception e) {
                Log.e("IdentifierManager", "invoke exception!", e);
                return null;
            }
        }
        return null;
    }
}
