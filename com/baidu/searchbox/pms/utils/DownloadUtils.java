package com.baidu.searchbox.pms.utils;

import android.text.TextUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.statistic.PackageFileStatisticManager;
import java.io.File;
import org.apache.commons.codec.digest4util.MD5Utils;
/* loaded from: classes2.dex */
public class DownloadUtils {
    public static final String PMS_DIR = "pms";

    public static boolean copyTo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str);
        File file2 = new File(str2);
        return (!file2.exists() || file2.delete()) && makeDirs(file2.getParentFile()) && FileUtils.copyFile(file, file2) > 0;
    }

    public static String createFileLayer(File file) {
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

    public static String createFileName(PackageInfo packageInfo) {
        String key = packageInfo.getKey();
        if (TextUtils.isEmpty(key)) {
            DebugUtils.throwExceptionForDebug("key is empty");
            return "";
        }
        return key.replace(File.separator, "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
        if (makeDirs(r0) != false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File getOutputDir(String str) {
        File file;
        if (!TextUtils.isEmpty(str)) {
            file = new File(str);
        }
        file = null;
        return file == null ? getPmsFileDir() : file;
    }

    public static String getOutputFile(PackageInfo packageInfo, String str) {
        File outputDir;
        if (packageInfo == null || (outputDir = getOutputDir(str)) == null) {
            return null;
        }
        return CommonUtils.mergePath(outputDir.getAbsolutePath(), createFileName(packageInfo));
    }

    public static File getPmsFileDir() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), PMS_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean isSameMD5(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return isSameMD5(new File(str), str2);
    }

    public static boolean makeDirs(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isDirectory();
        }
        return file.mkdirs();
    }

    public static ErrorInfo ubcFileExist(PackageInfo packageInfo) {
        String str;
        ErrorInfo errorInfo;
        int i;
        File file = new File(packageInfo.filePath);
        if (file.exists()) {
            errorInfo = null;
            str = String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_EXIST, packageInfo.toString());
            i = ErrorConstant.Code.DOWNLOAD_FILE_EXIST;
        } else {
            String format = String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, packageInfo.toString());
            String createFileLayer = createFileLayer(file);
            ErrorInfo errorInfo2 = new ErrorInfo();
            errorInfo2.code = ErrorConstant.Code.DOWNLOAD_ERROR_WRITE;
            errorInfo2.errorMsg = ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE + CommonUtils.createErrorJson("exception", format, "file_layer", createFileLayer);
            errorInfo2.tipMsg = ErrorConstant.TipMsg.DOWNLOAD_ERROR_WRITE;
            str = format;
            errorInfo = errorInfo2;
            i = ErrorConstant.Code.DOWNLOAD_FILE_INEXIST;
        }
        PackageFileStatisticManager.getInstance().addDownloadStatistic2(i, str, packageInfo.channelId, packageInfo.packageName, packageInfo.version, packageInfo.downloadUrl, "", 0, packageInfo.retryCount);
        return errorInfo;
    }

    public static boolean isSameMD5(File file, String str) {
        if (file != null && file.exists()) {
            String md5 = MD5Utils.toMd5(file, true);
            if (str != null && md5 != null) {
                return str.toUpperCase().equals(md5);
            }
        }
        return false;
    }
}
