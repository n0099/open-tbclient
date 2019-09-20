package com.baidu.cyberplayer.sdk.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.a.b;
import com.baidu.cyberplayer.sdk.c;
import com.baidu.cyberplayer.sdk.statistics.DpNetworkUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
/* loaded from: classes.dex */
public class CyberCfgManager {
    @Keep
    public static final String KEY_ACCURATE_SEEK_ENABLE = "accurate_seek_enable";
    @Keep
    public static final String KEY_INT_DECODE_MODE = "decode_mode";
    @Keep
    public static final String KEY_INT_ENABLE_FILE_CACHE = "enable_file_cache";
    @Keep
    public static final String KEY_INT_ENABLE_HW_DECODE = "enable_hw_decode";
    @Keep
    public static final String KEY_INT_ENABLE_LOW_BITRATE_CHOOSE_DECODER = "enable_low_bitrate_choose_decoder";
    @Keep
    public static final String KEY_INT_ENABLE_MEDIACODEC_REUSE = "enable_mediacodec_reuse";
    @Keep
    public static final String KEY_INT_ENABLE_PLAYER_THREAD = "enable_player_thread";
    @Keep
    public static final String KEY_INT_ENABLE_PREFETCH = "enable_prefetch";
    @Keep
    public static final String KEY_INT_FILE_CACHE_MIN_FREE_SIZE = "file_cache_min_free_size";
    @Keep
    public static final String KEY_INT_PCDN_FORBIDDEN = "pcdn_forbidden";
    @Keep
    public static final String LAST_CHECK_UNUSED_LIBS_TIME = "last_check_unused_libs_time";
    private static CyberCfgManager f;
    private String i;
    private String j;
    private static Context b = null;
    private static boolean g = false;
    private static int h = 86400000;
    public static ArrayList<String> a = new ArrayList<>();
    private static ArrayList<String> l = new ArrayList<>();
    private static ArrayList<String> m = new ArrayList<>();
    private static ArrayList<String> n = new ArrayList<>();
    private static ArrayList<String> o = new ArrayList<>();
    private static ArrayList<String> p = new ArrayList<>();
    private static ArrayList<String> q = new ArrayList<>();
    private Map<String, String> c = new HashMap();
    private String d = null;
    private String e = null;
    private boolean k = false;

    static {
        a.add("hwH60");
        a.add("hwp7");
        a.add("sp8830ec");
        a.add("Hisense M30T");
        l.add("GT-I9500");
        l.add("GT-I9268");
        l.add("GT-I8268");
        l.add("GT-I9260");
        l.add("GT-I9508V");
        l.add("SM-A7000");
        l.add("SM-N9008V");
        l.add("SM-N9006");
        l.add("SM-G9280");
        l.add("GT-I8552");
        l.add("SM-N9009");
        l.add("vivo X1");
        l.add("X9077");
        l.add("vivo X5Max+");
        l.add("vivo X5M");
        l.add("vivo Y37L");
        l.add("vivo Y37");
        l.add("vivo X5Pro V");
        l.add("vivo X7");
        l.add("OPPO R9tm");
        l.add("2013022");
        l.add("HUAWEI VNS-AL00");
        l.add("HUAWEI G629-UL00");
        l.add("Lenovo A606");
        l.add("Lenovo Z2");
        l.add("ALE-TL00");
        l.add("ALE-UL00");
        l.add("BLN-AL10");
        l.add("Che-UL00");
        l.add("CHE_TL00");
        l.add("CK2-01");
        l.add("EVA-AL10");
        l.add("NX506J");
        l.add("NEM-AL10");
        l.add("VIE-AL10");
        l.add("m2 note");
        l.add("HTC E9t");
        l.add("MHA-AL00");
        l.add("Redmi 3S");
        l.add("Redmi 3X");
        o.add("SM-N9009");
        o.add("ZTE A0622");
    }

    private CyberCfgManager() {
    }

    private int a(Map<String, String> map, String str, int i) {
        if (map != null) {
            String str2 = map.get(str);
            if (TextUtils.isEmpty(str2)) {
                return i;
            }
            try {
                return Integer.parseInt(str2);
            } catch (Exception e) {
                return i;
            }
        }
        return i;
    }

    private String a(Map<String, String> map, String str, String str2) {
        if (map != null) {
            String str3 = map.get(str);
            if (!TextUtils.isEmpty(str3)) {
                return str3;
            }
        }
        return str2;
    }

    private void a(String str, String str2) {
        if (a(this.c, str, -1) == -1) {
            String a2 = a(this.c, str2, "");
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            this.c.put(str, Integer.toString(CfgItemParser.versionMatchCheck(a2, SDKVersion.VERSION).booleanValue() ? 1 : 0));
        }
    }

    private boolean a(Map<String, String> map) {
        String a2 = a(map, "release_key", "");
        return !TextUtils.isEmpty(a2) && a2.equalsIgnoreCase(this.d);
    }

    private String b(String str, String str2) {
        try {
            return b != null ? b.getSharedPreferences("video_cfg_", 0).getString(str, str2) : str2;
        } catch (Exception e) {
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        this.c.clear();
        c();
        d();
        e();
        f();
    }

    private void b(Map<String, String> map) {
        int a2 = a(map, "log_level", -1);
        if (a2 != -1) {
            CyberLog.a(a2);
        }
    }

    private void c() {
        this.i = Utils.a() + File.separator + "cybermedia" + File.separator + "config";
        Map<String, String> a2 = a.a(this.i + File.separator + "cybermedia.pro");
        if (a2 != null) {
            this.c.putAll(a2);
        }
    }

    private void d() {
        try {
            for (Map.Entry<String, String> entry : CyberPlayerManager.getInstallOpts().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key.startsWith(CyberPlayerManager.INSTALL_OPT_ABTEST_SWITCH_START_CODE)) {
                    CyberLog.d("CyberCfgManager", "ABTest key:" + key + " value:" + value);
                    Map<String, String> c = Utils.c(value);
                    if (c != null) {
                        this.c.putAll(c);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private void e() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                this.j = Environment.getExternalStorageDirectory().getAbsolutePath();
                Map<String, String> a2 = a.a(this.j + File.separator + "cybermedia.pro");
                if (a2 != null) {
                    b(a2);
                    if (a(a2)) {
                        this.c.putAll(a2);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private void f() {
        a(KEY_INT_ENABLE_PREFETCH, "pre_download_ver");
        a(KEY_INT_ENABLE_FILE_CACHE, "file_cache_ver");
        a("enable_update_core", "update_core_sdk_ver");
        i();
        j();
        k();
        this.c.put(KEY_INT_ENABLE_HW_DECODE, Integer.toString(l() ? 0 : 1));
        this.c.put("enable_gl_render", Integer.toString(m() ? 0 : 1));
        if (getCfgBoolValue("remote_forbidden", false) || !n()) {
            return;
        }
        this.c.put("remote_forbidden", Integer.toString(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g() {
        String packageName = b.getPackageName();
        String str = (getCfgValue("update_cloud_cfg_server", "https://browserkernel.baidu.com/video") + File.separator + "videoconfig") + "?cmd=1&";
        StringBuilder sb = new StringBuilder();
        Utils.a(sb, Constants.PACKAGE_NAME, packageName);
        Utils.a(sb, "sdk_ver", SDKVersion.VERSION);
        if (!TextUtils.isEmpty(this.e)) {
            Utils.a(sb, "appid", this.e);
        }
        try {
            PackageManager packageManager = b.getPackageManager();
            if (packageManager != null) {
                Utils.a(sb, "appversion", packageManager.getPackageInfo(packageName, 0).versionName);
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        Utils.a(sb, "dev_ver", Build.VERSION.SDK_INT);
        Utils.a(sb, "net_type", DpNetworkUtils.getNetworkStatisticsData(b));
        if (!TextUtils.isEmpty(this.d)) {
            Utils.a(sb, DpStatConstants.KEY_CUID, this.d);
        }
        try {
            Utils.a(sb, "model", new String(Base64.encode(Build.MODEL.getBytes(), 0)));
        } catch (Throwable th) {
            CyberLog.e("CyberCfgManager", "model exception ", th);
        }
        return str + sb.toString();
    }

    @Keep
    public static synchronized CyberCfgManager getInstance() {
        CyberCfgManager cyberCfgManager;
        synchronized (CyberCfgManager.class) {
            if (f == null) {
                f = new CyberCfgManager();
            }
            if (b == null) {
                b = CyberPlayerManager.getApplicationContext();
            }
            cyberCfgManager = f;
        }
        return cyberCfgManager;
    }

    private void h() {
        CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.config.CyberCfgManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String g2 = CyberCfgManager.this.g();
                    Properties properties = new Properties();
                    Utils.b(CyberCfgManager.this.i);
                    File file = new File(CyberCfgManager.this.i, "cybermedia.pro");
                    if (!file.exists() || !file.isFile()) {
                        file.createNewFile();
                    }
                    File file2 = new File(CyberCfgManager.this.i, "cybermedia.pro.tmp");
                    if (!file2.exists() || !file2.isFile()) {
                        file2.createNewFile();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", g2);
                    byte[] a2 = b.a(hashMap);
                    String a3 = Utils.a(a2);
                    String a4 = Utils.a(a2, new String(Base64.decode("SFIyRVI=".getBytes(), 0)));
                    if (a4 != null) {
                        Map<String, String> c = Utils.c(a4);
                        if (c != null) {
                            FileWriter fileWriter = new FileWriter(file2.getAbsolutePath());
                            for (Map.Entry<String, String> entry : c.entrySet()) {
                                properties.setProperty(entry.getKey(), entry.getValue());
                                CyberLog.d("CyberCfgManager", "update cloud cfg key:" + entry.getKey() + " value:" + entry.getValue());
                            }
                            properties.store(fileWriter, "update");
                            fileWriter.close();
                        }
                        if (!file2.renameTo(file) || TextUtils.isEmpty(a3) || a3.equals(CyberCfgManager.this.getPrefStr("cloud_cfg_data_md5", ""))) {
                            return;
                        }
                        CyberCfgManager.this.setPrefStr("cloud_cfg_data_md5", a3);
                        CyberCfgManager.this.b();
                        c.f();
                        CyberLog.d("CyberCfgManager", "updateCloudCfgProFile success!");
                    }
                } catch (Exception e) {
                }
            }
        });
    }

    private void i() {
        if (a(this.c, "enable_upload_session_log", -1) == -1) {
            String a2 = a(this.c, "upload_session_log_ver", "");
            if (!TextUtils.isEmpty(a2) && !CfgItemParser.versionMatchCheck(a2, SDKVersion.VERSION).booleanValue()) {
                this.c.put("enable_upload_session_log", Integer.toString(0));
                return;
            }
            if (new Random().nextInt(10000) + 1 <= a(this.c, "session_log_collect_percent", 10000)) {
                this.c.put("enable_upload_session_log", Integer.toString(1));
            } else {
                this.c.put("enable_upload_session_log", Integer.toString(0));
            }
        }
    }

    private void j() {
        String[] split;
        String cfgValue = getCfgValue("update_core_info", "");
        if (TextUtils.isEmpty(cfgValue) || (split = cfgValue.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) == null || split.length != 2 || !CfgItemParser.versionMatchCheck(split[0], SDKVersion.VERSION).booleanValue()) {
            return;
        }
        this.c.put("update_core_ver", split[1]);
    }

    private void k() {
        String cfgValue = getCfgValue("decode_mode_for_rom", "");
        if (TextUtils.isEmpty(cfgValue)) {
            return;
        }
        try {
            String[] split = cfgValue.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            if (split == null || split.length != 2) {
                return;
            }
            for (String str : split[0].split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                if (Integer.parseInt(str) == Build.VERSION.SDK_INT) {
                    this.c.put("decode_mode", split[1]);
                    return;
                }
            }
        } catch (Exception e) {
        }
    }

    private boolean l() {
        if (Build.VERSION.SDK_INT >= 16 && !CfgItemParser.a(a, l)) {
            String a2 = a(this.c, "black_devices_for_hw", "");
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            String[] split = a2.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                arrayList.add(str);
            }
            return CfgItemParser.a(arrayList, arrayList);
        }
        return true;
    }

    private boolean m() {
        if (CfgItemParser.a(n, o)) {
            return true;
        }
        String a2 = a(this.c, "black_devices_for_gl_render", "");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        String[] split = a2.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            arrayList.add(str);
        }
        return CfgItemParser.a(arrayList, arrayList);
    }

    private boolean n() {
        if (CfgItemParser.a(p, q)) {
            return true;
        }
        String a2 = a(this.c, "remote_blacklist", "");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        String[] split = a2.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            arrayList.add(str);
        }
        return CfgItemParser.a(arrayList, arrayList);
    }

    private boolean o() {
        return this.k;
    }

    private void p() {
        try {
            this.c.clear();
            this.c.put("session_log_collect_percent", b("session_log_collect_percent", "10000"));
            this.c.put(KEY_INT_PCDN_FORBIDDEN, b(KEY_INT_PCDN_FORBIDDEN, "0"));
            e();
            f();
            CyberLog.d("CyberCfgManager", "updateCloudCfgFromT7Pref success!");
            c.f();
        } catch (Exception e) {
        }
    }

    public void a(boolean z) {
        this.k = z;
    }

    public synchronized boolean a() {
        boolean o2;
        o2 = o();
        if (!o2) {
            o2 = TextUtils.equals(b("spring_festival_switch", Boolean.toString(false)), "true");
        }
        CyberLog.d("CyberCfgManager", "isSFSwitchEnabled:" + o2);
        return o2;
    }

    @Keep
    public synchronized boolean getCfgBoolValue(String str, boolean z) {
        boolean z2;
        String str2;
        try {
            str2 = this.c.get(str);
        } catch (Exception e) {
            CyberLog.w("CyberCfgManager", str + " Cfg Value Invalid.");
        }
        if (str2 != null) {
            z2 = Integer.parseInt(str2) == 1;
        }
        z2 = z;
        return z2;
    }

    @Keep
    public synchronized int getCfgIntValue(String str, int i) {
        try {
            String str2 = this.c.get(str);
            if (str2 != null) {
                i = Integer.parseInt(str2);
            }
        } catch (Exception e) {
            CyberLog.w("CyberCfgManager", str + " Cfg Value Invalid.");
        }
        return i;
    }

    @Keep
    public synchronized long getCfgLongValue(String str, long j) {
        try {
            String str2 = this.c.get(str);
            if (str2 != null) {
                j = Long.parseLong(str2);
            }
        } catch (Exception e) {
            CyberLog.w("CyberCfgManager", str + " Cfg Value Invalid.");
        }
        return j;
    }

    @Keep
    public synchronized Map<String, String> getCfgMap() {
        HashMap hashMap;
        try {
            hashMap = new HashMap();
            try {
                hashMap.putAll(this.c);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            hashMap = null;
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:
        if (r0 != null) goto L5;
     */
    @Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String getCfgValue(String str, String str2) {
        String str3;
        try {
            str3 = this.c.get(str);
        } catch (Exception e) {
            CyberLog.w("CyberCfgManager", str + " Cfg Value Invalid.");
            str3 = str2;
            return str3;
        }
        return str3;
    }

    @Keep
    public synchronized long getPrefLong(String str, long j) {
        if (b != null) {
            j = b.getSharedPreferences("video_cfg", 0).getLong(str, j);
        }
        return j;
    }

    @Keep
    public synchronized String getPrefStr(String str, String str2) {
        if (b != null) {
            str2 = b.getSharedPreferences("video_cfg", 0).getString(str, str2);
        }
        return str2;
    }

    @Keep
    public synchronized void init() {
        this.d = CyberPlayerManager.getClientID();
        this.e = CyberPlayerManager.getAppID();
        long prefLong = getPrefLong("last_update_cloud_cfg_time", -1L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - prefLong > h || !g) {
            CyberLog.d("CyberCfgManager", "CyberCfgManager init in");
            if (a()) {
                p();
            } else {
                b();
                if (Utils.a(CyberPlayerManager.getApplicationContext())) {
                    h();
                }
            }
            g = true;
            setPrefLong("last_update_cloud_cfg_time", currentTimeMillis);
        }
    }

    @Keep
    public synchronized boolean isBlackUrl(String str) {
        boolean z = true;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && !CfgItemParser.a(str, m)) {
                String a2 = a(this.c, "black_url_list_for_file_cache", "");
                if (TextUtils.isEmpty(a2)) {
                    z = false;
                } else {
                    String[] split = a2.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : split) {
                        arrayList.add(str2);
                    }
                    z = CfgItemParser.a(str, arrayList);
                }
            }
        }
        return z;
    }

    @Keep
    public synchronized void setPrefLong(String str, long j) {
        if (b != null) {
            SharedPreferences.Editor edit = b.getSharedPreferences("video_cfg", 0).edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    @Keep
    public synchronized void setPrefStr(String str, String str2) {
        if (b != null) {
            SharedPreferences.Editor edit = b.getSharedPreferences("video_cfg", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }
}
