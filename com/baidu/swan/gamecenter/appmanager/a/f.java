package com.baidu.swan.gamecenter.appmanager.a;

import android.content.IntentFilter;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class f extends com.baidu.swan.gamecenter.c.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AppDownloadNetworkStateReceiver dpq;

    public f() {
        super("resumeAllDownloadWhileWifi");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(JSONObject jSONObject, com.baidu.swan.apps.o.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
        } else {
            if (this.dpq == null) {
                this.dpq = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            com.baidu.swan.apps.t.a.apu().registerReceiver(this.dpq, intentFilter);
            bVar.ao(null);
        }
        return null;
    }
}
