package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes11.dex */
    public static class a {
        public int cAo;
        public int cAp;
        public int cAq;
        public int cAr;

        public static a aO(JSONObject jSONObject) {
            if (jSONObject == null) {
                return apu();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return apu();
            }
            a aVar = new a();
            aVar.cAo = optJSONObject.optInt("request", com.baidu.swan.apps.u.a.aeU().Rj());
            aVar.cAp = optJSONObject.optInt("connectSocket", 60000);
            aVar.cAq = optJSONObject.optInt("uploadFile");
            aVar.cAr = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a apu() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.cAo = 60000;
            aVar.cAp = 60000;
            return aVar;
        }
    }
}
