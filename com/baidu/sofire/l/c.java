package com.baidu.sofire.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes20.dex */
public final class c implements com.baidu.sofire.j.b {
    private b a = null;
    private String b;

    @Override // com.baidu.sofire.j.b
    public final void a(Context context, com.baidu.sofire.j.c cVar) {
        this.a = new b(context, cVar);
        b bVar = this.a;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        bVar.b.bindService(intent, bVar.d, 1);
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        if (TextUtils.isEmpty(this.b)) {
            b bVar = this.a;
            this.b = bVar.a == null ? "" : bVar.a("OUID");
            return this.b;
        }
        return this.b;
    }
}
