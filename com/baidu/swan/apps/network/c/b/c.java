package com.baidu.swan.apps.network.c.b;

import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c extends b {
    private final boolean DEBUG;
    private final String TAG = "SwanAppPayCheckNode";

    @Override // com.baidu.swan.apps.network.c.b.b
    public void av(JSONObject jSONObject) {
        e aaq;
        com.baidu.swan.apps.setting.a aaz;
        if (this.DEBUG) {
            Log.d(this.TAG, "onUpdate: ");
        }
        if (jSONObject == null || (aaq = e.aaq()) == null || (aaz = aaq.aaz()) == null) {
            return;
        }
        aaz.putString("note_data_pay_check_list", jSONObject.toString());
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void WV() {
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
    public String WU() {
        return "payinfo";
    }
}
