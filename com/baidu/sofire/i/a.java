package com.baidu.sofire.i;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f11808a;

    /* renamed from: b  reason: collision with root package name */
    public c f11809b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f11810c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.sofire.h.c f11811d;

    /* renamed from: e  reason: collision with root package name */
    public String f11812e;

    public a(Context context, com.baidu.sofire.h.c cVar) {
        this.f11808a = null;
        this.f11808a = context;
        this.f11811d = cVar;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f11812e)) {
            if (this.f11809b != null) {
                this.f11812e = this.f11809b.a();
            }
            return this.f11812e;
        }
        return this.f11812e;
    }
}
