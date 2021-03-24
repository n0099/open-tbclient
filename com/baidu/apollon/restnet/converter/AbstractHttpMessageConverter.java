package com.baidu.apollon.restnet.converter;

import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.rest.e;
import java.io.IOException;
/* loaded from: classes2.dex */
public abstract class AbstractHttpMessageConverter<T> {

    /* renamed from: a  reason: collision with root package name */
    public String f3745a = "";

    public String a() {
        return this.f3745a;
    }

    public abstract T b(Class<?> cls, e eVar) throws IOException, RestRuntimeException;

    public void a(String str) {
        this.f3745a = str;
    }

    public final T a(Class<?> cls, e eVar) throws IOException {
        return b(cls, eVar);
    }
}
