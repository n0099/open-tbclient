package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes3.dex */
public class i extends c {
    public i(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i;
        String e = kVar.e();
        String h = kVar.h();
        PublicMsg a = j.a(this.a, h, e, bArr);
        if (a == null || TextUtils.isEmpty(a.mTitle) || TextUtils.isEmpty(a.mDescription) || TextUtils.isEmpty(a.mUrl)) {
            com.baidu.android.pushservice.j.m.b(">>> pMsg JSON parsing error!", this.a);
            i = 2;
        } else if (f.a(this.a, a) && com.baidu.android.pushservice.j.m.e(this.a, this.a.getPackageName())) {
            com.baidu.android.pushservice.j.m.b(">>> Show pMsg Notification!", this.a);
            f.a(this.a, a, h);
            i = 1;
        } else {
            com.baidu.android.pushservice.j.m.b(">>> Don't Show pMsg Notification! --- IsBaiduApp = " + com.baidu.android.pushservice.j.m.e(this.a, this.a.getPackageName()), this.a);
            i = 0;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
