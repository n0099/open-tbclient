package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes10.dex */
    public static class a {
        public int deZ;
        public int dfa;
        public int dfb;
        public int dfc;

        public static a bp(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aDM();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aDM();
            }
            a aVar = new a();
            aVar.deZ = optJSONObject.optInt("request", com.baidu.swan.apps.t.a.asi().abX());
            aVar.dfa = optJSONObject.optInt("connectSocket", 60000);
            aVar.dfb = optJSONObject.optInt("uploadFile");
            aVar.dfc = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aDM() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.deZ = 60000;
            aVar.dfa = 60000;
            return aVar;
        }
    }
}
