package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.install.e;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m extends z {
    public m(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/launch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("LaunchAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str = params.get("params");
        String str2 = params.get("from");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.ak.a hZ = new com.baidu.swan.apps.ak.a().Y(1L).Z(1L).hZ("paramsValue is empty");
            com.baidu.swan.apps.ak.e.Ok().b(hZ);
            com.baidu.swan.apps.v.a.a.a(context, hZ, 0, new com.baidu.swan.apps.v.a.c());
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(hZ).hr(str2).aC("scheme", unitedSchemeEntity.getUri().toString()));
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString("appid");
            String optString2 = jSONObject.optString("url");
            String optString3 = jSONObject.optString("extraData");
            String optString4 = jSONObject.optString("navi");
            String optString5 = jSONObject.optString("downloadurl");
            String optString6 = jSONObject.optString("clkid");
            String optString7 = jSONObject.optString("notinhis");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.ak.a hZ2 = new com.baidu.swan.apps.ak.a().Y(1L).Z(1L).hZ("appId is empty");
                com.baidu.swan.apps.ak.e.Ok().b(hZ2);
                com.baidu.swan.apps.v.a.a.a(context, hZ2, 0, new com.baidu.swan.apps.v.a.c());
                com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(hZ2).hr(str2).aC("scheme", unitedSchemeEntity.getUri().toString()));
                return false;
            }
            final com.baidu.swan.apps.v.b.c cVar = new com.baidu.swan.apps.v.b.c();
            cVar.mAppId = optString;
            cVar.ayL = optString2;
            cVar.mFrom = str2;
            cVar.ayP = unitedSchemeEntity.getUri().toString();
            cVar.ayO = optString6;
            cVar.ayQ = optString7;
            String valueOf = String.valueOf(System.currentTimeMillis());
            com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a(IntentConfig.START, valueOf, ""));
            com.baidu.swan.apps.statistic.b.c.e(cVar);
            cVar.aj("ext_stats_funnel_start", valueOf);
            if (bVar != null && !TextUtils.isEmpty(optString4)) {
                cVar.aj("extraData", optString3);
                cVar.aj("navi", optString4);
                com.baidu.swan.apps.v.b.b vk = bVar.vk();
                if (vk == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String appId = vk.getAppId();
                if (com.baidu.swan.apps.f.a.a(vk) && !com.baidu.swan.apps.f.a.db(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                cVar.aj("srcAppId", appId);
                cVar.aj("srcAppPage", Md());
            }
            if (DEBUG && !TextUtils.isEmpty(optString5)) {
                e.c cVar2 = new e.c();
                cVar2.mAppId = optString;
                cVar2.mDownloadUrl = optString5;
                com.baidu.swan.apps.install.e.a(cVar2, new e.b() { // from class: com.baidu.swan.apps.scheme.actions.m.1
                    @Override // com.baidu.swan.apps.install.e.b
                    public void cv(int i) {
                    }

                    @Override // com.baidu.swan.apps.install.e.b
                    public void onSuccess() {
                        cVar.ayR = "1.6.0";
                        cVar.ayM = true;
                        com.baidu.swan.apps.u.a.DB().startActivity(com.baidu.swan.apps.v.b.c.c(com.baidu.swan.apps.u.a.DB(), cVar));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    }

                    @Override // com.baidu.swan.apps.install.e.b
                    public void onFailed() {
                        com.baidu.swan.apps.ak.a hZ3 = new com.baidu.swan.apps.ak.a().Y(7L).Z(9L).hZ("debug download pkg fail");
                        com.baidu.swan.apps.ak.e.Ok().b(hZ3);
                        com.baidu.swan.apps.v.a.c cVar3 = new com.baidu.swan.apps.v.a.c();
                        cVar3.mAppId = optString;
                        com.baidu.swan.apps.v.a.a.a(com.baidu.swan.apps.u.a.DB(), hZ3, 0, cVar3);
                        com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(hZ3).c(cVar));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    }
                });
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                String valueOf2 = String.valueOf(System.currentTimeMillis());
                com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("scheme", valueOf2, ""));
                cVar.aj("ext_stats_funnel_scheme", valueOf2);
                cVar.ayM = false;
                Intent c = com.baidu.swan.apps.v.b.c.c(context, cVar);
                c.addFlags(268435456);
                context.startActivity(c);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.ak.a hZ3 = new com.baidu.swan.apps.ak.a().Y(1L).Z(1L).hZ("release but downloadUrl is not empty");
                com.baidu.swan.apps.ak.e.Ok().b(hZ3);
                com.baidu.swan.apps.v.a.c cVar3 = new com.baidu.swan.apps.v.a.c();
                cVar3.mAppId = optString;
                com.baidu.swan.apps.v.a.a.a(context, hZ3, 0, cVar3);
                com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().hr(str2).hq(optString).c(cVar).aC("scheme", unitedSchemeEntity.getUri().toString()));
                return false;
            }
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.ak.a hZ4 = new com.baidu.swan.apps.ak.a().Y(1L).Z(1L).hZ("parse paramsValue with JSONException:" + e.getMessage());
            com.baidu.swan.apps.ak.e.Ok().b(hZ4);
            com.baidu.swan.apps.v.a.a.a(context, hZ4, 0, new com.baidu.swan.apps.v.a.c());
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(hZ4).hr(str2).aC("scheme", unitedSchemeEntity.getUri().toString()));
            return false;
        }
    }

    private String Md() {
        com.baidu.swan.apps.core.d.e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi == null || vi.zL() == null) {
            return "";
        }
        return vi.zL().zy();
    }
}
