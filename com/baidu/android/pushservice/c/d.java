package com.baidu.android.pushservice.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.j.n;
import com.baidu.android.pushservice.j.q;
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
    private static d p;
    public HashMap<String, c> k;
    private String m;
    private int q;
    private c r;
    private int s;
    private int t;
    private String u;
    private static final String l = d.class.getSimpleName();
    public static int d = 0;
    public static int e = 1;
    public static int f = 2;
    public static int g = 3;
    public static int h = 4;
    public static int i = 5;
    public static int j = 6;
    private static int n = 259200000;
    private static boolean o = false;
    private static String[] v = {"/default.prop", "/system/build.prop", "/system/default.prop", "/data/local.prop"};

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    protected d(Context context) {
        super(context);
        this.m = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updatesdkconfig";
        this.s = d;
        this.t = com.baidu.android.pushservice.a.a();
        this.u = null;
        com.baidu.android.pushservice.g.a.c(l, "ModeConfig constructor......");
        this.c = "/data/data/" + this.a.getPackageName() + "/files/bdpush_modeconfig.json";
        f();
    }

    public static d a(Context context) {
        if (p != null) {
            return p;
        }
        p = new d(context);
        return p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(HashMap<String, String> hashMap) {
        String a2 = h.f() ? h.a() : h.b();
        if ((q.a() && PushSettings.m(this.a)) || (q.b() && PushSettings.n(this.a))) {
            this.m = a2 + "/rest/3.0/clientfile/updateconf";
        } else {
            this.m = a2 + "/rest/3.0/clientfile/updatesdkconfig";
        }
        com.baidu.android.pushservice.g.a.c(l, this.m);
        int i2 = 2;
        do {
            com.baidu.android.pushservice.f.a a3 = com.baidu.android.pushservice.f.b.a(this.m, "POST", hashMap, "BCCS_SDK/3.0");
            if (a3 != null) {
                int b = a3.b();
                String a4 = com.baidu.android.pushservice.h.a.b.a(a3.a());
                com.baidu.android.pushservice.g.a.c(l, "update config request response, code=" + b + ", result=" + a4);
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
        n.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE", cVar != null ? cVar.toString() : "CONFIG_MANUFACTURER_DEFAULT");
        n.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.q);
        l();
    }

    private boolean a(c cVar, String str) {
        String a2;
        String b;
        int i2;
        double d2;
        double d3;
        if (cVar != null && cVar.d() != null && cVar.d().size() > 0) {
            com.baidu.android.pushservice.g.a.c(l, "getPropValues");
            for (int i3 = 0; i3 < cVar.d().size(); i3++) {
                e eVar = cVar.d().get(i3);
                try {
                    a2 = com.baidu.android.pushservice.j.a.a().a(eVar.a(), "");
                    b = eVar.b();
                    com.baidu.android.pushservice.g.a.c(l, "MatchValue=" + eVar.c() + " | " + a2 + "--" + b);
                } catch (Exception e2) {
                    com.baidu.android.pushservice.g.a.a(l, e2);
                }
                if (eVar.c() == 0) {
                    if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(a2)) {
                        double d4 = 0.0d;
                        try {
                            d4 = Double.parseDouble(b);
                            d2 = d4;
                            d3 = Double.parseDouble(a2);
                        } catch (NumberFormatException e3) {
                            com.baidu.android.pushservice.g.a.a(l, "number format exception  confv " + d4 + " val 0.0", e3);
                            d2 = d4;
                            d3 = 0.0d;
                        }
                        if (d3 >= d2) {
                            com.baidu.android.pushservice.g.a.c(l, "manufacturerMatched success!!!");
                            return true;
                        }
                        com.baidu.android.pushservice.g.b.a(l, "manufaturer can not Matched, osversion is not ABOVE ", this.a);
                    }
                } else {
                    if (eVar.c() == 1) {
                        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(a2)) {
                            int i4 = 0;
                            try {
                                i4 = Integer.parseInt(b);
                                i2 = Integer.parseInt(a2);
                            } catch (NumberFormatException e4) {
                                com.baidu.android.pushservice.g.a.a(l, "number format exception  confv " + i4 + " val 0", e4);
                                i2 = 0;
                            }
                            if (i2 == i4) {
                                com.baidu.android.pushservice.g.a.c(l, "manufacturerMatched success!!!");
                                return true;
                            }
                            com.baidu.android.pushservice.g.b.a(l, "manufaturer can not Matched, osversion is not EQUAL ", this.a);
                        }
                    } else if (eVar.c() != 2) {
                        continue;
                    } else if (Pattern.matches(b, a2)) {
                        com.baidu.android.pushservice.g.a.c(l, "manufacturerMatched success!!!");
                        return true;
                    } else {
                        com.baidu.android.pushservice.g.a.c(l, "manufacturerMatched failure!!!");
                        com.baidu.android.pushservice.g.b.a(l, "manufaturer can not Matched, osversion is not REGULAR ", this.a);
                    }
                }
                com.baidu.android.pushservice.g.a.a(l, e2);
            }
        }
        if (cVar.e() != null && cVar.e().size() > 0) {
            com.baidu.android.pushservice.g.a.c(l, "getSystemProps");
            for (int i5 = 0; i5 < cVar.e().size(); i5++) {
                f fVar = cVar.e().get(i5);
                try {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, fVar.a());
                    com.baidu.android.pushservice.g.a.c(l, " buildVersion " + str2);
                    String lowerCase = Build.MODEL.toLowerCase();
                    boolean z = false;
                    if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains("nexus")) {
                        z = true;
                        com.baidu.android.pushservice.g.b.a(l, "manufaturer  is Nexus ", this.a);
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
                                com.baidu.android.pushservice.g.a.c(l, "versioncode >= configversioncode, manufacturerMatched success!!!");
                                return true;
                            }
                            com.baidu.android.pushservice.g.b.a(l, "versioncode < configversioncode, manufaturer can not Matched, osversion is not ABOVE ", this.a);
                        } else if (fVar.d() != 1) {
                            continue;
                        } else if (valueOf == valueOf2) {
                            com.baidu.android.pushservice.g.a.c(l, "versioncode == configversioncode, manufacturerMatched success!!!");
                            return true;
                        } else {
                            com.baidu.android.pushservice.g.b.a(l, "versioncode != configversioncode, manufaturer can not Matched, osversion is not EQUAL ", this.a);
                        }
                    } else {
                        continue;
                    }
                } catch (Exception e5) {
                    com.baidu.android.pushservice.g.a.a(l, e5);
                }
            }
        }
        return false;
    }

    private c b(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.android.pushservice.g.a.c(l, "facturerName is null!");
            return null;
        }
        String upperCase = str.toUpperCase();
        if (Build.MANUFACTURER.toUpperCase().equalsIgnoreCase("unknown") && this.k != null) {
            com.baidu.android.pushservice.g.a.c(l, "manufacturer is unknown!");
            for (Map.Entry<String, c> entry : this.k.entrySet()) {
                String key = entry.getKey();
                if (a(this.k.get(key), key)) {
                    return this.k.get(key);
                }
            }
        } else if (this.k != null && this.k.containsKey(upperCase)) {
            com.baidu.android.pushservice.g.a.c(l, "mManufacturers containsKey " + upperCase);
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
            com.baidu.android.pushservice.g.a.e(l, "not found com.xiaomi.mipush pkg, not xiaomiproxy mode!!!");
            return false;
        }
    }

    public static boolean c(Context context) {
        return a(context).b() == i && PushSettings.n(context);
    }

    public static boolean d(Context context) {
        return c(context) || b(context);
    }

    private boolean i() {
        com.baidu.android.pushservice.g.a.c(l, "parseConfig begin.....");
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            this.q = jSONObject.getInt("version");
            this.k = new HashMap<>();
            JSONArray jSONArray = jSONObject.getJSONArray("modeconfig");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                c cVar = new c(jSONArray.getString(i2));
                this.k.put(cVar.b(), cVar);
                com.baidu.android.pushservice.g.a.c(l, "mManufacturers put key" + i2 + " = " + cVar.b());
            }
            this.r = b(Build.MANUFACTURER.toUpperCase());
            a(this.r);
            return true;
        } catch (JSONException e2) {
            com.baidu.android.pushservice.g.a.a(l, e2);
            return false;
        }
    }

    private boolean j() {
        this.q = n.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
        if (this.q == -1) {
            return false;
        }
        String a2 = n.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (!a2.equals("CONFIG_MANUFACTURER_DEFAULT")) {
            this.r = new c(a2);
        }
        return true;
    }

    private boolean k() {
        long j2 = 0;
        if (System.currentTimeMillis() - n.c(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE") > TbConfig.APP_OVERDUR_DRAFT_BOX) {
            return true;
        }
        long c = n.c(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
        File file = new File(this.c);
        if (file.exists()) {
            if (c <= 0 || c != file.lastModified()) {
                return true;
            }
            long c2 = n.c(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
            for (String str : v) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j2 += file2.lastModified() / 10;
                }
            }
            return c2 != j2;
        }
        return true;
    }

    private void l() {
        File file = new File(this.c);
        if (file.exists()) {
            n.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", file.lastModified());
            long j2 = 0;
            for (String str : v) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j2 += file2.lastModified() / 10;
                }
            }
            n.a(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED", j2);
            n.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE", System.currentTimeMillis());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc A[Catch: all -> 0x0069, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0002, B:6:0x0011, B:8:0x0019, B:10:0x0021, B:12:0x0034, B:14:0x003f, B:15:0x0042, B:18:0x0059, B:20:0x005d, B:46:0x00bc, B:24:0x0063, B:29:0x006c, B:31:0x0072, B:33:0x007a, B:35:0x0082, B:37:0x0095, B:39:0x00a3, B:42:0x00a8, B:43:0x00ae, B:45:0x00b5), top: B:50:0x0002, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(final a aVar) {
        long c;
        final long currentTimeMillis;
        o = false;
        com.baidu.android.pushservice.g.a.c(l, "updateConfig......");
        if (q.a() && PushSettings.m(this.a) && !b(this.a)) {
            try {
                com.baidu.android.pushservice.g.a.c(l, "XiaomiProxyMode......");
                String C = q.C(this.a);
                if (!TextUtils.isEmpty(C) && Float.parseFloat(C) >= 4.0d) {
                    n = 0;
                }
            } catch (Exception e2) {
                com.baidu.android.pushservice.g.a.a(l, e2);
            }
            c = n.c(this.a, "last_update_config_time");
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c <= n) {
            }
        } else {
            if (q.b() && PushSettings.n(this.a) && !c(this.a)) {
                try {
                    com.baidu.android.pushservice.g.a.c(l, "HuaweiProxyMode......");
                    String C2 = q.C(this.a);
                    if (!TextUtils.isEmpty(C2) && Float.parseFloat(C2) >= 3.1d) {
                        n = 0;
                    }
                } catch (Exception e3) {
                    com.baidu.android.pushservice.g.a.a(l, e3);
                }
            } else {
                n = 259200000;
                if (aVar != null) {
                    o = true;
                    aVar.a();
                }
            }
            c = n.c(this.a, "last_update_config_time");
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c <= n) {
                com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("ModeConfig-updateConfig", (short) 100) { // from class: com.baidu.android.pushservice.c.d.1
                    @Override // com.baidu.android.pushservice.i.c
                    public void a() {
                        try {
                            HashMap hashMap = new HashMap();
                            com.baidu.android.pushservice.e.b.b(hashMap);
                            hashMap.put("version", d.this.q + "");
                            hashMap.put("model", Build.MODEL);
                            hashMap.put("osSdkInt", Build.VERSION.SDK_INT + "");
                            if ((q.a() && PushSettings.m(d.this.a)) || (q.b() && PushSettings.n(d.this.a))) {
                                hashMap.put("manufacture", Build.MANUFACTURER);
                                hashMap.put("sdk_version", ((int) com.baidu.android.pushservice.a.a()) + "");
                                hashMap.put("cuid", com.baidu.android.pushservice.k.e.a(d.this.a));
                                hashMap.put("channelid", PushSettings.a(d.this.a));
                                hashMap.put("package_name", d.this.a.getPackageName());
                                hashMap.put("pkg_sign", q.q(d.this.a, d.this.a.getPackageName()));
                                hashMap.put("rom_version", q.C(d.this.a));
                            } else {
                                hashMap.put("manufacturer", Build.MANUFACTURER);
                                hashMap.put("pushSdkInt", ((int) com.baidu.android.pushservice.a.a()) + "");
                            }
                            com.baidu.android.pushservice.g.a.c(d.l, "update config request send, params=" + com.baidu.android.pushservice.e.b.a(hashMap));
                            String a2 = d.this.a(hashMap);
                            if (!TextUtils.isEmpty(a2)) {
                                JSONObject jSONObject = new JSONObject(a2);
                                JSONObject jSONObject2 = (JSONObject) jSONObject.get("response_params");
                                com.baidu.android.pushservice.g.a.c(d.l, "new config content=" + jSONObject.toString());
                                if (jSONObject2 != null && jSONObject2.getInt("status") == 1) {
                                    String string = jSONObject2.getString("sdkconfig");
                                    if (!TextUtils.isEmpty(string)) {
                                        boolean a3 = d.this.a(string);
                                        com.baidu.android.pushservice.g.a.c(d.l, "write config >> " + a3);
                                        if (a3) {
                                            d.this.f();
                                            n.a(d.this.a, "last_update_config_time", currentTimeMillis);
                                        }
                                    }
                                }
                            }
                        } catch (Exception e4) {
                            com.baidu.android.pushservice.g.a.a(d.l, e4);
                        }
                        if (aVar == null || d.o) {
                            return;
                        }
                        aVar.a();
                    }
                });
            } else if (aVar != null && !o) {
                aVar.a();
            }
        }
    }

    public int b() {
        return this.s;
    }

    public String c() {
        return this.u;
    }

    public int d() {
        return this.t;
    }

    public boolean e() {
        boolean z;
        CertificateFactory certificateFactory;
        X509Certificate x509Certificate;
        byte[] bArr = null;
        if (this.r == null) {
            return true;
        }
        if (this.r.c() == i) {
            this.s = i;
            return true;
        } else if (this.r.c() == j) {
            this.s = j;
            return true;
        } else {
            if (this.r.c() == f && !TextUtils.isEmpty(this.r.f())) {
                try {
                    PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.r.f(), 16448);
                    if (packageInfo != null) {
                        int i2 = packageInfo.versionCode;
                        com.baidu.android.pushservice.g.a.c(l, "version code = " + i2);
                        if (this.r.a() == null) {
                            z = false;
                        } else if (this.r.a().b == -1) {
                            com.baidu.android.pushservice.g.a.c(l, "to = -1");
                            z = i2 >= this.r.a().a;
                        } else {
                            com.baidu.android.pushservice.g.a.c(l, "from");
                            z = (i2 >= this.r.a().a) & (i2 <= this.r.a().b);
                        }
                        com.baidu.android.pushservice.g.a.c(l, "version ret " + z);
                        if (z) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
                            try {
                                certificateFactory = CertificateFactory.getInstance("X509");
                            } catch (CertificateException e2) {
                                com.baidu.android.pushservice.g.a.a(l, e2);
                                certificateFactory = null;
                            }
                            try {
                                x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
                            } catch (CertificateException e3) {
                                com.baidu.android.pushservice.g.a.a(l, e3);
                                x509Certificate = null;
                            }
                            try {
                                bArr = com.baidu.android.pushservice.k.h.a(x509Certificate.getEncoded());
                            } catch (Exception e4) {
                                com.baidu.android.pushservice.g.a.a(l, e4);
                            }
                            String a2 = a(bArr);
                            com.baidu.android.pushservice.g.a.c(l, "hexString " + a2);
                            com.baidu.android.pushservice.g.a.c(l, "apkSignture" + this.r.g());
                            if (a2.equalsIgnoreCase(this.r.g())) {
                                this.u = this.r.f();
                                this.t = q.l(this.a, this.u);
                                if (this.a.getPackageName().equalsIgnoreCase(this.r.f())) {
                                    this.s = g;
                                    com.baidu.android.pushservice.g.a.c(l, "return true c_h");
                                    return true;
                                }
                                this.s = h;
                                com.baidu.android.pushservice.g.a.c(l, "return true c_c");
                                return true;
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException e5) {
                    return false;
                }
            }
            com.baidu.android.pushservice.g.b.a(l, " Current Mode = " + this.s, this.a);
            return false;
        }
    }

    public void f() {
        boolean k = k();
        boolean j2 = j();
        com.baidu.android.pushservice.g.a.c(l, "needReload = " + k + ", initFromCache = " + j2);
        if ((k || !j2) && a()) {
            i();
        }
        if (this.r != null) {
            e();
        } else {
            com.baidu.android.pushservice.g.b.a(l, "Config File Not Matched", this.a);
        }
    }
}
