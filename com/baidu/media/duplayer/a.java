package com.baidu.media.duplayer;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Object f3196a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f3197b;
    private static Method c;
    private static Method d;
    private static Method e;
    private static boolean f;

    static {
        f = false;
        try {
            f3196a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            f3197b = com.baidu.media.duplayer.a.a.a(cls, "doInit", Context.class, String[].class);
            d = com.baidu.media.duplayer.a.a.a(cls, "setStatisticParam", String.class);
            c = com.baidu.media.duplayer.a.a.a(cls, "setEnabled", Boolean.TYPE);
            e = com.baidu.media.duplayer.a.a.a(cls, "setCrashKeyValue", String.class, String.class);
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
                f3197b.invoke(f3196a, context, strArr);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str) {
        try {
            if (f) {
                d.invoke(f3196a, str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        try {
            if (f) {
                e.invoke(f3196a, str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(boolean z) {
        try {
            if (f) {
                c.invoke(f3196a, Boolean.valueOf(z));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a() {
        return f;
    }
}
