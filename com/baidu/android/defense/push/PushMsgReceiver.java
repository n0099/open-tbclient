package com.baidu.android.defense.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.moplus.MoPlusService;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PushMsgReceiver extends BroadcastReceiver {
    public static final String a = PushMsgReceiver.class.getSimpleName();
    private static Context b = null;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        b = context;
        String action = intent.getAction();
        if ("com.baidu.android.pushservice.action.MESSAGE".equals(action) || "com.baidu.pushservice.action.supper.MESSAGE".equals(action)) {
            if (com.baidu.android.a.j.a(context).h()) {
                Intent intent2 = new Intent(intent);
                intent2.setClass(context, MoPlusService.class);
                context.startService(intent2);
            }
        } else if ("com.baidu.android.pushservice.action.RECEIVE".equals(action) || "com.baidu.android.pushservice.action.internal.RECEIVE".equals(action)) {
            String stringExtra = intent.getStringExtra("method");
            int intExtra = intent.getIntExtra("error_msg", 0);
            if (intent.getByteArrayExtra("content") != null) {
                String str = new String(intent.getByteArrayExtra("content"));
                if ("method_bind".equals(stringExtra) && intExtra == 0) {
                    try {
                        JSONObject jSONObject = (JSONObject) new JSONObject(str).get("response_params");
                        String string = jSONObject.getString("channel_id");
                        String string2 = jSONObject.getString(com.baidu.tbadk.core.frameworkData.a.USER_ID);
                        if ("543540".equals(jSONObject.getString("appid"))) {
                            b.b(b, string);
                            b.c(b, string2);
                            if ("com.baidu.android.pushservice.action.RECEIVE".equals(action)) {
                                b.a(b, 1);
                            } else {
                                b.a(b, 2);
                            }
                            Intent intent3 = new Intent(intent);
                            intent3.setClass(context, MoPlusService.class);
                            context.startService(intent3);
                        }
                    } catch (JSONException e) {
                    }
                }
            }
        }
    }
}
