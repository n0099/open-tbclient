package com.baidu.sofire.utility;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.XmlResourceParser;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.rp.Report;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.tieba.service.AsInstallService;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10399a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f10400b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f10401c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f10402d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static String f10403e = "3";

    /* renamed from: f  reason: collision with root package name */
    public static String f10404f = "925fc15df8a49bed0b3eca8d2b44cb7b";

    /* renamed from: g  reason: collision with root package name */
    public static MyReceiver f10405g = null;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<Integer, ApkInfo> f10406h = null;

    /* renamed from: i  reason: collision with root package name */
    public static JSONObject f10407i = null;
    public static long j = 0;
    public static int k = -1;
    public static String l = "";
    public static String m = "";
    public static int n = -1;
    public static int o = -1;
    public static int p = -1;

    public static void a() {
        com.baidu.sofire.b.c();
    }

    public static String b(Context context) {
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
        if (TextUtils.isEmpty(l) && o != 1) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(context.getPackageName() + ".sofire.ac.provider", 0);
            if (resolveContentProvider != null && !resolveContentProvider.multiprocess) {
                l = resolveContentProvider.processName;
            }
            o = 1;
            return l;
        }
        return l;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str));
    }

    public static void d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            d(file2.getAbsolutePath());
                        } else {
                            file2.delete();
                        }
                    }
                }
                file.delete();
            }
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && 1 == activeNetworkInfo.getType();
    }

    public static String f(String str) {
        try {
            int length = str.length();
            int i2 = 0;
            while (i2 < length && (str.charAt(i2) <= ' ' || str.charAt(i2) == 160)) {
                i2++;
            }
            return i2 > 0 ? str.substring(i2) : str;
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return "";
        }
    }

    public static String[] g(Context context) {
        String[] split;
        String[] split2;
        String str = f10400b;
        String str2 = f10401c;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                String a2 = com.baidu.sofire.h.a.a(context).a();
                if (!TextUtils.isEmpty(a2) && (split = a2.split("-")) != null && split.length == 2) {
                    return split;
                }
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                String string = com.baidu.sofire.h.a.a(context).f10321a.getString("svi", "");
                if (!TextUtils.isEmpty(string) && (split2 = string.split("-")) != null && split2.length == 2) {
                    return split2;
                }
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                str = f10403e;
                str2 = f10404f;
            }
            return new String[]{str, str2};
        }
        return new String[]{str, str2};
    }

    public static void h(Context context) {
        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = a2.f10321a.getLong("se_ae_fd", 0L);
        if (j2 == 0) {
            j2 = System.currentTimeMillis();
            a2.g();
        }
        if (currentTimeMillis - j2 > 86400000) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.valueOf(a2.j() + 1));
            a2.c(0);
            a2.g();
            a(context, "1003119", (Map<String, Object>) hashMap, false);
            return;
        }
        a2.c(a2.j() + 1);
    }

    public static boolean i(Context context) {
        try {
            if (p < 0 && context != null) {
                String packageName = context.getPackageName();
                Field field = Class.forName(packageName + ".BuildConfig").getField("DEBUG");
                field.setAccessible(true);
                p = field.getBoolean(null) ? 1 : 0;
            }
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
        return p == 1;
    }

    public static void j(Context context) throws UnsupportedOperationException {
        if (!i(context) || "com.baidu.input".equals(context.getPackageName())) {
            return;
        }
        StringBuilder sb = new StringBuilder("SDK Self Check: ");
        int length = sb.length();
        try {
            System.loadLibrary("fire");
        } catch (Throwable unused) {
            sb.append("LoadLibrary Error,");
        }
        try {
            Class.forName("com.baidu.sofire.ac.F").getDeclaredMethod("getInstance", new Class[0]);
        } catch (Exception unused2) {
            sb.append("Proguard Error,");
        }
        try {
            boolean z = context.getPackageManager().resolveContentProvider(context.getPackageName() + ".sofire.ac.provider", 0).multiprocess;
        } catch (Throwable unused3) {
            sb.append("Provider Error,");
        }
        if (!a(context, false)) {
            sb.append("Service or Receiver Error.");
        }
        if (sb.length() > length) {
            throw new UnsupportedOperationException(sb.toString());
        }
    }

    public static int k(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                if (activeNetworkInfo.getType() == 1) {
                    return 4;
                }
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                            return 1;
                        case 3:
                            return 2;
                        case 4:
                            return 1;
                        case 5:
                        case 6:
                            return 2;
                        case 7:
                            return 1;
                        case 8:
                        case 9:
                        case 10:
                            return 2;
                        case 11:
                            return 1;
                        case 12:
                            return 2;
                        case 13:
                            return 3;
                        case 14:
                        case 15:
                            return 2;
                        default:
                            return 5;
                    }
                }
                return -2;
            }
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
        return -1;
    }

    public static JSONObject l(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = Build.BOARD;
            if (str == null) {
                str = "";
            }
            jSONObject.put("0", str);
            String str2 = Build.DEVICE;
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("1", str2);
            String b2 = e.b();
            if (b2 == null) {
                b2 = "";
            }
            jSONObject.put("2", b2);
            String str3 = Build.HOST;
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("3", str3);
            String a2 = e.a();
            if (a2 == null) {
                a2 = "";
            }
            jSONObject.put("4", a2);
            String str4 = Build.PRODUCT;
            if (str4 == null) {
                str4 = "";
            }
            jSONObject.put("5", str4);
            String str5 = Build.VERSION.CODENAME;
            if (str5 == null) {
                str5 = "";
            }
            jSONObject.put("6", str5);
            String str6 = Build.VERSION.INCREMENTAL;
            if (str6 == null) {
                str6 = "";
            }
            jSONObject.put("7", str6);
            jSONObject.put("8", e.b(context));
            String c2 = e.c();
            if (c2 == null) {
                c2 = "";
            }
            jSONObject.put("9", c2);
            String d2 = e.d();
            if (d2 == null) {
                d2 = "";
            }
            jSONObject.put("10", d2);
            jSONObject.put("11", e.f(context));
            String e2 = e.e();
            if (e2 == null) {
                e2 = "";
            }
            jSONObject.put("12", e2);
            jSONObject.put("13", e.c(context));
            jSONObject.put("14", "");
            jSONObject.put(Constants.VIA_REPORT_TYPE_START_GROUP, s.k(context));
            jSONObject.put("18", s.l(context));
            jSONObject.put("20", Build.VERSION.SDK_INT);
            TimeZone timeZone = TimeZone.getDefault();
            if (timeZone != null) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, timeZone.getID());
            } else {
                jSONObject.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, "-1");
            }
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
        return jSONObject;
    }

    public static int m(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            networkInfo = null;
        }
        if (networkInfo == null) {
            return 0;
        }
        if (1 == networkInfo.getType()) {
            return 2;
        }
        if (networkInfo.getType() == 0) {
        }
        return 1;
    }

    public static void n(Context context) {
        try {
            MyReceiver myReceiver = new MyReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.action.SOFIRE.VIEW");
            intentFilter.addCategory("com.baidu.category.SOFIRE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            context.registerReceiver(myReceiver, intentFilter, context.getPackageName() + ".permission.sofire.RECEIVE", null);
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(34:20|21|22|23|(3:225|(3:227|(1:232)|233)(1:235)|234)(1:27)|28|(1:224)(1:37)|(2:42|(4:46|48|49|(29:59|60|61|62|63|(1:65)|66|(1:68)|69|(1:71)|72|(1:74)|75|(1:77)|78|(1:80)|81|(1:83)|84|(1:86)|87|(1:89)|90|91|92|(1:94)|96|(1:98)(14:101|(2:103|(1:105)(1:211))(1:212)|106|(1:108)(1:210)|109|(1:111)(1:209)|112|(1:114)(1:208)|115|(1:120)|121|(1:123)|124|(2:127|(41:129|130|131|132|(1:134)(1:205)|135|137|138|(1:140)(1:203)|141|142|143|(1:145)(1:200)|146|147|148|149|(1:151)(1:197)|152|153|154|155|(1:157)(1:194)|158|159|160|(1:162)(1:191)|163|164|165|167|168|(1:170)(1:187)|171|172|173|174|176|177|(1:179)(1:182)|180)))|99)))|223|63|(0)|66|(0)|69|(0)|72|(0)|75|(0)|78|(0)|81|(0)|84|(0)|87|(0)|90|91|92|(0)|96|(0)(0)|99) */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02f0, code lost:
        com.baidu.sofire.b.c();
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x027f A[Catch: all -> 0x02b6, TryCatch #7 {all -> 0x04e9, blocks: (B:3:0x0016, B:6:0x0038, B:7:0x003b, B:13:0x0073, B:16:0x0097, B:19:0x009f, B:22:0x00c5, B:24:0x0102, B:81:0x01e8, B:20:0x00bd, B:226:0x04e4, B:9:0x0068, B:82:0x01eb, B:84:0x0201, B:85:0x020d, B:87:0x0215, B:88:0x0221, B:90:0x0229, B:91:0x0235, B:93:0x023e, B:94:0x024a, B:96:0x0252, B:97:0x0262, B:99:0x026a, B:100:0x0276, B:102:0x027f, B:103:0x028b, B:105:0x0293, B:106:0x02a0, B:108:0x02a8, B:111:0x02b9, B:117:0x02f3, B:120:0x02fd, B:122:0x0352, B:124:0x035f, B:127:0x0369, B:129:0x0371, B:131:0x0378, B:133:0x037f, B:135:0x0388, B:137:0x038f, B:139:0x03a0, B:144:0x03ba, B:145:0x03c6, B:147:0x03ce, B:148:0x03d1, B:151:0x03db, B:220:0x04da, B:138:0x039c, B:134:0x0384, B:130:0x0375, B:125:0x0363, B:116:0x02f0), top: B:241:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0293 A[Catch: all -> 0x02b6, TryCatch #7 {all -> 0x04e9, blocks: (B:3:0x0016, B:6:0x0038, B:7:0x003b, B:13:0x0073, B:16:0x0097, B:19:0x009f, B:22:0x00c5, B:24:0x0102, B:81:0x01e8, B:20:0x00bd, B:226:0x04e4, B:9:0x0068, B:82:0x01eb, B:84:0x0201, B:85:0x020d, B:87:0x0215, B:88:0x0221, B:90:0x0229, B:91:0x0235, B:93:0x023e, B:94:0x024a, B:96:0x0252, B:97:0x0262, B:99:0x026a, B:100:0x0276, B:102:0x027f, B:103:0x028b, B:105:0x0293, B:106:0x02a0, B:108:0x02a8, B:111:0x02b9, B:117:0x02f3, B:120:0x02fd, B:122:0x0352, B:124:0x035f, B:127:0x0369, B:129:0x0371, B:131:0x0378, B:133:0x037f, B:135:0x0388, B:137:0x038f, B:139:0x03a0, B:144:0x03ba, B:145:0x03c6, B:147:0x03ce, B:148:0x03d1, B:151:0x03db, B:220:0x04da, B:138:0x039c, B:134:0x0384, B:130:0x0375, B:125:0x0363, B:116:0x02f0), top: B:241:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02a8 A[Catch: all -> 0x02b6, TRY_LEAVE, TryCatch #7 {all -> 0x04e9, blocks: (B:3:0x0016, B:6:0x0038, B:7:0x003b, B:13:0x0073, B:16:0x0097, B:19:0x009f, B:22:0x00c5, B:24:0x0102, B:81:0x01e8, B:20:0x00bd, B:226:0x04e4, B:9:0x0068, B:82:0x01eb, B:84:0x0201, B:85:0x020d, B:87:0x0215, B:88:0x0221, B:90:0x0229, B:91:0x0235, B:93:0x023e, B:94:0x024a, B:96:0x0252, B:97:0x0262, B:99:0x026a, B:100:0x0276, B:102:0x027f, B:103:0x028b, B:105:0x0293, B:106:0x02a0, B:108:0x02a8, B:111:0x02b9, B:117:0x02f3, B:120:0x02fd, B:122:0x0352, B:124:0x035f, B:127:0x0369, B:129:0x0371, B:131:0x0378, B:133:0x037f, B:135:0x0388, B:137:0x038f, B:139:0x03a0, B:144:0x03ba, B:145:0x03c6, B:147:0x03ce, B:148:0x03d1, B:151:0x03db, B:220:0x04da, B:138:0x039c, B:134:0x0384, B:130:0x0375, B:125:0x0363, B:116:0x02f0), top: B:241:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02c7 A[Catch: all -> 0x02f0, TRY_LEAVE, TryCatch #11 {all -> 0x02f0, blocks: (B:112:0x02bd, B:114:0x02c7), top: B:246:0x02bd }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02fd A[Catch: all -> 0x04de, TryCatch #7 {all -> 0x04e9, blocks: (B:3:0x0016, B:6:0x0038, B:7:0x003b, B:13:0x0073, B:16:0x0097, B:19:0x009f, B:22:0x00c5, B:24:0x0102, B:81:0x01e8, B:20:0x00bd, B:226:0x04e4, B:9:0x0068, B:82:0x01eb, B:84:0x0201, B:85:0x020d, B:87:0x0215, B:88:0x0221, B:90:0x0229, B:91:0x0235, B:93:0x023e, B:94:0x024a, B:96:0x0252, B:97:0x0262, B:99:0x026a, B:100:0x0276, B:102:0x027f, B:103:0x028b, B:105:0x0293, B:106:0x02a0, B:108:0x02a8, B:111:0x02b9, B:117:0x02f3, B:120:0x02fd, B:122:0x0352, B:124:0x035f, B:127:0x0369, B:129:0x0371, B:131:0x0378, B:133:0x037f, B:135:0x0388, B:137:0x038f, B:139:0x03a0, B:144:0x03ba, B:145:0x03c6, B:147:0x03ce, B:148:0x03d1, B:151:0x03db, B:220:0x04da, B:138:0x039c, B:134:0x0384, B:130:0x0375, B:125:0x0363, B:116:0x02f0), top: B:241:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0201 A[Catch: all -> 0x02b6, TryCatch #7 {all -> 0x04e9, blocks: (B:3:0x0016, B:6:0x0038, B:7:0x003b, B:13:0x0073, B:16:0x0097, B:19:0x009f, B:22:0x00c5, B:24:0x0102, B:81:0x01e8, B:20:0x00bd, B:226:0x04e4, B:9:0x0068, B:82:0x01eb, B:84:0x0201, B:85:0x020d, B:87:0x0215, B:88:0x0221, B:90:0x0229, B:91:0x0235, B:93:0x023e, B:94:0x024a, B:96:0x0252, B:97:0x0262, B:99:0x026a, B:100:0x0276, B:102:0x027f, B:103:0x028b, B:105:0x0293, B:106:0x02a0, B:108:0x02a8, B:111:0x02b9, B:117:0x02f3, B:120:0x02fd, B:122:0x0352, B:124:0x035f, B:127:0x0369, B:129:0x0371, B:131:0x0378, B:133:0x037f, B:135:0x0388, B:137:0x038f, B:139:0x03a0, B:144:0x03ba, B:145:0x03c6, B:147:0x03ce, B:148:0x03d1, B:151:0x03db, B:220:0x04da, B:138:0x039c, B:134:0x0384, B:130:0x0375, B:125:0x0363, B:116:0x02f0), top: B:241:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0215 A[Catch: all -> 0x02b6, TryCatch #7 {all -> 0x04e9, blocks: (B:3:0x0016, B:6:0x0038, B:7:0x003b, B:13:0x0073, B:16:0x0097, B:19:0x009f, B:22:0x00c5, B:24:0x0102, B:81:0x01e8, B:20:0x00bd, B:226:0x04e4, B:9:0x0068, B:82:0x01eb, B:84:0x0201, B:85:0x020d, B:87:0x0215, B:88:0x0221, B:90:0x0229, B:91:0x0235, B:93:0x023e, B:94:0x024a, B:96:0x0252, B:97:0x0262, B:99:0x026a, B:100:0x0276, B:102:0x027f, B:103:0x028b, B:105:0x0293, B:106:0x02a0, B:108:0x02a8, B:111:0x02b9, B:117:0x02f3, B:120:0x02fd, B:122:0x0352, B:124:0x035f, B:127:0x0369, B:129:0x0371, B:131:0x0378, B:133:0x037f, B:135:0x0388, B:137:0x038f, B:139:0x03a0, B:144:0x03ba, B:145:0x03c6, B:147:0x03ce, B:148:0x03d1, B:151:0x03db, B:220:0x04da, B:138:0x039c, B:134:0x0384, B:130:0x0375, B:125:0x0363, B:116:0x02f0), top: B:241:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0229 A[Catch: all -> 0x02b6, TryCatch #7 {all -> 0x04e9, blocks: (B:3:0x0016, B:6:0x0038, B:7:0x003b, B:13:0x0073, B:16:0x0097, B:19:0x009f, B:22:0x00c5, B:24:0x0102, B:81:0x01e8, B:20:0x00bd, B:226:0x04e4, B:9:0x0068, B:82:0x01eb, B:84:0x0201, B:85:0x020d, B:87:0x0215, B:88:0x0221, B:90:0x0229, B:91:0x0235, B:93:0x023e, B:94:0x024a, B:96:0x0252, B:97:0x0262, B:99:0x026a, B:100:0x0276, B:102:0x027f, B:103:0x028b, B:105:0x0293, B:106:0x02a0, B:108:0x02a8, B:111:0x02b9, B:117:0x02f3, B:120:0x02fd, B:122:0x0352, B:124:0x035f, B:127:0x0369, B:129:0x0371, B:131:0x0378, B:133:0x037f, B:135:0x0388, B:137:0x038f, B:139:0x03a0, B:144:0x03ba, B:145:0x03c6, B:147:0x03ce, B:148:0x03d1, B:151:0x03db, B:220:0x04da, B:138:0x039c, B:134:0x0384, B:130:0x0375, B:125:0x0363, B:116:0x02f0), top: B:241:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x023e A[Catch: all -> 0x02b6, TryCatch #7 {all -> 0x04e9, blocks: (B:3:0x0016, B:6:0x0038, B:7:0x003b, B:13:0x0073, B:16:0x0097, B:19:0x009f, B:22:0x00c5, B:24:0x0102, B:81:0x01e8, B:20:0x00bd, B:226:0x04e4, B:9:0x0068, B:82:0x01eb, B:84:0x0201, B:85:0x020d, B:87:0x0215, B:88:0x0221, B:90:0x0229, B:91:0x0235, B:93:0x023e, B:94:0x024a, B:96:0x0252, B:97:0x0262, B:99:0x026a, B:100:0x0276, B:102:0x027f, B:103:0x028b, B:105:0x0293, B:106:0x02a0, B:108:0x02a8, B:111:0x02b9, B:117:0x02f3, B:120:0x02fd, B:122:0x0352, B:124:0x035f, B:127:0x0369, B:129:0x0371, B:131:0x0378, B:133:0x037f, B:135:0x0388, B:137:0x038f, B:139:0x03a0, B:144:0x03ba, B:145:0x03c6, B:147:0x03ce, B:148:0x03d1, B:151:0x03db, B:220:0x04da, B:138:0x039c, B:134:0x0384, B:130:0x0375, B:125:0x0363, B:116:0x02f0), top: B:241:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0252 A[Catch: all -> 0x02b6, TryCatch #7 {all -> 0x04e9, blocks: (B:3:0x0016, B:6:0x0038, B:7:0x003b, B:13:0x0073, B:16:0x0097, B:19:0x009f, B:22:0x00c5, B:24:0x0102, B:81:0x01e8, B:20:0x00bd, B:226:0x04e4, B:9:0x0068, B:82:0x01eb, B:84:0x0201, B:85:0x020d, B:87:0x0215, B:88:0x0221, B:90:0x0229, B:91:0x0235, B:93:0x023e, B:94:0x024a, B:96:0x0252, B:97:0x0262, B:99:0x026a, B:100:0x0276, B:102:0x027f, B:103:0x028b, B:105:0x0293, B:106:0x02a0, B:108:0x02a8, B:111:0x02b9, B:117:0x02f3, B:120:0x02fd, B:122:0x0352, B:124:0x035f, B:127:0x0369, B:129:0x0371, B:131:0x0378, B:133:0x037f, B:135:0x0388, B:137:0x038f, B:139:0x03a0, B:144:0x03ba, B:145:0x03c6, B:147:0x03ce, B:148:0x03d1, B:151:0x03db, B:220:0x04da, B:138:0x039c, B:134:0x0384, B:130:0x0375, B:125:0x0363, B:116:0x02f0), top: B:241:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x026a A[Catch: all -> 0x02b6, TryCatch #7 {all -> 0x04e9, blocks: (B:3:0x0016, B:6:0x0038, B:7:0x003b, B:13:0x0073, B:16:0x0097, B:19:0x009f, B:22:0x00c5, B:24:0x0102, B:81:0x01e8, B:20:0x00bd, B:226:0x04e4, B:9:0x0068, B:82:0x01eb, B:84:0x0201, B:85:0x020d, B:87:0x0215, B:88:0x0221, B:90:0x0229, B:91:0x0235, B:93:0x023e, B:94:0x024a, B:96:0x0252, B:97:0x0262, B:99:0x026a, B:100:0x0276, B:102:0x027f, B:103:0x028b, B:105:0x0293, B:106:0x02a0, B:108:0x02a8, B:111:0x02b9, B:117:0x02f3, B:120:0x02fd, B:122:0x0352, B:124:0x035f, B:127:0x0369, B:129:0x0371, B:131:0x0378, B:133:0x037f, B:135:0x0388, B:137:0x038f, B:139:0x03a0, B:144:0x03ba, B:145:0x03c6, B:147:0x03ce, B:148:0x03d1, B:151:0x03db, B:220:0x04da, B:138:0x039c, B:134:0x0384, B:130:0x0375, B:125:0x0363, B:116:0x02f0), top: B:241:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject o(Context context) {
        String str;
        String str2;
        JSONObject jSONObject;
        int optInt;
        int optInt2;
        int optInt3;
        int optInt4;
        int optInt5;
        int optInt6;
        int optInt7;
        int optInt8;
        JSONObject optJSONObject;
        String str3;
        boolean z;
        int i2;
        String optString;
        com.baidu.sofire.h.a a2;
        String[] strArr;
        String[] strArr2;
        JSONObject optJSONObject2;
        try {
            String str4 = b() + "p/5/aio";
            JSONObject jSONObject2 = new JSONObject();
            JSONArray s = s(context);
            if (s != null) {
                jSONObject2.put("0", s);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("0", Build.MODEL);
            jSONObject3.put("1", e.b(context));
            jSONObject3.put("3", String.valueOf(Build.VERSION.SDK_INT));
            jSONObject3.put("4", "3.5.8.6");
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
            if (packageInfo != null) {
                jSONObject3.put("5", f(packageInfo.applicationInfo.loadLabel(packageManager).toString()));
                jSONObject3.put("6", packageName);
                PublicKey a3 = a(packageInfo, packageInfo.applicationInfo.sourceDir);
                if (a3 != null) {
                    byte[] encoded = a3.getEncoded();
                    if (encoded != null) {
                        a(context, encoded);
                        str = "5";
                        jSONObject3.put("7", o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                    } else {
                        str = "5";
                        jSONObject3.put("7", "");
                    }
                } else {
                    str = "5";
                }
                jSONObject3.put("8", packageInfo.versionName);
                jSONObject3.put("9", String.valueOf(com.baidu.sofire.h.a.a(context).f10321a.getInt("opi", 0)));
                jSONObject3.put("14", s.i(context));
                jSONObject3.put(Constants.VIA_REPORT_TYPE_WPA_STATE, s.j(context));
                jSONObject2.put("1", jSONObject3);
                String a4 = f.a(context, str4, jSONObject2.toString(), true, true);
                if (TextUtils.isEmpty(a4)) {
                    return null;
                }
                JSONObject jSONObject4 = new JSONObject(a4);
                try {
                    a2 = com.baidu.sofire.h.a.a(context);
                    if (TextUtils.isEmpty(f10400b) || TextUtils.isEmpty(f10401c)) {
                        String a5 = com.baidu.sofire.h.a.a(context).a();
                        if (TextUtils.isEmpty(a5)) {
                            strArr = new String[0];
                        } else {
                            strArr2 = a5.split("-");
                            if (strArr2 != null && strArr2.length == 2) {
                                f10400b = strArr2[0];
                                f10401c = strArr2[1];
                            }
                            strArr = new String[0];
                        }
                        strArr2 = strArr;
                    } else {
                        strArr2 = new String[]{f10400b, f10401c};
                    }
                } catch (Throwable unused) {
                    str2 = "9";
                }
                if ((a2.f10321a.getInt("appinv_ky", 1) == 1 && (strArr2 == null || strArr2.length != 2 || TextUtils.isEmpty(strArr2[0]) || TextUtils.isEmpty(strArr2[1]))) && (optJSONObject2 = jSONObject4.optJSONObject("2")) != null) {
                    String optString2 = optJSONObject2.optString("0");
                    String optString3 = optJSONObject2.optString("1");
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        com.baidu.sofire.core.c a6 = com.baidu.sofire.core.c.a(context);
                        try {
                        } catch (Throwable unused2) {
                            str2 = "9";
                        }
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && (!f10403e.equals(optString2) || !f10404f.equals(optString3))) {
                            f10400b = optString2;
                            f10401c = optString3;
                            com.baidu.sofire.h.a aVar = a6.f10239a;
                            str2 = "9";
                            try {
                                aVar.f10322b.putString("svi_n", optString2 + "-" + optString3);
                                aVar.f10322b.commit();
                            } catch (Throwable unused3) {
                                try {
                                    com.baidu.sofire.b.c();
                                } catch (Throwable unused4) {
                                    com.baidu.sofire.b.c();
                                    jSONObject = jSONObject4.optJSONObject("3").getJSONObject("c");
                                    com.baidu.sofire.h.a a7 = com.baidu.sofire.h.a.a(context);
                                    optInt = jSONObject.optInt("n");
                                    if (optInt > 0) {
                                    }
                                    optInt2 = jSONObject.optInt("i");
                                    if (optInt2 > 0) {
                                    }
                                    optInt3 = jSONObject.optInt("i2");
                                    if (optInt3 > 0) {
                                    }
                                    optInt4 = jSONObject.optInt("w");
                                    if (optInt4 > 0) {
                                    }
                                    if (jSONObject.optInt("s1") > 0) {
                                    }
                                    optInt5 = jSONObject.optInt(Config.SESSTION_TRACK_START_TIME);
                                    if (optInt5 > 0) {
                                    }
                                    optInt6 = jSONObject.optInt("t");
                                    if (optInt6 > 0) {
                                    }
                                    optInt7 = jSONObject.optInt("l1");
                                    if (optInt7 > 0) {
                                    }
                                    optInt8 = jSONObject.optInt("l2");
                                    if (optInt8 > 0) {
                                    }
                                    com.baidu.sofire.h.a a8 = com.baidu.sofire.h.a.a(context);
                                    optString = jSONObject4.optString("0");
                                    if (!TextUtils.isEmpty(optString)) {
                                    }
                                    optJSONObject = jSONObject4.optJSONObject("4");
                                    if (optJSONObject == null) {
                                    }
                                    return jSONObject4;
                                }
                                jSONObject = jSONObject4.optJSONObject("3").getJSONObject("c");
                                com.baidu.sofire.h.a a72 = com.baidu.sofire.h.a.a(context);
                                optInt = jSONObject.optInt("n");
                                if (optInt > 0) {
                                }
                                optInt2 = jSONObject.optInt("i");
                                if (optInt2 > 0) {
                                }
                                optInt3 = jSONObject.optInt("i2");
                                if (optInt3 > 0) {
                                }
                                optInt4 = jSONObject.optInt("w");
                                if (optInt4 > 0) {
                                }
                                if (jSONObject.optInt("s1") > 0) {
                                }
                                optInt5 = jSONObject.optInt(Config.SESSTION_TRACK_START_TIME);
                                if (optInt5 > 0) {
                                }
                                optInt6 = jSONObject.optInt("t");
                                if (optInt6 > 0) {
                                }
                                optInt7 = jSONObject.optInt("l1");
                                if (optInt7 > 0) {
                                }
                                optInt8 = jSONObject.optInt("l2");
                                if (optInt8 > 0) {
                                }
                                com.baidu.sofire.h.a a82 = com.baidu.sofire.h.a.a(context);
                                optString = jSONObject4.optString("0");
                                if (!TextUtils.isEmpty(optString)) {
                                }
                                optJSONObject = jSONObject4.optJSONObject("4");
                                if (optJSONObject == null) {
                                }
                                return jSONObject4;
                            }
                            jSONObject = jSONObject4.optJSONObject("3").getJSONObject("c");
                            com.baidu.sofire.h.a a722 = com.baidu.sofire.h.a.a(context);
                            optInt = jSONObject.optInt("n");
                            if (optInt > 0) {
                                a722.f10326f.putInt("re_net_ty", optInt);
                                a722.f10326f.commit();
                            }
                            optInt2 = jSONObject.optInt("i");
                            if (optInt2 > 0) {
                                a722.f10326f.putInt("re_net_hr", optInt2);
                                a722.f10326f.commit();
                            }
                            optInt3 = jSONObject.optInt("i2");
                            if (optInt3 > 0) {
                                a722.f10326f.putInt("re_net_hr_bc", optInt3);
                                a722.f10326f.commit();
                            }
                            optInt4 = jSONObject.optInt("w");
                            if (optInt4 > 0) {
                                a722.f10326f.putInt("re_net_wt", optInt4);
                                a722.f10326f.commit();
                            }
                            if (jSONObject.optInt("s1") > 0) {
                                a722.f10326f.putInt("re_net_one_lt", jSONObject.optInt("s1"));
                                a722.f10326f.commit();
                            }
                            optInt5 = jSONObject.optInt(Config.SESSTION_TRACK_START_TIME);
                            if (optInt5 > 0) {
                                a722.f10326f.putInt("re_net_dy_lt", optInt5);
                                a722.f10326f.commit();
                            }
                            optInt6 = jSONObject.optInt("t");
                            if (optInt6 > 0) {
                                a722.f10326f.putInt("re_net_over", optInt6);
                                a722.f10326f.commit();
                            }
                            optInt7 = jSONObject.optInt("l1");
                            if (optInt7 > 0) {
                                a722.f10326f.putInt("up_nu_co", optInt7);
                                a722.f10326f.commit();
                            }
                            optInt8 = jSONObject.optInt("l2");
                            if (optInt8 > 0) {
                                a722.f10326f.putInt("up_nu_li", optInt8);
                                a722.f10326f.commit();
                            }
                            com.baidu.sofire.h.a a822 = com.baidu.sofire.h.a.a(context);
                            optString = jSONObject4.optString("0");
                            if (!TextUtils.isEmpty(optString)) {
                                a822.f10324d.putString("gli", new String(Base64.encode(g.a("30212102dicudiab".getBytes(), optString.getBytes("UTF-8"), true), 10), "UTF-8"));
                                a822.f10324d.commit();
                            }
                            optJSONObject = jSONObject4.optJSONObject("4");
                            if (optJSONObject == null) {
                                a822.f10322b.putInt("appinv_t", optJSONObject.optInt("app"));
                                a822.f10322b.commit();
                                a822.f10322b.putInt("appinv_js", optJSONObject.optInt("js"));
                                a822.f10322b.commit();
                                a822.f10322b.putInt("appinv_ky", optJSONObject.optInt("a", 1));
                                a822.f10322b.commit();
                                a822.f10322b.putInt("appplg_te", optJSONObject.optInt("pi", 360));
                                a822.f10322b.commit();
                                int optInt9 = optJSONObject.optInt(Config.FEED_LIST_PART, 1);
                                if (optInt9 > 0) {
                                    str3 = "4";
                                    int round = (int) Math.round(24.0d / optInt9);
                                    if (round > 0) {
                                        a822.e(round);
                                    } else {
                                        a822.e(24);
                                    }
                                } else {
                                    str3 = "4";
                                }
                                int optInt10 = optJSONObject.optInt("alm", 24);
                                if (optInt10 > 0) {
                                    a822.d(optInt10);
                                } else {
                                    a822.d(24);
                                }
                                if (optJSONObject.optInt("0", 0) > 0) {
                                    z = true;
                                    a822.c(true);
                                } else {
                                    z = true;
                                    a822.c(false);
                                }
                                if (optJSONObject.optInt("1", -1) == z) {
                                    i2 = 0;
                                    a822.f10321a.getBoolean("se_fg_s", false);
                                    a822.b(z);
                                } else {
                                    i2 = 0;
                                    a822.b(false);
                                }
                                a(context, "ampf", optJSONObject.optInt("mp", i2));
                                int optInt11 = optJSONObject.optInt("tc", -1);
                                if (optInt11 > 0 && optInt11 <= 20 && optInt11 <= 20) {
                                    a822.f10322b.putInt("s_t_p_c_s", optInt11);
                                    a822.f10322b.commit();
                                }
                                JSONObject optJSONObject3 = optJSONObject.optJSONObject("pc");
                                if (optJSONObject3 != null) {
                                    s.a(context, optJSONObject3);
                                }
                                JSONObject optJSONObject4 = optJSONObject.optJSONObject(Config.PRINCIPAL_PART);
                                if (optJSONObject4 != null && context != null) {
                                    com.baidu.sofire.b.b a9 = com.baidu.sofire.b.b.a(context);
                                    if (optJSONObject4 != null) {
                                        try {
                                            w a10 = w.a(a9.f10207a);
                                            try {
                                                a10.f10453b.putBoolean("lt_sdcf", optJSONObject4.getInt("1") == 1);
                                                a10.f10453b.commit();
                                            } catch (JSONException unused5) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10453b.putBoolean("lt_sucf", optJSONObject4.getInt("2") == 1);
                                                a10.f10453b.commit();
                                            } catch (JSONException unused6) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10453b.putBoolean("lt_sbff", optJSONObject4.getInt("3") == 1);
                                                a10.f10453b.commit();
                                            } catch (JSONException unused7) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10453b.putBoolean("lt_sppf", optJSONObject4.getInt(str3) == 1);
                                                a10.f10453b.commit();
                                            } catch (JSONException unused8) {
                                                com.baidu.sofire.b.c();
                                            }
                                            String str5 = str;
                                            try {
                                                a10.a(optJSONObject4.getInt(str5) == 1);
                                            } catch (JSONException unused9) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.a(optJSONObject4.getInt(str5) == 1);
                                            } catch (JSONException unused10) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10453b.putLong("lt_sfii", optJSONObject4.getLong("7"));
                                                a10.f10453b.commit();
                                            } catch (JSONException unused11) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10453b.putBoolean("lt_sfff", optJSONObject4.getInt("8") == 1);
                                                a10.f10453b.commit();
                                            } catch (JSONException unused12) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10453b.putString("lt_sha", optJSONObject4.getJSONArray(str2).toString());
                                                a10.f10453b.commit();
                                            } catch (JSONException unused13) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10453b.putBoolean("lt_sbwnp", optJSONObject4.getInt("10") == 1);
                                                a10.f10453b.commit();
                                            } catch (JSONException unused14) {
                                                com.baidu.sofire.b.c();
                                            }
                                        } catch (Throwable unused15) {
                                            com.baidu.sofire.b.c();
                                        }
                                    }
                                }
                            }
                            return jSONObject4;
                        }
                    }
                }
                str2 = "9";
                jSONObject = jSONObject4.optJSONObject("3").getJSONObject("c");
                com.baidu.sofire.h.a a7222 = com.baidu.sofire.h.a.a(context);
                optInt = jSONObject.optInt("n");
                if (optInt > 0) {
                }
                optInt2 = jSONObject.optInt("i");
                if (optInt2 > 0) {
                }
                optInt3 = jSONObject.optInt("i2");
                if (optInt3 > 0) {
                }
                optInt4 = jSONObject.optInt("w");
                if (optInt4 > 0) {
                }
                if (jSONObject.optInt("s1") > 0) {
                }
                optInt5 = jSONObject.optInt(Config.SESSTION_TRACK_START_TIME);
                if (optInt5 > 0) {
                }
                optInt6 = jSONObject.optInt("t");
                if (optInt6 > 0) {
                }
                optInt7 = jSONObject.optInt("l1");
                if (optInt7 > 0) {
                }
                optInt8 = jSONObject.optInt("l2");
                if (optInt8 > 0) {
                }
                com.baidu.sofire.h.a a8222 = com.baidu.sofire.h.a.a(context);
                optString = jSONObject4.optString("0");
                if (!TextUtils.isEmpty(optString)) {
                }
                optJSONObject = jSONObject4.optJSONObject("4");
                if (optJSONObject == null) {
                }
                return jSONObject4;
            }
            f10402d = 6;
            return null;
        } catch (Throwable unused16) {
            com.baidu.sofire.b.c();
            return null;
        }
    }

    public static String p(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        try {
            if (Build.VERSION.SDK_INT < 21 || (packageManager = context.getPackageManager()) == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0)) == null) {
                return "";
            }
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            return (String) declaredField.get(applicationInfo);
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return "";
        }
    }

    public static int q(Context context) {
        try {
            String b2 = b(context);
            if (TextUtils.isEmpty(m)) {
                m = b(Process.myPid());
            }
            if (TextUtils.isEmpty(m)) {
                return 0;
            }
            return !TextUtils.isEmpty(b2) ? b2.equals(m) ? 1 : 2 : context.getPackageName().equals(m) ? 3 : 4;
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return 0;
        }
    }

    public static String r(Context context) {
        int length;
        int length2;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(e.b(context));
            sb.append(":");
            String hexString = Long.toHexString(System.currentTimeMillis() / 1000);
            if (!TextUtils.isEmpty(hexString) && (length2 = 8 - hexString.length()) > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (length2 = 8 - hexString.length(); length2 > 0; length2--) {
                    sb2.append("0");
                }
                hexString = sb2.toString() + hexString;
            }
            String hexString2 = Long.toHexString(Long.valueOf(g(context)[0]).longValue());
            if (!TextUtils.isEmpty(hexString2) && (length = 16 - hexString2.length()) > 0) {
                StringBuilder sb3 = new StringBuilder();
                for (length = 16 - hexString2.length(); length > 0; length--) {
                    sb3.append("0");
                }
                hexString2 = sb3.toString() + hexString2;
            }
            sb.append(hexString);
            sb.append(hexString2);
            return sb.toString();
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return "";
        }
    }

    public static synchronized JSONArray s(Context context) {
        ApkInfo a2;
        synchronized (c.class) {
            try {
                com.baidu.sofire.h.a a3 = com.baidu.sofire.h.a.a(context);
                String b2 = b(context, "sofire_local.cfg", "local");
                if (TextUtils.isEmpty(b2)) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(b2);
                if (f10406h == null) {
                    f10406h = new HashMap<>();
                } else {
                    f10406h.clear();
                }
                ArrayList<ApkInfo> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    String optString = optJSONObject.optString("pkgname");
                    String optString2 = optJSONObject.optString("version");
                    int optInt = optJSONObject.optInt("id");
                    if (optInt > 0) {
                        arrayList2.add(Integer.valueOf(optInt));
                    }
                    String optString3 = optJSONObject.optString(PackageTable.MD5);
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && optInt > 0) {
                        SharedPreferences sharedPreferences = a3.f10321a;
                        String string = sharedPreferences.getString("g_l_l_p_v_" + optInt, "");
                        boolean z = true;
                        boolean z2 = (TextUtils.isEmpty(string) || b(optString2, string)) ? false : true;
                        if (z2 || (a2 = com.baidu.sofire.a.a.a(context).a(optInt)) == null || d(optString2, a2.versionName) || a2.initStatus != 1) {
                            z = z2;
                        }
                        String lowerCase = optString3.toLowerCase();
                        ApkInfo apkInfo = new ApkInfo();
                        apkInfo.packageName = optString;
                        apkInfo.versionName = optString2;
                        apkInfo.key = optInt;
                        apkInfo.apkMD5 = lowerCase;
                        if (z) {
                            arrayList.add(apkInfo);
                        } else {
                            f10406h.put(Integer.valueOf(optInt), apkInfo);
                        }
                    }
                }
                a3.a(arrayList2);
                if (f10406h.size() > 0 || arrayList.size() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (ApkInfo apkInfo2 : f10406h.values()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pk", apkInfo2.packageName);
                        jSONObject.put("m", apkInfo2.apkMD5);
                        jSONObject.put("l", apkInfo2.key);
                        jSONObject.put("v", apkInfo2.versionName);
                        jSONArray2.put(jSONObject);
                    }
                    for (ApkInfo apkInfo3 : arrayList) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("pk", apkInfo3.packageName);
                        jSONObject2.put("m", apkInfo3.apkMD5);
                        jSONObject2.put("l", apkInfo3.key);
                        jSONObject2.put("v", apkInfo3.versionName);
                        jSONArray2.put(jSONObject2);
                    }
                    return jSONArray2;
                }
                return null;
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return null;
            }
        }
    }

    public static String t(Context context) {
        try {
            return DeviceId.getCUID(context);
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: all -> 0x0072, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x0072, blocks: (B:15:0x0035, B:18:0x003e, B:21:0x0063, B:20:0x0049), top: B:38:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049 A[Catch: all -> 0x006e, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x0072, blocks: (B:15:0x0035, B:18:0x003e, B:21:0x0063, B:20:0x0049), top: B:38:0x0035 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String u(Context context) {
        String str;
        String str2 = "";
        try {
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            String m2 = a2.m();
            if (TextUtils.isEmpty(m2)) {
                String string = a2.f10323c.getString("xygls", "");
                if (TextUtils.isEmpty(string)) {
                    try {
                        str = j.a(context);
                    } catch (Throwable unused) {
                        str = "";
                    }
                    try {
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                    } catch (Throwable unused2) {
                        try {
                            com.baidu.sofire.b.c();
                            string = str;
                            if (!TextUtils.isEmpty(string)) {
                            }
                            return string;
                        } catch (Throwable unused3) {
                            str2 = str;
                            com.baidu.sofire.b.c();
                            return str2;
                        }
                    }
                    string = str;
                }
                try {
                    if (!TextUtils.isEmpty(string)) {
                        a2.f10324d.putString("xyglsn", "");
                        a2.f10324d.commit();
                    } else {
                        a2.f10324d.putString("xyglsn", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), string.getBytes("UTF-8"), true), 10), "UTF-8"));
                        a2.f10324d.commit();
                    }
                    return string;
                } catch (Throwable unused4) {
                    str2 = string;
                    com.baidu.sofire.b.c();
                    return str2;
                }
            }
            return m2;
        } catch (Throwable unused5) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey a(PackageInfo packageInfo, String str) {
        PublicKey publicKey;
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null && signatureArr.length > 0 && signatureArr[0] != null) {
            try {
                publicKey = b.a(signatureArr[0]);
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
            return publicKey != null ? b.a(str) : publicKey;
        }
        publicKey = null;
        if (publicKey != null) {
        }
    }

    public static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str2).exists()) {
            return false;
        }
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("chmod " + str + " " + str2 + "\n").waitFor();
            return true;
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return false;
        }
    }

    public static String e(String str) {
        try {
            String str2 = new String(g.a("30212102dicudiab".getBytes(), Base64.decode(str, 10)), "UTF-8");
            return !TextUtils.isEmpty(str2) ? str2 : "";
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return "";
        }
    }

    public static String a(Class<?> cls) {
        try {
            if (cls.getCanonicalName().equals(Integer.TYPE.getCanonicalName())) {
                return Integer.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Boolean.TYPE.getCanonicalName())) {
                return Boolean.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Character.TYPE.getCanonicalName())) {
                return Character.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Byte.TYPE.getCanonicalName())) {
                return Byte.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Short.TYPE.getCanonicalName())) {
                return Short.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Long.TYPE.getCanonicalName())) {
                return Long.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Float.TYPE.getCanonicalName())) {
                return Float.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Double.TYPE.getCanonicalName())) {
                return Double.class.getCanonicalName();
            }
            return null;
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return null;
        }
    }

    public static boolean f(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return false;
        }
    }

    public static void c(Context context) {
        try {
            Report report = Report.getInstance(context);
            JSONObject jSONObject = new JSONObject();
            com.baidu.sofire.a.a a2 = com.baidu.sofire.a.a.a(context);
            Map<Integer, String> b2 = a2.b();
            jSONObject.put("0", b2.keySet());
            jSONObject.put("1", b2.values());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("1003003", jSONObject);
            jSONObject2.put("0", jSONObject3);
            Map<Integer, String> c2 = a2.c();
            JSONArray jSONArray = new JSONArray();
            for (String str : c2.values()) {
                jSONArray.put(str);
            }
            jSONArray.put("com.baidu.sofire");
            jSONObject2.put("2", jSONArray);
            report.w(jSONObject2.toString());
        } catch (Throwable unused) {
        }
    }

    public static boolean e() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return false;
        }
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(m)) {
                m = b(Process.myPid());
            }
            return !str.equals(m);
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return false;
        }
    }

    public static void d(Context context) {
        if (TextUtils.isEmpty("3.5.8.6")) {
            return;
        }
        Report report = Report.getInstance(context);
        try {
            c(context);
            report.i("sofire", "com.baidu.sofire", "3.5.8.6", "1003003", "1003002");
        } catch (Throwable unused) {
        }
    }

    public static String b() {
        try {
            return new String(F.getInstance().ad(Base64.decode(n.f10433a, 0), "30212102dicudiab".getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                for (int i2 = 0; i2 < split.length && i2 < split2.length; i2++) {
                    int intValue = Integer.valueOf(split[i2]).intValue() - Integer.valueOf(split2[i2]).intValue();
                    if (intValue != 0) {
                        return intValue > 0;
                    }
                }
                if (split.length > split2.length) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX DEBUG: Null dom frontier in handler: IOException -> 0x0025 */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        if (r2 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (r2 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, String str, String str2) {
        String str3 = "";
        try {
            Properties properties = new Properties();
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                properties.load(inputStream);
                str3 = properties.getProperty(str2);
            } catch (IOException unused) {
            }
        } catch (Throwable unused2) {
            com.baidu.sofire.b.c();
        }
    }

    public static String g(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable unused) {
            fileInputStream = null;
        }
        try {
            String a2 = a(fileInputStream);
            try {
                fileInputStream.close();
            } catch (Throwable unused2) {
            }
            return a2;
        } catch (Throwable unused3) {
            try {
                com.baidu.sofire.b.c();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                return null;
            } catch (Throwable th) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused5) {
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
        r4.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d() {
        File file;
        if (Build.VERSION.SDK_INT > 22) {
            return Process.is64Bit();
        }
        try {
            file = new File("/proc/" + Process.myPid() + "/maps");
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
        if (!file.exists() || file.isDirectory()) {
            return false;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        if (readLine.contains("/system/lib64/libc.so")) {
                            try {
                                bufferedReader2.close();
                                return true;
                            } catch (IOException unused2) {
                                com.baidu.sofire.b.c();
                                return true;
                            }
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException unused3) {
                            com.baidu.sofire.b.c();
                        }
                    }
                } catch (Throwable unused4) {
                    bufferedReader = bufferedReader2;
                    com.baidu.sofire.b.c();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused5) {
                            com.baidu.sofire.b.c();
                        }
                    }
                    return false;
                }
                com.baidu.sofire.b.c();
            }
        } catch (Throwable unused6) {
        }
    }

    public static Class<?> a(String str) {
        try {
            if (str.contains(Integer.class.getCanonicalName())) {
                return Integer.TYPE;
            }
            if (str.contains(Boolean.class.getCanonicalName())) {
                return Boolean.TYPE;
            }
            if (str.contains(Character.class.getCanonicalName())) {
                return Character.TYPE;
            }
            if (str.contains(Byte.class.getCanonicalName())) {
                return Byte.TYPE;
            }
            if (str.contains(Short.class.getCanonicalName())) {
                return Short.TYPE;
            }
            if (str.contains(Long.class.getCanonicalName())) {
                return Long.TYPE;
            }
            if (str.contains(Float.class.getCanonicalName())) {
                return Float.TYPE;
            }
            if (str.contains(Double.class.getCanonicalName())) {
                return Double.TYPE;
            }
            return null;
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return null;
        }
    }

    public static boolean b(Context context, int i2) {
        if (i2 != 1 || e(context)) {
            return true;
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (f10405g == null) {
            f10405g = new MyReceiver().a();
        }
        a(context, f10405g, intentFilter);
        f10399a = true;
        return false;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v1 int), (r2v1 int), (r0v1 int)] */
    public static String c() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2);
        int i4 = calendar.get(5);
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append(i3);
        sb.append(i4);
        return sb.toString();
    }

    public static boolean b(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2)) ? false : true;
    }

    public static String b(int i2) {
        String str;
        String str2 = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str = Application.getProcessName();
                try {
                    if (!TextUtils.isEmpty(str)) {
                        return str.trim();
                    }
                } catch (Throwable unused) {
                    str2 = str;
                    com.baidu.sofire.b.c();
                    return str2;
                }
            } else {
                str = null;
            }
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                str = (String) invoke;
            }
        } catch (Throwable unused2) {
        }
        if (!TextUtils.isEmpty(str)) {
            return str.trim();
        }
        str2 = g(String.format("/proc/%d/cmdline", Integer.valueOf(i2)));
        if (!TextUtils.isEmpty(str2)) {
            return str2.trim();
        }
        return str2;
    }

    public static int a(Context context) {
        try {
            int i2 = 1;
            if (MyProvider.a()) {
                return 1;
            }
            if (k == -1) {
                int q = q(context);
                if (q != 1 && (q == 2 || !MyProvider.a())) {
                    i2 = 0;
                }
                k = i2;
            }
            return k;
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return -1;
        }
    }

    public static String a(byte[] bArr, int i2) {
        if (bArr != null) {
            try {
                byte[] bytes = Long.toString(System.currentTimeMillis() / 1000).getBytes();
                int length = bArr.length + bytes.length + 4;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                System.arraycopy(bytes, 0, bArr2, bArr.length, bytes.length);
                int i3 = length - 4;
                int[] iArr = new int[i3];
                iArr[0] = i2;
                for (int i4 = 1; i4 < i3; i4++) {
                    iArr[i4] = ((iArr[i4 - 1] * 3) + 1) % 128;
                }
                for (int i5 = 0; i5 < i3; i5++) {
                    bArr2[i5] = (byte) (bArr2[i5] ^ ((byte) iArr[i5]));
                }
                System.arraycopy(new byte[]{(byte) (i2 >>> 24), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)}, 0, bArr2, i3, 4);
                return Base64.encodeToString(bArr2, 9).replace("\n", "");
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
        }
        return "";
    }

    public static boolean b(Context context, String str) {
        try {
            File file = new File(context.getFilesDir(), ".tmp");
            if (!file.exists()) {
                file.mkdir();
            }
            return !new File(file, str).exists();
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return false;
        }
    }

    public static String a(Context context, int i2) {
        int length;
        try {
            String hexString = Integer.toHexString(i2);
            if (!TextUtils.isEmpty(hexString) && (length = 4 - hexString.length()) > 0) {
                StringBuilder sb = new StringBuilder();
                for (length = 4 - hexString.length(); length > 0; length--) {
                    sb.append("0");
                }
                hexString = sb.toString() + hexString;
            }
            byte[] a2 = g.a("30212102dicudiab".getBytes(), (r(context) + hexString).toString().getBytes(), false);
            com.baidu.sofire.h.a a3 = com.baidu.sofire.h.a.a(context);
            int i3 = a3.f10321a.getInt("tk_sa_pu_cl", 0) + 1;
            a3.f10322b.putInt("tk_sa_pu_cl", i3);
            a3.f10322b.commit();
            String a4 = a(a2, i3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a4);
            sb2.insert(sb2.length() - 2, "A");
            return sb2.toString().replace("\n", "");
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return "";
        }
    }

    public static synchronized boolean a(Context context, boolean z) {
        boolean a2;
        synchronized (c.class) {
            try {
                if (n != -1) {
                    return n == 1;
                }
                String b2 = b(context);
                if (TextUtils.isEmpty(b2)) {
                    a2 = a(context, context.getPackageName(), true, z);
                } else {
                    a2 = a(context, b2, false, z);
                }
                if (a2) {
                    n = 1;
                } else {
                    n = 0;
                }
                return a2;
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b A[Catch: all -> 0x008b, TryCatch #1 {all -> 0x008b, blocks: (B:11:0x0035, B:14:0x0043, B:16:0x004b, B:18:0x0057, B:22:0x0063, B:26:0x006d, B:30:0x0080, B:31:0x0085, B:28:0x0077), top: B:38:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0080 A[Catch: all -> 0x008b, TryCatch #1 {all -> 0x008b, blocks: (B:11:0x0035, B:14:0x0043, B:16:0x004b, B:18:0x0057, B:22:0x0063, B:26:0x006d, B:30:0x0080, B:31:0x0085, B:28:0x0077), top: B:38:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, boolean z, boolean z2) {
        ResolveInfo resolveInfo;
        boolean z3 = false;
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), MyService.class.getCanonicalName()));
            resolveInfo = context.getPackageManager().resolveService(intent, 0);
            if (resolveInfo != null) {
                try {
                    if (str.equals(resolveInfo.serviceInfo.processName)) {
                        z3 = true;
                    }
                } catch (Throwable unused) {
                    com.baidu.sofire.b.c();
                    if (resolveInfo == null) {
                    }
                    if (TextUtils.isEmpty(m)) {
                    }
                    if (z2) {
                        HashMap hashMap = new HashMap();
                        if (z3) {
                        }
                        if (z) {
                        }
                        a(context, "1003140", (Map<String, Object>) hashMap, true);
                    }
                    return z3;
                }
            }
        } catch (Throwable unused2) {
            resolveInfo = null;
        }
        if (resolveInfo == null) {
            try {
                if (str.equals(a(context, str, "service"))) {
                    z3 = true;
                }
            } catch (Throwable unused3) {
                com.baidu.sofire.b.c();
            }
        }
        if (TextUtils.isEmpty(m)) {
            m = b(Process.myPid());
        }
        if (z2 && m.equals(str) && (!z3 || z)) {
            HashMap hashMap2 = new HashMap();
            if (z3) {
                hashMap2.put("0", Integer.toString(2));
            } else if (!z3) {
                hashMap2.put("0", Integer.toString(1));
            }
            if (z) {
                hashMap2.put("1", "0");
            }
            a(context, "1003140", (Map<String, Object>) hashMap2, true);
        }
        return z3;
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        a(new File(str), new File(str2));
    }

    public static String a(Context context, String str, String str2) {
        int next;
        String attributeValue;
        String str3;
        String canonicalName;
        try {
            XmlResourceParser openXmlResourceParser = context.createPackageContext(context.getPackageName(), 3).getAssets().openXmlResourceParser("AndroidManifest.xml");
            if (openXmlResourceParser != null) {
                do {
                    next = openXmlResourceParser.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next == 2 && openXmlResourceParser.getName().equals("manifest") && (attributeValue = openXmlResourceParser.getAttributeValue(null, AsInstallService.SCHEME_PACKAGE_ADDED)) != null && attributeValue.length() != 0) {
                    int length = attributeValue.length();
                    int i2 = 0;
                    boolean z = false;
                    boolean z2 = true;
                    while (true) {
                        if (i2 < length) {
                            char charAt = attributeValue.charAt(i2);
                            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                                z2 = false;
                            } else if (z2 || ((charAt < '0' || charAt > '9') && charAt != '_')) {
                                if (charAt != '.') {
                                    str3 = "bad character '" + charAt + "'";
                                    break;
                                }
                                z = true;
                                z2 = true;
                            }
                            i2++;
                        } else {
                            str3 = z ? null : "must have at least one '.' separator";
                        }
                    }
                    if (str3 != null && !"android".equals(attributeValue)) {
                        return null;
                    }
                    if (str2.equals("provider")) {
                        canonicalName = MyProvider.class.getCanonicalName();
                    } else if (str2.equals("service")) {
                        canonicalName = MyService.class.getCanonicalName();
                    } else {
                        canonicalName = str2.equals(SocialConstants.PARAM_RECEIVER) ? MyReceiver.class.getCanonicalName() : null;
                    }
                    while (true) {
                        int next2 = openXmlResourceParser.next();
                        if (next2 == 1) {
                            break;
                        } else if (next2 == 2) {
                            String name = openXmlResourceParser.getName();
                            if ("provider".equals(name)) {
                                if (openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name").equals(canonicalName)) {
                                    String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "multiprocess");
                                    if (TextUtils.isEmpty(attributeValue2) || !"true".equals(attributeValue2.toLowerCase())) {
                                        String attributeValue3 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "authorities");
                                        if (TextUtils.isEmpty(attributeValue3) || !str.equals(attributeValue3)) {
                                            return null;
                                        }
                                        String attributeValue4 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                        if (!TextUtils.isEmpty(attributeValue4)) {
                                            if (attributeValue4.startsWith(":")) {
                                                return context.getPackageName() + attributeValue4;
                                            }
                                            return attributeValue4;
                                        }
                                        return context.getPackageName();
                                    }
                                    return null;
                                }
                            } else if ("service".equals(name)) {
                                String attributeValue5 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                                if (!TextUtils.isEmpty(attributeValue5) && attributeValue5.equals(canonicalName)) {
                                    String attributeValue6 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                        if (attributeValue6.startsWith(":")) {
                                            return context.getPackageName() + attributeValue6;
                                        }
                                        return attributeValue6;
                                    }
                                    return context.getPackageName();
                                }
                            } else if (SocialConstants.PARAM_RECEIVER.equals(name)) {
                                String attributeValue7 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                                if (!TextUtils.isEmpty(attributeValue7) && attributeValue7.equals(canonicalName)) {
                                    String attributeValue8 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                        if (attributeValue8.startsWith(":")) {
                                            return context.getPackageName() + attributeValue8;
                                        }
                                        return attributeValue8;
                                    }
                                    return context.getPackageName();
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                return null;
            }
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
        return null;
    }

    public static void a(File file, File file2) {
        FileOutputStream fileOutputStream;
        if (file == null || file2 == null || !a(file)) {
            return;
        }
        if (file2.exists()) {
            file2.delete();
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable unused) {
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                try {
                    fileInputStream2.close();
                } catch (Throwable unused2) {
                }
                try {
                    fileOutputStream.close();
                } catch (Throwable unused3) {
                }
            } catch (Throwable unused4) {
                fileInputStream = fileInputStream2;
                try {
                    com.baidu.sofire.b.c();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused5) {
                        }
                    }
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused7) {
                        }
                    }
                }
            }
        } catch (Throwable unused8) {
            fileOutputStream = null;
        }
    }

    public static boolean a(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0;
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (obj != null && !TextUtils.isEmpty(str)) {
            if (clsArr != null && objArr != null && clsArr.length != objArr.length) {
                throw new NoSuchMethodException("paramTypes or args fail");
            }
            Method[] declaredMethods = obj.getClass().getDeclaredMethods();
            Method method = null;
            int length = declaredMethods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Method method2 = declaredMethods[i2];
                if (a(method2, str, clsArr)) {
                    method = method2;
                    break;
                }
                i2++;
            }
            if (method != null) {
                return method.invoke(obj, objArr);
            }
            throw new NoSuchMethodException("cannot find method in target methodName=" + str);
        }
        throw new NoSuchMethodException("object=" + obj + ", methodName=" + str);
    }

    public static boolean a(Method method, String str, Class<?>[] clsArr) {
        if (str.equals(method.getName())) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ((parameterTypes == null || parameterTypes.length == 0) && (clsArr == null || clsArr.length == 0)) {
                return true;
            }
            if ((clsArr == null || clsArr.length == 0) && parameterTypes != null && parameterTypes.length > 0) {
                return false;
            }
            if (((parameterTypes == null || parameterTypes.length == 0) && clsArr != null && clsArr.length > 0) || parameterTypes == null || clsArr == null || parameterTypes.length != clsArr.length) {
                return false;
            }
            for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                if (parameterTypes[i2] != clsArr[i2]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void a(String str, boolean z) {
        c("771", str);
        if (z) {
            c("771", new File(str).getParentFile().getAbsolutePath());
        }
    }

    public static void a(Context context, String str, Map<String, Object> map, boolean z) {
        String str2;
        if (TextUtils.isEmpty(str) || !com.baidu.sofire.core.c.f10235c) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "");
            jSONObject2.put("2", "");
            String[] g2 = g(context);
            if (g2 != null && g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1])) {
                str2 = g2[0];
            } else {
                str2 = f10403e;
            }
            jSONObject2.put("3", str2);
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", "sofire");
            jSONObject2.put("9", "3.5.8.6");
            jSONObject2.put("10", str);
            jSONObject.put("Common_section", jSONObject2);
            if (map.size() > 0) {
                jSONObject.put("Module_section", new JSONObject(map));
            } else {
                jSONObject.put("Module_section", new JSONObject());
            }
            Report.getInstance(context).s(jSONObject.toString(), z);
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
    }

    public static void a(Context context, String str, Map<String, Object> map) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "");
            jSONObject2.put("2", "");
            String[] g2 = g(context);
            if (g2 != null && g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1])) {
                str2 = g2[0];
            } else {
                str2 = f10403e;
            }
            jSONObject2.put("3", str2);
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", "sofire");
            jSONObject2.put("9", "3.5.8.6");
            jSONObject2.put("10", str);
            jSONObject.put("Common_section", jSONObject2);
            if (map.size() > 0) {
                jSONObject.put("Module_section", new JSONObject(map));
            } else {
                jSONObject.put("Module_section", new JSONObject());
            }
            Report.getInstance(context).sr(jSONObject.toString());
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
    }

    public static void a(Context context, byte[] bArr) {
        try {
            String[] g2 = g(context);
            if (g2 == null || g2.length != 2) {
                return;
            }
            if (TextUtils.isEmpty(g2[0]) || TextUtils.isEmpty(g2[1]) || !"200080".equals(g2[0]) || !context.getPackageName().equals("com.baidu.BaiduMap") || bArr == null) {
                return;
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) (bArr[i2] ^ 246);
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a(Context context, com.baidu.sofire.c.a aVar, String str, boolean z) {
        return a(context, aVar.f10213a, aVar.f10215c, z ? aVar.f10216d : aVar.f10217e, str);
    }

    public static String a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append('\n');
                }
                sb.append(readLine);
            } else {
                return sb.toString();
            }
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        JSONObject jSONObject3 = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject2 = jSONObject.getJSONObject("Common_section");
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            jSONObject2 = null;
        }
        String str6 = "";
        if (jSONObject2 != null) {
            str = jSONObject2.optString("10");
            j2 = jSONObject2.optLong("0");
            str2 = jSONObject2.optString("1");
            str4 = jSONObject2.optString("3");
            str5 = jSONObject2.optString("8");
            str3 = jSONObject2.optString("9");
        } else {
            j2 = currentTimeMillis;
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        try {
            jSONObject3.put("1", context.getApplicationInfo().loadLabel(context.getPackageManager()).toString());
            jSONObject3.put("2", context.getPackageName());
            jSONObject3.put("3", z.a(context));
            jSONObject3.put("4", e.b(context));
            jSONObject3.put("5", str);
            jSONObject3.put("6", j2);
            jSONObject3.put("7", str2);
            jSONObject3.put("8", str4);
            jSONObject3.put("9", str5);
            jSONObject3.put("10", str3);
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            jSONObject3.put("11", a2.f10325e.getString("re_a_cv", ""));
            jSONObject3.put("12", a2.f10325e.getString("re_a_lc", ""));
            jSONObject3.put("13", 1);
            if (k(context) == 4) {
                jSONObject3.put("14", 1);
            } else {
                jSONObject3.put("14", 2);
            }
            jSONObject3.put("20", s.g(context));
            jSONObject3.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, s.f(context));
            jSONObject3.put(Constants.VIA_REPORT_TYPE_DATALINE, e.c(context));
            jSONObject3.put(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS, u(context));
            jSONObject3.put(SoUtils.SO_EVENT_ID_NEW_SO, com.baidu.sofire.rp.a.a(context));
            jSONObject3.put(SoUtils.SO_EVENT_ID_V8_SO, com.baidu.sofire.rp.a.b(context));
            jSONObject3.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, p.a(context));
            jSONObject3.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, t(context));
            String j3 = s.j(context);
            if (!TextUtils.isEmpty(j3)) {
                str6 = j3;
            }
            jSONObject3.put(EventType.GiftEventID.LOAD_ALL_GIFT_SUCCESS, str6);
            Object obj = jSONObject.get("Module_section");
            if (obj instanceof JSONArray) {
                jSONObject3.put("module_section", obj);
            } else {
                jSONObject3.put("module_section", new JSONArray().put(obj));
            }
        } catch (Throwable unused2) {
            com.baidu.sofire.b.c();
        }
        return jSONObject3;
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        int indexOf;
        com.baidu.sofire.c.a aVar;
        d.a(context).a();
        d a2 = d.a(context);
        Message message = new Message();
        message.what = 8;
        a2.f10410b.a(message);
        com.baidu.sofire.c.a aVar2 = new com.baidu.sofire.c.a();
        aVar2.f10213a = str;
        aVar2.f10214b = str2;
        aVar2.f10215c = str3;
        aVar2.f10216d = str4;
        aVar2.f10217e = str5;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            return;
        }
        com.baidu.sofire.h.a a3 = com.baidu.sofire.h.a.a(context);
        List<com.baidu.sofire.c.a> t = a3.t();
        if (t == null) {
            a3.a(aVar2);
        } else if (!t.contains(aVar2)) {
            a3.a(aVar2);
        } else {
            if (t != null && (indexOf = t.indexOf(aVar2)) != -1 && (aVar = t.get(indexOf)) != null) {
                a3.f10326f.putString("re_con", a3.f10325e.getString("re_con", "").replace(com.baidu.sofire.c.a.a(aVar), com.baidu.sofire.c.a.a(aVar2)));
                a3.f10326f.commit();
            }
            d.a(context).b();
            return;
        }
        String str6 = aVar2.f10217e;
        SharedPreferences sharedPreferences = a3.f10325e;
        if (!sharedPreferences.getBoolean("re_net_ins_" + str6, false)) {
            d a4 = d.a(context);
            com.baidu.sofire.g.a aVar3 = a4.f10410b;
            String e2 = aVar3.f10313a.e(aVar2.f10217e);
            com.baidu.sofire.e.a aVar4 = new com.baidu.sofire.e.a();
            aVar4.f10300b = aVar2.f10217e;
            aVar4.f10305g = 0;
            aVar4.f10301c = 1;
            aVar4.f10303e = System.currentTimeMillis();
            aVar4.f10304f = 1;
            aVar4.f10302d = a(aVar3.f10314b, aVar2, e2, false).toString();
            com.baidu.sofire.d.a.a(aVar3.f10314b).a(aVar4);
            com.baidu.sofire.h.a aVar5 = aVar3.f10313a;
            String str7 = aVar2.f10217e;
            SharedPreferences.Editor editor = aVar5.f10326f;
            editor.putBoolean("re_net_ins_" + str7, true);
            aVar5.f10326f.commit();
            a4.f10410b.a(aVar2);
        }
        d.a(context).b();
        d.a(context).c();
    }

    public static void a(Context context, String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            System.currentTimeMillis();
            a2.f10325e.getInt("re_net_ty", 2);
            JSONObject optJSONObject = jSONObject.optJSONObject("Common_section");
            long optLong = optJSONObject.optLong("0");
            String optString = optJSONObject.optString("10");
            int optInt = optJSONObject.optInt("5");
            int optInt2 = optJSONObject.optInt("6");
            int optInt3 = optJSONObject.optInt("7");
            int optInt4 = optJSONObject.optInt("11");
            if (optInt2 == 0) {
                optInt2 = 1;
            }
            com.baidu.sofire.e.a aVar = new com.baidu.sofire.e.a();
            aVar.f10302d = str;
            aVar.f10300b = optString;
            aVar.f10305g = optInt;
            aVar.f10301c = 3;
            aVar.f10303e = optLong;
            aVar.f10304f = optInt2;
            aVar.f10306h = optInt3;
            aVar.f10307i = optInt4;
            aVar.j = "";
            d a3 = d.a(context);
            Message message = new Message();
            if (!z && !e()) {
                com.baidu.sofire.d.a.a(a3.f10409a).a(aVar);
                message.what = 10;
                a3.f10410b.a(message);
            }
            message.what = 1;
            message.obj = aVar;
            a3.f10410b.a(message);
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
    }

    public static void a(Context context, String str) {
        String str2 = "";
        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("0");
                if (optJSONObject != null) {
                    String str3 = "";
                    while (optJSONObject.keys().hasNext()) {
                        str3 = String.valueOf(optJSONObject.keys().next());
                        if (!TextUtils.isEmpty(str3)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        String optString = optJSONObject.optString(str3);
                        SharedPreferences.Editor editor = a2.f10326f;
                        editor.putString("al_da" + str3, optString);
                        a2.f10326f.commit();
                    }
                }
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
            try {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("1");
                if (optJSONObject2 != null) {
                    while (optJSONObject2.keys().hasNext()) {
                        str2 = String.valueOf(optJSONObject2.keys().next());
                        if (!TextUtils.isEmpty(str2)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String optString2 = optJSONObject2.optString(str2);
                        SharedPreferences.Editor editor2 = a2.f10326f;
                        editor2.putString("in_da" + str2, optString2);
                        a2.f10326f.commit();
                    }
                }
            } catch (Throwable unused2) {
                com.baidu.sofire.b.c();
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("2");
                if (optJSONArray != null) {
                    a2.f10326f.putString("li_pk_s", optJSONArray.toString());
                    a2.f10326f.commit();
                }
            } catch (Throwable unused3) {
                com.baidu.sofire.b.c();
            }
        } catch (Throwable unused4) {
            com.baidu.sofire.b.c();
        }
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "0");
            jSONObject2.put("2", "0");
            String[] g2 = g(context);
            if (g2 != null && g2.length == 2) {
                jSONObject2.put("3", g2[0]);
            } else {
                jSONObject2.put("3", f10403e);
            }
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", str);
            jSONObject2.put("9", str2);
            jSONObject2.put("10", str3);
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(str4)) {
                jSONObject3 = new JSONObject(str4);
            }
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONObject3);
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
        return jSONObject;
    }

    public static void a(Context context, long j2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent("com.b.r.p");
        intent.setPackage(context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, intent, 134217728);
        try {
            alarmManager.cancel(broadcast);
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
        try {
            alarmManager.set(1, System.currentTimeMillis() + j2, broadcast);
        } catch (Throwable unused2) {
            com.baidu.sofire.b.c();
        }
    }

    public static String a(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }

    public static boolean a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            context.registerReceiver(broadcastReceiver, intentFilter, context.getPackageName() + ".permission.sofire.RECEIVE", null);
            return true;
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return false;
        }
    }

    public static void a(Context context, String str, int i2) {
        if (i2 < 0) {
            return;
        }
        try {
            File file = new File(context.getFilesDir(), ".tmp");
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, str);
            if (i2 > 0) {
                if (file2.exists()) {
                    file2.delete();
                }
            } else if (i2 != 0 || file2.exists()) {
            } else {
                file2.createNewFile();
            }
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
    }

    public static boolean a(int i2) {
        ApkInfo a2;
        com.baidu.sofire.core.f a3;
        try {
            com.baidu.sofire.a.a aVar = com.baidu.sofire.a.a.f10167d;
            if (aVar == null || (a2 = aVar.a(i2)) == null || a2.initStatus != 1 || (a3 = com.baidu.sofire.core.f.a()) == null) {
                return false;
            }
            return a3.d(a2.packageName) != null;
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
            return false;
        }
    }
}
