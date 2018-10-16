package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsNativeMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceTrace;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class PostMsgAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/postMessage";

    public PostMsgAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.POST_MSG_TAG, "PostMsgAction handle");
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsNativeMessage createEvent = AiAppsNativeMessage.createEvent(str);
        if (createEvent == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.POST_MSG_TAG, "PostEvent start");
        AiAppsController.getInstance().handleNativeMessage(createEvent, true);
        AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.POST_MSG_TAG, "PostEvent end.");
        return true;
    }
}
