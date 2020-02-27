package com.baidu.android.pushservice.hwproxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.e;
import com.baidu.android.pushservice.i.l;
/* loaded from: classes8.dex */
public class HwNotifyActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null && intent.getData() != null) {
                String b = e.b(intent);
                String a = e.a(intent);
                if (!TextUtils.isEmpty(a)) {
                    l.c(getApplicationContext(), intent, b, a);
                }
            }
        } catch (Exception e) {
        }
        finish();
    }
}
