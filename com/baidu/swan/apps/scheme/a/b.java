package com.baidu.swan.apps.scheme.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
/* loaded from: classes11.dex */
public class b extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aiapps_scheme_compat_interceptor";
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Uri uri = unitedSchemeEntity.getUri();
        String firstPath = unitedSchemeEntity.getFirstPath();
        if (uri != null && !TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(firstPath)) {
            String host = uri.getHost();
            if (host.toLowerCase().matches("v\\d+") && TextUtils.equals(firstPath, "swan")) {
                String uri2 = uri.toString();
                if (!TextUtils.isEmpty(uri2)) {
                    unitedSchemeEntity.resetUriAndPath(Uri.parse(uri2.replace(UnitedSchemeEntity.UNITED_SCHEME + host + "/" + firstPath, UnitedSchemeEntity.UNITED_SCHEME + "swanAPI")));
                }
            }
        }
        return false;
    }
}
