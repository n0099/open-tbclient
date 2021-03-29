package com.baidu.android.pushservice.hwproxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.f;
import com.baidu.android.pushservice.j.m;
/* loaded from: classes.dex */
public class HwNotifyActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null && intent.getData() != null) {
                String d2 = f.d(this, intent);
                String c2 = f.c(this, intent);
                if (!TextUtils.isEmpty(c2)) {
                    m.c(getApplicationContext(), intent, d2, c2);
                }
            }
        } catch (Exception unused) {
        }
        finish();
    }
}
