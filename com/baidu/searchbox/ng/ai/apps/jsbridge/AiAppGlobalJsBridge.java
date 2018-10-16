package com.baidu.searchbox.ng.ai.apps.jsbridge;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.moniter.SchemeTimeCostMoniter;
import com.baidu.webkit.sdk.jschecker.BdJsCallInfo;
/* loaded from: classes2.dex */
public class AiAppGlobalJsBridge extends AiAppBaseJsBridge implements NoProGuard {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_jsbridge";
    private static final String TAG = "SearchBoxJsBridge";

    public AiAppGlobalJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler) {
        super(context, unitedSchemeMainDispatcher, callbackHandler);
    }

    @JavascriptInterface
    public boolean dispatch(BdJsCallInfo bdJsCallInfo, String str) {
        return doSchemeDispatch(bdJsCallInfo.getUrl(), str);
    }

    @JavascriptInterface
    public boolean dispatch(final String str) {
        AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.jsbridge.AiAppGlobalJsBridge.1
            @Override // java.lang.Runnable
            public void run() {
                AiAppGlobalJsBridge.this.doSchemeDispatch(AiAppGlobalJsBridge.this.mCallbackHandler.getCurrentPageUrl(), str);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doSchemeDispatch(String str, String str2) {
        if (TextUtils.isEmpty(str2) || !str2.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            return false;
        }
        UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str2));
        unitedSchemeEntity.setReferUrl(this.mCallbackHandler.getCurrentPageUrl());
        unitedSchemeEntity.setPageUrl(str);
        SchemeTimeCostMoniter.getInstance().schemeStart(str2);
        boolean dispatch = this.mMainDispatcher.dispatch(getDispatchContext(), unitedSchemeEntity, this.mCallbackHandler);
        SchemeTimeCostMoniter.getInstance().schemeEnd(str2);
        return dispatch;
    }
}
