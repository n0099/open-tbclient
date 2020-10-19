package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes6.dex */
public class AppDownloadNetworkStateReceiver extends BroadcastReceiver {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String KEY_OPERATION = "operation";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (DEBUG) {
                Log.d("NetworkBroadcast", "——> onReceive: ");
            }
            if (b.aNF().aNG() && SwanAppNetworkUtils.ayn() == SwanAppNetworkUtils.NetType.WIFI) {
                if (ProcessUtils.isMainProcess()) {
                    com.baidu.swan.gamecenter.appmanager.a.aNv().aNx();
                    return;
                }
                com.baidu.swan.apps.process.messaging.client.a aCR = com.baidu.swan.apps.runtime.d.aCW().aCR();
                if (aCR != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_OPERATION, "resumeAllDownload");
                    aCR.b(bundle, d.class);
                }
            } else if (ProcessUtils.isMainProcess()) {
                com.baidu.swan.gamecenter.appmanager.a.aNv().aNy();
            } else {
                com.baidu.swan.apps.process.messaging.client.a aCR2 = com.baidu.swan.apps.runtime.d.aCW().aCR();
                if (aCR2 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                    aCR2.b(bundle2, d.class);
                }
            }
        }
    }
}
