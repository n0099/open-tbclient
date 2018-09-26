package com.baidu.sapi2.receiver;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.telephony.SmsMessage;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes.dex */
public class SMSReceiver extends BroadcastReceiver {
    private Handler a;

    public SMSReceiver(Handler handler) {
        this.a = handler;
    }

    @Override // android.content.BroadcastReceiver
    @TargetApi(4)
    public void onReceive(Context context, Intent intent) {
        try {
            Object[] objArr = (Object[]) intent.getExtras().get("pdus");
            SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < objArr.length) {
                    smsMessageArr[i2] = SmsMessage.createFromPdu((byte[]) objArr[i2]);
                    String smsCheckCode = SapiUtils.getSmsCheckCode(smsMessageArr[i2].getMessageBody());
                    if (this.a != null) {
                        Message obtainMessage = this.a.obtainMessage();
                        obtainMessage.obj = smsCheckCode;
                        this.a.sendMessage(obtainMessage);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } catch (Throwable th) {
            Log.e(th);
        }
    }
}
