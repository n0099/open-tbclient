package com.baidu.swan.apps.u;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
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
/* loaded from: classes8.dex */
public class a extends aa {

    /* renamed from: com.baidu.swan.apps.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0452a {
        void aqr();

        void aqs();
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
        String alv = SwanLauncher.alv();
        d.azE().azA().azM().nL(alv);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str2 = params.get("params");
        String str3 = params.get("from");
        if (TextUtils.isEmpty(str2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(1L).bP(1L).sm("paramsValue is empty");
            com.baidu.swan.apps.am.e.aEg().j(sm);
            com.baidu.swan.apps.u.b.a.a(context, sm, 0, "");
            h.b(new com.baidu.swan.apps.statistic.a.d().i(sm).rw(str3).cm(SuspensionBallEntity.KEY_SCHEME, str));
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
                com.baidu.swan.apps.am.a sm2 = new com.baidu.swan.apps.am.a().bO(1L).bP(1L).sm("appId is empty");
                com.baidu.swan.apps.am.e.aEg().j(sm2);
                com.baidu.swan.apps.u.b.a.a(context, sm2, 0, "");
                h.b(new com.baidu.swan.apps.statistic.a.d().i(sm2).rw(str3).cm(SuspensionBallEntity.KEY_SCHEME, str));
                return false;
            }
            final c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().nB(optString)).nG(optString2)).nE(str3)).nF(str)).nH(optString6)).nI(optString7)).nL(alv);
            if (eVar != null && !TextUtils.isEmpty(optString4)) {
                aVar.bI("extraData", optString3);
                aVar.bI("navi", optString4);
                b.a XZ = eVar.XZ();
                if (XZ == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String appId = XZ.getAppId();
                if (com.baidu.swan.apps.f.a.a(XZ) && !com.baidu.swan.apps.f.a.kl(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.bI("srcAppId", appId);
                aVar.bI("srcAppPage", ak.aFp().getPage());
            }
            if (DEBUG && !TextUtils.isEmpty(optString5)) {
                d.c cVar = new d.c();
                cVar.mAppId = optString;
                cVar.mDownloadUrl = optString5;
                com.baidu.swan.apps.r.d.a(cVar, new d.b() { // from class: com.baidu.swan.apps.u.a.1
                    @Override // com.baidu.swan.apps.r.d.b
                    public void fy(int i) {
                    }

                    @Override // com.baidu.swan.apps.r.d.b
                    public void onSuccess() {
                        ((c.a) aVar.eE(true)).nJ("1.6.0");
                        SwanLauncher.alu().a(aVar, (Bundle) null);
                        a.a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                    }

                    @Override // com.baidu.swan.apps.r.d.b
                    public void onFailed() {
                        com.baidu.swan.apps.am.a sm3 = new com.baidu.swan.apps.am.a().bO(7L).bP(9L).sm("debug download pkg fail");
                        com.baidu.swan.apps.am.e.aEg().j(sm3);
                        com.baidu.swan.apps.u.b.a.a(com.baidu.swan.apps.t.a.aoJ(), sm3, 0, optString);
                        h.b(new com.baidu.swan.apps.statistic.a.d().i(sm3).a(aVar));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    }
                });
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                aVar.eE(false);
                SwanLauncher.alu().a(aVar, (Bundle) null);
                a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.am.a sm3 = new com.baidu.swan.apps.am.a().bO(1L).bP(1L).sm("release but downloadUrl is not empty");
                com.baidu.swan.apps.am.e.aEg().j(sm3);
                com.baidu.swan.apps.u.b.a.a(context, sm3, 0, optString);
                h.b(new com.baidu.swan.apps.statistic.a.d().rw(str3).rv(optString).a(aVar).cm(SuspensionBallEntity.KEY_SCHEME, str));
                return false;
            }
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.am.a sm4 = new com.baidu.swan.apps.am.a().bO(1L).bP(1L).sm("parse paramsValue with JSONException:" + e.getMessage());
            com.baidu.swan.apps.am.e.aEg().j(sm4);
            com.baidu.swan.apps.u.b.a.a(context, sm4, 0, "");
            h.b(new com.baidu.swan.apps.statistic.a.d().i(sm4).rw(str3).cm(SuspensionBallEntity.KEY_SCHEME, str));
            return false;
        }
    }

    public static void a(String str, String str2, final CallbackHandler callbackHandler, final UnitedSchemeEntity unitedSchemeEntity, final String str3) {
        if (!TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        }
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str3)) {
            InterfaceC0452a interfaceC0452a = new InterfaceC0452a() { // from class: com.baidu.swan.apps.u.a.2
                @Override // com.baidu.swan.apps.u.a.InterfaceC0452a
                public void aqr() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 0);
                }

                @Override // com.baidu.swan.apps.u.a.InterfaceC0452a
                public void aqs() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 1001);
                }
            };
            if (ProcessUtils.isMainProcess()) {
                b.b(str2, interfaceC0452a);
            } else {
                a(str2, interfaceC0452a);
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

    private static void a(String str, final InterfaceC0452a interfaceC0452a) {
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("desAppId", str);
            com.baidu.swan.apps.runtime.d.azE().azz().b(bundle, b.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.u.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.process.a.b.c.a
                public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                    if (bVar.getResult() != null && bVar.getResult().getInt("ok") == 0) {
                        if (InterfaceC0452a.this != null) {
                            InterfaceC0452a.this.aqr();
                        }
                    } else if (InterfaceC0452a.this != null) {
                        InterfaceC0452a.this.aqs();
                    }
                }
            });
        }
    }
}
