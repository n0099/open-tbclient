package com.baidu.apollon.restnet.rest;

import android.util.Log;
import com.baidu.apollon.restnet.converter.AbstractHttpMessageConverter;
import com.baidu.apollon.restnet.http.HttpStatus;
/* loaded from: classes.dex */
public class f<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3811a = "f";

    /* renamed from: b  reason: collision with root package name */
    public final Class<T> f3812b;

    /* renamed from: c  reason: collision with root package name */
    public final AbstractHttpMessageConverter<?> f3813c;

    public f(Class<T> cls, AbstractHttpMessageConverter<?> abstractHttpMessageConverter) {
        if (cls == null) {
            throw new IllegalArgumentException("'responseType' must not be null");
        }
        if (abstractHttpMessageConverter != null) {
            this.f3812b = cls;
            this.f3813c = abstractHttpMessageConverter;
            return;
        }
        throw new IllegalArgumentException("'messageConverters' must not be empty");
    }

    private boolean b(e eVar) throws Exception {
        HttpStatus e2 = eVar.e();
        return (e2 == HttpStatus.NO_CONTENT || e2 == HttpStatus.NOT_MODIFIED || eVar.d().h() == 0) ? false : true;
    }

    public T a(e eVar) throws Exception {
        if (b(eVar)) {
            if (eVar.d().i() == null && Log.isLoggable(f3811a, 3)) {
                Log.d(f3811a, "No Content-Type header found, defaulting to application/octet-stream");
            }
            return (T) this.f3813c.a(this.f3812b, eVar);
        }
        return null;
    }

    public String a() {
        return this.f3813c.a();
    }
}
