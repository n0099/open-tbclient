package com.baidu.swan.apps.ae.a;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes2.dex */
    public static class a {
        public int aQT;
        public int aQU;
        public int aQV;
        public int aQW;

        public static a M(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Mw();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return Mw();
            }
            a aVar = new a();
            aVar.aQT = optJSONObject.optInt("request", 60000);
            aVar.aQU = optJSONObject.optInt("connectSocket", 60000);
            aVar.aQV = optJSONObject.optInt("uploadFile");
            aVar.aQW = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a Mw() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.aQT = 60000;
            aVar.aQU = 60000;
            return aVar;
        }
    }
}
