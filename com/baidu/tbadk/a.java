package com.baidu.tbadk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
/* loaded from: classes.dex */
class a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (TbadkApplication.getCurrentAccount() != null) {
            MessageManager.getInstance().sendMessage(new HttpMessage(1001507));
        }
    }
}
