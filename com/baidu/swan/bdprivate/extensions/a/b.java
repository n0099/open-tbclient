package com.baidu.swan.bdprivate.extensions.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.io.IOException;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.network.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public b(j jVar) {
        super(jVar, "/swanAPI/faceVerify");
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        } else if (eVar.ajS()) {
            if (DEBUG) {
                Log.d("FaceVerifyAction", "FaceVerifyAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is empty");
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "callback is empty");
                return false;
            }
            final String kW = com.baidu.swan.apps.api.module.network.c.kW(eVar.id);
            JSONObject kY = kY(kW);
            eVar.aIZ().a(context, "mapp_i_face_verify", com.baidu.swan.apps.setting.oauth.c.bY(optParamsAsJo), new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.bdprivate.extensions.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void N(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString);
                    } else {
                        b.f(kW, new com.baidu.swan.apps.ao.e.b<String>() { // from class: com.baidu.swan.bdprivate.extensions.a.b.1.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.ao.e.b
                            /* renamed from: onCallback */
                            public void N(String str) {
                                b.this.a(str, callbackHandler, optString, eVar);
                            }
                        });
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(kY, 0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final CallbackHandler callbackHandler, final String str2, com.baidu.swan.apps.runtime.e eVar) {
        if (str == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
        } else if (TextUtils.equals(str, "1") || TextUtils.equals(str, "0")) {
            a(str, eVar, new com.baidu.swan.apps.ao.e.b<String>() { // from class: com.baidu.swan.bdprivate.extensions.a.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: onCallback */
                public void N(String str3) {
                    callbackHandler.handleSchemeDispatchCallback(str2, str3);
                }
            });
        } else {
            callbackHandler.handleSchemeDispatchCallback(str2, str);
        }
    }

    public static void f(String str, com.baidu.swan.apps.ao.e.b<String> bVar) {
        Request uI = uI(str);
        if (uI == null) {
            bVar.N(null);
        } else {
            a(uI, bVar);
        }
    }

    private static void a(Request request, final com.baidu.swan.apps.ao.e.b<String> bVar) {
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a(request.url().toString(), request.body(), new ResponseCallback() { // from class: com.baidu.swan.bdprivate.extensions.a.b.3
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                b.a(response, com.baidu.swan.apps.ao.e.b.this);
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                com.baidu.swan.apps.ao.e.b.this.N(b.uH(exc == null ? "" : exc.getMessage()));
            }
        });
        aVar.tag = request.tag();
        aVar.evi = true;
        aVar.evj = true;
        aVar.evk = true;
        com.baidu.swan.a.c.a.bca().b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Response response, com.baidu.swan.apps.ao.e.b<String> bVar) {
        if (response == null) {
            bVar.N(uH("response is null"));
        } else if (!response.isSuccessful()) {
            bVar.N(uH("response code is error"));
        } else {
            ResponseBody body = response.body();
            if (body == null) {
                bVar.N(uH("body is null"));
                return;
            }
            String str = null;
            try {
                str = body.string();
            } catch (IOException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (DEBUG) {
                Log.d("FaceVerifyAction", "response body : " + str);
            }
            if (TextUtils.isEmpty(str)) {
                bVar.N(uH("body is null"));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) != 0) {
                    bVar.N(uH(jSONObject.optString(BaseJsonData.TAG_ERRMSG)));
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    bVar.N(uH("server data is null"));
                } else {
                    bVar.N(String.valueOf(optJSONObject.optInt("real_name")));
                }
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                bVar.N(uH("body format error"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String uH(String str) {
        com.baidu.swan.apps.console.c.i("FaceVerifyAction", str);
        return UnitedSchemeUtility.wrapCallbackParams(1001, str).toString();
    }

    public static void a(String str, com.baidu.swan.apps.runtime.e eVar, final com.baidu.swan.apps.ao.e.b<String> bVar) {
        com.baidu.swan.bdprivate.a.a.a(eVar.aIH(), str, eVar.id, new com.baidu.swan.apps.ao.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.extensions.a.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: B */
            public void N(Bundle bundle) {
                JSONObject wrapCallbackParams;
                if (bundle == null) {
                    com.baidu.swan.apps.ao.e.b.this.N(UnitedSchemeUtility.wrapCallbackParams(1001, "result is null").toString());
                    return;
                }
                String h = u.h(bundle, "callbackKey");
                if (TextUtils.isEmpty(h)) {
                    com.baidu.swan.apps.ao.e.b.this.N(UnitedSchemeUtility.wrapCallbackParams(1001, u.h(bundle, "failMsg")).toString());
                    return;
                }
                com.baidu.swan.apps.console.c.i("FaceVerifyAction", h);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("callbackKey", h);
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                } catch (JSONException e) {
                    if (b.DEBUG) {
                        e.printStackTrace();
                    }
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
                }
                com.baidu.swan.apps.ao.e.b.this.N(wrapCallbackParams.toString());
            }
        });
    }

    @Nullable
    private static Request uI(@Nullable String str) {
        HttpUrl parse = HttpUrl.parse(BaseUrlManager.ONLINE_URL);
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/realnamecheck");
        for (Map.Entry<String, String> entry : com.baidu.swan.apps.i.b.alC().cOi.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.tag(str);
        builder.post(new FormBody.Builder().build());
        builder.url(com.baidu.swan.apps.i.c.processCommonParams(build.toString()));
        return builder.build();
    }
}
