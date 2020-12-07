package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes25.dex */
    public static class a {
        public int dyO;
        public int dyP;
        public int dyQ;
        public int dyR;

        public static a bu(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aKG();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aKG();
            }
            a aVar = new a();
            aVar.dyO = optJSONObject.optInt("request", com.baidu.swan.apps.t.a.azd().aiR());
            aVar.dyP = optJSONObject.optInt("connectSocket", 60000);
            aVar.dyQ = optJSONObject.optInt("uploadFile");
            aVar.dyR = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aKG() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.dyO = 60000;
            aVar.dyP = 60000;
            return aVar;
        }
    }
}
