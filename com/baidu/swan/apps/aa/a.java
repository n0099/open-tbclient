package com.baidu.swan.apps.aa;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.d.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static volatile a dij;
    public String appId;
    public String dih;
    public String dii;
    public com.baidu.l.a.a dik;

    private a() {
    }

    public static a aDe() {
        if (dij == null) {
            synchronized (a.class) {
                if (dij == null) {
                    dij = new a();
                }
            }
        }
        return dij;
    }

    public boolean a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        String a2 = a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.console.c.i("SwanAppPayLaunchMsg", "wxPay: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (!com.baidu.l.b.aaM().aO(context)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, context.getText(a.h.aiapps_wx_not_install_toast_msg)).showToast();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "had not installed WeChat");
            return false;
        } else if (!i.b("wxPay", com.baidu.swan.apps.model.b.cb(a2, a2))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            com.baidu.swan.apps.console.c.i("SwanAppPayLaunchMsg", "open wxPay page success");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("finalUrl", a2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
    }

    private static String a(UnitedSchemeEntity unitedSchemeEntity, String str) {
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

    public static int jE(int i) {
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
