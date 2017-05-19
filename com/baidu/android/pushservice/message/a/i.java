package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.u;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes2.dex */
public class i extends c {
    private static final String b = i.class.getSimpleName();

    public i(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        return null;
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(String str, String str2, int i, byte[] bArr, String str3, byte[] bArr2) {
        int i2;
        PublicMsg a = j.a(this.a, str2, str, bArr2);
        if (a == null || TextUtils.isEmpty(a.mTitle) || TextUtils.isEmpty(a.mDescription) || TextUtils.isEmpty(a.mUrl)) {
            com.baidu.android.pushservice.e.a.e(b, ">>> pMsg JSON parsing error!");
            u.b(">>> pMsg JSON parsing error!", this.a);
            i2 = 2;
        } else if (f.a(this.a, a) && u.e(this.a, this.a.getPackageName())) {
            com.baidu.android.pushservice.e.a.c(b, ">>> Show pMsg Notification!");
            u.b(">>> Show pMsg Notification!", this.a);
            f.a(this.a, a, str2);
            i2 = 1;
        } else {
            String str4 = ">>> Don't Show pMsg Notification! --- IsBaiduApp = " + u.e(this.a, this.a.getPackageName());
            com.baidu.android.pushservice.e.a.c(b, str4);
            u.b(str4, this.a);
            i2 = 0;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i2);
        return gVar;
    }
}
