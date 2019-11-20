package com.baidu.swan.apps.ae.a;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes2.dex */
    public static class a {
        public int bkd;
        public int bke;
        public int bkf;
        public int bkg;

        public static a al(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Ru();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return Ru();
            }
            a aVar = new a();
            aVar.bkd = optJSONObject.optInt("request", 60000);
            aVar.bke = optJSONObject.optInt("connectSocket", 60000);
            aVar.bkf = optJSONObject.optInt("uploadFile");
            aVar.bkg = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a Ru() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.bkd = 60000;
            aVar.bke = 60000;
            return aVar;
        }
    }
}
