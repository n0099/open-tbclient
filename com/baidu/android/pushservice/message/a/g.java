package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.k;
/* loaded from: classes8.dex */
public class g extends b {
    public g(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.b
    public com.baidu.android.pushservice.message.g a(k kVar, byte[] bArr) {
        int i;
        String b = kVar.b();
        String e = kVar.e();
        PublicMsg a = h.a(this.a, e, b, bArr);
        if (a == null || TextUtils.isEmpty(a.mTitle) || TextUtils.isEmpty(a.mDescription) || TextUtils.isEmpty(a.mUrl)) {
            m.a(">>> pMsg JSON parsing error!", this.a);
            i = 2;
        } else if (d.a(this.a, a) && m.d(this.a, this.a.getPackageName())) {
            m.a(">>> Show pMsg Notification!", this.a);
            d.a(this.a, a, e);
            i = 1;
        } else {
            m.a(">>> Don't Show pMsg Notification! --- IsBaiduApp = " + m.d(this.a, this.a.getPackageName()), this.a);
            i = 0;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
