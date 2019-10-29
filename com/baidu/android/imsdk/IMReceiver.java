package com.baidu.android.imsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.chatmessage.BindStateManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMSettings;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.imsdk.IMService;
/* loaded from: classes6.dex */
public class IMReceiver extends BroadcastReceiver {
    private static final String TAG = "IMReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IMSettings.setContext(context.getApplicationContext());
        String action = intent.getAction();
        if ("android.intent.action.BOOT_COMPLETED".equals(action) || "android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.USER_PRESENT".equals(action) || "android.intent.action.MEDIA_CHECKING".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action) || "android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_REMOVED".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action) || "android.bluetooth.adapter.action.STATE_CHANGED".equals(action) || McastConfig.ACTION_NETWORK_STATE_CHANGED.equals(action) || McastConfig.ACTION_WIFI_STATE_CHANGED.equals(action)) {
            LogUtils.i(TAG, " start IMSerevice for action:" + action);
            if (IMConfigInternal.getInstance().getIMConfig(context).getRootComplete() && !Utility.isInitiativeDisconnect(context.getApplicationContext())) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    if (!intent.getBooleanExtra("noConnectivity", false)) {
                        startService(context, new Intent(Constants.ACTION_START));
                        BindStateManager.activeUnBind(context);
                        return;
                    }
                    return;
                }
                startService(context, new Intent(Constants.ACTION_START));
            }
        } else if (Constants.ACTION_METHOD.equals(intent.getAction())) {
            startService(context, intent);
        } else {
            startService(context);
        }
    }

    private void startService(Context context) {
        Intent intent = new Intent(context, IMService.class);
        intent.setAction(Constants.ACTION_START);
        try {
            context.startService(intent);
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
        }
    }

    private void startService(Context context, Intent intent) {
        if (intent == null) {
            startService(context);
            return;
        }
        intent.setClass(context, IMService.class);
        try {
            context.startService(intent);
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
        }
    }
}
