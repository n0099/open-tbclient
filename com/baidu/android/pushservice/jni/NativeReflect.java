package com.baidu.android.pushservice.jni;

import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class NativeReflect {
    static {
        try {
            System.loadLibrary("bdpush_V3_6");
        } catch (Throwable unused) {
        }
    }

    public static native Method getDeclaredMethod(Object obj, String str, Class<?>[] clsArr);
}
