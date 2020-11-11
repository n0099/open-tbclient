package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes10.dex */
    public static class a {
        public int dtw;
        public int dtx;
        public int dty;
        public int dtz;

        public static a by(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aIg();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aIg();
            }
            a aVar = new a();
            aVar.dtw = optJSONObject.optInt("request", com.baidu.swan.apps.t.a.awD().agr());
            aVar.dtx = optJSONObject.optInt("connectSocket", 60000);
            aVar.dty = optJSONObject.optInt("uploadFile");
            aVar.dtz = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aIg() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.dtw = 60000;
            aVar.dtx = 60000;
            return aVar;
        }
    }
}
