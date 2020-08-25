package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;
/* loaded from: classes11.dex */
public interface FieldTypeResolver extends ParseProcess {
    Type resolve(Object obj, String str);
}
