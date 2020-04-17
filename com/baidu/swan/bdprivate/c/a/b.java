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
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.network.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public b(j jVar) {
        super(jVar, "/swanAPI/faceVerify");
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
        } else if (!eVar.akY().isLogin(context)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not login");
            return false;
        } else {
            final String gV = com.baidu.swan.apps.api.module.g.c.gV(eVar.id);
            JSONObject gX = gX(gV);
            eVar.akX().a(context, "mapp_i_face_verify", com.baidu.swan.apps.setting.oauth.c.aZ(optParamsAsJo), new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.bdprivate.c.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void E(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        b.this.a(gV, optString, callbackHandler, eVar);
                    } else {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString);
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(gX, 0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final String str2, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        Request ow = ow(str);
        if (ow == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
        } else {
            com.baidu.swan.apps.setting.oauth.c.ahf().newCall(ow).enqueue(new Callback() { // from class: com.baidu.swan.bdprivate.c.a.b.2
                @Override // okhttp3.Callback
                public void onFailure(@Nullable Call call, @Nullable IOException iOException) {
                    b.this.b(iOException == null ? "" : iOException.getMessage(), str2, callbackHandler);
                }

                @Override // okhttp3.Callback
                public void onResponse(@Nullable Call call, @Nullable Response response) {
                    if (response == null) {
                        b.this.b("response is null", str2, callbackHandler);
                    } else if (!response.isSuccessful()) {
                        b.this.b("response code is error", str2, callbackHandler);
                    } else {
                        ResponseBody body = response.body();
                        if (body == null) {
                            b.this.b("body is null", str2, callbackHandler);
                            return;
                        }
                        String str3 = null;
                        try {
                            str3 = body.string();
                        } catch (IOException e) {
                            if (b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                        if (b.DEBUG) {
                            Log.d("FaceVerifyAction", "response body : " + str3);
                        }
                        if (TextUtils.isEmpty(str3)) {
                            b.this.b("body is null", str2, callbackHandler);
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) != 0) {
                                b.this.b(jSONObject.optString(BaseJsonData.TAG_ERRMSG), str2, callbackHandler);
                                return;
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject == null) {
                                b.this.b("server data is null", str2, callbackHandler);
                                return;
                            }
                            b.this.a(optJSONObject.optInt("real_name") == 1, str2, callbackHandler, eVar);
                        } catch (JSONException e2) {
                            if (b.DEBUG) {
                                e2.printStackTrace();
                            }
                            b.this.b("body format error", str2, callbackHandler);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, CallbackHandler callbackHandler) {
        com.baidu.swan.apps.console.c.i("FaceVerifyAction", str);
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final String str, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.bdprivate.a.a.a(eVar.getActivity(), z, eVar.id, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.c.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: z */
            public void E(Bundle bundle) {
                JSONObject wrapCallbackParams;
                if (bundle == null) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "result is null").toString());
                    return;
                }
                String safeGetString = r.safeGetString(bundle, "callbackKey");
                if (TextUtils.isEmpty(safeGetString)) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, r.safeGetString(bundle, "failMsg")).toString());
                    return;
                }
                com.baidu.swan.apps.console.c.i("FaceVerifyAction", safeGetString);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("callbackKey", safeGetString);
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                } catch (JSONException e) {
                    if (b.DEBUG) {
                        e.printStackTrace();
                    }
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
                }
                callbackHandler.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
            }
        });
    }

    @Nullable
    private Request ow(@Nullable String str) {
        HttpUrl parse = HttpUrl.parse(com.baidu.swan.apps.h.c.bIa);
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/realnamecheck");
        for (Map.Entry<String, String> entry : com.baidu.swan.apps.h.b.SS().bHZ.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.tag(str);
        builder.post(new FormBody.Builder().build());
        builder.url(com.baidu.swan.apps.h.c.processCommonParams(build.toString()));
        return builder.build();
    }
}
