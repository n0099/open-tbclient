package com.alibaba.fastjson.serializer;
/* loaded from: classes19.dex */
public interface ContextValueFilter extends SerializeFilter {
    Object process(BeanContext beanContext, Object obj, String str, Object obj2);
}
