package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes7.dex */
    public static class a {
        public int drN;
        public int drO;
        public int drP;
        public int drQ;

        public static a bs(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aHy();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aHy();
            }
            a aVar = new a();
            aVar.drN = optJSONObject.optInt("request", com.baidu.swan.apps.t.a.avV().afJ());
            aVar.drO = optJSONObject.optInt("connectSocket", 60000);
            aVar.drP = optJSONObject.optInt("uploadFile");
            aVar.drQ = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aHy() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.drN = 60000;
            aVar.drO = 60000;
            return aVar;
        }
    }
}
