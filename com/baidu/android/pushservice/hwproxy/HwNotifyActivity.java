package com.baidu.android.pushservice.hwproxy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.f;
import com.baidu.android.pushservice.j.p;
/* loaded from: classes2.dex */
public class HwNotifyActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                String d = f.d(getApplicationContext(), intent);
                String c = f.c(getApplicationContext(), intent);
                if (!TextUtils.isEmpty(c) && data != null && f.a(getApplicationContext(), c, d)) {
                    p.a(getApplicationContext(), intent);
                }
            }
        } catch (Exception e) {
        }
        finish();
    }
}
