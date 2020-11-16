package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes16.dex */
public class AppDownloadNetworkStateReceiver extends BroadcastReceiver {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String KEY_OPERATION = "operation";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (DEBUG) {
                Log.d("NetworkBroadcast", "——> onReceive: ");
            }
            if (b.aRr().aRs() && SwanAppNetworkUtils.aBZ() == SwanAppNetworkUtils.NetType.WIFI) {
                if (ProcessUtils.isMainProcess()) {
                    com.baidu.swan.gamecenter.appmanager.a.aRh().aRj();
                    return;
                }
                com.baidu.swan.apps.process.messaging.client.a aGD = com.baidu.swan.apps.runtime.d.aGI().aGD();
                if (aGD != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_OPERATION, "resumeAllDownload");
                    aGD.b(bundle, d.class);
                }
            } else if (ProcessUtils.isMainProcess()) {
                com.baidu.swan.gamecenter.appmanager.a.aRh().aRk();
            } else {
                com.baidu.swan.apps.process.messaging.client.a aGD2 = com.baidu.swan.apps.runtime.d.aGI().aGD();
                if (aGD2 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                    aGD2.b(bundle2, d.class);
                }
            }
        }
    }
}
