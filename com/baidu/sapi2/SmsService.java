package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.telephony.SmsManager;
import android.text.TextUtils;
import com.baidu.sapi2.callback.RequestSMSCallback;
import com.baidu.sapi2.permissions.AlertDialogInterface;
import com.baidu.sapi2.permissions.PassPermissions;
import com.baidu.sapi2.permissions.PermissionsCallback;
import com.baidu.sapi2.permissions.PermissionsDTO;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes3.dex */
public class SmsService {
    @TargetApi(4)
    public static void sendSms(Context context, final String str, final String str2, final PendingIntent pendingIntent, final PendingIntent pendingIntent2, final RequestSMSCallback requestSMSCallback) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            requestSMSCallback.sendSmsResult(false);
            return;
        }
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = context;
        permissionsDTO.permissions = new String[]{"android.permission.SEND_SMS"};
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.SmsService.1
            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public void onSuccess() {
                try {
                    SmsManager.getDefault().sendTextMessage(str, null, str2, pendingIntent, pendingIntent2);
                    requestSMSCallback.sendSmsResult(true);
                } catch (Throwable th) {
                    Log.e(th);
                    requestSMSCallback.sendSmsResult(false);
                }
            }

            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public void onFailure() {
                requestSMSCallback.sendSmsResult(false);
            }

            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public AlertDialogInterface getDialog(Activity activity) {
                return requestSMSCallback.getDialog(activity);
            }
        });
    }

    public static void registerReceiver(final Context context, final Handler handler, final RequestSMSCallback requestSMSCallback) {
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = context;
        permissionsDTO.permissions = new String[]{"android.permission.RECEIVE_SMS"};
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.SmsService.2
            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public void onSuccess() {
                SMSReceiver sMSReceiver = new SMSReceiver(handler);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
                intentFilter.setPriority(Integer.MAX_VALUE);
                context.registerReceiver(sMSReceiver, intentFilter);
                requestSMSCallback.receiverResult(sMSReceiver);
            }

            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public void onFailure() {
                requestSMSCallback.receiverResult(null);
            }

            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public AlertDialogInterface getDialog(Activity activity) {
                return requestSMSCallback.getDialog(activity);
            }
        });
    }
}
