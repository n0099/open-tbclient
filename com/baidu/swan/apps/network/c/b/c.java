package com.baidu.swan.apps.network.c.b;

import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import kotlin.h;
import org.json.JSONObject;
@h
/* loaded from: classes11.dex */
public final class c extends b {
    private final boolean DEBUG;
    private final String TAG = "SwanAppPayCheckNode";

    @Override // com.baidu.swan.apps.network.c.b.b
    public void aR(JSONObject jSONObject) {
        e apN;
        com.baidu.swan.apps.setting.a apY;
        if (this.DEBUG) {
            Log.d(this.TAG, "onUpdate: ");
        }
        if (jSONObject == null || (apN = e.apN()) == null || (apY = apN.apY()) == null) {
            return;
        }
        apY.putString("note_data_pay_check_list", jSONObject.toString());
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void alS() {
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
