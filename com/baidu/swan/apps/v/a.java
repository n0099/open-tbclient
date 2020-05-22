package com.baidu.swan.apps.v;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.v.b.c;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends aa {

    /* renamed from: com.baidu.swan.apps.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0394a {
        void agn();

        void ago();
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/launch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("LaunchAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str = params.get("params");
        String str2 = params.get("from");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(1L).bx(1L).pt("paramsValue is empty");
            com.baidu.swan.apps.an.e.asQ().g(pt);
            com.baidu.swan.apps.v.a.a.a(context, pt, 0, "");
            h.b(new d().f(pt).oE(str2).bS(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
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
                com.baidu.swan.apps.an.a pt2 = new com.baidu.swan.apps.an.a().bw(1L).bx(1L).pt("appId is empty");
                com.baidu.swan.apps.an.e.asQ().g(pt2);
                com.baidu.swan.apps.v.a.a.a(context, pt2, 0, "");
                h.b(new d().f(pt2).oE(str2).bS(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
                return false;
            }
            final c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().kW(optString)).lb(optString2)).kZ(str2)).la(unitedSchemeEntity.getUri().toString())).lc(optString6)).ld(optString7);
            if (eVar != null && !TextUtils.isEmpty(optString4)) {
                aVar.br("extraData", optString3);
                aVar.br("navi", optString4);
                b.a QJ = eVar.QJ();
                if (QJ == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String appId = QJ.getAppId();
                if (com.baidu.swan.apps.e.a.a(QJ) && !com.baidu.swan.apps.e.a.it(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.br("srcAppId", appId);
                aVar.br("srcAppPage", aj.atU().getPage());
            }
            if (DEBUG && !TextUtils.isEmpty(optString5)) {
                e.c cVar = new e.c();
                cVar.mAppId = optString;
                cVar.mDownloadUrl = optString5;
                com.baidu.swan.apps.r.e.a(cVar, new e.b() { // from class: com.baidu.swan.apps.v.a.1
                    @Override // com.baidu.swan.apps.r.e.b
                    public void dr(int i) {
                    }

                    @Override // com.baidu.swan.apps.r.e.b
                    public void onSuccess() {
                        ((c.a) aVar.dZ(true)).le("1.6.0");
                        SwanLauncher.acy().a(aVar, (Bundle) null);
                        a.a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                    }

                    @Override // com.baidu.swan.apps.r.e.b
                    public void onFailed() {
                        com.baidu.swan.apps.an.a pt3 = new com.baidu.swan.apps.an.a().bw(7L).bx(9L).pt("debug download pkg fail");
                        com.baidu.swan.apps.an.e.asQ().g(pt3);
                        com.baidu.swan.apps.v.a.a.a(com.baidu.swan.apps.u.a.aeR(), pt3, 0, optString);
                        h.b(new d().f(pt3).a(aVar));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    }
                });
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                aVar.dZ(false);
                SwanLauncher.acy().a(aVar, (Bundle) null);
                a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.an.a pt3 = new com.baidu.swan.apps.an.a().bw(1L).bx(1L).pt("release but downloadUrl is not empty");
                com.baidu.swan.apps.an.e.asQ().g(pt3);
                com.baidu.swan.apps.v.a.a.a(context, pt3, 0, optString);
                h.b(new d().oE(str2).oD(optString).a(aVar).bS(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
                return false;
            }
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.an.a pt4 = new com.baidu.swan.apps.an.a().bw(1L).bx(1L).pt("parse paramsValue with JSONException:" + e.getMessage());
            com.baidu.swan.apps.an.e.asQ().g(pt4);
            com.baidu.swan.apps.v.a.a.a(context, pt4, 0, "");
            h.b(new d().f(pt4).oE(str2).bS(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
            return false;
        }
    }

    public static void a(String str, String str2, final CallbackHandler callbackHandler, final UnitedSchemeEntity unitedSchemeEntity, final String str3) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str3)) {
            a(str2, new InterfaceC0394a() { // from class: com.baidu.swan.apps.v.a.2
                @Override // com.baidu.swan.apps.v.a.InterfaceC0394a
                public void agn() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 0);
                }

                @Override // com.baidu.swan.apps.v.a.InterfaceC0394a
                public void ago() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 1001);
                }
            });
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

    private static void a(String str, final InterfaceC0394a interfaceC0394a) {
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("desAppId", str);
            com.baidu.swan.apps.runtime.d.aoB().aow().b(bundle, b.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.v.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.process.a.b.c.a
                public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                    if (bVar.getResult() != null && bVar.getResult().getInt("ok") == 0) {
                        if (InterfaceC0394a.this != null) {
                            InterfaceC0394a.this.agn();
                        }
                    } else if (InterfaceC0394a.this != null) {
                        InterfaceC0394a.this.ago();
                    }
                }
            });
        }
    }
}
