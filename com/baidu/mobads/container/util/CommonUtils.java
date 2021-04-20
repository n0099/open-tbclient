package com.baidu.mobads.container.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes2.dex */
public class CommonUtils {
    public static final String DIALOG_MESSAGE = "当前是移动网络,是否继续下载?";
    public static final String DIALOG_NEG_TEXT = "连入wifi后下载";
    public static final String DIALOG_POS_TEXT = "继续下载";
    public static final String DIALOG_TITLE = "温馨提示";
    public static final String FILE_TYPE_APK = ".apk";
    public static final String MIMETYPE_APPLICATION_APK = "application/vnd.android.package-archive";
    public static final String MIMETYPE_OCTET_STREAM = "application/octet-stream";
    public static final String TAG = "CommonUtils";

    /* loaded from: classes2.dex */
    public interface DialogOperation {
        void onClickButton(boolean z);
    }

    public static boolean canDownloadLPApk(String str) {
        try {
            return Uri.parse(str).getPath().endsWith(".apk");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean checkRewardVideoExist() {
        try {
            return Class.forName("com.baidu.mobads.interfaces.IXRewardVideoAdContainer") != null;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static String convertArrayToString(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        for (String str : strArr) {
            sb.append(str);
            sb.append(",");
        }
        String sb2 = sb.toString();
        return sb2.endsWith(",") ? sb2.substring(0, sb2.length() - 1) : sb2;
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Bitmap getBitmapFromURL(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getCookieBaiduId(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("BAIDUID=");
        if (split.length != 2 || (str2 = split[1]) == null) {
            return "";
        }
        if (str2.contains(";")) {
            String[] split2 = str2.split(";");
            return split2.length >= 2 ? split2[0] : "";
        }
        return str2;
    }

    @TargetApi(17)
    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static boolean getInstallPermission(Context context) {
        boolean checkPermission = PermissionUtils.checkPermission(context, "android.permission.REQUEST_INSTALL_PACKAGES");
        if (Build.VERSION.SDK_INT < 26 || !checkPermission) {
            return false;
        }
        return context.getPackageManager().canRequestPackageInstalls();
    }

    public static String getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return null;
            }
            int type = activeNetworkInfo.getType();
            if (type != -1) {
                if (type != 0) {
                    return type != 1 ? "other type" : activeNetworkInfo.getTypeName();
                }
                return activeNetworkInfo.getSubtypeName();
            }
            return activeNetworkInfo.getTypeName();
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i, int i2) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(i2 / width, i / height);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getSPBaiduId(Context context) {
        return context.getSharedPreferences("cookiebaiduidsp", 0).getString("cookiebaiduid", "");
    }

    public static int getScreenHeight(Context context) {
        return getScreenRect(context).height();
    }

    @TargetApi(17)
    public static Rect getScreenRect(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        try {
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                return new Rect(0, 0, displayMetrics.heightPixels, displayMetrics.widthPixels);
            }
            return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getScreenWidth(Context context) {
        return getScreenRect(context).width();
    }

    public static int getTargetVersion(Context context) {
        try {
            return context.getApplicationContext().getApplicationInfo().targetSdkVersion;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean isMethodExist(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isUrlForDownloadApk(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            RemoteXAdLogger.getInstance().d("CommonUtils", "download url is empty");
            return false;
        } else if (!"application/vnd.android.package-archive".equals(str2) && ((!"application/octet-stream".equals(str2) || TextUtils.isEmpty(str3) || !str3.contains(".apk")) && !canDownloadLPApk(str))) {
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            remoteXAdLogger.d("CommonUtils", "Other Type :" + str2);
            return false;
        } else {
            RemoteXAdLogger remoteXAdLogger2 = RemoteXAdLogger.getInstance();
            remoteXAdLogger2.d("CommonUtils", "download apk: mimeType = " + str2 + ", Disposition" + str3);
            return true;
        }
    }

    public static boolean isWifi(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int px2dp(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean renameFile(String str, String str2) {
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists()) {
                return file.renameTo(file2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void setSPBaiduId(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("cookiebaiduidsp", 0).edit();
        edit.putString("cookiebaiduid", str);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public static void showAlertDialog(Activity activity, String str, String str2, String str3, String str4, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        if (activity == null) {
            return;
        }
        try {
            new AlertDialog.Builder(activity).setCancelable(z).setTitle(str).setMessage(str2).setPositiveButton(str3, onClickListener).setNegativeButton(str4, onClickListener2).create().show();
        } catch (Throwable unused) {
        }
    }

    public static void showDownloadConfirmDialog(Context context, final DialogOperation dialogOperation) {
        if (dialogOperation == null) {
            return;
        }
        if (context == null || !(context instanceof Activity)) {
            dialogOperation.onClickButton(true);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(DIALOG_TITLE).setMessage(DIALOG_MESSAGE).setPositiveButton(DIALOG_POS_TEXT, new DialogInterface.OnClickListener() { // from class: com.baidu.mobads.container.util.CommonUtils.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DialogOperation.this.onClickButton(true);
            }
        }).setNegativeButton(DIALOG_NEG_TEXT, new DialogInterface.OnClickListener() { // from class: com.baidu.mobads.container.util.CommonUtils.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DialogOperation.this.onClickButton(false);
            }
        }).setCancelable(false).create();
        builder.show();
    }

    public static int sp2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
