package com.baidu.android.pushservice.hwproxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.e;
import com.baidu.android.pushservice.util.Utility;
/* loaded from: classes.dex */
public class HwNotifyActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null && intent.getData() != null) {
                String b = e.b(this, intent);
                String c = e.c(this, intent);
                if (!TextUtils.isEmpty(c)) {
                    Utility.b(getApplicationContext(), intent, b, c);
                }
            }
        } catch (Exception unused) {
        }
        finish();
    }
}
