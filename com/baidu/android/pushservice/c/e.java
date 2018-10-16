package com.baidu.android.pushservice.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.j.j;
import com.baidu.android.pushservice.j.m;
import com.baidu.sapi2.SapiContext;
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends b {
    private static boolean e;
    private static e f;
    private static String[] m = {"/default.prop", "/system/build.prop", "/system/default.prop", "/data/local.prop"};
    private String d;
    private int g;
    private d h;
    private int i;
    private int j;
    private String k;
    private Map<String, d> l;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    protected e(Context context) {
        super(context);
        this.d = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updatesdkconfig";
        this.i = 0;
        this.j = com.baidu.android.pushservice.a.a();
        this.c = "/data/data/" + this.a.getPackageName() + "/files/bdpush_modeconfig.json";
        f();
    }

    public static e a(Context context) {
        if (f != null) {
            return f;
        }
        f = new e(context);
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(HashMap<String, String> hashMap) {
        String a2 = h.f() ? h.a() : h.b();
        if ((m.a() && PushSettings.k(this.a)) || ((m.c() && PushSettings.n(this.a)) || ((m.b() && PushSettings.l(this.a)) || (m.d() && PushSettings.m(this.a))))) {
            this.d = a2 + "/rest/3.0/clientfile/updateconf";
        } else {
            this.d = a2 + "/rest/3.0/clientfile/updatesdkconfig";
        }
        int i = 2;
        do {
            com.baidu.android.pushservice.f.a a3 = com.baidu.android.pushservice.f.b.a(this.d, "POST", hashMap, "BCCS_SDK/3.0");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.friend", 0).edit();
            edit.putString("config", str);
            edit.apply();
        } catch (Exception e2) {
        }
    }

    private void a(d dVar) {
        j.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE", dVar != null ? dVar.toString() : "CONFIG_MANUFACTURER_DEFAULT");
        j.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.g);
        k();
    }

    private boolean a(d dVar, String str) {
        int i;
        int i2;
        double d;
        double d2;
        if (dVar != null && dVar.d() != null && dVar.d().size() > 0) {
            for (int i3 = 0; i3 < dVar.d().size(); i3++) {
                f fVar = dVar.d().get(i3);
                try {
                    String D = m.D(this.a);
                    String a2 = fVar.a();
                    if (fVar.b() == 0) {
                        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(D)) {
                            double d3 = 0.0d;
                            try {
                                d3 = Double.parseDouble(a2);
                                d = d3;
                                d2 = Double.parseDouble(D);
                            } catch (NumberFormatException e2) {
                                d = d3;
                                d2 = 0.0d;
                            }
                            if (d2 >= d) {
                                return true;
                            }
                            com.baidu.android.pushservice.g.a.a("ModeConfig", "manufaturer can not Matched, osversion is not ABOVE ", this.a);
                        }
                    } else if (fVar.b() == 1) {
                        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(D)) {
                            int i4 = 0;
                            try {
                                i4 = Integer.parseInt(a2);
                                i = i4;
                                i2 = Integer.parseInt(D);
                            } catch (NumberFormatException e3) {
                                i = i4;
                                i2 = 0;
                            }
                            if (i2 == i) {
                                return true;
                            }
                            com.baidu.android.pushservice.g.a.a("ModeConfig", "manufaturer can not Matched, osversion is not EQUAL ", this.a);
                        }
                    } else if (fVar.b() != 2) {
                        continue;
                    } else if (Pattern.matches(a2, D)) {
                        return true;
                    } else {
                        com.baidu.android.pushservice.g.a.a("ModeConfig", "manufaturer can not Matched, osversion is not REGULAR ", this.a);
                    }
                } catch (Exception e4) {
                }
            }
        }
        if (dVar.e() != null && dVar.e().size() > 0) {
            for (int i5 = 0; i5 < dVar.e().size(); i5++) {
                g gVar = dVar.e().get(i5);
                try {
                    Class<?> cls = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES);
                    String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, gVar.a());
                    if (str.equalsIgnoreCase("HUAWEI") && !m.e() && !str2.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21 && PushSettings.n(this.a)) {
                        str2 = "3.1";
                    }
                    if (str.equalsIgnoreCase("OPPO") && PushSettings.m(this.a) && !i(this.a)) {
                        str2 = "V1.0";
                    }
                    Matcher matcher = Pattern.compile(gVar.c()).matcher(str2);
                    if (matcher.find()) {
                        Double valueOf = Double.valueOf(str.equalsIgnoreCase("OPPO") ? matcher.group(1) : matcher.group());
                        Double valueOf2 = Double.valueOf(gVar.b());
                        if (gVar.d() == 0) {
                            if (valueOf.doubleValue() >= valueOf2.doubleValue()) {
                                return true;
                            }
                            com.baidu.android.pushservice.g.a.a("ModeConfig", "versioncode < configversioncode, manufaturer can not Matched, osversion is not ABOVE ", this.a);
                        } else if (gVar.d() != 1) {
                            continue;
                        } else if (valueOf == valueOf2) {
                            return true;
                        } else {
                            com.baidu.android.pushservice.g.a.a("ModeConfig", "versioncode != configversioncode, manufaturer can not Matched, osversion is not EQUAL ", this.a);
                        }
                    } else {
                        continue;
                    }
                } catch (Exception e5) {
                }
            }
        }
        return false;
    }

    public static Map<String, List<c>> b(String str) {
        JSONArray optJSONArray;
        try {
            JSONArray optJSONArray2 = new JSONObject(str).optJSONArray("friend");
            if (optJSONArray2 != null) {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    try {
                        JSONObject jSONObject = new JSONObject(optJSONArray2.getString(i));
                        String optString = jSONObject.optString("cur");
                        if (!TextUtils.isEmpty(optString) && (optJSONArray = jSONObject.optJSONArray("pkgs")) != null) {
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                arrayList.add(new c(optJSONArray.getString(i2)));
                            }
                            if (!arrayList.isEmpty()) {
                                hashMap.put(optString, arrayList);
                            }
                        }
                    } catch (Exception e2) {
                        return hashMap;
                    }
                }
                return hashMap;
            }
            return null;
        } catch (Exception e3) {
            return null;
        }
    }

    public static boolean b(Context context) {
        return System.currentTimeMillis() > 1527782400000L || j.b(context, "enable_newcid", 0) == 1;
    }

    private d c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String upperCase = str.toUpperCase();
        if (Build.MANUFACTURER.toUpperCase().equalsIgnoreCase("unknown") && this.l != null) {
            for (Map.Entry<String, d> entry : this.l.entrySet()) {
                String key = entry.getKey();
                if (a(this.l.get(key), key)) {
                    return this.l.get(key);
                }
            }
        } else if (this.l != null && this.l.containsKey(upperCase) && a(this.l.get(upperCase), upperCase)) {
            return this.l.get(upperCase);
        }
        return null;
    }

    public static boolean c(Context context) {
        try {
            Class.forName("com.meizu.cloud.pushsdk.PushManager");
            if (a(context).b() == 7) {
                return PushSettings.l(context);
            }
            return false;
        } catch (ClassNotFoundException e2) {
            return false;
        }
    }

    public static boolean d(Context context) {
        try {
            Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
            if (a(context).b() == 6) {
                return PushSettings.k(context);
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean e(Context context) {
        return a(context).b() == 5 && PushSettings.n(context);
    }

    public static boolean f(Context context) {
        try {
            Class.forName("com.coloros.mcssdk.a");
            if (a(context).b() == 8) {
                return PushSettings.m(context);
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean g(Context context) {
        return m.d() && i(context);
    }

    private void h() {
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            this.g = jSONObject.getInt("version");
            this.l = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("modeconfig");
            for (int i = 0; i < jSONArray.length(); i++) {
                d dVar = new d(jSONArray.getString(i));
                this.l.put(dVar.b(), dVar);
            }
            this.h = c(Build.MANUFACTURER.toUpperCase());
            a(this.h);
        } catch (Exception e2) {
        }
    }

    public static boolean h(Context context) {
        return e(context) || d(context) || c(context) || f(context);
    }

    private boolean i() {
        this.g = j.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
        if (this.g == -1) {
            return false;
        }
        String a2 = j.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (!a2.equals("CONFIG_MANUFACTURER_DEFAULT")) {
            this.h = new d(a2);
        }
        return true;
    }

    private static boolean i(Context context) {
        try {
            return com.coloros.mcssdk.a.dp(context);
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean j() {
        long j = 0;
        if (System.currentTimeMillis() - j.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE") > 604800000) {
            return true;
        }
        long b = j.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
        File file = new File(this.c);
        if (file.exists()) {
            if (b <= 0 || b != file.lastModified()) {
                return true;
            }
            long b2 = j.b(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
            for (String str : m) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j += file2.lastModified() / 10;
                }
            }
            return b2 != j;
        }
        return true;
    }

    private void k() {
        File file = new File(this.c);
        if (file.exists()) {
            j.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", file.lastModified());
            long j = 0;
            for (String str : m) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j += file2.lastModified() / 10;
                }
            }
            j.a(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED", j);
            j.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE", System.currentTimeMillis());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (java.lang.Float.parseFloat(r2) >= 4.0d) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(final a aVar) {
        String D;
        String D2;
        String D3;
        int i = 0;
        synchronized (this) {
            e = false;
            int i2 = 259200000;
            if (m.a() && PushSettings.k(this.a) && !d(this.a)) {
                try {
                    if (!TextUtils.isEmpty(m.D(this.a))) {
                    }
                    i = 259200000;
                    i2 = i;
                } catch (Exception e2) {
                }
            } else if (m.c() && PushSettings.n(this.a) && !e(this.a)) {
                try {
                    if (!TextUtils.isEmpty(m.D(this.a))) {
                        if (Float.parseFloat(D3) >= 3.1d) {
                            i2 = 0;
                        }
                    }
                } catch (Exception e3) {
                }
            } else if (m.b() && PushSettings.l(this.a) && !c(this.a)) {
                try {
                    if (!TextUtils.isEmpty(m.D(this.a))) {
                        if (Float.parseFloat(D2) >= 5.0d) {
                            i2 = 0;
                        }
                    }
                } catch (Exception e4) {
                }
            } else if (m.d() && PushSettings.m(this.a) && !f(this.a)) {
                try {
                    if (!TextUtils.isEmpty(m.D(this.a))) {
                        if (Float.parseFloat(D) >= 3.0d) {
                            i2 = 0;
                        }
                    }
                } catch (Exception e5) {
                }
            }
            long b = j.b(this.a, "last_update_config_time");
            final long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b > i2) {
                com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("ModeConfig-updateConfig", (short) 100) { // from class: com.baidu.android.pushservice.c.e.1
                    @Override // com.baidu.android.pushservice.i.c
                    public void a() {
                        JSONObject jSONObject;
                        try {
                            HashMap hashMap = new HashMap();
                            com.baidu.android.pushservice.e.b.a(hashMap);
                            hashMap.put("version", e.this.g + "");
                            hashMap.put("model", Build.MODEL);
                            hashMap.put("osSdkInt", Build.VERSION.SDK_INT + "");
                            if ((m.a() && PushSettings.k(e.this.a)) || ((m.c() && PushSettings.n(e.this.a)) || ((m.b() && PushSettings.l(e.this.a)) || (m.d() && PushSettings.m(e.this.a))))) {
                                hashMap.put(SapiContext.KEY_SDK_VERSION, ((int) com.baidu.android.pushservice.a.a()) + "");
                                hashMap.put("channelid", PushSettings.a(e.this.a));
                                hashMap.put("pkg_sign", m.r(e.this.a, e.this.a.getPackageName()));
                                hashMap.put("rom_version", m.D(e.this.a));
                            } else {
                                hashMap.put("pushSdkInt", ((int) com.baidu.android.pushservice.a.a()) + "");
                            }
                            hashMap.put("manufacture", Build.MANUFACTURER);
                            hashMap.put("cuid", com.baidu.android.pushservice.k.e.a(e.this.a));
                            hashMap.put(ETAG.KEY_PACKAGE_NAME, e.this.a.getPackageName());
                            String a2 = e.this.a(hashMap);
                            if (!TextUtils.isEmpty(a2) && (jSONObject = (JSONObject) new JSONObject(a2).get("response_params")) != null) {
                                if (jSONObject.getInt("status") == 1) {
                                    String string = jSONObject.getString("sdkconfig");
                                    if (!TextUtils.isEmpty(string) && e.this.a(string)) {
                                        e.this.f();
                                        j.a(e.this.a, "last_update_config_time", currentTimeMillis);
                                    }
                                }
                                j.a(e.this.a, "enable_newcid", jSONObject.optInt("newcid"));
                                e.this.a(e.this.a, jSONObject.optString("friend"));
                            }
                        } catch (Exception e6) {
                        }
                        if (aVar == null || e.e) {
                            return;
                        }
                        aVar.a();
                    }
                });
            } else if (aVar != null && !e) {
                aVar.a();
            }
        }
    }

    public int b() {
        return this.i;
    }

    public String c() {
        return this.k;
    }

    public int d() {
        return this.j;
    }

    public boolean e() {
        boolean z;
        byte[] bArr;
        if (this.h == null) {
            return true;
        }
        if (this.h.c() == 5) {
            this.i = 5;
            return true;
        } else if (this.h.c() == 6) {
            this.i = 6;
            return true;
        } else if (this.h.c() == 7) {
            this.i = 7;
            return true;
        } else if (this.h.c() == 8) {
            this.i = 8;
            return true;
        } else {
            if (this.h.c() == 2 && !TextUtils.isEmpty(this.h.f())) {
                try {
                    PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.h.f(), 16448);
                    if (packageInfo != null) {
                        int i = packageInfo.versionCode;
                        if (this.h.a() == null) {
                            z = false;
                        } else if (this.h.a().b == -1) {
                            z = i >= this.h.a().a;
                        } else {
                            z = (i >= this.h.a().a) & (i <= this.h.a().b);
                        }
                        if (z) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
                            try {
                                CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
                                X509Certificate x509Certificate = certificateFactory != null ? (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream) : null;
                                bArr = x509Certificate != null ? com.baidu.android.pushservice.k.h.a(x509Certificate.getEncoded()) : null;
                                try {
                                    byteArrayInputStream.close();
                                } catch (IOException e2) {
                                }
                            } catch (CertificateException e3) {
                                try {
                                    byteArrayInputStream.close();
                                    bArr = null;
                                } catch (IOException e4) {
                                    bArr = null;
                                }
                            } catch (Exception e5) {
                                try {
                                    byteArrayInputStream.close();
                                    bArr = null;
                                } catch (IOException e6) {
                                    bArr = null;
                                }
                            } catch (Throwable th) {
                                try {
                                    byteArrayInputStream.close();
                                } catch (IOException e7) {
                                }
                                throw th;
                            }
                            if (bArr != null && a(bArr).equalsIgnoreCase(this.h.g())) {
                                this.k = this.h.f();
                                this.j = m.m(this.a, this.k);
                                if (this.a.getPackageName().equalsIgnoreCase(this.h.f())) {
                                    this.i = 3;
                                    return true;
                                }
                                this.i = 4;
                                return true;
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException e8) {
                    return false;
                }
            }
            com.baidu.android.pushservice.g.a.a("ModeConfig", " Current Mode = " + this.i, this.a);
            return false;
        }
    }

    public void f() {
        boolean j = j();
        boolean i = i();
        if ((j || !i) && a()) {
            h();
        }
        if (this.h != null) {
            e();
        } else {
            com.baidu.android.pushservice.g.a.a("ModeConfig", "Config File Not Matched", this.a);
        }
    }
}
