package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidubce.AbstractBceClient;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f extends ab {
    public f(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/navigateToProgram");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar.GS()) {
            if (DEBUG) {
                Log.d("NavigateToSmartProgram", "NavigateToSmartProgram does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            String ZU = com.baidu.swan.apps.runtime.e.ZU();
            if (TextUtils.isEmpty(ZU) || TextUtils.isEmpty(ZU.trim())) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            Request g = g(ZU, optParamsAsJo);
            if (g == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            eVar.aae().a(g, new Callback() { // from class: com.baidu.swan.apps.scheme.actions.k.f.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    try {
                        JSONObject jSONObject = new JSONObject(response.body().string());
                        if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                        } else {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                Uri lc = f.this.lc(optJSONObject.optString(SuspensionBallEntity.KEY_SCHEME));
                                if (lc == null) {
                                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                                } else {
                                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(SchemeRouter.invokeScheme(context, lc, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE) ? 0 : 1001).toString());
                                }
                            } else {
                                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                            }
                        }
                    } catch (Exception e) {
                        if (f.DEBUG) {
                            Log.d("NavigateToSmartProgram", e.getMessage());
                        }
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    private Request g(String str, JSONObject jSONObject) {
        Request request = null;
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            String d = com.baidu.swan.apps.model.b.d(ai.aeB());
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("app_key", str);
                jSONObject2.put("srcAppPage", d);
                jSONObject2.put("params", jSONObject);
                String FG = com.baidu.swan.apps.w.a.Rw().FG();
                request = new Request.Builder().url(FG).post(FormBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject2.toString())).build();
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

    /* JADX INFO: Access modifiers changed from: private */
    public Uri lc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.parse(str);
    }
}
