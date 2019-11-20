package com.baidu.swan.apps.aa;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.d.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();
    public static volatile d aZn;
    public String aZk;
    public String aZl;
    public String aZm;
    public com.baidu.swan.apps.aa.a.d aZo;

    private d() {
    }

    public static d Nk() {
        if (aZn == null) {
            synchronized (d.class) {
                if (aZn == null) {
                    aZn = new d();
                }
            }
        }
        return aZn;
    }

    public boolean a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        String b = b(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.i(TAG, "wxPay: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (!com.baidu.swan.apps.u.a.Jz().bh(context)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, context.getText(a.h.aiapps_wx_not_install_toast_msg)).QO();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "had not installed WeChat");
            return false;
        } else if (!g.b("wxPay", com.baidu.swan.apps.model.b.ay(b, b))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            com.baidu.swan.apps.console.c.i(TAG, "open wxPay page success");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("finalUrl", b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
    }

    private static String b(UnitedSchemeEntity unitedSchemeEntity, String str) {
        String str2 = unitedSchemeEntity.getParams().get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new JSONObject(str2).optString("src");
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static int dM(int i) {
        switch (i) {
            case -2:
                return 2;
            case -1:
            default:
                return 6;
            case 0:
                return 0;
        }
    }
}
