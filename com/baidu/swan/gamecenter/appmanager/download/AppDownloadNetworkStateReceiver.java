package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.f34;
import com.baidu.tieba.fs1;
import com.baidu.tieba.i34;
import com.baidu.tieba.q83;
import com.baidu.tieba.u24;
import com.baidu.tieba.ub3;
/* loaded from: classes4.dex */
public class AppDownloadNetworkStateReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = fs1.a;
    public static final String KEY_OPERATION = "operation";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && NetworkMonitor.NET_CHANGE_ACTION.equals(intent.getAction())) {
            if (DEBUG) {
                Log.d("NetworkBroadcast", "——> onReceive: ");
            }
            if (SwanAppNetworkUtils.NetType.WIFI == SwanAppNetworkUtils.f() && f34.a().b()) {
                if (ProcessUtils.isMainProcess()) {
                    u24.n().D();
                    return;
                }
                q83 y = ub3.K().y();
                if (y != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_OPERATION, "resumeAllDownload");
                    y.W(bundle, i34.class);
                }
            } else if (ProcessUtils.isMainProcess()) {
                u24.n().u();
            } else {
                q83 y2 = ub3.K().y();
                if (y2 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                    y2.W(bundle2, i34.class);
                }
            }
        }
    }
}
