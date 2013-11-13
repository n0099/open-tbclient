package com.baidu.android.defense.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.moplus.MoPlusService;
import com.baidu.android.pushservice.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PushMsgReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f627a = PushMsgReceiver.class.getSimpleName();
    private static Context b = null;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        b = context;
        String action = intent.getAction();
        if (PushConstants.ACTION_MESSAGE.equals(action) || "com.baidu.pushservice.action.supper.MESSAGE".equals(action)) {
            if (com.baidu.android.systemmonitor.d.a.k.a(context).c()) {
                Intent intent2 = new Intent(intent);
                intent2.setClass(context, MoPlusService.class);
                context.startService(intent2);
            }
        } else if (PushConstants.ACTION_RECEIVE.equals(action) || "com.baidu.android.pushservice.action.internal.RECEIVE".equals(action)) {
            String stringExtra = intent.getStringExtra(PushConstants.EXTRA_METHOD);
            int intExtra = intent.getIntExtra("error_msg", 0);
            if (intent.getByteArrayExtra("content") != null) {
                String str = new String(intent.getByteArrayExtra("content"));
                if (PushConstants.METHOD_BIND.equals(stringExtra) && intExtra == 0) {
                    try {
                        JSONObject jSONObject = (JSONObject) new JSONObject(str).get("response_params");
                        String string = jSONObject.getString("channel_id");
                        String string2 = jSONObject.getString(PushConstants.EXTRA_USER_ID);
                        if ("543540".equals(jSONObject.getString("appid"))) {
                            l.b(b, string);
                            l.c(b, string2);
                            if (PushConstants.ACTION_RECEIVE.equals(action)) {
                                l.a(b, 1);
                            } else {
                                l.a(b, 2);
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
