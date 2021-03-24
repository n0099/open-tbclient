package com.baidu.tbadk.commonReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class ScreenLockReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z = false;
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            z = true;
        } else {
            intent.getAction().equals("android.intent.action.SCREEN_ON");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016523, Boolean.valueOf(z)));
    }
}
