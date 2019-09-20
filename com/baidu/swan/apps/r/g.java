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
        EditText DZ = c.DY().DZ();
        if (DZ == null) {
            com.baidu.swan.apps.console.c.e("updateInput", "input组件不存在");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "input组件不存在");
            return false;
        }
        JSONObject df = o.df(unitedSchemeEntity.getParam("params"));
        DZ.removeTextChangedListener(c.DY().Ec());
        if (df.has("color")) {
            com.baidu.swan.apps.console.c.i("updateInput", "update color start");
            try {
                DZ.setTextColor(Color.parseColor(df.optString("color")));
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.console.c.e("updateInput", "color 解析错误");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                DZ.addTextChangedListener(c.DY().Ec());
                return false;
            }
        }
        if (df.has(UBC.CONTENT_KEY_VALUE)) {
            com.baidu.swan.apps.console.c.i("updateInput", "update text start");
            String optString = df.optString(UBC.CONTENT_KEY_VALUE);
            if (!TextUtils.equals(optString, DZ.getText())) {
                DZ.setText(optString);
                try {
                    DZ.setSelection(optString.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                    com.baidu.swan.apps.console.c.e("updateInput", "value is invalid, out of max length");
                }
            }
        }
        DZ.addTextChangedListener(c.DY().Ec());
        b Eb = c.DY().Eb();
        boolean B = Eb != null ? Eb.B(df) : false;
        com.baidu.swan.apps.console.c.i("updateInput", "update success");
        if (B) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, B ? 0 : 1001);
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
        }
        return true;
    }
}
