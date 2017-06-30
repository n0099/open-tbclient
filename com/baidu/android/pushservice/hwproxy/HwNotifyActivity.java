package com.baidu.android.pushservice.hwproxy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.f;
import com.baidu.android.pushservice.g.a;
import com.baidu.android.pushservice.j.q;
/* loaded from: classes2.dex */
public class HwNotifyActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                a.c("HwNotifyActivity", "intentUri  Data = " + data.toString());
                String d = f.d(getApplicationContext(), intent);
                String c = f.c(getApplicationContext(), intent);
                a.c("HwNotifyActivity", "hwsigninfo = " + c + "  checkinfo = " + d);
                if (!TextUtils.isEmpty(c) && data != null) {
                    boolean a = f.a(getApplicationContext(), c, d);
                    a.c("HwNotifyActivity", "hwMessageVerify = " + a);
                    if (a) {
                        q.a(getApplicationContext(), intent);
                    }
                }
            }
        } catch (Exception e) {
            a.a("HwNotifyActivity", e);
        }
        finish();
    }
}
