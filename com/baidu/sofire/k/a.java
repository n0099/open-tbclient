package com.baidu.sofire.k;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f10347a;

    /* renamed from: b  reason: collision with root package name */
    public c f10348b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f10349c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.sofire.j.c f10350d;

    /* renamed from: e  reason: collision with root package name */
    public String f10351e;

    public a(Context context, com.baidu.sofire.j.c cVar) {
        this.f10347a = null;
        this.f10347a = context;
        this.f10350d = cVar;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f10351e)) {
            if (this.f10348b != null) {
                this.f10351e = this.f10348b.a();
            }
            return this.f10351e;
        }
        return this.f10351e;
    }
}
