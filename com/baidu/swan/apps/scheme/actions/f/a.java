package com.baidu.swan.apps.scheme.actions.f;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
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
        e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.b Av = vN.Av();
        if (Av == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        SwanAppActionBar zF = Av.zF();
        if (zF == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        View rightMenu = zF.getRightMenu();
        if (rightMenu == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        unitedSchemeEntity.result = aj(rightMenu);
        return true;
    }

    private JSONObject aj(View view) {
        JSONObject wrapCallbackParams;
        float ag = com.baidu.swan.apps.an.z.ag(view.getLeft());
        float ag2 = com.baidu.swan.apps.an.z.ag(view.getRight());
        float ag3 = com.baidu.swan.apps.an.z.ag(view.getTop());
        float ag4 = com.baidu.swan.apps.an.z.ag(view.getBottom());
        float f = ag2 - ag;
        float f2 = ag4 - ag3;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", f);
            jSONObject.put("height", f2);
            jSONObject.put(CustomDialogData.POS_LEFT, ag);
            jSONObject.put("right", ag2);
            jSONObject.put("top", ag3);
            jSONObject.put("bottom", ag4);
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
