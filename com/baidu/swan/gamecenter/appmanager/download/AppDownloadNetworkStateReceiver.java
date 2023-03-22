package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.do1;
import com.baidu.tieba.dz3;
import com.baidu.tieba.gz3;
import com.baidu.tieba.o43;
import com.baidu.tieba.s73;
import com.baidu.tieba.sy3;
/* loaded from: classes3.dex */
public class AppDownloadNetworkStateReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = do1.a;
    public static final String KEY_OPERATION = "operation";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (DEBUG) {
                Log.d("NetworkBroadcast", "——> onReceive: ");
            }
            if (SwanAppNetworkUtils.NetType.WIFI == SwanAppNetworkUtils.f() && dz3.a().b()) {
                if (ProcessUtils.isMainProcess()) {
                    sy3.n().D();
                    return;
                }
                o43 y = s73.K().y();
                if (y != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_OPERATION, "resumeAllDownload");
                    y.W(bundle, gz3.class);
                }
            } else if (ProcessUtils.isMainProcess()) {
                sy3.n().u();
            } else {
                o43 y2 = s73.K().y();
                if (y2 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                    y2.W(bundle2, gz3.class);
                }
            }
        }
    }
}
