package com.baidu.adp.plugin.proxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
/* loaded from: classes.dex */
public class BroadcastReceiverProxy extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_RECEIVER);
            String stringExtra2 = intent.getStringExtra(Plugin.INTENT_EXTRA_PACKAGE_NAME);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String[] split = stringExtra.split("#");
                if (split == null || split.length == 0) {
                    BdLog.d("broadcastreceiver_onreceive_failed: receiver is null");
                    return;
                }
                Plugin plugin2 = PluginCenter.getInstance().getPlugin(stringExtra2);
                if (plugin2 == null || !plugin2.isLoaded()) {
                    BdLog.d("broadcastreceiver_onreceive_failed: plugin not fond " + stringExtra2);
                    return;
                }
                for (String str : split) {
                    try {
                        ((BroadcastReceiver) plugin2.getDexClassLoader().loadClass(str).asSubclass(BroadcastReceiver.class).newInstance()).onReceive(context, intent);
                    } catch (ClassNotFoundException e) {
                        BdLog.e(e);
                    } catch (IllegalAccessException e2) {
                        BdLog.e(e2);
                    } catch (InstantiationException e3) {
                        BdLog.e(e3);
                    }
                }
            }
        }
    }
}
