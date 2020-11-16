package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes19.dex */
public interface AutowiredObjectSerializer extends ObjectSerializer {
    Set<Type> getAutowiredFor();
}
