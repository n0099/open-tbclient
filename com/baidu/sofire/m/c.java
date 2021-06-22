package com.baidu.sofire.m;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class c implements com.baidu.sofire.j.b {

    /* renamed from: a  reason: collision with root package name */
    public b f10368a;

    /* renamed from: b  reason: collision with root package name */
    public String f10369b;

    /* renamed from: c  reason: collision with root package name */
    public Context f10370c;

    /* renamed from: d  reason: collision with root package name */
    public a f10371d;

    @Override // com.baidu.sofire.j.b
    public final void a(Context context, com.baidu.sofire.j.c cVar) {
        this.f10368a = new b(context);
        this.f10370c = context;
        if ("1".equals(com.baidu.sofire.o.a.a("persist.sys.identifierid.supported", "0"))) {
            this.f10371d = new a(this);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f10371d);
        }
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        if (TextUtils.isEmpty(this.f10369b)) {
            this.f10369b = this.f10368a.a();
        }
        return this.f10369b;
    }
}
