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
import com.baidu.swan.apps.aq.i;
import com.baidu.swan.apps.aq.v;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ik(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-Setting", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Setting", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) aS.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                c.e("Api-Setting", "empty cb");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "empty cb");
        }
        Context context = getContext();
        if (com.baidu.swan.apps.performance.b.b.aop()) {
            e arn = com.baidu.swan.apps.runtime.d.arr().arn();
            String string = arn.arH().getString(C0314a.b(arn), (String) null);
            if (TextUtils.isEmpty(string)) {
                P(context, optString);
            } else {
                JSONObject parseString = v.parseString(string);
                JSONObject optJSONObject = parseString.optJSONObject("data");
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString("swanid");
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.equals("null", optString2)) {
                        a(optString, new com.baidu.swan.apps.api.c.b(0, parseString));
                        c.i("Api-Setting", "getSwanId success");
                    } else {
                        P(context, optString);
                    }
                } else {
                    P(context, optString);
                }
            }
        } else {
            P(context, optString);
        }
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private void P(Context context, final String str) {
        c.i("Api-Setting", "getSwanId start");
        if (!SwanAppNetworkUtils.isNetworkConnected(context)) {
            c.e("Api-Setting", "network_error");
            a(str, new com.baidu.swan.apps.api.c.b(10002, "network_error"));
            return;
        }
        com.baidu.swan.apps.runtime.d.arr().art().Sv().Uf().bc(context).t(new com.baidu.swan.apps.aq.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.api.module.h.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<JSONObject> hVar) {
                if (hVar.isOk() && hVar.mData != null) {
                    a.this.a(str, new com.baidu.swan.apps.api.c.b(0, hVar.mData));
                    e arn = com.baidu.swan.apps.runtime.d.arr().arn();
                    arn.arH().putString(C0314a.b(arn), hVar.mData.toString());
                    c.i("Api-Setting", "getSwanId success");
                    return;
                }
                a.this.a(str, new com.baidu.swan.apps.api.c.b(10001, "getSwanId failed: internal_error"));
                c.e("Api-Setting", "getSwanId failed: internal_error");
            }
        }).atq();
    }

    public com.baidu.swan.apps.api.c.b VW() {
        c.d("Api-Setting", "start get app info sync");
        e arw = e.arw();
        if (arw == null) {
            c.d("Api-Setting", "illegal swanApp");
            return new com.baidu.swan.apps.api.c.b(1001, "illegal swanApp");
        }
        try {
            JSONObject a = a(arw, getContext());
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
        b.a arz = eVar.arz();
        String ajg = arz.ajg();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appid", arz.getAppId());
        jSONObject.put("appname", arz.aee());
        if (!TextUtils.isEmpty(arz.getIconUrl())) {
            jSONObject.put("iconUrl", arz.getIconUrl());
        }
        if (!TextUtils.isEmpty(arz.aji())) {
            jSONObject.put("appLaunchScheme", arz.aji());
        } else {
            jSONObject.put("appLaunchScheme", "");
        }
        PMSAppInfo ajw = arz.ajw();
        if (ajw != null) {
            String str = ajw.description;
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("appDesc", str);
            }
        }
        String bf = com.baidu.swan.apps.t.a.aho().bf(context);
        jSONObject.put("cuid", bf);
        jSONObject.put("mtjCuid", bf);
        if (i.aws() || !com.baidu.swan.apps.performance.b.b.aom()) {
            jSONObject.put("mtjFavor", SwanFavorDataManager.aft().kQ(arz.getAppKey()));
        }
        jSONObject.put("clkid", arz.ajn());
        jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, ajg);
        jSONObject.put("appId", arz.getAppId());
        Bundle ajl = arz.ajl();
        if (ajl != null) {
            String string = ajl.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("extraData", new JSONObject(string));
            }
            if (!TextUtils.isEmpty(ajl.getString("srcAppId"))) {
                jSONObject.put("srcAppId", ajl.getString("srcAppId"));
            }
            if (!TextUtils.isEmpty(ajl.getString("srcAppPage"))) {
                jSONObject.put("srcAppPage", ajl.getString("srcAppPage"));
            }
            if (TextUtils.isEmpty(ajg)) {
                ajg = "NA";
            }
            String string2 = ajl.getString("ubc");
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("rootSource", com.baidu.swan.d.c.c(new JSONObject(string2), "pre_source", ajg));
            }
            String str2 = "sys";
            SwanAppActivity akb = f.akr().akb();
            if (akb != null) {
                str2 = akb.Sa();
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

    public com.baidu.swan.apps.api.c.b VX() {
        if (DEBUG) {
            Log.d("Api-Setting", "start get slave id sync");
        }
        String containerId = VD().VC().getContainerId();
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

    public com.baidu.swan.apps.api.c.b il(String str) {
        if (DEBUG) {
            Log.d("Api-Setting", "start request");
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.h.a.2
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(e eVar, JSONObject jSONObject, @Nullable String str2) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                a.a(a.this.VD().VB(), str2);
                return new com.baidu.swan.apps.api.c.b(0);
            }
        });
    }

    public static void a(final CallbackHandler callbackHandler, final String str) {
        com.baidu.swan.apps.network.c.b.a.l(new com.baidu.swan.apps.aq.e.b<Map<String, com.baidu.swan.apps.setting.oauth.e>>() { // from class: com.baidu.swan.apps.api.module.h.a.3
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
                        if (!TextUtils.isEmpty(key) && value != null && value.atx() && !value.forbidden && TextUtils.equals("2", value.grade)) {
                            jSONObject.put(key, value.atw() ? "1" : "0");
                        }
                    }
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } catch (JSONException e) {
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        });
    }

    public com.baidu.swan.apps.api.c.b im(String str) {
        if (DEBUG) {
            Log.d("Api-Setting", "start get user info");
        }
        e arw = e.arw();
        CallbackHandler VB = VD().VB();
        if (arw == null) {
            com.baidu.swan.games.v.c.g(VB, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty swanApp");
        } else if (TextUtils.isEmpty(arw.getAppKey())) {
            com.baidu.swan.games.v.c.g(VB, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty clientId");
        } else {
            JSONObject hs = hs(str);
            if (hs == null) {
                com.baidu.swan.games.v.c.g(VB, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                return new com.baidu.swan.apps.api.c.b(201, "empty joParams");
            }
            final String optString = hs.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.swan.games.v.c.g(VB, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                return new com.baidu.swan.apps.api.c.b(201, "empty cb");
            }
            final Context context = getContext();
            if (!(context instanceof Activity)) {
                com.baidu.swan.games.v.c.g(VB, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                return new com.baidu.swan.apps.api.c.b(1001, "the context is not an activity");
            }
            final String nD = com.baidu.swan.apps.ad.g.b.nD(hs.optString("__plugin__", null));
            com.baidu.swan.apps.a.b arI = arw.arI();
            final boolean bu = com.baidu.swan.apps.setting.oauth.c.bu(hs);
            if (arI.isLogin(context) || !bu) {
                a(bu, optString, (Activity) context, nD, "snsapi_userinfo");
            } else {
                arI.a((Activity) context, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.api.module.h.a.4
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                a.this.a(bu, optString, (Activity) context, nD, "snsapi_userinfo");
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
                c.c("OpenData", "onOpenDataCallback:: ", aVar);
                if (aVar.atS()) {
                    bVar = new com.baidu.swan.apps.api.c.b(0, aVar.cMD);
                } else {
                    int avT = (int) aVar.cNv.avT();
                    bVar = new com.baidu.swan.apps.api.c.b(avT, com.baidu.swan.apps.setting.oauth.c.eE(avT));
                    com.baidu.swan.games.v.c.g(a.this.VD().VB(), bVar.toJsonString());
                }
                a.this.a(str, bVar);
            }
        });
    }

    /* renamed from: com.baidu.swan.apps.api.module.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0314a {
        public static String b(e eVar) {
            String appKey;
            if (eVar == null) {
                appKey = com.baidu.swan.apps.runtime.d.arr().arn().getAppKey();
            } else {
                appKey = eVar.getAppKey();
            }
            return "aiapp_" + appKey + "getSwanId";
        }
    }
}
