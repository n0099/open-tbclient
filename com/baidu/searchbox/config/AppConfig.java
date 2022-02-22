package com.baidu.searchbox.config;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.Domains;
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
@SuppressLint({"BDOfflineUrl"})
/* loaded from: classes11.dex */
public class AppConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONFIG_FILE = "searchbox_config.ini";
    public static final String DAILY_CONFIG_FILE = "daily_searchbox_config.ini";
    public static final long TIMESTAMP_AVAILABLE_DURATION = 120000;
    public static final String TIMESTAMP_FILE = ".config.lock";
    public static final String UBC_DEBUG_HOST = "UBC_DEBUG_HOST";
    public static final String UBC_DEBUG_URL = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc";
    public static final int VOICE_ID = 790;
    public static final String WEEKLY_CONFIG_FILE = "weekly_searchbox_config.ini";
    public static HashMap<String, String> sConfigMap;
    public static boolean sDebug;
    public static String sFileContent;
    public static String sInternalFileContent;
    public static boolean sIsBeta;
    public static boolean sIsDaily;
    public static boolean sIsWeekly;
    public static boolean sNeedSkipAndRemoveExternalConfig;
    public static boolean useQADefaultDings;
    public static boolean userProfileForbidFlag;
    public transient /* synthetic */ FieldHolder $fh;
    public File mConfigFile;
    public File mTimestampFile;

    /* loaded from: classes11.dex */
    public static class AppInfo {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DEFAULT_PACKAGE_NAME = "com.baidu.searchbox";
        public static final String PREVIEW_PACKAGE_NAME = "com.baidu.searchbox.preview";
        public static final String SMART_PACKAGE_NAME = "com.baidu.searchbox.unknown";
        public static final String TAG = "AppInfo";
        public static final String WEEKLY_PACKAGE_NAME = "com.baidu.searchbox.weekly";
        public static String sBoxVersionCode;
        public static String sBoxVersionName;
        public static String sPackageName;
        public transient /* synthetic */ FieldHolder $fh;

        public AppInfo() {
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

        public static String dumpAppInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                String str = "AppInfo: " + getPackageName() + "|" + getVersionName() + "|" + getVersionCode() + "|isDaily=" + isDaily() + "|isWeekly=" + isWeekly() + "|isPreview=" + isPreview() + "|isDebug=" + AppConfig.isDebug();
                AppConfig.isDebug();
                return str;
            }
            return (String) invokeV.objValue;
        }

        public static String getPackageName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (TextUtils.isEmpty(sPackageName)) {
                    sPackageName = AppRuntime.getAppContext().getPackageName();
                }
                return sPackageName;
            }
            return (String) invokeV.objValue;
        }

        public static String getVersionCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
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
            return (String) invokeV.objValue;
        }

        public static String getVersionName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
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
            return (String) invokeV.objValue;
        }

        public static boolean isDaily() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? AppConfig.sIsDaily : invokeV.booleanValue;
        }

        public static boolean isModifyPkg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? !TextUtils.equals(getPackageName(), "com.baidu.searchbox") : invokeV.booleanValue;
        }

        public static boolean isPreview() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? TextUtils.equals(getPackageName(), PREVIEW_PACKAGE_NAME) : invokeV.booleanValue;
        }

        public static boolean isSmartPreview() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? TextUtils.equals(getPackageName(), SMART_PACKAGE_NAME) : invokeV.booleanValue;
        }

        public static boolean isWeekly() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? TextUtils.equals(getPackageName(), WEEKLY_PACKAGE_NAME) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public interface ConfigValueFilter {
        boolean isIllegalContent(String str);
    }

    /* loaded from: classes11.dex */
    public static class ConfigWhiteList {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] WHITE_LIST;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1827430710, "Lcom/baidu/searchbox/config/AppConfig$ConfigWhiteList;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1827430710, "Lcom/baidu/searchbox/config/AppConfig$ConfigWhiteList;");
                    return;
                }
            }
            WHITE_LIST = new String[]{"GRAB_SERVER_COMMAND", "XSEARCH_FORCE_HTML5", "DREAM_QR_PAGEID", "USER_PROTOCOL_SWITCH", "SILENT_WEBKIT", "SILENT_VIDEO", "FORBID_CONFIG_FILE_WARNING", "ANTIHIJACK_WEBSEARCH_URL", "ANTIHIJACK_UPLOAD_URL", "USE_AUTO_FOCUS", "VOICE_PID", "IMG_SEARCH_URL", "LOAD_IN_MAIN_BROWSER", "DOWNLOAD_DEST_MODE", "DOWNLOAD_DEST_DIR", "USER_PROFILE_FORBIDDEN_CONFIG", "NETTRAFFIC_UPLOAD_NUM_LIMIT", "SPEED_MONITOR", "SPEED_MONITOR_UPLOAD"};
        }

        public ConfigWhiteList() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static boolean isInWhiteList(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                int length = WHITE_LIST.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (TextUtils.equals(WHITE_LIST[i2], str)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class Debug {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Debug() {
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

        public static String getJacocoUploadUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? AppConfig.getStringConfig("JACOCO_UPLOAD_URL", "http://cp01-searchbbox-andriod-cqa01.epc.baidu.com:8666/Coverage/fileUploadAPI/fileManager.php") : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class Downloads {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Downloads() {
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

        public static String getDestinationDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? AppConfig.getStringConfig("DOWNLOAD_DEST_DIR", "") : (String) invokeV.objValue;
        }

        public static String getDestinationMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? AppConfig.getStringConfig("DOWNLOAD_DEST_MODE", null) : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class HTTPSConfig {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long TMP_USE_HTTP_DELTA = 518400000;
        public transient /* synthetic */ FieldHolder $fh;

        public HTTPSConfig() {
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

        public static boolean isTmpUseHttp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                QuickPersistConfig quickPersistConfig = QuickPersistConfig.getInstance();
                if (quickPersistConfig.getInt(QuickPersistConfigConst.KEY_TMP_USE_HTTP, 0) == 0) {
                    return false;
                }
                return Math.abs(System.currentTimeMillis() - quickPersistConfig.getLong(QuickPersistConfigConst.KEY_LAST_TMP_USE_HTTP_TS, 0L)) < TMP_USE_HTTP_DELTA;
            }
            return invokeV.booleanValue;
        }

        public static void setTmpUseHttp() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, null) == null) {
                QuickPersistConfig quickPersistConfig = QuickPersistConfig.getInstance();
                quickPersistConfig.putInt(QuickPersistConfigConst.KEY_TMP_USE_HTTP, 1);
                quickPersistConfig.putLong(QuickPersistConfigConst.KEY_LAST_TMP_USE_HTTP_TS, System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class Speed {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Speed() {
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

        public static boolean getSpeedEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? AppConfig.getBooleanConfig("SPEED_MONITOR", false) : invokeV.booleanValue;
        }

        public static String getSpeedMonitorUpload() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? AppConfig.getStringConfig("SPEED_MONITOR_UPLOAD", "") : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1333490987, "Lcom/baidu/searchbox/config/AppConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1333490987, "Lcom/baidu/searchbox/config/AppConfig;");
        }
    }

    public AppConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0033 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0035 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x004b */
    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x004e */
    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x0079 */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004b, code lost:
        if (r2 != 0) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void activeConfigFile(Context context) {
        Exception e2;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || sDebug || context == null) {
            return;
        }
        File filesDir = context.getFilesDir();
        ?? r2 = TIMESTAMP_FILE;
        File file = new File(filesDir, TIMESTAMP_FILE);
        ?? r1 = 0;
        r1 = 0;
        try {
            try {
                try {
                    r2 = new FileOutputStream(file);
                } catch (Exception unused) {
                }
            } catch (Exception e3) {
                r2 = 0;
                e2 = e3;
                dataOutputStream = null;
            } catch (Throwable th) {
                th = th;
                r2 = 0;
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = file;
        }
        try {
            dataOutputStream = new DataOutputStream(r2);
            try {
                dataOutputStream.writeLong(System.currentTimeMillis());
                dataOutputStream.flush();
                dataOutputStream.close();
            } catch (Exception e4) {
                e2 = e4;
                e2.printStackTrace();
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
            }
        } catch (Exception e5) {
            e2 = e5;
            dataOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (Exception unused2) {
                    throw th;
                }
            }
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
        r2.close();
        Toast.makeText(context, "配置文件有效时间：" + getActiveDuration(), 0).show();
    }

    public static String getActiveDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "2分钟" : (String) invokeV.objValue;
    }

    public static final boolean getBooleanConfig(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, str, z)) == null) {
            HashMap<String, String> hashMap = sConfigMap;
            return (hashMap == null || (str2 = hashMap.get(str)) == null) ? z : Boolean.parseBoolean(str2);
        }
        return invokeLZ.booleanValue;
    }

    public static String getCommunityPreConnectImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? HostConfig.isSearchboxUseHttps() ? "https://timgmb.bdimg.com/timg" : "http://timgmb.bdimg.com/timg" : (String) invokeV.objValue;
    }

    public static String getConfigFileContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? sFileContent : (String) invokeV.objValue;
    }

    public static String getConfigUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? getStringConfig("CONFIG_URL", String.format("%s/static/searchbox/android/appconfig.html", DownloadConstants.REFER)) : (String) invokeV.objValue;
    }

    public static String getCookieHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? getStringConfig("COOKIE_URL", Domains.BAIDU) : (String) invokeV.objValue;
    }

    public static String getDailyUpdateUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? getWeeklyUpdateUrl() : (String) invokeV.objValue;
    }

    public static String getExternalConfigFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? CONFIG_FILE : (String) invokeV.objValue;
    }

    public static String getFollowAllUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? String.format("%s/api/subscribe/v1/relation/receive_all", HostConfig.getExtHostForHttps()) : (String) invokeV.objValue;
    }

    public static boolean getForbidConfigFileWarning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? getBooleanConfig("FORBID_CONFIG_FILE_WARNING", false) : invokeV.booleanValue;
    }

    public static boolean getGrabServerCommandSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? getBooleanConfig("GRAB_SERVER_COMMAND", true) : invokeV.booleanValue;
    }

    public static boolean getImageSearchGuideConfiged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? getStringConfig("IMAGE_SEARCH_GUIDE_HOST", null) != null : invokeV.booleanValue;
    }

    public static boolean getImageSearchHostConfiged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? getStringConfig("IMAGE_SEARCH_URL", null) != null : invokeV.booleanValue;
    }

    public static final int getIntConfig(String str, int i2) {
        InterceptResult invokeLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, str, i2)) == null) {
            HashMap<String, String> hashMap = sConfigMap;
            return (hashMap == null || (str2 = hashMap.get(str)) == null) ? i2 : Integer.parseInt(str2);
        }
        return invokeLI.intValue;
    }

    public static String getInternalConfigContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? sInternalFileContent : (String) invokeV.objValue;
    }

    public static boolean getLoadInMainBrowser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? getBooleanConfig("LOAD_IN_MAIN_BROWSER", false) : invokeV.booleanValue;
    }

    public static String getNetTestServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? "http://112.34.113.161/checkupdate" : (String) invokeV.objValue;
    }

    public static int getNetTrafficUploadNumLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? getIntConfig("NETTRAFFIC_UPLOAD_NUM_LIMIT", 0) : invokeV.intValue;
    }

    public static String getPreviewUpdateUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? getWeeklyUpdateUrl() : (String) invokeV.objValue;
    }

    public static String getQAWebSearchUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
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
        return (String) invokeV.objValue;
    }

    public static boolean getSilentVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? getBooleanConfig("SILENT_VIDEO", true) : invokeV.booleanValue;
    }

    public static boolean getSilentWebkit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? getBooleanConfig("SILENT_WEBKIT", true) : invokeV.booleanValue;
    }

    public static final String getStringConfig(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, str, str2)) == null) {
            HashMap<String, String> hashMap = sConfigMap;
            return (hashMap == null || (str3 = hashMap.get(str)) == null) ? str2 : str3;
        }
        return (String) invokeLL.objValue;
    }

    public static String getUbcTestUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? getStringConfig("UBC_DEBUG_HOST", "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc") : (String) invokeV.objValue;
    }

    public static boolean getUseAutoFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? getBooleanConfig("USE_AUTO_FOCUS", true) : invokeV.booleanValue;
    }

    public static boolean getUserProfileForbidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? getBooleanConfig("USER_PROFILE_FORBIDDEN_CONFIG", false) : invokeV.booleanValue;
    }

    public static int getVoicePid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? getIntConfig("VOICE_PID", VOICE_ID) : invokeV.intValue;
    }

    public static String getWeeklyUpdateUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? "http://shoubai.m.baidu.com/weeklyupdate/index.php?type=update" : (String) invokeV.objValue;
    }

    public static String getXDataUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? getStringConfig("XSEARCH_DATA_URL", "http://m.baidu.com/microapp") : (String) invokeV.objValue;
    }

    public static void init(boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            sIsDaily = z;
            sIsWeekly = z2;
            sDebug = z3;
            sIsBeta = z4;
        }
    }

    public static boolean isBeta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? sIsBeta : invokeV.booleanValue;
    }

    public static boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? sDebug : invokeV.booleanValue;
    }

    public static boolean isDebugBuild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void parseConfig(ConfigValueFilter configValueFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, null, configValueFilter) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (!parseExternalConfig(hashMap, configValueFilter) || !sIsDaily) {
                parseInternalConfig(hashMap, configValueFilter);
            }
            if (hashMap.size() > 0) {
                sConfigMap = hashMap;
            }
        }
    }

    public static boolean parseExternalConfig(HashMap<String, String> hashMap, ConfigValueFilter configValueFilter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, hashMap, configValueFilter)) == null) {
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
        return invokeLL.booleanValue;
    }

    public static void parseInternalConfig(HashMap<String, String> hashMap, ConfigValueFilter configValueFilter) {
        InputStream open;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65575, null, hashMap, configValueFilter) != null) {
            return;
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65576, null, new Object[]{inputStream, map, configValueFilter, Boolean.valueOf(z)}) == null) {
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
}
