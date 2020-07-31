package com.baidu.swan.bdprivate.extensions.a;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.u;
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
/* loaded from: classes11.dex */
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
        } else if (eVar.VF()) {
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
            final String id = com.baidu.swan.apps.api.module.network.c.id(eVar.id);
            JSONObject jSONObject = m28if(id);
            eVar.arH().a(context, "mapp_i_face_verify", com.baidu.swan.apps.setting.oauth.c.bu(optParamsAsJo), new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.bdprivate.extensions.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString);
                    } else {
                        b.e(id, new com.baidu.swan.apps.aq.e.b<String>() { // from class: com.baidu.swan.bdprivate.extensions.a.b.1.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.aq.e.b
                            /* renamed from: onCallback */
                            public void H(String str) {
                                b.this.a(str, callbackHandler, optString, eVar);
                            }
                        });
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final CallbackHandler callbackHandler, final String str2, com.baidu.swan.apps.runtime.e eVar) {
        if (str == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
        } else if (TextUtils.equals(str, "1") || TextUtils.equals(str, "0")) {
            a(str, eVar, new com.baidu.swan.apps.aq.e.b<String>() { // from class: com.baidu.swan.bdprivate.extensions.a.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: onCallback */
                public void H(String str3) {
                    callbackHandler.handleSchemeDispatchCallback(str2, str3);
                }
            });
        } else {
            callbackHandler.handleSchemeDispatchCallback(str2, str);
        }
    }

    public static void e(String str, com.baidu.swan.apps.aq.e.b<String> bVar) {
        Request qY = qY(str);
        if (qY == null) {
            bVar.H(null);
        } else {
            a(qY, bVar);
        }
    }

    private static void a(Request request, final com.baidu.swan.apps.aq.e.b<String> bVar) {
        com.baidu.swan.b.b.a aVar = new com.baidu.swan.b.b.a(request.url().toString(), request.body(), new ResponseCallback() { // from class: com.baidu.swan.bdprivate.extensions.a.b.3
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                b.a(response, com.baidu.swan.apps.aq.e.b.this);
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                com.baidu.swan.apps.aq.e.b.this.H(b.qX(exc == null ? "" : exc.getMessage()));
            }
        });
        aVar.tag = request.tag();
        aVar.dvF = true;
        aVar.dvG = true;
        aVar.dvH = true;
        com.baidu.swan.b.c.a.aKu().b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Response response, com.baidu.swan.apps.aq.e.b<String> bVar) {
        if (response == null) {
            bVar.H(qX("response is null"));
        } else if (!response.isSuccessful()) {
            bVar.H(qX("response code is error"));
        } else {
            ResponseBody body = response.body();
            if (body == null) {
                bVar.H(qX("body is null"));
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
                bVar.H(qX("body is null"));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) != 0) {
                    bVar.H(qX(jSONObject.optString(BaseJsonData.TAG_ERRMSG)));
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    bVar.H(qX("server data is null"));
                } else {
                    bVar.H(String.valueOf(optJSONObject.optInt("real_name")));
                }
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                bVar.H(qX("body format error"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qX(String str) {
        com.baidu.swan.apps.console.c.i("FaceVerifyAction", str);
        return UnitedSchemeUtility.wrapCallbackParams(1001, str).toString();
    }

    public static void a(String str, com.baidu.swan.apps.runtime.e eVar, final com.baidu.swan.apps.aq.e.b<String> bVar) {
        com.baidu.swan.bdprivate.a.a.a(eVar.arp(), str, eVar.id, new com.baidu.swan.apps.aq.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.extensions.a.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: D */
            public void H(Bundle bundle) {
                JSONObject wrapCallbackParams;
                if (bundle == null) {
                    com.baidu.swan.apps.aq.e.b.this.H(UnitedSchemeUtility.wrapCallbackParams(1001, "result is null").toString());
                    return;
                }
                String safeGetString = u.safeGetString(bundle, "callbackKey");
                if (TextUtils.isEmpty(safeGetString)) {
                    com.baidu.swan.apps.aq.e.b.this.H(UnitedSchemeUtility.wrapCallbackParams(1001, u.safeGetString(bundle, "failMsg")).toString());
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
                com.baidu.swan.apps.aq.e.b.this.H(wrapCallbackParams.toString());
            }
        });
    }

    @Nullable
    private static Request qY(@Nullable String str) {
        HttpUrl parse = HttpUrl.parse("https://mbd.baidu.com");
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/realnamecheck");
        for (Map.Entry<String, String> entry : com.baidu.swan.apps.h.b.Xo().bWB.entrySet()) {
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
