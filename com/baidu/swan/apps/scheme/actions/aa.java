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
/* loaded from: classes11.dex */
public abstract class aa extends d<com.baidu.swan.apps.scheme.j> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public abstract boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar);

    public aa(com.baidu.swan.apps.scheme.j jVar, String str) {
        super(jVar, str);
    }

    public com.baidu.swan.apps.runtime.e Zc() {
        return com.baidu.swan.apps.runtime.e.aoF();
    }

    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        boolean d;
        try {
            if (TextUtils.equals(this.name, str)) {
                d = a(context, unitedSchemeEntity, callbackHandler, Zc());
            } else {
                d = d(context, unitedSchemeEntity, callbackHandler, str, Zc());
            }
            return d;
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("SwanAppAction", Log.getStackTraceString(th));
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "execute with exception: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar) {
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
