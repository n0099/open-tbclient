package com.baidu.fsg.base.restnet.rest;

import android.util.Log;
import com.baidu.fsg.base.restnet.http.HttpStatus;
/* loaded from: classes2.dex */
public class f<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5240a = "f";

    /* renamed from: b  reason: collision with root package name */
    public final Class<T> f5241b;

    /* renamed from: c  reason: collision with root package name */
    public final com.baidu.fsg.base.restnet.a.a<?> f5242c;

    public f(Class<T> cls, com.baidu.fsg.base.restnet.a.a<?> aVar) {
        if (cls == null) {
            throw new IllegalArgumentException("'responseType' must not be null");
        }
        if (aVar != null) {
            this.f5241b = cls;
            this.f5242c = aVar;
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
            if (eVar.d().i() == null && Log.isLoggable(f5240a, 3)) {
                Log.d(f5240a, "No Content-Type header found, defaulting to application/octet-stream");
            }
            return (T) this.f5242c.a(this.f5241b, eVar);
        }
        return null;
    }
}
