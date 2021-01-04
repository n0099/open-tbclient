package com.baidu.android.imsdk.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class MethodInvokeUtil {
    public static Object invoke(Method method, Class<?> cls, Object[] objArr) {
        try {
            method.invoke(cls, objArr);
        } catch (IllegalAccessException e) {
            LogUtils.e(LogUtils.TAG, "IllegalAccessException ", e);
        } catch (IllegalArgumentException e2) {
            LogUtils.e(LogUtils.TAG, "IllegalArgumentException ", e2);
        } catch (InvocationTargetException e3) {
            LogUtils.e(LogUtils.TAG, "InvocationTargetException ", e3);
        }
        return null;
    }
}
