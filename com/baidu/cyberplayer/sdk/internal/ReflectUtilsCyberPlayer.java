package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ReflectUtilsCyberPlayer {

    /* renamed from: a  reason: collision with root package name */
    private static ClassLoader f733a = null;
    private static ClassLoader b = null;

    /* loaded from: classes.dex */
    enum a {
        LOAD_FROM_JAR,
        LOAD_FROM_APK,
        LOAD_FROM_CURPKG
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, a aVar) {
        switch (aVar) {
            case LOAD_FROM_JAR:
                b = b(context);
                return;
            case LOAD_FROM_APK:
                b = a(context);
                return;
            case LOAD_FROM_CURPKG:
                b = a(context);
                return;
            default:
                b = null;
                return;
        }
    }

    public static Class loadClass(String str) {
        Class<?> cls;
        try {
            if (b != null) {
                cls = Class.forName(str, true, b);
            } else {
                cls = Class.forName(str);
            }
            return cls;
        } catch (ClassNotFoundException e) {
            LogUtils.dumpException(e);
            return null;
        }
    }

    public static Method getSuperMethod(Class cls, String str, Class... clsArr) {
        return ReflectUtils.getMethod(cls, str + "Super", clsArr);
    }

    private static synchronized ClassLoader a(Context context) {
        ClassLoader classLoader;
        synchronized (ReflectUtilsCyberPlayer.class) {
            if (f733a == null && context != null && d.m16a(context)) {
                f733a = new PathClassLoader(d.m15a(context), ReflectUtilsCyberPlayer.class.getClassLoader());
            }
            classLoader = f733a;
        }
        return classLoader;
    }

    private static synchronized ClassLoader b(Context context) {
        ClassLoader classLoader;
        synchronized (ReflectUtilsCyberPlayer.class) {
            if (f733a == null) {
                String b2 = d.b(context);
                if (context != null && FileUtils.dirExists(b2)) {
                    f733a = new DexClassLoader(d.b(context) + CyberPlayerEngineConstants.CYBERPLAYER_JAR_NAME, b2, null, ReflectUtilsCyberPlayer.class.getClassLoader());
                }
            }
            classLoader = f733a;
        }
        return classLoader;
    }
}
