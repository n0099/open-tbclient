package com.baidu.searchbox.ng.ai.apps.media.audio.action;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerManager;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.baidu.searchbox.ng.ai.apps.media.audio.AudioPlayerParams;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AudioPlayerAction extends AiAppAction {
    private static final String ACTION_DESTROY = "/swan/audio/close";
    private static final String ACTION_OPEN = "/swan/audio/open";
    private static final String ACTION_PAUSE = "/swan/audio/pause";
    private static final String ACTION_PLAY = "/swan/audio/play";
    private static final String ACTION_SEEK = "/swan/audio/seek";
    private static final String ACTION_STOP = "/swan/audio/stop";
    private static final String ACTION_UPDATE = "/swan/audio/update";
    protected static final boolean DEBUG = false;
    private static final String KEY_PARAMS = "params";
    private static final String KEY_PLAYER_ID = "audioId";
    private static final String MODULE_NAME = "/swan/audio";
    private static final String MODULE_PATH = "/swan/audio/";
    private static final String MODULE_TAG = "audio";
    protected static final String TAG = "AudioPlayerAction";

    public AudioPlayerAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        AiAppsAudioPlayer player;
        boolean z;
        JSONObject paramsJSONObject = getParamsJSONObject(unitedSchemeEntity.getParam("params"));
        if (paramsJSONObject == null) {
            AiAppsLog.e("audio", "object is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String optString = paramsJSONObject.optString("audioId");
        if (TextUtils.equals(str, ACTION_OPEN)) {
            player = new AiAppsAudioPlayer(optString);
        } else {
            player = getPlayer(optString);
        }
        if (player == null) {
            AiAppsLog.e("audio", "player is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        AudioPlayerParams createFromJSON = AudioPlayerParams.createFromJSON(paramsJSONObject, player.getCurrentParams());
        if (!createFromJSON.isValid()) {
            AiAppsLog.e("audio", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -740157295:
                if (str.equals(ACTION_UPDATE)) {
                    c = 1;
                    break;
                }
                break;
            case 588994578:
                if (str.equals(ACTION_OPEN)) {
                    c = 0;
                    break;
                }
                break;
            case 589020412:
                if (str.equals(ACTION_PLAY)) {
                    c = 2;
                    break;
                }
                break;
            case 589103168:
                if (str.equals(ACTION_SEEK)) {
                    c = 4;
                    break;
                }
                break;
            case 589117898:
                if (str.equals(ACTION_STOP)) {
                    c = 5;
                    break;
                }
                break;
            case 1067771184:
                if (str.equals(ACTION_DESTROY)) {
                    c = 6;
                    break;
                }
                break;
            case 1079455022:
                if (str.equals(ACTION_PAUSE)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                AiAppsLog.i("audio", "open, audio id:" + createFromJSON.mPlayerId);
                player.openPlayer(createFromJSON, callbackHandler);
                z = true;
                break;
            case 1:
                AiAppsLog.i("audio", "update, audio id:" + createFromJSON.mPlayerId);
                player.update(createFromJSON);
                z = true;
                break;
            case 2:
                AiAppsLog.i("audio", "play, audio id:" + createFromJSON.mPlayerId);
                player.play();
                z = true;
                break;
            case 3:
                AiAppsLog.i("audio", "pause, audio id:" + createFromJSON.mPlayerId);
                player.pause();
                z = true;
                break;
            case 4:
                AiAppsLog.i("audio", "seek, audio id:" + createFromJSON.mPlayerId);
                player.seekTo(createFromJSON.mPos);
                z = true;
                break;
            case 5:
                AiAppsLog.i("audio", "stop, audio id:" + createFromJSON.mPlayerId);
                player.stop();
                z = true;
                break;
            case 6:
                AiAppsLog.i("audio", "release, audio id:" + createFromJSON.mPlayerId);
                player.release();
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return super.handleSubAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
    }

    private AiAppsAudioPlayer getPlayer(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AiAppsPlayerContext playerContext = AiAppsPlayerManager.getPlayerContext(str);
        if (!(playerContext instanceof AiAppsAudioPlayer)) {
            return null;
        }
        return (AiAppsAudioPlayer) playerContext.getPlayerObject();
    }

    private JSONObject getParamsJSONObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            return null;
        }
    }
}
