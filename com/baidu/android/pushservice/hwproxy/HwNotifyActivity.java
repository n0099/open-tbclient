package com.baidu.android.pushservice.hwproxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.f;
import com.baidu.android.pushservice.i.m;
/* loaded from: classes5.dex */
public class HwNotifyActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null && intent.getData() != null) {
                String d = f.d(this, intent);
                String c = f.c(this, intent);
                if (!TextUtils.isEmpty(c)) {
                    m.c(getApplicationContext(), intent, d, c);
                }
            }
        } catch (Exception e) {
        }
        finish();
    }
}
