package com.baidu.swan.mini.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private String dvl;
    private com.baidu.swan.pms.b.a dvm;
    private String dvn;

    private a() {
    }

    @NonNull
    public static a ck(@Nullable JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.dvl = jSONObject.optString("appInstanceId");
            aVar.dvm = com.baidu.swan.pms.b.a.cl(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("packageInfo");
            if (optJSONObject != null) {
                aVar.dvn = optJSONObject.optString("minCoreVersion");
            }
        }
        return aVar;
    }

    public boolean aKm() {
        return !TextUtils.isEmpty(this.dvl) && this.dvm.acP();
    }

    public String aKn() {
        return this.dvl;
    }

    @NonNull
    public com.baidu.swan.pms.b.a aKo() {
        return this.dvm;
    }

    public boolean bY(long j) {
        if (TextUtils.isEmpty(this.dvn)) {
            if (b.DEBUG) {
                Log.e("SwanMiniRuntime", "Param minCoreVersion is null");
            }
        } else {
            r0 = com.baidu.swan.apps.swancore.b.qb(this.dvn) <= j;
            if (b.DEBUG) {
                if (r0) {
                    Log.d("SwanMiniRuntime", "SwanCore version check OK, required: " + this.dvn + "; current: " + j);
                } else {
                    Log.e("SwanMiniRuntime", "SwanCore version not match, required: " + this.dvn + "; current: " + j);
                }
            }
        }
        return r0;
    }
}
