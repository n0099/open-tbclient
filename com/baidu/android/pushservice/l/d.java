package com.baidu.android.pushservice.l;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.PushServiceReceiver;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.a0.k;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.down.utils.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.heytap.msp.push.HeytapPushManager;
import com.hihonor.push.sdk.ipc.HonorApiAvailability;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends com.baidu.android.pushservice.l.b {
    public static int j = -1;
    public static int k = -1;
    public static int l = -1;
    public static int m = -1;
    public static int n = -1;
    public static int o = -1;
    public static int p = -1;
    public static int q = -1;
    public static int r = -1;
    public static int s = -1;
    public static d t;
    public static int u;
    public static String[] v = {"/default.prop", SnapshotConstant.DeviceFilePathConstants.DEVICE_BUILD_CONFIG, "/system/default.prop", "/data/local.prop"};
    public String d;
    public int e;
    public com.baidu.android.pushservice.l.c f;
    public int g;
    public int h;
    public Map<String, com.baidu.android.pushservice.l.c> i;

    /* loaded from: classes.dex */
    public class a extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ InterfaceC0029d c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, String str, short s, InterfaceC0029d interfaceC0029d) {
            super(str, s);
            this.c = interfaceC0029d;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            this.c.a();
        }
    }

    /* loaded from: classes.dex */
    public static class b implements InterfaceC0029d {
        @Override // com.baidu.android.pushservice.l.d.InterfaceC0029d
        public void a() {
        }
    }

    /* loaded from: classes.dex */
    public class c extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ InterfaceC0029d e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, short s, String str2, boolean z, InterfaceC0029d interfaceC0029d) {
            super(str, s);
            this.c = str2;
            this.d = z;
            this.e = interfaceC0029d;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            JSONObject jSONObject;
            try {
                HashMap hashMap = new HashMap();
                com.baidu.android.pushservice.p.b.a(d.this.a, hashMap);
                hashMap.put("version", d.this.e + "");
                hashMap.put("osSdkInt", Build.VERSION.SDK_INT + "");
                hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, this.c);
                hashMap.put("front_conn_avaliable", d.u + "");
                if ((Utility.H(d.this.a) && PushSettings.h(d.this.a)) || ((Utility.T(d.this.a) && PushSettings.m(d.this.a)) || ((Utility.J(d.this.a) && PushSettings.j(d.this.a)) || ((Utility.N(d.this.a) && PushSettings.k(d.this.a)) || (Utility.S(d.this.a) && PushSettings.l(d.this.a)))))) {
                    hashMap.put("rom_version", Utility.z(d.this.a));
                }
                String str = "1";
                if ((Utility.M(d.this.a) || Utility.P(d.this.a)) && PushSettings.k(d.this.a)) {
                    hashMap.put("rom_version", Utility.z(d.this.a));
                    hashMap.put("support_proxy", d.w(d.this.a) ? "1" : "0");
                }
                hashMap.put("manufacture", Utility.a(d.this.a, false));
                hashMap.put("sdk_version", ((int) com.baidu.android.pushservice.a.a()) + "");
                hashMap.put("cuid", DeviceId.getCUID(d.this.a));
                hashMap.put("package_name", d.this.a.getPackageName());
                if (!d.l(d.this.a)) {
                    str = "0";
                }
                hashMap.put("support_honor", str);
                hashMap.put("app_last_update_ts", Utility.u(d.this.a) + "");
                System.currentTimeMillis();
                HashMap a = d.this.a((HashMap<String, String>) hashMap);
                String str2 = (String) a.get("responseResult");
                if (!TextUtils.isEmpty(str2) && (jSONObject = (JSONObject) new JSONObject(str2).get("response_params")) != null) {
                    if (jSONObject.getInt("status") == 1) {
                        String string = jSONObject.getString("sdkconfig");
                        if (!TextUtils.isEmpty(string) && d.this.a(d.this.a, string)) {
                            d.this.h();
                        }
                    }
                    if (this.d) {
                        d.this.a(jSONObject);
                    } else {
                        d.b(d.this.a, jSONObject.toString());
                    }
                }
                Integer.parseInt((String) a.get(CloudStabilityUBCUtils.KEY_RESPONSE_CODE));
            } catch (Exception unused) {
            }
            InterfaceC0029d interfaceC0029d = this.e;
            if (interfaceC0029d != null) {
                interfaceC0029d.a();
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.l.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0029d {
        void a();
    }

    public d(Context context) {
        super(context);
        this.d = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updateconfig";
        this.g = 0;
        this.h = com.baidu.android.pushservice.a.a();
        this.c = "/data/data/" + this.a.getPackageName() + "/files/bdpush_modeconfig.json";
        h();
    }

    public static boolean A(Context context) {
        try {
            if (y(context)) {
                return i.a(context, "vi_push_proxy_mode", 0) == 1;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean B(Context context) {
        try {
            if (i(context).b() == 6) {
                return z(context);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void C(Context context) {
        String c2 = i.c(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        long a2 = k.a(context, "last_update_config_time", 0L) / 1000;
        long u2 = Utility.u(context);
        boolean a3 = k.a(context, "last_update_config_time");
        if (TextUtils.isEmpty(c2) || a2 > u2 || !a3) {
            return;
        }
        k.b(context, "last_update_config_time", System.currentTimeMillis());
        i(context).a(true, c2, new b());
    }

    public static void a(Context context, int i) {
        k.c(context, "ach_register", i);
    }

    public static void a(Context context, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("ach_service", -1);
        p = optInt;
        c(context, optInt);
        int optInt2 = jSONObject.optInt("ach_service_hpkit", -1);
        q = optInt2;
        d(context, optInt2);
        k.b(context, "last_update_config_time", System.currentTimeMillis());
        int optInt3 = jSONObject.optInt("ach_register");
        r = optInt3;
        a(context, optInt3);
        int optInt4 = jSONObject.optInt("data_report_switch");
        s = optInt4;
        com.baidu.android.pushservice.v.c.a().a(context, jSONObject.optJSONObject("ach_sw_info"));
        b(context, optInt4);
        k.a(context, "push_ach_bypass_key", jSONObject.optString("ach_bypass_key"));
    }

    public static boolean a(Context context) {
        if (l == -1) {
            l = i.a(context, "bddns_enable", 1);
        }
        return !g.f() && l == 1;
    }

    public static void b(Context context, int i) {
        k.c(context, "data_report_switch", i);
    }

    public static void b(Context context, String str) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.SAVE_PUSH_PROCESS_SP");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, PushServiceReceiver.class);
        intent.putExtra("com.baidu.android.pushservice.UPDATE_CONF_RESPONSE_DATA", str);
        context.sendBroadcast(intent);
    }

    public static boolean b(Context context) {
        if (n == -1) {
            n = i.a(context, "enable_front_switch", 0);
        }
        return n == 1;
    }

    public static void c(Context context, int i) {
        k.c(context, "ach_service_switch", i);
        boolean z = false;
        if (i.a(context, "key_push_launch_task_level", 0) == 0 && i == 1) {
            z = true;
        }
        com.baidu.android.pushservice.v.c.a().a(context, "com.baidu.android.pushservice.ach.PushAchService", z ? 1 : 2);
    }

    public static boolean c(Context context) {
        if (r == -1) {
            r = k.a(context, "ach_register", 0);
        }
        return r == 1;
    }

    public static void d(Context context, int i) {
        k.c(context, "ach_service_hpkit_switch", i);
        boolean z = false;
        if (i.a(context, "key_push_launch_task_level", 0) == 0 && i == 1) {
            z = true;
        }
        com.baidu.android.pushservice.v.c.a().a(context, "com.baidu.android.pushservice.ach.power.PushAchHpkitService", z ? 1 : 2);
    }

    public static boolean d(Context context) {
        if (s == -1) {
            s = k.a(context, "data_report_switch", 0);
        }
        return s == 1;
    }

    public static boolean e(Context context) {
        if (p == -1) {
            p = k.a(context, "ach_service_switch", 0);
        }
        return p == 1;
    }

    public static int f(Context context) {
        return i.a(context, "push_bind_interval", 12);
    }

    public static int g(Context context) {
        if (o == -1) {
            o = i.a(context, "honor_bind_type", 0);
        }
        return o;
    }

    public static boolean h(Context context) {
        if (q == -1) {
            q = k.a(context, "ach_service_hpkit_switch", 0);
        }
        return q == 1;
    }

    public static d i(Context context) {
        if (t == null) {
            synchronized (d.class) {
                if (t == null) {
                    t = new d(context);
                }
            }
        }
        return t;
    }

    public static List<String> j(Context context) {
        ArrayList arrayList = new ArrayList();
        String c2 = i.c(context, "keep_alive_pkgs");
        if (!TextUtils.isEmpty(c2)) {
            try {
                JSONArray jSONArray = new JSONArray(c2);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    if (!TextUtils.equals(context.getPackageName(), string)) {
                        arrayList.add(string);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public static boolean k(Context context) {
        try {
            return HonorApiAvailability.b(context) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean l(Context context) {
        return i(context).b() == 10 && PushSettings.g(context) && k(context);
    }

    public static boolean m(Context context) {
        return u(context) && i(context).b() == 5;
    }

    public static boolean n(Context context) {
        try {
            if (v(context)) {
                return i(context).b() == 7;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean o(Context context) {
        if (m == -1) {
            m = i.a(context, "enable_newcid", 0);
        }
        return m == 1;
    }

    public static boolean p(Context context) {
        try {
            if (i(context).b() == 8 && PushSettings.k(context)) {
                return Class.forName("com.heytap.msp.push.HeytapPushManager") != null;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean q(Context context) {
        if (k == -1) {
            k = i.a(context, "enable_conn_for_proxy", 0);
        }
        return k == 1;
    }

    public static boolean r(Context context) {
        switch (i(context).b()) {
            case 5:
                return PushSettings.h(context);
            case 6:
                return PushSettings.m(context);
            case 7:
                return PushSettings.j(context);
            case 8:
                return PushSettings.k(context);
            case 9:
                return PushSettings.l(context);
            case 10:
                return PushSettings.g(context);
            default:
                return false;
        }
    }

    public static boolean s(Context context) {
        if (j == -1) {
            j = (com.baidu.android.pushservice.a.a(context.getPackageName()) || i.a(context, "enable_single_conn", 1) == 1) ? 1 : 0;
        }
        return j == 1;
    }

    public static boolean t(Context context) {
        return i(context).b() == 10;
    }

    public static boolean u(Context context) {
        return Utility.H(context) && PushSettings.h(context);
    }

    public static boolean v(Context context) {
        try {
            if (Utility.J(context) && PushSettings.j(context)) {
                return Class.forName("com.meizu.cloud.pushsdk.PushManager") != null;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean w(Context context) {
        try {
            Class.forName("com.heytap.mcssdk.PushService");
            Class.forName("com.heytap.msp.push.HeytapPushManager");
            return HeytapPushManager.isSupportPush(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean x(Context context) {
        try {
            if (Utility.S(context) && PushSettings.l(context)) {
                return Class.forName("com.vivo.push.PushClient") != null;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean y(Context context) {
        try {
            if (x(context)) {
                return i(context).b() == 9;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean z(Context context) {
        try {
            if (Utility.T(context) && PushSettings.m(context)) {
                return Class.forName("com.xiaomi.mipush.sdk.MiPushClient") != null;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final com.baidu.android.pushservice.l.c a(String str) {
        Map<String, com.baidu.android.pushservice.l.c> map;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String upperCase = str.toUpperCase();
        String a2 = Utility.a(this.a, true);
        if (!a2.equalsIgnoreCase("unknown") || (map = this.i) == null) {
            Map<String, com.baidu.android.pushservice.l.c> map2 = this.i;
            if (map2 != null && map2.containsKey(upperCase)) {
                if (a2.equalsIgnoreCase("HONOR")) {
                    return a(this.i);
                }
                if (a(this.i.get(upperCase), upperCase)) {
                    return this.i.get(upperCase);
                }
                if (upperCase.equalsIgnoreCase("OPPO") && PushSettings.k(this.a) && w(this.a)) {
                    return this.i.get(upperCase);
                }
            }
        } else {
            for (Map.Entry<String, com.baidu.android.pushservice.l.c> entry : map.entrySet()) {
                String key = entry.getKey();
                if (a(this.i.get(key), key)) {
                    return this.i.get(key);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (a(r3.get("HONOR"), "HONOR") != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.baidu.android.pushservice.l.c a(Map<String, com.baidu.android.pushservice.l.c> map) {
        String str = (PushSettings.g(this.a) && k(this.a)) ? "HONOR" : "HUAWEI";
        if (!a(map.get("HUAWEI"), "HUAWEI")) {
            return null;
        }
        return this.i.get(str);
    }

    public final HashMap<String, String> a(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        this.d = (g.f() ? g.c() : g.d()) + "/rest/3.0/clientfile/updateconf";
        int i = 2;
        do {
            com.baidu.android.pushservice.q.b a2 = com.baidu.android.pushservice.q.c.a(this.a, this.d, "POST", hashMap, "BCCS_SDK/3.0", g.b());
            if (a2 != null) {
                int a3 = a2.a();
                hashMap2.put(CloudStabilityUBCUtils.KEY_RESPONSE_CODE, a3 + "");
                hashMap2.put("responseResult", Utility.a(this.a, a2.b()));
                if (a3 == 200) {
                    return hashMap2;
                }
            }
            i--;
        } while (i > 0);
        return hashMap2;
    }

    public final void a(com.baidu.android.pushservice.l.c cVar) {
        i.b(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE", cVar != null ? cVar.toString() : "CONFIG_MANUFACTURER_DEFAULT");
        i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.e);
        i();
    }

    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x004d */
    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x0167 */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
        if (java.lang.Float.parseFloat(r4) >= 5.0d) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ab, code lost:
        if (java.lang.Float.parseFloat(r4) >= 4.0d) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00dc, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.0d) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x010d, code lost:
        if (java.lang.Float.parseFloat(r4) >= 6.0d) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x013b, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.1d) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x014c, code lost:
        if (com.baidu.android.pushservice.util.Utility.P(r9.a) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0164, code lost:
        if (w(r9.a) == false) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x018d A[Catch: all -> 0x0198, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:6:0x001a, B:8:0x0027, B:10:0x002f, B:12:0x0037, B:14:0x0043, B:18:0x004d, B:20:0x0055, B:22:0x005d, B:24:0x0065, B:26:0x0071, B:89:0x0167, B:92:0x017a, B:95:0x018d, B:30:0x007e, B:32:0x0086, B:34:0x008e, B:36:0x0096, B:38:0x00a2, B:42:0x00af, B:44:0x00b7, B:46:0x00bf, B:48:0x00c7, B:50:0x00d3, B:54:0x00e0, B:56:0x00e8, B:58:0x00f0, B:60:0x00f8, B:62:0x0104, B:66:0x0110, B:68:0x0118, B:70:0x0120, B:72:0x0128, B:74:0x0134, B:78:0x013e, B:80:0x0146, B:82:0x014e, B:84:0x0156, B:86:0x015e), top: B:105:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(String str, InterfaceC0029d interfaceC0029d) {
        String z;
        long a2 = i.a(this.a, "cloud_update_config_time", 0) * 24 * 3600 * 1000;
        if (a2 <= 0) {
            a2 = 259200000;
        }
        if (Utility.H(this.a) && PushSettings.h(this.a) && !m(this.a)) {
            try {
                if (!TextUtils.isEmpty(Utility.z(this.a))) {
                    if (Float.parseFloat(z) >= 3.1d) {
                        a2 = 0;
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (Utility.G(this.a) && PushSettings.g(this.a) && !l(this.a)) {
            if (!TextUtils.isEmpty(Utility.z(this.a))) {
            }
            if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
            }
        } else if (Utility.T(this.a) && PushSettings.m(this.a) && !B(this.a)) {
            if (!TextUtils.isEmpty(Utility.z(this.a))) {
            }
            if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
            }
        } else if (Utility.N(this.a) && PushSettings.k(this.a) && !p(this.a)) {
            if (!TextUtils.isEmpty(Utility.z(this.a))) {
            }
            if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
            }
        } else if (Utility.J(this.a) && PushSettings.j(this.a) && !n(this.a)) {
            if (!TextUtils.isEmpty(Utility.z(this.a))) {
            }
            if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
            }
        } else if (!Utility.S(this.a) || !PushSettings.l(this.a) || A(this.a)) {
            if (!Utility.M(this.a)) {
            }
            if (PushSettings.k(this.a)) {
                if (!p(this.a)) {
                }
            }
            if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
                a(Utility.I(this.a), str, interfaceC0029d);
                return;
            }
            if (interfaceC0029d != null) {
                com.baidu.android.pushservice.z.e.a().a(new a(this, "updateConfig-local", (short) 99, interfaceC0029d));
            }
            return;
        } else {
            if (!TextUtils.isEmpty(Utility.z(this.a))) {
            }
            if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
            }
        }
        a2 = 0;
        if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
        }
    }

    public final void a(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("newcid", -1);
        if (optInt != -1) {
            m = optInt;
            i.b(this.a, "enable_newcid", optInt);
        }
        int optInt2 = jSONObject.optInt("honor_bind_type", -1);
        if (optInt2 != -1) {
            o = optInt2;
            i.b(this.a, "honor_bind_type", optInt2);
        }
        int optInt3 = jSONObject.optInt("mode", -1);
        if (optInt3 != -1) {
            k = optInt3;
            i.b(this.a, "enable_conn_for_proxy", optInt3);
        }
        int optInt4 = jSONObject.optInt("front_switch", -1);
        if (optInt4 != -1) {
            n = optInt4;
            i.b(this.a, "enable_front_switch", optInt4);
        }
        int optInt5 = jSONObject.optInt("enable_bddns", -1);
        if (optInt5 != -1) {
            l = optInt5;
            i.b(this.a, "bddns_enable", optInt5);
        }
        int optInt6 = jSONObject.optInt("single", -1);
        if (optInt6 != -1) {
            j = optInt6;
            i.b(this.a, "enable_single_conn", optInt6);
        }
        i.b(this.a, "cloud_update_config_time", jSONObject.optInt("update_time", 0));
        int optInt7 = jSONObject.optInt("bind_time", -1);
        if (optInt7 != -1) {
            i.b(this.a, "push_bind_interval", optInt7);
        }
        int optInt8 = jSONObject.optInt("stat", -1);
        if (optInt8 != -1) {
            i.b(this.a, "enable_stat_upload", optInt8);
        }
        int optInt9 = jSONObject.optInt("stat_real_time", -1);
        if (optInt9 != -1) {
            i.b(this.a, "enable_stat_real_time", optInt9);
        }
        int optInt10 = jSONObject.optInt("stat_time", -1);
        if (optInt10 != -1) {
            i.b(this.a, "stat_upload_interval", optInt10);
        }
        i.c(this.a, "keep_alive_pkgs", jSONObject.optString("keep_alive", null));
        i.b(this.a, "key_vip_type", jSONObject.optInt("vip_type", 3));
        JSONObject optJSONObject = jSONObject.optJSONObject("upload_control");
        if (optJSONObject != null) {
            b(optJSONObject);
        }
        if (jSONObject.has("pull_config")) {
            com.baidu.android.pushservice.y.c.b(this.a, jSONObject.optJSONObject("pull_config"));
        }
        if (jSONObject.has("am_config")) {
            com.baidu.android.pushservice.y.c.a(this.a, jSONObject.optJSONObject("am_config"));
        }
        b(this.a, jSONObject.toString());
    }

    public void a(boolean z, String str, InterfaceC0029d interfaceC0029d) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.android.pushservice.z.e.a().a(new c("ModeConfig-updateConfig", (short) 100, str, z, interfaceC0029d));
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0081 A[Catch: Exception -> 0x009b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x009b, blocks: (B:12:0x002d, B:14:0x003d, B:16:0x0043, B:19:0x004b, B:20:0x004f, B:27:0x005c, B:51:0x0098, B:29:0x0061, B:31:0x0067, B:33:0x006d, B:35:0x0073, B:36:0x0077, B:42:0x0081, B:44:0x0086, B:46:0x008d, B:49:0x0094), top: B:127:0x002d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(com.baidu.android.pushservice.l.c cVar, String str) {
        String str2;
        Context context;
        String str3;
        String i;
        String b2;
        Context context2;
        String str4;
        int i2;
        int i3;
        double d;
        if (cVar != null && cVar.f() != null && cVar.f().size() > 0) {
            for (int i4 = 0; i4 < cVar.f().size(); i4++) {
                e eVar = cVar.f().get(i4);
                try {
                    i = Utility.i(this.a, str);
                    b2 = eVar.b();
                } catch (Exception unused) {
                }
                if (eVar.a() == 0) {
                    if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(i)) {
                        double d2 = 0.0d;
                        try {
                            d = Double.parseDouble(b2);
                            try {
                                d2 = Double.parseDouble(i);
                            } catch (NumberFormatException unused2) {
                            }
                        } catch (NumberFormatException unused3) {
                            d = 0.0d;
                        }
                        if (d2 >= d) {
                            return true;
                        }
                        context2 = this.a;
                        str4 = "manufaturer can not Matched, osversion is not ABOVE ";
                    }
                } else if (eVar.a() == 1) {
                    if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(i)) {
                        try {
                            i2 = Integer.parseInt(b2);
                            try {
                                i3 = Integer.parseInt(i);
                            } catch (NumberFormatException unused4) {
                                i3 = 0;
                                if (i3 != i2) {
                                }
                            }
                        } catch (NumberFormatException unused5) {
                            i2 = 0;
                        }
                        if (i3 != i2) {
                            return true;
                        }
                        context2 = this.a;
                        str4 = "manufaturer can not Matched, osversion is not EQUAL ";
                    }
                } else if (eVar.a() != 2) {
                    continue;
                } else if (Pattern.matches(b2, i)) {
                    return true;
                } else {
                    context2 = this.a;
                    str4 = "manufaturer can not Matched, osversion is not REGULAR ";
                }
                com.baidu.android.pushservice.u.a.a("ModeConfig", str4, context2);
            }
        }
        if (cVar != null && cVar.h() != null && cVar.h().size() > 0) {
            for (int i5 = 0; i5 < cVar.h().size(); i5++) {
                f fVar = cVar.h().get(i5);
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        str2 = SystemProperties.get(fVar.a());
                    } else {
                        Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                        str2 = (String) cls.getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, fVar.a());
                    }
                    if (((str.equalsIgnoreCase("HUAWEI") && Utility.b()) || str.equalsIgnoreCase("HONOR")) && !Utility.K(this.a) && !Utility.a(str2, "\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21 && PushSettings.h(this.a)) {
                        str2 = Constants.SDK_VER;
                    }
                    if (str.equalsIgnoreCase("OPPO") && PushSettings.k(this.a) && !w(this.a)) {
                        str2 = "V1.0";
                    }
                    Matcher matcher = Pattern.compile(fVar.c()).matcher(str2);
                    if (matcher.find()) {
                        Double valueOf = Double.valueOf(str.equalsIgnoreCase("OPPO") ? matcher.group(1) : matcher.group());
                        Double valueOf2 = Double.valueOf(fVar.d());
                        if (fVar.b() == 0) {
                            if (valueOf.doubleValue() >= valueOf2.doubleValue()) {
                                return true;
                            }
                            context = this.a;
                            str3 = "versioncode < configversioncode, manufaturer can not Matched, osversion is not ABOVE ";
                        } else if (fVar.b() != 1) {
                            continue;
                        } else if (valueOf == valueOf2) {
                            return true;
                        } else {
                            context = this.a;
                            str3 = "versioncode != configversioncode, manufaturer can not Matched, osversion is not EQUAL ";
                        }
                        com.baidu.android.pushservice.u.a.a("ModeConfig", str3, context);
                    } else {
                        continue;
                    }
                } catch (Throwable unused6) {
                }
            }
        }
        if (cVar == null || cVar.g() != 1) {
            return false;
        }
        return (Utility.M(this.a) || Utility.P(this.a)) && w(this.a);
    }

    public int b() {
        return this.g;
    }

    public final void b(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data_sensitive");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("time_sensitive");
            JSONArray optJSONArray = jSONObject.optJSONArray("bind_attr");
            int optInt = jSONObject.optInt("click_data_size", -1);
            if (optInt != i.a(this.a, "click_data_size", -1) && optInt == -1) {
                com.baidu.android.pushservice.m.d.b(this.a);
            }
            i.b(this.a, "click_data_size", optInt);
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    arrayList.add(next);
                    com.baidu.android.pushservice.m.d.a(this.a, next, 1, optJSONObject.getLong(next));
                }
            }
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    arrayList.add(next2);
                    com.baidu.android.pushservice.m.d.a(this.a, next2, 0, optJSONObject2.getLong(next2));
                }
            }
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                optJSONArray = new JSONArray("[\"alert_freq\", \"bduss\", \"app_notify_status\"]");
            }
            com.baidu.android.pushservice.m.d.b(this.a, optJSONArray);
            com.baidu.android.pushservice.m.d.a(this.a, (ArrayList<String>) arrayList);
        } catch (Exception unused) {
        }
    }

    public int c() {
        return this.h;
    }

    public final boolean d() {
        int a2 = i.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
        this.e = a2;
        if (a2 == -1) {
            return false;
        }
        String c2 = i.c(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
        if (TextUtils.isEmpty(c2)) {
            return false;
        }
        if (c2.equals("CONFIG_MANUFACTURER_DEFAULT")) {
            return true;
        }
        this.f = new com.baidu.android.pushservice.l.c(this.a, c2);
        return true;
    }

    public final boolean e() {
        if (System.currentTimeMillis() - i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE") > 604800000) {
            return true;
        }
        long b2 = i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
        File file = new File(this.c);
        if (file.exists()) {
            long j2 = 0;
            if (b2 <= 0 || b2 != file.lastModified()) {
                return true;
            }
            long b3 = i.b(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
            for (String str : v) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j2 = (file2.lastModified() / 10) + j2;
                }
            }
            return b3 != j2;
        }
        return true;
    }

    public final void f() {
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            this.e = jSONObject.getInt("version");
            this.i = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("modeconfig");
            for (int i = 0; i < jSONArray.length(); i++) {
                com.baidu.android.pushservice.l.c cVar = new com.baidu.android.pushservice.l.c(this.a, jSONArray.getString(i));
                this.i.put(cVar.d(), cVar);
            }
            com.baidu.android.pushservice.l.c a2 = a(Utility.a(this.a, true));
            this.f = a2;
            a(a2);
        } catch (Exception unused) {
        }
    }

    public boolean g() {
        com.baidu.android.pushservice.l.c cVar = this.f;
        if (cVar == null) {
            return true;
        }
        if (cVar.e() == 5) {
            this.g = 5;
            return true;
        } else if (this.f.e() == 6) {
            this.g = 6;
            return true;
        } else if (this.f.e() == 7) {
            this.g = 7;
            return true;
        } else if (this.f.e() == 8) {
            this.g = 8;
            return true;
        } else if (this.f.e() == 9) {
            this.g = 9;
            return true;
        } else if (this.f.e() == 10) {
            this.g = 10;
            return true;
        } else {
            if (this.f.e() == 2 && !TextUtils.isEmpty(this.f.a())) {
                try {
                    PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.f.a(), 16448);
                    if (packageInfo != null) {
                        int i = packageInfo.versionCode;
                        if ((this.f.c() != null && (this.f.c().b != -1 ? !(i < this.f.c().a || i > this.f.c().b) : i >= this.f.c().a)) && BaiduAppSSOJni.encodeBySha1(packageInfo.signatures[0].toByteArray()).equalsIgnoreCase(this.f.b())) {
                            this.h = Utility.g(this.a, this.f.a());
                            this.g = this.a.getPackageName().equalsIgnoreCase(this.f.a()) ? 3 : 4;
                            return true;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    return false;
                }
            }
            com.baidu.android.pushservice.u.a.a("ModeConfig", " Current Mode = " + this.g, this.a);
            return false;
        }
    }

    public void h() {
        boolean e = e();
        boolean d = d();
        if ((e || !d) && a()) {
            f();
        }
        if (this.f != null) {
            g();
        } else {
            com.baidu.android.pushservice.u.a.a("ModeConfig", "Config File Not Matched", this.a);
        }
    }

    public final void i() {
        File file = new File(this.c);
        if (file.exists()) {
            i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", file.lastModified());
            long j2 = 0;
            for (String str : v) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j2 = (file2.lastModified() / 10) + j2;
                }
            }
            i.b(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED", j2);
            i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE", System.currentTimeMillis());
        }
    }
}
