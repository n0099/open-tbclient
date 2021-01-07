package com.baidu.fsg.base.restnet.rest;

import android.util.Log;
import com.baidu.fsg.base.restnet.http.HttpStatus;
/* loaded from: classes6.dex */
public class f<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1965a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final Class<T> f1966b;
    private final com.baidu.fsg.base.restnet.a.a<?> c;

    public f(Class<T> cls, com.baidu.fsg.base.restnet.a.a<?> aVar) {
        if (cls == null) {
            throw new IllegalArgumentException("'responseType' must not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("'messageConverters' must not be empty");
        }
        this.f1966b = cls;
        this.c = aVar;
    }

    public T a(e eVar) throws Exception {
        if (!b(eVar)) {
            return null;
        }
        if (eVar.d().i() == null && Log.isLoggable(f1965a, 3)) {
            Log.d(f1965a, "No Content-Type header found, defaulting to application/octet-stream");
        }
        return (T) this.c.a(this.f1966b, eVar);
    }

    private boolean b(e eVar) throws Exception {
        HttpStatus e = eVar.e();
        return (e == HttpStatus.NO_CONTENT || e == HttpStatus.NOT_MODIFIED || eVar.d().h() == 0) ? false : true;
    }
}
