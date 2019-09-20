package com.baidu.swan.apps.aj.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private UnitedSchemeEntity aAL;
    private CallbackHandler aAM;
    public String aXK;
    public String aXL;

    public void f(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            UnitedSchemeUtility.safeCallback(this.aAM, this.aAL, wrapCallbackParams.toString(), str);
            if (DEBUG) {
                Log.d("BluetoothStatusCallback", "bluetooth callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
