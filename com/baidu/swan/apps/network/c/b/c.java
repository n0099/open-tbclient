package com.baidu.swan.apps.network.c.b;

import android.util.Log;
import kotlin.e;
import org.json.JSONObject;
@e
/* loaded from: classes9.dex */
public final class c extends b {
    private final boolean DEBUG;
    private final String TAG = "SwanAppPayCheckNode";

    @Override // com.baidu.swan.apps.network.c.b.b
    public void q(JSONObject jSONObject, String str) {
        com.baidu.swan.apps.runtime.e aIL;
        com.baidu.swan.apps.setting.a aIW;
        if (this.DEBUG) {
            Log.d(this.TAG, "onUpdate: ");
        }
        if (jSONObject == null || (aIL = com.baidu.swan.apps.runtime.e.aIL()) == null || (aIW = aIL.aIW()) == null) {
            return;
        }
        aIW.putString("note_data_pay_check_list", jSONObject.toString());
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void aDq() {
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
