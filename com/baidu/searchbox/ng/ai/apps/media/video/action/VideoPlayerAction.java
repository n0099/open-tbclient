package com.baidu.searchbox.ng.ai.apps.media.video.action;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes2.dex */
public class VideoPlayerAction extends AiAppAction {
    private static final String ACTION_DANMU = "/swan/video/sendDanmu";
    private static final String ACTION_FULL_SCREEN = "/swan/video/fullScreen";
    private static final String ACTION_OPEN = "/swan/video/open";
    private static final String ACTION_PAUSE = "/swan/video/pause";
    private static final String ACTION_PLAY = "/swan/video/play";
    private static final String ACTION_SEEK = "/swan/video/seek";
    private static final String ACTION_UPDATE = "/swan/video/update";
    private static final boolean DEBUG = false;
    private static final String KEY_PARAMS = "params";
    private static final String KEY_PLAYER_ID = "videoId";
    private static final String MODULE_NAME = "/swan/video";
    private static final String MODULE_PATH = "/swan/video/";
    private static final String MODULE_TAG = "video";
    private static final String TAG = "VideoPlayerAction";

    public VideoPlayerAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        boolean sendDanmu;
        AiAppsLog.d(TAG, "handleSubAction subAction : " + str);
        AiAppsLog.d(TAG, "params : " + getParamAsJo(unitedSchemeEntity, "params"));
        char c = 65535;
        switch (str.hashCode()) {
            case -546094626:
                if (str.equals(ACTION_FULL_SCREEN)) {
                    c = 5;
                    break;
                }
                break;
            case 699042892:
                if (str.equals(ACTION_UPDATE)) {
                    c = 1;
                    break;
                }
                break;
            case 840892398:
                if (str.equals(ACTION_DANMU)) {
                    c = 6;
                    break;
                }
                break;
            case 1680070163:
                if (str.equals(ACTION_PAUSE)) {
                    c = 3;
                    break;
                }
                break;
            case 1716747917:
                if (str.equals(ACTION_OPEN)) {
                    c = 0;
                    break;
                }
                break;
            case 1716773751:
                if (str.equals(ACTION_PLAY)) {
                    c = 2;
                    break;
                }
                break;
            case 1716856507:
                if (str.equals(ACTION_SEEK)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                sendDanmu = AiAppsRuntime.getVideoRuntime().open(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 1:
                sendDanmu = AiAppsRuntime.getVideoRuntime().update(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 2:
                sendDanmu = AiAppsRuntime.getVideoRuntime().play(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 3:
                sendDanmu = AiAppsRuntime.getVideoRuntime().pause(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 4:
                sendDanmu = AiAppsRuntime.getVideoRuntime().seekTo(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 5:
                sendDanmu = AiAppsRuntime.getVideoRuntime().setFullScreen(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 6:
                sendDanmu = AiAppsRuntime.getVideoRuntime().sendDanmu(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            default:
                sendDanmu = false;
                break;
        }
        return sendDanmu || super.handleSubAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
    }
}
