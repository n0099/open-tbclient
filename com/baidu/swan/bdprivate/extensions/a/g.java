package com.baidu.swan.bdprivate.extensions.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends aa {
    private int dGE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        void ce(JSONObject jSONObject);
    }

    public g(j jVar) {
        super(jVar, "/swanAPI/privateGetUserInfo");
        this.dGE = -1;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        try {
            a(context, callbackHandler, eVar, optString);
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private void a(Context context, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar, final String str) throws JSONException {
        String cZ = com.baidu.swan.bdprivate.a.a.cZ(context);
        if (TextUtils.isEmpty(com.baidu.swan.bdprivate.a.a.cY(context)) || TextUtils.isEmpty(cZ)) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(10003).toString());
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        com.baidu.swan.bdprivate.a.aa di = com.baidu.swan.bdprivate.a.a.di(context);
        jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, di.displayName);
        jSONObject.put("portrait", di.bfc);
        if (this.dGE != -1) {
            a(callbackHandler, str, jSONObject);
        } else {
            a(new a() { // from class: com.baidu.swan.bdprivate.extensions.a.g.1
                @Override // com.baidu.swan.bdprivate.extensions.a.g.a
                public void ce(JSONObject jSONObject2) {
                    if (jSONObject2 == null) {
                        g.this.a(callbackHandler, str, jSONObject);
                        return;
                    }
                    g.this.dGE = g.this.cd(jSONObject2);
                    g.this.a(callbackHandler, str, jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        if (this.dGE != -1) {
            try {
                jSONObject.put("gender", String.valueOf(this.dGE));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cd(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONObject == null) {
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    optJSONObject = optJSONArray.getJSONObject(0);
                } else {
                    if (DEBUG) {
                        Log.d("BaseJsonData", "Invalid data field!");
                    }
                    optJSONObject = null;
                }
            }
            if (optJSONObject == null || (jSONObject2 = optJSONObject.getJSONObject("userx")) == null || (jSONObject3 = jSONObject2.getJSONObject(Config.EVENT_ATTR)) == null || (jSONObject4 = jSONObject3.getJSONObject("dataset")) == null) {
                return -1;
            }
            return jSONObject4.optInt("gender");
        } catch (JSONException e) {
            return -1;
        }
    }

    private void a(final a aVar) {
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gender", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(com.baidu.swan.apps.i.c.processCommonParams(com.baidu.swan.apps.i.a.akA()))).addParam("data", jSONObject.toString()).cookieManager(com.baidu.swan.apps.t.a.awr().ahB())).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.bdprivate.extensions.a.g.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    try {
                        aVar.ce(new JSONObject(str));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        aVar.ce(null);
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    aVar.ce(null);
                }
            });
        }
    }
}
