package com.baidu.sofire.i;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f11470a;

    /* renamed from: b  reason: collision with root package name */
    public c f11471b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f11472c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.sofire.h.c f11473d;

    /* renamed from: e  reason: collision with root package name */
    public String f11474e;

    public a(Context context, com.baidu.sofire.h.c cVar) {
        this.f11470a = null;
        this.f11470a = context;
        this.f11473d = cVar;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f11474e)) {
            if (this.f11471b != null) {
                this.f11474e = this.f11471b.a();
            }
            return this.f11474e;
        }
        return this.f11474e;
    }
}
