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
/* loaded from: classes11.dex */
public class f extends ab {
    private static final String buL = e.class.getSimpleName();
    private static final String buS = String.format("?swanjs_version=%s", com.baidu.swan.apps.swancore.b.gy(0));
    private static final String buT = "https://smartprogram.baidu.com/batapi/engine" + buS + "&type=1";
    private static final String buU = "https://smartprogram.baidu.com/batapi/engine" + buS + "&type=2";
    private boolean buV;
    private boolean buW;
    private boolean buX;
    private String buY;
    private String buZ;
    private String bva;
    private JSONObject bvb;

    public f(j jVar) {
        super(jVar, "/swanAPI/debug/setCtsConfig");
        this.buV = false;
        this.buW = false;
        this.buX = false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e(buL, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (eVar == null) {
            com.baidu.swan.apps.console.c.e(buL, "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            this.bva = b.optString("cb");
            if (!b.has("loadCts")) {
                com.baidu.swan.apps.console.c.e(buL, "loadCts is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eVar.acN().b(context, "mapp_cts_debug", new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.d.a.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, f.this.bva);
                        return;
                    }
                    f.this.bvb = new JSONObject();
                    if (b.optInt("loadCts") == 1) {
                        f.this.cc(context);
                        f.this.a(eVar, f.this.buY, callbackHandler, "master");
                        f.this.a(eVar, f.this.buZ, callbackHandler, "slave");
                        f.this.buX = true;
                        return;
                    }
                    f.this.buX = false;
                    com.baidu.swan.apps.ah.a.a.dq(false);
                    com.baidu.swan.apps.ah.a.a.ND();
                    callbackHandler.handleSchemeDispatchCallback(f.this.bva, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            });
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(Context context) {
        if (com.baidu.swan.apps.as.e.exists(context, "aiapps/debug_cts_url.json")) {
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.swan.apps.as.e.loadAssetsFile(context, "aiapps/debug_cts_url.json"));
                this.buY = jSONObject.optString("master");
                this.buZ = jSONObject.optString("slave");
                if (TextUtils.isEmpty(this.buY)) {
                    this.buY = buT;
                }
                if (TextUtils.isEmpty(this.buZ)) {
                    this.buZ = buU;
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                this.buY = buT;
                this.buZ = buU;
                return;
            }
        }
        this.buY = buT;
        this.buZ = buU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.swan.apps.runtime.e eVar, String str, final CallbackHandler callbackHandler, final String str2) {
        eVar.acP().a(new Request.Builder().url(str).get().build(), new Callback() { // from class: com.baidu.swan.apps.extcore.d.a.f.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                com.baidu.swan.apps.console.c.e("SwanAppAction", "request Cts Server Address onFailure: " + iOException.getMessage());
                callbackHandler.handleSchemeDispatchCallback(f.this.bva, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() != 200 || response.body() == null) {
                    com.baidu.swan.apps.console.c.e(f.buL, "request Cts Server Address fail,code is " + response.code());
                    callbackHandler.handleSchemeDispatchCallback(f.this.bva, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
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
                eVar.acP().YU().newBuilder().build().newCall(new Request.Builder().url(com.baidu.swan.apps.h.c.processCommonParams(jSONObject.optJSONArray("data").optString(0))).build()).enqueue(new Callback() { // from class: com.baidu.swan.apps.extcore.d.a.f.3
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        com.baidu.swan.apps.console.c.e(f.buL, "download cts file fail");
                        callbackHandler.handleSchemeDispatchCallback(f.this.bva, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response2) throws IOException {
                        if (response2.code() != 200 || response2.body() == null) {
                            com.baidu.swan.apps.console.c.e(f.buL, "download cts file fail,code is " + response2.code());
                            callbackHandler.handleSchemeDispatchCallback(f.this.bva, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                            return;
                        }
                        try {
                            InputStream byteStream = response2.body().byteStream();
                            File file = new File(new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_cts"), str + ".js");
                            if (!com.baidu.swan.d.f.streamToFile(byteStream, file)) {
                                com.baidu.swan.apps.console.c.e(f.buL, "save cts file fail");
                                callbackHandler.handleSchemeDispatchCallback(f.this.bva, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
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
                                    f.this.bvb.put("master", jSONArray);
                                    f.this.buV = true;
                                    f.this.a(f.this.bvb, callbackHandler, f.this.bva);
                                    return;
                                case 1:
                                    f.this.bvb.put("slave", jSONArray);
                                    f.this.buW = true;
                                    f.this.a(f.this.bvb, callbackHandler, f.this.bva);
                                    return;
                                default:
                                    callbackHandler.handleSchemeDispatchCallback(f.this.bva, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                                    com.baidu.swan.apps.console.c.e(f.buL, "error type, get cts url failed");
                                    return;
                            }
                        } catch (Exception e) {
                            com.baidu.swan.apps.console.c.e(f.buL, "save cts file fail");
                            callbackHandler.handleSchemeDispatchCallback(f.this.bva, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        }
                    }
                });
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(this.bva, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        } catch (JSONException e) {
            e.printStackTrace();
            callbackHandler.handleSchemeDispatchCallback(this.bva, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        if (this.buV && this.buW && this.buX) {
            com.baidu.swan.apps.ah.a.a.dq(true);
            com.baidu.swan.apps.storage.c.h.afp().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.buW = false;
            this.buV = false;
            com.baidu.swan.apps.ah.a.a.ND();
        }
    }
}
