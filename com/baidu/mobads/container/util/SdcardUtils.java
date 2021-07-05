package com.baidu.mobads.container.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class SdcardUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CACHE_PATH = "/bddownload/";
    public static final String DEFAULT_SD_CARD_PATH = "/mnt/sdcard";
    public static final String KEY_SYS_MEM = "sysMem";
    public static final String KEY_SYS_SDC = "sysSdc";
    public transient /* synthetic */ FieldHolder $fh;

    public SdcardUtils() {
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

    public static boolean canSupportSdcardStroage(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT <= 28 && !PermissionUtils.checkPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                    if (isUseOldStoragePath()) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static long getAllExternalMemorySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    return getAllMemorySize(Environment.getExternalStorageDirectory());
                }
                return -1L;
            } catch (Exception unused) {
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public static long getAllInternalMemorySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                return getAllMemorySize(Environment.getDataDirectory());
            } catch (Exception unused) {
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    @TargetApi(18)
    public static long getAllMemorySize(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, file)) == null) {
            try {
                StatFs statFs = new StatFs(file.getPath());
                return ((statFs.getBlockCount() * statFs.getBlockSize()) / 1024) / 1024;
            } catch (Exception unused) {
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static String getApkDlPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            return str + DEFAULT_CACHE_PATH;
        }
        return (String) invokeL.objValue;
    }

    public static String getAppSDC(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            String str = "";
            SPUtils sPUtils = new SPUtils(context);
            try {
                String string = sPUtils.getString(KEY_SYS_SDC, "");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e(e2);
            }
            if (Environment.getExternalStorageState().equals("mounted")) {
                try {
                    str = getAvailableExternalMemorySize() + "," + getAllExternalMemorySize();
                    sPUtils.putString(KEY_SYS_SDC, str);
                    return str;
                } catch (Exception unused) {
                    return str;
                }
            }
            return "0,0";
        }
        return (String) invokeL.objValue;
    }

    public static long getAvailableExternalMemorySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    return getAvailableMemorySize(Environment.getExternalStorageDirectory());
                }
                return -1L;
            } catch (Exception unused) {
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public static long getAvailableInternalMemorySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                return getAvailableMemorySize(Environment.getDataDirectory());
            } catch (Exception unused) {
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    @TargetApi(18)
    public static long getAvailableMemorySize(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, file)) == null) {
            try {
                StatFs statFs = new StatFs(file.getPath());
                return ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024) / 1024;
            } catch (Exception unused) {
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static File getExternalFilesDirByStatic(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    return context.getExternalFilesDir(null);
                }
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    if (PermissionUtils.checkPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) && PermissionUtils.hasPermission("permission_storage")) {
                        return getExternalStorageDirectory();
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        return context.getExternalFilesDir(null);
                    }
                    return context.getFilesDir();
                }
                return context.getFilesDir();
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e("TAG", e2.getMessage());
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public static File getExternalStorageDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? Environment.getExternalStorageDirectory() : (File) invokeV.objValue;
    }

    public static String getMem(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            String str = "";
            SPUtils sPUtils = new SPUtils(context);
            try {
                String string = sPUtils.getString(KEY_SYS_MEM, "");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e(e2);
            }
            try {
                str = getAvailableInternalMemorySize() + "," + getAllInternalMemorySize();
                sPUtils.putString(KEY_SYS_MEM, str);
                return str;
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getStoragePath(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) ? getStoragePath(context, DEFAULT_SD_CARD_PATH) : (String) invokeL.objValue;
    }

    public static String getStoragePathForDlApk(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            try {
                if (!AppUtils.needProviderForDl(context)) {
                    return getStoragePath(context, DEFAULT_SD_CARD_PATH);
                }
                if (AppUtils.supportInstallApkFromPublicSdPath(context)) {
                    return getStoragePath(context, DEFAULT_SD_CARD_PATH);
                }
                return getApkDlPath(context.getExternalFilesDir(null).getPath());
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean isUseOldStoragePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? Build.VERSION.SDK_INT < 23 : invokeV.booleanValue;
    }

    public static String getStoragePath(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) {
            try {
                return getApkDlPath(getExternalFilesDirByStatic(context).getPath());
            } catch (Throwable unused) {
                return getApkDlPath(str);
            }
        }
        return (String) invokeLL.objValue;
    }
}
