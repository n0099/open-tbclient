package com.baidu.mobads.container.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PermissionUtils {
    public static final String PERMISSION_APP_LIST = "permission_app_list";
    public static final String PERMISSION_LOCATION = "permission_location";
    public static final String PERMISSION_PHONE_STATE = "permission_read_phone_state";
    public static final String PERMISSION_STORAGE = "permission_storage";
    public static boolean mAccessAppListGranted = true;
    public static boolean mAccessLocationGranted = false;
    public static boolean mExternalStorageGranted = false;
    public static boolean mReadPhoneStateGranted = false;

    public static boolean checkPermission(Context context, String str) {
        try {
            return Build.VERSION.SDK_INT >= 23 ? context.checkSelfPermission(str) == 0 : context.checkCallingOrSelfPermission(str) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasPermission(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("permission_location".equalsIgnoreCase(str)) {
            return mAccessLocationGranted;
        }
        if ("permission_storage".equalsIgnoreCase(str)) {
            return mExternalStorageGranted;
        }
        if ("permission_app_list".equalsIgnoreCase(str)) {
            return mAccessAppListGranted;
        }
        if ("permission_read_phone_state".equalsIgnoreCase(str)) {
            return mReadPhoneStateGranted;
        }
        return false;
    }

    public static void setPermissionInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("permission_location");
        if (!TextUtils.isEmpty(optString)) {
            mAccessLocationGranted = Boolean.parseBoolean(optString);
        }
        String optString2 = jSONObject.optString("permission_storage");
        if (!TextUtils.isEmpty(optString2)) {
            mExternalStorageGranted = Boolean.parseBoolean(optString2);
        }
        String optString3 = jSONObject.optString("permission_app_list");
        if (!TextUtils.isEmpty(optString3)) {
            mAccessAppListGranted = Boolean.parseBoolean(optString3);
        }
        String optString4 = jSONObject.optString("permission_read_phone_state");
        if (TextUtils.isEmpty(optString4)) {
            return;
        }
        mReadPhoneStateGranted = Boolean.parseBoolean(optString4);
    }
}
