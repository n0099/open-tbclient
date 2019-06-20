package com.baidu.swan.apps.scheme.actions;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.u.b.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class y extends z {
    public y(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/share");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (context == null || bVar == null) {
            com.baidu.swan.apps.console.c.e("Share", "context or swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "system error");
            return false;
        }
        final JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            com.baidu.swan.apps.console.c.e("Share", "params invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
            return false;
        }
        final String optString = c.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Share", "cb is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
            return false;
        }
        try {
            c.put("iconUrl", c.optString("imageUrl", ""));
            c.remove("imageUrl");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("ShareAction", e.toString());
            }
        }
        String optString2 = c.optString("shareUrl");
        JSONArray optJSONArray = c.optJSONArray("pannel");
        JSONArray optJSONArray2 = c.optJSONArray("defaultPannel");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            if (optJSONArray2 != null) {
                try {
                    if (optJSONArray2.length() > 0) {
                        c.put("pannel", optJSONArray2);
                    }
                } catch (JSONException e2) {
                    if (DEBUG) {
                        Log.d("ShareAction", e2.toString());
                    }
                }
            }
            if (TextUtils.isEmpty(optString2)) {
                a(context, callbackHandler, optString, c);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            } else if (com.baidu.swan.apps.an.aa.ii(optString2)) {
                c.put("linkUrl", optString2);
                a(context, callbackHandler, optString, c);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        bVar.Lu().a((Activity) context, "mapp_i_share_update_linkurl", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.apps.scheme.actions.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: b */
            public void D(Boolean bool) {
                y.this.a(context, callbackHandler, optString, c, bool.booleanValue());
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Context context, CallbackHandler callbackHandler, String str, @NonNull JSONObject jSONObject, boolean z) {
        String optString = jSONObject.optString("shareUrl");
        JSONArray optJSONArray = jSONObject.optJSONArray("defaultPannel");
        try {
            if (!TextUtils.isEmpty(optString) && (com.baidu.swan.apps.an.aa.ii(optString) || z)) {
                jSONObject.put("linkUrl", optString);
            }
            if (optJSONArray != null && optJSONArray.length() > 0 && !z) {
                jSONObject.put("pannel", optJSONArray);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("ShareAction", e.toString());
            }
        }
        a(context, callbackHandler, str, jSONObject);
    }

    private void a(@NonNull Context context, final CallbackHandler callbackHandler, final String str, JSONObject jSONObject) {
        jSONObject.remove("defaultPannel");
        jSONObject.remove("shareUrl");
        com.baidu.swan.apps.u.a.DC().a(context, jSONObject, new u.a() { // from class: com.baidu.swan.apps.scheme.actions.y.2
            @Override // com.baidu.swan.apps.u.b.u.a
            public void EA() {
                y.this.a(callbackHandler, str, true);
            }

            @Override // com.baidu.swan.apps.u.b.u.a
            public void EB() {
                y.this.a(callbackHandler, str, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CallbackHandler callbackHandler, String str, boolean z) {
        if (callbackHandler != null && !TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", z);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("ShareAction", e.toString());
                }
            }
            int i = z ? 0 : 1001;
            com.baidu.swan.apps.console.c.i("Share", "result=" + z);
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i).toString());
        }
    }
}
