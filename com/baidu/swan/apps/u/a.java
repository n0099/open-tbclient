package com.baidu.swan.apps.u;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.al;
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
    public interface InterfaceC0406a {
        void aiL();

        void aiM();
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/launch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("LaunchAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String aeM = SwanLauncher.aeM();
        d.arr().arn().arz().lO(aeM);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str = params.get("params");
        String str2 = params.get("from");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(1L).bK(1L).qm("paramsValue is empty");
            com.baidu.swan.apps.an.e.avX().g(qm);
            com.baidu.swan.apps.u.b.a.a(context, qm, 0, "");
            h.b(new com.baidu.swan.apps.statistic.a.d().f(qm).pw(str2).bV(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
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
                com.baidu.swan.apps.an.a qm2 = new com.baidu.swan.apps.an.a().bJ(1L).bK(1L).qm("appId is empty");
                com.baidu.swan.apps.an.e.avX().g(qm2);
                com.baidu.swan.apps.u.b.a.a(context, qm2, 0, "");
                h.b(new com.baidu.swan.apps.statistic.a.d().f(qm2).pw(str2).bV(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
                return false;
            }
            final c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().lE(optString)).lJ(optString2)).lH(str2)).lI(unitedSchemeEntity.getUri().toString())).lK(optString6)).lL(optString7)).lO(aeM);
            if (eVar != null && !TextUtils.isEmpty(optString4)) {
                aVar.bv("extraData", optString3);
                aVar.bv("navi", optString4);
                b.a Se = eVar.Se();
                if (Se == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String appId = Se.getAppId();
                if (com.baidu.swan.apps.e.a.a(Se) && !com.baidu.swan.apps.e.a.iL(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.bv("srcAppId", appId);
                aVar.bv("srcAppPage", al.axg().getPage());
            }
            if (DEBUG && !TextUtils.isEmpty(optString5)) {
                d.c cVar = new d.c();
                cVar.mAppId = optString;
                cVar.mDownloadUrl = optString5;
                com.baidu.swan.apps.r.d.a(cVar, new d.b() { // from class: com.baidu.swan.apps.u.a.1
                    @Override // com.baidu.swan.apps.r.d.b
                    public void dE(int i) {
                    }

                    @Override // com.baidu.swan.apps.r.d.b
                    public void onSuccess() {
                        ((c.a) aVar.em(true)).lM("1.6.0");
                        SwanLauncher.aeL().a(aVar, (Bundle) null);
                        a.a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                    }

                    @Override // com.baidu.swan.apps.r.d.b
                    public void onFailed() {
                        com.baidu.swan.apps.an.a qm3 = new com.baidu.swan.apps.an.a().bJ(7L).bK(9L).qm("debug download pkg fail");
                        com.baidu.swan.apps.an.e.avX().g(qm3);
                        com.baidu.swan.apps.u.b.a.a(com.baidu.swan.apps.t.a.ahj(), qm3, 0, optString);
                        h.b(new com.baidu.swan.apps.statistic.a.d().f(qm3).a(aVar));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    }
                });
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                aVar.em(false);
                SwanLauncher.aeL().a(aVar, (Bundle) null);
                a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.an.a qm3 = new com.baidu.swan.apps.an.a().bJ(1L).bK(1L).qm("release but downloadUrl is not empty");
                com.baidu.swan.apps.an.e.avX().g(qm3);
                com.baidu.swan.apps.u.b.a.a(context, qm3, 0, optString);
                h.b(new com.baidu.swan.apps.statistic.a.d().pw(str2).pv(optString).a(aVar).bV(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
                return false;
            }
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.an.a qm4 = new com.baidu.swan.apps.an.a().bJ(1L).bK(1L).qm("parse paramsValue with JSONException:" + e.getMessage());
            com.baidu.swan.apps.an.e.avX().g(qm4);
            com.baidu.swan.apps.u.b.a.a(context, qm4, 0, "");
            h.b(new com.baidu.swan.apps.statistic.a.d().f(qm4).pw(str2).bV(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
            return false;
        }
    }

    public static void a(String str, String str2, final CallbackHandler callbackHandler, final UnitedSchemeEntity unitedSchemeEntity, final String str3) {
        if (!TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        }
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str3)) {
            InterfaceC0406a interfaceC0406a = new InterfaceC0406a() { // from class: com.baidu.swan.apps.u.a.2
                @Override // com.baidu.swan.apps.u.a.InterfaceC0406a
                public void aiL() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 0);
                }

                @Override // com.baidu.swan.apps.u.a.InterfaceC0406a
                public void aiM() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 1001);
                }
            };
            if (ProcessUtils.isMainProcess()) {
                b.b(str2, interfaceC0406a);
            } else {
                a(str2, interfaceC0406a);
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

    private static void a(String str, final InterfaceC0406a interfaceC0406a) {
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("desAppId", str);
            com.baidu.swan.apps.runtime.d.arr().arm().b(bundle, b.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.u.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.process.a.b.c.a
                public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                    if (bVar.getResult() != null && bVar.getResult().getInt("ok") == 0) {
                        if (InterfaceC0406a.this != null) {
                            InterfaceC0406a.this.aiL();
                        }
                    } else if (InterfaceC0406a.this != null) {
                        InterfaceC0406a.this.aiM();
                    }
                }
            });
        }
    }
}
