package com.baidu.swan.apps.u;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.u.c.c;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends aa {

    /* renamed from: com.baidu.swan.apps.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0479a {
        void ayH();

        void ayI();
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/launch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        String str;
        c.d("LaunchAction", "handle entity: ", unitedSchemeEntity);
        if (unitedSchemeEntity.getUri() == null) {
            str = "";
        } else {
            str = unitedSchemeEntity.getUri().toString();
        }
        c.i("LaunchAction", "launch scheme = " + str);
        String atM = SwanLauncher.atM();
        d.aIJ().aIF().aIR().pi(atM);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str2 = params.get("params");
        String str3 = params.get("from");
        if (TextUtils.isEmpty(str2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(1L).dc(1L).tO("paramsValue is empty");
            com.baidu.swan.apps.al.e.aNm().j(tO);
            com.baidu.swan.apps.u.b.a.a(context, tO, 0, "");
            h.b(new com.baidu.swan.apps.statistic.a.d().i(tO).sY(str3).cw("scheme", str));
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            final String optString = jSONObject.optString("appid");
            String optString2 = jSONObject.optString("url");
            String optString3 = jSONObject.optString("extraData");
            final String optString4 = jSONObject.optString("navi");
            String optString5 = jSONObject.optString("downloadurl");
            String optString6 = jSONObject.optString("clkid");
            String optString7 = jSONObject.optString("notinhis");
            final String optString8 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.al.a tO2 = new com.baidu.swan.apps.al.a().db(1L).dc(1L).tO("appId is empty");
                com.baidu.swan.apps.al.e.aNm().j(tO2);
                com.baidu.swan.apps.u.b.a.a(context, tO2, 0, "");
                h.b(new com.baidu.swan.apps.statistic.a.d().i(tO2).sY(str3).cw("scheme", str));
                return false;
            }
            final c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().oY(optString)).pd(optString2)).pb(str3)).pc(str)).pe(optString6)).pf(optString7)).pi(atM);
            if (eVar != null && !TextUtils.isEmpty(optString4)) {
                aVar.bS("extraData", optString3);
                aVar.bS("navi", optString4);
                b.a agc = eVar.agc();
                if (agc == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String appId = agc.getAppId();
                if (com.baidu.swan.apps.f.a.a(agc) && !com.baidu.swan.apps.f.a.lH(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.bS("srcAppId", appId);
                aVar.bS("srcAppPage", ak.aOu().getPage());
            }
            if (DEBUG && !TextUtils.isEmpty(optString5)) {
                d.c cVar = new d.c();
                cVar.mAppId = optString;
                cVar.mDownloadUrl = optString5;
                com.baidu.swan.apps.r.d.a(cVar, new d.b() { // from class: com.baidu.swan.apps.u.a.1
                    @Override // com.baidu.swan.apps.r.d.b
                    public void fo(int i) {
                    }

                    @Override // com.baidu.swan.apps.r.d.b
                    public void onSuccess() {
                        ((c.a) aVar.fU(true)).pg("1.6.0");
                        SwanLauncher.atL().a(aVar, (Bundle) null);
                        a.a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                    }

                    @Override // com.baidu.swan.apps.r.d.b
                    public void onFailed() {
                        com.baidu.swan.apps.al.a tO3 = new com.baidu.swan.apps.al.a().db(7L).dc(9L).tO("debug download pkg fail");
                        com.baidu.swan.apps.al.e.aNm().j(tO3);
                        com.baidu.swan.apps.u.b.a.a(com.baidu.swan.apps.t.a.awZ(), tO3, 0, optString);
                        h.b(new com.baidu.swan.apps.statistic.a.d().i(tO3).a(aVar));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    }
                });
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                aVar.fU(false);
                SwanLauncher.atL().a(aVar, (Bundle) null);
                a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.al.a tO3 = new com.baidu.swan.apps.al.a().db(1L).dc(1L).tO("release but downloadUrl is not empty");
                com.baidu.swan.apps.al.e.aNm().j(tO3);
                com.baidu.swan.apps.u.b.a.a(context, tO3, 0, optString);
                h.b(new com.baidu.swan.apps.statistic.a.d().sY(str3).sX(optString).a(aVar).cw("scheme", str));
                return false;
            }
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.al.a tO4 = new com.baidu.swan.apps.al.a().db(1L).dc(1L).tO("parse paramsValue with JSONException:" + e.getMessage());
            com.baidu.swan.apps.al.e.aNm().j(tO4);
            com.baidu.swan.apps.u.b.a.a(context, tO4, 0, "");
            h.b(new com.baidu.swan.apps.statistic.a.d().i(tO4).sY(str3).cw("scheme", str));
            return false;
        }
    }

    public static void a(String str, String str2, final CallbackHandler callbackHandler, final UnitedSchemeEntity unitedSchemeEntity, final String str3) {
        if (!TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        }
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str3)) {
            InterfaceC0479a interfaceC0479a = new InterfaceC0479a() { // from class: com.baidu.swan.apps.u.a.2
                @Override // com.baidu.swan.apps.u.a.InterfaceC0479a
                public void ayH() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 0);
                }

                @Override // com.baidu.swan.apps.u.a.InterfaceC0479a
                public void ayI() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 1001);
                }
            };
            if (ProcessUtils.isMainProcess()) {
                b.b(str2, interfaceC0479a);
            } else {
                a(str2, interfaceC0479a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i));
        } else {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i).toString(), str);
        }
    }

    private static void a(String str, final InterfaceC0479a interfaceC0479a) {
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("desAppId", str);
            com.baidu.swan.apps.runtime.d.aIJ().aIE().b(bundle, b.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.u.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.process.a.b.c.a
                public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                    if (bVar.getResult() != null && bVar.getResult().getInt("ok") == 0) {
                        if (InterfaceC0479a.this != null) {
                            InterfaceC0479a.this.ayH();
                        }
                    } else if (InterfaceC0479a.this != null) {
                        InterfaceC0479a.this.ayI();
                    }
                }
            });
        }
    }
}
