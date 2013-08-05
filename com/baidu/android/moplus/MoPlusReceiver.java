package com.baidu.android.moplus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class MoPlusReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        Intent intent2 = new Intent(intent);
        intent2.setClass(context, MoPlusService.class);
        context.getApplicationContext().startService(intent2);
    }
}
