package com.baidu.sofire.i;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f11478a;

    /* renamed from: b  reason: collision with root package name */
    public c f11479b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f11480c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.sofire.h.c f11481d;

    /* renamed from: e  reason: collision with root package name */
    public String f11482e;

    public a(Context context, com.baidu.sofire.h.c cVar) {
        this.f11478a = null;
        this.f11478a = context;
        this.f11481d = cVar;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f11482e)) {
            if (this.f11479b != null) {
                this.f11482e = this.f11479b.a();
            }
            return this.f11482e;
        }
        return this.f11482e;
    }
}
