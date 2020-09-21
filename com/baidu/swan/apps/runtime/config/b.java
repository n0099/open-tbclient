package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes3.dex */
    public static class a {
        public int cSR;
        public int cSS;
        public int cST;
        public int cSU;

        public static a bi(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aBd();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aBd();
            }
            a aVar = new a();
            aVar.cSR = optJSONObject.optInt("request", com.baidu.swan.apps.t.a.apx().Zl());
            aVar.cSS = optJSONObject.optInt("connectSocket", 60000);
            aVar.cST = optJSONObject.optInt("uploadFile");
            aVar.cSU = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aBd() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.cSR = 60000;
            aVar.cSS = 60000;
            return aVar;
        }
    }
}
