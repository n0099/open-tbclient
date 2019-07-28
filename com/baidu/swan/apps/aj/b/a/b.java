package com.baidu.swan.apps.aj.b.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aj.b.a;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class b extends z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(j jVar, String str) {
        super(jVar, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Context context, com.baidu.swan.apps.ae.b bVar, UnitedSchemeEntity unitedSchemeEntity) {
        if (bVar == null) {
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
    public JSONObject a(@NonNull a.C0115a c0115a) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("level", c0115a.level <= 100 ? c0115a.level : 100);
            jSONObject.put("isCharging", c0115a.aXl);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
