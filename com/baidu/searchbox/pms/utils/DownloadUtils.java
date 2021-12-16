package com.baidu.searchbox.pms.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.statistic.PackageFileStatisticManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.apache.commons.codec.digest4util.MD5Utils;
/* loaded from: classes10.dex */
public class DownloadUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PMS_DIR = "pms";
    public transient /* synthetic */ FieldHolder $fh;

    public DownloadUtils() {
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

    public static boolean copyTo(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            File file = new File(str);
            File file2 = new File(str2);
            return (!file2.exists() || file2.delete()) && makeDirs(file2.getParentFile()) && FileUtils.copyFile(file, file2) > 0;
        }
        return invokeLL.booleanValue;
    }

    public static String createFileLayer(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            if (file == null) {
                return "root_exist=bad_path";
            }
            boolean exists = file.exists();
            String str = "not_exist=" + file.getAbsolutePath() + ",";
            while (!exists) {
                file = file.getParentFile();
                if (file == null) {
                    return str + "root_exist=bad_path";
                }
                exists = file.exists();
                if (exists) {
                    return str + "root_exist=" + file.getAbsolutePath();
                }
                str = str + "not_exist=" + file.getAbsolutePath() + ",";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String createFileName(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, packageInfo)) == null) {
            String key = packageInfo.getKey();
            if (TextUtils.isEmpty(key)) {
                DebugUtils.throwExceptionForDebug("key is empty");
                return "";
            }
            return key.replace(File.separator, "");
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
        if (makeDirs(r0) != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File getOutputDir(String str) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                file = new File(str);
            }
            file = null;
            return file == null ? getPmsFileDir() : file;
        }
        return (File) invokeL.objValue;
    }

    public static String getOutputFile(PackageInfo packageInfo, String str) {
        InterceptResult invokeLL;
        File outputDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, packageInfo, str)) == null) {
            if (packageInfo == null || (outputDir = getOutputDir(str)) == null) {
                return null;
            }
            return CommonUtils.mergePath(outputDir.getAbsolutePath(), createFileName(packageInfo));
        }
        return (String) invokeLL.objValue;
    }

    public static File getPmsFileDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), PMS_DIR);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static boolean isSameMD5(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return isSameMD5(new File(str), str2);
        }
        return invokeLL.booleanValue;
    }

    public static boolean makeDirs(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, file)) == null) {
            if (file == null) {
                return false;
            }
            if (file.exists()) {
                return file.isDirectory();
            }
            return file.mkdirs();
        }
        return invokeL.booleanValue;
    }

    public static ErrorInfo ubcFileExist(PackageInfo packageInfo) {
        InterceptResult invokeL;
        String str;
        ErrorInfo errorInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, packageInfo)) == null) {
            File file = new File(packageInfo.filePath);
            if (file.exists()) {
                errorInfo = null;
                str = String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_EXIST, packageInfo.toString());
                i2 = ErrorConstant.Code.DOWNLOAD_FILE_EXIST;
            } else {
                String format = String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, packageInfo.toString());
                String createFileLayer = createFileLayer(file);
                ErrorInfo errorInfo2 = new ErrorInfo();
                errorInfo2.code = ErrorConstant.Code.DOWNLOAD_ERROR_WRITE;
                errorInfo2.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE + CommonUtils.createErrorJson("exception", format, "file_layer", createFileLayer);
                errorInfo2.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_ERROR_WRITE;
                str = format;
                errorInfo = errorInfo2;
                i2 = ErrorConstant.Code.DOWNLOAD_FILE_INEXIST;
            }
            PackageFileStatisticManager.getInstance().addDownloadStatistic2(i2, str, packageInfo.channelId, packageInfo.packageName, packageInfo.version, packageInfo.downloadUrl, "", 0, packageInfo.retryCount);
            return errorInfo;
        }
        return (ErrorInfo) invokeL.objValue;
    }

    public static boolean isSameMD5(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, file, str)) == null) {
            if (file != null && file.exists()) {
                String md5 = MD5Utils.toMd5(file, true);
                if (str != null && md5 != null) {
                    return str.toUpperCase().equals(md5);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
