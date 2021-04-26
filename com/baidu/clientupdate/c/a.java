package com.baidu.clientupdate.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.android.common.util.CommonParam;
import com.baidu.apollon.statistics.g;
import com.baidu.clientupdate.a.d;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.clientupdate.d.j;
import com.baidu.util.LogUtil;
import com.tencent.open.SocialConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes.dex */
public final class a {
    public static StringBuilder A;

    /* renamed from: a  reason: collision with root package name */
    public static a f4724a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f4725b;

    /* renamed from: c  reason: collision with root package name */
    public static String f4726c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4727d;

    /* renamed from: f  reason: collision with root package name */
    public static String f4728f;

    /* renamed from: g  reason: collision with root package name */
    public static String f4729g;
    public static String l;
    public static String m;
    public static String n;
    public static String w;
    public static String x;
    public d B;

    /* renamed from: e  reason: collision with root package name */
    public String f4730e;

    /* renamed from: h  reason: collision with root package name */
    public String f4731h;
    public String j;
    public String o;
    public String p;
    public String q;
    public String r;
    public ActivityManager s;
    public String t;
    public String u;
    public String v;
    public String y;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4732i = false;
    public Map k = new HashMap();
    public Boolean z = Boolean.FALSE;

    public a(Context context) {
        Context applicationContext = context.getApplicationContext();
        f4725b = applicationContext;
        this.B = d.a(applicationContext);
        d();
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f4724a == null) {
                f4724a = new a(context);
            }
            aVar = f4724a;
        }
        return aVar;
    }

    private String b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        int i4 = displayMetrics.densityDpi;
        String str = !TextUtils.isEmpty(this.v) ? this.v : "android";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2);
        stringBuffer.append("_");
        stringBuffer.append(i3);
        stringBuffer.append("_");
        stringBuffer.append(str);
        stringBuffer.append("_");
        stringBuffer.append(f4726c);
        stringBuffer.append("_");
        stringBuffer.append(i4);
        String stringBuffer2 = stringBuffer.toString();
        LogUtil.logD("BaiduParamManager", "ua = " + stringBuffer2);
        return stringBuffer2;
    }

    private String c(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return "";
        }
        if (activeNetworkInfo.getTypeName().toLowerCase().equals("wifi")) {
            return "WF";
        }
        int subtype = activeNetworkInfo.getSubtype();
        return (subtype == 7 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 10 || subtype == 9 || subtype == 3 || subtype == 14 || subtype == 12 || subtype == 15) ? g.f3962b : subtype == 13 ? "4G" : "2G";
    }

    public static boolean c(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private void d() {
        this.f4730e = f4725b.getPackageName();
        this.s = (ActivityManager) f4725b.getSystemService("activity");
        try {
            PackageInfo packageInfo = f4725b.getPackageManager().getPackageInfo(this.f4730e, 64);
            f4726c = packageInfo.versionName;
            f4727d = String.valueOf(packageInfo.versionCode);
            x = new File(packageInfo.applicationInfo.publicSourceDir).length() + "";
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        w = j.a(f4725b, this.f4730e);
        f4728f = g();
        this.f4731h = f();
        f4729g = b(f4725b);
    }

    private void e() {
        FileInputStream fileInputStream;
        File file = new File(Environment.getExternalStorageDirectory(), "clientupdate_server.cfg");
        if (!file.exists()) {
            LogUtil.logD("BaiduParamManager", "not found config file");
            return;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                properties.load(fileInputStream);
                if (properties.getProperty("server") != null) {
                    this.u = String.valueOf(properties.getProperty("server"));
                }
                LogUtil.logD("BaiduParamManager", "设置server:" + this.u);
                fileInputStream.close();
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    private String f() {
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        int i2 = Build.VERSION.SDK_INT;
        String str3 = Build.MANUFACTURER;
        String str4 = str.replace("_", "-") + "_" + str2.replace("_", "-") + "_" + i2 + "_" + str3.replace("_", "-");
        LogUtil.logD("BaiduParamManager", "get ut : " + str4);
        return str4;
    }

    private String g() {
        String str;
        if (TextUtils.isEmpty(f4728f)) {
            try {
                str = CommonParam.getCUID(f4725b);
            } catch (Exception e2) {
                e2.printStackTrace();
                str = System.currentTimeMillis() + "";
            }
            LogUtil.logD("BaiduParamManager", "new generated uid " + str);
            return str;
        }
        return f4728f;
    }

    private String h() {
        String j = j();
        if (j == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(j);
        sb.append("_");
        sb.append(i());
        return sb.reverse().toString();
    }

    private String i() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.s.getMemoryInfo(memoryInfo);
        LogUtil.logD("BaiduParamManager", "Avaialbe memory: " + memoryInfo.availMem);
        return Long.toHexString(memoryInfo.availMem);
    }

    private String j() {
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) f4725b.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return Long.toHexString(memoryInfo.totalMem);
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            LogUtil.logE("BaiduParamManager", "读取meminfo第一行，系统总内存大小==" + readLine);
            bufferedReader.close();
            if (readLine != null) {
                String[] split = readLine.split("\\s+");
                for (String str : split) {
                    LogUtil.logI("BaiduParamManager", str);
                }
                try {
                    if (c(split[1])) {
                        return Long.toHexString(Integer.valueOf(split[1]).intValue() * 1024);
                    }
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public String a() {
        if (this.z.booleanValue()) {
            LogUtil.logE("BaiduParamManager", "读取手机根目录cfg文件");
            e();
            String str = this.u;
            if (str != null) {
                return str;
            }
        }
        return "https://update.baidu.com";
    }

    public void a(String str) {
        this.v = str;
        f4729g = b(f4725b);
    }

    public void a(String str, String str2) {
        this.k.put(str, str2);
    }

    public void a(boolean z) {
        this.z = Boolean.valueOf(z);
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        A = sb;
        sb.append("{\"cid\":\"" + f4728f + "\",");
        StringBuilder sb2 = A;
        sb2.append("\"pl\":\"" + l + "\",");
        StringBuilder sb3 = A;
        sb3.append("\"os\":\"" + f4729g + "\",");
        StringBuilder sb4 = A;
        sb4.append("\"ot\":\"" + m + "\",");
        StringBuilder sb5 = A;
        sb5.append("\"cl\":\"" + n + "\",");
        StringBuilder sb6 = A;
        sb6.append("\"cvn\":\"" + f4726c + "\",");
        StringBuilder sb7 = A;
        sb7.append("\"cvc\":\"" + f4727d + "\",");
        StringBuilder sb8 = A;
        sb8.append("\"csz\":\"" + x + "\",");
        StringBuilder sb9 = A;
        sb9.append("\"cmd5\":\"" + w + "\",");
        ClientUpdateInfo a2 = com.baidu.clientupdate.d.a.a(f4725b).a();
        RuleInfo b2 = com.baidu.clientupdate.d.a.a(f4725b).b();
        if (a2 == null || b2 == null) {
            A.append("\"ug\":\"\",");
            A.append("\"vn\":\"\",");
            A.append("\"vc\":\"\",");
            A.append("\"sz\":\"\",");
            A.append("\"md5\":\"\",");
        } else {
            StringBuilder sb10 = A;
            sb10.append("\"ug\":\"" + b2.mUpgradeid + "\",");
            StringBuilder sb11 = A;
            sb11.append("\"vn\":\"" + a2.mVername + "\",");
            StringBuilder sb12 = A;
            sb12.append("\"vc\":\"" + a2.mVercode + "\",");
            StringBuilder sb13 = A;
            sb13.append("\"sz\":\"" + a2.mSize + "\",");
            StringBuilder sb14 = A;
            sb14.append("\"md5\":\"" + a2.mApkMd5 + "\",");
        }
        LogUtil.logE("BaiduParamManager", A.toString());
        return A.toString();
    }

    public String b(String str) {
        try {
            b bVar = new b(a() + str);
            bVar.a("versioncode", f4727d);
            bVar.a("versionname", f4726c);
            bVar.a("pkgname", this.f4730e);
            bVar.a("cuid", f4728f);
            bVar.a("ua", f4729g);
            bVar.a("ut", this.f4731h);
            bVar.a(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, String.valueOf(this.f4732i));
            String c2 = c(f4725b);
            this.j = c2;
            bVar.a("network", c2);
            String h2 = h();
            this.t = h2;
            if (h2 != null) {
                bVar.a("utm", h2);
            }
            bVar.a("osname", l);
            bVar.a(SocialConstants.PARAM_TYPE_ID, m);
            bVar.a("from", n);
            bVar.a("osbranch", this.o);
            bVar.a("cfrom", this.p);
            bVar.a("ignore", this.q);
            bVar.a("time", this.r);
            for (Map.Entry entry : this.k.entrySet()) {
                bVar.b((String) entry.getKey(), (String) entry.getValue());
            }
            if (!TextUtils.isEmpty(w)) {
                bVar.a("usermd5", w);
            }
            String a2 = j.a(f4725b, "com.baidu.appsearch");
            this.y = a2;
            if (!TextUtils.isEmpty(a2)) {
                bVar.a("appsearchmd5", this.y);
            }
            d dVar = this.B;
            String c3 = c();
            String b2 = b();
            dVar.a(c3, "0", b2, "a2", "0", (System.currentTimeMillis() / 1000) + "", "", "SDKParamManager", "");
            return bVar.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            d dVar2 = this.B;
            String c4 = c();
            String b3 = b();
            dVar2.a(c4, "0", b3, "a2", "1", (System.currentTimeMillis() / 1000) + "", "", "SDKParamManager", e2.toString());
            return "";
        }
    }

    public void b(boolean z) {
        this.f4732i = z;
    }

    public String c() {
        RuleInfo b2 = com.baidu.clientupdate.d.a.a(f4725b).b();
        return b2 != null ? b2.mUpgradeid : "-1";
    }

    public void d(String str) {
        f4726c = str;
    }

    public void e(String str) {
        f4727d = str;
    }

    public void f(String str) {
        l = str;
    }

    public void g(String str) {
        m = str;
    }

    public void h(String str) {
        n = str;
    }

    public void i(String str) {
        this.o = str;
    }

    public void j(String str) {
        this.p = str;
    }

    public void k(String str) {
        this.q = str;
    }

    public void l(String str) {
        this.r = str;
    }
}
