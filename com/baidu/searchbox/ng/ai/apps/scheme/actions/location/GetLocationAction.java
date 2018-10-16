package com.baidu.searchbox.ng.ai.apps.scheme.actions.location;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class GetLocationAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/getLocation";
    private static final String MODULE_TAG = "location";
    private static final String PARAM_ALTITUDE_KEY = "altitude";
    private static final String PARAM_TYPE_KEY = "type";
    private static final int RESULT_OK = 0;
    private static final String TAG = "GetLocationAction";
    private static final String TYPE_GCJ02 = "gcj02";
    private static final String TYPE_WGS84 = "wgs84";

    public GetLocationAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.e("location", "aiapp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final LocationParams parseFromJSON = LocationParams.parseFromJSON(unitedSchemeEntity.getParam("params"));
        if (parseFromJSON == null || !parseFromJSON.isValid()) {
            AiAppsLog.e("location", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (TextUtils.isEmpty(parseFromJSON.mResultCallback)) {
            AiAppsLog.e("location", "empty cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        } else if (!(context instanceof Activity)) {
            AiAppsLog.e("location", "the context is not an activity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        } else {
            aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_LOCATION, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.location.GetLocationAction.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(Boolean bool) {
                    AiAppsLog.i(GetLocationAction.TAG, "authorized result is " + bool);
                    if (bool.booleanValue()) {
                        GetLocationAction.this.handleAuthorized(context, callbackHandler, parseFromJSON);
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(parseFromJSON.mResultCallback, UnitedSchemeUtility.wrapCallbackParams(1001, "the location is not authorized").toString());
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorized(final Context context, final CallbackHandler callbackHandler, final LocationParams locationParams) {
        if (AiAppsUtils.isLocationPermissionGranted()) {
            doRequestLocation(context, callbackHandler, locationParams);
        } else {
            AiAppsController.getInstance().requestPermissionsExt(0, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.location.GetLocationAction.2
                @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    if (i != 0) {
                        callbackHandler.handleSchemeDispatchCallback(locationParams.mResultCallback, UnitedSchemeUtility.wrapCallbackParams(1001, "RequestCode error").toString());
                        AiAppsLog.e("location", "requestCode error");
                        return;
                    }
                    for (int i2 : iArr) {
                        if (i2 == -1) {
                            callbackHandler.handleSchemeDispatchCallback(locationParams.mResultCallback, UnitedSchemeUtility.wrapCallbackParams(401, "User reject").toString());
                            AiAppsLog.d("location", "user reject");
                            return;
                        }
                    }
                    GetLocationAction.this.doRequestLocation(context, callbackHandler, locationParams);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequestLocation(Context context, final CallbackHandler callbackHandler, final LocationParams locationParams) {
        String str;
        if (TextUtils.equals(locationParams.mType, "gcj02")) {
            str = "gcj02";
        } else {
            str = "wgs84";
        }
        AiAppsRuntime.getLocationRuntime().requestLocation(str, false, locationParams.mEnableAltitude, new IAiAppLocationIoc.LocationListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.location.GetLocationAction.3
            @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc.LocationListener
            public void onSuccess(LocationResult locationResult) {
                callbackHandler.handleSchemeDispatchCallback(locationParams.mResultCallback, UnitedSchemeUtility.wrapCallbackParams(locationResult.toJSON(), 0).toString());
            }

            @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc.LocationListener
            public void onFailed(int i) {
                AiAppsLog.e("location", "request location error code : " + i);
                callbackHandler.handleSchemeDispatchCallback(locationParams.mResultCallback, UnitedSchemeUtility.wrapCallbackParams(i).toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LocationParams {
        public boolean mEnableAltitude;
        public String mResultCallback;
        public String mType;

        private LocationParams() {
        }

        public static LocationParams parseFromJSON(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            LocationParams locationParams = new LocationParams();
            try {
                JSONObject jSONObject = new JSONObject(str);
                locationParams.mType = jSONObject.optString("type");
                if (TextUtils.isEmpty(locationParams.mType)) {
                    locationParams.mType = "wgs84";
                }
                locationParams.mEnableAltitude = jSONObject.optBoolean(GetLocationAction.PARAM_ALTITUDE_KEY);
                locationParams.mResultCallback = jSONObject.optString("cb");
                if (TextUtils.isEmpty(locationParams.mResultCallback)) {
                    return null;
                }
                return locationParams;
            } catch (JSONException e) {
                AiAppsLog.e("location", "parse failed: " + Log.getStackTraceString(e));
                return null;
            }
        }

        public boolean isValid() {
            return (TextUtils.equals(this.mType, "wgs84") || TextUtils.equals(this.mType, "gcj02")) && !TextUtils.isEmpty(this.mResultCallback);
        }
    }
}
