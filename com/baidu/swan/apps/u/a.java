package com.baidu.swan.apps.u;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.ak;
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
/* loaded from: classes7.dex */
public class a extends aa {

    /* renamed from: com.baidu.swan.apps.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0488a {
        void axA();

        void axz();
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
        String asE = SwanLauncher.asE();
        d.aGI().aGE().aGQ().pu(asE);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str2 = params.get("params");
        String str3 = params.get("from");
        if (TextUtils.isEmpty(str2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(1L).cw(1L).tV("paramsValue is empty");
            com.baidu.swan.apps.am.e.aLl().j(tV);
            com.baidu.swan.apps.u.b.a.a(context, tV, 0, "");
            h.b(new com.baidu.swan.apps.statistic.a.d().i(tV).tf(str3).cx("scheme", str));
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
                com.baidu.swan.apps.am.a tV2 = new com.baidu.swan.apps.am.a().cv(1L).cw(1L).tV("appId is empty");
                com.baidu.swan.apps.am.e.aLl().j(tV2);
                com.baidu.swan.apps.u.b.a.a(context, tV2, 0, "");
                h.b(new com.baidu.swan.apps.statistic.a.d().i(tV2).tf(str3).cx("scheme", str));
                return false;
            }
            final c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().pk(optString)).pp(optString2)).pn(str3)).po(str)).pq(optString6)).pr(optString7)).pu(asE);
            if (eVar != null && !TextUtils.isEmpty(optString4)) {
                aVar.bT("extraData", optString3);
                aVar.bT("navi", optString4);
                b.a afg = eVar.afg();
                if (afg == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String appId = afg.getAppId();
                if (com.baidu.swan.apps.f.a.a(afg) && !com.baidu.swan.apps.f.a.lT(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.bT("srcAppId", appId);
                aVar.bT("srcAppPage", ak.aMu().getPage());
            }
            if (DEBUG && !TextUtils.isEmpty(optString5)) {
                d.c cVar = new d.c();
                cVar.mAppId = optString;
                cVar.mDownloadUrl = optString5;
                com.baidu.swan.apps.r.d.a(cVar, new d.b() { // from class: com.baidu.swan.apps.u.a.1
                    @Override // com.baidu.swan.apps.r.d.b
                    public void eW(int i) {
                    }

                    @Override // com.baidu.swan.apps.r.d.b
                    public void onSuccess() {
                        ((c.a) aVar.fy(true)).ps("1.6.0");
                        SwanLauncher.asD().a(aVar, (Bundle) null);
                        a.a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                    }

                    @Override // com.baidu.swan.apps.r.d.b
                    public void onFailed() {
                        com.baidu.swan.apps.am.a tV3 = new com.baidu.swan.apps.am.a().cv(7L).cw(9L).tV("debug download pkg fail");
                        com.baidu.swan.apps.am.e.aLl().j(tV3);
                        com.baidu.swan.apps.u.b.a.a(com.baidu.swan.apps.t.a.avS(), tV3, 0, optString);
                        h.b(new com.baidu.swan.apps.statistic.a.d().i(tV3).a(aVar));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    }
                });
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                aVar.fy(false);
                SwanLauncher.asD().a(aVar, (Bundle) null);
                a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.am.a tV3 = new com.baidu.swan.apps.am.a().cv(1L).cw(1L).tV("release but downloadUrl is not empty");
                com.baidu.swan.apps.am.e.aLl().j(tV3);
                com.baidu.swan.apps.u.b.a.a(context, tV3, 0, optString);
                h.b(new com.baidu.swan.apps.statistic.a.d().tf(str3).te(optString).a(aVar).cx("scheme", str));
                return false;
            }
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.am.a tV4 = new com.baidu.swan.apps.am.a().cv(1L).cw(1L).tV("parse paramsValue with JSONException:" + e.getMessage());
            com.baidu.swan.apps.am.e.aLl().j(tV4);
            com.baidu.swan.apps.u.b.a.a(context, tV4, 0, "");
            h.b(new com.baidu.swan.apps.statistic.a.d().i(tV4).tf(str3).cx("scheme", str));
            return false;
        }
    }

    public static void a(String str, String str2, final CallbackHandler callbackHandler, final UnitedSchemeEntity unitedSchemeEntity, final String str3) {
        if (!TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        }
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str3)) {
            InterfaceC0488a interfaceC0488a = new InterfaceC0488a() { // from class: com.baidu.swan.apps.u.a.2
                @Override // com.baidu.swan.apps.u.a.InterfaceC0488a
                public void axz() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 0);
                }

                @Override // com.baidu.swan.apps.u.a.InterfaceC0488a
                public void axA() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 1001);
                }
            };
            if (ProcessUtils.isMainProcess()) {
                b.b(str2, interfaceC0488a);
            } else {
                a(str2, interfaceC0488a);
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

    private static void a(String str, final InterfaceC0488a interfaceC0488a) {
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("desAppId", str);
            com.baidu.swan.apps.runtime.d.aGI().aGD().b(bundle, b.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.u.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.process.a.b.c.a
                public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                    if (bVar.getResult() != null && bVar.getResult().getInt("ok") == 0) {
                        if (InterfaceC0488a.this != null) {
                            InterfaceC0488a.this.axz();
                        }
                    } else if (InterfaceC0488a.this != null) {
                        InterfaceC0488a.this.axA();
                    }
                }
            });
        }
    }
}
