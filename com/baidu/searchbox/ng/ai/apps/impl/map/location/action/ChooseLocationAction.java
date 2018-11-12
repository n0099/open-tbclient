package com.baidu.searchbox.ng.ai.apps.impl.map.location.action;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.ChooseLocationFragment;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.model.ChooseLocationModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.model.SelectedLocationInfo;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.webkit.sdk.WebView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ChooseLocationAction extends AbsMapBaseAction implements ChooseLocationFragment.OnChooseLocationListener {
    private static final boolean DEBUG = false;
    private static final String NO_PERMISSION_TEXT = "location permission fail";
    private static final int STATUS_CODE_CANCEL = 1002;
    private static final int STATUS_CODE_MAP_ERROR = 1007;
    private static final int STATUS_CODE_NO_PERMISSION = 1003;
    private static final String TAG = ChooseLocationAction.class.getSimpleName();
    private CallbackHandler mCallbackHandler;
    private ChooseLocationModel mLocationModel;
    private UnitedSchemeEntity mSchemeEntity;

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    protected boolean doAction(Context context, MapModel mapModel, WebView webView, AiApp aiApp, JSONObject jSONObject, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        AiAppsLog.i("map", "ChooseLocationAction start");
        if (!mapModel.isValid()) {
            AiAppsLog.e("map", "model is invalid");
            return false;
        }
        final String str = ((ChooseLocationModel) mapModel).callBack;
        if (TextUtils.isEmpty(str)) {
            AiAppsLog.e("map", "cb is empty");
            return false;
        }
        this.mSchemeEntity = unitedSchemeEntity;
        this.mCallbackHandler = callbackHandler;
        this.mLocationModel = (ChooseLocationModel) mapModel;
        LocationPermissionHelper.checkLocationPermission(context, new LocationPermissionHelper.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.location.action.ChooseLocationAction.1
            @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper.PermissionCallback
            public void onSuccess() {
                AiAppsLog.w("map", "location permission success");
                ChooseLocationAction.this.doStartChooseLocation();
            }

            @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper.PermissionCallback
            public void onFail() {
                AiAppsLog.w("map", ChooseLocationAction.NO_PERMISSION_TEXT);
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, ChooseLocationAction.NO_PERMISSION_TEXT).toString(), str);
            }
        });
        AiAppsLog.i("map", "ChooseLocationAction end");
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    public ChooseLocationModel getModel(UnitedSchemeEntity unitedSchemeEntity) {
        ChooseLocationModel chooseLocationModel;
        if (unitedSchemeEntity == null) {
            return null;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.isEmpty()) {
            AiAppsLog.e("map", "entity Params is empty");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(params.get("params"));
            chooseLocationModel = new ChooseLocationModel();
            try {
                chooseLocationModel.parseFromJson(jSONObject);
                return chooseLocationModel;
            } catch (JSONException e) {
                AiAppsLog.e("map", "entity Params json parse error");
                return chooseLocationModel;
            }
        } catch (JSONException e2) {
            chooseLocationModel = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStartChooseLocation() {
        ChooseLocationFragment newInstance = ChooseLocationFragment.newInstance(null);
        newInstance.setOnChooseLocationListener(this);
        newInstance.startFragment();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.location.ChooseLocationFragment.OnChooseLocationListener
    public void onCancel() {
        AiAppsLog.i("map", "choose location cancel");
        sendResult(UnitedSchemeUtility.wrapCallbackParams(1002, "choose location canceled").toString());
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.location.ChooseLocationFragment.OnChooseLocationListener
    public void onError() {
        AiAppsLog.i("map", "choose location fail");
        sendResult(UnitedSchemeUtility.wrapCallbackParams(1007, "choose location failed").toString());
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.location.ChooseLocationFragment.OnChooseLocationListener
    public void onSuccess(SelectedLocationInfo selectedLocationInfo) {
        sendResult(UnitedSchemeUtility.wrapCallbackParams(selectedLocationInfo.toJson(), 0).toString());
    }

    private void sendResult(String str) {
        if (this.mCallbackHandler != null && this.mSchemeEntity != null && this.mLocationModel != null) {
            UnitedSchemeUtility.safeCallback(this.mCallbackHandler, this.mSchemeEntity, str, this.mLocationModel.callBack);
        }
    }
}
