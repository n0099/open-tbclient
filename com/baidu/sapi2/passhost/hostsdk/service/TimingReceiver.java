package com.baidu.sapi2.passhost.hostsdk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.base.utils.AlarmerUtil;
/* loaded from: classes.dex */
public class TimingReceiver extends BroadcastReceiver {
    public static final String a = "com.baidu.sapi2.ACTION_HOUR_FREQUENCY";
    public static final String b = "com.baidu.sapi2.ACTION_DAY_FREQUENCY";
    private static final String c = "TimingReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.d(c, "TimingReceiver.onReceive()");
        String action = intent.getAction();
        if (action == null) {
            Log.d(c, "TimingReceiver.onReceive() action null");
            return;
        }
        Log.d(c, action);
        a.a().a(context.getApplicationContext());
        if (a.equals(action)) {
            Log.d(c, "TimingReceiver() handleDayFrequency");
            AlarmerUtil.addAlarm(context.getApplicationContext(), a, 10, 1);
            a.a().a(6);
        } else if (b.equals(action)) {
            Log.d(c, "TimingReceiver() handleDayFrequency");
            AlarmerUtil.addAlarm(context.getApplicationContext(), b, 7, 1);
            a.a().a(6);
        } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
            Log.d(c, "TimingReceiver() ACTION_SCREEN_OFF");
            a.a().a(4);
        } else if ("android.intent.action.SCREEN_ON".equals(action)) {
            Log.d(c, "TimingReceiver() ACTION_SCREEN_ON");
            a.a().a(3);
        } else if ("android.intent.action.USER_PRESENT".equals(action)) {
            Log.d(c, "TimingReceiver() ACTION_USER_PRESENT");
            a.a().a(5);
        } else if ("android.intent.action.TIME_TICK".equals(action)) {
            Log.d(c, "TimingReceiver() ACTION_TIME_TICK");
        } else {
            Log.d(c, "TimingReceiver.onReceive() not my action");
        }
    }
}
