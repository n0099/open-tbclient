package com.baidu.swan.apps.y;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.w.f;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends aa {
    public b(j jVar) {
        super(jVar, "/swanAPI/menu");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (context == null || eVar == null) {
            c.e("menu", "parameters dismissed");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            c.e("menu", "parameters are illegal");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        f ahV = f.ahV();
        if (ahV == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.e QH = ahV.QH();
        if (QH == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.b YP = QH.YP();
        if (YP == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        SwanAppActionBar Ya = YP.Ya();
        if (Ya == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        a(eVar, context, callbackHandler, optString, Ya, optParamsAsJo, str);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private void a(e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, JSONObject jSONObject, String str2) {
        if (swanAppActionBar == null) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        } else if (TextUtils.equals(str2, "/swanAPI/menu/setMenuEnabled")) {
            a(eVar, context, callbackHandler, str, swanAppActionBar, jSONObject.optBoolean("enabled", true));
        } else if (TextUtils.equals(str2, "/swanAPI/menu/setMenuOpacity")) {
            float optDouble = (float) jSONObject.optDouble("alpha", 1.0d);
            if (optDouble > 1.0f || optDouble < 0.1f) {
                c.e("menu", "The range of alpha should be in [0.1,1]");
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
            a(eVar, context, callbackHandler, str, swanAppActionBar, optDouble);
        } else {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    private void a(e eVar, Context context, final CallbackHandler callbackHandler, final String str, final SwanAppActionBar swanAppActionBar, final float f) {
        eVar.aoR().b(context, "mapp_change_menu_appearance", new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.y.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<b.d> hVar) {
                if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, str);
                } else if (swanAppActionBar.getRightMenu() == null) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                } else {
                    swanAppActionBar.setRightMenuAlpha(f);
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            }
        });
    }

    private void a(e eVar, Context context, final CallbackHandler callbackHandler, final String str, final SwanAppActionBar swanAppActionBar, final boolean z) {
        eVar.aoR().b(context, "scope_hide_menu", new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.y.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<b.d> hVar) {
                if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, str);
                    return;
                }
                if (z) {
                    b.this.b(swanAppActionBar);
                } else {
                    b.this.a(swanAppActionBar);
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(SwanAppActionBar swanAppActionBar) {
        View rightMenu;
        if (swanAppActionBar == null || (rightMenu = swanAppActionBar.getRightMenu()) == null) {
            return false;
        }
        rightMenu.setVisibility(4);
        swanAppActionBar.setRightMenuEnable(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(SwanAppActionBar swanAppActionBar) {
        View rightMenu;
        if (swanAppActionBar == null || (rightMenu = swanAppActionBar.getRightMenu()) == null) {
            return false;
        }
        rightMenu.setVisibility(0);
        swanAppActionBar.setRightMenuEnable(true);
        return true;
    }
}
