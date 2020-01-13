package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.WebSocketRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ae extends com.baidu.swan.apps.network.a implements com.baidu.swan.apps.network.f {
    private int bMJ;

    public ae(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/uploadFile");
        this.bMJ = 0;
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        final String optString = b.optString("onProgressUpdate");
        final String optString2 = b.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
            return false;
        }
        String aar = com.baidu.swan.apps.runtime.e.aar();
        if (TextUtils.isEmpty(aar)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String ft = com.baidu.swan.apps.api.module.g.c.ft(aar);
        final String valueOf = String.valueOf(System.currentTimeMillis());
        Request a = a(b, optString, ft, valueOf, eVar, callbackHandler);
        if (a == null) {
            unitedSchemeEntity.result = fm(this.bMJ);
            jr(valueOf);
            return false;
        }
        JSONObject optJSONObject = b.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar = new com.baidu.swan.apps.network.a.b();
        HashMap<String, String> c = c(optJSONObject, true);
        String optString3 = b.optString("__plugin__");
        if (!TextUtils.isEmpty(optString3)) {
            com.baidu.swan.pms.model.h jX = com.baidu.swan.apps.ag.g.b.jX(optString3);
            if (c == null) {
                c = new HashMap<>();
            }
            c.put("X-SWAN-HOSTSIGN", com.baidu.swan.apps.ag.g.a.e(jX));
        }
        bVar.m(c);
        eVar.aaB().a(a, bVar, new Callback() { // from class: com.baidu.swan.apps.scheme.actions.ae.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                ae.this.jr(valueOf);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    ae.this.a(jSONObject, response.body());
                    if (jSONObject.toString().length() > 26214400) {
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    }
                } catch (Exception e) {
                    if (ab.DEBUG) {
                        e.printStackTrace();
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                } finally {
                    ae.this.jr(valueOf);
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(fv(ft), 0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody) throws IOException, JSONException {
        if (responseBody != null) {
            String string = responseBody.string();
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(string);
                    if (jSONObject2 != null) {
                        jSONObject.put("data", jSONObject2);
                    }
                } catch (JSONException e) {
                    jSONObject.put("data", string);
                } catch (Throwable th) {
                    if (0 != 0) {
                        jSONObject.put("data", (Object) null);
                    }
                    throw th;
                }
            }
        }
    }

    @Nullable
    private Request a(@Nullable JSONObject jSONObject, @Nullable final String str, @Nullable String str2, @Nullable final String str3, @Nullable com.baidu.swan.apps.runtime.e eVar, @Nullable final CallbackHandler callbackHandler) {
        HttpUrl fu;
        String str4;
        if (jSONObject == null || (fu = com.baidu.swan.apps.api.module.g.c.fu(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = fu.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        this.bMJ = com.baidu.swan.apps.aj.a.b.C("uploadFile", httpUrl, jSONObject.optString("__plugin__"));
        if (this.bMJ != 0) {
            return null;
        }
        String optString = jSONObject.optString("filePath", "");
        if (TextUtils.isEmpty(optString) || com.baidu.swan.d.c.qT(optString)) {
            return null;
        }
        String lR = com.baidu.swan.apps.y.f.UC().Uj().lR(optString);
        if (TextUtils.isEmpty(lR)) {
            return null;
        }
        File file = new File(lR);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        final long length = file.length();
        if (length > 26214400) {
            return null;
        }
        String optString2 = jSONObject.optString("name", "");
        if (TextUtils.isEmpty(optString2)) {
            return null;
        }
        if (jSONObject.has("formData") && !(jSONObject.opt("formData") instanceof JSONObject)) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("formData");
        this.bBW.put(str3, 0L);
        String name = file.getName();
        if (!TextUtils.isEmpty(name)) {
            String mu = com.baidu.swan.apps.as.o.mu(com.baidu.swan.apps.as.o.mt(name));
            if (!TextUtils.isEmpty(mu)) {
                str4 = mu;
                com.baidu.swan.apps.network.c cVar = new com.baidu.swan.apps.network.c(file, str4, new com.baidu.swan.apps.network.b.a() { // from class: com.baidu.swan.apps.scheme.actions.ae.2
                    @Override // com.baidu.swan.apps.network.b.a
                    public void ap(long j) {
                        ae.this.a(length, j, str, str3, callbackHandler);
                    }
                });
                MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                a(type, optJSONObject);
                a(type, optString2, file.getName(), cVar);
                return new Request.Builder().url(httpUrl).tag(str2).post(type.build()).build();
            }
        }
        str4 = "multipart/form-data";
        com.baidu.swan.apps.network.c cVar2 = new com.baidu.swan.apps.network.c(file, str4, new com.baidu.swan.apps.network.b.a() { // from class: com.baidu.swan.apps.scheme.actions.ae.2
            @Override // com.baidu.swan.apps.network.b.a
            public void ap(long j) {
                ae.this.a(length, j, str, str3, callbackHandler);
            }
        });
        MultipartBody.Builder type2 = new MultipartBody.Builder().setType(MultipartBody.FORM);
        a(type2, optJSONObject);
        a(type2, optString2, file.getName(), cVar2);
        return new Request.Builder().url(httpUrl).tag(str2).post(type2.build()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2, String str, String str2, CallbackHandler callbackHandler) {
        if (j > 0 && j2 <= j && j2 != 0 && !TextUtils.isEmpty(str) && callbackHandler != null) {
            int floor = (int) Math.floor((100 * j2) / j);
            if (System.currentTimeMillis() - jq(str2) > 500 || floor == 100) {
                if (floor <= 100) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("progress", String.valueOf(floor));
                        jSONObject.put("totalBytesSent", String.valueOf(j2));
                        jSONObject.put("totalBytesExpectedToSend", String.valueOf(j));
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } catch (Exception e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
                this.bBW.put(str2, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    private void a(MultipartBody.Builder builder, String str, String str2, com.baidu.swan.apps.network.c cVar) {
        if (builder != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && cVar != null) {
            builder.addFormDataPart(str, str2, cVar);
        }
    }

    public static void a(MultipartBody.Builder builder, JSONObject jSONObject) {
        if (builder != null && jSONObject != null && jSONObject.length() >= 1) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    String optString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(optString)) {
                        builder.addFormDataPart(next, optString);
                    }
                }
            }
        }
    }
}
