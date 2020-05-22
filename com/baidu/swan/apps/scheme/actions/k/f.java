package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidubce.AbstractBceClient;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends aa {
    public f(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/navigateToProgram");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar.TU()) {
            if (DEBUG) {
                Log.d("NavigateToSmartProgram", "NavigateToSmartProgram does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            String aoH = com.baidu.swan.apps.runtime.e.aoH();
            if (TextUtils.isEmpty(aoH) || TextUtils.isEmpty(aoH.trim())) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            Request h = h(aoH, optParamsAsJo);
            if (h == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            a(h.body(), unitedSchemeEntity, optString, callbackHandler, eVar);
            return true;
        }
    }

    private void a(RequestBody requestBody, UnitedSchemeEntity unitedSchemeEntity, final String str, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.c.b.a aVar = new com.baidu.swan.c.b.a(com.baidu.swan.apps.u.a.afd().SL(), requestBody, new ResponseCallback() { // from class: com.baidu.swan.apps.scheme.actions.k.f.1
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                f.this.a(response, str, callbackHandler, eVar);
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        });
        aVar.dld = true;
        aVar.dle = false;
        aVar.dlf = true;
        com.baidu.swan.c.c.a.aFx().b(aVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Response response, String str, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        try {
            JSONObject jSONObject = new JSONObject(response.body().string());
            if (!TextUtils.equals(jSONObject.optString(BaseJsonData.TAG_ERRNO), "0")) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
            } else {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                } else {
                    Uri og = og(optJSONObject.optString(SuspensionBallEntity.KEY_SCHEME));
                    if (og == null) {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(SchemeRouter.invokeScheme(eVar.getApplicationContext(), og, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE) ? 0 : 1001).toString());
                    }
                }
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("NavigateToSmartProgram", e.getMessage());
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
        }
    }

    private Request h(String str, JSONObject jSONObject) {
        Request request = null;
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            String d = com.baidu.swan.apps.model.b.d(aj.atU());
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("app_key", str);
                jSONObject2.put("srcAppPage", d);
                jSONObject2.put("params", jSONObject);
                String SL = com.baidu.swan.apps.u.a.afd().SL();
                request = new Request.Builder().url(SL).post(FormBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject2.toString())).build();
                if (DEBUG) {
                    Log.i("NavigateToSmartProgram", "appId :" + str + "\nrequest params" + jSONObject2.toString());
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return request;
    }

    private Uri og(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        String schemeHead = SchemeConfig.getSchemeHead();
        if (TextUtils.isEmpty(schemeHead)) {
            schemeHead = "baiduboxapp";
        }
        buildUpon.scheme(schemeHead);
        if (DEBUG) {
            Log.i("NavigateToSmartProgram", buildUpon.build().toString());
        }
        return buildUpon.build();
    }
}
