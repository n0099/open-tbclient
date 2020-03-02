package com.baidu.swan.apps.aa;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.y.f;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends ab {
    public b(j jVar) {
        super(jVar, "/swanAPI/menu");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str, e eVar) {
        if (context == null || eVar == null) {
            c.e("menu", "parameters dismissed");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            c.e("menu", "parameters are illegal");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        f WS = f.WS();
        if (WS == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.e GC = WS.GC();
        if (GC == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.b On = GC.On();
        if (On == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final SwanAppActionBar ND = On.ND();
        if (ND == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        eVar.acP().b(context, "mapp_change_menu_appearance", new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.aa.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    if (b.this.a(ND, optParamsAsJo, str)) {
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                        return;
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        return;
                    }
                }
                com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(SwanAppActionBar swanAppActionBar, JSONObject jSONObject, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2126297380:
                if (str.equals("/swanAPI/menu/hideMenu")) {
                    c = 0;
                    break;
                }
                break;
            case -691212521:
                if (str.equals("/swanAPI/menu/showMenu")) {
                    c = 2;
                    break;
                }
                break;
            case 203492549:
                if (str.equals("/swanAPI/menu/setMenuOpacity")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return a(swanAppActionBar);
            case 1:
                return a(swanAppActionBar, jSONObject);
            case 2:
                return b(swanAppActionBar);
            default:
                return false;
        }
    }

    private boolean a(SwanAppActionBar swanAppActionBar) {
        View rightMenu = swanAppActionBar.getRightMenu();
        if (rightMenu == null) {
            return false;
        }
        rightMenu.setVisibility(4);
        return true;
    }

    private boolean a(SwanAppActionBar swanAppActionBar, JSONObject jSONObject) {
        if (swanAppActionBar == null) {
            return false;
        }
        float optDouble = (float) jSONObject.optDouble("alpha", 1.0d);
        if (optDouble > 1.0f || optDouble < 0.1f) {
            c.e("menu", "The range of alpha should be in [0.1,1]");
            return false;
        }
        View rightMenu = swanAppActionBar.getRightMenu();
        if (rightMenu != null) {
            rightMenu.setVisibility(0);
            swanAppActionBar.setRightMenuAlpha(optDouble);
            swanAppActionBar.setRightMenuEnable(true);
            return true;
        }
        return false;
    }

    private boolean b(SwanAppActionBar swanAppActionBar) {
        View rightMenu;
        if (swanAppActionBar == null || (rightMenu = swanAppActionBar.getRightMenu()) == null) {
            return false;
        }
        rightMenu.setVisibility(0);
        swanAppActionBar.setRightMenuAlpha(1.0f);
        swanAppActionBar.setRightMenuEnable(true);
        return true;
    }
}
