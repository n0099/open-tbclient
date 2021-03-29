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
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.MyService;
import com.baidu.sofire.a.a;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.core.f;
import com.baidu.sofire.core.i;
import com.baidu.sofire.e;
import com.baidu.sofire.g.b;
import com.baidu.sofire.g.d;
import com.baidu.sofire.g.l;
import com.baidu.sofire.g.n;
import com.baidu.sofire.g.p;
import com.baidu.sofire.jni.Asc;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class U extends Thread {
    public static final int FROM_DAILY_ALARM = 6;
    public static final int FROM_DEFAULT = 0;
    public static final int FROM_HANDLE_REMOVE = 4;
    public static final int FROM_INIT = 1;
    public static final int FROM_INIT_ALARM = 2;
    public static final int FROM_NET_CHANGE = 3;
    public static final int FROM_OUT_FLASH = 5;
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
    public static boolean sPidRegister = false;
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
    public Map<Integer, String> mStartKeyMap;
    public int mStartNetwork;
    public List<Integer> mUnloadPluginsList;
    public Map<Integer, UpgradeResult> mUpgradeResultMap;
    public JSONObject mWholeJson;
    public e preference;
    public File tmpDir;

    /* loaded from: classes2.dex */
    public class UpgradeResult {
        public int networkId;
        public int resultId;

        public UpgradeResult(int i, int i2) {
            this.networkId = i;
            this.resultId = i2;
        }
    }

    public U(Context context, int i, boolean z) {
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
        this.preference = new e(context);
        this.forHostAPP = c.a(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.mFrom = i;
        this.mOut = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePluginDownError(ApkInfo apkInfo, File file, int i, List<Integer> list) {
        Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
        if (map != null && !map.keySet().contains(Integer.valueOf(apkInfo.key))) {
            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i, 8));
        }
        int i2 = this.mFrom;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (list != null && list.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                sSetRetrmAlarm = true;
                b.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                sRetryDownoadHostCareApksTimesCount++;
            }
            if (!sMonitorNetworkWhenUpgradeNoNet) {
                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                MyReceiver myReceiver = d.f11754g;
                if (myReceiver == null) {
                    d.f11754g = new MyReceiver().a();
                } else {
                    myReceiver.a();
                }
                d.a(this.context, d.f11754g, intentFilter);
                sMonitorNetworkWhenUpgradeNoNet = true;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        e eVar = this.preference;
        long j = eVar.f11729a.getLong("pu_ap_fd", 0L);
        if (j == 0) {
            j = System.currentTimeMillis();
            eVar.d();
        }
        if (currentTimeMillis - j > 86400000) {
            HashMap hashMap = new HashMap();
            if (d.f(this.context)) {
                hashMap.put("0", Integer.valueOf(this.preference.e() + 1));
                hashMap.put("1", Integer.valueOf(this.preference.f()));
            } else {
                hashMap.put("0", Integer.valueOf(this.preference.e()));
                hashMap.put("1", Integer.valueOf(this.preference.f() + 1));
            }
            this.preference.a(0);
            this.preference.b(0);
            this.preference.d();
            d.a(this.context, "1003116", (Map<String, Object>) hashMap, false);
        } else if (d.f(this.context)) {
            e eVar2 = this.preference;
            eVar2.a(eVar2.e() + 1);
        } else {
            e eVar3 = this.preference;
            eVar3.b(eVar3.f() + 1);
        }
        com.baidu.sofire.b.a();
        file.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handlePluginDownload(ApkInfo apkInfo, File file, File file2, int i) {
        boolean a2;
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
            d.a();
        }
        if (!"com.baidu.input_huawei".equals(this.context.getPackageName()) || this.preference.y()) {
            if (p.a(this.context)) {
                a2 = new p(this.context).a(apkInfo.downloadURL, file);
            } else {
                a2 = new l(this.context).a(apkInfo.downloadURL, file);
            }
            com.baidu.sofire.b.a();
            if (a2) {
                if (file2.exists()) {
                    com.baidu.sofire.b.a();
                    file2.delete();
                }
                Asc asc = new Asc();
                byte[] bytes = apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes("utf-8");
                d.e(Constants.VIA_REPORT_TYPE_SET_AVATAR);
                if (com.baidu.sofire.g.a.a(file, file2, bytes) != 0) {
                    com.baidu.sofire.b.a();
                    if (file2.exists()) {
                        file2.delete();
                    }
                    d.e(Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                    if (asc.df(file.getAbsolutePath(), file2.getAbsolutePath(), bytes) != 0) {
                        d.e(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
                        com.baidu.sofire.b.a();
                        if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i, 7));
                        }
                        a2 = false;
                    }
                }
            } else if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i, 4));
            }
            new StringBuilder().append(a2);
            com.baidu.sofire.b.a();
            String a3 = n.a(file2);
            StringBuilder sb = new StringBuilder("ds=");
            sb.append(a2);
            sb.append(", fm=");
            sb.append(apkInfo.apkMD5);
            sb.append(", am=");
            sb.append(a3);
            com.baidu.sofire.b.a();
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

    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ff A[Catch: all -> 0x0239, TryCatch #1 {all -> 0x0239, blocks: (B:3:0x0008, B:5:0x002d, B:7:0x0037, B:9:0x003b, B:11:0x004d, B:13:0x005e, B:15:0x0066, B:16:0x006b, B:18:0x00c1, B:20:0x00cd, B:24:0x00ff, B:26:0x0103, B:38:0x0151, B:74:0x0235, B:41:0x0170, B:43:0x017d, B:45:0x0187, B:48:0x018e, B:50:0x0196, B:52:0x01a0, B:53:0x01ae, B:55:0x01b6, B:58:0x01c1, B:61:0x01c9, B:63:0x01d5, B:65:0x01e2, B:66:0x01f3, B:70:0x0215, B:72:0x022a, B:67:0x0205, B:27:0x0116, B:29:0x012a, B:31:0x013a, B:33:0x0147, B:21:0x00e8), top: B:107:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0151 A[Catch: all -> 0x0239, TryCatch #1 {all -> 0x0239, blocks: (B:3:0x0008, B:5:0x002d, B:7:0x0037, B:9:0x003b, B:11:0x004d, B:13:0x005e, B:15:0x0066, B:16:0x006b, B:18:0x00c1, B:20:0x00cd, B:24:0x00ff, B:26:0x0103, B:38:0x0151, B:74:0x0235, B:41:0x0170, B:43:0x017d, B:45:0x0187, B:48:0x018e, B:50:0x0196, B:52:0x01a0, B:53:0x01ae, B:55:0x01b6, B:58:0x01c1, B:61:0x01c9, B:63:0x01d5, B:65:0x01e2, B:66:0x01f3, B:70:0x0215, B:72:0x022a, B:67:0x0205, B:27:0x0116, B:29:0x012a, B:31:0x013a, B:33:0x0147, B:21:0x00e8), top: B:107:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b6 A[Catch: all -> 0x0239, TryCatch #1 {all -> 0x0239, blocks: (B:3:0x0008, B:5:0x002d, B:7:0x0037, B:9:0x003b, B:11:0x004d, B:13:0x005e, B:15:0x0066, B:16:0x006b, B:18:0x00c1, B:20:0x00cd, B:24:0x00ff, B:26:0x0103, B:38:0x0151, B:74:0x0235, B:41:0x0170, B:43:0x017d, B:45:0x0187, B:48:0x018e, B:50:0x0196, B:52:0x01a0, B:53:0x01ae, B:55:0x01b6, B:58:0x01c1, B:61:0x01c9, B:63:0x01d5, B:65:0x01e2, B:66:0x01f3, B:70:0x0215, B:72:0x022a, B:67:0x0205, B:27:0x0116, B:29:0x012a, B:31:0x013a, B:33:0x0147, B:21:0x00e8), top: B:107:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d5 A[Catch: all -> 0x0239, TryCatch #1 {all -> 0x0239, blocks: (B:3:0x0008, B:5:0x002d, B:7:0x0037, B:9:0x003b, B:11:0x004d, B:13:0x005e, B:15:0x0066, B:16:0x006b, B:18:0x00c1, B:20:0x00cd, B:24:0x00ff, B:26:0x0103, B:38:0x0151, B:74:0x0235, B:41:0x0170, B:43:0x017d, B:45:0x0187, B:48:0x018e, B:50:0x0196, B:52:0x01a0, B:53:0x01ae, B:55:0x01b6, B:58:0x01c1, B:61:0x01c9, B:63:0x01d5, B:65:0x01e2, B:66:0x01f3, B:70:0x0215, B:72:0x022a, B:67:0x0205, B:27:0x0116, B:29:0x012a, B:31:0x013a, B:33:0x0147, B:21:0x00e8), top: B:107:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0205 A[Catch: all -> 0x0239, TryCatch #1 {all -> 0x0239, blocks: (B:3:0x0008, B:5:0x002d, B:7:0x0037, B:9:0x003b, B:11:0x004d, B:13:0x005e, B:15:0x0066, B:16:0x006b, B:18:0x00c1, B:20:0x00cd, B:24:0x00ff, B:26:0x0103, B:38:0x0151, B:74:0x0235, B:41:0x0170, B:43:0x017d, B:45:0x0187, B:48:0x018e, B:50:0x0196, B:52:0x01a0, B:53:0x01ae, B:55:0x01b6, B:58:0x01c1, B:61:0x01c9, B:63:0x01d5, B:65:0x01e2, B:66:0x01f3, B:70:0x0215, B:72:0x022a, B:67:0x0205, B:27:0x0116, B:29:0x012a, B:31:0x013a, B:33:0x0147, B:21:0x00e8), top: B:107:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0215 A[Catch: all -> 0x0239, TryCatch #1 {all -> 0x0239, blocks: (B:3:0x0008, B:5:0x002d, B:7:0x0037, B:9:0x003b, B:11:0x004d, B:13:0x005e, B:15:0x0066, B:16:0x006b, B:18:0x00c1, B:20:0x00cd, B:24:0x00ff, B:26:0x0103, B:38:0x0151, B:74:0x0235, B:41:0x0170, B:43:0x017d, B:45:0x0187, B:48:0x018e, B:50:0x0196, B:52:0x01a0, B:53:0x01ae, B:55:0x01b6, B:58:0x01c1, B:61:0x01c9, B:63:0x01d5, B:65:0x01e2, B:66:0x01f3, B:70:0x0215, B:72:0x022a, B:67:0x0205, B:27:0x0116, B:29:0x012a, B:31:0x013a, B:33:0x0147, B:21:0x00e8), top: B:107:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0235 A[Catch: all -> 0x0239, TRY_LEAVE, TryCatch #1 {all -> 0x0239, blocks: (B:3:0x0008, B:5:0x002d, B:7:0x0037, B:9:0x003b, B:11:0x004d, B:13:0x005e, B:15:0x0066, B:16:0x006b, B:18:0x00c1, B:20:0x00cd, B:24:0x00ff, B:26:0x0103, B:38:0x0151, B:74:0x0235, B:41:0x0170, B:43:0x017d, B:45:0x0187, B:48:0x018e, B:50:0x0196, B:52:0x01a0, B:53:0x01ae, B:55:0x01b6, B:58:0x01c1, B:61:0x01c9, B:63:0x01d5, B:65:0x01e2, B:66:0x01f3, B:70:0x0215, B:72:0x022a, B:67:0x0205, B:27:0x0116, B:29:0x012a, B:31:0x013a, B:33:0x0147, B:21:0x00e8), top: B:107:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handlePluginUpgrade(final ApkInfo apkInfo) {
        boolean z;
        boolean z2;
        File file;
        boolean z3;
        boolean z4;
        boolean z5;
        File file2;
        try {
            final int l = d.l(this.context);
            new StringBuilder("a=").append(apkInfo);
            com.baidu.sofire.b.a();
            final List<Integer> q = this.preference.q();
            if (!q.contains(Integer.valueOf(apkInfo.key)) && !d.b(this.context, apkInfo.network)) {
                if (this.mUpgradeResultMap == null || this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    return;
                }
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(l, 3));
                return;
            }
            if (!this.tmpDir.exists()) {
                this.tmpDir.mkdir();
            }
            ApkInfo a2 = this.loadedPluginDB.a(apkInfo.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT);
            final File file3 = new File(this.tmpDir, apkInfo.key + "-" + apkInfo.versionName + ".tmp");
            final File file4 = new File(this.tmpDir, apkInfo.key + "-" + apkInfo.versionName + ".zip");
            if (file4.exists()) {
                if (apkInfo.apkMD5.equals(n.a(file4))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(apkInfo.versionName);
                    sb.append(" exists! ");
                    sb.append(apkInfo.key);
                    com.baidu.sofire.b.a();
                    z = false;
                    z2 = true;
                    if (z) {
                        file = file4;
                    } else if (apkInfo.isNextLoad) {
                        file = file4;
                        new Thread() { // from class: com.baidu.sofire.ac.U.2
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                try {
                                    boolean handlePluginDownload = U.this.handlePluginDownload(apkInfo, file3, file4, l);
                                    new StringBuilder().append(handlePluginDownload);
                                    com.baidu.sofire.b.a();
                                    if (!handlePluginDownload) {
                                        U.this.handlePluginDownError(apkInfo, file4, l, q);
                                        return;
                                    }
                                    apkInfo.pkgPath = file4.getAbsolutePath();
                                    ApkInfo apkInfo2 = new ApkInfo(apkInfo);
                                    apkInfo2.key += ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT;
                                    if (!TextUtils.isEmpty(apkInfo2.packageName)) {
                                        apkInfo2.packageName = new StringBuilder(apkInfo2.packageName).reverse().toString();
                                    }
                                    com.baidu.sofire.b.a();
                                    U.this.loadedPluginDB.a(apkInfo2);
                                } catch (Throwable unused) {
                                    d.a();
                                }
                            }
                        }.start();
                    } else {
                        file = file4;
                        boolean handlePluginDownload = handlePluginDownload(apkInfo, file3, file, l);
                        new StringBuilder().append(handlePluginDownload);
                        com.baidu.sofire.b.a();
                        z3 = !handlePluginDownload;
                        if (a2 != null) {
                            this.loadedPluginDB.h(a2.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT);
                            if (!TextUtils.isEmpty(a2.pkgPath)) {
                                File file5 = new File(a2.pkgPath);
                                if (file5.exists()) {
                                    file5.delete();
                                }
                            }
                        }
                        z2 = handlePluginDownload;
                        if (z2) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(apkInfo.versionName);
                            sb2.append(" ");
                            sb2.append(apkInfo.key);
                            com.baidu.sofire.b.a();
                            pluginUpdate(file, apkInfo, l);
                        } else {
                            if (a2 != null) {
                                com.baidu.sofire.b.a();
                                ApkInfo a3 = this.loadedPluginDB.a(apkInfo.key);
                                if (a3 != null) {
                                    if (d.b(a2.versionName, a3.versionName)) {
                                        com.baidu.sofire.b.a();
                                    } else {
                                        z5 = false;
                                        if (!TextUtils.isEmpty(a2.versionName) && a2.versionName.equals(apkInfo.versionName)) {
                                            com.baidu.sofire.b.a();
                                            this.loadedPluginDB.a(a2.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, a2.versionName);
                                            z5 = false;
                                        }
                                        file2 = TextUtils.isEmpty(a2.pkgPath) ? new File(a2.pkgPath) : null;
                                        if (file2 != null && file2.exists() && z5) {
                                            if (!a2.apkMD5.equals(n.a(file2))) {
                                                a2.key -= ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT;
                                                if (!TextUtils.isEmpty(a2.packageName)) {
                                                    a2.packageName = new StringBuilder(a2.packageName).reverse().toString();
                                                }
                                                new StringBuilder().append(a2.versionName);
                                                com.baidu.sofire.b.a();
                                                pluginUpdate(file2, a2, l);
                                                z4 = true;
                                                if (!z4) {
                                                    com.baidu.sofire.b.a();
                                                    if (f.a(this.context.getApplicationContext()).d(apkInfo.packageName) == null) {
                                                        this.forHostAPP.a(apkInfo.key, apkInfo.versionName, null);
                                                    }
                                                }
                                            } else {
                                                this.loadedPluginDB.a(a2.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, a2.versionName);
                                                file2.delete();
                                            }
                                        }
                                    }
                                }
                                z5 = true;
                                if (!TextUtils.isEmpty(a2.versionName)) {
                                    com.baidu.sofire.b.a();
                                    this.loadedPluginDB.a(a2.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, a2.versionName);
                                    z5 = false;
                                }
                                if (TextUtils.isEmpty(a2.pkgPath)) {
                                }
                                if (file2 != null) {
                                    if (!a2.apkMD5.equals(n.a(file2))) {
                                    }
                                }
                            }
                            z4 = false;
                            if (!z4) {
                            }
                        }
                        if (z3) {
                            handlePluginDownError(apkInfo, file, l, q);
                            return;
                        }
                        return;
                    }
                    z3 = false;
                    if (z2) {
                    }
                    if (z3) {
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(apkInfo.versionName);
                    sb3.append(" exists! but mdf ");
                    com.baidu.sofire.b.a();
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
            d.a();
            try {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(d.l(this.context), 2));
                }
            } catch (Throwable unused2) {
                d.a();
            }
            try {
                List<Integer> q2 = this.preference.q();
                if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                    if (q2.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                        sSetRetrmAlarm = true;
                        b.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                        sRetryDownoadHostCareApksTimesCount++;
                    }
                    if (sMonitorNetworkWhenUpgradeNoNet) {
                        return;
                    }
                    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    if (d.f11754g == null) {
                        d.f11754g = new MyReceiver().a();
                    } else {
                        d.f11754g.a();
                    }
                    d.a(this.context, d.f11754g, intentFilter);
                    sMonitorNetworkWhenUpgradeNoNet = true;
                }
            } catch (Throwable unused3) {
                d.a();
            }
        }
    }

    private void handleThreadEnd(String str) {
        try {
            this.preference.g(this.preference.u() + 1);
            if (this.mEndReason != 0) {
                this.preference.a(1, this.mEndReason, this.preference.a(1, this.mEndReason) + 1);
            }
        } catch (Throwable unused) {
            d.a();
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
            hashMap.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, b2.keySet());
            hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, b2.values());
            hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Integer.valueOf(this.mEndReason));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, str.replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
            }
            hashMap.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, Integer.valueOf(this.mStartNetwork));
            hashMap.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Integer.valueOf(d.l(this.context)));
            d.a(this.context, "1003129", (Map<String, Object>) hashMap, false);
        } catch (Throwable unused2) {
            d.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6 A[Catch: all -> 0x00ff, TryCatch #2 {all -> 0x00ff, blocks: (B:26:0x00ce, B:28:0x00e6, B:29:0x00f6), top: B:34:0x00ce }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleThreadStart() {
        try {
            try {
                long j = this.preference.f11729a.getLong("slruct", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i > 0 && currentTimeMillis - j > 86400000) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("1", Integer.valueOf(this.preference.t()));
                    this.preference.f(0);
                    JSONObject jSONObject = new JSONObject();
                    for (int i2 = 1; i2 <= 6; i2++) {
                        jSONObject.put(String.valueOf(i2), this.preference.a(0, i2));
                        this.preference.a(0, i2, 0);
                    }
                    hashMap.put("2", jSONObject);
                    hashMap.put("3", Integer.valueOf(this.preference.u()));
                    this.preference.g(0);
                    JSONObject jSONObject2 = new JSONObject();
                    for (int i3 = 1; i3 <= 11; i3++) {
                        jSONObject2.put(String.valueOf(i3), this.preference.a(1, i3));
                        this.preference.a(1, i3, 0);
                    }
                    hashMap.put("4", jSONObject2);
                    d.a(this.context, "1003128", (Map<String, Object>) hashMap, false);
                    this.preference.a(currentTimeMillis);
                } else if (i == 0) {
                    this.preference.a(currentTimeMillis);
                }
            } catch (Throwable unused) {
                d.a();
                d.a();
                this.mStartKeyMap = this.loadedPluginDB.b();
                this.preference.f(this.preference.t() + 1);
                if (this.mFrom != 0) {
                }
                this.mStartNetwork = d.l(this.context);
            }
        } catch (Throwable unused2) {
            this.preference.f(0);
            this.preference.g(0);
            for (int i4 = 1; i4 <= 6; i4++) {
                this.preference.a(0, i4, 0);
            }
            for (int i5 = 1; i5 <= 11; i5++) {
                this.preference.a(1, i5, 0);
            }
            d.a();
            this.mStartKeyMap = this.loadedPluginDB.b();
            this.preference.f(this.preference.t() + 1);
            if (this.mFrom != 0) {
            }
            this.mStartNetwork = d.l(this.context);
        }
        try {
            this.mStartKeyMap = this.loadedPluginDB.b();
            this.preference.f(this.preference.t() + 1);
            if (this.mFrom != 0) {
                this.preference.a(0, this.mFrom, this.preference.a(0, this.mFrom) + 1);
            }
            this.mStartNetwork = d.l(this.context);
        } catch (Throwable unused3) {
            d.a();
        }
    }

    private void pluginUpdate(File file, ApkInfo apkInfo, int i) {
        d.a(file.getAbsolutePath(), true);
        if (this.preference.c()) {
            File file2 = new File(this.context.getFilesDir(), ".b");
            if (!file2.exists()) {
                file2.mkdir();
            }
            File file3 = new File(file2, apkInfo.key + "-" + apkInfo.versionName);
            d.a(file, file3);
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
        StringBuilder sb2 = new StringBuilder();
        sb2.append(apkInfo.packageName);
        sb2.append(" s=");
        sb2.append(a3);
        com.baidu.sofire.b.a();
        this.loadedPluginDB.a(apkInfo.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, apkInfo.versionName);
        if (!a3) {
            Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
            if (map == null || map.keySet().contains(Integer.valueOf(apkInfo.key))) {
                return;
            }
            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i, 5));
            return;
        }
        int g2 = this.loadedPluginDB.g(apkInfo.key);
        StringBuilder sb3 = new StringBuilder("new plugin now loadStatus :");
        sb3.append(apkInfo.key);
        sb3.append(" ");
        sb3.append(g2);
        com.baidu.sofire.b.a();
        if (g2 < 3 && g2 != -1) {
            this.loadedPluginDB.b(apkInfo.key, g2 + 1);
        }
        Map<Integer, UpgradeResult> map2 = this.mUpgradeResultMap;
        if (map2 != null) {
            map2.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i, 1));
        }
    }

    public void handleWork(Context context, Intent intent) {
        this.context = context;
        this.loadedPluginDB = a.a(context);
        this.preference = new e(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.forHostAPP = c.a(context);
        this.mFrom = intent.getIntExtra("from", 0);
        com.baidu.sofire.b.a();
        start();
    }

    /* JADX WARN: Removed duplicated region for block: B:217:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x050a A[Catch: all -> 0x089c, TryCatch #13 {, blocks: (B:17:0x0018, B:19:0x0028, B:21:0x002c, B:23:0x0030, B:25:0x0034, B:27:0x003f, B:29:0x0043, B:30:0x0048, B:41:0x005a, B:43:0x0062, B:44:0x0068, B:58:0x0136, B:60:0x013f, B:63:0x014e, B:65:0x0152, B:66:0x0154, B:68:0x0162, B:70:0x0170, B:74:0x017c, B:76:0x0186, B:78:0x018a, B:83:0x019d, B:85:0x01a5, B:86:0x01ad, B:88:0x01b1, B:90:0x01b5, B:92:0x01b9, B:94:0x01bd, B:99:0x01db, B:101:0x01e6, B:103:0x01f7, B:105:0x0204, B:107:0x0208, B:108:0x020d, B:109:0x0210, B:110:0x0217, B:102:0x01f2, B:96:0x01c1, B:98:0x01cd, B:111:0x0218, B:113:0x022a, B:127:0x02b2, B:128:0x02b4, B:130:0x02f9, B:132:0x02fd, B:133:0x0301, B:134:0x0308, B:135:0x0309, B:137:0x030d, B:138:0x0311, B:140:0x0317, B:142:0x0332, B:143:0x033b, B:145:0x0350, B:146:0x0354, B:148:0x0367, B:149:0x036e, B:151:0x0374, B:153:0x037a, B:155:0x0381, B:156:0x0385, B:160:0x0391, B:164:0x039f, B:166:0x03a7, B:168:0x03bc, B:172:0x03d5, B:214:0x04d4, B:215:0x04d8, B:219:0x04ec, B:224:0x04fa, B:228:0x0506, B:230:0x050a, B:231:0x050c, B:233:0x0514, B:234:0x0524, B:236:0x052c, B:240:0x0539, B:242:0x0559, B:244:0x0561, B:246:0x056b, B:247:0x0579, B:249:0x057f, B:250:0x058e, B:253:0x0599, B:255:0x05c8, B:256:0x05d9, B:258:0x05df, B:260:0x05e4, B:262:0x05f4, B:264:0x05f8, B:266:0x05fc, B:269:0x060c, B:271:0x0612, B:272:0x061b, B:275:0x0627, B:276:0x0646, B:278:0x064f, B:285:0x067a, B:281:0x0660, B:283:0x0668, B:284:0x0675, B:286:0x067e, B:288:0x0689, B:290:0x069e, B:292:0x06a6, B:293:0x06ab, B:294:0x06ba, B:296:0x06c0, B:298:0x06d0, B:300:0x06d4, B:301:0x06df, B:303:0x06e9, B:304:0x0710, B:306:0x0716, B:308:0x0720, B:309:0x0727, B:310:0x072a, B:311:0x073e, B:313:0x0744, B:315:0x0750, B:317:0x0758, B:319:0x0763, B:321:0x0769, B:324:0x0773, B:326:0x0786, B:327:0x0789, B:329:0x07b3, B:330:0x07b6, B:336:0x0812, B:331:0x07be, B:333:0x07d1, B:335:0x07f4, B:342:0x0830, B:337:0x081d, B:339:0x0823, B:341:0x082d, B:343:0x0834, B:358:0x0852, B:360:0x0857, B:362:0x085b, B:368:0x0883, B:370:0x0887, B:372:0x088c, B:373:0x0893, B:374:0x0894, B:375:0x089b, B:364:0x0860, B:366:0x0871, B:367:0x087c, B:62:0x0143, B:116:0x024f, B:117:0x025e, B:119:0x026e, B:124:0x0297, B:120:0x0273, B:123:0x027f, B:45:0x006a, B:51:0x0126, B:46:0x011a, B:220:0x04ee, B:80:0x018e), top: B:432:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0514 A[Catch: all -> 0x089c, TryCatch #13 {, blocks: (B:17:0x0018, B:19:0x0028, B:21:0x002c, B:23:0x0030, B:25:0x0034, B:27:0x003f, B:29:0x0043, B:30:0x0048, B:41:0x005a, B:43:0x0062, B:44:0x0068, B:58:0x0136, B:60:0x013f, B:63:0x014e, B:65:0x0152, B:66:0x0154, B:68:0x0162, B:70:0x0170, B:74:0x017c, B:76:0x0186, B:78:0x018a, B:83:0x019d, B:85:0x01a5, B:86:0x01ad, B:88:0x01b1, B:90:0x01b5, B:92:0x01b9, B:94:0x01bd, B:99:0x01db, B:101:0x01e6, B:103:0x01f7, B:105:0x0204, B:107:0x0208, B:108:0x020d, B:109:0x0210, B:110:0x0217, B:102:0x01f2, B:96:0x01c1, B:98:0x01cd, B:111:0x0218, B:113:0x022a, B:127:0x02b2, B:128:0x02b4, B:130:0x02f9, B:132:0x02fd, B:133:0x0301, B:134:0x0308, B:135:0x0309, B:137:0x030d, B:138:0x0311, B:140:0x0317, B:142:0x0332, B:143:0x033b, B:145:0x0350, B:146:0x0354, B:148:0x0367, B:149:0x036e, B:151:0x0374, B:153:0x037a, B:155:0x0381, B:156:0x0385, B:160:0x0391, B:164:0x039f, B:166:0x03a7, B:168:0x03bc, B:172:0x03d5, B:214:0x04d4, B:215:0x04d8, B:219:0x04ec, B:224:0x04fa, B:228:0x0506, B:230:0x050a, B:231:0x050c, B:233:0x0514, B:234:0x0524, B:236:0x052c, B:240:0x0539, B:242:0x0559, B:244:0x0561, B:246:0x056b, B:247:0x0579, B:249:0x057f, B:250:0x058e, B:253:0x0599, B:255:0x05c8, B:256:0x05d9, B:258:0x05df, B:260:0x05e4, B:262:0x05f4, B:264:0x05f8, B:266:0x05fc, B:269:0x060c, B:271:0x0612, B:272:0x061b, B:275:0x0627, B:276:0x0646, B:278:0x064f, B:285:0x067a, B:281:0x0660, B:283:0x0668, B:284:0x0675, B:286:0x067e, B:288:0x0689, B:290:0x069e, B:292:0x06a6, B:293:0x06ab, B:294:0x06ba, B:296:0x06c0, B:298:0x06d0, B:300:0x06d4, B:301:0x06df, B:303:0x06e9, B:304:0x0710, B:306:0x0716, B:308:0x0720, B:309:0x0727, B:310:0x072a, B:311:0x073e, B:313:0x0744, B:315:0x0750, B:317:0x0758, B:319:0x0763, B:321:0x0769, B:324:0x0773, B:326:0x0786, B:327:0x0789, B:329:0x07b3, B:330:0x07b6, B:336:0x0812, B:331:0x07be, B:333:0x07d1, B:335:0x07f4, B:342:0x0830, B:337:0x081d, B:339:0x0823, B:341:0x082d, B:343:0x0834, B:358:0x0852, B:360:0x0857, B:362:0x085b, B:368:0x0883, B:370:0x0887, B:372:0x088c, B:373:0x0893, B:374:0x0894, B:375:0x089b, B:364:0x0860, B:366:0x0871, B:367:0x087c, B:62:0x0143, B:116:0x024f, B:117:0x025e, B:119:0x026e, B:124:0x0297, B:120:0x0273, B:123:0x027f, B:45:0x006a, B:51:0x0126, B:46:0x011a, B:220:0x04ee, B:80:0x018e), top: B:432:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x052c A[Catch: all -> 0x089c, TryCatch #13 {, blocks: (B:17:0x0018, B:19:0x0028, B:21:0x002c, B:23:0x0030, B:25:0x0034, B:27:0x003f, B:29:0x0043, B:30:0x0048, B:41:0x005a, B:43:0x0062, B:44:0x0068, B:58:0x0136, B:60:0x013f, B:63:0x014e, B:65:0x0152, B:66:0x0154, B:68:0x0162, B:70:0x0170, B:74:0x017c, B:76:0x0186, B:78:0x018a, B:83:0x019d, B:85:0x01a5, B:86:0x01ad, B:88:0x01b1, B:90:0x01b5, B:92:0x01b9, B:94:0x01bd, B:99:0x01db, B:101:0x01e6, B:103:0x01f7, B:105:0x0204, B:107:0x0208, B:108:0x020d, B:109:0x0210, B:110:0x0217, B:102:0x01f2, B:96:0x01c1, B:98:0x01cd, B:111:0x0218, B:113:0x022a, B:127:0x02b2, B:128:0x02b4, B:130:0x02f9, B:132:0x02fd, B:133:0x0301, B:134:0x0308, B:135:0x0309, B:137:0x030d, B:138:0x0311, B:140:0x0317, B:142:0x0332, B:143:0x033b, B:145:0x0350, B:146:0x0354, B:148:0x0367, B:149:0x036e, B:151:0x0374, B:153:0x037a, B:155:0x0381, B:156:0x0385, B:160:0x0391, B:164:0x039f, B:166:0x03a7, B:168:0x03bc, B:172:0x03d5, B:214:0x04d4, B:215:0x04d8, B:219:0x04ec, B:224:0x04fa, B:228:0x0506, B:230:0x050a, B:231:0x050c, B:233:0x0514, B:234:0x0524, B:236:0x052c, B:240:0x0539, B:242:0x0559, B:244:0x0561, B:246:0x056b, B:247:0x0579, B:249:0x057f, B:250:0x058e, B:253:0x0599, B:255:0x05c8, B:256:0x05d9, B:258:0x05df, B:260:0x05e4, B:262:0x05f4, B:264:0x05f8, B:266:0x05fc, B:269:0x060c, B:271:0x0612, B:272:0x061b, B:275:0x0627, B:276:0x0646, B:278:0x064f, B:285:0x067a, B:281:0x0660, B:283:0x0668, B:284:0x0675, B:286:0x067e, B:288:0x0689, B:290:0x069e, B:292:0x06a6, B:293:0x06ab, B:294:0x06ba, B:296:0x06c0, B:298:0x06d0, B:300:0x06d4, B:301:0x06df, B:303:0x06e9, B:304:0x0710, B:306:0x0716, B:308:0x0720, B:309:0x0727, B:310:0x072a, B:311:0x073e, B:313:0x0744, B:315:0x0750, B:317:0x0758, B:319:0x0763, B:321:0x0769, B:324:0x0773, B:326:0x0786, B:327:0x0789, B:329:0x07b3, B:330:0x07b6, B:336:0x0812, B:331:0x07be, B:333:0x07d1, B:335:0x07f4, B:342:0x0830, B:337:0x081d, B:339:0x0823, B:341:0x082d, B:343:0x0834, B:358:0x0852, B:360:0x0857, B:362:0x085b, B:368:0x0883, B:370:0x0887, B:372:0x088c, B:373:0x0893, B:374:0x0894, B:375:0x089b, B:364:0x0860, B:366:0x0871, B:367:0x087c, B:62:0x0143, B:116:0x024f, B:117:0x025e, B:119:0x026e, B:124:0x0297, B:120:0x0273, B:123:0x027f, B:45:0x006a, B:51:0x0126, B:46:0x011a, B:220:0x04ee, B:80:0x018e), top: B:432:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x05c8 A[Catch: all -> 0x089c, TryCatch #13 {, blocks: (B:17:0x0018, B:19:0x0028, B:21:0x002c, B:23:0x0030, B:25:0x0034, B:27:0x003f, B:29:0x0043, B:30:0x0048, B:41:0x005a, B:43:0x0062, B:44:0x0068, B:58:0x0136, B:60:0x013f, B:63:0x014e, B:65:0x0152, B:66:0x0154, B:68:0x0162, B:70:0x0170, B:74:0x017c, B:76:0x0186, B:78:0x018a, B:83:0x019d, B:85:0x01a5, B:86:0x01ad, B:88:0x01b1, B:90:0x01b5, B:92:0x01b9, B:94:0x01bd, B:99:0x01db, B:101:0x01e6, B:103:0x01f7, B:105:0x0204, B:107:0x0208, B:108:0x020d, B:109:0x0210, B:110:0x0217, B:102:0x01f2, B:96:0x01c1, B:98:0x01cd, B:111:0x0218, B:113:0x022a, B:127:0x02b2, B:128:0x02b4, B:130:0x02f9, B:132:0x02fd, B:133:0x0301, B:134:0x0308, B:135:0x0309, B:137:0x030d, B:138:0x0311, B:140:0x0317, B:142:0x0332, B:143:0x033b, B:145:0x0350, B:146:0x0354, B:148:0x0367, B:149:0x036e, B:151:0x0374, B:153:0x037a, B:155:0x0381, B:156:0x0385, B:160:0x0391, B:164:0x039f, B:166:0x03a7, B:168:0x03bc, B:172:0x03d5, B:214:0x04d4, B:215:0x04d8, B:219:0x04ec, B:224:0x04fa, B:228:0x0506, B:230:0x050a, B:231:0x050c, B:233:0x0514, B:234:0x0524, B:236:0x052c, B:240:0x0539, B:242:0x0559, B:244:0x0561, B:246:0x056b, B:247:0x0579, B:249:0x057f, B:250:0x058e, B:253:0x0599, B:255:0x05c8, B:256:0x05d9, B:258:0x05df, B:260:0x05e4, B:262:0x05f4, B:264:0x05f8, B:266:0x05fc, B:269:0x060c, B:271:0x0612, B:272:0x061b, B:275:0x0627, B:276:0x0646, B:278:0x064f, B:285:0x067a, B:281:0x0660, B:283:0x0668, B:284:0x0675, B:286:0x067e, B:288:0x0689, B:290:0x069e, B:292:0x06a6, B:293:0x06ab, B:294:0x06ba, B:296:0x06c0, B:298:0x06d0, B:300:0x06d4, B:301:0x06df, B:303:0x06e9, B:304:0x0710, B:306:0x0716, B:308:0x0720, B:309:0x0727, B:310:0x072a, B:311:0x073e, B:313:0x0744, B:315:0x0750, B:317:0x0758, B:319:0x0763, B:321:0x0769, B:324:0x0773, B:326:0x0786, B:327:0x0789, B:329:0x07b3, B:330:0x07b6, B:336:0x0812, B:331:0x07be, B:333:0x07d1, B:335:0x07f4, B:342:0x0830, B:337:0x081d, B:339:0x0823, B:341:0x082d, B:343:0x0834, B:358:0x0852, B:360:0x0857, B:362:0x085b, B:368:0x0883, B:370:0x0887, B:372:0x088c, B:373:0x0893, B:374:0x0894, B:375:0x089b, B:364:0x0860, B:366:0x0871, B:367:0x087c, B:62:0x0143, B:116:0x024f, B:117:0x025e, B:119:0x026e, B:124:0x0297, B:120:0x0273, B:123:0x027f, B:45:0x006a, B:51:0x0126, B:46:0x011a, B:220:0x04ee, B:80:0x018e), top: B:432:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x05df A[Catch: all -> 0x089c, TryCatch #13 {, blocks: (B:17:0x0018, B:19:0x0028, B:21:0x002c, B:23:0x0030, B:25:0x0034, B:27:0x003f, B:29:0x0043, B:30:0x0048, B:41:0x005a, B:43:0x0062, B:44:0x0068, B:58:0x0136, B:60:0x013f, B:63:0x014e, B:65:0x0152, B:66:0x0154, B:68:0x0162, B:70:0x0170, B:74:0x017c, B:76:0x0186, B:78:0x018a, B:83:0x019d, B:85:0x01a5, B:86:0x01ad, B:88:0x01b1, B:90:0x01b5, B:92:0x01b9, B:94:0x01bd, B:99:0x01db, B:101:0x01e6, B:103:0x01f7, B:105:0x0204, B:107:0x0208, B:108:0x020d, B:109:0x0210, B:110:0x0217, B:102:0x01f2, B:96:0x01c1, B:98:0x01cd, B:111:0x0218, B:113:0x022a, B:127:0x02b2, B:128:0x02b4, B:130:0x02f9, B:132:0x02fd, B:133:0x0301, B:134:0x0308, B:135:0x0309, B:137:0x030d, B:138:0x0311, B:140:0x0317, B:142:0x0332, B:143:0x033b, B:145:0x0350, B:146:0x0354, B:148:0x0367, B:149:0x036e, B:151:0x0374, B:153:0x037a, B:155:0x0381, B:156:0x0385, B:160:0x0391, B:164:0x039f, B:166:0x03a7, B:168:0x03bc, B:172:0x03d5, B:214:0x04d4, B:215:0x04d8, B:219:0x04ec, B:224:0x04fa, B:228:0x0506, B:230:0x050a, B:231:0x050c, B:233:0x0514, B:234:0x0524, B:236:0x052c, B:240:0x0539, B:242:0x0559, B:244:0x0561, B:246:0x056b, B:247:0x0579, B:249:0x057f, B:250:0x058e, B:253:0x0599, B:255:0x05c8, B:256:0x05d9, B:258:0x05df, B:260:0x05e4, B:262:0x05f4, B:264:0x05f8, B:266:0x05fc, B:269:0x060c, B:271:0x0612, B:272:0x061b, B:275:0x0627, B:276:0x0646, B:278:0x064f, B:285:0x067a, B:281:0x0660, B:283:0x0668, B:284:0x0675, B:286:0x067e, B:288:0x0689, B:290:0x069e, B:292:0x06a6, B:293:0x06ab, B:294:0x06ba, B:296:0x06c0, B:298:0x06d0, B:300:0x06d4, B:301:0x06df, B:303:0x06e9, B:304:0x0710, B:306:0x0716, B:308:0x0720, B:309:0x0727, B:310:0x072a, B:311:0x073e, B:313:0x0744, B:315:0x0750, B:317:0x0758, B:319:0x0763, B:321:0x0769, B:324:0x0773, B:326:0x0786, B:327:0x0789, B:329:0x07b3, B:330:0x07b6, B:336:0x0812, B:331:0x07be, B:333:0x07d1, B:335:0x07f4, B:342:0x0830, B:337:0x081d, B:339:0x0823, B:341:0x082d, B:343:0x0834, B:358:0x0852, B:360:0x0857, B:362:0x085b, B:368:0x0883, B:370:0x0887, B:372:0x088c, B:373:0x0893, B:374:0x0894, B:375:0x089b, B:364:0x0860, B:366:0x0871, B:367:0x087c, B:62:0x0143, B:116:0x024f, B:117:0x025e, B:119:0x026e, B:124:0x0297, B:120:0x0273, B:123:0x027f, B:45:0x006a, B:51:0x0126, B:46:0x011a, B:220:0x04ee, B:80:0x018e), top: B:432:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x05e4 A[Catch: all -> 0x089c, TryCatch #13 {, blocks: (B:17:0x0018, B:19:0x0028, B:21:0x002c, B:23:0x0030, B:25:0x0034, B:27:0x003f, B:29:0x0043, B:30:0x0048, B:41:0x005a, B:43:0x0062, B:44:0x0068, B:58:0x0136, B:60:0x013f, B:63:0x014e, B:65:0x0152, B:66:0x0154, B:68:0x0162, B:70:0x0170, B:74:0x017c, B:76:0x0186, B:78:0x018a, B:83:0x019d, B:85:0x01a5, B:86:0x01ad, B:88:0x01b1, B:90:0x01b5, B:92:0x01b9, B:94:0x01bd, B:99:0x01db, B:101:0x01e6, B:103:0x01f7, B:105:0x0204, B:107:0x0208, B:108:0x020d, B:109:0x0210, B:110:0x0217, B:102:0x01f2, B:96:0x01c1, B:98:0x01cd, B:111:0x0218, B:113:0x022a, B:127:0x02b2, B:128:0x02b4, B:130:0x02f9, B:132:0x02fd, B:133:0x0301, B:134:0x0308, B:135:0x0309, B:137:0x030d, B:138:0x0311, B:140:0x0317, B:142:0x0332, B:143:0x033b, B:145:0x0350, B:146:0x0354, B:148:0x0367, B:149:0x036e, B:151:0x0374, B:153:0x037a, B:155:0x0381, B:156:0x0385, B:160:0x0391, B:164:0x039f, B:166:0x03a7, B:168:0x03bc, B:172:0x03d5, B:214:0x04d4, B:215:0x04d8, B:219:0x04ec, B:224:0x04fa, B:228:0x0506, B:230:0x050a, B:231:0x050c, B:233:0x0514, B:234:0x0524, B:236:0x052c, B:240:0x0539, B:242:0x0559, B:244:0x0561, B:246:0x056b, B:247:0x0579, B:249:0x057f, B:250:0x058e, B:253:0x0599, B:255:0x05c8, B:256:0x05d9, B:258:0x05df, B:260:0x05e4, B:262:0x05f4, B:264:0x05f8, B:266:0x05fc, B:269:0x060c, B:271:0x0612, B:272:0x061b, B:275:0x0627, B:276:0x0646, B:278:0x064f, B:285:0x067a, B:281:0x0660, B:283:0x0668, B:284:0x0675, B:286:0x067e, B:288:0x0689, B:290:0x069e, B:292:0x06a6, B:293:0x06ab, B:294:0x06ba, B:296:0x06c0, B:298:0x06d0, B:300:0x06d4, B:301:0x06df, B:303:0x06e9, B:304:0x0710, B:306:0x0716, B:308:0x0720, B:309:0x0727, B:310:0x072a, B:311:0x073e, B:313:0x0744, B:315:0x0750, B:317:0x0758, B:319:0x0763, B:321:0x0769, B:324:0x0773, B:326:0x0786, B:327:0x0789, B:329:0x07b3, B:330:0x07b6, B:336:0x0812, B:331:0x07be, B:333:0x07d1, B:335:0x07f4, B:342:0x0830, B:337:0x081d, B:339:0x0823, B:341:0x082d, B:343:0x0834, B:358:0x0852, B:360:0x0857, B:362:0x085b, B:368:0x0883, B:370:0x0887, B:372:0x088c, B:373:0x0893, B:374:0x0894, B:375:0x089b, B:364:0x0860, B:366:0x0871, B:367:0x087c, B:62:0x0143, B:116:0x024f, B:117:0x025e, B:119:0x026e, B:124:0x0297, B:120:0x0273, B:123:0x027f, B:45:0x006a, B:51:0x0126, B:46:0x011a, B:220:0x04ee, B:80:0x018e), top: B:432:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x067e A[Catch: all -> 0x089c, TryCatch #13 {, blocks: (B:17:0x0018, B:19:0x0028, B:21:0x002c, B:23:0x0030, B:25:0x0034, B:27:0x003f, B:29:0x0043, B:30:0x0048, B:41:0x005a, B:43:0x0062, B:44:0x0068, B:58:0x0136, B:60:0x013f, B:63:0x014e, B:65:0x0152, B:66:0x0154, B:68:0x0162, B:70:0x0170, B:74:0x017c, B:76:0x0186, B:78:0x018a, B:83:0x019d, B:85:0x01a5, B:86:0x01ad, B:88:0x01b1, B:90:0x01b5, B:92:0x01b9, B:94:0x01bd, B:99:0x01db, B:101:0x01e6, B:103:0x01f7, B:105:0x0204, B:107:0x0208, B:108:0x020d, B:109:0x0210, B:110:0x0217, B:102:0x01f2, B:96:0x01c1, B:98:0x01cd, B:111:0x0218, B:113:0x022a, B:127:0x02b2, B:128:0x02b4, B:130:0x02f9, B:132:0x02fd, B:133:0x0301, B:134:0x0308, B:135:0x0309, B:137:0x030d, B:138:0x0311, B:140:0x0317, B:142:0x0332, B:143:0x033b, B:145:0x0350, B:146:0x0354, B:148:0x0367, B:149:0x036e, B:151:0x0374, B:153:0x037a, B:155:0x0381, B:156:0x0385, B:160:0x0391, B:164:0x039f, B:166:0x03a7, B:168:0x03bc, B:172:0x03d5, B:214:0x04d4, B:215:0x04d8, B:219:0x04ec, B:224:0x04fa, B:228:0x0506, B:230:0x050a, B:231:0x050c, B:233:0x0514, B:234:0x0524, B:236:0x052c, B:240:0x0539, B:242:0x0559, B:244:0x0561, B:246:0x056b, B:247:0x0579, B:249:0x057f, B:250:0x058e, B:253:0x0599, B:255:0x05c8, B:256:0x05d9, B:258:0x05df, B:260:0x05e4, B:262:0x05f4, B:264:0x05f8, B:266:0x05fc, B:269:0x060c, B:271:0x0612, B:272:0x061b, B:275:0x0627, B:276:0x0646, B:278:0x064f, B:285:0x067a, B:281:0x0660, B:283:0x0668, B:284:0x0675, B:286:0x067e, B:288:0x0689, B:290:0x069e, B:292:0x06a6, B:293:0x06ab, B:294:0x06ba, B:296:0x06c0, B:298:0x06d0, B:300:0x06d4, B:301:0x06df, B:303:0x06e9, B:304:0x0710, B:306:0x0716, B:308:0x0720, B:309:0x0727, B:310:0x072a, B:311:0x073e, B:313:0x0744, B:315:0x0750, B:317:0x0758, B:319:0x0763, B:321:0x0769, B:324:0x0773, B:326:0x0786, B:327:0x0789, B:329:0x07b3, B:330:0x07b6, B:336:0x0812, B:331:0x07be, B:333:0x07d1, B:335:0x07f4, B:342:0x0830, B:337:0x081d, B:339:0x0823, B:341:0x082d, B:343:0x0834, B:358:0x0852, B:360:0x0857, B:362:0x085b, B:368:0x0883, B:370:0x0887, B:372:0x088c, B:373:0x0893, B:374:0x0894, B:375:0x089b, B:364:0x0860, B:366:0x0871, B:367:0x087c, B:62:0x0143, B:116:0x024f, B:117:0x025e, B:119:0x026e, B:124:0x0297, B:120:0x0273, B:123:0x027f, B:45:0x006a, B:51:0x0126, B:46:0x011a, B:220:0x04ee, B:80:0x018e), top: B:432:0x0018 }] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void run() {
        boolean z;
        ArrayList arrayList;
        ArrayList arrayList2;
        Iterator<String> it;
        String str;
        ArrayList arrayList3;
        PackageInfo packageInfo;
        ApkInfo apkInfo;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        String str2;
        boolean z2;
        int indexOf;
        int indexOf2;
        ArrayList arrayList4;
        ArrayList arrayList5;
        JSONArray jSONArray;
        String str3;
        if (this.mOut) {
            if (sOutGoing) {
                return;
            }
            sOutGoing = true;
        }
        synchronized (U.class) {
            super.run();
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
            if (d.g(this.context)) {
                sLastCheckTime = System.currentTimeMillis();
            }
            Context context = this.context;
            e eVar = new e(context);
            long s = eVar.s() * VideoCloudSetting.HOUR_MILLISECOND;
            new StringBuilder("sjh-alarm gap ").append(eVar.s());
            com.baidu.sofire.b.a();
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
            long currentTimeMillis = ((System.currentTimeMillis() + s) - 600000) + ((long) (1200000.0d * Math.random()));
            eVar.f11731c.putLong("npuct", currentTimeMillis);
            eVar.f11731c.commit();
            StringBuilder sb = new StringBuilder("b=false,");
            sb.append(currentTimeMillis);
            sb.append(",");
            sb.append(s);
            sb.append(",");
            sb.append(System.currentTimeMillis());
            com.baidu.sofire.b.a();
            alarmManager.cancel(service);
            alarmManager.set(1, currentTimeMillis, service);
            i.a(this.context);
            if (this.mFrom == 1 || this.mFrom == 3) {
                sRetryPingTimesCount = 0;
                sRetryDownoadHostCareApksTimesCount = 0;
                b.a(this.context, 0, true);
                sSetRetrmAlarm = false;
            }
            if (this.mFrom == 2) {
                sSetRetrmAlarm = false;
            }
            boolean z3 = "com.baidu.input_huawei".equals(this.context.getPackageName()) ? !new e(this.context).y() : false;
            if (d.g(this.context) && !z3) {
                sLastCheckTime = System.currentTimeMillis();
                if (d.f11754g != null && (sMonitorNetworkWhenUpgradeNoNet || d.f11748a)) {
                    this.context.getApplicationContext().unregisterReceiver(d.f11754g);
                }
                sMonitorNetworkWhenUpgradeNoNet = false;
                d.f11748a = false;
                if (this.mFrom != 1) {
                    this.mWholeJson = d.p(this.context);
                }
                if (this.mWholeJson == null) {
                    if ((this.mFrom == 1 || this.mFrom == 2 || (this.mFrom == 3 && !sSetRetrmAlarm)) && this.preference.q().size() > 0) {
                        sSetRetrmAlarm = true;
                        b.a(this.context, sRetryPingTimesCount, false);
                        sRetryPingTimesCount++;
                    }
                    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    if (d.f11754g == null) {
                        d.f11754g = new MyReceiver().a();
                    } else {
                        d.f11754g.a();
                    }
                    d.a(this.context, d.f11754g, intentFilter);
                    sMonitorNetworkWhenUpgradeNoNet = true;
                    if (this.mEndReason == 0) {
                        if (d.f11751d != 0) {
                            this.mEndReason = d.f11751d;
                        } else {
                            this.mEndReason = 4;
                        }
                    }
                    throw new NetworkErrorException("ping faild");
                }
                sRetryPingTimesCount = 0;
                this.forHostAPP.a(this.mWholeJson);
                this.loadedPluginDB.d();
                if (!sPidRegister) {
                    e eVar2 = this.preference;
                    eVar2.f11731c.putInt("pdcg", this.preference.f11729a.getInt("pdcg", 0) + 1);
                    eVar2.f11731c.commit();
                    e eVar3 = this.preference;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 == 0) {
                        eVar3.f11731c.putString("pdcgts", "");
                        eVar3.f11731c.commit();
                    } else {
                        String string = eVar3.f11729a.getString("pdcgts", "");
                        if (TextUtils.isEmpty(string)) {
                            str3 = String.valueOf(currentTimeMillis2);
                        } else if (string.split("_").length < 20) {
                            str3 = string + "_" + String.valueOf(currentTimeMillis2);
                        }
                        new StringBuilder().append(str3);
                        com.baidu.sofire.b.a();
                        eVar3.f11731c.putString("pdcgts", str3);
                        eVar3.f11731c.commit();
                    }
                    sPidRegister = true;
                }
                e eVar4 = this.preference;
                eVar4.f11731c.putInt("rtqe", this.preference.f11729a.getInt("rtqe", 0) + 1);
                eVar4.f11731c.commit();
                List<ApkInfo> a2 = this.loadedPluginDB.a();
                new StringBuilder("a=").append(a2);
                com.baidu.sofire.b.a();
                ArrayList arrayList6 = new ArrayList();
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = new ArrayList();
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
                        String str4 = optInt + optString;
                        if (sRealtimeMd5Map == null) {
                            sRealtimeMd5Map = new HashMap();
                        }
                        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(optString3)) {
                            sRealtimeMd5Map.put(str4, optString3);
                        }
                        if (optString4 != null) {
                            optString4 = optString4.toLowerCase();
                        }
                        boolean z4 = optJSONObject4.optInt(Config.OS) == 1;
                        JSONObject jSONObject = optJSONObject3;
                        boolean z5 = optJSONObject4.optInt("d") == 1;
                        int optInt2 = optJSONObject4.optInt(r.f7664a);
                        if (z4) {
                            it = keys;
                            e eVar5 = this.preference;
                            arrayList = arrayList6;
                            arrayList2 = arrayList7;
                            str = optString4;
                            if (optInt2 > eVar5.f11729a.getInt("opi", 0)) {
                                eVar5.f11731c.putInt("opi", optInt2);
                                eVar5.f11731c.commit();
                            }
                        } else {
                            arrayList = arrayList6;
                            arrayList2 = arrayList7;
                            it = keys;
                            str = optString4;
                        }
                        if (z4 && z5) {
                            arrayList8.add(next);
                            optJSONObject3 = jSONObject;
                            keys = it;
                            arrayList6 = arrayList;
                            arrayList7 = arrayList2;
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
                                    arrayList3 = arrayList8;
                                } else {
                                    ArrayList arrayList9 = new ArrayList();
                                    int i = 0;
                                    while (i < optJSONArray.length()) {
                                        try {
                                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                                            if (jSONObject2 != null) {
                                                ActivityInfo activityInfo = new ActivityInfo();
                                                jSONArray = optJSONArray;
                                                try {
                                                    String optString6 = jSONObject2.optString("n");
                                                    activityInfo.name = optString6;
                                                    if (TextUtils.isEmpty(optString6)) {
                                                        arrayList3 = arrayList8;
                                                    } else {
                                                        arrayList3 = arrayList8;
                                                        try {
                                                            if (activityInfo.name.startsWith(".")) {
                                                                activityInfo.name = next + activityInfo.name;
                                                            }
                                                        } catch (Throwable unused) {
                                                            try {
                                                                d.a();
                                                                continue;
                                                                i++;
                                                                optJSONArray = jSONArray;
                                                                arrayList8 = arrayList3;
                                                            } catch (Throwable unused2) {
                                                                d.a();
                                                                packageInfo = null;
                                                                apkInfo = new ApkInfo(optInt, next, optString, optString2, optString3);
                                                                apkInfo.isOnce = !z4 ? 1 : 0;
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
                                                                apkInfo.signMD5 = str2;
                                                                apkInfo.startTime = System.currentTimeMillis();
                                                                indexOf = a2.indexOf(apkInfo);
                                                                StringBuilder sb2 = new StringBuilder("t=");
                                                                sb2.append(apkInfo);
                                                                sb2.append(", i=");
                                                                sb2.append(indexOf);
                                                                com.baidu.sofire.b.a();
                                                                ApkInfo apkInfo2 = new ApkInfo(apkInfo);
                                                                if (!TextUtils.isEmpty(apkInfo.packageName)) {
                                                                }
                                                                indexOf2 = a2.indexOf(apkInfo2);
                                                                if (indexOf2 >= 0) {
                                                                }
                                                                if (indexOf < 0) {
                                                                }
                                                                arrayList7 = arrayList5;
                                                                arrayList6 = arrayList4;
                                                                optJSONObject3 = jSONObject;
                                                                keys = it;
                                                                arrayList8 = arrayList3;
                                                            }
                                                        }
                                                    }
                                                    activityInfo.packageName = next;
                                                    activityInfo.theme = jSONObject2.optInt("t");
                                                    activityInfo.labelRes = jSONObject2.optInt("l");
                                                    if (TextUtils.isEmpty(activityInfo.name)) {
                                                        continue;
                                                    } else {
                                                        arrayList9.add(activityInfo);
                                                        continue;
                                                    }
                                                } catch (Throwable unused3) {
                                                    arrayList3 = arrayList8;
                                                    d.a();
                                                    continue;
                                                    i++;
                                                    optJSONArray = jSONArray;
                                                    arrayList8 = arrayList3;
                                                }
                                            } else {
                                                jSONArray = optJSONArray;
                                                arrayList3 = arrayList8;
                                                continue;
                                            }
                                        } catch (Throwable unused4) {
                                            jSONArray = optJSONArray;
                                        }
                                        i++;
                                        optJSONArray = jSONArray;
                                        arrayList8 = arrayList3;
                                    }
                                    arrayList3 = arrayList8;
                                    if (arrayList9.size() > 0) {
                                        packageInfo.activities = (ActivityInfo[]) arrayList9.toArray(new ActivityInfo[arrayList9.size()]);
                                    }
                                }
                            } catch (Throwable unused5) {
                                arrayList3 = arrayList8;
                            }
                            apkInfo = new ApkInfo(optInt, next, optString, optString2, optString3);
                            apkInfo.isOnce = !z4 ? 1 : 0;
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
                                z2 = optJSONObject2.optInt("nl", 0) == 1;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(next);
                                sb3.append(" nlld ");
                                sb3.append(Boolean.toString(z2));
                                com.baidu.sofire.b.a();
                                if (optJSONObject2.optInt("a") == 1) {
                                    List<Integer> q = this.preference.q();
                                    if (optInt > 0 && !q.contains(Integer.valueOf(optInt))) {
                                        q.add(Integer.valueOf(optInt));
                                        int[] iArr = new int[q.size()];
                                        for (int i2 = 0; i2 < q.size(); i2++) {
                                            iArr[i2] = q.get(i2).intValue();
                                        }
                                        this.preference.a(iArr);
                                    }
                                }
                                str2 = str;
                            } else {
                                str2 = str;
                                z2 = false;
                            }
                            apkInfo.signMD5 = str2;
                            apkInfo.startTime = System.currentTimeMillis();
                            indexOf = a2.indexOf(apkInfo);
                            StringBuilder sb22 = new StringBuilder("t=");
                            sb22.append(apkInfo);
                            sb22.append(", i=");
                            sb22.append(indexOf);
                            com.baidu.sofire.b.a();
                            ApkInfo apkInfo22 = new ApkInfo(apkInfo);
                            if (!TextUtils.isEmpty(apkInfo.packageName)) {
                                apkInfo22.packageName = new StringBuilder(apkInfo22.packageName).reverse().toString();
                            }
                            indexOf2 = a2.indexOf(apkInfo22);
                            if (indexOf2 >= 0) {
                                a2.remove(indexOf2);
                            }
                            if (indexOf < 0) {
                                ApkInfo apkInfo3 = a2.get(indexOf);
                                if (d.b(apkInfo.versionName, apkInfo3.versionName) && (c.f11661d == null || ((c.f11661d != null && !c.f11661d.contains(Integer.valueOf(apkInfo.key))) || z2))) {
                                    if (apkInfo3.priority != apkInfo.priority) {
                                        this.loadedPluginDB.c(apkInfo.key, apkInfo.priority);
                                    }
                                    if (this.loadedPluginDB.e(apkInfo3.key)) {
                                        arrayList5 = arrayList2;
                                    } else {
                                        if (z2) {
                                            StringBuilder sb4 = new StringBuilder();
                                            sb4.append(apkInfo.versionName);
                                            sb4.append(" ");
                                            sb4.append(apkInfo.key);
                                            sb4.append(" nl is t");
                                            com.baidu.sofire.b.a();
                                            apkInfo.isNextLoad = true;
                                        }
                                        arrayList5 = arrayList2;
                                        arrayList5.add(apkInfo);
                                        if (this.mDownloadPluginsList != null) {
                                            this.mDownloadPluginsList.add(Integer.valueOf(apkInfo.key));
                                        }
                                    }
                                    arrayList4 = arrayList;
                                } else {
                                    arrayList5 = arrayList2;
                                    if (apkInfo3.priority != apkInfo.priority) {
                                        apkInfo3.priority = apkInfo.priority;
                                        this.loadedPluginDB.c(apkInfo.key, apkInfo.priority);
                                    }
                                    arrayList4 = arrayList;
                                    arrayList4.add(apkInfo3);
                                }
                                a2.remove(indexOf);
                            } else {
                                arrayList4 = arrayList;
                                arrayList5 = arrayList2;
                                arrayList5.add(apkInfo);
                                if (this.mDownloadPluginsList != null) {
                                    this.mDownloadPluginsList.add(Integer.valueOf(apkInfo.key));
                                }
                            }
                            arrayList7 = arrayList5;
                            arrayList6 = arrayList4;
                            optJSONObject3 = jSONObject;
                            keys = it;
                            arrayList8 = arrayList3;
                        }
                    }
                }
                ArrayList arrayList10 = arrayList7;
                ArrayList arrayList11 = arrayList8;
                ArrayList arrayList12 = arrayList6;
                if (c.f11661d != null) {
                    c.f11661d.clear();
                }
                new StringBuilder().append(a2);
                com.baidu.sofire.b.a();
                for (ApkInfo apkInfo4 : a2) {
                    ArrayList arrayList13 = arrayList11;
                    if (!arrayList13.contains(apkInfo4.packageName)) {
                        if (this.mUnloadPluginsList != null) {
                            this.mUnloadPluginsList.add(Integer.valueOf(apkInfo4.key));
                        }
                        this.forHostAPP.a(apkInfo4.packageName);
                    }
                    arrayList11 = arrayList13;
                }
                d.d(this.context);
                new StringBuilder().append(arrayList12);
                com.baidu.sofire.b.a();
                f a3 = f.a(this.context.getApplicationContext());
                final List<Integer> r = this.preference.r();
                List<Integer> q2 = this.preference.q();
                for (int i3 = 0; i3 < q2.size(); i3++) {
                    if (!r.contains(q2.get(i3))) {
                        r.add(q2.get(i3));
                    }
                }
                ArrayList arrayList14 = new ArrayList();
                arrayList14.addAll(arrayList12);
                arrayList14.addAll(arrayList10);
                Collections.sort(arrayList14, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.ac.U.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(ApkInfo apkInfo5, ApkInfo apkInfo6) {
                        int i4;
                        int i5;
                        if (apkInfo5.priority != -1 || apkInfo6.priority == -1) {
                            if ((apkInfo5.priority == -1 || apkInfo6.priority != -1) && (i4 = apkInfo5.priority) >= (i5 = apkInfo6.priority)) {
                                if (i4 > i5) {
                                    return 1;
                                }
                                List list = r;
                                int indexOf3 = (list == null || !list.contains(Integer.valueOf(apkInfo5.key))) ? -1 : r.indexOf(Integer.valueOf(apkInfo5.key));
                                List list2 = r;
                                int indexOf4 = (list2 == null || !list2.contains(Integer.valueOf(apkInfo6.key))) ? -1 : r.indexOf(Integer.valueOf(apkInfo6.key));
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
                for (int i4 = 0; i4 < arrayList14.size(); i4++) {
                    ApkInfo apkInfo5 = (ApkInfo) arrayList14.get(i4);
                    if (arrayList12.contains(apkInfo5)) {
                        if (a3.d(apkInfo5.packageName) == null) {
                            if (this.loadedPluginDB.g(apkInfo5.key) == 3) {
                                com.baidu.sofire.b.a();
                                z = false;
                            } else {
                                z = true;
                            }
                            if (this.preference.c() && z) {
                                File file = new File(this.context.getFilesDir(), ".b");
                                if (!file.exists()) {
                                    file.mkdir();
                                }
                                File file2 = new File(apkInfo5.pkgPath);
                                File file3 = new File(file, apkInfo5.key + "-" + apkInfo5.versionName);
                                if (!d.a(file3)) {
                                    d.a(file2, file3);
                                }
                                com.baidu.sofire.c.a(this.context, apkInfo5.key, file2, file3);
                            } else {
                                File file4 = new File(this.context.getFilesDir(), ".b");
                                if (file4.exists()) {
                                    File file5 = new File(file4, apkInfo5.key + "-" + apkInfo5.versionName);
                                    if (d.a(file5)) {
                                        com.baidu.sofire.c.a(file5);
                                        boolean delete = file5.delete();
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append(file5.getAbsolutePath());
                                        sb5.append(" s=");
                                        sb5.append(delete);
                                        com.baidu.sofire.b.a();
                                    }
                                }
                            }
                            this.forHostAPP.a(apkInfo5.key, apkInfo5.versionName, null);
                        }
                    } else if (arrayList10.contains(apkInfo5) && !this.loadedPluginDB.e(apkInfo5.key)) {
                        handlePluginUpgrade(apkInfo5);
                    }
                }
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
                com.baidu.sofire.b.a();
                sMonitorNetworkWhenUpgradeNoNet = true;
                IntentFilter intentFilter2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                if (d.f11754g == null) {
                    d.f11754g = new MyReceiver().a();
                }
                d.a(this.context, d.f11754g, intentFilter2);
            }
            if (this.mEndReason == 0) {
                this.mEndReason = 3;
            }
            if (z3) {
                throw new NetworkErrorException("blocked by Huawei Input");
            }
            throw new NetworkErrorException("no internet");
        }
    }

    public U(Context context, int i, boolean z, JSONObject jSONObject) {
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
        this.preference = new e(context);
        this.forHostAPP = c.a(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.mFrom = i;
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
