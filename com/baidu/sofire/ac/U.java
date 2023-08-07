package com.baidu.sofire.ac;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.a.c;
import com.baidu.sofire.b.b;
import com.baidu.sofire.b.h;
import com.baidu.sofire.c.a;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.jni.Asc;
import com.baidu.sofire.k.f;
import com.baidu.sofire.k.i;
import com.baidu.sofire.k.j;
import com.baidu.sofire.k.p;
import com.baidu.sofire.k.t;
import com.baidu.sofire.k.u;
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
    public static boolean sFinishOnce;
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
    public b forHostAPP;
    public a loadedPluginDB;
    public Map<Integer, String> mCloudKeyMap;
    public List<Integer> mDownloadPluginsList;
    public int mEndReason;
    public int mFrom;
    public boolean mOut;
    public com.baidu.sofire.j.a mPreferenceManager;
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
        sFinishOnce = false;
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
        this.loadedPluginDB = a.a(context);
        this.mPreferenceManager = com.baidu.sofire.j.a.a(context);
        this.forHostAPP = b.a(context);
        this.tmpDir = new File(new File(context.getFilesDir(), "sofire_tmp"), ".tmp");
        this.mFrom = i;
        this.mOut = z;
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
        this.loadedPluginDB = a.a(context);
        this.mPreferenceManager = com.baidu.sofire.j.a.a(context);
        this.forHostAPP = b.a(context);
        this.tmpDir = new File(new File(context.getFilesDir(), "sofire_tmp"), ".tmp");
        this.mFrom = i;
        this.mOut = z;
        this.mWholeJson = jSONObject;
    }

    public static synchronized void addCallback(int i, BDModuleLoadCallback bDModuleLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, null, i, bDModuleLoadCallback) == null) {
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

    private boolean commonDownloadFile(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, str, file)) == null) {
            try {
                if (p.a(this.context)) {
                    return new p(this.context).a(str, file);
                }
                return new i(this.context).a(str, file);
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private void handlePluginDownError(ApkInfo apkInfo, File file, int i, List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65543, this, apkInfo, file, i, list) == null) {
            Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
            if (map != null && !map.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i, 4));
            }
            int i2 = this.mFrom;
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                if (list != null && list.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                    sSetRetrmAlarm = true;
                    com.baidu.sofire.a.a.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                    sRetryDownoadHostCareApksTimesCount++;
                }
                if (!sMonitorNetworkWhenUpgradeNoNet) {
                    IntentFilter intentFilter = new IntentFilter(NetworkMonitor.NET_CHANGE_ACTION);
                    MyReceiver myReceiver = com.baidu.sofire.k.b.g;
                    if (myReceiver == null) {
                        com.baidu.sofire.k.b.g = new MyReceiver().a();
                    } else {
                        myReceiver.a();
                    }
                    com.baidu.sofire.k.b.a(this.context, com.baidu.sofire.k.b.g, intentFilter);
                    sMonitorNetworkWhenUpgradeNoNet = true;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.sofire.j.a aVar = this.mPreferenceManager;
            long j = aVar.a.getLong("pu_ap_fd", 0L);
            if (j == 0) {
                j = System.currentTimeMillis();
                aVar.b.putLong("pu_ap_fd", System.currentTimeMillis());
                aVar.b.commit();
            }
            if (currentTimeMillis - j > 86400000) {
                HashMap hashMap = new HashMap();
                if (com.baidu.sofire.k.b.l(this.context)) {
                    hashMap.put("0", Integer.valueOf(this.mPreferenceManager.i() + 1));
                    hashMap.put("1", Integer.valueOf(this.mPreferenceManager.h()));
                } else {
                    hashMap.put("0", Integer.valueOf(this.mPreferenceManager.i()));
                    hashMap.put("1", Integer.valueOf(this.mPreferenceManager.h() + 1));
                }
                this.mPreferenceManager.c(0);
                this.mPreferenceManager.b(0);
                com.baidu.sofire.j.a aVar2 = this.mPreferenceManager;
                aVar2.b.putLong("pu_ap_fd", System.currentTimeMillis());
                aVar2.b.commit();
                com.baidu.sofire.k.b.a(this.context, "1003116", (Map<String, Object>) hashMap, false);
            } else if (com.baidu.sofire.k.b.l(this.context)) {
                com.baidu.sofire.j.a aVar3 = this.mPreferenceManager;
                aVar3.c(aVar3.i() + 1);
            } else {
                com.baidu.sofire.j.a aVar4 = this.mPreferenceManager;
                aVar4.b(aVar4.h() + 1);
            }
            file.delete();
        }
    }

    private boolean handlePluginDownload(ApkInfo apkInfo, File file, File file2, int i) {
        InterceptResult invokeLLLI;
        int i2;
        Asc asc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65544, this, apkInfo, file, file2, i)) == null) {
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable unused) {
                int i3 = com.baidu.sofire.a.b.a;
            }
            if ("com.baidu.input_huawei".equals(this.context.getPackageName()) && !this.mPreferenceManager.b()) {
                return false;
            }
            boolean commonDownloadFile = commonDownloadFile(apkInfo.downloadURL, file);
            if (commonDownloadFile) {
                if (file2.exists()) {
                    file2.delete();
                }
                byte[] bytes = apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes("utf-8");
                Asc asc2 = f.a;
                if (bytes != null && bytes.length > 0 && (asc = f.a) != null) {
                    i2 = asc.df(file.getAbsolutePath(), file2.getAbsolutePath(), bytes);
                } else {
                    i2 = -1;
                }
                if (i2 != 0) {
                    Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
                    if (map != null && !map.keySet().contains(Integer.valueOf(apkInfo.key))) {
                        this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i, 7));
                    }
                    commonDownloadFile = false;
                }
            } else {
                Map<Integer, UpgradeResult> map2 = this.mUpgradeResultMap;
                if (map2 != null && !map2.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i, 4));
                }
            }
            String a = j.a(file2);
            file.delete();
            if (commonDownloadFile) {
                if (apkInfo.apkMD5.equals(a)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLLI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f3 A[Catch: all -> 0x0125, TryCatch #1 {all -> 0x0125, blocks: (B:5:0x0007, B:7:0x001c, B:9:0x0022, B:11:0x0028, B:13:0x002e, B:15:0x0039, B:16:0x0044, B:19:0x0050, B:21:0x0054, B:23:0x0064, B:25:0x0075, B:27:0x007d, B:28:0x0082, B:30:0x0093, B:31:0x0096, B:33:0x00e0, B:38:0x00f3, B:40:0x00f9, B:41:0x00fe, B:43:0x0110, B:44:0x0117, B:46:0x011b, B:51:0x0120, B:45:0x0118), top: B:85:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9 A[Catch: all -> 0x0125, TryCatch #1 {all -> 0x0125, blocks: (B:5:0x0007, B:7:0x001c, B:9:0x0022, B:11:0x0028, B:13:0x002e, B:15:0x0039, B:16:0x0044, B:19:0x0050, B:21:0x0054, B:23:0x0064, B:25:0x0075, B:27:0x007d, B:28:0x0082, B:30:0x0093, B:31:0x0096, B:33:0x00e0, B:38:0x00f3, B:40:0x00f9, B:41:0x00fe, B:43:0x0110, B:44:0x0117, B:46:0x011b, B:51:0x0120, B:45:0x0118), top: B:85:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fe A[Catch: all -> 0x0125, TryCatch #1 {all -> 0x0125, blocks: (B:5:0x0007, B:7:0x001c, B:9:0x0022, B:11:0x0028, B:13:0x002e, B:15:0x0039, B:16:0x0044, B:19:0x0050, B:21:0x0054, B:23:0x0064, B:25:0x0075, B:27:0x007d, B:28:0x0082, B:30:0x0093, B:31:0x0096, B:33:0x00e0, B:38:0x00f3, B:40:0x00f9, B:41:0x00fe, B:43:0x0110, B:44:0x0117, B:46:0x011b, B:51:0x0120, B:45:0x0118), top: B:85:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handlePluginUpgrade(ApkInfo apkInfo) {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, apkInfo) == null) {
            try {
                int d = com.baidu.sofire.k.b.d(this.context);
                List<Integer> e = this.mPreferenceManager.e();
                if (!((ArrayList) e).contains(Integer.valueOf(apkInfo.key))) {
                    Context context = this.context;
                    if (apkInfo.network == 1 && !com.baidu.sofire.k.b.l(context)) {
                        IntentFilter intentFilter = new IntentFilter(NetworkMonitor.NET_CHANGE_ACTION);
                        if (com.baidu.sofire.k.b.g == null) {
                            com.baidu.sofire.k.b.g = new MyReceiver().a();
                        }
                        com.baidu.sofire.k.b.a(context, com.baidu.sofire.k.b.g, intentFilter);
                        com.baidu.sofire.k.b.a = true;
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
                        if (map != null && !map.keySet().contains(Integer.valueOf(apkInfo.key))) {
                            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, d, 3));
                            return;
                        }
                        return;
                    }
                }
                if (!this.tmpDir.exists()) {
                    this.tmpDir.mkdirs();
                }
                File file = new File(this.tmpDir, t.a());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, apkInfo.key + "." + apkInfo.versionName + ".t");
                File file3 = new File(file, apkInfo.key + "." + apkInfo.versionName + ".p");
                if (file3.exists()) {
                    if (apkInfo.apkMD5.equals(j.a(file3))) {
                        z = false;
                        z2 = true;
                        if (z) {
                            z2 = handlePluginDownload(apkInfo, file2, file3, d);
                        }
                        if (!z2) {
                            pluginUpdate(file3, apkInfo, d);
                            return;
                        }
                        if (com.baidu.sofire.b.i.a(this.context.getApplicationContext()).b(apkInfo.packageName) == null) {
                            b bVar = this.forHostAPP;
                            int i = apkInfo.key;
                            String str = apkInfo.versionName;
                            synchronized (bVar) {
                                bVar.a(i, str, false, (PackageInfo) null);
                            }
                        }
                        handlePluginDownError(apkInfo, file3, d, e);
                        return;
                    }
                }
                z = true;
                z2 = false;
                if (z) {
                }
                if (!z2) {
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                try {
                    Map<Integer, UpgradeResult> map2 = this.mUpgradeResultMap;
                    if (map2 != null && !map2.keySet().contains(Integer.valueOf(apkInfo.key))) {
                        this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, com.baidu.sofire.k.b.d(this.context), 2));
                    }
                } catch (Throwable unused2) {
                    int i3 = com.baidu.sofire.a.b.a;
                }
                try {
                    List<Integer> e2 = this.mPreferenceManager.e();
                    int i4 = this.mFrom;
                    if (i4 == 1 || i4 == 2 || i4 == 3) {
                        if (((ArrayList) e2).contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                            sSetRetrmAlarm = true;
                            com.baidu.sofire.a.a.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                            sRetryDownoadHostCareApksTimesCount++;
                        }
                        if (!sMonitorNetworkWhenUpgradeNoNet) {
                            IntentFilter intentFilter2 = new IntentFilter(NetworkMonitor.NET_CHANGE_ACTION);
                            MyReceiver myReceiver = com.baidu.sofire.k.b.g;
                            if (myReceiver == null) {
                                com.baidu.sofire.k.b.g = new MyReceiver().a();
                            } else {
                                myReceiver.a();
                            }
                            com.baidu.sofire.k.b.a(this.context, com.baidu.sofire.k.b.g, intentFilter2);
                            sMonitorNetworkWhenUpgradeNoNet = true;
                        }
                    }
                } catch (Throwable unused3) {
                    int i5 = com.baidu.sofire.a.b.a;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01c1, code lost:
        if (r5.keySet().contains(java.lang.Integer.valueOf(r4)) == false) goto L110;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleThreadEnd(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            try {
                com.baidu.sofire.j.a aVar = this.mPreferenceManager;
                aVar.e(aVar.a.getInt("sufzfd", 0) + 1);
                int i = this.mEndReason;
                if (i != 0) {
                    com.baidu.sofire.j.a aVar2 = this.mPreferenceManager;
                    aVar2.a(1, i, aVar2.a(1, i) + 1);
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            Map<Integer, String> map = null;
            try {
                HashMap hashMap = new HashMap();
                Map<Integer, String> map2 = this.mStartKeyMap;
                if (map2 != null) {
                    hashMap.put("1", map2.keySet());
                    hashMap.put("2", this.mStartKeyMap.values());
                }
                hashMap.put("3", Integer.valueOf(this.mFrom));
                Map<Integer, String> map3 = this.mCloudKeyMap;
                if (map3 != null) {
                    hashMap.put("4", map3.keySet());
                    hashMap.put("5", this.mCloudKeyMap.values());
                }
                List<Integer> list = this.mUnloadPluginsList;
                if (list != null) {
                    hashMap.put("6", list);
                }
                List<Integer> list2 = this.mDownloadPluginsList;
                if (list2 != null) {
                    hashMap.put("7", list2);
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
                map = this.loadedPluginDB.c();
                HashMap hashMap2 = (HashMap) map;
                hashMap.put("9", hashMap2.keySet());
                hashMap.put("10", hashMap2.values());
                hashMap.put("11", Integer.valueOf(this.mEndReason));
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("12", str.replace("\n", "").replace("\t", "").replace("\r", ""));
                }
                hashMap.put("13", Integer.valueOf(this.mStartNetwork));
                hashMap.put("14", Integer.valueOf(com.baidu.sofire.k.b.d(this.context)));
                com.baidu.sofire.k.b.a(this.context, "1003129", (Map<String, Object>) hashMap, false);
            } catch (Throwable unused2) {
                int i3 = com.baidu.sofire.a.b.a;
            }
            try {
                for (Map.Entry<Integer, List<BDModuleLoadCallback>> entry2 : sCallbackMap.entrySet()) {
                    int intValue2 = entry2.getKey().intValue();
                    List<BDModuleLoadCallback> value2 = entry2.getValue();
                    int i4 = 4;
                    if (map != null && map.containsKey(Integer.valueOf(intValue2))) {
                        i4 = 11;
                        z = true;
                    } else {
                        Map<Integer, UpgradeResult> map4 = this.mUpgradeResultMap;
                        if (map4 != null && map4.keySet().contains(Integer.valueOf(intValue2))) {
                            int i5 = this.mUpgradeResultMap.get(Integer.valueOf(intValue2)).resultId;
                            if (i5 != 2) {
                                if (i5 != 3 && i5 != 4) {
                                    if (i5 != 5) {
                                        if (i5 != 7) {
                                            if (i5 != 8) {
                                                i4 = 11;
                                            }
                                        }
                                        i4 = 3;
                                    } else {
                                        i4 = 2;
                                    }
                                    z = false;
                                }
                                i4 = 1;
                                z = false;
                            }
                            i4 = 6;
                            z = false;
                        } else {
                            switch (this.mEndReason) {
                                case 1:
                                    Map<Integer, String> map5 = this.mCloudKeyMap;
                                    if (map5 != null) {
                                        break;
                                    }
                                    i4 = 11;
                                    break;
                                case 2:
                                    i4 = 8;
                                    break;
                                case 3:
                                case 4:
                                case 7:
                                    i4 = 1;
                                    break;
                                case 5:
                                default:
                                    i4 = 11;
                                    break;
                                case 6:
                                    i4 = 7;
                                    break;
                                case 8:
                                    i4 = 3;
                                    break;
                                case 9:
                                case 10:
                                    i4 = 5;
                                    break;
                                case 11:
                                    i4 = 6;
                                    break;
                            }
                            z = false;
                        }
                    }
                    for (BDModuleLoadCallback bDModuleLoadCallback : value2) {
                        if (z) {
                            bDModuleLoadCallback.onSuccess(intValue2);
                        } else {
                            bDModuleLoadCallback.onFailure(intValue2, i4);
                        }
                    }
                }
                sCallbackMap.clear();
                sIsRunning = false;
            } catch (Throwable unused3) {
                int i6 = com.baidu.sofire.a.b.a;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0101 A[Catch: all -> 0x0114, TryCatch #0 {all -> 0x0114, blocks: (B:32:0x00e9, B:34:0x0101, B:35:0x010b), top: B:42:0x00e9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleThreadStart() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            try {
                try {
                    try {
                        long j = this.mPreferenceManager.a.getLong("slruct", 0L);
                        long currentTimeMillis = System.currentTimeMillis();
                        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                        if (i2 > 0 && currentTimeMillis - j > 86400000) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("1", Integer.valueOf(this.mPreferenceManager.a.getInt("sustfd", 0)));
                            this.mPreferenceManager.f(0);
                            JSONObject jSONObject = new JSONObject();
                            for (int i3 = 1; i3 <= 6; i3++) {
                                jSONObject.put(String.valueOf(i3), this.mPreferenceManager.a(0, i3));
                                this.mPreferenceManager.a(0, i3, 0);
                            }
                            hashMap.put("2", jSONObject);
                            hashMap.put("3", Integer.valueOf(this.mPreferenceManager.a.getInt("sufzfd", 0)));
                            this.mPreferenceManager.e(0);
                            JSONObject jSONObject2 = new JSONObject();
                            for (int i4 = 1; i4 <= 11; i4++) {
                                jSONObject2.put(String.valueOf(i4), this.mPreferenceManager.a(1, i4));
                                this.mPreferenceManager.a(1, i4, 0);
                            }
                            hashMap.put("4", jSONObject2);
                            com.baidu.sofire.k.b.a(this.context, "1003128", (Map<String, Object>) hashMap, false);
                            com.baidu.sofire.j.a aVar = this.mPreferenceManager;
                            aVar.b.putLong("slruct", currentTimeMillis);
                            aVar.b.commit();
                        } else if (i2 == 0) {
                            com.baidu.sofire.j.a aVar2 = this.mPreferenceManager;
                            aVar2.b.putLong("slruct", currentTimeMillis);
                            aVar2.b.commit();
                        }
                    } catch (Throwable unused) {
                        int i5 = com.baidu.sofire.a.b.a;
                        int i6 = com.baidu.sofire.a.b.a;
                        this.mStartKeyMap = this.loadedPluginDB.c();
                        com.baidu.sofire.j.a aVar3 = this.mPreferenceManager;
                        aVar3.f(aVar3.a.getInt("sustfd", 0) + 1);
                        i = this.mFrom;
                        if (i != 0) {
                        }
                        this.mStartNetwork = com.baidu.sofire.k.b.d(this.context);
                    }
                } catch (Throwable unused2) {
                    this.mPreferenceManager.f(0);
                    this.mPreferenceManager.e(0);
                    for (int i7 = 1; i7 <= 6; i7++) {
                        this.mPreferenceManager.a(0, i7, 0);
                    }
                    for (int i8 = 1; i8 <= 11; i8++) {
                        this.mPreferenceManager.a(1, i8, 0);
                    }
                    int i62 = com.baidu.sofire.a.b.a;
                    this.mStartKeyMap = this.loadedPluginDB.c();
                    com.baidu.sofire.j.a aVar32 = this.mPreferenceManager;
                    aVar32.f(aVar32.a.getInt("sustfd", 0) + 1);
                    i = this.mFrom;
                    if (i != 0) {
                    }
                    this.mStartNetwork = com.baidu.sofire.k.b.d(this.context);
                }
                this.mStartKeyMap = this.loadedPluginDB.c();
                com.baidu.sofire.j.a aVar322 = this.mPreferenceManager;
                aVar322.f(aVar322.a.getInt("sustfd", 0) + 1);
                i = this.mFrom;
                if (i != 0) {
                    com.baidu.sofire.j.a aVar4 = this.mPreferenceManager;
                    aVar4.a(0, i, aVar4.a(0, i) + 1);
                }
                this.mStartNetwork = com.baidu.sofire.k.b.d(this.context);
            } catch (Throwable unused3) {
                int i9 = com.baidu.sofire.a.b.a;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:142:0x0555 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:151:0x0565 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:153:0x0568 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0592 A[Catch: all -> 0x05fb, TryCatch #15 {all -> 0x05fb, blocks: (B:159:0x0581, B:161:0x0592, B:162:0x059d, B:164:0x05aa, B:165:0x05b0), top: B:215:0x0581 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x05aa A[Catch: all -> 0x05fb, TryCatch #15 {all -> 0x05fb, blocks: (B:159:0x0581, B:161:0x0592, B:162:0x059d, B:164:0x05aa, B:165:0x05b0), top: B:215:0x0581 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x062d  */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.sofire.ac.U] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v36, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.baidu.sofire.b.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pluginUpdate(File file, ApkInfo apkInfo, int i) {
        Interceptable interceptable;
        String str;
        String str2;
        String str3;
        Interceptable interceptable2;
        CharSequence charSequence;
        String str4;
        File file2;
        b bVar;
        ApkInfo apkInfo2;
        com.baidu.sofire.b.i iVar;
        boolean z;
        int i2;
        File file3;
        String str5;
        b bVar2;
        CharSequence charSequence2;
        HashMap hashMap;
        CharSequence charSequence3;
        String replace;
        String str6;
        String str7;
        String str8;
        h hVar;
        Class<?> a;
        Object invoke;
        Class[] clsArr;
        int i3;
        File file4;
        Interceptable interceptable3 = $ic;
        if (interceptable3 != null) {
            interceptable = interceptable3;
            if (interceptable.invokeLLI(65548, this, file, apkInfo, i) != null) {
                return;
            }
        }
        ?? r1 = this;
        String str9 = "2";
        com.baidu.sofire.k.b.a(file.getAbsolutePath(), true);
        if (!r1.mPreferenceManager.n()) {
            str = "m";
        } else {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            StringBuilder sb = new StringBuilder();
            str = "m";
            sb.append(apkInfo.key);
            sb.append(".");
            sb.append(apkInfo.versionName);
            sb.append(".b");
            File file5 = new File(parentFile, sb.toString());
            com.baidu.sofire.a.a.a(file, file5);
            c.a(r1.context, apkInfo.key, file, file5);
        }
        apkInfo.pkgPath = file.getAbsolutePath();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("before update, time=");
        sb2.append(System.currentTimeMillis());
        sb2.append(", downloadAPK path:");
        sb2.append(file.getAbsolutePath());
        ?? r14 = ", exists=";
        sb2.append(", exists=");
        sb2.append(file.exists());
        sb2.append(", canRead=");
        sb2.append(file.canRead());
        sb2.append(", isFile=");
        String str10 = "1003106";
        sb2.append(file.isFile());
        String str11 = ",length";
        sb2.append(",length");
        sb2.append(file.length());
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder("before update, time=" + System.currentTimeMillis() + StringUtil.ARRAY_ELEMENT_SEPARATOR);
        ApkInfo b = r1.loadedPluginDB.b(apkInfo.key);
        if (b == null) {
            sb4.append("apkInDB == null");
            str2 = "3";
        } else {
            File file6 = new File(b.pkgPath);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("origAPK path:");
            sb5.append(file6.getAbsolutePath());
            sb5.append(", exists=");
            sb5.append(file6.exists());
            sb5.append(", canRead=");
            sb5.append(file6.canRead());
            sb5.append(", isFile=");
            boolean isFile = file6.isFile();
            sb5.append(isFile);
            sb5.append(",length");
            sb5.append(file6.length());
            sb4.append(sb5.toString());
            str2 = isFile;
        }
        b bVar3 = r1.forHostAPP;
        sb4.toString();
        bVar3.getClass();
        File file7 = new File(apkInfo.pkgPath);
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            str3 = "2";
            interceptable2 = "1";
            str9 = str10;
            sb3 = "\r";
            charSequence = "\t";
            str4 = "3";
            file2 = file7;
            bVar = bVar3;
        }
        if (com.baidu.sofire.k.b.a(file7)) {
            str3 = "2";
            str9 = str10;
            sb3 = "\r";
            charSequence = "\t";
            if (!bVar3.c.f(apkInfo.key)) {
                bVar3.c.a(apkInfo);
            }
            com.baidu.sofire.b.i a2 = com.baidu.sofire.b.i.a(b.e.getApplicationContext());
            a2.a(apkInfo.key, true);
            bVar3.c(apkInfo.packageName);
            try {
            } catch (Throwable th3) {
                th = th3;
            }
            if (!a2.a(apkInfo, true)) {
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("0", 2);
                    r14 = "1";
                    try {
                        hashMap2.put(r14, apkInfo.key + "");
                        hashMap2.put(str3, apkInfo.versionName);
                        com.baidu.sofire.k.b.a(b.e, str9, (Map<String, Object>) hashMap2, false);
                        c.a(file7);
                        file7.delete();
                        if (file7.getParentFile() != null) {
                            com.baidu.sofire.k.b.d(file7.getParentFile().getAbsolutePath());
                        }
                        bVar3.a(apkInfo.key, apkInfo.versionName, true, (PackageInfo) null);
                        a2.a(apkInfo.key, false);
                    } catch (Throwable th4) {
                        th = th4;
                        str10 = file7;
                        bVar = bVar3;
                        str4 = "3";
                        charSequence = charSequence;
                        str3 = str3;
                        interceptable2 = r14;
                        file2 = str10;
                        apkInfo2 = apkInfo;
                        c.a(file2);
                        bVar.c(apkInfo2.packageName);
                        file2.delete();
                        if (file2.getParentFile() != null) {
                        }
                        bVar.a(apkInfo2.key, apkInfo2.versionName, true, null);
                        iVar = com.baidu.sofire.b.i.g;
                        if (iVar != null) {
                        }
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("0", 5);
                        hashMap3.put(interceptable2, apkInfo2.key + "");
                        hashMap3.put(str3, apkInfo2.versionName);
                        hashMap3.put(str4, Base64.encodeToString(com.baidu.sofire.a.b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                        com.baidu.sofire.k.b.a(b.e, str9, (Map<String, Object>) hashMap3, false);
                        z = false;
                        if (z) {
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str10 = file7;
                    r14 = "1";
                }
            } else {
                file2 = file7;
                interceptable2 = "1";
                String str12 = "setSecurityVerifyInfo";
                String str13 = "init";
                if (TextUtils.isEmpty(apkInfo.es)) {
                    str6 = "com.baidu.sofire.engine.EngineImpl";
                } else {
                    String[] split = apkInfo.es.split("#");
                    str6 = "com.baidu.sofire.engine.EngineImpl";
                    if (split.length >= 4) {
                        if (split[1].startsWith("c")) {
                            str6 = split[1].substring(1);
                        }
                        String str14 = str;
                        if (split[2].startsWith(str14)) {
                            str12 = split[2].substring(1);
                        }
                        String str15 = str12;
                        if (split[3].startsWith(str14)) {
                            str13 = split[3].substring(1);
                        }
                        str12 = str15;
                    }
                }
                String str16 = str13;
                String str17 = str6;
                String[] o = com.baidu.sofire.k.b.o(b.e);
                try {
                    if (o.length == 2 && !TextUtils.isEmpty(o[0]) && !TextUtils.isEmpty(o[1])) {
                        str8 = o[0];
                        str7 = o[1];
                    } else {
                        str7 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                        str8 = "3";
                    }
                    apkInfo2 = a2.c.get(apkInfo.pkgPath);
                } catch (Throwable th6) {
                    th = th6;
                    str4 = "3";
                    bVar = bVar3;
                    charSequence = charSequence;
                    str3 = str3;
                    interceptable2 = interceptable2;
                    file2 = file2;
                    apkInfo2 = apkInfo;
                    c.a(file2);
                    bVar.c(apkInfo2.packageName);
                    file2.delete();
                    if (file2.getParentFile() != null) {
                    }
                    bVar.a(apkInfo2.key, apkInfo2.versionName, true, null);
                    iVar = com.baidu.sofire.b.i.g;
                    if (iVar != null) {
                    }
                    HashMap hashMap32 = new HashMap();
                    hashMap32.put("0", 5);
                    hashMap32.put(interceptable2, apkInfo2.key + "");
                    hashMap32.put(str3, apkInfo2.versionName);
                    hashMap32.put(str4, Base64.encodeToString(com.baidu.sofire.a.b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                    com.baidu.sofire.k.b.a(b.e, str9, (Map<String, Object>) hashMap32, false);
                    z = false;
                    if (z) {
                    }
                }
                if (apkInfo2 != null) {
                    try {
                        hVar = (h) apkInfo2.classLoader;
                        a = hVar.a(str17);
                    } catch (Throwable th7) {
                        th = th7;
                        str4 = "3";
                    }
                    if (a != null) {
                        str4 = "3";
                        try {
                            invoke = a.getDeclaredMethod("getInstance", Context.class).invoke(a, b.e);
                            com.baidu.sofire.k.b.a(invoke, str12, new Class[]{String.class, String.class}, str8, str7);
                            clsArr = new Class[]{Integer.TYPE, Boolean.TYPE};
                            bVar = new Object[]{0, Boolean.TRUE};
                            try {
                            } catch (Throwable th8) {
                                th = th8;
                                c.a(file2);
                                bVar.c(apkInfo2.packageName);
                                file2.delete();
                                if (file2.getParentFile() != null) {
                                }
                                bVar.a(apkInfo2.key, apkInfo2.versionName, true, null);
                                iVar = com.baidu.sofire.b.i.g;
                                if (iVar != null) {
                                }
                                HashMap hashMap322 = new HashMap();
                                hashMap322.put("0", 5);
                                hashMap322.put(interceptable2, apkInfo2.key + "");
                                hashMap322.put(str3, apkInfo2.versionName);
                                hashMap322.put(str4, Base64.encodeToString(com.baidu.sofire.a.b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                                com.baidu.sofire.k.b.a(b.e, str9, (Map<String, Object>) hashMap322, false);
                                z = false;
                                if (z) {
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            bVar = bVar3;
                            c.a(file2);
                            bVar.c(apkInfo2.packageName);
                            file2.delete();
                            if (file2.getParentFile() != null) {
                            }
                            bVar.a(apkInfo2.key, apkInfo2.versionName, true, null);
                            iVar = com.baidu.sofire.b.i.g;
                            if (iVar != null) {
                            }
                            HashMap hashMap3222 = new HashMap();
                            hashMap3222.put("0", 5);
                            hashMap3222.put(interceptable2, apkInfo2.key + "");
                            hashMap3222.put(str3, apkInfo2.versionName);
                            hashMap3222.put(str4, Base64.encodeToString(com.baidu.sofire.a.b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                            com.baidu.sofire.k.b.a(b.e, str9, (Map<String, Object>) hashMap3222, false);
                            z = false;
                            if (z) {
                            }
                        }
                        if (!((Boolean) com.baidu.sofire.k.b.a(invoke, str16, clsArr, (Object[]) bVar)).booleanValue()) {
                            c.a(file2);
                            bVar3.c(apkInfo2.packageName);
                            file2.delete();
                            if (file2.getParentFile() != null) {
                                com.baidu.sofire.k.b.d(file2.getParentFile().getAbsolutePath());
                            }
                            bVar3.a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                            a2.a(apkInfo2.key, false);
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put("0", 4);
                            hashMap4.put(interceptable2, apkInfo2.key + "");
                            hashMap4.put(str3, apkInfo2.versionName);
                            com.baidu.sofire.k.b.a(b.e, str9, (Map<String, Object>) hashMap4, false);
                        } else {
                            if (apkInfo2.isMem) {
                                c.a(file2);
                                file2.delete();
                                com.baidu.sofire.k.b.d(apkInfo2.dataDir);
                                List<Integer> list = com.baidu.sofire.b.i.j;
                                if (list != null) {
                                    list.add(Integer.valueOf(apkInfo2.key));
                                }
                            }
                            try {
                                ApkInfo b2 = bVar3.c.b(apkInfo2.key);
                                if (b2 != null && !b2.versionName.equals(apkInfo2.versionName)) {
                                    file4 = new File(b2.pkgPath);
                                    i3 = 1;
                                } else {
                                    i3 = 1;
                                    file4 = null;
                                }
                                apkInfo2.initStatus = i3;
                                apkInfo2.apkParseSuc = i3;
                                if (bVar3.c.a(apkInfo2) > 0 && file4 != null && file4.exists()) {
                                    c.a(file4);
                                    file4.delete();
                                    if (file4.getParentFile() != null) {
                                        com.baidu.sofire.k.b.d(file4.getParentFile().getAbsolutePath());
                                    }
                                }
                                com.baidu.sofire.b.i iVar2 = com.baidu.sofire.b.i.g;
                                if (iVar2 != null) {
                                    iVar2.a(apkInfo2.key, false);
                                }
                                com.baidu.sofire.k.b.p(b.e);
                                HashMap hashMap5 = new HashMap();
                                hashMap5.put("0", 0);
                                hashMap5.put(interceptable2, apkInfo2.key + "");
                                hashMap5.put(str3, apkInfo2.versionName);
                                com.baidu.sofire.k.b.a(b.e, str9, (Map<String, Object>) hashMap5, false);
                            } catch (Throwable unused) {
                                int i4 = com.baidu.sofire.a.b.a;
                            }
                            z = true;
                            if (z) {
                                Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
                                if (map != null && !map.keySet().contains(Integer.valueOf(apkInfo.key))) {
                                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i, 5));
                                    return;
                                }
                                return;
                            }
                            int c = this.loadedPluginDB.c(apkInfo.key);
                            if (c < 3 && c != -1) {
                                i2 = 1;
                                this.loadedPluginDB.b(apkInfo.key, c + 1);
                            } else {
                                i2 = 1;
                            }
                            Map<Integer, UpgradeResult> map2 = this.mUpgradeResultMap;
                            if (map2 != null) {
                                map2.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i, i2));
                                return;
                            }
                            return;
                        }
                    } else {
                        Class<?> a3 = hVar.a("java.lang.String");
                        HashMap hashMap6 = new HashMap();
                        hashMap6.put("0", 6);
                        hashMap6.put(interceptable2, apkInfo2.key + "");
                        hashMap6.put(str3, apkInfo2.versionName);
                        hashMap6.put("3", Base64.encodeToString(("classloader=" + hVar + ",StringClass=" + a3).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                        com.baidu.sofire.k.b.a(b.e, str9, (Map<String, Object>) hashMap6, false);
                        c.a(file2);
                        file2.delete();
                        if (file2.getParentFile() != null) {
                            com.baidu.sofire.k.b.d(file2.getParentFile().getAbsolutePath());
                        }
                        a2.a(apkInfo2.key, false);
                    }
                }
            }
        } else {
            try {
                hashMap = new HashMap();
                hashMap.put("0", 1);
                hashMap.put("1", apkInfo.key + "");
                hashMap.put("2", apkInfo.versionName);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("nowTime:");
                str2 = "2";
                interceptable = "1";
                try {
                    sb6.append(System.currentTimeMillis());
                    sb6.append(", nowFileInfo: path=");
                    sb6.append(file7.getAbsolutePath());
                    sb6.append(", exists=");
                    sb6.append(file7.exists());
                    sb6.append(", canRead=");
                    sb6.append(file7.canRead());
                    sb6.append(", isFile=");
                    sb6.append(file7.isFile());
                    sb6.append(",length");
                    sb6.append(file7.length());
                    sb6.append(" - ");
                    sb6.append(sb3);
                    replace = Base64.encodeToString(sb6.toString().getBytes(), 0).replace("\n", "");
                    r1 = "\t";
                    try {
                        sb3 = "\r";
                        try {
                            str11 = "3";
                        } catch (Throwable th10) {
                            th = th10;
                            str9 = str10;
                            charSequence3 = r1;
                            file3 = file7;
                            bVar2 = bVar3;
                            str4 = "3";
                            charSequence2 = charSequence3;
                            str5 = str2;
                            interceptable2 = interceptable;
                            charSequence = charSequence2;
                            bVar = bVar2;
                            str3 = str5;
                            file2 = file3;
                            apkInfo2 = apkInfo;
                            try {
                                c.a(file2);
                                bVar.c(apkInfo2.packageName);
                                file2.delete();
                                if (file2.getParentFile() != null) {
                                    com.baidu.sofire.k.b.d(file2.getParentFile().getAbsolutePath());
                                }
                                bVar.a(apkInfo2.key, apkInfo2.versionName, true, null);
                                iVar = com.baidu.sofire.b.i.g;
                                if (iVar != null) {
                                    iVar.a(apkInfo2.key, false);
                                }
                                HashMap hashMap32222 = new HashMap();
                                hashMap32222.put("0", 5);
                                hashMap32222.put(interceptable2, apkInfo2.key + "");
                                hashMap32222.put(str3, apkInfo2.versionName);
                                hashMap32222.put(str4, Base64.encodeToString(com.baidu.sofire.a.b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                            } catch (Throwable unused2) {
                            }
                            try {
                                com.baidu.sofire.k.b.a(b.e, str9, (Map<String, Object>) hashMap32222, false);
                            } catch (Throwable unused3) {
                                int i5 = com.baidu.sofire.a.b.a;
                                z = false;
                                if (z) {
                                }
                            }
                            z = false;
                            if (z) {
                            }
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        str9 = str10;
                        sb3 = "\r";
                        charSequence3 = r1;
                    }
                } catch (Throwable th12) {
                    th = th12;
                    str9 = str10;
                    sb3 = "\r";
                    charSequence3 = "\t";
                }
            } catch (Throwable th13) {
                th = th13;
                str3 = "2";
                str9 = str10;
                sb3 = "\r";
                charSequence = "\t";
                file2 = file7;
                bVar = bVar3;
                interceptable2 = "1";
                str4 = "3";
                apkInfo2 = apkInfo;
                c.a(file2);
                bVar.c(apkInfo2.packageName);
                file2.delete();
                if (file2.getParentFile() != null) {
                }
                bVar.a(apkInfo2.key, apkInfo2.versionName, true, null);
                iVar = com.baidu.sofire.b.i.g;
                if (iVar != null) {
                }
                HashMap hashMap322222 = new HashMap();
                hashMap322222.put("0", 5);
                hashMap322222.put(interceptable2, apkInfo2.key + "");
                hashMap322222.put(str3, apkInfo2.versionName);
                hashMap322222.put(str4, Base64.encodeToString(com.baidu.sofire.a.b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                com.baidu.sofire.k.b.a(b.e, str9, (Map<String, Object>) hashMap322222, false);
                z = false;
                if (z) {
                }
            }
            try {
                hashMap.put(str11, replace.replace((CharSequence) r1, "").replace(sb3, ""));
                com.baidu.sofire.k.b.a(b.e, str10, (Map<String, Object>) hashMap, false);
            } catch (Throwable th14) {
                th = th14;
                str9 = str10;
                file3 = file7;
                bVar2 = bVar3;
                str4 = str11;
                charSequence2 = r1;
                str5 = str2;
                interceptable2 = interceptable;
                charSequence = charSequence2;
                bVar = bVar2;
                str3 = str5;
                file2 = file3;
                apkInfo2 = apkInfo;
                c.a(file2);
                bVar.c(apkInfo2.packageName);
                file2.delete();
                if (file2.getParentFile() != null) {
                }
                bVar.a(apkInfo2.key, apkInfo2.versionName, true, null);
                iVar = com.baidu.sofire.b.i.g;
                if (iVar != null) {
                }
                HashMap hashMap3222222 = new HashMap();
                hashMap3222222.put("0", 5);
                hashMap3222222.put(interceptable2, apkInfo2.key + "");
                hashMap3222222.put(str3, apkInfo2.versionName);
                hashMap3222222.put(str4, Base64.encodeToString(com.baidu.sofire.a.b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                com.baidu.sofire.k.b.a(b.e, str9, (Map<String, Object>) hashMap3222222, false);
                z = false;
                if (z) {
                }
            }
        }
        z = false;
        if (z) {
        }
    }

    public void handleWork(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            this.context = context;
            this.loadedPluginDB = a.a(context);
            this.mPreferenceManager = com.baidu.sofire.j.a.a(context);
            this.tmpDir = new File(new File(context.getFilesDir(), "sofire_tmp"), ".tmp");
            this.forHostAPP = b.a(context);
            this.mFrom = intent.getIntExtra("from", 0);
            u.a(context).b(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:215:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03bf A[Catch: all -> 0x06b4, TryCatch #17 {, blocks: (B:20:0x001d, B:24:0x002b, B:26:0x002f, B:28:0x003d, B:30:0x0041, B:31:0x0046, B:42:0x0058, B:44:0x0060, B:45:0x0066, B:49:0x0081, B:51:0x0085, B:53:0x0089, B:55:0x0095, B:57:0x009e, B:61:0x00aa, B:63:0x00b4, B:65:0x00b8, B:71:0x00cc, B:73:0x00d4, B:74:0x00dc, B:76:0x00e0, B:80:0x00e8, B:87:0x0108, B:89:0x0113, B:91:0x0122, B:93:0x012f, B:95:0x0133, B:96:0x0136, B:97:0x0139, B:98:0x0141, B:90:0x011f, B:82:0x00ec, B:84:0x00f4, B:86:0x00fa, B:99:0x0142, B:101:0x017c, B:103:0x0180, B:104:0x0184, B:105:0x018c, B:106:0x018d, B:107:0x0191, B:109:0x0197, B:111:0x01b3, B:112:0x01ba, B:114:0x01d0, B:115:0x01d4, B:117:0x01e9, B:118:0x01f0, B:120:0x01f6, B:122:0x01fc, B:125:0x020c, B:126:0x0210, B:130:0x021e, B:134:0x0229, B:136:0x0236, B:140:0x0244, B:141:0x0251, B:207:0x038a, B:208:0x038e, B:213:0x03af, B:217:0x03bb, B:219:0x03bf, B:220:0x03c1, B:222:0x03c9, B:223:0x03d9, B:225:0x03e1, B:227:0x03f0, B:229:0x03f8, B:231:0x0402, B:232:0x0410, B:234:0x0416, B:235:0x0425, B:236:0x042a, B:238:0x0436, B:240:0x043c, B:242:0x044c, B:244:0x0452, B:245:0x0459, B:247:0x0463, B:249:0x0467, B:251:0x0473, B:253:0x0482, B:255:0x0486, B:262:0x04b1, B:252:0x047b, B:258:0x0497, B:260:0x04a1, B:261:0x04ac, B:263:0x04b5, B:265:0x04c2, B:267:0x04db, B:269:0x04e5, B:271:0x04ec, B:272:0x04f0, B:274:0x04f6, B:277:0x0509, B:279:0x050d, B:280:0x0516, B:281:0x051e, B:284:0x053d, B:286:0x0543, B:288:0x054a, B:290:0x0550, B:291:0x0557, B:292:0x055a, B:293:0x056e, B:295:0x0574, B:297:0x0580, B:299:0x0588, B:303:0x0596, B:306:0x05a0, B:308:0x05d3, B:309:0x05d6, B:315:0x061d, B:310:0x05de, B:312:0x05ef, B:314:0x0617, B:321:0x063b, B:316:0x0628, B:318:0x062e, B:320:0x0638, B:322:0x063f, B:323:0x064f, B:338:0x0672, B:347:0x069b, B:349:0x069f, B:351:0x06a4, B:352:0x06ab, B:353:0x06ac, B:354:0x06b3, B:343:0x067c, B:345:0x0689, B:346:0x0694, B:48:0x0076, B:67:0x00bc, B:209:0x03a2), top: B:425:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03c9 A[Catch: all -> 0x06b4, TryCatch #17 {, blocks: (B:20:0x001d, B:24:0x002b, B:26:0x002f, B:28:0x003d, B:30:0x0041, B:31:0x0046, B:42:0x0058, B:44:0x0060, B:45:0x0066, B:49:0x0081, B:51:0x0085, B:53:0x0089, B:55:0x0095, B:57:0x009e, B:61:0x00aa, B:63:0x00b4, B:65:0x00b8, B:71:0x00cc, B:73:0x00d4, B:74:0x00dc, B:76:0x00e0, B:80:0x00e8, B:87:0x0108, B:89:0x0113, B:91:0x0122, B:93:0x012f, B:95:0x0133, B:96:0x0136, B:97:0x0139, B:98:0x0141, B:90:0x011f, B:82:0x00ec, B:84:0x00f4, B:86:0x00fa, B:99:0x0142, B:101:0x017c, B:103:0x0180, B:104:0x0184, B:105:0x018c, B:106:0x018d, B:107:0x0191, B:109:0x0197, B:111:0x01b3, B:112:0x01ba, B:114:0x01d0, B:115:0x01d4, B:117:0x01e9, B:118:0x01f0, B:120:0x01f6, B:122:0x01fc, B:125:0x020c, B:126:0x0210, B:130:0x021e, B:134:0x0229, B:136:0x0236, B:140:0x0244, B:141:0x0251, B:207:0x038a, B:208:0x038e, B:213:0x03af, B:217:0x03bb, B:219:0x03bf, B:220:0x03c1, B:222:0x03c9, B:223:0x03d9, B:225:0x03e1, B:227:0x03f0, B:229:0x03f8, B:231:0x0402, B:232:0x0410, B:234:0x0416, B:235:0x0425, B:236:0x042a, B:238:0x0436, B:240:0x043c, B:242:0x044c, B:244:0x0452, B:245:0x0459, B:247:0x0463, B:249:0x0467, B:251:0x0473, B:253:0x0482, B:255:0x0486, B:262:0x04b1, B:252:0x047b, B:258:0x0497, B:260:0x04a1, B:261:0x04ac, B:263:0x04b5, B:265:0x04c2, B:267:0x04db, B:269:0x04e5, B:271:0x04ec, B:272:0x04f0, B:274:0x04f6, B:277:0x0509, B:279:0x050d, B:280:0x0516, B:281:0x051e, B:284:0x053d, B:286:0x0543, B:288:0x054a, B:290:0x0550, B:291:0x0557, B:292:0x055a, B:293:0x056e, B:295:0x0574, B:297:0x0580, B:299:0x0588, B:303:0x0596, B:306:0x05a0, B:308:0x05d3, B:309:0x05d6, B:315:0x061d, B:310:0x05de, B:312:0x05ef, B:314:0x0617, B:321:0x063b, B:316:0x0628, B:318:0x062e, B:320:0x0638, B:322:0x063f, B:323:0x064f, B:338:0x0672, B:347:0x069b, B:349:0x069f, B:351:0x06a4, B:352:0x06ab, B:353:0x06ac, B:354:0x06b3, B:343:0x067c, B:345:0x0689, B:346:0x0694, B:48:0x0076, B:67:0x00bc, B:209:0x03a2), top: B:425:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x03e1 A[Catch: all -> 0x06b4, TryCatch #17 {, blocks: (B:20:0x001d, B:24:0x002b, B:26:0x002f, B:28:0x003d, B:30:0x0041, B:31:0x0046, B:42:0x0058, B:44:0x0060, B:45:0x0066, B:49:0x0081, B:51:0x0085, B:53:0x0089, B:55:0x0095, B:57:0x009e, B:61:0x00aa, B:63:0x00b4, B:65:0x00b8, B:71:0x00cc, B:73:0x00d4, B:74:0x00dc, B:76:0x00e0, B:80:0x00e8, B:87:0x0108, B:89:0x0113, B:91:0x0122, B:93:0x012f, B:95:0x0133, B:96:0x0136, B:97:0x0139, B:98:0x0141, B:90:0x011f, B:82:0x00ec, B:84:0x00f4, B:86:0x00fa, B:99:0x0142, B:101:0x017c, B:103:0x0180, B:104:0x0184, B:105:0x018c, B:106:0x018d, B:107:0x0191, B:109:0x0197, B:111:0x01b3, B:112:0x01ba, B:114:0x01d0, B:115:0x01d4, B:117:0x01e9, B:118:0x01f0, B:120:0x01f6, B:122:0x01fc, B:125:0x020c, B:126:0x0210, B:130:0x021e, B:134:0x0229, B:136:0x0236, B:140:0x0244, B:141:0x0251, B:207:0x038a, B:208:0x038e, B:213:0x03af, B:217:0x03bb, B:219:0x03bf, B:220:0x03c1, B:222:0x03c9, B:223:0x03d9, B:225:0x03e1, B:227:0x03f0, B:229:0x03f8, B:231:0x0402, B:232:0x0410, B:234:0x0416, B:235:0x0425, B:236:0x042a, B:238:0x0436, B:240:0x043c, B:242:0x044c, B:244:0x0452, B:245:0x0459, B:247:0x0463, B:249:0x0467, B:251:0x0473, B:253:0x0482, B:255:0x0486, B:262:0x04b1, B:252:0x047b, B:258:0x0497, B:260:0x04a1, B:261:0x04ac, B:263:0x04b5, B:265:0x04c2, B:267:0x04db, B:269:0x04e5, B:271:0x04ec, B:272:0x04f0, B:274:0x04f6, B:277:0x0509, B:279:0x050d, B:280:0x0516, B:281:0x051e, B:284:0x053d, B:286:0x0543, B:288:0x054a, B:290:0x0550, B:291:0x0557, B:292:0x055a, B:293:0x056e, B:295:0x0574, B:297:0x0580, B:299:0x0588, B:303:0x0596, B:306:0x05a0, B:308:0x05d3, B:309:0x05d6, B:315:0x061d, B:310:0x05de, B:312:0x05ef, B:314:0x0617, B:321:0x063b, B:316:0x0628, B:318:0x062e, B:320:0x0638, B:322:0x063f, B:323:0x064f, B:338:0x0672, B:347:0x069b, B:349:0x069f, B:351:0x06a4, B:352:0x06ab, B:353:0x06ac, B:354:0x06b3, B:343:0x067c, B:345:0x0689, B:346:0x0694, B:48:0x0076, B:67:0x00bc, B:209:0x03a2), top: B:425:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x043c A[Catch: all -> 0x06b4, TryCatch #17 {, blocks: (B:20:0x001d, B:24:0x002b, B:26:0x002f, B:28:0x003d, B:30:0x0041, B:31:0x0046, B:42:0x0058, B:44:0x0060, B:45:0x0066, B:49:0x0081, B:51:0x0085, B:53:0x0089, B:55:0x0095, B:57:0x009e, B:61:0x00aa, B:63:0x00b4, B:65:0x00b8, B:71:0x00cc, B:73:0x00d4, B:74:0x00dc, B:76:0x00e0, B:80:0x00e8, B:87:0x0108, B:89:0x0113, B:91:0x0122, B:93:0x012f, B:95:0x0133, B:96:0x0136, B:97:0x0139, B:98:0x0141, B:90:0x011f, B:82:0x00ec, B:84:0x00f4, B:86:0x00fa, B:99:0x0142, B:101:0x017c, B:103:0x0180, B:104:0x0184, B:105:0x018c, B:106:0x018d, B:107:0x0191, B:109:0x0197, B:111:0x01b3, B:112:0x01ba, B:114:0x01d0, B:115:0x01d4, B:117:0x01e9, B:118:0x01f0, B:120:0x01f6, B:122:0x01fc, B:125:0x020c, B:126:0x0210, B:130:0x021e, B:134:0x0229, B:136:0x0236, B:140:0x0244, B:141:0x0251, B:207:0x038a, B:208:0x038e, B:213:0x03af, B:217:0x03bb, B:219:0x03bf, B:220:0x03c1, B:222:0x03c9, B:223:0x03d9, B:225:0x03e1, B:227:0x03f0, B:229:0x03f8, B:231:0x0402, B:232:0x0410, B:234:0x0416, B:235:0x0425, B:236:0x042a, B:238:0x0436, B:240:0x043c, B:242:0x044c, B:244:0x0452, B:245:0x0459, B:247:0x0463, B:249:0x0467, B:251:0x0473, B:253:0x0482, B:255:0x0486, B:262:0x04b1, B:252:0x047b, B:258:0x0497, B:260:0x04a1, B:261:0x04ac, B:263:0x04b5, B:265:0x04c2, B:267:0x04db, B:269:0x04e5, B:271:0x04ec, B:272:0x04f0, B:274:0x04f6, B:277:0x0509, B:279:0x050d, B:280:0x0516, B:281:0x051e, B:284:0x053d, B:286:0x0543, B:288:0x054a, B:290:0x0550, B:291:0x0557, B:292:0x055a, B:293:0x056e, B:295:0x0574, B:297:0x0580, B:299:0x0588, B:303:0x0596, B:306:0x05a0, B:308:0x05d3, B:309:0x05d6, B:315:0x061d, B:310:0x05de, B:312:0x05ef, B:314:0x0617, B:321:0x063b, B:316:0x0628, B:318:0x062e, B:320:0x0638, B:322:0x063f, B:323:0x064f, B:338:0x0672, B:347:0x069b, B:349:0x069f, B:351:0x06a4, B:352:0x06ab, B:353:0x06ac, B:354:0x06b3, B:343:0x067c, B:345:0x0689, B:346:0x0694, B:48:0x0076, B:67:0x00bc, B:209:0x03a2), top: B:425:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04b5 A[Catch: all -> 0x06b4, TryCatch #17 {, blocks: (B:20:0x001d, B:24:0x002b, B:26:0x002f, B:28:0x003d, B:30:0x0041, B:31:0x0046, B:42:0x0058, B:44:0x0060, B:45:0x0066, B:49:0x0081, B:51:0x0085, B:53:0x0089, B:55:0x0095, B:57:0x009e, B:61:0x00aa, B:63:0x00b4, B:65:0x00b8, B:71:0x00cc, B:73:0x00d4, B:74:0x00dc, B:76:0x00e0, B:80:0x00e8, B:87:0x0108, B:89:0x0113, B:91:0x0122, B:93:0x012f, B:95:0x0133, B:96:0x0136, B:97:0x0139, B:98:0x0141, B:90:0x011f, B:82:0x00ec, B:84:0x00f4, B:86:0x00fa, B:99:0x0142, B:101:0x017c, B:103:0x0180, B:104:0x0184, B:105:0x018c, B:106:0x018d, B:107:0x0191, B:109:0x0197, B:111:0x01b3, B:112:0x01ba, B:114:0x01d0, B:115:0x01d4, B:117:0x01e9, B:118:0x01f0, B:120:0x01f6, B:122:0x01fc, B:125:0x020c, B:126:0x0210, B:130:0x021e, B:134:0x0229, B:136:0x0236, B:140:0x0244, B:141:0x0251, B:207:0x038a, B:208:0x038e, B:213:0x03af, B:217:0x03bb, B:219:0x03bf, B:220:0x03c1, B:222:0x03c9, B:223:0x03d9, B:225:0x03e1, B:227:0x03f0, B:229:0x03f8, B:231:0x0402, B:232:0x0410, B:234:0x0416, B:235:0x0425, B:236:0x042a, B:238:0x0436, B:240:0x043c, B:242:0x044c, B:244:0x0452, B:245:0x0459, B:247:0x0463, B:249:0x0467, B:251:0x0473, B:253:0x0482, B:255:0x0486, B:262:0x04b1, B:252:0x047b, B:258:0x0497, B:260:0x04a1, B:261:0x04ac, B:263:0x04b5, B:265:0x04c2, B:267:0x04db, B:269:0x04e5, B:271:0x04ec, B:272:0x04f0, B:274:0x04f6, B:277:0x0509, B:279:0x050d, B:280:0x0516, B:281:0x051e, B:284:0x053d, B:286:0x0543, B:288:0x054a, B:290:0x0550, B:291:0x0557, B:292:0x055a, B:293:0x056e, B:295:0x0574, B:297:0x0580, B:299:0x0588, B:303:0x0596, B:306:0x05a0, B:308:0x05d3, B:309:0x05d6, B:315:0x061d, B:310:0x05de, B:312:0x05ef, B:314:0x0617, B:321:0x063b, B:316:0x0628, B:318:0x062e, B:320:0x0638, B:322:0x063f, B:323:0x064f, B:338:0x0672, B:347:0x069b, B:349:0x069f, B:351:0x06a4, B:352:0x06ab, B:353:0x06ac, B:354:0x06b3, B:343:0x067c, B:345:0x0689, B:346:0x0694, B:48:0x0076, B:67:0x00bc, B:209:0x03a2), top: B:425:0x001d }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void run() {
        boolean z;
        boolean z2;
        JSONObject jSONObject;
        String str;
        int i;
        boolean z3;
        ArrayList arrayList;
        List<ApkInfo> list;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        JSONObject jSONObject2;
        PackageInfo packageInfo;
        JSONObject jSONObject3;
        boolean z4;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        int indexOf;
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
                        int i2 = this.mFrom;
                        if (i2 != 1 && i2 != 2 && i2 != 3 && !this.mOut && System.currentTimeMillis() - sLastCheckTime < 600000) {
                            if (this.mEndReason == 0) {
                                this.mEndReason = 2;
                                handleThreadEnd(null);
                            }
                            if (this.mOut && sOutGoing) {
                                sOutGoing = false;
                            }
                            return;
                        }
                        if (com.baidu.sofire.k.b.k(this.context)) {
                            sLastCheckTime = System.currentTimeMillis();
                        }
                        com.baidu.sofire.a.a.a(this.context, false);
                        com.baidu.sofire.a.a.a(this.context);
                        int i3 = this.mFrom;
                        if (i3 == 1 || i3 == 3) {
                            sRetryPingTimesCount = 0;
                            sRetryDownoadHostCareApksTimesCount = 0;
                            com.baidu.sofire.a.a.a(this.context, 0, true);
                            sSetRetrmAlarm = false;
                        }
                        if (this.mFrom == 2) {
                            sSetRetrmAlarm = false;
                        }
                        boolean z5 = "com.baidu.input_huawei".equals(this.context.getPackageName()) ? !this.mPreferenceManager.b() : false;
                        if (com.baidu.sofire.k.b.k(this.context) && !z5) {
                            sLastCheckTime = System.currentTimeMillis();
                            if (com.baidu.sofire.k.b.g != null && (sMonitorNetworkWhenUpgradeNoNet || com.baidu.sofire.k.b.a)) {
                                this.context.getApplicationContext().unregisterReceiver(com.baidu.sofire.k.b.g);
                            }
                            sMonitorNetworkWhenUpgradeNoNet = false;
                            com.baidu.sofire.k.b.a = false;
                            if (this.mFrom != 1) {
                                this.mWholeJson = com.baidu.sofire.k.b.n(this.context);
                            }
                            JSONObject jSONObject4 = this.mWholeJson;
                            if (jSONObject4 == null) {
                                int i4 = this.mFrom;
                                if ((i4 == 1 || i4 == 2 || (i4 == 3 && !sSetRetrmAlarm)) && ((ArrayList) this.mPreferenceManager.e()).size() > 0) {
                                    sSetRetrmAlarm = true;
                                    com.baidu.sofire.a.a.a(this.context, sRetryPingTimesCount, false);
                                    sRetryPingTimesCount++;
                                }
                                IntentFilter intentFilter = new IntentFilter(NetworkMonitor.NET_CHANGE_ACTION);
                                MyReceiver myReceiver = com.baidu.sofire.k.b.g;
                                if (myReceiver == null) {
                                    com.baidu.sofire.k.b.g = new MyReceiver().a();
                                } else {
                                    myReceiver.a();
                                }
                                com.baidu.sofire.k.b.a(this.context, com.baidu.sofire.k.b.g, intentFilter);
                                sMonitorNetworkWhenUpgradeNoNet = true;
                                if (this.mEndReason == 0) {
                                    int i5 = com.baidu.sofire.k.b.d;
                                    if (i5 != 0) {
                                        this.mEndReason = i5;
                                    } else {
                                        this.mEndReason = 4;
                                    }
                                }
                                throw new NetworkErrorException("ping faild");
                            }
                            sRetryPingTimesCount = 0;
                            this.forHostAPP.a(jSONObject4);
                            this.loadedPluginDB.a();
                            com.baidu.sofire.j.a aVar = this.mPreferenceManager;
                            aVar.d(aVar.m() + 1);
                            List<ApkInfo> b = this.loadedPluginDB.b();
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
                            Iterator<String> keys = optJSONObject3.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                JSONObject optJSONObject4 = optJSONObject3.optJSONObject(next);
                                int optInt = optJSONObject4.optInt("l");
                                String optString = optJSONObject4.optString("v");
                                Map<Integer, String> map = this.mCloudKeyMap;
                                if (map != null) {
                                    map.put(Integer.valueOf(optInt), optString);
                                }
                                String optString2 = optJSONObject4.optString("u");
                                String optString3 = optJSONObject4.optString("m");
                                String optString4 = optJSONObject4.optString("sm");
                                if (optString3 != null) {
                                    optString3 = optString3.toLowerCase();
                                }
                                String str2 = optString3;
                                String str3 = optInt + optString;
                                if (sRealtimeMd5Map == null) {
                                    sRealtimeMd5Map = new HashMap();
                                }
                                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                                    jSONObject = optJSONObject3;
                                    str = str2;
                                    sRealtimeMd5Map.put(str3, str);
                                } else {
                                    jSONObject = optJSONObject3;
                                    str = str2;
                                }
                                if (optString4 != null) {
                                    optString4 = optString4.toLowerCase();
                                }
                                if (optJSONObject4.optInt("o") == 1) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                if (optJSONObject4.optInt("d") == 1) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                int optInt2 = optJSONObject4.optInt("r");
                                Iterator<String> it = keys;
                                int i6 = i;
                                if (i6 != 0) {
                                    arrayList = arrayList7;
                                    this.mPreferenceManager.a(optInt2);
                                } else {
                                    arrayList = arrayList7;
                                }
                                if (i6 != 0 && z3) {
                                    arrayList9.add(next);
                                    list = b;
                                    arrayList5 = arrayList8;
                                    arrayList3 = arrayList9;
                                    arrayList6 = arrayList10;
                                    arrayList7 = arrayList;
                                } else {
                                    String optString5 = optJSONObject4.optString("es");
                                    try {
                                        packageInfo = new PackageInfo();
                                        packageInfo.packageName = optJSONObject4.optString("p");
                                        packageInfo.versionName = optString;
                                        ApplicationInfo applicationInfo = new ApplicationInfo();
                                        arrayList3 = arrayList9;
                                        try {
                                            String optString6 = optJSONObject4.optString("n");
                                            applicationInfo.className = optString6;
                                            if (!TextUtils.isEmpty(optString6)) {
                                                try {
                                                    arrayList2 = arrayList8;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    arrayList2 = arrayList8;
                                                }
                                                try {
                                                    if (applicationInfo.className.startsWith(".")) {
                                                        applicationInfo.className = next + applicationInfo.className;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    list = b;
                                                    arrayList4 = arrayList10;
                                                    jSONObject2 = optJSONObject4;
                                                    com.baidu.sofire.k.b.a(th);
                                                    packageInfo = null;
                                                    jSONObject3 = jSONObject2;
                                                    ApkInfo apkInfo = new ApkInfo(optInt, next, optString, optString2, str);
                                                    apkInfo.isOnce = i6;
                                                    apkInfo.es = optString5;
                                                    apkInfo.priority = jSONObject3.getInt("pr");
                                                    if (jSONObject3.optInt("mem") == 1) {
                                                    }
                                                    apkInfo.isMem = z4;
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
                                                    ArrayList arrayList11 = (ArrayList) list;
                                                    indexOf = arrayList11.indexOf(apkInfo);
                                                    if (indexOf >= 0) {
                                                    }
                                                    arrayList10 = arrayList6;
                                                    arrayList8 = arrayList5;
                                                    optJSONObject3 = jSONObject;
                                                    keys = it;
                                                    arrayList9 = arrayList3;
                                                    b = list;
                                                }
                                            } else {
                                                arrayList2 = arrayList8;
                                            }
                                            applicationInfo.theme = optJSONObject4.optInt("t");
                                            packageInfo.applicationInfo = applicationInfo;
                                            JSONArray optJSONArray = optJSONObject4.optJSONArray("a");
                                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                                ArrayList arrayList12 = new ArrayList();
                                                jSONObject2 = optJSONObject4;
                                                int i7 = 0;
                                                while (i7 < optJSONArray.length()) {
                                                    try {
                                                        try {
                                                            JSONObject jSONObject5 = optJSONArray.getJSONObject(i7);
                                                            if (jSONObject5 != null) {
                                                                jSONArray = optJSONArray;
                                                                try {
                                                                    ActivityInfo activityInfo = new ActivityInfo();
                                                                    arrayList4 = arrayList10;
                                                                    try {
                                                                        String optString7 = jSONObject5.optString("n");
                                                                        activityInfo.name = optString7;
                                                                        if (!TextUtils.isEmpty(optString7)) {
                                                                            list = b;
                                                                            try {
                                                                                if (activityInfo.name.startsWith(".")) {
                                                                                    activityInfo.name = next + activityInfo.name;
                                                                                }
                                                                            } catch (Throwable th3) {
                                                                                th = th3;
                                                                                try {
                                                                                    com.baidu.sofire.k.b.a(th);
                                                                                    continue;
                                                                                    i7++;
                                                                                    optJSONArray = jSONArray;
                                                                                    arrayList10 = arrayList4;
                                                                                    b = list;
                                                                                } catch (Throwable th4) {
                                                                                    th = th4;
                                                                                    com.baidu.sofire.k.b.a(th);
                                                                                    packageInfo = null;
                                                                                    jSONObject3 = jSONObject2;
                                                                                    ApkInfo apkInfo2 = new ApkInfo(optInt, next, optString, optString2, str);
                                                                                    apkInfo2.isOnce = i6;
                                                                                    apkInfo2.es = optString5;
                                                                                    apkInfo2.priority = jSONObject3.getInt("pr");
                                                                                    if (jSONObject3.optInt("mem") == 1) {
                                                                                    }
                                                                                    apkInfo2.isMem = z4;
                                                                                    if (packageInfo != null) {
                                                                                    }
                                                                                    optJSONObject = jSONObject3.optJSONObject("e");
                                                                                    if (optJSONObject != null) {
                                                                                    }
                                                                                    optJSONObject2 = jSONObject3.optJSONObject("ext");
                                                                                    if (optJSONObject2 != null) {
                                                                                    }
                                                                                    apkInfo2.signMD5 = optString4;
                                                                                    apkInfo2.startTime = System.currentTimeMillis();
                                                                                    ArrayList arrayList112 = (ArrayList) list;
                                                                                    indexOf = arrayList112.indexOf(apkInfo2);
                                                                                    if (indexOf >= 0) {
                                                                                    }
                                                                                    arrayList10 = arrayList6;
                                                                                    arrayList8 = arrayList5;
                                                                                    optJSONObject3 = jSONObject;
                                                                                    keys = it;
                                                                                    arrayList9 = arrayList3;
                                                                                    b = list;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            list = b;
                                                                        }
                                                                        activityInfo.packageName = next;
                                                                        activityInfo.theme = jSONObject5.optInt("t");
                                                                        activityInfo.labelRes = jSONObject5.optInt("l");
                                                                        if (TextUtils.isEmpty(activityInfo.name)) {
                                                                            continue;
                                                                        } else {
                                                                            arrayList12.add(activityInfo);
                                                                            continue;
                                                                        }
                                                                    } catch (Throwable th5) {
                                                                        th = th5;
                                                                        list = b;
                                                                    }
                                                                } catch (Throwable th6) {
                                                                    th = th6;
                                                                    list = b;
                                                                    arrayList4 = arrayList10;
                                                                    com.baidu.sofire.k.b.a(th);
                                                                    continue;
                                                                    i7++;
                                                                    optJSONArray = jSONArray;
                                                                    arrayList10 = arrayList4;
                                                                    b = list;
                                                                }
                                                            } else {
                                                                list = b;
                                                                jSONArray = optJSONArray;
                                                                arrayList4 = arrayList10;
                                                                continue;
                                                            }
                                                        } catch (Throwable th7) {
                                                            th = th7;
                                                            list = b;
                                                            jSONArray = optJSONArray;
                                                        }
                                                        i7++;
                                                        optJSONArray = jSONArray;
                                                        arrayList10 = arrayList4;
                                                        b = list;
                                                    } catch (Throwable th8) {
                                                        th = th8;
                                                        list = b;
                                                        arrayList4 = arrayList10;
                                                    }
                                                }
                                                list = b;
                                                arrayList4 = arrayList10;
                                                if (arrayList12.size() > 0) {
                                                    packageInfo.activities = (ActivityInfo[]) arrayList12.toArray(new ActivityInfo[arrayList12.size()]);
                                                }
                                            } else {
                                                list = b;
                                                arrayList4 = arrayList10;
                                                jSONObject2 = optJSONObject4;
                                            }
                                        } catch (Throwable th9) {
                                            th = th9;
                                            list = b;
                                            arrayList2 = arrayList8;
                                        }
                                    } catch (Throwable th10) {
                                        th = th10;
                                        list = b;
                                        arrayList2 = arrayList8;
                                        arrayList3 = arrayList9;
                                    }
                                    jSONObject3 = jSONObject2;
                                    ApkInfo apkInfo22 = new ApkInfo(optInt, next, optString, optString2, str);
                                    apkInfo22.isOnce = i6;
                                    apkInfo22.es = optString5;
                                    apkInfo22.priority = jSONObject3.getInt("pr");
                                    if (jSONObject3.optInt("mem") == 1) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    apkInfo22.isMem = z4;
                                    if (packageInfo != null) {
                                        apkInfo22.cloudPkgInfo = packageInfo;
                                    }
                                    optJSONObject = jSONObject3.optJSONObject("e");
                                    if (optJSONObject != null) {
                                        int optInt3 = optJSONObject.optInt("d");
                                        int optInt4 = optJSONObject.optInt("n");
                                        apkInfo22.duration = optInt3;
                                        apkInfo22.network = optInt4;
                                    }
                                    optJSONObject2 = jSONObject3.optJSONObject("ext");
                                    if (optJSONObject2 != null) {
                                        optJSONObject2.optInt("nl", 0);
                                        if (optJSONObject2.optInt("a") == 1) {
                                            List<Integer> e = this.mPreferenceManager.e();
                                            if (optInt > 0 && !e.contains(Integer.valueOf(optInt))) {
                                                e.add(Integer.valueOf(optInt));
                                                int[] iArr = new int[e.size()];
                                                for (int i8 = 0; i8 < e.size(); i8++) {
                                                    iArr[i8] = e.get(i8).intValue();
                                                }
                                                this.mPreferenceManager.a(iArr);
                                            }
                                        }
                                    }
                                    apkInfo22.signMD5 = optString4;
                                    apkInfo22.startTime = System.currentTimeMillis();
                                    ArrayList arrayList1122 = (ArrayList) list;
                                    indexOf = arrayList1122.indexOf(apkInfo22);
                                    if (indexOf >= 0) {
                                        ApkInfo apkInfo3 = (ApkInfo) arrayList1122.get(indexOf);
                                        if (com.baidu.sofire.k.b.b(apkInfo22.versionName, apkInfo3.versionName)) {
                                            int i9 = apkInfo3.priority;
                                            int i10 = apkInfo22.priority;
                                            if (i9 != i10) {
                                                this.loadedPluginDB.d(apkInfo22.key, i10);
                                            }
                                            if (!this.loadedPluginDB.e(apkInfo3.key)) {
                                                List<Integer> list2 = b.g;
                                                if (list2 != null && list2.contains(Integer.valueOf(apkInfo22.key))) {
                                                    arrayList6 = arrayList4;
                                                    arrayList6.add(apkInfo22);
                                                    arrayList5 = arrayList2;
                                                } else {
                                                    arrayList6 = arrayList4;
                                                    arrayList5 = arrayList2;
                                                    arrayList5.add(apkInfo22);
                                                }
                                                List<Integer> list3 = this.mDownloadPluginsList;
                                                if (list3 != null) {
                                                    list3.add(Integer.valueOf(apkInfo22.key));
                                                }
                                            } else {
                                                arrayList5 = arrayList2;
                                                arrayList6 = arrayList4;
                                            }
                                            arrayList7 = arrayList;
                                        } else {
                                            arrayList5 = arrayList2;
                                            arrayList6 = arrayList4;
                                            int i11 = apkInfo3.priority;
                                            int i12 = apkInfo22.priority;
                                            if (i11 != i12) {
                                                apkInfo3.priority = i12;
                                                this.loadedPluginDB.d(apkInfo22.key, apkInfo22.priority);
                                            }
                                            arrayList7 = arrayList;
                                            arrayList7.add(apkInfo3);
                                        }
                                        arrayList1122.remove(indexOf);
                                    } else {
                                        arrayList7 = arrayList;
                                        arrayList5 = arrayList2;
                                        arrayList6 = arrayList4;
                                        arrayList5.add(apkInfo22);
                                        List<Integer> list4 = this.mDownloadPluginsList;
                                        if (list4 != null) {
                                            list4.add(Integer.valueOf(apkInfo22.key));
                                        }
                                    }
                                }
                                arrayList10 = arrayList6;
                                arrayList8 = arrayList5;
                                optJSONObject3 = jSONObject;
                                keys = it;
                                arrayList9 = arrayList3;
                                b = list;
                            }
                            List<ApkInfo> list5 = b;
                            ArrayList arrayList13 = arrayList8;
                            ArrayList arrayList14 = arrayList9;
                            ArrayList arrayList15 = arrayList10;
                            List<Integer> list6 = b.g;
                            if (list6 != null) {
                                list6.clear();
                            }
                            Iterator it2 = ((ArrayList) list5).iterator();
                            while (it2.hasNext()) {
                                ApkInfo apkInfo4 = (ApkInfo) it2.next();
                                ArrayList arrayList16 = arrayList14;
                                if (!arrayList16.contains(apkInfo4.packageName)) {
                                    List<Integer> list7 = this.mUnloadPluginsList;
                                    if (list7 != null) {
                                        list7.add(Integer.valueOf(apkInfo4.key));
                                    }
                                    this.forHostAPP.b(apkInfo4.packageName);
                                }
                                arrayList14 = arrayList16;
                            }
                            com.baidu.sofire.k.b.p(this.context);
                            com.baidu.sofire.b.i a = com.baidu.sofire.b.i.a(this.context.getApplicationContext());
                            List<Integer> f = this.mPreferenceManager.f();
                            List<Integer> e2 = this.mPreferenceManager.e();
                            int i13 = 0;
                            while (true) {
                                ArrayList arrayList17 = (ArrayList) e2;
                                if (i13 >= arrayList17.size()) {
                                    break;
                                }
                                ArrayList arrayList18 = (ArrayList) f;
                                if (!arrayList18.contains(arrayList17.get(i13))) {
                                    arrayList18.add(arrayList17.get(i13));
                                }
                                i13++;
                            }
                            ArrayList arrayList19 = new ArrayList();
                            arrayList19.addAll(arrayList7);
                            arrayList19.addAll(arrayList13);
                            Collections.sort(arrayList19, new Comparator<ApkInfo>(this, f) { // from class: com.baidu.sofire.ac.U.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ U this$0;
                                public final /* synthetic */ List val$localSetIds;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, f};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i14 = newInitContext.flag;
                                        if ((i14 & 1) != 0) {
                                            int i15 = i14 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$localSetIds = f;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                public int compare(ApkInfo apkInfo5, ApkInfo apkInfo6) {
                                    InterceptResult invokeLL;
                                    int i14;
                                    int i15;
                                    int i16;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, apkInfo5, apkInfo6)) == null) {
                                        int i17 = apkInfo5.priority;
                                        if (i17 == -1 && apkInfo6.priority != -1) {
                                            return 1;
                                        }
                                        if ((i17 != -1 && apkInfo6.priority == -1) || i17 < (i14 = apkInfo6.priority)) {
                                            return -1;
                                        }
                                        if (i17 > i14) {
                                            return 1;
                                        }
                                        List list8 = this.val$localSetIds;
                                        if (list8 != null && list8.contains(Integer.valueOf(apkInfo5.key))) {
                                            i15 = this.val$localSetIds.indexOf(Integer.valueOf(apkInfo5.key));
                                        } else {
                                            i15 = -1;
                                        }
                                        List list9 = this.val$localSetIds;
                                        if (list9 != null && list9.contains(Integer.valueOf(apkInfo6.key))) {
                                            i16 = this.val$localSetIds.indexOf(Integer.valueOf(apkInfo6.key));
                                        } else {
                                            i16 = -1;
                                        }
                                        if (i15 != -1 && i16 == -1) {
                                            return -1;
                                        }
                                        if ((i15 == -1 && i16 != -1) || i15 > i16) {
                                            return 1;
                                        }
                                        if (i15 < i16) {
                                            return -1;
                                        }
                                        return 0;
                                    }
                                    return invokeLL.intValue;
                                }
                            });
                            for (int i14 = 0; i14 < arrayList19.size(); i14++) {
                                ApkInfo apkInfo5 = (ApkInfo) arrayList19.get(i14);
                                if (arrayList7.contains(apkInfo5)) {
                                    if (a.b(apkInfo5.packageName) == null) {
                                        if (this.loadedPluginDB.c(apkInfo5.key) == 3) {
                                            z2 = false;
                                        } else {
                                            z2 = true;
                                        }
                                        if (this.mPreferenceManager.n() && z2) {
                                            File file = new File(apkInfo5.pkgPath);
                                            File file2 = new File(file.getParentFile(), apkInfo5.key + "." + apkInfo5.versionName + ".b");
                                            if (!com.baidu.sofire.k.b.a(file2)) {
                                                com.baidu.sofire.a.a.a(file, file2);
                                            }
                                            c.a(this.context, apkInfo5.key, file, file2);
                                        } else {
                                            File parentFile = new File(apkInfo5.pkgPath).getParentFile();
                                            if (parentFile.exists()) {
                                                File file3 = new File(parentFile, apkInfo5.key + "." + apkInfo5.versionName + ".b");
                                                if (com.baidu.sofire.k.b.a(file3)) {
                                                    c.a(file3);
                                                    file3.delete();
                                                }
                                            }
                                        }
                                        this.forHostAPP.a(apkInfo5.key, apkInfo5.versionName, null);
                                    }
                                } else if (arrayList13.contains(apkInfo5) && !this.loadedPluginDB.e(apkInfo5.key)) {
                                    handlePluginUpgrade(apkInfo5);
                                }
                            }
                            new Timer().schedule(new TimerTask(this, arrayList15) { // from class: com.baidu.sofire.ac.U.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ U this$0;
                                public final /* synthetic */ List val$pluginNeedDelayUpdate;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, arrayList15};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i15 = newInitContext.flag;
                                        if ((i15 & 1) != 0) {
                                            int i16 = i15 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$pluginNeedDelayUpdate = arrayList15;
                                }

                                @Override // java.util.TimerTask, java.lang.Runnable
                                public void run() {
                                    List<ApkInfo> list8;
                                    Interceptable interceptable2 = $ic;
                                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (list8 = this.val$pluginNeedDelayUpdate) != null) {
                                        for (ApkInfo apkInfo6 : list8) {
                                            this.this$0.handlePluginUpgrade(apkInfo6);
                                        }
                                    }
                                }
                            }, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
                            if (this.mEndReason == 0) {
                                z = true;
                                this.mEndReason = 1;
                            } else {
                                z = true;
                            }
                            sFinishOnce = z;
                            handleThreadEnd(null);
                            if (this.mOut && sOutGoing) {
                                sOutGoing = false;
                            }
                            return;
                        }
                        int i15 = this.mFrom;
                        if (i15 == 1 || i15 == 2 || i15 == 3) {
                            sMonitorNetworkWhenUpgradeNoNet = true;
                            IntentFilter intentFilter2 = new IntentFilter(NetworkMonitor.NET_CHANGE_ACTION);
                            if (com.baidu.sofire.k.b.g == null) {
                                com.baidu.sofire.k.b.g = new MyReceiver().a();
                            }
                            com.baidu.sofire.k.b.a(this.context, com.baidu.sofire.k.b.g, intentFilter2);
                        }
                        if (this.mEndReason == 0) {
                            this.mEndReason = 3;
                        }
                        if (z5) {
                            throw new NetworkErrorException("blocked by Huawei Input");
                        }
                        throw new NetworkErrorException("no internet");
                    }
                }
            }
        }
    }
}
