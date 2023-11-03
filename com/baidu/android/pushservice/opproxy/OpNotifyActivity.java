package com.baidu.android.pushservice.opproxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.n.c;
import com.baidu.android.pushservice.util.Utility;
/* loaded from: classes.dex */
public class OpNotifyActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
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
                    Utility.a(intent2, getApplicationContext());
                    c.a().a(this, false, 1, stringExtra3);
                }
            }
        } catch (Exception unused) {
        }
        finish();
    }
}
