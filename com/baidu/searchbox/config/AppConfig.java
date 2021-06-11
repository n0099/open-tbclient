package com.baidu.searchbox.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.wallet.core.Domains;
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
/* loaded from: classes2.dex */
public class AppConfig {
    public static final String CONFIG_FILE = "searchbox_config.ini";
    public static final String DAILY_CONFIG_FILE = "daily_searchbox_config.ini";
    public static final long TIMESTAMP_AVAILABLE_DURATION = 120000;
    public static final String TIMESTAMP_FILE = ".config.lock";
    public static final String UBC_DEBUG_HOST = "UBC_DEBUG_HOST";
    public static final String UBC_DEBUG_URL = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc";
    public static final int VOICE_ID = 790;
    public static final String WEEKLY_CONFIG_FILE = "weekly_searchbox_config.ini";
    public static HashMap<String, String> sConfigMap = null;
    public static boolean sDebug = false;
    public static String sFileContent = null;
    public static String sInternalFileContent = null;
    public static boolean sIsBeta = false;
    public static boolean sIsDaily = false;
    public static boolean sIsWeekly = false;
    public static boolean sNeedSkipAndRemoveExternalConfig = false;
    public static boolean useQADefaultDings = false;
    public static boolean userProfileForbidFlag = false;
    public File mConfigFile;
    public File mTimestampFile;

    /* loaded from: classes2.dex */
    public static class AppInfo {
        public static final String DEFAULT_PACKAGE_NAME = "com.baidu.searchbox";
        public static final String PREVIEW_PACKAGE_NAME = "com.baidu.searchbox.preview";
        public static final String SMART_PACKAGE_NAME = "com.baidu.searchbox.unknown";
        public static final String TAG = "AppInfo";
        public static final String WEEKLY_PACKAGE_NAME = "com.baidu.searchbox.weekly";
        public static String sBoxVersionCode;
        public static String sBoxVersionName;
        public static String sPackageName;

        public static String dumpAppInfo() {
            String str = "AppInfo: " + getPackageName() + "|" + getVersionName() + "|" + getVersionCode() + "|isDaily=" + isDaily() + "|isWeekly=" + isWeekly() + "|isPreview=" + isPreview() + "|isDebug=" + AppConfig.isDebug();
            if (AppConfig.isDebug()) {
                Log.d(TAG, str);
            }
            return str;
        }

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
                    PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
                    sBoxVersionCode = packageInfo.versionCode + "";
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            return sBoxVersionCode;
        }

        public static String getVersionName() {
            if (TextUtils.isEmpty(sBoxVersionName)) {
                try {
                    Context appContext = AppRuntime.getAppContext();
                    PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
                    sBoxVersionName = packageInfo.versionName + "";
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            return sBoxVersionName;
        }

        public static boolean isDaily() {
            return AppConfig.sIsDaily;
        }

        public static boolean isModifyPkg() {
            return !TextUtils.equals(getPackageName(), "com.baidu.searchbox");
        }

        public static boolean isPreview() {
            return TextUtils.equals(getPackageName(), PREVIEW_PACKAGE_NAME);
        }

        public static boolean isSmartPreview() {
            return TextUtils.equals(getPackageName(), SMART_PACKAGE_NAME);
        }

        public static boolean isWeekly() {
            return TextUtils.equals(getPackageName(), WEEKLY_PACKAGE_NAME);
        }
    }

    /* loaded from: classes2.dex */
    public interface ConfigValueFilter {
        boolean isIllegalContent(String str);
    }

    /* loaded from: classes2.dex */
    public static class ConfigWhiteList {
        public static final String[] WHITE_LIST = {"GRAB_SERVER_COMMAND", "XSEARCH_FORCE_HTML5", "DREAM_QR_PAGEID", "USER_PROTOCOL_SWITCH", "SILENT_WEBKIT", "SILENT_VIDEO", "FORBID_CONFIG_FILE_WARNING", "ANTIHIJACK_WEBSEARCH_URL", "ANTIHIJACK_UPLOAD_URL", "USE_AUTO_FOCUS", "VOICE_PID", "IMG_SEARCH_URL", "LOAD_IN_MAIN_BROWSER", "DOWNLOAD_DEST_MODE", "DOWNLOAD_DEST_DIR", "USER_PROFILE_FORBIDDEN_CONFIG", "NETTRAFFIC_UPLOAD_NUM_LIMIT", "SPEED_MONITOR", "SPEED_MONITOR_UPLOAD"};

        public static boolean isInWhiteList(String str) {
            int length = WHITE_LIST.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (TextUtils.equals(WHITE_LIST[i2], str)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class Debug {
        public static String getJacocoUploadUrl() {
            return AppConfig.getStringConfig("JACOCO_UPLOAD_URL", "http://cp01-searchbbox-andriod-cqa01.epc.baidu.com:8666/Coverage/fileUploadAPI/fileManager.php");
        }
    }

    /* loaded from: classes2.dex */
    public static class Downloads {
        public static String getDestinationDir() {
            return AppConfig.getStringConfig("DOWNLOAD_DEST_DIR", "");
        }

        public static String getDestinationMode() {
            return AppConfig.getStringConfig("DOWNLOAD_DEST_MODE", null);
        }
    }

    /* loaded from: classes2.dex */
    public static class HTTPSConfig {
        public static final long TMP_USE_HTTP_DELTA = 518400000;

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

    /* loaded from: classes2.dex */
    public static class Speed {
        public static boolean getSpeedEnable() {
            return AppConfig.getBooleanConfig("SPEED_MONITOR", false);
        }

        public static String getSpeedMonitorUpload() {
            return AppConfig.getStringConfig("SPEED_MONITOR_UPLOAD", "");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
        if (r2 != null) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072 A[Catch: Exception -> 0x0075, TRY_LEAVE, TryCatch #6 {Exception -> 0x0075, blocks: (B:34:0x006d, B:36:0x0072), top: B:45:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void activeConfigFile(Context context) {
        FileOutputStream fileOutputStream;
        Exception e2;
        DataOutputStream dataOutputStream;
        if (sDebug || context == null) {
            return;
        }
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), TIMESTAMP_FILE));
                try {
                    dataOutputStream = new DataOutputStream(fileOutputStream);
                    try {
                        try {
                            dataOutputStream.writeLong(System.currentTimeMillis());
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        } catch (Exception e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream2 = dataOutputStream;
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (Exception unused) {
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    dataOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (dataOutputStream2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            e2 = e5;
            dataOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
        fileOutputStream.close();
        Toast.makeText(context, "配置文件有效时间：" + getActiveDuration(), 0).show();
    }

    public static String getActiveDuration() {
        return "2分钟";
    }

    public static final boolean getBooleanConfig(String str, boolean z) {
        String str2;
        HashMap<String, String> hashMap = sConfigMap;
        return (hashMap == null || (str2 = hashMap.get(str)) == null) ? z : Boolean.parseBoolean(str2);
    }

    public static String getCommunityPreConnectImageUrl() {
        return HostConfig.isSearchboxUseHttps() ? "https://timgmb.bdimg.com/timg" : "http://timgmb.bdimg.com/timg";
    }

    public static String getConfigFileContent() {
        return sFileContent;
    }

    public static String getConfigUrl() {
        return getStringConfig("CONFIG_URL", String.format("%s/static/searchbox/android/appconfig.html", DownloadConstants.REFER));
    }

    public static String getCookieHost() {
        return getStringConfig("COOKIE_URL", Domains.BAIDU);
    }

    public static String getDailyUpdateUrl() {
        return getWeeklyUpdateUrl();
    }

    public static String getExternalConfigFileName() {
        return CONFIG_FILE;
    }

    public static String getFollowAllUrl() {
        return String.format("%s/api/subscribe/v1/relation/receive_all", HostConfig.getExtHostForHttps());
    }

    public static boolean getForbidConfigFileWarning() {
        return getBooleanConfig("FORBID_CONFIG_FILE_WARNING", false);
    }

    public static boolean getGrabServerCommandSwitch() {
        return getBooleanConfig("GRAB_SERVER_COMMAND", true);
    }

    public static boolean getImageSearchGuideConfiged() {
        return getStringConfig("IMAGE_SEARCH_GUIDE_HOST", null) != null;
    }

    public static boolean getImageSearchHostConfiged() {
        return getStringConfig("IMAGE_SEARCH_URL", null) != null;
    }

    public static final int getIntConfig(String str, int i2) {
        String str2;
        HashMap<String, String> hashMap = sConfigMap;
        return (hashMap == null || (str2 = hashMap.get(str)) == null) ? i2 : Integer.parseInt(str2);
    }

    public static String getInternalConfigContent() {
        return sInternalFileContent;
    }

    public static boolean getLoadInMainBrowser() {
        return getBooleanConfig("LOAD_IN_MAIN_BROWSER", false);
    }

    public static String getNetTestServer() {
        return "http://112.34.113.161/checkupdate";
    }

    public static int getNetTrafficUploadNumLimit() {
        return getIntConfig("NETTRAFFIC_UPLOAD_NUM_LIMIT", 0);
    }

    public static String getPreviewUpdateUrl() {
        return getWeeklyUpdateUrl();
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

    public static boolean getSilentVideo() {
        return getBooleanConfig("SILENT_VIDEO", true);
    }

    public static boolean getSilentWebkit() {
        return getBooleanConfig("SILENT_WEBKIT", true);
    }

    public static final String getStringConfig(String str, String str2) {
        String str3;
        HashMap<String, String> hashMap = sConfigMap;
        return (hashMap == null || (str3 = hashMap.get(str)) == null) ? str2 : str3;
    }

    public static String getUbcTestUrl() {
        return getStringConfig("UBC_DEBUG_HOST", "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc");
    }

    public static boolean getUseAutoFocus() {
        return getBooleanConfig("USE_AUTO_FOCUS", true);
    }

    public static boolean getUserProfileForbidden() {
        return getBooleanConfig("USER_PROFILE_FORBIDDEN_CONFIG", false);
    }

    public static int getVoicePid() {
        return getIntConfig("VOICE_PID", VOICE_ID);
    }

    public static String getWeeklyUpdateUrl() {
        return "http://shoubai.m.baidu.com/weeklyupdate/index.php?type=update";
    }

    public static String getXDataUrl() {
        return getStringConfig("XSEARCH_DATA_URL", "http://m.baidu.com/microapp");
    }

    public static void init(boolean z, boolean z2, boolean z3, boolean z4) {
        sIsDaily = z;
        sIsWeekly = z2;
        sDebug = z3;
        sIsBeta = z4;
    }

    public static boolean isBeta() {
        return sIsBeta;
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static boolean isDebugBuild() {
        return false;
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

    public static boolean parseExternalConfig(HashMap<String, String> hashMap, ConfigValueFilter configValueFilter) {
        try {
            File file = new File(AppRuntime.getAppContext().getFilesDir().getPath(), CONFIG_FILE);
            if (file.exists()) {
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        parseStream(fileInputStream2, hashMap, configValueFilter, false);
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused) {
                        }
                        return true;
                    } catch (Exception unused2) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused4) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Exception unused5) {
        }
        return false;
    }

    public static void parseInternalConfig(HashMap<String, String> hashMap, ConfigValueFilter configValueFilter) {
        InputStream open;
        AssetManager assets = AppRuntime.getAppContext().getResources().getAssets();
        InputStream inputStream = null;
        try {
            if (sIsDaily) {
                open = assets.open(DAILY_CONFIG_FILE);
            } else if (sIsWeekly) {
                open = assets.open(WEEKLY_CONFIG_FILE);
            } else {
                open = assets.open(CONFIG_FILE);
            }
            inputStream = open;
            parseStream(inputStream, hashMap, configValueFilter, true);
            if (inputStream == null) {
                return;
            }
        } catch (Exception unused) {
            if (inputStream == null) {
                return;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        try {
            inputStream.close();
        } catch (Exception unused3) {
        }
    }

    public static void parseStream(InputStream inputStream, Map<String, String> map, ConfigValueFilter configValueFilter, boolean z) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String substring = readLine.substring(0, readLine.indexOf("="));
                String substring2 = readLine.substring(readLine.indexOf("=") + 1);
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
        } catch (IOException unused) {
        }
    }
}
