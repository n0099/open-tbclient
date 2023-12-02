package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.f33;
import com.baidu.tieba.j63;
import com.baidu.tieba.jx3;
import com.baidu.tieba.ux3;
import com.baidu.tieba.vm1;
import com.baidu.tieba.xx3;
/* loaded from: classes4.dex */
public class AppDownloadNetworkStateReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = vm1.a;
    public static final String KEY_OPERATION = "operation";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && NetworkMonitor.NET_CHANGE_ACTION.equals(intent.getAction())) {
            if (DEBUG) {
                Log.d("NetworkBroadcast", "——> onReceive: ");
            }
            if (SwanAppNetworkUtils.NetType.WIFI == SwanAppNetworkUtils.f() && ux3.a().b()) {
                if (ProcessUtils.isMainProcess()) {
                    jx3.n().D();
                    return;
                }
                f33 y = j63.K().y();
                if (y != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_OPERATION, "resumeAllDownload");
                    y.W(bundle, xx3.class);
                }
            } else if (ProcessUtils.isMainProcess()) {
                jx3.n().u();
            } else {
                f33 y2 = j63.K().y();
                if (y2 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                    y2.W(bundle2, xx3.class);
                }
            }
        }
    }
}
