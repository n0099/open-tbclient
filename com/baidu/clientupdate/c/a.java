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
import com.baidu.clientupdate.a.d;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.clientupdate.d.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.LogUtil;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;
/* loaded from: classes17.dex */
public final class a {
    private static StringBuilder A;

    /* renamed from: a  reason: collision with root package name */
    private static a f1321a;
    private static Context b;
    private static String c;
    private static String d;
    private static String f;
    private static String g;
    private static String l;
    private static String m;
    private static String n;
    private static String w;
    private static String x;
    private d B;
    private String e;
    private String h;
    private String j;
    private String o;
    private String p;
    private String q;
    private String r;
    private ActivityManager s;
    private String t;
    private String u;
    private String v;
    private String y;
    private boolean i = false;
    private Map k = new HashMap();
    private Boolean z = false;

    private a(Context context) {
        b = context.getApplicationContext();
        this.B = d.a(b);
        d();
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f1321a == null) {
                f1321a = new a(context);
            }
            aVar = f1321a;
        }
        return aVar;
    }

    private String b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.densityDpi;
        String str = TextUtils.isEmpty(this.v) ? "android" : this.v;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(i2);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(str);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(c);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(i3);
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
        return (subtype == 7 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 10 || subtype == 9 || subtype == 3 || subtype == 14 || subtype == 12 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : "2G";
    }

    public static boolean c(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private void d() {
        this.e = b.getPackageName();
        this.s = (ActivityManager) b.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        try {
            PackageInfo packageInfo = b.getPackageManager().getPackageInfo(this.e, 64);
            c = packageInfo.versionName;
            d = String.valueOf(packageInfo.versionCode);
            x = new File(packageInfo.applicationInfo.publicSourceDir).length() + "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        w = j.a(b, this.e);
        f = g();
        this.h = f();
        g = b(b);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0084 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        FileInputStream fileInputStream;
        File file = new File(Environment.getExternalStorageDirectory(), "clientupdate_server.cfg");
        ?? exists = file.exists();
        if (exists == 0) {
            LogUtil.logD("BaiduParamManager", "not found config file");
            return;
        }
        Properties properties = new Properties();
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    if (properties.getProperty("server") != null) {
                        this.u = String.valueOf(properties.getProperty("server"));
                    }
                    LogUtil.logD("BaiduParamManager", "设置server:" + this.u);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (exists != 0) {
                    try {
                        exists.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            exists = 0;
            if (exists != 0) {
            }
            throw th;
        }
    }

    private String f() {
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        String str3 = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.VERSION.SDK_INT + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.MANUFACTURER.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        LogUtil.logD("BaiduParamManager", "get ut : " + str3);
        return str3;
    }

    private String g() {
        String str;
        if (TextUtils.isEmpty(f)) {
            try {
                str = CommonParam.getCUID(b);
            } catch (Exception e) {
                e.printStackTrace();
                str = System.currentTimeMillis() + "";
            }
            LogUtil.logD("BaiduParamManager", "new generated uid " + str);
            return str;
        }
        return f;
    }

    private String h() {
        String j = j();
        if (j == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(j);
        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
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
            ((ActivityManager) b.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
            if (memoryInfo != null) {
                return Long.toHexString(memoryInfo.totalMem);
            }
            return null;
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
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String a() {
        if (this.z.booleanValue()) {
            LogUtil.logE("BaiduParamManager", "读取手机根目录cfg文件");
            e();
            return this.u != null ? this.u : "https://update.baidu.com";
        }
        return "https://update.baidu.com";
    }

    public void a(String str) {
        this.v = str;
        g = b(b);
    }

    public void a(String str, String str2) {
        this.k.put(str, str2);
    }

    public void a(boolean z) {
        this.z = Boolean.valueOf(z);
    }

    public String b() {
        A = new StringBuilder();
        A.append("{\"cid\":\"" + f + "\",");
        A.append("\"pl\":\"" + l + "\",");
        A.append("\"os\":\"" + g + "\",");
        A.append("\"ot\":\"" + m + "\",");
        A.append("\"cl\":\"" + n + "\",");
        A.append("\"cvn\":\"" + c + "\",");
        A.append("\"cvc\":\"" + d + "\",");
        A.append("\"csz\":\"" + x + "\",");
        A.append("\"cmd5\":\"" + w + "\",");
        ClientUpdateInfo a2 = com.baidu.clientupdate.d.a.a(b).a();
        RuleInfo b2 = com.baidu.clientupdate.d.a.a(b).b();
        if (a2 == null || b2 == null) {
            A.append("\"ug\":\"\",");
            A.append("\"vn\":\"\",");
            A.append("\"vc\":\"\",");
            A.append("\"sz\":\"\",");
            A.append("\"md5\":\"\",");
        } else {
            A.append("\"ug\":\"" + b2.mUpgradeid + "\",");
            A.append("\"vn\":\"" + a2.mVername + "\",");
            A.append("\"vc\":\"" + a2.mVercode + "\",");
            A.append("\"sz\":\"" + a2.mSize + "\",");
            A.append("\"md5\":\"" + a2.mApkMd5 + "\",");
        }
        LogUtil.logE("BaiduParamManager", A.toString());
        return A.toString();
    }

    public String b(String str) {
        try {
            b bVar = new b(a() + str);
            bVar.a("versioncode", d);
            bVar.a("versionname", c);
            bVar.a("pkgname", this.e);
            bVar.a("cuid", f);
            bVar.a(com.baidu.fsg.base.statistics.j.c, g);
            bVar.a("ut", this.h);
            bVar.a("auto", String.valueOf(this.i));
            this.j = c(b);
            bVar.a("network", this.j);
            this.t = h();
            if (this.t != null) {
                bVar.a("utm", this.t);
            }
            bVar.a("osname", l);
            bVar.a(SocialConstants.PARAM_TYPE_ID, m);
            bVar.a("from", n);
            bVar.a("osbranch", this.o);
            bVar.a(BdStatsConstant.StatsKey.CURRENT_CHANNEL, this.p);
            bVar.a("ignore", this.q);
            bVar.a("time", this.r);
            for (Map.Entry entry : this.k.entrySet()) {
                bVar.b((String) entry.getKey(), (String) entry.getValue());
            }
            if (!TextUtils.isEmpty(w)) {
                bVar.a("usermd5", w);
            }
            this.y = j.a(b, "com.baidu.appsearch");
            if (!TextUtils.isEmpty(this.y)) {
                bVar.a("appsearchmd5", this.y);
            }
            this.B.a(c(), "0", b(), "a2", "0", (System.currentTimeMillis() / 1000) + "", "", "SDKParamManager", "");
            return bVar.toString();
        } catch (Exception e) {
            e.printStackTrace();
            this.B.a(c(), "0", b(), "a2", "1", (System.currentTimeMillis() / 1000) + "", "", "SDKParamManager", e.toString());
            return "";
        }
    }

    public void b(boolean z) {
        this.i = z;
    }

    public String c() {
        RuleInfo b2 = com.baidu.clientupdate.d.a.a(b).b();
        return b2 != null ? b2.mUpgradeid : "-1";
    }

    public void d(String str) {
        c = str;
    }

    public void e(String str) {
        d = str;
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
