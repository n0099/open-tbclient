package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class a extends d {

    /* renamed from: com.baidu.android.pushservice.message.a.a$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3430a;

        static {
            int[] iArr = new int[com.baidu.android.pushservice.a.c.values().length];
            f3430a = iArr;
            try {
                iArr[com.baidu.android.pushservice.a.c.PUSH_CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.d
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        String c2 = kVar.c();
        String f2 = kVar.f();
        int g2 = kVar.g();
        byte[] i = kVar.i();
        String d2 = kVar.d();
        int a2 = kVar.a();
        String str = new String(bArr);
        com.baidu.android.pushservice.a.d a3 = com.baidu.android.pushservice.a.d.a(this.f3433a, c2);
        if (TextUtils.isEmpty(d2) || !m.b(this.f3433a, d2)) {
            d2 = a3.a() == com.baidu.android.pushservice.a.c.PUSH_CLIENT ? a3.f2688a.b() : null;
        }
        if (AnonymousClass1.f3430a[a3.a().ordinal()] != 1) {
            m.a(">>> Don't found app  in OldPrivateMessage " + str, this.f3433a);
        } else {
            String a4 = a(d2);
            try {
                this.f3433a.getPackageManager().getPackageInfo(a4, 128);
                Intent intent = new Intent();
                intent.putExtra(Constants.APP_ID, c2);
                intent.putExtra("msg_id", f2);
                intent.putExtra("message", bArr);
                intent.putExtra("message_string", str);
                intent.putExtra("notify_id", a2);
                intent.putExtra("message_id", f2);
                intent.putExtra("baidu_message_type", g2);
                intent.putExtra("baidu_message_body", bArr);
                intent.putExtra("baidu_message_secur_info", i);
                m.b(this.f3433a, intent, "com.baidu.android.pushservice.action.MESSAGE", a4);
                m.a(">>> Deliver message to client: " + a3.f2688a.b(), this.f3433a);
                return null;
            } catch (PackageManager.NameNotFoundException e2) {
                m.a(">>> NOT deliver to app: " + a3.f2688a.b() + ", package has been uninstalled.", this.f3433a);
                new b.c(this.f3433a).a(Log.getStackTraceString(e2)).a();
            }
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(7);
        return gVar;
    }
}
