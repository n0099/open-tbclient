package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes19.dex */
public interface ObjectSerializer {
    void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException;
}
