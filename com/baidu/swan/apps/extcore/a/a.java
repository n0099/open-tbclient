package com.baidu.swan.apps.extcore.a;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/publishThread");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("ExtCore-PublishThread", "handle: publishThread");
        }
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        final String optString = b.optString("data", "");
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(context, optString, 1).show();
            }
        });
        return true;
    }
}
