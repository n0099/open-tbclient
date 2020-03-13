package com.baidu.swan.mini.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String cAr;
    private com.baidu.swan.pms.b.a cAs;
    private String cAt;

    private a() {
    }

    @NonNull
    public static a bL(@Nullable JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cAr = jSONObject.optString("appInstanceId");
            aVar.cAs = com.baidu.swan.pms.b.a.bM(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("packageInfo");
            if (optJSONObject != null) {
                aVar.cAt = optJSONObject.optString("minCoreVersion");
            }
        }
        return aVar;
    }

    public boolean atk() {
        return !TextUtils.isEmpty(this.cAr) && this.cAs.PU();
    }

    public String atl() {
        return this.cAr;
    }

    @NonNull
    public com.baidu.swan.pms.b.a atm() {
        return this.cAs;
    }

    public boolean bh(long j) {
        if (TextUtils.isEmpty(this.cAt)) {
            if (b.DEBUG) {
                Log.e("SwanMiniRuntime", "Param minCoreVersion is null");
            }
        } else {
            r0 = com.baidu.swan.apps.swancore.b.mp(this.cAt) <= j;
            if (b.DEBUG) {
                if (r0) {
                    Log.d("SwanMiniRuntime", "SwanCore version check OK, required: " + this.cAt + "; current: " + j);
                } else {
                    Log.e("SwanMiniRuntime", "SwanCore version not match, required: " + this.cAt + "; current: " + j);
                }
            }
        }
        return r0;
    }
}
