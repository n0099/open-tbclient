package com.alibaba.fastjson.serializer;

import java.util.IdentityHashMap;
/* loaded from: classes.dex */
public abstract class AfterFilter implements SerializeFilter {
    public static final ThreadLocal<JSONSerializer> serializerLocal = new ThreadLocal<>();
    public static final ThreadLocal<Character> seperatorLocal = new ThreadLocal<>();
    public static final Character COMMA = ',';

    public final char writeAfter(JSONSerializer jSONSerializer, Object obj, char c2) {
        serializerLocal.set(jSONSerializer);
        seperatorLocal.set(Character.valueOf(c2));
        writeAfter(obj);
        serializerLocal.set(serializerLocal.get());
        return seperatorLocal.get().charValue();
    }

    public abstract void writeAfter(Object obj);

    public final void writeKeyValue(String str, Object obj) {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        JSONSerializer jSONSerializer = serializerLocal.get();
        char charValue = seperatorLocal.get().charValue();
        boolean containsReference = jSONSerializer.containsReference(obj);
        jSONSerializer.writeKeyValue(charValue, str, obj);
        if (!containsReference && (identityHashMap = jSONSerializer.references) != null) {
            identityHashMap.remove(obj);
        }
        if (charValue != ',') {
            seperatorLocal.set(COMMA);
        }
    }
}
