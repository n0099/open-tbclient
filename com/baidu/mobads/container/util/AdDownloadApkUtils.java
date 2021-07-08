package com.baidu.mobads.container.util;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.controller.InstallReceiver;
import com.baidu.mobads.container.components.monitor.RemoteInstallApkTask;
import com.baidu.mobads.container.components.monitor.RemoteScheduledMonitor;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdDownloadApkUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DL_STATUS_DONE = "DONE";
    public static final String DL_STATUS_DOWNLOADED = "DOWNLOADED";
    public static final String DL_STATUS_DOWNLOADING = "DOWNLOADING";
    public static final String DL_STATUS_DOWNLOAD_FAILED = "DOWNLOAD_FAILED";
    public static final String DL_STATUS_INSTALLED = "INSTALLED";
    public static final String DL_STATUS_INSTALLED_BY_OTHER = "INSTALLED_BY_OTHER";
    public static final String DL_STATUS_NONE = "NONE";
    public static final String PKGS_PREF_ACTIVATION = "__sdk_pasys_pkgs_2";
    public static final String PKGS_PREF_DOWNLOAD = "__sdk_remote_dl_2";
    public static final String PKGS_PREF_DOWNLOAD_STATUS = "dl";
    public static final int PREF_DOWNLOADED = 3;
    public static final int PREF_DOWNLOADED_DELETE = 5;
    public static final int PREF_DOWNLOAD_UNKNOWN = -1;
    public static final int PREF_DOWNOADING = 1;
    public static final int PREF_DOWNOAD_CANCELED = 2;
    public static final int PREF_DOWNOAD_FAILED = 4;
    public static final int PREF_LAUNCH_APP = 100;
    public static final int PREF_NOT_DOWNLOAD = 0;
    public static final String TAG = "AdDownloadApkUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public AdDownloadApkUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bd, code lost:
        if (java.lang.Math.abs(r9 - r3.length()) >= 2) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getApkDownloadStatus(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, str2)) == null) {
            SPUtils sPUtils = new SPUtils(context, PKGS_PREF_ACTIVATION);
            int i2 = -1;
            if (str != null && !"".equals(str)) {
                boolean z = false;
                try {
                    JSONObject optJSONObject = new JSONObject(sPUtils.getString("pkgs", StringUtil.EMPTY_ARRAY)).optJSONObject(str);
                    if (optJSONObject != null) {
                        if (optJSONObject.optBoolean("a", false)) {
                            return 100;
                        }
                    }
                } catch (Exception e2) {
                    Log.e(TAG, e2.getMessage());
                }
                try {
                    SPUtils sPUtils2 = new SPUtils(context, PKGS_PREF_DOWNLOAD);
                    JSONObject jSONObject = new JSONObject(sPUtils2.getString(str + XAdRemoteAPKDownloadExtraInfo.KEY_SPLIT + XAdRemoteAPKDownloadExtraInfo.getCurrentProcName(), StringUtil.EMPTY_ARRAY));
                    int optInt = jSONObject.optInt("dl", -1);
                    try {
                        String optString = jSONObject.optString("filename", null);
                        if (optString != null) {
                            File file = new File(SdcardUtils.getStoragePathForDlApk(context) + optString);
                            if (optInt == 3) {
                                if (file.exists() && file.length() != 0) {
                                    long optLong = jSONObject.optLong(XAdRemoteAPKDownloadExtraInfo.CONTENT_LENGTH, -1L);
                                    if (optLong != -1) {
                                    }
                                    if (z) {
                                        optInt = 5;
                                        try {
                                            jSONObject.put("dl", 5);
                                            sPUtils2.putString(str, jSONObject.toString());
                                        } catch (Exception e3) {
                                            e = e3;
                                            i2 = 5;
                                            Log.e(TAG, e.getMessage());
                                            return i2;
                                        }
                                    }
                                }
                                z = true;
                                if (z) {
                                }
                            }
                        }
                        return optInt;
                    } catch (Exception e4) {
                        e = e4;
                        i2 = optInt;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            }
            return i2;
        }
        return invokeLLL.intValue;
    }

    public static String getApkFileLocalPath(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(PKGS_PREF_DOWNLOAD, 0);
                String string = sharedPreferences.getString(str + XAdRemoteAPKDownloadExtraInfo.KEY_SPLIT + XAdRemoteAPKDownloadExtraInfo.getCurrentProcName(), "");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    String optString = jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.FOLDER);
                    String optString2 = jSONObject.optString("filename");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        return optString + optString2;
                    }
                }
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2);
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String getStatusStr(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            String str4 = "NONE";
            try {
                int apkDownloadStatus = getApkDownloadStatus(context, str, str2);
                boolean isInstalled = isInstalled(context, str);
                if (apkDownloadStatus == 0 || apkDownloadStatus == 1) {
                    if (isInstalled) {
                        return DL_STATUS_INSTALLED_BY_OTHER;
                    }
                    str3 = DL_STATUS_DOWNLOADING;
                    return str3;
                }
                if (apkDownloadStatus != 2) {
                    if (apkDownloadStatus == 3) {
                        str3 = isInstalled ? DL_STATUS_INSTALLED : DL_STATUS_DOWNLOADED;
                        return str3;
                    } else if (apkDownloadStatus != 4) {
                        if (apkDownloadStatus != 5) {
                            if (apkDownloadStatus == 100) {
                                return DL_STATUS_DONE;
                            }
                            if (isInstalled) {
                                str4 = DL_STATUS_INSTALLED_BY_OTHER;
                            }
                        } else if (isInstalled) {
                            str4 = DL_STATUS_DONE;
                        }
                        return str4;
                    }
                }
                if (!isInstalled) {
                    str3 = DL_STATUS_DOWNLOAD_FAILED;
                    return str3;
                }
                return DL_STATUS_INSTALLED_BY_OTHER;
            } catch (Exception unused) {
                return "NONE";
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static Uri getUriForFileByProvider(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, file)) == null) {
            try {
                return AppUtils.getUriForFile(context, context.getPackageName() + ".bd.provider", file);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Uri) invokeLL.objValue;
    }

    public static void installApkWithLog(Context context, File file, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, file, xAdRemoteAPKDownloadExtraInfo) == null) {
            try {
                AppUtils.installApp(context, file);
                RemoteScheduledMonitor remoteScheduledMonitor = RemoteScheduledMonitor.getInstance();
                remoteScheduledMonitor.addTask(new RemoteInstallApkTask(context, xAdRemoteAPKDownloadExtraInfo));
                remoteScheduledMonitor.startMonitor();
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().i(th);
            }
        }
    }

    public static void installApp(Context context, String str, File file, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, str, file, Boolean.valueOf(z)}) == null) {
            try {
                AppUtils.installApp(context, file);
                if (!z || str == null || str == null || str.equals("")) {
                    return;
                }
                XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo = new XAdRemoteAPKDownloadExtraInfo(str, "");
                xAdRemoteAPKDownloadExtraInfo.autoOpen = true;
                InstallReceiver installReceiver = new InstallReceiver(xAdRemoteAPKDownloadExtraInfo);
                IntentFilter intentFilter = new IntentFilter(PackageChangedReceiver.ACTION_INSTALL);
                intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
                context.registerReceiver(installReceiver, intentFilter);
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2);
            }
        }
    }

    public static boolean isInstalled(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
                if (applicationInfo != null) {
                    return str.equals(applicationInfo.packageName);
                }
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean needProviderForDl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? Build.VERSION.SDK_INT >= 24 && AppUtils.getTargetSdkVersion(context) >= 24 : invokeL.booleanValue;
    }

    public static boolean supportDl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context == null) {
                return false;
            }
            if (needProviderForDl(context) && !supportInstallApkFromPublicSdPath(context)) {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    if (supportInstallApk(context, SdcardUtils.getApkDlPath(externalFilesDir.getPath()))) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean supportInstallApk(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            if (needProviderForDl(context)) {
                try {
                    File file = new File(str + "t");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    return getUriForFileByProvider(context, file) != null;
                } catch (Exception e2) {
                    RemoteXAdLogger.getInstance().e(e2);
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean supportInstallApkFromPublicSdPath(Context context) {
        InterceptResult invokeL;
        File externalStorageDirectory;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? Build.VERSION.SDK_INT <= 28 && PermissionUtils.checkPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) && PermissionUtils.hasPermission("permission_storage") && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && supportInstallApk(context, SdcardUtils.getApkDlPath(externalStorageDirectory.getPath())) : invokeL.booleanValue;
    }
}
