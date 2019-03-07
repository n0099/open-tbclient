package cn.jiguang.d.a;

import android.content.Context;
import cn.jiguang.api.i;
import com.baidu.sapi2.SapiContext;
import java.io.Serializable;
/* loaded from: classes3.dex */
public final class a {
    public static String a = "";
    public static int b = -1;
    public static boolean c = false;
    private static cn.jiguang.g.b.d li;

    public static void G(Context context, String str) {
        Z(context).d("device_config_appkey", str);
    }

    public static String H(String str) {
        return (String) Z(null).c("device_channel", str);
    }

    public static void H(Context context, String str) {
        Z(context).d("udp_report_device_info", str);
    }

    private static cn.jiguang.g.b.d Z(Context context) {
        if (li == null) {
            li = cn.jiguang.g.b.d.O(context, "cn.jpush.preferences.v2");
        }
        return li;
    }

    public static long a(long j) {
        return (bH() + j) / 1000;
    }

    public static String a(Context context) {
        return (String) Z(context).c("push_udid", "");
    }

    public static void a() {
        Z(null).b(new cn.jiguang.g.b.a().a("last_good_sis", (Serializable) null).a("last_good_sis_address", (Serializable) null).a("default_sis", (Serializable) null).a("last_good_conn_ip", (Serializable) null).a("last_good_conn_port", (Serializable) null).a("last_sis_request_time", (Serializable) 0L).a("device_registered_appkey", (Serializable) null));
        d.h(null);
    }

    public static void a(int i) {
        i.d(cn.jiguang.d.a.d, "idc", i);
    }

    public static void a(Context context, int i) {
        d.a(context, "jpush_register_code", Integer.valueOf(i));
    }

    public static void a(Context context, String str) {
        Z(context).d("device_channel", str);
    }

    public static void a(Context context, String str, String str2) {
        d.a(context, str, cn.jiguang.d.h.a.a.a(str2));
    }

    public static void a(String str, int i) {
        Z(null).b(new cn.jiguang.g.b.a().l("last_good_conn_ip", str).f("last_good_conn_port", i));
    }

    public static void a(String str, String str2, String str3) {
        Z(null).b(new cn.jiguang.g.b.a().a("device_main_imei", str).a("device_main_android_id", str2).a("device_main_mac", str3));
    }

    public static void a(boolean z) {
        Z(null).d("sis_report_switch", Boolean.valueOf(z));
    }

    public static boolean a(String str) {
        if (str == null) {
            return true;
        }
        if (str.equalsIgnoreCase((String) Z(null).c("last_connection_type", null))) {
            return false;
        }
        Z(null).d("last_connection_type", str);
        return true;
    }

    public static String b() {
        return (String) Z(null).c("last_good_conn_ip", null);
    }

    public static String b(Context context) {
        return (String) Z(context).c("imei", "");
    }

    public static String b(Context context, String str) {
        return (String) Z(context).c("option_channel", null);
    }

    public static String b(Context context, String str, String str2) {
        String str3 = (String) d.b(context, str, "");
        return cn.jiguang.g.i.a(str3) ? str2 : cn.jiguang.d.h.a.a.b(str3, str2);
    }

    private static void b(int i) {
        Z(null).d("heartbeat_interval", Integer.valueOf(i));
    }

    public static void b(long j) {
        if (j > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            b.a(j, currentTimeMillis);
            Z(null).b(new cn.jiguang.g.b.a().c("login_server_time", j).c("login_local_time", currentTimeMillis));
        }
    }

    public static void b(String str) {
        Z(null).d("backup_user_addr", str);
    }

    public static long bG() {
        return a(System.currentTimeMillis());
    }

    public static long bH() {
        if (b.a()) {
            return b.b();
        }
        long longValue = ((Long) Z(null).c("login_local_time", 0L)).longValue();
        long longValue2 = ((Long) Z(null).c("login_server_time", 0L)).longValue();
        if (longValue == 0 || longValue2 == 0) {
            return 0L;
        }
        b.a(longValue2, longValue);
        return longValue2 - longValue;
    }

    public static c bI() {
        return new c((String) Z(null).c("device_main_imei", ""), (String) Z(null).c("device_main_android_id", ""), (String) Z(null).c("device_main_mac", ""));
    }

    public static int c() {
        return ((Integer) Z(null).c("last_good_conn_port", 0)).intValue();
    }

    public static String c(Context context) {
        return (String) Z(context).c("device_registered_appkey", null);
    }

    public static void c(Context context, String str) {
        Z(context).d("option_channel", str);
    }

    public static void c(String str) {
        Z(null).d("last_good_sis", str);
    }

    public static String d(Context context) {
        return (String) Z(context).c("device_config_appkey", null);
    }

    public static void d(Context context, String str) {
        Z(context).d(SapiContext.KEY_SDK_VERSION, str);
    }

    public static void d(String str) {
        Z(null).d("default_sis", str);
    }

    public static void d(String str, int i) {
        Z(null).b(new cn.jiguang.g.b.a().l("default_conn_ip", str).f("default_conn_port", i));
    }

    public static boolean d() {
        return System.currentTimeMillis() - ((Long) Z(null).c("last_sis_request_time", 0L)).longValue() > 180000;
    }

    public static String e(Context context) {
        return (String) Z(context).c("udp_report_device_info", "");
    }

    public static void e() {
        Z(null).d("last_sis_request_time", Long.valueOf(System.currentTimeMillis()));
    }

    public static void e(Context context, String str) {
        Z(context).d("push_udid", str);
    }

    public static void e(String str) {
        Z(null).d("sis_report_history", str);
    }

    public static synchronized long f() {
        long a2;
        synchronized (a.class) {
            a2 = e.a();
        }
        return a2;
    }

    public static void f(Context context) {
        Z(context).b(new cn.jiguang.g.b.a().a("last_report_index", (Serializable) 0L).a("last_good_sis", (Serializable) null).a("last_good_sis_address", (Serializable) null).a("default_sis", (Serializable) null).a("last_good_conn_ip", (Serializable) null).a("last_good_conn_port", (Serializable) null).a("last_sis_request_time", (Serializable) null).a("device_registered_appkey", (Serializable) null).a("heartbeat_interval", (Serializable) null).a("default_conn_ip", (Serializable) null).a("default_conn_port", (Serializable) null).a("sis_report_switch", (Serializable) null).a("sis_report_history", (Serializable) null));
    }

    public static void f(Context context, String str) {
        Z(context).d("imei", str);
    }

    public static void f(String str) {
        Z(null).d("last_good_sis_address", str);
    }

    public static int g() {
        return ((Integer) Z(null).c("heartbeat_interval", 290)).intValue();
    }

    public static void h() {
        b(290);
    }

    public static void h(String str) {
        Z(null).d("device_registered_appkey", str);
    }

    public static void i() {
        b(86400);
    }

    public static boolean j() {
        return g() == 86400;
    }

    public static String k() {
        return (String) Z(null).c("last_good_sis", null);
    }

    public static String l() {
        return (String) Z(null).c("default_sis", null);
    }

    public static String m() {
        return (String) Z(null).c("sis_report_history", "");
    }

    public static String n() {
        return (String) Z(null).c("last_good_sis_address", null);
    }

    public static boolean o() {
        return ((Boolean) Z(null).c("sis_report_switch", false)).booleanValue();
    }

    public static String p() {
        return (String) Z(null).c("foo001", null);
    }

    public static boolean t() {
        return ((Boolean) d.b(null, "is_im_logged_in", false)).booleanValue();
    }

    public static int u() {
        return ((Integer) d.b(null, "im_login_count", -1)).intValue();
    }

    public static int v() {
        return i.getInt(cn.jiguang.d.a.d, "idc", -1);
    }
}
