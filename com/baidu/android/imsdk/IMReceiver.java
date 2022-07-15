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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j60;
/* loaded from: classes.dex */
public class IMReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMReceiver";
    public transient /* synthetic */ FieldHolder $fh;

    public IMReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void startService(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
            Intent intent = new Intent(context, j60.class);
            intent.setAction(Constants.ACTION_START);
            try {
                j60.g(context).f(context, intent);
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            IMSettings.setContext(context.getApplicationContext());
            String action = intent.getAction();
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action) && !"android.intent.action.USER_PRESENT".equals(action) && !"android.intent.action.MEDIA_CHECKING".equals(action) && !"android.intent.action.MEDIA_EJECT".equals(action) && !"android.intent.action.MEDIA_UNMOUNTED".equals(action) && !"android.intent.action.MEDIA_REMOVED".equals(action) && !"android.intent.action.ACTION_POWER_CONNECTED".equals(action) && !"android.intent.action.ACTION_POWER_DISCONNECTED".equals(action) && !"android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && !McastConfig.ACTION_NETWORK_STATE_CHANGED.equals(action) && !McastConfig.ACTION_WIFI_STATE_CHANGED.equals(action)) {
                if (Constants.ACTION_METHOD.equals(intent.getAction())) {
                    startService(context, intent);
                    return;
                } else {
                    startService(context);
                    return;
                }
            }
            LogUtils.i(TAG, " start IMSerevice for action:" + action);
            if (!IMConfigInternal.getInstance().getIMConfig(context).getRootComplete() || Utility.isInitiativeDisconnect(context.getApplicationContext())) {
                return;
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                if (intent.getBooleanExtra("noConnectivity", false)) {
                    return;
                }
                startService(context, new Intent(Constants.ACTION_START));
                BindStateManager.activeUnBind(context);
                return;
            }
            startService(context, new Intent(Constants.ACTION_START));
        }
    }

    private void startService(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, intent) == null) {
            if (intent == null) {
                startService(context);
                return;
            }
            intent.setClass(context, j60.class);
            try {
                j60.g(context).f(context, intent);
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }
}
