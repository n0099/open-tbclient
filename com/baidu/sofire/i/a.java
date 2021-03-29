package com.baidu.sofire.i;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f11809a;

    /* renamed from: b  reason: collision with root package name */
    public c f11810b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f11811c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.sofire.h.c f11812d;

    /* renamed from: e  reason: collision with root package name */
    public String f11813e;

    public a(Context context, com.baidu.sofire.h.c cVar) {
        this.f11809a = null;
        this.f11809a = context;
        this.f11812d = cVar;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f11813e)) {
            if (this.f11810b != null) {
                this.f11813e = this.f11810b.a();
            }
            return this.f11813e;
        }
        return this.f11813e;
    }
}
