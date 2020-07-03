package com.baidu.swan.apps.api.module.h;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.w.f;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ia(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-Setting", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aR.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Setting", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) aR.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                c.e("Api-Setting", "empty cb");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "empty cb");
        }
        Context context = getContext();
        if (!(context instanceof Activity)) {
            if (DEBUG) {
                c.e("Api-Setting", "available context");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "available context");
        }
        P(context, optString);
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private void P(Context context, final String str) {
        c.i("Api-Setting", "getSwanId start");
        if (!SwanAppNetworkUtils.isNetworkConnected(context)) {
            c.e("Api-Setting", "network_error");
            a(str, new com.baidu.swan.apps.api.c.b(10002, "network_error"));
            return;
        }
        com.baidu.swan.apps.runtime.d.apI().apK().Se().TF().C((Activity) context).q(new com.baidu.swan.apps.aq.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.api.module.h.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<JSONObject> hVar) {
                if (hVar.isOk() && hVar.mData != null) {
                    a.this.a(str, new com.baidu.swan.apps.api.c.b(0, hVar.mData));
                    return;
                }
                c.e("Api-Setting", "getSwanId failed: internal_error");
                a.this.a(str, new com.baidu.swan.apps.api.c.b(10001, "getSwanId failed: internal_error"));
            }
        }).ary();
    }

    public com.baidu.swan.apps.api.c.b Vq() {
        if (DEBUG) {
            Log.d("Api-Setting", "start get app info sync");
        }
        e apN = e.apN();
        if (apN == null) {
            c.e("Api-Setting", "illegal swanApp");
            return new com.baidu.swan.apps.api.c.b(1001, "illegal swanApp");
        }
        try {
            JSONObject a = a(apN, getContext());
            if (DEBUG && a != null) {
                Log.d("Api-Setting", "data: " + a.toString());
            }
            return new com.baidu.swan.apps.api.c.b(0, a);
        } catch (JSONException e) {
            c.e("Api-Setting", Log.getStackTraceString(e));
            return new com.baidu.swan.apps.api.c.b(1001);
        }
    }

    public static JSONObject a(e eVar, Context context) throws JSONException {
        b.a apQ = eVar.apQ();
        String ahQ = apQ.ahQ();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appid", apQ.getAppId());
        jSONObject.put("appname", apQ.acZ());
        if (!TextUtils.isEmpty(apQ.getIconUrl())) {
            jSONObject.put("iconUrl", apQ.getIconUrl());
        }
        if (!TextUtils.isEmpty(apQ.ahS())) {
            jSONObject.put("appLaunchScheme", apQ.ahS());
        } else {
            jSONObject.put("appLaunchScheme", "");
        }
        if (apQ.aig() != null) {
            String str = apQ.aig().description;
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("appDesc", str);
            }
        }
        String bd = com.baidu.swan.apps.u.a.agc().bd(context);
        jSONObject.put("cuid", bd);
        jSONObject.put("mtjCuid", bd);
        if (com.baidu.swan.apps.aq.h.auq() || !com.baidu.swan.apps.performance.b.b.amR()) {
            jSONObject.put("mtjFavor", SwanFavorDataManager.aec().ku(apQ.getAppKey()));
        }
        jSONObject.put("clkid", apQ.ahX());
        jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, ahQ);
        jSONObject.put("appId", apQ.getAppId());
        Bundle ahV = apQ.ahV();
        if (ahV != null) {
            String string = ahV.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("extraData", new JSONObject(string));
            }
            if (!TextUtils.isEmpty(ahV.getString("srcAppId"))) {
                jSONObject.put("srcAppId", ahV.getString("srcAppId"));
            }
            if (!TextUtils.isEmpty(ahV.getString("srcAppPage"))) {
                jSONObject.put("srcAppPage", ahV.getString("srcAppPage"));
            }
            if (TextUtils.isEmpty(ahQ)) {
                ahQ = "NA";
            }
            String string2 = ahV.getString("ubc");
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("rootSource", com.baidu.swan.e.c.c(new JSONObject(string2), "pre_source", ahQ));
            }
            String str2 = "sys";
            SwanAppActivity aiL = f.ajb().aiL();
            if (aiL != null) {
                str2 = aiL.RL();
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

    public com.baidu.swan.apps.api.c.b Vr() {
        if (DEBUG) {
            Log.d("Api-Setting", "start get slave id sync");
        }
        String containerId = UY().UX().getContainerId();
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

    public com.baidu.swan.apps.api.c.b ib(String str) {
        if (DEBUG) {
            Log.d("Api-Setting", "start request");
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.h.a.2
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(e eVar, JSONObject jSONObject, @Nullable String str2) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                a.a(a.this.UY().UW(), str2);
                return new com.baidu.swan.apps.api.c.b(0);
            }
        });
    }

    public static void a(final CallbackHandler callbackHandler, final String str) {
        com.baidu.swan.apps.network.c.b.a.k(new com.baidu.swan.apps.aq.e.b<Map<String, com.baidu.swan.apps.setting.oauth.e>>() { // from class: com.baidu.swan.apps.api.module.h.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: n */
            public void H(Map<String, com.baidu.swan.apps.setting.oauth.e> map) {
                if (map == null) {
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, com.baidu.swan.apps.setting.oauth.e> entry : map.entrySet()) {
                        String key = entry.getKey();
                        com.baidu.swan.apps.setting.oauth.e value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && value != null && value.arF() && !value.forbidden && TextUtils.equals("2", value.grade)) {
                            jSONObject.put(key, value.arE() ? "1" : "0");
                        }
                    }
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } catch (JSONException e) {
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        });
    }

    public com.baidu.swan.apps.api.c.b ic(String str) {
        if (DEBUG) {
            Log.d("Api-Setting", "start get user info");
        }
        e apN = e.apN();
        CallbackHandler UW = UY().UW();
        if (apN == null) {
            com.baidu.swan.games.v.c.g(UW, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty swanApp");
        } else if (TextUtils.isEmpty(apN.getAppKey())) {
            com.baidu.swan.games.v.c.g(UW, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty clientId");
        } else {
            JSONObject hk = hk(str);
            if (hk == null) {
                com.baidu.swan.games.v.c.g(UW, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                return new com.baidu.swan.apps.api.c.b(201, "empty joParams");
            }
            final String optString = hk.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.swan.games.v.c.g(UW, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                return new com.baidu.swan.apps.api.c.b(201, "empty cb");
            }
            final Context context = getContext();
            if (!(context instanceof Activity)) {
                com.baidu.swan.games.v.c.g(UW, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                return new com.baidu.swan.apps.api.c.b(1001, "the context is not an activity");
            }
            final String mW = com.baidu.swan.apps.ae.g.b.mW(hk.optString("__plugin__", null));
            com.baidu.swan.apps.a.b apZ = apN.apZ();
            final boolean bp = com.baidu.swan.apps.setting.oauth.c.bp(hk);
            if (apZ.isLogin(context) || !bp) {
                a(bp, optString, (Activity) context, mW, "snsapi_userinfo");
            } else {
                apZ.a((Activity) context, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.api.module.h.a.4
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                a.this.a(bp, optString, (Activity) context, mW, "snsapi_userinfo");
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
        com.baidu.swan.apps.setting.b.a.a(activity, str3, str2, z, new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.api.module.h.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(com.baidu.swan.apps.setting.b.a aVar) {
                com.baidu.swan.apps.api.c.b bVar;
                c.i("OpenData", "onOpenDataCallback:: " + aVar.toString());
                if (aVar.arW()) {
                    bVar = new com.baidu.swan.apps.api.c.b(0, aVar.cJq);
                } else {
                    int atS = (int) aVar.cKe.atS();
                    bVar = new com.baidu.swan.apps.api.c.b(atS, com.baidu.swan.apps.setting.oauth.c.gZ(atS));
                    com.baidu.swan.games.v.c.g(a.this.UY().UW(), bVar.toJsonString());
                }
                a.this.a(str, bVar);
            }
        });
    }
}
