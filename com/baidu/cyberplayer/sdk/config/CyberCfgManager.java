package com.baidu.cyberplayer.sdk.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.a.b;
import com.baidu.cyberplayer.sdk.c;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.cyberplayer.sdk.n;
import com.baidu.cyberplayer.sdk.statistics.DpNetworkUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.sdk.VideoCloudSetting;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class CyberCfgManager {
    @Keep
    public static final String KEY_ACCURATE_SEEK_ENABLE = "accurate_seek_enable";
    @Keep
    public static final String KEY_INT_DECODE_MODE = "decode_mode";
    @Keep
    public static final String KEY_INT_ENABLE_BSO = "enable_bso";
    @Keep
    public static final String KEY_INT_ENABLE_CRASHPAD = "enable_crashpad";
    @Keep
    public static final String KEY_INT_ENABLE_FILE_CACHE = "enable_file_cache";
    @Keep
    public static final String KEY_INT_ENABLE_HW_DECODE = "enable_hw_decode";
    @Keep
    public static final String KEY_INT_ENABLE_MEDIACODEC_OMX_GOOGLE_HEVC = "mediacodec_enable_omx_google_hevc";
    @Keep
    public static final String KEY_INT_ENABLE_MEDIACODEC_REUSE = "enable_mediacodec_reuse";
    @Keep
    public static final String KEY_INT_ENABLE_MONITOR = "enable_monitor";
    @Keep
    public static final String KEY_INT_ENABLE_MULTI_INSTANCE = "enable_multi_instance";
    @Keep
    public static final String KEY_INT_ENABLE_PREFETCH = "enable_prefetch";
    @Keep
    public static final String KEY_INT_ENABLE_SR = "enable_sr";
    @Keep
    public static final String KEY_INT_FILE_CACHE_MIN_FREE_SIZE = "file_cache_min_free_size";
    @Keep
    public static final String KEY_INT_MEDIA_INSTANCE_CAP = "instance_capacity";
    @Keep
    public static final String KEY_INT_PCDN_FORBIDDEN = "pcdn_forbidden";
    @Keep
    public static final String KEY_INT_REMOTE_RESUME_FORBIDDEN = "remote_resume_forbidden";
    @Keep
    public static final String KEY_STR_UPDATE_EXT_RTC = "updata_ext_rtc_ver";
    @Keep
    public static final String LAST_CHECK_UNUSED_LIBS_TIME = "last_check_unused_libs_time";
    @Keep
    public static final String SR_REMAINING_INFO = "sr_remaining_info";
    private Map<String, String> c = new ConcurrentHashMap();
    private Map<String, String> d = new ConcurrentHashMap();
    private String e = null;
    private String f = null;
    private String k;
    private String l;

    /* renamed from: b  reason: collision with root package name */
    private static Context f1801b = null;
    private static CyberCfgManager g = new CyberCfgManager();
    private static volatile boolean h = false;
    private static volatile boolean i = false;
    private static int j = 86400000;

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<String> f1800a = new ArrayList<>();
    private static ArrayList<String> m = new ArrayList<>();
    private static ArrayList<String> n = new ArrayList<>();
    private static ArrayList<String> o = new ArrayList<>();
    private static ArrayList<String> p = new ArrayList<>();
    private static ArrayList<String> q = new ArrayList<>();
    private static ArrayList<String> r = new ArrayList<>();

    static {
        f1800a.add("hwH60");
        f1800a.add("hwp7");
        f1800a.add("sp8830ec");
        f1800a.add("Hisense M30T");
        m.add("GT-I9500");
        m.add("GT-I9268");
        m.add("GT-I8268");
        m.add("GT-I9260");
        m.add("GT-I9508V");
        m.add("SM-A7000");
        m.add("SM-N9008V");
        m.add("SM-N9006");
        m.add("SM-G9280");
        m.add("GT-I8552");
        m.add("SM-N9009");
        m.add("vivo X1");
        m.add("X9077");
        m.add("vivo X5Max+");
        m.add("vivo X5M");
        m.add("vivo Y37L");
        m.add("vivo Y37");
        m.add("vivo X5Pro V");
        m.add("vivo X6D");
        m.add("vivo X6Plus D");
        m.add("vivo X6L");
        m.add("vivo X7");
        m.add("OPPO A37m");
        m.add("OPPO A59m");
        m.add("OPPO A59s");
        m.add("OPPO R9m");
        m.add("OPPO R9tm");
        m.add("OPPO R9km");
        m.add("2013022");
        m.add("HUAWEI VNS-AL00");
        m.add("HUAWEI G629-UL00");
        m.add("Lenovo A606");
        m.add("Lenovo Z2");
        m.add("ALE-TL00");
        m.add("ALE-UL00");
        m.add("BLN-AL10");
        m.add("Che-UL00");
        m.add("CHE_TL00");
        m.add("CK2-01");
        m.add("EVA-AL10");
        m.add("NX506J");
        m.add("NEM-AL10");
        m.add("VIE-AL10");
        m.add("m2 note");
        m.add("HTC E9t");
        m.add("MHA-AL00");
        m.add("Redmi 3S");
        m.add("Redmi 3X");
        r.add("HMA-AL00");
        r.add("ELE-AL00");
        r.add("ELE-TL00");
        r.add("VOG-AL10");
        r.add("VOG-AL00");
        r.add("PAFM00");
    }

    private CyberCfgManager() {
    }

    private static int a(Map<String, String> map, String str, int i2) {
        if (map != null) {
            String str2 = map.get(str);
            if (TextUtils.isEmpty(str2)) {
                return i2;
            }
            try {
                return Integer.parseInt(str2);
            } catch (Exception e) {
                return i2;
            }
        }
        return i2;
    }

    private static long a(Map<String, String> map, String str, long j2) {
        if (map != null) {
            try {
                return Long.parseLong(map.get(str));
            } catch (Exception e) {
                return j2;
            }
        }
        return j2;
    }

    private static String a(Map<String, String> map, String str, String str2) {
        if (map != null) {
            String str3 = map.get(str);
            if (!TextUtils.isEmpty(str3)) {
                return str3;
            }
        }
        return str2;
    }

    private boolean a(Map<String, String> map) {
        String a2 = a(map, "release_key", "");
        return !TextUtils.isEmpty(a2) && a2.equalsIgnoreCase(this.e);
    }

    private static boolean a(Map<String, String> map, String str, boolean z) {
        return a(map, str, z ? 1 : 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.d.clear();
        d();
        c();
        e();
        f();
        synchronized (this) {
            this.c.clear();
            this.c.putAll(this.d);
        }
    }

    private void b(String str, String str2) {
        if (a(this.d, str, -1) == -1) {
            String a2 = a(this.d, str2, "");
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            this.d.put(str, Integer.toString(CfgItemParser.versionMatchCheck(a2, SDKVersion.VERSION).booleanValue() ? 1 : 0));
        }
    }

    private void b(Map<String, String> map) {
        int a2 = a(map, "log_level", -1);
        if (a2 != -1) {
            CyberLog.a(a2);
        }
    }

    private void c() {
        this.k = n.b() + File.separator + "config";
        Map<String, String> a2 = a.a(this.k + File.separator + "cybermedia.pro");
        if (a2 != null) {
            this.d.putAll(a2);
        }
    }

    private void d() {
        try {
            for (Map.Entry<String, String> entry : CyberPlayerManager.getInstallOpts().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key.startsWith(CyberPlayerManager.INSTALL_OPT_ABTEST_SWITCH_START_CODE)) {
                    CyberLog.d("CyberCfgManager", "ABTest key:" + key + " value:" + value);
                    Map<String, String> c = n.c(value);
                    if (c != null) {
                        this.d.putAll(c);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private void e() {
        Map<String, String> a2;
        try {
            if (f1801b != null) {
                this.l = n.a(f1801b);
            }
            if (TextUtils.isEmpty(this.l) || (a2 = a.a(this.l + File.separator + "cybermedia.pro")) == null) {
                return;
            }
            b(a2);
            if (a(a2)) {
                this.d.putAll(a2);
            }
        } catch (Exception e) {
        }
    }

    private void f() {
        b(KEY_INT_ENABLE_PREFETCH, "pre_download_ver");
        b(KEY_INT_ENABLE_FILE_CACHE, "file_cache_ver");
        b("enable_update_core", "update_core_sdk_ver");
        h();
        i();
        j();
        k();
        l();
        this.d.put(KEY_INT_ENABLE_HW_DECODE, Integer.toString(n() ? 0 : 1));
    }

    private void g() {
        if (c.a().e() && n.m()) {
            setPrefLong("last_update_cloud_cfg_time", System.currentTimeMillis());
            CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.config.CyberCfgManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String d = c.a().d();
                        Properties properties = new Properties();
                        n.b(CyberCfgManager.this.k);
                        File file = new File(CyberCfgManager.this.k, "cybermedia.pro");
                        if (!file.exists() || !file.isFile()) {
                            file.createNewFile();
                        }
                        File file2 = new File(CyberCfgManager.this.k, "cybermedia.pro.tmp");
                        if (!file2.exists() || !file2.isFile()) {
                            file2.createNewFile();
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("url", d);
                        byte[] a2 = b.a(hashMap);
                        String a3 = n.a(a2);
                        String a4 = n.a(a2, new String(Base64.decode("SFIyRVI=".getBytes(), 0)));
                        if (a4 != null) {
                            Map<String, String> c = n.c(a4);
                            if (c != null) {
                                FileWriter fileWriter = new FileWriter(file2.getAbsolutePath());
                                for (Map.Entry<String, String> entry : c.entrySet()) {
                                    properties.setProperty(entry.getKey(), entry.getValue());
                                    CyberLog.d("CyberCfgManager", "update cloud cfg key:" + entry.getKey() + " value:" + entry.getValue());
                                }
                                properties.store(fileWriter, IMTrack.DbBuilder.ACTION_UPDATE);
                                fileWriter.close();
                            }
                            if (!file2.renameTo(file) || TextUtils.isEmpty(a3) || a3.equals(CyberCfgManager.this.getPrefStr("cloud_cfg_data_md5", ""))) {
                                return;
                            }
                            CyberCfgManager.this.setPrefStr("cloud_cfg_data_md5", a3);
                            CyberCfgManager.this.b();
                            d.h();
                            CyberLog.d("CyberCfgManager", "updateCloudCfgProFile success!");
                        }
                    } catch (Exception e) {
                    }
                }
            });
        }
    }

    @Keep
    public static CyberCfgManager getInstance() {
        if (f1801b == null) {
            f1801b = CyberPlayerManager.getApplicationContext();
        }
        return g;
    }

    private void h() {
        if (a(this.d, "enable_upload_session_log", -1) == -1) {
            String a2 = a(this.d, "upload_session_log_ver", "");
            if (!TextUtils.isEmpty(a2) && !CfgItemParser.versionMatchCheck(a2, SDKVersion.VERSION).booleanValue()) {
                this.d.put("enable_upload_session_log", Integer.toString(0));
                return;
            }
            if (new Random().nextInt(10000) + 1 <= a(this.d, VideoCloudSetting.PREF_KEY_SESSION_LOG_COLLECT_PERCENT, 10000)) {
                this.d.put("enable_upload_session_log", Integer.toString(1));
            } else {
                this.d.put("enable_upload_session_log", Integer.toString(0));
            }
        }
    }

    private void i() {
        String[] split;
        String a2 = a(this.d, "update_core_info", "");
        if (TextUtils.isEmpty(a2) || (split = a2.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) == null || split.length != 2 || !CfgItemParser.versionMatchCheck(split[0], SDKVersion.VERSION).booleanValue()) {
            return;
        }
        this.d.put("update_core_ver", split[1]);
    }

    private void j() {
        String a2 = a(this.d, "decode_mode_for_rom", "");
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        try {
            String[] split = a2.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            if (split == null || split.length != 2) {
                return;
            }
            for (String str : split[0].split(",")) {
                if (Integer.parseInt(str) == Build.VERSION.SDK_INT) {
                    this.d.put("decode_mode", split[1]);
                    return;
                }
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        r7.d.put("remote_forbidden", r2[1]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k() {
        String a2 = a(this.d, "remote_forbidden_by_rom", "16,17,18,19,20;1");
        if (!TextUtils.isEmpty(a2)) {
            try {
                String[] split = a2.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                if (split != null && split.length == 2) {
                    String[] split2 = split[0].split(",");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= split2.length) {
                            break;
                        } else if (Integer.parseInt(split2[i2]) == Build.VERSION.SDK_INT) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        if (a(this.d, "remote_forbidden", false) || !o()) {
            return;
        }
        this.d.put("remote_forbidden", Integer.toString(1));
    }

    private void l() {
        String prefStr = getPrefStr(SR_REMAINING_INFO, null);
        if (!TextUtils.isEmpty(prefStr)) {
            String[] split = prefStr.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            if (split.length == 2) {
                this.d.put("sr_last_run_time", split[0]);
                this.d.put("sr_remaining_nb", split[1]);
            }
        }
        if (a(this.d, KEY_INT_ENABLE_SR, true)) {
            this.d.put(KEY_INT_ENABLE_SR, Integer.toString(m() ? 1 : 0));
        }
    }

    private boolean m() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        if (CfgItemParser.a(q, r)) {
            return true;
        }
        String a2 = a(this.d, "white_devices_for_sr", "");
        CyberLog.i("CyberCfgManager", "value : " + a2);
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
        if (Build.VERSION.SDK_INT >= 16 && !CfgItemParser.a(f1800a, m)) {
            String a2 = a(this.d, "black_devices_for_hw", "");
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

    private boolean o() {
        if (CfgItemParser.a(o, p)) {
            return true;
        }
        String a2 = a(this.d, "remote_blacklist", "");
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

    public String a(String str) {
        String packageName = f1801b.getPackageName();
        String str2 = (str + File.separator + "videoconfig") + "?cmd=1&";
        StringBuilder sb = new StringBuilder();
        n.a(sb, "package_name", packageName);
        n.a(sb, "sdk_ver", SDKVersion.VERSION);
        if (!TextUtils.isEmpty(this.f)) {
            n.a(sb, "appid", this.f);
        }
        try {
            PackageManager packageManager = f1801b.getPackageManager();
            if (packageManager != null) {
                n.a(sb, "appversion", packageManager.getPackageInfo(packageName, 0).versionName);
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        n.a(sb, ETAG.KEY_DEV_VER, Build.VERSION.SDK_INT);
        n.a(sb, "net_type", DpNetworkUtils.getNetworkStatisticsData(f1801b));
        try {
            n.a(sb, "model", new String(Base64.encode(Build.MODEL.getBytes(), 0)));
        } catch (Throwable th) {
            CyberLog.e("CyberCfgManager", "model exception ", th);
        }
        return str2 + sb.toString();
    }

    public String a(String str, String str2) {
        return a(this.c, str, str2);
    }

    public synchronized void a() {
        if (h) {
            if (i) {
                if (System.currentTimeMillis() - getPrefLong("last_update_cloud_cfg_time", -1L) > j) {
                    g();
                }
            } else {
                g();
                i = true;
            }
        }
    }

    public boolean a(String str, boolean z) {
        return a(this.c, str, z ? 1 : 0) == 1;
    }

    @Keep
    public synchronized boolean getCfgBoolValue(String str, boolean z) {
        boolean z2;
        synchronized (this) {
            z2 = a(this.c, str, z ? 1 : 0) == 1;
        }
        return z2;
    }

    @Keep
    public synchronized int getCfgIntValue(String str, int i2) {
        return a(this.c, str, i2);
    }

    @Keep
    public synchronized long getCfgLongValue(String str, long j2) {
        return a(this.c, str, j2);
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

    @Keep
    public synchronized String getCfgValue(String str, String str2) {
        return a(this.c, str, str2);
    }

    @Keep
    public synchronized long getPrefLong(String str, long j2) {
        if (f1801b != null) {
            j2 = f1801b.getSharedPreferences("video_cfg", 0).getLong(str, j2);
        }
        return j2;
    }

    @Keep
    public synchronized String getPrefStr(String str, String str2) {
        if (f1801b != null) {
            str2 = f1801b.getSharedPreferences("video_cfg", 0).getString(str, str2);
        }
        return str2;
    }

    @Keep
    public synchronized void init() {
        if (!h) {
            this.e = CyberPlayerManager.getClientID();
            this.f = CyberPlayerManager.getAppID();
            b();
            h = true;
        }
    }

    @Keep
    public synchronized boolean isBlackUrl(String str) {
        boolean z = true;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && !CfgItemParser.a(str, n)) {
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
    public synchronized void setPrefLong(String str, long j2) {
        if (f1801b != null) {
            SharedPreferences.Editor edit = f1801b.getSharedPreferences("video_cfg", 0).edit();
            edit.putLong(str, j2);
            edit.commit();
        }
    }

    @Keep
    public synchronized void setPrefStr(String str, String str2) {
        if (f1801b != null) {
            SharedPreferences.Editor edit = f1801b.getSharedPreferences("video_cfg", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }
}
