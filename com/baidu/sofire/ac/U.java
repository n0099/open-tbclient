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
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.a.b;
import com.baidu.sofire.a.c;
import com.baidu.sofire.b.d;
import com.baidu.sofire.b.k;
import com.baidu.sofire.c.a;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.jni.Asc;
import com.baidu.sofire.k.e;
import com.baidu.sofire.k.i;
import com.baidu.sofire.k.j;
import com.baidu.sofire.k.l;
import com.baidu.sofire.k.p;
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
/* loaded from: classes2.dex */
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
    public d forHostAPP;
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

    /* loaded from: classes2.dex */
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
        this.loadedPluginDB = a.a(context);
        this.mPreferenceManager = com.baidu.sofire.j.a.a(context);
        this.forHostAPP = d.a(context);
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

    private boolean commonDownloadFile(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, str, file)) == null) {
            try {
                if (l.a(this.context)) {
                    return new l(this.context).a(str, file);
                }
                return new i(this.context).a(str, file);
            } catch (Throwable unused) {
                int i = b.a;
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePluginDownError(ApkInfo apkInfo, File file, int i, List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65546, this, apkInfo, file, i, list) == null) {
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
                    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    MyReceiver myReceiver = com.baidu.sofire.k.a.g;
                    if (myReceiver == null) {
                        com.baidu.sofire.k.a.g = new MyReceiver().a();
                    } else {
                        myReceiver.a();
                    }
                    com.baidu.sofire.k.a.a(this.context, com.baidu.sofire.k.a.g, intentFilter);
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
                if (com.baidu.sofire.k.a.m(this.context)) {
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
                com.baidu.sofire.k.a.a(this.context, "1003116", (Map<String, Object>) hashMap, false);
            } else if (com.baidu.sofire.k.a.m(this.context)) {
                com.baidu.sofire.j.a aVar3 = this.mPreferenceManager;
                aVar3.c(aVar3.i() + 1);
            } else {
                com.baidu.sofire.j.a aVar4 = this.mPreferenceManager;
                aVar4.b(aVar4.h() + 1);
            }
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handlePluginDownload(ApkInfo apkInfo, File file, File file2, int i) {
        InterceptResult invokeLLLI;
        Asc asc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65547, this, apkInfo, file, file2, i)) == null) {
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable unused) {
                int i2 = b.a;
            }
            if (!"com.baidu.input_huawei".equals(this.context.getPackageName()) || this.mPreferenceManager.b()) {
                boolean commonDownloadFile = commonDownloadFile(apkInfo.downloadURL, file);
                if (commonDownloadFile) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    byte[] bytes = apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes(IMAudioTransRequest.CHARSET);
                    Asc asc2 = e.a;
                    if (((bytes == null || bytes.length <= 0 || (asc = e.a) == null) ? -1 : asc.df(file.getAbsolutePath(), file2.getAbsolutePath(), bytes)) != 0) {
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
            return false;
        }
        return invokeLLLI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f4 A[Catch: all -> 0x0201, TryCatch #4 {all -> 0x0201, blocks: (B:5:0x000a, B:7:0x001f, B:9:0x0025, B:11:0x002b, B:13:0x0031, B:15:0x003c, B:16:0x0047, B:19:0x0053, B:21:0x0057, B:23:0x0067, B:25:0x0078, B:27:0x0080, B:28:0x0085, B:30:0x00df, B:35:0x00f4, B:37:0x00f8, B:48:0x0140, B:93:0x01fc, B:51:0x0148, B:53:0x0152, B:58:0x0160, B:60:0x0168, B:62:0x0172, B:63:0x017d, B:65:0x0185, B:68:0x0190, B:71:0x0198, B:73:0x01a4, B:75:0x01b1, B:76:0x01c2, B:80:0x01d7, B:82:0x01e9, B:83:0x01ef, B:86:0x01f4, B:77:0x01c7, B:38:0x0112, B:40:0x011b, B:42:0x012b, B:44:0x0138, B:85:0x01f1), top: B:132:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0140 A[Catch: all -> 0x0201, TryCatch #4 {all -> 0x0201, blocks: (B:5:0x000a, B:7:0x001f, B:9:0x0025, B:11:0x002b, B:13:0x0031, B:15:0x003c, B:16:0x0047, B:19:0x0053, B:21:0x0057, B:23:0x0067, B:25:0x0078, B:27:0x0080, B:28:0x0085, B:30:0x00df, B:35:0x00f4, B:37:0x00f8, B:48:0x0140, B:93:0x01fc, B:51:0x0148, B:53:0x0152, B:58:0x0160, B:60:0x0168, B:62:0x0172, B:63:0x017d, B:65:0x0185, B:68:0x0190, B:71:0x0198, B:73:0x01a4, B:75:0x01b1, B:76:0x01c2, B:80:0x01d7, B:82:0x01e9, B:83:0x01ef, B:86:0x01f4, B:77:0x01c7, B:38:0x0112, B:40:0x011b, B:42:0x012b, B:44:0x0138, B:85:0x01f1), top: B:132:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0185 A[Catch: all -> 0x0201, TryCatch #4 {all -> 0x0201, blocks: (B:5:0x000a, B:7:0x001f, B:9:0x0025, B:11:0x002b, B:13:0x0031, B:15:0x003c, B:16:0x0047, B:19:0x0053, B:21:0x0057, B:23:0x0067, B:25:0x0078, B:27:0x0080, B:28:0x0085, B:30:0x00df, B:35:0x00f4, B:37:0x00f8, B:48:0x0140, B:93:0x01fc, B:51:0x0148, B:53:0x0152, B:58:0x0160, B:60:0x0168, B:62:0x0172, B:63:0x017d, B:65:0x0185, B:68:0x0190, B:71:0x0198, B:73:0x01a4, B:75:0x01b1, B:76:0x01c2, B:80:0x01d7, B:82:0x01e9, B:83:0x01ef, B:86:0x01f4, B:77:0x01c7, B:38:0x0112, B:40:0x011b, B:42:0x012b, B:44:0x0138, B:85:0x01f1), top: B:132:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a4 A[Catch: all -> 0x0201, TryCatch #4 {all -> 0x0201, blocks: (B:5:0x000a, B:7:0x001f, B:9:0x0025, B:11:0x002b, B:13:0x0031, B:15:0x003c, B:16:0x0047, B:19:0x0053, B:21:0x0057, B:23:0x0067, B:25:0x0078, B:27:0x0080, B:28:0x0085, B:30:0x00df, B:35:0x00f4, B:37:0x00f8, B:48:0x0140, B:93:0x01fc, B:51:0x0148, B:53:0x0152, B:58:0x0160, B:60:0x0168, B:62:0x0172, B:63:0x017d, B:65:0x0185, B:68:0x0190, B:71:0x0198, B:73:0x01a4, B:75:0x01b1, B:76:0x01c2, B:80:0x01d7, B:82:0x01e9, B:83:0x01ef, B:86:0x01f4, B:77:0x01c7, B:38:0x0112, B:40:0x011b, B:42:0x012b, B:44:0x0138, B:85:0x01f1), top: B:132:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c7 A[Catch: all -> 0x0201, TryCatch #4 {all -> 0x0201, blocks: (B:5:0x000a, B:7:0x001f, B:9:0x0025, B:11:0x002b, B:13:0x0031, B:15:0x003c, B:16:0x0047, B:19:0x0053, B:21:0x0057, B:23:0x0067, B:25:0x0078, B:27:0x0080, B:28:0x0085, B:30:0x00df, B:35:0x00f4, B:37:0x00f8, B:48:0x0140, B:93:0x01fc, B:51:0x0148, B:53:0x0152, B:58:0x0160, B:60:0x0168, B:62:0x0172, B:63:0x017d, B:65:0x0185, B:68:0x0190, B:71:0x0198, B:73:0x01a4, B:75:0x01b1, B:76:0x01c2, B:80:0x01d7, B:82:0x01e9, B:83:0x01ef, B:86:0x01f4, B:77:0x01c7, B:38:0x0112, B:40:0x011b, B:42:0x012b, B:44:0x0138, B:85:0x01f1), top: B:132:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fc A[Catch: all -> 0x0201, TRY_LEAVE, TryCatch #4 {all -> 0x0201, blocks: (B:5:0x000a, B:7:0x001f, B:9:0x0025, B:11:0x002b, B:13:0x0031, B:15:0x003c, B:16:0x0047, B:19:0x0053, B:21:0x0057, B:23:0x0067, B:25:0x0078, B:27:0x0080, B:28:0x0085, B:30:0x00df, B:35:0x00f4, B:37:0x00f8, B:48:0x0140, B:93:0x01fc, B:51:0x0148, B:53:0x0152, B:58:0x0160, B:60:0x0168, B:62:0x0172, B:63:0x017d, B:65:0x0185, B:68:0x0190, B:71:0x0198, B:73:0x01a4, B:75:0x01b1, B:76:0x01c2, B:80:0x01d7, B:82:0x01e9, B:83:0x01ef, B:86:0x01f4, B:77:0x01c7, B:38:0x0112, B:40:0x011b, B:42:0x012b, B:44:0x0138, B:85:0x01f1), top: B:132:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handlePluginUpgrade(ApkInfo apkInfo) {
        boolean z;
        boolean z2;
        File file;
        boolean z3;
        boolean z4;
        d dVar;
        boolean z5;
        File file2;
        boolean z6;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65548, this, apkInfo) != null) {
            return;
        }
        try {
            int d = com.baidu.sofire.k.a.d(this.context);
            List<Integer> e = this.mPreferenceManager.e();
            if (!((ArrayList) e).contains(Integer.valueOf(apkInfo.key))) {
                Context context = this.context;
                if (apkInfo.network != 1 || com.baidu.sofire.k.a.m(context)) {
                    z6 = true;
                } else {
                    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    if (com.baidu.sofire.k.a.g == null) {
                        com.baidu.sofire.k.a.g = new MyReceiver().a();
                    }
                    com.baidu.sofire.k.a.a(context, com.baidu.sofire.k.a.g, intentFilter);
                    com.baidu.sofire.k.a.a = true;
                    z6 = false;
                }
                if (!z6) {
                    Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
                    if (map == null || map.keySet().contains(Integer.valueOf(apkInfo.key))) {
                        return;
                    }
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, d, 3));
                    return;
                }
            }
            if (!this.tmpDir.exists()) {
                this.tmpDir.mkdir();
            }
            ApkInfo b = this.loadedPluginDB.b(apkInfo.key + 10000000);
            File file3 = new File(this.tmpDir, apkInfo.key + "-" + apkInfo.versionName + ".tmp");
            File file4 = new File(this.tmpDir, apkInfo.key + "-" + apkInfo.versionName + ".zip");
            if (file4.exists()) {
                if (apkInfo.apkMD5.equals(j.a(file4))) {
                    z = false;
                    z2 = true;
                    if (z) {
                        file = file4;
                    } else if (apkInfo.isNextLoad) {
                        file = file4;
                        p.a(this.context).a(new Runnable(this, apkInfo, file3, file4, d, e) { // from class: com.baidu.sofire.ac.U.3
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
                                    Object[] objArr = {this, apkInfo, file3, file4, Integer.valueOf(d), e};
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
                                this.val$networkType = d;
                                this.val$hostCarePluginKeys = e;
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
                                        ApkInfo apkInfo2 = new ApkInfo(this.val$apkInfo);
                                        apkInfo2.key += 10000000;
                                        if (!TextUtils.isEmpty(apkInfo2.packageName)) {
                                            apkInfo2.packageName = new StringBuilder(apkInfo2.packageName).reverse().toString();
                                        }
                                        this.this$0.loadedPluginDB.a(apkInfo2);
                                    } catch (Throwable unused) {
                                        int i = b.a;
                                    }
                                }
                            }
                        });
                    } else {
                        file = file4;
                        z2 = handlePluginDownload(apkInfo, file3, file, d);
                        z3 = !z2;
                        if (b != null) {
                            this.loadedPluginDB.a(b.key + 10000000);
                            if (!TextUtils.isEmpty(b.pkgPath)) {
                                File file5 = new File(b.pkgPath);
                                if (file5.exists()) {
                                    file5.delete();
                                }
                            }
                        }
                        if (z2) {
                            pluginUpdate(file, apkInfo, d);
                        } else {
                            if (b != null) {
                                ApkInfo b2 = this.loadedPluginDB.b(apkInfo.key);
                                if (b2 != null && !com.baidu.sofire.k.a.b(b.versionName, b2.versionName)) {
                                    z5 = false;
                                    if (!TextUtils.isEmpty(b.versionName) && b.versionName.equals(apkInfo.versionName)) {
                                        this.loadedPluginDB.a(b.key + 10000000, b.versionName);
                                        z5 = false;
                                    }
                                    file2 = TextUtils.isEmpty(b.pkgPath) ? new File(b.pkgPath) : null;
                                    if (file2 != null && file2.exists() && z5) {
                                        if (!b.apkMD5.equals(j.a(file2))) {
                                            b.key -= 10000000;
                                            if (!TextUtils.isEmpty(b.packageName)) {
                                                b.packageName = new StringBuilder(b.packageName).reverse().toString();
                                            }
                                            pluginUpdate(file2, b, d);
                                            z4 = true;
                                            if (!z4 && k.a(this.context.getApplicationContext()).b(apkInfo.packageName) == null) {
                                                dVar = this.forHostAPP;
                                                int i = apkInfo.key;
                                                String str = apkInfo.versionName;
                                                synchronized (dVar) {
                                                    dVar.a(i, str, false, (PackageInfo) null);
                                                }
                                            }
                                        } else {
                                            this.loadedPluginDB.a(b.key + 10000000, b.versionName);
                                            file2.delete();
                                        }
                                    }
                                }
                                z5 = true;
                                if (!TextUtils.isEmpty(b.versionName)) {
                                    this.loadedPluginDB.a(b.key + 10000000, b.versionName);
                                    z5 = false;
                                }
                                if (TextUtils.isEmpty(b.pkgPath)) {
                                }
                                if (file2 != null) {
                                    if (!b.apkMD5.equals(j.a(file2))) {
                                    }
                                }
                            }
                            z4 = false;
                            if (!z4) {
                                dVar = this.forHostAPP;
                                int i2 = apkInfo.key;
                                String str2 = apkInfo.versionName;
                                synchronized (dVar) {
                                }
                            }
                        }
                        if (z3) {
                            handlePluginDownError(apkInfo, file, d, e);
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
        } catch (Throwable unused) {
            int i3 = b.a;
            try {
                Map<Integer, UpgradeResult> map2 = this.mUpgradeResultMap;
                if (map2 != null && !map2.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, com.baidu.sofire.k.a.d(this.context), 2));
                }
            } catch (Throwable unused2) {
                int i4 = b.a;
            }
            try {
                List<Integer> e2 = this.mPreferenceManager.e();
                int i5 = this.mFrom;
                if (i5 == 1 || i5 == 2 || i5 == 3) {
                    if (((ArrayList) e2).contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                        sSetRetrmAlarm = true;
                        com.baidu.sofire.a.a.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                        sRetryDownoadHostCareApksTimesCount++;
                    }
                    if (sMonitorNetworkWhenUpgradeNoNet) {
                        return;
                    }
                    IntentFilter intentFilter2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    MyReceiver myReceiver = com.baidu.sofire.k.a.g;
                    if (myReceiver == null) {
                        com.baidu.sofire.k.a.g = new MyReceiver().a();
                    } else {
                        myReceiver.a();
                    }
                    com.baidu.sofire.k.a.a(this.context, com.baidu.sofire.k.a.g, intentFilter2);
                    sMonitorNetworkWhenUpgradeNoNet = true;
                }
            } catch (Throwable unused3) {
                int i6 = b.a;
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
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
            try {
                com.baidu.sofire.j.a aVar = this.mPreferenceManager;
                aVar.e(aVar.a.getInt("sufzfd", 0) + 1);
                int i = this.mEndReason;
                if (i != 0) {
                    com.baidu.sofire.j.a aVar2 = this.mPreferenceManager;
                    aVar2.a(1, i, aVar2.a(1, i) + 1);
                }
            } catch (Throwable unused) {
                int i2 = b.a;
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
                hashMap.put("14", Integer.valueOf(com.baidu.sofire.k.a.d(this.context)));
                com.baidu.sofire.k.a.a(this.context, "1003129", (Map<String, Object>) hashMap, false);
            } catch (Throwable unused2) {
                int i3 = b.a;
            }
            try {
                for (Map.Entry<Integer, List<BDModuleLoadCallback>> entry2 : sCallbackMap.entrySet()) {
                    int intValue2 = entry2.getKey().intValue();
                    List<BDModuleLoadCallback> value2 = entry2.getValue();
                    int i4 = 4;
                    if (map == null || !map.containsKey(Integer.valueOf(intValue2))) {
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
                    } else {
                        i4 = 11;
                        z = true;
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
                int i6 = b.a;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0100 A[Catch: all -> 0x0113, TryCatch #0 {all -> 0x0113, blocks: (B:32:0x00e8, B:34:0x0100, B:35:0x010a), top: B:42:0x00e8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleThreadStart() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
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
                            com.baidu.sofire.k.a.a(this.context, "1003128", (Map<String, Object>) hashMap, false);
                            com.baidu.sofire.j.a aVar = this.mPreferenceManager;
                            aVar.b.putLong("slruct", currentTimeMillis);
                            aVar.b.commit();
                        } else if (i2 == 0) {
                            com.baidu.sofire.j.a aVar2 = this.mPreferenceManager;
                            aVar2.b.putLong("slruct", currentTimeMillis);
                            aVar2.b.commit();
                        }
                    } catch (Throwable unused) {
                        int i5 = b.a;
                        int i6 = b.a;
                        this.mStartKeyMap = this.loadedPluginDB.c();
                        com.baidu.sofire.j.a aVar3 = this.mPreferenceManager;
                        aVar3.f(aVar3.a.getInt("sustfd", 0) + 1);
                        i = this.mFrom;
                        if (i != 0) {
                        }
                        this.mStartNetwork = com.baidu.sofire.k.a.d(this.context);
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
                    int i62 = b.a;
                    this.mStartKeyMap = this.loadedPluginDB.c();
                    com.baidu.sofire.j.a aVar32 = this.mPreferenceManager;
                    aVar32.f(aVar32.a.getInt("sustfd", 0) + 1);
                    i = this.mFrom;
                    if (i != 0) {
                    }
                    this.mStartNetwork = com.baidu.sofire.k.a.d(this.context);
                }
                this.mStartKeyMap = this.loadedPluginDB.c();
                com.baidu.sofire.j.a aVar322 = this.mPreferenceManager;
                aVar322.f(aVar322.a.getInt("sustfd", 0) + 1);
                i = this.mFrom;
                if (i != 0) {
                    com.baidu.sofire.j.a aVar4 = this.mPreferenceManager;
                    aVar4.a(0, i, aVar4.a(0, i) + 1);
                }
                this.mStartNetwork = com.baidu.sofire.k.a.d(this.context);
            } catch (Throwable unused3) {
                int i9 = b.a;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:118:0x04ad */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:125:0x04b7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:178:0x02f2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x023e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:0x02c9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03c8 A[Catch: all -> 0x04af, TRY_LEAVE, TryCatch #8 {all -> 0x04af, blocks: (B:92:0x03a2, B:94:0x03c8, B:90:0x039d), top: B:175:0x039d }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0414 A[Catch: all -> 0x04ad, TryCatch #7 {all -> 0x04ad, blocks: (B:96:0x03f0, B:97:0x0414, B:99:0x041a, B:101:0x0429), top: B:174:0x03c6 }] */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.sofire.ac.U] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pluginUpdate(File file, ApkInfo apkInfo, int i) {
        ?? r23;
        Class cls;
        ?? r14;
        Object[] objArr;
        String str;
        ApkInfo apkInfo2;
        boolean z;
        int i2;
        HashMap hashMap;
        String replace;
        k a;
        String str2;
        String str3;
        com.baidu.sofire.b.j jVar;
        Class<?> a2;
        Class[] clsArr;
        Class[] clsArr2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r23 = 65551;
            if (interceptable.invokeLLI(65551, this, file, apkInfo, i) != null) {
                return;
            }
        }
        CharSequence charSequence = this;
        String str4 = "2";
        com.baidu.sofire.k.a.a(file.getAbsolutePath(), true);
        if (!charSequence.mPreferenceManager.n()) {
            cls = String.class;
        } else {
            File file2 = new File(charSequence.context.getFilesDir(), ".b");
            if (!file2.exists()) {
                file2.mkdir();
            }
            StringBuilder sb = new StringBuilder();
            cls = String.class;
            sb.append(apkInfo.key);
            sb.append("-");
            sb.append(apkInfo.versionName);
            File file3 = new File(file2, sb.toString());
            com.baidu.sofire.k.a.a(file, file3);
            c.a(charSequence.context, apkInfo.key, file, file3);
        }
        apkInfo.pkgPath = file.getAbsolutePath();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("before update, time=");
        sb2.append(System.currentTimeMillis());
        sb2.append(", downloadAPK path:");
        sb2.append(file.getAbsolutePath());
        sb2.append(", exists=");
        sb2.append(file.exists());
        sb2.append(", canRead=");
        sb2.append(file.canRead());
        sb2.append(", isFile=");
        sb2.append(file.isFile());
        String str5 = ",length";
        sb2.append(",length");
        CharSequence charSequence2 = "\t";
        sb2.append(file.length());
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder("before update, time=" + System.currentTimeMillis() + StringUtil.ARRAY_ELEMENT_SEPARATOR);
        ApkInfo b = charSequence.loadedPluginDB.b(apkInfo.key);
        if (b == null) {
            sb4.append("apkInDB == null");
        } else {
            File file4 = new File(b.pkgPath);
            sb4.append("origAPK path:" + file4.getAbsolutePath() + ", exists=" + file4.exists() + ", canRead=" + file4.canRead() + ", isFile=" + file4.isFile() + ",length" + file4.length());
        }
        d dVar = charSequence.forHostAPP;
        sb4.toString();
        dVar.getClass();
        String str6 = apkInfo.pkgPath;
        File file5 = new File(str6);
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            str6 = "2";
            r14 = "1";
            objArr = "0";
            str4 = "1003106";
            sb3 = "\r";
            charSequence = charSequence2;
            str = "3";
        }
        if (!com.baidu.sofire.k.a.a(file5)) {
            try {
                hashMap = new HashMap();
                hashMap.put("0", 1);
                hashMap.put("1", apkInfo.key + "");
                hashMap.put("2", apkInfo.versionName);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("nowTime:");
                str6 = "2";
                r23 = "1";
                try {
                    sb5.append(System.currentTimeMillis());
                    sb5.append(", nowFileInfo: path=");
                    sb5.append(file5.getAbsolutePath());
                    sb5.append(", exists=");
                    sb5.append(file5.exists());
                    sb5.append(", canRead=");
                    sb5.append(file5.canRead());
                    sb5.append(", isFile=");
                    sb5.append(file5.isFile());
                    sb5.append(",length");
                    sb5.append(file5.length());
                    sb5.append(" - ");
                    sb5.append(sb3);
                    replace = Base64.encodeToString(sb5.toString().getBytes(), 0).replace("\n", "");
                    charSequence = charSequence2;
                    try {
                        sb3 = "\r";
                        try {
                            str5 = "3";
                        } catch (Throwable th3) {
                            th = th3;
                            str4 = "1003106";
                            charSequence = charSequence;
                            str5 = "3";
                            r14 = r23;
                            apkInfo2 = apkInfo;
                            str = str5;
                            objArr = "0";
                            try {
                                c.a(file5);
                                dVar.c(apkInfo2.packageName);
                                file5.delete();
                                dVar.a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                                dVar.c.b(apkInfo2.key, 0);
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put(objArr, 5);
                                hashMap2.put(r14, apkInfo2.key + "");
                                hashMap2.put(str6, apkInfo2.versionName);
                                hashMap2.put(str, Base64.encodeToString(b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                            } catch (Throwable unused) {
                            }
                            try {
                                com.baidu.sofire.k.a.a(d.e, str4, (Map<String, Object>) hashMap2, false);
                            } catch (Throwable unused2) {
                                int i3 = b.a;
                                z = false;
                                this.loadedPluginDB.a(apkInfo.key + 10000000, apkInfo.versionName);
                                if (!z) {
                                }
                            }
                            z = false;
                            this.loadedPluginDB.a(apkInfo.key + 10000000, apkInfo.versionName);
                            if (!z) {
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str4 = "1003106";
                        sb3 = "\r";
                        charSequence = charSequence;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str4 = "1003106";
                    sb3 = "\r";
                    charSequence = charSequence2;
                }
            } catch (Throwable th6) {
                th = th6;
                str6 = "2";
                str4 = "1003106";
                sb3 = "\r";
                charSequence = charSequence2;
                str5 = "3";
                r14 = "1";
                apkInfo2 = apkInfo;
                str = str5;
                objArr = "0";
                c.a(file5);
                dVar.c(apkInfo2.packageName);
                file5.delete();
                dVar.a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                dVar.c.b(apkInfo2.key, 0);
                HashMap hashMap22 = new HashMap();
                hashMap22.put(objArr, 5);
                hashMap22.put(r14, apkInfo2.key + "");
                hashMap22.put(str6, apkInfo2.versionName);
                hashMap22.put(str, Base64.encodeToString(b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                com.baidu.sofire.k.a.a(d.e, str4, (Map<String, Object>) hashMap22, false);
                z = false;
                this.loadedPluginDB.a(apkInfo.key + 10000000, apkInfo.versionName);
                if (!z) {
                }
            }
            try {
                hashMap.put(str5, replace.replace((CharSequence) charSequence, "").replace(sb3, ""));
                com.baidu.sofire.k.a.a(d.e, "1003106", (Map<String, Object>) hashMap, false);
            } catch (Throwable th7) {
                th = th7;
                str4 = "1003106";
                r14 = r23;
                apkInfo2 = apkInfo;
                str = str5;
                objArr = "0";
                c.a(file5);
                dVar.c(apkInfo2.packageName);
                file5.delete();
                dVar.a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                dVar.c.b(apkInfo2.key, 0);
                HashMap hashMap222 = new HashMap();
                hashMap222.put(objArr, 5);
                hashMap222.put(r14, apkInfo2.key + "");
                hashMap222.put(str6, apkInfo2.versionName);
                hashMap222.put(str, Base64.encodeToString(b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                com.baidu.sofire.k.a.a(d.e, str4, (Map<String, Object>) hashMap222, false);
                z = false;
                this.loadedPluginDB.a(apkInfo.key + 10000000, apkInfo.versionName);
                if (!z) {
                }
            }
        } else {
            str6 = "2";
            str4 = "1003106";
            sb3 = "\r";
            charSequence = charSequence2;
            str5 = "3";
            try {
                if (!dVar.c.g(apkInfo.key)) {
                    dVar.c.a(apkInfo);
                }
                a = k.a(d.e.getApplicationContext());
                r14 = 1;
                dVar.c.b(apkInfo.key, 1);
                dVar.c(apkInfo.packageName);
                try {
                } catch (Throwable th8) {
                    th = th8;
                    apkInfo2 = apkInfo;
                    str = str5;
                    objArr = "0";
                    c.a(file5);
                    dVar.c(apkInfo2.packageName);
                    file5.delete();
                    dVar.a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                    dVar.c.b(apkInfo2.key, 0);
                    HashMap hashMap2222 = new HashMap();
                    hashMap2222.put(objArr, 5);
                    hashMap2222.put(r14, apkInfo2.key + "");
                    hashMap2222.put(str6, apkInfo2.versionName);
                    hashMap2222.put(str, Base64.encodeToString(b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                    com.baidu.sofire.k.a.a(d.e, str4, (Map<String, Object>) hashMap2222, false);
                    z = false;
                    this.loadedPluginDB.a(apkInfo.key + 10000000, apkInfo.versionName);
                    if (!z) {
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                str = str5;
                objArr = "0";
                r14 = "1";
            }
            if (!a.a(apkInfo, true)) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("0", 2);
                hashMap3.put("1", apkInfo.key + "");
                hashMap3.put(str6, apkInfo.versionName);
                com.baidu.sofire.k.a.a(d.e, str4, (Map<String, Object>) hashMap3, false);
                c.a(file5);
                file5.delete();
                dVar.a(apkInfo.key, apkInfo.versionName, true, (PackageInfo) null);
                dVar.c.b(apkInfo.key, 0);
            } else {
                r14 = "1";
                try {
                    String[] p = com.baidu.sofire.k.a.p(d.e);
                    if (p.length != 2 || TextUtils.isEmpty(p[0]) || TextUtils.isEmpty(p[1])) {
                        str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                        str3 = str5;
                    } else {
                        str3 = p[0];
                        str2 = p[1];
                    }
                    apkInfo2 = a.c.get(apkInfo.pkgPath);
                } catch (Throwable th10) {
                    th = th10;
                    str = str5;
                    objArr = "0";
                    r14 = r14;
                    apkInfo2 = apkInfo;
                    c.a(file5);
                    dVar.c(apkInfo2.packageName);
                    file5.delete();
                    dVar.a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                    dVar.c.b(apkInfo2.key, 0);
                    HashMap hashMap22222 = new HashMap();
                    hashMap22222.put(objArr, 5);
                    hashMap22222.put(r14, apkInfo2.key + "");
                    hashMap22222.put(str6, apkInfo2.versionName);
                    hashMap22222.put(str, Base64.encodeToString(b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                    com.baidu.sofire.k.a.a(d.e, str4, (Map<String, Object>) hashMap22222, false);
                    z = false;
                    this.loadedPluginDB.a(apkInfo.key + 10000000, apkInfo.versionName);
                    if (!z) {
                    }
                }
                if (apkInfo2 != null) {
                    try {
                        jVar = (com.baidu.sofire.b.j) apkInfo2.classLoader;
                        a2 = jVar.a("com.baidu.sofire.engine.EngineImpl");
                        try {
                        } catch (Throwable th11) {
                            th = th11;
                            str = str5;
                        }
                    } catch (Throwable th12) {
                        th = th12;
                        str = str5;
                        objArr = "0";
                        c.a(file5);
                        dVar.c(apkInfo2.packageName);
                        file5.delete();
                        dVar.a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                        dVar.c.b(apkInfo2.key, 0);
                        HashMap hashMap222222 = new HashMap();
                        hashMap222222.put(objArr, 5);
                        hashMap222222.put(r14, apkInfo2.key + "");
                        hashMap222222.put(str6, apkInfo2.versionName);
                        hashMap222222.put(str, Base64.encodeToString(b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                        com.baidu.sofire.k.a.a(d.e, str4, (Map<String, Object>) hashMap222222, false);
                        z = false;
                        this.loadedPluginDB.a(apkInfo.key + 10000000, apkInfo.versionName);
                        if (!z) {
                        }
                    }
                    if (a2 == null) {
                        Class<?> a3 = jVar.a("java.lang.String");
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("0", 6);
                        StringBuilder sb6 = new StringBuilder();
                        charSequence2 = "0";
                        sb6.append(apkInfo2.key);
                        sb6.append("");
                        hashMap4.put(r14, sb6.toString());
                        hashMap4.put(str6, apkInfo2.versionName);
                        hashMap4.put(str5, Base64.encodeToString(("classloader=" + jVar + ",StringClass=" + a3).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                        com.baidu.sofire.k.a.a(d.e, str4, (Map<String, Object>) hashMap4, false);
                        c.a(file5);
                        file5.delete();
                        dVar.c.b(apkInfo2.key, 0);
                    } else {
                        charSequence2 = "0";
                        Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, d.e);
                        try {
                            clsArr2 = new Class[]{cls, cls};
                            str = str5;
                        } catch (Throwable unused3) {
                            str = str5;
                        }
                        try {
                            try {
                                com.baidu.sofire.k.a.a(invoke, "setSecurityVerifyInfo", clsArr2, str3, str2);
                            } catch (Throwable unused4) {
                                try {
                                    int i4 = b.a;
                                    clsArr = new Class[]{Integer.TYPE, Boolean.TYPE};
                                    objArr = new Object[]{0, Boolean.TRUE};
                                    if (((Boolean) com.baidu.sofire.k.a.a(invoke, "init", clsArr, objArr)).booleanValue()) {
                                    }
                                } catch (Throwable th13) {
                                    th = th13;
                                    objArr = charSequence2;
                                    c.a(file5);
                                    dVar.c(apkInfo2.packageName);
                                    file5.delete();
                                    dVar.a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                                    dVar.c.b(apkInfo2.key, 0);
                                    HashMap hashMap2222222 = new HashMap();
                                    hashMap2222222.put(objArr, 5);
                                    hashMap2222222.put(r14, apkInfo2.key + "");
                                    hashMap2222222.put(str6, apkInfo2.versionName);
                                    hashMap2222222.put(str, Base64.encodeToString(b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                                    com.baidu.sofire.k.a.a(d.e, str4, (Map<String, Object>) hashMap2222222, false);
                                    z = false;
                                    this.loadedPluginDB.a(apkInfo.key + 10000000, apkInfo.versionName);
                                    if (!z) {
                                    }
                                }
                            }
                        } catch (Throwable th14) {
                            th = th14;
                            c.a(file5);
                            dVar.c(apkInfo2.packageName);
                            file5.delete();
                            dVar.a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                            dVar.c.b(apkInfo2.key, 0);
                            HashMap hashMap22222222 = new HashMap();
                            hashMap22222222.put(objArr, 5);
                            hashMap22222222.put(r14, apkInfo2.key + "");
                            hashMap22222222.put(str6, apkInfo2.versionName);
                            hashMap22222222.put(str, Base64.encodeToString(b.a(th).getBytes(), 0).replace("\n", "").replace(charSequence, "").replace(sb3, ""));
                            com.baidu.sofire.k.a.a(d.e, str4, (Map<String, Object>) hashMap22222222, false);
                            z = false;
                            this.loadedPluginDB.a(apkInfo.key + 10000000, apkInfo.versionName);
                            if (!z) {
                            }
                        }
                        clsArr = new Class[]{Integer.TYPE, Boolean.TYPE};
                        objArr = new Object[]{0, Boolean.TRUE};
                        if (((Boolean) com.baidu.sofire.k.a.a(invoke, "init", clsArr, objArr)).booleanValue()) {
                            c.a(file5);
                            dVar.c(apkInfo2.packageName);
                            file5.delete();
                            dVar.a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                            dVar.c.b(apkInfo2.key, 0);
                            HashMap hashMap5 = new HashMap();
                            hashMap5.put(charSequence2, 4);
                            hashMap5.put(r14, apkInfo2.key + "");
                            hashMap5.put(str6, apkInfo2.versionName);
                            str5 = null;
                            com.baidu.sofire.k.a.a(d.e, str4, (Map<String, Object>) hashMap5, false);
                        } else {
                            if (apkInfo2.isMem) {
                                c.a(file5);
                                file5.delete();
                                com.baidu.sofire.k.a.c(apkInfo2.dataDir);
                                List<Integer> list = k.i;
                                if (list != null) {
                                    list.add(Integer.valueOf(apkInfo2.key));
                                }
                            }
                            try {
                                ApkInfo b2 = dVar.c.b(apkInfo2.key);
                                File file6 = (b2 == null || b2.versionName.equals(apkInfo2.versionName)) ? null : new File(b2.pkgPath);
                                apkInfo2.initStatus = 1;
                                apkInfo2.apkParseSuc = 1;
                                if (dVar.c.a(apkInfo2) > 0 && file6 != null && file6.exists()) {
                                    c.a(file6);
                                    file6.delete();
                                }
                                dVar.c.b(apkInfo2.key, 0);
                                com.baidu.sofire.k.a.q(d.e);
                                HashMap hashMap6 = new HashMap();
                                hashMap6.put(charSequence2, 0);
                                hashMap6.put(r14, apkInfo2.key + "");
                                hashMap6.put(str6, apkInfo2.versionName);
                                com.baidu.sofire.k.a.a(d.e, str4, (Map<String, Object>) hashMap6, false);
                            } catch (Throwable unused5) {
                                int i5 = b.a;
                            }
                            z = true;
                            this.loadedPluginDB.a(apkInfo.key + 10000000, apkInfo.versionName);
                            if (!z) {
                                Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
                                if (map == null || map.keySet().contains(Integer.valueOf(apkInfo.key))) {
                                    return;
                                }
                                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i, 5));
                                return;
                            }
                            int c = this.loadedPluginDB.c(apkInfo.key);
                            if (c >= 3 || c == -1) {
                                i2 = 1;
                            } else {
                                i2 = 1;
                                this.loadedPluginDB.c(apkInfo.key, c + 1);
                            }
                            Map<Integer, UpgradeResult> map2 = this.mUpgradeResultMap;
                            if (map2 != null) {
                                map2.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i, i2));
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        z = false;
        this.loadedPluginDB.a(apkInfo.key + 10000000, apkInfo.versionName);
        if (!z) {
        }
    }

    public void handleWork(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            this.context = context;
            this.loadedPluginDB = a.a(context);
            this.mPreferenceManager = com.baidu.sofire.j.a.a(context);
            this.tmpDir = new File(context.getFilesDir(), ".tmp");
            this.forHostAPP = d.a(context);
            this.mFrom = intent.getIntExtra("from", 0);
            p.a(context).b(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:212:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03a1 A[Catch: all -> 0x06d1, TryCatch #16 {, blocks: (B:20:0x001d, B:24:0x002b, B:26:0x002f, B:28:0x003d, B:30:0x0041, B:31:0x0046, B:42:0x0058, B:44:0x0060, B:45:0x0066, B:49:0x0081, B:51:0x0085, B:53:0x0089, B:55:0x0095, B:57:0x009e, B:61:0x00aa, B:63:0x00b4, B:65:0x00b8, B:71:0x00cc, B:73:0x00d4, B:74:0x00dc, B:76:0x00e0, B:80:0x00e8, B:87:0x0108, B:89:0x0113, B:91:0x0122, B:93:0x012f, B:95:0x0133, B:96:0x0136, B:97:0x0139, B:98:0x0140, B:90:0x011f, B:82:0x00ec, B:84:0x00f4, B:86:0x00fa, B:99:0x0141, B:101:0x017b, B:103:0x017f, B:104:0x0183, B:105:0x018a, B:106:0x018b, B:107:0x018f, B:109:0x0195, B:111:0x01b1, B:112:0x01b8, B:114:0x01cd, B:115:0x01d1, B:117:0x01e6, B:118:0x01ed, B:120:0x01f3, B:122:0x01f9, B:125:0x0209, B:126:0x020d, B:130:0x021b, B:134:0x0226, B:136:0x0232, B:140:0x0240, B:204:0x036f, B:205:0x0373, B:210:0x0391, B:214:0x039d, B:216:0x03a1, B:217:0x03a3, B:219:0x03ab, B:220:0x03bb, B:222:0x03c3, B:226:0x03d0, B:228:0x03d8, B:230:0x03e0, B:232:0x03ea, B:233:0x03f8, B:235:0x03fe, B:236:0x040d, B:238:0x0414, B:240:0x041f, B:242:0x0430, B:243:0x0441, B:245:0x0447, B:247:0x044c, B:249:0x045c, B:251:0x0462, B:252:0x0469, B:255:0x0475, B:256:0x0478, B:258:0x047c, B:260:0x0488, B:262:0x0497, B:264:0x049b, B:271:0x04c6, B:261:0x0490, B:267:0x04ac, B:269:0x04b6, B:270:0x04c1, B:272:0x04ca, B:274:0x04d7, B:276:0x04f2, B:278:0x04fe, B:280:0x0503, B:281:0x0507, B:283:0x050d, B:286:0x0520, B:288:0x0524, B:289:0x052d, B:290:0x0535, B:293:0x0554, B:295:0x055a, B:297:0x0561, B:299:0x0567, B:300:0x056e, B:301:0x0571, B:302:0x0585, B:304:0x058b, B:306:0x0597, B:308:0x059f, B:312:0x05ad, B:315:0x05b7, B:317:0x05ca, B:318:0x05cd, B:320:0x05f7, B:321:0x05fa, B:327:0x063e, B:322:0x0602, B:324:0x0615, B:326:0x0638, B:333:0x065c, B:328:0x0649, B:330:0x064f, B:332:0x0659, B:334:0x0660, B:335:0x0670, B:349:0x068f, B:358:0x06b8, B:360:0x06bc, B:362:0x06c1, B:363:0x06c8, B:364:0x06c9, B:365:0x06d0, B:354:0x0699, B:356:0x06a6, B:357:0x06b1, B:48:0x0076, B:67:0x00bc, B:206:0x0385), top: B:439:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03ab A[Catch: all -> 0x06d1, TryCatch #16 {, blocks: (B:20:0x001d, B:24:0x002b, B:26:0x002f, B:28:0x003d, B:30:0x0041, B:31:0x0046, B:42:0x0058, B:44:0x0060, B:45:0x0066, B:49:0x0081, B:51:0x0085, B:53:0x0089, B:55:0x0095, B:57:0x009e, B:61:0x00aa, B:63:0x00b4, B:65:0x00b8, B:71:0x00cc, B:73:0x00d4, B:74:0x00dc, B:76:0x00e0, B:80:0x00e8, B:87:0x0108, B:89:0x0113, B:91:0x0122, B:93:0x012f, B:95:0x0133, B:96:0x0136, B:97:0x0139, B:98:0x0140, B:90:0x011f, B:82:0x00ec, B:84:0x00f4, B:86:0x00fa, B:99:0x0141, B:101:0x017b, B:103:0x017f, B:104:0x0183, B:105:0x018a, B:106:0x018b, B:107:0x018f, B:109:0x0195, B:111:0x01b1, B:112:0x01b8, B:114:0x01cd, B:115:0x01d1, B:117:0x01e6, B:118:0x01ed, B:120:0x01f3, B:122:0x01f9, B:125:0x0209, B:126:0x020d, B:130:0x021b, B:134:0x0226, B:136:0x0232, B:140:0x0240, B:204:0x036f, B:205:0x0373, B:210:0x0391, B:214:0x039d, B:216:0x03a1, B:217:0x03a3, B:219:0x03ab, B:220:0x03bb, B:222:0x03c3, B:226:0x03d0, B:228:0x03d8, B:230:0x03e0, B:232:0x03ea, B:233:0x03f8, B:235:0x03fe, B:236:0x040d, B:238:0x0414, B:240:0x041f, B:242:0x0430, B:243:0x0441, B:245:0x0447, B:247:0x044c, B:249:0x045c, B:251:0x0462, B:252:0x0469, B:255:0x0475, B:256:0x0478, B:258:0x047c, B:260:0x0488, B:262:0x0497, B:264:0x049b, B:271:0x04c6, B:261:0x0490, B:267:0x04ac, B:269:0x04b6, B:270:0x04c1, B:272:0x04ca, B:274:0x04d7, B:276:0x04f2, B:278:0x04fe, B:280:0x0503, B:281:0x0507, B:283:0x050d, B:286:0x0520, B:288:0x0524, B:289:0x052d, B:290:0x0535, B:293:0x0554, B:295:0x055a, B:297:0x0561, B:299:0x0567, B:300:0x056e, B:301:0x0571, B:302:0x0585, B:304:0x058b, B:306:0x0597, B:308:0x059f, B:312:0x05ad, B:315:0x05b7, B:317:0x05ca, B:318:0x05cd, B:320:0x05f7, B:321:0x05fa, B:327:0x063e, B:322:0x0602, B:324:0x0615, B:326:0x0638, B:333:0x065c, B:328:0x0649, B:330:0x064f, B:332:0x0659, B:334:0x0660, B:335:0x0670, B:349:0x068f, B:358:0x06b8, B:360:0x06bc, B:362:0x06c1, B:363:0x06c8, B:364:0x06c9, B:365:0x06d0, B:354:0x0699, B:356:0x06a6, B:357:0x06b1, B:48:0x0076, B:67:0x00bc, B:206:0x0385), top: B:439:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03c3 A[Catch: all -> 0x06d1, TryCatch #16 {, blocks: (B:20:0x001d, B:24:0x002b, B:26:0x002f, B:28:0x003d, B:30:0x0041, B:31:0x0046, B:42:0x0058, B:44:0x0060, B:45:0x0066, B:49:0x0081, B:51:0x0085, B:53:0x0089, B:55:0x0095, B:57:0x009e, B:61:0x00aa, B:63:0x00b4, B:65:0x00b8, B:71:0x00cc, B:73:0x00d4, B:74:0x00dc, B:76:0x00e0, B:80:0x00e8, B:87:0x0108, B:89:0x0113, B:91:0x0122, B:93:0x012f, B:95:0x0133, B:96:0x0136, B:97:0x0139, B:98:0x0140, B:90:0x011f, B:82:0x00ec, B:84:0x00f4, B:86:0x00fa, B:99:0x0141, B:101:0x017b, B:103:0x017f, B:104:0x0183, B:105:0x018a, B:106:0x018b, B:107:0x018f, B:109:0x0195, B:111:0x01b1, B:112:0x01b8, B:114:0x01cd, B:115:0x01d1, B:117:0x01e6, B:118:0x01ed, B:120:0x01f3, B:122:0x01f9, B:125:0x0209, B:126:0x020d, B:130:0x021b, B:134:0x0226, B:136:0x0232, B:140:0x0240, B:204:0x036f, B:205:0x0373, B:210:0x0391, B:214:0x039d, B:216:0x03a1, B:217:0x03a3, B:219:0x03ab, B:220:0x03bb, B:222:0x03c3, B:226:0x03d0, B:228:0x03d8, B:230:0x03e0, B:232:0x03ea, B:233:0x03f8, B:235:0x03fe, B:236:0x040d, B:238:0x0414, B:240:0x041f, B:242:0x0430, B:243:0x0441, B:245:0x0447, B:247:0x044c, B:249:0x045c, B:251:0x0462, B:252:0x0469, B:255:0x0475, B:256:0x0478, B:258:0x047c, B:260:0x0488, B:262:0x0497, B:264:0x049b, B:271:0x04c6, B:261:0x0490, B:267:0x04ac, B:269:0x04b6, B:270:0x04c1, B:272:0x04ca, B:274:0x04d7, B:276:0x04f2, B:278:0x04fe, B:280:0x0503, B:281:0x0507, B:283:0x050d, B:286:0x0520, B:288:0x0524, B:289:0x052d, B:290:0x0535, B:293:0x0554, B:295:0x055a, B:297:0x0561, B:299:0x0567, B:300:0x056e, B:301:0x0571, B:302:0x0585, B:304:0x058b, B:306:0x0597, B:308:0x059f, B:312:0x05ad, B:315:0x05b7, B:317:0x05ca, B:318:0x05cd, B:320:0x05f7, B:321:0x05fa, B:327:0x063e, B:322:0x0602, B:324:0x0615, B:326:0x0638, B:333:0x065c, B:328:0x0649, B:330:0x064f, B:332:0x0659, B:334:0x0660, B:335:0x0670, B:349:0x068f, B:358:0x06b8, B:360:0x06bc, B:362:0x06c1, B:363:0x06c8, B:364:0x06c9, B:365:0x06d0, B:354:0x0699, B:356:0x06a6, B:357:0x06b1, B:48:0x0076, B:67:0x00bc, B:206:0x0385), top: B:439:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0430 A[Catch: all -> 0x06d1, TryCatch #16 {, blocks: (B:20:0x001d, B:24:0x002b, B:26:0x002f, B:28:0x003d, B:30:0x0041, B:31:0x0046, B:42:0x0058, B:44:0x0060, B:45:0x0066, B:49:0x0081, B:51:0x0085, B:53:0x0089, B:55:0x0095, B:57:0x009e, B:61:0x00aa, B:63:0x00b4, B:65:0x00b8, B:71:0x00cc, B:73:0x00d4, B:74:0x00dc, B:76:0x00e0, B:80:0x00e8, B:87:0x0108, B:89:0x0113, B:91:0x0122, B:93:0x012f, B:95:0x0133, B:96:0x0136, B:97:0x0139, B:98:0x0140, B:90:0x011f, B:82:0x00ec, B:84:0x00f4, B:86:0x00fa, B:99:0x0141, B:101:0x017b, B:103:0x017f, B:104:0x0183, B:105:0x018a, B:106:0x018b, B:107:0x018f, B:109:0x0195, B:111:0x01b1, B:112:0x01b8, B:114:0x01cd, B:115:0x01d1, B:117:0x01e6, B:118:0x01ed, B:120:0x01f3, B:122:0x01f9, B:125:0x0209, B:126:0x020d, B:130:0x021b, B:134:0x0226, B:136:0x0232, B:140:0x0240, B:204:0x036f, B:205:0x0373, B:210:0x0391, B:214:0x039d, B:216:0x03a1, B:217:0x03a3, B:219:0x03ab, B:220:0x03bb, B:222:0x03c3, B:226:0x03d0, B:228:0x03d8, B:230:0x03e0, B:232:0x03ea, B:233:0x03f8, B:235:0x03fe, B:236:0x040d, B:238:0x0414, B:240:0x041f, B:242:0x0430, B:243:0x0441, B:245:0x0447, B:247:0x044c, B:249:0x045c, B:251:0x0462, B:252:0x0469, B:255:0x0475, B:256:0x0478, B:258:0x047c, B:260:0x0488, B:262:0x0497, B:264:0x049b, B:271:0x04c6, B:261:0x0490, B:267:0x04ac, B:269:0x04b6, B:270:0x04c1, B:272:0x04ca, B:274:0x04d7, B:276:0x04f2, B:278:0x04fe, B:280:0x0503, B:281:0x0507, B:283:0x050d, B:286:0x0520, B:288:0x0524, B:289:0x052d, B:290:0x0535, B:293:0x0554, B:295:0x055a, B:297:0x0561, B:299:0x0567, B:300:0x056e, B:301:0x0571, B:302:0x0585, B:304:0x058b, B:306:0x0597, B:308:0x059f, B:312:0x05ad, B:315:0x05b7, B:317:0x05ca, B:318:0x05cd, B:320:0x05f7, B:321:0x05fa, B:327:0x063e, B:322:0x0602, B:324:0x0615, B:326:0x0638, B:333:0x065c, B:328:0x0649, B:330:0x064f, B:332:0x0659, B:334:0x0660, B:335:0x0670, B:349:0x068f, B:358:0x06b8, B:360:0x06bc, B:362:0x06c1, B:363:0x06c8, B:364:0x06c9, B:365:0x06d0, B:354:0x0699, B:356:0x06a6, B:357:0x06b1, B:48:0x0076, B:67:0x00bc, B:206:0x0385), top: B:439:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0447 A[Catch: all -> 0x06d1, TryCatch #16 {, blocks: (B:20:0x001d, B:24:0x002b, B:26:0x002f, B:28:0x003d, B:30:0x0041, B:31:0x0046, B:42:0x0058, B:44:0x0060, B:45:0x0066, B:49:0x0081, B:51:0x0085, B:53:0x0089, B:55:0x0095, B:57:0x009e, B:61:0x00aa, B:63:0x00b4, B:65:0x00b8, B:71:0x00cc, B:73:0x00d4, B:74:0x00dc, B:76:0x00e0, B:80:0x00e8, B:87:0x0108, B:89:0x0113, B:91:0x0122, B:93:0x012f, B:95:0x0133, B:96:0x0136, B:97:0x0139, B:98:0x0140, B:90:0x011f, B:82:0x00ec, B:84:0x00f4, B:86:0x00fa, B:99:0x0141, B:101:0x017b, B:103:0x017f, B:104:0x0183, B:105:0x018a, B:106:0x018b, B:107:0x018f, B:109:0x0195, B:111:0x01b1, B:112:0x01b8, B:114:0x01cd, B:115:0x01d1, B:117:0x01e6, B:118:0x01ed, B:120:0x01f3, B:122:0x01f9, B:125:0x0209, B:126:0x020d, B:130:0x021b, B:134:0x0226, B:136:0x0232, B:140:0x0240, B:204:0x036f, B:205:0x0373, B:210:0x0391, B:214:0x039d, B:216:0x03a1, B:217:0x03a3, B:219:0x03ab, B:220:0x03bb, B:222:0x03c3, B:226:0x03d0, B:228:0x03d8, B:230:0x03e0, B:232:0x03ea, B:233:0x03f8, B:235:0x03fe, B:236:0x040d, B:238:0x0414, B:240:0x041f, B:242:0x0430, B:243:0x0441, B:245:0x0447, B:247:0x044c, B:249:0x045c, B:251:0x0462, B:252:0x0469, B:255:0x0475, B:256:0x0478, B:258:0x047c, B:260:0x0488, B:262:0x0497, B:264:0x049b, B:271:0x04c6, B:261:0x0490, B:267:0x04ac, B:269:0x04b6, B:270:0x04c1, B:272:0x04ca, B:274:0x04d7, B:276:0x04f2, B:278:0x04fe, B:280:0x0503, B:281:0x0507, B:283:0x050d, B:286:0x0520, B:288:0x0524, B:289:0x052d, B:290:0x0535, B:293:0x0554, B:295:0x055a, B:297:0x0561, B:299:0x0567, B:300:0x056e, B:301:0x0571, B:302:0x0585, B:304:0x058b, B:306:0x0597, B:308:0x059f, B:312:0x05ad, B:315:0x05b7, B:317:0x05ca, B:318:0x05cd, B:320:0x05f7, B:321:0x05fa, B:327:0x063e, B:322:0x0602, B:324:0x0615, B:326:0x0638, B:333:0x065c, B:328:0x0649, B:330:0x064f, B:332:0x0659, B:334:0x0660, B:335:0x0670, B:349:0x068f, B:358:0x06b8, B:360:0x06bc, B:362:0x06c1, B:363:0x06c8, B:364:0x06c9, B:365:0x06d0, B:354:0x0699, B:356:0x06a6, B:357:0x06b1, B:48:0x0076, B:67:0x00bc, B:206:0x0385), top: B:439:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x044c A[Catch: all -> 0x06d1, TryCatch #16 {, blocks: (B:20:0x001d, B:24:0x002b, B:26:0x002f, B:28:0x003d, B:30:0x0041, B:31:0x0046, B:42:0x0058, B:44:0x0060, B:45:0x0066, B:49:0x0081, B:51:0x0085, B:53:0x0089, B:55:0x0095, B:57:0x009e, B:61:0x00aa, B:63:0x00b4, B:65:0x00b8, B:71:0x00cc, B:73:0x00d4, B:74:0x00dc, B:76:0x00e0, B:80:0x00e8, B:87:0x0108, B:89:0x0113, B:91:0x0122, B:93:0x012f, B:95:0x0133, B:96:0x0136, B:97:0x0139, B:98:0x0140, B:90:0x011f, B:82:0x00ec, B:84:0x00f4, B:86:0x00fa, B:99:0x0141, B:101:0x017b, B:103:0x017f, B:104:0x0183, B:105:0x018a, B:106:0x018b, B:107:0x018f, B:109:0x0195, B:111:0x01b1, B:112:0x01b8, B:114:0x01cd, B:115:0x01d1, B:117:0x01e6, B:118:0x01ed, B:120:0x01f3, B:122:0x01f9, B:125:0x0209, B:126:0x020d, B:130:0x021b, B:134:0x0226, B:136:0x0232, B:140:0x0240, B:204:0x036f, B:205:0x0373, B:210:0x0391, B:214:0x039d, B:216:0x03a1, B:217:0x03a3, B:219:0x03ab, B:220:0x03bb, B:222:0x03c3, B:226:0x03d0, B:228:0x03d8, B:230:0x03e0, B:232:0x03ea, B:233:0x03f8, B:235:0x03fe, B:236:0x040d, B:238:0x0414, B:240:0x041f, B:242:0x0430, B:243:0x0441, B:245:0x0447, B:247:0x044c, B:249:0x045c, B:251:0x0462, B:252:0x0469, B:255:0x0475, B:256:0x0478, B:258:0x047c, B:260:0x0488, B:262:0x0497, B:264:0x049b, B:271:0x04c6, B:261:0x0490, B:267:0x04ac, B:269:0x04b6, B:270:0x04c1, B:272:0x04ca, B:274:0x04d7, B:276:0x04f2, B:278:0x04fe, B:280:0x0503, B:281:0x0507, B:283:0x050d, B:286:0x0520, B:288:0x0524, B:289:0x052d, B:290:0x0535, B:293:0x0554, B:295:0x055a, B:297:0x0561, B:299:0x0567, B:300:0x056e, B:301:0x0571, B:302:0x0585, B:304:0x058b, B:306:0x0597, B:308:0x059f, B:312:0x05ad, B:315:0x05b7, B:317:0x05ca, B:318:0x05cd, B:320:0x05f7, B:321:0x05fa, B:327:0x063e, B:322:0x0602, B:324:0x0615, B:326:0x0638, B:333:0x065c, B:328:0x0649, B:330:0x064f, B:332:0x0659, B:334:0x0660, B:335:0x0670, B:349:0x068f, B:358:0x06b8, B:360:0x06bc, B:362:0x06c1, B:363:0x06c8, B:364:0x06c9, B:365:0x06d0, B:354:0x0699, B:356:0x06a6, B:357:0x06b1, B:48:0x0076, B:67:0x00bc, B:206:0x0385), top: B:439:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04ca A[Catch: all -> 0x06d1, TryCatch #16 {, blocks: (B:20:0x001d, B:24:0x002b, B:26:0x002f, B:28:0x003d, B:30:0x0041, B:31:0x0046, B:42:0x0058, B:44:0x0060, B:45:0x0066, B:49:0x0081, B:51:0x0085, B:53:0x0089, B:55:0x0095, B:57:0x009e, B:61:0x00aa, B:63:0x00b4, B:65:0x00b8, B:71:0x00cc, B:73:0x00d4, B:74:0x00dc, B:76:0x00e0, B:80:0x00e8, B:87:0x0108, B:89:0x0113, B:91:0x0122, B:93:0x012f, B:95:0x0133, B:96:0x0136, B:97:0x0139, B:98:0x0140, B:90:0x011f, B:82:0x00ec, B:84:0x00f4, B:86:0x00fa, B:99:0x0141, B:101:0x017b, B:103:0x017f, B:104:0x0183, B:105:0x018a, B:106:0x018b, B:107:0x018f, B:109:0x0195, B:111:0x01b1, B:112:0x01b8, B:114:0x01cd, B:115:0x01d1, B:117:0x01e6, B:118:0x01ed, B:120:0x01f3, B:122:0x01f9, B:125:0x0209, B:126:0x020d, B:130:0x021b, B:134:0x0226, B:136:0x0232, B:140:0x0240, B:204:0x036f, B:205:0x0373, B:210:0x0391, B:214:0x039d, B:216:0x03a1, B:217:0x03a3, B:219:0x03ab, B:220:0x03bb, B:222:0x03c3, B:226:0x03d0, B:228:0x03d8, B:230:0x03e0, B:232:0x03ea, B:233:0x03f8, B:235:0x03fe, B:236:0x040d, B:238:0x0414, B:240:0x041f, B:242:0x0430, B:243:0x0441, B:245:0x0447, B:247:0x044c, B:249:0x045c, B:251:0x0462, B:252:0x0469, B:255:0x0475, B:256:0x0478, B:258:0x047c, B:260:0x0488, B:262:0x0497, B:264:0x049b, B:271:0x04c6, B:261:0x0490, B:267:0x04ac, B:269:0x04b6, B:270:0x04c1, B:272:0x04ca, B:274:0x04d7, B:276:0x04f2, B:278:0x04fe, B:280:0x0503, B:281:0x0507, B:283:0x050d, B:286:0x0520, B:288:0x0524, B:289:0x052d, B:290:0x0535, B:293:0x0554, B:295:0x055a, B:297:0x0561, B:299:0x0567, B:300:0x056e, B:301:0x0571, B:302:0x0585, B:304:0x058b, B:306:0x0597, B:308:0x059f, B:312:0x05ad, B:315:0x05b7, B:317:0x05ca, B:318:0x05cd, B:320:0x05f7, B:321:0x05fa, B:327:0x063e, B:322:0x0602, B:324:0x0615, B:326:0x0638, B:333:0x065c, B:328:0x0649, B:330:0x064f, B:332:0x0659, B:334:0x0660, B:335:0x0670, B:349:0x068f, B:358:0x06b8, B:360:0x06bc, B:362:0x06c1, B:363:0x06c8, B:364:0x06c9, B:365:0x06d0, B:354:0x0699, B:356:0x06a6, B:357:0x06b1, B:48:0x0076, B:67:0x00bc, B:206:0x0385), top: B:439:0x001d }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void run() {
        JSONObject jSONObject;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        JSONObject jSONObject2;
        PackageInfo packageInfo;
        ApkInfo apkInfo;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        boolean z;
        int indexOf;
        int indexOf2;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
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
                        int i = this.mFrom;
                        if (i != 1 && i != 2 && i != 3 && !this.mOut && System.currentTimeMillis() - sLastCheckTime < 600000) {
                            if (this.mEndReason == 0) {
                                this.mEndReason = 2;
                                handleThreadEnd(null);
                            }
                            if (this.mOut && sOutGoing) {
                                sOutGoing = false;
                            }
                            return;
                        }
                        if (com.baidu.sofire.k.a.l(this.context)) {
                            sLastCheckTime = System.currentTimeMillis();
                        }
                        com.baidu.sofire.a.a.a(this.context, false);
                        com.baidu.sofire.a.a.a(this.context);
                        int i2 = this.mFrom;
                        if (i2 == 1 || i2 == 3) {
                            sRetryPingTimesCount = 0;
                            sRetryDownoadHostCareApksTimesCount = 0;
                            com.baidu.sofire.a.a.a(this.context, 0, true);
                            sSetRetrmAlarm = false;
                        }
                        if (this.mFrom == 2) {
                            sSetRetrmAlarm = false;
                        }
                        boolean z2 = "com.baidu.input_huawei".equals(this.context.getPackageName()) ? !this.mPreferenceManager.b() : false;
                        if (com.baidu.sofire.k.a.l(this.context) && !z2) {
                            sLastCheckTime = System.currentTimeMillis();
                            if (com.baidu.sofire.k.a.g != null && (sMonitorNetworkWhenUpgradeNoNet || com.baidu.sofire.k.a.a)) {
                                this.context.getApplicationContext().unregisterReceiver(com.baidu.sofire.k.a.g);
                            }
                            sMonitorNetworkWhenUpgradeNoNet = false;
                            com.baidu.sofire.k.a.a = false;
                            if (this.mFrom != 1) {
                                this.mWholeJson = com.baidu.sofire.k.a.o(this.context);
                            }
                            JSONObject jSONObject3 = this.mWholeJson;
                            if (jSONObject3 == null) {
                                int i3 = this.mFrom;
                                if ((i3 == 1 || i3 == 2 || (i3 == 3 && !sSetRetrmAlarm)) && ((ArrayList) this.mPreferenceManager.e()).size() > 0) {
                                    sSetRetrmAlarm = true;
                                    com.baidu.sofire.a.a.a(this.context, sRetryPingTimesCount, false);
                                    sRetryPingTimesCount++;
                                }
                                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                                MyReceiver myReceiver = com.baidu.sofire.k.a.g;
                                if (myReceiver == null) {
                                    com.baidu.sofire.k.a.g = new MyReceiver().a();
                                } else {
                                    myReceiver.a();
                                }
                                com.baidu.sofire.k.a.a(this.context, com.baidu.sofire.k.a.g, intentFilter);
                                sMonitorNetworkWhenUpgradeNoNet = true;
                                if (this.mEndReason == 0) {
                                    int i4 = com.baidu.sofire.k.a.d;
                                    if (i4 != 0) {
                                        this.mEndReason = i4;
                                    } else {
                                        this.mEndReason = 4;
                                    }
                                }
                                throw new NetworkErrorException("ping faild");
                            }
                            sRetryPingTimesCount = 0;
                            this.forHostAPP.a(jSONObject3);
                            this.loadedPluginDB.a();
                            com.baidu.sofire.j.a aVar = this.mPreferenceManager;
                            aVar.d(aVar.m() + 1);
                            List<ApkInfo> b = this.loadedPluginDB.b();
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = new ArrayList();
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = new ArrayList();
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
                                if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
                                    jSONObject = optJSONObject3;
                                    str = str2;
                                } else {
                                    jSONObject = optJSONObject3;
                                    str = str2;
                                    sRealtimeMd5Map.put(str3, str);
                                }
                                if (optString4 != null) {
                                    optString4 = optString4.toLowerCase();
                                }
                                int i5 = optJSONObject4.optInt("o") == 1 ? 1 : 0;
                                boolean z3 = optJSONObject4.optInt("d") == 1;
                                int optInt2 = optJSONObject4.optInt("r");
                                Iterator<String> it = keys;
                                int i6 = i5;
                                if (i6 != 0) {
                                    arrayList = arrayList8;
                                    this.mPreferenceManager.a(optInt2);
                                } else {
                                    arrayList = arrayList8;
                                }
                                if (i6 != 0 && z3) {
                                    arrayList10.add(next);
                                    arrayList6 = arrayList9;
                                    arrayList3 = arrayList10;
                                    arrayList7 = arrayList11;
                                    arrayList5 = arrayList;
                                } else {
                                    try {
                                        packageInfo = new PackageInfo();
                                        packageInfo.packageName = optJSONObject4.optString("p");
                                        packageInfo.versionName = optString;
                                        ApplicationInfo applicationInfo = new ApplicationInfo();
                                        String optString5 = optJSONObject4.optString("n");
                                        applicationInfo.className = optString5;
                                        if (TextUtils.isEmpty(optString5)) {
                                            arrayList3 = arrayList10;
                                        } else {
                                            try {
                                                arrayList3 = arrayList10;
                                                try {
                                                    if (applicationInfo.className.startsWith(".")) {
                                                        applicationInfo.className = next + applicationInfo.className;
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    arrayList2 = arrayList9;
                                                    arrayList4 = arrayList11;
                                                    jSONObject2 = optJSONObject4;
                                                    com.baidu.sofire.k.a.a(th);
                                                    packageInfo = null;
                                                    JSONObject jSONObject4 = jSONObject2;
                                                    apkInfo = new ApkInfo(optInt, next, optString, optString2, str);
                                                    apkInfo.isOnce = i6;
                                                    apkInfo.priority = jSONObject4.getInt(Config.PRINCIPAL_PART);
                                                    apkInfo.isMem = jSONObject4.optInt("mem") == 1;
                                                    if (packageInfo != null) {
                                                    }
                                                    optJSONObject = jSONObject4.optJSONObject("e");
                                                    if (optJSONObject != null) {
                                                    }
                                                    optJSONObject2 = jSONObject4.optJSONObject("ext");
                                                    if (optJSONObject2 != null) {
                                                    }
                                                    apkInfo.signMD5 = optString4;
                                                    apkInfo.startTime = System.currentTimeMillis();
                                                    ArrayList arrayList12 = (ArrayList) b;
                                                    indexOf = arrayList12.indexOf(apkInfo);
                                                    ApkInfo apkInfo2 = new ApkInfo(apkInfo);
                                                    if (!TextUtils.isEmpty(apkInfo.packageName)) {
                                                    }
                                                    indexOf2 = arrayList12.indexOf(apkInfo2);
                                                    if (indexOf2 >= 0) {
                                                    }
                                                    if (indexOf >= 0) {
                                                    }
                                                    arrayList11 = arrayList7;
                                                    optJSONObject3 = jSONObject;
                                                    keys = it;
                                                    arrayList10 = arrayList3;
                                                    ArrayList arrayList13 = arrayList5;
                                                    arrayList9 = arrayList6;
                                                    arrayList8 = arrayList13;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                arrayList3 = arrayList10;
                                            }
                                        }
                                        applicationInfo.theme = optJSONObject4.optInt("t");
                                        packageInfo.applicationInfo = applicationInfo;
                                        JSONArray optJSONArray = optJSONObject4.optJSONArray("a");
                                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                                            arrayList2 = arrayList9;
                                            arrayList4 = arrayList11;
                                            jSONObject2 = optJSONObject4;
                                        } else {
                                            ArrayList arrayList14 = new ArrayList();
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
                                                                arrayList2 = arrayList9;
                                                                try {
                                                                    String optString6 = jSONObject5.optString("n");
                                                                    activityInfo.name = optString6;
                                                                    if (TextUtils.isEmpty(optString6)) {
                                                                        arrayList4 = arrayList11;
                                                                    } else {
                                                                        arrayList4 = arrayList11;
                                                                        try {
                                                                            if (activityInfo.name.startsWith(".")) {
                                                                                activityInfo.name = next + activityInfo.name;
                                                                            }
                                                                        } catch (Throwable th3) {
                                                                            th = th3;
                                                                            try {
                                                                                com.baidu.sofire.k.a.a(th);
                                                                                continue;
                                                                                i7++;
                                                                                optJSONArray = jSONArray;
                                                                                arrayList9 = arrayList2;
                                                                                arrayList11 = arrayList4;
                                                                            } catch (Throwable th4) {
                                                                                th = th4;
                                                                                com.baidu.sofire.k.a.a(th);
                                                                                packageInfo = null;
                                                                                JSONObject jSONObject42 = jSONObject2;
                                                                                apkInfo = new ApkInfo(optInt, next, optString, optString2, str);
                                                                                apkInfo.isOnce = i6;
                                                                                apkInfo.priority = jSONObject42.getInt(Config.PRINCIPAL_PART);
                                                                                apkInfo.isMem = jSONObject42.optInt("mem") == 1;
                                                                                if (packageInfo != null) {
                                                                                }
                                                                                optJSONObject = jSONObject42.optJSONObject("e");
                                                                                if (optJSONObject != null) {
                                                                                }
                                                                                optJSONObject2 = jSONObject42.optJSONObject("ext");
                                                                                if (optJSONObject2 != null) {
                                                                                }
                                                                                apkInfo.signMD5 = optString4;
                                                                                apkInfo.startTime = System.currentTimeMillis();
                                                                                ArrayList arrayList122 = (ArrayList) b;
                                                                                indexOf = arrayList122.indexOf(apkInfo);
                                                                                ApkInfo apkInfo22 = new ApkInfo(apkInfo);
                                                                                if (!TextUtils.isEmpty(apkInfo.packageName)) {
                                                                                }
                                                                                indexOf2 = arrayList122.indexOf(apkInfo22);
                                                                                if (indexOf2 >= 0) {
                                                                                }
                                                                                if (indexOf >= 0) {
                                                                                }
                                                                                arrayList11 = arrayList7;
                                                                                optJSONObject3 = jSONObject;
                                                                                keys = it;
                                                                                arrayList10 = arrayList3;
                                                                                ArrayList arrayList132 = arrayList5;
                                                                                arrayList9 = arrayList6;
                                                                                arrayList8 = arrayList132;
                                                                            }
                                                                        }
                                                                    }
                                                                    activityInfo.packageName = next;
                                                                    activityInfo.theme = jSONObject5.optInt("t");
                                                                    activityInfo.labelRes = jSONObject5.optInt("l");
                                                                    if (TextUtils.isEmpty(activityInfo.name)) {
                                                                        continue;
                                                                    } else {
                                                                        arrayList14.add(activityInfo);
                                                                        continue;
                                                                    }
                                                                } catch (Throwable th5) {
                                                                    th = th5;
                                                                    arrayList4 = arrayList11;
                                                                    com.baidu.sofire.k.a.a(th);
                                                                    continue;
                                                                    i7++;
                                                                    optJSONArray = jSONArray;
                                                                    arrayList9 = arrayList2;
                                                                    arrayList11 = arrayList4;
                                                                }
                                                            } catch (Throwable th6) {
                                                                th = th6;
                                                                arrayList2 = arrayList9;
                                                                arrayList4 = arrayList11;
                                                                com.baidu.sofire.k.a.a(th);
                                                                continue;
                                                                i7++;
                                                                optJSONArray = jSONArray;
                                                                arrayList9 = arrayList2;
                                                                arrayList11 = arrayList4;
                                                            }
                                                        } else {
                                                            jSONArray = optJSONArray;
                                                            arrayList2 = arrayList9;
                                                            arrayList4 = arrayList11;
                                                            continue;
                                                        }
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        jSONArray = optJSONArray;
                                                    }
                                                    i7++;
                                                    optJSONArray = jSONArray;
                                                    arrayList9 = arrayList2;
                                                    arrayList11 = arrayList4;
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    arrayList2 = arrayList9;
                                                    arrayList4 = arrayList11;
                                                }
                                            }
                                            arrayList2 = arrayList9;
                                            arrayList4 = arrayList11;
                                            if (arrayList14.size() > 0) {
                                                packageInfo.activities = (ActivityInfo[]) arrayList14.toArray(new ActivityInfo[arrayList14.size()]);
                                            }
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                        arrayList2 = arrayList9;
                                        arrayList3 = arrayList10;
                                    }
                                    JSONObject jSONObject422 = jSONObject2;
                                    apkInfo = new ApkInfo(optInt, next, optString, optString2, str);
                                    apkInfo.isOnce = i6;
                                    apkInfo.priority = jSONObject422.getInt(Config.PRINCIPAL_PART);
                                    apkInfo.isMem = jSONObject422.optInt("mem") == 1;
                                    if (packageInfo != null) {
                                        apkInfo.cloudPkgInfo = packageInfo;
                                    }
                                    optJSONObject = jSONObject422.optJSONObject("e");
                                    if (optJSONObject != null) {
                                        int optInt3 = optJSONObject.optInt("d");
                                        int optInt4 = optJSONObject.optInt("n");
                                        apkInfo.duration = optInt3;
                                        apkInfo.network = optInt4;
                                    }
                                    optJSONObject2 = jSONObject422.optJSONObject("ext");
                                    if (optJSONObject2 != null) {
                                        z = optJSONObject2.optInt("nl", 0) == 1;
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
                                    } else {
                                        z = false;
                                    }
                                    apkInfo.signMD5 = optString4;
                                    apkInfo.startTime = System.currentTimeMillis();
                                    ArrayList arrayList1222 = (ArrayList) b;
                                    indexOf = arrayList1222.indexOf(apkInfo);
                                    ApkInfo apkInfo222 = new ApkInfo(apkInfo);
                                    if (!TextUtils.isEmpty(apkInfo.packageName)) {
                                        apkInfo222.packageName = new StringBuilder(apkInfo222.packageName).reverse().toString();
                                    }
                                    indexOf2 = arrayList1222.indexOf(apkInfo222);
                                    if (indexOf2 >= 0) {
                                        arrayList1222.remove(indexOf2);
                                    }
                                    if (indexOf >= 0) {
                                        ApkInfo apkInfo3 = (ApkInfo) arrayList1222.get(indexOf);
                                        if (com.baidu.sofire.k.a.b(apkInfo.versionName, apkInfo3.versionName)) {
                                            int i9 = apkInfo3.priority;
                                            int i10 = apkInfo.priority;
                                            if (i9 != i10) {
                                                this.loadedPluginDB.e(apkInfo.key, i10);
                                            }
                                            if (this.loadedPluginDB.f(apkInfo3.key)) {
                                                arrayList6 = arrayList2;
                                                arrayList7 = arrayList4;
                                            } else {
                                                if (z) {
                                                    apkInfo.isNextLoad = true;
                                                }
                                                List<Integer> list = d.g;
                                                if (list != null && list.contains(Integer.valueOf(apkInfo.key))) {
                                                    arrayList7 = arrayList4;
                                                    arrayList7.add(apkInfo);
                                                    arrayList6 = arrayList2;
                                                } else {
                                                    arrayList7 = arrayList4;
                                                    arrayList6 = arrayList2;
                                                    arrayList6.add(apkInfo);
                                                }
                                                List<Integer> list2 = this.mDownloadPluginsList;
                                                if (list2 != null) {
                                                    list2.add(Integer.valueOf(apkInfo.key));
                                                }
                                            }
                                            arrayList5 = arrayList;
                                        } else {
                                            arrayList6 = arrayList2;
                                            arrayList7 = arrayList4;
                                            int i11 = apkInfo3.priority;
                                            int i12 = apkInfo.priority;
                                            if (i11 != i12) {
                                                apkInfo3.priority = i12;
                                                this.loadedPluginDB.e(apkInfo.key, apkInfo.priority);
                                            }
                                            arrayList5 = arrayList;
                                            arrayList5.add(apkInfo3);
                                        }
                                        arrayList1222.remove(indexOf);
                                    } else {
                                        arrayList5 = arrayList;
                                        arrayList6 = arrayList2;
                                        arrayList7 = arrayList4;
                                        arrayList6.add(apkInfo);
                                        List<Integer> list3 = this.mDownloadPluginsList;
                                        if (list3 != null) {
                                            list3.add(Integer.valueOf(apkInfo.key));
                                        }
                                    }
                                }
                                arrayList11 = arrayList7;
                                optJSONObject3 = jSONObject;
                                keys = it;
                                arrayList10 = arrayList3;
                                ArrayList arrayList1322 = arrayList5;
                                arrayList9 = arrayList6;
                                arrayList8 = arrayList1322;
                            }
                            ArrayList arrayList15 = arrayList10;
                            ArrayList arrayList16 = arrayList11;
                            ArrayList arrayList17 = arrayList9;
                            ArrayList arrayList18 = arrayList8;
                            List<Integer> list4 = d.g;
                            if (list4 != null) {
                                list4.clear();
                            }
                            Iterator it2 = ((ArrayList) b).iterator();
                            while (it2.hasNext()) {
                                ApkInfo apkInfo4 = (ApkInfo) it2.next();
                                ArrayList arrayList19 = arrayList15;
                                if (!arrayList19.contains(apkInfo4.packageName)) {
                                    List<Integer> list5 = this.mUnloadPluginsList;
                                    if (list5 != null) {
                                        list5.add(Integer.valueOf(apkInfo4.key));
                                    }
                                    this.forHostAPP.b(apkInfo4.packageName);
                                }
                                arrayList15 = arrayList19;
                            }
                            com.baidu.sofire.k.a.q(this.context);
                            k a = k.a(this.context.getApplicationContext());
                            List<Integer> f = this.mPreferenceManager.f();
                            List<Integer> e2 = this.mPreferenceManager.e();
                            int i13 = 0;
                            while (true) {
                                ArrayList arrayList20 = (ArrayList) e2;
                                if (i13 >= arrayList20.size()) {
                                    break;
                                }
                                ArrayList arrayList21 = (ArrayList) f;
                                if (!arrayList21.contains(arrayList20.get(i13))) {
                                    arrayList21.add(arrayList20.get(i13));
                                }
                                i13++;
                            }
                            ArrayList arrayList22 = new ArrayList();
                            arrayList22.addAll(arrayList18);
                            arrayList22.addAll(arrayList17);
                            Collections.sort(arrayList22, new Comparator<ApkInfo>(this, f) { // from class: com.baidu.sofire.ac.U.1
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
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, apkInfo5, apkInfo6)) == null) {
                                        int i15 = apkInfo5.priority;
                                        if (i15 != -1 || apkInfo6.priority == -1) {
                                            if ((i15 == -1 || apkInfo6.priority != -1) && i15 >= (i14 = apkInfo6.priority)) {
                                                if (i15 > i14) {
                                                    return 1;
                                                }
                                                List list6 = this.val$localSetIds;
                                                int indexOf3 = (list6 == null || !list6.contains(Integer.valueOf(apkInfo5.key))) ? -1 : this.val$localSetIds.indexOf(Integer.valueOf(apkInfo5.key));
                                                List list7 = this.val$localSetIds;
                                                int indexOf4 = (list7 == null || !list7.contains(Integer.valueOf(apkInfo6.key))) ? -1 : this.val$localSetIds.indexOf(Integer.valueOf(apkInfo6.key));
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
                            for (int i14 = 0; i14 < arrayList22.size(); i14++) {
                                ApkInfo apkInfo5 = (ApkInfo) arrayList22.get(i14);
                                if (arrayList18.contains(apkInfo5)) {
                                    if (a.b(apkInfo5.packageName) == null) {
                                        boolean z4 = this.loadedPluginDB.c(apkInfo5.key) != 3;
                                        if (this.mPreferenceManager.n() && z4) {
                                            File file = new File(this.context.getFilesDir(), ".b");
                                            if (!file.exists()) {
                                                file.mkdir();
                                            }
                                            File file2 = new File(apkInfo5.pkgPath);
                                            File file3 = new File(file, apkInfo5.key + "-" + apkInfo5.versionName);
                                            if (!com.baidu.sofire.k.a.a(file3)) {
                                                com.baidu.sofire.k.a.a(file2, file3);
                                            }
                                            c.a(this.context, apkInfo5.key, file2, file3);
                                        } else {
                                            File file4 = new File(this.context.getFilesDir(), ".b");
                                            if (file4.exists()) {
                                                File file5 = new File(file4, apkInfo5.key + "-" + apkInfo5.versionName);
                                                if (com.baidu.sofire.k.a.a(file5)) {
                                                    c.a(file5);
                                                    file5.delete();
                                                }
                                            }
                                        }
                                        this.forHostAPP.a(apkInfo5.key, apkInfo5.versionName, null);
                                    }
                                } else if (arrayList17.contains(apkInfo5) && !this.loadedPluginDB.f(apkInfo5.key)) {
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
                                        int i15 = newInitContext.flag;
                                        if ((i15 & 1) != 0) {
                                            int i16 = i15 & 2;
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
                                    List<ApkInfo> list6;
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (list6 = this.val$pluginNeedDelayUpdate) == null) {
                                        return;
                                    }
                                    for (ApkInfo apkInfo6 : list6) {
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
                        int i15 = this.mFrom;
                        if (i15 == 1 || i15 == 2 || i15 == 3) {
                            sMonitorNetworkWhenUpgradeNoNet = true;
                            IntentFilter intentFilter2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                            if (com.baidu.sofire.k.a.g == null) {
                                com.baidu.sofire.k.a.g = new MyReceiver().a();
                            }
                            com.baidu.sofire.k.a.a(this.context, com.baidu.sofire.k.a.g, intentFilter2);
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
        this.loadedPluginDB = a.a(context);
        this.mPreferenceManager = com.baidu.sofire.j.a.a(context);
        this.forHostAPP = d.a(context);
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
