package com.baidu.fsg.base.restnet.rest;

import android.util.Log;
import com.baidu.fsg.base.restnet.http.HttpStatus;
/* loaded from: classes15.dex */
public class f<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1476a = f.class.getSimpleName();
    private final Class<T> b;
    private final com.baidu.fsg.base.restnet.a.a<?> c;

    public f(Class<T> cls, com.baidu.fsg.base.restnet.a.a<?> aVar) {
        if (cls == null) {
            throw new IllegalArgumentException("'responseType' must not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("'messageConverters' must not be empty");
        }
        this.b = cls;
        this.c = aVar;
    }

    public T a(e eVar) throws Exception {
        if (!b(eVar)) {
            return null;
        }
        if (eVar.d().i() == null && Log.isLoggable(f1476a, 3)) {
            Log.d(f1476a, "No Content-Type header found, defaulting to application/octet-stream");
        }
        return (T) this.c.a(this.b, eVar);
    }

    private boolean b(e eVar) throws Exception {
        HttpStatus e = eVar.e();
        return (e == HttpStatus.NO_CONTENT || e == HttpStatus.NOT_MODIFIED || eVar.d().h() == 0) ? false : true;
    }
}
