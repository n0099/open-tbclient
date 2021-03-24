package com.alibaba.fastjson.serializer;
/* loaded from: classes.dex */
public abstract class BeforeFilter implements SerializeFilter {
    public static final ThreadLocal<JSONSerializer> serializerLocal = new ThreadLocal<>();
    public static final ThreadLocal<Character> seperatorLocal = new ThreadLocal<>();
    public static final Character COMMA = ',';

    public final char writeBefore(JSONSerializer jSONSerializer, Object obj, char c2) {
        serializerLocal.set(jSONSerializer);
        seperatorLocal.set(Character.valueOf(c2));
        writeBefore(obj);
        serializerLocal.set(null);
        return seperatorLocal.get().charValue();
    }

    public abstract void writeBefore(Object obj);

    public final void writeKeyValue(String str, Object obj) {
        char charValue = seperatorLocal.get().charValue();
        serializerLocal.get().writeKeyValue(charValue, str, obj);
        if (charValue != ',') {
            seperatorLocal.set(COMMA);
        }
    }
}
