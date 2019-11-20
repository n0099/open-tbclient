package com.baidu.swan.apps.scheme.actions.f;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.view.SwanAppActionBar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends z {
    public a(j jVar) {
        super(jVar, "/swan/getMenuButtonBoundingClientRect");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b bVar) {
        if (DEBUG) {
            Log.d("GetMenuButtonBounding", "handle entity: " + unitedSchemeEntity.toString());
        }
        e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.b Fr = AI.Fr();
        if (Fr == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        SwanAppActionBar EB = Fr.EB();
        if (EB == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        View rightMenu = EB.getRightMenu();
        if (rightMenu == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        unitedSchemeEntity.result = ap(rightMenu);
        return true;
    }

    private JSONObject ap(View view) {
        JSONObject wrapCallbackParams;
        float V = com.baidu.swan.apps.an.z.V(view.getLeft());
        float V2 = com.baidu.swan.apps.an.z.V(view.getRight());
        float V3 = com.baidu.swan.apps.an.z.V(view.getTop());
        float V4 = com.baidu.swan.apps.an.z.V(view.getBottom());
        float f = V2 - V;
        float f2 = V4 - V3;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", f);
            jSONObject.put("height", f2);
            jSONObject.put("left", V);
            jSONObject.put(HorizontalTranslateLayout.RIGHT, V2);
            jSONObject.put(VerticalTranslateLayout.TOP, V3);
            jSONObject.put(VerticalTranslateLayout.BOTTOM, V4);
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
