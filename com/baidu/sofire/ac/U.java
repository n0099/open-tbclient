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
import com.baidu.ar.util.IoUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.OpenAppAction;
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
import com.baidu.sofire.core.j;
import com.baidu.sofire.e;
import com.baidu.sofire.jni.Asc;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
/* loaded from: classes.dex */
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
    /* loaded from: classes.dex */
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
        b.a("handleWork in");
        start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [809=5, 810=5, 812=5, 813=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public synchronized void run() {
        String str;
        JSONObject jSONObject;
        PackageInfo packageInfo;
        JSONObject jSONObject2;
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
                    if (com.baidu.sofire.b.e.g(this.context)) {
                        sLastCheckTime = System.currentTimeMillis();
                    }
                    com.baidu.sofire.b.b.a(this.context, false);
                    j.a(this.context);
                    if (this.mFrom == 1 || this.mFrom == 3) {
                        sRetryPingTimesCount = 0;
                        sRetryDownoadHostCareApksTimesCount = 0;
                        com.baidu.sofire.b.b.a(this.context, 0, true);
                        sSetRetrmAlarm = false;
                    }
                    if (this.mFrom == 2) {
                        sSetRetrmAlarm = false;
                    }
                    if (!com.baidu.sofire.b.e.g(this.context)) {
                        if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                            b.a("from Init!");
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
                        try {
                            this.context.getApplicationContext().unregisterReceiver(com.baidu.sofire.b.e.d);
                        } catch (Throwable th) {
                            com.baidu.sofire.b.e.a(th);
                        }
                    }
                    sMonitorNetworkWhenUpgradeNoNet = false;
                    com.baidu.sofire.b.e.a = false;
                    String str2 = com.baidu.sofire.b.e.e(this.context) + "opmon";
                    String str3 = null;
                    try {
                        str3 = new m(this.context).a(str2);
                    } catch (Throwable th2) {
                        com.baidu.sofire.b.e.a(th2);
                    }
                    if (TextUtils.isEmpty(str3)) {
                        try {
                            str = new m(this.context).a(str2);
                        } catch (Throwable th3) {
                            com.baidu.sofire.b.e.a(th3);
                            str = str3;
                        }
                        if (TextUtils.isEmpty(str)) {
                            if ((this.mFrom == 1 || this.mFrom == 2 || (this.mFrom == 3 && !sSetRetrmAlarm)) && this.preference.B().size() > 0) {
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
                    }
                    sRetryPingTimesCount = 0;
                    if (System.currentTimeMillis() - this.preference.K() > this.preference.J() * 60 * 1000) {
                        boolean z = false;
                        String str4 = com.baidu.sofire.b.e.e(this.context) + "p/1/stt";
                        b.a("URL " + str4);
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(Config.APP_VERSION_CODE, "b");
                            String a = h.a(this.context, str4, jSONObject3.toString(), true, true);
                            b.a("after decrypt ResponseDataJsonString=--" + a);
                            if (a != null) {
                                JSONObject jSONObject4 = new JSONObject(a);
                                int optInt = jSONObject4.optInt("app");
                                b.a("after decrypt ResponseDataJsonString=App-" + Integer.toString(optInt));
                                this.preference.i(optInt);
                                int optInt2 = jSONObject4.optInt("js");
                                b.a("after decrypt ResponseDataJsonString=JS-" + Integer.toString(optInt2));
                                this.preference.j(optInt2);
                                int optInt3 = jSONObject4.optInt(Config.APP_VERSION_CODE, 1);
                                b.a("after decrypt ResponseDataJsonString=get key-" + Integer.toString(optInt3));
                                this.preference.k(optInt3);
                                int optInt4 = jSONObject4.optInt("pi", 360);
                                b.a("after decrypt ResponseDataJsonString=net Interval-" + Integer.toString(optInt4));
                                this.preference.n(optInt4);
                                int optInt5 = jSONObject4.optInt(Config.FEED_LIST_PART, 1);
                                b.a("sjh-alarm times-" + Integer.toString(optInt5));
                                if (optInt5 > 0) {
                                    int round = (int) Math.round(24.0d / optInt5);
                                    b.a("sjh-alarm hours-" + Integer.toString(round));
                                    if (round > 0) {
                                        this.preference.m(round);
                                    } else {
                                        this.preference.m(24);
                                    }
                                }
                                int optInt6 = jSONObject4.optInt("alm", 24);
                                b.a("sjh-Dayalarm set hours" + Integer.toString(optInt6));
                                if (optInt6 > 0) {
                                    this.preference.l(optInt6);
                                } else {
                                    this.preference.l(24);
                                }
                                z = true;
                            }
                        } catch (Throwable th4) {
                            com.baidu.sofire.b.e.a(th4);
                        }
                        if (z) {
                            b.a("set last get setting suc time");
                            this.preference.c(System.currentTimeMillis());
                        }
                    }
                    boolean z2 = false;
                    String[] i = com.baidu.sofire.b.e.i(this.context);
                    if (this.preference.H() == 1 && (i == null || i.length != 2 || TextUtils.isEmpty(i[0]) || TextUtils.isEmpty(i[1]))) {
                        z2 = true;
                    }
                    if (!z2 || h.a(this.context)) {
                        this.forHostAPP.b(this.context);
                        String h = this.preference.h();
                        if (TextUtils.isEmpty(h)) {
                            com.baidu.sofire.b.e.p(this.context);
                            h = this.preference.h();
                        }
                        b.a("l:" + h);
                        if (this.preference.G() == 1) {
                            com.baidu.sofire.b.e.q(this.context);
                        }
                        this.loadedPluginDB.e();
                        JSONObject jSONObject5 = new JSONObject();
                        JSONObject jSONObject6 = new JSONObject();
                        JSONObject jSONObject7 = new JSONObject();
                        String packageName = this.context.getPackageName();
                        jSONObject7.put(PushConstants.URI_PACKAGE_NAME, packageName);
                        jSONObject6.put(PushConstants.URI_PACKAGE_NAME, packageName);
                        jSONObject6.put("dm", Build.MODEL);
                        jSONObject7.put("dm", Build.MODEL);
                        jSONObject6.put("cuid", g.a(this.context));
                        jSONObject6.put("al", String.valueOf(Build.VERSION.SDK_INT));
                        jSONObject7.put("al", String.valueOf(Build.VERSION.SDK_INT));
                        jSONObject6.put("ev", "3.1.8");
                        PackageInfo packageInfo2 = null;
                        try {
                            packageInfo2 = this.context.getPackageManager().getPackageInfo(packageName, 64);
                        } catch (Throwable th5) {
                            com.baidu.sofire.b.e.a(th5);
                        }
                        if (packageInfo2 == null) {
                            if (this.mEndReason == 0) {
                                this.mEndReason = 6;
                            }
                            throw new NetworkErrorException("hostPkgInfo is null");
                        }
                        jSONObject6.put("av", packageInfo2.versionName);
                        jSONObject7.put("av", packageInfo2.versionName);
                        PublicKey a2 = com.baidu.sofire.b.e.a(packageInfo2, packageInfo2.applicationInfo.sourceDir);
                        if (a2 != null) {
                            byte[] encoded = a2.getEncoded();
                            if (encoded != null) {
                                com.baidu.sofire.b.e.a(this.context, encoded);
                                String a3 = o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                                jSONObject6.put("sm", a3);
                                jSONObject7.put("sm", a3);
                            } else {
                                jSONObject6.put("sm", "");
                                jSONObject7.put("sm", "");
                            }
                        }
                        jSONObject6.put("or", this.preference.g());
                        jSONObject6.put(Config.PLATFORM_TYPE, this.preference.i());
                        jSONObject5.put(Config.DEVICE_PART, jSONObject6);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject7);
                        HashMap hashMap = new HashMap();
                        hashMap.putAll(com.baidu.sofire.b.e.e);
                        for (String str5 : hashMap.keySet()) {
                            try {
                                jSONObject2 = new JSONObject((String) hashMap.get(str5));
                            } catch (Throwable th6) {
                                com.baidu.sofire.b.e.a(th6);
                                jSONObject2 = null;
                            }
                            if (jSONObject2 != null) {
                                jSONArray.put(jSONObject2);
                            }
                        }
                        jSONObject5.put("host_apps", jSONArray);
                        String jSONObject8 = jSONObject5.toString();
                        b.a("p:" + jSONObject8);
                        String str6 = com.baidu.sofire.b.e.e(this.context) + "p/1/pls";
                        if (!sPidRegister) {
                            this.preference.h(this.preference.F() + 1);
                            this.preference.b(System.currentTimeMillis());
                            sPidRegister = true;
                        }
                        this.preference.g(this.preference.D() + 1);
                        String a4 = h.a(this.context, str6, jSONObject8, true, true);
                        b.a("after decrypt ResponseDataJsonString=" + a4);
                        try {
                            jSONObject = new JSONObject(a4);
                        } catch (Throwable th7) {
                            com.baidu.sofire.b.e.a(th7);
                            jSONObject = null;
                        }
                        if (jSONObject == null) {
                            if (this.mEndReason == 0) {
                                this.mEndReason = 9;
                            }
                            throw new NetworkErrorException("response json is null");
                        }
                        List<ApkInfo> b = this.loadedPluginDB.b();
                        b.a("a=" + b);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        JSONArray optJSONArray = jSONObject.optJSONArray("product");
                        long optLong = jSONObject.optLong(Config.PLATFORM_TYPE);
                        if (optJSONArray != null && optJSONArray.length() > 0 && optLong > 0) {
                            this.preference.a(optJSONArray.toString(), optLong);
                            com.baidu.sofire.b.e.j(this.context);
                        }
                        JSONObject optJSONObject = jSONObject.optJSONObject(OpenAppAction.DOWNLOAD_FROM_PLUGIN);
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
                                    this.preference.a(optInt8);
                                }
                                if (z3 && z4) {
                                    arrayList3.add(next);
                                } else {
                                    try {
                                        packageInfo = new PackageInfo();
                                        packageInfo.packageName = optJSONObject2.optString("p");
                                        packageInfo.versionName = optJSONObject2.optString("v");
                                        ApplicationInfo applicationInfo = new ApplicationInfo();
                                        applicationInfo.className = optJSONObject2.optString("n");
                                        if (!TextUtils.isEmpty(applicationInfo.className) && applicationInfo.className.startsWith(".")) {
                                            applicationInfo.className = next + applicationInfo.className;
                                        }
                                        applicationInfo.theme = optJSONObject2.optInt("t");
                                        packageInfo.applicationInfo = applicationInfo;
                                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray(Config.APP_VERSION_CODE);
                                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                            ArrayList arrayList4 = new ArrayList();
                                            int i2 = 0;
                                            while (true) {
                                                int i3 = i2;
                                                if (i3 >= optJSONArray2.length()) {
                                                    break;
                                                }
                                                JSONObject jSONObject9 = optJSONArray2.getJSONObject(i3);
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
                                                i2 = i3 + 1;
                                            }
                                            if (arrayList4.size() > 0) {
                                                packageInfo.activities = (ActivityInfo[]) arrayList4.toArray(new ActivityInfo[arrayList4.size()]);
                                            }
                                        }
                                    } catch (Throwable th8) {
                                        packageInfo = null;
                                        com.baidu.sofire.b.e.a(th8);
                                    }
                                    ApkInfo apkInfo = new ApkInfo(optInt7, next, optString, optString2, optString3);
                                    apkInfo.isOnce = z3 ? 1 : 0;
                                    try {
                                        apkInfo.priority = optJSONObject2.getInt(Config.PRINCIPAL_PART);
                                    } catch (Throwable th9) {
                                        apkInfo.priority = -1;
                                    }
                                    apkInfo.isMem = optJSONObject2.optInt("mem") == 1;
                                    if (packageInfo != null) {
                                        apkInfo.cloudPkgInfo = packageInfo;
                                    }
                                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("e");
                                    if (optJSONObject3 != null) {
                                        int optInt9 = optJSONObject3.optInt("d");
                                        int optInt10 = optJSONObject3.optInt("n");
                                        apkInfo.duration = optInt9;
                                        apkInfo.network = optInt10;
                                    }
                                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("ext");
                                    if (optJSONObject4 != null && optJSONObject4.optInt(Config.APP_VERSION_CODE) == 1) {
                                        List<Integer> B = this.preference.B();
                                        ArrayList arrayList5 = B == null ? new ArrayList() : B;
                                        if (optInt7 > 0 && !arrayList5.contains(Integer.valueOf(optInt7))) {
                                            arrayList5.add(Integer.valueOf(optInt7));
                                            int[] iArr = new int[arrayList5.size()];
                                            int i4 = 0;
                                            while (true) {
                                                int i5 = i4;
                                                if (i5 >= arrayList5.size()) {
                                                    break;
                                                }
                                                iArr[i5] = arrayList5.get(i5).intValue();
                                                i4 = i5 + 1;
                                            }
                                            this.preference.a(iArr);
                                        }
                                    }
                                    apkInfo.signMD5 = lowerCase;
                                    apkInfo.startTime = System.currentTimeMillis();
                                    int indexOf = b.indexOf(apkInfo);
                                    b.a("t=" + apkInfo + ", i=" + indexOf);
                                    if (indexOf >= 0) {
                                        ApkInfo apkInfo2 = b.get(indexOf);
                                        if (!com.baidu.sofire.b.e.d(apkInfo.versionName, apkInfo2.versionName) || (d.b != null && (d.b == null || d.b.contains(Integer.valueOf(apkInfo.key))))) {
                                            if (apkInfo2.priority != apkInfo.priority) {
                                                apkInfo2.priority = apkInfo.priority;
                                                this.loadedPluginDB.e(apkInfo.key, apkInfo.priority);
                                            }
                                            arrayList.add(apkInfo2);
                                        } else {
                                            if (apkInfo2.priority != apkInfo.priority) {
                                                this.loadedPluginDB.e(apkInfo.key, apkInfo.priority);
                                            }
                                            if (!this.loadedPluginDB.e(apkInfo2.key)) {
                                                arrayList2.add(apkInfo);
                                                if (this.mDownloadPluginsList != null) {
                                                    this.mDownloadPluginsList.add(Integer.valueOf(apkInfo.key));
                                                }
                                            }
                                        }
                                        b.remove(indexOf);
                                    } else {
                                        arrayList2.add(apkInfo);
                                        if (this.mDownloadPluginsList != null) {
                                            this.mDownloadPluginsList.add(Integer.valueOf(apkInfo.key));
                                        }
                                    }
                                }
                            }
                        }
                        if (d.b != null) {
                            d.b.clear();
                        }
                        b.a("NeedToUnload=" + b);
                        for (ApkInfo apkInfo3 : b) {
                            if (!arrayList3.contains(apkInfo3.packageName)) {
                                if (this.mUnloadPluginsList != null) {
                                    this.mUnloadPluginsList.add(Integer.valueOf(apkInfo3.key));
                                }
                                this.forHostAPP.b(apkInfo3.packageName);
                            }
                        }
                        com.baidu.sofire.b.e.c(this.context);
                        b.a("NeedToLocalLoad=" + arrayList);
                        com.baidu.sofire.core.g a5 = com.baidu.sofire.core.g.a(this.context.getApplicationContext(), true);
                        final List<Integer> C = this.preference.C();
                        List<Integer> B2 = this.preference.B();
                        for (int i6 = 0; i6 < B2.size(); i6++) {
                            if (!C.contains(B2.get(i6))) {
                                C.add(B2.get(i6));
                            }
                        }
                        ArrayList arrayList6 = new ArrayList();
                        arrayList6.addAll(arrayList);
                        arrayList6.addAll(arrayList2);
                        Collections.sort(arrayList6, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.ac.U.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            public int compare(ApkInfo apkInfo4, ApkInfo apkInfo5) {
                                if (apkInfo4.priority != -1 || apkInfo5.priority == -1) {
                                    if ((apkInfo4.priority == -1 || apkInfo5.priority != -1) && apkInfo4.priority >= apkInfo5.priority) {
                                        if (apkInfo4.priority > apkInfo5.priority) {
                                            return 1;
                                        }
                                        int indexOf2 = (C == null || !C.contains(Integer.valueOf(apkInfo4.key))) ? -1 : C.indexOf(Integer.valueOf(apkInfo4.key));
                                        int indexOf3 = (C == null || !C.contains(Integer.valueOf(apkInfo5.key))) ? -1 : C.indexOf(Integer.valueOf(apkInfo5.key));
                                        if (indexOf2 == -1 || indexOf3 != -1) {
                                            if ((indexOf2 != -1 || indexOf3 == -1) && indexOf2 <= indexOf3) {
                                                return indexOf2 >= indexOf3 ? 0 : -1;
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
                        for (int i7 = 0; i7 < arrayList6.size(); i7++) {
                            ApkInfo apkInfo4 = (ApkInfo) arrayList6.get(i7);
                            if (arrayList == null || !arrayList.contains(apkInfo4)) {
                                if (arrayList2 != null && arrayList2.contains(apkInfo4) && !this.loadedPluginDB.e(apkInfo4.key)) {
                                    handlePluginUpgrade(apkInfo4);
                                }
                            } else if (a5.d(apkInfo4.packageName) == null) {
                                boolean z5 = true;
                                if (this.loadedPluginDB.f(apkInfo4.key) == 3) {
                                    b.a("load plugin can remove the backup!");
                                    z5 = false;
                                }
                                if (this.preference.f() && z5) {
                                    File file = new File(this.context.getFilesDir(), ".b");
                                    if (!file.exists()) {
                                        file.mkdir();
                                    }
                                    File file2 = new File(apkInfo4.pkgPath);
                                    File file3 = new File(file, apkInfo4.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo4.versionName);
                                    if (!com.baidu.sofire.b.e.a(file3)) {
                                        com.baidu.sofire.b.e.a(file2, file3);
                                    }
                                    c.a(this.context, apkInfo4.key, file2, file3);
                                } else {
                                    File file4 = new File(this.context.getFilesDir(), ".b");
                                    if (file4.exists()) {
                                        File file5 = new File(file4, apkInfo4.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo4.versionName);
                                        if (com.baidu.sofire.b.e.a(file5)) {
                                            c.a(file5);
                                            b.a("remove the backup file: " + file5.getAbsolutePath() + " s=" + file5.delete());
                                        }
                                    }
                                }
                                this.forHostAPP.a(apkInfo4.key, apkInfo4.versionName, (PackageInfo) null);
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
                        b.a("get key  redress key failed!");
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
            this.preference.p(this.preference.M() + 1);
            if (this.mEndReason != 0) {
                this.preference.a(1, this.mEndReason, this.preference.a(1, this.mEndReason) + 1);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
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
            Map<Integer, String> c = this.loadedPluginDB.c();
            if (c != null) {
                hashMap.put("9", c.keySet());
                hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, c.values());
            }
            hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Integer.valueOf(this.mEndReason));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, str.replace("\n", "").replace("\t", "").replace("\r", ""));
            }
            hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP, Integer.valueOf(this.mStartNetwork));
            hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Integer.valueOf(com.baidu.sofire.b.e.l(this.context)));
            com.baidu.sofire.b.e.a(this.context, "1003129", hashMap);
        } catch (Throwable th2) {
            com.baidu.sofire.b.e.a(th2);
        }
    }

    private void handleThreadStart() {
        try {
            long N = this.preference.N();
            long currentTimeMillis = System.currentTimeMillis();
            if (N > 0 && currentTimeMillis - N > 86400000) {
                HashMap hashMap = new HashMap();
                hashMap.put("1", Integer.valueOf(this.preference.L()));
                this.preference.o(0);
                JSONObject jSONObject = new JSONObject();
                for (int i = 1; i <= 6; i++) {
                    jSONObject.put(String.valueOf(i), this.preference.a(0, i));
                    this.preference.a(0, i, 0);
                }
                hashMap.put("2", jSONObject);
                hashMap.put("3", Integer.valueOf(this.preference.M()));
                this.preference.p(0);
                JSONObject jSONObject2 = new JSONObject();
                for (int i2 = 1; i2 <= 11; i2++) {
                    jSONObject2.put(String.valueOf(i2), this.preference.a(1, i2));
                    this.preference.a(1, i2, 0);
                }
                hashMap.put("4", jSONObject2);
                com.baidu.sofire.b.e.a(this.context, "1003128", hashMap);
                this.preference.d(currentTimeMillis);
            } else if (N == 0) {
                this.preference.d(currentTimeMillis);
            }
        } catch (Throwable th) {
            try {
                this.preference.o(0);
                this.preference.p(0);
                for (int i3 = 1; i3 <= 6; i3++) {
                    this.preference.a(0, i3, 0);
                }
                for (int i4 = 1; i4 <= 11; i4++) {
                    this.preference.a(1, i4, 0);
                }
            } catch (Throwable th2) {
                com.baidu.sofire.b.e.a(th2);
            }
            com.baidu.sofire.b.e.a(th);
        }
        try {
            this.mStartKeyMap = this.loadedPluginDB.c();
            this.preference.o(this.preference.L() + 1);
            if (this.mFrom != 0) {
                this.preference.a(0, this.mFrom, this.preference.a(0, this.mFrom) + 1);
            }
            this.mStartNetwork = com.baidu.sofire.b.e.l(this.context);
        } catch (Throwable th3) {
            com.baidu.sofire.b.e.a(th3);
        }
    }

    private void handlePluginUpgrade(ApkInfo apkInfo) {
        boolean z = false;
        try {
            int l = com.baidu.sofire.b.e.l(this.context);
            b.a("a=" + apkInfo);
            List<Integer> B = this.preference.B();
            if ((B == null || !B.contains(Integer.valueOf(apkInfo.key))) && !com.baidu.sofire.b.e.a(this.context, apkInfo.network)) {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(l, 3));
                    return;
                }
                return;
            }
            if (!this.tmpDir.exists()) {
                this.tmpDir.mkdir();
            }
            StringBuilder sb = new StringBuilder("before update, time=" + System.currentTimeMillis() + ", ");
            ApkInfo a = this.loadedPluginDB.a(apkInfo.key);
            if (a == null) {
                sb.append("apkInDB == null");
            } else {
                File file = new File(a.pkgPath);
                sb.append("origAPK path:" + file.getAbsolutePath() + ", exists=" + file.exists() + ", canRead=" + file.canRead() + ", isFile=" + file.isFile() + ",length" + file.length());
            }
            File file2 = new File(this.tmpDir, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".tmp");
            File file3 = new File(this.tmpDir, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".zip");
            boolean a2 = new m(this.context, null).a(apkInfo.downloadURL, file2);
            b.a("s: " + a2);
            if (a2) {
                if (file3.exists()) {
                    b.a("resfile exists ... ");
                    file3.delete();
                }
                Asc asc = new Asc();
                byte[] bytes = apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes(IoUtils.UTF_8);
                b.a("sj call decrytf ");
                com.baidu.sofire.b.e.g(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
                if (com.baidu.sofire.b.a.a(file2, file3, bytes) != 0) {
                    b.a("java decode err... ");
                    if (file3.exists()) {
                        file3.delete();
                    }
                    com.baidu.sofire.b.e.g(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                    if (asc.df(file2.getAbsolutePath(), file3.getAbsolutePath(), bytes) != 0) {
                        com.baidu.sofire.b.e.g(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
                        b.a("c decode err... ");
                        if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(l, 7));
                        }
                        a2 = z;
                    }
                }
                z = a2;
                a2 = z;
            } else if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(l, 4));
            }
            b.a("" + a2);
            String a3 = o.a(file3);
            b.a("ds=" + a2 + ", fm=" + apkInfo.apkMD5 + ", am=" + a3);
            file2.delete();
            if (a2 && apkInfo.apkMD5.equals(a3)) {
                com.baidu.sofire.b.e.a(file3.getAbsolutePath(), true);
                if (this.preference.f()) {
                    File file4 = new File(this.context.getFilesDir(), ".b");
                    if (!file4.exists()) {
                        file4.mkdir();
                    }
                    File file5 = new File(file4, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                    com.baidu.sofire.b.e.a(file3, file5);
                    c.a(this.context, apkInfo.key, file3, file5);
                }
                apkInfo.pkgPath = file3.getAbsolutePath();
                boolean a4 = this.forHostAPP.a(apkInfo, "before update, time=" + System.currentTimeMillis() + ", downloadAPK path:" + file3.getAbsolutePath() + ", exists=" + file3.exists() + ", canRead=" + file3.canRead() + ", isFile=" + file3.isFile() + ",length" + file3.length(), sb.toString());
                b.a("newCloudCome package=" + apkInfo.packageName + " s=" + a4);
                if (!a4) {
                    if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                        this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(l, 5));
                        return;
                    }
                    return;
                }
                int f = this.loadedPluginDB.f(apkInfo.key);
                b.a("new plugin now loadStatus :" + apkInfo.key + " " + f);
                if (f < 3 && f != -1) {
                    this.loadedPluginDB.d(apkInfo.key, f + 1);
                }
                if (this.mUpgradeResultMap != null) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(l, 1));
                    return;
                }
                return;
            }
            if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(l, 8));
            }
            if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                if (B != null && B.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
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
            if (System.currentTimeMillis() - this.preference.j() > 86400000) {
                HashMap hashMap = new HashMap();
                if (com.baidu.sofire.b.e.f(this.context)) {
                    hashMap.put("0", Integer.valueOf(this.preference.l() + 1));
                    hashMap.put("1", Integer.valueOf(this.preference.m()));
                } else {
                    hashMap.put("0", Integer.valueOf(this.preference.l()));
                    hashMap.put("1", Integer.valueOf(this.preference.m() + 1));
                }
                this.preference.b(0);
                this.preference.c(0);
                this.preference.k();
                com.baidu.sofire.b.e.a(this.context, "1003116", hashMap);
            } else if (com.baidu.sofire.b.e.f(this.context)) {
                this.preference.b(this.preference.l() + 1);
            } else {
                this.preference.c(this.preference.m() + 1);
            }
            b.a("downlaod file faild");
            file3.delete();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            try {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(com.baidu.sofire.b.e.l(this.context), 2));
                }
            } catch (Throwable th2) {
                com.baidu.sofire.b.e.a(th2);
            }
            try {
                List<Integer> B2 = this.preference.B();
                if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                    if (B2 != null && B2.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                        sSetRetrmAlarm = true;
                        com.baidu.sofire.b.b.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                        sRetryDownoadHostCareApksTimesCount++;
                    }
                    if (!sMonitorNetworkWhenUpgradeNoNet) {
                        IntentFilter intentFilter2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        if (com.baidu.sofire.b.e.d == null) {
                            com.baidu.sofire.b.e.d = new MyReceiver().a();
                        } else {
                            com.baidu.sofire.b.e.d.a();
                        }
                        this.context.getApplicationContext().registerReceiver(com.baidu.sofire.b.e.d, intentFilter2);
                        sMonitorNetworkWhenUpgradeNoNet = true;
                    }
                }
            } catch (Throwable th3) {
                com.baidu.sofire.b.e.a(th3);
            }
        }
    }
}
