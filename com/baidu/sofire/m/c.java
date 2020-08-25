package com.baidu.sofire.m;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes20.dex */
public final class c implements com.baidu.sofire.j.b {
    b a;
    String b;
    private Context c;
    private a d;

    @Override // com.baidu.sofire.j.b
    public final String b() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = this.a.a();
        }
        return this.b;
    }

    @Override // com.baidu.sofire.j.b
    public final void a(Context context, com.baidu.sofire.j.c cVar) {
        this.a = new b(context);
        this.c = context;
        if ("1".equals(com.baidu.sofire.o.a.a("persist.sys.identifierid.supported", "0"))) {
            this.d = new a(this);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.d);
        }
    }
}
