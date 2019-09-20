package com.baidu.swan.apps.ae.a;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes2.dex */
    public static class a {
        public int aRr;
        public int aRs;
        public int aRt;
        public int aRu;

        public static a M(JSONObject jSONObject) {
            if (jSONObject == null) {
                return MA();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return MA();
            }
            a aVar = new a();
            aVar.aRr = optJSONObject.optInt("request", 60000);
            aVar.aRs = optJSONObject.optInt("connectSocket", 60000);
            aVar.aRt = optJSONObject.optInt("uploadFile");
            aVar.aRu = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a MA() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.aRr = 60000;
            aVar.aRs = 60000;
            return aVar;
        }
    }
}
