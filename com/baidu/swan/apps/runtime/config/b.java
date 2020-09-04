package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes8.dex */
    public static class a {
        public int cQR;
        public int cQS;
        public int cQT;
        public int cQU;

        public static a bf(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aAu();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aAu();
            }
            a aVar = new a();
            aVar.cQR = optJSONObject.optInt("request", com.baidu.swan.apps.t.a.aoM().YC());
            aVar.cQS = optJSONObject.optInt("connectSocket", 60000);
            aVar.cQT = optJSONObject.optInt("uploadFile");
            aVar.cQU = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aAu() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.cQR = 60000;
            aVar.cQS = 60000;
            return aVar;
        }
    }
}
