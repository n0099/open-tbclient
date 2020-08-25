package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.util.List;
/* loaded from: classes5.dex */
public class PushPatchMessageReceiver extends com.xiaomi.mipush.sdk.PushMessageReceiver {
    public static final int MSG_ARRIVED = 2;
    public static final int MSG_CLICKED = 3;
    public static final int MSG_PASS = 1;
    public static final String PUSH_MSG = "xm_push_msg";
    public static final String PUSH_MSG_TYPE = "xm_push_msg_type";
    public static final String REGID = "xm_regid";
    public static final String REGISTER_ERRORCODE = "xm_register_errorcode";
    private static final String TAG = "PushPatchMessageReceiver";

    private void handleXiaomiMsg(Context context, MiPushMessage miPushMessage, int i) {
        try {
            Intent intent = new Intent("com.xiaomi.mipush.PUSH_MSG");
            intent.putExtra(PUSH_MSG, miPushMessage);
            intent.putExtra(PUSH_MSG_TYPE, i);
            m.a(intent, context.getApplicationContext());
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageArrived(context, miPushMessage);
        handleXiaomiMsg(context, miPushMessage, 2);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageClicked(context, miPushMessage);
        handleXiaomiMsg(context, miPushMessage, 3);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        super.onReceivePassThroughMessage(context, miPushMessage);
        handleXiaomiMsg(context, miPushMessage, 1);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        super.onReceiveRegisterResult(context, miPushCommandMessage);
        if (miPushCommandMessage != null) {
            try {
                String command = miPushCommandMessage.getCommand();
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                String str = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
                if ("register".equals(command)) {
                    Intent intent = new Intent("com.xiaomi.mipush.REGISTER");
                    intent.putExtra(REGID, str);
                    intent.putExtra(REGISTER_ERRORCODE, miPushCommandMessage.getResultCode());
                    m.a(intent, context.getApplicationContext());
                }
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
            }
        }
    }
}
