package com.baidu.swan.apps.r;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.o;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends z {
    public g(j jVar) {
        super(jVar, "/swan/updateInput");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            com.baidu.swan.apps.console.c.e("updateInput", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        EditText Dm = c.Dl().Dm();
        if (Dm == null) {
            com.baidu.swan.apps.console.c.e("updateInput", "input组件不存在");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "input组件不存在");
            return false;
        }
        JSONObject cY = o.cY(unitedSchemeEntity.getParam("params"));
        Dm.removeTextChangedListener(c.Dl().Dp());
        if (cY.has("color")) {
            com.baidu.swan.apps.console.c.i("updateInput", "update color start");
            try {
                Dm.setTextColor(Color.parseColor(cY.optString("color")));
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.console.c.e("updateInput", "color 解析错误");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                Dm.addTextChangedListener(c.Dl().Dp());
                return false;
            }
        }
        if (cY.has(UBC.CONTENT_KEY_VALUE)) {
            com.baidu.swan.apps.console.c.i("updateInput", "update text start");
            String optString = cY.optString(UBC.CONTENT_KEY_VALUE);
            if (!TextUtils.equals(optString, Dm.getText())) {
                Dm.setText(optString);
                try {
                    Dm.setSelection(optString.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                    com.baidu.swan.apps.console.c.e("updateInput", "value is invalid, out of max length");
                }
            }
        }
        Dm.addTextChangedListener(c.Dl().Dp());
        b Do = c.Dl().Do();
        boolean B = Do != null ? Do.B(cY) : false;
        com.baidu.swan.apps.console.c.i("updateInput", "update success");
        if (B) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, B ? 0 : 1001);
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
        }
        return true;
    }
}
