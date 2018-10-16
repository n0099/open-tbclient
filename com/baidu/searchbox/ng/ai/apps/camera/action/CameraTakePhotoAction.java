package com.baidu.searchbox.ng.ai.apps.camera.action;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.camera.AiAppsCameraManager;
import com.baidu.searchbox.ng.ai.apps.camera.listener.ActionCompleteListener;
import com.baidu.searchbox.ng.ai.apps.camera.model.CameraTakePhotoModel;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CameraTakePhotoAction extends AbsCameraAction {
    private static final String ACTION_TYPE = "/swan/camera/takePhoto";

    public CameraTakePhotoAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp) {
        final CameraTakePhotoModel cameraTakePhotoModel = (CameraTakePhotoModel) parseData(unitedSchemeEntity);
        if (cameraTakePhotoModel == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e("AiAppCamera", "parse json model is null");
            return false;
        }
        final CameraPreview cameraPreviewBySlaveId = AiAppsCameraManager.getIns().getCameraPreviewBySlaveId(cameraTakePhotoModel.slaveId);
        if (cameraPreviewBySlaveId == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            AiAppsLog.e("AiAppCamera", "get camera view is null");
            return false;
        }
        final String aiappTmpDirectory = StorageUtil.getAiappTmpDirectory(aiApp.id);
        if (TextUtils.isEmpty(aiappTmpDirectory)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            AiAppsLog.e("AiAppCamera", "get camera take photo cache path is empty");
            return false;
        }
        aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_CAMERA, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.camera.action.CameraTakePhotoAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    CameraTakePhotoAction.this.handleAuthorized(context, unitedSchemeEntity, callbackHandler, aiApp, cameraTakePhotoModel, cameraPreviewBySlaveId, aiappTmpDirectory);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.CAMERA_USER_DENY);
                AiAppsLog.e("AiAppCamera", "camera authorize failure");
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorized(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp, final CameraTakePhotoModel cameraTakePhotoModel, final CameraPreview cameraPreview, final String str) {
        AiAppsLog.i("AiAppCamera", "handleAuthorized start");
        if (AiAppsCameraManager.getIns().hasCameraPermission(context)) {
            takePhoto(unitedSchemeEntity, callbackHandler, aiApp, cameraPreview, cameraTakePhotoModel, str);
            AiAppsLog.e("AiAppCamera", "has authorize");
            return;
        }
        AiAppsController.getInstance().requestPermissionsExt(1, new String[]{"android.permission.CAMERA"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.camera.action.CameraTakePhotoAction.2
            @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = false;
                if (i != 1) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.CAMERA_SYSTEM_DENY);
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
                    CameraTakePhotoAction.this.takePhoto(unitedSchemeEntity, callbackHandler, aiApp, cameraPreview, cameraTakePhotoModel, str);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.CAMERA_SYSTEM_DENY);
                AiAppsLog.e("AiAppCamera", "user want not authorize");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takePhoto(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp, CameraPreview cameraPreview, final CameraTakePhotoModel cameraTakePhotoModel, String str) {
        AiAppsLog.i("AiAppCamera", "take photo start");
        cameraPreview.setQuality(cameraTakePhotoModel.quality);
        final String takePhotoPath = cameraPreview.getTakePhotoPath(str);
        try {
            cameraPreview.takePicture(takePhotoPath, new ActionCompleteListener() { // from class: com.baidu.searchbox.ng.ai.apps.camera.action.CameraTakePhotoAction.3
                @Override // com.baidu.searchbox.ng.ai.apps.camera.listener.ActionCompleteListener
                public void onSuccess(String str2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tempImagePath", StorageUtil.path2Scheme(takePhotoPath, aiApp.id));
                    } catch (JSONException e) {
                        AiAppsLog.e("AiAppCamera", "take picture onSuccess but json object occur exception");
                        AiAppsCameraManager.getIns().onExceptionError(cameraTakePhotoModel.slaveId, cameraTakePhotoModel.cameraId, false);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                }

                @Override // com.baidu.searchbox.ng.ai.apps.camera.listener.ActionCompleteListener
                public void onFailure() {
                    CameraTakePhotoAction.this.callback(unitedSchemeEntity, callbackHandler, false);
                    AiAppsLog.e("AiAppCamera", "take picture onFailure");
                }
            });
        } catch (Exception e) {
            AiAppsLog.e("AiAppCamera", "take picture api occur exception");
            AiAppsCameraManager.getIns().onExceptionError(cameraTakePhotoModel.slaveId, cameraTakePhotoModel.cameraId, false);
        }
        AiAppsLog.i("AiAppCamera", "take photo end");
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.action.AbsCameraAction
    protected AiAppsNaViewModel parseData(UnitedSchemeEntity unitedSchemeEntity) {
        return new CameraTakePhotoModel(getParamsValue(unitedSchemeEntity));
    }
}
