package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes11.dex */
    public static class a {
        public int coC;
        public int coD;
        public int coE;
        public int coF;

        public static a aJ(JSONObject jSONObject) {
            if (jSONObject == null) {
                return alx();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return alx();
            }
            a aVar = new a();
            aVar.coC = optJSONObject.optInt("request", 60000);
            aVar.coD = optJSONObject.optInt("connectSocket", 60000);
            aVar.coE = optJSONObject.optInt("uploadFile");
            aVar.coF = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a alx() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.coC = 60000;
            aVar.coD = 60000;
            return aVar;
        }
    }
}
