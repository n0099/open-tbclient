package com.baidu.cyberplayer.sdk.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
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
    public static /* synthetic */ Interceptable $ic = null;
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
    public static ArrayList<String> a;
    public static Context b;
    public static CyberCfgManager g;
    public static volatile boolean h;
    public static volatile boolean i;
    public static int j;
    public static ArrayList<String> m;
    public static ArrayList<String> n;
    public static ArrayList<String> o;
    public static ArrayList<String> p;
    public static ArrayList<String> q;
    public static ArrayList<String> r;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> c;
    public Map<String, String> d;
    public String e;
    public String f;
    public String k;
    public String l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2141281746, "Lcom/baidu/cyberplayer/sdk/config/CyberCfgManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2141281746, "Lcom/baidu/cyberplayer/sdk/config/CyberCfgManager;");
                return;
            }
        }
        g = new CyberCfgManager();
        h = false;
        i = false;
        j = 86400000;
        a = new ArrayList<>();
        m = new ArrayList<>();
        n = new ArrayList<>();
        o = new ArrayList<>();
        p = new ArrayList<>();
        q = new ArrayList<>();
        r = new ArrayList<>();
        a.add("hwH60");
        a.add("hwp7");
        a.add("sp8830ec");
        a.add("Hisense M30T");
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

    public CyberCfgManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = null;
        this.f = null;
    }

    public static int a(Map<String, String> map, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, map, str, i2)) == null) {
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
        return invokeLLI.intValue;
    }

    public static long a(Map<String, String> map, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{map, str, Long.valueOf(j2)})) == null) {
            if (map != null) {
                try {
                    return Long.parseLong(map.get(str));
                } catch (Exception unused) {
                }
            }
            return j2;
        }
        return invokeCommon.longValue;
    }

    public static String a(Map<String, String> map, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, map, str, str2)) == null) {
            if (map != null) {
                String str3 = map.get(str);
                if (!TextUtils.isEmpty(str3)) {
                    return str3;
                }
            }
            return str2;
        }
        return (String) invokeLLL.objValue;
    }

    private boolean a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, map)) == null) {
            String a2 = a(map, "release_key", "");
            return !TextUtils.isEmpty(a2) && a2.equalsIgnoreCase(this.e);
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Map<String, String> map, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65543, null, map, str, z)) == null) ? a(map, str, z ? 1 : 0) == 1 : invokeLLZ.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
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
    }

    private void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, this, str, str2) == null) && o.m()) {
            setPrefStr("update_type_black", str);
            setPrefStr("update_version_black", str2);
        }
    }

    private void b(Map<String, String> map) {
        int a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, map) == null) || (a2 = a(map, "log_level", -1)) == -1) {
            return;
        }
        CyberLog.a(a2);
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return "7.32.10".equals(str.substring(0, str.lastIndexOf(".")));
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.k = o.b() + File.separator + "config";
            Map<String, String> a2 = b.a(this.k + File.separator + "cybermedia.pro");
            if (a2 != null) {
                this.d.putAll(a2);
            }
        }
    }

    private void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65550, this, str, str2) == null) && a(this.d, str, -1) == -1) {
            String a2 = a(this.d, str2, "");
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            this.d.put(str, Integer.toString(a.a(a2, SDKVersion.VERSION).booleanValue() ? 1 : 0));
        }
    }

    @Keep
    public static int compareVersion(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, str2)) == null) {
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
        return invokeLL.intValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            try {
                for (Map.Entry<String, String> entry : CyberPlayerManager.getInstallOpts().entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (key.startsWith(CyberPlayerManager.INSTALL_OPT_ABTEST_SWITCH_START_CODE)) {
                        CyberLog.d("CyberCfgManager", "ABTest key:" + key + " value:" + value);
                        Map<String, String> c = o.c(value);
                        if (c != null) {
                            this.d.putAll(c);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            try {
                if (b != null) {
                    this.l = o.a(b);
                }
                if (TextUtils.isEmpty(this.l)) {
                    return;
                }
                Map<String, String> a2 = b.a(this.l + File.separator + "cybermedia.pro");
                if (a2 != null) {
                    b(a2);
                    if (a(a2)) {
                        this.d.putAll(a2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            c(KEY_INT_ENABLE_PREFETCH, "pre_download_ver");
            c(KEY_INT_ENABLE_FILE_CACHE, "file_cache_ver");
            c("enable_update_core", "update_core_sdk_ver");
            i();
            j();
            l();
            m();
            n();
            k();
            this.d.put(KEY_INT_ENABLE_HW_DECODE, Integer.toString(!p()));
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && o.m()) {
            removePref("install_error_count");
            removePref(SP_KEY_UPDATE_TYPE);
            removePref("update_version");
            removePref("update_type_black");
            removePref("update_version_black");
        }
    }

    @Keep
    public static CyberCfgManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (b == null) {
                b = CyberPlayerManager.getApplicationContext();
            }
            return g;
        }
        return (CyberCfgManager) invokeV.objValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && c.a().g() && o.m()) {
            setPrefLong("last_update_cloud_cfg_time", System.currentTimeMillis());
            CyberTaskExcutor.getInstance().execute(new Runnable(this) { // from class: com.baidu.cyberplayer.sdk.config.CyberCfgManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CyberCfgManager a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            String f = c.a().f();
                            Properties properties = new Properties();
                            o.b(this.a.k);
                            File file = new File(this.a.k, "cybermedia.pro");
                            if (!file.exists() || !file.isFile()) {
                                file.createNewFile();
                            }
                            File file2 = new File(this.a.k, "cybermedia.pro.tmp");
                            if (!file2.exists() || !file2.isFile()) {
                                file2.createNewFile();
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("url", f);
                            byte[] a2 = com.baidu.cyberplayer.sdk.downloader.b.a(hashMap);
                            String a3 = o.a(a2);
                            String a4 = o.a(a2, new String(Base64.decode(WebSettingsGlobalBlink.DEFAULT_SECRECT_KEY.getBytes(), 0)));
                            if (a4 != null) {
                                Map<String, String> c = o.c(a4);
                                if (c != null) {
                                    FileWriter fileWriter = new FileWriter(file2.getAbsolutePath());
                                    for (Map.Entry<String, String> entry : c.entrySet()) {
                                        properties.setProperty(entry.getKey(), entry.getValue());
                                        CyberLog.d("CyberCfgManager", "update cloud cfg key:" + entry.getKey() + " value:" + entry.getValue());
                                    }
                                    properties.store(fileWriter, StickerDataChangeType.UPDATE);
                                    fileWriter.close();
                                }
                                if (file2.renameTo(file) && !TextUtils.isEmpty(a3) && !a3.equals(this.a.getPrefStr("cloud_cfg_data_md5", ""))) {
                                    this.a.setPrefStr("cloud_cfg_data_md5", a3);
                                    this.a.b();
                                    d.h();
                                    CyberLog.d("CyberCfgManager", "updateCloudCfgProFile success!");
                                }
                            }
                            if (this.a.getCfgBoolValue("delete_unuse_files", true)) {
                                o.a(o.b() + File.separator + "cyberplayer");
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    private void i() {
        Map<String, String> map;
        String num;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && a(this.d, "enable_upload_session_log", -1) == -1) {
            String a2 = a(this.d, "upload_session_log_ver", "");
            if (TextUtils.isEmpty(a2) || a.a(a2, SDKVersion.VERSION).booleanValue()) {
                if (new Random().nextInt(10000) + 1 <= a(this.d, VideoCloudSetting.PREF_KEY_SESSION_LOG_COLLECT_PERCENT, 10000)) {
                    map = this.d;
                    num = Integer.toString(1);
                    map.put("enable_upload_session_log", num);
                }
            }
            map = this.d;
            num = Integer.toString(0);
            map.put("enable_upload_session_log", num);
        }
    }

    private void j() {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            String a2 = a(this.d, "update_core_info", "");
            if (!TextUtils.isEmpty(a2) && (split = a2.split(";")) != null && split.length == 3 && a.a(split[0], SDKVersion.VERSION).booleanValue() && b(split[1]) && isAllowUpdate("cyber-media-dex", split[1], SDKVersion.VERSION)) {
                this.d.put("update_core_ver", keepMainProcessVersion("cyber-media-dex", split[1]));
                this.d.put("update_core_enable_downgrade", split[2]);
            }
        }
    }

    private void k() {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            String a2 = a(this.d, "update_lib_info", "");
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
                            this.d.put(next, string);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Keep
    public static String keepMainProcessVersion(String str, String str2) {
        InterceptResult invokeLL;
        Map<String, String> installOpts;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return "";
            }
            if (o.m() || (installOpts = CyberPlayerManager.getInstallOpts()) == null) {
                return str2;
            }
            String str3 = installOpts.get(str);
            return (TextUtils.isEmpty(str3) || str3.equals("0.0.0.0") || str3.equals(str2)) ? str2 : str3;
        }
        return (String) invokeLL.objValue;
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            String a2 = a(this.d, "decode_mode_for_rom", "");
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
                        this.d.put("decode_mode", split[1]);
                        return;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        r8.d.put("remote_forbidden", r0[1]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            String a2 = a(this.d, "remote_forbidden_by_rom", "16,17,18,19,20;1");
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
            if (a(this.d, "remote_forbidden", false) || !q()) {
                return;
            }
            this.d.put("remote_forbidden", Integer.toString(1));
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            String prefStr = getPrefStr(SR_REMAINING_INFO, null);
            if (!TextUtils.isEmpty(prefStr)) {
                String[] split = prefStr.split(";");
                if (split.length == 2) {
                    this.d.put("sr_last_run_time", split[0]);
                    this.d.put("sr_remaining_nb", split[1]);
                }
            }
            if (a(this.d, KEY_INT_ENABLE_SR, true)) {
                this.d.put(KEY_INT_ENABLE_SR, Integer.toString(o() ? 1 : 0));
            }
        }
    }

    private boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                return false;
            }
            if (a.a(q, r)) {
                return true;
            }
            String a2 = a(this.d, "white_devices_for_sr", "");
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
        return invokeV.booleanValue;
    }

    private boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) {
            if (Build.VERSION.SDK_INT >= 16 && !a.a(a, m)) {
                String a2 = a(this.d, "black_devices_for_hw", "");
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
        return invokeV.booleanValue;
    }

    private boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
            if (a.a(o, p)) {
                return true;
            }
            String a2 = a(this.d, "remote_blacklist", "");
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
        return invokeV.booleanValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String packageName = b.getPackageName();
            String str2 = (str + File.separator + "videoconfig") + "?cmd=1&";
            StringBuilder sb = new StringBuilder();
            o.a(sb, "package_name", packageName);
            o.a(sb, "sdk_ver", SDKVersion.VERSION);
            if (!TextUtils.isEmpty(this.f)) {
                o.a(sb, "appid", this.f);
            }
            try {
                PackageManager packageManager = b.getPackageManager();
                if (packageManager != null) {
                    o.a(sb, "appversion", packageManager.getPackageInfo(packageName, 0).versionName);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            o.a(sb, ETAG.KEY_DEV_VER, Build.VERSION.SDK_INT);
            o.a(sb, "net_type", DpNetworkUtils.getNetworkStatisticsData(b));
            try {
                o.a(sb, "model", new String(Base64.encode(Build.MODEL.getBytes(), 0)));
            } catch (Throwable th) {
                CyberLog.e("CyberCfgManager", "model exception ", th);
            }
            return str2 + sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? a(this.c, str, str2) : (String) invokeLL.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (h) {
                    if (i) {
                        if (System.currentTimeMillis() - getPrefLong("last_update_cloud_cfg_time", -1L) > j) {
                            h();
                        }
                    } else {
                        h();
                        i = true;
                    }
                }
            }
        }
    }

    public boolean a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) ? a(this.c, str, z ? 1 : 0) == 1 : invokeLZ.booleanValue;
    }

    @Keep
    public synchronized boolean getCfgBoolValue(String str, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            synchronized (this) {
                z2 = a(this.c, str, z ? 1 : 0) == 1;
            }
            return z2;
        }
        return invokeLZ.booleanValue;
    }

    @Keep
    public synchronized int getCfgIntValue(String str, int i2) {
        InterceptResult invokeLI;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            synchronized (this) {
                a2 = a(this.c, str, i2);
            }
            return a2;
        }
        return invokeLI.intValue;
    }

    @Keep
    public synchronized long getCfgLongValue(String str, long j2) {
        InterceptResult invokeLJ;
        long a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j2)) == null) {
            synchronized (this) {
                a2 = a(this.c, str, j2);
            }
            return a2;
        }
        return invokeLJ.longValue;
    }

    @Keep
    public synchronized Map<String, String> getCfgMap() {
        InterceptResult invokeV;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                HashMap hashMap2 = null;
                try {
                    hashMap = new HashMap();
                } catch (Exception unused) {
                }
                try {
                    hashMap.putAll(this.c);
                } catch (Exception unused2) {
                    hashMap2 = hashMap;
                    hashMap = hashMap2;
                    return hashMap;
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Keep
    public synchronized String getCfgValue(String str, String str2) {
        InterceptResult invokeLL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            synchronized (this) {
                a2 = a(this.c, str, str2);
            }
            return a2;
        }
        return (String) invokeLL.objValue;
    }

    @Keep
    public synchronized int getPrefInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i2)) == null) {
            synchronized (this) {
                if (b != null) {
                    i2 = b.getSharedPreferences("video_cfg", 0).getInt(str, i2);
                }
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    @Keep
    public synchronized long getPrefLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j2)) == null) {
            synchronized (this) {
                if (b != null) {
                    j2 = b.getSharedPreferences("video_cfg", 0).getLong(str, j2);
                }
            }
            return j2;
        }
        return invokeLJ.longValue;
    }

    @Keep
    public synchronized String getPrefStr(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            synchronized (this) {
                if (b != null) {
                    str2 = b.getSharedPreferences("video_cfg", 0).getString(str, str2);
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    @Keep
    public synchronized void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (!h) {
                    this.e = CyberPlayerManager.getClientID();
                    this.f = CyberPlayerManager.getAppID();
                    b();
                    h = true;
                }
            }
        }
    }

    @Keep
    public boolean isAllowUpdate(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, str, str2, str3)) == null) {
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
        return invokeLLL.booleanValue;
    }

    @Keep
    public synchronized boolean isBlackUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                if (a.a(str, n)) {
                    return true;
                }
                String a2 = a(this.c, "black_url_list_for_file_cache", "");
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
        }
        return invokeL.booleanValue;
    }

    @Keep
    public synchronized void removePref(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            synchronized (this) {
                if (b != null) {
                    SharedPreferences.Editor edit = b.getSharedPreferences("video_cfg", 0).edit();
                    edit.remove(str);
                    edit.commit();
                }
            }
        }
    }

    @Keep
    public synchronized void setPrefInt(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, str, i2) == null) {
            synchronized (this) {
                if (b != null) {
                    SharedPreferences.Editor edit = b.getSharedPreferences("video_cfg", 0).edit();
                    edit.putInt(str, i2);
                    edit.commit();
                }
            }
        }
    }

    @Keep
    public synchronized void setPrefLong(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048593, this, str, j2) == null) {
            synchronized (this) {
                if (b != null) {
                    SharedPreferences.Editor edit = b.getSharedPreferences("video_cfg", 0).edit();
                    edit.putLong(str, j2);
                    edit.commit();
                }
            }
        }
    }

    @Keep
    public synchronized void setPrefStr(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) {
            synchronized (this) {
                if (b != null) {
                    SharedPreferences.Editor edit = b.getSharedPreferences("video_cfg", 0).edit();
                    edit.putString(str, str2);
                    edit.commit();
                }
            }
        }
    }
}
