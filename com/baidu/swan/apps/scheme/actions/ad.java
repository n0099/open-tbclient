package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes11.dex */
public class ad extends com.baidu.swan.apps.network.a implements com.baidu.swan.apps.network.f {
    private int cBK;

    public ad(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/uploadFile");
        this.cBK = 0;
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.aa
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
        String aoH = com.baidu.swan.apps.runtime.e.aoH();
        if (TextUtils.isEmpty(aoH)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String hL = com.baidu.swan.apps.api.module.network.c.hL(aoH);
        final String valueOf = String.valueOf(System.currentTimeMillis());
        Request a = a(b, optString, hL, valueOf, eVar, callbackHandler);
        if (a == null) {
            unitedSchemeEntity.result = fY(this.cBK);
            mg(valueOf);
            return false;
        }
        JSONObject optJSONObject = b.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar = new com.baidu.swan.apps.network.a.b();
        HashMap<String, String> c = c(optJSONObject, true);
        String optString3 = b.optString("__plugin__");
        if (!TextUtils.isEmpty(optString3)) {
            com.baidu.swan.pms.model.h mP = com.baidu.swan.apps.ae.g.b.mP(optString3);
            if (c == null) {
                c = new HashMap<>();
            }
            c.put("X-SWAN-HOSTSIGN", com.baidu.swan.apps.ae.g.a.e(mP));
        }
        c.putAll(com.baidu.swan.apps.network.a.c.by("uploadFile", b.optString("__plugin__")));
        bVar.B(c);
        com.baidu.swan.apps.w.f.ahV().aic();
        com.baidu.swan.c.b.a aVar = new com.baidu.swan.c.b.a(a.url().toString(), a.body(), new ResponseCallback() { // from class: com.baidu.swan.apps.scheme.actions.ad.1
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                ad.this.a(response, callbackHandler, optString, optString2, valueOf);
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
                com.baidu.swan.apps.w.f.ahV().aid();
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                com.baidu.swan.apps.w.f.ahV().aid();
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
                ad.this.mg(valueOf);
            }
        });
        aVar.headers = c;
        aVar.tag = a.tag();
        aVar.dld = true;
        aVar.dle = false;
        aVar.dlf = true;
        com.baidu.swan.c.c.a.aFx().b(aVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(hN(hL), 0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Response response, CallbackHandler callbackHandler, String str, String str2, String str3) {
        try {
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
            mg(str3);
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
        HttpUrl hM;
        String str4;
        if (jSONObject == null || (hM = com.baidu.swan.apps.api.module.network.c.hM(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = hM.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        this.cBK = com.baidu.swan.apps.ah.a.b.G("uploadFile", httpUrl, jSONObject.optString("__plugin__"));
        if (this.cBK != 0) {
            return null;
        }
        String optString = jSONObject.optString("filePath", "");
        if (TextUtils.isEmpty(optString) || com.baidu.swan.e.d.tZ(optString)) {
            return null;
        }
        String oY = com.baidu.swan.apps.w.f.ahV().ahB().oY(optString);
        if (TextUtils.isEmpty(oY)) {
            return null;
        }
        File file = new File(oY);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        final long length = file.length();
        if (length > 524288000) {
            if (DEBUG) {
                Log.i("UploadFileAction", "file over size: " + (length / 1048576) + " MB.");
            }
            this.cBK = 5;
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
        this.cpN.put(str3, 0L);
        String name = file.getName();
        if (!TextUtils.isEmpty(name)) {
            String pE = com.baidu.swan.apps.aq.p.pE(com.baidu.swan.apps.aq.p.pC(name));
            if (!TextUtils.isEmpty(pE)) {
                str4 = pE;
                com.baidu.swan.apps.network.c cVar = new com.baidu.swan.apps.network.c(file, str4, new com.baidu.swan.apps.network.b.a() { // from class: com.baidu.swan.apps.scheme.actions.ad.2
                    @Override // com.baidu.swan.apps.network.b.a
                    public void bf(long j) {
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
            public void bf(long j) {
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
            if (System.currentTimeMillis() - mf(str2) > 500 || floor == 100) {
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
                this.cpN.put(str2, Long.valueOf(System.currentTimeMillis()));
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
