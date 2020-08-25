package com.baidu.fsg.base.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.fsg.base.NoProguard;
/* loaded from: classes10.dex */
public class PermissionManager implements NoProguard {
    private static final int PERMISSION_REQUEST_CODE_BASE = 0;
    public static final int REQUEST_CODE_CALL_PHONE = 2;
    public static final int REQUEST_CODE_READ_CONTRACT = 3;
    public static final int REQUEST_CODE_READ_SMS = 1;
    public static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 4;

    @TargetApi(23)
    public static void checkCallingPermission(Activity activity, String[] strArr, int i) {
        if (activity != null && strArr != null) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && activity.checkCallingPermission(str) == -1) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        activity.requestPermissions(strArr, i);
                    } else {
                        activity.checkSelfPermission(str);
                    }
                }
            }
        }
    }

    public static boolean checkCallingPermission(Context context, String str) {
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) == 0;
    }
}
