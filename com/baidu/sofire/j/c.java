package com.baidu.sofire.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class c implements com.baidu.sofire.h.b {

    /* renamed from: a  reason: collision with root package name */
    public b f11825a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f11826b;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, com.baidu.sofire.h.c cVar) {
        b bVar = new b(context, cVar);
        this.f11825a = bVar;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        bVar.f11820b.bindService(intent, bVar.f11822d, 1);
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        if (TextUtils.isEmpty(this.f11826b)) {
            b bVar = this.f11825a;
            String a2 = bVar.f11819a == null ? "" : bVar.a("OUID");
            this.f11826b = a2;
            return a2;
        }
        return this.f11826b;
    }
}
