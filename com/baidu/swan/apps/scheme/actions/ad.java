package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.WebSocketRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ad extends com.baidu.swan.apps.network.a implements com.baidu.swan.apps.network.f {
    private int dIS;

    public ad(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/uploadFile");
        this.dIS = 0;
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject b2 = b(unitedSchemeEntity, "params");
        if (b2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        final String optString = b2.optString("onProgressUpdate");
        final String optString2 = b2.optString("headersReceivedEvent");
        final String optString3 = b2.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
            return false;
        }
        String aMn = com.baidu.swan.apps.runtime.e.aMn();
        if (TextUtils.isEmpty(aMn)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String lI = com.baidu.swan.apps.api.module.network.c.lI(aMn);
        final String valueOf = String.valueOf(System.currentTimeMillis());
        Request a2 = a(b2, optString, lI, valueOf, eVar, callbackHandler);
        if (a2 == null) {
            unitedSchemeEntity.result = jS(this.dIS);
            qT(valueOf);
            return false;
        }
        JSONObject optJSONObject = b2.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar = new com.baidu.swan.apps.network.a.b();
        HashMap<String, String> e = e(optJSONObject, true);
        String optString4 = b2.optString("__plugin__");
        if (!TextUtils.isEmpty(optString4)) {
            com.baidu.swan.pms.model.h rJ = com.baidu.swan.apps.ac.g.b.rJ(optString4);
            if (e == null) {
                e = new HashMap<>();
            }
            e.put("X-SWAN-HOSTSIGN", com.baidu.swan.apps.ac.g.a.e(rJ));
        }
        e.putAll(com.baidu.swan.apps.network.a.c.ci("uploadFile", b2.optString("__plugin__")));
        bVar.A(e);
        com.baidu.swan.apps.v.f.aDH().aDO();
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a(a2.url().toString(), a2.body(), new ResponseCallback() { // from class: com.baidu.swan.apps.scheme.actions.ad.1
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                ad.this.a(response, callbackHandler, optString, optString3, optString2, valueOf);
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
                com.baidu.swan.apps.v.f.aDH().aDP();
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                com.baidu.swan.apps.v.f.aDH().aDP();
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
                ad.this.qT(valueOf);
            }
        });
        aVar.headers = e;
        aVar.tag = a2.tag();
        aVar.ewn = true;
        aVar.ewo = false;
        aVar.ewp = true;
        com.baidu.swan.a.c.a.bfF().b(aVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(lK(lI), 0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Response response, CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
        try {
            a(str3, response.headers());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("statusCode", response.code());
            a(jSONObject, response.body());
            if (jSONObject.toString().length() > 26214400) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
            } else {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
        } finally {
            qT(str4);
        }
    }

    private void a(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody) throws IOException, JSONException {
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
        HttpUrl lJ;
        String str4;
        if (jSONObject == null || (lJ = com.baidu.swan.apps.api.module.network.c.lJ(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = lJ.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        this.dIS = com.baidu.swan.apps.af.a.b.Y("uploadFile", httpUrl, jSONObject.optString("__plugin__"));
        if (this.dIS != 0) {
            return null;
        }
        String optString = jSONObject.optString("filePath", "");
        if (TextUtils.isEmpty(optString) || com.baidu.swan.c.d.zJ(optString)) {
            return null;
        }
        String ue = com.baidu.swan.apps.v.f.aDH().aDn().ue(optString);
        if (TextUtils.isEmpty(ue)) {
            return null;
        }
        File file = new File(ue);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        final long length = file.length();
        if (length > 524288000) {
            if (DEBUG) {
                Log.i("UploadFileAction", "file over size: " + (length / 1048576) + " MB.");
            }
            this.dIS = 5;
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
        this.dro.put(str3, 0L);
        String name = file.getName();
        if (!TextUtils.isEmpty(name)) {
            String uL = com.baidu.swan.apps.ao.r.uL(com.baidu.swan.apps.ao.r.uJ(name));
            if (!TextUtils.isEmpty(uL)) {
                str4 = uL;
                com.baidu.swan.apps.network.c cVar = new com.baidu.swan.apps.network.c(file, str4, new com.baidu.swan.apps.network.b.a() { // from class: com.baidu.swan.apps.scheme.actions.ad.2
                    @Override // com.baidu.swan.apps.network.b.a
                    public void cv(long j) {
                        ad.this.a(length, j, str, str3, callbackHandler);
                    }
                });
                MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                a(type, optJSONObject);
                a(type, optString2, file.getName(), cVar);
                return new Request.Builder().url(httpUrl).tag(str2).post(type.build()).build();
            }
        }
        str4 = "multipart/form-data";
        com.baidu.swan.apps.network.c cVar2 = new com.baidu.swan.apps.network.c(file, str4, new com.baidu.swan.apps.network.b.a() { // from class: com.baidu.swan.apps.scheme.actions.ad.2
            @Override // com.baidu.swan.apps.network.b.a
            public void cv(long j) {
                ad.this.a(length, j, str, str3, callbackHandler);
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
            if (System.currentTimeMillis() - qS(str2) > 500 || floor == 100) {
                if (floor <= 100) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("progress", floor);
                        jSONObject.put("totalBytesSent", j2);
                        jSONObject.put("totalBytesExpectedToSend", j);
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } catch (Exception e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
                this.dro.put(str2, Long.valueOf(System.currentTimeMillis()));
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
