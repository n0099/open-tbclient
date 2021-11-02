package com.baidu.adp.plugin.proxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BroadcastReceiverProxy extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BroadcastReceiverProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_RECEIVER);
        String stringExtra2 = intent.getStringExtra(Plugin.INTENT_EXTRA_PACKAGE_NAME);
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        String[] split = stringExtra.split("#");
        if (split != null && split.length != 0) {
            Plugin plugin2 = PluginCenter.getInstance().getPlugin(stringExtra2);
            if (plugin2 != null && plugin2.isLoaded()) {
                for (String str : split) {
                    try {
                        ((BroadcastReceiver) plugin2.getDexClassLoader().loadClass(str).asSubclass(BroadcastReceiver.class).newInstance()).onReceive(context, intent);
                    } catch (ClassNotFoundException e2) {
                        BdLog.e(e2);
                    } catch (IllegalAccessException e3) {
                        BdLog.e(e3);
                    } catch (InstantiationException e4) {
                        BdLog.e(e4);
                    }
                }
                return;
            }
            BdLog.d("broadcastreceiver_onreceive_failed: plugin not fond " + stringExtra2);
            return;
        }
        BdLog.d("broadcastreceiver_onreceive_failed: receiver is null");
    }
}
