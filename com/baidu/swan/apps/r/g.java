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
        EditText IU = c.IT().IU();
        if (IU == null) {
            com.baidu.swan.apps.console.c.e("updateInput", "input组件不存在");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "input组件不存在");
            return false;
        }
        JSONObject dP = o.dP(unitedSchemeEntity.getParam("params"));
        IU.removeTextChangedListener(c.IT().IX());
        if (dP.has("color")) {
            com.baidu.swan.apps.console.c.i("updateInput", "update color start");
            try {
                IU.setTextColor(Color.parseColor(dP.optString("color")));
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.console.c.e("updateInput", "color 解析错误");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                IU.addTextChangedListener(c.IT().IX());
                return false;
            }
        }
        if (dP.has("value")) {
            com.baidu.swan.apps.console.c.i("updateInput", "update text start");
            String optString = dP.optString("value");
            if (!TextUtils.equals(optString, IU.getText())) {
                IU.setText(optString);
                try {
                    IU.setSelection(optString.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                    com.baidu.swan.apps.console.c.e("updateInput", "value is invalid, out of max length");
                }
            }
        }
        IU.addTextChangedListener(c.IT().IX());
        b IW = c.IT().IW();
        boolean aa = IW != null ? IW.aa(dP) : false;
        com.baidu.swan.apps.console.c.i("updateInput", "update success");
        if (aa) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, aa ? 0 : 1001);
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
        }
        return true;
    }
}
