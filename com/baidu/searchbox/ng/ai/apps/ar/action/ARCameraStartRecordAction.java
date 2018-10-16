package com.baidu.searchbox.ng.ai.apps.ar.action;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.ar.listener.RecordListener;
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
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ARCameraStartRecordAction extends AbsARAction {
    private static final String ACTION_TYPE = "/swan/ARCamera/startRecord";
    private static final String PROGRESS_CALLBACK = "onProgressUpdate";
    private static final String STOP_CALLBACK = "stopCallback";

    public ARCameraStartRecordAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
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
        aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_RECORD, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraStartRecordAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    ARCameraStartRecordAction.this.handleAuthorized(context, unitedSchemeEntity, callbackHandler, aiApp, parseData, cameraViewBySlaveId, aiappTmpDirectory);
                } else {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.AUDIO_USER_DENY);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorized(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp, final ARCameraAttr aRCameraAttr, final ARCameraView aRCameraView, final String str) {
        if (Util.hasCameraPermission(context) && Util.hasRecordPermission(context)) {
            startRecord(unitedSchemeEntity, callbackHandler, aiApp, aRCameraView, aRCameraAttr, str);
        } else {
            AiAppsController.getInstance().requestPermissionsExt(1, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraStartRecordAction.2
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
                        ARCameraStartRecordAction.this.startRecord(unitedSchemeEntity, callbackHandler, aiApp, aRCameraView, aRCameraAttr, str);
                    } else {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) AiAppActionErrorCode.Accredit.AUDIO_SYSTEM_DENY);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp, final ARCameraView aRCameraView, final ARCameraAttr aRCameraAttr, String str) {
        boolean z;
        final HashMap<String, String> hashMap = new HashMap<>();
        try {
            String str2 = str + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + ".mp4";
            AiAppsFileUtils.createNewFileSafely(new File(str2));
            hashMap.put("tempVideoPath", StorageUtil.path2Scheme(str2, aiApp.id));
            z = aRCameraView.startRecord(str2, new RecordListener() { // from class: com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraStartRecordAction.3
                private int progress = 0;

                @Override // com.baidu.searchbox.ng.ai.apps.ar.listener.RecordListener
                public void onComplete(String str3) {
                    hashMap.put("tempVideoPath", StorageUtil.path2Scheme(str3, aiApp.id));
                    if (this.progress >= 100) {
                        aRCameraView.stopRecord();
                        aRCameraView.removeVideoPath();
                        ARCameraStartRecordAction.this.callBackWhenTimeOutOrCancel(unitedSchemeEntity, callbackHandler, hashMap);
                    }
                }

                @Override // com.baidu.searchbox.ng.ai.apps.ar.listener.RecordListener
                public void onFailure() {
                    aRCameraView.removeVideoPath();
                    Util.onExceptionError(aRCameraAttr.slaveId, aRCameraAttr.cameraId);
                }

                @Override // com.baidu.searchbox.ng.ai.apps.ar.listener.RecordListener
                public void onProgress(int i) {
                    this.progress = i;
                    ARCameraStartRecordAction.this.callbackProgress(unitedSchemeEntity, callbackHandler, i);
                }
            }, true);
        } catch (Exception e) {
            Util.onExceptionError(aRCameraAttr.slaveId, aRCameraAttr.cameraId);
            z = false;
        }
        if (z) {
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
                    optString = new JSONObject(str).optString(STOP_CALLBACK);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void callbackProgress(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, int i) {
        HashMap<String, String> params;
        String optString;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("progress", String.valueOf(i));
        if (unitedSchemeEntity != null && callbackHandler != null && hashMap != null && (params = unitedSchemeEntity.getParams()) != null && !params.isEmpty()) {
            String str = params.get("params");
            if (str != null) {
                try {
                    optString = new JSONObject(str).optString("onProgressUpdate");
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
}
