package com.baidu.sofire.k;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class c implements com.baidu.sofire.h.b {

    /* renamed from: a  reason: collision with root package name */
    public b f10292a;

    /* renamed from: b  reason: collision with root package name */
    public String f10293b;

    /* renamed from: c  reason: collision with root package name */
    public Context f10294c;

    /* renamed from: d  reason: collision with root package name */
    public a f10295d;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, com.baidu.sofire.h.c cVar) {
        this.f10292a = new b(context);
        this.f10294c = context;
        if ("1".equals(com.baidu.sofire.m.a.a("persist.sys.identifierid.supported", "0"))) {
            this.f10295d = new a(this);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f10295d);
        }
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        if (TextUtils.isEmpty(this.f10293b)) {
            this.f10293b = this.f10292a.a();
        }
        return this.f10293b;
    }
}
