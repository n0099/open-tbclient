package com.baidu.sofire.ac;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.a.a;
import com.baidu.sofire.b;
import com.baidu.sofire.b.g;
import com.baidu.sofire.b.h;
import com.baidu.sofire.b.m;
import com.baidu.sofire.b.o;
import com.baidu.sofire.c;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.d;
import com.baidu.sofire.e;
import com.baidu.sofire.jni.Asc;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.security.PublicKey;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [819=5, 820=5, 823=5] */
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
                    if (!com.baidu.sofire.b.e.f(this.context)) {
                        if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                            b.a();
                            sMonitorNetworkWhenUpgradeNoNet = true;
                            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                            if (com.baidu.sofire.b.e.d == null) {
                                com.baidu.sofire.b.e.d = new MyReceiver().a();
                            }
                            this.context.getApplicationContext().registerReceiver(com.baidu.sofire.b.e.d, intentFilter);
                        }
                        if (this.mEndReason == 0) {
                            this.mEndReason = 3;
                        }
                        throw new NetworkErrorException("no internet");
                    }
                    sLastCheckTime = System.currentTimeMillis();
                    if (com.baidu.sofire.b.e.d != null && (sMonitorNetworkWhenUpgradeNoNet || com.baidu.sofire.b.e.a)) {
                        this.context.getApplicationContext().unregisterReceiver(com.baidu.sofire.b.e.d);
                    }
                    sMonitorNetworkWhenUpgradeNoNet = false;
                    com.baidu.sofire.b.e.a = false;
                    String str2 = com.baidu.sofire.b.e.b() + "opmon";
                    if (TextUtils.isEmpty(new m(this.context, (byte) 0).a(str2)) && TextUtils.isEmpty(new m(this.context, (byte) 0).a(str2))) {
                        if ((this.mFrom == 1 || this.mFrom == 2 || (this.mFrom == 3 && !sSetRetrmAlarm)) && this.preference.o().size() > 0) {
                            sSetRetrmAlarm = true;
                            com.baidu.sofire.b.b.a(this.context, sRetryPingTimesCount, false);
                            sRetryPingTimesCount++;
                        }
                        IntentFilter intentFilter2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        if (com.baidu.sofire.b.e.d == null) {
                            com.baidu.sofire.b.e.d = new MyReceiver().a();
                        } else {
                            com.baidu.sofire.b.e.d.a();
                        }
                        this.context.getApplicationContext().registerReceiver(com.baidu.sofire.b.e.d, intentFilter2);
                        sMonitorNetworkWhenUpgradeNoNet = true;
                        if (this.mEndReason == 0) {
                            this.mEndReason = 4;
                        }
                        throw new NetworkErrorException("ping faild");
                    }
                    sRetryPingTimesCount = 0;
                    if (System.currentTimeMillis() - this.preference.a.getLong("plla_tm", 0L) > this.preference.a.getInt("appplg_te", 360) * 60 * 1000) {
                        boolean z = false;
                        String str3 = com.baidu.sofire.b.e.b() + "p/1/stt";
                        new StringBuilder().append(str3);
                        b.a();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(Config.APP_VERSION_CODE, "b");
                        String a3 = h.a(this.context, str3, jSONObject.toString(), true);
                        b.a();
                        if (a3 != null) {
                            JSONObject jSONObject2 = new JSONObject(a3);
                            int optInt = jSONObject2.optInt("app");
                            new StringBuilder("App-").append(Integer.toString(optInt));
                            b.a();
                            e eVar = this.preference;
                            eVar.c.putInt("appinv_t", optInt);
                            eVar.c.commit();
                            int optInt2 = jSONObject2.optInt("js");
                            new StringBuilder("JS-").append(Integer.toString(optInt2));
                            b.a();
                            e eVar2 = this.preference;
                            eVar2.c.putInt("appinv_js", optInt2);
                            eVar2.c.commit();
                            int optInt3 = jSONObject2.optInt(Config.APP_VERSION_CODE, 1);
                            new StringBuilder("get key-").append(Integer.toString(optInt3));
                            b.a();
                            e eVar3 = this.preference;
                            eVar3.c.putInt("appinv_ky", optInt3);
                            eVar3.c.commit();
                            int optInt4 = jSONObject2.optInt("pi", 360);
                            new StringBuilder("net Interval-").append(Integer.toString(optInt4));
                            b.a();
                            e eVar4 = this.preference;
                            eVar4.c.putInt("appplg_te", optInt4);
                            eVar4.c.commit();
                            int optInt5 = jSONObject2.optInt(Config.FEED_LIST_PART, 1);
                            if (optInt5 > 0) {
                                int round = (int) Math.round(24.0d / optInt5);
                                if (round > 0) {
                                    this.preference.e(round);
                                } else {
                                    this.preference.e(24);
                                }
                            }
                            int optInt6 = jSONObject2.optInt("alm", 24);
                            if (optInt6 > 0) {
                                this.preference.d(optInt6);
                            } else {
                                this.preference.d(24);
                            }
                            z = true;
                        }
                        if (z) {
                            e eVar5 = this.preference;
                            eVar5.c.putLong("plla_tm", System.currentTimeMillis());
                            eVar5.c.commit();
                        }
                    }
                    boolean z2 = false;
                    String[] h = com.baidu.sofire.b.e.h(this.context);
                    if (this.preference.a.getInt("appinv_ky", 1) == 1 && (h == null || h.length != 2 || TextUtils.isEmpty(h[0]) || TextUtils.isEmpty(h[1]))) {
                        z2 = true;
                    }
                    if (!z2 || h.a(this.context)) {
                        this.forHostAPP.b(this.context);
                        if (TextUtils.isEmpty(this.preference.d())) {
                            com.baidu.sofire.b.e.p(this.context);
                            this.preference.d();
                        }
                        b.a();
                        if (this.preference.a.getInt("appinv_t", 0) == 1) {
                            com.baidu.sofire.b.e.q(this.context);
                        }
                        this.loadedPluginDB.d();
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        JSONObject jSONObject5 = new JSONObject();
                        String packageName = this.context.getPackageName();
                        jSONObject5.put("pk", packageName);
                        jSONObject4.put("pk", packageName);
                        jSONObject4.put("dm", Build.MODEL);
                        jSONObject5.put("dm", Build.MODEL);
                        jSONObject4.put("cuid", g.a(this.context));
                        jSONObject4.put("al", String.valueOf(Build.VERSION.SDK_INT));
                        jSONObject5.put("al", String.valueOf(Build.VERSION.SDK_INT));
                        jSONObject4.put(Config.EVENT_PART, "3.2.2.1");
                        PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(packageName, 64);
                        if (packageInfo == null) {
                            if (this.mEndReason == 0) {
                                this.mEndReason = 6;
                            }
                            throw new NetworkErrorException("hostPkgInfo is null");
                        }
                        jSONObject4.put("av", packageInfo.versionName);
                        jSONObject5.put("av", packageInfo.versionName);
                        PublicKey a4 = com.baidu.sofire.b.e.a(packageInfo, packageInfo.applicationInfo.sourceDir);
                        if (a4 != null) {
                            byte[] encoded = a4.getEncoded();
                            if (encoded != null) {
                                com.baidu.sofire.b.e.a(this.context, encoded);
                                String a5 = o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                                jSONObject4.put("sm", a5);
                                jSONObject5.put("sm", a5);
                            } else {
                                jSONObject4.put("sm", "");
                                jSONObject5.put("sm", "");
                            }
                        }
                        jSONObject4.put("or", this.preference.a.getInt("opi", 0));
                        jSONObject4.put(Config.PLATFORM_TYPE, this.preference.e());
                        jSONObject3.put(Config.DEVICE_PART, jSONObject4);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject5);
                        HashMap hashMap = new HashMap();
                        hashMap.putAll(com.baidu.sofire.b.e.e);
                        for (String str4 : hashMap.keySet()) {
                            JSONObject jSONObject6 = new JSONObject((String) hashMap.get(str4));
                            if (jSONObject6 != null) {
                                jSONArray.put(jSONObject6);
                            }
                        }
                        jSONObject3.put("host_apps", jSONArray);
                        String jSONObject7 = jSONObject3.toString();
                        b.a();
                        String str5 = com.baidu.sofire.b.e.b() + "p/1/pls";
                        if (!sPidRegister) {
                            e eVar6 = this.preference;
                            eVar6.c.putInt("pdcg", this.preference.a.getInt("pdcg", 0) + 1);
                            eVar6.c.commit();
                            e eVar7 = this.preference;
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis == 0) {
                                eVar7.c.putString("pdcgts", "");
                                eVar7.c.commit();
                            } else {
                                String string = eVar7.a.getString("pdcgts", "");
                                if (TextUtils.isEmpty(string)) {
                                    str = String.valueOf(currentTimeMillis);
                                } else if (string.split("_").length < 20) {
                                    str = string + "_" + String.valueOf(currentTimeMillis);
                                }
                                new StringBuilder().append(str);
                                b.a();
                                eVar7.c.putString("pdcgts", str);
                                eVar7.c.commit();
                            }
                            sPidRegister = true;
                        }
                        e eVar8 = this.preference;
                        eVar8.c.putInt("rtqe", this.preference.a.getInt("rtqe", 0) + 1);
                        eVar8.c.commit();
                        String a6 = h.a(this.context, str5, jSONObject7, true);
                        new StringBuilder().append(a6);
                        b.a();
                        JSONObject jSONObject8 = new JSONObject(a6);
                        if (jSONObject8 == null) {
                            if (this.mEndReason == 0) {
                                this.mEndReason = 9;
                            }
                            throw new NetworkErrorException("response json is null");
                        }
                        List<ApkInfo> a7 = this.loadedPluginDB.a();
                        new StringBuilder("a=").append(a7);
                        b.a();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        JSONArray optJSONArray = jSONObject8.optJSONArray("product");
                        long optLong = jSONObject8.optLong(Config.PLATFORM_TYPE);
                        if (optJSONArray != null && optJSONArray.length() > 0 && optLong > 0) {
                            this.preference.a(optJSONArray.toString(), optLong);
                            com.baidu.sofire.b.e.i(this.context);
                        }
                        JSONObject optJSONObject = jSONObject8.optJSONObject("plugin");
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
                                int optInt7 = optJSONObject2.optInt("l");
                                String optString = optJSONObject2.optString("v");
                                if (this.mCloudKeyMap != null) {
                                    this.mCloudKeyMap.put(Integer.valueOf(optInt7), optString);
                                }
                                String optString2 = optJSONObject2.optString("u");
                                String optString3 = optJSONObject2.optString(Config.MODEL);
                                String optString4 = optJSONObject2.optString("sm");
                                if (optString3 != null) {
                                    optString3 = optString3.toLowerCase();
                                }
                                String lowerCase = optString4 != null ? optString4.toLowerCase() : optString4;
                                boolean z3 = optJSONObject2.optInt(Config.OS) == 1;
                                boolean z4 = optJSONObject2.optInt("d") == 1;
                                int optInt8 = optJSONObject2.optInt("r");
                                if (z3) {
                                    e eVar9 = this.preference;
                                    if (optInt8 > eVar9.a.getInt("opi", 0)) {
                                        eVar9.c.putInt("opi", optInt8);
                                        eVar9.c.commit();
                                    }
                                }
                                if (z3 && z4) {
                                    arrayList3.add(next);
                                } else {
                                    PackageInfo packageInfo2 = new PackageInfo();
                                    packageInfo2.packageName = optJSONObject2.optString("p");
                                    packageInfo2.versionName = optString;
                                    ApplicationInfo applicationInfo = new ApplicationInfo();
                                    applicationInfo.className = optJSONObject2.optString("n");
                                    if (!TextUtils.isEmpty(applicationInfo.className) && applicationInfo.className.startsWith(".")) {
                                        applicationInfo.className = next + applicationInfo.className;
                                    }
                                    applicationInfo.theme = optJSONObject2.optInt("t");
                                    packageInfo2.applicationInfo = applicationInfo;
                                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray(Config.APP_VERSION_CODE);
                                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                        ArrayList arrayList4 = new ArrayList();
                                        for (int i = 0; i < optJSONArray2.length(); i++) {
                                            JSONObject jSONObject9 = optJSONArray2.getJSONObject(i);
                                            if (jSONObject9 != null) {
                                                ActivityInfo activityInfo = new ActivityInfo();
                                                activityInfo.name = jSONObject9.optString("n");
                                                if (!TextUtils.isEmpty(activityInfo.name) && activityInfo.name.startsWith(".")) {
                                                    activityInfo.name = next + activityInfo.name;
                                                }
                                                activityInfo.packageName = next;
                                                activityInfo.theme = jSONObject9.optInt("t");
                                                activityInfo.labelRes = jSONObject9.optInt("l");
                                                if (!TextUtils.isEmpty(activityInfo.name)) {
                                                    arrayList4.add(activityInfo);
                                                }
                                            }
                                        }
                                        if (arrayList4.size() > 0) {
                                            packageInfo2.activities = (ActivityInfo[]) arrayList4.toArray(new ActivityInfo[arrayList4.size()]);
                                        }
                                    }
                                    ApkInfo apkInfo2 = new ApkInfo(optInt7, next, optString, optString2, optString3);
                                    apkInfo2.isOnce = z3 ? 1 : 0;
                                    apkInfo2.priority = optJSONObject2.getInt(Config.PRINCIPAL_PART);
                                    apkInfo2.isMem = optJSONObject2.optInt("mem") == 1;
                                    if (packageInfo2 != null) {
                                        apkInfo2.cloudPkgInfo = packageInfo2;
                                    }
                                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("e");
                                    if (optJSONObject3 != null) {
                                        int optInt9 = optJSONObject3.optInt("d");
                                        int optInt10 = optJSONObject3.optInt("n");
                                        apkInfo2.duration = optInt9;
                                        apkInfo2.network = optInt10;
                                    }
                                    boolean z5 = false;
                                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("ext");
                                    if (optJSONObject4 != null) {
                                        z5 = optJSONObject4.optInt("nl", 0) == 1;
                                        new StringBuilder().append(next).append(" nlld ").append(Boolean.toString(z5));
                                        b.a();
                                        if (optJSONObject4.optInt(Config.APP_VERSION_CODE) == 1) {
                                            List<Integer> o = this.preference.o();
                                            if (optInt7 > 0 && !o.contains(Integer.valueOf(optInt7))) {
                                                o.add(Integer.valueOf(optInt7));
                                                int[] iArr = new int[o.size()];
                                                int i2 = 0;
                                                while (true) {
                                                    int i3 = i2;
                                                    if (i3 >= o.size()) {
                                                        break;
                                                    }
                                                    iArr[i3] = o.get(i3).intValue();
                                                    i2 = i3 + 1;
                                                }
                                                this.preference.a(iArr);
                                            }
                                        }
                                    }
                                    boolean z6 = z5;
                                    apkInfo2.signMD5 = lowerCase;
                                    apkInfo2.startTime = System.currentTimeMillis();
                                    int indexOf = a7.indexOf(apkInfo2);
                                    new StringBuilder("t=").append(apkInfo2).append(", i=").append(indexOf);
                                    b.a();
                                    ApkInfo apkInfo3 = new ApkInfo(apkInfo2);
                                    if (!TextUtils.isEmpty(apkInfo2.packageName)) {
                                        apkInfo3.packageName = new StringBuilder(apkInfo3.packageName).reverse().toString();
                                    }
                                    int indexOf2 = a7.indexOf(apkInfo3);
                                    if (indexOf2 >= 0) {
                                        a7.remove(indexOf2);
                                    }
                                    if (indexOf >= 0) {
                                        ApkInfo apkInfo4 = a7.get(indexOf);
                                        if (!com.baidu.sofire.b.e.c(apkInfo2.versionName, apkInfo4.versionName) || (d.c != null && ((d.c == null || d.c.contains(Integer.valueOf(apkInfo2.key))) && !z6))) {
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
                                                if (z6) {
                                                    new StringBuilder().append(apkInfo2.versionName).append(" ").append(apkInfo2.key).append(" nl is t");
                                                    b.a();
                                                    apkInfo2.isNextLoad = true;
                                                }
                                                arrayList2.add(apkInfo2);
                                                if (this.mDownloadPluginsList != null) {
                                                    this.mDownloadPluginsList.add(Integer.valueOf(apkInfo2.key));
                                                }
                                            }
                                        }
                                        a7.remove(indexOf);
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
                        new StringBuilder().append(a7);
                        b.a();
                        for (ApkInfo apkInfo5 : a7) {
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
                        com.baidu.sofire.core.g a8 = com.baidu.sofire.core.g.a(this.context.getApplicationContext());
                        final List<Integer> p = this.preference.p();
                        List<Integer> o2 = this.preference.o();
                        for (int i4 = 0; i4 < o2.size(); i4++) {
                            if (!p.contains(o2.get(i4))) {
                                p.add(o2.get(i4));
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
                                        int indexOf3 = (p == null || !p.contains(Integer.valueOf(apkInfo6.key))) ? -1 : p.indexOf(Integer.valueOf(apkInfo6.key));
                                        int indexOf4 = (p == null || !p.contains(Integer.valueOf(apkInfo7.key))) ? -1 : p.indexOf(Integer.valueOf(apkInfo7.key));
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
                                if (a8.d(apkInfo6.packageName) == null) {
                                    boolean z7 = true;
                                    if (this.loadedPluginDB.g(apkInfo6.key) == 3) {
                                        b.a();
                                        z7 = false;
                                    }
                                    if (this.preference.c() && z7) {
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
                        b.a();
                        if (this.mOut && sOutGoing) {
                            sOutGoing = false;
                        }
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
            this.preference.g(this.preference.t() + 1);
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
                hashMap.put(com.tencent.connect.common.Constants.VIA_SHARE_TYPE_INFO, this.mUnloadPluginsList);
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
            hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Integer.valueOf(com.baidu.sofire.b.e.m(this.context)));
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
                hashMap.put("1", Integer.valueOf(this.preference.s()));
                this.preference.f(0);
                JSONObject jSONObject = new JSONObject();
                for (int i = 1; i <= 6; i++) {
                    jSONObject.put(String.valueOf(i), this.preference.a(0, i));
                    this.preference.a(0, i, 0);
                }
                hashMap.put("2", jSONObject);
                hashMap.put("3", Integer.valueOf(this.preference.t()));
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
            this.preference.f(this.preference.s() + 1);
            if (this.mFrom != 0) {
                this.preference.a(0, this.mFrom, this.preference.a(0, this.mFrom) + 1);
            }
            this.mStartNetwork = com.baidu.sofire.b.e.m(this.context);
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
        try {
            if (file.exists()) {
                file.delete();
            }
            boolean a = new m(this.context).a(apkInfo.downloadURL, file);
            b.a();
            if (a) {
                if (file2.exists()) {
                    b.a();
                    file2.delete();
                }
                Asc asc = new Asc();
                byte[] bytes = apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes("utf-8");
                com.baidu.sofire.b.e.f(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
                if (com.baidu.sofire.b.a.a(file, file2, bytes) != 0) {
                    b.a();
                    if (file2.exists()) {
                        file2.delete();
                    }
                    com.baidu.sofire.b.e.f(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                    if (asc.df(file.getAbsolutePath(), file2.getAbsolutePath(), bytes) != 0) {
                        com.baidu.sofire.b.e.f(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
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
            String a2 = o.a(file2);
            new StringBuilder("ds=").append(a).append(", fm=").append(apkInfo.apkMD5).append(", am=").append(a2);
            b.a();
            file.delete();
            if (a) {
                return apkInfo.apkMD5.equals(a2);
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
                if (com.baidu.sofire.b.e.d == null) {
                    com.baidu.sofire.b.e.d = new MyReceiver().a();
                } else {
                    com.baidu.sofire.b.e.d.a();
                }
                this.context.getApplicationContext().registerReceiver(com.baidu.sofire.b.e.d, intentFilter);
                sMonitorNetworkWhenUpgradeNoNet = true;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        e eVar = this.preference;
        long j = eVar.a.getLong("pu_ap_fd", 0L);
        if (j == 0) {
            j = System.currentTimeMillis();
            eVar.f();
        }
        if (currentTimeMillis - j > 86400000) {
            HashMap hashMap = new HashMap();
            if (com.baidu.sofire.b.e.e(this.context)) {
                hashMap.put("0", Integer.valueOf(this.preference.g() + 1));
                hashMap.put("1", Integer.valueOf(this.preference.h()));
            } else {
                hashMap.put("0", Integer.valueOf(this.preference.g()));
                hashMap.put("1", Integer.valueOf(this.preference.h() + 1));
            }
            this.preference.a(0);
            this.preference.b(0);
            this.preference.f();
            com.baidu.sofire.b.e.a(this.context, "1003116", hashMap);
        } else if (com.baidu.sofire.b.e.e(this.context)) {
            this.preference.a(this.preference.g() + 1);
        } else {
            this.preference.b(this.preference.h() + 1);
        }
        b.a();
        file.delete();
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x025c A[Catch: Throwable -> 0x012f, TryCatch #1 {Throwable -> 0x012f, blocks: (B:3:0x0007, B:5:0x002d, B:7:0x0037, B:9:0x003b, B:11:0x004d, B:13:0x005f, B:15:0x0067, B:16:0x006c, B:18:0x00cf, B:20:0x00db, B:22:0x00f9, B:24:0x00fd, B:26:0x010b, B:28:0x012a, B:70:0x0218, B:72:0x0225, B:74:0x022f, B:76:0x0233, B:78:0x023b, B:80:0x0245, B:81:0x0253, B:83:0x025c, B:85:0x0265, B:88:0x026d, B:90:0x0279, B:92:0x0286, B:93:0x0297, B:95:0x02aa, B:97:0x02bf, B:98:0x02cb, B:58:0x01dc, B:62:0x01f0, B:64:0x0200, B:66:0x020d, B:57:0x01c4), top: B:112:0x0007 }] */
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
            final int m = com.baidu.sofire.b.e.m(this.context);
            new StringBuilder("a=").append(apkInfo);
            b.a();
            final List<Integer> o = this.preference.o();
            if (!o.contains(Integer.valueOf(apkInfo.key)) && !com.baidu.sofire.b.e.b(this.context, apkInfo.network)) {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(m, 3));
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
                if (apkInfo.apkMD5.equals(o.a(file3))) {
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
                            boolean handlePluginDownload = U.this.handlePluginDownload(apkInfo, file2, file3, m);
                            new StringBuilder().append(handlePluginDownload);
                            b.a();
                            if (!handlePluginDownload) {
                                U.this.handlePluginDownError(apkInfo, file3, m, o);
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
                boolean handlePluginDownload = handlePluginDownload(apkInfo, file2, file3, m);
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
                new StringBuilder().append(apkInfo.versionName).append(" ").append(apkInfo.key);
                b.a();
                pluginUpdate(file3, apkInfo, m);
            } else {
                if (a != null) {
                    b.a();
                    ApkInfo a2 = this.loadedPluginDB.a(apkInfo.key);
                    if (a2 != null) {
                        if (com.baidu.sofire.b.e.c(a.versionName, a2.versionName)) {
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
                                if (a.apkMD5.equals(o.a(file))) {
                                    a.key -= 10000000;
                                    if (!TextUtils.isEmpty(a.packageName)) {
                                        a.packageName = new StringBuilder(a.packageName).reverse().toString();
                                    }
                                    new StringBuilder().append(a.versionName);
                                    b.a();
                                    pluginUpdate(file, a, m);
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
                    if (com.baidu.sofire.core.g.a(this.context.getApplicationContext()).d(apkInfo.packageName) == null) {
                        this.forHostAPP.a(apkInfo.key, apkInfo.versionName, null);
                    }
                }
            }
            if (z3) {
                handlePluginDownError(apkInfo, file3, m, o);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
            try {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(com.baidu.sofire.b.e.m(this.context), 2));
                }
            } catch (Throwable th2) {
                com.baidu.sofire.b.e.a();
            }
            try {
                List<Integer> o2 = this.preference.o();
                if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                    if (o2.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                        sSetRetrmAlarm = true;
                        com.baidu.sofire.b.b.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                        sRetryDownoadHostCareApksTimesCount++;
                    }
                    if (!sMonitorNetworkWhenUpgradeNoNet) {
                        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        if (com.baidu.sofire.b.e.d == null) {
                            com.baidu.sofire.b.e.d = new MyReceiver().a();
                        } else {
                            com.baidu.sofire.b.e.d.a();
                        }
                        this.context.getApplicationContext().registerReceiver(com.baidu.sofire.b.e.d, intentFilter);
                        sMonitorNetworkWhenUpgradeNoNet = true;
                    }
                }
            } catch (Throwable th3) {
                com.baidu.sofire.b.e.a();
            }
        }
    }
}
