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
    public interface InterfaceC0400a {
        void aht();

        void ahu();
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
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(1L).bx(1L).pB("paramsValue is empty");
            com.baidu.swan.apps.an.e.atW().g(pB);
            com.baidu.swan.apps.v.a.a.a(context, pB, 0, "");
            h.b(new d().f(pB).oM(str2).bU(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
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
                com.baidu.swan.apps.an.a pB2 = new com.baidu.swan.apps.an.a().bw(1L).bx(1L).pB("appId is empty");
                com.baidu.swan.apps.an.e.atW().g(pB2);
                com.baidu.swan.apps.v.a.a.a(context, pB2, 0, "");
                h.b(new d().f(pB2).oM(str2).bU(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
                return false;
            }
            final c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().le(optString)).lj(optString2)).lh(str2)).li(unitedSchemeEntity.getUri().toString())).lk(optString6)).ll(optString7);
            if (eVar != null && !TextUtils.isEmpty(optString4)) {
                aVar.bt("extraData", optString3);
                aVar.bt("navi", optString4);
                b.a RP = eVar.RP();
                if (RP == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String appId = RP.getAppId();
                if (com.baidu.swan.apps.e.a.a(RP) && !com.baidu.swan.apps.e.a.iB(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.bt("srcAppId", appId);
                aVar.bt("srcAppPage", aj.ava().getPage());
            }
            if (DEBUG && !TextUtils.isEmpty(optString5)) {
                e.c cVar = new e.c();
                cVar.mAppId = optString;
                cVar.mDownloadUrl = optString5;
                com.baidu.swan.apps.r.e.a(cVar, new e.b() { // from class: com.baidu.swan.apps.v.a.1
                    @Override // com.baidu.swan.apps.r.e.b
                    public void dE(int i) {
                    }

                    @Override // com.baidu.swan.apps.r.e.b
                    public void onSuccess() {
                        ((c.a) aVar.ee(true)).lm("1.6.0");
                        SwanLauncher.adE().a(aVar, (Bundle) null);
                        a.a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                    }

                    @Override // com.baidu.swan.apps.r.e.b
                    public void onFailed() {
                        com.baidu.swan.apps.an.a pB3 = new com.baidu.swan.apps.an.a().bw(7L).bx(9L).pB("debug download pkg fail");
                        com.baidu.swan.apps.an.e.atW().g(pB3);
                        com.baidu.swan.apps.v.a.a.a(com.baidu.swan.apps.u.a.afX(), pB3, 0, optString);
                        h.b(new d().f(pB3).a(aVar));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    }
                });
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                aVar.ee(false);
                SwanLauncher.adE().a(aVar, (Bundle) null);
                a(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.an.a pB3 = new com.baidu.swan.apps.an.a().bw(1L).bx(1L).pB("release but downloadUrl is not empty");
                com.baidu.swan.apps.an.e.atW().g(pB3);
                com.baidu.swan.apps.v.a.a.a(context, pB3, 0, optString);
                h.b(new d().oM(str2).oL(optString).a(aVar).bU(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
                return false;
            }
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.an.a pB4 = new com.baidu.swan.apps.an.a().bw(1L).bx(1L).pB("parse paramsValue with JSONException:" + e.getMessage());
            com.baidu.swan.apps.an.e.atW().g(pB4);
            com.baidu.swan.apps.v.a.a.a(context, pB4, 0, "");
            h.b(new d().f(pB4).oM(str2).bU(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
            return false;
        }
    }

    public static void a(String str, String str2, final CallbackHandler callbackHandler, final UnitedSchemeEntity unitedSchemeEntity, final String str3) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str3)) {
            a(str2, new InterfaceC0400a() { // from class: com.baidu.swan.apps.v.a.2
                @Override // com.baidu.swan.apps.v.a.InterfaceC0400a
                public void aht() {
                    a.a(CallbackHandler.this, unitedSchemeEntity, str3, 0);
                }

                @Override // com.baidu.swan.apps.v.a.InterfaceC0400a
                public void ahu() {
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

    private static void a(String str, final InterfaceC0400a interfaceC0400a) {
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("desAppId", str);
            com.baidu.swan.apps.runtime.d.apI().apD().b(bundle, b.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.v.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.process.a.b.c.a
                public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                    if (bVar.getResult() != null && bVar.getResult().getInt("ok") == 0) {
                        if (InterfaceC0400a.this != null) {
                            InterfaceC0400a.this.aht();
                        }
                    } else if (InterfaceC0400a.this != null) {
                        InterfaceC0400a.this.ahu();
                    }
                }
            });
        }
    }
}
