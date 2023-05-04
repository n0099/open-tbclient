package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.ho1;
import com.baidu.tieba.hz3;
import com.baidu.tieba.kz3;
import com.baidu.tieba.s43;
import com.baidu.tieba.w73;
import com.baidu.tieba.wy3;
/* loaded from: classes3.dex */
public class AppDownloadNetworkStateReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = ho1.a;
    public static final String KEY_OPERATION = "operation";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (DEBUG) {
                Log.d("NetworkBroadcast", "——> onReceive: ");
            }
            if (SwanAppNetworkUtils.NetType.WIFI == SwanAppNetworkUtils.f() && hz3.a().b()) {
                if (ProcessUtils.isMainProcess()) {
                    wy3.n().D();
                    return;
                }
                s43 y = w73.K().y();
                if (y != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_OPERATION, "resumeAllDownload");
                    y.W(bundle, kz3.class);
                }
            } else if (ProcessUtils.isMainProcess()) {
                wy3.n().u();
            } else {
                s43 y2 = w73.K().y();
                if (y2 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                    y2.W(bundle2, kz3.class);
                }
            }
        }
    }
}
