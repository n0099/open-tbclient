package com.baidu.swan.apps.scheme.actions.g;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.core.d.b;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.y.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/getMenuButtonBoundingClientRect");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (DEBUG) {
            Log.d("GetMenuButtonBounding", "handle entity: " + unitedSchemeEntity.toString());
        }
        com.baidu.swan.apps.core.d.e Ou = f.aeK().Ou();
        if (Ou == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        b We = Ou.We();
        if (We == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (eVar.ale() && (We instanceof i)) {
            View WM = ((i) We).WM();
            if (WM == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            unitedSchemeEntity.result = as(WM);
        } else {
            SwanAppActionBar Vt = We.Vt();
            if (Vt == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            View rightMenu = Vt.getRightMenu();
            if (rightMenu == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            unitedSchemeEntity.result = as(rightMenu);
        }
        return true;
    }

    private JSONObject as(View view) {
        JSONObject wrapCallbackParams;
        e akN = e.akN();
        int px2dpFloat = akN != null ? akN.ale() : false ? 0 : (int) (af.px2dpFloat(af.getStatusBarHeight()) + 0.5f);
        int px2dpFloat2 = (int) (af.px2dpFloat(view.getLeft()) + 0.5f);
        int px2dpFloat3 = (int) (af.px2dpFloat(view.getRight()) + 0.5f);
        int px2dpFloat4 = ((int) (af.px2dpFloat(view.getTop()) + 0.5f)) + px2dpFloat;
        int px2dpFloat5 = px2dpFloat + ((int) (af.px2dpFloat(view.getBottom()) + 0.5f));
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
