package com.baidu.sofire.i;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f10370a;

    /* renamed from: b  reason: collision with root package name */
    public c f10371b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f10372c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.sofire.h.c f10373d;

    /* renamed from: e  reason: collision with root package name */
    public String f10374e;

    public a(Context context, com.baidu.sofire.h.c cVar) {
        this.f10370a = null;
        this.f10370a = context;
        this.f10373d = cVar;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f10374e)) {
            if (this.f10371b != null) {
                this.f10374e = this.f10371b.a();
            }
            return this.f10374e;
        }
        return this.f10374e;
    }
}
