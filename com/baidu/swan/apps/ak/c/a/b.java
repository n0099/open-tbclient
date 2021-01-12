package com.baidu.swan.apps.ak.c.a;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ak.c.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public abstract class b extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(j jVar, String str) {
        super(jVar, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Context context, e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("battery", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "getBatteryInfo --- illegal swanApp");
                return false;
            }
            return false;
        } else if (context == null) {
            com.baidu.swan.apps.console.c.e("battery", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (DEBUG) {
                Log.d("SwanAppAction", "getBatteryInfo --- illegal context");
                return false;
            }
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public JSONObject a(@NonNull a.C0361a c0361a) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("level", String.valueOf(c0361a.level <= 100 ? c0361a.level : 100));
            jSONObject.put("isCharging", c0361a.dKM);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
