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
            if (b.aPz().aPA() && SwanAppNetworkUtils.aAh() == SwanAppNetworkUtils.NetType.WIFI) {
                if (ProcessUtils.isMainProcess()) {
                    com.baidu.swan.gamecenter.appmanager.a.aPp().aPr();
                    return;
                }
                com.baidu.swan.apps.process.messaging.client.a aEL = com.baidu.swan.apps.runtime.d.aEQ().aEL();
                if (aEL != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_OPERATION, "resumeAllDownload");
                    aEL.b(bundle, d.class);
                }
            } else if (ProcessUtils.isMainProcess()) {
                com.baidu.swan.gamecenter.appmanager.a.aPp().aPs();
            } else {
                com.baidu.swan.apps.process.messaging.client.a aEL2 = com.baidu.swan.apps.runtime.d.aEQ().aEL();
                if (aEL2 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                    aEL2.b(bundle2, d.class);
                }
            }
        }
    }
}
