package com.baidu.searchbox.ng.ai.apps.ar.action;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.ar.listener.TakePhotoListener;
import com.baidu.searchbox.ng.ai.apps.ar.manager.ARCameraUtil;
import com.baidu.searchbox.ng.ai.apps.ar.manager.Util;
import com.baidu.searchbox.ng.ai.apps.ar.model.ARCameraAttr;
import com.baidu.searchbox.ng.ai.apps.ar.view.ARCameraView;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
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
public class ARCameraTakePhotoAction extends AbsARAction {
    private static final String ACTION_TYPE = "/swan/ARCamera/takePhoto";
    private static final boolean DEBUG = false;
    private static final String TAG = "ARCameraTakePhotoAction";

    public ARCameraTakePhotoAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp) {
        final ARCameraAttr parseData = parseData(unitedSchemeEntity);
        if (parseData == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final ARCameraView cameraViewBySlaveId = ARCameraUtil.getInstance().getCameraViewBySlaveId(parseData.slaveId);
        if (cameraViewBySlaveId == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final String aiappTmpDirectory = StorageUtil.getAiappTmpDirectory(aiApp.id);
        if (TextUtils.isEmpty(aiappTmpDirectory)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_CAMERA, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraTakePhotoAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    ARCameraTakePhotoAction.this.handleAuthorized(context, unitedSchemeEntity, callbackHandler, aiApp, parseData, cameraViewBySlaveId, aiappTmpDirectory);
                } else {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200101);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorized(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp, final ARCameraAttr aRCameraAttr, final ARCameraView aRCameraView, final String str) {
        if (Util.hasCameraPermission(context)) {
            takePhoto(unitedSchemeEntity, callbackHandler, aiApp, aRCameraView, aRCameraAttr, str);
        } else {
            AiAppsController.getInstance().requestPermissionsExt(1, new String[]{"android.permission.CAMERA"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraTakePhotoAction.2
                @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    boolean z = false;
                    if (i != 1) {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200102);
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
                        ARCameraTakePhotoAction.this.takePhoto(unitedSchemeEntity, callbackHandler, aiApp, aRCameraView, aRCameraAttr, str);
                    } else {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200102);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takePhoto(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp, ARCameraView aRCameraView, final ARCameraAttr aRCameraAttr, String str) {
        final String takePhotoPath = aRCameraView.getTakePhotoPath(str);
        try {
            aRCameraView.takePhoto(takePhotoPath, new TakePhotoListener() { // from class: com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraTakePhotoAction.3
                @Override // com.baidu.searchbox.ng.ai.apps.ar.listener.TakePhotoListener
                public void onSuccess(String str2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tempImagePath", StorageUtil.path2Scheme(takePhotoPath, aiApp.id));
                    } catch (JSONException e) {
                        Util.onExceptionError(aRCameraAttr.slaveId, aRCameraAttr.cameraId);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                }

                @Override // com.baidu.searchbox.ng.ai.apps.ar.listener.TakePhotoListener
                public void onFailure() {
                    ARCameraTakePhotoAction.this.callback(unitedSchemeEntity, callbackHandler, false);
                }
            }, true);
        } catch (Exception e) {
            Util.onExceptionError(aRCameraAttr.slaveId, aRCameraAttr.cameraId);
        }
    }
}
