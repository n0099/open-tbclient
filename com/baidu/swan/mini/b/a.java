package com.baidu.swan.mini.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private String cwg;
    private com.baidu.swan.pms.b.a cwh;
    private String cwi;

    private a() {
    }

    @NonNull
    public static a bL(@Nullable JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cwg = jSONObject.optString("appInstanceId");
            aVar.cwh = com.baidu.swan.pms.b.a.bM(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("packageInfo");
            if (optJSONObject != null) {
                aVar.cwi = optJSONObject.optString("minCoreVersion");
            }
        }
        return aVar;
    }

    public boolean aqB() {
        return !TextUtils.isEmpty(this.cwg) && this.cwh.Ni();
    }

    public String aqC() {
        return this.cwg;
    }

    @NonNull
    public com.baidu.swan.pms.b.a aqD() {
        return this.cwh;
    }

    public boolean ba(long j) {
        if (TextUtils.isEmpty(this.cwi)) {
            if (b.DEBUG) {
                Log.e("SwanMiniRuntime", "Param minCoreVersion is null");
            }
        } else {
            r0 = com.baidu.swan.apps.swancore.b.lX(this.cwi) <= j;
            if (b.DEBUG) {
                if (r0) {
                    Log.d("SwanMiniRuntime", "SwanCore version check OK, required: " + this.cwi + "; current: " + j);
                } else {
                    Log.e("SwanMiniRuntime", "SwanCore version not match, required: " + this.cwi + "; current: " + j);
                }
            }
        }
        return r0;
    }
}
