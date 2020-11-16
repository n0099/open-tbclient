package com.baidu.android.pushservice.opproxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.m;
/* loaded from: classes7.dex */
public class OpNotifyActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("msgid");
            String stringExtra2 = intent.getStringExtra("opsigninfo");
            String stringExtra3 = intent.getStringExtra("custom_content");
            String stringExtra4 = intent.getStringExtra("pkg_content");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                Intent intent2 = new Intent("com.baidu.android.pushservice.action.OPPO_CLICK");
                intent2.putExtra("op_notification_sign", stringExtra2);
                intent2.putExtra("op_notification_msg_id", stringExtra);
                intent2.putExtra("op_notification_pkg_content", stringExtra4);
                intent2.putExtra("extra_extra_custom_content", stringExtra3);
                m.a(intent2, getApplicationContext());
            }
        }
        finish();
    }
}
