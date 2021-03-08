package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes8.dex */
    public static class a {
        public int dGm;
        public int dGn;
        public int dGo;
        public int dGp;

        public static a bB(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aJz();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aJz();
            }
            a aVar = new a();
            aVar.dGm = optJSONObject.optInt("request", com.baidu.swan.apps.t.a.axc().agH());
            aVar.dGn = optJSONObject.optInt("connectSocket", 60000);
            aVar.dGo = optJSONObject.optInt("uploadFile");
            aVar.dGp = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aJz() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.dGm = 60000;
            aVar.dGn = 60000;
            return aVar;
        }
    }
}
