package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.b34;
import com.baidu.tieba.bc3;
import com.baidu.tieba.m34;
import com.baidu.tieba.ms1;
import com.baidu.tieba.p34;
import com.baidu.tieba.x83;
/* loaded from: classes4.dex */
public class AppDownloadNetworkStateReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = ms1.a;
    public static final String KEY_OPERATION = "operation";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && NetworkMonitor.NET_CHANGE_ACTION.equals(intent.getAction())) {
            if (DEBUG) {
                Log.d("NetworkBroadcast", "——> onReceive: ");
            }
            if (SwanAppNetworkUtils.NetType.WIFI == SwanAppNetworkUtils.f() && m34.a().b()) {
                if (ProcessUtils.isMainProcess()) {
                    b34.n().D();
                    return;
                }
                x83 y = bc3.K().y();
                if (y != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_OPERATION, "resumeAllDownload");
                    y.W(bundle, p34.class);
                }
            } else if (ProcessUtils.isMainProcess()) {
                b34.n().u();
            } else {
                x83 y2 = bc3.K().y();
                if (y2 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                    y2.W(bundle2, p34.class);
                }
            }
        }
    }
}
