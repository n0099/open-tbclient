package com.baidu.swan.apps.scheme.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.b.c.e;
/* loaded from: classes2.dex */
public class b extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aiapps_websafe_interceptor";
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str;
        boolean z = false;
        if (callbackHandler == null || !(callbackHandler instanceof e)) {
            if (DEBUG) {
                Log.d(TAG, "intercept: false, handler is null or not WebSafeHolder");
            }
        } else {
            String wd = ((e) callbackHandler).wd();
            if ("ai_apps_widget".equals(wd)) {
                String n = n(unitedSchemeEntity);
                z = com.baidu.swan.apps.af.a.b.gt(n) ? false : true;
                str = n;
            } else if ("ai_apps_ad_landing".equals(wd)) {
                String n2 = n(unitedSchemeEntity);
                z = com.baidu.swan.apps.af.a.b.gv(n2) ? false : true;
                str = n2;
            } else if (DEBUG) {
                Log.d(TAG, "intercept: false, source frame is not aiapps widget frame");
            }
            if (DEBUG) {
                Log.d(TAG, "intercept: result=" + z + ", path=" + str);
            }
            if (z) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(402);
            }
        }
        return z;
    }

    private String n(UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            return "";
        }
        String path = unitedSchemeEntity.getUri().getPath();
        if (!TextUtils.isEmpty(path) && path.startsWith("/")) {
            return path.substring(1);
        }
        return path;
    }
}
