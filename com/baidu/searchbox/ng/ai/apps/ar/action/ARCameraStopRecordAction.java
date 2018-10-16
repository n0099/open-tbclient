package com.baidu.searchbox.ng.ai.apps.ar.action;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.ar.manager.ARCameraUtil;
import com.baidu.searchbox.ng.ai.apps.ar.manager.Util;
import com.baidu.searchbox.ng.ai.apps.ar.model.ARCameraAttr;
import com.baidu.searchbox.ng.ai.apps.ar.view.ARCameraView;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
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
public class ARCameraStopRecordAction extends AbsARAction {
    private static final String ACTION_TYPE = "/swan/ARCamera/stopRecord";

    public ARCameraStopRecordAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
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
        } else if (TextUtils.isEmpty(StorageUtil.getAiappTmpDirectory(aiApp.id))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_RECORD, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraStopRecordAction.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(Boolean bool) {
                    if (bool.booleanValue()) {
                        ARCameraStopRecordAction.this.handleAuthorized(context, unitedSchemeEntity, callbackHandler, aiApp, parseData, cameraViewBySlaveId);
                    } else {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.AUDIO_USER_DENY);
                    }
                }
            });
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorized(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp, final ARCameraAttr aRCameraAttr, final ARCameraView aRCameraView) {
        if (Util.hasCameraPermission(context) && Util.hasRecordPermission(context)) {
            stopRecord(unitedSchemeEntity, callbackHandler, aiApp, aRCameraView, aRCameraAttr);
        } else {
            AiAppsController.getInstance().requestPermissionsExt(1, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraStopRecordAction.2
                @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    boolean z = false;
                    if (i != 1) {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.AUDIO_SYSTEM_DENY);
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
                        ARCameraStopRecordAction.this.stopRecord(unitedSchemeEntity, callbackHandler, aiApp, aRCameraView, aRCameraAttr);
                    } else {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.AUDIO_SYSTEM_DENY);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecord(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp, ARCameraView aRCameraView, ARCameraAttr aRCameraAttr) {
        boolean z;
        try {
            z = aRCameraView.stopRecord();
        } catch (Exception e) {
            aRCameraView.removeVideoPath();
            Util.onExceptionError(aRCameraAttr.slaveId, aRCameraAttr.cameraId);
            z = false;
        }
        String videoPath = aRCameraView.getVideoPath();
        if (z && !TextUtils.isEmpty(videoPath)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("tempVideoPath", StorageUtil.path2Scheme(videoPath, aiApp.id));
            callBackWithData(unitedSchemeEntity, callbackHandler, hashMap, "");
        } else {
            callback(unitedSchemeEntity, callbackHandler, false);
        }
        aRCameraView.removeVideoPath();
    }
}
