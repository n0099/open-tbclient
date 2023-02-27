package com.baidu.swan.hide.api.bypass;

import android.annotation.SuppressLint;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
@SuppressLint({"BDSoLoader"})
/* loaded from: classes3.dex */
public class NativeHideApiBypass {
    public static native Field getDeclaredField(Object obj, String str);

    public static native Method getDeclaredMethod(Object obj, String str, Class<?>[] clsArr);

    public static native Method getMethod(Object obj, String str, Class<?>[] clsArr);

    static {
        System.loadLibrary("hide-api-bypass");
    }
}
