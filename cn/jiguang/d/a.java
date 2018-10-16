package cn.jiguang.d;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.api.SdkType;
import cn.jiguang.api.e;
import cn.jiguang.d.d.aa;
import cn.jiguang.d.d.g;
import cn.jiguang.d.d.i;
import cn.jiguang.d.d.l;
import cn.jiguang.d.d.s;
import cn.jiguang.service.Protocol;
import cn.jpush.android.service.PushService;
import java.io.Serializable;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class a {
    public static String c;
    public static Context d;
    public static String g;
    private static Pair<String, Integer> lf;
    public static final String a = SdkType.JCORE.name();
    public static boolean b = false;
    static boolean e = false;
    public static final cn.jiguang.c.b ld = new cn.jiguang.c.a();
    public static boolean h = false;
    public static boolean i = false;
    private static final AtomicInteger le = new AtomicInteger(-1);
    private static final Object k = new Object();
    private static ServiceConnection m = new b();

    public static Context X(Context context) {
        if (d == null && context != null) {
            d = context.getApplicationContext();
            c = context.getPackageName();
        }
        return d;
    }

    public static Pair<String, Integer> Y(Context context) {
        if (lf == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                String str = packageInfo.versionName;
                if (str.length() > 30) {
                    str = str.substring(0, 30);
                }
                lf = new Pair<>(str, Integer.valueOf(packageInfo.versionCode));
            } catch (Throwable th) {
                cn.jiguang.e.c.a("JCoreGlobal", "NO versionCode or versionName defined in manifest.");
            }
        }
        return lf;
    }

    public static void a(Context context, boolean z) {
        if (cn.jiguang.g.a.a.d()) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, PushService.class);
        try {
            if (context.bindService(intent, m, 1)) {
                cn.jiguang.g.a.a.e();
            }
        } catch (SecurityException e2) {
            cn.jiguang.e.c.c("JCoreGlobal", "Remote Service bind failed caused by SecurityException!");
        }
    }

    public static void a(Context context, boolean z, long j) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", z);
            bundle.putLong("rtc_delay", j);
            l.bZ().d(context, "intent.RTC", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreGlobal", "sendHeartBeat error:" + th.getMessage());
        }
    }

    private static boolean a() {
        int i2;
        try {
            i2 = Protocol.GetSdkVersion();
        } catch (UnsatisfiedLinkError e2) {
            cn.jiguang.e.c.d("JCoreGlobal", "Get sdk version fail![获取sdk版本失败!]");
            e2.printStackTrace();
            i2 = 0;
        }
        return i2 >= 100;
    }

    public static String b(Context context) {
        ApplicationInfo applicationInfo;
        if (TextUtils.isEmpty(g)) {
            try {
                Context X = X(context);
                if (X != null && (applicationInfo = X.getPackageManager().getApplicationInfo(X.getPackageName(), 128)) != null && applicationInfo.metaData != null) {
                    String c2 = c(applicationInfo.metaData, "JPUSH_APPKEY");
                    g = c2;
                    if (!TextUtils.isEmpty(c2)) {
                        g = g.toLowerCase(Locale.getDefault());
                    }
                }
            } catch (Throwable th) {
            }
        }
        return g;
    }

    public static String c(Bundle bundle, String str) {
        Object obj;
        if (bundle == null || (obj = bundle.get(str)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static boolean c(Context context) {
        switch (le.get()) {
            case -1:
                Context X = X(context);
                if (X != null) {
                    e.a("SDK_MAIN", new c(X, 0), new int[0]);
                    return false;
                }
                return false;
            case 0:
                return true;
            default:
                return false;
        }
    }

    public static boolean d(Context context) {
        int e2 = e(X(context));
        switch (e2) {
            case 0:
                return true;
            default:
                cn.jiguang.e.c.c("JCoreGlobal", "JCore init code = " + e2);
                return false;
        }
    }

    public static int e(Context context) {
        i = h;
        h = true;
        int i2 = le.get();
        if (i2 != -1) {
            return i2;
        }
        synchronized (k) {
            int i3 = le.get();
            if (i3 != -1) {
                return i3;
            }
            cn.jiguang.e.c.a("JCoreGlobal", "action:init - sdkVersion:1.2.5, buildId:195");
            i.bX();
            Context X = X(context);
            if (X == null) {
                return -1;
            }
            cn.jiguang.a.a.c.e.bq().b();
            cn.jiguang.d.a.a.d(X, "1.2.5");
            cn.jiguang.a.a.a(X);
            if (!a()) {
                cn.jiguang.e.c.d("JCoreGlobal", "JCore .so file do not match JCore .jar file in the project, Failed to init JCore");
                le.set(3);
                return 3;
            } else if (!g(X)) {
                le.set(2);
                return 2;
            } else {
                int at = cn.jiguang.g.a.at(X);
                if (at != 0) {
                    le.set(at);
                    return at;
                }
                b(X);
                String d2 = cn.jiguang.d.a.a.d(X);
                if (TextUtils.isEmpty(d2)) {
                    d2 = cn.jiguang.d.a.a.c(X);
                }
                String b2 = b(X);
                if (cn.jiguang.g.i.a(d2) || "null".equals(d2) || !d2.equalsIgnoreCase(b2)) {
                    cn.jiguang.d.a.a.G(X, b2);
                    cn.jiguang.e.c.a("ServiceHelper", "We found the appKey is changed or register appkey is empty. Will re-register.");
                    cn.jiguang.d.a.d.f(X);
                    cn.jiguang.d.a.a.f(X);
                    cn.jiguang.d.a.d.a(X, new cn.jiguang.g.b.a().a("last_report_device_info", (Serializable) null).a("lbs_report_enable", (Serializable) null).a("last_collection_location", (Serializable) null).a("location_report_delay", (Serializable) null).a("location_collect_frequency", (Serializable) null).a("last_check_userapp_status", (Serializable) null).a("nb_upload", (Serializable) null).a("nb_lasttime", (Serializable) null).a("app_running_collect_enable", (Serializable) null).a("app_running_collect_interval", (Serializable) null).a("app_running_last_collect_time", (Serializable) null).a("app_running_collect_app_type", (Serializable) null).a("app_running_collect_process_type", (Serializable) null).a("battery_last_collect_time", (Serializable) null).a("last_report_location", (Serializable) null).a("lbs_report_now", (Serializable) null).a("report_location_frequency", (Serializable) null).a("report_notify_state", (Serializable) null));
                    cn.jiguang.a.a.c.b.a(X, (String) null);
                    aa.e(X);
                    cn.jiguang.a.a.c.e.a(X);
                    s.a(X, (String) null, "nowrap");
                }
                le.set(0);
                e.a("SDK_MAIN", new c(X, 1), new int[0]);
                return 0;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean g(Context context) {
        boolean z;
        String str = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                cn.jiguang.e.c.c("JCoreGlobal", "metadata: Can not get metaData from ApplicationInfo");
                z = false;
            } else if (applicationInfo.metaData == null) {
                cn.jiguang.e.c.c("JCoreGlobal", "NO meta data defined in manifest.");
                z = false;
            } else {
                Bundle bundle = applicationInfo.metaData;
                String b2 = cn.jiguang.d.a.a.b(context, null);
                if (b2 != null) {
                    cn.jiguang.e.c.a("JCoreGlobal", "set option channel - " + b2);
                } else {
                    b2 = c(bundle, "JPUSH_CHANNEL");
                    cn.jiguang.e.c.a("JCoreGlobal", "manifest:channel - " + b2);
                }
                cn.jiguang.d.a.a.a(context, cn.jiguang.g.i.c(b2));
                String c2 = c(bundle, "JPUSH_APPKEY");
                if (TextUtils.isEmpty(c2) || TextUtils.isEmpty(g) || !g.equals(c2)) {
                    g = c2;
                    if (cn.jiguang.g.i.a(c2)) {
                        cn.jiguang.e.c.d("JCoreGlobal", "errorcode:10001,metadata: JCore appKey - not defined in manifest");
                        g.a(d, 10001, false);
                        cn.jiguang.d.a.a.a(context, 10001);
                        z = false;
                    } else if (g.length() != 24) {
                        cn.jiguang.e.c.d("JCoreGlobal", "errorcode:1008,Invalid appKey : " + g + ", Please get your Appkey from JIGUANG web console!");
                        g.a(d, 1008, false);
                        cn.jiguang.d.a.a.a(context, 1008);
                        z = false;
                    } else {
                        g = g.toLowerCase(Locale.getDefault());
                        str = "metadata: appKey - " + g;
                        cn.jiguang.e.c.a("JCoreGlobal", str);
                        z = true;
                    }
                } else {
                    z = g.length() == 24;
                }
            }
            return z;
        } catch (Throwable th) {
            cn.jiguang.e.c.a("JCoreGlobal", "Unexpected: failed to get current application info", th);
            return str;
        }
    }
}
