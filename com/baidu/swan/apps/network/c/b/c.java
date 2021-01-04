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
    public void r(JSONObject jSONObject, String str) {
        com.baidu.swan.apps.runtime.e aMl;
        com.baidu.swan.apps.setting.a aMw;
        if (this.DEBUG) {
            Log.d(this.TAG, "onUpdate: ");
        }
        if (jSONObject == null || (aMl = com.baidu.swan.apps.runtime.e.aMl()) == null || (aMw = aMl.aMw()) == null) {
            return;
        }
        aMw.putString("note_data_pay_check_list", jSONObject.toString());
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void aGN() {
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
