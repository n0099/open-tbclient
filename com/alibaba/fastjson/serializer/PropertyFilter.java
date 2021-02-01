package com.alibaba.fastjson.serializer;
/* loaded from: classes4.dex */
public interface PropertyFilter extends SerializeFilter {
    boolean apply(Object obj, String str, Object obj2);
}
