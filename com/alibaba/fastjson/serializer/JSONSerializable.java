package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes11.dex */
public interface JSONSerializable {
    void write(JSONSerializer jSONSerializer, Object obj, Type type, int i) throws IOException;
}
