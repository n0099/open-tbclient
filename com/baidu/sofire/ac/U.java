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
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mobstat.Config;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.MyService;
import com.baidu.sofire.b;
import com.baidu.sofire.c.a;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.core.f;
import com.baidu.sofire.core.i;
import com.baidu.sofire.e;
import com.baidu.sofire.i.n;
import com.baidu.sofire.i.p;
import com.baidu.sofire.i.r;
import com.baidu.sofire.jni.Asc;
import com.baidu.webkit.internal.ABTestConstants;
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
/* loaded from: classes14.dex */
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
    public static Map<String, String> sRealtimeMd5Map;
    private Context context;
    private c forHostAPP;
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
    /* loaded from: classes14.dex */
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
        this.forHostAPP = c.a(context);
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

    public void handleWork(Context context, Intent intent) {
        this.context = context;
        this.loadedPluginDB = a.a(context);
        this.preference = new e(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.forHostAPP = c.a(context);
        this.mFrom = intent.getIntExtra("from", 0);
        b.a();
        start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [657=4, 658=4, 661=4] */
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
                if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3 || this.mOut || System.currentTimeMillis() - sLastCheckTime >= 600000) {
                    if (com.baidu.sofire.i.e.f(this.context)) {
                        sLastCheckTime = System.currentTimeMillis();
                    }
                    Context context = this.context;
                    if (!"tvshield".equals("sofire")) {
                        e eVar = new e(context);
                        long u = eVar.u() * BdKVCache.MILLS_1Hour;
                        new StringBuilder("sjh-alarm gap ").append(eVar.u());
                        b.a();
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
                        long currentTimeMillis = ((System.currentTimeMillis() + u) - 600000) + ((long) (1200000.0d * Math.random()));
                        eVar.c.putLong("npuct", currentTimeMillis);
                        eVar.c.commit();
                        new StringBuilder("b=false,").append(currentTimeMillis).append(",").append(u).append(",").append(System.currentTimeMillis());
                        b.a();
                        alarmManager.cancel(service);
                        alarmManager.set(1, currentTimeMillis, service);
                    }
                    i.a(this.context);
                    if (this.mFrom == 1 || this.mFrom == 3) {
                        sRetryPingTimesCount = 0;
                        sRetryDownoadHostCareApksTimesCount = 0;
                        com.baidu.sofire.i.b.a(this.context, 0, true);
                        sSetRetrmAlarm = false;
                    }
                    if (this.mFrom == 2) {
                        sSetRetrmAlarm = false;
                    }
                    boolean z = "com.baidu.input_huawei".equals(this.context.getPackageName()) ? !new e(this.context).A() : false;
                    if (!com.baidu.sofire.i.e.f(this.context) || z) {
                        if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                            b.a();
                            sMonitorNetworkWhenUpgradeNoNet = true;
                            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                            if (com.baidu.sofire.i.e.g == null) {
                                com.baidu.sofire.i.e.g = new MyReceiver().a();
                            }
                            com.baidu.sofire.i.e.a(this.context, com.baidu.sofire.i.e.g, intentFilter);
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
                    if (com.baidu.sofire.i.e.g != null && (sMonitorNetworkWhenUpgradeNoNet || com.baidu.sofire.i.e.f5254a)) {
                        this.context.getApplicationContext().unregisterReceiver(com.baidu.sofire.i.e.g);
                    }
                    sMonitorNetworkWhenUpgradeNoNet = false;
                    com.baidu.sofire.i.e.f5254a = false;
                    if (this.mFrom != 1) {
                        this.mWholeJson = com.baidu.sofire.i.e.o(this.context);
                    }
                    if (this.mWholeJson == null) {
                        if ((this.mFrom == 1 || this.mFrom == 2 || (this.mFrom == 3 && !sSetRetrmAlarm)) && this.preference.q().size() > 0) {
                            sSetRetrmAlarm = true;
                            com.baidu.sofire.i.b.a(this.context, sRetryPingTimesCount, false);
                            sRetryPingTimesCount++;
                        }
                        IntentFilter intentFilter2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        if (com.baidu.sofire.i.e.g == null) {
                            com.baidu.sofire.i.e.g = new MyReceiver().a();
                        } else {
                            com.baidu.sofire.i.e.g.a();
                        }
                        com.baidu.sofire.i.e.a(this.context, com.baidu.sofire.i.e.g, intentFilter2);
                        sMonitorNetworkWhenUpgradeNoNet = true;
                        if (this.mEndReason == 0) {
                            if (com.baidu.sofire.i.e.d != 0) {
                                this.mEndReason = com.baidu.sofire.i.e.d;
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
                        eVar2.c.putInt("pdcg", this.preference.f5238a.getInt("pdcg", 0) + 1);
                        eVar2.c.commit();
                        e eVar3 = this.preference;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (currentTimeMillis2 == 0) {
                            eVar3.c.putString("pdcgts", "");
                            eVar3.c.commit();
                        } else {
                            String string = eVar3.f5238a.getString("pdcgts", "");
                            if (TextUtils.isEmpty(string)) {
                                str = String.valueOf(currentTimeMillis2);
                            } else if (string.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).length < 20) {
                                str = string + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + String.valueOf(currentTimeMillis2);
                            }
                            new StringBuilder().append(str);
                            b.a();
                            eVar3.c.putString("pdcgts", str);
                            eVar3.c.commit();
                        }
                        sPidRegister = true;
                    }
                    e eVar4 = this.preference;
                    eVar4.c.putInt("rtqe", this.preference.f5238a.getInt("rtqe", 0) + 1);
                    eVar4.c.commit();
                    List<ApkInfo> a2 = this.loadedPluginDB.a();
                    new StringBuilder("a=").append(a2);
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
                            String str2 = optInt + optString;
                            if (sRealtimeMd5Map == null) {
                                sRealtimeMd5Map = new HashMap();
                            }
                            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(optString3)) {
                                sRealtimeMd5Map.put(str2, optString3);
                            }
                            String lowerCase = optString4 != null ? optString4.toLowerCase() : optString4;
                            boolean z2 = optJSONObject2.optInt(Config.OS) == 1;
                            boolean z3 = optJSONObject2.optInt("d") == 1;
                            int optInt2 = optJSONObject2.optInt("r");
                            if (z2) {
                                e eVar5 = this.preference;
                                if (optInt2 > eVar5.f5238a.getInt("opi", 0)) {
                                    eVar5.c.putInt("opi", optInt2);
                                    eVar5.c.commit();
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
                                if (!TextUtils.isEmpty(applicationInfo.className) && applicationInfo.className.startsWith(".")) {
                                    applicationInfo.className = next + applicationInfo.className;
                                }
                                applicationInfo.theme = optJSONObject2.optInt("t");
                                packageInfo.applicationInfo = applicationInfo;
                                JSONArray optJSONArray = optJSONObject2.optJSONArray("a");
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    ArrayList arrayList4 = new ArrayList();
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                                        if (jSONObject != null) {
                                            ActivityInfo activityInfo = new ActivityInfo();
                                            activityInfo.name = jSONObject.optString("n");
                                            if (!TextUtils.isEmpty(activityInfo.name) && activityInfo.name.startsWith(".")) {
                                                activityInfo.name = next + activityInfo.name;
                                            }
                                            activityInfo.packageName = next;
                                            activityInfo.theme = jSONObject.optInt("t");
                                            activityInfo.labelRes = jSONObject.optInt("l");
                                            if (!TextUtils.isEmpty(activityInfo.name)) {
                                                arrayList4.add(activityInfo);
                                            }
                                        }
                                    }
                                    if (arrayList4.size() > 0) {
                                        packageInfo.activities = (ActivityInfo[]) arrayList4.toArray(new ActivityInfo[arrayList4.size()]);
                                    }
                                }
                                ApkInfo apkInfo = new ApkInfo(optInt, next, optString, optString2, optString3);
                                apkInfo.isOnce = z2 ? 1 : 0;
                                apkInfo.priority = optJSONObject2.getInt(Config.PRINCIPAL_PART);
                                apkInfo.isMem = optJSONObject2.optInt("mem") == 1;
                                if (packageInfo != null) {
                                    apkInfo.cloudPkgInfo = packageInfo;
                                }
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("e");
                                if (optJSONObject3 != null) {
                                    int optInt3 = optJSONObject3.optInt("d");
                                    int optInt4 = optJSONObject3.optInt("n");
                                    apkInfo.duration = optInt3;
                                    apkInfo.network = optInt4;
                                }
                                boolean z4 = false;
                                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("ext");
                                if (optJSONObject4 != null) {
                                    z4 = optJSONObject4.optInt("nl", 0) == 1;
                                    new StringBuilder().append(next).append(" nlld ").append(Boolean.toString(z4));
                                    b.a();
                                    if (optJSONObject4.optInt("a") == 1) {
                                        List<Integer> q = this.preference.q();
                                        if (optInt > 0 && !q.contains(Integer.valueOf(optInt))) {
                                            q.add(Integer.valueOf(optInt));
                                            int[] iArr = new int[q.size()];
                                            int i2 = 0;
                                            while (true) {
                                                int i3 = i2;
                                                if (i3 >= q.size()) {
                                                    break;
                                                }
                                                iArr[i3] = q.get(i3).intValue();
                                                i2 = i3 + 1;
                                            }
                                            this.preference.a(iArr);
                                        }
                                    }
                                }
                                boolean z5 = z4;
                                apkInfo.signMD5 = lowerCase;
                                apkInfo.startTime = System.currentTimeMillis();
                                int indexOf = a2.indexOf(apkInfo);
                                new StringBuilder("t=").append(apkInfo).append(", i=").append(indexOf);
                                b.a();
                                ApkInfo apkInfo2 = new ApkInfo(apkInfo);
                                if (!TextUtils.isEmpty(apkInfo.packageName)) {
                                    apkInfo2.packageName = new StringBuilder(apkInfo2.packageName).reverse().toString();
                                }
                                int indexOf2 = a2.indexOf(apkInfo2);
                                if (indexOf2 >= 0) {
                                    a2.remove(indexOf2);
                                }
                                if (indexOf >= 0) {
                                    ApkInfo apkInfo3 = a2.get(indexOf);
                                    if (!com.baidu.sofire.i.e.b(apkInfo.versionName, apkInfo3.versionName) || (c.c != null && ((c.c == null || c.c.contains(Integer.valueOf(apkInfo.key))) && !z5))) {
                                        if (apkInfo3.priority != apkInfo.priority) {
                                            apkInfo3.priority = apkInfo.priority;
                                            this.loadedPluginDB.c(apkInfo.key, apkInfo.priority);
                                        }
                                        arrayList.add(apkInfo3);
                                    } else {
                                        if (apkInfo3.priority != apkInfo.priority) {
                                            this.loadedPluginDB.c(apkInfo.key, apkInfo.priority);
                                        }
                                        if (!this.loadedPluginDB.e(apkInfo3.key)) {
                                            if (z5) {
                                                new StringBuilder().append(apkInfo.versionName).append(" ").append(apkInfo.key).append(" nl is t");
                                                b.a();
                                                apkInfo.isNextLoad = true;
                                            }
                                            arrayList2.add(apkInfo);
                                            if (this.mDownloadPluginsList != null) {
                                                this.mDownloadPluginsList.add(Integer.valueOf(apkInfo.key));
                                            }
                                        }
                                    }
                                    a2.remove(indexOf);
                                } else {
                                    arrayList2.add(apkInfo);
                                    if (this.mDownloadPluginsList != null) {
                                        this.mDownloadPluginsList.add(Integer.valueOf(apkInfo.key));
                                    }
                                }
                            }
                        }
                    }
                    if (c.c != null) {
                        c.c.clear();
                    }
                    new StringBuilder().append(a2);
                    b.a();
                    for (ApkInfo apkInfo4 : a2) {
                        if (!arrayList3.contains(apkInfo4.packageName)) {
                            if (this.mUnloadPluginsList != null) {
                                this.mUnloadPluginsList.add(Integer.valueOf(apkInfo4.key));
                            }
                            this.forHostAPP.a(apkInfo4.packageName);
                        }
                    }
                    com.baidu.sofire.i.e.c(this.context);
                    new StringBuilder().append(arrayList);
                    b.a();
                    f a3 = f.a(this.context.getApplicationContext());
                    final List<Integer> r = this.preference.r();
                    List<Integer> q2 = this.preference.q();
                    for (int i4 = 0; i4 < q2.size(); i4++) {
                        if (!r.contains(q2.get(i4))) {
                            r.add(q2.get(i4));
                        }
                    }
                    ArrayList arrayList5 = new ArrayList();
                    arrayList5.addAll(arrayList);
                    arrayList5.addAll(arrayList2);
                    Collections.sort(arrayList5, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.ac.U.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(ApkInfo apkInfo5, ApkInfo apkInfo6) {
                            if (apkInfo5.priority != -1 || apkInfo6.priority == -1) {
                                if ((apkInfo5.priority == -1 || apkInfo6.priority != -1) && apkInfo5.priority >= apkInfo6.priority) {
                                    if (apkInfo5.priority > apkInfo6.priority) {
                                        return 1;
                                    }
                                    int indexOf3 = (r == null || !r.contains(Integer.valueOf(apkInfo5.key))) ? -1 : r.indexOf(Integer.valueOf(apkInfo5.key));
                                    int indexOf4 = (r == null || !r.contains(Integer.valueOf(apkInfo6.key))) ? -1 : r.indexOf(Integer.valueOf(apkInfo6.key));
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
                        ApkInfo apkInfo5 = (ApkInfo) arrayList5.get(i5);
                        if (arrayList.contains(apkInfo5)) {
                            if (a3.d(apkInfo5.packageName) == null) {
                                boolean z6 = true;
                                if (this.loadedPluginDB.g(apkInfo5.key) == 3) {
                                    b.a();
                                    z6 = false;
                                }
                                if (this.preference.c() && z6) {
                                    File file = new File(this.context.getFilesDir(), ".b");
                                    if (!file.exists()) {
                                        file.mkdir();
                                    }
                                    File file2 = new File(apkInfo5.pkgPath);
                                    File file3 = new File(file, apkInfo5.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo5.versionName);
                                    if (!com.baidu.sofire.i.e.a(file3)) {
                                        com.baidu.sofire.i.e.a(file2, file3);
                                    }
                                    com.baidu.sofire.c.a(this.context, apkInfo5.key, file2, file3);
                                } else {
                                    File file4 = new File(this.context.getFilesDir(), ".b");
                                    if (file4.exists()) {
                                        File file5 = new File(file4, apkInfo5.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo5.versionName);
                                        if (com.baidu.sofire.i.e.a(file5)) {
                                            com.baidu.sofire.c.a(file5);
                                            new StringBuilder().append(file5.getAbsolutePath()).append(" s=").append(file5.delete());
                                            b.a();
                                        }
                                    }
                                }
                                this.forHostAPP.a(apkInfo5.key, apkInfo5.versionName, null);
                            }
                        } else if (arrayList2.contains(apkInfo5) && !this.loadedPluginDB.e(apkInfo5.key)) {
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
            this.preference.g(this.preference.w() + 1);
            if (this.mEndReason != 0) {
                this.preference.a(1, this.mEndReason, this.preference.a(1, this.mEndReason) + 1);
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
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
            hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, b2.values());
            hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Integer.valueOf(this.mEndReason));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, str.replace("\n", "").replace("\t", "").replace("\r", ""));
            }
            hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP, Integer.valueOf(this.mStartNetwork));
            hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Integer.valueOf(com.baidu.sofire.i.e.k(this.context)));
            com.baidu.sofire.i.e.a(this.context, "1003129", hashMap);
        } catch (Throwable th2) {
            com.baidu.sofire.i.e.a();
        }
    }

    private void handleThreadStart() {
        try {
            long j = this.preference.f5238a.getLong("slruct", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (j > 0 && currentTimeMillis - j > 86400000) {
                HashMap hashMap = new HashMap();
                hashMap.put("1", Integer.valueOf(this.preference.v()));
                this.preference.f(0);
                JSONObject jSONObject = new JSONObject();
                for (int i = 1; i <= 6; i++) {
                    jSONObject.put(String.valueOf(i), this.preference.a(0, i));
                    this.preference.a(0, i, 0);
                }
                hashMap.put("2", jSONObject);
                hashMap.put("3", Integer.valueOf(this.preference.w()));
                this.preference.g(0);
                JSONObject jSONObject2 = new JSONObject();
                for (int i2 = 1; i2 <= 11; i2++) {
                    jSONObject2.put(String.valueOf(i2), this.preference.a(1, i2));
                    this.preference.a(1, i2, 0);
                }
                hashMap.put("4", jSONObject2);
                com.baidu.sofire.i.e.a(this.context, "1003128", hashMap);
                this.preference.a(currentTimeMillis);
            } else if (j == 0) {
                this.preference.a(currentTimeMillis);
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
                com.baidu.sofire.i.e.a();
            }
            com.baidu.sofire.i.e.a();
        }
        try {
            this.mStartKeyMap = this.loadedPluginDB.b();
            this.preference.f(this.preference.v() + 1);
            if (this.mFrom != 0) {
                this.preference.a(0, this.mFrom, this.preference.a(0, this.mFrom) + 1);
            }
            this.mStartNetwork = com.baidu.sofire.i.e.k(this.context);
        } catch (Throwable th3) {
            com.baidu.sofire.i.e.a();
        }
    }

    private void pluginUpdate(File file, ApkInfo apkInfo, int i) {
        com.baidu.sofire.i.e.a(file.getAbsolutePath(), true);
        if (this.preference.c()) {
            File file2 = new File(this.context.getFilesDir(), ".b");
            if (!file2.exists()) {
                file2.mkdir();
            }
            File file3 = new File(file2, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
            com.baidu.sofire.i.e.a(file, file3);
            com.baidu.sofire.c.a(this.context, apkInfo.key, file, file3);
        }
        apkInfo.pkgPath = file.getAbsolutePath();
        String str = "before update, time=" + System.currentTimeMillis() + ", downloadAPK path:" + file.getAbsolutePath() + ", exists=" + file.exists() + ", canRead=" + file.canRead() + ", isFile=" + file.isFile() + ",length" + file.length();
        StringBuilder sb = new StringBuilder("before update, time=" + System.currentTimeMillis() + ", ");
        ApkInfo a2 = this.loadedPluginDB.a(apkInfo.key);
        if (a2 == null) {
            sb.append("apkInDB == null");
        } else {
            File file4 = new File(a2.pkgPath);
            sb.append("origAPK path:" + file4.getAbsolutePath() + ", exists=" + file4.exists() + ", canRead=" + file4.canRead() + ", isFile=" + file4.isFile() + ",length" + file4.length());
        }
        boolean a3 = this.forHostAPP.a(apkInfo, str);
        new StringBuilder().append(apkInfo.packageName).append(" s=").append(a3);
        b.a();
        this.loadedPluginDB.a(apkInfo.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, apkInfo.versionName);
        if (!a3) {
            if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i, 5));
                return;
            }
            return;
        }
        int g = this.loadedPluginDB.g(apkInfo.key);
        new StringBuilder("new plugin now loadStatus :").append(apkInfo.key).append(" ").append(g);
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
        boolean a2;
        try {
            if (file.exists()) {
                file.delete();
            }
            if (!"com.baidu.input_huawei".equals(this.context.getPackageName()) || this.preference.A()) {
                if (r.a(this.context)) {
                    a2 = new r(this.context).a(apkInfo.downloadURL, file);
                } else {
                    a2 = new n(this.context).a(apkInfo.downloadURL, file);
                }
                b.a();
                if (a2) {
                    if (file2.exists()) {
                        b.a();
                        file2.delete();
                    }
                    Asc asc = new Asc();
                    byte[] bytes = apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes("utf-8");
                    com.baidu.sofire.i.e.e(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
                    if (com.baidu.sofire.i.a.a(file, file2, bytes) != 0) {
                        b.a();
                        if (file2.exists()) {
                            file2.delete();
                        }
                        com.baidu.sofire.i.e.e(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                        if (asc.df(file.getAbsolutePath(), file2.getAbsolutePath(), bytes) != 0) {
                            com.baidu.sofire.i.e.e(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
                            b.a();
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
                b.a();
                String a3 = p.a(file2);
                new StringBuilder("ds=").append(a2).append(", fm=").append(apkInfo.apkMD5).append(", am=").append(a3);
                b.a();
                file.delete();
                if (a2) {
                    return apkInfo.apkMD5.equals(a3);
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
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
                com.baidu.sofire.i.b.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                sRetryDownoadHostCareApksTimesCount++;
            }
            if (!sMonitorNetworkWhenUpgradeNoNet) {
                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                if (com.baidu.sofire.i.e.g == null) {
                    com.baidu.sofire.i.e.g = new MyReceiver().a();
                } else {
                    com.baidu.sofire.i.e.g.a();
                }
                com.baidu.sofire.i.e.a(this.context, com.baidu.sofire.i.e.g, intentFilter);
                sMonitorNetworkWhenUpgradeNoNet = true;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        e eVar = this.preference;
        long j = eVar.f5238a.getLong("pu_ap_fd", 0L);
        if (j == 0) {
            j = System.currentTimeMillis();
            eVar.d();
        }
        if (currentTimeMillis - j > 86400000) {
            HashMap hashMap = new HashMap();
            if (com.baidu.sofire.i.e.e(this.context)) {
                hashMap.put("0", Integer.valueOf(this.preference.e() + 1));
                hashMap.put("1", Integer.valueOf(this.preference.f()));
            } else {
                hashMap.put("0", Integer.valueOf(this.preference.e()));
                hashMap.put("1", Integer.valueOf(this.preference.f() + 1));
            }
            this.preference.a(0);
            this.preference.b(0);
            this.preference.d();
            com.baidu.sofire.i.e.a(this.context, "1003116", hashMap);
        } else if (com.baidu.sofire.i.e.e(this.context)) {
            this.preference.a(this.preference.e() + 1);
        } else {
            this.preference.b(this.preference.f() + 1);
        }
        b.a();
        file.delete();
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f9 A[Catch: Throwable -> 0x012f, TryCatch #1 {Throwable -> 0x012f, blocks: (B:3:0x0007, B:5:0x002d, B:7:0x0037, B:9:0x003b, B:11:0x004d, B:13:0x005f, B:15:0x0067, B:16:0x006c, B:18:0x00cf, B:20:0x00db, B:22:0x00f9, B:24:0x00fd, B:26:0x010b, B:28:0x012a, B:71:0x0213, B:73:0x0220, B:75:0x022a, B:77:0x022e, B:79:0x0236, B:81:0x0240, B:82:0x024e, B:84:0x0257, B:86:0x0260, B:89:0x0268, B:91:0x0274, B:93:0x0281, B:94:0x0292, B:96:0x02a5, B:98:0x02ba, B:99:0x02c6, B:59:0x01d8, B:63:0x01ec, B:65:0x01fc, B:67:0x0209, B:57:0x01c0), top: B:112:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010b A[Catch: Throwable -> 0x012f, TryCatch #1 {Throwable -> 0x012f, blocks: (B:3:0x0007, B:5:0x002d, B:7:0x0037, B:9:0x003b, B:11:0x004d, B:13:0x005f, B:15:0x0067, B:16:0x006c, B:18:0x00cf, B:20:0x00db, B:22:0x00f9, B:24:0x00fd, B:26:0x010b, B:28:0x012a, B:71:0x0213, B:73:0x0220, B:75:0x022a, B:77:0x022e, B:79:0x0236, B:81:0x0240, B:82:0x024e, B:84:0x0257, B:86:0x0260, B:89:0x0268, B:91:0x0274, B:93:0x0281, B:94:0x0292, B:96:0x02a5, B:98:0x02ba, B:99:0x02c6, B:59:0x01d8, B:63:0x01ec, B:65:0x01fc, B:67:0x0209, B:57:0x01c0), top: B:112:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012a A[Catch: Throwable -> 0x012f, TRY_LEAVE, TryCatch #1 {Throwable -> 0x012f, blocks: (B:3:0x0007, B:5:0x002d, B:7:0x0037, B:9:0x003b, B:11:0x004d, B:13:0x005f, B:15:0x0067, B:16:0x006c, B:18:0x00cf, B:20:0x00db, B:22:0x00f9, B:24:0x00fd, B:26:0x010b, B:28:0x012a, B:71:0x0213, B:73:0x0220, B:75:0x022a, B:77:0x022e, B:79:0x0236, B:81:0x0240, B:82:0x024e, B:84:0x0257, B:86:0x0260, B:89:0x0268, B:91:0x0274, B:93:0x0281, B:94:0x0292, B:96:0x02a5, B:98:0x02ba, B:99:0x02c6, B:59:0x01d8, B:63:0x01ec, B:65:0x01fc, B:67:0x0209, B:57:0x01c0), top: B:112:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0257 A[Catch: Throwable -> 0x012f, TryCatch #1 {Throwable -> 0x012f, blocks: (B:3:0x0007, B:5:0x002d, B:7:0x0037, B:9:0x003b, B:11:0x004d, B:13:0x005f, B:15:0x0067, B:16:0x006c, B:18:0x00cf, B:20:0x00db, B:22:0x00f9, B:24:0x00fd, B:26:0x010b, B:28:0x012a, B:71:0x0213, B:73:0x0220, B:75:0x022a, B:77:0x022e, B:79:0x0236, B:81:0x0240, B:82:0x024e, B:84:0x0257, B:86:0x0260, B:89:0x0268, B:91:0x0274, B:93:0x0281, B:94:0x0292, B:96:0x02a5, B:98:0x02ba, B:99:0x02c6, B:59:0x01d8, B:63:0x01ec, B:65:0x01fc, B:67:0x0209, B:57:0x01c0), top: B:112:0x0007 }] */
    /* JADX WARN: Type inference failed for: r0v63, types: [com.baidu.sofire.ac.U$2] */
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
            final int k = com.baidu.sofire.i.e.k(this.context);
            new StringBuilder("a=").append(apkInfo);
            b.a();
            final List<Integer> q = this.preference.q();
            if (!q.contains(Integer.valueOf(apkInfo.key)) && !com.baidu.sofire.i.e.b(this.context, apkInfo.network)) {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(k, 3));
                    return;
                }
                return;
            }
            if (!this.tmpDir.exists()) {
                this.tmpDir.mkdir();
            }
            ApkInfo a2 = this.loadedPluginDB.a(apkInfo.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT);
            final File file2 = new File(this.tmpDir, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".tmp");
            final File file3 = new File(this.tmpDir, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".zip");
            if (file3.exists()) {
                if (apkInfo.apkMD5.equals(p.a(file3))) {
                    new StringBuilder().append(apkInfo.versionName).append(" exists! ").append(apkInfo.key);
                    b.a();
                    z = false;
                    z2 = true;
                    if (z) {
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
                                        U.this.handlePluginDownError(apkInfo, file3, k, q);
                                        return;
                                    }
                                    apkInfo.pkgPath = file3.getAbsolutePath();
                                    ApkInfo apkInfo2 = new ApkInfo(apkInfo);
                                    apkInfo2.key += ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT;
                                    if (!TextUtils.isEmpty(apkInfo2.packageName)) {
                                        apkInfo2.packageName = new StringBuilder(apkInfo2.packageName).reverse().toString();
                                    }
                                    b.a();
                                    U.this.loadedPluginDB.a(apkInfo2);
                                } catch (Throwable th) {
                                    com.baidu.sofire.i.e.a();
                                }
                            }
                        }.start();
                        z3 = false;
                        z4 = z2;
                    } else {
                        z4 = handlePluginDownload(apkInfo, file2, file3, k);
                        new StringBuilder().append(z4);
                        b.a();
                        boolean z8 = !z4;
                        if (a2 != null) {
                            this.loadedPluginDB.h(a2.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT);
                            if (!TextUtils.isEmpty(a2.pkgPath)) {
                                File file4 = new File(a2.pkgPath);
                                if (file4.exists()) {
                                    file4.delete();
                                }
                            }
                        }
                        z3 = z8;
                    }
                    if (!z4) {
                        new StringBuilder().append(apkInfo.versionName).append(" ").append(apkInfo.key);
                        b.a();
                        pluginUpdate(file3, apkInfo, k);
                    } else {
                        if (a2 != null) {
                            b.a();
                            ApkInfo a3 = this.loadedPluginDB.a(apkInfo.key);
                            if (a3 != null) {
                                if (com.baidu.sofire.i.e.b(a2.versionName, a3.versionName)) {
                                    b.a();
                                } else {
                                    z6 = false;
                                    if (TextUtils.isEmpty(a2.versionName) && a2.versionName.equals(apkInfo.versionName)) {
                                        b.a();
                                        this.loadedPluginDB.a(a2.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, a2.versionName);
                                        z7 = false;
                                    } else {
                                        z7 = z6;
                                    }
                                    file = null;
                                    if (!TextUtils.isEmpty(a2.pkgPath)) {
                                        file = new File(a2.pkgPath);
                                    }
                                    if (file == null && file.exists() && z7) {
                                        if (a2.apkMD5.equals(p.a(file))) {
                                            a2.key -= ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT;
                                            if (!TextUtils.isEmpty(a2.packageName)) {
                                                a2.packageName = new StringBuilder(a2.packageName).reverse().toString();
                                            }
                                            new StringBuilder().append(a2.versionName);
                                            b.a();
                                            pluginUpdate(file, a2, k);
                                            z5 = true;
                                        } else {
                                            this.loadedPluginDB.a(a2.key + ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, a2.versionName);
                                            file.delete();
                                            z5 = false;
                                        }
                                    } else {
                                        z5 = false;
                                    }
                                }
                            }
                            z6 = true;
                            if (TextUtils.isEmpty(a2.versionName)) {
                            }
                            z7 = z6;
                            file = null;
                            if (!TextUtils.isEmpty(a2.pkgPath)) {
                            }
                            if (file == null) {
                            }
                            z5 = false;
                        } else {
                            z5 = false;
                        }
                        if (!z5) {
                            b.a();
                            if (f.a(this.context.getApplicationContext()).d(apkInfo.packageName) == null) {
                                this.forHostAPP.a(apkInfo.key, apkInfo.versionName, null);
                            }
                        }
                    }
                    if (!z3) {
                        handlePluginDownError(apkInfo, file3, k, q);
                        return;
                    }
                    return;
                }
                new StringBuilder().append(apkInfo.versionName).append(" exists! but mdf ");
                b.a();
            }
            z = true;
            z2 = false;
            if (z) {
            }
            if (!z4) {
            }
            if (!z3) {
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            try {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(com.baidu.sofire.i.e.k(this.context), 2));
                }
            } catch (Throwable th2) {
                com.baidu.sofire.i.e.a();
            }
            try {
                List<Integer> q2 = this.preference.q();
                if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                    if (q2.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                        sSetRetrmAlarm = true;
                        com.baidu.sofire.i.b.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                        sRetryDownoadHostCareApksTimesCount++;
                    }
                    if (!sMonitorNetworkWhenUpgradeNoNet) {
                        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        if (com.baidu.sofire.i.e.g == null) {
                            com.baidu.sofire.i.e.g = new MyReceiver().a();
                        } else {
                            com.baidu.sofire.i.e.g.a();
                        }
                        com.baidu.sofire.i.e.a(this.context, com.baidu.sofire.i.e.g, intentFilter);
                        sMonitorNetworkWhenUpgradeNoNet = true;
                    }
                }
            } catch (Throwable th3) {
                com.baidu.sofire.i.e.a();
            }
        }
    }
}
