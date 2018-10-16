package com.baidu.searchbox.ng.ai.apps.media.recorder.action;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.media.recorder.AudioRecordParams;
import com.baidu.searchbox.ng.ai.apps.media.recorder.RecordStatusCallback;
import com.baidu.searchbox.ng.ai.apps.media.recorder.manager.AiAppsAudioRecorderManager;
import com.baidu.searchbox.ng.ai.apps.media.recorder.utils.AiAppsRecordConstants;
import com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AudioRecordAction extends AiAppAction {
    public static final String ACTION_PAUSE = "/swan/recorder/pause";
    public static final String ACTION_RESUME = "/swan/recorder/resume";
    public static final String ACTION_START = "/swan/recorder/start";
    public static final String ACTION_STOP = "/swan/recorder/stop";
    protected static final boolean DEBUG = false;
    private static final String MODULE_NAME = "/swan/recorder";
    private static final String MODULE_PATH = "/swan/recorder/";
    private static final String MODULE_TAG = "record";
    protected static final String TAG = "AudioRecordAction";

    public AudioRecordAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str, final AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal aiApp");
            return false;
        } else if (TextUtils.isEmpty(aiApp.id)) {
            AiAppsLog.e(MODULE_TAG, "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none aiApp id");
            return false;
        } else {
            JSONObject paramsJSONObject = getParamsJSONObject(unitedSchemeEntity.getParam("params"));
            if (TextUtils.equals(str, ACTION_START) && paramsJSONObject == null) {
                AiAppsLog.e(MODULE_TAG, "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                return false;
            }
            final AudioRecordParams createFromJSON = AudioRecordParams.createFromJSON(paramsJSONObject, AiAppsAudioRecorderManager.getInstance().getCurrentParams());
            if (createFromJSON == null) {
                AiAppsLog.e(MODULE_TAG, "error params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                return false;
            }
            JSONObject paramsWrongCode = createFromJSON.getParamsWrongCode();
            if (paramsWrongCode != null) {
                AiAppsLog.e(MODULE_TAG, "error params");
                unitedSchemeEntity.result = paramsWrongCode;
                return false;
            }
            final RecordStatusCallback createFromJSON2 = RecordStatusCallback.createFromJSON(callbackHandler, unitedSchemeEntity, createFromJSON.callbacks, AiAppsAudioRecorderManager.getInstance().getCurrentCallbacks());
            if (createFromJSON2 == null) {
                AiAppsLog.e(MODULE_TAG, "error cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                return false;
            }
            final String aiappTmpDirectory = StorageUtil.getAiappTmpDirectory(aiApp.id);
            if (TextUtils.isEmpty(aiappTmpDirectory)) {
                AiAppsLog.e(MODULE_TAG, "none tmp path");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                AiAppsLog.e(MODULE_TAG, "handle action, but context is not Activity");
                return false;
            } else {
                aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_RECORD, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.media.recorder.action.AudioRecordAction.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                    public void onCallback(Boolean bool) {
                        if (bool.booleanValue()) {
                            AudioRecordAction.this.handleAuthorized(context, unitedSchemeEntity, callbackHandler, str, createFromJSON, createFromJSON2, aiappTmpDirectory, aiApp.id);
                            return;
                        }
                        AiAppsLog.e(AudioRecordAction.MODULE_TAG, "record authorize failure");
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
                        if (createFromJSON2 != null) {
                            createFromJSON2.dispatchErrorCallback(2004, AiAppsRecordConstants.ERROR_USER_DENY);
                        }
                    }
                });
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorized(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str, final AudioRecordParams audioRecordParams, final RecordStatusCallback recordStatusCallback, final String str2, final String str3) {
        if (AiAppsAudioRecorderManager.getInstance().hasRecordPermission(context)) {
            dispatchSubAction(callbackHandler, unitedSchemeEntity, str, context, audioRecordParams, recordStatusCallback, str2, str3);
        } else {
            AiAppsController.getInstance().requestPermissionsExt(2, new String[]{"android.permission.RECORD_AUDIO"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.media.recorder.action.AudioRecordAction.2
                @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    if (i != 2 || iArr.length <= 0) {
                        AiAppsLog.e(AudioRecordAction.MODULE_TAG, "none permission");
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                        if (recordStatusCallback != null) {
                            recordStatusCallback.dispatchErrorCallback(2002, AiAppsRecordConstants.ERROR_EXECUTE);
                            return;
                        }
                        return;
                    }
                    boolean z = true;
                    int length = iArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (iArr[i2] == -1) {
                            z = false;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z) {
                        AudioRecordAction.this.dispatchSubAction(callbackHandler, unitedSchemeEntity, str, context, audioRecordParams, recordStatusCallback, str2, str3);
                        return;
                    }
                    AiAppsLog.e(AudioRecordAction.MODULE_TAG, "none permission");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (recordStatusCallback != null) {
                        recordStatusCallback.dispatchErrorCallback(2002, AiAppsRecordConstants.ERROR_EXECUTE);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSubAction(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, AudioRecordParams audioRecordParams, RecordStatusCallback recordStatusCallback, String str2, String str3) {
        char c = 65535;
        switch (str.hashCode()) {
            case 302900500:
                if (str.equals(ACTION_PAUSE)) {
                    c = 1;
                    break;
                }
                break;
            case 306217856:
                if (str.equals(ACTION_START)) {
                    c = 0;
                    break;
                }
                break;
            case 425520420:
                if (str.equals(ACTION_STOP)) {
                    c = 3;
                    break;
                }
                break;
            case 860875983:
                if (str.equals(ACTION_RESUME)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                startRecord(context, audioRecordParams, recordStatusCallback, str2, str3);
                break;
            case 1:
                AiAppsLog.i(MODULE_TAG, "pause");
                pauseRecord();
                break;
            case 2:
                AiAppsLog.i(MODULE_TAG, "resume");
                resumeRecord();
                break;
            case 3:
                AiAppsLog.i(MODULE_TAG, IntentConfig.STOP);
                stopRecord();
                break;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    private void startRecord(Context context, AudioRecordParams audioRecordParams, RecordStatusCallback recordStatusCallback, String str, String str2) {
        AiAppsLog.i(MODULE_TAG, AiAppsRouteMessage.TYPE_INIT);
        AiAppsAudioRecorderManager.getInstance().init(str, audioRecordParams, context, recordStatusCallback, str2);
        AiAppsLog.i(MODULE_TAG, IntentConfig.START);
        AiAppsAudioRecorderManager.getInstance().startRecord(true);
    }

    private void pauseRecord() {
        AiAppsAudioRecorderManager.getInstance().pauseRecord();
    }

    private void resumeRecord() {
        AiAppsAudioRecorderManager.getInstance().resumeRecord();
    }

    private void stopRecord() {
        AiAppsAudioRecorderManager.getInstance().stopRecord();
        AiAppsAudioRecorderManager.release();
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
