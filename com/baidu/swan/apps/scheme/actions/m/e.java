package com.baidu.swan.apps.scheme.actions.m;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class e extends aa {
    public e(j jVar, String str) {
        super(jVar, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final CallbackHandler callbackHandler, SwanAppSlaveManager swanAppSlaveManager, final d dVar) {
        swanAppSlaveManager.b(new com.baidu.swan.apps.core.f.d() { // from class: com.baidu.swan.apps.scheme.actions.m.e.1
            @Override // com.baidu.swan.apps.core.f.d
            public void iJ(String str) {
            }

            @Override // com.baidu.swan.apps.core.f.d
            public void goBack() {
            }

            @Override // com.baidu.swan.apps.core.f.d
            public boolean iK(String str) {
                if (e.this.d(str, dVar.dvc)) {
                    e.this.a(str, callbackHandler, dVar.callback);
                    return true;
                }
                return false;
            }

            @Override // com.baidu.swan.apps.core.f.d
            public void hP(String str) {
            }

            @Override // com.baidu.swan.apps.core.f.d
            public void e(int i, String str, String str2) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, CallbackHandler callbackHandler, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return false;
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }
}
