package com.baidu.android.pushservice.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.i;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.down.utils.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.heytap.mcssdk.PushManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends b {

    /* renamed from: e  reason: collision with root package name */
    public static int f2707e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static int f2708f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static int f2709g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static int f2710h = -1;
    public static int i = -1;
    public static int j = -1;
    public static int k = -1;
    public static d l;
    public static String[] t = {"/default.prop", SnapshotConstant.DeviceFilePathConstants.DEVICE_BUILD_CONFIG, "/system/default.prop", "/data/local.prop"};

    /* renamed from: d  reason: collision with root package name */
    public String f2711d;
    public int m;
    public c n;
    public int o;
    public int p;
    public final String q;
    public final String r;
    public Map<String, c> s;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public d(Context context) {
        super(context);
        this.f2711d = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updateconfig";
        this.o = 0;
        this.p = com.baidu.android.pushservice.a.a();
        this.q = CloudStabilityUBCUtils.KEY_RESPONSE_CODE;
        this.r = "responseResult";
        this.f2695c = "/data/data/" + this.f2693a.getPackageName() + "/files/bdpush_modeconfig.json";
        e();
    }

    private c a(String str) {
        c cVar;
        Map<String, c> map;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String upperCase = str.toUpperCase();
        if (!Build.MANUFACTURER.toUpperCase().equalsIgnoreCase("unknown") || (map = this.s) == null) {
            Map<String, c> map2 = this.s;
            if (map2 != null && map2.containsKey(upperCase) && a(this.s.get(upperCase), upperCase)) {
                cVar = this.s.get(upperCase);
                return cVar;
            }
            return null;
        }
        for (Map.Entry<String, c> entry : map.entrySet()) {
            String key = entry.getKey();
            if (a(this.s.get(key), key)) {
                cVar = this.s.get(key);
                return cVar;
            }
        }
        return null;
    }

    public static d a(Context context) {
        if (l == null) {
            synchronized (d.class) {
                if (l == null) {
                    l = new d(context);
                }
            }
        }
        return l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> a(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        this.f2711d = (h.f() ? h.a() : h.b()) + "/rest/3.0/clientfile/updateconf";
        int i2 = 2;
        do {
            com.baidu.android.pushservice.e.b b2 = com.baidu.android.pushservice.e.c.b(this.f2693a, this.f2711d, "POST", hashMap, "BCCS_SDK/3.0", h.c());
            if (b2 != null) {
                int b3 = b2.b();
                hashMap2.put(CloudStabilityUBCUtils.KEY_RESPONSE_CODE, b3 + "");
                hashMap2.put("responseResult", m.a(this.f2693a, b2.a()));
                if (b3 == 200) {
                    return hashMap2;
                }
            }
            i2--;
        } while (i2 > 0);
        return hashMap2;
    }

    private void a(c cVar) {
        i.a(this.f2693a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE", cVar != null ? cVar.toString() : "CONFIG_MANUFACTURER_DEFAULT");
        i.a(this.f2693a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.m);
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data_sensitive");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("time_sensitive");
            JSONArray optJSONArray = jSONObject.optJSONArray("bind_attr");
            int optInt = jSONObject.optInt("click_data_size", -1);
            if (optInt != i.b(this.f2693a, "click_data_size", -1) && optInt == -1) {
                com.baidu.android.pushservice.c.c.g(this.f2693a);
            }
            i.a(this.f2693a, "click_data_size", optInt);
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    arrayList.add(next);
                    com.baidu.android.pushservice.c.c.a(this.f2693a, next, 1, optJSONObject.getLong(next));
                }
            }
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    arrayList.add(next2);
                    com.baidu.android.pushservice.c.c.a(this.f2693a, next2, 0, optJSONObject2.getLong(next2));
                }
            }
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                optJSONArray = new JSONArray("[\"alert_freq\", \"bduss\", \"app_notify_status\"]");
            }
            com.baidu.android.pushservice.c.c.b(this.f2693a, optJSONArray);
            com.baidu.android.pushservice.c.c.a(this.f2693a, arrayList);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x0083 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(c cVar, String str) {
        String str2;
        String str3;
        String n;
        String a2;
        String str4;
        int i2;
        int i3;
        double d2;
        if (cVar != null && cVar.d() != null && cVar.d().size() > 0) {
            for (int i4 = 0; i4 < cVar.d().size(); i4++) {
                e eVar = cVar.d().get(i4);
                try {
                    n = m.n(this.f2693a);
                    a2 = eVar.a();
                } catch (Exception unused) {
                }
                if (eVar.b() == 0) {
                    if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(n)) {
                        double d3 = 0.0d;
                        try {
                            d2 = Double.parseDouble(a2);
                            try {
                                d3 = Double.parseDouble(n);
                            } catch (NumberFormatException unused2) {
                            }
                        } catch (NumberFormatException unused3) {
                            d2 = 0.0d;
                        }
                        if (d3 >= d2) {
                            return true;
                        }
                        str4 = "manufaturer can not Matched, osversion is not ABOVE ";
                    }
                } else if (eVar.b() == 1) {
                    if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(n)) {
                        try {
                            i2 = Integer.parseInt(a2);
                        } catch (NumberFormatException unused4) {
                            i2 = 0;
                        }
                        try {
                            i3 = Integer.parseInt(n);
                        } catch (NumberFormatException unused5) {
                            i3 = 0;
                            if (i3 != i2) {
                            }
                        }
                        if (i3 != i2) {
                            return true;
                        }
                        str4 = "manufaturer can not Matched, osversion is not EQUAL ";
                    }
                } else if (eVar.b() != 2) {
                    continue;
                } else if (Pattern.matches(a2, n)) {
                    return true;
                } else {
                    str4 = "manufaturer can not Matched, osversion is not REGULAR ";
                }
                com.baidu.android.pushservice.g.a.a("ModeConfig", str4, this.f2693a);
            }
        }
        if (cVar != null && cVar.e() != null && cVar.e().size() > 0) {
            for (int i5 = 0; i5 < cVar.e().size(); i5++) {
                f fVar = cVar.e().get(i5);
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        str2 = SystemProperties.get(fVar.a());
                    } else {
                        Class<?> cls = Class.forName("android.os.SystemProperties");
                        str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, fVar.a());
                    }
                    if ((str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("HONOR")) && !m.i() && !str2.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21 && PushSettings.k(this.f2693a)) {
                        str2 = Constants.SDK_VER;
                    }
                    if (str.equalsIgnoreCase("OPPO") && PushSettings.i(this.f2693a) && !p(this.f2693a)) {
                        str2 = "V1.0";
                    }
                    Matcher matcher = Pattern.compile(fVar.c()).matcher(str2);
                    if (matcher.find()) {
                        Double valueOf = Double.valueOf(str.equalsIgnoreCase("OPPO") ? matcher.group(1) : matcher.group());
                        Double valueOf2 = Double.valueOf(fVar.b());
                        if (fVar.d() == 0) {
                            if (valueOf.doubleValue() >= valueOf2.doubleValue()) {
                                return true;
                            }
                            str3 = "versioncode < configversioncode, manufaturer can not Matched, osversion is not ABOVE ";
                        } else if (fVar.d() != 1) {
                            continue;
                        } else if (valueOf == valueOf2) {
                            return true;
                        } else {
                            str3 = "versioncode != configversioncode, manufaturer can not Matched, osversion is not EQUAL ";
                        }
                        com.baidu.android.pushservice.g.a.a("ModeConfig", str3, this.f2693a);
                    } else {
                        continue;
                    }
                } catch (Throwable unused6) {
                }
            }
        }
        if (cVar == null || cVar.h() != 1) {
            return false;
        }
        return (m.f() || m.g()) && p(this.f2693a);
    }

    public static boolean b(Context context) {
        if (j == -1) {
            j = i.b(context, "enable_newcid", 0);
        }
        return j == 1;
    }

    public static boolean c(Context context) {
        if (f2710h == -1) {
            f2710h = i.b(context, "enable_conn_for_proxy", 0);
        }
        return f2710h == 1;
    }

    public static boolean d(Context context) {
        if (k == -1) {
            k = i.b(context, "enable_front_switch", 0);
        }
        return k == 1;
    }

    public static boolean e(Context context) {
        if (f2709g == -1) {
            f2709g = (com.baidu.android.pushservice.a.a(context.getPackageName()) || i.b(context, "enable_single_conn", 1) == 1) ? 1 : 0;
        }
        return f2709g == 1;
    }

    public static int f() {
        try {
            return ((Integer) Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper").getMethod("getDelayTime", new Class[0]).invoke(null, new Object[0])).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int f(Context context) {
        return i.b(context, "push_bind_interval", 12);
    }

    public static boolean g() {
        try {
            return ((Boolean) Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper").getMethod("isPeakTime", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g(Context context) {
        if (f2707e == -1) {
            f2707e = i.b(context, "enable_stat_upload", 0);
        }
        return f2707e == 1;
    }

    public static int h() {
        if (g()) {
            return new Random().nextInt(com.baidu.android.imsdk.internal.Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID) + 10;
        }
        return 0;
    }

    public static int h(Context context) {
        return i.b(context, "stat_upload_interval", 6);
    }

    public static List<String> i(Context context) {
        ArrayList arrayList = new ArrayList();
        String a2 = i.a(context, "keep_alive_pkgs");
        if (!TextUtils.isEmpty(a2)) {
            try {
                JSONArray jSONArray = new JSONArray(a2);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getString(i2);
                    if (!TextUtils.equals(context.getPackageName(), string)) {
                        arrayList.add(string);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private void i() {
        try {
            JSONObject jSONObject = new JSONObject(this.f2694b);
            this.m = jSONObject.getInt("version");
            this.s = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("modeconfig");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                c cVar = new c(this.f2693a, jSONArray.getString(i2));
                this.s.put(cVar.b(), cVar);
            }
            c a2 = a(Build.MANUFACTURER.toUpperCase());
            this.n = a2;
            a(a2);
        } catch (Exception unused) {
        }
    }

    private boolean j() {
        int b2 = i.b(this.f2693a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
        this.m = b2;
        if (b2 == -1) {
            return false;
        }
        String a2 = i.a(this.f2693a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (a2.equals("CONFIG_MANUFACTURER_DEFAULT")) {
            return true;
        }
        this.n = new c(this.f2693a, a2);
        return true;
    }

    public static boolean j(Context context) {
        try {
            if (r(context)) {
                return a(context).b() == 7;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean k() {
        if (System.currentTimeMillis() - i.b(this.f2693a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE") > 604800000) {
            return true;
        }
        long b2 = i.b(this.f2693a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
        File file = new File(this.f2695c);
        if (file.exists()) {
            long j2 = 0;
            if (b2 <= 0 || b2 != file.lastModified()) {
                return true;
            }
            long b3 = i.b(this.f2693a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
            for (String str : t) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j2 = (file2.lastModified() / 10) + j2;
                }
            }
            return b3 != j2;
        }
        return true;
    }

    public static boolean k(Context context) {
        try {
            if (a(context).b() == 6) {
                return s(context);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private void l() {
        File file = new File(this.f2695c);
        if (file.exists()) {
            i.a(this.f2693a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", file.lastModified());
            long j2 = 0;
            for (String str : t) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j2 = (file2.lastModified() / 10) + j2;
                }
            }
            i.a(this.f2693a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED", j2);
            i.a(this.f2693a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE", System.currentTimeMillis());
        }
    }

    public static boolean l(Context context) {
        return t(context) && a(context).b() == 5;
    }

    public static boolean m(Context context) {
        try {
            if (a(context).b() == 8 && PushSettings.i(context)) {
                return Class.forName("com.heytap.mcssdk.PushManager") != null;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean n(Context context) {
        try {
            if (o(context)) {
                return i.b(context, "vi_push_proxy_mode", 0) == 1;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean o(Context context) {
        try {
            if (u(context)) {
                return a(context).b() == 9;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean p(Context context) {
        try {
            Class.forName("com.heytap.mcssdk.PushService");
            Class.forName("com.heytap.mcssdk.PushManager");
            return PushManager.isSupportPush(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean q(Context context) {
        switch (a(context).b()) {
            case 5:
                return PushSettings.k(context);
            case 6:
                return PushSettings.g(context);
            case 7:
                return PushSettings.h(context);
            case 8:
                return PushSettings.i(context);
            case 9:
                return PushSettings.j(context);
            default:
                return false;
        }
    }

    public static boolean r(Context context) {
        try {
            if (m.c() && PushSettings.h(context)) {
                return Class.forName("com.meizu.cloud.pushsdk.PushManager") != null;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean s(Context context) {
        try {
            if (m.b() && PushSettings.g(context)) {
                return Class.forName("com.xiaomi.mipush.sdk.MiPushClient") != null;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean t(Context context) {
        return m.d() && PushSettings.k(context);
    }

    public static boolean u(Context context) {
        try {
            if (m.h() && PushSettings.j(context)) {
                return Class.forName("com.vivo.push.PushManager") != null;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x012d */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.1d) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
        if (java.lang.Float.parseFloat(r4) >= 4.0d) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a8, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.0d) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (java.lang.Float.parseFloat(r4) >= 6.0d) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0103, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.1d) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0129, code lost:
        if (p(r12.f2693a) != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0154 A[Catch: all -> 0x016a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:6:0x001a, B:8:0x0025, B:10:0x002d, B:12:0x0035, B:14:0x0041, B:79:0x012d, B:82:0x0141, B:85:0x0154, B:20:0x004f, B:22:0x0055, B:24:0x005d, B:26:0x0065, B:28:0x0071, B:32:0x007d, B:34:0x0083, B:36:0x008b, B:38:0x0093, B:40:0x009f, B:44:0x00ab, B:46:0x00b1, B:48:0x00b9, B:50:0x00c1, B:52:0x00cd, B:56:0x00da, B:58:0x00e0, B:60:0x00e8, B:62:0x00f0, B:64:0x00fc, B:68:0x0107, B:70:0x010d, B:72:0x0113, B:74:0x011b, B:76:0x0123), top: B:95:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(final String str, final a aVar) {
        long b2;
        final long currentTimeMillis;
        long b3 = i.b(this.f2693a, "cloud_update_config_time", 0) * 24 * 3600 * 1000;
        long j2 = 0;
        if (b3 <= 0) {
            b3 = 259200000;
        }
        if (m.d() && PushSettings.k(this.f2693a) && !l(this.f2693a)) {
            if (!TextUtils.isEmpty(m.n(this.f2693a))) {
            }
            j2 = b3;
        } else if (m.b() && PushSettings.g(this.f2693a) && !k(this.f2693a)) {
            if (!TextUtils.isEmpty(m.n(this.f2693a))) {
            }
            j2 = b3;
        } else if (m.e() && PushSettings.i(this.f2693a) && !m(this.f2693a)) {
            if (!TextUtils.isEmpty(m.n(this.f2693a))) {
            }
            j2 = b3;
        } else if (m.c() && PushSettings.h(this.f2693a) && !j(this.f2693a)) {
            if (!TextUtils.isEmpty(m.n(this.f2693a))) {
            }
            j2 = b3;
        } else if (!m.h() || !PushSettings.j(this.f2693a) || n(this.f2693a)) {
            if ((m.f() || m.g()) && PushSettings.i(this.f2693a) && !m(this.f2693a)) {
            }
            b2 = i.b(this.f2693a, "last_update_config_time");
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b2 <= b3) {
                com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("ModeConfig-updateConfig", (short) 100) { // from class: com.baidu.android.pushservice.b.d.2
                    @Override // com.baidu.android.pushservice.h.c
                    public void a() {
                        JSONObject jSONObject;
                        try {
                            HashMap hashMap = new HashMap();
                            com.baidu.android.pushservice.d.b.a(d.this.f2693a, hashMap);
                            hashMap.put("version", d.this.m + "");
                            hashMap.put("model", Build.MODEL);
                            hashMap.put("osSdkInt", Build.VERSION.SDK_INT + "");
                            hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, str);
                            if ((m.d() && PushSettings.k(d.this.f2693a)) || ((m.b() && PushSettings.g(d.this.f2693a)) || ((m.c() && PushSettings.h(d.this.f2693a)) || ((m.e() && PushSettings.i(d.this.f2693a)) || (m.h() && PushSettings.j(d.this.f2693a)))))) {
                                hashMap.put("rom_version", m.n(d.this.f2693a));
                            }
                            if ((m.f() || m.g()) && PushSettings.i(d.this.f2693a)) {
                                hashMap.put("rom_version", m.n(d.this.f2693a));
                                hashMap.put("support_proxy", d.p(d.this.f2693a) ? "1" : "0");
                            }
                            hashMap.put("manufacture", Build.MANUFACTURER);
                            hashMap.put("sdk_version", ((int) com.baidu.android.pushservice.a.a()) + "");
                            hashMap.put("cuid", DeviceId.getCUID(d.this.f2693a));
                            hashMap.put("package_name", d.this.f2693a.getPackageName());
                            long currentTimeMillis2 = System.currentTimeMillis();
                            HashMap a2 = d.this.a(hashMap);
                            String str2 = (String) a2.get("responseResult");
                            if (!TextUtils.isEmpty(str2) && (jSONObject = (JSONObject) new JSONObject(str2).get("response_params")) != null) {
                                if (jSONObject.getInt("status") == 1) {
                                    String string = jSONObject.getString("sdkconfig");
                                    if (!TextUtils.isEmpty(string) && d.this.a(d.this.f2693a, string)) {
                                        d.this.e();
                                    }
                                }
                                i.a(d.this.f2693a, "last_update_config_time", currentTimeMillis);
                                int optInt = jSONObject.optInt("newcid", -1);
                                if (optInt != -1) {
                                    int unused = d.j = optInt;
                                    i.a(d.this.f2693a, "enable_newcid", optInt);
                                }
                                int optInt2 = jSONObject.optInt("mode", -1);
                                if (optInt2 != -1) {
                                    int unused2 = d.f2710h = optInt2;
                                    i.a(d.this.f2693a, "enable_conn_for_proxy", optInt2);
                                }
                                int optInt3 = jSONObject.optInt("front_switch", -1);
                                if (optInt3 != -1) {
                                    int unused3 = d.k = optInt3;
                                    i.a(d.this.f2693a, "enable_front_switch", optInt3);
                                }
                                int optInt4 = jSONObject.optInt("enable_bddns", -1);
                                if (optInt4 != -1) {
                                    int unused4 = d.i = optInt4;
                                    i.a(d.this.f2693a, "bddns_enable", optInt4);
                                }
                                int optInt5 = jSONObject.optInt("single", -1);
                                if (optInt5 != -1) {
                                    int unused5 = d.f2709g = optInt5;
                                    i.a(d.this.f2693a, "enable_single_conn", optInt5);
                                }
                                i.a(d.this.f2693a, "cloud_update_config_time", jSONObject.optInt("update_time", 0));
                                int optInt6 = jSONObject.optInt("bind_time", -1);
                                if (optInt6 != -1) {
                                    i.a(d.this.f2693a, "push_bind_interval", optInt6);
                                }
                                int optInt7 = jSONObject.optInt("stat", -1);
                                if (optInt7 != -1) {
                                    int unused6 = d.f2707e = optInt7;
                                    i.a(d.this.f2693a, "enable_stat_upload", optInt7);
                                }
                                int optInt8 = jSONObject.optInt("stat_real_time", -1);
                                if (optInt8 != -1) {
                                    int unused7 = d.f2708f = optInt8;
                                    i.a(d.this.f2693a, "enable_stat_real_time", optInt8);
                                }
                                int optInt9 = jSONObject.optInt("stat_time", -1);
                                if (optInt9 != -1) {
                                    i.a(d.this.f2693a, "stat_upload_interval", optInt9);
                                }
                                i.b(d.this.f2693a, "keep_alive_pkgs", jSONObject.optString("keep_alive", null));
                                i.a(d.this.f2693a, "key_vip_type", jSONObject.optInt("vip_type", 3));
                                JSONObject optJSONObject = jSONObject.optJSONObject("upload_control");
                                if (optJSONObject != null) {
                                    d.this.a(optJSONObject);
                                }
                            }
                            int parseInt = Integer.parseInt((String) a2.get(CloudStabilityUBCUtils.KEY_RESPONSE_CODE));
                            new b.d(d.this.f2693a).d(501001L).c(parseInt).a(currentTimeMillis2).b(System.currentTimeMillis()).a(d.this.f2711d).c(parseInt != 200 ? str2 : "").a();
                        } catch (Exception unused8) {
                        }
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                    }
                });
                return;
            }
            if (aVar != null) {
                com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("updateConfig-local", (short) 99) { // from class: com.baidu.android.pushservice.b.d.1
                    @Override // com.baidu.android.pushservice.h.c
                    public void a() {
                        aVar.a();
                    }
                });
            }
            return;
        } else {
            if (!TextUtils.isEmpty(m.n(this.f2693a))) {
            }
            j2 = b3;
        }
        b3 = j2;
        b2 = i.b(this.f2693a, "last_update_config_time");
        currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b2 <= b3) {
        }
    }

    public int b() {
        return this.o;
    }

    public int c() {
        return this.p;
    }

    public boolean d() {
        c cVar = this.n;
        if (cVar == null) {
            return true;
        }
        if (cVar.c() == 5) {
            this.o = 5;
            return true;
        } else if (this.n.c() == 6) {
            this.o = 6;
            return true;
        } else if (this.n.c() == 7) {
            this.o = 7;
            return true;
        } else if (this.n.c() == 8) {
            this.o = 8;
            return true;
        } else if (this.n.c() == 9) {
            this.o = 9;
            return true;
        } else {
            if (this.n.c() == 2 && !TextUtils.isEmpty(this.n.f())) {
                try {
                    PackageInfo packageInfo = this.f2693a.getPackageManager().getPackageInfo(this.n.f(), 16448);
                    if (packageInfo != null) {
                        int i2 = packageInfo.versionCode;
                        if ((this.n.a() != null && (this.n.a().f2705b != -1 ? !(i2 < this.n.a().f2704a || i2 > this.n.a().f2705b) : i2 >= this.n.a().f2704a)) && BaiduAppSSOJni.encodeBySha1(packageInfo.signatures[0].toByteArray()).equalsIgnoreCase(this.n.g())) {
                            this.p = m.g(this.f2693a, this.n.f());
                            this.o = this.f2693a.getPackageName().equalsIgnoreCase(this.n.f()) ? 3 : 4;
                            return true;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    return false;
                }
            }
            com.baidu.android.pushservice.g.a.a("ModeConfig", " Current Mode = " + this.o, this.f2693a);
            return false;
        }
    }

    public void e() {
        boolean k2 = k();
        boolean j2 = j();
        if ((k2 || !j2) && a()) {
            i();
        }
        if (this.n != null) {
            d();
        } else {
            com.baidu.android.pushservice.g.a.a("ModeConfig", "Config File Not Matched", this.f2693a);
        }
    }
}
