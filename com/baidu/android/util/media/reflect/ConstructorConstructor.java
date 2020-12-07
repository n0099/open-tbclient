package com.baidu.android.util.media.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes20.dex */
public class ConstructorConstructor {
    public <T> ObjectConstructor<T> get(Class<? super T> cls) {
        return newDefaultConstructor(cls);
    }

    private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new ObjectConstructor<T>() { // from class: com.baidu.android.util.media.reflect.ConstructorConstructor.1
                /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
                @Override // com.baidu.android.util.media.reflect.ObjectConstructor
                public T construct() {
                    try {
                        return declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
}
