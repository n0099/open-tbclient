package com.baidu.sofire.g;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
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
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
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
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f11409a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f11410b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f11411c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f11412d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static String f11413e = "3";

    /* renamed from: f  reason: collision with root package name */
    public static String f11414f = "925fc15df8a49bed0b3eca8d2b44cb7b";

    /* renamed from: g  reason: collision with root package name */
    public static MyReceiver f11415g = null;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<Integer, ApkInfo> f11416h = null;
    public static JSONObject i = null;
    public static long j = 0;
    public static String k = "";
    public static String l = "";
    public static int m = -1;
    public static int n = -1;
    public static int o = -1;

    public static void a() {
        com.baidu.sofire.b.d();
    }

    public static int b(Context context) {
        try {
            int a2 = a(context);
            if (a2 == 1 || a2 == 3) {
                return 1;
            }
            return (a2 == 2 || a2 == 4) ? 0 : -1;
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
            return -1;
        }
    }

    public static String c(Context context) {
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
        }
        if (TextUtils.isEmpty(k) && n != 1) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(context.getPackageName() + ".sofire.ac.provider", 0);
            if (resolveContentProvider != null && !resolveContentProvider.multiprocess) {
                k = resolveContentProvider.processName;
            }
            n = 1;
            return k;
        }
        return k;
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
                            boolean delete = file2.delete();
                            StringBuilder sb = new StringBuilder();
                            sb.append(file2.getAbsolutePath());
                            sb.append(" d:");
                            sb.append(delete);
                            com.baidu.sofire.b.a();
                        }
                    }
                }
                boolean delete2 = file.delete();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(file.getAbsolutePath());
                sb2.append(" d:");
                sb2.append(delete2);
                com.baidu.sofire.b.a();
            }
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
        }
    }

    public static void e(Context context) {
        com.baidu.sofire.b.a();
        if (TextUtils.isEmpty("3.5.7.3")) {
            return;
        }
        Report report = Report.getInstance(context);
        try {
            d(context);
            report.i("sofire", "com.baidu.sofire", "3.5.7.3", "1003003", "1003002");
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.sofire.b.c();
        }
    }

    public static boolean f(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && 1 == activeNetworkInfo.getType();
    }

    public static String g(String str) {
        try {
            int length = str.length();
            int i2 = 0;
            while (i2 < length && (str.charAt(i2) <= ' ' || str.charAt(i2) == 160)) {
                i2++;
            }
            return i2 > 0 ? str.substring(i2) : str;
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
            return "";
        }
    }

    public static String[] h(Context context) {
        String[] split;
        String[] split2;
        String str = f11410b;
        String str2 = f11411c;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.baidu.sofire.b.a();
            return new String[]{str, str2};
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String b2 = new com.baidu.sofire.e(context).b();
            if (!TextUtils.isEmpty(b2) && (split = b2.split("-")) != null && split.length == 2) {
                com.baidu.sofire.b.a();
                return split;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String string = new com.baidu.sofire.e(context).f11390a.getString("svi", "");
            if (!TextUtils.isEmpty(string) && (split2 = string.split("-")) != null && split2.length == 2) {
                com.baidu.sofire.b.a();
                return split2;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.baidu.sofire.b.a();
            str = f11413e;
            str2 = f11414f;
        }
        return new String[]{str, str2};
    }

    public static void i(Context context) {
        com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = eVar.f11390a.getLong("se_ae_fd", 0L);
        if (j2 == 0) {
            j2 = System.currentTimeMillis();
            eVar.h();
        }
        if (currentTimeMillis - j2 > 86400000) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.valueOf(eVar.k() + 1));
            eVar.c(0);
            eVar.h();
            a(context, "1003119", (Map<String, Object>) hashMap, false);
            return;
        }
        eVar.c(eVar.k() + 1);
    }

    public static boolean j(Context context) {
        try {
            if (o < 0 && context != null) {
                String packageName = context.getPackageName();
                Field field = Class.forName(packageName + ".BuildConfig").getField("DEBUG");
                field.setAccessible(true);
                o = field.getBoolean(null) ? 1 : 0;
            }
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
        }
        return o == 1;
    }

    public static void k(Context context) throws UnsupportedOperationException {
        if (!j(context) || "com.baidu.input".equals(context.getPackageName())) {
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

    public static int l(Context context) {
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
            com.baidu.sofire.b.d();
        }
        return -1;
    }

    public static JSONObject m(Context context) {
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
            String b2 = f.b();
            if (b2 == null) {
                b2 = "";
            }
            jSONObject.put("2", b2);
            String str3 = Build.HOST;
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("3", str3);
            String a2 = f.a();
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
            jSONObject.put("8", f.b(context));
            String c2 = f.c();
            if (c2 == null) {
                c2 = "";
            }
            jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, c2);
            String d2 = f.d();
            if (d2 == null) {
                d2 = "";
            }
            jSONObject.put("10", d2);
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, f.g(context));
            String e2 = f.e();
            if (e2 == null) {
                e2 = "";
            }
            jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, e2);
            jSONObject.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, f.d(context));
            jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "");
            jSONObject.put(Constants.VIA_REPORT_TYPE_START_GROUP, r.k(context));
            jSONObject.put("18", r.l(context));
            jSONObject.put("20", Build.VERSION.SDK_INT);
            TimeZone timeZone = TimeZone.getDefault();
            if (timeZone != null) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, timeZone.getID());
            } else {
                jSONObject.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, "-1");
            }
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
        }
        return jSONObject;
    }

    public static int n(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
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

    public static void o(Context context) {
        try {
            MyReceiver myReceiver = new MyReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.action.SOFIRE.VIEW");
            intentFilter.addCategory("com.baidu.category.SOFIRE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            context.registerReceiver(myReceiver, intentFilter, context.getPackageName() + ".permission.sofire.RECEIVE", null);
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
        }
    }

    public static JSONObject p(Context context) {
        String[] strArr;
        String[] strArr2;
        boolean z;
        int i2;
        try {
            String str = b() + "p/5/aio";
            com.baidu.sofire.b.a();
            JSONObject jSONObject = new JSONObject();
            JSONArray s = s(context);
            if (s != null) {
                jSONObject.put("0", s);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", Build.MODEL);
            jSONObject2.put("1", f.b(context));
            jSONObject2.put("3", String.valueOf(Build.VERSION.SDK_INT));
            jSONObject2.put("4", "3.5.7.3");
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
            if (packageInfo != null) {
                jSONObject2.put("5", g(packageInfo.applicationInfo.loadLabel(packageManager).toString()));
                jSONObject2.put("6", packageName);
                PublicKey a2 = a(packageInfo, packageInfo.applicationInfo.sourceDir);
                if (a2 != null) {
                    byte[] encoded = a2.getEncoded();
                    if (encoded != null) {
                        a(context, encoded);
                        jSONObject2.put("7", n.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                    } else {
                        jSONObject2.put("7", "");
                    }
                }
                jSONObject2.put("8", packageInfo.versionName);
                jSONObject2.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, String.valueOf(new com.baidu.sofire.e(context).f11390a.getInt("opi", 0)));
                jSONObject2.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, r.i(context));
                jSONObject2.put(Constants.VIA_REPORT_TYPE_WPA_STATE, r.j(context));
                jSONObject.put("1", jSONObject2);
                String jSONObject3 = jSONObject.toString();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("---");
                sb.append(jSONObject3);
                com.baidu.sofire.b.a();
                String a3 = g.a(context, str, jSONObject3, true, true);
                com.baidu.sofire.b.a();
                if (TextUtils.isEmpty(a3)) {
                    return null;
                }
                JSONObject jSONObject4 = new JSONObject(a3);
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                if (TextUtils.isEmpty(f11410b) || TextUtils.isEmpty(f11411c)) {
                    String b2 = new com.baidu.sofire.e(context).b();
                    if (TextUtils.isEmpty(b2)) {
                        strArr = new String[0];
                    } else {
                        strArr2 = b2.split("-");
                        if (strArr2 != null && strArr2.length == 2) {
                            f11410b = strArr2[0];
                            f11411c = strArr2[1];
                        }
                        strArr = new String[0];
                    }
                    strArr2 = strArr;
                } else {
                    strArr2 = new String[]{f11410b, f11411c};
                }
                if (eVar.f11390a.getInt("appinv_ky", 1) == 1 && (strArr2 == null || strArr2.length != 2 || TextUtils.isEmpty(strArr2[0]) || TextUtils.isEmpty(strArr2[1]))) {
                    JSONObject optJSONObject = jSONObject4.optJSONObject("2");
                    new StringBuilder("c:").append(optJSONObject);
                    com.baidu.sofire.b.a();
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("0");
                        String optString2 = optJSONObject.optString("1");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            com.baidu.sofire.core.c a4 = com.baidu.sofire.core.c.a(context);
                            try {
                                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && (!f11413e.equals(optString) || !f11414f.equals(optString2))) {
                                    f11410b = optString;
                                    f11411c = optString2;
                                    com.baidu.sofire.e eVar2 = a4.f11325a;
                                    eVar2.f11392c.putString("svi_n", optString + "-" + optString2);
                                    eVar2.f11392c.commit();
                                }
                            } catch (Throwable unused) {
                                com.baidu.sofire.b.d();
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject4.optJSONObject("3");
                new StringBuilder("i:").append(optJSONObject2);
                com.baidu.sofire.b.a();
                JSONObject jSONObject5 = optJSONObject2.getJSONObject("c");
                com.baidu.sofire.e eVar3 = new com.baidu.sofire.e(context);
                int optInt = jSONObject5.optInt("n");
                if (optInt > 0) {
                    eVar3.f11395f.putInt("re_net_ty", optInt);
                    eVar3.f11395f.commit();
                }
                int optInt2 = jSONObject5.optInt("i");
                if (optInt2 > 0) {
                    eVar3.f11395f.putInt("re_net_hr", optInt2);
                    eVar3.f11395f.commit();
                }
                int optInt3 = jSONObject5.optInt("i2");
                if (optInt3 > 0) {
                    eVar3.f11395f.putInt("re_net_hr_bc", optInt3);
                    eVar3.f11395f.commit();
                }
                int optInt4 = jSONObject5.optInt("w");
                if (optInt4 > 0) {
                    eVar3.f11395f.putInt("re_net_wt", optInt4);
                    eVar3.f11395f.commit();
                }
                if (jSONObject5.optInt("s1") > 0) {
                    eVar3.f11395f.putInt("re_net_one_lt", jSONObject5.optInt("s1"));
                    eVar3.f11395f.commit();
                }
                int optInt5 = jSONObject5.optInt(Config.SESSTION_TRACK_START_TIME);
                if (optInt5 > 0) {
                    eVar3.f11395f.putInt("re_net_dy_lt", optInt5);
                    eVar3.f11395f.commit();
                }
                int optInt6 = jSONObject5.optInt("t");
                if (optInt6 > 0) {
                    eVar3.f11395f.putInt("re_net_over", optInt6);
                    eVar3.f11395f.commit();
                }
                int optInt7 = jSONObject5.optInt("l1");
                if (optInt7 > 0) {
                    eVar3.f11395f.putInt("up_nu_co", optInt7);
                    eVar3.f11395f.commit();
                }
                int optInt8 = jSONObject5.optInt("l2");
                if (optInt8 > 0) {
                    eVar3.f11395f.putInt("up_nu_li", optInt8);
                    eVar3.f11395f.commit();
                }
                com.baidu.sofire.e eVar4 = new com.baidu.sofire.e(context);
                try {
                    String optString3 = jSONObject4.optString("0");
                    if (!TextUtils.isEmpty(optString3)) {
                        eVar4.f11393d.putString("gli", new String(Base64.encode(a.a("30212102dicudiab".getBytes(), optString3.getBytes("UTF-8")), 10), "UTF-8"));
                        eVar4.f11393d.commit();
                    }
                } catch (Throwable unused2) {
                    com.baidu.sofire.b.d();
                }
                JSONObject optJSONObject3 = jSONObject4.optJSONObject("4");
                new StringBuilder("s:").append(optJSONObject3);
                com.baidu.sofire.b.a();
                if (optJSONObject3 != null) {
                    int optInt9 = optJSONObject3.optInt("app");
                    new StringBuilder("App-").append(Integer.toString(optInt9));
                    com.baidu.sofire.b.a();
                    eVar4.f11392c.putInt("appinv_t", optInt9);
                    eVar4.f11392c.commit();
                    int optInt10 = optJSONObject3.optInt("js");
                    new StringBuilder("JS-").append(Integer.toString(optInt10));
                    com.baidu.sofire.b.a();
                    eVar4.f11392c.putInt("appinv_js", optInt10);
                    eVar4.f11392c.commit();
                    int optInt11 = optJSONObject3.optInt("a", 1);
                    new StringBuilder("get key-").append(Integer.toString(optInt11));
                    com.baidu.sofire.b.a();
                    eVar4.f11392c.putInt("appinv_ky", optInt11);
                    eVar4.f11392c.commit();
                    int optInt12 = optJSONObject3.optInt("pi", 360);
                    new StringBuilder("net Interval-").append(Integer.toString(optInt12));
                    com.baidu.sofire.b.a();
                    eVar4.f11392c.putInt("appplg_te", optInt12);
                    eVar4.f11392c.commit();
                    int optInt13 = optJSONObject3.optInt(Config.FEED_LIST_PART, 1);
                    if (optInt13 > 0) {
                        int round = (int) Math.round(24.0d / optInt13);
                        if (round > 0) {
                            eVar4.e(round);
                        } else {
                            eVar4.e(24);
                        }
                    }
                    int optInt14 = optJSONObject3.optInt("alm", 24);
                    if (optInt14 > 0) {
                        eVar4.d(optInt14);
                    } else {
                        eVar4.d(24);
                    }
                    if (optJSONObject3.optInt("0", 0) > 0) {
                        z = true;
                        eVar4.c(true);
                    } else {
                        z = true;
                        eVar4.c(false);
                    }
                    if (optJSONObject3.optInt("1", -1) == z) {
                        i2 = 0;
                        eVar4.f11390a.getBoolean("se_fg_s", false);
                        eVar4.b(z);
                    } else {
                        i2 = 0;
                        eVar4.b(false);
                    }
                    a(context, "ampf", optJSONObject3.optInt("mp", i2));
                    int optInt15 = optJSONObject3.optInt("tc", -1);
                    if (optInt15 > 0 && optInt15 <= 20 && optInt15 <= 20) {
                        eVar4.f11392c.putInt("s_t_p_c_s", optInt15);
                        eVar4.f11392c.commit();
                    }
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("pc");
                    if (optJSONObject4 != null) {
                        r.a(context, optJSONObject4);
                    }
                }
                return jSONObject4;
            }
            f11412d = 6;
            return null;
        } catch (Throwable unused3) {
            com.baidu.sofire.b.d();
            return null;
        }
    }

    public static String q(Context context) {
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
            com.baidu.sofire.b.d();
            return "";
        }
    }

    public static String r(Context context) {
        int length;
        int length2;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(f.b(context));
            sb.append(":");
            String hexString = Long.toHexString(System.currentTimeMillis() / 1000);
            if (!TextUtils.isEmpty(hexString) && (length2 = 8 - hexString.length()) > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (length2 = 8 - hexString.length(); length2 > 0; length2--) {
                    sb2.append("0");
                }
                hexString = sb2.toString() + hexString;
            }
            String str = h(context)[0];
            String hexString2 = Long.toHexString(Long.valueOf(str).longValue());
            StringBuilder sb3 = new StringBuilder("time ");
            sb3.append(hexString);
            sb3.append(" appkey");
            sb3.append(str);
            com.baidu.sofire.b.a();
            if (!TextUtils.isEmpty(hexString2) && (length = 16 - hexString2.length()) > 0) {
                StringBuilder sb4 = new StringBuilder();
                for (length = 16 - hexString2.length(); length > 0; length--) {
                    sb4.append("0");
                }
                hexString2 = sb4.toString() + hexString2;
            }
            sb.append(hexString);
            sb.append(hexString2);
            return sb.toString();
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
            return "";
        }
    }

    public static synchronized JSONArray s(Context context) {
        ApkInfo a2;
        synchronized (d.class) {
            try {
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                String b2 = b(context, "sofire_local.cfg", "local");
                if (TextUtils.isEmpty(b2)) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(b2);
                if (f11416h == null) {
                    f11416h = new HashMap<>();
                } else {
                    f11416h.clear();
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
                        SharedPreferences sharedPreferences = eVar.f11390a;
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
                            f11416h.put(Integer.valueOf(optInt), apkInfo);
                        }
                    }
                }
                eVar.a(arrayList2);
                if (f11416h.size() > 0 || arrayList.size() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (ApkInfo apkInfo2 : f11416h.values()) {
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
                com.baidu.sofire.b.d();
                return null;
            }
        }
    }

    public static String t(Context context) {
        try {
            return DeviceId.getCUID(context);
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f A[Catch: all -> 0x0072, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x0072, blocks: (B:15:0x0036, B:18:0x003f, B:21:0x0063, B:20:0x004a), top: B:38:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a A[Catch: all -> 0x006e, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x0072, blocks: (B:15:0x0036, B:18:0x003f, B:21:0x0063, B:20:0x004a), top: B:38:0x0036 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String u(Context context) {
        String str;
        String str2 = "";
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String n2 = eVar.n();
            if (TextUtils.isEmpty(n2)) {
                String string = eVar.f11391b.getString("xygls", "");
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
                            com.baidu.sofire.b.d();
                            string = str;
                            if (!TextUtils.isEmpty(string)) {
                            }
                            return string;
                        } catch (Throwable unused3) {
                            str2 = str;
                            com.baidu.sofire.b.d();
                            return str2;
                        }
                    }
                    string = str;
                }
                try {
                    if (!TextUtils.isEmpty(string)) {
                        eVar.f11393d.putString("xyglsn", "");
                        eVar.f11393d.commit();
                    } else {
                        eVar.f11393d.putString("xyglsn", new String(Base64.encode(a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), string.getBytes("UTF-8")), 10), "UTF-8"));
                        eVar.f11393d.commit();
                    }
                    return string;
                } catch (Throwable unused4) {
                    str2 = string;
                    com.baidu.sofire.b.d();
                    return str2;
                }
            }
            return n2;
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
                publicKey = c.a(signatureArr[0]);
            } catch (Throwable unused) {
                com.baidu.sofire.b.d();
            }
            return publicKey != null ? c.a(str) : publicKey;
        }
        publicKey = null;
        if (publicKey != null) {
        }
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(l)) {
                l = b(Process.myPid());
            }
            return !str.equals(l);
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
            return false;
        }
    }

    public static String f(String str) {
        try {
            String str2 = new String(a.a("30212102dicudiab".getBytes(), Base64.decode(str, 10), true), "UTF-8");
            return !TextUtils.isEmpty(str2) ? str2 : "";
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
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
            com.baidu.sofire.b.d();
            return null;
        }
    }

    public static boolean g(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
            return false;
        }
    }

    public static String b() {
        try {
            return new String(F.getInstance().ad(Base64.decode(m.f11445a, 0), "30212102dicudiab".getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void e(String str) {
        Map h2;
        try {
            if (com.baidu.sofire.core.c.f11320b == null) {
                return;
            }
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(com.baidu.sofire.core.c.f11320b);
            String string = eVar.f11390a.getString("ses_ic", "");
            if (TextUtils.isEmpty(string)) {
                h2 = new HashMap();
                h2.put(str, 1);
            } else {
                h2 = h(string);
                if (h2 != null && h2.size() > 0) {
                    if (h2.get(str) != null) {
                        h2.put(str, Integer.valueOf(((Integer) h2.get(str)).intValue() + 1));
                    } else {
                        h2.put(str, 1);
                    }
                }
            }
            if (h2 == null || h2.size() <= 0) {
                return;
            }
            eVar.f11392c.putString("ses_ic", new JSONObject(h2).toString());
            eVar.f11392c.commit();
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
        }
    }

    public static String b(Context context, String str, String str2) {
        String str3 = "";
        try {
            Properties properties = new Properties();
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                properties.load(inputStream);
                str3 = properties.getProperty(str2);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        e.getMessage();
                        com.baidu.sofire.b.c();
                        return str3;
                    }
                }
            } catch (IOException e3) {
                e3.getMessage();
                com.baidu.sofire.b.c();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        e.getMessage();
                        com.baidu.sofire.b.c();
                        return str3;
                    }
                }
            }
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
        }
        return str3;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str));
    }

    public static String i(String str) {
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
                com.baidu.sofire.b.d();
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

    public static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str2).exists()) {
            return false;
        }
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("chmod " + str + " " + str2 + "\n").waitFor();
            return true;
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
            return false;
        }
    }

    public static void d(Context context) {
        try {
            Report report = Report.getInstance(context);
            JSONObject jSONObject = new JSONObject();
            com.baidu.sofire.a.a a2 = com.baidu.sofire.a.a.a(context);
            Map<Integer, String> b2 = a2.b();
            jSONObject.put("0", b2.keySet());
            jSONObject.put("1", b2.values());
            new StringBuilder().append(jSONObject.toString());
            com.baidu.sofire.b.a();
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
            new StringBuilder().append(jSONArray.toString());
            com.baidu.sofire.b.a();
            jSONObject2.put("2", jSONArray);
            report.w(jSONObject2.toString());
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.sofire.b.c();
        }
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

    public static boolean b(Context context, int i2) {
        if (i2 != 1 || f(context)) {
            return true;
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (f11415g == null) {
            f11415g = new MyReceiver().a();
        }
        a(context, f11415g, intentFilter);
        f11409a = true;
        return false;
    }

    public static Map<String, Integer> h(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, (Integer) jSONObject.get(next));
            }
            return hashMap;
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
            return null;
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
            com.baidu.sofire.b.d();
            return null;
        }
    }

    public static boolean b(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2)) ? false : true;
    }

    public static String b(int i2) {
        String str;
        try {
            str = i(String.format("/proc/%d/cmdline", Integer.valueOf(i2)));
            try {
                if (!TextUtils.isEmpty(str)) {
                    return str.trim();
                }
            } catch (Throwable unused) {
                com.baidu.sofire.b.d();
                return str;
            }
        } catch (Throwable unused2) {
            str = null;
        }
        return str;
    }

    public static boolean b(Context context, String str) {
        try {
            File file = new File(context.getFilesDir(), ".tmp");
            if (!file.exists()) {
                file.mkdir();
            }
            return !new File(file, str).exists();
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
            return false;
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

    public static int a(Context context) {
        try {
            String c2 = c(context);
            if (TextUtils.isEmpty(l)) {
                l = b(Process.myPid());
            }
            return !TextUtils.isEmpty(c2) ? c2.equals(l) ? 1 : 2 : context.getPackageName().equals(l) ? 3 : 4;
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
            return 0;
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
            com.baidu.sofire.b.d();
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
                                com.baidu.sofire.b.d();
                                return true;
                            }
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException unused3) {
                            com.baidu.sofire.b.d();
                        }
                    }
                } catch (Throwable unused4) {
                    bufferedReader = bufferedReader2;
                    com.baidu.sofire.b.d();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused5) {
                            com.baidu.sofire.b.d();
                        }
                    }
                    return false;
                }
                com.baidu.sofire.b.d();
            }
        } catch (Throwable unused6) {
        }
    }

    public static String a(byte[] bArr, int i2) {
        try {
            if (bArr != null) {
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
            }
            com.baidu.sofire.b.a();
            return "";
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
            return "";
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
            byte[] b2 = a.b("30212102dicudiab".getBytes(), (r(context) + hexString).toString().getBytes());
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            int i3 = eVar.f11390a.getInt("tk_sa_pu_cl", 0) + 1;
            eVar.f11392c.putInt("tk_sa_pu_cl", i3);
            eVar.f11392c.commit();
            String a2 = a(b2, i3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a2);
            sb2.insert(sb2.length() - 2, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
            return sb2.toString().replace("\n", "");
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
            return "";
        }
    }

    public static synchronized boolean a(Context context, boolean z) {
        boolean a2;
        synchronized (d.class) {
            try {
                if (m != -1) {
                    return m == 1;
                }
                String c2 = c(context);
                if (TextUtils.isEmpty(c2)) {
                    a2 = a(context, context.getPackageName(), true, z);
                } else {
                    a2 = a(context, c2, false, z);
                }
                if (a2) {
                    m = 1;
                } else {
                    m = 0;
                }
                return a2;
            } catch (Throwable unused) {
                com.baidu.sofire.b.d();
                return false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004a A[Catch: all -> 0x008a, TryCatch #1 {all -> 0x008a, blocks: (B:11:0x0035, B:14:0x0042, B:16:0x004a, B:18:0x0056, B:22:0x0062, B:26:0x006c, B:30:0x007f, B:31:0x0084, B:28:0x0076), top: B:38:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f A[Catch: all -> 0x008a, TryCatch #1 {all -> 0x008a, blocks: (B:11:0x0035, B:14:0x0042, B:16:0x004a, B:18:0x0056, B:22:0x0062, B:26:0x006c, B:30:0x007f, B:31:0x0084, B:28:0x0076), top: B:38:0x0035 }] */
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
                    com.baidu.sofire.b.d();
                    if (resolveInfo == null) {
                    }
                    if (TextUtils.isEmpty(l)) {
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
                com.baidu.sofire.b.d();
            }
        }
        if (TextUtils.isEmpty(l)) {
            l = b(Process.myPid());
        }
        if (z2 && l.equals(str) && (!z3 || z)) {
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
                while (true) {
                    next = openXmlResourceParser.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                    com.baidu.sofire.b.a();
                }
                if (next == 2 && openXmlResourceParser.getName().equals("manifest") && (attributeValue = openXmlResourceParser.getAttributeValue(null, "package")) != null && attributeValue.length() != 0) {
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
                    new StringBuilder().append(canonicalName);
                    com.baidu.sofire.b.a();
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
            com.baidu.sofire.b.d();
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
                    StringBuilder sb = new StringBuilder();
                    sb.append(file.getAbsolutePath());
                    sb.append(" > ");
                    sb.append(file2.getAbsolutePath());
                    com.baidu.sofire.b.a();
                    try {
                        fileInputStream2.close();
                    } catch (Throwable th) {
                        th.getMessage();
                        com.baidu.sofire.b.c();
                    }
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                    fileInputStream = fileInputStream2;
                    try {
                        com.baidu.sofire.b.d();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th2) {
                                th2.getMessage();
                                com.baidu.sofire.b.c();
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th4) {
                                th4.getMessage();
                                com.baidu.sofire.b.c();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th5) {
                                th5.getMessage();
                                com.baidu.sofire.b.c();
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable unused3) {
                fileOutputStream = null;
            }
        } catch (Throwable th6) {
            th6.getMessage();
            com.baidu.sofire.b.c();
        }
    }

    public static boolean a(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0;
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (obj != null && !TextUtils.isEmpty(str)) {
            if (clsArr != null && objArr != null && clsArr.length != objArr.length) {
                com.baidu.sofire.b.a();
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
            com.baidu.sofire.b.a();
            throw new NoSuchMethodException("cannot find method in target methodName=" + str);
        }
        com.baidu.sofire.b.a();
        throw new NoSuchMethodException("object=" + obj + ", methodName=" + str);
    }

    public static boolean a(Method method, String str, Class<?>[] clsArr) {
        if (str.equals(method.getName())) {
            new StringBuilder().append(str);
            com.baidu.sofire.b.a();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ((parameterTypes != null && parameterTypes.length != 0) || (clsArr != null && clsArr.length != 0)) {
                if ((clsArr == null || clsArr.length == 0) && parameterTypes != null && parameterTypes.length > 0) {
                    com.baidu.sofire.b.a();
                    return false;
                } else if ((parameterTypes == null || parameterTypes.length == 0) && clsArr != null && clsArr.length > 0) {
                    com.baidu.sofire.b.a();
                    return false;
                } else if (parameterTypes == null || clsArr == null) {
                    return false;
                } else {
                    if (parameterTypes.length != clsArr.length) {
                        com.baidu.sofire.b.a();
                        return false;
                    }
                    for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                        if (parameterTypes[i2] != clsArr[i2]) {
                            com.baidu.sofire.b.a();
                            return false;
                        }
                    }
                    com.baidu.sofire.b.a();
                    return true;
                }
            }
            com.baidu.sofire.b.a();
            return true;
        }
        return false;
    }

    public static void a(String str, boolean z) {
        boolean c2 = c("771", str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(",s=");
        sb.append(c2);
        com.baidu.sofire.b.a();
        if (z) {
            String absolutePath = new File(str).getParentFile().getAbsolutePath();
            c("771", absolutePath);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(absolutePath);
            sb2.append(",s=");
            sb2.append(c2);
            com.baidu.sofire.b.a();
        }
    }

    public static void a(Context context, String str, Map<String, Object> map, boolean z) {
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
            String[] h2 = h(context);
            if (h2 != null && h2.length == 2 && !TextUtils.isEmpty(h2[0]) && !TextUtils.isEmpty(h2[1])) {
                str2 = h2[0];
            } else {
                str2 = f11413e;
            }
            jSONObject2.put("3", str2);
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", "sofire");
            jSONObject2.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, "3.5.7.3");
            jSONObject2.put("10", str);
            jSONObject.put("Common_section", jSONObject2);
            if (map.size() > 0) {
                jSONObject.put("Module_section", new JSONObject(map));
            } else {
                jSONObject.put("Module_section", new JSONObject());
            }
            Report report = Report.getInstance(context);
            String jSONObject3 = jSONObject.toString();
            new StringBuilder().append(jSONObject3);
            com.baidu.sofire.b.a();
            report.s(jSONObject3, z);
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
        }
    }

    public static void a(Context context, byte[] bArr) {
        try {
            String[] h2 = h(context);
            if (h2 == null || h2.length != 2) {
                return;
            }
            if (TextUtils.isEmpty(h2[0]) || TextUtils.isEmpty(h2[1]) || !"200080".equals(h2[0]) || !context.getPackageName().equals("com.baidu.BaiduMap") || bArr == null) {
                return;
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) (bArr[i2] ^ 246);
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a(Context context, com.baidu.sofire.b.a aVar, String str, boolean z) {
        return a(context, aVar.f11294a, aVar.f11296c, z ? aVar.f11297d : aVar.f11298e, str);
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
            com.baidu.sofire.b.d();
            jSONObject2 = null;
        }
        String str6 = "";
        if (jSONObject2 != null) {
            str = jSONObject2.optString("10");
            j2 = jSONObject2.optLong("0");
            str2 = jSONObject2.optString("1");
            str4 = jSONObject2.optString("3");
            str5 = jSONObject2.optString("8");
            str3 = jSONObject2.optString(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9);
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
            jSONObject3.put("3", v.a(context));
            jSONObject3.put("4", f.b(context));
            jSONObject3.put("5", str);
            jSONObject3.put("6", j2);
            jSONObject3.put("7", str2);
            jSONObject3.put("8", str4);
            jSONObject3.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, str5);
            jSONObject3.put("10", str3);
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            jSONObject3.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, eVar.f11394e.getString("re_a_cv", ""));
            jSONObject3.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, eVar.f11394e.getString("re_a_lc", ""));
            jSONObject3.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, 1);
            if (l(context) == 4) {
                jSONObject3.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, 1);
            } else {
                jSONObject3.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, 2);
            }
            jSONObject3.put("20", r.g(context));
            jSONObject3.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, r.f(context));
            jSONObject3.put(Constants.VIA_REPORT_TYPE_DATALINE, f.d(context));
            jSONObject3.put("32", u(context));
            jSONObject3.put(SoUtils.SO_EVENT_ID_NEW_SO, com.baidu.sofire.rp.a.a(context));
            jSONObject3.put(SoUtils.SO_EVENT_ID_V8_SO, com.baidu.sofire.rp.a.b(context));
            jSONObject3.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, o.a(context));
            jSONObject3.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, t(context));
            String j3 = r.j(context);
            if (!TextUtils.isEmpty(j3)) {
                str6 = j3;
            }
            jSONObject3.put("34", str6);
            Object obj = jSONObject.get("Module_section");
            if (obj instanceof JSONArray) {
                jSONObject3.put("module_section", obj);
            } else {
                jSONObject3.put("module_section", new JSONArray().put(obj));
            }
        } catch (Throwable unused2) {
            com.baidu.sofire.b.d();
        }
        return jSONObject3;
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        int indexOf;
        com.baidu.sofire.b.a aVar;
        e.a(context).a();
        e a2 = e.a(context);
        Message message = new Message();
        message.what = 8;
        a2.f11419b.a(message);
        com.baidu.sofire.b.a aVar2 = new com.baidu.sofire.b.a();
        aVar2.f11294a = str;
        aVar2.f11295b = str2;
        aVar2.f11296c = str3;
        aVar2.f11297d = str4;
        aVar2.f11298e = str5;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            return;
        }
        com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
        List<com.baidu.sofire.b.a> v = eVar.v();
        if (v == null) {
            eVar.a(aVar2);
        } else if (!v.contains(aVar2)) {
            eVar.a(aVar2);
        } else {
            if (v != null && (indexOf = v.indexOf(aVar2)) != -1 && (aVar = v.get(indexOf)) != null) {
                eVar.f11395f.putString("re_con", eVar.f11394e.getString("re_con", "").replace(com.baidu.sofire.b.a.a(aVar), com.baidu.sofire.b.a.a(aVar2)));
                eVar.f11395f.commit();
            }
            e.a(context).b();
            return;
        }
        String str6 = aVar2.f11298e;
        SharedPreferences sharedPreferences = eVar.f11394e;
        if (!sharedPreferences.getBoolean("re_net_ins_" + str6, false)) {
            e a3 = e.a(context);
            com.baidu.sofire.f.a aVar3 = a3.f11419b;
            String d2 = aVar3.f11399a.d(aVar2.f11298e);
            com.baidu.sofire.d.a aVar4 = new com.baidu.sofire.d.a();
            aVar4.f11380b = aVar2.f11298e;
            aVar4.f11385g = 0;
            aVar4.f11381c = 1;
            aVar4.f11383e = System.currentTimeMillis();
            aVar4.f11384f = 1;
            aVar4.f11382d = a(aVar3.f11400b, aVar2, d2, false).toString();
            com.baidu.sofire.c.a.a(aVar3.f11400b).a(aVar4);
            com.baidu.sofire.e eVar2 = aVar3.f11399a;
            String str7 = aVar2.f11298e;
            SharedPreferences.Editor editor = eVar2.f11395f;
            editor.putBoolean("re_net_ins_" + str7, true);
            eVar2.f11395f.commit();
            a3.f11419b.a(aVar2);
        }
        e.a(context).b();
        e.a(context).c();
    }

    public static void a(Context context, String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            System.currentTimeMillis();
            eVar.f11394e.getInt("re_net_ty", 2);
            JSONObject optJSONObject = jSONObject.optJSONObject("Common_section");
            long optLong = optJSONObject.optLong("0");
            String optString = optJSONObject.optString("10");
            int optInt = optJSONObject.optInt("5");
            int optInt2 = optJSONObject.optInt("6");
            int optInt3 = optJSONObject.optInt("7");
            int optInt4 = optJSONObject.optInt(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            if (optInt2 == 0) {
                optInt2 = 1;
            }
            com.baidu.sofire.d.a aVar = new com.baidu.sofire.d.a();
            aVar.f11382d = str;
            aVar.f11380b = optString;
            aVar.f11385g = optInt;
            aVar.f11381c = 3;
            aVar.f11383e = optLong;
            aVar.f11384f = optInt2;
            aVar.f11386h = optInt3;
            aVar.i = optInt4;
            aVar.j = "";
            e a2 = e.a(context);
            Message message = new Message();
            if (z) {
                message.what = 1;
                message.obj = aVar;
            } else {
                com.baidu.sofire.c.a.a(a2.f11418a).a(aVar);
                com.baidu.sofire.b.a();
                message.what = 10;
            }
            a2.f11419b.a(message);
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
        }
    }

    public static void a(Context context, String str) {
        String str2 = "";
        com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
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
                        SharedPreferences.Editor editor = eVar.f11395f;
                        editor.putString("al_da" + str3, optString);
                        eVar.f11395f.commit();
                    }
                }
            } catch (Throwable unused) {
                com.baidu.sofire.b.d();
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
                        SharedPreferences.Editor editor2 = eVar.f11395f;
                        editor2.putString("in_da" + str2, optString2);
                        eVar.f11395f.commit();
                    }
                }
            } catch (Throwable unused2) {
                com.baidu.sofire.b.d();
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("2");
                if (optJSONArray != null) {
                    new StringBuilder().append(optJSONArray.toString());
                    com.baidu.sofire.b.a();
                    eVar.f11395f.putString("li_pk_s", optJSONArray.toString());
                    eVar.f11395f.commit();
                }
            } catch (Throwable unused3) {
                com.baidu.sofire.b.d();
            }
        } catch (Throwable unused4) {
            com.baidu.sofire.b.d();
        }
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "0");
            jSONObject2.put("2", "0");
            String[] h2 = h(context);
            if (h2 != null && h2.length == 2) {
                jSONObject2.put("3", h2[0]);
            } else {
                jSONObject2.put("3", f11413e);
            }
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", str);
            jSONObject2.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, str2);
            jSONObject2.put("10", str3);
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(str4)) {
                jSONObject3 = new JSONObject(str4);
            }
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONObject3);
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
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
            com.baidu.sofire.b.d();
        }
        try {
            alarmManager.set(1, System.currentTimeMillis() + j2, broadcast);
        } catch (Throwable unused2) {
            com.baidu.sofire.b.d();
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
            com.baidu.sofire.b.d();
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
            com.baidu.sofire.b.d();
        }
    }

    public static Bundle a(Context context, String str, Bundle bundle) {
        ContentProviderClient contentProviderClient;
        if (Build.VERSION.SDK_INT < 11) {
            return null;
        }
        try {
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            Uri parse = Uri.parse("content://" + context.getPackageName() + ".sofire.ac.provider");
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    contentProviderClient = contentResolver.acquireUnstableContentProviderClient(parse);
                } catch (Throwable unused) {
                    contentProviderClient = null;
                }
                try {
                    Bundle call = contentProviderClient.call(str, null, bundle);
                    if (contentProviderClient != null) {
                        contentProviderClient.release();
                    }
                    return call;
                } catch (Throwable unused2) {
                    com.baidu.sofire.b.d();
                    if (contentProviderClient != null) {
                        contentProviderClient.release();
                    }
                    return null;
                }
            }
            return contentResolver.call(parse, str, (String) null, bundle);
        } catch (Throwable unused3) {
            com.baidu.sofire.b.d();
            return null;
        }
    }

    public static boolean a(int i2) {
        ApkInfo a2;
        com.baidu.sofire.core.f a3;
        try {
            com.baidu.sofire.a.a aVar = com.baidu.sofire.a.a.f11284d;
            if (aVar == null || (a2 = aVar.a(i2)) == null || a2.initStatus != 1 || (a3 = com.baidu.sofire.core.f.a()) == null) {
                return false;
            }
            return a3.d(a2.packageName) != null;
        } catch (Throwable unused) {
            com.baidu.sofire.b.d();
            return false;
        }
    }
}
