package com.baidu.gson;
/* loaded from: classes.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.baidu.gson.LongSerializationPolicy.1
        @Override // com.baidu.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive((Number) l);
        }
    },
    STRING { // from class: com.baidu.gson.LongSerializationPolicy.2
        @Override // com.baidu.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive(String.valueOf(l));
        }
    };

    /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static LongSerializationPolicy[] valuesCustom() {
        LongSerializationPolicy[] valuesCustom = values();
        int length = valuesCustom.length;
        LongSerializationPolicy[] longSerializationPolicyArr = new LongSerializationPolicy[length];
        System.arraycopy(valuesCustom, 0, longSerializationPolicyArr, 0, length);
        return longSerializationPolicyArr;
    }

    public abstract JsonElement serialize(Long l);

    /* synthetic */ LongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        this();
    }
}
