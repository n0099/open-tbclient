package com.baidu.media.duplayer;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class a {
    private static Object a;
    private static Method b;
    private static Method c;
    private static Method d;
    private static Method e;
    private static boolean f;

    static {
        f = false;
        try {
            a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            b = com.baidu.media.duplayer.a.c.a(cls, "doInit", Context.class, String[].class);
            d = com.baidu.media.duplayer.a.c.a(cls, "setStatisticParam", String.class);
            c = com.baidu.media.duplayer.a.c.a(cls, "setEnabled", Boolean.TYPE);
            e = com.baidu.media.duplayer.a.c.a(cls, "setCrashKeyValue", String.class, String.class);
            f = true;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(Context context, String[] strArr) {
        try {
            if (f) {
                b.invoke(a, context, strArr);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str) {
        try {
            if (f) {
                d.invoke(a, str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        try {
            if (f) {
                e.invoke(a, str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(boolean z) {
        try {
            if (f) {
                c.invoke(a, Boolean.valueOf(z));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a() {
        return f;
    }
}
