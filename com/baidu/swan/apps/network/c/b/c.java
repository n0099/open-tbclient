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
    public void av(JSONObject jSONObject) {
        e acJ;
        com.baidu.swan.apps.setting.a acS;
        if (this.DEBUG) {
            Log.d(this.TAG, "onUpdate: ");
        }
        if (jSONObject == null || (acJ = e.acJ()) == null || (acS = acJ.acS()) == null) {
            return;
        }
        acS.putString("note_data_pay_check_list", jSONObject.toString());
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void Zo() {
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
    public String Zn() {
        return "payinfo";
    }
}
