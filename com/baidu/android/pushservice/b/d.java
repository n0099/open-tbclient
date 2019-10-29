package com.baidu.android.pushservice.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.i.i;
import com.baidu.android.pushservice.i.l;
import com.baidu.live.tbadk.data.Config;
import com.baidu.sapi2.SapiContext;
import com.coloros.mcssdk.PushManager;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends b {
    private static boolean e;
    private static d f;
    private static String[] m = {"/default.prop", "/system/build.prop", "/system/default.prop", "/data/local.prop"};
    private String d;
    private int g;
    private c h;
    private int i;
    private int j;
    private String k;
    private Map<String, c> l;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    protected d(Context context) {
        super(context);
        this.d = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updatesdkconfig";
        this.i = 0;
        this.j = com.baidu.android.pushservice.a.a();
        this.c = "/data/data/" + this.a.getPackageName() + "/files/bdpush_modeconfig.json";
        f();
    }

    public static d a(Context context) {
        if (f != null) {
            return f;
        }
        f = new d(context);
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(HashMap<String, String> hashMap) {
        String a2 = g.f() ? g.a() : g.b();
        if ((l.c() && PushSettings.l(this.a)) || ((l.a() && PushSettings.h(this.a)) || ((l.d() && PushSettings.j(this.a)) || ((l.b() && PushSettings.i(this.a)) || (l.e() && PushSettings.k(this.a)))))) {
            this.d = a2 + "/rest/3.0/clientfile/updateconf";
        } else {
            this.d = a2 + "/rest/3.0/clientfile/updatesdkconfig";
        }
        int i = 2;
        do {
            com.baidu.android.pushservice.e.a a3 = com.baidu.android.pushservice.e.b.a(this.d, "POST", hashMap, "BCCS_SDK/3.0");
            if (a3 != null) {
                int b = a3.b();
                String a4 = com.baidu.android.pushservice.g.a.b.a(a3.a());
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
        i.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE", cVar != null ? cVar.toString() : "CONFIG_MANUFACTURER_DEFAULT");
        i.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.g);
        k();
    }

    private boolean a(c cVar, String str) {
        String str2;
        int i;
        int i2;
        double d;
        double d2;
        if (cVar != null && cVar.d() != null && cVar.d().size() > 0) {
            for (int i3 = 0; i3 < cVar.d().size(); i3++) {
                e eVar = cVar.d().get(i3);
                try {
                    String j = l.j();
                    String a2 = eVar.a();
                    if (eVar.b() == 0) {
                        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(j)) {
                            double d3 = 0.0d;
                            try {
                                d3 = Double.parseDouble(a2);
                                d = d3;
                                d2 = Double.parseDouble(j);
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
                        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(j)) {
                            int i4 = 0;
                            try {
                                i4 = Integer.parseInt(a2);
                                i = i4;
                                i2 = Integer.parseInt(j);
                            } catch (NumberFormatException e3) {
                                i = i4;
                                i2 = 0;
                            }
                            if (i2 == i) {
                                return true;
                            }
                            com.baidu.android.pushservice.f.a.a("ModeConfig", "manufaturer can not Matched, osversion is not EQUAL ", this.a);
                        }
                    } else if (eVar.b() != 2) {
                        continue;
                    } else if (Pattern.matches(a2, j)) {
                        return true;
                    } else {
                        com.baidu.android.pushservice.f.a.a("ModeConfig", "manufaturer can not Matched, osversion is not REGULAR ", this.a);
                    }
                } catch (Exception e4) {
                }
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
                    if (str.equalsIgnoreCase("HUAWEI") && !l.f() && !str2.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21 && PushSettings.l(this.a)) {
                        str2 = "3.1";
                    }
                    if (str.equalsIgnoreCase("OPPO") && PushSettings.j(this.a) && !j(this.a)) {
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
        return false;
    }

    private c b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String upperCase = str.toUpperCase();
        if (Build.MANUFACTURER.toUpperCase().equalsIgnoreCase("unknown") && this.l != null) {
            for (Map.Entry<String, c> entry : this.l.entrySet()) {
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

    public static boolean b(Context context) {
        return i.b(context, "enable_newcid", 0) == 1;
    }

    public static boolean c(Context context) {
        return i.b(context, "enable_conn_for_proxy", 0) == 1;
    }

    public static boolean d(Context context) {
        try {
            if (m(context)) {
                return a(context).b() == 7;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean e(Context context) {
        try {
            if (n(context)) {
                return a(context).b() == 6;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean f(Context context) {
        return o(context) && a(context).b() == 5;
    }

    public static boolean g(Context context) {
        try {
            if (l.d()) {
                Class.forName("com.coloros.mcssdk.PushManager");
                if (a(context).b() == 8) {
                    return PushSettings.j(context);
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private void h() {
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            this.g = jSONObject.getInt("version");
            this.l = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("modeconfig");
            for (int i = 0; i < jSONArray.length(); i++) {
                c cVar = new c(jSONArray.getString(i));
                this.l.put(cVar.b(), cVar);
            }
            this.h = b(Build.MANUFACTURER.toUpperCase());
            a(this.h);
        } catch (Exception e2) {
        }
    }

    public static boolean h(Context context) {
        try {
            if (i(context)) {
                if (i.b(context, "vi_push_proxy_mode", 0) == 1) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean i() {
        this.g = i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
        if (this.g == -1) {
            return false;
        }
        String a2 = i.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (!a2.equals("CONFIG_MANUFACTURER_DEFAULT")) {
            this.h = new c(a2);
        }
        return true;
    }

    public static boolean i(Context context) {
        try {
            if (p(context)) {
                return a(context).b() == 9;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean j() {
        long j = 0;
        if (System.currentTimeMillis() - i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE") > 604800000) {
            return true;
        }
        long b = i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
        File file = new File(this.c);
        if (file.exists()) {
            if (b <= 0 || b != file.lastModified()) {
                return true;
            }
            long b2 = i.b(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
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

    public static boolean j(Context context) {
        try {
            if (l.d()) {
                Class.forName("com.coloros.mcssdk.PushManager");
                return PushManager.isSupportPush(context);
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private void k() {
        File file = new File(this.c);
        if (file.exists()) {
            i.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", file.lastModified());
            long j = 0;
            for (String str : m) {
                File file2 = new File(str);
                if (file2.exists()) {
                    j += file2.lastModified() / 10;
                }
            }
            i.a(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED", j);
            i.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE", System.currentTimeMillis());
        }
    }

    public static boolean k(Context context) {
        return f(context) || e(context) || g(context) || d(context) || h(context);
    }

    public static boolean l(Context context) {
        return o(context) || n(context) || j(context) || m(context) || p(context);
    }

    private static boolean m(Context context) {
        try {
            if (l.b()) {
                Class.forName("com.meizu.cloud.pushsdk.PushManager");
                return PushSettings.i(context);
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean n(Context context) {
        try {
            if (l.a()) {
                Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
                return PushSettings.h(context);
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean o(Context context) {
        return l.c() && PushSettings.l(context);
    }

    private static boolean p(Context context) {
        try {
            if (l.e()) {
                Class.forName("com.vivo.push.PushManager");
                return PushSettings.k(context);
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.1d) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(final a aVar) {
        String j;
        String j2;
        String j3;
        String j4;
        long j5 = 0;
        synchronized (this) {
            e = false;
            long b = i.b(this.a, "cloud_update_config_time", 0) * 24 * 3600 * 1000;
            if (b <= 0) {
                b = Config.THREAD_IMAGE_SAVE_MAX_TIME;
            }
            if (l.c() && PushSettings.l(this.a) && !f(this.a)) {
                try {
                    if (!TextUtils.isEmpty(l.j())) {
                    }
                    j5 = b;
                    b = j5;
                } catch (Exception e2) {
                }
            } else if (l.a() && PushSettings.h(this.a) && !e(this.a)) {
                try {
                    if (!TextUtils.isEmpty(l.j())) {
                        if (Float.parseFloat(j4) >= 4.0d) {
                            b = 0;
                        }
                    }
                } catch (Exception e3) {
                }
            } else if (l.d() && PushSettings.j(this.a) && !g(this.a)) {
                try {
                    if (!TextUtils.isEmpty(l.j())) {
                        if (Float.parseFloat(j3) >= 3.0d) {
                            b = 0;
                        }
                    }
                } catch (Exception e4) {
                }
            } else if (l.b() && PushSettings.i(this.a) && !d(this.a)) {
                try {
                    if (!TextUtils.isEmpty(l.j())) {
                        if (Float.parseFloat(j2) >= 6.0d) {
                            b = 0;
                        }
                    }
                } catch (Exception e5) {
                }
            } else if (l.e() && PushSettings.k(this.a) && !h(this.a)) {
                try {
                    if (!TextUtils.isEmpty(l.j())) {
                        if (Float.parseFloat(j) >= 3.1d) {
                            b = 0;
                        }
                    }
                } catch (Exception e6) {
                }
            }
            long b2 = i.b(this.a, "last_update_config_time");
            final long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b2 > b) {
                com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("ModeConfig-updateConfig", (short) 100) { // from class: com.baidu.android.pushservice.b.d.1
                    @Override // com.baidu.android.pushservice.h.c
                    public void a() {
                        JSONObject jSONObject;
                        try {
                            HashMap hashMap = new HashMap();
                            com.baidu.android.pushservice.d.b.a(hashMap);
                            hashMap.put("version", d.this.g + "");
                            hashMap.put("model", Build.MODEL);
                            hashMap.put("osSdkInt", Build.VERSION.SDK_INT + "");
                            if ((l.c() && PushSettings.l(d.this.a)) || ((l.a() && PushSettings.h(d.this.a)) || ((l.d() && PushSettings.j(d.this.a)) || ((l.b() && PushSettings.i(d.this.a)) || (l.e() && PushSettings.k(d.this.a)))))) {
                                hashMap.put(SapiContext.KEY_SDK_VERSION, ((int) com.baidu.android.pushservice.a.a()) + "");
                                hashMap.put("channelid", PushSettings.a(d.this.a));
                                hashMap.put("pkg_sign", l.r(d.this.a, d.this.a.getPackageName()));
                                hashMap.put("rom_version", l.j());
                            } else {
                                hashMap.put("pushSdkInt", ((int) com.baidu.android.pushservice.a.a()) + "");
                            }
                            hashMap.put("manufacture", Build.MANUFACTURER);
                            hashMap.put("cuid", DeviceId.getCUID(d.this.a));
                            hashMap.put(Constants.PACKAGE_NAME, d.this.a.getPackageName());
                            String a2 = d.this.a(hashMap);
                            if (!TextUtils.isEmpty(a2) && (jSONObject = (JSONObject) new JSONObject(a2).get("response_params")) != null) {
                                if (jSONObject.getInt("status") == 1) {
                                    String string = jSONObject.getString("sdkconfig");
                                    if (!TextUtils.isEmpty(string) && d.this.a(string)) {
                                        d.this.f();
                                    }
                                }
                                i.a(d.this.a, "last_update_config_time", currentTimeMillis);
                                i.a(d.this.a, "enable_newcid", jSONObject.optInt("newcid"));
                                i.a(d.this.a, "enable_conn_for_proxy", jSONObject.optInt("mode"));
                                i.a(d.this.a, "cloud_update_config_time", jSONObject.optInt("update_time", 0));
                            }
                        } catch (Exception e7) {
                        }
                        if (aVar == null || d.e) {
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
        } else if (this.h.c() == 9) {
            this.i = 9;
            return true;
        } else {
            if (this.h.c() == 2 && !TextUtils.isEmpty(this.h.f())) {
                try {
                    PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.h.f(), 16448);
                    if (packageInfo != null) {
                        int i = packageInfo.versionCode;
                        if (this.h.a() != null ? this.h.a().b == -1 ? i >= this.h.a().a : i >= this.h.a().a && i <= this.h.a().b : false) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
                            try {
                                CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
                                X509Certificate x509Certificate = certificateFactory != null ? (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream) : null;
                                bArr = x509Certificate != null ? com.baidu.android.pushservice.j.f.a(x509Certificate.getEncoded()) : null;
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
                                this.j = l.m(this.a, this.k);
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
            com.baidu.android.pushservice.f.a.a("ModeConfig", " Current Mode = " + this.i, this.a);
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
            com.baidu.android.pushservice.f.a.a("ModeConfig", "Config File Not Matched", this.a);
        }
    }
}
