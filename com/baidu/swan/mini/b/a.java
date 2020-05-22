package com.baidu.swan.mini.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String dkJ;
    private com.baidu.swan.pms.b.a dkK;
    private String dkL;

    private a() {
    }

    @NonNull
    public static a bX(@Nullable JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.dkJ = jSONObject.optString("appInstanceId");
            aVar.dkK = com.baidu.swan.pms.b.a.bY(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("packageInfo");
            if (optJSONObject != null) {
                aVar.dkL = optJSONObject.optString("minCoreVersion");
            }
        }
        return aVar;
    }

    public boolean aFp() {
        return !TextUtils.isEmpty(this.dkJ) && this.dkK.aaF();
    }

    public String aFq() {
        return this.dkJ;
    }

    @NonNull
    public com.baidu.swan.pms.b.a aFr() {
        return this.dkK;
    }

    public boolean bK(long j) {
        if (TextUtils.isEmpty(this.dkL)) {
            if (b.DEBUG) {
                Log.e("SwanMiniRuntime", "Param minCoreVersion is null");
            }
        } else {
            r0 = com.baidu.swan.apps.swancore.b.pi(this.dkL) <= j;
            if (b.DEBUG) {
                if (r0) {
                    Log.d("SwanMiniRuntime", "SwanCore version check OK, required: " + this.dkL + "; current: " + j);
                } else {
                    Log.e("SwanMiniRuntime", "SwanCore version not match, required: " + this.dkL + "; current: " + j);
                }
            }
        }
        return r0;
    }
}
