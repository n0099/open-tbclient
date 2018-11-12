package com.baidu.searchbox.ng.ai.apps.impl.map.action.helper;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
/* loaded from: classes4.dex */
public class LocationPermissionHelper {

    /* loaded from: classes4.dex */
    public interface PermissionCallback {
        void onFail();

        void onSuccess();
    }

    public static void checkLocationPermission(Context context, final PermissionCallback permissionCallback) {
        if (!(context instanceof Activity)) {
            permissionCallback.onFail();
            return;
        }
        AiApp aiApp = AiApp.get();
        if (aiApp != null) {
            aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_LOCATION, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(Boolean bool) {
                    if (bool.booleanValue()) {
                        LocationPermissionHelper.handleAuthorized(PermissionCallback.this);
                    } else {
                        PermissionCallback.this.onFail();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleAuthorized(final PermissionCallback permissionCallback) {
        if (AiAppsUtils.isLocationPermissionGranted()) {
            permissionCallback.onSuccess();
        } else {
            AiAppsController.getInstance().requestPermissionsExt(0, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper.2
                @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    if (i != 0) {
                        PermissionCallback.this.onFail();
                        return;
                    }
                    for (int i2 : iArr) {
                        if (i2 == -1) {
                            PermissionCallback.this.onFail();
                            return;
                        }
                    }
                    PermissionCallback.this.onSuccess();
                }
            });
        }
    }
}
