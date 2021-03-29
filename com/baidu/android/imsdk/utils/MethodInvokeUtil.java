package com.baidu.android.imsdk.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class MethodInvokeUtil {
    public static Object invoke(Method method, Class<?> cls, Object[] objArr) {
        try {
            method.invoke(cls, objArr);
            return null;
        } catch (IllegalAccessException e2) {
            LogUtils.e(LogUtils.TAG, "IllegalAccessException ", e2);
            return null;
        } catch (IllegalArgumentException e3) {
            LogUtils.e(LogUtils.TAG, "IllegalArgumentException ", e3);
            return null;
        } catch (InvocationTargetException e4) {
            LogUtils.e(LogUtils.TAG, "InvocationTargetException ", e4);
            return null;
        }
    }
}
