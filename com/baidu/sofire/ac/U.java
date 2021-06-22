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
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobstat.Config;
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
import com.baidu.sofire.utility.g;
import com.baidu.sofire.utility.m;
import com.baidu.sofire.utility.o;
import com.baidu.sofire.utility.q;
import com.baidu.sofire.utility.x;
import com.baidu.webkit.internal.ABTestConstants;
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
    public static long sLastCheckTime = 0;
    public static boolean sMonitorNetworkWhenUpgradeNoNet = false;
    public static volatile boolean sOutGoing = false;
    public static Map<String, String> sRealtimeMd5Map = null;
    public static int sRetryDownoadHostCareApksTimesCount = 0;
    public static int sRetryPingTimesCount = 0;
    public static boolean sSetRetrmAlarm = false;
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

    /* loaded from: classes2.dex */
    public class UpgradeResult {
        public int networkId;
        public int resultId;

        public UpgradeResult(int i2, int i3) {
            this.networkId = i2;
            this.resultId = i3;
        }
    }

    public U(Context context, int i2, boolean z) {
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
        Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
        if (map != null && !map.keySet().contains(Integer.valueOf(apkInfo.key))) {
            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i2, 8));
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
                MyReceiver myReceiver = com.baidu.sofire.utility.c.f10405g;
                if (myReceiver == null) {
                    com.baidu.sofire.utility.c.f10405g = new MyReceiver().a();
                } else {
                    myReceiver.a();
                }
                com.baidu.sofire.utility.c.a(this.context, com.baidu.sofire.utility.c.f10405g, intentFilter);
                sMonitorNetworkWhenUpgradeNoNet = true;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.sofire.h.a aVar = this.mPreferenceManager;
        long j = aVar.f10321a.getLong("pu_ap_fd", 0L);
        if (j == 0) {
            j = System.currentTimeMillis();
            aVar.c();
        }
        if (currentTimeMillis - j > 86400000) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handlePluginDownload(ApkInfo apkInfo, File file, File file2, int i2) {
        boolean a2;
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        if (!"com.baidu.input_huawei".equals(this.context.getPackageName()) || this.mPreferenceManager.w()) {
            if (q.a(this.context)) {
                a2 = new q(this.context).a(apkInfo.downloadURL, file);
            } else {
                a2 = new m(this.context).a(apkInfo.downloadURL, file);
            }
            if (a2) {
                if (file2.exists()) {
                    file2.delete();
                }
                new Asc();
                if (g.a(file, file2, apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes("utf-8")) != 0) {
                    if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                        this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i2, 7));
                    }
                    a2 = false;
                }
            } else if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i2, 4));
            }
            String a3 = o.a(file2);
            file.delete();
            if (a2) {
                if (apkInfo.apkMD5.equals(a3)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8 A[Catch: all -> 0x01cc, TryCatch #0 {all -> 0x01cc, blocks: (B:3:0x0007, B:5:0x001f, B:7:0x0029, B:9:0x002d, B:11:0x003f, B:13:0x0050, B:15:0x0058, B:16:0x005d, B:18:0x00b3, B:23:0x00c8, B:25:0x00cc, B:36:0x0114, B:72:0x01c8, B:39:0x011c, B:41:0x0126, B:46:0x0134, B:48:0x013c, B:50:0x0146, B:51:0x0151, B:53:0x0159, B:56:0x0164, B:59:0x016c, B:61:0x0178, B:63:0x0185, B:64:0x0196, B:68:0x01ab, B:70:0x01bd, B:65:0x019b, B:26:0x00e6, B:28:0x00ef, B:30:0x00ff, B:32:0x010c), top: B:103:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0114 A[Catch: all -> 0x01cc, TryCatch #0 {all -> 0x01cc, blocks: (B:3:0x0007, B:5:0x001f, B:7:0x0029, B:9:0x002d, B:11:0x003f, B:13:0x0050, B:15:0x0058, B:16:0x005d, B:18:0x00b3, B:23:0x00c8, B:25:0x00cc, B:36:0x0114, B:72:0x01c8, B:39:0x011c, B:41:0x0126, B:46:0x0134, B:48:0x013c, B:50:0x0146, B:51:0x0151, B:53:0x0159, B:56:0x0164, B:59:0x016c, B:61:0x0178, B:63:0x0185, B:64:0x0196, B:68:0x01ab, B:70:0x01bd, B:65:0x019b, B:26:0x00e6, B:28:0x00ef, B:30:0x00ff, B:32:0x010c), top: B:103:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0159 A[Catch: all -> 0x01cc, TryCatch #0 {all -> 0x01cc, blocks: (B:3:0x0007, B:5:0x001f, B:7:0x0029, B:9:0x002d, B:11:0x003f, B:13:0x0050, B:15:0x0058, B:16:0x005d, B:18:0x00b3, B:23:0x00c8, B:25:0x00cc, B:36:0x0114, B:72:0x01c8, B:39:0x011c, B:41:0x0126, B:46:0x0134, B:48:0x013c, B:50:0x0146, B:51:0x0151, B:53:0x0159, B:56:0x0164, B:59:0x016c, B:61:0x0178, B:63:0x0185, B:64:0x0196, B:68:0x01ab, B:70:0x01bd, B:65:0x019b, B:26:0x00e6, B:28:0x00ef, B:30:0x00ff, B:32:0x010c), top: B:103:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0178 A[Catch: all -> 0x01cc, TryCatch #0 {all -> 0x01cc, blocks: (B:3:0x0007, B:5:0x001f, B:7:0x0029, B:9:0x002d, B:11:0x003f, B:13:0x0050, B:15:0x0058, B:16:0x005d, B:18:0x00b3, B:23:0x00c8, B:25:0x00cc, B:36:0x0114, B:72:0x01c8, B:39:0x011c, B:41:0x0126, B:46:0x0134, B:48:0x013c, B:50:0x0146, B:51:0x0151, B:53:0x0159, B:56:0x0164, B:59:0x016c, B:61:0x0178, B:63:0x0185, B:64:0x0196, B:68:0x01ab, B:70:0x01bd, B:65:0x019b, B:26:0x00e6, B:28:0x00ef, B:30:0x00ff, B:32:0x010c), top: B:103:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019b A[Catch: all -> 0x01cc, TryCatch #0 {all -> 0x01cc, blocks: (B:3:0x0007, B:5:0x001f, B:7:0x0029, B:9:0x002d, B:11:0x003f, B:13:0x0050, B:15:0x0058, B:16:0x005d, B:18:0x00b3, B:23:0x00c8, B:25:0x00cc, B:36:0x0114, B:72:0x01c8, B:39:0x011c, B:41:0x0126, B:46:0x0134, B:48:0x013c, B:50:0x0146, B:51:0x0151, B:53:0x0159, B:56:0x0164, B:59:0x016c, B:61:0x0178, B:63:0x0185, B:64:0x0196, B:68:0x01ab, B:70:0x01bd, B:65:0x019b, B:26:0x00e6, B:28:0x00ef, B:30:0x00ff, B:32:0x010c), top: B:103:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c8 A[Catch: all -> 0x01cc, TRY_LEAVE, TryCatch #0 {all -> 0x01cc, blocks: (B:3:0x0007, B:5:0x001f, B:7:0x0029, B:9:0x002d, B:11:0x003f, B:13:0x0050, B:15:0x0058, B:16:0x005d, B:18:0x00b3, B:23:0x00c8, B:25:0x00cc, B:36:0x0114, B:72:0x01c8, B:39:0x011c, B:41:0x0126, B:46:0x0134, B:48:0x013c, B:50:0x0146, B:51:0x0151, B:53:0x0159, B:56:0x0164, B:59:0x016c, B:61:0x0178, B:63:0x0185, B:64:0x0196, B:68:0x01ab, B:70:0x01bd, B:65:0x019b, B:26:0x00e6, B:28:0x00ef, B:30:0x00ff, B:32:0x010c), top: B:103:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handlePluginUpgrade(final ApkInfo apkInfo) {
        boolean z;
        boolean z2;
        File file;
        boolean z3;
        boolean z4;
        boolean z5;
        File file2;
        try {
            final int k = com.baidu.sofire.utility.c.k(this.context);
            final List<Integer> p = this.mPreferenceManager.p();
            if (!p.contains(Integer.valueOf(apkInfo.key)) && !com.baidu.sofire.utility.c.b(this.context, apkInfo.network)) {
                if (this.mUpgradeResultMap == null || this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    return;
                }
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(k, 3));
                return;
            }
            if (!this.tmpDir.exists()) {
                this.tmpDir.mkdir();
            }
            ApkInfo a2 = this.loadedPluginDB.a(apkInfo.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT);
            final File file3 = new File(this.tmpDir, apkInfo.key + "-" + apkInfo.versionName + ".tmp");
            final File file4 = new File(this.tmpDir, apkInfo.key + "-" + apkInfo.versionName + ".zip");
            if (file4.exists()) {
                if (apkInfo.apkMD5.equals(o.a(file4))) {
                    z = false;
                    z2 = true;
                    if (z) {
                        file = file4;
                    } else if (apkInfo.isNextLoad) {
                        file = file4;
                        x.a(this.context).a(new Runnable() { // from class: com.baidu.sofire.ac.U.3
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (!U.this.handlePluginDownload(apkInfo, file3, file4, k)) {
                                        U.this.handlePluginDownError(apkInfo, file4, k, p);
                                        return;
                                    }
                                    apkInfo.pkgPath = file4.getAbsolutePath();
                                    ApkInfo apkInfo2 = new ApkInfo(apkInfo);
                                    apkInfo2.key += ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT;
                                    if (!TextUtils.isEmpty(apkInfo2.packageName)) {
                                        apkInfo2.packageName = new StringBuilder(apkInfo2.packageName).reverse().toString();
                                    }
                                    U.this.loadedPluginDB.a(apkInfo2);
                                } catch (Throwable unused) {
                                    com.baidu.sofire.utility.c.a();
                                }
                            }
                        });
                    } else {
                        file = file4;
                        z2 = handlePluginDownload(apkInfo, file3, file, k);
                        z3 = !z2;
                        if (a2 != null) {
                            this.loadedPluginDB.h(a2.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT);
                            if (!TextUtils.isEmpty(a2.pkgPath)) {
                                File file5 = new File(a2.pkgPath);
                                if (file5.exists()) {
                                    file5.delete();
                                }
                            }
                        }
                        if (z2) {
                            pluginUpdate(file, apkInfo, k);
                        } else {
                            if (a2 != null) {
                                ApkInfo a3 = this.loadedPluginDB.a(apkInfo.key);
                                if (a3 != null && !com.baidu.sofire.utility.c.b(a2.versionName, a3.versionName)) {
                                    z5 = false;
                                    if (!TextUtils.isEmpty(a2.versionName) && a2.versionName.equals(apkInfo.versionName)) {
                                        this.loadedPluginDB.a(a2.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, a2.versionName);
                                        z5 = false;
                                    }
                                    file2 = TextUtils.isEmpty(a2.pkgPath) ? new File(a2.pkgPath) : null;
                                    if (file2 != null && file2.exists() && z5) {
                                        if (!a2.apkMD5.equals(o.a(file2))) {
                                            a2.key -= ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT;
                                            if (!TextUtils.isEmpty(a2.packageName)) {
                                                a2.packageName = new StringBuilder(a2.packageName).reverse().toString();
                                            }
                                            pluginUpdate(file2, a2, k);
                                            z4 = true;
                                            if (!z4 && f.a(this.context.getApplicationContext()).d(apkInfo.packageName) == null) {
                                                this.forHostAPP.a(apkInfo.key, apkInfo.versionName, null);
                                            }
                                        } else {
                                            this.loadedPluginDB.a(a2.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, a2.versionName);
                                            file2.delete();
                                        }
                                    }
                                }
                                z5 = true;
                                if (!TextUtils.isEmpty(a2.versionName)) {
                                    this.loadedPluginDB.a(a2.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, a2.versionName);
                                    z5 = false;
                                }
                                if (TextUtils.isEmpty(a2.pkgPath)) {
                                }
                                if (file2 != null) {
                                    if (!a2.apkMD5.equals(o.a(file2))) {
                                    }
                                }
                            }
                            z4 = false;
                            if (!z4) {
                                this.forHostAPP.a(apkInfo.key, apkInfo.versionName, null);
                            }
                        }
                        if (z3) {
                            handlePluginDownError(apkInfo, file, k, p);
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
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(com.baidu.sofire.utility.c.k(this.context), 2));
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
                    if (com.baidu.sofire.utility.c.f10405g == null) {
                        com.baidu.sofire.utility.c.f10405g = new MyReceiver().a();
                    } else {
                        com.baidu.sofire.utility.c.f10405g.a();
                    }
                    com.baidu.sofire.utility.c.a(this.context, com.baidu.sofire.utility.c.f10405g, intentFilter);
                    sMonitorNetworkWhenUpgradeNoNet = true;
                }
            } catch (Throwable unused3) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    private void handleThreadEnd(String str) {
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
                hashMap.put("12", str.replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
            }
            hashMap.put("13", Integer.valueOf(this.mStartNetwork));
            hashMap.put("14", Integer.valueOf(com.baidu.sofire.utility.c.k(this.context)));
            com.baidu.sofire.utility.c.a(this.context, "1003129", (Map<String, Object>) hashMap, false);
        } catch (Throwable unused2) {
            com.baidu.sofire.utility.c.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00e7 A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:26:0x00cf, B:28:0x00e7, B:29:0x00f7), top: B:33:0x00cf }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleThreadStart() {
        try {
            try {
                try {
                    long j = this.mPreferenceManager.f10321a.getLong("slruct", 0L);
                    long currentTimeMillis = System.currentTimeMillis();
                    int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                    if (i2 > 0 && currentTimeMillis - j > 86400000) {
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

    private void pluginUpdate(File file, ApkInfo apkInfo, int i2) {
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
        ApkInfo a2 = this.loadedPluginDB.a(apkInfo.key);
        if (a2 == null) {
            sb.append("apkInDB == null");
        } else {
            File file4 = new File(a2.pkgPath);
            sb.append("origAPK path:" + file4.getAbsolutePath() + ", exists=" + file4.exists() + ", canRead=" + file4.canRead() + ", isFile=" + file4.isFile() + ",length" + file4.length());
        }
        boolean a3 = this.forHostAPP.a(apkInfo, str);
        this.loadedPluginDB.a(apkInfo.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, apkInfo.versionName);
        if (!a3) {
            Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
            if (map == null || map.keySet().contains(Integer.valueOf(apkInfo.key))) {
                return;
            }
            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i2, 5));
            return;
        }
        int g2 = this.loadedPluginDB.g(apkInfo.key);
        if (g2 < 3 && g2 != -1) {
            this.loadedPluginDB.b(apkInfo.key, g2 + 1);
        }
        Map<Integer, UpgradeResult> map2 = this.mUpgradeResultMap;
        if (map2 != null) {
            map2.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i2, 1));
        }
    }

    public void handleWork(Context context, Intent intent) {
        this.context = context;
        this.loadedPluginDB = a.a(context);
        this.mPreferenceManager = com.baidu.sofire.h.a.a(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.forHostAPP = c.a(context);
        this.mFrom = intent.getIntExtra("from", 0);
        x.a(context).b(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:192:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0437 A[Catch: all -> 0x076a, TryCatch #18 {, blocks: (B:17:0x0018, B:19:0x0025, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x003c, B:29:0x0040, B:30:0x0045, B:41:0x0057, B:43:0x005f, B:44:0x0065, B:50:0x00f4, B:52:0x00fd, B:55:0x010c, B:57:0x0110, B:58:0x0112, B:60:0x0120, B:62:0x0129, B:66:0x0135, B:68:0x013f, B:70:0x0143, B:75:0x0156, B:77:0x015e, B:78:0x0166, B:80:0x016a, B:82:0x016e, B:84:0x0172, B:86:0x0176, B:91:0x0194, B:93:0x019f, B:95:0x01b0, B:97:0x01bd, B:99:0x01c1, B:100:0x01c6, B:101:0x01c9, B:102:0x01d0, B:94:0x01ab, B:88:0x017a, B:90:0x0186, B:103:0x01d1, B:105:0x021c, B:107:0x0220, B:108:0x0224, B:109:0x022b, B:110:0x022c, B:112:0x0230, B:113:0x0234, B:115:0x023a, B:117:0x0255, B:118:0x025e, B:120:0x0274, B:121:0x0278, B:123:0x028b, B:124:0x0292, B:126:0x0298, B:128:0x029e, B:131:0x02aa, B:132:0x02ae, B:136:0x02ba, B:140:0x02c8, B:142:0x02d0, B:144:0x02e5, B:148:0x02fe, B:189:0x0401, B:190:0x0405, B:194:0x0419, B:199:0x0427, B:203:0x0433, B:205:0x0437, B:206:0x0439, B:208:0x0441, B:209:0x0451, B:211:0x0459, B:215:0x0466, B:217:0x046e, B:219:0x0476, B:221:0x0480, B:222:0x048e, B:224:0x0494, B:225:0x04a3, B:227:0x04aa, B:229:0x04c5, B:230:0x04d6, B:232:0x04dc, B:234:0x04e1, B:236:0x04f1, B:238:0x04f7, B:239:0x0500, B:242:0x050c, B:243:0x050f, B:245:0x0513, B:247:0x0521, B:249:0x0530, B:251:0x0534, B:258:0x0563, B:248:0x0529, B:254:0x0547, B:256:0x0551, B:257:0x055e, B:259:0x0567, B:261:0x0574, B:263:0x058e, B:265:0x0598, B:266:0x059d, B:267:0x05a1, B:269:0x05a7, B:271:0x05b7, B:273:0x05bb, B:274:0x05c6, B:276:0x05d0, B:277:0x05ec, B:279:0x05f2, B:281:0x05fc, B:282:0x0603, B:283:0x0606, B:284:0x061a, B:286:0x0620, B:288:0x062c, B:290:0x0634, B:294:0x0642, B:297:0x064c, B:299:0x065f, B:300:0x0662, B:302:0x068c, B:303:0x068f, B:309:0x06d3, B:304:0x0697, B:306:0x06aa, B:308:0x06cd, B:315:0x06f1, B:310:0x06de, B:312:0x06e4, B:314:0x06ee, B:316:0x06f5, B:317:0x0705, B:332:0x0723, B:334:0x0728, B:336:0x072c, B:342:0x0751, B:344:0x0755, B:346:0x075a, B:347:0x0761, B:348:0x0762, B:349:0x0769, B:338:0x0731, B:340:0x073f, B:341:0x074a, B:54:0x0101, B:195:0x041b, B:45:0x0067, B:72:0x0147), top: B:410:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0441 A[Catch: all -> 0x076a, TryCatch #18 {, blocks: (B:17:0x0018, B:19:0x0025, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x003c, B:29:0x0040, B:30:0x0045, B:41:0x0057, B:43:0x005f, B:44:0x0065, B:50:0x00f4, B:52:0x00fd, B:55:0x010c, B:57:0x0110, B:58:0x0112, B:60:0x0120, B:62:0x0129, B:66:0x0135, B:68:0x013f, B:70:0x0143, B:75:0x0156, B:77:0x015e, B:78:0x0166, B:80:0x016a, B:82:0x016e, B:84:0x0172, B:86:0x0176, B:91:0x0194, B:93:0x019f, B:95:0x01b0, B:97:0x01bd, B:99:0x01c1, B:100:0x01c6, B:101:0x01c9, B:102:0x01d0, B:94:0x01ab, B:88:0x017a, B:90:0x0186, B:103:0x01d1, B:105:0x021c, B:107:0x0220, B:108:0x0224, B:109:0x022b, B:110:0x022c, B:112:0x0230, B:113:0x0234, B:115:0x023a, B:117:0x0255, B:118:0x025e, B:120:0x0274, B:121:0x0278, B:123:0x028b, B:124:0x0292, B:126:0x0298, B:128:0x029e, B:131:0x02aa, B:132:0x02ae, B:136:0x02ba, B:140:0x02c8, B:142:0x02d0, B:144:0x02e5, B:148:0x02fe, B:189:0x0401, B:190:0x0405, B:194:0x0419, B:199:0x0427, B:203:0x0433, B:205:0x0437, B:206:0x0439, B:208:0x0441, B:209:0x0451, B:211:0x0459, B:215:0x0466, B:217:0x046e, B:219:0x0476, B:221:0x0480, B:222:0x048e, B:224:0x0494, B:225:0x04a3, B:227:0x04aa, B:229:0x04c5, B:230:0x04d6, B:232:0x04dc, B:234:0x04e1, B:236:0x04f1, B:238:0x04f7, B:239:0x0500, B:242:0x050c, B:243:0x050f, B:245:0x0513, B:247:0x0521, B:249:0x0530, B:251:0x0534, B:258:0x0563, B:248:0x0529, B:254:0x0547, B:256:0x0551, B:257:0x055e, B:259:0x0567, B:261:0x0574, B:263:0x058e, B:265:0x0598, B:266:0x059d, B:267:0x05a1, B:269:0x05a7, B:271:0x05b7, B:273:0x05bb, B:274:0x05c6, B:276:0x05d0, B:277:0x05ec, B:279:0x05f2, B:281:0x05fc, B:282:0x0603, B:283:0x0606, B:284:0x061a, B:286:0x0620, B:288:0x062c, B:290:0x0634, B:294:0x0642, B:297:0x064c, B:299:0x065f, B:300:0x0662, B:302:0x068c, B:303:0x068f, B:309:0x06d3, B:304:0x0697, B:306:0x06aa, B:308:0x06cd, B:315:0x06f1, B:310:0x06de, B:312:0x06e4, B:314:0x06ee, B:316:0x06f5, B:317:0x0705, B:332:0x0723, B:334:0x0728, B:336:0x072c, B:342:0x0751, B:344:0x0755, B:346:0x075a, B:347:0x0761, B:348:0x0762, B:349:0x0769, B:338:0x0731, B:340:0x073f, B:341:0x074a, B:54:0x0101, B:195:0x041b, B:45:0x0067, B:72:0x0147), top: B:410:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0459 A[Catch: all -> 0x076a, TryCatch #18 {, blocks: (B:17:0x0018, B:19:0x0025, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x003c, B:29:0x0040, B:30:0x0045, B:41:0x0057, B:43:0x005f, B:44:0x0065, B:50:0x00f4, B:52:0x00fd, B:55:0x010c, B:57:0x0110, B:58:0x0112, B:60:0x0120, B:62:0x0129, B:66:0x0135, B:68:0x013f, B:70:0x0143, B:75:0x0156, B:77:0x015e, B:78:0x0166, B:80:0x016a, B:82:0x016e, B:84:0x0172, B:86:0x0176, B:91:0x0194, B:93:0x019f, B:95:0x01b0, B:97:0x01bd, B:99:0x01c1, B:100:0x01c6, B:101:0x01c9, B:102:0x01d0, B:94:0x01ab, B:88:0x017a, B:90:0x0186, B:103:0x01d1, B:105:0x021c, B:107:0x0220, B:108:0x0224, B:109:0x022b, B:110:0x022c, B:112:0x0230, B:113:0x0234, B:115:0x023a, B:117:0x0255, B:118:0x025e, B:120:0x0274, B:121:0x0278, B:123:0x028b, B:124:0x0292, B:126:0x0298, B:128:0x029e, B:131:0x02aa, B:132:0x02ae, B:136:0x02ba, B:140:0x02c8, B:142:0x02d0, B:144:0x02e5, B:148:0x02fe, B:189:0x0401, B:190:0x0405, B:194:0x0419, B:199:0x0427, B:203:0x0433, B:205:0x0437, B:206:0x0439, B:208:0x0441, B:209:0x0451, B:211:0x0459, B:215:0x0466, B:217:0x046e, B:219:0x0476, B:221:0x0480, B:222:0x048e, B:224:0x0494, B:225:0x04a3, B:227:0x04aa, B:229:0x04c5, B:230:0x04d6, B:232:0x04dc, B:234:0x04e1, B:236:0x04f1, B:238:0x04f7, B:239:0x0500, B:242:0x050c, B:243:0x050f, B:245:0x0513, B:247:0x0521, B:249:0x0530, B:251:0x0534, B:258:0x0563, B:248:0x0529, B:254:0x0547, B:256:0x0551, B:257:0x055e, B:259:0x0567, B:261:0x0574, B:263:0x058e, B:265:0x0598, B:266:0x059d, B:267:0x05a1, B:269:0x05a7, B:271:0x05b7, B:273:0x05bb, B:274:0x05c6, B:276:0x05d0, B:277:0x05ec, B:279:0x05f2, B:281:0x05fc, B:282:0x0603, B:283:0x0606, B:284:0x061a, B:286:0x0620, B:288:0x062c, B:290:0x0634, B:294:0x0642, B:297:0x064c, B:299:0x065f, B:300:0x0662, B:302:0x068c, B:303:0x068f, B:309:0x06d3, B:304:0x0697, B:306:0x06aa, B:308:0x06cd, B:315:0x06f1, B:310:0x06de, B:312:0x06e4, B:314:0x06ee, B:316:0x06f5, B:317:0x0705, B:332:0x0723, B:334:0x0728, B:336:0x072c, B:342:0x0751, B:344:0x0755, B:346:0x075a, B:347:0x0761, B:348:0x0762, B:349:0x0769, B:338:0x0731, B:340:0x073f, B:341:0x074a, B:54:0x0101, B:195:0x041b, B:45:0x0067, B:72:0x0147), top: B:410:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x04c5 A[Catch: all -> 0x076a, TryCatch #18 {, blocks: (B:17:0x0018, B:19:0x0025, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x003c, B:29:0x0040, B:30:0x0045, B:41:0x0057, B:43:0x005f, B:44:0x0065, B:50:0x00f4, B:52:0x00fd, B:55:0x010c, B:57:0x0110, B:58:0x0112, B:60:0x0120, B:62:0x0129, B:66:0x0135, B:68:0x013f, B:70:0x0143, B:75:0x0156, B:77:0x015e, B:78:0x0166, B:80:0x016a, B:82:0x016e, B:84:0x0172, B:86:0x0176, B:91:0x0194, B:93:0x019f, B:95:0x01b0, B:97:0x01bd, B:99:0x01c1, B:100:0x01c6, B:101:0x01c9, B:102:0x01d0, B:94:0x01ab, B:88:0x017a, B:90:0x0186, B:103:0x01d1, B:105:0x021c, B:107:0x0220, B:108:0x0224, B:109:0x022b, B:110:0x022c, B:112:0x0230, B:113:0x0234, B:115:0x023a, B:117:0x0255, B:118:0x025e, B:120:0x0274, B:121:0x0278, B:123:0x028b, B:124:0x0292, B:126:0x0298, B:128:0x029e, B:131:0x02aa, B:132:0x02ae, B:136:0x02ba, B:140:0x02c8, B:142:0x02d0, B:144:0x02e5, B:148:0x02fe, B:189:0x0401, B:190:0x0405, B:194:0x0419, B:199:0x0427, B:203:0x0433, B:205:0x0437, B:206:0x0439, B:208:0x0441, B:209:0x0451, B:211:0x0459, B:215:0x0466, B:217:0x046e, B:219:0x0476, B:221:0x0480, B:222:0x048e, B:224:0x0494, B:225:0x04a3, B:227:0x04aa, B:229:0x04c5, B:230:0x04d6, B:232:0x04dc, B:234:0x04e1, B:236:0x04f1, B:238:0x04f7, B:239:0x0500, B:242:0x050c, B:243:0x050f, B:245:0x0513, B:247:0x0521, B:249:0x0530, B:251:0x0534, B:258:0x0563, B:248:0x0529, B:254:0x0547, B:256:0x0551, B:257:0x055e, B:259:0x0567, B:261:0x0574, B:263:0x058e, B:265:0x0598, B:266:0x059d, B:267:0x05a1, B:269:0x05a7, B:271:0x05b7, B:273:0x05bb, B:274:0x05c6, B:276:0x05d0, B:277:0x05ec, B:279:0x05f2, B:281:0x05fc, B:282:0x0603, B:283:0x0606, B:284:0x061a, B:286:0x0620, B:288:0x062c, B:290:0x0634, B:294:0x0642, B:297:0x064c, B:299:0x065f, B:300:0x0662, B:302:0x068c, B:303:0x068f, B:309:0x06d3, B:304:0x0697, B:306:0x06aa, B:308:0x06cd, B:315:0x06f1, B:310:0x06de, B:312:0x06e4, B:314:0x06ee, B:316:0x06f5, B:317:0x0705, B:332:0x0723, B:334:0x0728, B:336:0x072c, B:342:0x0751, B:344:0x0755, B:346:0x075a, B:347:0x0761, B:348:0x0762, B:349:0x0769, B:338:0x0731, B:340:0x073f, B:341:0x074a, B:54:0x0101, B:195:0x041b, B:45:0x0067, B:72:0x0147), top: B:410:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x04dc A[Catch: all -> 0x076a, TryCatch #18 {, blocks: (B:17:0x0018, B:19:0x0025, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x003c, B:29:0x0040, B:30:0x0045, B:41:0x0057, B:43:0x005f, B:44:0x0065, B:50:0x00f4, B:52:0x00fd, B:55:0x010c, B:57:0x0110, B:58:0x0112, B:60:0x0120, B:62:0x0129, B:66:0x0135, B:68:0x013f, B:70:0x0143, B:75:0x0156, B:77:0x015e, B:78:0x0166, B:80:0x016a, B:82:0x016e, B:84:0x0172, B:86:0x0176, B:91:0x0194, B:93:0x019f, B:95:0x01b0, B:97:0x01bd, B:99:0x01c1, B:100:0x01c6, B:101:0x01c9, B:102:0x01d0, B:94:0x01ab, B:88:0x017a, B:90:0x0186, B:103:0x01d1, B:105:0x021c, B:107:0x0220, B:108:0x0224, B:109:0x022b, B:110:0x022c, B:112:0x0230, B:113:0x0234, B:115:0x023a, B:117:0x0255, B:118:0x025e, B:120:0x0274, B:121:0x0278, B:123:0x028b, B:124:0x0292, B:126:0x0298, B:128:0x029e, B:131:0x02aa, B:132:0x02ae, B:136:0x02ba, B:140:0x02c8, B:142:0x02d0, B:144:0x02e5, B:148:0x02fe, B:189:0x0401, B:190:0x0405, B:194:0x0419, B:199:0x0427, B:203:0x0433, B:205:0x0437, B:206:0x0439, B:208:0x0441, B:209:0x0451, B:211:0x0459, B:215:0x0466, B:217:0x046e, B:219:0x0476, B:221:0x0480, B:222:0x048e, B:224:0x0494, B:225:0x04a3, B:227:0x04aa, B:229:0x04c5, B:230:0x04d6, B:232:0x04dc, B:234:0x04e1, B:236:0x04f1, B:238:0x04f7, B:239:0x0500, B:242:0x050c, B:243:0x050f, B:245:0x0513, B:247:0x0521, B:249:0x0530, B:251:0x0534, B:258:0x0563, B:248:0x0529, B:254:0x0547, B:256:0x0551, B:257:0x055e, B:259:0x0567, B:261:0x0574, B:263:0x058e, B:265:0x0598, B:266:0x059d, B:267:0x05a1, B:269:0x05a7, B:271:0x05b7, B:273:0x05bb, B:274:0x05c6, B:276:0x05d0, B:277:0x05ec, B:279:0x05f2, B:281:0x05fc, B:282:0x0603, B:283:0x0606, B:284:0x061a, B:286:0x0620, B:288:0x062c, B:290:0x0634, B:294:0x0642, B:297:0x064c, B:299:0x065f, B:300:0x0662, B:302:0x068c, B:303:0x068f, B:309:0x06d3, B:304:0x0697, B:306:0x06aa, B:308:0x06cd, B:315:0x06f1, B:310:0x06de, B:312:0x06e4, B:314:0x06ee, B:316:0x06f5, B:317:0x0705, B:332:0x0723, B:334:0x0728, B:336:0x072c, B:342:0x0751, B:344:0x0755, B:346:0x075a, B:347:0x0761, B:348:0x0762, B:349:0x0769, B:338:0x0731, B:340:0x073f, B:341:0x074a, B:54:0x0101, B:195:0x041b, B:45:0x0067, B:72:0x0147), top: B:410:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x04e1 A[Catch: all -> 0x076a, TryCatch #18 {, blocks: (B:17:0x0018, B:19:0x0025, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x003c, B:29:0x0040, B:30:0x0045, B:41:0x0057, B:43:0x005f, B:44:0x0065, B:50:0x00f4, B:52:0x00fd, B:55:0x010c, B:57:0x0110, B:58:0x0112, B:60:0x0120, B:62:0x0129, B:66:0x0135, B:68:0x013f, B:70:0x0143, B:75:0x0156, B:77:0x015e, B:78:0x0166, B:80:0x016a, B:82:0x016e, B:84:0x0172, B:86:0x0176, B:91:0x0194, B:93:0x019f, B:95:0x01b0, B:97:0x01bd, B:99:0x01c1, B:100:0x01c6, B:101:0x01c9, B:102:0x01d0, B:94:0x01ab, B:88:0x017a, B:90:0x0186, B:103:0x01d1, B:105:0x021c, B:107:0x0220, B:108:0x0224, B:109:0x022b, B:110:0x022c, B:112:0x0230, B:113:0x0234, B:115:0x023a, B:117:0x0255, B:118:0x025e, B:120:0x0274, B:121:0x0278, B:123:0x028b, B:124:0x0292, B:126:0x0298, B:128:0x029e, B:131:0x02aa, B:132:0x02ae, B:136:0x02ba, B:140:0x02c8, B:142:0x02d0, B:144:0x02e5, B:148:0x02fe, B:189:0x0401, B:190:0x0405, B:194:0x0419, B:199:0x0427, B:203:0x0433, B:205:0x0437, B:206:0x0439, B:208:0x0441, B:209:0x0451, B:211:0x0459, B:215:0x0466, B:217:0x046e, B:219:0x0476, B:221:0x0480, B:222:0x048e, B:224:0x0494, B:225:0x04a3, B:227:0x04aa, B:229:0x04c5, B:230:0x04d6, B:232:0x04dc, B:234:0x04e1, B:236:0x04f1, B:238:0x04f7, B:239:0x0500, B:242:0x050c, B:243:0x050f, B:245:0x0513, B:247:0x0521, B:249:0x0530, B:251:0x0534, B:258:0x0563, B:248:0x0529, B:254:0x0547, B:256:0x0551, B:257:0x055e, B:259:0x0567, B:261:0x0574, B:263:0x058e, B:265:0x0598, B:266:0x059d, B:267:0x05a1, B:269:0x05a7, B:271:0x05b7, B:273:0x05bb, B:274:0x05c6, B:276:0x05d0, B:277:0x05ec, B:279:0x05f2, B:281:0x05fc, B:282:0x0603, B:283:0x0606, B:284:0x061a, B:286:0x0620, B:288:0x062c, B:290:0x0634, B:294:0x0642, B:297:0x064c, B:299:0x065f, B:300:0x0662, B:302:0x068c, B:303:0x068f, B:309:0x06d3, B:304:0x0697, B:306:0x06aa, B:308:0x06cd, B:315:0x06f1, B:310:0x06de, B:312:0x06e4, B:314:0x06ee, B:316:0x06f5, B:317:0x0705, B:332:0x0723, B:334:0x0728, B:336:0x072c, B:342:0x0751, B:344:0x0755, B:346:0x075a, B:347:0x0761, B:348:0x0762, B:349:0x0769, B:338:0x0731, B:340:0x073f, B:341:0x074a, B:54:0x0101, B:195:0x041b, B:45:0x0067, B:72:0x0147), top: B:410:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0567 A[Catch: all -> 0x076a, TryCatch #18 {, blocks: (B:17:0x0018, B:19:0x0025, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x003c, B:29:0x0040, B:30:0x0045, B:41:0x0057, B:43:0x005f, B:44:0x0065, B:50:0x00f4, B:52:0x00fd, B:55:0x010c, B:57:0x0110, B:58:0x0112, B:60:0x0120, B:62:0x0129, B:66:0x0135, B:68:0x013f, B:70:0x0143, B:75:0x0156, B:77:0x015e, B:78:0x0166, B:80:0x016a, B:82:0x016e, B:84:0x0172, B:86:0x0176, B:91:0x0194, B:93:0x019f, B:95:0x01b0, B:97:0x01bd, B:99:0x01c1, B:100:0x01c6, B:101:0x01c9, B:102:0x01d0, B:94:0x01ab, B:88:0x017a, B:90:0x0186, B:103:0x01d1, B:105:0x021c, B:107:0x0220, B:108:0x0224, B:109:0x022b, B:110:0x022c, B:112:0x0230, B:113:0x0234, B:115:0x023a, B:117:0x0255, B:118:0x025e, B:120:0x0274, B:121:0x0278, B:123:0x028b, B:124:0x0292, B:126:0x0298, B:128:0x029e, B:131:0x02aa, B:132:0x02ae, B:136:0x02ba, B:140:0x02c8, B:142:0x02d0, B:144:0x02e5, B:148:0x02fe, B:189:0x0401, B:190:0x0405, B:194:0x0419, B:199:0x0427, B:203:0x0433, B:205:0x0437, B:206:0x0439, B:208:0x0441, B:209:0x0451, B:211:0x0459, B:215:0x0466, B:217:0x046e, B:219:0x0476, B:221:0x0480, B:222:0x048e, B:224:0x0494, B:225:0x04a3, B:227:0x04aa, B:229:0x04c5, B:230:0x04d6, B:232:0x04dc, B:234:0x04e1, B:236:0x04f1, B:238:0x04f7, B:239:0x0500, B:242:0x050c, B:243:0x050f, B:245:0x0513, B:247:0x0521, B:249:0x0530, B:251:0x0534, B:258:0x0563, B:248:0x0529, B:254:0x0547, B:256:0x0551, B:257:0x055e, B:259:0x0567, B:261:0x0574, B:263:0x058e, B:265:0x0598, B:266:0x059d, B:267:0x05a1, B:269:0x05a7, B:271:0x05b7, B:273:0x05bb, B:274:0x05c6, B:276:0x05d0, B:277:0x05ec, B:279:0x05f2, B:281:0x05fc, B:282:0x0603, B:283:0x0606, B:284:0x061a, B:286:0x0620, B:288:0x062c, B:290:0x0634, B:294:0x0642, B:297:0x064c, B:299:0x065f, B:300:0x0662, B:302:0x068c, B:303:0x068f, B:309:0x06d3, B:304:0x0697, B:306:0x06aa, B:308:0x06cd, B:315:0x06f1, B:310:0x06de, B:312:0x06e4, B:314:0x06ee, B:316:0x06f5, B:317:0x0705, B:332:0x0723, B:334:0x0728, B:336:0x072c, B:342:0x0751, B:344:0x0755, B:346:0x075a, B:347:0x0761, B:348:0x0762, B:349:0x0769, B:338:0x0731, B:340:0x073f, B:341:0x074a, B:54:0x0101, B:195:0x041b, B:45:0x0067, B:72:0x0147), top: B:410:0x0018 }] */
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
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
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
            long currentTimeMillis = ((System.currentTimeMillis() + (a2.f10321a.getInt("appal_te", 24) * 3600000)) - 600000) + ((long) (Math.random() * 1200000.0d));
            a2.f10322b.putLong("npuct", currentTimeMillis);
            a2.f10322b.commit();
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
                    if (com.baidu.sofire.utility.c.f10405g != null && (sMonitorNetworkWhenUpgradeNoNet || com.baidu.sofire.utility.c.f10399a)) {
                        this.context.getApplicationContext().unregisterReceiver(com.baidu.sofire.utility.c.f10405g);
                    }
                    sMonitorNetworkWhenUpgradeNoNet = false;
                    com.baidu.sofire.utility.c.f10399a = false;
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
                        if (com.baidu.sofire.utility.c.f10405g == null) {
                            com.baidu.sofire.utility.c.f10405g = new MyReceiver().a();
                        } else {
                            com.baidu.sofire.utility.c.f10405g.a();
                        }
                        com.baidu.sofire.utility.c.a(this.context, com.baidu.sofire.utility.c.f10405g, intentFilter);
                        sMonitorNetworkWhenUpgradeNoNet = true;
                        if (this.mEndReason == 0) {
                            if (com.baidu.sofire.utility.c.f10402d != 0) {
                                this.mEndReason = com.baidu.sofire.utility.c.f10402d;
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
                    aVar.f10322b.putInt("rtqe", this.mPreferenceManager.f10321a.getInt("rtqe", 0) + 1);
                    aVar.f10322b.commit();
                    List<ApkInfo> a3 = this.loadedPluginDB.a();
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
                            String optString2 = optJSONObject4.optString("u");
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
                            boolean z3 = optJSONObject4.optInt(Config.OS) == 1;
                            Iterator<String> it = keys;
                            boolean z4 = optJSONObject4.optInt("d") == 1;
                            int optInt2 = optJSONObject4.optInt(r.f7715a);
                            if (z3) {
                                arrayList = arrayList8;
                                com.baidu.sofire.h.a aVar2 = this.mPreferenceManager;
                                arrayList2 = arrayList9;
                                arrayList3 = arrayList11;
                                list = a3;
                                if (optInt2 > aVar2.f10321a.getInt("opi", 0)) {
                                    aVar2.f10322b.putInt("opi", optInt2);
                                    aVar2.f10322b.commit();
                                }
                            } else {
                                list = a3;
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
                                a3 = list;
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
                                                                    apkInfo.priority = optJSONObject4.getInt(Config.PRINCIPAL_PART);
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
                                                                                if (c.f10236d != null && c.f10236d.contains(Integer.valueOf(apkInfo.key))) {
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
                                                                    a3 = list2;
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
                                apkInfo.priority = optJSONObject4.getInt(Config.PRINCIPAL_PART);
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
                                a3 = list22;
                                arrayList9 = arrayList6;
                                arrayList8 = arrayList5;
                                optJSONObject3 = jSONObject;
                                keys = it;
                                arrayList10 = arrayList4;
                                arrayList11 = arrayList7;
                            }
                        }
                    }
                    List<ApkInfo> list3 = a3;
                    ArrayList arrayList13 = arrayList10;
                    final ArrayList arrayList14 = arrayList11;
                    ArrayList arrayList15 = arrayList8;
                    ArrayList arrayList16 = arrayList9;
                    if (c.f10236d != null) {
                        c.f10236d.clear();
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
                    f a4 = f.a(this.context.getApplicationContext());
                    final List<Integer> q = this.mPreferenceManager.q();
                    List<Integer> p2 = this.mPreferenceManager.p();
                    for (int i4 = 0; i4 < p2.size(); i4++) {
                        if (!q.contains(p2.get(i4))) {
                            q.add(p2.get(i4));
                        }
                    }
                    ArrayList arrayList18 = new ArrayList();
                    arrayList18.addAll(arrayList15);
                    arrayList18.addAll(arrayList16);
                    Collections.sort(arrayList18, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.ac.U.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(ApkInfo apkInfo5, ApkInfo apkInfo6) {
                            int i5;
                            int i6;
                            if (apkInfo5.priority != -1 || apkInfo6.priority == -1) {
                                if ((apkInfo5.priority == -1 || apkInfo6.priority != -1) && (i5 = apkInfo5.priority) >= (i6 = apkInfo6.priority)) {
                                    if (i5 > i6) {
                                        return 1;
                                    }
                                    List list4 = q;
                                    int indexOf3 = (list4 == null || !list4.contains(Integer.valueOf(apkInfo5.key))) ? -1 : q.indexOf(Integer.valueOf(apkInfo5.key));
                                    List list5 = q;
                                    int indexOf4 = (list5 == null || !list5.contains(Integer.valueOf(apkInfo6.key))) ? -1 : q.indexOf(Integer.valueOf(apkInfo6.key));
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
                    });
                    for (int i5 = 0; i5 < arrayList18.size(); i5++) {
                        ApkInfo apkInfo5 = (ApkInfo) arrayList18.get(i5);
                        if (arrayList15.contains(apkInfo5)) {
                            if (a4.d(apkInfo5.packageName) == null) {
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
                    new Timer().schedule(new TimerTask() { // from class: com.baidu.sofire.ac.U.2
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            List<ApkInfo> list4 = arrayList14;
                            if (list4 != null) {
                                for (ApkInfo apkInfo6 : list4) {
                                    U.this.handlePluginUpgrade(apkInfo6);
                                }
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
                    if (com.baidu.sofire.utility.c.f10405g == null) {
                        com.baidu.sofire.utility.c.f10405g = new MyReceiver().a();
                    }
                    com.baidu.sofire.utility.c.a(this.context, com.baidu.sofire.utility.c.f10405g, intentFilter2);
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

    public U(Context context, int i2, boolean z, JSONObject jSONObject) {
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
