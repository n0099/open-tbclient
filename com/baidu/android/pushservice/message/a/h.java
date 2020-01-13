package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes6.dex */
public class h extends b {
    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.b
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i;
        String b = kVar.b();
        String e = kVar.e();
        PublicMsg a = i.a(this.a, e, b, bArr);
        if (a == null || TextUtils.isEmpty(a.mTitle) || TextUtils.isEmpty(a.mDescription) || TextUtils.isEmpty(a.mUrl)) {
            l.b(">>> pMsg JSON parsing error!", this.a);
            i = 2;
        } else if (e.a(this.a, a) && l.e(this.a, this.a.getPackageName())) {
            l.b(">>> Show pMsg Notification!", this.a);
            e.a(this.a, a, e);
            i = 1;
        } else {
            l.b(">>> Don't Show pMsg Notification! --- IsBaiduApp = " + l.e(this.a, this.a.getPackageName()), this.a);
            i = 0;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
