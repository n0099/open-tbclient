package com.baidu.swan.apps.api.module.h;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.i;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b jH(String str) {
        e azA = com.baidu.swan.apps.runtime.d.azE().azA();
        final JSONObject parseString = v.parseString(azA.azU().getString(C0360a.b(azA), (String) null));
        return a(str, new c("getSwanId") { // from class: com.baidu.swan.apps.api.module.h.a.1
            @Override // com.baidu.swan.apps.api.a.c
            protected boolean abK() {
                if (com.baidu.swan.apps.performance.b.c.awj() && !i.aEC()) {
                    return a.this.ay(parseString);
                }
                return false;
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull final c.a aVar) {
                if (com.baidu.swan.apps.performance.b.c.awj() && a.this.ay(parseString)) {
                    aVar.b(new com.baidu.swan.apps.api.c.b(0, parseString));
                    return new com.baidu.swan.apps.api.c.b(0);
                }
                com.baidu.swan.apps.console.c.i("Api-Setting", "getSwanId start");
                if (!SwanAppNetworkUtils.isNetworkConnected(a.this.getContext())) {
                    com.baidu.swan.apps.console.c.e("Api-Setting", "network_error");
                    return new com.baidu.swan.apps.api.c.b(10002, "network_error");
                }
                com.baidu.swan.apps.runtime.d.azE().azG().Yq().aah().bh(a.this.getContext()).A(new com.baidu.swan.apps.ap.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.api.module.h.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void I(h<JSONObject> hVar) {
                        if (hVar.isOk() && hVar.mData != null) {
                            aVar.b(new com.baidu.swan.apps.api.c.b(0, hVar.mData));
                            e azA2 = com.baidu.swan.apps.runtime.d.azE().azA();
                            azA2.azU().putString(C0360a.b(azA2), hVar.mData.toString());
                            com.baidu.swan.apps.console.c.i("Api-Setting", "getSwanId success");
                            return;
                        }
                        aVar.b(new com.baidu.swan.apps.api.c.b(10001, "getSwanId failed: internal_error"));
                        com.baidu.swan.apps.console.c.e("Api-Setting", "getSwanId failed: internal_error");
                    }
                }).aBy();
                return new com.baidu.swan.apps.api.c.b(0);
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b ap(@NonNull JSONObject jSONObject) {
                return new com.baidu.swan.apps.api.c.b(0, parseString);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ay(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return false;
        }
        String optString = optJSONObject.optString("swanid");
        return (TextUtils.isEmpty(optString) || TextUtils.equals("null", optString)) ? false : true;
    }

    public com.baidu.swan.apps.api.c.b acc() {
        com.baidu.swan.apps.console.c.d("Api-Setting", "start get app info sync");
        e azJ = e.azJ();
        if (azJ == null) {
            com.baidu.swan.apps.console.c.d("Api-Setting", "illegal swanApp");
            return new com.baidu.swan.apps.api.c.b(1001, "illegal swanApp");
        }
        try {
            JSONObject a = a(azJ, getContext());
            if (DEBUG && a != null) {
                Log.d("Api-Setting", "data: " + a.toString());
            }
            return new com.baidu.swan.apps.api.c.b(0, a);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Api-Setting", Log.getStackTraceString(e));
            return new com.baidu.swan.apps.api.c.b(1001);
        }
    }

    public static JSONObject a(e eVar, Context context) throws JSONException {
        b.a azM = eVar.azM();
        String aqN = azM.aqN();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appid", azM.getAppId());
        jSONObject.put("appname", azM.akO());
        if (!TextUtils.isEmpty(azM.getIconUrl())) {
            jSONObject.put("iconUrl", azM.getIconUrl());
        }
        if (!TextUtils.isEmpty(azM.aqP())) {
            jSONObject.put("appLaunchScheme", azM.aqP());
        } else {
            jSONObject.put("appLaunchScheme", "");
        }
        PMSAppInfo ard = azM.ard();
        if (ard != null) {
            String str = ard.description;
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("appDesc", str);
            }
        }
        String bl = com.baidu.swan.apps.t.a.aoO().bl(context);
        jSONObject.put("cuid", bl);
        jSONObject.put("mtjCuid", bl);
        jSONObject.put("clkid", azM.aqU());
        jSONObject.put("scene", aqN);
        jSONObject.put("appId", azM.getAppId());
        Bundle aqS = azM.aqS();
        if (aqS != null) {
            String string = aqS.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("extraData", new JSONObject(string));
            }
            if (!TextUtils.isEmpty(aqS.getString("srcAppId"))) {
                jSONObject.put("srcAppId", aqS.getString("srcAppId"));
            }
            if (!TextUtils.isEmpty(aqS.getString("srcAppPage"))) {
                jSONObject.put("srcAppPage", aqS.getString("srcAppPage"));
            }
            if (TextUtils.isEmpty(aqN)) {
                aqN = "NA";
            }
            String string2 = aqS.getString("ubc");
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("rootSource", com.baidu.swan.c.c.c(new JSONObject(string2), "pre_source", aqN));
            }
            String str2 = "sys";
            SwanAppActivity arI = f.arY().arI();
            if (arI != null) {
                str2 = arI.XV();
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "sys";
            }
            if (DEBUG) {
                Log.d("Api-Setting", "showBy: " + str2);
            }
            jSONObject.put("showBy", str2);
        }
        return jSONObject;
    }

    public com.baidu.swan.apps.api.c.b acd() {
        if (DEBUG) {
            Log.d("Api-Setting", "start get slave id sync");
        }
        String containerId = abJ().abI().getContainerId();
        if (TextUtils.isEmpty(containerId)) {
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("slaveId", containerId);
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("Api-Setting", Log.getStackTraceString(e));
            }
            return new com.baidu.swan.apps.api.c.b(1001);
        }
    }

    public com.baidu.swan.apps.api.c.b jI(String str) {
        if (DEBUG) {
            Log.d("Api-Setting", "start request");
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.h.a.2
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(e eVar, JSONObject jSONObject, @Nullable String str2) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                a.a(a.this.abJ().abH(), str2);
                return new com.baidu.swan.apps.api.c.b(0);
            }
        });
    }

    public static void a(final CallbackHandler callbackHandler, final String str) {
        com.baidu.swan.apps.network.c.b.a.s(new com.baidu.swan.apps.ap.e.b<Map<String, com.baidu.swan.apps.setting.oauth.e>>() { // from class: com.baidu.swan.apps.api.module.h.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: n */
            public void I(Map<String, com.baidu.swan.apps.setting.oauth.e> map) {
                if (map == null) {
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, com.baidu.swan.apps.setting.oauth.e> entry : map.entrySet()) {
                        String key = entry.getKey();
                        com.baidu.swan.apps.setting.oauth.e value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && value != null && value.aBF() && !value.forbidden && TextUtils.equals("2", value.grade)) {
                            jSONObject.put(key, value.aBE() ? "1" : "0");
                        }
                    }
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } catch (JSONException e) {
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        });
    }

    public com.baidu.swan.apps.api.c.b jJ(String str) {
        if (DEBUG) {
            Log.d("Api-Setting", "start get user info");
        }
        e azJ = e.azJ();
        CallbackHandler abH = abJ().abH();
        if (azJ == null) {
            com.baidu.swan.games.v.c.g(abH, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty swanApp");
        } else if (TextUtils.isEmpty(azJ.getAppKey())) {
            com.baidu.swan.games.v.c.g(abH, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty clientId");
        } else {
            JSONObject iP = iP(str);
            if (iP == null) {
                com.baidu.swan.games.v.c.g(abH, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                return new com.baidu.swan.apps.api.c.b(201, "empty joParams");
            }
            final String optString = iP.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.swan.games.v.c.g(abH, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                return new com.baidu.swan.apps.api.c.b(201, "empty cb");
            }
            SwanAppActivity azC = getContext() instanceof Activity ? (Activity) getContext() : azJ.azC();
            if (azC == null) {
                com.baidu.swan.games.v.c.g(abH, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                return new com.baidu.swan.apps.api.c.b(1001, "the context is not an activity");
            }
            final String pB = com.baidu.swan.apps.ac.g.b.pB(iP.optString("__plugin__", null));
            com.baidu.swan.apps.a.b azV = azJ.azV();
            final boolean bC = com.baidu.swan.apps.setting.oauth.c.bC(iP);
            if (azV.isLogin(azC) || !bC) {
                a(bC, optString, azC, pB, "snsapi_userinfo");
            } else {
                final Activity activity = azC;
                azV.a(azC, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.api.module.h.a.4
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                a.this.a(bC, optString, activity, pB, "snsapi_userinfo");
                                return;
                            default:
                                a.this.a(optString, new com.baidu.swan.apps.api.c.b(10004, "user not logged in"));
                                return;
                        }
                    }
                });
            }
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final String str, Activity activity, String str2, String str3) {
        com.baidu.swan.apps.setting.b.a.a(activity, str3, str2, z, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.api.module.h.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void I(com.baidu.swan.apps.setting.b.a aVar) {
                com.baidu.swan.apps.api.c.b bVar;
                com.baidu.swan.apps.console.c.d("OpenData", "onOpenDataCallback:: ", aVar);
                if (aVar.aCb()) {
                    bVar = new com.baidu.swan.apps.api.c.b(0, aVar.cVz);
                } else {
                    int aEc = (int) aVar.cWr.aEc();
                    bVar = new com.baidu.swan.apps.api.c.b(aEc, com.baidu.swan.apps.setting.oauth.c.gC(aEc));
                    com.baidu.swan.games.v.c.g(a.this.abJ().abH(), bVar.toJsonString());
                }
                a.this.a(str, bVar);
            }
        });
    }

    /* renamed from: com.baidu.swan.apps.api.module.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0360a {
        public static String b(e eVar) {
            String appKey;
            if (eVar == null) {
                appKey = com.baidu.swan.apps.runtime.d.azE().azA().getAppKey();
            } else {
                appKey = eVar.getAppKey();
            }
            return "aiapp_" + appKey + "getSwanId";
        }
    }
}
