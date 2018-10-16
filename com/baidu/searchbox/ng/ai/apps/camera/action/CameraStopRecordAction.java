package com.baidu.searchbox.ng.ai.apps.camera.action;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.camera.AiAppsCameraManager;
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
/* loaded from: classes2.dex */
public class CameraStopRecordAction extends AbsCameraAction {
    private static final String ACTION_TYPE = "/swan/camera/stopRecord";

    public CameraStopRecordAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
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
        } else if (TextUtils.isEmpty(StorageUtil.getAiappTmpDirectory(aiApp.id))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            AiAppsLog.e("AiAppCamera", "get camera stop record cache path is empty");
            return false;
        } else {
            aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_RECORD, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.camera.action.CameraStopRecordAction.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(Boolean bool) {
                    if (bool.booleanValue()) {
                        CameraStopRecordAction.this.handleAuthorized(context, unitedSchemeEntity, callbackHandler, aiApp, cameraModel, cameraPreviewBySlaveId);
                        return;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.AUDIO_USER_DENY);
                    AiAppsLog.e("AiAppCamera", "camera authorize failure");
                }
            });
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorized(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp, final CameraModel cameraModel, final CameraPreview cameraPreview) {
        AiAppsLog.i("AiAppCamera", "handleAuthorized start");
        if (AiAppsCameraManager.getIns().hasCameraPermission(context) && AiAppsCameraManager.getIns().hasRecordPermission(context)) {
            AiAppsLog.e("AiAppCamera", "has authorize");
            stopRecord(unitedSchemeEntity, callbackHandler, aiApp, cameraPreview, cameraModel);
            return;
        }
        AiAppsController.getInstance().requestPermissionsExt(1, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.camera.action.CameraStopRecordAction.2
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
                    CameraStopRecordAction.this.stopRecord(unitedSchemeEntity, callbackHandler, aiApp, cameraPreview, cameraModel);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.AUDIO_SYSTEM_DENY);
                AiAppsLog.e("AiAppCamera", "user want not authorize");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecord(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp, CameraPreview cameraPreview, CameraModel cameraModel) {
        boolean z;
        AiAppsLog.i("AiAppCamera", "stop record start");
        try {
            z = cameraPreview.stopRecording();
        } catch (Exception e) {
            z = false;
        }
        try {
            AiAppsCameraManager.getIns().stopTimer();
        } catch (Exception e2) {
            cameraPreview.clearSaveMediaPath();
            AiAppsCameraManager.getIns().onExceptionError(cameraModel.slaveId, cameraModel.cameraId, false);
            AiAppsLog.e("AiAppCamera", "stop recording api occur exception");
            String videoPath = cameraPreview.getVideoPath();
            String thumbPath = cameraPreview.getThumbPath();
            if (!z) {
            }
            callback(unitedSchemeEntity, callbackHandler, false);
            cameraPreview.clearSaveMediaPath();
            AiAppsLog.i("AiAppCamera", "stop record end");
        }
        String videoPath2 = cameraPreview.getVideoPath();
        String thumbPath2 = cameraPreview.getThumbPath();
        if (!z && !TextUtils.isEmpty(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("tempVideoPath", StorageUtil.path2Scheme(videoPath2, aiApp.id));
            hashMap.put("tempThumbPath", StorageUtil.path2Scheme(thumbPath2, aiApp.id));
            callBackWithData(unitedSchemeEntity, callbackHandler, hashMap, "");
        } else {
            callback(unitedSchemeEntity, callbackHandler, false);
        }
        cameraPreview.clearSaveMediaPath();
        AiAppsLog.i("AiAppCamera", "stop record end");
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.action.AbsCameraAction
    protected AiAppsNaViewModel parseData(UnitedSchemeEntity unitedSchemeEntity) {
        return new CameraModel(getParamsValue(unitedSchemeEntity));
    }
}
