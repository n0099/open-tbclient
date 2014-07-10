package com.baidu.gson.stream;
/* loaded from: classes.dex */
public enum JsonToken {
    BEGIN_ARRAY,
    END_ARRAY,
    BEGIN_OBJECT,
    END_OBJECT,
    NAME,
    STRING,
    NUMBER,
    BOOLEAN,
    NULL,
    END_DOCUMENT;

    /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static JsonToken[] valuesCustom() {
        JsonToken[] valuesCustom = values();
        int length = valuesCustom.length;
        JsonToken[] jsonTokenArr = new JsonToken[length];
        System.arraycopy(valuesCustom, 0, jsonTokenArr, 0, length);
        return jsonTokenArr;
    }
}
