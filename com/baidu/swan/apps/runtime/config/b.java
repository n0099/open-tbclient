package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes10.dex */
    public static class a {
        public int bLs;
        public int bLt;
        public int bLu;
        public int bLv;

        public static a ay(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aba();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aba();
            }
            a aVar = new a();
            aVar.bLs = optJSONObject.optInt("request", 60000);
            aVar.bLt = optJSONObject.optInt("connectSocket", 60000);
            aVar.bLu = optJSONObject.optInt("uploadFile");
            aVar.bLv = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aba() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.bLs = 60000;
            aVar.bLt = 60000;
            return aVar;
        }
    }
}
