package cn.jpush.android.d;

import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public final class j {
    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        Object obj2;
        Exception exc = null;
        if (objArr.length != clsArr.length) {
            throw new IllegalArgumentException("argClasses' size is not equal to args' size");
        }
        Method method = obj.getClass().getMethod(str, clsArr);
        boolean isAccessible = method.isAccessible();
        if (!isAccessible) {
            method.setAccessible(true);
        }
        try {
            obj2 = method.invoke(obj, objArr);
        } catch (Exception e) {
            obj2 = null;
            exc = e;
        }
        if (!isAccessible) {
            method.setAccessible(false);
        }
        if (exc != null) {
            throw exc;
        }
        return obj2;
    }
}
