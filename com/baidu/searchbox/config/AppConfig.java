package com.baidu.searchbox.config;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.aop.annotation.TimeSpendTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class AppConfig {
    private static final String CONFIG_FILE = "searchbox_config.ini";
    private static final String DAILY_CONFIG_FILE = "daily_searchbox_config.ini";
    private static final long TIMESTAMP_AVAILABLE_DURATION = 120000;
    private static final String TIMESTAMP_FILE = ".config.lock";
    static final String UBC_DEBUG_HOST = "UBC_DEBUG_HOST";
    static final String UBC_DEBUG_URL = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc";
    private static final int VOICE_ID = 790;
    private static final String WEEKLY_CONFIG_FILE = "weekly_searchbox_config.ini";
    private static HashMap<String, String> sConfigMap;
    private static String sFileContent;
    private static String sInternalFileContent;
    public static boolean sNeedSkipAndRemoveExternalConfig;
    private File mConfigFile;
    private File mTimestampFile;
    private static boolean sIsDaily = false;
    private static boolean sIsWeekly = false;
    private static boolean sDebug = false;
    private static boolean sIsBeta = false;
    public static boolean useQADefaultDings = false;
    public static boolean userProfileForbidFlag = false;

    /* loaded from: classes11.dex */
    public interface ConfigValueFilter {
        boolean isIllegalContent(String str);
    }

    @DebugTrace
    @TimeSpendTrace(tag = "AppInit")
    public static void init(boolean z, boolean z2, boolean z3, boolean z4) {
        sIsDaily = z;
        sIsWeekly = z2;
        sDebug = z3;
        sIsBeta = z4;
    }

    public static boolean isDebugBuild() {
        return false;
    }

    /* loaded from: classes11.dex */
    public static class AppInfo {
        private static final String DEFAULT_PACKAGE_NAME = "com.baidu.searchbox";
        private static final String PREVIEW_PACKAGE_NAME = "com.baidu.searchbox.preview";
        private static final String SMART_PACKAGE_NAME = "com.baidu.searchbox.unknown";
        private static final String TAG = "AppInfo";
        private static final String WEEKLY_PACKAGE_NAME = "com.baidu.searchbox.weekly";
        private static String sBoxVersionCode;
        private static String sBoxVersionName;
        private static String sPackageName;

        public static String getPackageName() {
            if (TextUtils.isEmpty(sPackageName)) {
                sPackageName = AppRuntime.getAppContext().getPackageName();
            }
            return sPackageName;
        }

        public static String getVersionCode() {
            if (TextUtils.isEmpty(sBoxVersionCode)) {
                try {
                    Context appContext = AppRuntime.getAppContext();
                    sBoxVersionCode = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionCode + "";
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return sBoxVersionCode;
        }

        public static String getVersionName() {
            if (TextUtils.isEmpty(sBoxVersionName)) {
                try {
                    Context appContext = AppRuntime.getAppContext();
                    sBoxVersionName = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName + "";
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return sBoxVersionName;
        }

        public static boolean isDaily() {
            return AppConfig.sIsDaily;
        }

        public static boolean isWeekly() {
            return TextUtils.equals(getPackageName(), WEEKLY_PACKAGE_NAME);
        }

        public static boolean isPreview() {
            return TextUtils.equals(getPackageName(), PREVIEW_PACKAGE_NAME);
        }

        public static boolean isSmartPreview() {
            return TextUtils.equals(getPackageName(), SMART_PACKAGE_NAME);
        }

        public static boolean isModifyPkg() {
            return !TextUtils.equals(getPackageName(), "com.baidu.searchbox");
        }

        public static String dumpAppInfo() {
            String str = "AppInfo: " + getPackageName() + "|" + getVersionName() + "|" + getVersionCode() + "|isDaily=" + isDaily() + "|isWeekly=" + isWeekly() + "|isPreview=" + isPreview() + "|isDebug=" + AppConfig.isDebug();
            if (AppConfig.isDebug()) {
                Log.d(TAG, str);
            }
            return str;
        }
    }

    public static final String getStringConfig(String str, String str2) {
        String str3;
        HashMap<String, String> hashMap = sConfigMap;
        return (hashMap == null || (str3 = hashMap.get(str)) == null) ? str2 : str3;
    }

    public static final boolean getBooleanConfig(String str, boolean z) {
        String str2;
        HashMap<String, String> hashMap = sConfigMap;
        if (hashMap != null && (str2 = hashMap.get(str)) != null) {
            return Boolean.parseBoolean(str2);
        }
        return z;
    }

    public static final int getIntConfig(String str, int i) {
        String str2;
        HashMap<String, String> hashMap = sConfigMap;
        if (hashMap != null && (str2 = hashMap.get(str)) != null) {
            return Integer.parseInt(str2);
        }
        return i;
    }

    /* loaded from: classes11.dex */
    public static class HTTPSConfig {
        private static final long TMP_USE_HTTP_DELTA = 518400000;

        public static boolean isTmpUseHttp() {
            QuickPersistConfig quickPersistConfig = QuickPersistConfig.getInstance();
            if (quickPersistConfig.getInt(QuickPersistConfigConst.KEY_TMP_USE_HTTP, 0) == 0) {
                return false;
            }
            return Math.abs(System.currentTimeMillis() - quickPersistConfig.getLong(QuickPersistConfigConst.KEY_LAST_TMP_USE_HTTP_TS, 0L)) < TMP_USE_HTTP_DELTA;
        }

        public static void setTmpUseHttp() {
            QuickPersistConfig quickPersistConfig = QuickPersistConfig.getInstance();
            quickPersistConfig.putInt(QuickPersistConfigConst.KEY_TMP_USE_HTTP, 1);
            quickPersistConfig.putLong(QuickPersistConfigConst.KEY_LAST_TMP_USE_HTTP_TS, System.currentTimeMillis());
        }
    }

    public static String getActiveDuration() {
        return "2分钟";
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0071 A[Catch: Exception -> 0x0075, TRY_LEAVE, TryCatch #6 {Exception -> 0x0075, blocks: (B:29:0x006c, B:31:0x0071), top: B:51:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void activeConfigFile(Context context) {
        File file;
        DataOutputStream dataOutputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (!sDebug && context != null && (file = new File(context.getFilesDir(), TIMESTAMP_FILE)) != null) {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    dataOutputStream = new DataOutputStream(fileOutputStream);
                } catch (Exception e) {
                    e = e;
                    dataOutputStream = null;
                    fileOutputStream2 = fileOutputStream;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = null;
                }
            } catch (Exception e2) {
                e = e2;
                dataOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
                fileOutputStream = null;
            }
            try {
                dataOutputStream.writeLong(System.currentTimeMillis());
                dataOutputStream.flush();
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (Exception e3) {
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                try {
                    e.printStackTrace();
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    Toast.makeText(context, "配置文件有效时间：" + getActiveDuration(), 0).show();
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e6) {
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (dataOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
            Toast.makeText(context, "配置文件有效时间：" + getActiveDuration(), 0).show();
        }
    }

    public static boolean getLoadInMainBrowser() {
        return getBooleanConfig("LOAD_IN_MAIN_BROWSER", false);
    }

    public static boolean getForbidConfigFileWarning() {
        return getBooleanConfig("FORBID_CONFIG_FILE_WARNING", false);
    }

    public static boolean getSilentWebkit() {
        return getBooleanConfig("SILENT_WEBKIT", true);
    }

    public static boolean getSilentVideo() {
        return getBooleanConfig("SILENT_VIDEO", true);
    }

    public static int getVoicePid() {
        return getIntConfig("VOICE_PID", VOICE_ID);
    }

    public static String getNetTestServer() {
        return "http://112.34.113.161/checkupdate";
    }

    public static String getQAWebSearchUrl() {
        String stringConfig = getStringConfig("WEB_SEARCH_URL", null);
        if (stringConfig == null) {
            String stringConfig2 = getStringConfig("ANTIHIJACK_WEBSEARCH_URL", null);
            if (stringConfig2 != null) {
                return stringConfig2;
            }
            return null;
        }
        return stringConfig + "/s?tn=zbios&pu=sz%401320_480&bd_page_type=1&word=";
    }

    public static String getCookieHost() {
        return getStringConfig("COOKIE_URL", ".baidu.com");
    }

    public static String getConfigUrl() {
        return getStringConfig("CONFIG_URL", String.format("%s/static/searchbox/android/appconfig.html", DownloadConstants.REFER));
    }

    public static String getXDataUrl() {
        return getStringConfig("XSEARCH_DATA_URL", "http://m.baidu.com/microapp");
    }

    /* loaded from: classes11.dex */
    public static class Speed {
        public static boolean getSpeedEnable() {
            return AppConfig.getBooleanConfig("SPEED_MONITOR", false);
        }

        public static String getSpeedMonitorUpload() {
            return AppConfig.getStringConfig("SPEED_MONITOR_UPLOAD", "");
        }
    }

    public static boolean getImageSearchGuideConfiged() {
        return getStringConfig("IMAGE_SEARCH_GUIDE_HOST", null) != null;
    }

    public static boolean getImageSearchHostConfiged() {
        return getStringConfig("IMAGE_SEARCH_URL", null) != null;
    }

    public static boolean getUseAutoFocus() {
        return getBooleanConfig("USE_AUTO_FOCUS", true);
    }

    public static String getConfigFileContent() {
        return sFileContent;
    }

    public static String getInternalConfigContent() {
        return sInternalFileContent;
    }

    public static String getWeeklyUpdateUrl() {
        return "http://shoubai.m.baidu.com/weeklyupdate/index.php?type=update";
    }

    public static String getPreviewUpdateUrl() {
        return getWeeklyUpdateUrl();
    }

    public static String getDailyUpdateUrl() {
        return getWeeklyUpdateUrl();
    }

    public static String getCommunityPreConnectImageUrl() {
        return HostConfig.isSearchboxUseHttps() ? "https://timgmb.bdimg.com/timg" : "http://timgmb.bdimg.com/timg";
    }

    public static boolean getGrabServerCommandSwitch() {
        return getBooleanConfig("GRAB_SERVER_COMMAND", true);
    }

    public static boolean getUserProfileForbidden() {
        return getBooleanConfig("USER_PROFILE_FORBIDDEN_CONFIG", false);
    }

    public static int getNetTrafficUploadNumLimit() {
        return getIntConfig("NETTRAFFIC_UPLOAD_NUM_LIMIT", 0);
    }

    public static void parseConfig(ConfigValueFilter configValueFilter) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (!parseExternalConfig(hashMap, configValueFilter) || !sIsDaily) {
            parseInternalConfig(hashMap, configValueFilter);
        }
        if (hashMap.size() > 0) {
            sConfigMap = hashMap;
        }
    }

    public static String getExternalConfigFileName() {
        return CONFIG_FILE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [631=4] */
    private static void parseInternalConfig(HashMap<String, String> hashMap, ConfigValueFilter configValueFilter) {
        InputStream inputStream;
        Throwable th;
        AssetManager assets = AppRuntime.getAppContext().getResources().getAssets();
        InputStream inputStream2 = null;
        try {
            try {
                inputStream2 = sIsDaily ? assets.open(DAILY_CONFIG_FILE) : sIsWeekly ? assets.open(WEEKLY_CONFIG_FILE) : assets.open(CONFIG_FILE);
                try {
                    parseStream(inputStream2, hashMap, configValueFilter, true);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (Throwable th2) {
                    inputStream = inputStream2;
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e4) {
                    }
                }
            }
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [654=4] */
    private static boolean parseExternalConfig(HashMap<String, String> hashMap, ConfigValueFilter configValueFilter) {
        FileInputStream fileInputStream;
        boolean z = false;
        File file = new File(AppRuntime.getAppContext().getFilesDir().getPath(), CONFIG_FILE);
        if (file.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    parseStream(fileInputStream, hashMap, configValueFilter, false);
                    z = true;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    return z;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z;
    }

    private static void parseStream(InputStream inputStream, Map<String, String> map, ConfigValueFilter configValueFilter, boolean z) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String substring = readLine.substring(0, readLine.indexOf(ETAG.EQUAL));
                String substring2 = readLine.substring(readLine.indexOf(ETAG.EQUAL) + 1);
                if (ConfigWhiteList.isInWhiteList(substring) || configValueFilter == null || !configValueFilter.isIllegalContent(substring2)) {
                    map.put(substring, substring2);
                    sb.append(readLine);
                }
            }
            if (z) {
                sInternalFileContent = sb.toString();
            } else {
                sFileContent = sb.toString();
            }
        } catch (IOException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class ConfigWhiteList {
        static final String[] WHITE_LIST = {"GRAB_SERVER_COMMAND", "XSEARCH_FORCE_HTML5", "DREAM_QR_PAGEID", "USER_PROTOCOL_SWITCH", "SILENT_WEBKIT", "SILENT_VIDEO", "FORBID_CONFIG_FILE_WARNING", "ANTIHIJACK_WEBSEARCH_URL", "ANTIHIJACK_UPLOAD_URL", "USE_AUTO_FOCUS", "VOICE_PID", "IMG_SEARCH_URL", "LOAD_IN_MAIN_BROWSER", "DOWNLOAD_DEST_MODE", "DOWNLOAD_DEST_DIR", "USER_PROFILE_FORBIDDEN_CONFIG", "NETTRAFFIC_UPLOAD_NUM_LIMIT", "SPEED_MONITOR", "SPEED_MONITOR_UPLOAD"};

        ConfigWhiteList() {
        }

        public static boolean isInWhiteList(String str) {
            int length = WHITE_LIST.length;
            for (int i = 0; i < length; i++) {
                if (TextUtils.equals(WHITE_LIST[i], str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static boolean isBeta() {
        return sIsBeta;
    }

    /* loaded from: classes11.dex */
    public static class Downloads {
        public static String getDestinationMode() {
            return AppConfig.getStringConfig("DOWNLOAD_DEST_MODE", null);
        }

        public static String getDestinationDir() {
            return AppConfig.getStringConfig("DOWNLOAD_DEST_DIR", "");
        }
    }

    public static String getFollowAllUrl() {
        return String.format("%s/api/subscribe/v1/relation/receive_all", HostConfig.getExtHostForHttps());
    }

    public static String getUbcTestUrl() {
        return getStringConfig(UBC_DEBUG_HOST, UBC_DEBUG_URL);
    }

    /* loaded from: classes11.dex */
    public static class Debug {
        public static String getJacocoUploadUrl() {
            return AppConfig.getStringConfig("JACOCO_UPLOAD_URL", "http://cp01-searchbbox-andriod-cqa01.epc.baidu.com:8666/Coverage/fileUploadAPI/fileManager.php");
        }
    }
}
