package com.baidu.searchbox.ng.ai.apps.media.live.action;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class LivePlayerAction extends AiAppAction {
    private static final String ACTION_FULLSCREEN = "/swan/live/fullScreen";
    private static final String ACTION_MUTE = "/swan/live/mute";
    private static final String ACTION_OPEN = "/swan/live/open";
    private static final String ACTION_PLAY = "/swan/live/play";
    private static final String ACTION_STOP = "/swan/live/stop";
    private static final String ACTION_UPDATE = "/swan/live/update";
    private static final boolean DEBUG = false;
    private static final String MODULE_NAME = "/swan/live";
    private static final String MODULE_PATH = "/swan/live/";
    private static final String MODULE_TAG = "live";
    private static final String TAG = "LivePlayerAction";

    public LivePlayerAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        if (authorize(context, str, unitedSchemeEntity, callbackHandler, aiApp)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return super.handleSubAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
    }

    private boolean authorize(final Context context, final String str, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp) {
        AiApp aiApp2 = AiApp.get();
        if (aiApp2 == null) {
            return false;
        }
        aiApp2.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_LIVE, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.media.live.action.LivePlayerAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    AiAppsLog.i(LivePlayerAction.MODULE_TAG, "authorize success");
                    LivePlayerAction.this.doAction(context, str, unitedSchemeEntity, callbackHandler, aiApp);
                    return;
                }
                AiAppsLog.i(LivePlayerAction.MODULE_TAG, "authorize fail");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(401));
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAction(Context context, String str, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        char c = 65535;
        switch (str.hashCode()) {
            case -866190259:
                if (str.equals(ACTION_MUTE)) {
                    c = 4;
                    break;
                }
                break;
            case -866135938:
                if (str.equals(ACTION_OPEN)) {
                    c = 0;
                    break;
                }
                break;
            case -866110104:
                if (str.equals(ACTION_PLAY)) {
                    c = 2;
                    break;
                }
                break;
            case -866012618:
                if (str.equals(ACTION_STOP)) {
                    c = 3;
                    break;
                }
                break;
            case 838638351:
                if (str.equals(ACTION_FULLSCREEN)) {
                    c = 5;
                    break;
                }
                break;
            case 1038755325:
                if (str.equals(ACTION_UPDATE)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                AiAppsRuntime.getLiveRuntime().open(context, unitedSchemeEntity, callbackHandler, aiApp);
                return;
            case 1:
                AiAppsRuntime.getLiveRuntime().update(context, unitedSchemeEntity, callbackHandler, aiApp);
                return;
            case 2:
                AiAppsRuntime.getLiveRuntime().play(context, unitedSchemeEntity, callbackHandler, aiApp);
                return;
            case 3:
                AiAppsRuntime.getLiveRuntime().stop(context, unitedSchemeEntity, callbackHandler, aiApp);
                return;
            case 4:
                AiAppsRuntime.getLiveRuntime().mute(context, unitedSchemeEntity, callbackHandler, aiApp);
                return;
            case 5:
                AiAppsRuntime.getLiveRuntime().setFullScreen(context, unitedSchemeEntity, callbackHandler, aiApp);
                return;
            default:
                return;
        }
    }
}
