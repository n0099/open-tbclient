package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes.dex */
public class ab {
    public static boolean checkLocationForBaiduLocation(Context context) {
        boolean z;
        boolean z2;
        if (com.baidu.h.a.MI()) {
            if (context == null) {
                return false;
            }
            try {
                z = com.baidu.h.a.a.checkPermissionGranted(context, "android.permission.READ_PHONE_STATE");
            } catch (Exception e) {
                e = e;
                z = false;
            }
            try {
                z2 = checkLocationForGoogle(context);
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                z2 = false;
                if (z2) {
                }
            }
            return !z2 && z;
        }
        return true;
    }

    public static boolean checkLocationForGoogle(Context context) {
        if (com.baidu.h.a.MI()) {
            if (context != null) {
                try {
                    if (!com.baidu.h.a.a.checkPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION")) {
                        if (!com.baidu.h.a.a.checkPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                            return false;
                        }
                    }
                    return true;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean checkCamera(Context context) {
        if (!com.baidu.h.a.MI()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.h.a.a.checkPermissionGranted(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean checkRecodeAudio(Context context) {
        if (!com.baidu.h.a.MI()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.h.a.a.checkPermissionGranted(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean checkReadPhoneState(Context context) {
        if (!com.baidu.h.a.MI()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.h.a.a.checkPermissionGranted(context, "android.permission.READ_PHONE_STATE");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean checkWriteExternalStorage(Context context) {
        if (!com.baidu.h.a.MI()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.h.a.a.checkPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean d(Activity activity, int i) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_COARSE_LOCATION");
        permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_FINE_LOCATION");
        return permissionJudgePolicy.e(activity, i);
    }

    public static boolean a(Activity activity, int i, PermissionJudgePolicy.a aVar) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_COARSE_LOCATION");
        permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_FINE_LOCATION");
        return permissionJudgePolicy.a(activity, i, PermissionJudgePolicy.EXTRA_DIALOG_REFUSE_POLICY.Reject_all, aVar);
    }

    public static void requestWriteExternalStorage(Activity activity, int i) {
        try {
            com.baidu.h.a.a.requestPermissions(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static ArrayMap<String, Boolean> transformPermissionResult(String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            return null;
        }
        ArrayMap<String, Boolean> arrayMap = new ArrayMap<>(strArr.length);
        for (int i = 0; i < strArr.length && i < iArr.length; i++) {
            arrayMap.put(strArr[i], Boolean.valueOf(iArr[i] == 0));
        }
        return arrayMap;
    }

    public static boolean requestWriteExternalStorgeAndCameraPermission(Activity activity, int i) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        if (!checkWriteExternalStorage(activity.getApplicationContext())) {
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (!checkCamera(activity.getApplicationContext())) {
            permissionJudgePolicy.appendRequestPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        }
        return permissionJudgePolicy.a(activity, i, PermissionJudgePolicy.EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one, null);
    }

    public static boolean ah(Context context, String str) {
        if (!com.baidu.h.a.MI()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.h.a.a.checkPermissionGranted(context, str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }
}
