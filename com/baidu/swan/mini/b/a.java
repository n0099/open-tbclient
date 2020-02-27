package com.baidu.swan.mini.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String cAp;
    private com.baidu.swan.pms.b.a cAq;
    private String cAr;

    private a() {
    }

    @NonNull
    public static a bL(@Nullable JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cAp = jSONObject.optString("appInstanceId");
            aVar.cAq = com.baidu.swan.pms.b.a.bM(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("packageInfo");
            if (optJSONObject != null) {
                aVar.cAr = optJSONObject.optString("minCoreVersion");
            }
        }
        return aVar;
    }

    public boolean ati() {
        return !TextUtils.isEmpty(this.cAp) && this.cAq.PS();
    }

    public String atj() {
        return this.cAp;
    }

    @NonNull
    public com.baidu.swan.pms.b.a atk() {
        return this.cAq;
    }

    public boolean bh(long j) {
        if (TextUtils.isEmpty(this.cAr)) {
            if (b.DEBUG) {
                Log.e("SwanMiniRuntime", "Param minCoreVersion is null");
            }
        } else {
            r0 = com.baidu.swan.apps.swancore.b.mp(this.cAr) <= j;
            if (b.DEBUG) {
                if (r0) {
                    Log.d("SwanMiniRuntime", "SwanCore version check OK, required: " + this.cAr + "; current: " + j);
                } else {
                    Log.e("SwanMiniRuntime", "SwanCore version not match, required: " + this.cAr + "; current: " + j);
                }
            }
        }
        return r0;
    }
}
