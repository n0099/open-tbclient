package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.install.e;
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
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(1L).as(1L).iL("paramsValue is empty");
            com.baidu.swan.apps.ak.e.TR().b(iL);
            com.baidu.swan.apps.v.a.a.a(context, iL, 0, new com.baidu.swan.apps.v.a.c());
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(iL).ic(str2).aK("scheme", unitedSchemeEntity.getUri().toString()));
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
                com.baidu.swan.apps.ak.a iL2 = new com.baidu.swan.apps.ak.a().ar(1L).as(1L).iL("appId is empty");
                com.baidu.swan.apps.ak.e.TR().b(iL2);
                com.baidu.swan.apps.v.a.a.a(context, iL2, 0, new com.baidu.swan.apps.v.a.c());
                com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(iL2).ic(str2).aK("scheme", unitedSchemeEntity.getUri().toString()));
                return false;
            }
            final com.baidu.swan.apps.v.b.c cVar = new com.baidu.swan.apps.v.b.c();
            cVar.mAppId = optString;
            cVar.aSM = optString2;
            cVar.mFrom = str2;
            cVar.aSQ = unitedSchemeEntity.getUri().toString();
            cVar.aSP = optString6;
            cVar.aSR = optString7;
            String valueOf = String.valueOf(System.currentTimeMillis());
            com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("start", valueOf, ""));
            com.baidu.swan.apps.statistic.b.c.e(cVar);
            cVar.ar("ext_stats_funnel_start", valueOf);
            if (bVar != null && !TextUtils.isEmpty(optString4)) {
                cVar.ar("extraData", optString3);
                cVar.ar("navi", optString4);
                com.baidu.swan.apps.v.b.b AK = bVar.AK();
                if (AK == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String appId = AK.getAppId();
                if (com.baidu.swan.apps.f.a.a(AK) && !com.baidu.swan.apps.f.a.dQ(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                cVar.ar("srcAppId", appId);
                cVar.ar("srcAppPage", RO());
            }
            if (DEBUG && !TextUtils.isEmpty(optString5)) {
                e.c cVar2 = new e.c();
                cVar2.mAppId = optString;
                cVar2.mDownloadUrl = optString5;
                com.baidu.swan.apps.install.e.a(cVar2, new e.b() { // from class: com.baidu.swan.apps.scheme.actions.m.1
                    @Override // com.baidu.swan.apps.install.e.b
                    public void cr(int i) {
                    }

                    @Override // com.baidu.swan.apps.install.e.b
                    public void onSuccess() {
                        cVar.aSS = "1.6.0";
                        cVar.aSN = true;
                        com.baidu.swan.apps.u.a.Jj().startActivity(com.baidu.swan.apps.v.b.c.c(com.baidu.swan.apps.u.a.Jj(), cVar));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    }

                    @Override // com.baidu.swan.apps.install.e.b
                    public void onFailed() {
                        com.baidu.swan.apps.ak.a iL3 = new com.baidu.swan.apps.ak.a().ar(7L).as(9L).iL("debug download pkg fail");
                        com.baidu.swan.apps.ak.e.TR().b(iL3);
                        com.baidu.swan.apps.v.a.c cVar3 = new com.baidu.swan.apps.v.a.c();
                        cVar3.mAppId = optString;
                        com.baidu.swan.apps.v.a.a.a(com.baidu.swan.apps.u.a.Jj(), iL3, 0, cVar3);
                        com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(iL3).c(cVar));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    }
                });
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                String valueOf2 = String.valueOf(System.currentTimeMillis());
                com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("scheme", valueOf2, ""));
                cVar.ar("ext_stats_funnel_scheme", valueOf2);
                cVar.aSN = false;
                Intent c = com.baidu.swan.apps.v.b.c.c(context, cVar);
                c.addFlags(268435456);
                context.startActivity(c);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.ak.a iL3 = new com.baidu.swan.apps.ak.a().ar(1L).as(1L).iL("release but downloadUrl is not empty");
                com.baidu.swan.apps.ak.e.TR().b(iL3);
                com.baidu.swan.apps.v.a.c cVar3 = new com.baidu.swan.apps.v.a.c();
                cVar3.mAppId = optString;
                com.baidu.swan.apps.v.a.a.a(context, iL3, 0, cVar3);
                com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().ic(str2).ib(optString).c(cVar).aK("scheme", unitedSchemeEntity.getUri().toString()));
                return false;
            }
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.ak.a iL4 = new com.baidu.swan.apps.ak.a().ar(1L).as(1L).iL("parse paramsValue with JSONException:" + e.getMessage());
            com.baidu.swan.apps.ak.e.TR().b(iL4);
            com.baidu.swan.apps.v.a.a.a(context, iL4, 0, new com.baidu.swan.apps.v.a.c());
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(iL4).ic(str2).aK("scheme", unitedSchemeEntity.getUri().toString()));
            return false;
        }
    }

    private String RO() {
        com.baidu.swan.apps.core.d.e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI == null || AI.Fs() == null) {
            return "";
        }
        return AI.Fs().Ff();
    }
}
