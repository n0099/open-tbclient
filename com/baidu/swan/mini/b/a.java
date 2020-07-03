package com.baidu.swan.mini.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String dpu;
    private com.baidu.swan.pms.b.a dpv;
    private String dpw;

    private a() {
    }

    @NonNull
    public static a ce(@Nullable JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.dpu = jSONObject.optString("appInstanceId");
            aVar.dpv = com.baidu.swan.pms.b.a.cf(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("packageInfo");
            if (optJSONObject != null) {
                aVar.dpw = optJSONObject.optString("minCoreVersion");
            }
        }
        return aVar;
    }

    public boolean aGv() {
        return !TextUtils.isEmpty(this.dpu) && this.dpv.abL();
    }

    public String aGw() {
        return this.dpu;
    }

    @NonNull
    public com.baidu.swan.pms.b.a aGx() {
        return this.dpv;
    }

    public boolean bK(long j) {
        if (TextUtils.isEmpty(this.dpw)) {
            if (b.DEBUG) {
                Log.e("SwanMiniRuntime", "Param minCoreVersion is null");
            }
        } else {
            r0 = com.baidu.swan.apps.swancore.b.pq(this.dpw) <= j;
            if (b.DEBUG) {
                if (r0) {
                    Log.d("SwanMiniRuntime", "SwanCore version check OK, required: " + this.dpw + "; current: " + j);
                } else {
                    Log.e("SwanMiniRuntime", "SwanCore version not match, required: " + this.dpw + "; current: " + j);
                }
            }
        }
        return r0;
    }
}
