package com.alipay.a.a;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a implements i, j {
    @Override // com.alipay.a.a.j
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Object[]) obj) {
            arrayList.add(f.b(obj2));
        }
        return arrayList;
    }

    @Override // com.alipay.a.a.i
    public final Object a(Object obj, Type type) {
        if (obj.getClass().equals(org.json.alipay.a.class)) {
            org.json.alipay.a aVar = (org.json.alipay.a) obj;
            if (type instanceof GenericArrayType) {
                throw new IllegalArgumentException("Does not support generic array!");
            }
            Class<?> componentType = ((Class) type).getComponentType();
            int a2 = aVar.a();
            Object newInstance = Array.newInstance(componentType, a2);
            for (int i = 0; i < a2; i++) {
                Array.set(newInstance, i, e.a(aVar.a(i), componentType));
            }
            return newInstance;
        }
        return null;
    }

    @Override // com.alipay.a.a.i, com.alipay.a.a.j
    public final boolean a(Class<?> cls) {
        return cls.isArray();
    }
}
