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
/* loaded from: classes10.dex */
public class a extends aa {

    /* renamed from: com.baidu.swan.apps.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0478a {
        void avH();

        void avI();
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
        String aqL = SwanLauncher.aqL();
        d.aEQ().aEM().aEY().pm(aqL);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str2 = params.get("params");
        String str3 = params.get("from");
        if (TextUtils.isEmpty(str2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(1L).ca(1L).tM("paramsValue is empty");
            com.baidu.swan.apps.am.e.aJt().j(tM);
            com.baidu.swan.apps.u.b.a.a(context, tM, 0, "");
            h.b(new com.baidu.swan.apps.statistic.a.d().i(tM).sW(str3).cy("scheme", str));
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
                com.baidu.swan.apps.am.a tM2 = new com.baidu.swan.apps.am.a().bZ(1L).ca(1L).tM("appId is empty");
                com.baidu.swan.apps.am.e.aJt().j(tM2);
                com.baidu.swan.apps.u.b.a.a(context, tM2, 0, "");
                h.b(new com.baidu.swan.apps.statistic.a.d().i(tM2).sW(str3).cy("scheme", str));
                return false;
            }
            final c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().pc(optString)).ph(optString2)).pf(str3)).pg(str)).pi(optString6)).pj(optString7)).pm(aqL);
            if (eVar != null && !TextUtils.isEmpty(optString4)) {
                aVar.bU("extraData", optString3);
                aVar.bU("navi", optString4);
                b.a ado = eVar.ado();
                if (ado == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String appId = ado.getAppId();
                if (com.baidu.swan.apps.f.a.a(ado) && !com.baidu.swan.apps.f.a.lK(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.bU("srcAppId", appId);
                aVar.bU("srcAppPage", ak.aKC().getPage());
            }
            if (DEBUG && !TextUtils.isEmpty(optString5)) {
                d.c cVar = new d.c();
                cVar.mAppId = optString;
                cVar.mDownloadUrl = optString5;
                com.baidu.swan.apps.r.d.a(cVar, new d.b() { // from class: com.baidu.swan.apps.u.a.1
                    @Override // com.baidu.swan.apps.r.d.b
                    public void fa(int i) {
                    }

                    @Override // com.baidu.swan.apps.r.d.b
                    public void onSuccess() {
                        ((c.a) aVar.fm(true)).pk("1.6.0");
                        SwanLauncher.aqK().a(aVar, (Bundle) null);
                        a.a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                    }

                    @Override // com.baidu.swan.apps.r.d.b
                    public void onFailed() {
                        com.baidu.swan.apps.am.a tM3 = new com.baidu.swan.apps.am.a().bZ(7L).ca(9L).tM("debug download pkg fail");
                        com.baidu.swan.apps.am.e.aJt().j(tM3);
                        com.baidu.swan.apps.u.b.a.a(com.baidu.swan.apps.t.a.aua(), tM3, 0, optString);
                        h.b(new com.baidu.swan.apps.statistic.a.d().i(tM3).a(aVar));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    }
                });
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                aVar.fm(false);
                SwanLauncher.aqK().a(aVar, (Bundle) null);
                a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.am.a tM3 = new com.baidu.swan.apps.am.a().bZ(1L).ca(1L).tM("release but downloadUrl is not empty");
                com.baidu.swan.apps.am.e.aJt().j(tM3);
                com.baidu.swan.apps.u.b.a.a(context, tM3, 0, optString);
                h.b(new com.baidu.swan.apps.statistic.a.d().sW(str3).sV(optString).a(aVar).cy("scheme", str));
                return false;
            }
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.am.a tM4 = new com.baidu.swan.apps.am.a().bZ(1L).ca(1L).tM("parse paramsValue with JSONException:" + e.getMessage());
            com.baidu.swan.apps.am.e.aJt().j(tM4);
            com.baidu.swan.apps.u.b.a.a(context, tM4, 0, "");
            h.b(new com.baidu.swan.apps.statistic.a.d().i(tM4).sW(str3).cy("scheme", str));
            return false;
        }
    }

    public static void a(String str, String str2, final CallbackHandler callbackHandler, final UnitedSchemeEntity unitedSchemeEntity, final String str3) {
        if (!TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        }
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str3)) {
            InterfaceC0478a interfaceC0478a = new InterfaceC0478a() { // from class: com.baidu.swan.apps.u.a.2
                @Override // com.baidu.swan.apps.u.a.InterfaceC0478a
                public void avH() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 0);
                }

                @Override // com.baidu.swan.apps.u.a.InterfaceC0478a
                public void avI() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 1001);
                }
            };
            if (ProcessUtils.isMainProcess()) {
                b.b(str2, interfaceC0478a);
            } else {
                a(str2, interfaceC0478a);
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

    private static void a(String str, final InterfaceC0478a interfaceC0478a) {
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("desAppId", str);
            com.baidu.swan.apps.runtime.d.aEQ().aEL().b(bundle, b.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.u.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.process.a.b.c.a
                public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                    if (bVar.getResult() != null && bVar.getResult().getInt("ok") == 0) {
                        if (InterfaceC0478a.this != null) {
                            InterfaceC0478a.this.avH();
                        }
                    } else if (InterfaceC0478a.this != null) {
                        InterfaceC0478a.this.avI();
                    }
                }
            });
        }
    }
}
