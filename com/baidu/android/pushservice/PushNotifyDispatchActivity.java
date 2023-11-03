package com.baidu.android.pushservice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.util.Utility;
/* loaded from: classes.dex */
public class PushNotifyDispatchActivity extends Activity {
    public final void a(Intent intent, Context context) {
        String packageName;
        if (intent != null) {
            String str = "com.baidu.android.pushservice.PushService";
            if (TextUtils.equals(intent.getAction(), "com.baidu.android.pushservice.action.privatenotification.CLICK")) {
                packageName = context.getPackageName();
                if (Utility.U(context)) {
                    str = "com.baidu.pushservice.PushService";
                }
            } else if (TextUtils.equals(intent.getAction(), "com.baidu.android.pushservice.action.pass_through_notify_CLICK")) {
                intent.setClassName(context.getPackageName(), Utility.b(context, context.getPackageName(), "com.baidu.android.pushservice.action.RECEIVE"));
                context.sendBroadcast(intent);
                return;
            } else if (!TextUtils.equals(intent.getAction(), "com.baidu.pushservice.action.publicmsg.CLICK_V2")) {
                return;
            } else {
                packageName = context.getPackageName();
            }
            intent.setClassName(packageName, str);
            context.startService(intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent(), getApplicationContext());
        finish();
    }
}
