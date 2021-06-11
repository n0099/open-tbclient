package com.baidu.cyberplayer.sdk.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.c;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.cyberplayer.sdk.statistics.DpNetworkUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.VideoCloudSetting;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
    public static final String KEY_INT_ENABLE_DLNA = "enable_dlna";
    @Keep
    public static final String KEY_INT_ENABLE_DMO = "enable_dmo";
    @Keep
    public static final String KEY_INT_ENABLE_DMR = "enable_decode_mode_random";
    @Keep
    public static final String KEY_INT_ENABLE_FILE_CACHE = "enable_file_cache";
    @Keep
    public static final String KEY_INT_ENABLE_HW_DECODE = "enable_hw_decode";
    @Keep
    public static final String KEY_INT_ENABLE_MEDIACODEC_REUSE = "enable_mediacodec_reuse";
    @Keep
    public static final String KEY_INT_ENABLE_MONITOR = "enable_monitor";
    @Keep
    public static final String KEY_INT_ENABLE_MULTI_INSTANCE = "enable_multi_instance";
    @Keep
    public static final String KEY_INT_ENABLE_PLAYER_SERVER = "enable_player_policy";
    @Keep
    public static final String KEY_INT_ENABLE_PLAY_SCORE_MONITOR = "enable_play_score_monitor";
    @Keep
    public static final String KEY_INT_ENABLE_PREFETCH = "enable_prefetch";
    @Keep
    public static final String KEY_INT_ENABLE_RTC = "enable_rtc";
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
    public static final String LAST_CHECK_UNUSED_LIBS_TIME = "last_check_unused_libs_time";
    @Keep
    public static final String SP_KEY_UPDATE_TYPE = "update_type";
    @Keep
    public static final String SP_KEY_UPDATE_VERSION = "update_version";
    @Keep
    public static final String SR_REMAINING_INFO = "sr_remaining_info";

    /* renamed from: b  reason: collision with root package name */
    public static Context f4791b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f4795c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f4796d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public String f4797e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f4798f = null;
    public String k;
    public String l;

    /* renamed from: g  reason: collision with root package name */
    public static CyberCfgManager f4792g = new CyberCfgManager();

    /* renamed from: h  reason: collision with root package name */
    public static volatile boolean f4793h = false;

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f4794i = false;
    public static int j = 86400000;

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<String> f4790a = new ArrayList<>();
    public static ArrayList<String> m = new ArrayList<>();
    public static ArrayList<String> n = new ArrayList<>();
    public static ArrayList<String> o = new ArrayList<>();
    public static ArrayList<String> p = new ArrayList<>();
    public static ArrayList<String> q = new ArrayList<>();
    public static ArrayList<String> r = new ArrayList<>();

    static {
        f4790a.add("hwH60");
        f4790a.add("hwp7");
        f4790a.add("sp8830ec");
        f4790a.add("Hisense M30T");
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

    public static int a(Map<String, String> map, String str, int i2) {
        if (map != null) {
            String str2 = map.get(str);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    return Integer.parseInt(str2);
                } catch (Exception unused) {
                }
            }
        }
        return i2;
    }

    public static long a(Map<String, String> map, String str, long j2) {
        if (map != null) {
            try {
                return Long.parseLong(map.get(str));
            } catch (Exception unused) {
            }
        }
        return j2;
    }

    public static String a(Map<String, String> map, String str, String str2) {
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
        return !TextUtils.isEmpty(a2) && a2.equalsIgnoreCase(this.f4797e);
    }

    public static boolean a(Map<String, String> map, String str, boolean z) {
        return a(map, str, z ? 1 : 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f4796d.clear();
        d();
        c();
        e();
        f();
        synchronized (this) {
            this.f4795c.clear();
            this.f4795c.putAll(this.f4796d);
        }
    }

    private void b(String str, String str2) {
        if (o.m()) {
            setPrefStr("update_type_black", str);
            setPrefStr("update_version_black", str2);
        }
    }

    private void b(Map<String, String> map) {
        int a2 = a(map, "log_level", -1);
        if (a2 != -1) {
            CyberLog.a(a2);
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return "7.26.2".equals(str.substring(0, str.lastIndexOf(".")));
        } catch (Exception unused) {
            return false;
        }
    }

    private void c() {
        this.k = o.b() + File.separator + "config";
        Map<String, String> a2 = b.a(this.k + File.separator + "cybermedia.pro");
        if (a2 != null) {
            this.f4796d.putAll(a2);
        }
    }

    private void c(String str, String str2) {
        if (a(this.f4796d, str, -1) == -1) {
            String a2 = a(this.f4796d, str2, "");
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            this.f4796d.put(str, Integer.toString(a.a(a2, SDKVersion.VERSION).booleanValue() ? 1 : 0));
        }
    }

    @Keep
    public static int compareVersion(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.equals(str2)) {
                return 0;
            }
            try {
                String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                if (split != null && split2 != null) {
                    int min = Math.min(split.length, split2.length);
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < min) {
                        i3 = Integer.parseInt(split[i2]) - Integer.parseInt(split2[i2]);
                        if (i3 != 0) {
                            break;
                        }
                        i2++;
                    }
                    if (i3 != 0) {
                        return i3 > 0 ? 1 : -1;
                    }
                    for (int i4 = i2; i4 < split.length; i4++) {
                        if (Integer.parseInt(split[i4]) > 0) {
                            return 1;
                        }
                    }
                    while (i2 < split2.length) {
                        if (Integer.parseInt(split2[i2]) > 0) {
                            return -1;
                        }
                        i2++;
                    }
                    return 0;
                }
                return -2;
            } catch (Exception unused) {
                CyberLog.e("CyberCfgManager", "compareVersion exception, version1=" + str + " version2=" + str2);
            }
        }
        return -2;
    }

    private void d() {
        try {
            for (Map.Entry<String, String> entry : CyberPlayerManager.getInstallOpts().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key.startsWith(CyberPlayerManager.INSTALL_OPT_ABTEST_SWITCH_START_CODE)) {
                    CyberLog.d("CyberCfgManager", "ABTest key:" + key + " value:" + value);
                    Map<String, String> c2 = o.c(value);
                    if (c2 != null) {
                        this.f4796d.putAll(c2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void e() {
        try {
            if (f4791b != null) {
                this.l = o.a(f4791b);
            }
            if (TextUtils.isEmpty(this.l)) {
                return;
            }
            Map<String, String> a2 = b.a(this.l + File.separator + "cybermedia.pro");
            if (a2 != null) {
                b(a2);
                if (a(a2)) {
                    this.f4796d.putAll(a2);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void f() {
        c(KEY_INT_ENABLE_PREFETCH, "pre_download_ver");
        c(KEY_INT_ENABLE_FILE_CACHE, "file_cache_ver");
        c("enable_update_core", "update_core_sdk_ver");
        i();
        j();
        l();
        m();
        n();
        k();
        this.f4796d.put(KEY_INT_ENABLE_HW_DECODE, Integer.toString(!p()));
    }

    private void g() {
        if (o.m()) {
            removePref("install_error_count");
            removePref(SP_KEY_UPDATE_TYPE);
            removePref("update_version");
            removePref("update_type_black");
            removePref("update_version_black");
        }
    }

    @Keep
    public static CyberCfgManager getInstance() {
        if (f4791b == null) {
            f4791b = CyberPlayerManager.getApplicationContext();
        }
        return f4792g;
    }

    private void h() {
        if (c.a().g() && o.m()) {
            setPrefLong("last_update_cloud_cfg_time", System.currentTimeMillis());
            CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.config.CyberCfgManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String f2 = c.a().f();
                        Properties properties = new Properties();
                        o.b(CyberCfgManager.this.k);
                        File file = new File(CyberCfgManager.this.k, "cybermedia.pro");
                        if (!file.exists() || !file.isFile()) {
                            file.createNewFile();
                        }
                        File file2 = new File(CyberCfgManager.this.k, "cybermedia.pro.tmp");
                        if (!file2.exists() || !file2.isFile()) {
                            file2.createNewFile();
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("url", f2);
                        byte[] a2 = com.baidu.cyberplayer.sdk.downloader.b.a(hashMap);
                        String a3 = o.a(a2);
                        String a4 = o.a(a2, new String(Base64.decode(WebSettingsGlobalBlink.DEFAULT_SECRECT_KEY.getBytes(), 0)));
                        if (a4 != null) {
                            Map<String, String> c2 = o.c(a4);
                            if (c2 != null) {
                                FileWriter fileWriter = new FileWriter(file2.getAbsolutePath());
                                for (Map.Entry<String, String> entry : c2.entrySet()) {
                                    properties.setProperty(entry.getKey(), entry.getValue());
                                    CyberLog.d("CyberCfgManager", "update cloud cfg key:" + entry.getKey() + " value:" + entry.getValue());
                                }
                                properties.store(fileWriter, IMTrack.DbBuilder.ACTION_UPDATE);
                                fileWriter.close();
                            }
                            if (file2.renameTo(file) && !TextUtils.isEmpty(a3) && !a3.equals(CyberCfgManager.this.getPrefStr("cloud_cfg_data_md5", ""))) {
                                CyberCfgManager.this.setPrefStr("cloud_cfg_data_md5", a3);
                                CyberCfgManager.this.b();
                                d.h();
                                CyberLog.d("CyberCfgManager", "updateCloudCfgProFile success!");
                            }
                        }
                        if (CyberCfgManager.this.getCfgBoolValue("delete_unuse_files", true)) {
                            o.a(o.b() + File.separator + "cyberplayer");
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    private void i() {
        Map<String, String> map;
        String num;
        if (a(this.f4796d, "enable_upload_session_log", -1) == -1) {
            String a2 = a(this.f4796d, "upload_session_log_ver", "");
            if (TextUtils.isEmpty(a2) || a.a(a2, SDKVersion.VERSION).booleanValue()) {
                if (new Random().nextInt(10000) + 1 <= a(this.f4796d, VideoCloudSetting.PREF_KEY_SESSION_LOG_COLLECT_PERCENT, 10000)) {
                    map = this.f4796d;
                    num = Integer.toString(1);
                    map.put("enable_upload_session_log", num);
                }
            }
            map = this.f4796d;
            num = Integer.toString(0);
            map.put("enable_upload_session_log", num);
        }
    }

    private void j() {
        String[] split;
        String a2 = a(this.f4796d, "update_core_info", "");
        if (!TextUtils.isEmpty(a2) && (split = a2.split(";")) != null && split.length == 3 && a.a(split[0], SDKVersion.VERSION).booleanValue() && b(split[1]) && isAllowUpdate("cyber-media-dex", split[1], SDKVersion.VERSION)) {
            this.f4796d.put("update_core_ver", keepMainProcessVersion("cyber-media-dex", split[1]));
            this.f4796d.put("update_core_enable_downgrade", split[2]);
        }
    }

    private void k() {
        String[] split;
        String a2 = a(this.f4796d, "update_lib_info", "");
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(a2);
            if (jSONObject.length() == 1) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string) && (split = string.split(";")) != null && split.length == 3 && a.a(split[0], SDKVersion.VERSION).booleanValue()) {
                        this.f4796d.put(next, string);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Keep
    public static String keepMainProcessVersion(String str, String str2) {
        Map<String, String> installOpts;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (o.m() || (installOpts = CyberPlayerManager.getInstallOpts()) == null) {
            return str2;
        }
        String str3 = installOpts.get(str);
        return (TextUtils.isEmpty(str3) || str3.equals("0.0.0.0") || str3.equals(str2)) ? str2 : str3;
    }

    private void l() {
        String a2 = a(this.f4796d, "decode_mode_for_rom", "");
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        try {
            String[] split = a2.split(";");
            if (split == null || split.length != 2) {
                return;
            }
            for (String str : split[0].split(",")) {
                if (Integer.parseInt(str) == Build.VERSION.SDK_INT) {
                    this.f4796d.put("decode_mode", split[1]);
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        r8.f4796d.put("remote_forbidden", r0[1]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m() {
        String a2 = a(this.f4796d, "remote_forbidden_by_rom", "16,17,18,19,20;1");
        if (!TextUtils.isEmpty(a2)) {
            try {
                String[] split = a2.split(";");
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
            } catch (Exception unused) {
            }
        }
        if (a(this.f4796d, "remote_forbidden", false) || !q()) {
            return;
        }
        this.f4796d.put("remote_forbidden", Integer.toString(1));
    }

    private void n() {
        String prefStr = getPrefStr(SR_REMAINING_INFO, null);
        if (!TextUtils.isEmpty(prefStr)) {
            String[] split = prefStr.split(";");
            if (split.length == 2) {
                this.f4796d.put("sr_last_run_time", split[0]);
                this.f4796d.put("sr_remaining_nb", split[1]);
            }
        }
        if (a(this.f4796d, KEY_INT_ENABLE_SR, true)) {
            this.f4796d.put(KEY_INT_ENABLE_SR, Integer.toString(o() ? 1 : 0));
        }
    }

    private boolean o() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        if (a.a(q, r)) {
            return true;
        }
        String a2 = a(this.f4796d, "white_devices_for_sr", "");
        CyberLog.i("CyberCfgManager", "value : " + a2);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        String[] split = a2.split(";");
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            arrayList.add(str);
        }
        return a.a(arrayList, arrayList);
    }

    private boolean p() {
        if (Build.VERSION.SDK_INT >= 16 && !a.a(f4790a, m)) {
            String a2 = a(this.f4796d, "black_devices_for_hw", "");
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            String[] split = a2.split(";");
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                arrayList.add(str);
            }
            return a.a(arrayList, arrayList);
        }
        return true;
    }

    private boolean q() {
        if (a.a(o, p)) {
            return true;
        }
        String a2 = a(this.f4796d, "remote_blacklist", "");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        String[] split = a2.split(";");
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            arrayList.add(str);
        }
        return a.a(arrayList, arrayList);
    }

    public String a(String str) {
        String packageName = f4791b.getPackageName();
        String str2 = (str + File.separator + "videoconfig") + "?cmd=1&";
        StringBuilder sb = new StringBuilder();
        o.a(sb, "package_name", packageName);
        o.a(sb, "sdk_ver", SDKVersion.VERSION);
        if (!TextUtils.isEmpty(this.f4798f)) {
            o.a(sb, "appid", this.f4798f);
        }
        try {
            PackageManager packageManager = f4791b.getPackageManager();
            if (packageManager != null) {
                o.a(sb, "appversion", packageManager.getPackageInfo(packageName, 0).versionName);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        o.a(sb, ETAG.KEY_DEV_VER, Build.VERSION.SDK_INT);
        o.a(sb, "net_type", DpNetworkUtils.getNetworkStatisticsData(f4791b));
        try {
            o.a(sb, "model", new String(Base64.encode(Build.MODEL.getBytes(), 0)));
        } catch (Throwable th) {
            CyberLog.e("CyberCfgManager", "model exception ", th);
        }
        return str2 + sb.toString();
    }

    public String a(String str, String str2) {
        return a(this.f4795c, str, str2);
    }

    public synchronized void a() {
        if (f4793h) {
            if (f4794i) {
                if (System.currentTimeMillis() - getPrefLong("last_update_cloud_cfg_time", -1L) > j) {
                    h();
                }
            } else {
                h();
                f4794i = true;
            }
        }
    }

    public boolean a(String str, boolean z) {
        return a(this.f4795c, str, z ? 1 : 0) == 1;
    }

    @Keep
    public synchronized boolean getCfgBoolValue(String str, boolean z) {
        return a(this.f4795c, str, z ? 1 : 0) == 1;
    }

    @Keep
    public synchronized int getCfgIntValue(String str, int i2) {
        return a(this.f4795c, str, i2);
    }

    @Keep
    public synchronized long getCfgLongValue(String str, long j2) {
        return a(this.f4795c, str, j2);
    }

    @Keep
    public synchronized Map<String, String> getCfgMap() {
        HashMap hashMap;
        HashMap hashMap2 = null;
        try {
            hashMap = new HashMap();
            try {
                hashMap.putAll(this.f4795c);
            } catch (Exception unused) {
                hashMap2 = hashMap;
                hashMap = hashMap2;
                return hashMap;
            }
        } catch (Exception unused2) {
        }
        return hashMap;
    }

    @Keep
    public synchronized String getCfgValue(String str, String str2) {
        return a(this.f4795c, str, str2);
    }

    @Keep
    public synchronized int getPrefInt(String str, int i2) {
        if (f4791b != null) {
            i2 = f4791b.getSharedPreferences("video_cfg", 0).getInt(str, i2);
        }
        return i2;
    }

    @Keep
    public synchronized long getPrefLong(String str, long j2) {
        if (f4791b != null) {
            j2 = f4791b.getSharedPreferences("video_cfg", 0).getLong(str, j2);
        }
        return j2;
    }

    @Keep
    public synchronized String getPrefStr(String str, String str2) {
        if (f4791b != null) {
            str2 = f4791b.getSharedPreferences("video_cfg", 0).getString(str, str2);
        }
        return str2;
    }

    @Keep
    public synchronized void init() {
        if (!f4793h) {
            this.f4797e = CyberPlayerManager.getClientID();
            this.f4798f = CyberPlayerManager.getAppID();
            b();
            f4793h = true;
        }
    }

    @Keep
    public boolean isAllowUpdate(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        if ((str.equals(getPrefStr("update_type_black", "")) && str2.equals(getPrefStr("update_version_black", ""))) || compareVersion(str2, str3) == -1) {
            return false;
        }
        int prefInt = getPrefInt("install_error_count", 1);
        String prefStr = getPrefStr("update_version", "");
        String prefStr2 = getPrefStr(SP_KEY_UPDATE_TYPE, "");
        CyberLog.i("CyberCfgManager", "installErrorCount=" + prefInt + " prefUpdateVersion=" + prefStr + " prefUpdateType=" + prefStr2);
        if (!str.equals(prefStr2)) {
            g();
            return true;
        } else if (str2.equals(prefStr)) {
            if (prefInt < 3) {
                return prefInt < 3;
            }
            b(str, str2);
            return false;
        } else if (compareVersion(prefStr, str2) == -1 || compareVersion(prefStr, str3) == -1) {
            g();
            return true;
        } else {
            return false;
        }
    }

    @Keep
    public synchronized boolean isBlackUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (a.a(str, n)) {
            return true;
        }
        String a2 = a(this.f4795c, "black_url_list_for_file_cache", "");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        String[] split = a2.split(";");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            arrayList.add(str2);
        }
        return a.a(str, arrayList);
    }

    @Keep
    public synchronized void removePref(String str) {
        if (f4791b != null) {
            SharedPreferences.Editor edit = f4791b.getSharedPreferences("video_cfg", 0).edit();
            edit.remove(str);
            edit.commit();
        }
    }

    @Keep
    public synchronized void setPrefInt(String str, int i2) {
        if (f4791b != null) {
            SharedPreferences.Editor edit = f4791b.getSharedPreferences("video_cfg", 0).edit();
            edit.putInt(str, i2);
            edit.commit();
        }
    }

    @Keep
    public synchronized void setPrefLong(String str, long j2) {
        if (f4791b != null) {
            SharedPreferences.Editor edit = f4791b.getSharedPreferences("video_cfg", 0).edit();
            edit.putLong(str, j2);
            edit.commit();
        }
    }

    @Keep
    public synchronized void setPrefStr(String str, String str2) {
        if (f4791b != null) {
            SharedPreferences.Editor edit = f4791b.getSharedPreferences("video_cfg", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }
}
