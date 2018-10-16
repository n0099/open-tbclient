package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.telephony.SmsManager;
import android.text.TextUtils;
/* loaded from: classes6.dex */
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
}
