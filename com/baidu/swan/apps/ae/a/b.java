package com.baidu.swan.apps.ae.a;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;

    /* loaded from: classes2.dex */
    public static class a {
        public int aOb;
        public int aOc;
        public int aOd;
        public int aOe;

        public static a N(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Jp();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return Jp();
            }
            a aVar = new a();
            aVar.aOb = optJSONObject.optInt("request", 60000);
            aVar.aOc = optJSONObject.optInt("connectSocket", 60000);
            aVar.aOd = optJSONObject.optInt("uploadFile");
            aVar.aOe = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a Jp() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.aOb = 60000;
            aVar.aOc = 60000;
            return aVar;
        }
    }
}
