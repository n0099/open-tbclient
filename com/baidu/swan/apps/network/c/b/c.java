package com.baidu.swan.apps.network.c.b;

import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import kotlin.h;
import org.json.JSONObject;
@h
/* loaded from: classes3.dex */
public final class c extends b {
    private final boolean DEBUG;
    private final String TAG = "SwanAppPayCheckNode";

    @Override // com.baidu.swan.apps.network.c.b.b
    public void u(JSONObject jSONObject, String str) {
        e aAs;
        com.baidu.swan.apps.setting.a aAD;
        if (this.DEBUG) {
            Log.d(this.TAG, "onUpdate: ");
        }
        if (jSONObject == null || (aAs = e.aAs()) == null || (aAD = aAs.aAD()) == null) {
            return;
        }
        aAD.putString("note_data_pay_check_list", jSONObject.toString());
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void avN() {
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
