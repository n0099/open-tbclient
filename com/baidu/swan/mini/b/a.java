package com.baidu.swan.mini.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String cAq;
    private com.baidu.swan.pms.b.a cAr;
    private String cAs;

    private a() {
    }

    @NonNull
    public static a bL(@Nullable JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cAq = jSONObject.optString("appInstanceId");
            aVar.cAr = com.baidu.swan.pms.b.a.bM(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("packageInfo");
            if (optJSONObject != null) {
                aVar.cAs = optJSONObject.optString("minCoreVersion");
            }
        }
        return aVar;
    }

    public boolean atk() {
        return !TextUtils.isEmpty(this.cAq) && this.cAr.PU();
    }

    public String atl() {
        return this.cAq;
    }

    @NonNull
    public com.baidu.swan.pms.b.a atm() {
        return this.cAr;
    }

    public boolean bh(long j) {
        if (TextUtils.isEmpty(this.cAs)) {
            if (b.DEBUG) {
                Log.e("SwanMiniRuntime", "Param minCoreVersion is null");
            }
        } else {
            r0 = com.baidu.swan.apps.swancore.b.mp(this.cAs) <= j;
            if (b.DEBUG) {
                if (r0) {
                    Log.d("SwanMiniRuntime", "SwanCore version check OK, required: " + this.cAs + "; current: " + j);
                } else {
                    Log.e("SwanMiniRuntime", "SwanCore version not match, required: " + this.cAs + "; current: " + j);
                }
            }
        }
        return r0;
    }
}
