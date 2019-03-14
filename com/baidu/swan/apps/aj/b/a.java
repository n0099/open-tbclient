package com.baidu.swan.apps.aj.b;

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
    public String aTH;
    public String aTI;
    private UnitedSchemeEntity ayE;
    private CallbackHandler ayF;

    public void f(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            UnitedSchemeUtility.safeCallback(this.ayF, this.ayE, wrapCallbackParams.toString(), str);
            if (DEBUG) {
                Log.d("BluetoothStatusCallback", "bluetooth callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
