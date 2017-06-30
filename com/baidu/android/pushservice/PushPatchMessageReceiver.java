package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes2.dex */
public class PushPatchMessageReceiver extends com.xiaomi.mipush.sdk.PushMessageReceiver {
    public static final int MSG_ARRIVED = 2;
    public static final int MSG_CLICKED = 3;
    public static final int MSG_PASS = 1;
    public static final String PUSH_MSG = "xm_push_msg";
    public static final String PUSH_MSG_TYPE = "xm_push_msg_type";
    public static final String REGID = "xm_regid";
    public static final String REGISTER_ERRORCODE = "xm_register_errorcode";
    private static final String TAG = "PushPatchMessageReceiver";
    public static final String XIAOMI_PUSH_MSG = "com.xiaomi.mipush.PUSH_MSG";
    public static final String XIAOMI_REGISTER = "com.xiaomi.mipush.REGISTER";

    private static String getReceiver(Context context, String str, String str2) {
        List<ResolveInfo> list;
        PackageManager packageManager;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            Log.e(TAG, "patch receiver err", e);
            list = null;
        }
        if (packageManager != null) {
            list = packageManager.queryBroadcastReceivers(intent, 544);
            if (list == null || list.size() <= 0) {
                return null;
            }
            return list.get(0).activityInfo.name;
        }
        return null;
    }

    private void handleXiaomiMsg(Context context, MiPushMessage miPushMessage, int i) {
        try {
            Log.d(TAG, "XM> PushPatchMessageReceiver Receive XM Msg");
            Intent intent = new Intent(XIAOMI_PUSH_MSG);
            intent.putExtra(PUSH_MSG, miPushMessage);
            intent.putExtra(PUSH_MSG_TYPE, i);
            reflectReceiver(intent, context.getApplicationContext());
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    private void reflectReceiver(Intent intent, Context context) {
        try {
            String packageName = context.getPackageName();
            String receiver = getReceiver(context, context.getPackageName(), PushConstants.ACTION_MESSAGE);
            Log.d(TAG, "XM> patch reflect recelver = " + receiver);
            Class<?> cls = Class.forName(receiver);
            Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            String[] strArr = {"android.content.Context", "android.content.Intent"};
            Method method = cls.getMethod("onReceive", Context.class, Intent.class);
            intent.setClassName(packageName, receiver);
            method.invoke(newInstance, context, intent);
        } catch (Exception e) {
            Log.e(TAG, "reflect err", e);
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageArrived(context, miPushMessage);
        handleXiaomiMsg(context, miPushMessage, 2);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageClicked(context, miPushMessage);
        handleXiaomiMsg(context, miPushMessage, 3);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        super.onReceivePassThroughMessage(context, miPushMessage);
        handleXiaomiMsg(context, miPushMessage, 1);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        super.onReceiveRegisterResult(context, miPushCommandMessage);
        if (miPushCommandMessage != null) {
            try {
                String command = miPushCommandMessage.getCommand();
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                String str = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
                if (MiPushClient.COMMAND_REGISTER.equals(command)) {
                    Intent intent = new Intent(XIAOMI_REGISTER);
                    intent.putExtra(REGID, str);
                    intent.putExtra(REGISTER_ERRORCODE, miPushCommandMessage.getResultCode());
                    reflectReceiver(intent, context.getApplicationContext());
                    Log.d(TAG, "XM> PushPatchMessageReceiver Receive Register Msg");
                }
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        }
    }
}
