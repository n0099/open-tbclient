package com.baidu.swan.mini.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String cAC;
    private com.baidu.swan.pms.b.a cAD;
    private String cAE;

    private a() {
    }

    @NonNull
    public static a bL(@Nullable JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cAC = jSONObject.optString("appInstanceId");
            aVar.cAD = com.baidu.swan.pms.b.a.bM(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("packageInfo");
            if (optJSONObject != null) {
                aVar.cAE = optJSONObject.optString("minCoreVersion");
            }
        }
        return aVar;
    }

    public boolean atn() {
        return !TextUtils.isEmpty(this.cAC) && this.cAD.PX();
    }

    public String ato() {
        return this.cAC;
    }

    @NonNull
    public com.baidu.swan.pms.b.a atp() {
        return this.cAD;
    }

    public boolean bh(long j) {
        if (TextUtils.isEmpty(this.cAE)) {
            if (b.DEBUG) {
                Log.e("SwanMiniRuntime", "Param minCoreVersion is null");
            }
        } else {
            r0 = com.baidu.swan.apps.swancore.b.mo(this.cAE) <= j;
            if (b.DEBUG) {
                if (r0) {
                    Log.d("SwanMiniRuntime", "SwanCore version check OK, required: " + this.cAE + "; current: " + j);
                } else {
                    Log.e("SwanMiniRuntime", "SwanCore version not match, required: " + this.cAE + "; current: " + j);
                }
            }
        }
        return r0;
    }
}
