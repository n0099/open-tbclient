package com.baidu.gson;

import com.baidu.gson.reflect.TypeToken;
/* loaded from: classes.dex */
public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}
