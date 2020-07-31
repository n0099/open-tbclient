package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes7.dex */
    public static class a {
        public int cHO;
        public int cHP;
        public int cHQ;
        public int cHR;

        public static a aY(JSONObject jSONObject) {
            if (jSONObject == null) {
                return ash();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return ash();
            }
            a aVar = new a();
            aVar.cHO = optJSONObject.optInt("request", com.baidu.swan.apps.t.a.ahm().SH());
            aVar.cHP = optJSONObject.optInt("connectSocket", 60000);
            aVar.cHQ = optJSONObject.optInt("uploadFile");
            aVar.cHR = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a ash() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.cHO = 60000;
            aVar.cHP = 60000;
            return aVar;
        }
    }
}
