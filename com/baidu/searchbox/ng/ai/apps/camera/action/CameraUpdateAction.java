package com.baidu.searchbox.ng.ai.apps.camera.action;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.camera.AiAppsCameraManager;
import com.baidu.searchbox.ng.ai.apps.camera.model.CameraAttrModel;
import com.baidu.searchbox.ng.ai.apps.camera.view.CameraPreview;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsRectPosition;
import com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.util.NAViewFinder;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class CameraUpdateAction extends AbsCameraAction {
    private static final String ACTION_TYPE = "/swan/camera/update";

    public CameraUpdateAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            AiAppsLog.e("AiAppCamera", "handle action, but context is not Activity");
            return false;
        }
        aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_CAMERA, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.camera.action.CameraUpdateAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Boolean bool) {
                CameraAttrModel cameraAttrModel = (CameraAttrModel) CameraUpdateAction.this.parseData(unitedSchemeEntity);
                if (bool.booleanValue()) {
                    CameraUpdateAction.this.handleAuthorized(context, unitedSchemeEntity, callbackHandler, cameraAttrModel);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200101);
                AiAppsLog.e("AiAppCamera", "camera authorize failure");
            }
        });
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.action.AbsCameraAction
    protected AiAppsNaViewModel parseData(UnitedSchemeEntity unitedSchemeEntity) {
        return new CameraAttrModel(getParamsValue(unitedSchemeEntity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorized(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final CameraAttrModel cameraAttrModel) {
        AiAppsLog.i("AiAppCamera", "handleAuthorized start");
        if (AiAppsCameraManager.getIns().hasCameraPermission(context)) {
            callback(unitedSchemeEntity, callbackHandler, executionInstruction(cameraAttrModel));
            AiAppsLog.e("AiAppCamera", "has authorize");
            return;
        }
        AiAppsController.getInstance().requestPermissionsExt(1, new String[]{"android.permission.CAMERA"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.camera.action.CameraUpdateAction.2
            @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = false;
                if (i != 1) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200102);
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
                    CameraUpdateAction.this.callback(unitedSchemeEntity, callbackHandler, CameraUpdateAction.this.executionInstruction(cameraAttrModel));
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200102);
                AiAppsLog.e("AiAppCamera", "user want not authorize");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean executionInstruction(CameraAttrModel cameraAttrModel) {
        AiAppsLog.i("AiAppCamera", "handle update camera instruction start");
        if (cameraAttrModel == null) {
            AiAppsLog.e("AiAppCamera", "Model is null");
            return false;
        }
        String str = cameraAttrModel.cameraId;
        AiAppsRectPosition aiAppsRectPosition = cameraAttrModel.position;
        if (TextUtils.isEmpty(str) || aiAppsRectPosition == null || !aiAppsRectPosition.isValid()) {
            AiAppsLog.e("AiAppCamera", "cameraId = " + str + " ; position = " + (aiAppsRectPosition == null));
            return false;
        }
        CameraPreview cameraPreviewBySlaveId = AiAppsCameraManager.getIns().getCameraPreviewBySlaveId(cameraAttrModel.slaveId);
        if (cameraPreviewBySlaveId != null) {
            cameraPreviewBySlaveId.updateAttr(cameraAttrModel);
        }
        AiAppsLog.i("AiAppCamera", "handle update camera instruction end");
        AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(cameraAttrModel, null);
        if (findNAViewContainer == null || !findNAViewContainer.updateView(cameraAttrModel)) {
            r0 = false;
        }
        return r0;
    }
}
