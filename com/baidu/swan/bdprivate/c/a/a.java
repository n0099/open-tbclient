package com.baidu.swan.bdprivate.c.a;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.j;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.apps.network.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public a(j jVar) {
        super(jVar, "/swanAPI/faceResultVerify");
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.ab
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
        } else if (!eVar.acT().isLogin(context)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not login");
            return false;
        } else {
            final String fH = com.baidu.swan.apps.api.module.g.c.fH(eVar.id);
            JSONObject fJ = fJ(fH);
            com.baidu.swan.bdprivate.a.a.a(eVar.getActivity(), new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.c.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: z */
                public void D(Bundle bundle) {
                    if (bundle != null && !TextUtils.isEmpty(bundle.getString("dev"))) {
                        String string = bundle.getString("dev");
                        if (a.DEBUG) {
                            Log.d("FaceResultVerifyAction", "stoken=" + string);
                        }
                        a.this.a(optString2, string, fH, optString, callbackHandler, eVar);
                        return;
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, "stoken is null").toString());
                }
            }, "dev");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(fJ, 0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, final String str4, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
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
        Request c = c(str3, hashMap);
        if (c == null) {
            callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
        } else {
            com.baidu.swan.apps.setting.oauth.c.YZ().newCall(c).enqueue(new Callback() { // from class: com.baidu.swan.bdprivate.c.a.a.2
                @Override // okhttp3.Callback
                public void onFailure(@Nullable Call call, @Nullable IOException iOException) {
                    a.this.b(iOException == null ? "" : iOException.getMessage(), str4, callbackHandler);
                }

                @Override // okhttp3.Callback
                public void onResponse(@Nullable Call call, @Nullable Response response) {
                    if (response == null) {
                        a.this.b("response is null", str4, callbackHandler);
                    } else if (!response.isSuccessful()) {
                        a.this.b("response code is error", str4, callbackHandler);
                    } else {
                        ResponseBody body = response.body();
                        if (body == null) {
                            a.this.b("body is null", str4, callbackHandler);
                            return;
                        }
                        String str5 = null;
                        try {
                            str5 = body.string();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        if (a.DEBUG) {
                            Log.d("FaceResultVerifyAction", "response body : " + str5);
                        }
                        if (TextUtils.isEmpty(str5)) {
                            a.this.b("body is null", str4, callbackHandler);
                            return;
                        }
                        try {
                            JSONObject jSONObject3 = new JSONObject(str5);
                            if (jSONObject3.optInt("errno") != 0) {
                                a.this.b(jSONObject3.optString(BaseJsonData.TAG_ERRMSG), str4, callbackHandler);
                                return;
                            }
                            JSONObject optJSONObject = jSONObject3.optJSONObject("data");
                            if (optJSONObject == null) {
                                a.this.b("server data is null", str4, callbackHandler);
                                return;
                            }
                            callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0).toString());
                        } catch (JSONException e3) {
                            if (a.DEBUG) {
                                e3.printStackTrace();
                            }
                            a.this.b("body format error", str4, callbackHandler);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, CallbackHandler callbackHandler) {
        com.baidu.swan.apps.console.c.i("FaceResultVerifyAction", str);
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
    }

    @Nullable
    private Request c(@Nullable String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(com.baidu.swan.apps.h.c.bjS);
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/facecheck");
        for (Map.Entry<String, String> entry : com.baidu.swan.apps.h.b.Le().bjR.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.tag(str);
        if (map != null) {
            builder.post(com.baidu.swan.apps.setting.oauth.c.p(map));
        }
        builder.url(com.baidu.swan.apps.h.c.processCommonParams(build.toString()));
        return builder.build();
    }
}
