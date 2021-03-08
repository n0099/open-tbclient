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
        String b = kVar.b();
        String e = kVar.e();
        PublicMsg a2 = h.a(this.f1237a, e, b, bArr);
        if (a2 == null || TextUtils.isEmpty(a2.mTitle) || TextUtils.isEmpty(a2.mDescription) || TextUtils.isEmpty(a2.mUrl)) {
            m.a(">>> pMsg JSON parsing error!", this.f1237a);
            i = 2;
        } else if (d.a(this.f1237a, a2) && m.d(this.f1237a, this.f1237a.getPackageName())) {
            m.a(">>> Show pMsg Notification!", this.f1237a);
            d.a(this.f1237a, a2, e);
            i = 1;
        } else {
            m.a(">>> Don't Show pMsg Notification! --- IsBaiduApp = " + m.d(this.f1237a, this.f1237a.getPackageName()), this.f1237a);
            i = 0;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
