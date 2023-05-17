package com.baidu.nps.interfa;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public interface IPrivateReflectAbility {
    Class<?> forName(String str) throws ClassNotFoundException;

    Field getField(Class<?> cls, String str);

    Method getMethod(Class<?> cls, String str, Class<?>... clsArr);
}
