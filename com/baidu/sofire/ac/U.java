package com.baidu.sofire.ac;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.sofire.FileDeleteObserverUtils;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.ForHostApp;
import com.baidu.sofire.core.PluginloaderHub;
import com.baidu.sofire.core.TimeoutRunner;
import com.baidu.sofire.d.D;
import com.baidu.sofire.jni.Asc;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.sofire.utility.AlarmUtil;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.EncryptUtil;
import com.baidu.sofire.utility.HttpUtil;
import com.baidu.sofire.utility.LocalConstant;
import com.baidu.sofire.utility.MD5Util;
import com.baidu.sofire.utility.OkHttpUtil;
import com.baidu.sofire.utility.ThreadPoolManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class U implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_DAILY_ALARM = 6;
    public static final int FROM_DEFAULT = 0;
    public static final int FROM_HANDLE_REMOVE = 4;
    public static final int FROM_HOST_CALL = 7;
    public static final int FROM_INIT = 1;
    public static final int FROM_INIT_ALARM = 2;
    public static final int FROM_NET_CHANGE = 3;
    public static final int FROM_OUT_FLASH = 5;
    public static final int MINUTE = 60000;
    public static final int MODULE_LOAD_ERROR_CHECK_FAIL = 4;
    public static final int MODULE_LOAD_ERROR_CLOUD_NULL = 5;
    public static final int MODULE_LOAD_ERROR_DECRYPT_FAIL = 3;
    public static final int MODULE_LOAD_ERROR_EXCEPTION = 6;
    public static final int MODULE_LOAD_ERROR_HOST_INFO = 7;
    public static final int MODULE_LOAD_ERROR_LOAD_FAIL = 2;
    public static final int MODULE_LOAD_ERROR_NETWORK = 1;
    public static final int MODULE_LOAD_ERROR_OTHER = 11;
    public static final int MODULE_LOAD_ERROR_POLICY = 10;
    public static final int MODULE_LOAD_ERROR_PROCESS = 9;
    public static final int MODULE_LOAD_ERROR_TOO_CLOSE = 8;
    public static final int NETWORK_TYPE_2G = 1;
    public static final int NETWORK_TYPE_3G = 2;
    public static final int NETWORK_TYPE_4G = 3;
    public static final int NETWORK_TYPE_MOBILE = 5;
    public static final int NETWORK_TYPE_UNCONNECTED = -1;
    public static final int NETWORK_TYPE_UNKNOWN = -2;
    public static final int NETWORK_TYPE_WIFI = 4;
    public static final int OUT_AES_FAIL = 8;
    public static final int OUT_FINISH = 1;
    public static final int OUT_NO_INTERNET = 3;
    public static final int OUT_NULL_APPKEY = 5;
    public static final int OUT_NULL_HOST_PKGINFO = 6;
    public static final int OUT_NULL_PLUGIN_JSON = 10;
    public static final int OUT_NULL_RESPONSE_JSON = 9;
    public static final int OUT_OTHER_THROWABLE = 11;
    public static final int OUT_PING_FAIL = 4;
    public static final int OUT_RESPONSE_EMPTY = 7;
    public static final int OUT_TIME_TOO_CLOSE = 2;
    public static final int OUT_UNSET = 0;
    public static final int TYPE_END = 1;
    public static final int TYPE_START = 0;
    public static final int UPGRADE_DECRYPT_FAIL = 7;
    public static final int UPGRADE_DOWNLOAD_FAIL = 4;
    public static final int UPGRADE_ERROR_CRASH_TIMES = 6;
    public static final int UPGRADE_LOAD_FAIL = 5;
    public static final int UPGRADE_MD5_FAIL = 8;
    public static final int UPGRADE_NETWORK_CHECK_FAIL = 3;
    public static final int UPGRADE_RESULT_EXCEPTION = 2;
    public static final int UPGRADE_RESULT_SUCCESS = 1;
    public static Map<Integer, List<BDModuleLoadCallback>> sCallbackMap;
    public static boolean sIsRunning;
    public static long sLastCheckTime;
    public static boolean sMonitorNetworkWhenUpgradeNoNet;
    public static volatile boolean sOutGoing;
    public static Map<String, String> sRealtimeMd5Map;
    public static int sRetryDownoadHostCareApksTimesCount;
    public static int sRetryPingTimesCount;
    public static boolean sSetRetrmAlarm;
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;
    public ForHostApp forHostAPP;
    public D loadedPluginDB;
    public Map<Integer, String> mCloudKeyMap;
    public List<Integer> mDownloadPluginsList;
    public int mEndReason;
    public int mFrom;
    public boolean mOut;
    public SharedPreferenceManager mPreferenceManager;
    public Map<Integer, String> mStartKeyMap;
    public int mStartNetwork;
    public List<Integer> mUnloadPluginsList;
    public Map<Integer, UpgradeResult> mUpgradeResultMap;
    public JSONObject mWholeJson;
    public File tmpDir;

    /* loaded from: classes4.dex */
    public class UpgradeResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int networkId;
        public int resultId;
        public final /* synthetic */ U this$0;

        public UpgradeResult(U u, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = u;
            this.networkId = i;
            this.resultId = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-130218012, "Lcom/baidu/sofire/ac/U;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-130218012, "Lcom/baidu/sofire/ac/U;");
                return;
            }
        }
        sCallbackMap = new HashMap();
        sLastCheckTime = 0L;
        sOutGoing = false;
        sMonitorNetworkWhenUpgradeNoNet = false;
        sRetryPingTimesCount = 0;
        sRetryDownoadHostCareApksTimesCount = 0;
        sSetRetrmAlarm = false;
    }

    public U(Context context, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mFrom = 0;
        this.mEndReason = 0;
        this.mOut = false;
        this.mCloudKeyMap = new HashMap();
        this.mUnloadPluginsList = new ArrayList();
        this.mDownloadPluginsList = new ArrayList();
        this.mUpgradeResultMap = new HashMap();
        this.mStartNetwork = -2;
        this.context = context;
        this.loadedPluginDB = D.getInstance(context);
        this.mPreferenceManager = SharedPreferenceManager.getInstance(context);
        this.forHostAPP = ForHostApp.getInstance(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.mFrom = i;
        this.mOut = z;
    }

    public static synchronized void addCallback(int i, BDModuleLoadCallback bDModuleLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i, bDModuleLoadCallback) == null) {
            synchronized (U.class) {
                List<BDModuleLoadCallback> list = sCallbackMap.get(Integer.valueOf(i));
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(bDModuleLoadCallback);
                sCallbackMap.put(Integer.valueOf(i), list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePluginDownError(ApkInfo apkInfo, File file, int i, List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65545, this, apkInfo, file, i, list) == null) {
            Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
            if (map != null && !map.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i, 4));
            }
            int i2 = this.mFrom;
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                if (list != null && list.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                    sSetRetrmAlarm = true;
                    AlarmUtil.setCheckUpdateRetryAlarm(this.context, sRetryDownoadHostCareApksTimesCount, false);
                    sRetryDownoadHostCareApksTimesCount++;
                }
                if (!sMonitorNetworkWhenUpgradeNoNet) {
                    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    MyReceiver myReceiver = CommonMethods.sNetWorkReceiver;
                    if (myReceiver == null) {
                        CommonMethods.sNetWorkReceiver = new MyReceiver().setOnlyNetSelf();
                    } else {
                        myReceiver.setOnlyNetSelf();
                    }
                    CommonMethods.registerReceiver(this.context, CommonMethods.sNetWorkReceiver, intentFilter);
                    sMonitorNetworkWhenUpgradeNoNet = true;
                }
            }
            if (System.currentTimeMillis() - this.mPreferenceManager.getPullApkFailedTime() > 86400000) {
                HashMap hashMap = new HashMap();
                if (CommonMethods.isWifiAvailable(this.context)) {
                    hashMap.put("0", Integer.valueOf(this.mPreferenceManager.getPullApkWifiFailed() + 1));
                    hashMap.put("1", Integer.valueOf(this.mPreferenceManager.getPullApkMobileFailed()));
                } else {
                    hashMap.put("0", Integer.valueOf(this.mPreferenceManager.getPullApkWifiFailed()));
                    hashMap.put("1", Integer.valueOf(this.mPreferenceManager.getPullApkMobileFailed() + 1));
                }
                this.mPreferenceManager.setPullApkWifiFailed(0);
                this.mPreferenceManager.setPullApkMobileFailed(0);
                this.mPreferenceManager.setPullApkFailedTime();
                CommonMethods.sendEventUDC(this.context, "1003116", hashMap, false);
            } else if (CommonMethods.isWifiAvailable(this.context)) {
                SharedPreferenceManager sharedPreferenceManager = this.mPreferenceManager;
                sharedPreferenceManager.setPullApkWifiFailed(sharedPreferenceManager.getPullApkWifiFailed() + 1);
            } else {
                SharedPreferenceManager sharedPreferenceManager2 = this.mPreferenceManager;
                sharedPreferenceManager2.setPullApkMobileFailed(sharedPreferenceManager2.getPullApkMobileFailed() + 1);
            }
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handlePluginDownload(ApkInfo apkInfo, File file, File file2, int i) {
        InterceptResult invokeLLLI;
        boolean downloadFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65546, this, apkInfo, file, file2, i)) == null) {
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (!CommonMethods.PKGNAME_HUAWEI_INPUT.equals(this.context.getPackageName()) || this.mPreferenceManager.getCanConn()) {
                if (OkHttpUtil.useOkHttp(this.context)) {
                    downloadFile = new OkHttpUtil(this.context).requestForGetFile(apkInfo.downloadURL, file);
                } else {
                    downloadFile = new HttpUtil(this.context, null).downloadFile(apkInfo.downloadURL, file);
                }
                if (downloadFile) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    new Asc();
                    if (EncryptUtil.decryptFile(file, file2, apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes(IMAudioTransRequest.CHARSET)) != 0) {
                        if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i, 7));
                        }
                        downloadFile = false;
                    }
                } else if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i, 4));
                }
                String md5 = MD5Util.getMD5(file2);
                file.delete();
                if (downloadFile) {
                    if (apkInfo.apkMD5.equals(md5)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLLLI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ce A[Catch: all -> 0x01d4, TryCatch #0 {all -> 0x01d4, blocks: (B:5:0x000b, B:7:0x0019, B:17:0x0056, B:19:0x005e, B:20:0x0063, B:22:0x00b9, B:27:0x00ce, B:29:0x00d2, B:40:0x011c, B:76:0x01d0, B:43:0x0124, B:45:0x012e, B:50:0x013c, B:52:0x0144, B:54:0x014e, B:55:0x0159, B:57:0x0161, B:60:0x016c, B:63:0x0174, B:65:0x0180, B:67:0x018d, B:68:0x019e, B:72:0x01b3, B:74:0x01c5, B:69:0x01a3, B:30:0x00ec, B:32:0x00f6, B:34:0x0106, B:36:0x0113, B:9:0x0025, B:11:0x002f, B:13:0x0033, B:15:0x0045), top: B:114:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011c A[Catch: all -> 0x01d4, TryCatch #0 {all -> 0x01d4, blocks: (B:5:0x000b, B:7:0x0019, B:17:0x0056, B:19:0x005e, B:20:0x0063, B:22:0x00b9, B:27:0x00ce, B:29:0x00d2, B:40:0x011c, B:76:0x01d0, B:43:0x0124, B:45:0x012e, B:50:0x013c, B:52:0x0144, B:54:0x014e, B:55:0x0159, B:57:0x0161, B:60:0x016c, B:63:0x0174, B:65:0x0180, B:67:0x018d, B:68:0x019e, B:72:0x01b3, B:74:0x01c5, B:69:0x01a3, B:30:0x00ec, B:32:0x00f6, B:34:0x0106, B:36:0x0113, B:9:0x0025, B:11:0x002f, B:13:0x0033, B:15:0x0045), top: B:114:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0161 A[Catch: all -> 0x01d4, TryCatch #0 {all -> 0x01d4, blocks: (B:5:0x000b, B:7:0x0019, B:17:0x0056, B:19:0x005e, B:20:0x0063, B:22:0x00b9, B:27:0x00ce, B:29:0x00d2, B:40:0x011c, B:76:0x01d0, B:43:0x0124, B:45:0x012e, B:50:0x013c, B:52:0x0144, B:54:0x014e, B:55:0x0159, B:57:0x0161, B:60:0x016c, B:63:0x0174, B:65:0x0180, B:67:0x018d, B:68:0x019e, B:72:0x01b3, B:74:0x01c5, B:69:0x01a3, B:30:0x00ec, B:32:0x00f6, B:34:0x0106, B:36:0x0113, B:9:0x0025, B:11:0x002f, B:13:0x0033, B:15:0x0045), top: B:114:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0180 A[Catch: all -> 0x01d4, TryCatch #0 {all -> 0x01d4, blocks: (B:5:0x000b, B:7:0x0019, B:17:0x0056, B:19:0x005e, B:20:0x0063, B:22:0x00b9, B:27:0x00ce, B:29:0x00d2, B:40:0x011c, B:76:0x01d0, B:43:0x0124, B:45:0x012e, B:50:0x013c, B:52:0x0144, B:54:0x014e, B:55:0x0159, B:57:0x0161, B:60:0x016c, B:63:0x0174, B:65:0x0180, B:67:0x018d, B:68:0x019e, B:72:0x01b3, B:74:0x01c5, B:69:0x01a3, B:30:0x00ec, B:32:0x00f6, B:34:0x0106, B:36:0x0113, B:9:0x0025, B:11:0x002f, B:13:0x0033, B:15:0x0045), top: B:114:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a3 A[Catch: all -> 0x01d4, TryCatch #0 {all -> 0x01d4, blocks: (B:5:0x000b, B:7:0x0019, B:17:0x0056, B:19:0x005e, B:20:0x0063, B:22:0x00b9, B:27:0x00ce, B:29:0x00d2, B:40:0x011c, B:76:0x01d0, B:43:0x0124, B:45:0x012e, B:50:0x013c, B:52:0x0144, B:54:0x014e, B:55:0x0159, B:57:0x0161, B:60:0x016c, B:63:0x0174, B:65:0x0180, B:67:0x018d, B:68:0x019e, B:72:0x01b3, B:74:0x01c5, B:69:0x01a3, B:30:0x00ec, B:32:0x00f6, B:34:0x0106, B:36:0x0113, B:9:0x0025, B:11:0x002f, B:13:0x0033, B:15:0x0045), top: B:114:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d0 A[Catch: all -> 0x01d4, TRY_LEAVE, TryCatch #0 {all -> 0x01d4, blocks: (B:5:0x000b, B:7:0x0019, B:17:0x0056, B:19:0x005e, B:20:0x0063, B:22:0x00b9, B:27:0x00ce, B:29:0x00d2, B:40:0x011c, B:76:0x01d0, B:43:0x0124, B:45:0x012e, B:50:0x013c, B:52:0x0144, B:54:0x014e, B:55:0x0159, B:57:0x0161, B:60:0x016c, B:63:0x0174, B:65:0x0180, B:67:0x018d, B:68:0x019e, B:72:0x01b3, B:74:0x01c5, B:69:0x01a3, B:30:0x00ec, B:32:0x00f6, B:34:0x0106, B:36:0x0113, B:9:0x0025, B:11:0x002f, B:13:0x0033, B:15:0x0045), top: B:114:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handlePluginUpgrade(ApkInfo apkInfo) {
        boolean z;
        boolean z2;
        File file;
        ApkInfo apkInfo2;
        boolean z3;
        boolean z4;
        boolean z5;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65547, this, apkInfo) != null) {
            return;
        }
        try {
            int currNetworkType = CommonMethods.getCurrNetworkType(this.context);
            List<Integer> hostCarePluginKeys = this.mPreferenceManager.getHostCarePluginKeys();
            if ((hostCarePluginKeys == null || !hostCarePluginKeys.contains(Integer.valueOf(apkInfo.key))) && !CommonMethods.checkNetwork(this.context, apkInfo.network)) {
                if (this.mUpgradeResultMap == null || this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    return;
                }
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, currNetworkType, 3));
                return;
            }
            if (!this.tmpDir.exists()) {
                this.tmpDir.mkdir();
            }
            ApkInfo pluginByID = this.loadedPluginDB.getPluginByID(apkInfo.key + LocalConstant.NEXTSUFFIX);
            File file3 = new File(this.tmpDir, apkInfo.key + "-" + apkInfo.versionName + ".tmp");
            File file4 = new File(this.tmpDir, apkInfo.key + "-" + apkInfo.versionName + ".zip");
            if (file4.exists()) {
                if (apkInfo.apkMD5.equals(MD5Util.getMD5(file4))) {
                    z = false;
                    z2 = true;
                    if (z) {
                        file = file4;
                        apkInfo2 = pluginByID;
                    } else if (apkInfo.isNextLoad) {
                        file = file4;
                        apkInfo2 = pluginByID;
                        ThreadPoolManager.getInstance(this.context).execute(new Runnable(this, apkInfo, file3, file4, currNetworkType, hostCarePluginKeys) { // from class: com.baidu.sofire.ac.U.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ U this$0;
                            public final /* synthetic */ ApkInfo val$apkInfo;
                            public final /* synthetic */ File val$file;
                            public final /* synthetic */ List val$hostCarePluginKeys;
                            public final /* synthetic */ int val$networkType;
                            public final /* synthetic */ File val$resfile;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, apkInfo, file3, file4, Integer.valueOf(currNetworkType), hostCarePluginKeys};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$apkInfo = apkInfo;
                                this.val$file = file3;
                                this.val$resfile = file4;
                                this.val$networkType = currNetworkType;
                                this.val$hostCarePluginKeys = hostCarePluginKeys;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        if (!this.this$0.handlePluginDownload(this.val$apkInfo, this.val$file, this.val$resfile, this.val$networkType)) {
                                            this.this$0.handlePluginDownError(this.val$apkInfo, this.val$resfile, this.val$networkType, this.val$hostCarePluginKeys);
                                            return;
                                        }
                                        this.val$apkInfo.pkgPath = this.val$resfile.getAbsolutePath();
                                        ApkInfo apkInfo3 = new ApkInfo(this.val$apkInfo);
                                        apkInfo3.key += LocalConstant.NEXTSUFFIX;
                                        if (!TextUtils.isEmpty(apkInfo3.packageName)) {
                                            apkInfo3.packageName = new StringBuilder(apkInfo3.packageName).reverse().toString();
                                        }
                                        this.this$0.loadedPluginDB.insertOrUpdatePluginRecord(apkInfo3);
                                    } catch (Throwable th) {
                                        CommonMethods.handleNuLException(th);
                                    }
                                }
                            }
                        });
                    } else {
                        file = file4;
                        apkInfo2 = pluginByID;
                        z2 = handlePluginDownload(apkInfo, file3, file, currNetworkType);
                        z3 = !z2;
                        if (apkInfo2 != null) {
                            this.loadedPluginDB.deletePluginById(apkInfo2.key + LocalConstant.NEXTSUFFIX);
                            if (!TextUtils.isEmpty(apkInfo2.pkgPath)) {
                                File file5 = new File(apkInfo2.pkgPath);
                                if (file5.exists()) {
                                    file5.delete();
                                }
                            }
                        }
                        if (z2) {
                            pluginUpdate(file, apkInfo, currNetworkType);
                        } else {
                            if (apkInfo2 != null) {
                                ApkInfo pluginByID2 = this.loadedPluginDB.getPluginByID(apkInfo.key);
                                if (pluginByID2 != null && !CommonMethods.compareVersionNotEquals(apkInfo2.versionName, pluginByID2.versionName)) {
                                    z5 = false;
                                    if (!TextUtils.isEmpty(apkInfo2.versionName) && apkInfo2.versionName.equals(apkInfo.versionName)) {
                                        this.loadedPluginDB.deletePluginByIdVersion(apkInfo2.key + LocalConstant.NEXTSUFFIX, apkInfo2.versionName);
                                        z5 = false;
                                    }
                                    file2 = TextUtils.isEmpty(apkInfo2.pkgPath) ? new File(apkInfo2.pkgPath) : null;
                                    if (file2 != null && file2.exists() && z5) {
                                        if (!apkInfo2.apkMD5.equals(MD5Util.getMD5(file2))) {
                                            apkInfo2.key -= LocalConstant.NEXTSUFFIX;
                                            if (!TextUtils.isEmpty(apkInfo2.packageName)) {
                                                apkInfo2.packageName = new StringBuilder(apkInfo2.packageName).reverse().toString();
                                            }
                                            pluginUpdate(file2, apkInfo2, currNetworkType);
                                            z4 = true;
                                            if (!z4 && PluginloaderHub.createSingleInstance(this.context.getApplicationContext()).getApkInfoByPackageName(apkInfo.packageName) == null) {
                                                this.forHostAPP.initPlugin(apkInfo.key, apkInfo.versionName, null);
                                            }
                                        } else {
                                            this.loadedPluginDB.deletePluginByIdVersion(apkInfo2.key + LocalConstant.NEXTSUFFIX, apkInfo2.versionName);
                                            file2.delete();
                                        }
                                    }
                                }
                                z5 = true;
                                if (!TextUtils.isEmpty(apkInfo2.versionName)) {
                                    this.loadedPluginDB.deletePluginByIdVersion(apkInfo2.key + LocalConstant.NEXTSUFFIX, apkInfo2.versionName);
                                    z5 = false;
                                }
                                if (TextUtils.isEmpty(apkInfo2.pkgPath)) {
                                }
                                if (file2 != null) {
                                    if (!apkInfo2.apkMD5.equals(MD5Util.getMD5(file2))) {
                                    }
                                }
                            }
                            z4 = false;
                            if (!z4) {
                                this.forHostAPP.initPlugin(apkInfo.key, apkInfo.versionName, null);
                            }
                        }
                        if (z3) {
                            handlePluginDownError(apkInfo, file, currNetworkType, hostCarePluginKeys);
                            return;
                        }
                        return;
                    }
                    z3 = false;
                    if (z2) {
                    }
                    if (z3) {
                    }
                }
            }
            z = true;
            z2 = false;
            if (z) {
            }
            z3 = false;
            if (z2) {
            }
            if (z3) {
            }
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
            try {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, CommonMethods.getCurrNetworkType(this.context), 2));
                }
            } catch (Throwable th2) {
                CommonMethods.handleNuLException(th2);
            }
            try {
                List<Integer> hostCarePluginKeys2 = this.mPreferenceManager.getHostCarePluginKeys();
                if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                    if (hostCarePluginKeys2 != null && hostCarePluginKeys2.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                        sSetRetrmAlarm = true;
                        AlarmUtil.setCheckUpdateRetryAlarm(this.context, sRetryDownoadHostCareApksTimesCount, false);
                        sRetryDownoadHostCareApksTimesCount++;
                    }
                    if (sMonitorNetworkWhenUpgradeNoNet) {
                        return;
                    }
                    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    if (CommonMethods.sNetWorkReceiver == null) {
                        CommonMethods.sNetWorkReceiver = new MyReceiver().setOnlyNetSelf();
                    } else {
                        CommonMethods.sNetWorkReceiver.setOnlyNetSelf();
                    }
                    CommonMethods.registerReceiver(this.context, CommonMethods.sNetWorkReceiver, intentFilter);
                    sMonitorNetworkWhenUpgradeNoNet = true;
                }
            } catch (Throwable th3) {
                CommonMethods.handleNuLException(th3);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x01f0 A[Catch: all -> 0x020b, TryCatch #1 {all -> 0x020b, blocks: (B:45:0x0143, B:46:0x014d, B:48:0x0153, B:50:0x0175, B:81:0x01e6, B:82:0x01ea, B:84:0x01f0, B:86:0x01f8, B:87:0x01fc, B:53:0x0183, B:55:0x0187, B:57:0x0197, B:67:0x01b7, B:68:0x01b9, B:76:0x01d1, B:78:0x01d5, B:89:0x0203), top: B:99:0x0143 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleThreadEnd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, str) == null) {
            boolean z = true;
            try {
                this.mPreferenceManager.setUFinishTimesFor1Day(this.mPreferenceManager.getUFinishTimesFor1Day() + 1);
                if (this.mEndReason != 0) {
                    this.mPreferenceManager.setUStartEndTimesForId(1, this.mEndReason, this.mPreferenceManager.getUStartEndTimesForId(1, this.mEndReason) + 1);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            Map<Integer, String> map = null;
            try {
                HashMap hashMap = new HashMap();
                if (this.mStartKeyMap != null) {
                    hashMap.put("1", this.mStartKeyMap.keySet());
                    hashMap.put("2", this.mStartKeyMap.values());
                }
                hashMap.put("3", Integer.valueOf(this.mFrom));
                if (this.mCloudKeyMap != null) {
                    hashMap.put("4", this.mCloudKeyMap.keySet());
                    hashMap.put("5", this.mCloudKeyMap.values());
                }
                if (this.mUnloadPluginsList != null) {
                    hashMap.put("6", this.mUnloadPluginsList);
                }
                if (this.mDownloadPluginsList != null) {
                    hashMap.put("7", this.mDownloadPluginsList);
                }
                if (this.mUpgradeResultMap != null) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<Integer, UpgradeResult> entry : this.mUpgradeResultMap.entrySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        int intValue = entry.getKey().intValue();
                        UpgradeResult value = entry.getValue();
                        if (value != null) {
                            jSONObject2.put("1", value.networkId);
                            jSONObject2.put("0", value.resultId);
                        }
                        jSONObject.put(String.valueOf(intValue), jSONObject2);
                    }
                    hashMap.put("8", jSONObject);
                }
                map = this.loadedPluginDB.getInitSuceedPluginKeys();
                if (map != null) {
                    hashMap.put("9", map.keySet());
                    hashMap.put("10", map.values());
                }
                hashMap.put("11", Integer.valueOf(this.mEndReason));
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("12", str.replace("\n", "").replace("\t", "").replace("\r", ""));
                }
                hashMap.put("13", Integer.valueOf(this.mStartNetwork));
                hashMap.put("14", Integer.valueOf(CommonMethods.getCurrNetworkType(this.context)));
                CommonMethods.sendEventUDC(this.context, "1003129", hashMap, false);
            } catch (Throwable th2) {
                CommonMethods.handleNuLException(th2);
            }
            try {
                for (Map.Entry<Integer, List<BDModuleLoadCallback>> entry2 : sCallbackMap.entrySet()) {
                    int intValue2 = entry2.getKey().intValue();
                    List<BDModuleLoadCallback> value2 = entry2.getValue();
                    int i = 4;
                    if (map == null || !map.containsKey(Integer.valueOf(intValue2))) {
                        if (this.mUpgradeResultMap != null && this.mUpgradeResultMap.keySet().contains(Integer.valueOf(intValue2))) {
                            int i2 = this.mUpgradeResultMap.get(Integer.valueOf(intValue2)).resultId;
                            if (i2 != 2) {
                                if (i2 != 3 && i2 != 4) {
                                    if (i2 != 5) {
                                        if (i2 != 7) {
                                            if (i2 != 8) {
                                                z = false;
                                            } else {
                                                z = false;
                                            }
                                        }
                                        z = false;
                                        i = 3;
                                    } else {
                                        z = false;
                                        i = 2;
                                    }
                                    while (r2.hasNext()) {
                                    }
                                    z = true;
                                }
                                z = false;
                                i = 1;
                                while (r2.hasNext()) {
                                }
                                z = true;
                            }
                            z = false;
                            i = 6;
                            while (r2.hasNext()) {
                            }
                            z = true;
                        } else {
                            switch (this.mEndReason) {
                                case 1:
                                    if (this.mCloudKeyMap != null && !this.mCloudKeyMap.keySet().contains(Integer.valueOf(intValue2))) {
                                        z = false;
                                        i = 5;
                                        break;
                                    }
                                    z = false;
                                    break;
                                case 2:
                                    z = false;
                                    i = 8;
                                    break;
                                case 3:
                                case 4:
                                case 7:
                                    z = false;
                                    i = 1;
                                    break;
                                case 5:
                                default:
                                    z = false;
                                    break;
                                case 6:
                                    z = false;
                                    i = 7;
                                    break;
                                case 8:
                                    z = false;
                                    i = 3;
                                    break;
                                case 9:
                                case 10:
                                    z = false;
                                    i = 5;
                                    break;
                                case 11:
                                    z = false;
                                    i = 6;
                                    break;
                            }
                            for (BDModuleLoadCallback bDModuleLoadCallback : value2) {
                                if (z) {
                                    bDModuleLoadCallback.onSuccess(intValue2);
                                } else {
                                    bDModuleLoadCallback.onFailure(intValue2, i);
                                }
                            }
                            z = true;
                        }
                    }
                    i = 11;
                    while (r2.hasNext()) {
                    }
                    z = true;
                }
                sCallbackMap.clear();
                sIsRunning = false;
            } catch (Throwable th3) {
                CommonMethods.handleNuLException(th3);
            }
        }
    }

    private void handleThreadStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            try {
                long lastReportUCountTime = this.mPreferenceManager.getLastReportUCountTime();
                long currentTimeMillis = System.currentTimeMillis();
                int i = (lastReportUCountTime > 0L ? 1 : (lastReportUCountTime == 0L ? 0 : -1));
                if (i > 0 && currentTimeMillis - lastReportUCountTime > 86400000) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("1", Integer.valueOf(this.mPreferenceManager.getUStartTimesFor1Day()));
                    this.mPreferenceManager.setUStartTimesFor1Day(0);
                    JSONObject jSONObject = new JSONObject();
                    for (int i2 = 1; i2 <= 6; i2++) {
                        jSONObject.put(String.valueOf(i2), this.mPreferenceManager.getUStartEndTimesForId(0, i2));
                        this.mPreferenceManager.setUStartEndTimesForId(0, i2, 0);
                    }
                    hashMap.put("2", jSONObject);
                    hashMap.put("3", Integer.valueOf(this.mPreferenceManager.getUFinishTimesFor1Day()));
                    this.mPreferenceManager.setUFinishTimesFor1Day(0);
                    JSONObject jSONObject2 = new JSONObject();
                    for (int i3 = 1; i3 <= 11; i3++) {
                        jSONObject2.put(String.valueOf(i3), this.mPreferenceManager.getUStartEndTimesForId(1, i3));
                        this.mPreferenceManager.setUStartEndTimesForId(1, i3, 0);
                    }
                    hashMap.put("4", jSONObject2);
                    CommonMethods.sendEventUDC(this.context, "1003128", hashMap, false);
                    this.mPreferenceManager.setLastReportUCountTime(currentTimeMillis);
                } else if (i == 0) {
                    this.mPreferenceManager.setLastReportUCountTime(currentTimeMillis);
                }
            } catch (Throwable th) {
                try {
                    this.mPreferenceManager.setUStartTimesFor1Day(0);
                    this.mPreferenceManager.setUFinishTimesFor1Day(0);
                    for (int i4 = 1; i4 <= 6; i4++) {
                        this.mPreferenceManager.setUStartEndTimesForId(0, i4, 0);
                    }
                    for (int i5 = 1; i5 <= 11; i5++) {
                        this.mPreferenceManager.setUStartEndTimesForId(1, i5, 0);
                    }
                } catch (Throwable th2) {
                    CommonMethods.handleNuLException(th2);
                }
                CommonMethods.handleNuLException(th);
            }
            try {
                this.mStartKeyMap = this.loadedPluginDB.getInitSuceedPluginKeys();
                this.mPreferenceManager.setUStartTimesFor1Day(this.mPreferenceManager.getUStartTimesFor1Day() + 1);
                if (this.mFrom != 0) {
                    this.mPreferenceManager.setUStartEndTimesForId(0, this.mFrom, this.mPreferenceManager.getUStartEndTimesForId(0, this.mFrom) + 1);
                }
                this.mStartNetwork = CommonMethods.getCurrNetworkType(this.context);
            } catch (Throwable th3) {
                CommonMethods.handleNuLException(th3);
            }
        }
    }

    private void pluginUpdate(File file, ApkInfo apkInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65550, this, file, apkInfo, i) == null) {
            CommonMethods.ensureQuanxian(file.getAbsolutePath(), true);
            if (this.mPreferenceManager.isNeedBackupAPK()) {
                File file2 = new File(this.context.getFilesDir(), ".b");
                if (!file2.exists()) {
                    file2.mkdir();
                }
                File file3 = new File(file2, apkInfo.key + "-" + apkInfo.versionName);
                CommonMethods.copyFile(file, file3);
                FileDeleteObserverUtils.registerObserver(this.context, apkInfo.key, file, file3);
            }
            apkInfo.pkgPath = file.getAbsolutePath();
            String str = "before update, time=" + System.currentTimeMillis() + ", downloadAPK path:" + file.getAbsolutePath() + ", exists=" + file.exists() + ", canRead=" + file.canRead() + ", isFile=" + file.isFile() + ",length" + file.length();
            StringBuilder sb = new StringBuilder("before update, time=" + System.currentTimeMillis() + StringUtil.ARRAY_ELEMENT_SEPARATOR);
            ApkInfo pluginByID = this.loadedPluginDB.getPluginByID(apkInfo.key);
            if (pluginByID == null) {
                sb.append("apkInDB == null");
            } else {
                File file4 = new File(pluginByID.pkgPath);
                sb.append("origAPK path:" + file4.getAbsolutePath() + ", exists=" + file4.exists() + ", canRead=" + file4.canRead() + ", isFile=" + file4.isFile() + ",length" + file4.length());
            }
            boolean newCloudPluginCome = this.forHostAPP.newCloudPluginCome(apkInfo, str, sb.toString());
            this.loadedPluginDB.deletePluginByIdVersion(apkInfo.key + LocalConstant.NEXTSUFFIX, apkInfo.versionName);
            if (!newCloudPluginCome) {
                Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
                if (map == null || map.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    return;
                }
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i, 5));
                return;
            }
            int pluginDeleteStatus = this.loadedPluginDB.getPluginDeleteStatus(apkInfo.key);
            if (pluginDeleteStatus < 3 && pluginDeleteStatus != -1) {
                this.loadedPluginDB.updatePluginDeleteStatus(apkInfo.key, pluginDeleteStatus + 1);
            }
            Map<Integer, UpgradeResult> map2 = this.mUpgradeResultMap;
            if (map2 != null) {
                map2.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i, 1));
            }
        }
    }

    public void handleWork(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            this.context = context;
            this.loadedPluginDB = D.getInstance(context);
            this.mPreferenceManager = SharedPreferenceManager.getInstance(context);
            this.tmpDir = new File(context.getFilesDir(), ".tmp");
            this.forHostAPP = ForHostApp.getInstance(context);
            this.mFrom = intent.getIntExtra("from", 0);
            ThreadPoolManager.getInstance(context).executeCore(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:217:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03c4 A[Catch: all -> 0x0700, TryCatch #17 {all -> 0x0786, blocks: (B:20:0x001d, B:345:0x069a, B:347:0x069e, B:348:0x06a1, B:21:0x001e, B:23:0x0028, B:25:0x002c, B:27:0x0030, B:29:0x0034, B:31:0x0042, B:33:0x0046, B:34:0x004b, B:47:0x005f, B:49:0x0067, B:50:0x006d, B:52:0x007b, B:55:0x008a, B:57:0x008e, B:58:0x0090, B:60:0x009e, B:62:0x00a7, B:66:0x00b3, B:68:0x00bd, B:70:0x00c1, B:77:0x00d6, B:79:0x00de, B:80:0x00e6, B:82:0x00ea, B:84:0x00ee, B:86:0x00f2, B:88:0x00f6, B:93:0x0114, B:95:0x011f, B:97:0x0130, B:99:0x013d, B:101:0x0141, B:102:0x0146, B:103:0x0149, B:104:0x0150, B:96:0x012b, B:90:0x00fa, B:92:0x0106, B:105:0x0151, B:107:0x018f, B:109:0x0193, B:110:0x0197, B:111:0x019e, B:112:0x019f, B:114:0x01a3, B:115:0x01a7, B:117:0x01ad, B:119:0x01c8, B:120:0x01d1, B:122:0x01e6, B:123:0x01ea, B:125:0x01ff, B:126:0x0206, B:128:0x020c, B:130:0x0212, B:133:0x021e, B:134:0x0222, B:138:0x022e, B:142:0x023c, B:144:0x0244, B:148:0x0252, B:214:0x038d, B:215:0x0391, B:219:0x03a6, B:224:0x03b4, B:228:0x03c0, B:230:0x03c4, B:231:0x03c6, B:233:0x03ce, B:234:0x03de, B:236:0x03e6, B:240:0x03f3, B:242:0x03fb, B:244:0x0403, B:246:0x040a, B:248:0x0414, B:249:0x0422, B:251:0x0428, B:252:0x0437, B:254:0x043e, B:256:0x0459, B:257:0x046a, B:259:0x0470, B:261:0x0475, B:263:0x0485, B:265:0x048b, B:266:0x0494, B:269:0x04a0, B:270:0x04a3, B:272:0x04a7, B:274:0x04b5, B:276:0x04c4, B:278:0x04c8, B:285:0x04f7, B:275:0x04bd, B:281:0x04db, B:283:0x04e5, B:284:0x04f2, B:286:0x04fb, B:288:0x0508, B:290:0x0522, B:292:0x052c, B:293:0x0531, B:294:0x0535, B:296:0x053b, B:298:0x054b, B:300:0x054f, B:301:0x055a, B:303:0x0564, B:304:0x0580, B:306:0x0586, B:308:0x0590, B:309:0x0597, B:310:0x059a, B:311:0x05ae, B:313:0x05b4, B:315:0x05c0, B:317:0x05c8, B:321:0x05d6, B:324:0x05e0, B:326:0x05f3, B:327:0x05f6, B:329:0x0620, B:330:0x0623, B:336:0x0667, B:331:0x062b, B:333:0x063e, B:335:0x0661, B:342:0x0685, B:337:0x0672, B:339:0x0678, B:341:0x0682, B:343:0x0689, B:344:0x0699, B:361:0x06b9, B:363:0x06be, B:365:0x06c2, B:371:0x06e7, B:373:0x06eb, B:375:0x06f0, B:376:0x06f7, B:377:0x06f8, B:378:0x06ff, B:367:0x06c7, B:369:0x06d5, B:370:0x06e0, B:54:0x007f, B:220:0x03a8, B:72:0x00c5, B:349:0x06a5, B:351:0x06a9, B:353:0x06ad, B:7:0x0008, B:9:0x000c, B:13:0x0012, B:35:0x004c, B:37:0x0050, B:39:0x0054), top: B:452:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03ce A[Catch: all -> 0x0700, TryCatch #17 {all -> 0x0786, blocks: (B:20:0x001d, B:345:0x069a, B:347:0x069e, B:348:0x06a1, B:21:0x001e, B:23:0x0028, B:25:0x002c, B:27:0x0030, B:29:0x0034, B:31:0x0042, B:33:0x0046, B:34:0x004b, B:47:0x005f, B:49:0x0067, B:50:0x006d, B:52:0x007b, B:55:0x008a, B:57:0x008e, B:58:0x0090, B:60:0x009e, B:62:0x00a7, B:66:0x00b3, B:68:0x00bd, B:70:0x00c1, B:77:0x00d6, B:79:0x00de, B:80:0x00e6, B:82:0x00ea, B:84:0x00ee, B:86:0x00f2, B:88:0x00f6, B:93:0x0114, B:95:0x011f, B:97:0x0130, B:99:0x013d, B:101:0x0141, B:102:0x0146, B:103:0x0149, B:104:0x0150, B:96:0x012b, B:90:0x00fa, B:92:0x0106, B:105:0x0151, B:107:0x018f, B:109:0x0193, B:110:0x0197, B:111:0x019e, B:112:0x019f, B:114:0x01a3, B:115:0x01a7, B:117:0x01ad, B:119:0x01c8, B:120:0x01d1, B:122:0x01e6, B:123:0x01ea, B:125:0x01ff, B:126:0x0206, B:128:0x020c, B:130:0x0212, B:133:0x021e, B:134:0x0222, B:138:0x022e, B:142:0x023c, B:144:0x0244, B:148:0x0252, B:214:0x038d, B:215:0x0391, B:219:0x03a6, B:224:0x03b4, B:228:0x03c0, B:230:0x03c4, B:231:0x03c6, B:233:0x03ce, B:234:0x03de, B:236:0x03e6, B:240:0x03f3, B:242:0x03fb, B:244:0x0403, B:246:0x040a, B:248:0x0414, B:249:0x0422, B:251:0x0428, B:252:0x0437, B:254:0x043e, B:256:0x0459, B:257:0x046a, B:259:0x0470, B:261:0x0475, B:263:0x0485, B:265:0x048b, B:266:0x0494, B:269:0x04a0, B:270:0x04a3, B:272:0x04a7, B:274:0x04b5, B:276:0x04c4, B:278:0x04c8, B:285:0x04f7, B:275:0x04bd, B:281:0x04db, B:283:0x04e5, B:284:0x04f2, B:286:0x04fb, B:288:0x0508, B:290:0x0522, B:292:0x052c, B:293:0x0531, B:294:0x0535, B:296:0x053b, B:298:0x054b, B:300:0x054f, B:301:0x055a, B:303:0x0564, B:304:0x0580, B:306:0x0586, B:308:0x0590, B:309:0x0597, B:310:0x059a, B:311:0x05ae, B:313:0x05b4, B:315:0x05c0, B:317:0x05c8, B:321:0x05d6, B:324:0x05e0, B:326:0x05f3, B:327:0x05f6, B:329:0x0620, B:330:0x0623, B:336:0x0667, B:331:0x062b, B:333:0x063e, B:335:0x0661, B:342:0x0685, B:337:0x0672, B:339:0x0678, B:341:0x0682, B:343:0x0689, B:344:0x0699, B:361:0x06b9, B:363:0x06be, B:365:0x06c2, B:371:0x06e7, B:373:0x06eb, B:375:0x06f0, B:376:0x06f7, B:377:0x06f8, B:378:0x06ff, B:367:0x06c7, B:369:0x06d5, B:370:0x06e0, B:54:0x007f, B:220:0x03a8, B:72:0x00c5, B:349:0x06a5, B:351:0x06a9, B:353:0x06ad, B:7:0x0008, B:9:0x000c, B:13:0x0012, B:35:0x004c, B:37:0x0050, B:39:0x0054), top: B:452:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03e6 A[Catch: all -> 0x0700, TryCatch #17 {all -> 0x0786, blocks: (B:20:0x001d, B:345:0x069a, B:347:0x069e, B:348:0x06a1, B:21:0x001e, B:23:0x0028, B:25:0x002c, B:27:0x0030, B:29:0x0034, B:31:0x0042, B:33:0x0046, B:34:0x004b, B:47:0x005f, B:49:0x0067, B:50:0x006d, B:52:0x007b, B:55:0x008a, B:57:0x008e, B:58:0x0090, B:60:0x009e, B:62:0x00a7, B:66:0x00b3, B:68:0x00bd, B:70:0x00c1, B:77:0x00d6, B:79:0x00de, B:80:0x00e6, B:82:0x00ea, B:84:0x00ee, B:86:0x00f2, B:88:0x00f6, B:93:0x0114, B:95:0x011f, B:97:0x0130, B:99:0x013d, B:101:0x0141, B:102:0x0146, B:103:0x0149, B:104:0x0150, B:96:0x012b, B:90:0x00fa, B:92:0x0106, B:105:0x0151, B:107:0x018f, B:109:0x0193, B:110:0x0197, B:111:0x019e, B:112:0x019f, B:114:0x01a3, B:115:0x01a7, B:117:0x01ad, B:119:0x01c8, B:120:0x01d1, B:122:0x01e6, B:123:0x01ea, B:125:0x01ff, B:126:0x0206, B:128:0x020c, B:130:0x0212, B:133:0x021e, B:134:0x0222, B:138:0x022e, B:142:0x023c, B:144:0x0244, B:148:0x0252, B:214:0x038d, B:215:0x0391, B:219:0x03a6, B:224:0x03b4, B:228:0x03c0, B:230:0x03c4, B:231:0x03c6, B:233:0x03ce, B:234:0x03de, B:236:0x03e6, B:240:0x03f3, B:242:0x03fb, B:244:0x0403, B:246:0x040a, B:248:0x0414, B:249:0x0422, B:251:0x0428, B:252:0x0437, B:254:0x043e, B:256:0x0459, B:257:0x046a, B:259:0x0470, B:261:0x0475, B:263:0x0485, B:265:0x048b, B:266:0x0494, B:269:0x04a0, B:270:0x04a3, B:272:0x04a7, B:274:0x04b5, B:276:0x04c4, B:278:0x04c8, B:285:0x04f7, B:275:0x04bd, B:281:0x04db, B:283:0x04e5, B:284:0x04f2, B:286:0x04fb, B:288:0x0508, B:290:0x0522, B:292:0x052c, B:293:0x0531, B:294:0x0535, B:296:0x053b, B:298:0x054b, B:300:0x054f, B:301:0x055a, B:303:0x0564, B:304:0x0580, B:306:0x0586, B:308:0x0590, B:309:0x0597, B:310:0x059a, B:311:0x05ae, B:313:0x05b4, B:315:0x05c0, B:317:0x05c8, B:321:0x05d6, B:324:0x05e0, B:326:0x05f3, B:327:0x05f6, B:329:0x0620, B:330:0x0623, B:336:0x0667, B:331:0x062b, B:333:0x063e, B:335:0x0661, B:342:0x0685, B:337:0x0672, B:339:0x0678, B:341:0x0682, B:343:0x0689, B:344:0x0699, B:361:0x06b9, B:363:0x06be, B:365:0x06c2, B:371:0x06e7, B:373:0x06eb, B:375:0x06f0, B:376:0x06f7, B:377:0x06f8, B:378:0x06ff, B:367:0x06c7, B:369:0x06d5, B:370:0x06e0, B:54:0x007f, B:220:0x03a8, B:72:0x00c5, B:349:0x06a5, B:351:0x06a9, B:353:0x06ad, B:7:0x0008, B:9:0x000c, B:13:0x0012, B:35:0x004c, B:37:0x0050, B:39:0x0054), top: B:452:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0459 A[Catch: all -> 0x0700, TryCatch #17 {all -> 0x0786, blocks: (B:20:0x001d, B:345:0x069a, B:347:0x069e, B:348:0x06a1, B:21:0x001e, B:23:0x0028, B:25:0x002c, B:27:0x0030, B:29:0x0034, B:31:0x0042, B:33:0x0046, B:34:0x004b, B:47:0x005f, B:49:0x0067, B:50:0x006d, B:52:0x007b, B:55:0x008a, B:57:0x008e, B:58:0x0090, B:60:0x009e, B:62:0x00a7, B:66:0x00b3, B:68:0x00bd, B:70:0x00c1, B:77:0x00d6, B:79:0x00de, B:80:0x00e6, B:82:0x00ea, B:84:0x00ee, B:86:0x00f2, B:88:0x00f6, B:93:0x0114, B:95:0x011f, B:97:0x0130, B:99:0x013d, B:101:0x0141, B:102:0x0146, B:103:0x0149, B:104:0x0150, B:96:0x012b, B:90:0x00fa, B:92:0x0106, B:105:0x0151, B:107:0x018f, B:109:0x0193, B:110:0x0197, B:111:0x019e, B:112:0x019f, B:114:0x01a3, B:115:0x01a7, B:117:0x01ad, B:119:0x01c8, B:120:0x01d1, B:122:0x01e6, B:123:0x01ea, B:125:0x01ff, B:126:0x0206, B:128:0x020c, B:130:0x0212, B:133:0x021e, B:134:0x0222, B:138:0x022e, B:142:0x023c, B:144:0x0244, B:148:0x0252, B:214:0x038d, B:215:0x0391, B:219:0x03a6, B:224:0x03b4, B:228:0x03c0, B:230:0x03c4, B:231:0x03c6, B:233:0x03ce, B:234:0x03de, B:236:0x03e6, B:240:0x03f3, B:242:0x03fb, B:244:0x0403, B:246:0x040a, B:248:0x0414, B:249:0x0422, B:251:0x0428, B:252:0x0437, B:254:0x043e, B:256:0x0459, B:257:0x046a, B:259:0x0470, B:261:0x0475, B:263:0x0485, B:265:0x048b, B:266:0x0494, B:269:0x04a0, B:270:0x04a3, B:272:0x04a7, B:274:0x04b5, B:276:0x04c4, B:278:0x04c8, B:285:0x04f7, B:275:0x04bd, B:281:0x04db, B:283:0x04e5, B:284:0x04f2, B:286:0x04fb, B:288:0x0508, B:290:0x0522, B:292:0x052c, B:293:0x0531, B:294:0x0535, B:296:0x053b, B:298:0x054b, B:300:0x054f, B:301:0x055a, B:303:0x0564, B:304:0x0580, B:306:0x0586, B:308:0x0590, B:309:0x0597, B:310:0x059a, B:311:0x05ae, B:313:0x05b4, B:315:0x05c0, B:317:0x05c8, B:321:0x05d6, B:324:0x05e0, B:326:0x05f3, B:327:0x05f6, B:329:0x0620, B:330:0x0623, B:336:0x0667, B:331:0x062b, B:333:0x063e, B:335:0x0661, B:342:0x0685, B:337:0x0672, B:339:0x0678, B:341:0x0682, B:343:0x0689, B:344:0x0699, B:361:0x06b9, B:363:0x06be, B:365:0x06c2, B:371:0x06e7, B:373:0x06eb, B:375:0x06f0, B:376:0x06f7, B:377:0x06f8, B:378:0x06ff, B:367:0x06c7, B:369:0x06d5, B:370:0x06e0, B:54:0x007f, B:220:0x03a8, B:72:0x00c5, B:349:0x06a5, B:351:0x06a9, B:353:0x06ad, B:7:0x0008, B:9:0x000c, B:13:0x0012, B:35:0x004c, B:37:0x0050, B:39:0x0054), top: B:452:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0470 A[Catch: all -> 0x0700, TryCatch #17 {all -> 0x0786, blocks: (B:20:0x001d, B:345:0x069a, B:347:0x069e, B:348:0x06a1, B:21:0x001e, B:23:0x0028, B:25:0x002c, B:27:0x0030, B:29:0x0034, B:31:0x0042, B:33:0x0046, B:34:0x004b, B:47:0x005f, B:49:0x0067, B:50:0x006d, B:52:0x007b, B:55:0x008a, B:57:0x008e, B:58:0x0090, B:60:0x009e, B:62:0x00a7, B:66:0x00b3, B:68:0x00bd, B:70:0x00c1, B:77:0x00d6, B:79:0x00de, B:80:0x00e6, B:82:0x00ea, B:84:0x00ee, B:86:0x00f2, B:88:0x00f6, B:93:0x0114, B:95:0x011f, B:97:0x0130, B:99:0x013d, B:101:0x0141, B:102:0x0146, B:103:0x0149, B:104:0x0150, B:96:0x012b, B:90:0x00fa, B:92:0x0106, B:105:0x0151, B:107:0x018f, B:109:0x0193, B:110:0x0197, B:111:0x019e, B:112:0x019f, B:114:0x01a3, B:115:0x01a7, B:117:0x01ad, B:119:0x01c8, B:120:0x01d1, B:122:0x01e6, B:123:0x01ea, B:125:0x01ff, B:126:0x0206, B:128:0x020c, B:130:0x0212, B:133:0x021e, B:134:0x0222, B:138:0x022e, B:142:0x023c, B:144:0x0244, B:148:0x0252, B:214:0x038d, B:215:0x0391, B:219:0x03a6, B:224:0x03b4, B:228:0x03c0, B:230:0x03c4, B:231:0x03c6, B:233:0x03ce, B:234:0x03de, B:236:0x03e6, B:240:0x03f3, B:242:0x03fb, B:244:0x0403, B:246:0x040a, B:248:0x0414, B:249:0x0422, B:251:0x0428, B:252:0x0437, B:254:0x043e, B:256:0x0459, B:257:0x046a, B:259:0x0470, B:261:0x0475, B:263:0x0485, B:265:0x048b, B:266:0x0494, B:269:0x04a0, B:270:0x04a3, B:272:0x04a7, B:274:0x04b5, B:276:0x04c4, B:278:0x04c8, B:285:0x04f7, B:275:0x04bd, B:281:0x04db, B:283:0x04e5, B:284:0x04f2, B:286:0x04fb, B:288:0x0508, B:290:0x0522, B:292:0x052c, B:293:0x0531, B:294:0x0535, B:296:0x053b, B:298:0x054b, B:300:0x054f, B:301:0x055a, B:303:0x0564, B:304:0x0580, B:306:0x0586, B:308:0x0590, B:309:0x0597, B:310:0x059a, B:311:0x05ae, B:313:0x05b4, B:315:0x05c0, B:317:0x05c8, B:321:0x05d6, B:324:0x05e0, B:326:0x05f3, B:327:0x05f6, B:329:0x0620, B:330:0x0623, B:336:0x0667, B:331:0x062b, B:333:0x063e, B:335:0x0661, B:342:0x0685, B:337:0x0672, B:339:0x0678, B:341:0x0682, B:343:0x0689, B:344:0x0699, B:361:0x06b9, B:363:0x06be, B:365:0x06c2, B:371:0x06e7, B:373:0x06eb, B:375:0x06f0, B:376:0x06f7, B:377:0x06f8, B:378:0x06ff, B:367:0x06c7, B:369:0x06d5, B:370:0x06e0, B:54:0x007f, B:220:0x03a8, B:72:0x00c5, B:349:0x06a5, B:351:0x06a9, B:353:0x06ad, B:7:0x0008, B:9:0x000c, B:13:0x0012, B:35:0x004c, B:37:0x0050, B:39:0x0054), top: B:452:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0475 A[Catch: all -> 0x0700, TryCatch #17 {all -> 0x0786, blocks: (B:20:0x001d, B:345:0x069a, B:347:0x069e, B:348:0x06a1, B:21:0x001e, B:23:0x0028, B:25:0x002c, B:27:0x0030, B:29:0x0034, B:31:0x0042, B:33:0x0046, B:34:0x004b, B:47:0x005f, B:49:0x0067, B:50:0x006d, B:52:0x007b, B:55:0x008a, B:57:0x008e, B:58:0x0090, B:60:0x009e, B:62:0x00a7, B:66:0x00b3, B:68:0x00bd, B:70:0x00c1, B:77:0x00d6, B:79:0x00de, B:80:0x00e6, B:82:0x00ea, B:84:0x00ee, B:86:0x00f2, B:88:0x00f6, B:93:0x0114, B:95:0x011f, B:97:0x0130, B:99:0x013d, B:101:0x0141, B:102:0x0146, B:103:0x0149, B:104:0x0150, B:96:0x012b, B:90:0x00fa, B:92:0x0106, B:105:0x0151, B:107:0x018f, B:109:0x0193, B:110:0x0197, B:111:0x019e, B:112:0x019f, B:114:0x01a3, B:115:0x01a7, B:117:0x01ad, B:119:0x01c8, B:120:0x01d1, B:122:0x01e6, B:123:0x01ea, B:125:0x01ff, B:126:0x0206, B:128:0x020c, B:130:0x0212, B:133:0x021e, B:134:0x0222, B:138:0x022e, B:142:0x023c, B:144:0x0244, B:148:0x0252, B:214:0x038d, B:215:0x0391, B:219:0x03a6, B:224:0x03b4, B:228:0x03c0, B:230:0x03c4, B:231:0x03c6, B:233:0x03ce, B:234:0x03de, B:236:0x03e6, B:240:0x03f3, B:242:0x03fb, B:244:0x0403, B:246:0x040a, B:248:0x0414, B:249:0x0422, B:251:0x0428, B:252:0x0437, B:254:0x043e, B:256:0x0459, B:257:0x046a, B:259:0x0470, B:261:0x0475, B:263:0x0485, B:265:0x048b, B:266:0x0494, B:269:0x04a0, B:270:0x04a3, B:272:0x04a7, B:274:0x04b5, B:276:0x04c4, B:278:0x04c8, B:285:0x04f7, B:275:0x04bd, B:281:0x04db, B:283:0x04e5, B:284:0x04f2, B:286:0x04fb, B:288:0x0508, B:290:0x0522, B:292:0x052c, B:293:0x0531, B:294:0x0535, B:296:0x053b, B:298:0x054b, B:300:0x054f, B:301:0x055a, B:303:0x0564, B:304:0x0580, B:306:0x0586, B:308:0x0590, B:309:0x0597, B:310:0x059a, B:311:0x05ae, B:313:0x05b4, B:315:0x05c0, B:317:0x05c8, B:321:0x05d6, B:324:0x05e0, B:326:0x05f3, B:327:0x05f6, B:329:0x0620, B:330:0x0623, B:336:0x0667, B:331:0x062b, B:333:0x063e, B:335:0x0661, B:342:0x0685, B:337:0x0672, B:339:0x0678, B:341:0x0682, B:343:0x0689, B:344:0x0699, B:361:0x06b9, B:363:0x06be, B:365:0x06c2, B:371:0x06e7, B:373:0x06eb, B:375:0x06f0, B:376:0x06f7, B:377:0x06f8, B:378:0x06ff, B:367:0x06c7, B:369:0x06d5, B:370:0x06e0, B:54:0x007f, B:220:0x03a8, B:72:0x00c5, B:349:0x06a5, B:351:0x06a9, B:353:0x06ad, B:7:0x0008, B:9:0x000c, B:13:0x0012, B:35:0x004c, B:37:0x0050, B:39:0x0054), top: B:452:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04fb A[Catch: all -> 0x0700, TryCatch #17 {all -> 0x0786, blocks: (B:20:0x001d, B:345:0x069a, B:347:0x069e, B:348:0x06a1, B:21:0x001e, B:23:0x0028, B:25:0x002c, B:27:0x0030, B:29:0x0034, B:31:0x0042, B:33:0x0046, B:34:0x004b, B:47:0x005f, B:49:0x0067, B:50:0x006d, B:52:0x007b, B:55:0x008a, B:57:0x008e, B:58:0x0090, B:60:0x009e, B:62:0x00a7, B:66:0x00b3, B:68:0x00bd, B:70:0x00c1, B:77:0x00d6, B:79:0x00de, B:80:0x00e6, B:82:0x00ea, B:84:0x00ee, B:86:0x00f2, B:88:0x00f6, B:93:0x0114, B:95:0x011f, B:97:0x0130, B:99:0x013d, B:101:0x0141, B:102:0x0146, B:103:0x0149, B:104:0x0150, B:96:0x012b, B:90:0x00fa, B:92:0x0106, B:105:0x0151, B:107:0x018f, B:109:0x0193, B:110:0x0197, B:111:0x019e, B:112:0x019f, B:114:0x01a3, B:115:0x01a7, B:117:0x01ad, B:119:0x01c8, B:120:0x01d1, B:122:0x01e6, B:123:0x01ea, B:125:0x01ff, B:126:0x0206, B:128:0x020c, B:130:0x0212, B:133:0x021e, B:134:0x0222, B:138:0x022e, B:142:0x023c, B:144:0x0244, B:148:0x0252, B:214:0x038d, B:215:0x0391, B:219:0x03a6, B:224:0x03b4, B:228:0x03c0, B:230:0x03c4, B:231:0x03c6, B:233:0x03ce, B:234:0x03de, B:236:0x03e6, B:240:0x03f3, B:242:0x03fb, B:244:0x0403, B:246:0x040a, B:248:0x0414, B:249:0x0422, B:251:0x0428, B:252:0x0437, B:254:0x043e, B:256:0x0459, B:257:0x046a, B:259:0x0470, B:261:0x0475, B:263:0x0485, B:265:0x048b, B:266:0x0494, B:269:0x04a0, B:270:0x04a3, B:272:0x04a7, B:274:0x04b5, B:276:0x04c4, B:278:0x04c8, B:285:0x04f7, B:275:0x04bd, B:281:0x04db, B:283:0x04e5, B:284:0x04f2, B:286:0x04fb, B:288:0x0508, B:290:0x0522, B:292:0x052c, B:293:0x0531, B:294:0x0535, B:296:0x053b, B:298:0x054b, B:300:0x054f, B:301:0x055a, B:303:0x0564, B:304:0x0580, B:306:0x0586, B:308:0x0590, B:309:0x0597, B:310:0x059a, B:311:0x05ae, B:313:0x05b4, B:315:0x05c0, B:317:0x05c8, B:321:0x05d6, B:324:0x05e0, B:326:0x05f3, B:327:0x05f6, B:329:0x0620, B:330:0x0623, B:336:0x0667, B:331:0x062b, B:333:0x063e, B:335:0x0661, B:342:0x0685, B:337:0x0672, B:339:0x0678, B:341:0x0682, B:343:0x0689, B:344:0x0699, B:361:0x06b9, B:363:0x06be, B:365:0x06c2, B:371:0x06e7, B:373:0x06eb, B:375:0x06f0, B:376:0x06f7, B:377:0x06f8, B:378:0x06ff, B:367:0x06c7, B:369:0x06d5, B:370:0x06e0, B:54:0x007f, B:220:0x03a8, B:72:0x00c5, B:349:0x06a5, B:351:0x06a9, B:353:0x06ad, B:7:0x0008, B:9:0x000c, B:13:0x0012, B:35:0x004c, B:37:0x0050, B:39:0x0054), top: B:452:0x0008 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void run() {
        Iterator<String> it;
        ArrayList arrayList;
        List<ApkInfo> list;
        ArrayList arrayList2;
        ArrayList arrayList3;
        JSONObject jSONObject;
        PackageInfo packageInfo;
        ApkInfo apkInfo;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        boolean z;
        int indexOf;
        int indexOf2;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                try {
                    if (this.mOut) {
                        if (sOutGoing) {
                            return;
                        }
                        sOutGoing = true;
                    }
                    synchronized (U.class) {
                        handleThreadStart();
                        if (this.mFrom != 1 && this.mFrom != 2 && this.mFrom != 3 && !this.mOut && System.currentTimeMillis() - sLastCheckTime < 600000) {
                            if (this.mEndReason == 0) {
                                this.mEndReason = 2;
                                handleThreadEnd(null);
                            }
                            if (this.mOut && sOutGoing) {
                                sOutGoing = false;
                            }
                            return;
                        }
                        if (CommonMethods.isNetworkAvailable(this.context)) {
                            sLastCheckTime = System.currentTimeMillis();
                        }
                        AlarmUtil.setCheckRTSDKUpgradeAlarm(this.context, false);
                        TimeoutRunner.handleWork(this.context);
                        if (this.mFrom == 1 || this.mFrom == 3) {
                            sRetryPingTimesCount = 0;
                            sRetryDownoadHostCareApksTimesCount = 0;
                            AlarmUtil.setCheckUpdateRetryAlarm(this.context, 0, true);
                            sSetRetrmAlarm = false;
                        }
                        if (this.mFrom == 2) {
                            sSetRetrmAlarm = false;
                        }
                        boolean z2 = CommonMethods.PKGNAME_HUAWEI_INPUT.equals(this.context.getPackageName()) ? !this.mPreferenceManager.getCanConn() : false;
                        if (CommonMethods.isNetworkAvailable(this.context) && !z2) {
                            sLastCheckTime = System.currentTimeMillis();
                            if (CommonMethods.sNetWorkReceiver != null && (sMonitorNetworkWhenUpgradeNoNet || CommonMethods.sNeedCheckConnectivity)) {
                                this.context.getApplicationContext().unregisterReceiver(CommonMethods.sNetWorkReceiver);
                            }
                            sMonitorNetworkWhenUpgradeNoNet = false;
                            CommonMethods.sNeedCheckConnectivity = false;
                            if (this.mFrom != 1) {
                                this.mWholeJson = CommonMethods.requestWholeInfo(this.context);
                            }
                            if (this.mWholeJson == null) {
                                if ((this.mFrom == 1 || this.mFrom == 2 || (this.mFrom == 3 && !sSetRetrmAlarm)) && this.mPreferenceManager.getHostCarePluginKeys().size() > 0) {
                                    sSetRetrmAlarm = true;
                                    AlarmUtil.setCheckUpdateRetryAlarm(this.context, sRetryPingTimesCount, false);
                                    sRetryPingTimesCount++;
                                }
                                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                                if (CommonMethods.sNetWorkReceiver == null) {
                                    CommonMethods.sNetWorkReceiver = new MyReceiver().setOnlyNetSelf();
                                } else {
                                    CommonMethods.sNetWorkReceiver.setOnlyNetSelf();
                                }
                                CommonMethods.registerReceiver(this.context, CommonMethods.sNetWorkReceiver, intentFilter);
                                sMonitorNetworkWhenUpgradeNoNet = true;
                                if (this.mEndReason == 0) {
                                    if (CommonMethods.sRequestWholeErrorCode != 0) {
                                        this.mEndReason = CommonMethods.sRequestWholeErrorCode;
                                    } else {
                                        this.mEndReason = 4;
                                    }
                                }
                                throw new NetworkErrorException("ping faild");
                            }
                            sRetryPingTimesCount = 0;
                            this.forHostAPP.loadLocalPlugins(this.mWholeJson);
                            this.loadedPluginDB.deletePluginIfAPKNotExist();
                            this.mPreferenceManager.setRequestPluginTimes(this.mPreferenceManager.getRequestPluginTimes() + 1);
                            List<ApkInfo> allPlugins = this.loadedPluginDB.getAllPlugins();
                            ArrayList arrayList7 = new ArrayList();
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = new ArrayList();
                            ArrayList arrayList10 = new ArrayList();
                            JSONObject optJSONObject3 = this.mWholeJson.optJSONObject("5");
                            if (optJSONObject3 == null) {
                                if (this.mEndReason == 0) {
                                    this.mEndReason = 10;
                                }
                                throw new NetworkErrorException("plugin json is null");
                            }
                            if (optJSONObject3 instanceof JSONObject) {
                                Iterator<String> keys = optJSONObject3.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject(next);
                                    int optInt = optJSONObject4.optInt("l");
                                    String optString = optJSONObject4.optString("v");
                                    if (this.mCloudKeyMap != null) {
                                        this.mCloudKeyMap.put(Integer.valueOf(optInt), optString);
                                    }
                                    String optString2 = optJSONObject4.optString("u");
                                    String optString3 = optJSONObject4.optString("m");
                                    String optString4 = optJSONObject4.optString("sm");
                                    if (optString3 != null) {
                                        optString3 = optString3.toLowerCase();
                                    }
                                    JSONObject jSONObject2 = optJSONObject3;
                                    String str = optInt + optString;
                                    if (sRealtimeMd5Map == null) {
                                        sRealtimeMd5Map = new HashMap();
                                    }
                                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(optString3)) {
                                        it = keys;
                                    } else {
                                        it = keys;
                                        sRealtimeMd5Map.put(str, optString3);
                                    }
                                    if (optString4 != null) {
                                        optString4 = optString4.toLowerCase();
                                    }
                                    boolean z3 = optJSONObject4.optInt("o") == 1;
                                    ArrayList arrayList11 = arrayList7;
                                    boolean z4 = optJSONObject4.optInt("d") == 1;
                                    int optInt2 = optJSONObject4.optInt("r");
                                    if (z3) {
                                        arrayList = arrayList8;
                                        this.mPreferenceManager.setOncePluginId(optInt2);
                                    } else {
                                        arrayList = arrayList8;
                                    }
                                    if (z3 && z4) {
                                        arrayList9.add(next);
                                        optJSONObject3 = jSONObject2;
                                        keys = it;
                                        arrayList7 = arrayList11;
                                        arrayList8 = arrayList;
                                    } else {
                                        try {
                                            packageInfo = new PackageInfo();
                                            packageInfo.packageName = optJSONObject4.optString("p");
                                            packageInfo.versionName = optString;
                                            ApplicationInfo applicationInfo = new ApplicationInfo();
                                            String optString5 = optJSONObject4.optString("n");
                                            applicationInfo.className = optString5;
                                            if (TextUtils.isEmpty(optString5)) {
                                                arrayList2 = arrayList9;
                                            } else {
                                                try {
                                                    arrayList2 = arrayList9;
                                                    try {
                                                        if (applicationInfo.className.startsWith(".")) {
                                                            applicationInfo.className = next + applicationInfo.className;
                                                        }
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        list = allPlugins;
                                                        arrayList3 = arrayList10;
                                                        jSONObject = optJSONObject4;
                                                        CommonMethods.handleNuLException(th);
                                                        packageInfo = null;
                                                        JSONObject jSONObject3 = jSONObject;
                                                        apkInfo = new ApkInfo(optInt, next, optString, optString2, optString3);
                                                        apkInfo.isOnce = z3 ? 1 : 0;
                                                        apkInfo.priority = jSONObject3.getInt("pr");
                                                        apkInfo.isMem = jSONObject3.optInt("mem") == 1;
                                                        if (packageInfo != null) {
                                                        }
                                                        optJSONObject = jSONObject3.optJSONObject("e");
                                                        if (optJSONObject != null) {
                                                        }
                                                        optJSONObject2 = jSONObject3.optJSONObject("ext");
                                                        if (optJSONObject2 != null) {
                                                        }
                                                        apkInfo.signMD5 = optString4;
                                                        apkInfo.startTime = System.currentTimeMillis();
                                                        List<ApkInfo> list2 = list;
                                                        indexOf = list2.indexOf(apkInfo);
                                                        ApkInfo apkInfo2 = new ApkInfo(apkInfo);
                                                        if (!TextUtils.isEmpty(apkInfo.packageName)) {
                                                        }
                                                        indexOf2 = list2.indexOf(apkInfo2);
                                                        if (indexOf2 >= 0) {
                                                        }
                                                        if (indexOf >= 0) {
                                                        }
                                                        allPlugins = list2;
                                                        arrayList10 = arrayList6;
                                                        arrayList7 = arrayList4;
                                                        optJSONObject3 = jSONObject2;
                                                        keys = it;
                                                        arrayList9 = arrayList2;
                                                        arrayList8 = arrayList5;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    arrayList2 = arrayList9;
                                                }
                                            }
                                            applicationInfo.theme = optJSONObject4.optInt("t");
                                            packageInfo.applicationInfo = applicationInfo;
                                            JSONArray optJSONArray = optJSONObject4.optJSONArray("a");
                                            if (optJSONArray == null || optJSONArray.length() <= 0) {
                                                list = allPlugins;
                                                arrayList3 = arrayList10;
                                                jSONObject = optJSONObject4;
                                            } else {
                                                ArrayList arrayList12 = new ArrayList();
                                                jSONObject = optJSONObject4;
                                                int i = 0;
                                                while (i < optJSONArray.length()) {
                                                    try {
                                                        try {
                                                            JSONObject jSONObject4 = optJSONArray.getJSONObject(i);
                                                            if (jSONObject4 != null) {
                                                                jSONArray = optJSONArray;
                                                                try {
                                                                    ActivityInfo activityInfo = new ActivityInfo();
                                                                    arrayList3 = arrayList10;
                                                                    try {
                                                                        String optString6 = jSONObject4.optString("n");
                                                                        activityInfo.name = optString6;
                                                                        if (TextUtils.isEmpty(optString6)) {
                                                                            list = allPlugins;
                                                                        } else {
                                                                            list = allPlugins;
                                                                            try {
                                                                                if (activityInfo.name.startsWith(".")) {
                                                                                    activityInfo.name = next + activityInfo.name;
                                                                                }
                                                                            } catch (Throwable th3) {
                                                                                th = th3;
                                                                                try {
                                                                                    CommonMethods.handleNuLException(th);
                                                                                    continue;
                                                                                    i++;
                                                                                    optJSONArray = jSONArray;
                                                                                    arrayList10 = arrayList3;
                                                                                    allPlugins = list;
                                                                                } catch (Throwable th4) {
                                                                                    th = th4;
                                                                                    CommonMethods.handleNuLException(th);
                                                                                    packageInfo = null;
                                                                                    JSONObject jSONObject32 = jSONObject;
                                                                                    apkInfo = new ApkInfo(optInt, next, optString, optString2, optString3);
                                                                                    apkInfo.isOnce = z3 ? 1 : 0;
                                                                                    apkInfo.priority = jSONObject32.getInt("pr");
                                                                                    apkInfo.isMem = jSONObject32.optInt("mem") == 1;
                                                                                    if (packageInfo != null) {
                                                                                    }
                                                                                    optJSONObject = jSONObject32.optJSONObject("e");
                                                                                    if (optJSONObject != null) {
                                                                                    }
                                                                                    optJSONObject2 = jSONObject32.optJSONObject("ext");
                                                                                    if (optJSONObject2 != null) {
                                                                                    }
                                                                                    apkInfo.signMD5 = optString4;
                                                                                    apkInfo.startTime = System.currentTimeMillis();
                                                                                    List<ApkInfo> list22 = list;
                                                                                    indexOf = list22.indexOf(apkInfo);
                                                                                    ApkInfo apkInfo22 = new ApkInfo(apkInfo);
                                                                                    if (!TextUtils.isEmpty(apkInfo.packageName)) {
                                                                                    }
                                                                                    indexOf2 = list22.indexOf(apkInfo22);
                                                                                    if (indexOf2 >= 0) {
                                                                                    }
                                                                                    if (indexOf >= 0) {
                                                                                    }
                                                                                    allPlugins = list22;
                                                                                    arrayList10 = arrayList6;
                                                                                    arrayList7 = arrayList4;
                                                                                    optJSONObject3 = jSONObject2;
                                                                                    keys = it;
                                                                                    arrayList9 = arrayList2;
                                                                                    arrayList8 = arrayList5;
                                                                                }
                                                                            }
                                                                        }
                                                                        activityInfo.packageName = next;
                                                                        activityInfo.theme = jSONObject4.optInt("t");
                                                                        activityInfo.labelRes = jSONObject4.optInt("l");
                                                                        if (TextUtils.isEmpty(activityInfo.name)) {
                                                                            continue;
                                                                        } else {
                                                                            arrayList12.add(activityInfo);
                                                                            continue;
                                                                        }
                                                                    } catch (Throwable th5) {
                                                                        th = th5;
                                                                        list = allPlugins;
                                                                    }
                                                                } catch (Throwable th6) {
                                                                    th = th6;
                                                                    list = allPlugins;
                                                                    arrayList3 = arrayList10;
                                                                    CommonMethods.handleNuLException(th);
                                                                    continue;
                                                                    i++;
                                                                    optJSONArray = jSONArray;
                                                                    arrayList10 = arrayList3;
                                                                    allPlugins = list;
                                                                }
                                                            } else {
                                                                list = allPlugins;
                                                                jSONArray = optJSONArray;
                                                                arrayList3 = arrayList10;
                                                                continue;
                                                            }
                                                        } catch (Throwable th7) {
                                                            th = th7;
                                                            list = allPlugins;
                                                            jSONArray = optJSONArray;
                                                        }
                                                        i++;
                                                        optJSONArray = jSONArray;
                                                        arrayList10 = arrayList3;
                                                        allPlugins = list;
                                                    } catch (Throwable th8) {
                                                        th = th8;
                                                        list = allPlugins;
                                                        arrayList3 = arrayList10;
                                                    }
                                                }
                                                list = allPlugins;
                                                arrayList3 = arrayList10;
                                                if (arrayList12.size() > 0) {
                                                    packageInfo.activities = (ActivityInfo[]) arrayList12.toArray(new ActivityInfo[arrayList12.size()]);
                                                }
                                            }
                                        } catch (Throwable th9) {
                                            th = th9;
                                            list = allPlugins;
                                            arrayList2 = arrayList9;
                                        }
                                        JSONObject jSONObject322 = jSONObject;
                                        apkInfo = new ApkInfo(optInt, next, optString, optString2, optString3);
                                        apkInfo.isOnce = z3 ? 1 : 0;
                                        apkInfo.priority = jSONObject322.getInt("pr");
                                        apkInfo.isMem = jSONObject322.optInt("mem") == 1;
                                        if (packageInfo != null) {
                                            apkInfo.cloudPkgInfo = packageInfo;
                                        }
                                        optJSONObject = jSONObject322.optJSONObject("e");
                                        if (optJSONObject != null) {
                                            int optInt3 = optJSONObject.optInt("d");
                                            int optInt4 = optJSONObject.optInt("n");
                                            apkInfo.duration = optInt3;
                                            apkInfo.network = optInt4;
                                        }
                                        optJSONObject2 = jSONObject322.optJSONObject("ext");
                                        if (optJSONObject2 != null) {
                                            z = optJSONObject2.optInt("nl", 0) == 1;
                                            if (optJSONObject2.optInt("a") == 1) {
                                                List<Integer> hostCarePluginKeys = this.mPreferenceManager.getHostCarePluginKeys();
                                                if (hostCarePluginKeys == null) {
                                                    hostCarePluginKeys = new ArrayList<>();
                                                }
                                                if (optInt > 0 && !hostCarePluginKeys.contains(Integer.valueOf(optInt))) {
                                                    hostCarePluginKeys.add(Integer.valueOf(optInt));
                                                    int[] iArr = new int[hostCarePluginKeys.size()];
                                                    for (int i2 = 0; i2 < hostCarePluginKeys.size(); i2++) {
                                                        iArr[i2] = hostCarePluginKeys.get(i2).intValue();
                                                    }
                                                    this.mPreferenceManager.setHostCarePluginKeys(iArr);
                                                }
                                            }
                                        } else {
                                            z = false;
                                        }
                                        apkInfo.signMD5 = optString4;
                                        apkInfo.startTime = System.currentTimeMillis();
                                        List<ApkInfo> list222 = list;
                                        indexOf = list222.indexOf(apkInfo);
                                        ApkInfo apkInfo222 = new ApkInfo(apkInfo);
                                        if (!TextUtils.isEmpty(apkInfo.packageName)) {
                                            apkInfo222.packageName = new StringBuilder(apkInfo222.packageName).reverse().toString();
                                        }
                                        indexOf2 = list222.indexOf(apkInfo222);
                                        if (indexOf2 >= 0) {
                                            list222.remove(indexOf2);
                                        }
                                        if (indexOf >= 0) {
                                            ApkInfo apkInfo3 = list222.get(indexOf);
                                            if (CommonMethods.compareVersionNotEquals(apkInfo.versionName, apkInfo3.versionName)) {
                                                if (apkInfo3.priority != apkInfo.priority) {
                                                    this.loadedPluginDB.updatePriorityById(apkInfo.key, apkInfo.priority);
                                                }
                                                if (this.loadedPluginDB.isPluinWorking(apkInfo3.key)) {
                                                    arrayList5 = arrayList;
                                                    arrayList6 = arrayList3;
                                                } else {
                                                    if (z) {
                                                        apkInfo.isNextLoad = true;
                                                    }
                                                    if (ForHostApp.sSkipList != null && ForHostApp.sSkipList.contains(Integer.valueOf(apkInfo.key))) {
                                                        arrayList6 = arrayList3;
                                                        arrayList6.add(apkInfo);
                                                        arrayList5 = arrayList;
                                                    } else {
                                                        arrayList6 = arrayList3;
                                                        arrayList5 = arrayList;
                                                        arrayList5.add(apkInfo);
                                                    }
                                                    if (this.mDownloadPluginsList != null) {
                                                        this.mDownloadPluginsList.add(Integer.valueOf(apkInfo.key));
                                                    }
                                                }
                                                arrayList4 = arrayList11;
                                            } else {
                                                arrayList5 = arrayList;
                                                arrayList6 = arrayList3;
                                                if (apkInfo3.priority != apkInfo.priority) {
                                                    apkInfo3.priority = apkInfo.priority;
                                                    this.loadedPluginDB.updatePriorityById(apkInfo.key, apkInfo.priority);
                                                }
                                                arrayList4 = arrayList11;
                                                arrayList4.add(apkInfo3);
                                            }
                                            list222.remove(indexOf);
                                        } else {
                                            arrayList4 = arrayList11;
                                            arrayList5 = arrayList;
                                            arrayList6 = arrayList3;
                                            arrayList5.add(apkInfo);
                                            if (this.mDownloadPluginsList != null) {
                                                this.mDownloadPluginsList.add(Integer.valueOf(apkInfo.key));
                                            }
                                        }
                                        allPlugins = list222;
                                        arrayList10 = arrayList6;
                                        arrayList7 = arrayList4;
                                        optJSONObject3 = jSONObject2;
                                        keys = it;
                                        arrayList9 = arrayList2;
                                        arrayList8 = arrayList5;
                                    }
                                }
                            }
                            List<ApkInfo> list3 = allPlugins;
                            ArrayList arrayList13 = arrayList8;
                            ArrayList arrayList14 = arrayList9;
                            ArrayList arrayList15 = arrayList7;
                            ArrayList arrayList16 = arrayList10;
                            if (ForHostApp.sSkipList != null) {
                                ForHostApp.sSkipList.clear();
                            }
                            for (ApkInfo apkInfo4 : list3) {
                                ArrayList arrayList17 = arrayList14;
                                if (!arrayList17.contains(apkInfo4.packageName)) {
                                    if (this.mUnloadPluginsList != null) {
                                        this.mUnloadPluginsList.add(Integer.valueOf(apkInfo4.key));
                                    }
                                    this.forHostAPP.unloadPlugin(apkInfo4.packageName);
                                }
                                arrayList14 = arrayList17;
                            }
                            CommonMethods.setAliveData(this.context);
                            PluginloaderHub createSingleInstance = PluginloaderHub.createSingleInstance(this.context.getApplicationContext());
                            List<Integer> localSetPluginKeys = this.mPreferenceManager.getLocalSetPluginKeys();
                            List<Integer> hostCarePluginKeys2 = this.mPreferenceManager.getHostCarePluginKeys();
                            for (int i3 = 0; i3 < hostCarePluginKeys2.size(); i3++) {
                                if (!localSetPluginKeys.contains(hostCarePluginKeys2.get(i3))) {
                                    localSetPluginKeys.add(hostCarePluginKeys2.get(i3));
                                }
                            }
                            ArrayList arrayList18 = new ArrayList();
                            arrayList18.addAll(arrayList15);
                            arrayList18.addAll(arrayList13);
                            Collections.sort(arrayList18, new Comparator<ApkInfo>(this, localSetPluginKeys) { // from class: com.baidu.sofire.ac.U.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ U this$0;
                                public final /* synthetic */ List val$localSetIds;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, localSetPluginKeys};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$localSetIds = localSetPluginKeys;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                public int compare(ApkInfo apkInfo5, ApkInfo apkInfo6) {
                                    InterceptResult invokeLL;
                                    int i4;
                                    int i5;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, apkInfo5, apkInfo6)) == null) {
                                        if (apkInfo5.priority != -1 || apkInfo6.priority == -1) {
                                            if ((apkInfo5.priority == -1 || apkInfo6.priority != -1) && (i4 = apkInfo5.priority) >= (i5 = apkInfo6.priority)) {
                                                if (i4 > i5) {
                                                    return 1;
                                                }
                                                List list4 = this.val$localSetIds;
                                                int indexOf3 = (list4 == null || !list4.contains(Integer.valueOf(apkInfo5.key))) ? -1 : this.val$localSetIds.indexOf(Integer.valueOf(apkInfo5.key));
                                                List list5 = this.val$localSetIds;
                                                int indexOf4 = (list5 == null || !list5.contains(Integer.valueOf(apkInfo6.key))) ? -1 : this.val$localSetIds.indexOf(Integer.valueOf(apkInfo6.key));
                                                if (indexOf3 == -1 || indexOf4 != -1) {
                                                    if ((indexOf3 != -1 || indexOf4 == -1) && indexOf3 <= indexOf4) {
                                                        return indexOf3 < indexOf4 ? -1 : 0;
                                                    }
                                                    return 1;
                                                }
                                                return -1;
                                            }
                                            return -1;
                                        }
                                        return 1;
                                    }
                                    return invokeLL.intValue;
                                }
                            });
                            for (int i4 = 0; i4 < arrayList18.size(); i4++) {
                                ApkInfo apkInfo5 = (ApkInfo) arrayList18.get(i4);
                                if (arrayList15.contains(apkInfo5)) {
                                    if (createSingleInstance.getApkInfoByPackageName(apkInfo5.packageName) == null) {
                                        boolean z5 = this.loadedPluginDB.getPluginDeleteStatus(apkInfo5.key) != 3;
                                        if (this.mPreferenceManager.isNeedBackupAPK() && z5) {
                                            File file = new File(this.context.getFilesDir(), ".b");
                                            if (!file.exists()) {
                                                file.mkdir();
                                            }
                                            File file2 = new File(apkInfo5.pkgPath);
                                            File file3 = new File(file, apkInfo5.key + "-" + apkInfo5.versionName);
                                            if (!CommonMethods.isFileExist(file3)) {
                                                CommonMethods.copyFile(file2, file3);
                                            }
                                            FileDeleteObserverUtils.registerObserver(this.context, apkInfo5.key, file2, file3);
                                        } else {
                                            File file4 = new File(this.context.getFilesDir(), ".b");
                                            if (file4.exists()) {
                                                File file5 = new File(file4, apkInfo5.key + "-" + apkInfo5.versionName);
                                                if (CommonMethods.isFileExist(file5)) {
                                                    FileDeleteObserverUtils.unRegisterObserver(file5);
                                                    file5.delete();
                                                }
                                            }
                                        }
                                        this.forHostAPP.initPlugin(apkInfo5.key, apkInfo5.versionName, null);
                                    }
                                } else if (arrayList13.contains(apkInfo5) && !this.loadedPluginDB.isPluinWorking(apkInfo5.key)) {
                                    handlePluginUpgrade(apkInfo5);
                                }
                            }
                            new Timer().schedule(new TimerTask(this, arrayList16) { // from class: com.baidu.sofire.ac.U.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ U this$0;
                                public final /* synthetic */ List val$pluginNeedDelayUpdate;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, arrayList16};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i5 = newInitContext.flag;
                                        if ((i5 & 1) != 0) {
                                            int i6 = i5 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$pluginNeedDelayUpdate = arrayList16;
                                }

                                @Override // java.util.TimerTask, java.lang.Runnable
                                public void run() {
                                    List<ApkInfo> list4;
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (list4 = this.val$pluginNeedDelayUpdate) == null) {
                                        return;
                                    }
                                    for (ApkInfo apkInfo6 : list4) {
                                        this.this$0.handlePluginUpgrade(apkInfo6);
                                    }
                                }
                            }, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
                            if (this.mEndReason == 0) {
                                this.mEndReason = 1;
                            }
                            handleThreadEnd(null);
                            if (this.mOut && sOutGoing) {
                                sOutGoing = false;
                            }
                            return;
                        }
                        if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                            sMonitorNetworkWhenUpgradeNoNet = true;
                            IntentFilter intentFilter2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                            if (CommonMethods.sNetWorkReceiver == null) {
                                CommonMethods.sNetWorkReceiver = new MyReceiver().setOnlyNetSelf();
                            }
                            CommonMethods.registerReceiver(this.context, CommonMethods.sNetWorkReceiver, intentFilter2);
                        }
                        if (this.mEndReason == 0) {
                            this.mEndReason = 3;
                        }
                        if (z2) {
                            throw new NetworkErrorException("blocked by Huawei Input");
                        }
                        throw new NetworkErrorException("no internet");
                    }
                }
            }
        }
    }

    public U(Context context, int i, boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z), jSONObject};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mFrom = 0;
        this.mEndReason = 0;
        this.mOut = false;
        this.mCloudKeyMap = new HashMap();
        this.mUnloadPluginsList = new ArrayList();
        this.mDownloadPluginsList = new ArrayList();
        this.mUpgradeResultMap = new HashMap();
        this.mStartNetwork = -2;
        this.context = context;
        this.loadedPluginDB = D.getInstance(context);
        this.mPreferenceManager = SharedPreferenceManager.getInstance(context);
        this.forHostAPP = ForHostApp.getInstance(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.mFrom = i;
        this.mOut = z;
        this.mWholeJson = jSONObject;
    }

    public U() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFrom = 0;
        this.mEndReason = 0;
        this.mOut = false;
        this.mCloudKeyMap = new HashMap();
        this.mUnloadPluginsList = new ArrayList();
        this.mDownloadPluginsList = new ArrayList();
        this.mUpgradeResultMap = new HashMap();
        this.mStartNetwork = -2;
    }
}
