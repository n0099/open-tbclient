package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes11.dex */
    public static class a {
        public int bPA;
        public int bPx;
        public int bPy;
        public int bPz;

        public static a ay(JSONObject jSONObject) {
            if (jSONObject == null) {
                return ado();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return ado();
            }
            a aVar = new a();
            aVar.bPx = optJSONObject.optInt("request", 60000);
            aVar.bPy = optJSONObject.optInt("connectSocket", 60000);
            aVar.bPz = optJSONObject.optInt("uploadFile");
            aVar.bPA = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a ado() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.bPx = 60000;
            aVar.bPy = 60000;
            return aVar;
        }
    }
}
