package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes11.dex */
    public static class a {
        public int bPK;
        public int bPL;
        public int bPM;
        public int bPN;

        public static a ay(JSONObject jSONObject) {
            if (jSONObject == null) {
                return adt();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return adt();
            }
            a aVar = new a();
            aVar.bPK = optJSONObject.optInt("request", 60000);
            aVar.bPL = optJSONObject.optInt("connectSocket", 60000);
            aVar.bPM = optJSONObject.optInt("uploadFile");
            aVar.bPN = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a adt() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.bPK = 60000;
            aVar.bPL = 60000;
            return aVar;
        }
    }
}
