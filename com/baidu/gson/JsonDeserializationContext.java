package com.baidu.gson;

import java.lang.reflect.Type;
/* loaded from: classes.dex */
public interface JsonDeserializationContext {
    <T> T deserialize(JsonElement jsonElement, Type type);
}
