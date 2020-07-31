package com.baidu.swan.apps.extcore.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends aa {
    private static final String cjR = e.class.getSimpleName();
    private static final String cjY = String.format("?swanjs_version=%s", com.baidu.swan.apps.swancore.b.hv(0));
    private static final String cjZ = "https://smartprogram.baidu.com/batapi/engine" + cjY + "&type=1";
    private static final String cka = "https://smartprogram.baidu.com/batapi/engine" + cjY + "&type=2";
    private boolean ckb;
    private boolean ckc;
    private boolean ckd;
    private String cke;
    private String ckf;
    private String ckg;
    private JSONObject ckh;

    public f(j jVar) {
        super(jVar, "/swanAPI/debug/setCtsConfig");
        this.ckb = false;
        this.ckc = false;
        this.ckd = false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e(cjR, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (eVar == null) {
            com.baidu.swan.apps.console.c.e(cjR, "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            this.ckg = b.optString("cb");
            if (!b.has("loadCts")) {
                com.baidu.swan.apps.console.c.e(cjR, "loadCts is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eVar.arH().b(context, "mapp_cts_debug", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, f.this.ckg);
                        return;
                    }
                    f.this.ckh = new JSONObject();
                    if (b.optInt("loadCts") == 1) {
                        f.this.bS(context);
                        f.this.a(eVar, f.this.cke, callbackHandler, "master");
                        f.this.a(eVar, f.this.ckf, callbackHandler, "slave");
                        f.this.ckd = true;
                        return;
                    }
                    f.this.ckd = false;
                    com.baidu.swan.apps.ae.a.a.eS(false);
                    com.baidu.swan.apps.ae.a.a.aam();
                    callbackHandler.handleSchemeDispatchCallback(f.this.ckg, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            });
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(Context context) {
        if (com.baidu.swan.apps.aq.g.exists(context, "aiapps/debug_cts_url.json")) {
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.swan.apps.aq.g.loadAssetsFile(context, "aiapps/debug_cts_url.json"));
                this.cke = jSONObject.optString("master");
                this.ckf = jSONObject.optString("slave");
                if (TextUtils.isEmpty(this.cke)) {
                    this.cke = cjZ;
                }
                if (TextUtils.isEmpty(this.ckf)) {
                    this.ckf = cka;
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                this.cke = cjZ;
                this.ckf = cka;
                return;
            }
        }
        this.cke = cjZ;
        this.ckf = cka;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.swan.apps.runtime.e eVar, String str, final CallbackHandler callbackHandler, final String str2) {
        com.baidu.swan.b.b.a aVar = new com.baidu.swan.b.b.a(str, new ResponseCallback() { // from class: com.baidu.swan.apps.extcore.c.a.f.2
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                if (response.code() != 200 || response.body() == null) {
                    com.baidu.swan.apps.console.c.e(f.cjR, "request Cts Server Address fail,code is " + response.code());
                    callbackHandler.handleSchemeDispatchCallback(f.this.ckg, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                } else {
                    f.this.a(eVar, response, str2, callbackHandler);
                }
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                com.baidu.swan.apps.console.c.e("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
                callbackHandler.handleSchemeDispatchCallback(f.this.ckg, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        });
        aVar.dvF = true;
        aVar.dvG = false;
        aVar.dvH = true;
        com.baidu.swan.b.c.a.aKu().a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.runtime.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject(response.body().string());
            if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                a(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
            } else {
                callbackHandler.handleSchemeDispatchCallback(this.ckg, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
            callbackHandler.handleSchemeDispatchCallback(this.ckg, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    private void a(String str, final String str2, com.baidu.swan.apps.runtime.e eVar, final CallbackHandler callbackHandler) {
        com.baidu.swan.b.b.a aVar = new com.baidu.swan.b.b.a(com.baidu.swan.apps.h.c.processCommonParams(str), new ResponseCallback() { // from class: com.baidu.swan.apps.extcore.c.a.f.3
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                f.this.a(response, str2, f.this.ckg, callbackHandler);
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                com.baidu.swan.apps.console.c.e(f.cjR, "download cts file fail");
                callbackHandler.handleSchemeDispatchCallback(f.this.ckg, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        });
        aVar.dvF = true;
        aVar.dvG = false;
        aVar.dvH = true;
        com.baidu.swan.b.c.a.aKu().a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Response response, String str, String str2, CallbackHandler callbackHandler) {
        if (response.code() == 200 && response.body() != null) {
            try {
                InputStream byteStream = response.body().byteStream();
                File file = new File(new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_cts"), str + ".js");
                if (com.baidu.swan.d.f.streamToFile(byteStream, file)) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(file);
                    char c = 65535;
                    switch (str.hashCode()) {
                        case -1081267614:
                            if (str.equals("master")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 109519319:
                            if (str.equals("slave")) {
                                c = 1;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            this.ckh.put("master", jSONArray);
                            this.ckb = true;
                            a(this.ckh, callbackHandler, str2);
                            return;
                        case 1:
                            this.ckh.put("slave", jSONArray);
                            this.ckc = true;
                            a(this.ckh, callbackHandler, str2);
                            return;
                        default:
                            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                            com.baidu.swan.apps.console.c.e(cjR, "error type, get cts url failed");
                            return;
                    }
                }
                com.baidu.swan.apps.console.c.e(cjR, "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            } catch (Exception e) {
                com.baidu.swan.apps.console.c.e(cjR, "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
        }
        com.baidu.swan.apps.console.c.e(cjR, "download cts file fail,code is " + response.code());
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
    }

    private void a(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        if (this.ckb && this.ckc && this.ckd) {
            com.baidu.swan.apps.ae.a.a.eS(true);
            com.baidu.swan.apps.storage.c.h.auW().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.ckc = false;
            this.ckb = false;
            com.baidu.swan.apps.ae.a.a.aam();
        }
    }
}
