package com.baidu.android.pushservice.w.m;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
/* loaded from: classes.dex */
public class g extends c {

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
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

    public g(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.w.m.c
    public com.baidu.android.pushservice.w.g a(com.baidu.android.pushservice.w.k kVar, byte[] bArr) {
        String a2 = kVar.a();
        String h = kVar.h();
        int q = kVar.q();
        byte[] n = kVar.n();
        String j = kVar.j();
        int i = kVar.i();
        int o = kVar.o();
        String str = new String(bArr);
        com.baidu.android.pushservice.k.d a3 = com.baidu.android.pushservice.k.d.a(this.a, a2);
        if (TextUtils.isEmpty(j) || !Utility.m(this.a, j)) {
            j = a3.a() == com.baidu.android.pushservice.k.c.PUSH_CLIENT ? a3.b.b() : null;
        }
        int i2 = 7;
        if (a.a[a3.a().ordinal()] == 1) {
            String a4 = a(j);
            try {
                this.a.getPackageManager().getPackageInfo(a4, 128);
                Intent intent = new Intent();
                intent.putExtra("app_id", a2);
                intent.putExtra("msg_id", h);
                intent.putExtra("message", bArr);
                intent.putExtra("message_string", str);
                intent.putExtra(ForbidActivityConfig.CHAT_MSG_ID, h);
                intent.putExtra("baidu_message_type", q);
                intent.putExtra("baidu_message_body", bArr);
                intent.putExtra("baidu_message_secur_info", n);
                intent.putExtra(Constants.EXTRA_NOTIFY_ID, i);
                intent.putExtra("connect_source", o);
                intent.putExtra("widget_badge_info", kVar.r());
                intent.putExtra("foreground_show_num", kVar.d());
                intent.putExtra("notification_log_ext", kVar.f());
                if (kVar.d() < 1 || !Utility.B(this.a)) {
                    int a5 = Utility.a(this.a, intent, "com.baidu.android.pushservice.action.MESSAGE", a4);
                    String str2 = ">>> Deliver message to client: " + a3.b.b() + " result: " + a5;
                    i2 = a5;
                } else {
                    i2 = new e(this.a).a(kVar, bArr).a();
                }
            } catch (PackageManager.NameNotFoundException unused) {
                String str3 = ">>> NOT deliver to app: " + a3.b.b() + ", package has been uninstalled.";
            }
        }
        com.baidu.android.pushservice.w.g gVar = new com.baidu.android.pushservice.w.g();
        gVar.a(i2);
        return gVar;
    }
}
