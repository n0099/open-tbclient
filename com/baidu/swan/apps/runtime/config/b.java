package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes11.dex */
    public static class a {
        public int cEY;
        public int cEZ;
        public int cFa;
        public int cFb;

        public static a aV(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aqA();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aqA();
            }
            a aVar = new a();
            aVar.cEY = optJSONObject.optInt("request", com.baidu.swan.apps.u.a.aga().Sp());
            aVar.cEZ = optJSONObject.optInt("connectSocket", 60000);
            aVar.cFa = optJSONObject.optInt("uploadFile");
            aVar.cFb = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aqA() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.cEY = 60000;
            aVar.cEZ = 60000;
            return aVar;
        }
    }
}
