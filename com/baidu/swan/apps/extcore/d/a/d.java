package com.baidu.swan.apps.extcore.d.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends y {
    private static final String avB = c.class.getSimpleName();
    private static final String avC = String.format("?swanjs_version=%s", com.baidu.swan.apps.swancore.b.dI(0));
    private static final String avD = "http://sut.baidu-int.com/yts/sut/preload" + avC + "&type=1";
    private static final String avE = "http://sut.baidu-int.com/yts/sut/preload" + avC + "&type=2";
    private boolean avF;
    private boolean avG;
    private boolean avH;

    public d(j jVar) {
        super(jVar, "/swan/debug/setCtsConfig");
        this.avF = false;
        this.avG = false;
        this.avH = false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!DEBUG) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, LegoListActivityConfig.PARAMS);
        if (c == null) {
            com.baidu.swan.apps.console.c.e(avB, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = c.optString("cb");
        if (!c.has("loadCts")) {
            com.baidu.swan.apps.console.c.e(avB, "loadCts is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (c.optInt("loadCts") == 1) {
            JSONObject jSONObject = new JSONObject();
            a(bVar, avD, callbackHandler, optString, jSONObject);
            a(bVar, avE, callbackHandler, optString, jSONObject);
            this.avH = true;
        } else {
            this.avH = false;
            com.baidu.swan.apps.ac.a.a.bz(false);
            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
        return true;
    }

    private void a(com.baidu.swan.apps.ae.b bVar, final String str, final CallbackHandler callbackHandler, final String str2, final JSONObject jSONObject) {
        bVar.Jd().a(new Request.Builder().url(str).get().build(), new Callback() { // from class: com.baidu.swan.apps.extcore.d.a.d.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (d.DEBUG) {
                    Log.d("SwanAppAction", "onFailure: " + iOException.getMessage());
                }
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200 && response.body() != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(response.body().string());
                        if (jSONObject2.has("code") && jSONObject2.optInt("code") == 0) {
                            JSONArray optJSONArray = jSONObject2.optJSONArray("data");
                            if (!TextUtils.equals(d.avD, str)) {
                                if (TextUtils.equals(d.avE, str)) {
                                    jSONObject.put("slave", optJSONArray);
                                    d.this.avG = true;
                                    d.this.a(jSONObject, callbackHandler, str2);
                                }
                            } else {
                                jSONObject.put("master", optJSONArray);
                                d.this.avF = true;
                                d.this.a(jSONObject, callbackHandler, str2);
                            }
                        } else {
                            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        return;
                    }
                }
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        if (this.avF && this.avG && this.avH) {
            com.baidu.swan.apps.ac.a.a.bz(true);
            f.KL().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.avG = false;
            this.avF = false;
        }
    }
}
