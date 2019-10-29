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
        EditText IT = c.IS().IT();
        if (IT == null) {
            com.baidu.swan.apps.console.c.e("updateInput", "input组件不存在");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "input组件不存在");
            return false;
        }
        JSONObject dP = o.dP(unitedSchemeEntity.getParam("params"));
        IT.removeTextChangedListener(c.IS().IW());
        if (dP.has("color")) {
            com.baidu.swan.apps.console.c.i("updateInput", "update color start");
            try {
                IT.setTextColor(Color.parseColor(dP.optString("color")));
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.console.c.e("updateInput", "color 解析错误");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                IT.addTextChangedListener(c.IS().IW());
                return false;
            }
        }
        if (dP.has("value")) {
            com.baidu.swan.apps.console.c.i("updateInput", "update text start");
            String optString = dP.optString("value");
            if (!TextUtils.equals(optString, IT.getText())) {
                IT.setText(optString);
                try {
                    IT.setSelection(optString.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                    com.baidu.swan.apps.console.c.e("updateInput", "value is invalid, out of max length");
                }
            }
        }
        IT.addTextChangedListener(c.IS().IW());
        b IV = c.IS().IV();
        boolean Z = IV != null ? IV.Z(dP) : false;
        com.baidu.swan.apps.console.c.i("updateInput", "update success");
        if (Z) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, Z ? 0 : 1001);
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
        }
        return true;
    }
}
