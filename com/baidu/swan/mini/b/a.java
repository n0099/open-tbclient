package com.baidu.swan.mini.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private String cwr;
    private com.baidu.swan.pms.b.a cws;
    private String cwt;

    private a() {
    }

    @NonNull
    public static a bL(@Nullable JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cwr = jSONObject.optString("appInstanceId");
            aVar.cws = com.baidu.swan.pms.b.a.bM(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("packageInfo");
            if (optJSONObject != null) {
                aVar.cwt = optJSONObject.optString("minCoreVersion");
            }
        }
        return aVar;
    }

    public boolean aqU() {
        return !TextUtils.isEmpty(this.cwr) && this.cws.NE();
    }

    public String aqV() {
        return this.cwr;
    }

    @NonNull
    public com.baidu.swan.pms.b.a aqW() {
        return this.cws;
    }

    public boolean bd(long j) {
        if (TextUtils.isEmpty(this.cwt)) {
            if (b.DEBUG) {
                Log.e("SwanMiniRuntime", "Param minCoreVersion is null");
            }
        } else {
            r0 = com.baidu.swan.apps.swancore.b.ma(this.cwt) <= j;
            if (b.DEBUG) {
                if (r0) {
                    Log.d("SwanMiniRuntime", "SwanCore version check OK, required: " + this.cwt + "; current: " + j);
                } else {
                    Log.e("SwanMiniRuntime", "SwanCore version not match, required: " + this.cwt + "; current: " + j);
                }
            }
        }
        return r0;
    }
}
