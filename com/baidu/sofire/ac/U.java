package com.baidu.sofire.ac;

import android.accounts.NetworkErrorException;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.MyService;
import com.baidu.sofire.a.a;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.core.f;
import com.baidu.sofire.core.i;
import com.baidu.sofire.jni.Asc;
import com.baidu.sofire.utility.h;
import com.baidu.sofire.utility.o;
import com.baidu.sofire.utility.q;
import com.baidu.sofire.utility.s;
import com.baidu.sofire.utility.z;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.x;
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
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class U implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_DAILY_ALARM = 6;
    public static final int FROM_DEFAULT = 0;
    public static final int FROM_HANDLE_REMOVE = 4;
    public static final int FROM_INIT = 1;
    public static final int FROM_INIT_ALARM = 2;
    public static final int FROM_NET_CHANGE = 3;
    public static final int FROM_OUT_FLASH = 5;
    public static final int MINUTE = 60000;
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
    public static long sLastCheckTime;
    public static boolean sMonitorNetworkWhenUpgradeNoNet;
    public static volatile boolean sOutGoing;
    public static Map<String, String> sRealtimeMd5Map;
    public static int sRetryDownoadHostCareApksTimesCount;
    public static int sRetryPingTimesCount;
    public static boolean sSetRetrmAlarm;
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;
    public c forHostAPP;
    public a loadedPluginDB;
    public Map<Integer, String> mCloudKeyMap;
    public List<Integer> mDownloadPluginsList;
    public int mEndReason;
    public int mFrom;
    public boolean mOut;
    public com.baidu.sofire.h.a mPreferenceManager;
    public Map<Integer, String> mStartKeyMap;
    public int mStartNetwork;
    public List<Integer> mUnloadPluginsList;
    public Map<Integer, UpgradeResult> mUpgradeResultMap;
    public JSONObject mWholeJson;
    public File tmpDir;

    /* loaded from: classes10.dex */
    public class UpgradeResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int networkId;
        public int resultId;
        public final /* synthetic */ U this$0;

        public UpgradeResult(U u, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = u;
            this.networkId = i2;
            this.resultId = i3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-130218012, "Lcom/baidu/sofire/ac/U;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-130218012, "Lcom/baidu/sofire/ac/U;");
        }
    }

    public U(Context context, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        this.mPreferenceManager = com.baidu.sofire.h.a.a(context);
        this.forHostAPP = c.a(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.mFrom = i2;
        this.mOut = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePluginDownError(ApkInfo apkInfo, File file, int i2, List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65544, this, apkInfo, file, i2, list) == null) {
            Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
            if (map != null && !map.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i2, 8));
            }
            int i3 = this.mFrom;
            if (i3 == 1 || i3 == 2 || i3 == 3) {
                if (list != null && list.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                    sSetRetrmAlarm = true;
                    com.baidu.sofire.utility.a.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                    sRetryDownoadHostCareApksTimesCount++;
                }
                if (!sMonitorNetworkWhenUpgradeNoNet) {
                    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    MyReceiver myReceiver = com.baidu.sofire.utility.c.f39681g;
                    if (myReceiver == null) {
                        com.baidu.sofire.utility.c.f39681g = new MyReceiver().a();
                    } else {
                        myReceiver.a();
                    }
                    com.baidu.sofire.utility.c.a(this.context, com.baidu.sofire.utility.c.f39681g, intentFilter);
                    sMonitorNetworkWhenUpgradeNoNet = true;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.sofire.h.a aVar = this.mPreferenceManager;
            long j2 = aVar.a.getLong("pu_ap_fd", 0L);
            if (j2 == 0) {
                j2 = System.currentTimeMillis();
                aVar.c();
            }
            if (currentTimeMillis - j2 > 86400000) {
                HashMap hashMap = new HashMap();
                if (com.baidu.sofire.utility.c.e(this.context)) {
                    hashMap.put("0", Integer.valueOf(this.mPreferenceManager.d() + 1));
                    hashMap.put("1", Integer.valueOf(this.mPreferenceManager.e()));
                } else {
                    hashMap.put("0", Integer.valueOf(this.mPreferenceManager.d()));
                    hashMap.put("1", Integer.valueOf(this.mPreferenceManager.e() + 1));
                }
                this.mPreferenceManager.a(0);
                this.mPreferenceManager.b(0);
                this.mPreferenceManager.c();
                com.baidu.sofire.utility.c.a(this.context, "1003116", (Map<String, Object>) hashMap, false);
            } else if (com.baidu.sofire.utility.c.e(this.context)) {
                com.baidu.sofire.h.a aVar2 = this.mPreferenceManager;
                aVar2.a(aVar2.d() + 1);
            } else {
                com.baidu.sofire.h.a aVar3 = this.mPreferenceManager;
                aVar3.b(aVar3.e() + 1);
            }
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handlePluginDownload(ApkInfo apkInfo, File file, File file2, int i2) {
        InterceptResult invokeLLLI;
        boolean a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65545, this, apkInfo, file, file2, i2)) == null) {
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            if (!"com.baidu.input_huawei".equals(this.context.getPackageName()) || this.mPreferenceManager.w()) {
                if (s.a(this.context)) {
                    a = new s(this.context).a(apkInfo.downloadURL, file);
                } else {
                    a = new o(this.context).a(apkInfo.downloadURL, file);
                }
                if (a) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    new Asc();
                    if (h.a(file, file2, apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes("utf-8")) != 0) {
                        if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i2, 7));
                        }
                        a = false;
                    }
                } else if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i2, 4));
                }
                String a2 = q.a(file2);
                file.delete();
                if (a) {
                    if (apkInfo.apkMD5.equals(a2)) {
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
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cc A[Catch: all -> 0x01d0, TryCatch #0 {all -> 0x01d0, blocks: (B:5:0x000b, B:7:0x0023, B:9:0x002d, B:11:0x0031, B:13:0x0043, B:15:0x0054, B:17:0x005c, B:18:0x0061, B:20:0x00b7, B:25:0x00cc, B:27:0x00d0, B:38:0x0118, B:74:0x01cc, B:41:0x0120, B:43:0x012a, B:48:0x0138, B:50:0x0140, B:52:0x014a, B:53:0x0155, B:55:0x015d, B:58:0x0168, B:61:0x0170, B:63:0x017c, B:65:0x0189, B:66:0x019a, B:70:0x01af, B:72:0x01c1, B:67:0x019f, B:28:0x00ea, B:30:0x00f3, B:32:0x0103, B:34:0x0110), top: B:108:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0118 A[Catch: all -> 0x01d0, TryCatch #0 {all -> 0x01d0, blocks: (B:5:0x000b, B:7:0x0023, B:9:0x002d, B:11:0x0031, B:13:0x0043, B:15:0x0054, B:17:0x005c, B:18:0x0061, B:20:0x00b7, B:25:0x00cc, B:27:0x00d0, B:38:0x0118, B:74:0x01cc, B:41:0x0120, B:43:0x012a, B:48:0x0138, B:50:0x0140, B:52:0x014a, B:53:0x0155, B:55:0x015d, B:58:0x0168, B:61:0x0170, B:63:0x017c, B:65:0x0189, B:66:0x019a, B:70:0x01af, B:72:0x01c1, B:67:0x019f, B:28:0x00ea, B:30:0x00f3, B:32:0x0103, B:34:0x0110), top: B:108:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015d A[Catch: all -> 0x01d0, TryCatch #0 {all -> 0x01d0, blocks: (B:5:0x000b, B:7:0x0023, B:9:0x002d, B:11:0x0031, B:13:0x0043, B:15:0x0054, B:17:0x005c, B:18:0x0061, B:20:0x00b7, B:25:0x00cc, B:27:0x00d0, B:38:0x0118, B:74:0x01cc, B:41:0x0120, B:43:0x012a, B:48:0x0138, B:50:0x0140, B:52:0x014a, B:53:0x0155, B:55:0x015d, B:58:0x0168, B:61:0x0170, B:63:0x017c, B:65:0x0189, B:66:0x019a, B:70:0x01af, B:72:0x01c1, B:67:0x019f, B:28:0x00ea, B:30:0x00f3, B:32:0x0103, B:34:0x0110), top: B:108:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017c A[Catch: all -> 0x01d0, TryCatch #0 {all -> 0x01d0, blocks: (B:5:0x000b, B:7:0x0023, B:9:0x002d, B:11:0x0031, B:13:0x0043, B:15:0x0054, B:17:0x005c, B:18:0x0061, B:20:0x00b7, B:25:0x00cc, B:27:0x00d0, B:38:0x0118, B:74:0x01cc, B:41:0x0120, B:43:0x012a, B:48:0x0138, B:50:0x0140, B:52:0x014a, B:53:0x0155, B:55:0x015d, B:58:0x0168, B:61:0x0170, B:63:0x017c, B:65:0x0189, B:66:0x019a, B:70:0x01af, B:72:0x01c1, B:67:0x019f, B:28:0x00ea, B:30:0x00f3, B:32:0x0103, B:34:0x0110), top: B:108:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019f A[Catch: all -> 0x01d0, TryCatch #0 {all -> 0x01d0, blocks: (B:5:0x000b, B:7:0x0023, B:9:0x002d, B:11:0x0031, B:13:0x0043, B:15:0x0054, B:17:0x005c, B:18:0x0061, B:20:0x00b7, B:25:0x00cc, B:27:0x00d0, B:38:0x0118, B:74:0x01cc, B:41:0x0120, B:43:0x012a, B:48:0x0138, B:50:0x0140, B:52:0x014a, B:53:0x0155, B:55:0x015d, B:58:0x0168, B:61:0x0170, B:63:0x017c, B:65:0x0189, B:66:0x019a, B:70:0x01af, B:72:0x01c1, B:67:0x019f, B:28:0x00ea, B:30:0x00f3, B:32:0x0103, B:34:0x0110), top: B:108:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01cc A[Catch: all -> 0x01d0, TRY_LEAVE, TryCatch #0 {all -> 0x01d0, blocks: (B:5:0x000b, B:7:0x0023, B:9:0x002d, B:11:0x0031, B:13:0x0043, B:15:0x0054, B:17:0x005c, B:18:0x0061, B:20:0x00b7, B:25:0x00cc, B:27:0x00d0, B:38:0x0118, B:74:0x01cc, B:41:0x0120, B:43:0x012a, B:48:0x0138, B:50:0x0140, B:52:0x014a, B:53:0x0155, B:55:0x015d, B:58:0x0168, B:61:0x0170, B:63:0x017c, B:65:0x0189, B:66:0x019a, B:70:0x01af, B:72:0x01c1, B:67:0x019f, B:28:0x00ea, B:30:0x00f3, B:32:0x0103, B:34:0x0110), top: B:108:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handlePluginUpgrade(ApkInfo apkInfo) {
        boolean z;
        boolean z2;
        File file;
        boolean z3;
        boolean z4;
        boolean z5;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65546, this, apkInfo) != null) {
            return;
        }
        try {
            int k2 = com.baidu.sofire.utility.c.k(this.context);
            List<Integer> p = this.mPreferenceManager.p();
            if (!p.contains(Integer.valueOf(apkInfo.key)) && !com.baidu.sofire.utility.c.b(this.context, apkInfo.network)) {
                if (this.mUpgradeResultMap == null || this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    return;
                }
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, k2, 3));
                return;
            }
            if (!this.tmpDir.exists()) {
                this.tmpDir.mkdir();
            }
            ApkInfo a = this.loadedPluginDB.a(apkInfo.key + 10000000);
            File file3 = new File(this.tmpDir, apkInfo.key + "-" + apkInfo.versionName + ".tmp");
            File file4 = new File(this.tmpDir, apkInfo.key + "-" + apkInfo.versionName + ".zip");
            if (file4.exists()) {
                if (apkInfo.apkMD5.equals(q.a(file4))) {
                    z = false;
                    z2 = true;
                    if (z) {
                        file = file4;
                    } else if (apkInfo.isNextLoad) {
                        file = file4;
                        z.a(this.context).a(new Runnable(this, apkInfo, file3, file4, k2, p) { // from class: com.baidu.sofire.ac.U.3
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
                                    Object[] objArr = {this, apkInfo, file3, file4, Integer.valueOf(k2), p};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$apkInfo = apkInfo;
                                this.val$file = file3;
                                this.val$resfile = file4;
                                this.val$networkType = k2;
                                this.val$hostCarePluginKeys = p;
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
                                        com.baidu.sofire.utility.c.a();
                                    }
                                }
                            }
                        });
                    } else {
                        file = file4;
                        z2 = handlePluginDownload(apkInfo, file3, file, k2);
                        z3 = !z2;
                        if (a != null) {
                            this.loadedPluginDB.h(a.key + 10000000);
                            if (!TextUtils.isEmpty(a.pkgPath)) {
                                File file5 = new File(a.pkgPath);
                                if (file5.exists()) {
                                    file5.delete();
                                }
                            }
                        }
                        if (z2) {
                            pluginUpdate(file, apkInfo, k2);
                        } else {
                            if (a != null) {
                                ApkInfo a2 = this.loadedPluginDB.a(apkInfo.key);
                                if (a2 != null && !com.baidu.sofire.utility.c.b(a.versionName, a2.versionName)) {
                                    z5 = false;
                                    if (!TextUtils.isEmpty(a.versionName) && a.versionName.equals(apkInfo.versionName)) {
                                        this.loadedPluginDB.a(a.key + 10000000, a.versionName);
                                        z5 = false;
                                    }
                                    file2 = TextUtils.isEmpty(a.pkgPath) ? new File(a.pkgPath) : null;
                                    if (file2 != null && file2.exists() && z5) {
                                        if (!a.apkMD5.equals(q.a(file2))) {
                                            a.key -= 10000000;
                                            if (!TextUtils.isEmpty(a.packageName)) {
                                                a.packageName = new StringBuilder(a.packageName).reverse().toString();
                                            }
                                            pluginUpdate(file2, a, k2);
                                            z4 = true;
                                            if (!z4 && f.a(this.context.getApplicationContext()).d(apkInfo.packageName) == null) {
                                                this.forHostAPP.a(apkInfo.key, apkInfo.versionName, null);
                                            }
                                        } else {
                                            this.loadedPluginDB.a(a.key + 10000000, a.versionName);
                                            file2.delete();
                                        }
                                    }
                                }
                                z5 = true;
                                if (!TextUtils.isEmpty(a.versionName)) {
                                    this.loadedPluginDB.a(a.key + 10000000, a.versionName);
                                    z5 = false;
                                }
                                if (TextUtils.isEmpty(a.pkgPath)) {
                                }
                                if (file2 != null) {
                                    if (!a.apkMD5.equals(q.a(file2))) {
                                    }
                                }
                            }
                            z4 = false;
                            if (!z4) {
                                this.forHostAPP.a(apkInfo.key, apkInfo.versionName, null);
                            }
                        }
                        if (z3) {
                            handlePluginDownError(apkInfo, file, k2, p);
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
            com.baidu.sofire.utility.c.a();
            try {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, com.baidu.sofire.utility.c.k(this.context), 2));
                }
            } catch (Throwable unused2) {
                com.baidu.sofire.utility.c.a();
            }
            try {
                List<Integer> p2 = this.mPreferenceManager.p();
                if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                    if (p2.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                        sSetRetrmAlarm = true;
                        com.baidu.sofire.utility.a.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                        sRetryDownoadHostCareApksTimesCount++;
                    }
                    if (sMonitorNetworkWhenUpgradeNoNet) {
                        return;
                    }
                    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    if (com.baidu.sofire.utility.c.f39681g == null) {
                        com.baidu.sofire.utility.c.f39681g = new MyReceiver().a();
                    } else {
                        com.baidu.sofire.utility.c.f39681g.a();
                    }
                    com.baidu.sofire.utility.c.a(this.context, com.baidu.sofire.utility.c.f39681g, intentFilter);
                    sMonitorNetworkWhenUpgradeNoNet = true;
                }
            } catch (Throwable unused3) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    private void handleThreadEnd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            try {
                this.mPreferenceManager.g(this.mPreferenceManager.s() + 1);
                if (this.mEndReason != 0) {
                    this.mPreferenceManager.a(1, this.mEndReason, this.mPreferenceManager.a(1, this.mEndReason) + 1);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
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
                Map<Integer, String> b2 = this.loadedPluginDB.b();
                hashMap.put("9", b2.keySet());
                hashMap.put("10", b2.values());
                hashMap.put("11", Integer.valueOf(this.mEndReason));
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("12", str.replace(StringUtils.LF, "").replace(TrackUI.SEPERATOR, "").replace(StringUtils.CR, ""));
                }
                hashMap.put("13", Integer.valueOf(this.mStartNetwork));
                hashMap.put("14", Integer.valueOf(com.baidu.sofire.utility.c.k(this.context)));
                com.baidu.sofire.utility.c.a(this.context, "1003129", (Map<String, Object>) hashMap, false);
            } catch (Throwable unused2) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ea A[Catch: all -> 0x0103, TryCatch #0 {all -> 0x0103, blocks: (B:28:0x00d2, B:30:0x00ea, B:31:0x00fa), top: B:38:0x00d2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleThreadStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            try {
                try {
                    try {
                        long j2 = this.mPreferenceManager.a.getLong("slruct", 0L);
                        long currentTimeMillis = System.currentTimeMillis();
                        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                        if (i2 > 0 && currentTimeMillis - j2 > 86400000) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("1", Integer.valueOf(this.mPreferenceManager.r()));
                            this.mPreferenceManager.f(0);
                            JSONObject jSONObject = new JSONObject();
                            for (int i3 = 1; i3 <= 6; i3++) {
                                jSONObject.put(String.valueOf(i3), this.mPreferenceManager.a(0, i3));
                                this.mPreferenceManager.a(0, i3, 0);
                            }
                            hashMap.put("2", jSONObject);
                            hashMap.put("3", Integer.valueOf(this.mPreferenceManager.s()));
                            this.mPreferenceManager.g(0);
                            JSONObject jSONObject2 = new JSONObject();
                            for (int i4 = 1; i4 <= 11; i4++) {
                                jSONObject2.put(String.valueOf(i4), this.mPreferenceManager.a(1, i4));
                                this.mPreferenceManager.a(1, i4, 0);
                            }
                            hashMap.put("4", jSONObject2);
                            com.baidu.sofire.utility.c.a(this.context, "1003128", (Map<String, Object>) hashMap, false);
                            this.mPreferenceManager.a(currentTimeMillis);
                        } else if (i2 == 0) {
                            this.mPreferenceManager.a(currentTimeMillis);
                        }
                    } catch (Throwable unused) {
                        com.baidu.sofire.utility.c.a();
                        com.baidu.sofire.utility.c.a();
                        this.mStartKeyMap = this.loadedPluginDB.b();
                        this.mPreferenceManager.f(this.mPreferenceManager.r() + 1);
                        if (this.mFrom != 0) {
                        }
                        this.mStartNetwork = com.baidu.sofire.utility.c.k(this.context);
                    }
                } catch (Throwable unused2) {
                    this.mPreferenceManager.f(0);
                    this.mPreferenceManager.g(0);
                    for (int i5 = 1; i5 <= 6; i5++) {
                        this.mPreferenceManager.a(0, i5, 0);
                    }
                    for (int i6 = 1; i6 <= 11; i6++) {
                        this.mPreferenceManager.a(1, i6, 0);
                    }
                    com.baidu.sofire.utility.c.a();
                    this.mStartKeyMap = this.loadedPluginDB.b();
                    this.mPreferenceManager.f(this.mPreferenceManager.r() + 1);
                    if (this.mFrom != 0) {
                    }
                    this.mStartNetwork = com.baidu.sofire.utility.c.k(this.context);
                }
                this.mStartKeyMap = this.loadedPluginDB.b();
                this.mPreferenceManager.f(this.mPreferenceManager.r() + 1);
                if (this.mFrom != 0) {
                    this.mPreferenceManager.a(0, this.mFrom, this.mPreferenceManager.a(0, this.mFrom) + 1);
                }
                this.mStartNetwork = com.baidu.sofire.utility.c.k(this.context);
            } catch (Throwable unused3) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    private void pluginUpdate(File file, ApkInfo apkInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65549, this, file, apkInfo, i2) == null) {
            com.baidu.sofire.utility.c.a(file.getAbsolutePath(), true);
            if (this.mPreferenceManager.b()) {
                File file2 = new File(this.context.getFilesDir(), ".b");
                if (!file2.exists()) {
                    file2.mkdir();
                }
                File file3 = new File(file2, apkInfo.key + "-" + apkInfo.versionName);
                com.baidu.sofire.utility.c.a(file, file3);
                com.baidu.sofire.c.a(this.context, apkInfo.key, file, file3);
            }
            apkInfo.pkgPath = file.getAbsolutePath();
            String str = "before update, time=" + System.currentTimeMillis() + ", downloadAPK path:" + file.getAbsolutePath() + ", exists=" + file.exists() + ", canRead=" + file.canRead() + ", isFile=" + file.isFile() + ",length" + file.length();
            StringBuilder sb = new StringBuilder("before update, time=" + System.currentTimeMillis() + StringUtil.ARRAY_ELEMENT_SEPARATOR);
            ApkInfo a = this.loadedPluginDB.a(apkInfo.key);
            if (a == null) {
                sb.append("apkInDB == null");
            } else {
                File file4 = new File(a.pkgPath);
                sb.append("origAPK path:" + file4.getAbsolutePath() + ", exists=" + file4.exists() + ", canRead=" + file4.canRead() + ", isFile=" + file4.isFile() + ",length" + file4.length());
            }
            boolean a2 = this.forHostAPP.a(apkInfo, str);
            this.loadedPluginDB.a(apkInfo.key + 10000000, apkInfo.versionName);
            if (!a2) {
                Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
                if (map == null || map.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    return;
                }
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i2, 5));
                return;
            }
            int g2 = this.loadedPluginDB.g(apkInfo.key);
            if (g2 < 3 && g2 != -1) {
                this.loadedPluginDB.b(apkInfo.key, g2 + 1);
            }
            Map<Integer, UpgradeResult> map2 = this.mUpgradeResultMap;
            if (map2 != null) {
                map2.put(Integer.valueOf(apkInfo.key), new UpgradeResult(this, i2, 1));
            }
        }
    }

    public void handleWork(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            this.context = context;
            this.loadedPluginDB = a.a(context);
            this.mPreferenceManager = com.baidu.sofire.h.a.a(context);
            this.tmpDir = new File(context.getFilesDir(), ".tmp");
            this.forHostAPP = c.a(context);
            this.mFrom = intent.getIntExtra("from", 0);
            z.a(context).b(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:194:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0434 A[Catch: all -> 0x0767, TryCatch #19 {, blocks: (B:19:0x001c, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x0035, B:29:0x0040, B:31:0x0044, B:32:0x0049, B:43:0x005b, B:45:0x0063, B:46:0x0069, B:52:0x00f6, B:54:0x00ff, B:57:0x010e, B:59:0x0112, B:60:0x0114, B:62:0x0122, B:64:0x012b, B:68:0x0137, B:70:0x0141, B:72:0x0145, B:77:0x0158, B:79:0x0160, B:80:0x0168, B:82:0x016c, B:84:0x0170, B:86:0x0174, B:88:0x0178, B:93:0x0196, B:95:0x01a1, B:97:0x01b2, B:99:0x01bf, B:101:0x01c3, B:102:0x01c8, B:103:0x01cb, B:104:0x01d2, B:96:0x01ad, B:90:0x017c, B:92:0x0188, B:105:0x01d3, B:107:0x021e, B:109:0x0222, B:110:0x0226, B:111:0x022d, B:112:0x022e, B:114:0x0232, B:115:0x0236, B:117:0x023c, B:119:0x0256, B:120:0x025f, B:122:0x0273, B:123:0x0277, B:125:0x028a, B:126:0x0291, B:128:0x0297, B:130:0x029d, B:133:0x02a9, B:134:0x02ad, B:138:0x02b9, B:142:0x02c7, B:144:0x02cf, B:146:0x02e4, B:150:0x02fd, B:191:0x03fe, B:192:0x0402, B:196:0x0416, B:201:0x0424, B:205:0x0430, B:207:0x0434, B:208:0x0436, B:210:0x043e, B:211:0x044e, B:213:0x0456, B:217:0x0463, B:219:0x046b, B:221:0x0473, B:223:0x047d, B:224:0x048b, B:226:0x0491, B:227:0x04a0, B:229:0x04a7, B:231:0x04c2, B:232:0x04d3, B:234:0x04d9, B:236:0x04de, B:238:0x04ee, B:240:0x04f4, B:241:0x04fd, B:244:0x0509, B:245:0x050c, B:247:0x0510, B:249:0x051e, B:251:0x052d, B:253:0x0531, B:260:0x0560, B:250:0x0526, B:256:0x0544, B:258:0x054e, B:259:0x055b, B:261:0x0564, B:263:0x0571, B:265:0x058b, B:267:0x0595, B:268:0x059a, B:269:0x059e, B:271:0x05a4, B:273:0x05b4, B:275:0x05b8, B:276:0x05c3, B:278:0x05cd, B:279:0x05e9, B:281:0x05ef, B:283:0x05f9, B:284:0x0600, B:285:0x0603, B:286:0x0617, B:288:0x061d, B:290:0x0629, B:292:0x0631, B:296:0x063f, B:299:0x0649, B:301:0x065c, B:302:0x065f, B:304:0x0689, B:305:0x068c, B:311:0x06d0, B:306:0x0694, B:308:0x06a7, B:310:0x06ca, B:317:0x06ee, B:312:0x06db, B:314:0x06e1, B:316:0x06eb, B:318:0x06f2, B:319:0x0702, B:334:0x0720, B:336:0x0725, B:338:0x0729, B:344:0x074e, B:346:0x0752, B:348:0x0757, B:349:0x075e, B:350:0x075f, B:351:0x0766, B:340:0x072e, B:342:0x073c, B:343:0x0747, B:56:0x0103, B:197:0x0418, B:47:0x006b, B:74:0x0149), top: B:413:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x043e A[Catch: all -> 0x0767, TryCatch #19 {, blocks: (B:19:0x001c, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x0035, B:29:0x0040, B:31:0x0044, B:32:0x0049, B:43:0x005b, B:45:0x0063, B:46:0x0069, B:52:0x00f6, B:54:0x00ff, B:57:0x010e, B:59:0x0112, B:60:0x0114, B:62:0x0122, B:64:0x012b, B:68:0x0137, B:70:0x0141, B:72:0x0145, B:77:0x0158, B:79:0x0160, B:80:0x0168, B:82:0x016c, B:84:0x0170, B:86:0x0174, B:88:0x0178, B:93:0x0196, B:95:0x01a1, B:97:0x01b2, B:99:0x01bf, B:101:0x01c3, B:102:0x01c8, B:103:0x01cb, B:104:0x01d2, B:96:0x01ad, B:90:0x017c, B:92:0x0188, B:105:0x01d3, B:107:0x021e, B:109:0x0222, B:110:0x0226, B:111:0x022d, B:112:0x022e, B:114:0x0232, B:115:0x0236, B:117:0x023c, B:119:0x0256, B:120:0x025f, B:122:0x0273, B:123:0x0277, B:125:0x028a, B:126:0x0291, B:128:0x0297, B:130:0x029d, B:133:0x02a9, B:134:0x02ad, B:138:0x02b9, B:142:0x02c7, B:144:0x02cf, B:146:0x02e4, B:150:0x02fd, B:191:0x03fe, B:192:0x0402, B:196:0x0416, B:201:0x0424, B:205:0x0430, B:207:0x0434, B:208:0x0436, B:210:0x043e, B:211:0x044e, B:213:0x0456, B:217:0x0463, B:219:0x046b, B:221:0x0473, B:223:0x047d, B:224:0x048b, B:226:0x0491, B:227:0x04a0, B:229:0x04a7, B:231:0x04c2, B:232:0x04d3, B:234:0x04d9, B:236:0x04de, B:238:0x04ee, B:240:0x04f4, B:241:0x04fd, B:244:0x0509, B:245:0x050c, B:247:0x0510, B:249:0x051e, B:251:0x052d, B:253:0x0531, B:260:0x0560, B:250:0x0526, B:256:0x0544, B:258:0x054e, B:259:0x055b, B:261:0x0564, B:263:0x0571, B:265:0x058b, B:267:0x0595, B:268:0x059a, B:269:0x059e, B:271:0x05a4, B:273:0x05b4, B:275:0x05b8, B:276:0x05c3, B:278:0x05cd, B:279:0x05e9, B:281:0x05ef, B:283:0x05f9, B:284:0x0600, B:285:0x0603, B:286:0x0617, B:288:0x061d, B:290:0x0629, B:292:0x0631, B:296:0x063f, B:299:0x0649, B:301:0x065c, B:302:0x065f, B:304:0x0689, B:305:0x068c, B:311:0x06d0, B:306:0x0694, B:308:0x06a7, B:310:0x06ca, B:317:0x06ee, B:312:0x06db, B:314:0x06e1, B:316:0x06eb, B:318:0x06f2, B:319:0x0702, B:334:0x0720, B:336:0x0725, B:338:0x0729, B:344:0x074e, B:346:0x0752, B:348:0x0757, B:349:0x075e, B:350:0x075f, B:351:0x0766, B:340:0x072e, B:342:0x073c, B:343:0x0747, B:56:0x0103, B:197:0x0418, B:47:0x006b, B:74:0x0149), top: B:413:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0456 A[Catch: all -> 0x0767, TryCatch #19 {, blocks: (B:19:0x001c, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x0035, B:29:0x0040, B:31:0x0044, B:32:0x0049, B:43:0x005b, B:45:0x0063, B:46:0x0069, B:52:0x00f6, B:54:0x00ff, B:57:0x010e, B:59:0x0112, B:60:0x0114, B:62:0x0122, B:64:0x012b, B:68:0x0137, B:70:0x0141, B:72:0x0145, B:77:0x0158, B:79:0x0160, B:80:0x0168, B:82:0x016c, B:84:0x0170, B:86:0x0174, B:88:0x0178, B:93:0x0196, B:95:0x01a1, B:97:0x01b2, B:99:0x01bf, B:101:0x01c3, B:102:0x01c8, B:103:0x01cb, B:104:0x01d2, B:96:0x01ad, B:90:0x017c, B:92:0x0188, B:105:0x01d3, B:107:0x021e, B:109:0x0222, B:110:0x0226, B:111:0x022d, B:112:0x022e, B:114:0x0232, B:115:0x0236, B:117:0x023c, B:119:0x0256, B:120:0x025f, B:122:0x0273, B:123:0x0277, B:125:0x028a, B:126:0x0291, B:128:0x0297, B:130:0x029d, B:133:0x02a9, B:134:0x02ad, B:138:0x02b9, B:142:0x02c7, B:144:0x02cf, B:146:0x02e4, B:150:0x02fd, B:191:0x03fe, B:192:0x0402, B:196:0x0416, B:201:0x0424, B:205:0x0430, B:207:0x0434, B:208:0x0436, B:210:0x043e, B:211:0x044e, B:213:0x0456, B:217:0x0463, B:219:0x046b, B:221:0x0473, B:223:0x047d, B:224:0x048b, B:226:0x0491, B:227:0x04a0, B:229:0x04a7, B:231:0x04c2, B:232:0x04d3, B:234:0x04d9, B:236:0x04de, B:238:0x04ee, B:240:0x04f4, B:241:0x04fd, B:244:0x0509, B:245:0x050c, B:247:0x0510, B:249:0x051e, B:251:0x052d, B:253:0x0531, B:260:0x0560, B:250:0x0526, B:256:0x0544, B:258:0x054e, B:259:0x055b, B:261:0x0564, B:263:0x0571, B:265:0x058b, B:267:0x0595, B:268:0x059a, B:269:0x059e, B:271:0x05a4, B:273:0x05b4, B:275:0x05b8, B:276:0x05c3, B:278:0x05cd, B:279:0x05e9, B:281:0x05ef, B:283:0x05f9, B:284:0x0600, B:285:0x0603, B:286:0x0617, B:288:0x061d, B:290:0x0629, B:292:0x0631, B:296:0x063f, B:299:0x0649, B:301:0x065c, B:302:0x065f, B:304:0x0689, B:305:0x068c, B:311:0x06d0, B:306:0x0694, B:308:0x06a7, B:310:0x06ca, B:317:0x06ee, B:312:0x06db, B:314:0x06e1, B:316:0x06eb, B:318:0x06f2, B:319:0x0702, B:334:0x0720, B:336:0x0725, B:338:0x0729, B:344:0x074e, B:346:0x0752, B:348:0x0757, B:349:0x075e, B:350:0x075f, B:351:0x0766, B:340:0x072e, B:342:0x073c, B:343:0x0747, B:56:0x0103, B:197:0x0418, B:47:0x006b, B:74:0x0149), top: B:413:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04c2 A[Catch: all -> 0x0767, TryCatch #19 {, blocks: (B:19:0x001c, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x0035, B:29:0x0040, B:31:0x0044, B:32:0x0049, B:43:0x005b, B:45:0x0063, B:46:0x0069, B:52:0x00f6, B:54:0x00ff, B:57:0x010e, B:59:0x0112, B:60:0x0114, B:62:0x0122, B:64:0x012b, B:68:0x0137, B:70:0x0141, B:72:0x0145, B:77:0x0158, B:79:0x0160, B:80:0x0168, B:82:0x016c, B:84:0x0170, B:86:0x0174, B:88:0x0178, B:93:0x0196, B:95:0x01a1, B:97:0x01b2, B:99:0x01bf, B:101:0x01c3, B:102:0x01c8, B:103:0x01cb, B:104:0x01d2, B:96:0x01ad, B:90:0x017c, B:92:0x0188, B:105:0x01d3, B:107:0x021e, B:109:0x0222, B:110:0x0226, B:111:0x022d, B:112:0x022e, B:114:0x0232, B:115:0x0236, B:117:0x023c, B:119:0x0256, B:120:0x025f, B:122:0x0273, B:123:0x0277, B:125:0x028a, B:126:0x0291, B:128:0x0297, B:130:0x029d, B:133:0x02a9, B:134:0x02ad, B:138:0x02b9, B:142:0x02c7, B:144:0x02cf, B:146:0x02e4, B:150:0x02fd, B:191:0x03fe, B:192:0x0402, B:196:0x0416, B:201:0x0424, B:205:0x0430, B:207:0x0434, B:208:0x0436, B:210:0x043e, B:211:0x044e, B:213:0x0456, B:217:0x0463, B:219:0x046b, B:221:0x0473, B:223:0x047d, B:224:0x048b, B:226:0x0491, B:227:0x04a0, B:229:0x04a7, B:231:0x04c2, B:232:0x04d3, B:234:0x04d9, B:236:0x04de, B:238:0x04ee, B:240:0x04f4, B:241:0x04fd, B:244:0x0509, B:245:0x050c, B:247:0x0510, B:249:0x051e, B:251:0x052d, B:253:0x0531, B:260:0x0560, B:250:0x0526, B:256:0x0544, B:258:0x054e, B:259:0x055b, B:261:0x0564, B:263:0x0571, B:265:0x058b, B:267:0x0595, B:268:0x059a, B:269:0x059e, B:271:0x05a4, B:273:0x05b4, B:275:0x05b8, B:276:0x05c3, B:278:0x05cd, B:279:0x05e9, B:281:0x05ef, B:283:0x05f9, B:284:0x0600, B:285:0x0603, B:286:0x0617, B:288:0x061d, B:290:0x0629, B:292:0x0631, B:296:0x063f, B:299:0x0649, B:301:0x065c, B:302:0x065f, B:304:0x0689, B:305:0x068c, B:311:0x06d0, B:306:0x0694, B:308:0x06a7, B:310:0x06ca, B:317:0x06ee, B:312:0x06db, B:314:0x06e1, B:316:0x06eb, B:318:0x06f2, B:319:0x0702, B:334:0x0720, B:336:0x0725, B:338:0x0729, B:344:0x074e, B:346:0x0752, B:348:0x0757, B:349:0x075e, B:350:0x075f, B:351:0x0766, B:340:0x072e, B:342:0x073c, B:343:0x0747, B:56:0x0103, B:197:0x0418, B:47:0x006b, B:74:0x0149), top: B:413:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x04d9 A[Catch: all -> 0x0767, TryCatch #19 {, blocks: (B:19:0x001c, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x0035, B:29:0x0040, B:31:0x0044, B:32:0x0049, B:43:0x005b, B:45:0x0063, B:46:0x0069, B:52:0x00f6, B:54:0x00ff, B:57:0x010e, B:59:0x0112, B:60:0x0114, B:62:0x0122, B:64:0x012b, B:68:0x0137, B:70:0x0141, B:72:0x0145, B:77:0x0158, B:79:0x0160, B:80:0x0168, B:82:0x016c, B:84:0x0170, B:86:0x0174, B:88:0x0178, B:93:0x0196, B:95:0x01a1, B:97:0x01b2, B:99:0x01bf, B:101:0x01c3, B:102:0x01c8, B:103:0x01cb, B:104:0x01d2, B:96:0x01ad, B:90:0x017c, B:92:0x0188, B:105:0x01d3, B:107:0x021e, B:109:0x0222, B:110:0x0226, B:111:0x022d, B:112:0x022e, B:114:0x0232, B:115:0x0236, B:117:0x023c, B:119:0x0256, B:120:0x025f, B:122:0x0273, B:123:0x0277, B:125:0x028a, B:126:0x0291, B:128:0x0297, B:130:0x029d, B:133:0x02a9, B:134:0x02ad, B:138:0x02b9, B:142:0x02c7, B:144:0x02cf, B:146:0x02e4, B:150:0x02fd, B:191:0x03fe, B:192:0x0402, B:196:0x0416, B:201:0x0424, B:205:0x0430, B:207:0x0434, B:208:0x0436, B:210:0x043e, B:211:0x044e, B:213:0x0456, B:217:0x0463, B:219:0x046b, B:221:0x0473, B:223:0x047d, B:224:0x048b, B:226:0x0491, B:227:0x04a0, B:229:0x04a7, B:231:0x04c2, B:232:0x04d3, B:234:0x04d9, B:236:0x04de, B:238:0x04ee, B:240:0x04f4, B:241:0x04fd, B:244:0x0509, B:245:0x050c, B:247:0x0510, B:249:0x051e, B:251:0x052d, B:253:0x0531, B:260:0x0560, B:250:0x0526, B:256:0x0544, B:258:0x054e, B:259:0x055b, B:261:0x0564, B:263:0x0571, B:265:0x058b, B:267:0x0595, B:268:0x059a, B:269:0x059e, B:271:0x05a4, B:273:0x05b4, B:275:0x05b8, B:276:0x05c3, B:278:0x05cd, B:279:0x05e9, B:281:0x05ef, B:283:0x05f9, B:284:0x0600, B:285:0x0603, B:286:0x0617, B:288:0x061d, B:290:0x0629, B:292:0x0631, B:296:0x063f, B:299:0x0649, B:301:0x065c, B:302:0x065f, B:304:0x0689, B:305:0x068c, B:311:0x06d0, B:306:0x0694, B:308:0x06a7, B:310:0x06ca, B:317:0x06ee, B:312:0x06db, B:314:0x06e1, B:316:0x06eb, B:318:0x06f2, B:319:0x0702, B:334:0x0720, B:336:0x0725, B:338:0x0729, B:344:0x074e, B:346:0x0752, B:348:0x0757, B:349:0x075e, B:350:0x075f, B:351:0x0766, B:340:0x072e, B:342:0x073c, B:343:0x0747, B:56:0x0103, B:197:0x0418, B:47:0x006b, B:74:0x0149), top: B:413:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x04de A[Catch: all -> 0x0767, TryCatch #19 {, blocks: (B:19:0x001c, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x0035, B:29:0x0040, B:31:0x0044, B:32:0x0049, B:43:0x005b, B:45:0x0063, B:46:0x0069, B:52:0x00f6, B:54:0x00ff, B:57:0x010e, B:59:0x0112, B:60:0x0114, B:62:0x0122, B:64:0x012b, B:68:0x0137, B:70:0x0141, B:72:0x0145, B:77:0x0158, B:79:0x0160, B:80:0x0168, B:82:0x016c, B:84:0x0170, B:86:0x0174, B:88:0x0178, B:93:0x0196, B:95:0x01a1, B:97:0x01b2, B:99:0x01bf, B:101:0x01c3, B:102:0x01c8, B:103:0x01cb, B:104:0x01d2, B:96:0x01ad, B:90:0x017c, B:92:0x0188, B:105:0x01d3, B:107:0x021e, B:109:0x0222, B:110:0x0226, B:111:0x022d, B:112:0x022e, B:114:0x0232, B:115:0x0236, B:117:0x023c, B:119:0x0256, B:120:0x025f, B:122:0x0273, B:123:0x0277, B:125:0x028a, B:126:0x0291, B:128:0x0297, B:130:0x029d, B:133:0x02a9, B:134:0x02ad, B:138:0x02b9, B:142:0x02c7, B:144:0x02cf, B:146:0x02e4, B:150:0x02fd, B:191:0x03fe, B:192:0x0402, B:196:0x0416, B:201:0x0424, B:205:0x0430, B:207:0x0434, B:208:0x0436, B:210:0x043e, B:211:0x044e, B:213:0x0456, B:217:0x0463, B:219:0x046b, B:221:0x0473, B:223:0x047d, B:224:0x048b, B:226:0x0491, B:227:0x04a0, B:229:0x04a7, B:231:0x04c2, B:232:0x04d3, B:234:0x04d9, B:236:0x04de, B:238:0x04ee, B:240:0x04f4, B:241:0x04fd, B:244:0x0509, B:245:0x050c, B:247:0x0510, B:249:0x051e, B:251:0x052d, B:253:0x0531, B:260:0x0560, B:250:0x0526, B:256:0x0544, B:258:0x054e, B:259:0x055b, B:261:0x0564, B:263:0x0571, B:265:0x058b, B:267:0x0595, B:268:0x059a, B:269:0x059e, B:271:0x05a4, B:273:0x05b4, B:275:0x05b8, B:276:0x05c3, B:278:0x05cd, B:279:0x05e9, B:281:0x05ef, B:283:0x05f9, B:284:0x0600, B:285:0x0603, B:286:0x0617, B:288:0x061d, B:290:0x0629, B:292:0x0631, B:296:0x063f, B:299:0x0649, B:301:0x065c, B:302:0x065f, B:304:0x0689, B:305:0x068c, B:311:0x06d0, B:306:0x0694, B:308:0x06a7, B:310:0x06ca, B:317:0x06ee, B:312:0x06db, B:314:0x06e1, B:316:0x06eb, B:318:0x06f2, B:319:0x0702, B:334:0x0720, B:336:0x0725, B:338:0x0729, B:344:0x074e, B:346:0x0752, B:348:0x0757, B:349:0x075e, B:350:0x075f, B:351:0x0766, B:340:0x072e, B:342:0x073c, B:343:0x0747, B:56:0x0103, B:197:0x0418, B:47:0x006b, B:74:0x0149), top: B:413:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0564 A[Catch: all -> 0x0767, TryCatch #19 {, blocks: (B:19:0x001c, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x0035, B:29:0x0040, B:31:0x0044, B:32:0x0049, B:43:0x005b, B:45:0x0063, B:46:0x0069, B:52:0x00f6, B:54:0x00ff, B:57:0x010e, B:59:0x0112, B:60:0x0114, B:62:0x0122, B:64:0x012b, B:68:0x0137, B:70:0x0141, B:72:0x0145, B:77:0x0158, B:79:0x0160, B:80:0x0168, B:82:0x016c, B:84:0x0170, B:86:0x0174, B:88:0x0178, B:93:0x0196, B:95:0x01a1, B:97:0x01b2, B:99:0x01bf, B:101:0x01c3, B:102:0x01c8, B:103:0x01cb, B:104:0x01d2, B:96:0x01ad, B:90:0x017c, B:92:0x0188, B:105:0x01d3, B:107:0x021e, B:109:0x0222, B:110:0x0226, B:111:0x022d, B:112:0x022e, B:114:0x0232, B:115:0x0236, B:117:0x023c, B:119:0x0256, B:120:0x025f, B:122:0x0273, B:123:0x0277, B:125:0x028a, B:126:0x0291, B:128:0x0297, B:130:0x029d, B:133:0x02a9, B:134:0x02ad, B:138:0x02b9, B:142:0x02c7, B:144:0x02cf, B:146:0x02e4, B:150:0x02fd, B:191:0x03fe, B:192:0x0402, B:196:0x0416, B:201:0x0424, B:205:0x0430, B:207:0x0434, B:208:0x0436, B:210:0x043e, B:211:0x044e, B:213:0x0456, B:217:0x0463, B:219:0x046b, B:221:0x0473, B:223:0x047d, B:224:0x048b, B:226:0x0491, B:227:0x04a0, B:229:0x04a7, B:231:0x04c2, B:232:0x04d3, B:234:0x04d9, B:236:0x04de, B:238:0x04ee, B:240:0x04f4, B:241:0x04fd, B:244:0x0509, B:245:0x050c, B:247:0x0510, B:249:0x051e, B:251:0x052d, B:253:0x0531, B:260:0x0560, B:250:0x0526, B:256:0x0544, B:258:0x054e, B:259:0x055b, B:261:0x0564, B:263:0x0571, B:265:0x058b, B:267:0x0595, B:268:0x059a, B:269:0x059e, B:271:0x05a4, B:273:0x05b4, B:275:0x05b8, B:276:0x05c3, B:278:0x05cd, B:279:0x05e9, B:281:0x05ef, B:283:0x05f9, B:284:0x0600, B:285:0x0603, B:286:0x0617, B:288:0x061d, B:290:0x0629, B:292:0x0631, B:296:0x063f, B:299:0x0649, B:301:0x065c, B:302:0x065f, B:304:0x0689, B:305:0x068c, B:311:0x06d0, B:306:0x0694, B:308:0x06a7, B:310:0x06ca, B:317:0x06ee, B:312:0x06db, B:314:0x06e1, B:316:0x06eb, B:318:0x06f2, B:319:0x0702, B:334:0x0720, B:336:0x0725, B:338:0x0729, B:344:0x074e, B:346:0x0752, B:348:0x0757, B:349:0x075e, B:350:0x075f, B:351:0x0766, B:340:0x072e, B:342:0x073c, B:343:0x0747, B:56:0x0103, B:197:0x0418, B:47:0x006b, B:74:0x0149), top: B:413:0x001c }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void run() {
        JSONObject jSONObject;
        List<ApkInfo> list;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
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
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
            return;
        }
        synchronized (this) {
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
                if (com.baidu.sofire.utility.c.f(this.context)) {
                    sLastCheckTime = System.currentTimeMillis();
                }
                Context context = this.context;
                com.baidu.sofire.h.a a = com.baidu.sofire.h.a.a(context);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
                intent.setClass(context, MyService.class);
                intent.setPackage(context.getPackageName());
                intent.addCategory("com.baidu.category.SOFIRE");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("from_plugin_package", context.getPackageName());
                intent.putExtra("target_class", U.class.getCanonicalName());
                intent.putExtra("target_method", "handleWork");
                intent.putExtra("from", 6);
                PendingIntent service = PendingIntent.getService(context, 1000, intent, 134217728);
                long currentTimeMillis = ((System.currentTimeMillis() + (a.a.getInt("appal_te", 24) * 3600000)) - 600000) + ((long) (Math.random() * 1200000.0d));
                a.f39609b.putLong("npuct", currentTimeMillis);
                a.f39609b.commit();
                try {
                    alarmManager.cancel(service);
                } catch (Throwable unused) {
                }
                try {
                    alarmManager.set(1, currentTimeMillis, service);
                } catch (Throwable unused2) {
                    i.a(this.context);
                    if (this.mFrom == 1 || this.mFrom == 3) {
                        sRetryPingTimesCount = 0;
                        sRetryDownoadHostCareApksTimesCount = 0;
                        com.baidu.sofire.utility.a.a(this.context, 0, true);
                        sSetRetrmAlarm = false;
                    }
                    if (this.mFrom == 2) {
                        sSetRetrmAlarm = false;
                    }
                    boolean z2 = "com.baidu.input_huawei".equals(this.context.getPackageName()) ? !this.mPreferenceManager.w() : false;
                    if (com.baidu.sofire.utility.c.f(this.context) && !z2) {
                        sLastCheckTime = System.currentTimeMillis();
                        if (com.baidu.sofire.utility.c.f39681g != null && (sMonitorNetworkWhenUpgradeNoNet || com.baidu.sofire.utility.c.a)) {
                            this.context.getApplicationContext().unregisterReceiver(com.baidu.sofire.utility.c.f39681g);
                        }
                        sMonitorNetworkWhenUpgradeNoNet = false;
                        com.baidu.sofire.utility.c.a = false;
                        if (this.mFrom != 1) {
                            this.mWholeJson = com.baidu.sofire.utility.c.o(this.context);
                        }
                        if (this.mWholeJson == null) {
                            if ((this.mFrom == 1 || this.mFrom == 2 || (this.mFrom == 3 && !sSetRetrmAlarm)) && this.mPreferenceManager.p().size() > 0) {
                                sSetRetrmAlarm = true;
                                com.baidu.sofire.utility.a.a(this.context, sRetryPingTimesCount, false);
                                sRetryPingTimesCount++;
                            }
                            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                            if (com.baidu.sofire.utility.c.f39681g == null) {
                                com.baidu.sofire.utility.c.f39681g = new MyReceiver().a();
                            } else {
                                com.baidu.sofire.utility.c.f39681g.a();
                            }
                            com.baidu.sofire.utility.c.a(this.context, com.baidu.sofire.utility.c.f39681g, intentFilter);
                            sMonitorNetworkWhenUpgradeNoNet = true;
                            if (this.mEndReason == 0) {
                                if (com.baidu.sofire.utility.c.f39678d != 0) {
                                    this.mEndReason = com.baidu.sofire.utility.c.f39678d;
                                } else {
                                    this.mEndReason = 4;
                                }
                            }
                            throw new NetworkErrorException("ping faild");
                        }
                        sRetryPingTimesCount = 0;
                        this.forHostAPP.a(this.mWholeJson);
                        this.loadedPluginDB.d();
                        com.baidu.sofire.h.a aVar = this.mPreferenceManager;
                        aVar.f39609b.putInt("rtqe", this.mPreferenceManager.a.getInt("rtqe", 0) + 1);
                        aVar.f39609b.commit();
                        List<ApkInfo> a2 = this.loadedPluginDB.a();
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
                                String optString2 = optJSONObject4.optString(x.o);
                                String optString3 = optJSONObject4.optString("m");
                                String optString4 = optJSONObject4.optString("sm");
                                if (optString3 != null) {
                                    optString3 = optString3.toLowerCase();
                                }
                                String str = optInt + optString;
                                if (sRealtimeMd5Map == null) {
                                    sRealtimeMd5Map = new HashMap();
                                }
                                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(optString3)) {
                                    jSONObject = optJSONObject3;
                                } else {
                                    jSONObject = optJSONObject3;
                                    sRealtimeMd5Map.put(str, optString3);
                                }
                                if (optString4 != null) {
                                    optString4 = optString4.toLowerCase();
                                }
                                boolean z3 = optJSONObject4.optInt("o") == 1;
                                Iterator<String> it = keys;
                                boolean z4 = optJSONObject4.optInt("d") == 1;
                                int optInt2 = optJSONObject4.optInt("r");
                                if (z3) {
                                    arrayList = arrayList8;
                                    com.baidu.sofire.h.a aVar2 = this.mPreferenceManager;
                                    arrayList2 = arrayList9;
                                    arrayList3 = arrayList11;
                                    list = a2;
                                    if (optInt2 > aVar2.a.getInt("opi", 0)) {
                                        aVar2.f39609b.putInt("opi", optInt2);
                                        aVar2.f39609b.commit();
                                    }
                                } else {
                                    list = a2;
                                    arrayList = arrayList8;
                                    arrayList2 = arrayList9;
                                    arrayList3 = arrayList11;
                                }
                                if (z3 && z4) {
                                    arrayList10.add(next);
                                    optJSONObject3 = jSONObject;
                                    keys = it;
                                    arrayList8 = arrayList;
                                    arrayList9 = arrayList2;
                                    arrayList11 = arrayList3;
                                    a2 = list;
                                } else {
                                    try {
                                        packageInfo = new PackageInfo();
                                        packageInfo.packageName = optJSONObject4.optString("p");
                                        packageInfo.versionName = optString;
                                        ApplicationInfo applicationInfo = new ApplicationInfo();
                                        String optString5 = optJSONObject4.optString("n");
                                        applicationInfo.className = optString5;
                                        if (!TextUtils.isEmpty(optString5) && applicationInfo.className.startsWith(".")) {
                                            applicationInfo.className = next + applicationInfo.className;
                                        }
                                        applicationInfo.theme = optJSONObject4.optInt("t");
                                        packageInfo.applicationInfo = applicationInfo;
                                        JSONArray optJSONArray = optJSONObject4.optJSONArray("a");
                                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                                            arrayList4 = arrayList10;
                                        } else {
                                            ArrayList arrayList12 = new ArrayList();
                                            int i2 = 0;
                                            while (i2 < optJSONArray.length()) {
                                                try {
                                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                                    if (jSONObject2 != null) {
                                                        ActivityInfo activityInfo = new ActivityInfo();
                                                        jSONArray = optJSONArray;
                                                        try {
                                                            String optString6 = jSONObject2.optString("n");
                                                            activityInfo.name = optString6;
                                                            if (TextUtils.isEmpty(optString6)) {
                                                                arrayList4 = arrayList10;
                                                            } else {
                                                                arrayList4 = arrayList10;
                                                                try {
                                                                    if (activityInfo.name.startsWith(".")) {
                                                                        activityInfo.name = next + activityInfo.name;
                                                                    }
                                                                } catch (Throwable unused3) {
                                                                    try {
                                                                        com.baidu.sofire.utility.c.a();
                                                                        continue;
                                                                        i2++;
                                                                        optJSONArray = jSONArray;
                                                                        arrayList10 = arrayList4;
                                                                    } catch (Throwable unused4) {
                                                                        com.baidu.sofire.utility.c.a();
                                                                        packageInfo = null;
                                                                        apkInfo = new ApkInfo(optInt, next, optString, optString2, optString3);
                                                                        apkInfo.isOnce = !z3 ? 1 : 0;
                                                                        apkInfo.priority = optJSONObject4.getInt("pr");
                                                                        apkInfo.isMem = optJSONObject4.optInt("mem") != 1;
                                                                        if (packageInfo != null) {
                                                                            apkInfo.cloudPkgInfo = packageInfo;
                                                                        }
                                                                        optJSONObject = optJSONObject4.optJSONObject("e");
                                                                        if (optJSONObject != null) {
                                                                            int optInt3 = optJSONObject.optInt("d");
                                                                            int optInt4 = optJSONObject.optInt("n");
                                                                            apkInfo.duration = optInt3;
                                                                            apkInfo.network = optInt4;
                                                                        }
                                                                        optJSONObject2 = optJSONObject4.optJSONObject("ext");
                                                                        if (optJSONObject2 == null) {
                                                                            z = optJSONObject2.optInt("nl", 0) == 1;
                                                                            if (optJSONObject2.optInt("a") == 1) {
                                                                                List<Integer> p = this.mPreferenceManager.p();
                                                                                if (optInt > 0 && !p.contains(Integer.valueOf(optInt))) {
                                                                                    p.add(Integer.valueOf(optInt));
                                                                                    int[] iArr = new int[p.size()];
                                                                                    for (int i3 = 0; i3 < p.size(); i3++) {
                                                                                        iArr[i3] = p.get(i3).intValue();
                                                                                    }
                                                                                    this.mPreferenceManager.a(iArr);
                                                                                }
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                        apkInfo.signMD5 = optString4;
                                                                        apkInfo.startTime = System.currentTimeMillis();
                                                                        List<ApkInfo> list2 = list;
                                                                        indexOf = list2.indexOf(apkInfo);
                                                                        ApkInfo apkInfo2 = new ApkInfo(apkInfo);
                                                                        if (!TextUtils.isEmpty(apkInfo.packageName)) {
                                                                            apkInfo2.packageName = new StringBuilder(apkInfo2.packageName).reverse().toString();
                                                                        }
                                                                        indexOf2 = list2.indexOf(apkInfo2);
                                                                        if (indexOf2 >= 0) {
                                                                            list2.remove(indexOf2);
                                                                        }
                                                                        if (indexOf < 0) {
                                                                            ApkInfo apkInfo3 = list2.get(indexOf);
                                                                            if (com.baidu.sofire.utility.c.b(apkInfo.versionName, apkInfo3.versionName)) {
                                                                                if (apkInfo3.priority != apkInfo.priority) {
                                                                                    this.loadedPluginDB.c(apkInfo.key, apkInfo.priority);
                                                                                }
                                                                                if (this.loadedPluginDB.e(apkInfo3.key)) {
                                                                                    arrayList6 = arrayList2;
                                                                                    arrayList7 = arrayList3;
                                                                                } else {
                                                                                    if (z) {
                                                                                        apkInfo.isNextLoad = true;
                                                                                    }
                                                                                    if (c.f39545d != null && c.f39545d.contains(Integer.valueOf(apkInfo.key))) {
                                                                                        arrayList7 = arrayList3;
                                                                                        arrayList7.add(apkInfo);
                                                                                        arrayList6 = arrayList2;
                                                                                    } else {
                                                                                        arrayList7 = arrayList3;
                                                                                        arrayList6 = arrayList2;
                                                                                        arrayList6.add(apkInfo);
                                                                                    }
                                                                                    if (this.mDownloadPluginsList != null) {
                                                                                        this.mDownloadPluginsList.add(Integer.valueOf(apkInfo.key));
                                                                                    }
                                                                                }
                                                                                arrayList5 = arrayList;
                                                                            } else {
                                                                                arrayList6 = arrayList2;
                                                                                arrayList7 = arrayList3;
                                                                                if (apkInfo3.priority != apkInfo.priority) {
                                                                                    apkInfo3.priority = apkInfo.priority;
                                                                                    this.loadedPluginDB.c(apkInfo.key, apkInfo.priority);
                                                                                }
                                                                                arrayList5 = arrayList;
                                                                                arrayList5.add(apkInfo3);
                                                                            }
                                                                            list2.remove(indexOf);
                                                                        } else {
                                                                            arrayList5 = arrayList;
                                                                            arrayList6 = arrayList2;
                                                                            arrayList7 = arrayList3;
                                                                            arrayList6.add(apkInfo);
                                                                            if (this.mDownloadPluginsList != null) {
                                                                                this.mDownloadPluginsList.add(Integer.valueOf(apkInfo.key));
                                                                            }
                                                                        }
                                                                        a2 = list2;
                                                                        arrayList9 = arrayList6;
                                                                        arrayList8 = arrayList5;
                                                                        optJSONObject3 = jSONObject;
                                                                        keys = it;
                                                                        arrayList10 = arrayList4;
                                                                        arrayList11 = arrayList7;
                                                                    }
                                                                }
                                                            }
                                                            activityInfo.packageName = next;
                                                            activityInfo.theme = jSONObject2.optInt("t");
                                                            activityInfo.labelRes = jSONObject2.optInt("l");
                                                            if (TextUtils.isEmpty(activityInfo.name)) {
                                                                continue;
                                                            } else {
                                                                arrayList12.add(activityInfo);
                                                                continue;
                                                            }
                                                        } catch (Throwable unused5) {
                                                            arrayList4 = arrayList10;
                                                            com.baidu.sofire.utility.c.a();
                                                            continue;
                                                            i2++;
                                                            optJSONArray = jSONArray;
                                                            arrayList10 = arrayList4;
                                                        }
                                                    } else {
                                                        jSONArray = optJSONArray;
                                                        arrayList4 = arrayList10;
                                                        continue;
                                                    }
                                                } catch (Throwable unused6) {
                                                    jSONArray = optJSONArray;
                                                }
                                                i2++;
                                                optJSONArray = jSONArray;
                                                arrayList10 = arrayList4;
                                            }
                                            arrayList4 = arrayList10;
                                            if (arrayList12.size() > 0) {
                                                packageInfo.activities = (ActivityInfo[]) arrayList12.toArray(new ActivityInfo[arrayList12.size()]);
                                            }
                                        }
                                    } catch (Throwable unused7) {
                                        arrayList4 = arrayList10;
                                    }
                                    apkInfo = new ApkInfo(optInt, next, optString, optString2, optString3);
                                    apkInfo.isOnce = !z3 ? 1 : 0;
                                    apkInfo.priority = optJSONObject4.getInt("pr");
                                    apkInfo.isMem = optJSONObject4.optInt("mem") != 1;
                                    if (packageInfo != null) {
                                    }
                                    optJSONObject = optJSONObject4.optJSONObject("e");
                                    if (optJSONObject != null) {
                                    }
                                    optJSONObject2 = optJSONObject4.optJSONObject("ext");
                                    if (optJSONObject2 == null) {
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
                                    if (indexOf < 0) {
                                    }
                                    a2 = list22;
                                    arrayList9 = arrayList6;
                                    arrayList8 = arrayList5;
                                    optJSONObject3 = jSONObject;
                                    keys = it;
                                    arrayList10 = arrayList4;
                                    arrayList11 = arrayList7;
                                }
                            }
                        }
                        List<ApkInfo> list3 = a2;
                        ArrayList arrayList13 = arrayList10;
                        ArrayList arrayList14 = arrayList11;
                        ArrayList arrayList15 = arrayList8;
                        ArrayList arrayList16 = arrayList9;
                        if (c.f39545d != null) {
                            c.f39545d.clear();
                        }
                        for (ApkInfo apkInfo4 : list3) {
                            ArrayList arrayList17 = arrayList13;
                            if (!arrayList17.contains(apkInfo4.packageName)) {
                                if (this.mUnloadPluginsList != null) {
                                    this.mUnloadPluginsList.add(Integer.valueOf(apkInfo4.key));
                                }
                                this.forHostAPP.a(apkInfo4.packageName);
                            }
                            arrayList13 = arrayList17;
                        }
                        com.baidu.sofire.utility.c.c(this.context);
                        f a3 = f.a(this.context.getApplicationContext());
                        List<Integer> q = this.mPreferenceManager.q();
                        List<Integer> p2 = this.mPreferenceManager.p();
                        for (int i4 = 0; i4 < p2.size(); i4++) {
                            if (!q.contains(p2.get(i4))) {
                                q.add(p2.get(i4));
                            }
                        }
                        ArrayList arrayList18 = new ArrayList();
                        arrayList18.addAll(arrayList15);
                        arrayList18.addAll(arrayList16);
                        Collections.sort(arrayList18, new Comparator<ApkInfo>(this, q) { // from class: com.baidu.sofire.ac.U.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ U this$0;
                            public final /* synthetic */ List val$localSetIds;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, q};
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
                                this.val$localSetIds = q;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            public int compare(ApkInfo apkInfo5, ApkInfo apkInfo6) {
                                InterceptResult invokeLL;
                                int i5;
                                int i6;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, apkInfo5, apkInfo6)) == null) {
                                    if (apkInfo5.priority != -1 || apkInfo6.priority == -1) {
                                        if ((apkInfo5.priority == -1 || apkInfo6.priority != -1) && (i5 = apkInfo5.priority) >= (i6 = apkInfo6.priority)) {
                                            if (i5 > i6) {
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
                        for (int i5 = 0; i5 < arrayList18.size(); i5++) {
                            ApkInfo apkInfo5 = (ApkInfo) arrayList18.get(i5);
                            if (arrayList15.contains(apkInfo5)) {
                                if (a3.d(apkInfo5.packageName) == null) {
                                    boolean z5 = this.loadedPluginDB.g(apkInfo5.key) != 3;
                                    if (this.mPreferenceManager.b() && z5) {
                                        File file = new File(this.context.getFilesDir(), ".b");
                                        if (!file.exists()) {
                                            file.mkdir();
                                        }
                                        File file2 = new File(apkInfo5.pkgPath);
                                        File file3 = new File(file, apkInfo5.key + "-" + apkInfo5.versionName);
                                        if (!com.baidu.sofire.utility.c.a(file3)) {
                                            com.baidu.sofire.utility.c.a(file2, file3);
                                        }
                                        com.baidu.sofire.c.a(this.context, apkInfo5.key, file2, file3);
                                    } else {
                                        File file4 = new File(this.context.getFilesDir(), ".b");
                                        if (file4.exists()) {
                                            File file5 = new File(file4, apkInfo5.key + "-" + apkInfo5.versionName);
                                            if (com.baidu.sofire.utility.c.a(file5)) {
                                                com.baidu.sofire.c.a(file5);
                                                file5.delete();
                                            }
                                        }
                                    }
                                    this.forHostAPP.a(apkInfo5.key, apkInfo5.versionName, null);
                                }
                            } else if (arrayList16.contains(apkInfo5) && !this.loadedPluginDB.e(apkInfo5.key)) {
                                handlePluginUpgrade(apkInfo5);
                            }
                        }
                        new Timer().schedule(new TimerTask(this, arrayList14) { // from class: com.baidu.sofire.ac.U.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ U this$0;
                            public final /* synthetic */ List val$pluginNeedDelayUpdate;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, arrayList14};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i6 = newInitContext.flag;
                                    if ((i6 & 1) != 0) {
                                        int i7 = i6 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$pluginNeedDelayUpdate = arrayList14;
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
                        if (com.baidu.sofire.utility.c.f39681g == null) {
                            com.baidu.sofire.utility.c.f39681g = new MyReceiver().a();
                        }
                        com.baidu.sofire.utility.c.a(this.context, com.baidu.sofire.utility.c.f39681g, intentFilter2);
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

    public U(Context context, int i2, boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Boolean.valueOf(z), jSONObject};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        this.mPreferenceManager = com.baidu.sofire.h.a.a(context);
        this.forHostAPP = c.a(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.mFrom = i2;
        this.mOut = z;
        this.mWholeJson = jSONObject;
    }

    public U() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
