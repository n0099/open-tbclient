package com.baidu.sofire.ac;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mobstat.Config;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.a.a;
import com.baidu.sofire.b;
import com.baidu.sofire.b.n;
import com.baidu.sofire.b.p;
import com.baidu.sofire.c;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.d;
import com.baidu.sofire.core.g;
import com.baidu.sofire.e;
import com.baidu.sofire.jni.Asc;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.xiaomi.mipush.sdk.Constants;
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
    private Context context;
    private d forHostAPP;
    private a loadedPluginDB;
    private Map<Integer, String> mCloudKeyMap;
    List<Integer> mDownloadPluginsList;
    private int mEndReason;
    private int mFrom;
    private boolean mOut;
    private Map<Integer, String> mStartKeyMap;
    private int mStartNetwork;
    List<Integer> mUnloadPluginsList;
    private Map<Integer, UpgradeResult> mUpgradeResultMap;
    private JSONObject mWholeJson;
    private e preference;
    private File tmpDir;
    private static long sLastCheckTime = 0;
    private static volatile boolean sOutGoing = false;
    private static boolean sPidRegister = false;
    public static boolean sMonitorNetworkWhenUpgradeNoNet = false;
    private static int sRetryPingTimesCount = 0;
    private static int sRetryDownoadHostCareApksTimesCount = 0;
    private static boolean sSetRetrmAlarm = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class UpgradeResult {
        int networkId;
        int resultId;

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
        this.forHostAPP = d.a(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.mFrom = i;
        this.mOut = z;
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
        this.forHostAPP = d.a(context);
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

    public void handleWork(Context context, Intent intent) {
        this.context = context;
        this.loadedPluginDB = a.a(context);
        this.preference = new e(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.forHostAPP = d.a(context);
        this.mFrom = intent.getIntExtra("from", 0);
        b.a();
        start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [646=4, 647=4, 650=4] */
    @Override // java.lang.Thread, java.lang.Runnable
    public synchronized void run() {
        String str;
        try {
            if (this.mOut) {
                if (!sOutGoing) {
                    sOutGoing = true;
                }
            }
            synchronized (U.class) {
                super.run();
                handleThreadStart();
                if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3 || this.mOut || System.currentTimeMillis() - sLastCheckTime >= KeepJobService.JOB_CHECK_PERIODIC) {
                    if (com.baidu.sofire.b.e.f(this.context)) {
                        sLastCheckTime = System.currentTimeMillis();
                    }
                    com.baidu.sofire.b.b.a(this.context, false);
                    Context context = this.context;
                    a a = a.a(context);
                    d a2 = d.a(context);
                    b.a();
                    for (ApkInfo apkInfo : a.a()) {
                        if (apkInfo.duration != 0 && apkInfo.startTime + (apkInfo.duration * 60 * 1000) < System.currentTimeMillis()) {
                            a2.a(apkInfo.packageName);
                        }
                    }
                    if (this.mFrom == 1 || this.mFrom == 3) {
                        sRetryPingTimesCount = 0;
                        sRetryDownoadHostCareApksTimesCount = 0;
                        com.baidu.sofire.b.b.a(this.context, 0, true);
                        sSetRetrmAlarm = false;
                    }
                    if (this.mFrom == 2) {
                        sSetRetrmAlarm = false;
                    }
                    boolean z = "com.baidu.input_huawei".equals(this.context.getPackageName()) ? !new e(this.context).z() : false;
                    if (!com.baidu.sofire.b.e.f(this.context) || z) {
                        if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                            b.a();
                            sMonitorNetworkWhenUpgradeNoNet = true;
                            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                            if (com.baidu.sofire.b.e.e == null) {
                                com.baidu.sofire.b.e.e = new MyReceiver().a();
                            }
                            com.baidu.sofire.b.e.a(this.context, com.baidu.sofire.b.e.e, intentFilter);
                        }
                        if (this.mEndReason == 0) {
                            this.mEndReason = 3;
                        }
                        if (!z) {
                            throw new NetworkErrorException("no internet");
                        }
                        throw new NetworkErrorException("blocked by Huawei Input");
                    }
                    sLastCheckTime = System.currentTimeMillis();
                    if (com.baidu.sofire.b.e.e != null && (sMonitorNetworkWhenUpgradeNoNet || com.baidu.sofire.b.e.a)) {
                        this.context.getApplicationContext().unregisterReceiver(com.baidu.sofire.b.e.e);
                    }
                    sMonitorNetworkWhenUpgradeNoNet = false;
                    com.baidu.sofire.b.e.a = false;
                    if (this.mFrom != 1) {
                        this.mWholeJson = com.baidu.sofire.b.e.o(this.context);
                    }
                    if (this.mWholeJson == null) {
                        if ((this.mFrom == 1 || this.mFrom == 2 || (this.mFrom == 3 && !sSetRetrmAlarm)) && this.preference.p().size() > 0) {
                            sSetRetrmAlarm = true;
                            com.baidu.sofire.b.b.a(this.context, sRetryPingTimesCount, false);
                            sRetryPingTimesCount++;
                        }
                        IntentFilter intentFilter2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        if (com.baidu.sofire.b.e.e == null) {
                            com.baidu.sofire.b.e.e = new MyReceiver().a();
                        } else {
                            com.baidu.sofire.b.e.e.a();
                        }
                        com.baidu.sofire.b.e.a(this.context, com.baidu.sofire.b.e.e, intentFilter2);
                        sMonitorNetworkWhenUpgradeNoNet = true;
                        if (this.mEndReason == 0) {
                            if (com.baidu.sofire.b.e.d != 0) {
                                this.mEndReason = com.baidu.sofire.b.e.d;
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
                        e eVar = this.preference;
                        eVar.c.putInt("pdcg", this.preference.a.getInt("pdcg", 0) + 1);
                        eVar.c.commit();
                        e eVar2 = this.preference;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis == 0) {
                            eVar2.c.putString("pdcgts", "");
                            eVar2.c.commit();
                        } else {
                            String string = eVar2.a.getString("pdcgts", "");
                            if (TextUtils.isEmpty(string)) {
                                str = String.valueOf(currentTimeMillis);
                            } else if (string.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).length < 20) {
                                str = string + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + String.valueOf(currentTimeMillis);
                            }
                            new StringBuilder().append(str);
                            b.a();
                            eVar2.c.putString("pdcgts", str);
                            eVar2.c.commit();
                        }
                        sPidRegister = true;
                    }
                    e eVar3 = this.preference;
                    eVar3.c.putInt("rtqe", this.preference.a.getInt("rtqe", 0) + 1);
                    eVar3.c.commit();
                    List<ApkInfo> a3 = this.loadedPluginDB.a();
                    new StringBuilder("a=").append(a3);
                    b.a();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    JSONObject optJSONObject = this.mWholeJson.optJSONObject("5");
                    if (optJSONObject == null) {
                        if (this.mEndReason == 0) {
                            this.mEndReason = 10;
                        }
                        throw new NetworkErrorException("plugin json is null");
                    }
                    if (optJSONObject instanceof JSONObject) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                            int optInt = optJSONObject2.optInt("l");
                            String optString = optJSONObject2.optString("v");
                            if (this.mCloudKeyMap != null) {
                                this.mCloudKeyMap.put(Integer.valueOf(optInt), optString);
                            }
                            String optString2 = optJSONObject2.optString("u");
                            String optString3 = optJSONObject2.optString("m");
                            String optString4 = optJSONObject2.optString("sm");
                            if (optString3 != null) {
                                optString3 = optString3.toLowerCase();
                            }
                            String lowerCase = optString4 != null ? optString4.toLowerCase() : optString4;
                            boolean z2 = optJSONObject2.optInt(Config.OS) == 1;
                            boolean z3 = optJSONObject2.optInt("d") == 1;
                            int optInt2 = optJSONObject2.optInt("r");
                            if (z2) {
                                e eVar4 = this.preference;
                                if (optInt2 > eVar4.a.getInt("opi", 0)) {
                                    eVar4.c.putInt("opi", optInt2);
                                    eVar4.c.commit();
                                }
                            }
                            if (z2 && z3) {
                                arrayList3.add(next);
                            } else {
                                PackageInfo packageInfo = new PackageInfo();
                                packageInfo.packageName = optJSONObject2.optString("p");
                                packageInfo.versionName = optString;
                                ApplicationInfo applicationInfo = new ApplicationInfo();
                                applicationInfo.className = optJSONObject2.optString("n");
                                if (!TextUtils.isEmpty(applicationInfo.className) && applicationInfo.className.startsWith(DefaultConfig.TOKEN_SEPARATOR)) {
                                    applicationInfo.className = next + applicationInfo.className;
                                }
                                applicationInfo.theme = optJSONObject2.optInt("t");
                                packageInfo.applicationInfo = applicationInfo;
                                JSONArray optJSONArray = optJSONObject2.optJSONArray(Config.APP_VERSION_CODE);
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    ArrayList arrayList4 = new ArrayList();
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        try {
                                            JSONObject jSONObject = optJSONArray.getJSONObject(i);
                                            if (jSONObject != null) {
                                                ActivityInfo activityInfo = new ActivityInfo();
                                                activityInfo.name = jSONObject.optString("n");
                                                if (!TextUtils.isEmpty(activityInfo.name) && activityInfo.name.startsWith(DefaultConfig.TOKEN_SEPARATOR)) {
                                                    activityInfo.name = next + activityInfo.name;
                                                }
                                                activityInfo.packageName = next;
                                                activityInfo.theme = jSONObject.optInt("t");
                                                activityInfo.labelRes = jSONObject.optInt("l");
                                                if (!TextUtils.isEmpty(activityInfo.name)) {
                                                    arrayList4.add(activityInfo);
                                                }
                                            }
                                        } catch (Throwable th) {
                                            com.baidu.sofire.b.e.a();
                                        }
                                    }
                                    if (arrayList4.size() > 0) {
                                        packageInfo.activities = (ActivityInfo[]) arrayList4.toArray(new ActivityInfo[arrayList4.size()]);
                                    }
                                }
                                ApkInfo apkInfo2 = new ApkInfo(optInt, next, optString, optString2, optString3);
                                apkInfo2.isOnce = z2 ? 1 : 0;
                                apkInfo2.priority = optJSONObject2.getInt(Config.PRINCIPAL_PART);
                                apkInfo2.isMem = optJSONObject2.optInt("mem") == 1;
                                if (packageInfo != null) {
                                    apkInfo2.cloudPkgInfo = packageInfo;
                                }
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("e");
                                if (optJSONObject3 != null) {
                                    int optInt3 = optJSONObject3.optInt("d");
                                    int optInt4 = optJSONObject3.optInt("n");
                                    apkInfo2.duration = optInt3;
                                    apkInfo2.network = optInt4;
                                }
                                boolean z4 = false;
                                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("ext");
                                if (optJSONObject4 != null) {
                                    z4 = optJSONObject4.optInt("nl", 0) == 1;
                                    new StringBuilder().append(next).append(" nlld ").append(Boolean.toString(z4));
                                    b.a();
                                    if (optJSONObject4.optInt(Config.APP_VERSION_CODE) == 1) {
                                        List<Integer> p = this.preference.p();
                                        if (optInt > 0 && !p.contains(Integer.valueOf(optInt))) {
                                            p.add(Integer.valueOf(optInt));
                                            int[] iArr = new int[p.size()];
                                            int i2 = 0;
                                            while (true) {
                                                int i3 = i2;
                                                if (i3 >= p.size()) {
                                                    break;
                                                }
                                                iArr[i3] = p.get(i3).intValue();
                                                i2 = i3 + 1;
                                            }
                                            this.preference.a(iArr);
                                        }
                                    }
                                }
                                boolean z5 = z4;
                                apkInfo2.signMD5 = lowerCase;
                                apkInfo2.startTime = System.currentTimeMillis();
                                int indexOf = a3.indexOf(apkInfo2);
                                new StringBuilder("t=").append(apkInfo2).append(", i=").append(indexOf);
                                b.a();
                                ApkInfo apkInfo3 = new ApkInfo(apkInfo2);
                                if (!TextUtils.isEmpty(apkInfo2.packageName)) {
                                    apkInfo3.packageName = new StringBuilder(apkInfo3.packageName).reverse().toString();
                                }
                                int indexOf2 = a3.indexOf(apkInfo3);
                                if (indexOf2 >= 0) {
                                    a3.remove(indexOf2);
                                }
                                if (indexOf >= 0) {
                                    ApkInfo apkInfo4 = a3.get(indexOf);
                                    if (!com.baidu.sofire.b.e.b(apkInfo2.versionName, apkInfo4.versionName) || (d.c != null && ((d.c == null || d.c.contains(Integer.valueOf(apkInfo2.key))) && !z5))) {
                                        if (apkInfo4.priority != apkInfo2.priority) {
                                            apkInfo4.priority = apkInfo2.priority;
                                            this.loadedPluginDB.c(apkInfo2.key, apkInfo2.priority);
                                        }
                                        arrayList.add(apkInfo4);
                                    } else {
                                        if (apkInfo4.priority != apkInfo2.priority) {
                                            this.loadedPluginDB.c(apkInfo2.key, apkInfo2.priority);
                                        }
                                        if (!this.loadedPluginDB.e(apkInfo4.key)) {
                                            if (z5) {
                                                new StringBuilder().append(apkInfo2.versionName).append(HanziToPinyin.Token.SEPARATOR).append(apkInfo2.key).append(" nl is t");
                                                b.a();
                                                apkInfo2.isNextLoad = true;
                                            }
                                            arrayList2.add(apkInfo2);
                                            if (this.mDownloadPluginsList != null) {
                                                this.mDownloadPluginsList.add(Integer.valueOf(apkInfo2.key));
                                            }
                                        }
                                    }
                                    a3.remove(indexOf);
                                } else {
                                    arrayList2.add(apkInfo2);
                                    if (this.mDownloadPluginsList != null) {
                                        this.mDownloadPluginsList.add(Integer.valueOf(apkInfo2.key));
                                    }
                                }
                            }
                        }
                    }
                    if (d.c != null) {
                        d.c.clear();
                    }
                    new StringBuilder().append(a3);
                    b.a();
                    for (ApkInfo apkInfo5 : a3) {
                        if (!arrayList3.contains(apkInfo5.packageName)) {
                            if (this.mUnloadPluginsList != null) {
                                this.mUnloadPluginsList.add(Integer.valueOf(apkInfo5.key));
                            }
                            this.forHostAPP.a(apkInfo5.packageName);
                        }
                    }
                    com.baidu.sofire.b.e.c(this.context);
                    new StringBuilder().append(arrayList);
                    b.a();
                    g a4 = g.a(this.context.getApplicationContext());
                    final List<Integer> q = this.preference.q();
                    List<Integer> p2 = this.preference.p();
                    for (int i4 = 0; i4 < p2.size(); i4++) {
                        if (!q.contains(p2.get(i4))) {
                            q.add(p2.get(i4));
                        }
                    }
                    ArrayList arrayList5 = new ArrayList();
                    arrayList5.addAll(arrayList);
                    arrayList5.addAll(arrayList2);
                    Collections.sort(arrayList5, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.ac.U.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(ApkInfo apkInfo6, ApkInfo apkInfo7) {
                            if (apkInfo6.priority != -1 || apkInfo7.priority == -1) {
                                if ((apkInfo6.priority == -1 || apkInfo7.priority != -1) && apkInfo6.priority >= apkInfo7.priority) {
                                    if (apkInfo6.priority > apkInfo7.priority) {
                                        return 1;
                                    }
                                    int indexOf3 = (q == null || !q.contains(Integer.valueOf(apkInfo6.key))) ? -1 : q.indexOf(Integer.valueOf(apkInfo6.key));
                                    int indexOf4 = (q == null || !q.contains(Integer.valueOf(apkInfo7.key))) ? -1 : q.indexOf(Integer.valueOf(apkInfo7.key));
                                    if (indexOf3 == -1 || indexOf4 != -1) {
                                        if ((indexOf3 != -1 || indexOf4 == -1) && indexOf3 <= indexOf4) {
                                            return indexOf3 >= indexOf4 ? 0 : -1;
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
                    for (int i5 = 0; i5 < arrayList5.size(); i5++) {
                        ApkInfo apkInfo6 = (ApkInfo) arrayList5.get(i5);
                        if (arrayList.contains(apkInfo6)) {
                            if (a4.d(apkInfo6.packageName) == null) {
                                boolean z6 = true;
                                if (this.loadedPluginDB.g(apkInfo6.key) == 3) {
                                    b.a();
                                    z6 = false;
                                }
                                if (this.preference.c() && z6) {
                                    File file = new File(this.context.getFilesDir(), ".b");
                                    if (!file.exists()) {
                                        file.mkdir();
                                    }
                                    File file2 = new File(apkInfo6.pkgPath);
                                    File file3 = new File(file, apkInfo6.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo6.versionName);
                                    if (!com.baidu.sofire.b.e.a(file3)) {
                                        com.baidu.sofire.b.e.a(file2, file3);
                                    }
                                    c.a(this.context, apkInfo6.key, file2, file3);
                                } else {
                                    File file4 = new File(this.context.getFilesDir(), ".b");
                                    if (file4.exists()) {
                                        File file5 = new File(file4, apkInfo6.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo6.versionName);
                                        if (com.baidu.sofire.b.e.a(file5)) {
                                            c.a(file5);
                                            new StringBuilder().append(file5.getAbsolutePath()).append(" s=").append(file5.delete());
                                            b.a();
                                        }
                                    }
                                }
                                this.forHostAPP.a(apkInfo6.key, apkInfo6.versionName, null);
                            }
                        } else if (arrayList2.contains(apkInfo6) && !this.loadedPluginDB.e(apkInfo6.key)) {
                            handlePluginUpgrade(apkInfo6);
                        }
                    }
                    if (this.mEndReason == 0) {
                        this.mEndReason = 1;
                    }
                    handleThreadEnd(null);
                    if (this.mOut && sOutGoing) {
                        sOutGoing = false;
                    }
                } else {
                    if (this.mEndReason == 0) {
                        this.mEndReason = 2;
                        handleThreadEnd(null);
                    }
                    if (this.mOut && sOutGoing) {
                        sOutGoing = false;
                    }
                }
            }
        }
    }

    private void handleThreadEnd(String str) {
        try {
            this.preference.g(this.preference.v() + 1);
            if (this.mEndReason != 0) {
                this.preference.a(1, this.mEndReason, this.preference.a(1, this.mEndReason) + 1);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
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
                hashMap.put(com.tencent.connect.common.Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, jSONObject);
            }
            Map<Integer, String> b = this.loadedPluginDB.b();
            hashMap.put("9", b.keySet());
            hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, b.values());
            hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Integer.valueOf(this.mEndReason));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, str.replace("\n", "").replace("\t", "").replace("\r", ""));
            }
            hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP, Integer.valueOf(this.mStartNetwork));
            hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Integer.valueOf(com.baidu.sofire.b.e.k(this.context)));
            com.baidu.sofire.b.e.a(this.context, "1003129", hashMap);
        } catch (Throwable th2) {
            com.baidu.sofire.b.e.a();
        }
    }

    private void handleThreadStart() {
        try {
            long j = this.preference.a.getLong("slruct", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (j > 0 && currentTimeMillis - j > 86400000) {
                HashMap hashMap = new HashMap();
                hashMap.put("1", Integer.valueOf(this.preference.u()));
                this.preference.f(0);
                JSONObject jSONObject = new JSONObject();
                for (int i = 1; i <= 6; i++) {
                    jSONObject.put(String.valueOf(i), this.preference.a(0, i));
                    this.preference.a(0, i, 0);
                }
                hashMap.put("2", jSONObject);
                hashMap.put("3", Integer.valueOf(this.preference.v()));
                this.preference.g(0);
                JSONObject jSONObject2 = new JSONObject();
                for (int i2 = 1; i2 <= 11; i2++) {
                    jSONObject2.put(String.valueOf(i2), this.preference.a(1, i2));
                    this.preference.a(1, i2, 0);
                }
                hashMap.put("4", jSONObject2);
                com.baidu.sofire.b.e.a(this.context, "1003128", hashMap);
                this.preference.b(currentTimeMillis);
            } else if (j == 0) {
                this.preference.b(currentTimeMillis);
            }
        } catch (Throwable th) {
            try {
                this.preference.f(0);
                this.preference.g(0);
                for (int i3 = 1; i3 <= 6; i3++) {
                    this.preference.a(0, i3, 0);
                }
                for (int i4 = 1; i4 <= 11; i4++) {
                    this.preference.a(1, i4, 0);
                }
            } catch (Throwable th2) {
                com.baidu.sofire.b.e.a();
            }
            com.baidu.sofire.b.e.a();
        }
        try {
            this.mStartKeyMap = this.loadedPluginDB.b();
            this.preference.f(this.preference.u() + 1);
            if (this.mFrom != 0) {
                this.preference.a(0, this.mFrom, this.preference.a(0, this.mFrom) + 1);
            }
            this.mStartNetwork = com.baidu.sofire.b.e.k(this.context);
        } catch (Throwable th3) {
            com.baidu.sofire.b.e.a();
        }
    }

    private void pluginUpdate(File file, ApkInfo apkInfo, int i) {
        com.baidu.sofire.b.e.a(file.getAbsolutePath(), true);
        if (this.preference.c()) {
            File file2 = new File(this.context.getFilesDir(), ".b");
            if (!file2.exists()) {
                file2.mkdir();
            }
            File file3 = new File(file2, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
            com.baidu.sofire.b.e.a(file, file3);
            c.a(this.context, apkInfo.key, file, file3);
        }
        apkInfo.pkgPath = file.getAbsolutePath();
        String str = "before update, time=" + System.currentTimeMillis() + ", downloadAPK path:" + file.getAbsolutePath() + ", exists=" + file.exists() + ", canRead=" + file.canRead() + ", isFile=" + file.isFile() + ",length" + file.length();
        StringBuilder sb = new StringBuilder("before update, time=" + System.currentTimeMillis() + ", ");
        ApkInfo a = this.loadedPluginDB.a(apkInfo.key);
        if (a == null) {
            sb.append("apkInDB == null");
        } else {
            File file4 = new File(a.pkgPath);
            sb.append("origAPK path:" + file4.getAbsolutePath() + ", exists=" + file4.exists() + ", canRead=" + file4.canRead() + ", isFile=" + file4.isFile() + ",length" + file4.length());
        }
        boolean a2 = this.forHostAPP.a(apkInfo, str);
        new StringBuilder().append(apkInfo.packageName).append(" s=").append(a2);
        b.a();
        this.loadedPluginDB.a(apkInfo.key + 10000000, apkInfo.versionName);
        if (!a2) {
            if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i, 5));
                return;
            }
            return;
        }
        int g = this.loadedPluginDB.g(apkInfo.key);
        new StringBuilder("new plugin now loadStatus :").append(apkInfo.key).append(HanziToPinyin.Token.SEPARATOR).append(g);
        b.a();
        if (g < 3 && g != -1) {
            this.loadedPluginDB.b(apkInfo.key, g + 1);
        }
        if (this.mUpgradeResultMap != null) {
            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handlePluginDownload(ApkInfo apkInfo, File file, File file2, int i) {
        try {
            if (file.exists()) {
                file.delete();
            }
            if (!"com.baidu.input_huawei".equals(this.context.getPackageName()) || this.preference.z()) {
                boolean a = new n(this.context).a(apkInfo.downloadURL, file);
                b.a();
                if (a) {
                    if (file2.exists()) {
                        b.a();
                        file2.delete();
                    }
                    Asc asc = new Asc();
                    byte[] bytes = apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes("utf-8");
                    com.baidu.sofire.b.e.e(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
                    if (com.baidu.sofire.b.a.a(file, file2, bytes) != 0) {
                        b.a();
                        if (file2.exists()) {
                            file2.delete();
                        }
                        com.baidu.sofire.b.e.e(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                        if (asc.df(file.getAbsolutePath(), file2.getAbsolutePath(), bytes) != 0) {
                            com.baidu.sofire.b.e.e(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
                            b.a();
                            if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i, 7));
                            }
                            a = false;
                        }
                    }
                } else if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i, 4));
                }
                new StringBuilder().append(a);
                b.a();
                String a2 = p.a(file2);
                new StringBuilder("ds=").append(a).append(", fm=").append(apkInfo.apkMD5).append(", am=").append(a2);
                b.a();
                file.delete();
                if (a) {
                    return apkInfo.apkMD5.equals(a2);
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePluginDownError(ApkInfo apkInfo, File file, int i, List<Integer> list) {
        if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i, 8));
        }
        if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
            if (list != null && list.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                sSetRetrmAlarm = true;
                com.baidu.sofire.b.b.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                sRetryDownoadHostCareApksTimesCount++;
            }
            if (!sMonitorNetworkWhenUpgradeNoNet) {
                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                if (com.baidu.sofire.b.e.e == null) {
                    com.baidu.sofire.b.e.e = new MyReceiver().a();
                } else {
                    com.baidu.sofire.b.e.e.a();
                }
                com.baidu.sofire.b.e.a(this.context, com.baidu.sofire.b.e.e, intentFilter);
                sMonitorNetworkWhenUpgradeNoNet = true;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        e eVar = this.preference;
        long j = eVar.a.getLong("pu_ap_fd", 0L);
        if (j == 0) {
            j = System.currentTimeMillis();
            eVar.d();
        }
        if (currentTimeMillis - j > 86400000) {
            HashMap hashMap = new HashMap();
            if (com.baidu.sofire.b.e.e(this.context)) {
                hashMap.put("0", Integer.valueOf(this.preference.e() + 1));
                hashMap.put("1", Integer.valueOf(this.preference.f()));
            } else {
                hashMap.put("0", Integer.valueOf(this.preference.e()));
                hashMap.put("1", Integer.valueOf(this.preference.f() + 1));
            }
            this.preference.a(0);
            this.preference.b(0);
            this.preference.d();
            com.baidu.sofire.b.e.a(this.context, "1003116", hashMap);
        } else if (com.baidu.sofire.b.e.e(this.context)) {
            this.preference.a(this.preference.e() + 1);
        } else {
            this.preference.b(this.preference.f() + 1);
        }
        b.a();
        file.delete();
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0258 A[Catch: Throwable -> 0x012f, TryCatch #1 {Throwable -> 0x012f, blocks: (B:3:0x0007, B:5:0x002d, B:7:0x0037, B:9:0x003b, B:11:0x004d, B:13:0x005f, B:15:0x0067, B:16:0x006c, B:18:0x00cf, B:20:0x00db, B:22:0x00f9, B:24:0x00fd, B:26:0x010b, B:28:0x012a, B:70:0x0214, B:72:0x0221, B:74:0x022b, B:76:0x022f, B:78:0x0237, B:80:0x0241, B:81:0x024f, B:83:0x0258, B:85:0x0261, B:88:0x0269, B:90:0x0275, B:92:0x0282, B:93:0x0293, B:95:0x02a6, B:97:0x02bb, B:98:0x02c7, B:58:0x01d8, B:62:0x01ec, B:64:0x01fc, B:66:0x0209, B:57:0x01c0), top: B:112:0x0007 }] */
    /* JADX WARN: Type inference failed for: r0v66, types: [com.baidu.sofire.ac.U$2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handlePluginUpgrade(final ApkInfo apkInfo) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        File file;
        try {
            final int k = com.baidu.sofire.b.e.k(this.context);
            new StringBuilder("a=").append(apkInfo);
            b.a();
            final List<Integer> p = this.preference.p();
            if (!p.contains(Integer.valueOf(apkInfo.key)) && !com.baidu.sofire.b.e.b(this.context, apkInfo.network)) {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(k, 3));
                    return;
                }
                return;
            }
            if (!this.tmpDir.exists()) {
                this.tmpDir.mkdir();
            }
            ApkInfo a = this.loadedPluginDB.a(apkInfo.key + 10000000);
            final File file2 = new File(this.tmpDir, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".tmp");
            final File file3 = new File(this.tmpDir, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".zip");
            if (file3.exists()) {
                if (apkInfo.apkMD5.equals(p.a(file3))) {
                    new StringBuilder().append(apkInfo.versionName).append(" exists! ").append(apkInfo.key);
                    b.a();
                    z = false;
                    z2 = true;
                } else {
                    new StringBuilder().append(apkInfo.versionName).append(" exists! but mdf ");
                    z = true;
                    z2 = false;
                    b.a();
                }
            } else {
                z = true;
                z2 = false;
            }
            if (!z) {
                z3 = false;
                z4 = z2;
            } else if (apkInfo.isNextLoad) {
                new Thread() { // from class: com.baidu.sofire.ac.U.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            boolean handlePluginDownload = U.this.handlePluginDownload(apkInfo, file2, file3, k);
                            new StringBuilder().append(handlePluginDownload);
                            b.a();
                            if (!handlePluginDownload) {
                                U.this.handlePluginDownError(apkInfo, file3, k, p);
                                return;
                            }
                            apkInfo.pkgPath = file3.getAbsolutePath();
                            ApkInfo apkInfo2 = new ApkInfo(apkInfo);
                            apkInfo2.key += 10000000;
                            if (!TextUtils.isEmpty(apkInfo2.packageName)) {
                                apkInfo2.packageName = new StringBuilder(apkInfo2.packageName).reverse().toString();
                            }
                            b.a();
                            U.this.loadedPluginDB.a(apkInfo2);
                        } catch (Throwable th) {
                            com.baidu.sofire.b.e.a();
                        }
                    }
                }.start();
                z3 = false;
                z4 = z2;
            } else {
                boolean handlePluginDownload = handlePluginDownload(apkInfo, file2, file3, k);
                new StringBuilder().append(handlePluginDownload);
                b.a();
                boolean z8 = !handlePluginDownload;
                if (a != null) {
                    this.loadedPluginDB.h(a.key + 10000000);
                    if (!TextUtils.isEmpty(a.pkgPath)) {
                        File file4 = new File(a.pkgPath);
                        if (file4.exists()) {
                            file4.delete();
                        }
                    }
                }
                z3 = z8;
                z4 = handlePluginDownload;
            }
            if (z4) {
                new StringBuilder().append(apkInfo.versionName).append(HanziToPinyin.Token.SEPARATOR).append(apkInfo.key);
                b.a();
                pluginUpdate(file3, apkInfo, k);
            } else {
                if (a != null) {
                    b.a();
                    ApkInfo a2 = this.loadedPluginDB.a(apkInfo.key);
                    if (a2 != null) {
                        if (com.baidu.sofire.b.e.b(a.versionName, a2.versionName)) {
                            b.a();
                        } else {
                            z6 = false;
                            if (TextUtils.isEmpty(a.versionName) && a.versionName.equals(apkInfo.versionName)) {
                                b.a();
                                this.loadedPluginDB.a(a.key + 10000000, a.versionName);
                                z7 = false;
                            } else {
                                z7 = z6;
                            }
                            file = null;
                            if (!TextUtils.isEmpty(a.pkgPath)) {
                                file = new File(a.pkgPath);
                            }
                            if (file == null && file.exists() && z7) {
                                if (a.apkMD5.equals(p.a(file))) {
                                    a.key -= 10000000;
                                    if (!TextUtils.isEmpty(a.packageName)) {
                                        a.packageName = new StringBuilder(a.packageName).reverse().toString();
                                    }
                                    new StringBuilder().append(a.versionName);
                                    b.a();
                                    pluginUpdate(file, a, k);
                                    z5 = true;
                                } else {
                                    this.loadedPluginDB.a(a.key + 10000000, a.versionName);
                                    file.delete();
                                    z5 = false;
                                }
                            } else {
                                z5 = false;
                            }
                        }
                    }
                    z6 = true;
                    if (TextUtils.isEmpty(a.versionName)) {
                    }
                    z7 = z6;
                    file = null;
                    if (!TextUtils.isEmpty(a.pkgPath)) {
                    }
                    if (file == null) {
                    }
                    z5 = false;
                } else {
                    z5 = false;
                }
                if (!z5) {
                    b.a();
                    if (g.a(this.context.getApplicationContext()).d(apkInfo.packageName) == null) {
                        this.forHostAPP.a(apkInfo.key, apkInfo.versionName, null);
                    }
                }
            }
            if (z3) {
                handlePluginDownError(apkInfo, file3, k, p);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
            try {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(com.baidu.sofire.b.e.k(this.context), 2));
                }
            } catch (Throwable th2) {
                com.baidu.sofire.b.e.a();
            }
            try {
                List<Integer> p2 = this.preference.p();
                if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                    if (p2.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                        sSetRetrmAlarm = true;
                        com.baidu.sofire.b.b.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                        sRetryDownoadHostCareApksTimesCount++;
                    }
                    if (!sMonitorNetworkWhenUpgradeNoNet) {
                        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        if (com.baidu.sofire.b.e.e == null) {
                            com.baidu.sofire.b.e.e = new MyReceiver().a();
                        } else {
                            com.baidu.sofire.b.e.e.a();
                        }
                        com.baidu.sofire.b.e.a(this.context, com.baidu.sofire.b.e.e, intentFilter);
                        sMonitorNetworkWhenUpgradeNoNet = true;
                    }
                }
            } catch (Throwable th3) {
                com.baidu.sofire.b.e.a();
            }
        }
    }
}
