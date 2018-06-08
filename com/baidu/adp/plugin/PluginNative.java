package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.h;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class PluginNative {
    public static final String PLUGIN_NATIVE_HOOK_LIB = "pluginhook";
    public static boolean bLoadLibrary;

    public static native int hookdvmResolveClass();

    public static native boolean replaceInit(boolean z, int i);

    public static native void replaceMethod(Method method, Method method2);

    public static native void setFieldPublicFlag(Field field);

    static {
        bLoadLibrary = false;
        bLoadLibrary = h.jp().i(PLUGIN_NATIVE_HOOK_LIB, 2);
    }
}
