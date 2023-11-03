package com.baidu.searchbox.permission;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.permission.DangerousPermissionManager;
import com.baidu.searchbox.permission.popupwindow.PermissionInAppWindow;
import com.baidu.tieba.by;
import com.baidu.ubc.UBC;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DangerousPermissionUtils {
    public static final boolean DEBUG = DangerousPermissionRuntime.GLOBAL_DEBUG;
    public static final String TAG = "PermissionUtils";

    public static void requestGrantPermissionsDialog(Context context, String str, String str2, DangerousPermissionManager.RequestGrantPermissionCallBack requestGrantPermissionCallBack) {
        if (!isAppOnForeground()) {
            if (DangerousPermissionRuntime.GLOBAL_DEBUG) {
                Log.d(TAG, "requestPermissionsDialog: 应用处于后台， 不允许申请权限");
                return;
            }
            return;
        }
        DangerousPermissionManager.getInstance(DangerousPermissionRuntime.getAppContext()).requestGrantPermissionsDialog(context, str, str2, requestGrantPermissionCallBack);
    }

    @Deprecated
    public static void requestPermissionsDialog(String str, Context context, String[] strArr, DangerousPermissionManager.RequestPermissionCallBack requestPermissionCallBack) {
        requestPermissionsDialog(str, context, strArr, requestPermissionCallBack, null, -1, false);
    }

    public static void sendPermissionUBCEvent(String str, String str2, String str3, String str4) {
        sendPermissionUBCEvent(null, str, str2, str3, str4, null, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String appendValueForJson(String str, String str2, String str3) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(str2, str3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject2.toString();
        }
        JSONObject jSONObject3 = null;
        try {
            jSONObject = new JSONObject(str);
            try {
                jSONObject.put(str2, str3);
            } catch (JSONException e2) {
                e = e2;
                jSONObject3 = jSONObject;
                e.printStackTrace();
                jSONObject = jSONObject3;
                if (jSONObject != null) {
                }
            }
        } catch (JSONException e3) {
            e = e3;
        }
        if (jSONObject != null) {
            return "";
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String getPermissionUBCPage(String str) {
        char c;
        switch (str.hashCode()) {
            case -1639857183:
                if (str.equals("android.permission-group.CONTACTS")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1410061184:
                if (str.equals("android.permission-group.PHONE")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1140935117:
                if (str.equals("android.permission-group.CAMERA")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 828638019:
                if (str.equals("android.permission-group.LOCATION")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 852078861:
                if (str.equals("android.permission-group.STORAGE")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1581272376:
                if (str.equals("android.permission-group.MICROPHONE")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1795181803:
                if (str.equals("android.permission-group.SMS")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return DangerousPermissionConstants.DANGEROUS_PERMISSION_MIC;
            case 1:
                return "camera";
            case 2:
                return "location";
            case 3:
                return DangerousPermissionConstants.DANGEROUS_PERMISSION_CONTACT;
            case 4:
            case 5:
                return "storage";
            case 6:
                return "phone";
            default:
                return null;
        }
    }

    public static boolean isAppOnForeground() {
        Context appContext = DangerousPermissionRuntime.getAppContext();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) appContext.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (!runningAppProcessInfo.processName.equals(appContext.getPackageName())) {
                String str = runningAppProcessInfo.processName;
                if (!str.startsWith(appContext.getPackageName() + ":")) {
                    continue;
                }
            }
            if (runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPermissionGroupGranted(Context context, String[] strArr) {
        DangerousPermissionManager.getInstance(DangerousPermissionRuntime.getAppContext());
        return DangerousPermissionManager.isPermissionGroupGranted(DangerousPermissionRuntime.getAppContext(), strArr);
    }

    public static void requestGrantPermissionsDialog(String str, String str2, DangerousPermissionManager.RequestGrantPermissionCallBack requestGrantPermissionCallBack) {
        requestGrantPermissionsDialog(AppRuntime.getAppContext(), str, str2, requestGrantPermissionCallBack);
    }

    public static void requestPermissions(String str, Context context, String[] strArr, int i, DangerousPermissionManager.RequestSystemPermissionCallBack requestSystemPermissionCallBack) {
        if (!isAppOnForeground()) {
            if (DangerousPermissionRuntime.GLOBAL_DEBUG) {
                Log.d(TAG, "requestPermissionsDialog: 应用处于后台， 不允许申请权限");
                return;
            }
            return;
        }
        startPermissionActivity(context, strArr, i, requestSystemPermissionCallBack);
    }

    @Deprecated
    public static void requestPermissionsDialog(final String str, final Context context, final String[] strArr, final DangerousPermissionManager.RequestPermissionCallBack requestPermissionCallBack, final DangerousPermissionManager.RequestSystemPermissionCallBack requestSystemPermissionCallBack, final int i, final boolean z) {
        Context context2;
        if (!isAppOnForeground()) {
            if (DangerousPermissionRuntime.GLOBAL_DEBUG) {
                Log.d(TAG, "requestPermissionsDialog: 应用处于后台， 不允许申请权限");
                return;
            }
            return;
        }
        DangerousPermissionManager dangerousPermissionManager = DangerousPermissionManager.getInstance(DangerousPermissionRuntime.getAppContext());
        if (context == null) {
            context2 = DangerousPermissionRuntime.getAppContext();
        } else {
            context2 = context;
        }
        dangerousPermissionManager.requestPermissionsDialog(context2, strArr, new DangerousPermissionManager.RequestPermissionCallBack() { // from class: com.baidu.searchbox.permission.DangerousPermissionUtils.3
            @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestPermissionCallBack
            public void isAllAgree(Boolean bool) {
                DangerousPermissionManager.RequestSystemPermissionCallBack requestSystemPermissionCallBack2;
                DangerousPermissionManager.RequestPermissionCallBack requestPermissionCallBack2 = DangerousPermissionManager.RequestPermissionCallBack.this;
                if (requestPermissionCallBack2 != null) {
                    requestPermissionCallBack2.isAllAgree(bool);
                }
                if (bool.booleanValue() && Build.VERSION.SDK_INT >= 23 && z && (requestSystemPermissionCallBack2 = requestSystemPermissionCallBack) != null) {
                    DangerousPermissionUtils.startPermissionActivity(context, strArr, i, requestSystemPermissionCallBack2);
                }
            }

            @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestPermissionCallBack
            public void isShow(String str2, Boolean bool) {
                DangerousPermissionManager.RequestPermissionCallBack requestPermissionCallBack2 = DangerousPermissionManager.RequestPermissionCallBack.this;
                if (requestPermissionCallBack2 != null) {
                    requestPermissionCallBack2.isShow(str2, bool);
                }
                if (str2 != null && bool.booleanValue()) {
                    DangerousPermissionUtils.sendPermissionUBCEvent(str, "show", DangerousPermissionUtils.getPermissionUBCPage(str2), null);
                }
            }

            @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestPermissionCallBack
            public void requestResult(String str2, Boolean bool) {
                String str3;
                DangerousPermissionManager.RequestPermissionCallBack requestPermissionCallBack2 = DangerousPermissionManager.RequestPermissionCallBack.this;
                if (requestPermissionCallBack2 != null) {
                    requestPermissionCallBack2.requestResult(str2, bool);
                }
                if (str2 != null) {
                    String permissionUBCPage = DangerousPermissionUtils.getPermissionUBCPage(str2);
                    String str4 = str;
                    if (bool.booleanValue()) {
                        str3 = DangerousPermissionStatistic.UBC_DANGEROUS_PERMISSION_CLICK_AGREE;
                    } else {
                        str3 = "disagree";
                    }
                    DangerousPermissionUtils.sendPermissionUBCEvent(str4, "click", permissionUBCPage, str3);
                }
            }
        });
    }

    @Deprecated
    public static void requestPermissionsDialog(String str, String[] strArr, DangerousPermissionManager.RequestSystemPermissionCallBack requestSystemPermissionCallBack, int i) {
        requestPermissionsDialog(str, DangerousPermissionRuntime.getAppContext(), strArr, null, requestSystemPermissionCallBack, i, true);
    }

    public static void sendPermissionUBCEvent(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (TextUtils.isEmpty(str)) {
                str = "tool";
            }
            jSONObject.put("from", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("source", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("type", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("page", str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                jSONObject.put("value", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                jSONObject.put("ext", str6);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (DEBUG) {
            Log.i(TAG, "DangerousPermissionManager sendPermissionUBCEvent:" + jSONObject.toString());
        }
        UBC.onEvent(DangerousPermissionStatistic.UBC_DANGEROUS_PERMISSION_ID, jSONObject.toString(), i);
    }

    public static void sendPermissionUBCEventPrivacy(String str, String str2, String str3, String str4, String str5, String str6) {
        sendPermissionUBCEvent(str, str2, str3, str4, str5, appendValueForJson(str6, "iid", by.f(AppRuntime.getAppContext()).e()), 128);
    }

    public static DangerousPermissionManager.RequestSystemPermissionCallBack showPermissionInstrumentWindow(String str, final Activity activity, final String[] strArr) {
        final DangerousPermissionManager dangerousPermissionManager = DangerousPermissionManager.getInstance(AppRuntime.getAppContext());
        if (activity == null || activity.isFinishing() || !dangerousPermissionManager.shouldShowPermissionInstrumentWindow(activity, strArr) || DangerousPermissionManager.isPermissionGroupGranted(activity, strArr) || !isAppOnForeground()) {
            return null;
        }
        final PermissionInAppWindow buildPermissionInstrumentWindow = dangerousPermissionManager.buildPermissionInstrumentWindow(activity, strArr);
        if (buildPermissionInstrumentWindow == null) {
            if (DangerousPermissionRuntime.GLOBAL_DEBUG) {
                Log.e(TAG, "permissionInAppWindow is null");
            }
            return null;
        }
        if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.baidu.searchbox.permission.DangerousPermissionUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    PermissionInAppWindow permissionInAppWindow;
                    Activity activity2 = activity;
                    if (activity2 != null && !activity2.isFinishing() && dangerousPermissionManager.shouldShowPermissionInstrumentWindow(activity, strArr) && !DangerousPermissionManager.isPermissionGroupGranted(activity, strArr) && DangerousPermissionUtils.isAppOnForeground() && (permissionInAppWindow = buildPermissionInstrumentWindow) != null && !permissionInAppWindow.isShowing() && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                        buildPermissionInstrumentWindow.showAtLocation(activity.getWindow().getDecorView(), 48, 0, 0);
                        DangerousPermissionSpUtils.getInstance().putBoolean(DangerousPermissionConstants.PRE_DANGEROUS_PERMISSION_SHOULD_SHOW + dangerousPermissionManager.getPermissionGroupName(activity, strArr), false);
                    }
                }
            });
        }
        return new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.searchbox.permission.DangerousPermissionUtils.2
            public boolean hasClosePermissionWindow = false;

            @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
            public void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                if (AppConfig.isDebug()) {
                    Log.d(DangerousPermissionUtils.TAG, "onRequestPermissionsResult: requestCode = " + i + ", hasClosePermissionWindow = " + this.hasClosePermissionWindow);
                }
                PermissionInAppWindow permissionInAppWindow = PermissionInAppWindow.this;
                if (permissionInAppWindow != null && permissionInAppWindow.isShowing() && !this.hasClosePermissionWindow) {
                    PermissionInAppWindow.this.dismiss();
                    this.hasClosePermissionWindow = true;
                }
            }
        };
    }

    public static void startPermissionActivity(Context context, String[] strArr, int i, DangerousPermissionManager.RequestSystemPermissionCallBack requestSystemPermissionCallBack) {
        if (context == null || Build.VERSION.SDK_INT < 23 || DangerousPermissionManager.isPermissionGroupGranted(context, strArr)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), PermissionActivity.class.getName());
        if (!(context instanceof Activity)) {
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        intent.putExtra(PermissionActivity.PERMISSION_CALLBACK_TAG, valueOf);
        intent.putExtra(PermissionActivity.PERMISSION_CODE, i);
        intent.putExtra(PermissionActivity.PERMISSION_ARRAY, strArr);
        DangerousPermissionManager.getInstance(context).addRequestPermissionCallBack(valueOf, requestSystemPermissionCallBack);
        context.startActivity(intent);
    }
}
