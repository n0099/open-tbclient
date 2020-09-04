package com.baidu.swan.gamecenter.appmanager.a;

import android.content.IntentFilter;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends com.baidu.swan.gamecenter.c.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AppDownloadNetworkStateReceiver dnn;

    public f() {
        super("resumeAllDownloadWhileWifi");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(JSONObject jSONObject, com.baidu.swan.apps.o.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
        } else {
            if (this.dnn == null) {
                this.dnn = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            com.baidu.swan.apps.t.a.aoJ().registerReceiver(this.dnn, intentFilter);
            bVar.al(null);
        }
        return null;
    }
}
