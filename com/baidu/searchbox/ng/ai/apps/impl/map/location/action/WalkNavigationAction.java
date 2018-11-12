package com.baidu.searchbox.ng.ai.apps.impl.map.location.action;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.ng.ai.apps.camera.AiAppsCameraManager;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.model.WalkNavigationModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.walknav.WalkARNavFragment;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.walknav.WalkARNavPreparer;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetworkUtils;
import com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.location.LocationResult;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.webkit.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WalkNavigationAction extends AbsMapBaseAction {
    private static final String LESS_THAN_30 = "the distance is less than 30 meters";
    private static final String LOCATION_ERROR_TEXT = "get location fail";
    private static final String MORE_THAN_50 = "the distance is longer than 50 kilometers";
    private static final String NAV_FAIL_MSG = "prepare route error";
    private static final String NO_CAMERA_AUTHOR_TEXT = "camera is not authorized";
    private static final String NO_CAMERA_PERMISSION_TEXT = "no camera permission";
    private static final String NO_LOCATION_AUTHOR_TEXT = "location is not authorized";
    private static final String NO_LOCATION_PERMISSION_TEXT = "no location permission";
    private static final String NO_NET_MSG = "no network";
    private static final String OTHER_PAGE_TEXT = "open navigation canceled on another page";
    private static final int STATUS_CODE_CAMERA_AUTHOR_FAIL = 1011;
    private static final int STATUS_CODE_CAMERA_PERMISSION_FAIL = 1012;
    private static final int STATUS_CODE_LOCATION_AUTHOR_FAIL = 1009;
    private static final int STATUS_CODE_LOCATION_FAIL = 1007;
    private static final int STATUS_CODE_LOCATION_PERMISSION_FAIL = 1010;
    private static final int STATUS_CODE_NAV_FAIL = 1004;
    private static final int STATUS_CODE_NAV_LESS_30 = 1005;
    private static final int STATUS_CODE_NAV_MORE_50 = 1006;
    private static final int STATUS_CODE_NO_NET = 1003;
    private WeakReference<AiAppsFragment> mTopFragment;

    /* loaded from: classes4.dex */
    public interface OnWalkNavResultCallback {
        void onResult(boolean z, String str);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    protected boolean doAction(final Context context, final MapModel mapModel, WebView webView, final AiApp aiApp, JSONObject jSONObject, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        AiAppsLog.i("map", "WalkNavigationAction start");
        if (!mapModel.isValid()) {
            AiAppsLog.e("map", "model is invalid");
            return false;
        }
        final String str = ((WalkNavigationModel) mapModel).callBack;
        if (TextUtils.isEmpty(str)) {
            AiAppsLog.e("map", "cb is empty");
            return false;
        } else if (!AiAppNetworkUtils.isNetworkConnected(context)) {
            AiAppsLog.w("map", NO_NET_MSG);
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, NO_NET_MSG).toString(), str);
            return true;
        } else {
            this.mTopFragment = new WeakReference<>(AiAppsController.getInstance().getTopAiAppsFragment());
            LocationPermissionHelper.checkLocationPermission(context, new LocationPermissionHelper.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.location.action.WalkNavigationAction.1
                @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper.PermissionCallback
                public void onSuccess() {
                    AiAppsLog.w("map", "location permission success");
                    WalkNavigationAction.this.checkCameraPermission(context, unitedSchemeEntity, mapModel, callbackHandler, aiApp, str);
                }

                @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper.PermissionCallback
                public void onFail() {
                    AiAppsLog.w("map", "location permission fail");
                    aiApp.getSetting().checkAuthorize(ScopeInfo.SCOPE_ID_LOCATION, new TypedCallback<ScopeInfo>() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.location.action.WalkNavigationAction.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                        public void onCallback(ScopeInfo scopeInfo) {
                            if (scopeInfo != null && (scopeInfo.forbidden || !scopeInfo.authorized())) {
                                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1009, WalkNavigationAction.NO_LOCATION_AUTHOR_TEXT).toString(), str);
                            } else {
                                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1010, WalkNavigationAction.NO_LOCATION_PERMISSION_TEXT).toString(), str);
                            }
                        }
                    });
                }
            });
            AiAppsLog.i("map", "WalkNavigationAction end");
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    public WalkNavigationModel getModel(UnitedSchemeEntity unitedSchemeEntity) {
        WalkNavigationModel walkNavigationModel;
        JSONException e;
        JSONObject jSONObject;
        if (unitedSchemeEntity == null) {
            return null;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.isEmpty()) {
            AiAppsLog.e("map", "entity Params is empty");
            return null;
        }
        try {
            jSONObject = new JSONObject(params.get("params"));
            walkNavigationModel = new WalkNavigationModel();
        } catch (JSONException e2) {
            walkNavigationModel = null;
            e = e2;
        }
        try {
            walkNavigationModel.parseFromJson(jSONObject);
            return walkNavigationModel;
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            AiAppsLog.e("map", "entity Params json parse error");
            return walkNavigationModel;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCameraPermission(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final MapModel mapModel, final CallbackHandler callbackHandler, AiApp aiApp, final String str) {
        aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_CAMERA, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.location.action.WalkNavigationAction.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    WalkNavigationAction.this.handleCameraAuthorized(context, unitedSchemeEntity, callbackHandler, (WalkNavigationModel) mapModel);
                    return;
                }
                AiAppsLog.w("map", "camera permission fail");
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1011, WalkNavigationAction.NO_CAMERA_AUTHOR_TEXT).toString(), str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCameraAuthorized(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final WalkNavigationModel walkNavigationModel) {
        AiAppsLog.i("map", "handleAuthorized camera start");
        if (AiAppsCameraManager.getIns().hasCameraPermission(context)) {
            AiAppsLog.e("map", "has camera authorize");
            startWalkNavigation(context, walkNavigationModel, unitedSchemeEntity, callbackHandler);
            return;
        }
        AiAppsController.getInstance().requestPermissionsExt(1, new String[]{"android.permission.CAMERA"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.location.action.WalkNavigationAction.3
            @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = false;
                if (i != 1) {
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, WalkNavigationAction.NO_CAMERA_PERMISSION_TEXT).toString(), walkNavigationModel.callBack);
                    AiAppsLog.e("map", "handleAuthorized camera end, failure");
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
                if (!z) {
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1012, WalkNavigationAction.NO_CAMERA_PERMISSION_TEXT).toString(), walkNavigationModel.callBack);
                    AiAppsLog.e("map", "handleAuthorized camera end, failure");
                    return;
                }
                AiAppsLog.e("map", "has camera authorize");
                WalkNavigationAction.this.startWalkNavigation(context, walkNavigationModel, unitedSchemeEntity, callbackHandler);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWalkNavigation(Context context, final WalkNavigationModel walkNavigationModel, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        AiAppsRuntime.getLocationRuntime().requestLocation("gcj02", true, true, new IAiAppLocationIoc.LocationListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.location.action.WalkNavigationAction.4
            @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc.LocationListener
            public void onSuccess(LocationResult locationResult) {
                AiAppsLog.i("map", "get location ok ");
                WalkNavigationAction.this.prepareWalkNav(AiApp.get().getActivity(), new LatLng(locationResult.latitude, locationResult.longitude), walkNavigationModel.endPt, callbackHandler, unitedSchemeEntity, walkNavigationModel);
            }

            @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc.LocationListener
            public void onFailed(int i) {
                AiAppsLog.i("map", "get location error " + i);
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1007, WalkNavigationAction.LOCATION_ERROR_TEXT).toString(), walkNavigationModel.callBack);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareWalkNav(Activity activity, LatLng latLng, LatLng latLng2, final CallbackHandler callbackHandler, final UnitedSchemeEntity unitedSchemeEntity, final WalkNavigationModel walkNavigationModel) {
        WalkARNavPreparer.prepareWalkNav(activity, latLng, latLng2, new WalkARNavPreparer.OnWalkNavPrepareListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.location.action.WalkNavigationAction.5
            @Override // com.baidu.searchbox.ng.ai.apps.impl.map.location.walknav.WalkARNavPreparer.OnWalkNavPrepareListener
            public void onPrepareStart() {
                AiAppsLog.i("map", "walk navigation onPrepareStart ");
                SDKInitializer.setCoordType(CoordType.BD09LL);
            }

            @Override // com.baidu.searchbox.ng.ai.apps.impl.map.location.walknav.WalkARNavPreparer.OnWalkNavPrepareListener
            public void onPrepareSuccess() {
                AiAppsLog.i("map", "walk navigation onPrepareSuccess ");
                AiAppsFragment topAiAppsFragment = AiAppsController.getInstance().getTopAiAppsFragment();
                if (WalkNavigationAction.this.mTopFragment == null || topAiAppsFragment != WalkNavigationAction.this.mTopFragment.get()) {
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, WalkNavigationAction.OTHER_PAGE_TEXT).toString(), walkNavigationModel.callBack);
                    return;
                }
                SDKInitializer.setCoordType(CoordType.GCJ02);
                WalkARNavFragment.newInstance(null).startFragment();
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0, "").toString(), walkNavigationModel.callBack);
            }

            @Override // com.baidu.searchbox.ng.ai.apps.impl.map.location.walknav.WalkARNavPreparer.OnWalkNavPrepareListener
            public void onPrepareFailed(String str) {
                String jSONObject;
                AiAppsLog.i("map", "walk navigation onPrepareFailed ");
                SDKInitializer.setCoordType(CoordType.GCJ02);
                if (str.contains(WalkNavigationAction.LESS_THAN_30)) {
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1005, WalkNavigationAction.LESS_THAN_30).toString();
                } else if (str.contains(WalkNavigationAction.MORE_THAN_50)) {
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1006, WalkNavigationAction.MORE_THAN_50).toString();
                } else {
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1004, WalkNavigationAction.NAV_FAIL_MSG).toString();
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, jSONObject, walkNavigationModel.callBack);
            }
        });
    }
}
