package com.baidu.cyberplayer.sdk.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.c;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.cyberplayer.sdk.downloader.a;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements a.InterfaceC1748a {
    public static /* synthetic */ Interceptable $ic;
    public static ClassLoader m;
    public static a n;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public int f25416b;

    /* renamed from: c  reason: collision with root package name */
    public Context f25417c;

    /* renamed from: d  reason: collision with root package name */
    public String f25418d;

    /* renamed from: e  reason: collision with root package name */
    public String f25419e;

    /* renamed from: f  reason: collision with root package name */
    public String f25420f;

    /* renamed from: g  reason: collision with root package name */
    public String f25421g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25422h;
    public volatile int i;
    public Map<String, String> j;
    public ArrayList<String> k;
    public CyberPlayerManager.InstallListener2 l;
    public long o;
    public long p;
    public long q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1039501246, "Lcom/baidu/cyberplayer/sdk/loader/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1039501246, "Lcom/baidu/cyberplayer/sdk/loader/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f25416b = 0;
        this.f25417c = null;
        this.f25418d = SDKVersion.VERSION;
        this.f25419e = null;
        this.f25420f = null;
        this.f25421g = null;
        this.f25422h = false;
        this.j = null;
        this.k = null;
        this.l = null;
        this.o = -1L;
        this.p = -1L;
        this.q = -1L;
    }

    private synchronized int a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, str, i)) == null) {
            synchronized (this) {
                String string = d().getString(str, null);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        i = Integer.parseInt(string);
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (n == null) {
                synchronized (a.class) {
                    if (n == null) {
                        n = new a();
                    }
                }
            }
            return n;
        }
        return (a) invokeV.objValue;
    }

    private void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, str) == null) {
            if (h()) {
                c();
                return;
            }
            CyberPlayerManager.InstallListener2 installListener2 = this.l;
            if (installListener2 != null) {
                installListener2.onInstallError(this.i, i, str);
            }
            if (i == -4 || !o.m()) {
                return;
            }
            CyberCfgManager.getInstance().setPrefInt("install_error_count", 0);
        }
    }

    private void a(String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, this, str) == null) && e() && !TextUtils.isEmpty(str)) {
            com.baidu.cyberplayer.sdk.downloader.a aVar = new com.baidu.cyberplayer.sdk.downloader.a();
            if (str.startsWith("model_")) {
                str2 = this.f25421g;
                str3 = this.f25420f;
            } else {
                str2 = this.f25421g;
                str3 = this.f25419e;
            }
            aVar.a(str2, str, str3, this);
        }
    }

    private synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, str, str2) == null) {
            synchronized (this) {
                SharedPreferences.Editor edit = d().edit();
                edit.putString(str, str2);
                edit.apply();
            }
        }
    }

    private synchronized String b(String str, String str2) {
        InterceptResult invokeLL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, str2)) == null) {
            synchronized (this) {
                string = d().getString(str, str2);
            }
            return string;
        }
        return (String) invokeLL.objValue;
    }

    private void b(int i) {
        CyberPlayerManager.InstallListener2 installListener2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65544, this, i) == null) || (installListener2 = this.l) == null) {
            return;
        }
        installListener2.onInstallProgress(this.i, i);
    }

    private void c() {
        StringBuilder sb;
        ClassLoader classLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            CyberLog.d("CyberCoreLoader", "tryLoadCore:" + this.i);
            if (d.a(this.i)) {
                return;
            }
            if (!d.g()) {
                this.f25418d = CyberCoreLoaderManager.a().b();
                i();
                File file = new File(this.f25419e, "cyber-media-dex_" + this.f25418d + ".jar");
                if (file.exists()) {
                    CyberLog.d("CyberCoreLoader", "try load from extend:" + file.getAbsolutePath());
                    classLoader = new CyberClassLoader(file.getAbsolutePath(), new File(this.f25419e), null, this.f25417c.getClassLoader());
                } else if (!this.f25418d.equals(SDKVersion.VERSION)) {
                    sb = new StringBuilder();
                    sb.append(o.o());
                    sb.append("_cyber-media-dex_");
                    sb.append(this.f25418d);
                    sb.append(".zip");
                    a(sb.toString());
                    return;
                } else {
                    classLoader = this.f25417c.getClassLoader();
                }
                m = classLoader;
                try {
                    d.a(this.f25417c, m, this.f25420f, this.l);
                    this.o = System.currentTimeMillis() - currentTimeMillis;
                } catch (Exception unused) {
                    m = null;
                    sb = new StringBuilder();
                }
            }
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (d.a(this.i, this.j)) {
                    this.p = System.currentTimeMillis() - currentTimeMillis2;
                    g();
                    CyberLog.d("CyberCoreLoader", "load success curVer:" + d.a() + " installType:" + this.i);
                }
            } catch (FileNotFoundException e2) {
                CyberLog.d("CyberCoreLoader", "FileNotFoundException:" + e2.getMessage());
                a(e2.getMessage());
            } catch (Error e3) {
                CyberLog.w("CyberCoreLoader", "loadLibs Error:" + e3.getMessage());
            } catch (Exception e4) {
                CyberLog.w("CyberCoreLoader", "loadLibs Exception:" + e4.getMessage());
                a(-4, e4.getMessage());
            }
        }
    }

    private SharedPreferences d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.f25417c.getSharedPreferences("video_cfg", 0) : (SharedPreferences) invokeV.objValue;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (!c.a().h()) {
                CyberLog.d("CyberCoreLoader", "cancel download isSFSwitchEnabled");
                a(-4, "cancel download isSFSwitchEnabled");
                return false;
            }
            int a = a("success-download-core-count", 0);
            this.f25416b = a;
            if (a >= 36) {
                CyberLog.w("CyberCoreLoader", "Achieve max success download time:36");
                a(-1, "Achieve max success download time");
                return false;
            } else if (o.e() < DownloadManager.MIN_LEFT_SIZE) {
                a(-1, "storagespace not enough " + o.e());
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            String g2 = o.g();
            return g2.contains("armv7-neon") || g2.contains("AArch64") || g2.contains("arm64");
        }
        return invokeV.booleanValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            CyberPlayerManager.InstallListener2 installListener2 = this.l;
            if (installListener2 != null) {
                installListener2.onInstallSuccess(this.i, d.a());
            }
            if (o.m()) {
                CyberCfgManager.getInstance().setPrefInt("install_error_count", 0);
            }
        }
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            if (this.f25422h) {
                return false;
            }
            if (SDKVersion.VERSION.equals(this.f25418d)) {
                if (d.k()) {
                    this.f25422h = true;
                    return true;
                }
                return false;
            } else if (!this.f25418d.equals(d.a()) && CyberCfgManager.getInstance().getCfgBoolValue("update_core_enable_downgrade", true)) {
                this.f25418d = SDKVersion.VERSION;
                this.f25422h = true;
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && o.m()) {
            CyberCfgManager.getInstance().setPrefInt("install_error_count", CyberCfgManager.getInstance().getPrefInt("install_error_count", 0) + 1);
            if (SDKVersion.VERSION.equals(this.f25418d)) {
                return;
            }
            CyberCfgManager.getInstance().setPrefStr(CyberCfgManager.SP_KEY_UPDATE_TYPE, "cyber-media-dex");
            CyberCfgManager.getInstance().setPrefStr("update_version", this.f25418d);
        }
    }

    public long a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i == 0) {
                return this.o;
            }
            if (i == 1) {
                return this.p;
            }
            if (i == 2) {
                return this.q;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    public synchronized void a(String str, int i, Map<String, String> map, CyberPlayerManager.InstallListener2 installListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, map, installListener2) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                this.i = i;
                this.j = map;
                if (!f()) {
                    if (installListener2 != null) {
                        a(-5, "cpu not support:" + o.g());
                    }
                    return;
                }
                CyberLog.d("CyberCoreLoader", "InstallTask:" + i + " start");
                CyberCfgManager.getInstance().init();
                this.q = System.currentTimeMillis() - currentTimeMillis;
                this.f25421g = c.a().a(str);
                this.l = installListener2;
                this.f25417c = CyberPlayerManager.getApplicationContext();
                String d2 = o.d();
                if (!d2.equals(b("success-download-core-time", null))) {
                    a("success-download-core-count", Integer.toString(0));
                    a("success-download-core-time", d2);
                }
                this.f25420f = o.b();
                this.f25419e = this.f25420f + File.separator + "libs";
                c();
                CyberLog.d("CyberCoreLoader", "InstallTask:" + i + " end");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC1748a
    public void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC1748a
    public void a(String str, long j, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i), str2}) == null) {
            CyberLog.d("CyberCoreLoader", "srcUrl:" + str + " detail:" + str2);
            if (i != -1) {
                int i2 = this.f25416b + 1;
                this.f25416b = i2;
                a("success-download-core-count", Integer.toString(i2));
            }
            a(i, str2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC1748a
    public void a(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (valueOf.longValue() - this.a > 500) {
                int i = (int) ((((float) j) / ((float) j2)) * 99.0f);
                b(i);
                this.a = valueOf.longValue();
                CyberLog.d("CyberCoreLoader", "onDownloading:" + i + "%");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC1748a
    public void a(String str, long j, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j), arrayList}) == null) {
            this.k = arrayList;
            int i = this.f25416b + 1;
            this.f25416b = i;
            a("success-download-core-count", Integer.toString(i));
            CyberLog.d("CyberCoreLoader", "onDownloadSuccess:" + this.k);
            c();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f25422h : invokeV.booleanValue;
    }
}
