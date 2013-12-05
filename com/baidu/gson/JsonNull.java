package com.baidu.gson;
/* loaded from: classes.dex */
public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE = new JsonNull();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.gson.JsonElement
    public JsonNull deepCopy() {
        return INSTANCE;
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof JsonNull);
    }
}
