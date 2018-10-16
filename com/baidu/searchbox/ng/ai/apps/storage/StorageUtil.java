package com.baidu.searchbox.ng.ai.apps.storage;

import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import java.io.File;
/* loaded from: classes2.dex */
public final class StorageUtil {
    public static String AIAPP_EXTERNAL_PATH = "/aiapp";
    public static final String BD_FILE_PREFEX = "bdfile://";
    public static final String BD_FILE_STORE_DIR = "/store";
    public static final String BD_FILE_TMP_DIR = "/tmp";
    public static final boolean DEBUG = false;
    private static final String HTTPS_PREFIX = "https://";
    private static final String HTTP_PREFIX = "http://";
    public static final int KILO = 1024;
    public static final int MEGA = 1048576;
    private static final String PREFIX = "aiapp_";
    public static final String REPLACEMENT = "";
    public static final String STORE_FILE_PREFEX = "store_";
    public static final String TAG = "StorageUtil";
    public static final String TMP_FILE_PREFEX = "tmp_";

    private StorageUtil() {
    }

    @Nullable
    public static String scheme2Path(String str, String str2) {
        Uri parse;
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        String host = parse.getHost();
        if (TextUtils.isEmpty(host)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (host.startsWith(TMP_FILE_PREFEX)) {
            str3 = host.replace(TMP_FILE_PREFEX, "");
            stringBuffer.append(getAiappTmpDirectory(str2));
        } else if (host.startsWith(STORE_FILE_PREFEX)) {
            str3 = host.replace(STORE_FILE_PREFEX, "");
            stringBuffer.append(getAiappStoreDirectory(str2));
        } else {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            stringBuffer.append(new String(Base64.decode(str3, 10)));
            return stringBuffer.toString();
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static boolean isLocalFileScheme(String str) {
        PathType pathType = getPathType(str);
        return pathType == PathType.BD_FILE || pathType == PathType.RELATIVE;
    }

    public static String obtainPathFromScheme(String str, @NonNull AiApp aiApp) {
        String relativeToPath;
        switch (getPathType(str)) {
            case BD_FILE:
                relativeToPath = scheme2Path(str, aiApp.id);
                break;
            case RELATIVE:
                relativeToPath = relativeToPath(str, aiApp, aiApp.getVersion());
                break;
            default:
                relativeToPath = str;
                break;
        }
        return relativeToPath == null ? str : relativeToPath;
    }

    @Nullable
    public static String path2Scheme(String str, String str2) {
        String replace;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String aiappStoreDirectory = getAiappStoreDirectory(str2);
        String aiappTmpDirectory = getAiappTmpDirectory(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(BD_FILE_PREFEX);
        if (!TextUtils.isEmpty(aiappTmpDirectory) && str.startsWith(aiappTmpDirectory)) {
            replace = str.replace(aiappTmpDirectory, "");
            stringBuffer.append(TMP_FILE_PREFEX);
        } else if (TextUtils.isEmpty(aiappStoreDirectory) || !str.startsWith(aiappStoreDirectory)) {
            return null;
        } else {
            replace = str.replace(aiappStoreDirectory, "");
            stringBuffer.append(STORE_FILE_PREFEX);
        }
        if (TextUtils.isEmpty(replace)) {
            return null;
        }
        stringBuffer.append(new String(Base64.encode(replace.getBytes(), 10)));
        return stringBuffer.toString();
    }

    public static String getAiappStoreRoot() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return AppRuntime.getAppContext().getExternalFilesDir(null) + AIAPP_EXTERNAL_PATH;
        }
        return null;
    }

    public static String getAiappStoreDirectory(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + AIAPP_EXTERNAL_PATH + BD_FILE_STORE_DIR + File.separator + PREFIX + str;
        createFolder(str2);
        return str2;
    }

    public static String getAiappTmpRoot() {
        return AppRuntime.getAppContext().getExternalCacheDir() + AIAPP_EXTERNAL_PATH;
    }

    public static String getAiappTmpDirectory(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + AIAPP_EXTERNAL_PATH + BD_FILE_TMP_DIR + File.separator + PREFIX + str;
        createFolder(str2);
        return str2;
    }

    public static String createTmpFile(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return getAiappTmpDirectory(str) + File.separator + str2 + ("." + str3);
        }
        return getAiappTmpDirectory(str) + File.separator + str2;
    }

    public static String relativeToPath(String str, AiApp aiApp, String str2) {
        if (aiApp == null) {
            return null;
        }
        AiAppsLaunchInfo launchInfo = aiApp.getLaunchInfo();
        if (launchInfo == null || launchInfo.mIsDebug) {
        }
        if (TextUtils.isEmpty(aiApp.id) || TextUtils.isEmpty(str2) || getPathType(str) != PathType.RELATIVE) {
            return null;
        }
        File unzipFolder = AiAppsBundleHelper.ReleaseBundleHelper.getUnzipFolder(aiApp.id, str2);
        if (unzipFolder.exists()) {
            if (str.startsWith("/")) {
                return unzipFolder.getAbsolutePath() + str;
            }
            return unzipFolder.getAbsolutePath() + File.separator + str;
        }
        return null;
    }

    public static PathType getPathType(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (str.startsWith(BD_FILE_PREFEX)) {
            return PathType.BD_FILE;
        }
        if (str.startsWith(HTTP_PREFIX) || str.startsWith("https://")) {
            return PathType.NETWORK;
        }
        return PathType.RELATIVE;
    }

    private static boolean createFolder(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }
}
