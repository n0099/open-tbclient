package com.baidu.searchbox.ng.ai.apps.scheme.intercept;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.safe.webview.WebSafeCheckers;
import com.baidu.searchbox.ng.ai.apps.safe.webview.WebSafeHolder;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class AiAppsWebSafeInterceptor extends UnitedSchemeBaseInterceptor {
    public static final String AIAPPS_WEBSAFE_INTERCEPTOR_NAME = "aiapps_websafe_interceptor";
    private static final boolean DEBUG = false;
    private static final String TAG = AiAppsWebSafeInterceptor.class.getSimpleName();

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return AIAPPS_WEBSAFE_INTERCEPTOR_NAME;
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        NgWebView webView;
        boolean z = false;
        if (callbackHandler != null && (callbackHandler instanceof WebSafeHolder) && (webView = ((WebSafeHolder) callbackHandler).getWebView()) != null) {
            String qw = webView.getSettings().qw();
            if (AiAppsWebViewManager.FRAME_WHITE_LIST_AI_APPS_WIDGET.equals(qw)) {
                z = WebSafeCheckers.checkWebAction(getUriPath(unitedSchemeEntity)) ? false : true;
            } else if (AiAppsWebViewManager.FRAME_WHITE_LIST_AI_APPS_AD_LANDING.equals(qw)) {
                z = WebSafeCheckers.checkAdLandingWebAction(getUriPath(unitedSchemeEntity)) ? false : true;
            }
            if (z) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(402);
            }
        }
        return z;
    }

    private String getUriPath(UnitedSchemeEntity unitedSchemeEntity) {
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
