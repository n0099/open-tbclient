package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.am1;
import com.baidu.tieba.cx3;
import com.baidu.tieba.k23;
import com.baidu.tieba.o53;
import com.baidu.tieba.ow3;
import com.baidu.tieba.zw3;
/* loaded from: classes4.dex */
public class AppDownloadNetworkStateReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = am1.a;
    public static final String KEY_OPERATION = "operation";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && NetworkMonitor.NET_CHANGE_ACTION.equals(intent.getAction())) {
            if (DEBUG) {
                Log.d("NetworkBroadcast", "——> onReceive: ");
            }
            if (SwanAppNetworkUtils.NetType.WIFI == SwanAppNetworkUtils.f() && zw3.a().b()) {
                if (ProcessUtils.isMainProcess()) {
                    ow3.n().D();
                    return;
                }
                k23 y = o53.K().y();
                if (y != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_OPERATION, "resumeAllDownload");
                    y.W(bundle, cx3.class);
                }
            } else if (ProcessUtils.isMainProcess()) {
                ow3.n().u();
            } else {
                k23 y2 = o53.K().y();
                if (y2 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                    y2.W(bundle2, cx3.class);
                }
            }
        }
    }
}
