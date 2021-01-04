package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes9.dex */
    public static class a {
        public int dHt;
        public int dHu;
        public int dHv;
        public int dHw;

        public static a bC(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aMW();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aMW();
            }
            a aVar = new a();
            aVar.dHt = optJSONObject.optInt("request", com.baidu.swan.apps.t.a.aAu().ajZ());
            aVar.dHu = optJSONObject.optInt("connectSocket", 60000);
            aVar.dHv = optJSONObject.optInt("uploadFile");
            aVar.dHw = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aMW() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.dHt = 60000;
            aVar.dHu = 60000;
            return aVar;
        }
    }
}
