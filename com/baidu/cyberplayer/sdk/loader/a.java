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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
public class a implements a.InterfaceC1637a {
    public static /* synthetic */ Interceptable $ic;
    public static ClassLoader m;
    public static a n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f38924a;

    /* renamed from: b  reason: collision with root package name */
    public int f38925b;

    /* renamed from: c  reason: collision with root package name */
    public Context f38926c;

    /* renamed from: d  reason: collision with root package name */
    public String f38927d;

    /* renamed from: e  reason: collision with root package name */
    public String f38928e;

    /* renamed from: f  reason: collision with root package name */
    public String f38929f;

    /* renamed from: g  reason: collision with root package name */
    public String f38930g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38931h;

    /* renamed from: i  reason: collision with root package name */
    public volatile int f38932i;

    /* renamed from: j  reason: collision with root package name */
    public Map<String, String> f38933j;
    public ArrayList<String> k;
    public CyberPlayerManager.InstallListener l;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38924a = 0L;
        this.f38925b = 0;
        this.f38926c = null;
        this.f38927d = SDKVersion.VERSION;
        this.f38928e = null;
        this.f38929f = null;
        this.f38930g = null;
        this.f38931h = false;
        this.f38933j = null;
        this.k = null;
        this.l = null;
    }

    private synchronized int a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, str, i2)) == null) {
            synchronized (this) {
                String string = d().getString(str, null);
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

    private void a(int i2) {
        CyberPlayerManager.InstallListener installListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) || (installListener = this.l) == null) {
            return;
        }
        installListener.onInstallProgress(this.f38932i, i2);
    }

    private void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, this, i2, str) == null) {
            if (h()) {
                c();
                return;
            }
            CyberPlayerManager.InstallListener installListener = this.l;
            if (installListener != null) {
                installListener.onInstallError(this.f38932i, i2, str);
            }
            if (i2 == -4 || !o.m()) {
                return;
            }
            CyberCfgManager.getInstance().setPrefInt("install_error_count", 0);
        }
    }

    private void a(String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) && e() && !TextUtils.isEmpty(str)) {
            com.baidu.cyberplayer.sdk.downloader.a aVar = new com.baidu.cyberplayer.sdk.downloader.a();
            if (str.startsWith("model_")) {
                str2 = this.f38930g;
                str3 = this.f38929f;
            } else {
                str2 = this.f38930g;
                str3 = this.f38928e;
            }
            aVar.a(str2, str, str3, this);
        }
    }

    private synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, str2) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, str2)) == null) {
            synchronized (this) {
                string = d().getString(str, str2);
            }
            return string;
        }
        return (String) invokeLL.objValue;
    }

    private void c() {
        StringBuilder sb;
        ClassLoader classLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            CyberLog.d("CyberCoreLoader", "tryLoadCore:" + this.f38932i);
            if (d.a(this.f38932i)) {
                return;
            }
            if (!d.g()) {
                this.f38927d = CyberCoreLoaderManager.a().b();
                i();
                File file = new File(this.f38928e, "cyber-media-dex_" + this.f38927d + ".jar");
                if (file.exists()) {
                    CyberLog.d("CyberCoreLoader", "try load from extend:" + file.getAbsolutePath());
                    classLoader = new CyberClassLoader(file.getAbsolutePath(), new File(this.f38928e), null, this.f38926c.getClassLoader());
                } else if (!this.f38927d.equals(SDKVersion.VERSION)) {
                    sb = new StringBuilder();
                    sb.append(o.o());
                    sb.append("_cyber-media-dex_");
                    sb.append(this.f38927d);
                    sb.append(".zip");
                    a(sb.toString());
                    return;
                } else {
                    classLoader = this.f38926c.getClassLoader();
                }
                m = classLoader;
                try {
                    d.a(this.f38926c, m, this.f38929f);
                } catch (Exception unused) {
                    m = null;
                    sb = new StringBuilder();
                }
            }
            try {
                if (d.a(this.f38932i, this.f38933j)) {
                    g();
                    CyberLog.d("CyberCoreLoader", "load success curVer:" + d.a() + " installType:" + this.f38932i);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.f38926c.getSharedPreferences("video_cfg", 0) : (SharedPreferences) invokeV.objValue;
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
            int a2 = a("success-download-core-count", 0);
            this.f38925b = a2;
            if (a2 >= 12) {
                CyberLog.w("CyberCoreLoader", "Achieve max success download time:12");
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
            CyberPlayerManager.InstallListener installListener = this.l;
            if (installListener != null) {
                installListener.onInstallSuccess(this.f38932i, d.a());
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
            if (this.f38931h) {
                return false;
            }
            if (SDKVersion.VERSION.equals(this.f38927d)) {
                if (d.k()) {
                    this.f38931h = true;
                    return true;
                }
                return false;
            } else if (!this.f38927d.equals(d.a()) && CyberCfgManager.getInstance().getCfgBoolValue("update_core_enable_downgrade", true)) {
                this.f38927d = SDKVersion.VERSION;
                this.f38931h = true;
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
            if (SDKVersion.VERSION.equals(this.f38927d)) {
                return;
            }
            CyberCfgManager.getInstance().setPrefStr(CyberCfgManager.SP_KEY_UPDATE_TYPE, "cyber-media-dex");
            CyberCfgManager.getInstance().setPrefStr("update_version", this.f38927d);
        }
    }

    public synchronized void a(String str, int i2, Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048576, this, str, i2, map, installListener) == null) {
            synchronized (this) {
                this.f38932i = i2;
                this.f38933j = map;
                if (!f()) {
                    if (installListener != null) {
                        a(-5, "cpu not support:" + o.g());
                    }
                    return;
                }
                CyberLog.d("CyberCoreLoader", "InstallTask:" + i2 + " start");
                CyberCfgManager.getInstance().init();
                this.f38930g = c.a().a(str);
                this.l = installListener;
                this.f38926c = CyberPlayerManager.getApplicationContext();
                String d2 = o.d();
                if (!d2.equals(b("success-download-core-time", null))) {
                    a("success-download-core-count", Integer.toString(0));
                    a("success-download-core-time", d2);
                }
                this.f38929f = o.b();
                this.f38928e = this.f38929f + File.separator + "libs";
                c();
                CyberLog.d("CyberCoreLoader", "InstallTask:" + i2 + " end");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC1637a
    public void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC1637a
    public void a(String str, long j2, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), str2}) == null) {
            CyberLog.d("CyberCoreLoader", "srcUrl:" + str + " detail:" + str2);
            if (i2 != -1) {
                int i3 = this.f38925b + 1;
                this.f38925b = i3;
                a("success-download-core-count", Integer.toString(i3));
            }
            a(i2, str2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC1637a
    public void a(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (valueOf.longValue() - this.f38924a > 500) {
                int i2 = (int) ((((float) j2) / ((float) j3)) * 99.0f);
                a(i2);
                this.f38924a = valueOf.longValue();
                CyberLog.d("CyberCoreLoader", "onDownloading:" + i2 + "%");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC1637a
    public void a(String str, long j2, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j2), arrayList}) == null) {
            this.k = arrayList;
            int i2 = this.f38925b + 1;
            this.f38925b = i2;
            a("success-download-core-count", Integer.toString(i2));
            CyberLog.d("CyberCoreLoader", "onDownloadSuccess:" + this.k);
            c();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38931h : invokeV.booleanValue;
    }
}
