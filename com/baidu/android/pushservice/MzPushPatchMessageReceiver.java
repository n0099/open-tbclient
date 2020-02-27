package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.i.l;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
/* loaded from: classes8.dex */
public class MzPushPatchMessageReceiver extends MzPushMessageReceiver {
    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onMessage(Context context, String str) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onNotificationClicked(Context context, MzPushMessage mzPushMessage) {
        if (mzPushMessage == null) {
            return;
        }
        try {
            String title = mzPushMessage.getTitle();
            String content = mzPushMessage.getContent();
            String selfDefineContentString = mzPushMessage.getSelfDefineContentString();
            Intent intent = new Intent("com.meizu.mzpush.PUSH_MSG");
            intent.putExtra("mz_notification_title", title);
            intent.putExtra("mz_notification_content", content);
            intent.putExtra("mz_notification_self_define_content", selfDefineContentString);
            intent.putExtra("mz_push_msg_type", 3);
            l.a(intent, context.getApplicationContext());
        } catch (Exception e) {
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver, com.meizu.cloud.pushsdk.base.IntentReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (Double.parseDouble(l.j()) < 6.0d) {
                return;
            }
        } catch (Exception e) {
        }
        super.onReceive(context, intent);
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onRegister(Context context, String str) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
        if (registerStatus != null) {
            try {
                String pushId = registerStatus.getPushId();
                Intent intent = new Intent("com.meizu.mzpush.REGISTER");
                intent.putExtra("mz_pushid", pushId);
                intent.putExtra("mz_register_errorcode", registerStatus.getCode());
                l.a(intent, context.getApplicationContext());
            } catch (Exception e) {
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onUnRegister(Context context, boolean z) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus) {
    }
}
