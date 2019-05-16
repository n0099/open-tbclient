package com.baidu.swan.apps.ae.a;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes2.dex */
    public static class a {
        public int aQj;
        public int aQk;
        public int aQl;
        public int aQm;

        public static a M(JSONObject jSONObject) {
            if (jSONObject == null) {
                return LI();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return LI();
            }
            a aVar = new a();
            aVar.aQj = optJSONObject.optInt("request", 60000);
            aVar.aQk = optJSONObject.optInt("connectSocket", 60000);
            aVar.aQl = optJSONObject.optInt("uploadFile");
            aVar.aQm = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a LI() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.aQj = 60000;
            aVar.aQk = 60000;
            return aVar;
        }
    }
}
