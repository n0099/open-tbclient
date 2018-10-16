package cn.jiguang.d.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.d.d.l;
import cn.jiguang.g.i;
import cn.jpush.android.service.PushService;
import com.baidu.webkit.internal.ETAG;
import java.io.Serializable;
/* loaded from: classes3.dex */
public final class d {
    private static volatile cn.jiguang.g.b.d li;

    public static int a() {
        return ((Integer) aa(null).c(ETAG.KEY_STATISTICS_SEESIONID, 0)).intValue();
    }

    public static String a(Context context) {
        return (String) aa(context).c("device_registration_id", "");
    }

    public static void a(Context context, int i) {
        aa(context).d(ETAG.KEY_STATISTICS_SEESIONID, Integer.valueOf(i));
    }

    public static void a(Context context, long j) {
        aa(context).d("services_launched_time", Long.valueOf(j));
    }

    public static void a(Context context, long j, String str, String str2, String str3) {
        cn.jiguang.g.b.a l = new cn.jiguang.g.b.a().a("device_uid", Long.valueOf(j)).l("device_password", str).l("device_registration_id", str2);
        if (!i.a(str3)) {
            l.l("devcie_id_generated", str3);
        }
        aa(context).b(l);
        a.h(cn.jiguang.d.a.b(context));
    }

    public static void a(Context context, cn.jiguang.g.b.a aVar) {
        aa(context).b(aVar);
    }

    public static <T extends Serializable> void a(Context context, String str, T t) {
        aa(context).d(str, t);
    }

    public static void a(Context context, String str, String str2) {
        aa(context).d("sdk_version_" + str, str2);
    }

    public static void a(Context context, boolean z) {
        aa(context).d("upload_crash", Boolean.valueOf(z));
    }

    public static void a(String str) {
        aa(null).d("brd", str);
    }

    public static boolean a(Context context, String str) {
        return aa(context).d("devcie_id_generated", str);
    }

    private static cn.jiguang.g.b.d aa(Context context) {
        if (li == null) {
            li = cn.jiguang.g.b.d.O(context, "cn.jpush.android.user.profile");
        }
        return li;
    }

    public static long ab(Context context) {
        return ((Long) aa(context).c("services_launched_time", -1L)).longValue();
    }

    public static long ac(Context context) {
        return ((Long) aa(context).c("whitelist_wakeup_time", -1L)).longValue();
    }

    public static long ad(Context context) {
        return ((Long) aa(context).c("last_update_report_urls", 0L)).longValue();
    }

    public static int ae(Context context) {
        int intValue = ((Integer) aa(context).c("sp_state", 0)).intValue();
        if (intValue == 0 || intValue == 1) {
            return intValue;
        }
        return 0;
    }

    public static long af(Context context) {
        return ((Long) aa(context).c("key_share_process_uuid_creattime", -1L)).longValue();
    }

    public static cn.jiguang.g.b.a b(Context context, cn.jiguang.g.b.a aVar) {
        return aa(context).a(aVar);
    }

    public static <T extends Serializable> T b(Context context, String str, T t) {
        return (T) aa(context).c(str, t);
    }

    public static String b(Context context) {
        return (String) aa(context).c("devcie_id_generated", "");
    }

    public static String b(Context context, String str) {
        return (String) aa(context).c("sdk_version_" + str, "");
    }

    public static void b(Context context, int i) {
        aa(context).d("sp_state", Integer.valueOf(i));
    }

    public static void b(Context context, long j) {
        aa(context).d("whitelist_wakeup_time", Long.valueOf(j));
    }

    public static void b(Context context, boolean z) {
        aa(context).d("is_tcp_close", Boolean.valueOf(z));
    }

    public static void b(String str) {
        aa(null).d("last_location", str);
    }

    public static boolean b() {
        return ((Boolean) aa(null).c("upload_crash", true)).booleanValue();
    }

    public static long c(Context context) {
        return ((Long) aa(context).c("device_uid", 0L)).longValue();
    }

    public static String c() {
        return (String) aa(null).c("brd", "");
    }

    public static void c(Context context, long j) {
        aa(context).d("last_update_report_urls", Long.valueOf(j));
    }

    public static void c(Context context, boolean z) {
        aa(context).d("tcp_loggedin", Boolean.valueOf(z));
    }

    public static void d(Context context, String str) {
        aa(context).d("report_urls", str);
    }

    public static boolean d() {
        try {
            if (cn.jiguang.g.a.a.c()) {
                try {
                    return cn.jiguang.g.a.a.b().a();
                } catch (Throwable th) {
                }
            }
            String N = cn.jiguang.g.a.N(cn.jiguang.d.a.d, PushService.class.getCanonicalName());
            String c = cn.jiguang.d.b.a.c(cn.jiguang.d.a.d);
            if (!TextUtils.isEmpty(N) && !TextUtils.isEmpty(c) && c.equals(N)) {
                cn.jiguang.d.b.d.bO();
                return cn.jiguang.d.b.d.d();
            } else if (!cn.jiguang.d.b.a.c() && cn.jiguang.d.b.a.b(cn.jiguang.d.a.d)) {
                cn.jiguang.d.b.d.bO();
                return cn.jiguang.d.b.d.d();
            } else {
                if (!cn.jiguang.g.a.b(cn.jiguang.d.a.d)) {
                    if (cn.jiguang.d.a.d != null) {
                        l.bZ().e(cn.jiguang.d.a.d, null, null);
                    }
                    if (cn.jiguang.d.b.a.c()) {
                        return false;
                    }
                }
                return ((Boolean) aa(cn.jiguang.d.a.d).c("tcp_loggedin", false)).booleanValue();
            }
        } catch (Throwable th2) {
            return false;
        }
    }

    public static boolean d(Context context) {
        if (c(context) > 0 && !TextUtils.isEmpty(a(context))) {
            String b = cn.jiguang.d.a.b(context);
            if (TextUtils.isEmpty(b)) {
                return false;
            }
            String c = a.c(context);
            return !TextUtils.isEmpty(c) && TextUtils.equals(b, c);
        }
        return false;
    }

    public static String e(Context context) {
        return (String) aa(context).c("device_password", "");
    }

    public static void e(Context context, String str) {
        aa(context).d("report_sis_urls", str);
    }

    public static long f(Context context, long j) {
        return ((Long) aa(context).c("report_urls_ttl_millis", 3600000L)).longValue();
    }

    public static void f(Context context) {
        aa(context).b(new cn.jiguang.g.b.a().a("device_uid", (Serializable) 0L).l("device_password", "").l("device_registration_id", "").l("devcie_id_generated", "").l("device_appkey", "").f(ETAG.KEY_STATISTICS_SEESIONID, 0).l("brd", ""));
    }

    public static void f(Context context, String str) {
        aa(context).d("key_share_process_uuid", str);
    }

    public static void g(Context context) {
        aa(context).b(new cn.jiguang.g.b.a().a("device_uid", (Serializable) 0L).l("device_password", "").l("device_registration_id", "").l("devcie_id_generated", ""));
        a.h(null);
    }

    public static void g(Context context, long j) {
        aa(context).d("report_urls_ttl_millis", Long.valueOf(j));
    }

    public static void h(Context context) {
        aa(null).b(new cn.jiguang.g.b.a().a("device_uid", (Serializable) 0L).l("device_password", "").l("device_registration_id", ""));
    }

    public static void h(Context context, long j) {
        aa(context).d("key_share_process_uuid_creattime", Long.valueOf(j));
    }

    public static void h(Context context, boolean z) {
        aa(context).d("power_save_is_enbale", Boolean.valueOf(z));
    }

    public static boolean i(Context context) {
        return ((Boolean) aa(context).c("is_tcp_close", false)).booleanValue();
    }

    public static String l(Context context) {
        return (String) aa(context).c("last_location", "");
    }

    public static String m(Context context) {
        return (String) aa(context).c("analytics_account_id", "");
    }

    public static String o(Context context) {
        return (String) aa(context).c("report_urls", "");
    }

    public static String p(Context context) {
        return (String) aa(context).c("report_sis_urls", "");
    }

    public static boolean q(Context context) {
        return ((Boolean) aa(context).c("power_save_is_enbale", false)).booleanValue();
    }

    public static String r(Context context) {
        return (String) aa(context).c("key_share_process_uuid", "");
    }
}
