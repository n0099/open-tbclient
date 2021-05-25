package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.l0.a.a2.d;
import d.a.l0.a.k;
import d.a.l0.g.c.a;
import d.a.l0.g.c.d.b;
import d.a.l0.g.c.d.e;
/* loaded from: classes3.dex */
public class AppDownloadNetworkStateReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = k.f43199a;
    public static final String KEY_OPERATION = "operation";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            return;
        }
        if (DEBUG) {
            Log.d("NetworkBroadcast", "——> onReceive: ");
        }
        if (b.a().b() && SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType.WIFI) {
            if (ProcessUtils.isMainProcess()) {
                a.n().D();
                return;
            }
            d.a.l0.a.v1.c.e.a z = d.g().z();
            if (z != null) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_OPERATION, "resumeAllDownload");
                z.K(bundle, e.class);
            }
        } else if (ProcessUtils.isMainProcess()) {
            a.n().u();
        } else {
            d.a.l0.a.v1.c.e.a z2 = d.g().z();
            if (z2 != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                z2.K(bundle2, e.class);
            }
        }
    }
}
