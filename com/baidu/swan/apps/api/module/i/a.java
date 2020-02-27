package com.baidu.swan.apps.api.module.i;

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
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.apps.y.f;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends c {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b fP(String str) {
        e acD = e.acD();
        if (acD == null) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Setting", "illegal swanApp");
            }
            return new com.baidu.swan.apps.api.b.b(1001, "illegal swanApp");
        } else if (TextUtils.isEmpty(acD.getAppKey())) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Setting", "empty clientId");
            }
            return new com.baidu.swan.apps.api.b.b(1001, "empty clientId");
        } else {
            Pair<com.baidu.swan.apps.api.b.b, JSONObject> ar = com.baidu.swan.apps.api.c.b.ar("Api-Setting", str);
            com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ar.first;
            if (!bVar.isSuccess()) {
                if (DEBUG) {
                    com.baidu.swan.apps.console.c.e("Api-Setting", "parse fail");
                    return bVar;
                }
                return bVar;
            }
            String optString = ((JSONObject) ar.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (DEBUG) {
                    com.baidu.swan.apps.console.c.e("Api-Setting", "empty cb");
                }
                return new com.baidu.swan.apps.api.b.b(1001, "empty cb");
            }
            Context context = getContext();
            if (!(context instanceof Activity)) {
                if (DEBUG) {
                    com.baidu.swan.apps.console.c.e("Api-Setting", "available context");
                }
                return new com.baidu.swan.apps.api.b.b(1001, "available context");
            }
            ah(context, optString);
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }

    private void ah(Context context, final String str) {
        com.baidu.swan.apps.console.c.i("Api-Setting", "getSwanId start");
        if (!SwanAppNetworkUtils.isNetworkConnected(context)) {
            com.baidu.swan.apps.console.c.e("Api-Setting", "network_error");
            a(str, new com.baidu.swan.apps.api.b.b(10002, "network_error"));
            return;
        }
        d.acA().acC().GT().HQ().G((Activity) context).h(new com.baidu.swan.apps.as.d.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.api.module.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(h<JSONObject> hVar) {
                if (hVar.isOk() && hVar.mData != null) {
                    a.this.a(str, new com.baidu.swan.apps.api.b.b(0, hVar.mData));
                    return;
                }
                com.baidu.swan.apps.console.c.e("Api-Setting", "getSwanId failed: internal_error");
                a.this.a(str, new com.baidu.swan.apps.api.b.b(10001, "getSwanId failed: internal_error"));
            }
        }).aeg();
    }

    public com.baidu.swan.apps.api.b.b JS() {
        if (DEBUG) {
            Log.d("Api-Setting", "start get app info sync");
        }
        e acE = e.acE();
        if (acE == null) {
            com.baidu.swan.apps.console.c.e("Api-Setting", "illegal swanApp");
            return new com.baidu.swan.apps.api.b.b(1001, "illegal swanApp");
        }
        try {
            JSONObject a = a(acE, getContext());
            if (DEBUG && a != null) {
                Log.d("Api-Setting", "data: " + a.toString());
            }
            return new com.baidu.swan.apps.api.b.b(0, a);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Api-Setting", Log.getStackTraceString(e));
            return new com.baidu.swan.apps.api.b.b(1001);
        }
    }

    public static JSONObject a(e eVar, Context context) throws JSONException {
        b.a acG = eVar.acG();
        String VH = acG.VH();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appid", acG.getAppId());
        jSONObject.put("appname", acG.QZ());
        if (!TextUtils.isEmpty(acG.getIconUrl())) {
            jSONObject.put("iconUrl", acG.getIconUrl());
        }
        if (!TextUtils.isEmpty(acG.VJ())) {
            jSONObject.put("appLaunchScheme", acG.VJ());
        } else {
            jSONObject.put("appLaunchScheme", "");
        }
        if (acG.VX() != null) {
            String str = acG.VX().description;
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("appDesc", str);
            }
        }
        String br = com.baidu.swan.apps.w.a.TZ().br(context);
        jSONObject.put("cuid", br);
        jSONObject.put("mtjCuid", br);
        jSONObject.put("clkid", acG.VO());
        jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, VH);
        jSONObject.put("appId", acG.getAppId());
        Bundle VM = acG.VM();
        if (VM != null) {
            String string = VM.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("extraData", new JSONObject(string));
            }
            if (!TextUtils.isEmpty(VM.getString("srcAppId"))) {
                jSONObject.put("srcAppId", VM.getString("srcAppId"));
            }
            if (!TextUtils.isEmpty(VM.getString("srcAppPage"))) {
                jSONObject.put("srcAppPage", VM.getString("srcAppPage"));
            }
            if (TextUtils.isEmpty(VH)) {
                VH = "NA";
            }
            String string2 = VM.getString("ubc");
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("rootSource", com.baidu.swan.d.b.c(new JSONObject(string2), "pre_source", VH));
            }
            String str2 = "sys";
            SwanAppActivity WB = f.WQ().WB();
            if (WB != null) {
                str2 = WB.Gy();
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

    public com.baidu.swan.apps.api.b.b JT() {
        if (DEBUG) {
            Log.d("Api-Setting", "start get slave id sync");
        }
        String containerId = JC().JB().getContainerId();
        if (TextUtils.isEmpty(containerId)) {
            return new com.baidu.swan.apps.api.b.b(1001);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("slaveId", containerId);
            return new com.baidu.swan.apps.api.b.b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("Api-Setting", Log.getStackTraceString(e));
            }
            return new com.baidu.swan.apps.api.b.b(1001);
        }
    }

    public com.baidu.swan.apps.api.b.b fQ(String str) {
        if (DEBUG) {
            Log.d("Api-Setting", "start request");
        }
        return a(str, true, new c.a() { // from class: com.baidu.swan.apps.api.module.i.a.2
            @Override // com.baidu.swan.apps.api.a.c.a
            public com.baidu.swan.apps.api.b.b a(e eVar, JSONObject jSONObject, @Nullable String str2) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                a.a(a.this.JC().JA(), str2);
                return new com.baidu.swan.apps.api.b.b(0);
            }
        });
    }

    public static void a(final CallbackHandler callbackHandler, final String str) {
        com.baidu.swan.apps.network.c.b.a.d(new com.baidu.swan.apps.as.d.b<Map<String, com.baidu.swan.apps.setting.oauth.e>>() { // from class: com.baidu.swan.apps.api.module.i.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: n */
            public void D(Map<String, com.baidu.swan.apps.setting.oauth.e> map) {
                if (map == null) {
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, com.baidu.swan.apps.setting.oauth.e> entry : map.entrySet()) {
                        String key = entry.getKey();
                        com.baidu.swan.apps.setting.oauth.e value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && value != null && value.aen()) {
                            jSONObject.put(key, value.aem() ? "1" : "0");
                        }
                    }
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } catch (JSONException e) {
                    CallbackHandler.this.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        });
    }

    public com.baidu.swan.apps.api.b.b fR(String str) {
        if (DEBUG) {
            Log.d("Api-Setting", "start get user info");
        }
        e acE = e.acE();
        CallbackHandler JA = JC().JA();
        if (acE == null) {
            com.baidu.swan.games.u.c.f(JA, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.b.b(1001, "empty swanApp");
        } else if (TextUtils.isEmpty(acE.getAppKey())) {
            com.baidu.swan.games.u.c.h(JA, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
            return new com.baidu.swan.apps.api.b.b(1001, "empty clientId");
        } else {
            JSONObject fd = fd(str);
            if (fd == null) {
                com.baidu.swan.games.u.c.f(JA, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                return new com.baidu.swan.apps.api.b.b(201, "empty joParams");
            }
            final String optString = fd.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.swan.games.u.c.f(JA, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                return new com.baidu.swan.apps.api.b.b(201, "empty cb");
            }
            Context context = getContext();
            if (!(context instanceof Activity)) {
                com.baidu.swan.games.u.c.h(JA, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                return new com.baidu.swan.apps.api.b.b(1001, "the context is not an activity");
            }
            com.baidu.swan.apps.setting.b.a.a((Activity) context, "snsapi_userinfo", com.baidu.swan.apps.ag.g.b.kl(fd.optString("__plugin__", null)), com.baidu.swan.apps.setting.oauth.c.aO(fd), new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.api.module.i.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(com.baidu.swan.apps.setting.b.a aVar) {
                    com.baidu.swan.apps.api.b.b bVar;
                    com.baidu.swan.apps.console.c.i("OpenData", "onOpenDataCallback:: " + aVar.toString());
                    if (aVar.aeD()) {
                        bVar = new com.baidu.swan.apps.api.b.b(0, aVar.bTB);
                    } else {
                        int agi = (int) aVar.bUr.agi();
                        bVar = new com.baidu.swan.apps.api.b.b(agi, com.baidu.swan.apps.setting.oauth.c.gn(agi));
                        com.baidu.swan.games.u.c.h(a.this.JC().JA(), bVar.toJsonString());
                    }
                    a.this.a(optString, bVar);
                }
            });
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }
}
