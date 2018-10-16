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
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.OpenAppAction;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.b.b;
import com.baidu.sofire.b.g;
import com.baidu.sofire.b.h;
import com.baidu.sofire.b.m;
import com.baidu.sofire.b.n;
import com.baidu.sofire.b.o;
import com.baidu.sofire.b.s;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
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
    private c forHostAPP;
    private com.baidu.sofire.a.a loadedPluginDB;
    private Map<Integer, String> mCloudKeyMap;
    List<Integer> mDownloadPluginsList;
    private int mEndReason;
    private int mFrom;
    private boolean mOut;
    private Map<Integer, String> mStartKeyMap;
    private int mStartNetwork;
    List<Integer> mUnloadPluginsList;
    private Map<Integer, a> mUpgradeResultMap;
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
    public class a {
        int a;
        int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
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
        this.loadedPluginDB = com.baidu.sofire.a.a.a(context);
        this.preference = new e(context);
        this.forHostAPP = c.a(context);
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
        this.loadedPluginDB = com.baidu.sofire.a.a.a(context);
        this.preference = new e(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.forHostAPP = c.a(context);
        this.mFrom = intent.getIntExtra("from", 0);
        start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [759=5, 760=5, 763=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public synchronized void run() {
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
                    if (com.baidu.sofire.b.e.d(this.context)) {
                        sLastCheckTime = System.currentTimeMillis();
                    }
                    b.a(this.context, false);
                    Context context = this.context;
                    com.baidu.sofire.a.a a2 = com.baidu.sofire.a.a.a(context);
                    c a3 = c.a(context);
                    for (ApkInfo apkInfo : a2.a()) {
                        if (apkInfo.duration != 0 && apkInfo.startTime + (apkInfo.duration * 60 * 1000) < System.currentTimeMillis()) {
                            String str = apkInfo.packageName;
                            new StringBuilder().append(str);
                            new c.AnonymousClass4(str).start();
                        }
                    }
                    if (this.mFrom == 1 || this.mFrom == 3) {
                        sRetryPingTimesCount = 0;
                        sRetryDownoadHostCareApksTimesCount = 0;
                        b.a(this.context, 0, true);
                        sSetRetrmAlarm = false;
                    }
                    if (this.mFrom == 2) {
                        sSetRetrmAlarm = false;
                    }
                    if (!com.baidu.sofire.b.e.d(this.context)) {
                        if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
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
                    String str2 = com.baidu.sofire.b.e.a() + "opmon";
                    if (TextUtils.isEmpty(new m(this.context, (byte) 0).a(str2)) && TextUtils.isEmpty(new m(this.context, (byte) 0).a(str2))) {
                        if ((this.mFrom == 1 || this.mFrom == 2 || (this.mFrom == 3 && !sSetRetrmAlarm)) && this.preference.b().size() > 0) {
                            sSetRetrmAlarm = true;
                            b.a(this.context, sRetryPingTimesCount, false);
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
                        String str3 = com.baidu.sofire.b.e.a() + "p/1/stt";
                        new StringBuilder().append(str3);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(Config.APP_VERSION_CODE, "b");
                        JSONObject jSONObject2 = new JSONObject(h.a(this.context, str3, jSONObject.toString(), true, false));
                        int optInt = jSONObject2.optInt("app");
                        new StringBuilder("App-").append(Integer.toString(optInt));
                        e eVar = this.preference;
                        eVar.c.putInt("appinv_t", optInt);
                        eVar.c.commit();
                        int optInt2 = jSONObject2.optInt("js");
                        new StringBuilder("JS-").append(Integer.toString(optInt2));
                        e eVar2 = this.preference;
                        eVar2.c.putInt("appinv_js", optInt2);
                        eVar2.c.commit();
                        int optInt3 = jSONObject2.optInt(Config.APP_VERSION_CODE, 1);
                        new StringBuilder("get key-").append(Integer.toString(optInt3));
                        e eVar3 = this.preference;
                        eVar3.c.putInt("appinv_ky", optInt3);
                        eVar3.c.commit();
                        int optInt4 = jSONObject2.optInt("pi", 360);
                        new StringBuilder("net Interval-").append(Integer.toString(optInt4));
                        e eVar4 = this.preference;
                        eVar4.c.putInt("appplg_te", optInt4);
                        eVar4.c.commit();
                        if (1 != 0) {
                            e eVar5 = this.preference;
                            eVar5.c.putLong("plla_tm", System.currentTimeMillis());
                            eVar5.c.commit();
                        }
                    }
                    boolean z = false;
                    String[] f = com.baidu.sofire.b.e.f(this.context);
                    if (this.preference.a.getInt("appinv_ky", 1) == 1 && (f == null || f.length != 2 || TextUtils.isEmpty(f[0]) || TextUtils.isEmpty(f[1]))) {
                        z = true;
                    }
                    if (!z || s.a(this.context)) {
                        this.forHostAPP.b(this.context);
                        if (TextUtils.isEmpty(this.preference.a())) {
                            o.a(this.context);
                            this.preference.a();
                        }
                        if (this.preference.a.getInt("appinv_t", 0) == 1) {
                            o.b(this.context);
                        }
                        this.loadedPluginDB.d();
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        JSONObject jSONObject5 = new JSONObject();
                        String packageName = this.context.getPackageName();
                        jSONObject5.put(PushConstants.URI_PACKAGE_NAME, packageName);
                        jSONObject4.put(PushConstants.URI_PACKAGE_NAME, packageName);
                        jSONObject4.put("dm", Build.MODEL);
                        jSONObject5.put("dm", Build.MODEL);
                        jSONObject4.put("cuid", g.a(this.context));
                        jSONObject4.put("al", String.valueOf(Build.VERSION.SDK_INT));
                        jSONObject5.put("al", String.valueOf(Build.VERSION.SDK_INT));
                        jSONObject4.put("ev", "3.1.3.2");
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
                                String a5 = n.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                                jSONObject4.put("sm", a5);
                                jSONObject5.put("sm", a5);
                            } else {
                                jSONObject4.put("sm", "");
                                jSONObject5.put("sm", "");
                            }
                        }
                        jSONObject4.put("or", this.preference.a.getInt("opi", 0));
                        jSONObject4.put(Config.PLATFORM_TYPE, this.preference.a.getLong("lslt", 0L));
                        jSONObject3.put(Config.DEVICE_PART, jSONObject4);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject5);
                        HashMap hashMap = new HashMap();
                        hashMap.putAll(o.a);
                        for (String str4 : hashMap.keySet()) {
                            JSONObject jSONObject6 = new JSONObject((String) hashMap.get(str4));
                            if (jSONObject6 != null) {
                                jSONArray.put(jSONObject6);
                            }
                        }
                        jSONObject3.put("host_apps", jSONArray);
                        String jSONObject7 = jSONObject3.toString();
                        String str5 = com.baidu.sofire.b.e.a() + "p/1/pls";
                        if (!sPidRegister) {
                            e eVar6 = this.preference;
                            eVar6.c.putInt("pdcg", this.preference.a.getInt("pdcg", 0) + 1);
                            eVar6.c.commit();
                            this.preference.a(System.currentTimeMillis());
                            sPidRegister = true;
                        }
                        e eVar7 = this.preference;
                        eVar7.c.putInt("rtqe", this.preference.a.getInt("rtqe", 0) + 1);
                        eVar7.c.commit();
                        String a6 = h.a(this.context, str5, jSONObject7, true, false);
                        new StringBuilder().append(a6);
                        JSONObject jSONObject8 = new JSONObject(a6);
                        if (jSONObject8 == null) {
                            if (this.mEndReason == 0) {
                                this.mEndReason = 9;
                            }
                            throw new NetworkErrorException("response json is null");
                        }
                        List<ApkInfo> a7 = this.loadedPluginDB.a();
                        new StringBuilder("a=").append(a7);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        JSONArray optJSONArray = jSONObject8.optJSONArray("product");
                        long optLong = jSONObject8.optLong(Config.PLATFORM_TYPE);
                        if (optJSONArray != null && optJSONArray.length() > 0 && optLong > 0) {
                            this.preference.a(optJSONArray.toString(), optLong);
                            com.baidu.sofire.b.e.h(this.context);
                        }
                        JSONObject optJSONObject = jSONObject8.optJSONObject(OpenAppAction.DOWNLOAD_FROM_PLUGIN);
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
                                int optInt5 = optJSONObject2.optInt("l");
                                String optString = optJSONObject2.optString("v");
                                if (this.mCloudKeyMap != null) {
                                    this.mCloudKeyMap.put(Integer.valueOf(optInt5), optString);
                                }
                                String optString2 = optJSONObject2.optString("u");
                                String optString3 = optJSONObject2.optString(Config.MODEL);
                                String optString4 = optJSONObject2.optString("sm");
                                if (optString3 != null) {
                                    optString3 = optString3.toLowerCase();
                                }
                                String lowerCase = optString4 != null ? optString4.toLowerCase() : optString4;
                                boolean z2 = optJSONObject2.optInt(Config.OS) == 1;
                                boolean z3 = optJSONObject2.optInt("d") == 1;
                                int optInt6 = optJSONObject2.optInt("r");
                                if (z2) {
                                    e eVar8 = this.preference;
                                    if (optInt6 > eVar8.a.getInt("opi", 0)) {
                                        eVar8.c.putInt("opi", optInt6);
                                        eVar8.c.commit();
                                    }
                                }
                                if (z2 && z3) {
                                    arrayList3.add(next);
                                } else {
                                    PackageInfo packageInfo2 = new PackageInfo();
                                    packageInfo2.packageName = optJSONObject2.optString("p");
                                    packageInfo2.versionName = optJSONObject2.optString("v");
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
                                        int i = 0;
                                        while (true) {
                                            int i2 = i;
                                            if (i2 >= optJSONArray2.length()) {
                                                break;
                                            }
                                            JSONObject jSONObject9 = optJSONArray2.getJSONObject(i2);
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
                                            i = i2 + 1;
                                        }
                                        if (arrayList4.size() > 0) {
                                            packageInfo2.activities = (ActivityInfo[]) arrayList4.toArray(new ActivityInfo[arrayList4.size()]);
                                        }
                                    }
                                    ApkInfo apkInfo2 = new ApkInfo(optInt5, next, optString, optString2, optString3);
                                    apkInfo2.isOnce = z2 ? 1 : 0;
                                    apkInfo2.priority = optJSONObject2.getInt(Config.PRINCIPAL_PART);
                                    apkInfo2.isMem = optJSONObject2.optInt("mem") == 1;
                                    if (packageInfo2 != null) {
                                        apkInfo2.cloudPkgInfo = packageInfo2;
                                    }
                                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("e");
                                    if (optJSONObject3 != null) {
                                        int optInt7 = optJSONObject3.optInt("d");
                                        int optInt8 = optJSONObject3.optInt("n");
                                        apkInfo2.duration = optInt7;
                                        apkInfo2.network = optInt8;
                                    }
                                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("ext");
                                    if (optJSONObject4 != null && optJSONObject4.optInt(Config.APP_VERSION_CODE) == 1) {
                                        List<Integer> b = this.preference.b();
                                        if (optInt5 > 0 && !b.contains(Integer.valueOf(optInt5))) {
                                            b.add(Integer.valueOf(optInt5));
                                            int[] iArr = new int[b.size()];
                                            int i3 = 0;
                                            while (true) {
                                                int i4 = i3;
                                                if (i4 >= b.size()) {
                                                    break;
                                                }
                                                iArr[i4] = b.get(i4).intValue();
                                                i3 = i4 + 1;
                                            }
                                            this.preference.a(iArr);
                                        }
                                    }
                                    apkInfo2.signMD5 = lowerCase;
                                    apkInfo2.startTime = System.currentTimeMillis();
                                    int indexOf = a7.indexOf(apkInfo2);
                                    new StringBuilder("t=").append(apkInfo2).append(", i=").append(indexOf);
                                    if (indexOf >= 0) {
                                        ApkInfo apkInfo3 = a7.get(indexOf);
                                        if (!com.baidu.sofire.b.e.c(apkInfo2.versionName, apkInfo3.versionName) || (c.d != null && (c.d == null || c.d.contains(Integer.valueOf(apkInfo2.key))))) {
                                            if (apkInfo3.priority != apkInfo2.priority) {
                                                apkInfo3.priority = apkInfo2.priority;
                                                this.loadedPluginDB.c(apkInfo2.key, apkInfo2.priority);
                                            }
                                            arrayList.add(apkInfo3);
                                        } else {
                                            if (apkInfo3.priority != apkInfo2.priority) {
                                                this.loadedPluginDB.c(apkInfo2.key, apkInfo2.priority);
                                            }
                                            if (!this.loadedPluginDB.e(apkInfo3.key)) {
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
                        if (c.d != null) {
                            c.d.clear();
                        }
                        new StringBuilder().append(a7);
                        for (ApkInfo apkInfo4 : a7) {
                            if (!arrayList3.contains(apkInfo4.packageName)) {
                                if (this.mUnloadPluginsList != null) {
                                    this.mUnloadPluginsList.add(Integer.valueOf(apkInfo4.key));
                                }
                                c cVar = this.forHostAPP;
                                String str6 = apkInfo4.packageName;
                                new StringBuilder().append(str6);
                                new c.AnonymousClass4(str6).start();
                            }
                        }
                        com.baidu.sofire.b.e.a(this.context);
                        new StringBuilder().append(arrayList);
                        com.baidu.sofire.core.e a8 = com.baidu.sofire.core.e.a(this.context.getApplicationContext());
                        final List<Integer> c = this.preference.c();
                        List<Integer> b2 = this.preference.b();
                        for (int i5 = 0; i5 < b2.size(); i5++) {
                            if (!c.contains(b2.get(i5))) {
                                c.add(b2.get(i5));
                            }
                        }
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.addAll(arrayList);
                        arrayList5.addAll(arrayList2);
                        Collections.sort(arrayList5, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.ac.U.1
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                            @Override // java.util.Comparator
                            public final /* synthetic */ int compare(ApkInfo apkInfo5, ApkInfo apkInfo6) {
                                ApkInfo apkInfo7 = apkInfo5;
                                ApkInfo apkInfo8 = apkInfo6;
                                if (apkInfo7.priority != -1 || apkInfo8.priority == -1) {
                                    if ((apkInfo7.priority == -1 || apkInfo8.priority != -1) && apkInfo7.priority >= apkInfo8.priority) {
                                        if (apkInfo7.priority > apkInfo8.priority) {
                                            return 1;
                                        }
                                        int indexOf2 = (c == null || !c.contains(Integer.valueOf(apkInfo7.key))) ? -1 : c.indexOf(Integer.valueOf(apkInfo7.key));
                                        int indexOf3 = (c == null || !c.contains(Integer.valueOf(apkInfo8.key))) ? -1 : c.indexOf(Integer.valueOf(apkInfo8.key));
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
                        for (int i6 = 0; i6 < arrayList5.size(); i6++) {
                            ApkInfo apkInfo5 = (ApkInfo) arrayList5.get(i6);
                            if (arrayList.contains(apkInfo5)) {
                                if (a8.d(apkInfo5.packageName) == null) {
                                    boolean z4 = this.loadedPluginDB.g(apkInfo5.key) != 3;
                                    if (this.preference.a.getBoolean("bka", true) && z4) {
                                        File file = new File(this.context.getFilesDir(), ".b");
                                        if (!file.exists()) {
                                            file.mkdir();
                                        }
                                        File file2 = new File(apkInfo5.pkgPath);
                                        File file3 = new File(file, apkInfo5.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo5.versionName);
                                        if (!com.baidu.sofire.b.e.a(file3)) {
                                            com.baidu.sofire.b.e.a(file2, file3);
                                        }
                                        com.baidu.sofire.c.a(this.context, apkInfo5.key, file2, file3);
                                    } else {
                                        File file4 = new File(this.context.getFilesDir(), ".b");
                                        if (file4.exists()) {
                                            File file5 = new File(file4, apkInfo5.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo5.versionName);
                                            if (com.baidu.sofire.b.e.a(file5)) {
                                                com.baidu.sofire.c.a(file5);
                                                new StringBuilder().append(file5.getAbsolutePath()).append(" s=").append(file5.delete());
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
                    } else if (this.mOut && sOutGoing) {
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
            e eVar = this.preference;
            eVar.c.putInt("sufzfd", this.preference.a.getInt("sufzfd", 0) + 1);
            eVar.c.commit();
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
                for (Map.Entry<Integer, a> entry : this.mUpgradeResultMap.entrySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    int intValue = entry.getKey().intValue();
                    a value = entry.getValue();
                    if (value != null) {
                        jSONObject2.put("1", value.a);
                        jSONObject2.put("0", value.b);
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
            hashMap.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Integer.valueOf(com.baidu.sofire.b.e.j(this.context)));
            com.baidu.sofire.b.e.a(this.context, "1003129", hashMap);
        } catch (Throwable th2) {
            com.baidu.sofire.b.e.a(th2);
        }
    }

    private void handleThreadStart() {
        try {
            long j = this.preference.a.getLong("slruct", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (j > 0 && currentTimeMillis - j > 86400000) {
                HashMap hashMap = new HashMap();
                hashMap.put("1", Integer.valueOf(this.preference.a.getInt("sustfd", 0)));
                e eVar = this.preference;
                eVar.c.putInt("sustfd", 0);
                eVar.c.commit();
                JSONObject jSONObject = new JSONObject();
                for (int i = 1; i <= 6; i++) {
                    jSONObject.put(String.valueOf(i), this.preference.a(0, i));
                    this.preference.a(0, i, 0);
                }
                hashMap.put("2", jSONObject);
                hashMap.put("3", Integer.valueOf(this.preference.a.getInt("sufzfd", 0)));
                e eVar2 = this.preference;
                eVar2.c.putInt("sufzfd", 0);
                eVar2.c.commit();
                JSONObject jSONObject2 = new JSONObject();
                for (int i2 = 1; i2 <= 11; i2++) {
                    jSONObject2.put(String.valueOf(i2), this.preference.a(1, i2));
                    this.preference.a(1, i2, 0);
                }
                hashMap.put("4", jSONObject2);
                com.baidu.sofire.b.e.a(this.context, "1003128", hashMap);
                e eVar3 = this.preference;
                eVar3.c.putLong("slruct", currentTimeMillis);
                eVar3.c.commit();
            } else if (j == 0) {
                e eVar4 = this.preference;
                eVar4.c.putLong("slruct", currentTimeMillis);
                eVar4.c.commit();
            }
        } catch (Throwable th) {
            try {
                e eVar5 = this.preference;
                eVar5.c.putInt("sustfd", 0);
                eVar5.c.commit();
                e eVar6 = this.preference;
                eVar6.c.putInt("sufzfd", 0);
                eVar6.c.commit();
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
            this.mStartKeyMap = this.loadedPluginDB.b();
            e eVar7 = this.preference;
            eVar7.c.putInt("sustfd", this.preference.a.getInt("sustfd", 0) + 1);
            eVar7.c.commit();
            if (this.mFrom != 0) {
                this.preference.a(0, this.mFrom, this.preference.a(0, this.mFrom) + 1);
            }
            this.mStartNetwork = com.baidu.sofire.b.e.j(this.context);
        } catch (Throwable th3) {
            com.baidu.sofire.b.e.a(th3);
        }
    }

    private void handlePluginUpgrade(ApkInfo apkInfo) {
        try {
            int j = com.baidu.sofire.b.e.j(this.context);
            new StringBuilder("a=").append(apkInfo);
            List<Integer> b = this.preference.b();
            if (!b.contains(Integer.valueOf(apkInfo.key)) && !com.baidu.sofire.b.e.a(this.context, apkInfo.network)) {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(j, 3));
                    return;
                }
                return;
            }
            if (!this.tmpDir.exists()) {
                this.tmpDir.mkdir();
            }
            StringBuilder sb = new StringBuilder("before update, time=" + System.currentTimeMillis() + ", ");
            ApkInfo a2 = this.loadedPluginDB.a(apkInfo.key);
            if (a2 == null) {
                sb.append("apkInDB == null");
            } else {
                File file = new File(a2.pkgPath);
                sb.append("origAPK path:" + file.getAbsolutePath() + ", exists=" + file.exists() + ", canRead=" + file.canRead() + ", isFile=" + file.isFile() + ",length" + file.length());
            }
            File file2 = new File(this.tmpDir, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".tmp");
            File file3 = new File(this.tmpDir, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".zip");
            boolean a3 = new m(this.context).a(apkInfo.downloadURL, file2);
            if (a3) {
                if (file3.exists()) {
                    file3.delete();
                }
                Asc asc = new Asc();
                byte[] bytes = apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes(IoUtils.UTF_8);
                com.baidu.sofire.b.e.d(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
                if (com.baidu.sofire.b.a.a(file2, file3, bytes) != 0) {
                    if (file3.exists()) {
                        file3.delete();
                    }
                    com.baidu.sofire.b.e.d(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                    if (asc.df(file2.getAbsolutePath(), file3.getAbsolutePath(), bytes) != 0) {
                        com.baidu.sofire.b.e.d(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
                        if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(j, 7));
                        }
                        a3 = false;
                    }
                }
            } else if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(j, 4));
            }
            new StringBuilder().append(a3);
            String a4 = n.a(file3);
            new StringBuilder("ds=").append(a3).append(", fm=").append(apkInfo.apkMD5).append(", am=").append(a4);
            file2.delete();
            if (a3 && apkInfo.apkMD5.equals(a4)) {
                com.baidu.sofire.b.e.a(file3.getAbsolutePath(), true);
                if (this.preference.a.getBoolean("bka", true)) {
                    File file4 = new File(this.context.getFilesDir(), ".b");
                    if (!file4.exists()) {
                        file4.mkdir();
                    }
                    File file5 = new File(file4, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                    com.baidu.sofire.b.e.a(file3, file5);
                    com.baidu.sofire.c.a(this.context, apkInfo.key, file3, file5);
                }
                apkInfo.pkgPath = file3.getAbsolutePath();
                boolean a5 = this.forHostAPP.a(apkInfo, "before update, time=" + System.currentTimeMillis() + ", downloadAPK path:" + file3.getAbsolutePath() + ", exists=" + file3.exists() + ", canRead=" + file3.canRead() + ", isFile=" + file3.isFile() + ",length" + file3.length());
                new StringBuilder().append(apkInfo.packageName).append(" s=").append(a5);
                if (!a5) {
                    if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                        this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(j, 5));
                        return;
                    }
                    return;
                }
                int g = this.loadedPluginDB.g(apkInfo.key);
                new StringBuilder("new plugin now loadStatus :").append(apkInfo.key).append(" ").append(g);
                if (g < 3 && g != -1) {
                    this.loadedPluginDB.b(apkInfo.key, g + 1);
                }
                if (this.mUpgradeResultMap != null) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(j, 1));
                    return;
                }
                return;
            }
            if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(j, 8));
            }
            if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                if (b.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                    sSetRetrmAlarm = true;
                    b.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
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
            long j2 = eVar.a.getLong("pu_ap_fd", 0L);
            if (j2 == 0) {
                j2 = System.currentTimeMillis();
                eVar.c.putLong("pu_ap_fd", System.currentTimeMillis());
                eVar.c.commit();
            }
            if (currentTimeMillis - j2 > 86400000) {
                HashMap hashMap = new HashMap();
                if (com.baidu.sofire.b.e.c(this.context)) {
                    hashMap.put("0", Integer.valueOf(this.preference.a.getInt("wi_fa_pu_ap", 0) + 1));
                    hashMap.put("1", Integer.valueOf(this.preference.a.getInt("mo_fa_pu_ap", 0)));
                } else {
                    hashMap.put("0", Integer.valueOf(this.preference.a.getInt("wi_fa_pu_ap", 0)));
                    hashMap.put("1", Integer.valueOf(this.preference.a.getInt("mo_fa_pu_ap", 0) + 1));
                }
                e eVar2 = this.preference;
                eVar2.c.putInt("wi_fa_pu_ap", 0);
                eVar2.c.commit();
                e eVar3 = this.preference;
                eVar3.c.putInt("mo_fa_pu_ap", 0);
                eVar3.c.commit();
                e eVar4 = this.preference;
                eVar4.c.putLong("pu_ap_fd", System.currentTimeMillis());
                eVar4.c.commit();
                com.baidu.sofire.b.e.a(this.context, "1003116", hashMap);
            } else if (com.baidu.sofire.b.e.c(this.context)) {
                e eVar5 = this.preference;
                eVar5.c.putInt("wi_fa_pu_ap", this.preference.a.getInt("wi_fa_pu_ap", 0) + 1);
                eVar5.c.commit();
            } else {
                e eVar6 = this.preference;
                eVar6.c.putInt("mo_fa_pu_ap", this.preference.a.getInt("mo_fa_pu_ap", 0) + 1);
                eVar6.c.commit();
            }
            file3.delete();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            try {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(com.baidu.sofire.b.e.j(this.context), 2));
                }
            } catch (Throwable th2) {
                com.baidu.sofire.b.e.a(th2);
            }
            try {
                List<Integer> b2 = this.preference.b();
                if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                    if (b2.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                        sSetRetrmAlarm = true;
                        b.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
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

    public static void handleUploadPidChange(Context context, Intent intent) {
        try {
            b.a(context);
            e eVar = new e(context);
            JSONArray jSONArray = new JSONArray();
            String string = eVar.a.getString("pdcgts", "");
            com.baidu.sofire.b.e.g(context);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(BaseRequestAction.SPLITE);
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(Long.valueOf(str));
                    }
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.valueOf(eVar.a.getInt("rtqe", 0)));
            hashMap.put("1", Integer.valueOf(eVar.a.getInt("pdcg", 0)));
            hashMap.put("2", jSONArray);
            eVar.c.putInt("rtqe", 0);
            eVar.c.commit();
            eVar.c.putInt("pdcg", 0);
            eVar.c.commit();
            eVar.a(0L);
            com.baidu.sofire.b.e.a(context, "1003122", hashMap);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }
}
