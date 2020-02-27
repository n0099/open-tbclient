package com.baidu.swan.apps.scheme.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes11.dex */
public class c extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aiapps_websafe_interceptor";
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String r = r(unitedSchemeEntity);
        boolean a = com.baidu.swan.apps.api.c.a.a(r, callbackHandler);
        if (DEBUG) {
            Log.d(TAG, "intercept: result=" + a + ", path=" + r);
        }
        if (a) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(402);
        }
        return a;
    }

    private String r(UnitedSchemeEntity unitedSchemeEntity) {
        String[] paths;
        if (unitedSchemeEntity == null || (paths = UnitedSchemeUtility.getPaths(unitedSchemeEntity.getUri())) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : paths) {
            sb.append("/").append(str);
        }
        return sb.substring(1);
    }
}
