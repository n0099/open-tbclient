package com.baidu.android.systemmonitor.devicestatistic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.systemmonitor.StatisticManager;
/* loaded from: classes.dex */
public class StatisticReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!action.equals("android.intent.action.ACTION_SHUTDOWN")) {
            StatisticManager.getInstance(context).handleAction(action);
        } else if (com.baidu.android.systemmonitor.util.b.t(context) == 1) {
            com.baidu.android.systemmonitor.util.e.a(context, System.currentTimeMillis(), false);
        }
    }
}
