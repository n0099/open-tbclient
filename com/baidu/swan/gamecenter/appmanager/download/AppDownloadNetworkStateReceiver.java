package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.c24;
import com.baidu.tieba.cb3;
import com.baidu.tieba.n24;
import com.baidu.tieba.nr1;
import com.baidu.tieba.q24;
import com.baidu.tieba.y73;
/* loaded from: classes4.dex */
public class AppDownloadNetworkStateReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = nr1.a;
    public static final String KEY_OPERATION = "operation";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && NetworkMonitor.NET_CHANGE_ACTION.equals(intent.getAction())) {
            if (DEBUG) {
                Log.d("NetworkBroadcast", "——> onReceive: ");
            }
            if (SwanAppNetworkUtils.NetType.WIFI == SwanAppNetworkUtils.f() && n24.a().b()) {
                if (ProcessUtils.isMainProcess()) {
                    c24.n().D();
                    return;
                }
                y73 y = cb3.K().y();
                if (y != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_OPERATION, "resumeAllDownload");
                    y.W(bundle, q24.class);
                }
            } else if (ProcessUtils.isMainProcess()) {
                c24.n().u();
            } else {
                y73 y2 = cb3.K().y();
                if (y2 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                    y2.W(bundle2, q24.class);
                }
            }
        }
    }
}
