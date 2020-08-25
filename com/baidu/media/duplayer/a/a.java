package com.baidu.media.duplayer.a;

import java.lang.reflect.Method;
/* loaded from: classes12.dex */
public class a {
    public static Method a(Class cls, String str, Class... clsArr) {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        boolean isAccessible = declaredMethod.isAccessible();
        declaredMethod.setAccessible(true);
        declaredMethod.setAccessible(isAccessible);
        return declaredMethod;
    }
}
