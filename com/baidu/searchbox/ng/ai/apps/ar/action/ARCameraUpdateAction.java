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
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsRectPosition;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppActionErrorCode;
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
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public class ARCameraUpdateAction extends AbsARAction {
    private static final String ACTION_TYPE = "/swan/ARCamera/update";

    public ARCameraUpdateAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_CAMERA, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraUpdateAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Boolean bool) {
                ARCameraAttr parseData = ARCameraUpdateAction.this.parseData(unitedSchemeEntity);
                if (bool.booleanValue()) {
                    ARCameraUpdateAction.this.handleAuthorized(context, unitedSchemeEntity, callbackHandler, parseData);
                } else {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.CAMERA_USER_DENY);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorized(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final ARCameraAttr aRCameraAttr) {
        final WebView bdWebViewBySlaveId = AiAppsController.getInstance().getBdWebViewBySlaveId(aRCameraAttr.slaveId);
        if (Util.hasCameraPermission(context)) {
            callback(unitedSchemeEntity, callbackHandler, executionInstruction(bdWebViewBySlaveId, aRCameraAttr));
        } else {
            AiAppsController.getInstance().requestPermissionsExt(1, new String[]{"android.permission.CAMERA"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraUpdateAction.2
                @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    boolean z = false;
                    if (i != 1) {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.CAMERA_SYSTEM_DENY);
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
                        ARCameraUpdateAction.this.callback(unitedSchemeEntity, callbackHandler, ARCameraUpdateAction.this.executionInstruction(bdWebViewBySlaveId, aRCameraAttr));
                        return;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.CAMERA_SYSTEM_DENY);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean executionInstruction(WebView webView, ARCameraAttr aRCameraAttr) {
        boolean z = true;
        if (webView == null || aRCameraAttr == null) {
            return false;
        }
        String str = aRCameraAttr.cameraId;
        AiAppsRectPosition aiAppsRectPosition = aRCameraAttr.position;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ARCameraView cameraViewBySlaveId = ARCameraUtil.getInstance().getCameraViewBySlaveId(aRCameraAttr.slaveId);
        if (cameraViewBySlaveId != null) {
            cameraViewBySlaveId.updateAttr(aRCameraAttr);
        }
        if (aiAppsRectPosition == null || !aiAppsRectPosition.isValid()) {
            return true;
        }
        AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(aRCameraAttr, null);
        if (findNAViewContainer == null || !findNAViewContainer.updateView(aRCameraAttr)) {
            z = false;
        }
        return z;
    }
}
