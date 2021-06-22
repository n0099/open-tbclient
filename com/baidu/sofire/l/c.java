package com.baidu.sofire.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class c implements com.baidu.sofire.j.b {

    /* renamed from: a  reason: collision with root package name */
    public b f10363a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f10364b;

    @Override // com.baidu.sofire.j.b
    public final void a(Context context, com.baidu.sofire.j.c cVar) {
        b bVar = new b(context, cVar);
        this.f10363a = bVar;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        bVar.f10358b.bindService(intent, bVar.f10360d, 1);
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        if (TextUtils.isEmpty(this.f10364b)) {
            b bVar = this.f10363a;
            String a2 = bVar.f10357a == null ? "" : bVar.a("OUID");
            this.f10364b = a2;
            return a2;
        }
        return this.f10364b;
    }
}
