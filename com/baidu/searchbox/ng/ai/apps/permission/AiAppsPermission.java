package com.baidu.searchbox.ng.ai.apps.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.SparseArray;
/* loaded from: classes2.dex */
public final class AiAppsPermission {
    private static final boolean DEBUG = false;
    public static final int REQUEST_CAMERA_CODE = 1;
    public static final int REQUEST_LOCATION_CODE = 0;
    public static final int REQUEST_RECORD_CODE = 2;
    private static final String TAG = "AiAppsPermission";
    private SparseArray<PermissionCallback> mCallbacks = new SparseArray<>();

    /* loaded from: classes2.dex */
    public interface PermissionCallback {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    @TargetApi(23)
    public void requestPermissions(Activity activity, int i, @NonNull String[] strArr, PermissionCallback permissionCallback) {
        if (permissionCallback != null) {
            this.mCallbacks.put(i, permissionCallback);
            activity.requestPermissions(strArr, i);
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionCallback permissionCallback = this.mCallbacks.get(i);
        if (permissionCallback != null) {
            permissionCallback.onRequestPermissionsResult(i, strArr, iArr);
            this.mCallbacks.remove(i);
        }
    }
}
