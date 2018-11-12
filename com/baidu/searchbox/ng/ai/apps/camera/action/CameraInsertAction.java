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
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class CameraInsertAction extends AbsCameraAction {
    private static final String ACTION_TYPE = "/swan/camera/insert";
    private AiAppsNAViewContainer mContainer;

    public CameraInsertAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            AiAppsLog.e("AiAppCamera", "handle action, but context is not Activity");
            return false;
        }
        final CameraAttrModel cameraAttrModel = (CameraAttrModel) parseData(unitedSchemeEntity);
        this.mContainer = new AiAppsNAViewContainer(context);
        this.mContainer.bindModel(cameraAttrModel);
        this.mContainer.attach();
        aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_CAMERA, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.camera.action.CameraInsertAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    CameraInsertAction.this.handleAuthorized(context, unitedSchemeEntity, callbackHandler, cameraAttrModel);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200101);
                CameraInsertAction.this.mContainer.removeView();
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
    public void handleAuthorized(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final CameraAttrModel cameraAttrModel) {
        AiAppsLog.i("AiAppCamera", "handleAuthorized start");
        if (AiAppsCameraManager.getIns().hasCameraPermission(context)) {
            callback(unitedSchemeEntity, callbackHandler, executionInstruction(context, cameraAttrModel));
            AiAppsLog.e("AiAppCamera", "has authorize");
            return;
        }
        AiAppsController.getInstance().requestPermissionsExt(1, new String[]{"android.permission.CAMERA"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.camera.action.CameraInsertAction.2
            @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = false;
                if (i != 1) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200102);
                    CameraInsertAction.this.mContainer.removeView();
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
                    CameraInsertAction.this.callback(unitedSchemeEntity, callbackHandler, CameraInsertAction.this.executionInstruction(context, cameraAttrModel));
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200102);
                CameraInsertAction.this.mContainer.removeView();
                AiAppsLog.e("AiAppCamera", "user want not authorize");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean executionInstruction(Context context, CameraAttrModel cameraAttrModel) {
        AiAppsLog.i("AiAppCamera", "handle insert camera instruction start");
        if (context == null || cameraAttrModel == null) {
            AiAppsLog.e("AiAppCamera", "Context is null ? = " + (context == null) + " ; model is null ? = " + (cameraAttrModel == null));
            return false;
        }
        String str = cameraAttrModel.cameraId;
        AiAppsRectPosition aiAppsRectPosition = cameraAttrModel.position;
        if (TextUtils.isEmpty(str) || aiAppsRectPosition == null || !aiAppsRectPosition.isValid()) {
            AiAppsLog.e("AiAppCamera", "cameraId = " + str + " ; position = " + (aiAppsRectPosition == null));
            return false;
        }
        CameraPreview cameraPreview = new CameraPreview(context, cameraAttrModel);
        this.mContainer.addView(cameraPreview, 0);
        AiAppsCameraManager.getIns().addCameraPreview(cameraPreview);
        AiAppsLog.e("AiAppCamera", "handle insert camera instruction end");
        return true;
    }
}
