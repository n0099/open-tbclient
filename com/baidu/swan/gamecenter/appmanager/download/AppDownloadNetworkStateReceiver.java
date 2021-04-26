package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.h0.a.k;
import d.a.h0.a.r1.d;
import d.a.h0.f.f.a;
import d.a.h0.f.f.d.b;
/* loaded from: classes3.dex */
public class AppDownloadNetworkStateReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = k.f43101a;
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
                a.l().w();
                return;
            }
            d.a.h0.a.n1.c.e.a x = d.e().x();
            if (x != null) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_OPERATION, "resumeAllDownload");
                x.I(bundle, d.a.h0.f.f.d.d.class);
            }
        } else if (ProcessUtils.isMainProcess()) {
            a.l().o();
        } else {
            d.a.h0.a.n1.c.e.a x2 = d.e().x();
            if (x2 != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                x2.I(bundle2, d.a.h0.f.f.d.d.class);
            }
        }
    }
}
