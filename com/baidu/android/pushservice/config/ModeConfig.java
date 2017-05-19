package com.baidu.android.pushservice.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.h.m;
import com.baidu.android.pushservice.h.u;
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
public class ModeConfig extends b {
    private static final String CONFIG_MANUFACTURER_DEFAULT = "CONFIG_MANUFACTURER_DEFAULT";
    private static final String LAST_UPDATE_CONFIG_TIME = "last_update_config_time";
    private static final String MODECONFIG = "modeconfig";
    private static final String VERSION = "version";
    private static ModeConfig mInstance;
    private int mConfigVersion;
    private int mCurrentMode;
    private c mFacturer;
    private int mHighestVersion;
    private String mHostPackage;
    public HashMap<String, c> mManufacturers;
    private String updateConfigUrl;
    private static final String TAG = ModeConfig.class.getSimpleName();
    public static int MODE_O = 0;
    public static int MODE_I = 1;
    public static int MODE_C = 2;
    public static int MODE_C_H = 3;
    public static int MODE_C_C = 4;
    public static int MODE_I_HW = 5;
    public static int MODE_I_XM = 6;
    private static int updateConfigTime = 259200000;
    private static boolean hasCallBack = false;
    private static String[] BUILD_PROP_FILES = {"/default.prop", "/system/build.prop", "/system/default.prop", "/data/local.prop"};

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    protected ModeConfig(Context context) {
        super(context);
        this.updateConfigUrl = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updatesdkconfig";
        this.mCurrentMode = MODE_O;
        this.mHighestVersion = com.baidu.android.pushservice.a.a();
        this.mHostPackage = null;
        com.baidu.android.pushservice.e.a.c(TAG, "ModeConfig constructor......");
        this.localConfigPath = "/data/data/" + this.mContext.getPackageName() + "/files/bdpush_modeconfig.json";
        this.defaultConfigPath = "/com/baidu/android/pushservice/assets/defaultconfig.json";
        reload();
    }

    private static String byte2HexFormatted(byte[] bArr) {
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

    public static ModeConfig getInstance(Context context) {
        if (mInstance != null) {
            return mInstance;
        }
        mInstance = new ModeConfig(context);
        return mInstance;
    }

    private boolean initFromCache() {
        this.mConfigVersion = m.b(this.mContext, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
        if (this.mConfigVersion == -1) {
            return false;
        }
        String a2 = m.a(this.mContext, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (!a2.equals(CONFIG_MANUFACTURER_DEFAULT)) {
            this.mFacturer = new c(a2);
        }
        return true;
    }

    public static boolean isHuaweiProxyMode(Context context) {
        return getInstance(context).getCurrentMode() == MODE_I_HW && PushSettings.n(context);
    }

    public static boolean isProxyMode(Context context) {
        return isHuaweiProxyMode(context) || isXiaomiProxyMode(context);
    }

    public static boolean isXiaomiProxyMode(Context context) {
        try {
            MiPushClient.getRegId(context);
            if (getInstance(context).getCurrentMode() == MODE_I_XM) {
                return PushSettings.m(context);
            }
            return false;
        } catch (Throwable th) {
            com.baidu.android.pushservice.e.a.e(TAG, "not found com.xiaomi.mipush pkg, not xiaomiproxy mode!!!");
            return false;
        }
    }

    private boolean manufacturerMatched(c cVar, String str) {
        String a2;
        String b;
        int i;
        double d;
        double d2;
        if (cVar != null && cVar.d() != null && cVar.d().size() > 0) {
            com.baidu.android.pushservice.e.a.c(TAG, "getPropValues");
            for (int i2 = 0; i2 < cVar.d().size(); i2++) {
                d dVar = cVar.d().get(i2);
                try {
                    a2 = com.baidu.android.pushservice.h.a.a().a(dVar.a(), "");
                    b = dVar.b();
                    com.baidu.android.pushservice.e.a.c(TAG, "MatchValue=" + dVar.c() + " | " + a2 + "--" + b);
                } catch (Exception e) {
                    com.baidu.android.pushservice.e.a.a(TAG, e);
                }
                if (dVar.c() == 0) {
                    if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(a2)) {
                        double d3 = 0.0d;
                        try {
                            d3 = Double.parseDouble(b);
                            d = d3;
                            d2 = Double.parseDouble(a2);
                        } catch (NumberFormatException e2) {
                            com.baidu.android.pushservice.e.a.a(TAG, "number format exception  confv " + d3 + " val 0.0", e2);
                            d = d3;
                            d2 = 0.0d;
                        }
                        if (d2 >= d) {
                            com.baidu.android.pushservice.e.a.c(TAG, "manufacturerMatched success!!!");
                            return true;
                        }
                        com.baidu.android.pushservice.e.b.a(TAG, "manufaturer can not Matched, osversion is not ABOVE ", this.mContext);
                    }
                } else {
                    if (dVar.c() == 1) {
                        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(a2)) {
                            int i3 = 0;
                            try {
                                i3 = Integer.parseInt(b);
                                i = Integer.parseInt(a2);
                            } catch (NumberFormatException e3) {
                                com.baidu.android.pushservice.e.a.a(TAG, "number format exception  confv " + i3 + " val 0", e3);
                                i = 0;
                            }
                            if (i == i3) {
                                com.baidu.android.pushservice.e.a.c(TAG, "manufacturerMatched success!!!");
                                return true;
                            }
                            com.baidu.android.pushservice.e.b.a(TAG, "manufaturer can not Matched, osversion is not EQUAL ", this.mContext);
                        }
                    } else if (dVar.c() != 2) {
                        continue;
                    } else if (Pattern.matches(b, a2)) {
                        com.baidu.android.pushservice.e.a.c(TAG, "manufacturerMatched success!!!");
                        return true;
                    } else {
                        com.baidu.android.pushservice.e.a.c(TAG, "manufacturerMatched failure!!!");
                        com.baidu.android.pushservice.e.b.a(TAG, "manufaturer can not Matched, osversion is not REGULAR ", this.mContext);
                    }
                }
                com.baidu.android.pushservice.e.a.a(TAG, e);
            }
        }
        if (cVar.e() != null && cVar.e().size() > 0) {
            com.baidu.android.pushservice.e.a.c(TAG, "getSystemProps");
            for (int i4 = 0; i4 < cVar.e().size(); i4++) {
                e eVar = cVar.e().get(i4);
                try {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, eVar.a());
                    com.baidu.android.pushservice.e.a.c(TAG, " buildVersion " + str2);
                    String lowerCase = Build.MODEL.toLowerCase();
                    boolean z = false;
                    if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains("nexus")) {
                        z = true;
                        com.baidu.android.pushservice.e.b.a(TAG, "manufaturer  is Nexus ", this.mContext);
                    }
                    if (str.equalsIgnoreCase("HUAWEI") && !z && !str2.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21 && PushSettings.n(this.mContext)) {
                        str2 = "3.1";
                    }
                    Matcher matcher = Pattern.compile(eVar.c()).matcher(str2);
                    if (matcher.find()) {
                        Double valueOf = Double.valueOf(matcher.group());
                        Double valueOf2 = Double.valueOf(eVar.b());
                        if (eVar.d() == 0) {
                            if (valueOf.doubleValue() >= valueOf2.doubleValue()) {
                                com.baidu.android.pushservice.e.a.c(TAG, "versioncode >= configversioncode, manufacturerMatched success!!!");
                                return true;
                            }
                            com.baidu.android.pushservice.e.b.a(TAG, "versioncode < configversioncode, manufaturer can not Matched, osversion is not ABOVE ", this.mContext);
                        } else if (eVar.d() != 1) {
                            continue;
                        } else if (valueOf == valueOf2) {
                            com.baidu.android.pushservice.e.a.c(TAG, "versioncode == configversioncode, manufacturerMatched success!!!");
                            return true;
                        } else {
                            com.baidu.android.pushservice.e.b.a(TAG, "versioncode != configversioncode, manufaturer can not Matched, osversion is not EQUAL ", this.mContext);
                        }
                    } else {
                        continue;
                    }
                } catch (Exception e4) {
                    com.baidu.android.pushservice.e.a.a(TAG, e4);
                }
            }
        }
        return false;
    }

    private boolean needReload() {
        long j = 0;
        if (System.currentTimeMillis() - m.c(this.mContext, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE") > TbConfig.APP_OVERDUR_DRAFT_BOX) {
            return true;
        }
        long c = m.c(this.mContext, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
        File file = new File(this.localConfigPath);
        if (!file.exists()) {
            file = new File(this.defaultConfigPath);
        }
        if (c <= 0 || c != file.lastModified()) {
            return true;
        }
        long c2 = m.c(this.mContext, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
        for (String str : BUILD_PROP_FILES) {
            File file2 = new File(str);
            if (file2.exists()) {
                j += file2.lastModified() / 10;
            }
        }
        return c2 != j;
    }

    private boolean parseConfig() {
        com.baidu.android.pushservice.e.a.c(TAG, "parseConfig begin.....");
        try {
            JSONObject jSONObject = new JSONObject(this.mConfigContent);
            this.mConfigVersion = jSONObject.getInt(VERSION);
            this.mManufacturers = new HashMap<>();
            JSONArray jSONArray = jSONObject.getJSONArray(MODECONFIG);
            for (int i = 0; i < jSONArray.length(); i++) {
                c cVar = new c(jSONArray.getString(i));
                this.mManufacturers.put(cVar.b(), cVar);
                com.baidu.android.pushservice.e.a.c(TAG, "mManufacturers put key" + i + " = " + cVar.b());
            }
            this.mFacturer = selectCurrentManufacturer(Build.MANUFACTURER.toUpperCase());
            setCache(this.mFacturer);
            return true;
        } catch (JSONException e) {
            com.baidu.android.pushservice.e.a.a(TAG, e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String requestConfig(HashMap<String, String> hashMap) {
        String a2 = h.f() ? h.a() : h.b();
        if ((u.a() && PushSettings.m(this.mContext)) || (u.b() && PushSettings.n(this.mContext))) {
            this.updateConfigUrl = a2 + "/rest/3.0/clientfile/updateconf";
        } else {
            this.updateConfigUrl = a2 + "/rest/3.0/clientfile/updatesdkconfig";
        }
        com.baidu.android.pushservice.e.a.c(TAG, this.updateConfigUrl);
        int i = 2;
        do {
            com.baidu.android.pushservice.d.a a3 = com.baidu.android.pushservice.d.b.a(this.updateConfigUrl, "POST", hashMap, "BCCS_SDK/3.0");
            if (a3 != null) {
                int b = a3.b();
                String a4 = com.baidu.android.pushservice.f.a.b.a(a3.a());
                com.baidu.android.pushservice.e.a.c(TAG, "update config request response, code=" + b + ", result=" + a4);
                if (b == 200) {
                    return a4;
                }
            }
            i--;
        } while (i > 0);
        return null;
    }

    private c selectCurrentManufacturer(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.android.pushservice.e.a.c(TAG, "facturerName is null!");
            return null;
        }
        String upperCase = str.toUpperCase();
        if (Build.MANUFACTURER.toUpperCase().equalsIgnoreCase("unknown") && this.mManufacturers != null) {
            com.baidu.android.pushservice.e.a.c(TAG, "manufacturer is unknown!");
            for (Map.Entry<String, c> entry : this.mManufacturers.entrySet()) {
                String key = entry.getKey();
                if (manufacturerMatched(this.mManufacturers.get(key), key)) {
                    return this.mManufacturers.get(key);
                }
            }
        } else if (this.mManufacturers != null && this.mManufacturers.containsKey(upperCase)) {
            com.baidu.android.pushservice.e.a.c(TAG, "mManufacturers containsKey " + upperCase);
            if (manufacturerMatched(this.mManufacturers.get(upperCase), upperCase)) {
                return this.mManufacturers.get(upperCase);
            }
        }
        return null;
    }

    private void setCache(c cVar) {
        String str = CONFIG_MANUFACTURER_DEFAULT;
        if (cVar != null) {
            str = cVar.toString();
        }
        m.a(this.mContext, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE", str);
        m.a(this.mContext, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.mConfigVersion);
        setReloadCache();
    }

    private void setReloadCache() {
        File file = new File(this.localConfigPath);
        if (!file.exists()) {
            file = new File(this.defaultConfigPath);
        }
        m.a(this.mContext, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", file.lastModified());
        long j = 0;
        for (String str : BUILD_PROP_FILES) {
            File file2 = new File(str);
            if (file2.exists()) {
                j += file2.lastModified() / 10;
            }
        }
        m.a(this.mContext, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED", j);
        m.a(this.mContext, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE", System.currentTimeMillis());
    }

    public int getConfigVersion() {
        return this.mConfigVersion;
    }

    public int getCurrentMode() {
        return this.mCurrentMode;
    }

    public int getHighestVersion() {
        return this.mHighestVersion;
    }

    public String getHostPackageName() {
        return this.mHostPackage;
    }

    public boolean refreshMode() {
        boolean z;
        CertificateFactory certificateFactory;
        X509Certificate x509Certificate;
        byte[] bArr = null;
        if (this.mFacturer == null) {
            return true;
        }
        if (this.mFacturer.c() == MODE_I_HW) {
            this.mCurrentMode = MODE_I_HW;
            return true;
        } else if (this.mFacturer.c() == MODE_I_XM) {
            this.mCurrentMode = MODE_I_XM;
            return true;
        } else {
            if (this.mFacturer.c() == MODE_C && !TextUtils.isEmpty(this.mFacturer.f())) {
                try {
                    PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mFacturer.f(), 16448);
                    if (packageInfo != null) {
                        int i = packageInfo.versionCode;
                        com.baidu.android.pushservice.e.a.c(TAG, "version code = " + i);
                        if (this.mFacturer.a() == null) {
                            z = false;
                        } else if (this.mFacturer.a().b == -1) {
                            com.baidu.android.pushservice.e.a.c(TAG, "to = -1");
                            z = i >= this.mFacturer.a().a;
                        } else {
                            com.baidu.android.pushservice.e.a.c(TAG, "from");
                            z = (i >= this.mFacturer.a().a) & (i <= this.mFacturer.a().b);
                        }
                        com.baidu.android.pushservice.e.a.c(TAG, "version ret " + z);
                        if (z) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
                            try {
                                certificateFactory = CertificateFactory.getInstance("X509");
                            } catch (CertificateException e) {
                                com.baidu.android.pushservice.e.a.a(TAG, e);
                                certificateFactory = null;
                            }
                            try {
                                x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
                            } catch (CertificateException e2) {
                                com.baidu.android.pushservice.e.a.a(TAG, e2);
                                x509Certificate = null;
                            }
                            try {
                                bArr = com.baidu.android.pushservice.i.h.a(x509Certificate.getEncoded());
                            } catch (Exception e3) {
                                com.baidu.android.pushservice.e.a.a(TAG, e3);
                            }
                            String byte2HexFormatted = byte2HexFormatted(bArr);
                            com.baidu.android.pushservice.e.a.c(TAG, "hexString " + byte2HexFormatted);
                            com.baidu.android.pushservice.e.a.c(TAG, "apkSignture" + this.mFacturer.g());
                            if (byte2HexFormatted.equalsIgnoreCase(this.mFacturer.g())) {
                                this.mHostPackage = this.mFacturer.f();
                                this.mHighestVersion = u.l(this.mContext, this.mHostPackage);
                                if (this.mContext.getPackageName().equalsIgnoreCase(this.mFacturer.f())) {
                                    this.mCurrentMode = MODE_C_H;
                                    com.baidu.android.pushservice.e.a.c(TAG, "return true c_h");
                                    return true;
                                }
                                this.mCurrentMode = MODE_C_C;
                                com.baidu.android.pushservice.e.a.c(TAG, "return true c_c");
                                return true;
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException e4) {
                    return false;
                }
            }
            com.baidu.android.pushservice.e.b.a(TAG, " Current Mode = " + this.mCurrentMode, this.mContext);
            return false;
        }
    }

    public void reload() {
        boolean needReload = needReload();
        boolean initFromCache = initFromCache();
        com.baidu.android.pushservice.e.a.c(TAG, "needReload = " + needReload + ", initFromCache = " + initFromCache);
        if ((needReload || !initFromCache) && loadConfig()) {
            parseConfig();
        }
        if (this.mFacturer != null) {
            refreshMode();
        } else {
            com.baidu.android.pushservice.e.b.a(TAG, "Config File Not Matched", this.mContext);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc A[Catch: all -> 0x0069, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0002, B:6:0x0011, B:8:0x0019, B:10:0x0021, B:12:0x0034, B:14:0x003f, B:15:0x0042, B:18:0x0059, B:20:0x005d, B:46:0x00bc, B:24:0x0063, B:29:0x006c, B:31:0x0072, B:33:0x007a, B:35:0x0082, B:37:0x0095, B:39:0x00a3, B:42:0x00a8, B:43:0x00ae, B:45:0x00b5), top: B:50:0x0002, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void updateConfig(final a aVar) {
        long c;
        final long currentTimeMillis;
        hasCallBack = false;
        com.baidu.android.pushservice.e.a.c(TAG, "updateConfig......");
        if (u.a() && PushSettings.m(this.mContext) && !isXiaomiProxyMode(this.mContext)) {
            try {
                com.baidu.android.pushservice.e.a.c(TAG, "XiaomiProxyMode......");
                String C = u.C(this.mContext);
                if (!TextUtils.isEmpty(C) && Float.parseFloat(C) >= 4.0d) {
                    updateConfigTime = 0;
                }
            } catch (Exception e) {
                com.baidu.android.pushservice.e.a.a(TAG, e);
            }
            c = m.c(this.mContext, LAST_UPDATE_CONFIG_TIME);
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c <= updateConfigTime) {
            }
        } else {
            if (u.b() && PushSettings.n(this.mContext) && !isHuaweiProxyMode(this.mContext)) {
                try {
                    com.baidu.android.pushservice.e.a.c(TAG, "HuaweiProxyMode......");
                    String C2 = u.C(this.mContext);
                    if (!TextUtils.isEmpty(C2) && Float.parseFloat(C2) >= 3.1d) {
                        updateConfigTime = 0;
                    }
                } catch (Exception e2) {
                    com.baidu.android.pushservice.e.a.a(TAG, e2);
                }
            } else {
                updateConfigTime = 259200000;
                if (aVar != null) {
                    hasCallBack = true;
                    aVar.a();
                }
            }
            c = m.c(this.mContext, LAST_UPDATE_CONFIG_TIME);
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c <= updateConfigTime) {
                com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("ModeConfig-updateConfig", (short) 100) { // from class: com.baidu.android.pushservice.config.ModeConfig.1
                    @Override // com.baidu.android.pushservice.g.c
                    public void a() {
                        try {
                            HashMap hashMap = new HashMap();
                            com.baidu.android.pushservice.c.b.b(hashMap);
                            hashMap.put(ModeConfig.VERSION, ModeConfig.this.mConfigVersion + "");
                            hashMap.put("model", Build.MODEL);
                            hashMap.put("osSdkInt", Build.VERSION.SDK_INT + "");
                            if ((u.a() && PushSettings.m(ModeConfig.this.mContext)) || (u.b() && PushSettings.n(ModeConfig.this.mContext))) {
                                hashMap.put("manufacture", Build.MANUFACTURER);
                                hashMap.put("sdk_version", ((int) com.baidu.android.pushservice.a.a()) + "");
                                hashMap.put("cuid", com.baidu.android.pushservice.i.e.a(ModeConfig.this.mContext));
                                hashMap.put("channelid", PushSettings.a(ModeConfig.this.mContext));
                                hashMap.put("package_name", ModeConfig.this.mContext.getPackageName());
                                hashMap.put("pkg_sign", u.q(ModeConfig.this.mContext, ModeConfig.this.mContext.getPackageName()));
                                hashMap.put("rom_version", u.C(ModeConfig.this.mContext));
                            } else {
                                hashMap.put("manufacturer", Build.MANUFACTURER);
                                hashMap.put("pushSdkInt", ((int) com.baidu.android.pushservice.a.a()) + "");
                            }
                            com.baidu.android.pushservice.e.a.c(ModeConfig.TAG, "update config request send, params=" + com.baidu.android.pushservice.c.b.a(hashMap));
                            String requestConfig = ModeConfig.this.requestConfig(hashMap);
                            if (!TextUtils.isEmpty(requestConfig)) {
                                JSONObject jSONObject = new JSONObject(requestConfig);
                                JSONObject jSONObject2 = (JSONObject) jSONObject.get("response_params");
                                com.baidu.android.pushservice.e.a.c(ModeConfig.TAG, "new config content=" + jSONObject.toString());
                                if (jSONObject2 != null && jSONObject2.getInt("status") == 1) {
                                    String string = jSONObject2.getString("sdkconfig");
                                    if (!TextUtils.isEmpty(string)) {
                                        boolean writeConfig = ModeConfig.this.writeConfig(string);
                                        com.baidu.android.pushservice.e.a.c(ModeConfig.TAG, "write config >> " + writeConfig);
                                        if (writeConfig) {
                                            ModeConfig.this.reload();
                                            m.a(ModeConfig.this.mContext, ModeConfig.LAST_UPDATE_CONFIG_TIME, currentTimeMillis);
                                        }
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            com.baidu.android.pushservice.e.a.a(ModeConfig.TAG, e3);
                        }
                        if (aVar == null || ModeConfig.hasCallBack) {
                            return;
                        }
                        aVar.a();
                    }
                });
            } else if (aVar != null && !hasCallBack) {
                aVar.a();
            }
        }
    }
}
