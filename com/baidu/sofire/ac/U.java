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
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.b.b;
import com.baidu.sofire.b.e;
import com.baidu.sofire.b.f;
import com.baidu.sofire.b.i;
import com.baidu.sofire.b.j;
import com.baidu.sofire.b.k;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.d;
import com.baidu.sofire.jni.Asc;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
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
    private d preference;
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
        this.loadedPluginDB = com.baidu.sofire.a.a.aA(context);
        this.preference = new d(context);
        this.forHostAPP = c.aB(context);
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
        this.loadedPluginDB = com.baidu.sofire.a.a.aA(context);
        this.preference = new d(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.forHostAPP = c.aB(context);
        this.mFrom = intent.getIntExtra("from", 0);
        start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [718=4, 719=4, 722=4] */
    @Override // java.lang.Thread, java.lang.Runnable
    public synchronized void run() {
        String str;
        String str2;
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
                    if (com.baidu.sofire.b.d.d(this.context)) {
                        sLastCheckTime = System.currentTimeMillis();
                    }
                    b.a(this.context, false);
                    Context context = this.context;
                    com.baidu.sofire.a.a aA = com.baidu.sofire.a.a.aA(context);
                    c aB = c.aB(context);
                    for (ApkInfo apkInfo : aA.a()) {
                        if (apkInfo.duration != 0 && apkInfo.startTime + (apkInfo.duration * 60 * 1000) < System.currentTimeMillis()) {
                            String str3 = apkInfo.packageName;
                            new StringBuilder().append(str3);
                            new c.AnonymousClass4(str3).start();
                        }
                    }
                    if (this.mFrom == 1 || this.mFrom == 3) {
                        sRetryPingTimesCount = 0;
                        sRetryDownoadHostCareApksTimesCount = 0;
                        b.c(this.context, 0, true);
                        sSetRetrmAlarm = false;
                    }
                    if (this.mFrom == 2) {
                        sSetRetrmAlarm = false;
                    }
                    if (!com.baidu.sofire.b.d.d(this.context)) {
                        if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                            sMonitorNetworkWhenUpgradeNoNet = true;
                            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                            if (com.baidu.sofire.b.d.aET == null) {
                                com.baidu.sofire.b.d.aET = new MyReceiver().a();
                            }
                            this.context.getApplicationContext().registerReceiver(com.baidu.sofire.b.d.aET, intentFilter);
                        }
                        if (this.mEndReason == 0) {
                            this.mEndReason = 3;
                        }
                        throw new NetworkErrorException("no internet");
                    }
                    sLastCheckTime = System.currentTimeMillis();
                    if (com.baidu.sofire.b.d.aET != null && (sMonitorNetworkWhenUpgradeNoNet || com.baidu.sofire.b.d.a)) {
                        this.context.getApplicationContext().unregisterReceiver(com.baidu.sofire.b.d.aET);
                    }
                    sMonitorNetworkWhenUpgradeNoNet = false;
                    com.baidu.sofire.b.d.a = false;
                    String str4 = com.baidu.sofire.b.d.a() + "opmon";
                    if (TextUtils.isEmpty(new i(this.context, (byte) 0).a(str4)) && TextUtils.isEmpty(new i(this.context, (byte) 0).a(str4))) {
                        if ((this.mFrom == 1 || this.mFrom == 2 || (this.mFrom == 3 && !sSetRetrmAlarm)) && this.preference.b().size() > 0) {
                            sSetRetrmAlarm = true;
                            b.c(this.context, sRetryPingTimesCount, false);
                            sRetryPingTimesCount++;
                        }
                        IntentFilter intentFilter2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        if (com.baidu.sofire.b.d.aET == null) {
                            com.baidu.sofire.b.d.aET = new MyReceiver().a();
                        } else {
                            com.baidu.sofire.b.d.aET.a();
                        }
                        this.context.getApplicationContext().registerReceiver(com.baidu.sofire.b.d.aET, intentFilter2);
                        sMonitorNetworkWhenUpgradeNoNet = true;
                        if (this.mEndReason == 0) {
                            this.mEndReason = 4;
                        }
                        throw new NetworkErrorException("ping faild");
                    }
                    sRetryPingTimesCount = 0;
                    Context context2 = this.context;
                    String[] e = com.baidu.sofire.b.d.e(context2);
                    if (e == null || e.length != 2 || TextUtils.isEmpty(e[0]) || TextUtils.isEmpty(e[1])) {
                        str = "";
                        str2 = "";
                    } else {
                        String str5 = e[0];
                        str = e[1];
                        str2 = str5;
                    }
                    boolean z = false;
                    if ((TextUtils.isEmpty(str2) || "3".equals(str2) || TextUtils.isEmpty(str) || "925fc15df8a49bed0b3eca8d2b44cb7b".equals(str)) ? true : true) {
                        JSONObject jSONObject = new JSONObject();
                        String packageName = context2.getPackageName();
                        jSONObject.put(PushConstants.URI_PACKAGE_NAME, packageName);
                        PackageInfo packageInfo = context2.getPackageManager().getPackageInfo(packageName, 64);
                        if (packageInfo != null) {
                            PublicKey cd = com.baidu.sofire.b.c.cd(packageInfo.applicationInfo.sourceDir);
                            PublicKey publicKey = (cd != null || packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo.signatures[0] == null) ? cd : CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray())).getPublicKey();
                            if (publicKey != null) {
                                byte[] encoded = publicKey.getEncoded();
                                if (encoded != null) {
                                    com.baidu.sofire.b.d.a(context2, encoded);
                                    jSONObject.put("sm", j.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                                }
                            } else {
                                jSONObject.put("sm", "");
                            }
                        } else {
                            jSONObject.put("sm", "");
                        }
                        String a2 = f.a(context2, com.baidu.sofire.b.d.a() + "plugin/v1/product/key", jSONObject.toString(), false, false, "");
                        new StringBuilder().append(a2);
                        JSONObject jSONObject2 = new JSONObject(a2);
                        String optString = jSONObject2.optString("ak");
                        String optString2 = jSONObject2.optString("sk");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            c.aB(context2).a(optString, optString2);
                        }
                    }
                    this.forHostAPP.b(this.context);
                    if (TextUtils.isEmpty(this.preference.a())) {
                        k.a(this.context);
                        this.preference.a();
                    }
                    if (this.preference.a.getInt("appinv_t", 0) == 1) {
                        k.b(this.context);
                    }
                    this.loadedPluginDB.d();
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = new JSONObject();
                    String packageName2 = this.context.getPackageName();
                    jSONObject5.put(PushConstants.URI_PACKAGE_NAME, packageName2);
                    jSONObject4.put(PushConstants.URI_PACKAGE_NAME, packageName2);
                    jSONObject4.put("dm", Build.MODEL);
                    jSONObject5.put("dm", Build.MODEL);
                    jSONObject4.put("cuid", e.a(this.context));
                    jSONObject4.put("al", String.valueOf(Build.VERSION.SDK_INT));
                    jSONObject5.put("al", String.valueOf(Build.VERSION.SDK_INT));
                    jSONObject4.put("ev", "3.0.6.1");
                    PackageInfo packageInfo2 = this.context.getPackageManager().getPackageInfo(packageName2, 64);
                    if (packageInfo2 == null) {
                        if (this.mEndReason == 0) {
                            this.mEndReason = 6;
                        }
                        throw new NetworkErrorException("hostPkgInfo is null");
                    }
                    jSONObject4.put("av", packageInfo2.versionName);
                    jSONObject5.put("av", packageInfo2.versionName);
                    PublicKey cd2 = com.baidu.sofire.b.c.cd(packageInfo2.applicationInfo.sourceDir);
                    PublicKey publicKey2 = (cd2 != null || packageInfo2.signatures == null || packageInfo2.signatures.length <= 0 || packageInfo2.signatures[0] == null) ? cd2 : CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo2.signatures[0].toByteArray())).getPublicKey();
                    if (publicKey2 != null) {
                        byte[] encoded2 = publicKey2.getEncoded();
                        if (encoded2 != null) {
                            com.baidu.sofire.b.d.a(this.context, encoded2);
                            String a3 = j.a(Base64.encodeToString(encoded2, 0).replace("\n", "").replace("\r", ""));
                            jSONObject4.put("sm", a3);
                            jSONObject5.put("sm", a3);
                        } else {
                            jSONObject4.put("sm", "");
                            jSONObject5.put("sm", "");
                        }
                    }
                    jSONObject4.put("or", this.preference.a.getInt("opi", 0));
                    jSONObject4.put("pt", this.preference.a.getLong("lslt", 0L));
                    jSONObject3.put("device", jSONObject4);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject5);
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(k.a);
                    for (String str6 : hashMap.keySet()) {
                        JSONObject jSONObject6 = new JSONObject((String) hashMap.get(str6));
                        if (jSONObject6 != null) {
                            jSONArray.put(jSONObject6);
                        }
                    }
                    jSONObject3.put("host_apps", jSONArray);
                    String jSONObject7 = jSONObject3.toString();
                    String str7 = com.baidu.sofire.b.d.a() + "plugin/v1/plugins";
                    if (!sPidRegister) {
                        d dVar = this.preference;
                        dVar.c.putInt("pdcg", this.preference.a.getInt("pdcg", 0) + 1);
                        dVar.c.commit();
                        this.preference.a(System.currentTimeMillis());
                        sPidRegister = true;
                    }
                    d dVar2 = this.preference;
                    dVar2.c.putInt("rtqe", this.preference.a.getInt("rtqe", 0) + 1);
                    dVar2.c.commit();
                    String a4 = f.a(this.context, str7, jSONObject7, true, false, "");
                    new StringBuilder().append(a4);
                    JSONObject jSONObject8 = new JSONObject(a4);
                    if (jSONObject8 == null) {
                        if (this.mEndReason == 0) {
                            this.mEndReason = 9;
                        }
                        throw new NetworkErrorException("response json is null");
                    }
                    List<ApkInfo> a5 = this.loadedPluginDB.a();
                    new StringBuilder("a=").append(a5);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    JSONArray optJSONArray = jSONObject8.optJSONArray("product");
                    long optLong = jSONObject8.optLong("pt");
                    if (optJSONArray != null && optJSONArray.length() > 0 && optLong > 0) {
                        this.preference.a(optJSONArray.toString(), optLong);
                        com.baidu.sofire.b.d.f(this.context);
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
                            int optInt = optJSONObject2.optInt(NotifyType.LIGHTS);
                            String optString3 = optJSONObject2.optString(NotifyType.VIBRATE);
                            if (this.mCloudKeyMap != null) {
                                this.mCloudKeyMap.put(Integer.valueOf(optInt), optString3);
                            }
                            String optString4 = optJSONObject2.optString("u");
                            String optString5 = optJSONObject2.optString("m");
                            String optString6 = optJSONObject2.optString("sm");
                            if (optString5 != null) {
                                optString5 = optString5.toLowerCase();
                            }
                            String lowerCase = optString6 != null ? optString6.toLowerCase() : optString6;
                            boolean z2 = optJSONObject2.optInt("o") == 1;
                            boolean z3 = optJSONObject2.optInt("d") == 1;
                            int optInt2 = optJSONObject2.optInt("r");
                            if (z2) {
                                d dVar3 = this.preference;
                                if (optInt2 > dVar3.a.getInt("opi", 0)) {
                                    dVar3.c.putInt("opi", optInt2);
                                    dVar3.c.commit();
                                }
                            }
                            if (z2 && z3) {
                                arrayList3.add(next);
                            } else {
                                PackageInfo packageInfo3 = new PackageInfo();
                                packageInfo3.packageName = optJSONObject2.optString("p");
                                packageInfo3.versionName = optJSONObject2.optString(NotifyType.VIBRATE);
                                ApplicationInfo applicationInfo = new ApplicationInfo();
                                applicationInfo.className = optJSONObject2.optString("n");
                                if (!TextUtils.isEmpty(applicationInfo.className) && applicationInfo.className.startsWith(".")) {
                                    applicationInfo.className = next + applicationInfo.className;
                                }
                                applicationInfo.theme = optJSONObject2.optInt(Info.kBaiduTimeKey);
                                packageInfo3.applicationInfo = applicationInfo;
                                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("a");
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
                                            activityInfo.theme = jSONObject9.optInt(Info.kBaiduTimeKey);
                                            activityInfo.labelRes = jSONObject9.optInt(NotifyType.LIGHTS);
                                            if (!TextUtils.isEmpty(activityInfo.name)) {
                                                arrayList4.add(activityInfo);
                                            }
                                        }
                                        i = i2 + 1;
                                    }
                                    if (arrayList4.size() > 0) {
                                        packageInfo3.activities = (ActivityInfo[]) arrayList4.toArray(new ActivityInfo[arrayList4.size()]);
                                    }
                                }
                                ApkInfo apkInfo2 = new ApkInfo(optInt, next, optString3, optString4, optString5);
                                apkInfo2.isOnce = z2 ? 1 : 0;
                                apkInfo2.priority = optJSONObject2.getInt("pr");
                                apkInfo2.isMem = optJSONObject2.optInt("mem") == 1;
                                if (packageInfo3 != null) {
                                    apkInfo2.cloudPkgInfo = packageInfo3;
                                }
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("e");
                                if (optJSONObject3 != null) {
                                    int optInt3 = optJSONObject3.optInt("d");
                                    int optInt4 = optJSONObject3.optInt("n");
                                    apkInfo2.duration = optInt3;
                                    apkInfo2.network = optInt4;
                                }
                                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("ext");
                                if (optJSONObject4 != null && optJSONObject4.optInt("a") == 1) {
                                    List<Integer> b = this.preference.b();
                                    if (optInt > 0 && !b.contains(Integer.valueOf(optInt))) {
                                        b.add(Integer.valueOf(optInt));
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
                                        this.preference.l(iArr);
                                    }
                                }
                                apkInfo2.signMD5 = lowerCase;
                                apkInfo2.startTime = System.currentTimeMillis();
                                int indexOf = a5.indexOf(apkInfo2);
                                new StringBuilder("t=").append(apkInfo2).append(", i=").append(indexOf);
                                if (indexOf >= 0) {
                                    ApkInfo apkInfo3 = a5.get(indexOf);
                                    if (!com.baidu.sofire.b.d.c(apkInfo2.versionName, apkInfo3.versionName) || (c.c != null && (c.c == null || c.c.contains(Integer.valueOf(apkInfo2.key))))) {
                                        if (apkInfo3.priority != apkInfo2.priority) {
                                            apkInfo3.priority = apkInfo2.priority;
                                            this.loadedPluginDB.as(apkInfo2.key, apkInfo2.priority);
                                        }
                                        arrayList.add(apkInfo3);
                                    } else {
                                        if (apkInfo3.priority != apkInfo2.priority) {
                                            this.loadedPluginDB.as(apkInfo2.key, apkInfo2.priority);
                                        }
                                        if (!this.loadedPluginDB.dY(apkInfo3.key)) {
                                            arrayList2.add(apkInfo2);
                                            if (this.mDownloadPluginsList != null) {
                                                this.mDownloadPluginsList.add(Integer.valueOf(apkInfo2.key));
                                            }
                                        }
                                    }
                                    a5.remove(indexOf);
                                } else {
                                    arrayList2.add(apkInfo2);
                                    if (this.mDownloadPluginsList != null) {
                                        this.mDownloadPluginsList.add(Integer.valueOf(apkInfo2.key));
                                    }
                                }
                            }
                        }
                    }
                    if (c.c != null) {
                        c.c.clear();
                    }
                    new StringBuilder().append(a5);
                    for (ApkInfo apkInfo4 : a5) {
                        if (!arrayList3.contains(apkInfo4.packageName)) {
                            if (this.mUnloadPluginsList != null) {
                                this.mUnloadPluginsList.add(Integer.valueOf(apkInfo4.key));
                            }
                            c cVar = this.forHostAPP;
                            String str8 = apkInfo4.packageName;
                            new StringBuilder().append(str8);
                            new c.AnonymousClass4(str8).start();
                        }
                    }
                    com.baidu.sofire.b.d.a(this.context);
                    new StringBuilder().append(arrayList);
                    com.baidu.sofire.core.e aC = com.baidu.sofire.core.e.aC(this.context.getApplicationContext());
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
                            if (aC.cf(apkInfo5.packageName) == null) {
                                boolean z4 = this.loadedPluginDB.dZ(apkInfo5.key) != 3;
                                if (this.preference.a.getBoolean("bka", true) && z4) {
                                    File file = new File(this.context.getFilesDir(), ".b");
                                    if (!file.exists()) {
                                        file.mkdir();
                                    }
                                    File file2 = new File(apkInfo5.pkgPath);
                                    File file3 = new File(file, apkInfo5.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo5.versionName);
                                    if (!com.baidu.sofire.b.d.a(file3)) {
                                        com.baidu.sofire.b.d.a(file2, file3);
                                    }
                                    com.baidu.sofire.b.a(this.context, apkInfo5.key, file2, file3);
                                } else {
                                    File file4 = new File(this.context.getFilesDir(), ".b");
                                    if (file4.exists()) {
                                        File file5 = new File(file4, apkInfo5.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo5.versionName);
                                        if (com.baidu.sofire.b.d.a(file5)) {
                                            com.baidu.sofire.b.a(file5);
                                            new StringBuilder().append(file5.getAbsolutePath()).append(" s=").append(file5.delete());
                                        }
                                    }
                                }
                                this.forHostAPP.a(apkInfo5.key, apkInfo5.versionName, null);
                            }
                        } else if (arrayList2.contains(apkInfo5) && !this.loadedPluginDB.dY(apkInfo5.key)) {
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
            d dVar = this.preference;
            dVar.c.putInt("sufzfd", this.preference.a.getInt("sufzfd", 0) + 1);
            dVar.c.commit();
            if (this.mEndReason != 0) {
                this.preference.a(1, this.mEndReason, this.preference.a(1, this.mEndReason) + 1);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
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
                hashMap.put("8", jSONObject);
            }
            Map<Integer, String> b = this.loadedPluginDB.b();
            hashMap.put("9", b.keySet());
            hashMap.put("10", b.values());
            hashMap.put("11", Integer.valueOf(this.mEndReason));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("12", str.replace("\n", "").replace("\t", "").replace("\r", ""));
            }
            hashMap.put("13", Integer.valueOf(this.mStartNetwork));
            hashMap.put("14", Integer.valueOf(com.baidu.sofire.b.d.h(this.context)));
            com.baidu.sofire.b.d.a(this.context, "1003129", hashMap);
        } catch (Throwable th2) {
            com.baidu.sofire.b.d.a(th2);
        }
    }

    private void handleThreadStart() {
        try {
            long j = this.preference.a.getLong("slruct", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (j > 0 && currentTimeMillis - j > 86400000) {
                HashMap hashMap = new HashMap();
                hashMap.put("1", Integer.valueOf(this.preference.a.getInt("sustfd", 0)));
                d dVar = this.preference;
                dVar.c.putInt("sustfd", 0);
                dVar.c.commit();
                JSONObject jSONObject = new JSONObject();
                for (int i = 1; i <= 6; i++) {
                    jSONObject.put(String.valueOf(i), this.preference.a(0, i));
                    this.preference.a(0, i, 0);
                }
                hashMap.put("2", jSONObject);
                hashMap.put("3", Integer.valueOf(this.preference.a.getInt("sufzfd", 0)));
                d dVar2 = this.preference;
                dVar2.c.putInt("sufzfd", 0);
                dVar2.c.commit();
                JSONObject jSONObject2 = new JSONObject();
                for (int i2 = 1; i2 <= 11; i2++) {
                    jSONObject2.put(String.valueOf(i2), this.preference.a(1, i2));
                    this.preference.a(1, i2, 0);
                }
                hashMap.put("4", jSONObject2);
                com.baidu.sofire.b.d.a(this.context, "1003128", hashMap);
                d dVar3 = this.preference;
                dVar3.c.putLong("slruct", currentTimeMillis);
                dVar3.c.commit();
            } else if (j == 0) {
                d dVar4 = this.preference;
                dVar4.c.putLong("slruct", currentTimeMillis);
                dVar4.c.commit();
            }
        } catch (Throwable th) {
            try {
                d dVar5 = this.preference;
                dVar5.c.putInt("sustfd", 0);
                dVar5.c.commit();
                d dVar6 = this.preference;
                dVar6.c.putInt("sufzfd", 0);
                dVar6.c.commit();
                for (int i3 = 1; i3 <= 6; i3++) {
                    this.preference.a(0, i3, 0);
                }
                for (int i4 = 1; i4 <= 11; i4++) {
                    this.preference.a(1, i4, 0);
                }
            } catch (Throwable th2) {
                com.baidu.sofire.b.d.a(th2);
            }
            com.baidu.sofire.b.d.a(th);
        }
        try {
            this.mStartKeyMap = this.loadedPluginDB.b();
            d dVar7 = this.preference;
            dVar7.c.putInt("sustfd", this.preference.a.getInt("sustfd", 0) + 1);
            dVar7.c.commit();
            if (this.mFrom != 0) {
                this.preference.a(0, this.mFrom, this.preference.a(0, this.mFrom) + 1);
            }
            this.mStartNetwork = com.baidu.sofire.b.d.h(this.context);
        } catch (Throwable th3) {
            com.baidu.sofire.b.d.a(th3);
        }
    }

    private void handlePluginUpgrade(ApkInfo apkInfo) {
        try {
            int h = com.baidu.sofire.b.d.h(this.context);
            new StringBuilder("a=").append(apkInfo);
            List<Integer> b = this.preference.b();
            if (!b.contains(Integer.valueOf(apkInfo.key)) && !com.baidu.sofire.b.d.a(this.context, apkInfo.network)) {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(h, 3));
                    return;
                }
                return;
            }
            if (!this.tmpDir.exists()) {
                this.tmpDir.mkdir();
            }
            StringBuilder sb = new StringBuilder("before update, time=" + System.currentTimeMillis() + ", ");
            ApkInfo dW = this.loadedPluginDB.dW(apkInfo.key);
            if (dW == null) {
                sb.append("apkInDB == null");
            } else {
                File file = new File(dW.pkgPath);
                sb.append("origAPK path:" + file.getAbsolutePath() + ", exists=" + file.exists() + ", canRead=" + file.canRead() + ", isFile=" + file.isFile() + ",length" + file.length());
            }
            File file2 = new File(this.tmpDir, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".tmp");
            File file3 = new File(this.tmpDir, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".zip");
            boolean b2 = new i(this.context).b(apkInfo.downloadURL, file2);
            if (b2) {
                if (file3.exists()) {
                    file3.delete();
                }
                Asc asc = new Asc();
                byte[] bytes = apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes("utf-8");
                if (com.baidu.sofire.b.a.a(file2, file3, bytes) != 0) {
                    if (file3.exists()) {
                        file3.delete();
                    }
                    if (asc.df(file2.getAbsolutePath(), file3.getAbsolutePath(), bytes) != 0) {
                        if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(h, 7));
                        }
                        b2 = false;
                    }
                }
            } else if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(h, 4));
            }
            new StringBuilder().append(b2);
            String a2 = j.a(file3);
            new StringBuilder("ds=").append(b2).append(", fm=").append(apkInfo.apkMD5).append(", am=").append(a2);
            file2.delete();
            if (b2 && apkInfo.apkMD5.equals(a2)) {
                com.baidu.sofire.b.d.a(file3.getAbsolutePath(), true);
                if (this.preference.a.getBoolean("bka", true)) {
                    File file4 = new File(this.context.getFilesDir(), ".b");
                    if (!file4.exists()) {
                        file4.mkdir();
                    }
                    File file5 = new File(file4, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                    com.baidu.sofire.b.d.a(file3, file5);
                    com.baidu.sofire.b.a(this.context, apkInfo.key, file3, file5);
                }
                apkInfo.pkgPath = file3.getAbsolutePath();
                boolean a3 = this.forHostAPP.a(apkInfo, "before update, time=" + System.currentTimeMillis() + ", downloadAPK path:" + file3.getAbsolutePath() + ", exists=" + file3.exists() + ", canRead=" + file3.canRead() + ", isFile=" + file3.isFile() + ",length" + file3.length());
                new StringBuilder().append(apkInfo.packageName).append(" s=").append(a3);
                if (!a3) {
                    if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                        this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(h, 5));
                        return;
                    }
                    return;
                }
                int dZ = this.loadedPluginDB.dZ(apkInfo.key);
                new StringBuilder("new plugin now loadStatus :").append(apkInfo.key).append(" ").append(dZ);
                if (dZ < 3 && dZ != -1) {
                    this.loadedPluginDB.b(apkInfo.key, dZ + 1);
                }
                if (this.mUpgradeResultMap != null) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(h, 1));
                    return;
                }
                return;
            }
            if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(h, 8));
            }
            if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                if (b.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                    sSetRetrmAlarm = true;
                    b.c(this.context, sRetryDownoadHostCareApksTimesCount, false);
                    sRetryDownoadHostCareApksTimesCount++;
                }
                if (!sMonitorNetworkWhenUpgradeNoNet) {
                    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    if (com.baidu.sofire.b.d.aET == null) {
                        com.baidu.sofire.b.d.aET = new MyReceiver().a();
                    } else {
                        com.baidu.sofire.b.d.aET.a();
                    }
                    this.context.getApplicationContext().registerReceiver(com.baidu.sofire.b.d.aET, intentFilter);
                    sMonitorNetworkWhenUpgradeNoNet = true;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            d dVar = this.preference;
            long j = dVar.a.getLong("pu_ap_fd", 0L);
            if (j == 0) {
                j = System.currentTimeMillis();
                dVar.c.putLong("pu_ap_fd", System.currentTimeMillis());
                dVar.c.commit();
            }
            if (currentTimeMillis - j > 86400000) {
                HashMap hashMap = new HashMap();
                if (com.baidu.sofire.b.d.c(this.context)) {
                    hashMap.put("0", Integer.valueOf(this.preference.a.getInt("wi_fa_pu_ap", 0) + 1));
                    hashMap.put("1", Integer.valueOf(this.preference.a.getInt("mo_fa_pu_ap", 0)));
                } else {
                    hashMap.put("0", Integer.valueOf(this.preference.a.getInt("wi_fa_pu_ap", 0)));
                    hashMap.put("1", Integer.valueOf(this.preference.a.getInt("mo_fa_pu_ap", 0) + 1));
                }
                d dVar2 = this.preference;
                dVar2.c.putInt("wi_fa_pu_ap", 0);
                dVar2.c.commit();
                d dVar3 = this.preference;
                dVar3.c.putInt("mo_fa_pu_ap", 0);
                dVar3.c.commit();
                d dVar4 = this.preference;
                dVar4.c.putLong("pu_ap_fd", System.currentTimeMillis());
                dVar4.c.commit();
                com.baidu.sofire.b.d.a(this.context, "1003116", hashMap);
            } else if (com.baidu.sofire.b.d.c(this.context)) {
                d dVar5 = this.preference;
                dVar5.c.putInt("wi_fa_pu_ap", this.preference.a.getInt("wi_fa_pu_ap", 0) + 1);
                dVar5.c.commit();
            } else {
                d dVar6 = this.preference;
                dVar6.c.putInt("mo_fa_pu_ap", this.preference.a.getInt("mo_fa_pu_ap", 0) + 1);
                dVar6.c.commit();
            }
            file3.delete();
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            try {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(com.baidu.sofire.b.d.h(this.context), 2));
                }
            } catch (Throwable th2) {
                com.baidu.sofire.b.d.a(th2);
            }
            try {
                List<Integer> b3 = this.preference.b();
                if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                    if (b3.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                        sSetRetrmAlarm = true;
                        b.c(this.context, sRetryDownoadHostCareApksTimesCount, false);
                        sRetryDownoadHostCareApksTimesCount++;
                    }
                    if (!sMonitorNetworkWhenUpgradeNoNet) {
                        IntentFilter intentFilter2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        if (com.baidu.sofire.b.d.aET == null) {
                            com.baidu.sofire.b.d.aET = new MyReceiver().a();
                        } else {
                            com.baidu.sofire.b.d.aET.a();
                        }
                        this.context.getApplicationContext().registerReceiver(com.baidu.sofire.b.d.aET, intentFilter2);
                        sMonitorNetworkWhenUpgradeNoNet = true;
                    }
                }
            } catch (Throwable th3) {
                com.baidu.sofire.b.d.a(th3);
            }
        }
    }

    public static void handleUploadPidChange(Context context, Intent intent) {
        try {
            b.a(context);
            d dVar = new d(context);
            JSONArray jSONArray = new JSONArray();
            String string = dVar.a.getString("pdcgts", "");
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split("_");
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(Long.valueOf(str));
                    }
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.valueOf(dVar.a.getInt("rtqe", 0)));
            hashMap.put("1", Integer.valueOf(dVar.a.getInt("pdcg", 0)));
            hashMap.put("2", jSONArray);
            dVar.c.putInt("rtqe", 0);
            dVar.c.commit();
            dVar.c.putInt("pdcg", 0);
            dVar.c.commit();
            dVar.a(0L);
            com.baidu.sofire.b.d.a(context, "1003122", hashMap);
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }
}
