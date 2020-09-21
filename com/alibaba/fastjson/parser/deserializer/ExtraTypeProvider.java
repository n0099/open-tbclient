package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;
/* loaded from: classes10.dex */
public interface ExtraTypeProvider extends ParseProcess {
    Type getExtraType(Object obj, String str);
}
