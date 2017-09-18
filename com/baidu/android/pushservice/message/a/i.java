package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes2.dex */
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
            com.baidu.android.pushservice.g.a.e("PublicMessageHandler", ">>> pMsg JSON parsing error!");
            p.b(">>> pMsg JSON parsing error!", this.a);
            i = 2;
        } else if (f.a(this.a, a) && p.e(this.a, this.a.getPackageName())) {
            com.baidu.android.pushservice.g.a.c("PublicMessageHandler", ">>> Show pMsg Notification!");
            p.b(">>> Show pMsg Notification!", this.a);
            f.a(this.a, a, h);
            i = 1;
        } else {
            String str = ">>> Don't Show pMsg Notification! --- IsBaiduApp = " + p.e(this.a, this.a.getPackageName());
            com.baidu.android.pushservice.g.a.c("PublicMessageHandler", str);
            p.b(str, this.a);
            i = 0;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
