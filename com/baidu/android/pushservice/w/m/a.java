package com.baidu.android.pushservice.w.m;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: com.baidu.android.pushservice.w.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0040a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.baidu.android.pushservice.k.c.values().length];
            a = iArr;
            try {
                iArr[com.baidu.android.pushservice.k.c.PUSH_CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.w.m.c
    public com.baidu.android.pushservice.w.g a(com.baidu.android.pushservice.w.k kVar, byte[] bArr) {
        String a = kVar.a();
        String h = kVar.h();
        int q = kVar.q();
        byte[] n = kVar.n();
        String j = kVar.j();
        int i = kVar.i();
        String str = new String(bArr);
        com.baidu.android.pushservice.k.d a2 = com.baidu.android.pushservice.k.d.a(this.a, a);
        if (TextUtils.isEmpty(j) || !Utility.m(this.a, j)) {
            j = a2.a() == com.baidu.android.pushservice.k.c.PUSH_CLIENT ? a2.b.b() : null;
        }
        if (C0040a.a[a2.a().ordinal()] == 1) {
            String a3 = a(j);
            try {
                this.a.getPackageManager().getPackageInfo(a3, 128);
                Intent intent = new Intent();
                intent.putExtra("app_id", a);
                intent.putExtra("msg_id", h);
                intent.putExtra("message", bArr);
                intent.putExtra("message_string", str);
                intent.putExtra(Constants.EXTRA_NOTIFY_ID, i);
                intent.putExtra("widget_badge_info", kVar.r());
                intent.putExtra(ForbidActivityConfig.CHAT_MSG_ID, h);
                intent.putExtra("baidu_message_type", q);
                intent.putExtra("baidu_message_body", bArr);
                intent.putExtra("baidu_message_secur_info", n);
                Utility.c(this.a, intent, "com.baidu.android.pushservice.action.MESSAGE", a3);
                String str2 = ">>> Deliver message to client: " + a2.b.b();
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                String str3 = ">>> NOT deliver to app: " + a2.b.b() + ", package has been uninstalled.";
            }
        }
        com.baidu.android.pushservice.w.g gVar = new com.baidu.android.pushservice.w.g();
        gVar.a(7);
        return gVar;
    }
}
