package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes11.dex */
    public static class a {
        public int bPA;
        public int bPB;
        public int bPC;
        public int bPz;

        public static a ay(JSONObject jSONObject) {
            if (jSONObject == null) {
                return adq();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return adq();
            }
            a aVar = new a();
            aVar.bPz = optJSONObject.optInt("request", 60000);
            aVar.bPA = optJSONObject.optInt("connectSocket", 60000);
            aVar.bPB = optJSONObject.optInt("uploadFile");
            aVar.bPC = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a adq() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.bPz = 60000;
            aVar.bPA = 60000;
            return aVar;
        }
    }
}
