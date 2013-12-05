package com.baidu.gson.internal;

import com.baidu.gson.stream.JsonReader;
/* loaded from: classes.dex */
public abstract class JsonReaderInternalAccess {
    public static JsonReaderInternalAccess INSTANCE;

    public abstract void promoteNameToValue(JsonReader jsonReader);
}
