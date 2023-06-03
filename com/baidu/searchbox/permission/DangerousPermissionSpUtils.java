package com.baidu.searchbox.permission;

import android.util.Log;
import com.baidu.android.util.UniKV;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes4.dex */
public class DangerousPermissionSpUtils extends UniKV {
    public static final String SP_FILE_DANGEROUS_PERMISSION = "dangerous_permission_sp";
    public static final String TAG = "DangerousPermission";

    /* loaded from: classes4.dex */
    public static class Holder {
        public static final DangerousPermissionSpUtils INSTANCE = new DangerousPermissionSpUtils();
    }

    public DangerousPermissionSpUtils() {
        super(SP_FILE_DANGEROUS_PERMISSION);
    }

    public static DangerousPermissionSpUtils getInstance() {
        return Holder.INSTANCE;
    }

    @Override // com.baidu.android.util.UniKV, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return super.getBoolean(str, z);
    }

    @Override // com.baidu.android.util.UniKV, android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (DangerousPermissionRuntime.GLOBAL_DEBUG) {
            Log.d("DangerousPermission", "getString() called with: key = [" + str + "], value = [" + str2 + PreferencesUtil.RIGHT_MOUNT);
        }
        return super.getString(str, str2);
    }

    @Override // com.baidu.android.util.UniKV
    public void putBoolean(String str, boolean z) {
        super.putBoolean(str, z);
    }

    @Override // com.baidu.android.util.UniKV
    public void putString(String str, String str2) {
        if (DangerousPermissionRuntime.GLOBAL_DEBUG) {
            Log.d("DangerousPermission", "putString() called with: key = [" + str + "], value = [" + str2 + PreferencesUtil.RIGHT_MOUNT);
        }
        super.putString(str, str2);
    }
}
