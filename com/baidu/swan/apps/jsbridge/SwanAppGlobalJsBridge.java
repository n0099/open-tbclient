package com.baidu.swan.apps.jsbridge;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.moniter.SchemeTimeCostMoniter;
import com.baidu.swan.apps.as.ai;
@Keep
/* loaded from: classes10.dex */
public class SwanAppGlobalJsBridge extends a {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_jsbridge";
    private static final String TAG = "SwanAppGlobalJsBridge";

    public SwanAppGlobalJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler) {
        super(context, unitedSchemeMainDispatcher, callbackHandler);
    }

    @JavascriptInterface
    public boolean dispatch(final String str) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge.1
            @Override // java.lang.Runnable
            public void run() {
                SwanAppGlobalJsBridge.this.doSchemeDispatch(SwanAppGlobalJsBridge.this.mCallbackHandler.getCurrentPageUrl(), str);
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
        if (DEBUG) {
            Log.d(TAG, "doSchemeDispatch scheme: " + str2 + " mCallbackHandler: " + this.mCallbackHandler);
        }
        SchemeTimeCostMoniter.getInstance().schemeStart(str2);
        boolean dispatch = this.mMainDispatcher.dispatch(getDispatchContext(), unitedSchemeEntity, this.mCallbackHandler);
        SchemeTimeCostMoniter.getInstance().schemeEnd(str2);
        return dispatch;
    }
}
