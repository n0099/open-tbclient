package com.baidu.swan.apps.x;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.apps.x.b.c;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends ab {

    /* renamed from: com.baidu.swan.apps.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0307a {
        void Vp();

        void Vq();
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/launch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("LaunchAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str = params.get("params");
        String str2 = params.get("from");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(1L).aJ(1L).my("paramsValue is empty");
            com.baidu.swan.apps.ap.e.agr().f(my);
            com.baidu.swan.apps.x.a.a.a(context, my, 0, "");
            f.b(new d().e(my).lO(str2).bn(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
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
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.ap.a my2 = new com.baidu.swan.apps.ap.a().aI(1L).aJ(1L).my("appId is empty");
                com.baidu.swan.apps.ap.e.agr().f(my2);
                com.baidu.swan.apps.x.a.a.a(context, my2, 0, "");
                f.b(new d().e(my2).lO(str2).bn(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
                return false;
            }
            final c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().ix(optString)).iC(optString2)).iA(str2)).iB(unitedSchemeEntity.getUri().toString())).iD(optString6)).iE(optString7);
            if (eVar != null && !TextUtils.isEmpty(optString4)) {
                aVar.aQ("extraData", optString3);
                aVar.aQ("navi", optString4);
                b.a GJ = eVar.GJ();
                if (GJ == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String appId = GJ.getAppId();
                if (com.baidu.swan.apps.e.a.a(GJ) && !com.baidu.swan.apps.e.a.gg(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.aQ("srcAppId", appId);
                aVar.aQ("srcAppPage", ai.ahn().getPage());
            }
            if (DEBUG && !TextUtils.isEmpty(optString5)) {
                e.c cVar = new e.c();
                cVar.mAppId = optString;
                cVar.mDownloadUrl = optString5;
                com.baidu.swan.apps.t.e.a(cVar, new e.b() { // from class: com.baidu.swan.apps.x.a.1
                    @Override // com.baidu.swan.apps.t.e.b
                    public void cX(int i) {
                    }

                    @Override // com.baidu.swan.apps.t.e.b
                    public void onSuccess() {
                        ((c.a) aVar.cN(true)).iF("1.6.0");
                        SwanLauncher.RJ().a(aVar, (Bundle) null);
                        a.a(optString4, optString, callbackHandler, unitedSchemeEntity);
                    }

                    @Override // com.baidu.swan.apps.t.e.b
                    public void onFailed() {
                        com.baidu.swan.apps.ap.a my3 = new com.baidu.swan.apps.ap.a().aI(7L).aJ(9L).my("debug download pkg fail");
                        com.baidu.swan.apps.ap.e.agr().f(my3);
                        com.baidu.swan.apps.x.a.a.a(com.baidu.swan.apps.w.a.TZ(), my3, 0, optString);
                        f.b(new d().e(my3).a(aVar));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    }
                });
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                aVar.cN(false);
                SwanLauncher.RJ().a(aVar, (Bundle) null);
                a(optString4, optString, callbackHandler, unitedSchemeEntity);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.ap.a my3 = new com.baidu.swan.apps.ap.a().aI(1L).aJ(1L).my("release but downloadUrl is not empty");
                com.baidu.swan.apps.ap.e.agr().f(my3);
                com.baidu.swan.apps.x.a.a.a(context, my3, 0, optString);
                f.b(new d().lO(str2).lN(optString).a(aVar).bn(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
                return false;
            }
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            com.baidu.swan.apps.ap.a my4 = new com.baidu.swan.apps.ap.a().aI(1L).aJ(1L).my("parse paramsValue with JSONException:" + e.getMessage());
            com.baidu.swan.apps.ap.e.agr().f(my4);
            com.baidu.swan.apps.x.a.a.a(context, my4, 0, "");
            f.b(new d().e(my4).lO(str2).bn(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString()));
            return false;
        }
    }

    public static void a(String str, String str2, final CallbackHandler callbackHandler, final UnitedSchemeEntity unitedSchemeEntity) {
        if (!TextUtils.isEmpty(str)) {
            a(str2, new InterfaceC0307a() { // from class: com.baidu.swan.apps.x.a.2
                @Override // com.baidu.swan.apps.x.a.InterfaceC0307a
                public void Vp() {
                    UnitedSchemeUtility.callCallback(CallbackHandler.this, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                }

                @Override // com.baidu.swan.apps.x.a.InterfaceC0307a
                public void Vq() {
                    UnitedSchemeUtility.callCallback(CallbackHandler.this, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
                }
            });
        }
    }

    private static void a(String str, final InterfaceC0307a interfaceC0307a) {
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("desAppId", str);
            com.baidu.swan.apps.runtime.d.acF().acB().a(bundle, b.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.x.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.process.a.b.c.a
                public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                    if (bVar.getResult() != null && bVar.getResult().getInt("ok") == 0) {
                        if (InterfaceC0307a.this != null) {
                            InterfaceC0307a.this.Vp();
                        }
                    } else if (InterfaceC0307a.this != null) {
                        InterfaceC0307a.this.Vq();
                    }
                }
            });
        }
    }
}
