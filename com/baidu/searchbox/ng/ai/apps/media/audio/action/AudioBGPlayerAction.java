package com.baidu.searchbox.ng.ai.apps.media.audio.action;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsBGAudioPlayer;
import com.baidu.searchbox.ng.ai.apps.media.audio.AudioBGPlayerParams;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AudioBGPlayerAction extends AiAppAction {
    private static final String ACTION_GET_PARAM = "/swan/backgroundAudio/getParamsSync";
    private static final String ACTION_OPEN = "/swan/backgroundAudio/open";
    private static final String ACTION_PAUSE = "/swan/backgroundAudio/pause";
    private static final String ACTION_PLAY = "/swan/backgroundAudio/play";
    private static final String ACTION_SEEK = "/swan/backgroundAudio/seek";
    private static final String ACTION_STOP = "/swan/backgroundAudio/stop";
    private static final String ACTION_UPDATE = "/swan/backgroundAudio/update";
    private static final String MODULE_NAME = "/swan/backgroundAudio";
    private static final String MODULE_PATH = "/swan/backgroundAudio/";
    private static final String MODULE_TAG = "backgroundAudio";
    protected static final String TAG = "AudioBGPlayerAction";

    public AudioBGPlayerAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        AudioBGPlayerParams createFromJSON;
        JSONObject jSONObject;
        boolean z;
        JSONObject paramsJSONObject = getParamsJSONObject(unitedSchemeEntity.getParam("params"));
        if (paramsJSONObject == null) {
            AiAppsLog.e(MODULE_TAG, "param is null!");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        AiAppsBGAudioPlayer backgroundPlayer = aiApp.getBackgroundPlayer();
        if (TextUtils.equals(str, ACTION_OPEN)) {
            createFromJSON = AudioBGPlayerParams.createFromJSON(paramsJSONObject, new AudioBGPlayerParams());
        } else {
            createFromJSON = AudioBGPlayerParams.createFromJSON(paramsJSONObject, backgroundPlayer.getCurrentParams());
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2055590369:
                if (str.equals(ACTION_UPDATE)) {
                    c = 1;
                    break;
                }
                break;
            case -71356960:
                if (str.equals(ACTION_PAUSE)) {
                    c = 3;
                    break;
                }
                break;
            case 239897377:
                if (str.equals(ACTION_GET_PARAM)) {
                    c = 6;
                    break;
                }
                break;
            case 1798797600:
                if (str.equals(ACTION_OPEN)) {
                    c = 0;
                    break;
                }
                break;
            case 1798823434:
                if (str.equals(ACTION_PLAY)) {
                    c = 2;
                    break;
                }
                break;
            case 1798906190:
                if (str.equals(ACTION_SEEK)) {
                    c = 4;
                    break;
                }
                break;
            case 1798920920:
                if (str.equals(ACTION_STOP)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                AiAppsLog.i(MODULE_TAG, "open, audioId " + createFromJSON.mPlayerId);
                backgroundPlayer.openPlayer(createFromJSON, callbackHandler);
                jSONObject = null;
                z = true;
                break;
            case 1:
                AiAppsLog.i(MODULE_TAG, "update, audioId " + createFromJSON.mPlayerId);
                backgroundPlayer.update(createFromJSON);
                jSONObject = null;
                z = true;
                break;
            case 2:
                AiAppsLog.i(MODULE_TAG, "play, audioId " + createFromJSON.mPlayerId);
                backgroundPlayer.resume();
                jSONObject = null;
                z = true;
                break;
            case 3:
                AiAppsLog.i(MODULE_TAG, "pause, audioId " + createFromJSON.mPlayerId);
                backgroundPlayer.pause();
                jSONObject = null;
                z = true;
                break;
            case 4:
                AiAppsLog.i(MODULE_TAG, "seek, audioId " + createFromJSON.mPlayerId + " position " + createFromJSON.mPos);
                backgroundPlayer.seekTo(createFromJSON.mPos);
                jSONObject = null;
                z = true;
                break;
            case 5:
                AiAppsLog.i(MODULE_TAG, "stop, audioId " + createFromJSON.mPlayerId);
                backgroundPlayer.stop();
                jSONObject = null;
                z = true;
                break;
            case 6:
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt(createFromJSON.mGetParam, backgroundPlayer.getCurrentSwanParam(createFromJSON.mGetParam));
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0);
                    return true;
                } catch (JSONException e) {
                    AiAppsLog.e(MODULE_TAG, "getParams error " + e.toString());
                    jSONObject = jSONObject2;
                    z = true;
                    break;
                }
            default:
                jSONObject = null;
                z = false;
                break;
        }
        if (z) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
        return super.handleSubAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
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
