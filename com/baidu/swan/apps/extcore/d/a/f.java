package com.baidu.swan.apps.extcore.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends ab {
    private static final String bqB = e.class.getSimpleName();
    private static final String bqI = String.format("?swanjs_version=%s", com.baidu.swan.apps.swancore.b.gh(0));
    private static final String bqJ = "https://smartprogram.baidu.com/batapi/engine" + bqI + "&type=1";
    private static final String bqK = "https://smartprogram.baidu.com/batapi/engine" + bqI + "&type=2";
    private boolean bqL;
    private boolean bqM;
    private boolean bqN;
    private String bqO;
    private String bqP;
    private String bqQ;
    private JSONObject bqR;

    public f(j jVar) {
        super(jVar, "/swanAPI/debug/setCtsConfig");
        this.bqL = false;
        this.bqM = false;
        this.bqN = false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e(bqB, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (eVar == null) {
            com.baidu.swan.apps.console.c.e(bqB, "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            this.bqQ = b.optString("cb");
            if (!b.has("loadCts")) {
                com.baidu.swan.apps.console.c.e(bqB, "loadCts is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eVar.aaz().b(context, "mapp_cts_debug", new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.d.a.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, f.this.bqQ);
                        return;
                    }
                    f.this.bqR = new JSONObject();
                    if (b.optInt("loadCts") == 1) {
                        f.this.bY(context);
                        f.this.a(eVar, f.this.bqO, callbackHandler, "master");
                        f.this.a(eVar, f.this.bqP, callbackHandler, "slave");
                        f.this.bqN = true;
                        return;
                    }
                    f.this.bqN = false;
                    com.baidu.swan.apps.ah.a.a.dj(false);
                    com.baidu.swan.apps.ah.a.a.Lp();
                    callbackHandler.handleSchemeDispatchCallback(f.this.bqQ, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            });
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(Context context) {
        if (com.baidu.swan.apps.as.e.exists(context, "aiapps/debug_cts_url.json")) {
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.swan.apps.as.e.loadAssetsFile(context, "aiapps/debug_cts_url.json"));
                this.bqO = jSONObject.optString("master");
                this.bqP = jSONObject.optString("slave");
                if (TextUtils.isEmpty(this.bqO)) {
                    this.bqO = bqJ;
                }
                if (TextUtils.isEmpty(this.bqP)) {
                    this.bqP = bqK;
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                this.bqO = bqJ;
                this.bqP = bqK;
                return;
            }
        }
        this.bqO = bqJ;
        this.bqP = bqK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.swan.apps.runtime.e eVar, String str, final CallbackHandler callbackHandler, final String str2) {
        eVar.aaB().a(new Request.Builder().url(str).get().build(), new Callback() { // from class: com.baidu.swan.apps.extcore.d.a.f.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                com.baidu.swan.apps.console.c.e("SwanAppAction", "request Cts Server Address onFailure: " + iOException.getMessage());
                callbackHandler.handleSchemeDispatchCallback(f.this.bqQ, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() != 200 || response.body() == null) {
                    com.baidu.swan.apps.console.c.e(f.bqB, "request Cts Server Address fail,code is " + response.code());
                    callbackHandler.handleSchemeDispatchCallback(f.this.bqQ, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                f.this.a(eVar, response, str2, callbackHandler);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.runtime.e eVar, Response response, final String str, final CallbackHandler callbackHandler) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject(response.body().string());
            if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                eVar.aaB().WG().newBuilder().build().newCall(new Request.Builder().url(com.baidu.swan.apps.h.c.processCommonParams(jSONObject.optJSONArray("data").optString(0))).build()).enqueue(new Callback() { // from class: com.baidu.swan.apps.extcore.d.a.f.3
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        com.baidu.swan.apps.console.c.e(f.bqB, "download cts file fail");
                        callbackHandler.handleSchemeDispatchCallback(f.this.bqQ, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response2) throws IOException {
                        if (response2.code() != 200 || response2.body() == null) {
                            com.baidu.swan.apps.console.c.e(f.bqB, "download cts file fail,code is " + response2.code());
                            callbackHandler.handleSchemeDispatchCallback(f.this.bqQ, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                            return;
                        }
                        try {
                            InputStream byteStream = response2.body().byteStream();
                            File file = new File(new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_cts"), str + ".js");
                            if (!com.baidu.swan.d.f.streamToFile(byteStream, file)) {
                                com.baidu.swan.apps.console.c.e(f.bqB, "save cts file fail");
                                callbackHandler.handleSchemeDispatchCallback(f.this.bqQ, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                                return;
                            }
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(file);
                            String str2 = str;
                            char c = 65535;
                            switch (str2.hashCode()) {
                                case -1081267614:
                                    if (str2.equals("master")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case 109519319:
                                    if (str2.equals("slave")) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    f.this.bqR.put("master", jSONArray);
                                    f.this.bqL = true;
                                    f.this.a(f.this.bqR, callbackHandler, f.this.bqQ);
                                    return;
                                case 1:
                                    f.this.bqR.put("slave", jSONArray);
                                    f.this.bqM = true;
                                    f.this.a(f.this.bqR, callbackHandler, f.this.bqQ);
                                    return;
                                default:
                                    callbackHandler.handleSchemeDispatchCallback(f.this.bqQ, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                                    com.baidu.swan.apps.console.c.e(f.bqB, "error type, get cts url failed");
                                    return;
                            }
                        } catch (Exception e) {
                            com.baidu.swan.apps.console.c.e(f.bqB, "save cts file fail");
                            callbackHandler.handleSchemeDispatchCallback(f.this.bqQ, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        }
                    }
                });
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(this.bqQ, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        } catch (JSONException e) {
            e.printStackTrace();
            callbackHandler.handleSchemeDispatchCallback(this.bqQ, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        if (this.bqL && this.bqM && this.bqN) {
            com.baidu.swan.apps.ah.a.a.dj(true);
            com.baidu.swan.apps.storage.c.h.adb().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.bqM = false;
            this.bqL = false;
            com.baidu.swan.apps.ah.a.a.Lp();
        }
    }
}
