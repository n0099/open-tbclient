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
/* loaded from: classes10.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lg(String str) {
        e aEM = com.baidu.swan.apps.runtime.d.aEQ().aEM();
        final JSONObject parseString = v.parseString(aEM.aFg().getString(C0386a.b(aEM), (String) null));
        return a(str, new c("getSwanId") { // from class: com.baidu.swan.apps.api.module.h.a.1
            @Override // com.baidu.swan.apps.api.a.c
            protected boolean agZ() {
                if (com.baidu.swan.apps.performance.b.c.aBx() && !i.aJP()) {
                    return a.this.aL(parseString);
                }
                return false;
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull final c.a aVar) {
                if (com.baidu.swan.apps.performance.b.c.aBx() && a.this.aL(parseString)) {
                    aVar.b(new com.baidu.swan.apps.api.c.b(0, parseString));
                    return new com.baidu.swan.apps.api.c.b(0);
                }
                com.baidu.swan.apps.console.c.i("Api-Setting", "getSwanId start");
                if (!SwanAppNetworkUtils.isNetworkConnected(a.this.getContext())) {
                    com.baidu.swan.apps.console.c.e("Api-Setting", "network_error");
                    return new com.baidu.swan.apps.api.c.b(10002, "network_error");
                }
                com.baidu.swan.apps.runtime.d.aEQ().aES().adF().afw().bm(a.this.getContext()).A(new com.baidu.swan.apps.ap.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.api.module.h.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(h<JSONObject> hVar) {
                        if (hVar.isOk() && hVar.mData != null) {
                            aVar.b(new com.baidu.swan.apps.api.c.b(0, hVar.mData));
                            e aEM2 = com.baidu.swan.apps.runtime.d.aEQ().aEM();
                            aEM2.aFg().putString(C0386a.b(aEM2), hVar.mData.toString());
                            com.baidu.swan.apps.console.c.i("Api-Setting", "getSwanId success");
                            return;
                        }
                        aVar.b(new com.baidu.swan.apps.api.c.b(10001, "getSwanId failed: internal_error"));
                        com.baidu.swan.apps.console.c.e("Api-Setting", "getSwanId failed: internal_error");
                    }
                }).aGL();
                return new com.baidu.swan.apps.api.c.b(0);
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b aC(@NonNull JSONObject jSONObject) {
                return new com.baidu.swan.apps.api.c.b(0, parseString);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aL(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return false;
        }
        String optString = optJSONObject.optString("swanid");
        return (TextUtils.isEmpty(optString) || TextUtils.equals("null", optString)) ? false : true;
    }

    public com.baidu.swan.apps.api.c.b ahr() {
        com.baidu.swan.apps.console.c.d("Api-Setting", "start get app info sync");
        e aEV = e.aEV();
        if (aEV == null) {
            com.baidu.swan.apps.console.c.d("Api-Setting", "illegal swanApp");
            return new com.baidu.swan.apps.api.c.b(1001, "illegal swanApp");
        }
        try {
            JSONObject a2 = a(aEV, getContext());
            if (DEBUG && a2 != null) {
                Log.d("Api-Setting", "data: " + a2.toString());
            }
            return new com.baidu.swan.apps.api.c.b(0, a2);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Api-Setting", Log.getStackTraceString(e));
            return new com.baidu.swan.apps.api.c.b(1001);
        }
    }

    public static JSONObject a(e eVar, Context context) throws JSONException {
        b.a aEY = eVar.aEY();
        String awd = aEY.awd();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appid", aEY.getAppId());
        jSONObject.put("appname", aEY.aqe());
        if (!TextUtils.isEmpty(aEY.getIconUrl())) {
            jSONObject.put("iconUrl", aEY.getIconUrl());
        }
        if (!TextUtils.isEmpty(aEY.awf())) {
            jSONObject.put("appLaunchScheme", aEY.awf());
        } else {
            jSONObject.put("appLaunchScheme", "");
        }
        PMSAppInfo awt = aEY.awt();
        if (awt != null) {
            String str = awt.description;
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("appDesc", str);
            }
        }
        String bq = com.baidu.swan.apps.t.a.auf().bq(context);
        jSONObject.put("cuid", bq);
        jSONObject.put("mtjCuid", bq);
        jSONObject.put("clkid", aEY.awk());
        jSONObject.put("scene", awd);
        jSONObject.put("appId", aEY.getAppId());
        Bundle awi = aEY.awi();
        if (awi != null) {
            String string = awi.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("extraData", new JSONObject(string));
            }
            if (!TextUtils.isEmpty(awi.getString("srcAppId"))) {
                jSONObject.put("srcAppId", awi.getString("srcAppId"));
            }
            if (!TextUtils.isEmpty(awi.getString("srcAppPage"))) {
                jSONObject.put("srcAppPage", awi.getString("srcAppPage"));
            }
            if (TextUtils.isEmpty(awd)) {
                awd = "NA";
            }
            String string2 = awi.getString("ubc");
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("rootSource", com.baidu.swan.c.c.c(new JSONObject(string2), "pre_source", awd));
            }
            String str2 = "sys";
            SwanAppActivity awY = f.axo().awY();
            if (awY != null) {
                str2 = awY.adk();
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

    public com.baidu.swan.apps.api.c.b ahs() {
        if (DEBUG) {
            Log.d("Api-Setting", "start get slave id sync");
        }
        String containerId = agY().agX().getContainerId();
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

    public com.baidu.swan.apps.api.c.b lh(String str) {
        if (DEBUG) {
            Log.d("Api-Setting", "start request");
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.h.a.2
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(e eVar, JSONObject jSONObject, @Nullable String str2) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                a.a(a.this.agY().agW(), str2);
                return new com.baidu.swan.apps.api.c.b(0);
            }
        });
    }

    public static void a(final CallbackHandler callbackHandler, final String str) {
        com.baidu.swan.apps.network.c.b.a.s(new com.baidu.swan.apps.ap.e.b<Map<String, com.baidu.swan.apps.setting.oauth.e>>() { // from class: com.baidu.swan.apps.api.module.h.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: x */
            public void M(Map<String, com.baidu.swan.apps.setting.oauth.e> map) {
                if (map == null) {
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, com.baidu.swan.apps.setting.oauth.e> entry : map.entrySet()) {
                        String key = entry.getKey();
                        com.baidu.swan.apps.setting.oauth.e value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && value != null && value.aGS() && !value.forbidden && TextUtils.equals("2", value.grade)) {
                            jSONObject.put(key, value.aGR() ? "1" : "0");
                        }
                    }
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } catch (JSONException e) {
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        });
    }

    public com.baidu.swan.apps.api.c.b li(String str) {
        if (DEBUG) {
            Log.d("Api-Setting", "start get user info");
        }
        e aEV = e.aEV();
        CallbackHandler agW = agY().agW();
        if (aEV == null) {
            com.baidu.swan.games.v.c.g(agW, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty swanApp");
        } else if (TextUtils.isEmpty(aEV.getAppKey())) {
            com.baidu.swan.games.v.c.g(agW, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty clientId");
        } else {
            JSONObject ko = ko(str);
            if (ko == null) {
                com.baidu.swan.games.v.c.g(agW, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                return new com.baidu.swan.apps.api.c.b(201, "empty joParams");
            }
            final String optString = ko.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.swan.games.v.c.g(agW, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                return new com.baidu.swan.apps.api.c.b(201, "empty cb");
            }
            SwanAppActivity aEO = getContext() instanceof Activity ? (Activity) getContext() : aEV.aEO();
            if (aEO == null) {
                com.baidu.swan.games.v.c.g(agW, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                return new com.baidu.swan.apps.api.c.b(1001, "the context is not an activity");
            }
            final String ra = com.baidu.swan.apps.ac.g.b.ra(ko.optString("__plugin__", null));
            com.baidu.swan.apps.a.b aFh = aEV.aFh();
            final boolean bP = com.baidu.swan.apps.setting.oauth.c.bP(ko);
            if (aFh.isLogin(aEO) || !bP) {
                a(bP, optString, aEO, ra, "snsapi_userinfo");
            } else {
                final Activity activity = aEO;
                aFh.a(aEO, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.api.module.h.a.4
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                a.this.a(bP, optString, activity, ra, "snsapi_userinfo");
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
            public void M(com.baidu.swan.apps.setting.b.a aVar) {
                com.baidu.swan.apps.api.c.b bVar;
                com.baidu.swan.apps.console.c.d("OpenData", "onOpenDataCallback:: ", aVar);
                if (aVar.aHo()) {
                    bVar = new com.baidu.swan.apps.api.c.b(0, aVar.dsn);
                } else {
                    int aJp = (int) aVar.dtg.aJp();
                    bVar = new com.baidu.swan.apps.api.c.b(aJp, com.baidu.swan.apps.setting.oauth.c.ht(aJp));
                    com.baidu.swan.games.v.c.g(a.this.agY().agW(), bVar.toJsonString());
                }
                a.this.a(str, bVar);
            }
        });
    }

    /* renamed from: com.baidu.swan.apps.api.module.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0386a {
        public static String b(e eVar) {
            String appKey;
            if (eVar == null) {
                appKey = com.baidu.swan.apps.runtime.d.aEQ().aEM().getAppKey();
            } else {
                appKey = eVar.getAppKey();
            }
            return "aiapp_" + appKey + "getSwanId";
        }
    }
}
