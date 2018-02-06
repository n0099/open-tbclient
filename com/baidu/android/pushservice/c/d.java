package com.baidu.android.pushservice.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.p;
import com.baidu.tieba.keepLive.util.RomTypeUtil;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
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
    private static d h;
    public HashMap<String, c> d;
    private String e;
    private int i;
    private c j;
    private int k;
    private int l;
    private String m;
    private static int f = 259200000;
    private static boolean g = false;
    private static String[] n = {"/default.prop", "/system/build.prop", "/system/default.prop", "/data/local.prop"};

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    protected d(Context context) {
        super(context);
        this.e = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updatesdkconfig";
        this.k = 0;
        this.l = com.baidu.android.pushservice.a.a();
        this.m = null;
        this.c = "/data/data/" + this.a.getPackageName() + "/files/bdpush_modeconfig.json";
        f();
    }

    public static d a(Context context) {
        if (h != null) {
            return h;
        }
        h = new d(context);
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(HashMap<String, String> hashMap) {
        int i;
        String a2 = h.f() ? h.a() : h.b();
        if ((p.a() && PushSettings.m(this.a)) || ((p.c() && PushSettings.p(this.a)) || ((p.b() && PushSettings.n(this.a)) || (p.d() && PushSettings.o(this.a))))) {
            this.e = a2 + "/rest/3.0/clientfile/updateconf";
            i = 2;
        } else {
            this.e = a2 + "/rest/3.0/clientfile/updatesdkconfig";
            i = 2;
        }
        do {
            com.baidu.android.pushservice.f.a a3 = com.baidu.android.pushservice.f.b.a(this.e, "POST", hashMap, "BCCS_SDK/3.0");
            if (a3 != null) {
                int b = a3.b();
                String a4 = com.baidu.android.pushservice.h.a.b.a(a3.a());
                if (b == 200) {
                    return a4;
                }
            }
            i--;
        } while (i > 0);
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
        m.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.i);
        k();
    }

    private boolean a(c cVar, String str) {
        int i;
        int i2;
        double d;
        double d2;
        if (cVar != null && cVar.d() != null && cVar.d().size() > 0) {
            for (int i3 = 0; i3 < cVar.d().size(); i3++) {
                e eVar = cVar.d().get(i3);
                try {
                    String a2 = com.baidu.android.pushservice.j.a.a().a(eVar.a(), "");
                    String b = eVar.b();
                    if (eVar.c() == 0) {
                        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(a2)) {
                            double d3 = 0.0d;
                            try {
                                d3 = Double.parseDouble(b);
                                d = d3;
                                d2 = Double.parseDouble(a2);
                            } catch (NumberFormatException e) {
                                d = d3;
                                d2 = 0.0d;
                            }
                            if (d2 >= d) {
                                return true;
                            }
                            com.baidu.android.pushservice.g.a.a("ModeConfig", "manufaturer can not Matched, osversion is not ABOVE ", this.a);
                        }
                    } else if (eVar.c() == 1) {
                        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(a2)) {
                            int i4 = 0;
                            try {
                                i4 = Integer.parseInt(b);
                                i = i4;
                                i2 = Integer.parseInt(a2);
                            } catch (NumberFormatException e2) {
                                i = i4;
                                i2 = 0;
                            }
                            if (i2 == i) {
                                return true;
                            }
                            com.baidu.android.pushservice.g.a.a("ModeConfig", "manufaturer can not Matched, osversion is not EQUAL ", this.a);
                        }
                    } else if (eVar.c() != 2) {
                        continue;
                    } else if (Pattern.matches(b, a2)) {
                        return true;
                    } else {
                        com.baidu.android.pushservice.g.a.a("ModeConfig", "manufaturer can not Matched, osversion is not REGULAR ", this.a);
                    }
                } catch (Exception e3) {
                }
            }
        }
        if (cVar.e() != null && cVar.e().size() > 0) {
            for (int i5 = 0; i5 < cVar.e().size(); i5++) {
                f fVar = cVar.e().get(i5);
                try {
                    Class<?> cls = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES);
                    String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, fVar.a());
                    String lowerCase = Build.MODEL.toLowerCase();
                    boolean z = false;
                    if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains("nexus")) {
                        z = true;
                        com.baidu.android.pushservice.g.a.a("ModeConfig", "manufaturer  is Nexus ", this.a);
                    }
                    if (str.equalsIgnoreCase("HUAWEI") && !z && !str2.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21 && PushSettings.p(this.a)) {
                        str2 = "3.1";
                    }
                    if (str.equalsIgnoreCase(RomTypeUtil.ROM_OPPO) && PushSettings.o(this.a) && !h(this.a)) {
                        str2 = "V1.0";
                    }
                    Matcher matcher = Pattern.compile(fVar.c()).matcher(str2);
                    if (matcher.find()) {
                        Double valueOf = Double.valueOf(str.equalsIgnoreCase(RomTypeUtil.ROM_OPPO) ? matcher.group(1) : matcher.group());
                        Double valueOf2 = Double.valueOf(fVar.b());
                        if (fVar.d() == 0) {
                            if (valueOf.doubleValue() >= valueOf2.doubleValue()) {
                                return true;
                            }
                            com.baidu.android.pushservice.g.a.a("ModeConfig", "versioncode < configversioncode, manufaturer can not Matched, osversion is not ABOVE ", this.a);
                        } else if (fVar.d() != 1) {
                            continue;
                        } else if (valueOf == valueOf2) {
                            return true;
                        } else {
                            com.baidu.android.pushservice.g.a.a("ModeConfig", "versioncode != configversioncode, manufaturer can not Matched, osversion is not EQUAL ", this.a);
                        }
                    } else {
                        continue;
                    }
                } catch (Exception e4) {
                }
            }
        }
        return false;
    }

    private c b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String upperCase = str.toUpperCase();
        if (Build.MANUFACTURER.toUpperCase().equalsIgnoreCase("unknown") && this.d != null) {
            for (Map.Entry<String, c> entry : this.d.entrySet()) {
                String key = entry.getKey();
                if (a(this.d.get(key), key)) {
                    return this.d.get(key);
                }
            }
        } else if (this.d != null && this.d.containsKey(upperCase) && a(this.d.get(upperCase), upperCase)) {
            return this.d.get(upperCase);
        }
        return null;
    }

    public static boolean b(Context context) {
        try {
            Class.forName("com.meizu.cloud.pushsdk.PushManager");
            if (a(context).b() == 7) {
                return PushSettings.n(context);
            }
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean c(Context context) {
        try {
            Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
            if (a(context).b() == 6) {
                return PushSettings.m(context);
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean d(Context context) {
        return a(context).b() == 5 && PushSettings.p(context);
    }

    public static boolean e(Context context) {
        try {
            Class.forName("com.coloros.mcssdk.a");
            if (a(context).b() == 8) {
                return PushSettings.o(context);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean f(Context context) {
        return p.d() && h(context);
    }

    public static boolean g(Context context) {
        return d(context) || c(context) || b(context) || e(context);
    }

    private boolean h() {
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            this.i = jSONObject.getInt("version");
            this.d = new HashMap<>();
            JSONArray jSONArray = jSONObject.getJSONArray("modeconfig");
            for (int i = 0; i < jSONArray.length(); i++) {
                c cVar = new c(jSONArray.getString(i));
                this.d.put(cVar.b(), cVar);
            }
            this.j = b(Build.MANUFACTURER.toUpperCase());
            a(this.j);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    private static boolean h(Context context) {
        try {
            return com.coloros.mcssdk.a.cv(context);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean i() {
        this.i = m.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
        if (this.i == -1) {
            return false;
        }
        String a2 = m.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (!a2.equals("CONFIG_MANUFACTURER_DEFAULT")) {
            this.j = new c(a2);
        }
        return true;
    }

    private boolean j() {
        long j = 0;
        if (System.currentTimeMillis() - m.c(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE") > 604800000) {
            return true;
        }
        long c = m.c(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
        File file = new File(this.c);
        if (file.exists()) {
            if (c <= 0 || c != file.lastModified()) {
                return true;
            }
            long c2 = m.c(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
            for (String str : n) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j += file2.lastModified() / 10;
                }
            }
            return c2 != j;
        }
        return true;
    }

    private void k() {
        File file = new File(this.c);
        if (file.exists()) {
            m.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", file.lastModified());
            long j = 0;
            for (String str : n) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j += file2.lastModified() / 10;
                }
            }
            m.a(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED", j);
            m.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE", System.currentTimeMillis());
        }
    }

    public synchronized void a(final a aVar) {
        g = false;
        if (p.a() && PushSettings.m(this.a) && !c(this.a)) {
            try {
                String D = p.D(this.a);
                if (!TextUtils.isEmpty(D) && Float.parseFloat(D) >= 4.0d) {
                    f = 0;
                }
            } catch (Exception e) {
            }
        } else if (p.c() && PushSettings.p(this.a) && !d(this.a)) {
            try {
                String D2 = p.D(this.a);
                if (!TextUtils.isEmpty(D2) && Float.parseFloat(D2) >= 3.1d) {
                    f = 0;
                }
            } catch (Exception e2) {
            }
        } else if (p.b() && PushSettings.n(this.a) && !b(this.a)) {
            try {
                String D3 = p.D(this.a);
                if (!TextUtils.isEmpty(D3) && Float.parseFloat(D3) >= 5.0d) {
                    f = 0;
                }
            } catch (Exception e3) {
            }
        } else if (p.d() && PushSettings.o(this.a) && !e(this.a)) {
            try {
                String D4 = p.D(this.a);
                if (!TextUtils.isEmpty(D4) && Float.parseFloat(D4) >= 3.0d) {
                    f = 0;
                }
            } catch (Exception e4) {
            }
        } else {
            f = 259200000;
            if (aVar != null) {
                g = true;
                aVar.a();
            }
        }
        long c = m.c(this.a, "last_update_config_time");
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - c > f) {
            com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("ModeConfig-updateConfig", (short) 100) { // from class: com.baidu.android.pushservice.c.d.1
                @Override // com.baidu.android.pushservice.i.c
                public void a() {
                    JSONObject jSONObject;
                    try {
                        HashMap hashMap = new HashMap();
                        com.baidu.android.pushservice.e.b.a(hashMap);
                        hashMap.put("version", d.this.i + "");
                        hashMap.put("model", Build.MODEL);
                        hashMap.put("osSdkInt", Build.VERSION.SDK_INT + "");
                        if ((p.a() && PushSettings.m(d.this.a)) || ((p.c() && PushSettings.p(d.this.a)) || ((p.b() && PushSettings.n(d.this.a)) || (p.d() && PushSettings.o(d.this.a))))) {
                            hashMap.put("manufacture", Build.MANUFACTURER);
                            hashMap.put("sdk_version", ((int) com.baidu.android.pushservice.a.a()) + "");
                            hashMap.put("cuid", com.baidu.android.pushservice.k.e.a(d.this.a));
                            hashMap.put("channelid", PushSettings.a(d.this.a));
                            hashMap.put("package_name", d.this.a.getPackageName());
                            hashMap.put("pkg_sign", p.r(d.this.a, d.this.a.getPackageName()));
                            hashMap.put("rom_version", p.D(d.this.a));
                        } else {
                            hashMap.put("manufacturer", Build.MANUFACTURER);
                            hashMap.put("pushSdkInt", ((int) com.baidu.android.pushservice.a.a()) + "");
                        }
                        String a2 = d.this.a(hashMap);
                        if (!TextUtils.isEmpty(a2) && (jSONObject = (JSONObject) new JSONObject(a2).get("response_params")) != null && jSONObject.getInt(NotificationCompat.CATEGORY_STATUS) == 1) {
                            String string = jSONObject.getString("sdkconfig");
                            if (!TextUtils.isEmpty(string) && d.this.a(string)) {
                                d.this.f();
                                m.a(d.this.a, "last_update_config_time", currentTimeMillis);
                            }
                        }
                    } catch (Exception e5) {
                    }
                    if (aVar == null || d.g) {
                        return;
                    }
                    aVar.a();
                }
            });
        } else if (aVar != null && !g) {
            aVar.a();
        }
    }

    public int b() {
        return this.k;
    }

    public String c() {
        return this.m;
    }

    public int d() {
        return this.l;
    }

    public boolean e() {
        boolean z;
        CertificateFactory certificateFactory;
        X509Certificate x509Certificate;
        byte[] bArr = null;
        if (this.j == null) {
            return true;
        }
        if (this.j.c() == 5) {
            this.k = 5;
            return true;
        } else if (this.j.c() == 6) {
            this.k = 6;
            return true;
        } else if (this.j.c() == 7) {
            this.k = 7;
            return true;
        } else if (this.j.c() == 8) {
            this.k = 8;
            return true;
        } else {
            if (this.j.c() == 2 && !TextUtils.isEmpty(this.j.f())) {
                try {
                    PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.j.f(), 16448);
                    if (packageInfo != null) {
                        int i = packageInfo.versionCode;
                        if (this.j.a() == null) {
                            z = false;
                        } else if (this.j.a().b == -1) {
                            z = i >= this.j.a().a;
                        } else {
                            z = (i >= this.j.a().a) & (i <= this.j.a().b);
                        }
                        if (z) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
                            try {
                                certificateFactory = CertificateFactory.getInstance("X509");
                            } catch (CertificateException e) {
                                certificateFactory = null;
                            }
                            try {
                                x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
                            } catch (CertificateException e2) {
                                x509Certificate = null;
                            }
                            try {
                                bArr = com.baidu.android.pushservice.k.h.a(x509Certificate.getEncoded());
                            } catch (Exception e3) {
                            }
                            if (a(bArr).equalsIgnoreCase(this.j.g())) {
                                this.m = this.j.f();
                                this.l = p.m(this.a, this.m);
                                if (this.a.getPackageName().equalsIgnoreCase(this.j.f())) {
                                    this.k = 3;
                                    return true;
                                }
                                this.k = 4;
                                return true;
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException e4) {
                    return false;
                }
            }
            com.baidu.android.pushservice.g.a.a("ModeConfig", " Current Mode = " + this.k, this.a);
            return false;
        }
    }

    public void f() {
        boolean j = j();
        boolean i = i();
        if ((j || !i) && a()) {
            h();
        }
        if (this.j != null) {
            e();
        } else {
            com.baidu.android.pushservice.g.a.a("ModeConfig", "Config File Not Matched", this.a);
        }
    }
}
