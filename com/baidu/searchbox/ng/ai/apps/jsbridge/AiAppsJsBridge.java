package com.baidu.searchbox.ng.ai.apps.jsbridge;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsNativeMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceTrace;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.moniter.SchemeTimeCostMoniter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class AiAppsJsBridge extends AiAppBaseJsBridge implements NoProGuard {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_aiapps_jsbridge";
    private static final String TAG = "AiAppsJsBridge";

    public AiAppsJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler) {
        super(context, unitedSchemeMainDispatcher, callbackHandler);
    }

    @JavascriptInterface
    public String allowCrossOrigin() {
        return AiAppsController.getInstance().getCloudConfigData().getAllowCrossOriginSwitch();
    }

    @JavascriptInterface
    public String setData(String str, String str2) {
        int i = 0;
        AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.POST_MSG_TAG, "PostMsg setData handle");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            i = 202;
        } else {
            AiAppsNativeMessage aiAppsNativeMessage = new AiAppsNativeMessage(str, str2);
            AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.POST_MSG_TAG, "PostMsg setData start");
            AiAppsController.getInstance().handleNativeMessage(aiAppsNativeMessage, false);
            AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.POST_MSG_TAG, "PostMsg setData end");
        }
        return UnitedSchemeUtility.wrapCallbackParams(i).toString();
    }

    @JavascriptInterface
    public String dispatch(String str) {
        return doSchemeDispatch(str);
    }

    private String doSchemeDispatch(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str));
            SchemeTimeCostMoniter.getInstance().schemeStart(str);
            this.mMainDispatcher.dispatch(getDispatchContext(), unitedSchemeEntity, this.mCallbackHandler);
            SchemeTimeCostMoniter.getInstance().schemeEnd(str);
            return unitedSchemeEntity.result.toString();
        }
        return UnitedSchemeUtility.wrapCallbackParams(201).toString();
    }
}
