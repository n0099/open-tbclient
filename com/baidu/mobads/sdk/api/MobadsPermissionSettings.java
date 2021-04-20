package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.RemoteDexLoader;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MobadsPermissionSettings {
    public static final String PERMISSION_APP_LIST = "permission_app_list";
    public static final String PERMISSION_LOCATION = "permission_location";
    public static final String PERMISSION_PHONE_STATE = "permission_read_phone_state";
    public static final String PERMISSION_STORAGE = "permission_storage";
    public static boolean mAccessAppListGranted = true;
    public static boolean mAccessLocationGranted = false;
    public static boolean mExternalStorageGranted = false;
    public static boolean mReadPhoneStateGranted = false;

    public static JSONObject getPermissionInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("permission_location", "" + mAccessLocationGranted);
            jSONObject.put("permission_storage", "" + mExternalStorageGranted);
            jSONObject.put("permission_app_list", "" + mAccessAppListGranted);
            jSONObject.put("permission_read_phone_state", "" + mReadPhoneStateGranted);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static void postPermissionInfoRemote() {
        IXAdContainerFactory containerFactory = RemoteDexLoader.getInstance().getContainerFactory();
        if (containerFactory != null) {
            containerFactory.onTaskDistribute("permission_module", getPermissionInfo());
        }
    }

    public static void setPermissionAppList(boolean z) {
        mAccessAppListGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionLocation(boolean z) {
        mAccessLocationGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionReadDeviceID(boolean z) {
        mReadPhoneStateGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionStorage(boolean z) {
        mExternalStorageGranted = z;
        postPermissionInfoRemote();
    }
}
