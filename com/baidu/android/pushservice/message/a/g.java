package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.k;
/* loaded from: classes5.dex */
public class g extends b {
    public g(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.b
    public com.baidu.android.pushservice.message.g a(k kVar, byte[] bArr) {
        int i;
        String b2 = kVar.b();
        String e = kVar.e();
        PublicMsg a2 = h.a(this.f1455a, e, b2, bArr);
        if (a2 == null || TextUtils.isEmpty(a2.mTitle) || TextUtils.isEmpty(a2.mDescription) || TextUtils.isEmpty(a2.mUrl)) {
            m.a(">>> pMsg JSON parsing error!", this.f1455a);
            i = 2;
        } else if (d.a(this.f1455a, a2) && m.d(this.f1455a, this.f1455a.getPackageName())) {
            m.a(">>> Show pMsg Notification!", this.f1455a);
            d.a(this.f1455a, a2, e);
            i = 1;
        } else {
            m.a(">>> Don't Show pMsg Notification! --- IsBaiduApp = " + m.d(this.f1455a, this.f1455a.getPackageName()), this.f1455a);
            i = 0;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
