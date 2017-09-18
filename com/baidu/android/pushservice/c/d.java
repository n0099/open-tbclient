package com.baidu.android.pushservice.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.p;
import com.baidu.tbadk.TbConfig;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends b {
    private static d o;
    public HashMap<String, c> k;
    private String l;
    private int p;
    private c q;
    private int r;
    private int s;
    private String t;
    public static int d = 0;
    public static int e = 1;
    public static int f = 2;
    public static int g = 3;
    public static int h = 4;
    public static int i = 5;
    public static int j = 6;
    private static int m = 259200000;
    private static boolean n = false;
    private static String[] u = {"/default.prop", "/system/build.prop", "/system/default.prop", "/data/local.prop"};

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    protected d(Context context) {
        super(context);
        this.l = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updatesdkconfig";
        this.r = d;
        this.s = com.baidu.android.pushservice.a.a();
        this.t = null;
        com.baidu.android.pushservice.g.a.c("ModeConfig", "ModeConfig constructor......");
        this.c = "/data/data/" + this.a.getPackageName() + "/files/bdpush_modeconfig.json";
        f();
    }

    public static d a(Context context) {
        if (o != null) {
            return o;
        }
        o = new d(context);
        return o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(HashMap<String, String> hashMap) {
        String a2 = h.f() ? h.a() : h.b();
        if ((p.a() && PushSettings.m(this.a)) || (p.b() && PushSettings.n(this.a))) {
            this.l = a2 + "/rest/3.0/clientfile/updateconf";
        } else {
            this.l = a2 + "/rest/3.0/clientfile/updatesdkconfig";
        }
        com.baidu.android.pushservice.g.a.c("ModeConfig", this.l);
        int i2 = 2;
        do {
            com.baidu.android.pushservice.f.a a3 = com.baidu.android.pushservice.f.b.a(this.l, "POST", hashMap, "BCCS_SDK/3.0");
            if (a3 != null) {
                int b = a3.b();
                String a4 = com.baidu.android.pushservice.h.a.b.a(a3.a());
                com.baidu.android.pushservice.g.a.c("ModeConfig", "update config request response, code=" + b + ", result=" + a4);
                if (b == 200) {
                    return a4;
                }
            }
            i2--;
        } while (i2 > 0);
        return null;
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            stringBuffer.append(hexString.toUpperCase(Locale.ENGLISH));
        }
        return stringBuffer.toString();
    }

    private void a(c cVar) {
        m.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE", cVar != null ? cVar.toString() : "CONFIG_MANUFACTURER_DEFAULT");
        m.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.p);
        k();
    }

    private boolean a(c cVar, String str) {
        String a2;
        String b;
        int i2;
        double d2;
        double d3;
        if (cVar != null && cVar.d() != null && cVar.d().size() > 0) {
            com.baidu.android.pushservice.g.a.c("ModeConfig", "getPropValues");
            for (int i3 = 0; i3 < cVar.d().size(); i3++) {
                e eVar = cVar.d().get(i3);
                try {
                    a2 = com.baidu.android.pushservice.j.a.a().a(eVar.a(), "");
                    b = eVar.b();
                    com.baidu.android.pushservice.g.a.c("ModeConfig", "MatchValue=" + eVar.c() + " | " + a2 + "--" + b);
                } catch (Exception e2) {
                    com.baidu.android.pushservice.g.a.a("ModeConfig", e2);
                }
                if (eVar.c() == 0) {
                    if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(a2)) {
                        double d4 = 0.0d;
                        try {
                            d4 = Double.parseDouble(b);
                            d2 = d4;
                            d3 = Double.parseDouble(a2);
                        } catch (NumberFormatException e3) {
                            com.baidu.android.pushservice.g.a.a("ModeConfig", "number format exception  confv " + d4 + " val 0.0", e3);
                            d2 = d4;
                            d3 = 0.0d;
                        }
                        if (d3 >= d2) {
                            com.baidu.android.pushservice.g.a.c("ModeConfig", "manufacturerMatched success!!!");
                            return true;
                        }
                        com.baidu.android.pushservice.g.b.a("ModeConfig", "manufaturer can not Matched, osversion is not ABOVE ", this.a);
                    }
                } else {
                    if (eVar.c() == 1) {
                        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(a2)) {
                            int i4 = 0;
                            try {
                                i4 = Integer.parseInt(b);
                                i2 = Integer.parseInt(a2);
                            } catch (NumberFormatException e4) {
                                com.baidu.android.pushservice.g.a.a("ModeConfig", "number format exception  confv " + i4 + " val 0", e4);
                                i2 = 0;
                            }
                            if (i2 == i4) {
                                com.baidu.android.pushservice.g.a.c("ModeConfig", "manufacturerMatched success!!!");
                                return true;
                            }
                            com.baidu.android.pushservice.g.b.a("ModeConfig", "manufaturer can not Matched, osversion is not EQUAL ", this.a);
                        }
                    } else if (eVar.c() != 2) {
                        continue;
                    } else if (Pattern.matches(b, a2)) {
                        com.baidu.android.pushservice.g.a.c("ModeConfig", "manufacturerMatched success!!!");
                        return true;
                    } else {
                        com.baidu.android.pushservice.g.a.c("ModeConfig", "manufacturerMatched failure!!!");
                        com.baidu.android.pushservice.g.b.a("ModeConfig", "manufaturer can not Matched, osversion is not REGULAR ", this.a);
                    }
                }
                com.baidu.android.pushservice.g.a.a("ModeConfig", e2);
            }
        }
        if (cVar.e() != null && cVar.e().size() > 0) {
            com.baidu.android.pushservice.g.a.c("ModeConfig", "getSystemProps");
            for (int i5 = 0; i5 < cVar.e().size(); i5++) {
                f fVar = cVar.e().get(i5);
                try {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, fVar.a());
                    com.baidu.android.pushservice.g.a.c("ModeConfig", " buildVersion " + str2);
                    String lowerCase = Build.MODEL.toLowerCase();
                    boolean z = false;
                    if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains("nexus")) {
                        z = true;
                        com.baidu.android.pushservice.g.b.a("ModeConfig", "manufaturer  is Nexus ", this.a);
                    }
                    if (str.equalsIgnoreCase("HUAWEI") && !z && !str2.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21 && PushSettings.n(this.a)) {
                        str2 = "3.1";
                    }
                    Matcher matcher = Pattern.compile(fVar.c()).matcher(str2);
                    if (matcher.find()) {
                        Double valueOf = Double.valueOf(matcher.group());
                        Double valueOf2 = Double.valueOf(fVar.b());
                        if (fVar.d() == 0) {
                            if (valueOf.doubleValue() >= valueOf2.doubleValue()) {
                                com.baidu.android.pushservice.g.a.c("ModeConfig", "versioncode >= configversioncode, manufacturerMatched success!!!");
                                return true;
                            }
                            com.baidu.android.pushservice.g.b.a("ModeConfig", "versioncode < configversioncode, manufaturer can not Matched, osversion is not ABOVE ", this.a);
                        } else if (fVar.d() != 1) {
                            continue;
                        } else if (valueOf == valueOf2) {
                            com.baidu.android.pushservice.g.a.c("ModeConfig", "versioncode == configversioncode, manufacturerMatched success!!!");
                            return true;
                        } else {
                            com.baidu.android.pushservice.g.b.a("ModeConfig", "versioncode != configversioncode, manufaturer can not Matched, osversion is not EQUAL ", this.a);
                        }
                    } else {
                        continue;
                    }
                } catch (Exception e5) {
                    com.baidu.android.pushservice.g.a.a("ModeConfig", e5);
                }
            }
        }
        return false;
    }

    private c b(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.android.pushservice.g.a.c("ModeConfig", "facturerName is null!");
            return null;
        }
        String upperCase = str.toUpperCase();
        if (Build.MANUFACTURER.toUpperCase().equalsIgnoreCase("unknown") && this.k != null) {
            com.baidu.android.pushservice.g.a.c("ModeConfig", "manufacturer is unknown!");
            for (Map.Entry<String, c> entry : this.k.entrySet()) {
                String key = entry.getKey();
                if (a(this.k.get(key), key)) {
                    return this.k.get(key);
                }
            }
        } else if (this.k != null && this.k.containsKey(upperCase)) {
            com.baidu.android.pushservice.g.a.c("ModeConfig", "mManufacturers containsKey " + upperCase);
            if (a(this.k.get(upperCase), upperCase)) {
                return this.k.get(upperCase);
            }
        }
        return null;
    }

    public static boolean b(Context context) {
        try {
            MiPushClient.getRegId(context);
            if (a(context).b() == j) {
                return PushSettings.m(context);
            }
            return false;
        } catch (Throwable th) {
            com.baidu.android.pushservice.g.a.e("ModeConfig", "not found com.xiaomi.mipush pkg, not xiaomiproxy mode!!!");
            return false;
        }
    }

    public static boolean c(Context context) {
        return a(context).b() == i && PushSettings.n(context);
    }

    public static boolean d(Context context) {
        return c(context) || b(context);
    }

    private boolean h() {
        com.baidu.android.pushservice.g.a.c("ModeConfig", "parseConfig begin.....");
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            this.p = jSONObject.getInt("version");
            this.k = new HashMap<>();
            JSONArray jSONArray = jSONObject.getJSONArray("modeconfig");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                c cVar = new c(jSONArray.getString(i2));
                this.k.put(cVar.b(), cVar);
                com.baidu.android.pushservice.g.a.c("ModeConfig", "mManufacturers put key" + i2 + " = " + cVar.b());
            }
            this.q = b(Build.MANUFACTURER.toUpperCase());
            a(this.q);
            return true;
        } catch (JSONException e2) {
            com.baidu.android.pushservice.g.a.a("ModeConfig", e2);
            return false;
        }
    }

    private boolean i() {
        this.p = m.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
        if (this.p == -1) {
            return false;
        }
        String a2 = m.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (!a2.equals("CONFIG_MANUFACTURER_DEFAULT")) {
            this.q = new c(a2);
        }
        return true;
    }

    private boolean j() {
        long j2 = 0;
        if (System.currentTimeMillis() - m.c(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE") > TbConfig.APP_OVERDUR_DRAFT_BOX) {
            return true;
        }
        long c = m.c(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
        File file = new File(this.c);
        if (file.exists()) {
            if (c <= 0 || c != file.lastModified()) {
                return true;
            }
            long c2 = m.c(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
            for (String str : u) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j2 += file2.lastModified() / 10;
                }
            }
            return c2 != j2;
        }
        return true;
    }

    private void k() {
        File file = new File(this.c);
        if (file.exists()) {
            m.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", file.lastModified());
            long j2 = 0;
            for (String str : u) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j2 += file2.lastModified() / 10;
                }
            }
            m.a(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED", j2);
            m.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE", System.currentTimeMillis());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c5 A[Catch: all -> 0x006f, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0002, B:6:0x0013, B:8:0x001b, B:10:0x0023, B:12:0x0038, B:14:0x0043, B:15:0x0046, B:18:0x005e, B:20:0x0062, B:46:0x00c5, B:24:0x0068, B:29:0x0072, B:31:0x0078, B:33:0x0080, B:35:0x0088, B:37:0x009d, B:39:0x00ab, B:42:0x00b0, B:43:0x00b7, B:45:0x00be), top: B:52:0x0002, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(final a aVar) {
        long c;
        final long currentTimeMillis;
        n = false;
        com.baidu.android.pushservice.g.a.c("ModeConfig", "updateConfig......");
        if (p.a() && PushSettings.m(this.a) && !b(this.a)) {
            try {
                com.baidu.android.pushservice.g.a.c("ModeConfig", "XiaomiProxyMode......");
                String C = p.C(this.a);
                if (!TextUtils.isEmpty(C) && Float.parseFloat(C) >= 4.0d) {
                    m = 0;
                }
            } catch (Exception e2) {
                com.baidu.android.pushservice.g.a.a("ModeConfig", e2);
            }
            c = m.c(this.a, "last_update_config_time");
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c <= m) {
            }
        } else {
            if (p.b() && PushSettings.n(this.a) && !c(this.a)) {
                try {
                    com.baidu.android.pushservice.g.a.c("ModeConfig", "HuaweiProxyMode......");
                    String C2 = p.C(this.a);
                    if (!TextUtils.isEmpty(C2) && Float.parseFloat(C2) >= 3.1d) {
                        m = 0;
                    }
                } catch (Exception e3) {
                    com.baidu.android.pushservice.g.a.a("ModeConfig", e3);
                }
            } else {
                m = 259200000;
                if (aVar != null) {
                    n = true;
                    aVar.a();
                }
            }
            c = m.c(this.a, "last_update_config_time");
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c <= m) {
                com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("ModeConfig-updateConfig", (short) 100) { // from class: com.baidu.android.pushservice.c.d.1
                    @Override // com.baidu.android.pushservice.i.c
                    public void a() {
                        try {
                            HashMap hashMap = new HashMap();
                            com.baidu.android.pushservice.e.b.b(hashMap);
                            hashMap.put("version", d.this.p + "");
                            hashMap.put("model", Build.MODEL);
                            hashMap.put("osSdkInt", Build.VERSION.SDK_INT + "");
                            if ((p.a() && PushSettings.m(d.this.a)) || (p.b() && PushSettings.n(d.this.a))) {
                                hashMap.put("manufacture", Build.MANUFACTURER);
                                hashMap.put("sdk_version", ((int) com.baidu.android.pushservice.a.a()) + "");
                                hashMap.put("cuid", com.baidu.android.pushservice.k.e.a(d.this.a));
                                hashMap.put("channelid", PushSettings.a(d.this.a));
                                hashMap.put("package_name", d.this.a.getPackageName());
                                hashMap.put("pkg_sign", p.q(d.this.a, d.this.a.getPackageName()));
                                hashMap.put("rom_version", p.C(d.this.a));
                            } else {
                                hashMap.put("manufacturer", Build.MANUFACTURER);
                                hashMap.put("pushSdkInt", ((int) com.baidu.android.pushservice.a.a()) + "");
                            }
                            com.baidu.android.pushservice.g.a.c("ModeConfig", "update config request send, params=" + com.baidu.android.pushservice.e.b.a(hashMap));
                            String a2 = d.this.a(hashMap);
                            if (!TextUtils.isEmpty(a2)) {
                                JSONObject jSONObject = new JSONObject(a2);
                                JSONObject jSONObject2 = (JSONObject) jSONObject.get("response_params");
                                com.baidu.android.pushservice.g.a.c("ModeConfig", "new config content=" + jSONObject.toString());
                                if (jSONObject2 != null && jSONObject2.getInt("status") == 1) {
                                    String string = jSONObject2.getString("sdkconfig");
                                    if (!TextUtils.isEmpty(string)) {
                                        boolean a3 = d.this.a(string);
                                        com.baidu.android.pushservice.g.a.c("ModeConfig", "write config >> " + a3);
                                        if (a3) {
                                            d.this.f();
                                            m.a(d.this.a, "last_update_config_time", currentTimeMillis);
                                        }
                                    }
                                }
                            }
                        } catch (Exception e4) {
                            com.baidu.android.pushservice.g.a.a("ModeConfig", e4);
                        }
                        if (aVar == null || d.n) {
                            return;
                        }
                        aVar.a();
                    }
                });
            } else if (aVar != null && !n) {
                aVar.a();
            }
        }
    }

    public int b() {
        return this.r;
    }

    public String c() {
        return this.t;
    }

    public int d() {
        return this.s;
    }

    public boolean e() {
        boolean z;
        CertificateFactory certificateFactory;
        X509Certificate x509Certificate;
        byte[] bArr = null;
        if (this.q == null) {
            return true;
        }
        if (this.q.c() == i) {
            this.r = i;
            return true;
        } else if (this.q.c() == j) {
            this.r = j;
            return true;
        } else {
            if (this.q.c() == f && !TextUtils.isEmpty(this.q.f())) {
                try {
                    PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.q.f(), 16448);
                    if (packageInfo != null) {
                        int i2 = packageInfo.versionCode;
                        com.baidu.android.pushservice.g.a.c("ModeConfig", "version code = " + i2);
                        if (this.q.a() == null) {
                            z = false;
                        } else if (this.q.a().b == -1) {
                            com.baidu.android.pushservice.g.a.c("ModeConfig", "to = -1");
                            z = i2 >= this.q.a().a;
                        } else {
                            com.baidu.android.pushservice.g.a.c("ModeConfig", "from");
                            z = (i2 >= this.q.a().a) & (i2 <= this.q.a().b);
                        }
                        com.baidu.android.pushservice.g.a.c("ModeConfig", "version ret " + z);
                        if (z) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
                            try {
                                certificateFactory = CertificateFactory.getInstance("X509");
                            } catch (CertificateException e2) {
                                com.baidu.android.pushservice.g.a.a("ModeConfig", e2);
                                certificateFactory = null;
                            }
                            try {
                                x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
                            } catch (CertificateException e3) {
                                com.baidu.android.pushservice.g.a.a("ModeConfig", e3);
                                x509Certificate = null;
                            }
                            try {
                                bArr = com.baidu.android.pushservice.k.h.a(x509Certificate.getEncoded());
                            } catch (Exception e4) {
                                com.baidu.android.pushservice.g.a.a("ModeConfig", e4);
                            }
                            String a2 = a(bArr);
                            com.baidu.android.pushservice.g.a.c("ModeConfig", "hexString " + a2);
                            com.baidu.android.pushservice.g.a.c("ModeConfig", "apkSignture" + this.q.g());
                            if (a2.equalsIgnoreCase(this.q.g())) {
                                this.t = this.q.f();
                                this.s = p.l(this.a, this.t);
                                if (this.a.getPackageName().equalsIgnoreCase(this.q.f())) {
                                    this.r = g;
                                    com.baidu.android.pushservice.g.a.c("ModeConfig", "return true c_h");
                                    return true;
                                }
                                this.r = h;
                                com.baidu.android.pushservice.g.a.c("ModeConfig", "return true c_c");
                                return true;
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException e5) {
                    return false;
                }
            }
            com.baidu.android.pushservice.g.b.a("ModeConfig", " Current Mode = " + this.r, this.a);
            return false;
        }
    }

    public void f() {
        boolean j2 = j();
        boolean i2 = i();
        com.baidu.android.pushservice.g.a.c("ModeConfig", "needReload = " + j2 + ", initFromCache = " + i2);
        if ((j2 || !i2) && a()) {
            h();
        }
        if (this.q != null) {
            e();
        } else {
            com.baidu.android.pushservice.g.b.a("ModeConfig", "Config File Not Matched", this.a);
        }
    }
}
