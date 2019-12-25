package com.baidu.swan.apps.ao.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.b;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    public String bRQ;
    public String bRR;
    private UnitedSchemeEntity buJ;
    private CallbackHandler buK;

    public void d(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            UnitedSchemeUtility.safeCallback(this.buK, this.buJ, wrapCallbackParams.toString(), str);
            if (DEBUG) {
                Log.d("BluetoothStatusCallback", "bluetooth callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
