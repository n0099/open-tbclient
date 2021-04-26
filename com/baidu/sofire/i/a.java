package com.baidu.sofire.i;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f11303a;

    /* renamed from: b  reason: collision with root package name */
    public c f11304b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f11305c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.sofire.h.c f11306d;

    /* renamed from: e  reason: collision with root package name */
    public String f11307e;

    public a(Context context, com.baidu.sofire.h.c cVar) {
        this.f11303a = null;
        this.f11303a = context;
        this.f11306d = cVar;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f11307e)) {
            if (this.f11304b != null) {
                this.f11307e = this.f11304b.a();
            }
            return this.f11307e;
        }
        return this.f11307e;
    }
}
