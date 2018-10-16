package com.baidu.searchbox.ng.ai.apps.ar.action;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.ar.listener.ARCameraStateCallback;
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
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public class ARCameraInsertAction extends AbsARAction {
    private static final String ACTION_TYPE = "/swan/ARCamera/insert";
    private AiAppsNAViewContainer mContainer;

    public ARCameraInsertAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        ARCameraAttr parseData = parseData(unitedSchemeEntity);
        this.mContainer = new AiAppsNAViewContainer(context);
        this.mContainer.bindModel(parseData);
        this.mContainer.attach();
        aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_CAMERA, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraInsertAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Boolean bool) {
                ARCameraAttr parseData2 = ARCameraInsertAction.this.parseData(unitedSchemeEntity);
                if (bool.booleanValue()) {
                    ARCameraInsertAction.this.handleAuthorized(context, unitedSchemeEntity, callbackHandler, parseData2);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.CAMERA_USER_DENY);
                ARCameraInsertAction.this.mContainer.removeView();
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
            AiAppsController.getInstance().requestPermissionsExt(1, new String[]{"android.permission.CAMERA"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraInsertAction.2
                @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    boolean z = false;
                    if (i != 1) {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.CAMERA_SYSTEM_DENY);
                        ARCameraInsertAction.this.mContainer.removeView();
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
                        ARCameraInsertAction.this.callback(unitedSchemeEntity, callbackHandler, ARCameraInsertAction.this.executionInstruction(bdWebViewBySlaveId, aRCameraAttr));
                        return;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.CAMERA_SYSTEM_DENY);
                    ARCameraInsertAction.this.mContainer.removeView();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean executionInstruction(WebView webView, final ARCameraAttr aRCameraAttr) {
        if (webView == null || aRCameraAttr == null) {
            return false;
        }
        String str = aRCameraAttr.cameraId;
        AiAppsRectPosition aiAppsRectPosition = aRCameraAttr.position;
        if (TextUtils.isEmpty(str) || aiAppsRectPosition == null || !aiAppsRectPosition.isValid()) {
            return false;
        }
        ARCameraView aRCameraView = new ARCameraView(webView.getContext(), aRCameraAttr, new ARCameraStateCallback() { // from class: com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraInsertAction.3
            @Override // com.baidu.searchbox.ng.ai.apps.ar.listener.ARCameraStateCallback
            public void onLoadComplete() {
                Util.onLoaded(aRCameraAttr.slaveId, aRCameraAttr.cameraId);
            }

            @Override // com.baidu.searchbox.ng.ai.apps.ar.listener.ARCameraStateCallback
            public void onLoadError() {
                Util.onLoadError(aRCameraAttr.slaveId, aRCameraAttr.cameraId);
            }

            @Override // com.baidu.searchbox.ng.ai.apps.ar.listener.ARCameraStateCallback
            public void onScanComplete() {
                Util.onScanEnd(aRCameraAttr.slaveId, aRCameraAttr.cameraId);
            }
        });
        this.mContainer.addView(aRCameraView, 0);
        ARCameraUtil.getInstance().addCameraView(aRCameraView);
        return true;
    }
}
