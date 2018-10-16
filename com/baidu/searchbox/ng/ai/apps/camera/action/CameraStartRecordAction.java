package com.baidu.searchbox.ng.ai.apps.camera.action;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.camera.AiAppsCameraManager;
import com.baidu.searchbox.ng.ai.apps.camera.listener.CameraTimeOutListener;
import com.baidu.searchbox.ng.ai.apps.camera.model.CameraModel;
import com.baidu.searchbox.ng.ai.apps.camera.view.CameraPreview;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppActionErrorCode;
import com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CameraStartRecordAction extends AbsCameraAction {
    private static final String ACTION_TYPE = "/swan/camera/startRecord";
    private static final int CAMERA_TIME_OUT = 31000;
    private static final String TIME_OUT_CALL_BACK = "timeoutCallback";

    public CameraStartRecordAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp) {
        final CameraModel cameraModel = (CameraModel) parseData(unitedSchemeEntity);
        if (cameraModel == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e("AiAppCamera", "parse json model is null");
            return false;
        }
        final CameraPreview cameraPreviewBySlaveId = AiAppsCameraManager.getIns().getCameraPreviewBySlaveId(cameraModel.slaveId);
        if (cameraPreviewBySlaveId == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            AiAppsLog.e("AiAppCamera", "get camera view is null");
            return false;
        }
        final String aiappTmpDirectory = StorageUtil.getAiappTmpDirectory(aiApp.id);
        if (TextUtils.isEmpty(aiappTmpDirectory)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            AiAppsLog.e("AiAppCamera", "get camera start record cache path is empty");
            return false;
        }
        aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_RECORD, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.camera.action.CameraStartRecordAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    CameraStartRecordAction.this.handleAuthorized(context, unitedSchemeEntity, callbackHandler, aiApp, cameraModel, cameraPreviewBySlaveId, aiappTmpDirectory);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.AUDIO_USER_DENY);
                AiAppsLog.e("AiAppCamera", "camera authorize failure");
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorized(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp, final CameraModel cameraModel, final CameraPreview cameraPreview, final String str) {
        AiAppsLog.i("AiAppCamera", "handleAuthorized start");
        if (AiAppsCameraManager.getIns().hasCameraPermission(context) && AiAppsCameraManager.getIns().hasRecordPermission(context)) {
            AiAppsLog.e("AiAppCamera", "has authorize");
            startRecord(unitedSchemeEntity, callbackHandler, aiApp, cameraPreview, cameraModel, str);
            return;
        }
        AiAppsController.getInstance().requestPermissionsExt(1, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.camera.action.CameraStartRecordAction.2
            @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = false;
                if (i != 1) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.AUDIO_SYSTEM_DENY);
                    AiAppsLog.e("AiAppCamera", "handleAuthorized end, failure");
                    return;
                }
                int length = iArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (iArr[i2] == -1) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    CameraStartRecordAction.this.startRecord(unitedSchemeEntity, callbackHandler, aiApp, cameraPreview, cameraModel, str);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.AUDIO_SYSTEM_DENY);
                AiAppsLog.e("AiAppCamera", "user want not authorize");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startRecord(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp, final CameraPreview cameraPreview, CameraModel cameraModel, String str) {
        boolean z;
        AiAppsLog.i("AiAppCamera", "start record start");
        boolean z2 = false;
        final HashMap<String, String> hashMap = new HashMap<>();
        try {
            z = cameraPreview.startRecording(str);
        } catch (Exception e) {
        }
        try {
            hashMap.put("tempVideoPath", StorageUtil.path2Scheme(cameraPreview.getVideoPath(), aiApp.id));
            hashMap.put("tempThumbPath", StorageUtil.path2Scheme(cameraPreview.getThumbPath(), aiApp.id));
            AiAppsCameraManager.getIns().startTimer(CAMERA_TIME_OUT, new CameraTimeOutListener() { // from class: com.baidu.searchbox.ng.ai.apps.camera.action.CameraStartRecordAction.3
                @Override // com.baidu.searchbox.ng.ai.apps.camera.listener.CameraTimeOutListener
                public void timeOut() {
                    cameraPreview.stopRecording();
                    cameraPreview.clearSaveMediaPath();
                    CameraStartRecordAction.this.callBackWhenTimeOutOrCancel(unitedSchemeEntity, callbackHandler, hashMap);
                    AiAppsLog.e("AiAppCamera", "start record timeout");
                }

                @Override // com.baidu.searchbox.ng.ai.apps.camera.listener.CameraTimeOutListener
                public void cancel() {
                    cameraPreview.clearSaveMediaPath();
                    CameraStartRecordAction.this.callBackWhenTimeOutOrCancel(unitedSchemeEntity, callbackHandler, hashMap);
                    AiAppsLog.e("AiAppCamera", "start record cancel");
                }
            });
        } catch (Exception e2) {
            z2 = z;
            AiAppsCameraManager.getIns().onExceptionError(cameraModel.slaveId, cameraModel.cameraId, false);
            AiAppsLog.e("AiAppCamera", "start recording api occur exception");
            z = z2;
            if (!z) {
            }
        }
        if (!z) {
            callBackWithData(unitedSchemeEntity, callbackHandler, hashMap, "");
        } else {
            callback(unitedSchemeEntity, callbackHandler, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void callBackWhenTimeOutOrCancel(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap) {
        HashMap<String, String> params;
        String optString;
        if (unitedSchemeEntity != null && callbackHandler != null && hashMap != null && (params = unitedSchemeEntity.getParams()) != null && !params.isEmpty()) {
            String str = params.get("params");
            if (str != null) {
                try {
                    optString = new JSONObject(str).optString(TIME_OUT_CALL_BACK);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(optString)) {
                    callBackWithData(unitedSchemeEntity, callbackHandler, hashMap, optString);
                    return;
                }
                return;
            }
            optString = null;
            if (TextUtils.isEmpty(optString)) {
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.action.AbsCameraAction
    protected AiAppsNaViewModel parseData(UnitedSchemeEntity unitedSchemeEntity) {
        return new CameraModel(getParamsValue(unitedSchemeEntity));
    }
}
