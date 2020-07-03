package com.baidu.swan.bdprivate.d.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.ActionJsonData;
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
import com.baidu.swan.bdprivate.a.z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends aa {
    private int cSI;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public interface a {
        void bE(JSONObject jSONObject);
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/privateGetUserInfo");
        this.cSI = -1;
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
        String cJ = com.baidu.swan.bdprivate.a.a.cJ(context);
        if (TextUtils.isEmpty(com.baidu.swan.bdprivate.a.a.cI(context)) || TextUtils.isEmpty(cJ)) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(10003).toString());
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        z cS = com.baidu.swan.bdprivate.a.a.cS(context);
        jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, cS.displayName);
        jSONObject.put("portrait", cS.aRD);
        if (this.cSI != -1) {
            a(callbackHandler, str, jSONObject);
        } else {
            a(new a() { // from class: com.baidu.swan.bdprivate.d.a.f.1
                @Override // com.baidu.swan.bdprivate.d.a.f.a
                public void bE(JSONObject jSONObject2) {
                    if (jSONObject2 == null) {
                        f.this.a(callbackHandler, str, jSONObject);
                        return;
                    }
                    f.this.cSI = f.this.bD(jSONObject2);
                    f.this.a(callbackHandler, str, jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        if (this.cSI != -1) {
            try {
                jSONObject.put("gender", String.valueOf(this.cSI));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bD(JSONObject jSONObject) {
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
            if (optJSONObject == null || (jSONObject2 = optJSONObject.getJSONObject("userx")) == null || (jSONObject3 = jSONObject2.getJSONObject(Config.EVENT_ATTR)) == null || (jSONObject4 = jSONObject3.getJSONObject(ActionJsonData.TAG_DATASET)) == null) {
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
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(com.baidu.swan.apps.h.c.processCommonParams(com.baidu.swan.apps.h.a.WH()))).addParam("data", jSONObject.toString()).cookieManager(com.baidu.swan.apps.u.a.agu().TS())).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.bdprivate.d.a.f.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    try {
                        aVar.bE(new JSONObject(str));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        aVar.bE(null);
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    aVar.bE(null);
                }
            });
        }
    }
}
