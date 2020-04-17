package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes11.dex */
    public static class a {
        public int cow;
        public int cox;
        public int coy;
        public int coz;

        public static a aJ(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aly();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aly();
            }
            a aVar = new a();
            aVar.cow = optJSONObject.optInt("request", 60000);
            aVar.cox = optJSONObject.optInt("connectSocket", 60000);
            aVar.coy = optJSONObject.optInt("uploadFile");
            aVar.coz = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aly() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.cow = 60000;
            aVar.cox = 60000;
            return aVar;
        }
    }
}
