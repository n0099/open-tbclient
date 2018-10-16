package com.baidu.searchbox.ng.ai.apps.system.memory.action;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.system.memory.TrimMemoryConsumer;
import com.baidu.searchbox.ng.ai.apps.system.memory.TrimMemoryDispatcher;
import com.baidu.searchbox.ng.ai.apps.system.memory.TrimMemoryDispatcherHolder;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MemoryWarningAction extends AiAppAction {
    private static final String KEY_CALLBACK = "cb";
    public static final String MODULE_NAME = "/swan/memoryWarning";
    private static final String TAG = "MemoryWarningAction";

    public MemoryWarningAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (context == null || callbackHandler == null || aiApp == null) {
            AiAppsLog.e(TAG, "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            AiAppsLog.e(TAG, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            AiAppsLog.e(TAG, "callback is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        registerTrimMemoryListener(context, callbackHandler, optString);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public void registerTrimMemoryListener(Context context, final CallbackHandler callbackHandler, final String str) {
        TrimMemoryDispatcher trimMemoryDispatcher;
        if ((context instanceof TrimMemoryDispatcherHolder) && (trimMemoryDispatcher = ((TrimMemoryDispatcherHolder) context).getTrimMemoryDispatcher()) != null) {
            trimMemoryDispatcher.setConsumer(new TrimMemoryConsumer() { // from class: com.baidu.searchbox.ng.ai.apps.system.memory.action.MemoryWarningAction.1
                @Override // com.baidu.searchbox.ng.ai.apps.system.memory.TrimMemoryConsumer
                public void consume(int i) {
                    AiAppsLog.i(MemoryWarningAction.TAG, "trimMemory consume level:" + i);
                    if (i == 10 || i == 15) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("level", i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                    }
                }
            });
        }
    }
}
