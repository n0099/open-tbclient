package com.baidu.searchbox.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.ext.widget.dialog.BdDialog;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.DangerousPermissionContentUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.permission.popupwindow.PermissionInAppWindow;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class DangerousPermissionManager {
    public static final String CALL_LOG_PERMISIION_GROUP = "android.permission-group.CALL_LOG";
    public static final boolean DEBUG = DangerousPermissionRuntime.GLOBAL_DEBUG;
    public static final int DEFAULT_PERMISSIONS_SIZE = 4;
    public static final String TAG = "PermissionManager";
    public static volatile DangerousPermissionManager sInstance;
    public Context mContext;
    public ArrayList<String> mShowingGroupKeyList = new ArrayList<>(4);
    public HashMap<String, RequestSystemPermissionCallBack> mRequestCallbackMap = new HashMap<>();

    /* loaded from: classes4.dex */
    public interface RequestGrantPermissionCallBack {
        void isClosed();

        void isGranted();
    }

    /* loaded from: classes4.dex */
    public interface RequestPermissionCallBack {
        void isAllAgree(Boolean bool);

        void isShow(String str, Boolean bool);

        void requestResult(String str, Boolean bool);
    }

    /* loaded from: classes4.dex */
    public interface RequestSystemPermissionCallBack {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openPermissionPage() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", AppRuntime.getAppContext().getPackageName(), null));
        ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), intent);
    }

    public DangerousPermissionManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static DangerousPermissionManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (DangerousPermissionManager.class) {
                if (sInstance == null) {
                    sInstance = new DangerousPermissionManager(context);
                }
            }
        }
        return sInstance;
    }

    public static String getPermissionGroupName(String str) {
        PackageManager packageManager;
        if (DangerousPermissionRuntime.getAppContext() != null && (packageManager = DangerousPermissionRuntime.getAppContext().getPackageManager()) != null) {
            try {
                PermissionInfo permissionInfo = packageManager.getPermissionInfo(str, 0);
                if (permissionInfo != null) {
                    return permissionInfo.group;
                }
                return null;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public ArrayList<String> getCurrentShowingList(String[] strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : strArr) {
            String permissionGroupName = getPermissionGroupName(str);
            if (isShowing(permissionGroupName)) {
                arrayList.add(permissionGroupName);
            }
        }
        return arrayList;
    }

    public RequestSystemPermissionCallBack getRequestPermissionCallBack(String str) {
        if (this.mRequestCallbackMap.containsKey(str)) {
            return this.mRequestCallbackMap.get(str);
        }
        return null;
    }

    public void removeRequestPermissionCallBack(String str) {
        if (this.mRequestCallbackMap.containsKey(str)) {
            this.mRequestCallbackMap.remove(str);
        }
    }

    public static void requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.requestPermissions(strArr, i);
        }
    }

    public void requestGrantPermissionsDialog(String str, @NonNull String str2, RequestGrantPermissionCallBack requestGrantPermissionCallBack) {
        requestGrantPermissionsDialog(AppRuntime.getAppContext(), str, str2, requestGrantPermissionCallBack);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String getGrantPermissionMessage(Context context, String str) {
        char c;
        Resources resources = context.getResources();
        switch (str.hashCode()) {
            case -1884274053:
                if (str.equals("storage")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1367751899:
                if (str.equals("camera")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 108103:
                if (str.equals(DangerousPermissionConstants.DANGEROUS_PERMISSION_MIC)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 106642798:
                if (str.equals("phone")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 951526432:
                if (str.equals(DangerousPermissionConstants.DANGEROUS_PERMISSION_CONTACT)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 954925063:
                if (str.equals("message")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1901043637:
                if (str.equals("location")) {
                    c = 2;
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
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f106a);
            case 1:
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f106d);
            case 2:
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f106b);
            case 3:
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f106c);
            case 4:
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f106e);
            case 5:
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f106f);
            case 6:
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1070);
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String getGrantPermissionTitle(Context context, String str) {
        char c;
        String string;
        Resources resources = context.getResources();
        switch (str.hashCode()) {
            case -1884274053:
                if (str.equals("storage")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1367751899:
                if (str.equals("camera")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 108103:
                if (str.equals(DangerousPermissionConstants.DANGEROUS_PERMISSION_MIC)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 106642798:
                if (str.equals("phone")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 951526432:
                if (str.equals(DangerousPermissionConstants.DANGEROUS_PERMISSION_CONTACT)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 954925063:
                if (str.equals("message")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1901043637:
                if (str.equals("location")) {
                    c = 2;
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
                string = resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1067);
                break;
            case 1:
                string = resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1083);
                break;
            case 2:
                string = resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1073);
                break;
            case 3:
                string = resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1082);
                break;
            case 4:
                string = resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1084);
                break;
            case 5:
                string = resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1086);
                break;
            case 6:
                string = resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1089);
                break;
            default:
                string = null;
                break;
        }
        return context.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1071) + string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c5, code lost:
        r1.release();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized ArrayList<String> getNeedShowPermissionGroup(Context context, String[] strArr) {
        DangerousPermissionGroupFinder dangerousPermissionGroupFinder;
        String str;
        if (strArr != null) {
            if (strArr.length > 0) {
                if (DEBUG) {
                    Log.i("PermissionManager", "请求授权数组：\n");
                    for (String str2 : strArr) {
                        Log.i("PermissionManager", "请求授权permission：" + str2);
                    }
                }
                if (ApiUtils.hasQVersion()) {
                    dangerousPermissionGroupFinder = new DangerousPermissionGroupFinder();
                } else {
                    dangerousPermissionGroupFinder = null;
                }
                ArrayList<String> arrayList = new ArrayList<>(4);
                for (String str3 : strArr) {
                    if (!isPermissionGranted(context, str3)) {
                        if (Build.VERSION.SDK_INT < 29) {
                            str = getPermissionGroupName(str3);
                        } else if (dangerousPermissionGroupFinder != null) {
                            str = dangerousPermissionGroupFinder.getPermssionGroupInfo(str3);
                        } else {
                            str = null;
                        }
                        if (str == null || TextUtils.equals(str, "android.permission-group.CALENDAR") || TextUtils.equals(str, "android.permission-group.SENSORS") || TextUtils.equals(str, CALL_LOG_PERMISIION_GROUP)) {
                            break;
                        } else if (getFormatTitle(context, str) != null && !PreferenceUtils.getBoolean(str, false) && arrayList.indexOf(str) == -1 && !isShowing(str)) {
                            arrayList.add(str);
                            this.mShowingGroupKeyList.add(str);
                        }
                    } else if (DEBUG) {
                        Log.i("PermissionManager", str3 + "不需要弹窗！");
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String getPermissionTitle(Context context, String str) {
        char c;
        Resources resources = context.getResources();
        switch (str.hashCode()) {
            case -1639857183:
                if (str.equals("android.permission-group.CONTACTS")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1410061184:
                if (str.equals("android.permission-group.PHONE")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1250730292:
                if (str.equals("android.permission-group.CALENDAR")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1243751087:
                if (str.equals(CALL_LOG_PERMISIION_GROUP)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1140935117:
                if (str.equals("android.permission-group.CAMERA")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 421761675:
                if (str.equals("android.permission-group.SENSORS")) {
                    c = '\b';
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
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1581272376:
                if (str.equals("android.permission-group.MICROPHONE")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1795181803:
                if (str.equals("android.permission-group.SMS")) {
                    c = 5;
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
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1067);
            case 1:
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1083);
            case 2:
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1073);
            case 3:
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1082);
            case 4:
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1084);
            case 5:
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1086);
            case 6:
                return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1089);
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String getPermissionMessage(Context context, String str) {
        char c;
        Resources resources = context.getResources();
        switch (str.hashCode()) {
            case -1639857183:
                if (str.equals("android.permission-group.CONTACTS")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1410061184:
                if (str.equals("android.permission-group.PHONE")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1250730292:
                if (str.equals("android.permission-group.CALENDAR")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1243751087:
                if (str.equals(CALL_LOG_PERMISIION_GROUP)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1140935117:
                if (str.equals("android.permission-group.CAMERA")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 421761675:
                if (str.equals("android.permission-group.SENSORS")) {
                    c = '\b';
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
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1581272376:
                if (str.equals("android.permission-group.MICROPHONE")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1795181803:
                if (str.equals("android.permission-group.SMS")) {
                    c = 5;
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
                String string = DangerousPermissionSpUtils.getInstance().getString("camera", "");
                if (TextUtils.isEmpty(string)) {
                    return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1075);
                }
                return string;
            case 1:
                String string2 = DangerousPermissionSpUtils.getInstance().getString(DangerousPermissionConstants.DANGEROUS_PERMISSION_CONTACT, "");
                if (TextUtils.isEmpty(string2)) {
                    return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f107b);
                }
                return string2;
            case 2:
                String string3 = DangerousPermissionSpUtils.getInstance().getString("location", "");
                if (TextUtils.isEmpty(string3)) {
                    return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1077);
                }
                return string3;
            case 3:
                String string4 = DangerousPermissionSpUtils.getInstance().getString(DangerousPermissionConstants.DANGEROUS_PERMISSION_MIC, "");
                if (TextUtils.isEmpty(string4)) {
                    return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1079);
                }
                return string4;
            case 4:
                String string5 = DangerousPermissionSpUtils.getInstance().getString("phone", "");
                if (TextUtils.isEmpty(string5)) {
                    return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f107d);
                }
                return string5;
            case 5:
                String string6 = DangerousPermissionSpUtils.getInstance().getString("message", "");
                if (TextUtils.isEmpty(string6)) {
                    return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f107f);
                }
                return string6;
            case 6:
                String string7 = DangerousPermissionSpUtils.getInstance().getString("storage", "");
                if (TextUtils.isEmpty(string7)) {
                    return resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1080);
                }
                return string7;
            default:
                return null;
        }
    }

    public static boolean isPermissionGranted(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPermissionGroupGranted(Context context, String[] strArr) {
        for (String str : strArr) {
            if (!isPermissionGranted(context, str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpPermissionState(String str, boolean z) {
        PreferenceUtils.setBoolean(str, z);
    }

    public void addRequestPermissionCallBack(String str, RequestSystemPermissionCallBack requestSystemPermissionCallBack) {
        if (this.mRequestCallbackMap.containsKey(str)) {
            this.mRequestCallbackMap.remove(str);
        }
        this.mRequestCallbackMap.put(str, requestSystemPermissionCallBack);
    }

    private boolean isShowing(String str) {
        if (DEBUG) {
            Log.i("PermissionManager", "isShowing，groupSPKey：" + str);
        }
        if (this.mShowingGroupKeyList.indexOf(str) != -1) {
            if (DEBUG) {
                Log.i("PermissionManager", str + "正在显示中，不能再添加！");
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPermissionsDialog(final Context context, final ArrayList<String> arrayList, final int i, final RequestPermissionCallBack requestPermissionCallBack) {
        final int size;
        if (arrayList != null && arrayList.size() != 0 && i < (size = arrayList.size())) {
            final String str = arrayList.get(i);
            new BdDialog.Builder().setTitle(getFormatTitle(context, str)).setMessage(getPermissionMessage(context, str)).setContext(context).setButton(new BdDialog.BottomItem(AppRuntime.getAppContext().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f0478), new BdDialog.OnItemClickListener() { // from class: com.baidu.searchbox.permission.DangerousPermissionManager.5
                @Override // com.baidu.android.ext.widget.dialog.BdDialog.OnItemClickListener
                public void onItemClick(View view2) {
                    DangerousPermissionManager.this.mShowingGroupKeyList.removeAll(arrayList);
                    DangerousPermissionManager.this.setSpPermissionState(str, false);
                    requestPermissionCallBack.requestResult(str, Boolean.FALSE);
                    requestPermissionCallBack.isAllAgree(Boolean.FALSE);
                }
            })).setButton(new BdDialog.BottomItem(AppRuntime.getAppContext().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f0479), new BdDialog.OnItemClickListener() { // from class: com.baidu.searchbox.permission.DangerousPermissionManager.4
                @Override // com.baidu.android.ext.widget.dialog.BdDialog.OnItemClickListener
                public void onItemClick(View view2) {
                    DangerousPermissionManager.this.mShowingGroupKeyList.remove(str);
                    DangerousPermissionManager.this.setSpPermissionState(str, true);
                    requestPermissionCallBack.requestResult(str, Boolean.TRUE);
                    int i2 = i;
                    if (i2 == size - 1) {
                        requestPermissionCallBack.isAllAgree(Boolean.TRUE);
                    } else {
                        DangerousPermissionManager.this.showPermissionsDialog(context, arrayList, i2 + 1, requestPermissionCallBack);
                    }
                }
            })).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.searchbox.permission.DangerousPermissionManager.3
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    if (i2 == 4) {
                        dialogInterface.dismiss();
                        DangerousPermissionManager.this.mShowingGroupKeyList.removeAll(arrayList);
                        DangerousPermissionManager.this.setSpPermissionState(str, false);
                        requestPermissionCallBack.requestResult(str, Boolean.FALSE);
                        requestPermissionCallBack.isAllAgree(Boolean.FALSE);
                        return true;
                    }
                    return true;
                }
            }).show();
            requestPermissionCallBack.isShow(str, Boolean.TRUE);
        }
    }

    public PermissionInAppWindow buildPermissionInstrumentWindow(Activity activity, String[] strArr) {
        if (activity == null) {
            return null;
        }
        String permissionGroupName = getPermissionGroupName(activity, strArr);
        if (TextUtils.isEmpty(permissionGroupName)) {
            return null;
        }
        String formatTitle = DangerousPermissionContentUtils.INSTANCE.getFormatTitle(activity, permissionGroupName);
        String permissionMessage = DangerousPermissionContentUtils.INSTANCE.getPermissionMessage(activity, permissionGroupName);
        if (TextUtils.isEmpty(formatTitle) || TextUtils.isEmpty(permissionMessage)) {
            return null;
        }
        PermissionInAppWindow permissionInAppWindow = new PermissionInAppWindow(activity);
        permissionInAppWindow.setTitleText(formatTitle);
        permissionInAppWindow.setContentText(permissionMessage);
        return permissionInAppWindow;
    }

    public String getFormatTitle(Context context, String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1088));
        String permissionTitle = getPermissionTitle(context, str);
        if (permissionTitle == null) {
            return null;
        }
        sb.append("\"" + permissionTitle + "\"");
        return sb.toString();
    }

    public String getPermissionGroupName(Context context, String[] strArr) {
        DangerousPermissionGroupFinder dangerousPermissionGroupFinder;
        String str = null;
        for (String str2 : strArr) {
            if (!isPermissionGranted(context, str2)) {
                if (Build.VERSION.SDK_INT < 29) {
                    str = getPermissionGroupName(str2);
                } else {
                    if (ApiUtils.hasQVersion()) {
                        dangerousPermissionGroupFinder = new DangerousPermissionGroupFinder();
                    } else {
                        dangerousPermissionGroupFinder = null;
                    }
                    if (dangerousPermissionGroupFinder != null) {
                        str = dangerousPermissionGroupFinder.getPermssionGroupInfo(str2);
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
            }
        }
        return str;
    }

    public boolean shouldShowPermissionInstrumentWindow(Context context, String[] strArr) {
        boolean z = DangerousPermissionSpUtils.getInstance().getBoolean(DangerousPermissionConstants.PRE_DANGEROUS_PERMISSION_SHOULD_SHOW + getPermissionGroupName(context, strArr), true);
        if (DangerousPermissionRuntime.GLOBAL_DEBUG) {
            Log.d("PermissionManager", "shouldShowPermissionInstrumentWindow = " + z);
        }
        return z;
    }

    public void requestGrantPermissionsDialog(Context context, final String str, @NonNull String str2, final RequestGrantPermissionCallBack requestGrantPermissionCallBack) {
        if (DEBUG) {
            Log.i("PermissionManager", "requestGrantPermissionsDialog: source = " + str + ", permission = " + str2);
        }
        if (str2 == null) {
            Log.e("PermissionManager", "param permission can not be null");
            return;
        }
        String grantPermissionTitle = getGrantPermissionTitle(AppRuntime.getAppContext(), str2);
        if (grantPermissionTitle == null) {
            Log.e("PermissionManager", str2 + " get title failed");
            return;
        }
        String grantPermissionMessage = getGrantPermissionMessage(AppRuntime.getAppContext(), str2);
        if (grantPermissionMessage == null) {
            Log.e("PermissionManager", str2 + " get message failed");
            return;
        }
        final String str3 = "grant_" + str2;
        new BdDialog.Builder().setTitle(grantPermissionTitle).setMessage(grantPermissionMessage).setContext(context).setButton(new BdDialog.BottomItem(AppRuntime.getAppContext().getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1069), new BdDialog.OnItemClickListener() { // from class: com.baidu.searchbox.permission.DangerousPermissionManager.2
            @Override // com.baidu.android.ext.widget.dialog.BdDialog.OnItemClickListener
            public void onItemClick(View view2) {
                DangerousPermissionUtils.sendPermissionUBCEvent(str, "click", str3, "close");
                RequestGrantPermissionCallBack requestGrantPermissionCallBack2 = requestGrantPermissionCallBack;
                if (requestGrantPermissionCallBack2 != null) {
                    requestGrantPermissionCallBack2.isClosed();
                }
            }
        })).setButton(new BdDialog.BottomItem(AppRuntime.getAppContext().getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1068), new BdDialog.OnItemClickListener() { // from class: com.baidu.searchbox.permission.DangerousPermissionManager.1
            @Override // com.baidu.android.ext.widget.dialog.BdDialog.OnItemClickListener
            public void onItemClick(View view2) {
                DangerousPermissionUtils.sendPermissionUBCEvent(str, "click", str3, DangerousPermissionStatistic.UBC_DANGEROUS_PERMISSION_CLICK_JUMP_SETTINGS);
                RequestGrantPermissionCallBack requestGrantPermissionCallBack2 = requestGrantPermissionCallBack;
                if (requestGrantPermissionCallBack2 != null) {
                    requestGrantPermissionCallBack2.isGranted();
                }
                DangerousPermissionManager.this.openPermissionPage();
            }
        })).show();
    }

    public void requestPermissionsDialog(Context context, @NonNull String[] strArr, RequestPermissionCallBack requestPermissionCallBack) {
        if (DEBUG) {
            Log.i("PermissionManager", "requestPermissionsDialog permissions:" + strArr + ",mShowingGroupKeyList:" + this.mShowingGroupKeyList);
        }
        if (strArr != null && strArr.length > 0) {
            ArrayList<String> needShowPermissionGroup = getNeedShowPermissionGroup(context, strArr);
            if (DEBUG) {
                Log.i("PermissionManager", "requestPermissionsDialog needShowGroupList:" + needShowPermissionGroup);
            }
            if (needShowPermissionGroup != null && needShowPermissionGroup.size() > 0) {
                showPermissionsDialog(context, needShowPermissionGroup, 0, requestPermissionCallBack);
                return;
            }
            ArrayList<String> currentShowingList = getCurrentShowingList(strArr);
            if (currentShowingList != null && currentShowingList.size() > 0) {
                requestPermissionCallBack.isAllAgree(Boolean.FALSE);
                return;
            } else {
                requestPermissionCallBack.isAllAgree(Boolean.TRUE);
                return;
            }
        }
        requestPermissionCallBack.isAllAgree(Boolean.TRUE);
    }
}
