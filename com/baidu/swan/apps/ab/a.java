package com.baidu.swan.apps.ab;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.d.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    public static volatile a cxO;
    public String appId;
    public String cxM;
    public String cxN;
    public com.baidu.h.a.a cxP;

    private a() {
    }

    public static a anv() {
        if (cxO == null) {
            synchronized (a.class) {
                if (cxO == null) {
                    cxO = new a();
                }
            }
        }
        return cxO;
    }

    public boolean a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        String a = a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.i(TAG, "wxPay: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (!com.baidu.h.b.NT().aG(context)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, context.getText(a.h.aiapps_wx_not_install_toast_msg)).showToast();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "had not installed WeChat");
            return false;
        } else if (!i.b("wxPay", com.baidu.swan.apps.model.b.bB(a, a))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            com.baidu.swan.apps.console.c.i(TAG, "open wxPay page success");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("finalUrl", a);
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
            return new JSONObject(str2).optString(UserAccountActionItem.KEY_SRC);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static int gw(int i) {
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
