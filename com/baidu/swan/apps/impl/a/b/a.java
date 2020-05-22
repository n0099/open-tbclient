package com.baidu.swan.apps.impl.a.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.impl.a.b;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends UnitedSchemeBaseInterceptor {
    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "";
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    public boolean shouldInterceptDispatch(final Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Uri uri = unitedSchemeEntity.getUri();
        if (uri != null && TextUtils.equals(uri.getHost(), "swanAPI")) {
            String path = uri.getPath();
            if (TextUtils.isEmpty(path)) {
                return false;
            }
            if (TextUtils.equals(path, "/clone")) {
                final String m = m(unitedSchemeEntity);
                if (TextUtils.isEmpty(m)) {
                    return false;
                }
                n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.impl.a.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.impl.a.a.aef().S(context, m);
                    }
                }, "cloneSwanAppRunnable");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            } else if (TextUtils.equals(path, "/install")) {
                final String m2 = m(unitedSchemeEntity);
                if (TextUtils.isEmpty(m2)) {
                    return false;
                }
                n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.impl.a.b.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.impl.a.a.aef().kt("cloneResult = " + b.aeh().ku(m2));
                    }
                }, "installSwanAppRunnable");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private String m(UnitedSchemeEntity unitedSchemeEntity) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            return null;
        }
        return optParamsAsJo.optString("appKey");
    }
}
