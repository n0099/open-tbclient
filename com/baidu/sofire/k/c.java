package com.baidu.sofire.k;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class c implements com.baidu.sofire.h.b {

    /* renamed from: a  reason: collision with root package name */
    public b f11324a;

    /* renamed from: b  reason: collision with root package name */
    public String f11325b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11326c;

    /* renamed from: d  reason: collision with root package name */
    public a f11327d;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, com.baidu.sofire.h.c cVar) {
        this.f11324a = new b(context);
        this.f11326c = context;
        if ("1".equals(com.baidu.sofire.m.a.a("persist.sys.identifierid.supported", "0"))) {
            this.f11327d = new a(this);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f11327d);
        }
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        if (TextUtils.isEmpty(this.f11325b)) {
            this.f11325b = this.f11324a.a();
        }
        return this.f11325b;
    }
}
