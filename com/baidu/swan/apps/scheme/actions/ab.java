package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class ab extends d<com.baidu.swan.apps.scheme.j> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public abstract boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar);

    public ab(com.baidu.swan.apps.scheme.j jVar, String str) {
        super(jVar, str);
    }

    public com.baidu.swan.apps.runtime.e LO() {
        return com.baidu.swan.apps.runtime.e.ZS();
    }

    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        boolean e;
        try {
            if (TextUtils.equals(this.name, str)) {
                e = a(context, unitedSchemeEntity, callbackHandler, LO());
            } else {
                e = e(context, unitedSchemeEntity, callbackHandler, str, LO());
            }
            return e;
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("SwanAppAction", Log.getStackTraceString(th));
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "execute with exception: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar) {
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(101, "not support such action ：" + this.name + str);
        return false;
    }

    @Nullable
    public static JSONObject b(UnitedSchemeEntity unitedSchemeEntity, String str) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        String param = unitedSchemeEntity.getParam(str);
        if (TextUtils.isEmpty(param)) {
            return null;
        }
        try {
            return new JSONObject(param);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}
