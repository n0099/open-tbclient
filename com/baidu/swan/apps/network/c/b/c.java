package com.baidu.swan.apps.network.c.b;

import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import kotlin.h;
import org.json.JSONObject;
@h
/* loaded from: classes8.dex */
public final class c extends b {
    private final boolean DEBUG;
    private final String TAG = "SwanAppPayCheckNode";

    @Override // com.baidu.swan.apps.network.c.b.b
    public void u(JSONObject jSONObject, String str) {
        e azJ;
        com.baidu.swan.apps.setting.a azU;
        if (this.DEBUG) {
            Log.d(this.TAG, "onUpdate: ");
        }
        if (jSONObject == null || (azJ = e.azJ()) == null || (azU = azJ.azU()) == null) {
            return;
        }
        azU.putString("note_data_pay_check_list", jSONObject.toString());
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void ave() {
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
