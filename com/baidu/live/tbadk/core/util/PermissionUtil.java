package com.baidu.live.tbadk.core.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.baidu.i.a;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PermissionUtil {
    public static boolean checkLocation(Context context) {
        return checkLocationForGoogle(context);
    }

    public static boolean checkLocationForBaiduLocation(Context context) {
        boolean z;
        boolean z2;
        if (a.NX()) {
            if (context == null) {
                return false;
            }
            try {
                z = com.baidu.i.a.a.checkPermissionGranted(context, "android.permission.READ_PHONE_STATE");
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
        if (a.NX()) {
            if (context != null) {
                try {
                    if (!com.baidu.i.a.a.checkPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION")) {
                        if (!com.baidu.i.a.a.checkPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION")) {
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

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (com.baidu.i.a.a.checkPermissionGranted(r3, "android.permission.ACCESS_COARSE_LOCATION") != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkFineLocation(Context context) {
        boolean z = false;
        if (a.NX()) {
            try {
                if (!com.baidu.i.a.a.checkPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION")) {
                }
                z = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            return z;
        }
        return true;
    }

    public static boolean checkCamera(Context context) {
        if (!a.NX()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.i.a.a.checkPermissionGranted(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean checkRecodeAudio(Context context) {
        if (!a.NX()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.i.a.a.checkPermissionGranted(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean checkRecodeAudioStorageDeniedAndShowPrompt(Context context) {
        Context providerContext = providerContext(context);
        if (providerContext == null) {
            return true;
        }
        try {
            if (a.NX() && com.baidu.i.a.a.F(providerContext, PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                BdUtilHelper.showToast(providerContext, a.i.sdk_record_audio_permission_denied_fun_disable);
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return false;
    }

    public static boolean checkReadPhoneState(Context context) {
        if (!com.baidu.i.a.NX()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.i.a.a.checkPermissionGranted(context, "android.permission.READ_PHONE_STATE");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean checkWriteExternalStorage(Context context) {
        if (!com.baidu.i.a.NX()) {
            return true;
        }
        if (context != null) {
            try {
                return com.baidu.i.a.a.checkPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean checkWriteExternalStorageDeniedAndShowPrompt(Context context) {
        Context providerContext = providerContext(context);
        if (providerContext == null) {
            return true;
        }
        try {
            if (com.baidu.i.a.NX() && com.baidu.i.a.a.F(providerContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                BdUtilHelper.showToast(providerContext, a.i.sdk_write_external_storage_permission_denied_fun_disable);
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return false;
    }

    public static Context providerContext(Context context) {
        return context == null ? TbadkCoreApplication.getInst().getContext() : context;
    }

    public static void reuqestLocation(Activity activity, int i) {
        try {
            com.baidu.i.a.a.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void requestWriteExternalStorage(Activity activity, int i) {
        try {
            com.baidu.i.a.a.requestPermissions(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void reuqestReadPhoneState(Activity activity, int i) {
        try {
            com.baidu.i.a.a.requestPermissions(activity, new String[]{"android.permission.READ_PHONE_STATE"}, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void reuqestCamera(Activity activity, int i) {
        try {
            com.baidu.i.a.a.requestPermissions(activity, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, i);
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
        ArrayList arrayList = new ArrayList(2);
        if (!checkWriteExternalStorage(activity.getApplicationContext())) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (!checkCamera(activity.getApplicationContext())) {
            arrayList.add(PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        }
        if (arrayList.size() == 0) {
            return false;
        }
        try {
            com.baidu.i.a.a.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return true;
    }

    public static boolean requestWriteExternalStorgeAndAudioPermission(Activity activity, int i) {
        ArrayList arrayList = new ArrayList(2);
        if (!checkWriteExternalStorage(activity.getApplicationContext())) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (!checkRecodeAudio(activity.getApplicationContext())) {
            arrayList.add(PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        }
        if (arrayList.size() == 0) {
            return false;
        }
        try {
            com.baidu.i.a.a.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return true;
    }

    public static boolean requestRecordAudioPermission(Activity activity, int i) {
        ArrayList arrayList = new ArrayList();
        if (!checkRecodeAudio(activity.getApplicationContext())) {
            arrayList.add(PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        }
        if (arrayList.size() == 0) {
            return false;
        }
        try {
            com.baidu.i.a.a.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return true;
    }
}
