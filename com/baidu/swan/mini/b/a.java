package com.baidu.swan.mini.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String cZF;
    private com.baidu.swan.pms.b.a cZG;
    private String cZH;

    private a() {
    }

    @NonNull
    public static a bW(@Nullable JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cZF = jSONObject.optString("appInstanceId");
            aVar.cZG = com.baidu.swan.pms.b.a.bX(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("packageInfo");
            if (optJSONObject != null) {
                aVar.cZH = optJSONObject.optString("minCoreVersion");
            }
        }
        return aVar;
    }

    public boolean aBx() {
        return !TextUtils.isEmpty(this.cZF) && this.cZG.XL();
    }

    public String aBy() {
        return this.cZF;
    }

    @NonNull
    public com.baidu.swan.pms.b.a aBz() {
        return this.cZG;
    }

    public boolean bM(long j) {
        if (TextUtils.isEmpty(this.cZH)) {
            if (b.DEBUG) {
                Log.e("SwanMiniRuntime", "Param minCoreVersion is null");
            }
        } else {
            r0 = com.baidu.swan.apps.swancore.b.nB(this.cZH) <= j;
            if (b.DEBUG) {
                if (r0) {
                    Log.d("SwanMiniRuntime", "SwanCore version check OK, required: " + this.cZH + "; current: " + j);
                } else {
                    Log.e("SwanMiniRuntime", "SwanCore version not match, required: " + this.cZH + "; current: " + j);
                }
            }
        }
        return r0;
    }
}
