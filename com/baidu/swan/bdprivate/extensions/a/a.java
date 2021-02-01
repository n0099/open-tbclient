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
import com.baidu.swan.apps.scheme.j;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.apps.network.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public a(j jVar) {
        super(jVar, "/swanAPI/faceResultVerify");
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        }
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
        final String optString2 = optParamsAsJo.optString("callbackKey");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "callbackKey is empty");
            return false;
        } else if (!eVar.aIX().isLogin(context)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in");
            return false;
        } else {
            final String kP = com.baidu.swan.apps.api.module.network.c.kP(eVar.id);
            JSONObject kR = kR(kP);
            com.baidu.swan.bdprivate.a.a.a(eVar.aIE(), new com.baidu.swan.apps.ao.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.extensions.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: B */
                public void L(Bundle bundle) {
                    if (bundle != null && !TextUtils.isEmpty(bundle.getString("dev"))) {
                        String string = bundle.getString("dev");
                        if (a.DEBUG) {
                            Log.d("FaceResultVerifyAction", "stoken=" + string);
                        }
                        a.this.a(optString2, string, kP, optString, callbackHandler, eVar);
                        return;
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, "stoken is null").toString());
                }
            }, "dev");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(kR, 0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("callbackkey", str);
            jSONObject.put("client_id", eVar.id);
            jSONObject2.put("stoken", str2);
            jSONObject2.put("app_key", eVar.getAppKey());
            jSONObject2.put("host_pkgname", com.baidu.swan.apps.setting.oauth.c.getAppContext().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        hashMap.put("data", jSONObject.toString());
        Request f = f(str3, hashMap);
        if (f == null) {
            callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
        } else {
            a(f, str4, callbackHandler);
        }
    }

    private void a(Request request, final String str, final CallbackHandler callbackHandler) {
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a(request.url().toString(), request.body(), new ResponseCallback() { // from class: com.baidu.swan.bdprivate.extensions.a.a.2
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                a.this.a(response, str, callbackHandler);
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                a.this.b(exc == null ? "" : exc.getMessage(), str, callbackHandler);
            }
        });
        aVar.tag = request.tag();
        aVar.etH = true;
        aVar.etI = true;
        aVar.etJ = true;
        com.baidu.swan.a.c.a.bbY().b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Response response, String str, CallbackHandler callbackHandler) {
        if (response == null) {
            b("response is null", str, callbackHandler);
        } else if (!response.isSuccessful()) {
            b("response code is error", str, callbackHandler);
        } else {
            ResponseBody body = response.body();
            if (body == null) {
                b("body is null", str, callbackHandler);
                return;
            }
            String str2 = null;
            try {
                str2 = body.string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (DEBUG) {
                Log.d("FaceResultVerifyAction", "response body : " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                b("body is null", str, callbackHandler);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) != 0) {
                    b(jSONObject.optString(BaseJsonData.TAG_ERRMSG), str, callbackHandler);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    b("server data is null", str, callbackHandler);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0).toString());
                }
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                b("body format error", str, callbackHandler);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, CallbackHandler callbackHandler) {
        com.baidu.swan.apps.console.c.i("FaceResultVerifyAction", str);
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
    }

    @Nullable
    private Request f(@Nullable String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(BaseUrlManager.ONLINE_URL);
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/facecheck");
        for (Map.Entry<String, String> entry : com.baidu.swan.apps.i.b.alz().cMI.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.tag(str);
        if (map != null) {
            builder.post(com.baidu.swan.apps.setting.oauth.c.D(map));
        }
        builder.url(com.baidu.swan.apps.i.c.processCommonParams(build.toString()));
        return builder.build();
    }
}
