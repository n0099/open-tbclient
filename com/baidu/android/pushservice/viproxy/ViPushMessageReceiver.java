package com.baidu.android.pushservice.viproxy;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class ViPushMessageReceiver extends OpenClientPushMessageReceiver {
    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage) {
        if (uPSNotificationMessage == null) {
            return;
        }
        int skipType = uPSNotificationMessage.getSkipType();
        String skipContent = uPSNotificationMessage.getSkipContent();
        if (skipType != 3 || skipContent.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(skipContent);
            String optString = jSONObject.optString("msgid");
            String optString2 = jSONObject.optString("visigninfo");
            String optString3 = jSONObject.optString("pkg_content");
            String optString4 = jSONObject.optString("custom_content");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            Intent intent = new Intent("com.baidu.android.pushservice.action.VIVO_CLICK");
            intent.putExtra("vi_notification_title", uPSNotificationMessage.getTitle());
            intent.putExtra("vi_notification_content", uPSNotificationMessage.getContent());
            intent.putExtra("vi_notification_sign", optString2);
            intent.putExtra("vi_notification_msg_id", optString);
            intent.putExtra("vi_notification_pkg_content", optString3);
            intent.putExtra("extra_extra_custom_content", optString4);
            m.a(intent, context.getApplicationContext());
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(Context context, String str) {
    }
}
