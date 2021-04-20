package com.baidu.sofire.k;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class c implements com.baidu.sofire.h.b {

    /* renamed from: a  reason: collision with root package name */
    public b f11491a;

    /* renamed from: b  reason: collision with root package name */
    public String f11492b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11493c;

    /* renamed from: d  reason: collision with root package name */
    public a f11494d;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, com.baidu.sofire.h.c cVar) {
        this.f11491a = new b(context);
        this.f11493c = context;
        if ("1".equals(com.baidu.sofire.m.a.a("persist.sys.identifierid.supported", "0"))) {
            this.f11494d = new a(this);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f11494d);
        }
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        if (TextUtils.isEmpty(this.f11492b)) {
            this.f11492b = this.f11491a.a();
        }
        return this.f11492b;
    }
}
