package com.baidu.searchbox.ng.ai.apps.console.debugger;

import android.content.Context;
import android.os.Build;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class RemoteDebugAction extends AiAppAction {
    private static final String ACTION_RELOAD = "/swan/remoteDebug/reload";
    private static final String ACTION_SHUTDOWN = "/swan/remoteDebug/shutdown";
    private static final String MODULE_NAME = "/swan/remoteDebug";
    private static final String MODULE_PATH = "/swan/remoteDebug/";
    private static final String TAG = "RemoteDebugAction";

    public RemoteDebugAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        AiAppsLog.d(TAG, "handle entity: " + unitedSchemeEntity.toString());
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        AiAppsLog.i(TAG, "handleSubAction subAction: " + str);
        if (!RemoteDebugger.isRemoteDebug()) {
            AiAppsLog.e(TAG, "Can't invoke this action outside Remote Debug mode");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        AiAppsActivity activity = AiAppsController.getInstance().getActivity();
        char c = 65535;
        switch (str.hashCode()) {
            case 1183295719:
                if (str.equals(ACTION_SHUTDOWN)) {
                    c = 1;
                    break;
                }
                break;
            case 1524864106:
                if (str.equals(ACTION_RELOAD)) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                AiAppsLog.i(TAG, "Remote Debug reload");
                if (activity != null) {
                    AiAppsLaunchInfo launchInfo = activity.getLaunchInfo();
                    activity.getLoadingView().showAiAppStartView();
                    AiAppsController.release();
                    AiAppsController.getInstance().setActivityRef(activity);
                    AiAppsController.getInstance().asyncLoadAiApps(launchInfo);
                    AiApp.updateAiApp(launchInfo);
                }
                return true;
            case 1:
                if (activity != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        activity.finishAndRemoveTask();
                    } else {
                        activity.finish();
                    }
                    System.exit(0);
                }
                return true;
            default:
                return super.handleSubAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
        }
    }
}
