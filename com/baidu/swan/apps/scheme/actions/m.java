package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.install.c;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m extends y {
    public m(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/launch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("LaunchAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str = params.get(LegoListActivityConfig.PARAMS);
        String str2 = params.get("from");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(1L).M(1L).hw("paramsValue is empty");
            com.baidu.swan.apps.ak.e.LG().b(hw);
            com.baidu.swan.apps.v.a.a.a(context, hw, 0);
            com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().a(hw).gT(str2).aA("scheme", unitedSchemeEntity.getUri().toString()));
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appid");
            String optString2 = jSONObject.optString("url");
            String optString3 = jSONObject.optString("extraData");
            String optString4 = jSONObject.optString("navi");
            String optString5 = jSONObject.optString("downloadurl");
            String optString6 = jSONObject.optString("clkid");
            String optString7 = jSONObject.optString("notinhis");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.ak.a hw2 = new com.baidu.swan.apps.ak.a().L(1L).M(1L).hw("appId is empty");
                com.baidu.swan.apps.ak.e.LG().b(hw2);
                com.baidu.swan.apps.v.a.a.a(context, hw2, 0);
                com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().a(hw2).gT(str2).aA("scheme", unitedSchemeEntity.getUri().toString()));
                return false;
            }
            final com.baidu.swan.apps.v.b.c cVar = new com.baidu.swan.apps.v.b.c();
            cVar.mAppId = optString;
            cVar.axI = optString2;
            cVar.mFrom = str2;
            cVar.axH = unitedSchemeEntity.getUri().toString();
            cVar.axR = optString6;
            cVar.axT = optString7;
            String valueOf = String.valueOf(System.currentTimeMillis());
            com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a(IntentConfig.START, valueOf, ""));
            com.baidu.swan.apps.statistic.b.c.e(cVar);
            cVar.al("ext_stats_funnel_start", valueOf);
            if (bVar != null && !TextUtils.isEmpty(optString4)) {
                cVar.al("extraData", optString3);
                cVar.al("navi", optString4);
                com.baidu.swan.apps.v.b.b uB = bVar.uB();
                if (uB == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String str3 = uB.mAppId;
                if (com.baidu.swan.apps.f.a.a(uB) && !com.baidu.swan.apps.f.a.dm(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                cVar.al("srcAppId", str3);
                cVar.al("srcAppPage", JK());
            }
            if (DEBUG && !TextUtils.isEmpty(optString5)) {
                c.C0144c c0144c = new c.C0144c();
                c0144c.mAppId = optString;
                c0144c.mDownloadUrl = optString5;
                com.baidu.swan.apps.install.c.a(c0144c, new c.b() { // from class: com.baidu.swan.apps.scheme.actions.m.1
                    @Override // com.baidu.swan.apps.install.c.b
                    public void cv(int i) {
                    }

                    @Override // com.baidu.swan.apps.install.c.b
                    public void onSuccess() {
                        cVar.axW = "1.6.0";
                        cVar.axS = true;
                        com.baidu.swan.apps.u.a.Cy().startActivity(com.baidu.swan.apps.v.b.c.c(com.baidu.swan.apps.u.a.Cy(), cVar));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    }

                    @Override // com.baidu.swan.apps.install.c.b
                    public void onFailed() {
                        com.baidu.swan.apps.ak.a hw3 = new com.baidu.swan.apps.ak.a().L(7L).M(9L).hw("debug download pkg fail");
                        com.baidu.swan.apps.ak.e.LG().b(hw3);
                        com.baidu.swan.apps.v.a.a.a(com.baidu.swan.apps.u.a.Cy(), hw3, 0);
                        com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().a(hw3).c(cVar));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    }
                });
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                String valueOf2 = String.valueOf(System.currentTimeMillis());
                com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("scheme", valueOf2, ""));
                cVar.al("ext_stats_funnel_scheme", valueOf2);
                cVar.axS = false;
                Intent c = com.baidu.swan.apps.v.b.c.c(context, cVar);
                c.addFlags(268435456);
                context.startActivity(c);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.ak.a hw3 = new com.baidu.swan.apps.ak.a().L(1L).M(1L).hw("release but downloadUrl is not empty");
                com.baidu.swan.apps.ak.e.LG().b(hw3);
                com.baidu.swan.apps.v.a.a.a(context, hw3, 0);
                com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().gT(str2).gS(optString).c(cVar).aA("scheme", unitedSchemeEntity.getUri().toString()));
                return false;
            }
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.ak.a hw4 = new com.baidu.swan.apps.ak.a().L(1L).M(1L).hw("parse paramsValue with JSONException:" + e.getMessage());
            com.baidu.swan.apps.ak.e.LG().b(hw4);
            com.baidu.swan.apps.v.a.a.a(context, hw4, 0);
            com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().a(hw4).gT(str2).aA("scheme", unitedSchemeEntity.getUri().toString()));
            return false;
        }
    }

    private String JK() {
        com.baidu.swan.apps.core.c.e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz == null || uz.yP() == null) {
            return "";
        }
        return uz.yP().yE();
    }
}
