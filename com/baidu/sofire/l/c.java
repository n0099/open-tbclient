package com.baidu.sofire.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class c implements com.baidu.sofire.j.b {

    /* renamed from: a  reason: collision with root package name */
    private b f5302a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f5303b;

    @Override // com.baidu.sofire.j.b
    public final void a(Context context, com.baidu.sofire.j.c cVar) {
        this.f5302a = new b(context, cVar);
        b bVar = this.f5302a;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        bVar.f5301b.bindService(intent, bVar.d, 1);
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        if (TextUtils.isEmpty(this.f5303b)) {
            b bVar = this.f5302a;
            this.f5303b = bVar.f5300a == null ? "" : bVar.a("OUID");
            return this.f5303b;
        }
        return this.f5303b;
    }
}
