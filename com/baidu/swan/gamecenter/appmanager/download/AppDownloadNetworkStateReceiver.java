package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes3.dex */
public class AppDownloadNetworkStateReceiver extends BroadcastReceiver {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String KEY_OPERATION = "operation";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (DEBUG) {
                Log.d("NetworkBroadcast", "——> onReceive: ");
            }
            if (b.aWR().aWS() && SwanAppNetworkUtils.aGD() == SwanAppNetworkUtils.NetType.WIFI) {
                if (ProcessUtils.isMainProcess()) {
                    com.baidu.swan.gamecenter.appmanager.a.aWH().aWJ();
                    return;
                }
                com.baidu.swan.apps.process.messaging.client.a aMc = com.baidu.swan.apps.runtime.d.aMh().aMc();
                if (aMc != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_OPERATION, "resumeAllDownload");
                    aMc.b(bundle, d.class);
                }
            } else if (ProcessUtils.isMainProcess()) {
                com.baidu.swan.gamecenter.appmanager.a.aWH().aWK();
            } else {
                com.baidu.swan.apps.process.messaging.client.a aMc2 = com.baidu.swan.apps.runtime.d.aMh().aMc();
                if (aMc2 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                    aMc2.b(bundle2, d.class);
                }
            }
        }
    }
}
