package com.baidu.browser.core.util;

import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public final class b {
    public static Object a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr, Object obj2) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th) {
            Log.e("BdReflectUtils", th.getMessage(), th);
            return obj2;
        }
    }
}
