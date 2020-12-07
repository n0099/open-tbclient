package com.baidu.swan.apps.scheme.actions.g;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.core.d.c;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.view.SwanAppActionBar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/getMenuButtonBoundingClientRect");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (DEBUG) {
            Log.d("GetMenuButtonBounding", "handle entity: " + unitedSchemeEntity.toString());
        }
        f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        c arB = aim.arB();
        if (arB == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (eVar.aKn() && (arB instanceof com.baidu.swan.apps.core.d.j)) {
            View asg = ((com.baidu.swan.apps.core.d.j) arB).asg();
            if (asg == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            unitedSchemeEntity.result = aG(asg);
        } else {
            SwanAppActionBar aqJ = arB.aqJ();
            if (aqJ == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            View rightMenu = aqJ.getRightMenu();
            if (rightMenu == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            unitedSchemeEntity.result = aG(rightMenu);
        }
        return true;
    }

    private JSONObject aG(View view) {
        JSONObject wrapCallbackParams;
        e aJU = e.aJU();
        int px2dpFloat = aJU != null ? aJU.aKn() : false ? 0 : (int) (ah.px2dpFloat(ah.getStatusBarHeight()) + 0.5f);
        int px2dpFloat2 = (int) (ah.px2dpFloat(view.getLeft()) + 0.5f);
        int px2dpFloat3 = (int) (ah.px2dpFloat(view.getRight()) + 0.5f);
        int px2dpFloat4 = ((int) (ah.px2dpFloat(view.getTop()) + 0.5f)) + px2dpFloat;
        int px2dpFloat5 = px2dpFloat + ((int) (ah.px2dpFloat(view.getBottom()) + 0.5f));
        int i = px2dpFloat3 - px2dpFloat2;
        int i2 = px2dpFloat5 - px2dpFloat4;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            jSONObject.put("left", px2dpFloat2);
            jSONObject.put(HorizontalTranslateLayout.DIRECTION_RIGHT, px2dpFloat3);
            jSONObject.put(VerticalTranslateLayout.TOP, px2dpFloat4);
            jSONObject.put(VerticalTranslateLayout.BOTTOM, px2dpFloat5);
            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
        }
        if (DEBUG) {
            Log.e("GetMenuButtonBounding", wrapCallbackParams.toString());
        }
        return wrapCallbackParams;
    }
}
