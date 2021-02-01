package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes9.dex */
    public static class a {
        public int dEL;
        public int dEM;
        public int dEN;
        public int dEO;

        public static a bz(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aJw();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aJw();
            }
            a aVar = new a();
            aVar.dEL = optJSONObject.optInt("request", com.baidu.swan.apps.t.a.awZ().agE());
            aVar.dEM = optJSONObject.optInt("connectSocket", 60000);
            aVar.dEN = optJSONObject.optInt("uploadFile");
            aVar.dEO = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aJw() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.dEL = 60000;
            aVar.dEM = 60000;
            return aVar;
        }
    }
}
