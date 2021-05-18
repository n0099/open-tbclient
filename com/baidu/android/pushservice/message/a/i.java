package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes.dex */
public class i extends d {
    public i(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.d
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i2;
        String c2 = kVar.c();
        String f2 = kVar.f();
        int a2 = kVar.a();
        PublicMsg a3 = j.a(this.f3504a, f2, c2, bArr);
        if (a3 == null || TextUtils.isEmpty(a3.mTitle) || TextUtils.isEmpty(a3.mDescription) || TextUtils.isEmpty(a3.mUrl)) {
            m.a(">>> pMsg JSON parsing error!", this.f3504a);
            i2 = 2;
        } else {
            if (f.a(this.f3504a, a3)) {
                Context context = this.f3504a;
                if (m.d(context, context.getPackageName())) {
                    m.a(">>> Show pMsg Notification!", this.f3504a);
                    f.a(this.f3504a, a3, f2, a2);
                    i2 = 1;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(">>> Don't Show pMsg Notification! --- IsBaiduApp = ");
            Context context2 = this.f3504a;
            sb.append(m.d(context2, context2.getPackageName()));
            m.a(sb.toString(), this.f3504a);
            i2 = 0;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i2);
        return gVar;
    }
}
