package com.baidu.android.pushservice.viproxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.z.c;
import com.baidu.android.pushservice.z.e;
/* loaded from: classes.dex */
public class ViNotifyActivity extends Activity {

    /* loaded from: classes.dex */
    public class a extends c {
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public a(String str, String str2, String str3, String str4) {
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            String str = this.c;
            if (!TextUtils.isEmpty(str)) {
                str = Utility.a(Base64.decode(this.c.getBytes(), 2), "UTF-8");
            }
            String str2 = this.d;
            if (!TextUtils.isEmpty(str2)) {
                str2 = Utility.a(Base64.decode(this.d.getBytes(), 2), "UTF-8");
            }
            ViNotifyActivity.this.a(this.e, str2, this.f, str);
        }
    }

    public final void a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent("com.baidu.android.pushservice.action.VIVO_CLICK");
        intent.putExtra("vi_notification_sign", str3);
        intent.putExtra("vi_notification_msg_id", str);
        intent.putExtra("vi_notification_pkg_content", str2);
        intent.putExtra("extra_extra_custom_content", str4);
        Utility.a(intent, getApplicationContext());
        com.baidu.android.pushservice.n.c.a().a(getApplicationContext(), false, 1, str4);
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        if (TextUtils.equals("1", str)) {
            e.a().a(new a(str5, str3, str2, str4));
        } else {
            a(str2, str3, str4, str5);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("msgid");
            String stringExtra2 = intent.getStringExtra("visigninfo");
            a(intent.getStringExtra("c"), stringExtra, intent.getStringExtra("pkg_content"), stringExtra2, intent.getStringExtra("custom_content"));
        } catch (Exception unused) {
        }
        finish();
    }
}
