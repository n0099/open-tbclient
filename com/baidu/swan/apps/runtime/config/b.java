package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes9.dex */
    public static class a {
        public int bKI;
        public int bKJ;
        public int bKK;
        public int bKL;

        public static a ay(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aaD();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aaD();
            }
            a aVar = new a();
            aVar.bKI = optJSONObject.optInt("request", 60000);
            aVar.bKJ = optJSONObject.optInt("connectSocket", 60000);
            aVar.bKK = optJSONObject.optInt("uploadFile");
            aVar.bKL = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aaD() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.bKI = 60000;
            aVar.bKJ = 60000;
            return aVar;
        }
    }
}
