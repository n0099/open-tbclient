package com.baidu.swan.gamecenter.appmanager.a;

import android.content.IntentFilter;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class f extends com.baidu.swan.gamecenter.c.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AppDownloadNetworkStateReceiver dda;

    public f() {
        super("resumeAllDownloadWhileWifi");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(JSONObject jSONObject, com.baidu.swan.apps.n.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
        } else {
            if (this.dda == null) {
                this.dda = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            com.baidu.swan.apps.t.a.ahj().registerReceiver(this.dda, intentFilter);
            bVar.aj(null);
        }
        return null;
    }
}
