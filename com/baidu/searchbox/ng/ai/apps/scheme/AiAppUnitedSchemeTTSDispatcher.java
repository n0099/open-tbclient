package com.baidu.searchbox.ng.ai.apps.scheme;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppTTSIoc;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class AiAppUnitedSchemeTTSDispatcher extends UnitedSchemeBaseDispatcher {
    private static final String ACTION_RESUME = "resume";
    private static final String ACTION_SPEAK = "speak";
    private static final String ACTION_STOP = "stop";
    private static final String ACTION_SUSPEND = "suspend";
    private static final boolean DEBUG = false;
    public static final String MODULE_TTS = "tts";
    private static final String TAG = AiAppUnitedSchemeTTSDispatcher.class.getSimpleName();

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        boolean stop;
        String path = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(path)) {
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        } else {
            IAiAppTTSIoc tTSRuntime = AiAppsRuntime.getTTSRuntime();
            if (tTSRuntime == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "no implementation");
                return false;
            }
            String lowerCase = path.toLowerCase();
            if (TextUtils.equals(lowerCase, ACTION_SPEAK)) {
                stop = tTSRuntime.speak(context, unitedSchemeEntity, callbackHandler);
            } else if (TextUtils.equals(lowerCase, ACTION_SUSPEND)) {
                stop = tTSRuntime.suspend(context, unitedSchemeEntity, callbackHandler);
            } else if (TextUtils.equals(lowerCase, ACTION_RESUME)) {
                stop = tTSRuntime.resume(context, unitedSchemeEntity, callbackHandler);
            } else if (TextUtils.equals(lowerCase, "stop")) {
                stop = tTSRuntime.stop(context, unitedSchemeEntity, callbackHandler);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            }
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForSchemeInvoke(unitedSchemeEntity.getSource(), unitedSchemeEntity.getUri());
            }
            if (unitedSchemeEntity.result == null) {
                if (stop) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return stop;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return stop;
            }
            return stop;
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }
}
