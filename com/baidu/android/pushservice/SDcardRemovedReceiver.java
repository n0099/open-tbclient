package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class SDcardRemovedReceiver extends BroadcastReceiver {
    private static String a = "SDRev";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            if (action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_REMOVED")) {
                com.baidu.android.pushservice.c.a.a();
            }
        }
    }
}
