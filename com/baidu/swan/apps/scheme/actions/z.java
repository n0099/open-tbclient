package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.t.b.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class z extends aa {
    public z(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/share");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (context == null || eVar == null) {
            com.baidu.swan.apps.console.c.e("Share", "context or swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "system error");
            return false;
        } else if (eVar.abL()) {
            if (DEBUG) {
                Log.d("ShareAction", "ShareAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            final JSONObject b = b(unitedSchemeEntity, "params");
            if (b == null) {
                com.baidu.swan.apps.console.c.e("Share", "params invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                return false;
            }
            final String optString = b.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.swan.apps.console.c.e("Share", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                return false;
            }
            try {
                b.put("iconUrl", b.optString("imageUrl", ""));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("ShareAction", e.toString());
                }
            }
            eVar.azU().e("mapp_i_share_update_weburl", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.scheme.actions.z.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: c */
                public void I(com.baidu.swan.apps.setting.oauth.e eVar2) {
                    String str = "";
                    if (eVar2 != null && !eVar2.forbidden && eVar2.cVo == 1 && !TextUtils.isEmpty(eVar2.cVs.optString("web_url"))) {
                        String optString2 = eVar2.cVs.optString("web_url");
                        String optString3 = b.optString("path");
                        if (!TextUtils.isEmpty(optString3)) {
                            if (!optString2.endsWith("/")) {
                                optString2 = optString2 + "/";
                            }
                            if (optString3.startsWith("/")) {
                                optString3 = optString3.substring(1);
                            }
                            optString2 = optString2 + optString3;
                        }
                        str = ai.addParam(ai.addParam(optString2, "_swebfr", "1"), "hostname", com.baidu.swan.apps.t.a.apw().getHostName());
                    }
                    String h = (ak.aFn() || !TextUtils.isEmpty(str)) ? str : com.baidu.swan.config.c.c.aHc().h(eVar.getAppKey(), eVar.XP(), b.optString("path"));
                    if (aa.DEBUG) {
                        Log.d("ShareAction", "final share url is " + h);
                    }
                    z.this.a(h, context, optString, callbackHandler, b, eVar);
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, @NonNull final Context context, @NonNull final String str2, @NonNull final CallbackHandler callbackHandler, @NonNull final JSONObject jSONObject, @NonNull com.baidu.swan.apps.runtime.e eVar) {
        String optString = jSONObject.optString("shareUrl");
        JSONArray optJSONArray = jSONObject.optJSONArray("pannel");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("defaultPannel");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            if (optJSONArray2 != null) {
                try {
                    if (optJSONArray2.length() > 0) {
                        jSONObject.put("pannel", optJSONArray2);
                    }
                } catch (JSONException e) {
                    if (DEBUG) {
                        Log.d("ShareAction", e.toString());
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("linkUrl", str);
            }
            if (TextUtils.isEmpty(optString)) {
                a(context, callbackHandler, str2, jSONObject);
                return;
            } else if (ai.isBaiduDomain(optString)) {
                jSONObject.put("linkUrl", optString);
                a(context, callbackHandler, str2, jSONObject);
                return;
            }
        }
        eVar.azU().b(context, "mapp_i_share_update_linkurl", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.z.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void I(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                z.this.a(context, callbackHandler, str2, jSONObject, com.baidu.swan.apps.setting.oauth.c.b(hVar), str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Context context, CallbackHandler callbackHandler, String str, @NonNull JSONObject jSONObject, boolean z, String str2) {
        String optString = jSONObject.optString("shareUrl");
        JSONArray optJSONArray = jSONObject.optJSONArray("defaultPannel");
        try {
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("linkUrl", str2);
            }
            if (!TextUtils.isEmpty(optString) && (ai.isBaiduDomain(optString) || z)) {
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
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ != null) {
            String aqN = azJ.azM().aqN();
            JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
            if (optJSONObject != null) {
                com.baidu.swan.apps.ap.v.b(optJSONObject, "source", aqN);
            } else {
                com.baidu.swan.apps.ap.v.b(jSONObject, "categoryInfo", com.baidu.swan.apps.ap.v.b(null, "source", aqN));
            }
        }
        com.baidu.swan.apps.t.a.aoK().a(context, jSONObject, new i.a() { // from class: com.baidu.swan.apps.scheme.actions.z.3
            @Override // com.baidu.swan.apps.t.b.i.a
            public void aqo() {
                z.this.a(callbackHandler, str, true);
            }

            @Override // com.baidu.swan.apps.t.b.i.a
            public void aqp() {
                z.this.a(callbackHandler, str, false);
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
