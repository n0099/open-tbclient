package com.baidu.cyberplayer.sdk.downloader;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.c;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.downloader.a;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class SilentDownloaderManager implements a.InterfaceC1604a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile SilentDownloaderManager f37055a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f37056d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f37057b;

    /* renamed from: c  reason: collision with root package name */
    public Context f37058c;

    /* renamed from: e  reason: collision with root package name */
    public String f37059e;

    /* renamed from: f  reason: collision with root package name */
    public String f37060f;

    /* renamed from: g  reason: collision with root package name */
    public String f37061g;

    /* renamed from: h  reason: collision with root package name */
    public a f37062h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f37063i;
    public Map<String, String> j;
    public HashMap<String, String> k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f37064a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f37065b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f37066c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ a[] f37067d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(923870429, "Lcom/baidu/cyberplayer/sdk/downloader/SilentDownloaderManager$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(923870429, "Lcom/baidu/cyberplayer/sdk/downloader/SilentDownloaderManager$a;");
                    return;
                }
            }
            f37064a = new a("CORE", 0);
            f37065b = new a("LIBS_INFO_DEF_PRO", 1);
            a aVar = new a("LIB", 2);
            f37066c = aVar;
            f37067d = new a[]{f37064a, f37065b, aVar};
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f37067d.clone() : (a[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1523059270, "Lcom/baidu/cyberplayer/sdk/downloader/SilentDownloaderManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1523059270, "Lcom/baidu/cyberplayer/sdk/downloader/SilentDownloaderManager;");
        }
    }

    public SilentDownloaderManager() {
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
        this.f37057b = 0;
        this.f37058c = null;
        this.f37059e = null;
        this.f37060f = null;
        this.f37061g = null;
        this.f37062h = null;
        this.f37063i = true;
        this.f37059e = c.a().a((String) null);
        this.f37061g = o.b();
        this.f37060f = this.f37061g + File.separator + "libs";
        this.k = new HashMap<>();
        this.j = new HashMap();
        this.f37058c = CyberPlayerManager.getApplicationContext();
        String d2 = o.d();
        if (d2.equals(d("silent_download_success_time", null))) {
            return;
        }
        c("silent_download_success_count", Integer.toString(0));
        c("silent_download_success_time", d2);
    }

    private synchronized int a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, str, i2)) == null) {
            synchronized (this) {
                String string = e().getString(str, null);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        i2 = Integer.parseInt(string);
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    private void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, map) == null) || map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) || !TextUtils.isEmpty(entry.getValue())) {
                c(b(entry.getKey(), entry.getValue()));
                if (!this.f37063i) {
                    return;
                }
            }
        }
    }

    private boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2)) == null) {
            try {
                return new File(this.f37060f + File.separator + o.o() + File.separator + str + "_" + str2 + File.separator + "lib" + str + ".so").exists();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, str2)) == null) {
            if ("cyber-media-dex".equals(str)) {
                return o.o() + "_cyber-media-dex_" + str2 + ".zip";
            } else if ("cyber-sdl".equals(str)) {
                return o.o() + "_cyber-player_" + str2 + ".zip";
            } else {
                return o.o() + "_" + str + "_" + str2 + ".zip";
            }
        }
        return (String) invokeLL.objValue;
    }

    private Map<String, String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            String str2 = this.f37060f + File.separator + "libsinfodef_" + str + ".pro";
            Map<String, String> a2 = com.baidu.cyberplayer.sdk.config.b.a(str2);
            HashMap hashMap = new HashMap();
            if (a2 != null && a2.size() != 0) {
                for (Map.Entry<String, String> entry : a2.entrySet()) {
                    String prefStr = CyberCfgManager.getInstance().getPrefStr(entry.getKey(), "");
                    if (!TextUtils.isEmpty(prefStr) && !prefStr.equals(entry.getValue()) && !a(entry.getKey(), entry.getValue())) {
                        hashMap.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            CyberLog.i("SilentDownloaderManager", "libsInfoDefProPath=" + str2 + " downloadMap=" + hashMap);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            e("silentdownload", "1");
            com.baidu.cyberplayer.sdk.statistics.b.a(this.f37058c, (int) DpStatConstants.ACTION_LIB_LOAD_RESULT, this.k);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            HashMap<String, String> hashMap = this.k;
            if (hashMap != null) {
                hashMap.clear();
            }
            Map<String, String> map = this.j;
            if (map != null) {
                map.clear();
            }
        }
    }

    private void c(String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.cyberplayer.sdk.downloader.a aVar = new com.baidu.cyberplayer.sdk.downloader.a();
        if (str.startsWith("model_")) {
            str2 = this.f37059e;
            str3 = this.f37061g;
        } else {
            str2 = this.f37059e;
            str3 = this.f37060f;
        }
        aVar.a(str2, str, str3, this);
    }

    private synchronized void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, str, str2) == null) {
            synchronized (this) {
                SharedPreferences.Editor edit = e().edit();
                edit.putString(str, str2);
                edit.apply();
            }
        }
    }

    private synchronized String d(String str, String str2) {
        InterceptResult invokeLL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, str, str2)) == null) {
            synchronized (this) {
                string = e().getString(str, str2);
            }
            return string;
        }
        return (String) invokeLL.objValue;
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (o.m()) {
                if (!c.a().h()) {
                    CyberLog.d("SilentDownloaderManager", "cancel download isSFSwitchEnabled");
                    return false;
                } else if (!CyberCfgManager.getInstance().getCfgBoolValue("enable_silent_download", false)) {
                    CyberLog.i("SilentDownloaderManager", "silent download disable");
                    return false;
                } else if (Looper.myLooper() == Looper.getMainLooper()) {
                    return false;
                } else {
                    int a2 = a("silent_download_success_count", 0);
                    this.f37057b = a2;
                    if (a2 >= 36) {
                        CyberLog.w("SilentDownloaderManager", "Achieve max success download time:36");
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) {
            try {
                return new File(this.f37060f + File.separator + "cyber-media-dex_" + str + ".jar").exists();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private SharedPreferences e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? this.f37058c.getSharedPreferences("dp_silent_download_cfg_", 0) : (SharedPreferences) invokeV.objValue;
    }

    private String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return str.substring(str.lastIndexOf(File.separator) + 1, str.lastIndexOf("."));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private void e(String str, String str2) {
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, this, str, str2) == null) || (hashMap = this.k) == null) {
            return;
        }
        hashMap.put(str, str2);
    }

    @Keep
    public static SilentDownloaderManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (f37055a == null) {
                synchronized (SilentDownloaderManager.class) {
                    if (f37055a == null) {
                        f37055a = new SilentDownloaderManager();
                    }
                }
            }
            return f37055a;
        }
        return (SilentDownloaderManager) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC1604a
    public void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC1604a
    public void a(String str, long j, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i2), str2}) == null) {
            CyberLog.i("SilentDownloaderManager", "onDownloadFail srcUrl:" + str + " detail:" + str2);
            this.f37063i = false;
            if (i2 != -1) {
                int i3 = this.f37057b + 1;
                this.f37057b = i3;
                c("silent_download_success_count", Integer.toString(i3));
            }
            e("errorCode", String.valueOf(i2));
            e("detail", str2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC1604a
    public void a(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC1604a
    public void a(String str, long j, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j), arrayList}) == null) {
            CyberLog.i("SilentDownloaderManager", "onDownloadSuccess:" + arrayList);
            int i2 = this.f37057b + 1;
            this.f37057b = i2;
            c("silent_download_success_count", Integer.toString(i2));
            e(e(str), "1");
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Map<String, String> map;
        Map<String, String> map2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!d() || (map = this.j) == null || map.size() == 0 || this.f37062h == null) {
                return false;
            }
            synchronized (SilentDownloaderManager.class) {
                if (f37056d) {
                    return false;
                }
                f37056d = true;
                CyberLog.i("SilentDownloaderManager", "downloadOnce mDownloadMap=" + this.j);
                a aVar = this.f37062h;
                if (aVar == a.f37064a) {
                    c(b("cyber-media-dex", this.j.get("cyber-media-dex")));
                    if (this.f37063i) {
                        map2 = b(this.j.get("cyber-media-dex"));
                        a(map2);
                    }
                    b();
                    c();
                    return this.f37063i;
                }
                if (aVar == a.f37065b || aVar == a.f37066c) {
                    map2 = this.j;
                    a(map2);
                }
                b();
                c();
                return this.f37063i;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!SDKVersion.VERSION.equals(str) && d()) {
                if (!CyberCfgManager.getInstance().getCfgBoolValue("update_core_enable_downgrade", false)) {
                    CyberLog.i("SilentDownloaderManager", "core force update");
                    return false;
                }
                if (d(str)) {
                    Map<String, String> b2 = b(str);
                    if (b2 == null || b2.size() == 0) {
                        return false;
                    }
                    this.f37062h = a.f37065b;
                    this.j.putAll(b2);
                    str2 = "libsinfodef.pro has so need to download, mDownloadMap=" + this.j;
                } else {
                    this.f37062h = a.f37064a;
                    this.j.put("cyber-media-dex", str);
                    str2 = "core not exist";
                }
                CyberLog.i("SilentDownloaderManager", str2);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Keep
    public boolean checkLibs(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            if (!d() || a(str, str2) || "cybermedia-ext-rtc".equals(str)) {
                return false;
            }
            this.f37062h = a.f37066c;
            this.j.put(str, str2);
            CyberLog.i("SilentDownloaderManager", "so not exist, mDownloadMap=" + this.j);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
