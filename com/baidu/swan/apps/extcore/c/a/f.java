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
/* loaded from: classes9.dex */
public class f extends aa {
    private static final String ddW = String.format("?swanjs_version=%s", com.baidu.swan.apps.swancore.b.le(0));
    private static final String ddX = "https://smartprogram.baidu.com/batapi/engine" + ddW + "&type=1";
    private static final String ddY = "https://smartprogram.baidu.com/batapi/engine" + ddW + "&type=2";
    private String cFi;
    private boolean ddZ;
    private boolean dea;
    private boolean deb;
    private String dec;
    private String ded;
    private JSONObject dee;

    public f(j jVar) {
        super(jVar, "/swanAPI/debug/setCtsConfig");
        this.ddZ = false;
        this.dea = false;
        this.deb = false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject b2 = b(unitedSchemeEntity, "params");
        if (b2 == null) {
            com.baidu.swan.apps.console.c.e("setCtsConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (eVar == null) {
            com.baidu.swan.apps.console.c.e("setCtsConfig", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            this.cFi = b2.optString("cb");
            if (!b2.has("loadCts")) {
                com.baidu.swan.apps.console.c.e("setCtsConfig", "loadCts is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eVar.aMx().b(context, "mapp_cts_debug", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, f.this.cFi);
                        return;
                    }
                    f.this.dee = new JSONObject();
                    if (b2.optInt("loadCts") == 1) {
                        f.this.cS(context);
                        f.this.a(eVar, f.this.dec, callbackHandler, "master");
                        f.this.a(eVar, f.this.ded, callbackHandler, "slave");
                        f.this.deb = true;
                        return;
                    }
                    f.this.deb = false;
                    com.baidu.swan.apps.ad.a.a.gD(false);
                    com.baidu.swan.apps.ad.a.a.arY();
                    callbackHandler.handleSchemeDispatchCallback(f.this.cFi, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            });
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cS(Context context) {
        if (com.baidu.swan.apps.ao.g.exists(context, "aiapps/debug_cts_url.json")) {
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.swan.apps.ao.g.loadAssetsFile(context, "aiapps/debug_cts_url.json"));
                this.dec = jSONObject.optString("master");
                this.ded = jSONObject.optString("slave");
                if (TextUtils.isEmpty(this.dec)) {
                    this.dec = ddX;
                }
                if (TextUtils.isEmpty(this.ded)) {
                    this.ded = ddY;
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                this.dec = ddX;
                this.ded = ddY;
                return;
            }
        }
        this.dec = ddX;
        this.ded = ddY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.swan.apps.runtime.e eVar, String str, final CallbackHandler callbackHandler, final String str2) {
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a(str, new ResponseCallback() { // from class: com.baidu.swan.apps.extcore.c.a.f.2
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                if (response.code() == 200 && response.body() != null) {
                    f.this.a(eVar, response, str2, callbackHandler);
                } else {
                    com.baidu.swan.apps.console.c.e("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                    callbackHandler.handleSchemeDispatchCallback(f.this.cFi, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                com.baidu.swan.apps.console.c.e("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
                callbackHandler.handleSchemeDispatchCallback(f.this.cFi, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        });
        aVar.ewn = true;
        aVar.ewo = false;
        aVar.ewp = true;
        com.baidu.swan.a.c.a.bfF().a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.runtime.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject(response.body().string());
            if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                a(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
            } else {
                callbackHandler.handleSchemeDispatchCallback(this.cFi, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
            callbackHandler.handleSchemeDispatchCallback(this.cFi, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    private void a(String str, final String str2, com.baidu.swan.apps.runtime.e eVar, final CallbackHandler callbackHandler) {
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a(com.baidu.swan.apps.t.a.aAE().kP(str), new ResponseCallback() { // from class: com.baidu.swan.apps.extcore.c.a.f.3
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                f.this.a(response, str2, f.this.cFi, callbackHandler);
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                com.baidu.swan.apps.console.c.e("setCtsConfig", "download cts file fail");
                callbackHandler.handleSchemeDispatchCallback(f.this.cFi, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        });
        aVar.ewn = true;
        aVar.ewo = false;
        aVar.ewp = true;
        com.baidu.swan.a.c.a.bfF().a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Response response, String str, String str2, CallbackHandler callbackHandler) {
        if (response.code() == 200 && response.body() != null) {
            try {
                InputStream byteStream = response.body().byteStream();
                File file = new File(new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_cts"), str + ".js");
                if (com.baidu.swan.c.f.streamToFile(byteStream, file)) {
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
                            this.dee.put("master", jSONArray);
                            this.ddZ = true;
                            a(this.dee, callbackHandler, str2);
                            return;
                        case 1:
                            this.dee.put("slave", jSONArray);
                            this.dea = true;
                            a(this.dee, callbackHandler, str2);
                            return;
                        default:
                            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                            com.baidu.swan.apps.console.c.e("setCtsConfig", "error type, get cts url failed");
                            return;
                    }
                }
                com.baidu.swan.apps.console.c.e("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            } catch (Exception e) {
                com.baidu.swan.apps.console.c.e("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
        }
        com.baidu.swan.apps.console.c.e("setCtsConfig", "download cts file fail,code is " + response.code());
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
    }

    private void a(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        if (this.ddZ && this.dea && this.deb) {
            com.baidu.swan.apps.ad.a.a.gD(true);
            com.baidu.swan.apps.storage.c.h.aPI().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.dea = false;
            this.ddZ = false;
            com.baidu.swan.apps.ad.a.a.arY();
        }
    }
}
