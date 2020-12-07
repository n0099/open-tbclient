package com.baidu.swan.apps.network.c.b;

import android.util.Log;
import kotlin.e;
import org.json.JSONObject;
@e
/* loaded from: classes25.dex */
public final class c extends b {
    private final boolean DEBUG;
    private final String TAG = "SwanAppPayCheckNode";

    @Override // com.baidu.swan.apps.network.c.b.b
    public void r(JSONObject jSONObject, String str) {
        com.baidu.swan.apps.runtime.e aJV;
        com.baidu.swan.apps.setting.a aKg;
        if (this.DEBUG) {
            Log.d(this.TAG, "onUpdate: ");
        }
        if (jSONObject == null || (aJV = com.baidu.swan.apps.runtime.e.aJV()) == null || (aKg = aJV.aKg()) == null) {
            return;
        }
        aKg.putString("note_data_pay_check_list", jSONObject.toString());
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void aFt() {
        if (this.DEBUG) {
            Log.d(this.TAG, "onFiltered: ");
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void onFail() {
        if (this.DEBUG) {
            Log.d(this.TAG, "onFail: ");
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public String getNodeName() {
        return "payinfo";
    }
}
