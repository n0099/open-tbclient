package com.alibaba.fastjson.serializer;
/* loaded from: classes19.dex */
public interface PropertyPreFilter extends SerializeFilter {
    boolean apply(JSONSerializer jSONSerializer, Object obj, String str);
}
