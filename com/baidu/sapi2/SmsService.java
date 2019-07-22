package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v7.widget.ActivityChooserView;
import android.telephony.SmsManager;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class SmsService {
    @TargetApi(4)
    public static boolean sendSms(String str, String str2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            SmsManager.getDefault().sendTextMessage(str, null, str2, pendingIntent, pendingIntent2);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static BroadcastReceiver registerReceiver(Context context, Handler handler) {
        SMSReceiver sMSReceiver = new SMSReceiver(handler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        intentFilter.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        context.registerReceiver(sMSReceiver, intentFilter);
        return sMSReceiver;
    }
}
