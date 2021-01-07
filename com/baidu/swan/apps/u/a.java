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
/* loaded from: classes9.dex */
public class a extends aa {

    /* renamed from: com.baidu.swan.apps.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0493a {
        void aCa();

        void aCb();
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
        String axf = SwanLauncher.axf();
        d.aMh().aMd().aMp().pU(axf);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str2 = params.get("params");
        String str3 = params.get("from");
        if (TextUtils.isEmpty(str2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(1L).cW(1L).uz("paramsValue is empty");
            com.baidu.swan.apps.al.e.aQK().j(uz);
            com.baidu.swan.apps.u.b.a.a(context, uz, 0, "");
            h.b(new com.baidu.swan.apps.statistic.a.d().i(uz).tJ(str3).cD("scheme", str));
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
                com.baidu.swan.apps.al.a uz2 = new com.baidu.swan.apps.al.a().cV(1L).cW(1L).uz("appId is empty");
                com.baidu.swan.apps.al.e.aQK().j(uz2);
                com.baidu.swan.apps.u.b.a.a(context, uz2, 0, "");
                h.b(new com.baidu.swan.apps.statistic.a.d().i(uz2).tJ(str3).cD("scheme", str));
                return false;
            }
            final c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().pK(optString)).pP(optString2)).pN(str3)).pO(str)).pQ(optString6)).pR(optString7)).pU(axf);
            if (eVar != null && !TextUtils.isEmpty(optString4)) {
                aVar.bZ("extraData", optString3);
                aVar.bZ("navi", optString4);
                b.a ajv = eVar.ajv();
                if (ajv == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String appId = ajv.getAppId();
                if (com.baidu.swan.apps.f.a.a(ajv) && !com.baidu.swan.apps.f.a.mt(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.bZ("srcAppId", appId);
                aVar.bZ("srcAppPage", ak.aRS().getPage());
            }
            if (DEBUG && !TextUtils.isEmpty(optString5)) {
                d.c cVar = new d.c();
                cVar.mAppId = optString;
                cVar.mDownloadUrl = optString5;
                com.baidu.swan.apps.r.d.a(cVar, new d.b() { // from class: com.baidu.swan.apps.u.a.1
                    @Override // com.baidu.swan.apps.r.d.b
                    public void fu(int i) {
                    }

                    @Override // com.baidu.swan.apps.r.d.b
                    public void onSuccess() {
                        ((c.a) aVar.fW(true)).pS("1.6.0");
                        SwanLauncher.axe().a(aVar, (Bundle) null);
                        a.a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                    }

                    @Override // com.baidu.swan.apps.r.d.b
                    public void onFailed() {
                        com.baidu.swan.apps.al.a uz3 = new com.baidu.swan.apps.al.a().cV(7L).cW(9L).uz("debug download pkg fail");
                        com.baidu.swan.apps.al.e.aQK().j(uz3);
                        com.baidu.swan.apps.u.b.a.a(com.baidu.swan.apps.t.a.aAs(), uz3, 0, optString);
                        h.b(new com.baidu.swan.apps.statistic.a.d().i(uz3).a(aVar));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    }
                });
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                aVar.fW(false);
                SwanLauncher.axe().a(aVar, (Bundle) null);
                a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.al.a uz3 = new com.baidu.swan.apps.al.a().cV(1L).cW(1L).uz("release but downloadUrl is not empty");
                com.baidu.swan.apps.al.e.aQK().j(uz3);
                com.baidu.swan.apps.u.b.a.a(context, uz3, 0, optString);
                h.b(new com.baidu.swan.apps.statistic.a.d().tJ(str3).tI(optString).a(aVar).cD("scheme", str));
                return false;
            }
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.al.a uz4 = new com.baidu.swan.apps.al.a().cV(1L).cW(1L).uz("parse paramsValue with JSONException:" + e.getMessage());
            com.baidu.swan.apps.al.e.aQK().j(uz4);
            com.baidu.swan.apps.u.b.a.a(context, uz4, 0, "");
            h.b(new com.baidu.swan.apps.statistic.a.d().i(uz4).tJ(str3).cD("scheme", str));
            return false;
        }
    }

    public static void a(String str, String str2, final CallbackHandler callbackHandler, final UnitedSchemeEntity unitedSchemeEntity, final String str3) {
        if (!TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        }
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str3)) {
            InterfaceC0493a interfaceC0493a = new InterfaceC0493a() { // from class: com.baidu.swan.apps.u.a.2
                @Override // com.baidu.swan.apps.u.a.InterfaceC0493a
                public void aCa() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 0);
                }

                @Override // com.baidu.swan.apps.u.a.InterfaceC0493a
                public void aCb() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 1001);
                }
            };
            if (ProcessUtils.isMainProcess()) {
                b.b(str2, interfaceC0493a);
            } else {
                a(str2, interfaceC0493a);
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

    private static void a(String str, final InterfaceC0493a interfaceC0493a) {
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("desAppId", str);
            com.baidu.swan.apps.runtime.d.aMh().aMc().b(bundle, b.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.u.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.process.a.b.c.a
                public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                    if (bVar.getResult() != null && bVar.getResult().getInt("ok") == 0) {
                        if (InterfaceC0493a.this != null) {
                            InterfaceC0493a.this.aCa();
                        }
                    } else if (InterfaceC0493a.this != null) {
                        InterfaceC0493a.this.aCb();
                    }
                }
            });
        }
    }
}
