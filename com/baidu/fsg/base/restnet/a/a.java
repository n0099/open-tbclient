package com.baidu.fsg.base.restnet.a;

import com.baidu.fsg.base.restnet.RestRuntimeException;
import com.baidu.fsg.base.restnet.rest.e;
import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class a<T> {
    protected abstract T b(Class<?> cls, e eVar) throws IOException, RestRuntimeException;

    public final T a(Class<?> cls, e eVar) throws IOException {
        return b(cls, eVar);
    }
}
