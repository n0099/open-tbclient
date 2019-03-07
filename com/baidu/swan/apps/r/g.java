package com.baidu.swan.apps.r;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends y {
    public g(j jVar) {
        super(jVar, "/swan/updateInput");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            com.baidu.swan.apps.console.c.e("updateInput", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        EditText Cm = c.Cl().Cm();
        if (Cm == null) {
            com.baidu.swan.apps.console.c.e("updateInput", "input组件不存在");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "input组件不存在");
            return false;
        }
        JSONObject dk = n.dk(unitedSchemeEntity.getParam(LegoListActivityConfig.PARAMS));
        Cm.removeTextChangedListener(c.Cl().Cp());
        if (dk.has("color")) {
            com.baidu.swan.apps.console.c.i("updateInput", "update color start");
            try {
                Cm.setTextColor(Color.parseColor(dk.optString("color")));
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.console.c.e("updateInput", "color 解析错误");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                Cm.addTextChangedListener(c.Cl().Cp());
                return false;
            }
        }
        if (dk.has(UBC.CONTENT_KEY_VALUE)) {
            com.baidu.swan.apps.console.c.i("updateInput", "update text start");
            String optString = dk.optString(UBC.CONTENT_KEY_VALUE);
            if (!TextUtils.equals(optString, Cm.getText())) {
                Cm.setText(optString);
                try {
                    Cm.setSelection(optString.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                    com.baidu.swan.apps.console.c.e("updateInput", "value is invalid, out of max length");
                }
            }
        }
        Cm.addTextChangedListener(c.Cl().Cp());
        b Co = c.Cl().Co();
        boolean E = Co != null ? Co.E(dk) : false;
        com.baidu.swan.apps.console.c.i("updateInput", "update success");
        if (E) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, E ? 0 : 1001);
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
        }
        return true;
    }
}
