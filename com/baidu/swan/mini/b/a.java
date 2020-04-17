package com.baidu.swan.mini.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String cZA;
    private com.baidu.swan.pms.b.a cZB;
    private String cZC;

    private a() {
    }

    @NonNull
    public static a bW(@Nullable JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cZA = jSONObject.optString("appInstanceId");
            aVar.cZB = com.baidu.swan.pms.b.a.bX(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("packageInfo");
            if (optJSONObject != null) {
                aVar.cZC = optJSONObject.optString("minCoreVersion");
            }
        }
        return aVar;
    }

    public boolean aBx() {
        return !TextUtils.isEmpty(this.cZA) && this.cZB.XM();
    }

    public String aBy() {
        return this.cZA;
    }

    @NonNull
    public com.baidu.swan.pms.b.a aBz() {
        return this.cZB;
    }

    public boolean bM(long j) {
        if (TextUtils.isEmpty(this.cZC)) {
            if (b.DEBUG) {
                Log.e("SwanMiniRuntime", "Param minCoreVersion is null");
            }
        } else {
            r0 = com.baidu.swan.apps.swancore.b.nB(this.cZC) <= j;
            if (b.DEBUG) {
                if (r0) {
                    Log.d("SwanMiniRuntime", "SwanCore version check OK, required: " + this.cZC + "; current: " + j);
                } else {
                    Log.e("SwanMiniRuntime", "SwanCore version not match, required: " + this.cZC + "; current: " + j);
                }
            }
        }
        return r0;
    }
}
