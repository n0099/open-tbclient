package com.baidu.android.pushservice.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.i;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.down.utils.Constants;
import com.baidu.live.tbadk.data.Config;
import com.baidu.sapi2.SapiContext;
import com.heytap.mcssdk.PushManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d extends b {
    private static d k;
    private String d;
    private int l;
    private c m;
    private int n;
    private int o;
    private final String p;
    private final String q;
    private Map<String, c> r;
    private static int e = -1;
    private static int f = -1;
    private static int g = -1;
    private static int h = -1;
    private static int i = -1;
    private static int j = -1;
    private static String[] s = {"/default.prop", "/system/build.prop", "/system/default.prop", "/data/local.prop"};

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    protected d(Context context) {
        super(context);
        this.d = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updateconfig";
        this.n = 0;
        this.o = com.baidu.android.pushservice.a.a();
        this.p = "responseCode";
        this.q = "responseResult";
        this.c = "/data/data/" + this.a.getPackageName() + "/files/bdpush_modeconfig.json";
        e();
    }

    private c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String upperCase = str.toUpperCase();
        if (Build.MANUFACTURER.toUpperCase().equalsIgnoreCase("unknown") && this.r != null) {
            for (Map.Entry<String, c> entry : this.r.entrySet()) {
                String key = entry.getKey();
                if (a(this.r.get(key), key)) {
                    return this.r.get(key);
                }
            }
        } else if (this.r != null && this.r.containsKey(upperCase) && a(this.r.get(upperCase), upperCase)) {
            return this.r.get(upperCase);
        }
        return null;
    }

    public static d a(Context context) {
        if (k == null) {
            synchronized (d.class) {
                if (k == null) {
                    k = new d(context);
                }
            }
        }
        return k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> a(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        this.d = (h.f() ? h.a() : h.b()) + "/rest/3.0/clientfile/updateconf";
        int i2 = 2;
        while (true) {
            int i3 = i2;
            com.baidu.android.pushservice.e.a a2 = com.baidu.android.pushservice.e.b.a(this.a, this.d, "POST", hashMap, "BCCS_SDK/3.0", h.c());
            if (a2 != null) {
                int b = a2.b();
                hashMap2.put("responseCode", b + "");
                hashMap2.put("responseResult", m.a(this.a, a2.a()));
                if (b == 200) {
                    return hashMap2;
                }
            }
            i2 = i3 - 1;
            if (i2 <= 0) {
                return hashMap2;
            }
        }
    }

    private void a(c cVar) {
        i.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE", cVar != null ? cVar.toString() : "CONFIG_MANUFACTURER_DEFAULT");
        i.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.l);
        l();
    }

    private boolean a(c cVar, String str) {
        String str2;
        int i2;
        int i3;
        double d;
        double d2;
        if (cVar != null && cVar.d() != null && cVar.d().size() > 0) {
            for (int i4 = 0; i4 < cVar.d().size(); i4++) {
                e eVar = cVar.d().get(i4);
                try {
                    String n = m.n(this.a);
                    String a2 = eVar.a();
                    if (eVar.b() == 0) {
                        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(n)) {
                            double d3 = 0.0d;
                            try {
                                d3 = Double.parseDouble(a2);
                                d = d3;
                                d2 = Double.parseDouble(n);
                            } catch (NumberFormatException e2) {
                                d = d3;
                                d2 = 0.0d;
                            }
                            if (d2 >= d) {
                                return true;
                            }
                            com.baidu.android.pushservice.f.a.a("ModeConfig", "manufaturer can not Matched, osversion is not ABOVE ", this.a);
                        }
                    } else if (eVar.b() == 1) {
                        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(n)) {
                            int i5 = 0;
                            try {
                                i5 = Integer.parseInt(a2);
                                i2 = i5;
                                i3 = Integer.parseInt(n);
                            } catch (NumberFormatException e3) {
                                i2 = i5;
                                i3 = 0;
                            }
                            if (i3 == i2) {
                                return true;
                            }
                            com.baidu.android.pushservice.f.a.a("ModeConfig", "manufaturer can not Matched, osversion is not EQUAL ", this.a);
                        }
                    } else if (eVar.b() != 2) {
                        continue;
                    } else if (Pattern.matches(a2, n)) {
                        return true;
                    } else {
                        com.baidu.android.pushservice.f.a.a("ModeConfig", "manufaturer can not Matched, osversion is not REGULAR ", this.a);
                    }
                } catch (Exception e4) {
                }
            }
        }
        if (cVar != null && cVar.e() != null && cVar.e().size() > 0) {
            for (int i6 = 0; i6 < cVar.e().size(); i6++) {
                f fVar = cVar.e().get(i6);
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        str2 = SystemProperties.get(fVar.a());
                    } else {
                        Class<?> cls = Class.forName("android.os.SystemProperties");
                        str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, fVar.a());
                    }
                    if (str.equalsIgnoreCase("HUAWEI") && !m.i() && !str2.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21 && PushSettings.j(this.a)) {
                        str2 = Constants.SDK_VER;
                    }
                    if (str.equalsIgnoreCase(RomUtils.ROM_OPPO) && PushSettings.h(this.a) && !p(this.a)) {
                        str2 = "V1.0";
                    }
                    Matcher matcher = Pattern.compile(fVar.c()).matcher(str2);
                    if (matcher.find()) {
                        Double valueOf = Double.valueOf(str.equalsIgnoreCase(RomUtils.ROM_OPPO) ? matcher.group(1) : matcher.group());
                        Double valueOf2 = Double.valueOf(fVar.b());
                        if (fVar.d() == 0) {
                            if (valueOf.doubleValue() >= valueOf2.doubleValue()) {
                                return true;
                            }
                            com.baidu.android.pushservice.f.a.a("ModeConfig", "versioncode < configversioncode, manufaturer can not Matched, osversion is not ABOVE ", this.a);
                        } else if (fVar.d() != 1) {
                            continue;
                        } else if (valueOf == valueOf2) {
                            return true;
                        } else {
                            com.baidu.android.pushservice.f.a.a("ModeConfig", "versioncode != configversioncode, manufaturer can not Matched, osversion is not EQUAL ", this.a);
                        }
                    } else {
                        continue;
                    }
                } catch (Throwable th) {
                }
            }
        }
        if (cVar == null || cVar.h() != 1) {
            return false;
        }
        return (m.f() || m.g()) && p(this.a);
    }

    public static boolean b(Context context) {
        if (j == -1) {
            j = i.b(context, "enable_newcid", 0);
        }
        return j == 1;
    }

    public static boolean c(Context context) {
        if (h == -1) {
            h = com.baidu.android.pushservice.a.b(context) || i.b(context, "enable_conn_for_proxy", 0) == 1 ? 1 : 0;
        }
        return h == 1;
    }

    public static boolean d(Context context) {
        if (i == -1) {
            i = i.b(context, "bddns_enable", 1);
        }
        return !h.f() && i == 1;
    }

    public static boolean e(Context context) {
        if (g == -1) {
            g = com.baidu.android.pushservice.a.a(context.getPackageName()) || i.b(context, "enable_single_conn", 1) == 1 ? 1 : 0;
        }
        return g == 1;
    }

    public static int f() {
        try {
            return ((Integer) Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper").getMethod("getDelayTime", new Class[0]).invoke(null, new Object[0])).intValue();
        } catch (Exception e2) {
            return 0;
        }
    }

    public static int f(Context context) {
        return i.b(context, "push_bind_interval", 12);
    }

    public static boolean g() {
        try {
            return ((Boolean) Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper").getMethod("isPeakTime", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean g(Context context) {
        if (e == -1) {
            e = i.b(context, "enable_stat_upload", 0);
        }
        return e == 1;
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
            } catch (Exception e2) {
            }
        }
        return arrayList;
    }

    private void i() {
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            this.l = jSONObject.getInt("version");
            this.r = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("modeconfig");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                c cVar = new c(this.a, jSONArray.getString(i2));
                this.r.put(cVar.b(), cVar);
            }
            this.m = a(Build.MANUFACTURER.toUpperCase());
            a(this.m);
        } catch (Exception e2) {
        }
    }

    private boolean j() {
        this.l = i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
        if (this.l == -1) {
            return false;
        }
        String a2 = i.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (!a2.equals("CONFIG_MANUFACTURER_DEFAULT")) {
            this.m = new c(this.a, a2);
        }
        return true;
    }

    public static boolean j(Context context) {
        try {
            if (r(context)) {
                return a(context).b() == 7;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean k() {
        long j2 = 0;
        if (System.currentTimeMillis() - i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE") > 604800000) {
            return true;
        }
        long b = i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
        File file = new File(this.c);
        if (file.exists() && b > 0 && b == file.lastModified()) {
            long b2 = i.b(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
            for (String str : s) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j2 += file2.lastModified() / 10;
                }
            }
            return b2 != j2;
        }
        return true;
    }

    public static boolean k(Context context) {
        try {
            if (a(context).b() == 6) {
                return s(context);
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    private void l() {
        File file = new File(this.c);
        if (file.exists()) {
            i.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", file.lastModified());
            long j2 = 0;
            for (String str : s) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j2 += file2.lastModified() / 10;
                }
            }
            i.a(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED", j2);
            i.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE", System.currentTimeMillis());
        }
    }

    public static boolean l(Context context) {
        return t(context) && a(context).b() == 5;
    }

    public static boolean m(Context context) {
        try {
            if (a(context).b() == 8 && PushSettings.h(context)) {
                return Class.forName("com.heytap.mcssdk.PushManager") != null;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean n(Context context) {
        try {
            if (o(context)) {
                if (i.b(context, "vi_push_proxy_mode", 0) == 1) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean o(Context context) {
        try {
            if (u(context)) {
                return a(context).b() == 9;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean p(Context context) {
        try {
            Class.forName("com.heytap.mcssdk.PushService");
            Class.forName("com.heytap.mcssdk.PushManager");
            return PushManager.isSupportPush(context);
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean q(Context context) {
        switch (a(context).b()) {
            case 5:
                return PushSettings.j(context);
            case 6:
                return PushSettings.f(context);
            case 7:
                return PushSettings.g(context);
            case 8:
                return PushSettings.h(context);
            case 9:
                return PushSettings.i(context);
            default:
                return false;
        }
    }

    private static boolean r(Context context) {
        try {
            if (m.c() && PushSettings.g(context)) {
                return Class.forName("com.meizu.cloud.pushsdk.PushManager") != null;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean s(Context context) {
        try {
            if (m.b() && PushSettings.f(context)) {
                return Class.forName("com.xiaomi.mipush.sdk.MiPushClient") != null;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean t(Context context) {
        return m.d() && PushSettings.j(context);
    }

    private static boolean u(Context context) {
        try {
            if (m.h() && PushSettings.i(context)) {
                return Class.forName("com.vivo.push.PushManager") != null;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.1d) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(final a aVar) {
        String n;
        String n2;
        String n3;
        String n4;
        synchronized (this) {
            long b = i.b(this.a, "cloud_update_config_time", 0) * 24 * 3600 * 1000;
            if (b <= 0) {
                b = Config.THREAD_IMAGE_SAVE_MAX_TIME;
            }
            if (m.d() && PushSettings.j(this.a) && !l(this.a)) {
                try {
                    if (!TextUtils.isEmpty(m.n(this.a))) {
                    }
                    r0 = b;
                    b = r0;
                } catch (Exception e2) {
                }
            } else if (m.b() && PushSettings.f(this.a) && !k(this.a)) {
                try {
                    if (!TextUtils.isEmpty(m.n(this.a))) {
                        if (Float.parseFloat(n4) >= 4.0d) {
                            b = 0;
                        }
                    }
                } catch (Exception e3) {
                }
            } else if (m.e() && PushSettings.h(this.a) && !m(this.a)) {
                try {
                    if (!TextUtils.isEmpty(m.n(this.a))) {
                        if (Float.parseFloat(n3) >= 3.0d) {
                            b = 0;
                        }
                    }
                } catch (Exception e4) {
                }
            } else if (m.c() && PushSettings.g(this.a) && !j(this.a)) {
                try {
                    if (!TextUtils.isEmpty(m.n(this.a))) {
                        if (Float.parseFloat(n2) >= 6.0d) {
                            b = 0;
                        }
                    }
                } catch (Exception e5) {
                }
            } else if (m.h() && PushSettings.i(this.a) && !n(this.a)) {
                try {
                    if (!TextUtils.isEmpty(m.n(this.a))) {
                        if (Float.parseFloat(n) >= 3.1d) {
                            b = 0;
                        }
                    }
                } catch (Exception e6) {
                }
            } else if ((m.f() || m.g()) && PushSettings.h(this.a) && !m(this.a)) {
                try {
                    b = p(this.a) ? 0L : b;
                } catch (Exception e7) {
                }
            }
            long b2 = i.b(this.a, "last_update_config_time");
            final long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b2 > b) {
                com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("ModeConfig-updateConfig", (short) 100) { // from class: com.baidu.android.pushservice.b.d.1
                    @Override // com.baidu.android.pushservice.g.c
                    public void a() {
                        JSONObject jSONObject;
                        try {
                            HashMap hashMap = new HashMap();
                            com.baidu.android.pushservice.d.b.a(d.this.a, hashMap);
                            hashMap.put("version", d.this.l + "");
                            hashMap.put("model", Build.MODEL);
                            hashMap.put("osSdkInt", Build.VERSION.SDK_INT + "");
                            if ((m.d() && PushSettings.j(d.this.a)) || ((m.b() && PushSettings.f(d.this.a)) || ((m.c() && PushSettings.g(d.this.a)) || ((m.e() && PushSettings.h(d.this.a)) || (m.h() && PushSettings.i(d.this.a)))))) {
                                hashMap.put("rom_version", m.n(d.this.a));
                            }
                            if ((m.f() || m.g()) && PushSettings.h(d.this.a)) {
                                hashMap.put("rom_version", m.n(d.this.a));
                                hashMap.put("support_proxy", d.p(d.this.a) ? "1" : "0");
                            }
                            hashMap.put("manufacture", Build.MANUFACTURER);
                            hashMap.put(SapiContext.KEY_SDK_VERSION, ((int) com.baidu.android.pushservice.a.a()) + "");
                            hashMap.put("cuid", DeviceId.getCUID(d.this.a));
                            hashMap.put("package_name", d.this.a.getPackageName());
                            long currentTimeMillis2 = System.currentTimeMillis();
                            HashMap a2 = d.this.a(hashMap);
                            String str = (String) a2.get("responseResult");
                            if (!TextUtils.isEmpty(str) && (jSONObject = (JSONObject) new JSONObject(str).get("response_params")) != null) {
                                if (jSONObject.getInt("status") == 1) {
                                    String string = jSONObject.getString("sdkconfig");
                                    if (!TextUtils.isEmpty(string) && d.this.a(d.this.a, string)) {
                                        d.this.e();
                                    }
                                }
                                i.a(d.this.a, "last_update_config_time", currentTimeMillis);
                                int optInt = jSONObject.optInt("newcid", -1);
                                if (optInt != -1) {
                                    int unused = d.j = optInt;
                                    i.a(d.this.a, "enable_newcid", optInt);
                                }
                                int optInt2 = jSONObject.optInt("mode", -1);
                                if (optInt2 != -1) {
                                    int unused2 = d.h = optInt2;
                                    i.a(d.this.a, "enable_conn_for_proxy", optInt2);
                                }
                                int optInt3 = jSONObject.optInt("enable_bddns", -1);
                                if (optInt3 != -1) {
                                    int unused3 = d.i = optInt3;
                                    i.a(d.this.a, "bddns_enable", optInt3);
                                }
                                int optInt4 = jSONObject.optInt("single", -1);
                                if (optInt4 != -1) {
                                    int unused4 = d.g = optInt4;
                                    i.a(d.this.a, "enable_single_conn", optInt4);
                                }
                                i.a(d.this.a, "cloud_update_config_time", jSONObject.optInt("update_time", 0));
                                int optInt5 = jSONObject.optInt("bind_time", -1);
                                if (optInt5 != -1) {
                                    i.a(d.this.a, "push_bind_interval", optInt5);
                                }
                                int optInt6 = jSONObject.optInt("stat", -1);
                                if (optInt6 != -1) {
                                    int unused5 = d.e = optInt6;
                                    i.a(d.this.a, "enable_stat_upload", optInt6);
                                }
                                int optInt7 = jSONObject.optInt("stat_real_time", -1);
                                if (optInt7 != -1) {
                                    int unused6 = d.f = optInt7;
                                    i.a(d.this.a, "enable_stat_real_time", optInt7);
                                }
                                int optInt8 = jSONObject.optInt("stat_time", -1);
                                if (optInt8 != -1) {
                                    i.a(d.this.a, "stat_upload_interval", optInt8);
                                }
                                i.b(d.this.a, "keep_alive_pkgs", jSONObject.optString("keep_alive", null));
                            }
                            int parseInt = Integer.parseInt((String) a2.get("responseCode"));
                            b.d a3 = new b.d(d.this.a).d(501001L).c(parseInt).a(currentTimeMillis2).b(System.currentTimeMillis()).a(d.this.d);
                            if (parseInt == 200) {
                                str = "";
                            }
                            a3.c(str).a();
                        } catch (Exception e8) {
                        }
                        if (aVar != null) {
                            aVar.a();
                        }
                    }
                });
            } else if (aVar != null) {
                aVar.a();
            }
        }
    }

    public int b() {
        return this.n;
    }

    public int c() {
        return this.o;
    }

    public boolean d() {
        if (this.m == null) {
            return true;
        }
        if (this.m.c() == 5) {
            this.n = 5;
            return true;
        } else if (this.m.c() == 6) {
            this.n = 6;
            return true;
        } else if (this.m.c() == 7) {
            this.n = 7;
            return true;
        } else if (this.m.c() == 8) {
            this.n = 8;
            return true;
        } else if (this.m.c() == 9) {
            this.n = 9;
            return true;
        } else {
            if (this.m.c() == 2 && !TextUtils.isEmpty(this.m.f())) {
                try {
                    PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.m.f(), 16448);
                    if (packageInfo != null) {
                        int i2 = packageInfo.versionCode;
                        if ((this.m.a() != null ? this.m.a().b == -1 ? i2 >= this.m.a().a : i2 >= this.m.a().a && i2 <= this.m.a().b : false) && BaiduAppSSOJni.encodeBySha1(packageInfo.signatures[0].toByteArray()).equalsIgnoreCase(this.m.g())) {
                            this.o = m.g(this.a, this.m.f());
                            if (this.a.getPackageName().equalsIgnoreCase(this.m.f())) {
                                this.n = 3;
                                return true;
                            }
                            this.n = 4;
                            return true;
                        }
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    return false;
                }
            }
            com.baidu.android.pushservice.f.a.a("ModeConfig", " Current Mode = " + this.n, this.a);
            return false;
        }
    }

    public void e() {
        boolean k2 = k();
        boolean j2 = j();
        if ((k2 || !j2) && a()) {
            i();
        }
        if (this.m != null) {
            d();
        } else {
            com.baidu.android.pushservice.f.a.a("ModeConfig", "Config File Not Matched", this.a);
        }
    }
}
