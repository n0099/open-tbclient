package com.alipay.a.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class k implements i {
    @Override // com.alipay.a.a.i
    public final Object a(Object obj, Type type) {
        if (obj.getClass().equals(org.json.alipay.a.class)) {
            org.json.alipay.a aVar = (org.json.alipay.a) obj;
            HashSet hashSet = new HashSet();
            Class cls = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class;
            for (int i2 = 0; i2 < aVar.a(); i2++) {
                hashSet.add(e.a(aVar.a(i2), cls));
            }
            return hashSet;
        }
        return null;
    }

    @Override // com.alipay.a.a.i, com.alipay.a.a.j
    public final boolean a(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }
}
