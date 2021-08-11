package c.a.n0.a.a1;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a1.h.a;
import c.a.n0.a.f1.e.b;
import c.a.n0.a.j2.c;
import c.a.n0.a.j2.k;
import c.a.n0.a.j2.m;
import c.a.n0.a.k2.g.h;
import c.a.n0.a.v2.o0;
import c.a.n0.a.v2.q0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4218a;

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f4219b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.f1.e.b f4220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4221f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.a1.b f4222g;

        public a(c.a.n0.a.f1.e.b bVar, JSONObject jSONObject, c.a.n0.a.a1.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, jSONObject, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4220e = bVar;
            this.f4221f = jSONObject;
            this.f4222g = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            g l;
            SwanAppConfigData swanAppConfigData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.v2.a1.b bVar = new c.a.n0.a.v2.a1.b();
                if (c.a.n0.a.u1.a.a.A(this.f4220e)) {
                    l = c.a.n0.a.u1.a.a.c(this.f4220e, bVar);
                } else {
                    l = C0104e.l(this.f4220e, bVar, this.f4221f);
                }
                if (l == null || (swanAppConfigData = l.f4225b) == null || swanAppConfigData.f46332b == null) {
                    c.a.n0.a.q2.a aVar = bVar.f9015a;
                    if (aVar == null) {
                        aVar = new c.a.n0.a.q2.a();
                        aVar.j(5L);
                        aVar.h(20L);
                        aVar.e("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    c.a.n0.a.j2.p.d dVar = new c.a.n0.a.j2.p.d();
                    c.a.n0.a.f1.e.b bVar2 = this.f4220e;
                    dVar.q(k.m(bVar2 != null ? bVar2.G() : 0));
                    dVar.p(aVar);
                    dVar.s("appjson_config_invalid");
                    dVar.r(this.f4220e);
                    k.L(dVar);
                }
                this.f4222g.a(0, l);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static g a(c.a.n0.a.f1.e.b bVar, c.a.n0.a.v2.a1.b bVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bVar, bVar2)) == null) {
                File b2 = b(bVar2);
                if (b2 == null) {
                    return null;
                }
                c.a.n0.a.a2.e i2 = c.a.n0.a.a2.e.i();
                if (i2 == null) {
                    if (!e.L(b2, e(), bVar, bVar2)) {
                        c.a.n0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").F();
                        c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
                        aVar.j(5L);
                        aVar.h(7L);
                        aVar.e("小程序bundle解压失败! for debug");
                        c.a.n0.a.q2.e.a().f(aVar);
                        if (bVar2 != null && bVar2.f9015a == null) {
                            bVar2.f9015a = aVar;
                        }
                        return null;
                    }
                } else {
                    String q = i2.T().q("installed_debug_bundle_md5", "");
                    String b3 = c.a.n0.t.f.b(b2, false);
                    if (!TextUtils.equals(q, b3)) {
                        if (!e.L(b2, e(), bVar, bVar2)) {
                            c.a.n0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").F();
                            c.a.n0.a.q2.a aVar2 = new c.a.n0.a.q2.a();
                            aVar2.j(5L);
                            aVar2.h(7L);
                            aVar2.e("小程序bundle解压失败! for debug");
                            c.a.n0.a.q2.e.a().f(aVar2);
                            if (bVar2 != null && bVar2.f9015a == null) {
                                bVar2.f9015a = aVar2;
                            }
                            return null;
                        }
                        i2.T().B("installed_debug_bundle_md5", b3);
                    }
                }
                g gVar = new g();
                File g2 = g();
                File file = new File(g2, "app.json");
                SwanAppConfigData b4 = c.a.n0.a.a2.n.d.b(g2.getAbsolutePath());
                gVar.f4224a = g2.getPath() + File.separator;
                gVar.f4225b = b4;
                c.a.n0.a.t1.b.a.f(b4, true);
                c.a.n0.a.t1.g.b.l(b4);
                c.a.n0.a.e0.d.h("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.f4224a);
                return gVar;
            }
            return (g) invokeLL.objValue;
        }

        public static File b(c.a.n0.a.v2.a1.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
                File c2 = c();
                File[] listFiles = c2.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    return h(listFiles);
                }
                Context appContext = AppRuntime.getAppContext();
                c.a.n0.a.z1.b.f.e.g(appContext, c2.getPath() + " 没有测试程序包!").F();
                c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
                aVar.j(5L);
                aVar.h(4L);
                aVar.e("没有小程序包! for debug, bundle files are empty");
                c.a.n0.a.q2.e.a().f(aVar);
                if (bVar != null) {
                    bVar.f9015a = aVar;
                    return null;
                }
                return null;
            }
            return (File) invokeL.objValue;
        }

        public static File c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                File file = new File(c.a.n0.a.f1.c.a.d().get(0).f9084a, "/aiapps_debug/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new File(c.a.n0.a.f1.c.a.d().get(0).f9084a, "/aiapps_debug/").getAbsolutePath() : (String) invokeV.objValue;
        }

        public static File e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
                file.mkdirs();
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                return AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aiapps_bundle";
            }
            return (String) invokeV.objValue;
        }

        public static File g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? e() : (File) invokeV.objValue;
        }

        public static File h(File[] fileArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fileArr)) == null) {
                File file = null;
                for (File file2 : fileArr) {
                    if (file == null || file2.lastModified() > file.lastModified()) {
                        file = file2;
                    }
                }
                return file;
            }
            return (File) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void onFailed();

        void onProgressChanged(int i2);

        void onSuccess();
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f4223a;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* renamed from: c.a.n0.a.a1.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0104e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.n0.a.a1.e$e$a */
        /* loaded from: classes.dex */
        public static class a implements FileFilter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? file.isDirectory() && TextUtils.isDigitsOnly(file.getName()) : invokeL.booleanValue;
            }
        }

        public static long a(String str, String str2) throws IllegalArgumentException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (TextUtils.isDigitsOnly(str) && TextUtils.isDigitsOnly(str2)) {
                        return Long.parseLong(str) - Long.parseLong(str2);
                    }
                    throw new IllegalArgumentException("version is not digits only");
                }
                throw new IllegalArgumentException("version null");
            }
            return invokeLL.longValue;
        }

        public static File b(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeL.objValue;
        }

        public static void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            File[] listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new a());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                if (k(str2, file.getName())) {
                    c.a.n0.a.e0.d.h("SwanAppBundleHelper", "#deleteLowerVersionFolder del：" + file.getAbsolutePath());
                    c.a.n0.n.g.a.h().d(str, file.getName());
                    c.a.n0.t.d.i(file);
                    c.a.n0.a.l1.d.c.b(str, file.getName());
                }
            }
        }

        public static void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, null) == null) {
                c.a.n0.t.d.K(e.q());
            }
        }

        public static void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            File f2 = f(str, false);
            if (f2 != null) {
                c.a.n0.t.d.K(f2);
            }
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str);
            c.a.n0.a.l1.d.c.a(str);
            c.a.n0.t.d.K(file);
            c.a.n0.t.d.K(new File(e.o(str)));
            int indexOf = str.indexOf("_dev");
            if (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                c.a.n0.t.d.K(new File(e.o(substring + "_dev")));
            }
        }

        @Nullable
        public static File f(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, str, z)) == null) ? g(str, z, null) : (File) invokeLZ.objValue;
        }

        @Nullable
        public static File g(@Nullable String str, boolean z, @Nullable c.a.n0.a.v2.a1.b bVar) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{str, Boolean.valueOf(z), bVar})) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File h2 = h();
                File file = new File(h2, str + ".aiapps");
                if (file.exists() && file.isFile()) {
                    return file;
                }
                if (e.f4218a && z) {
                    Context appContext = AppRuntime.getAppContext();
                    c.a.n0.a.z1.b.f.e.g(appContext, h2.getPath() + " 没有小程序包!").F();
                }
                if (bVar != null) {
                    c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(4L);
                    aVar.e("没有小程序包! for release, no such bundle file");
                    c.a.n0.a.q2.e.a().f(aVar);
                    bVar.f9015a = aVar;
                }
                return null;
            }
            return (File) invokeCommon.objValue;
        }

        public static File h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static File i(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? j(str, str2, null) : (File) invokeLL.objValue;
        }

        public static File j(String str, String str2, @Nullable JSONObject jSONObject) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, str, str2, jSONObject)) == null) {
                if (m.e(str2)) {
                    m.f(str, str2, jSONObject);
                }
                return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
            }
            return (File) invokeLLL.objValue;
        }

        public static boolean k(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
                if (e.f4218a) {
                    String str3 = "curVersion:" + str + ",targetVersion:" + str2;
                }
                try {
                    return a(str, str2) > 0;
                } catch (IllegalArgumentException e2) {
                    if (e.f4218a) {
                        String str4 = "比较版本号Exception：" + e2.getMessage();
                    }
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static g l(c.a.n0.a.f1.e.b bVar, c.a.n0.a.v2.a1.b bVar2, @Nullable JSONObject jSONObject) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, bVar, bVar2, jSONObject)) == null) {
                if (bVar == null) {
                    return null;
                }
                File v = e.v(bVar.H(), bVar.u1(), bVar.n0(), bVar.h0(), jSONObject);
                if (!v.exists()) {
                    File g2 = g(bVar.H(), true, bVar2);
                    if (g2 == null) {
                        c.a.n0.a.v1.c.e.a.E().O(8, new SwanAppDeleteInfo(bVar.H(), 1).setPurgerScenes(5));
                        c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
                        aVar.j(5L);
                        aVar.h(31L);
                        aVar.e("小程序zip和bundle不存在，兜底重置");
                        c.a.n0.a.j2.p.d dVar = new c.a.n0.a.j2.p.d();
                        dVar.q(k.m(bVar.G()));
                        dVar.p(aVar);
                        dVar.r(bVar);
                        k.L(dVar);
                        boolean unused = e.f4218a;
                        return null;
                    }
                    b(v);
                    if (!e.L(g2, v, bVar, bVar2)) {
                        c.a.n0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").F();
                        c.a.n0.a.q2.a aVar2 = new c.a.n0.a.q2.a();
                        aVar2.j(5L);
                        aVar2.h(7L);
                        aVar2.e("小程序bundle解压失败! for release");
                        c.a.n0.a.q2.e.a().f(aVar2);
                        if (bVar2 != null && bVar2.f9015a == null) {
                            bVar2.f9015a = aVar2;
                        }
                        return null;
                    }
                }
                c(bVar.H(), bVar.u1());
                g gVar = new g();
                File file = new File(v, "app.json");
                SwanAppConfigData b2 = c.a.n0.a.a2.n.d.b(v.getAbsolutePath());
                if (b2 == null) {
                    return null;
                }
                gVar.f4224a = i(bVar.H(), bVar.u1()).getPath() + File.separator;
                gVar.f4225b = b2;
                c.a.n0.a.t1.b.a.f(b2, true);
                c.a.n0.a.t1.g.b.l(b2);
                c.a.n0.a.e0.d.h("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.f4224a);
                return gVar;
            }
            return (g) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static g a(c.a.n0.a.f1.e.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bVar)) == null) {
                File e2 = e();
                c.a.n0.a.e0.f.e.d.g().h("unzipstart");
                e.K(b(), e2, bVar);
                c.a.n0.a.e0.f.e.d.g().h("unzipend");
                g gVar = new g();
                File file = new File(e2, "app.json");
                SwanAppConfigData b2 = c.a.n0.a.a2.n.d.b(e2.getAbsolutePath());
                gVar.f4224a = e2.getPath() + File.separator;
                gVar.f4225b = b2;
                c.a.n0.a.t1.b.a.f(b2, true);
                c.a.n0.a.t1.g.b.l(b2);
                c.a.n0.a.e0.d.h("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.f4224a);
                return gVar;
            }
            return (g) invokeL.objValue;
        }

        public static File b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new File(c(), "remote_debug.aiapps") : (File) invokeV.objValue;
        }

        public static File c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_remote_debug_zip";
            }
            return (String) invokeV.objValue;
        }

        public static File e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_remote_debug_folder";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class g extends c.a.n0.a.a1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f4224a;

        /* renamed from: b  reason: collision with root package name */
        public SwanAppConfigData f4225b;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1205599264, "Lc/a/n0/a/a1/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1205599264, "Lc/a/n0/a/a1/e;");
                return;
            }
        }
        f4218a = c.a.n0.a.k.f6803a;
        f4219b = Executors.newSingleThreadExecutor();
    }

    public static boolean A(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            boolean exists = new File(k(str, str2), "app.json").exists();
            c.a.n0.a.e0.d.h("SwanAppBundleHelper", "isAppJsonExist = " + exists);
            return exists;
        }
        return invokeLL.booleanValue;
    }

    public static boolean B(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) ? z(p(str, str2, str3)) : invokeLLL.booleanValue;
    }

    public static boolean C(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            String g2 = o0.g(str2);
            int lastIndexOf = g2.lastIndexOf(File.separator);
            if (lastIndexOf > 0) {
                g2 = g2.substring(0, lastIndexOf);
            }
            boolean exists = new File(str, g2).exists();
            if (f4218a) {
                String str3 = "pagePath - " + g2 + ", isExist - " + exists;
            }
            return exists;
        }
        return invokeLL.booleanValue;
    }

    public static void D(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            c.b bVar = new c.b(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER);
            bVar.j(str);
            bVar.l(str2);
            bVar.m();
        }
    }

    public static void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) {
            h.a().putBoolean("swanapps_has_done_fallback_strategy_key", z);
        }
    }

    public static void F(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, cVar) == null) {
            d dVar = new d();
            dVar.f4223a = str;
            new c.a.n0.a.k0.a().e(dVar, c.a.n0.a.p0.f.b.j().getPath(), cVar);
        }
    }

    public static void G(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, cVar) == null) {
            d dVar = new d();
            dVar.f4223a = str;
            c.a.n0.a.p0.f.c.a();
            new c.a.n0.a.k0.a().e(dVar, c.a.n0.a.p0.f.c.c().getPath(), cVar);
        }
    }

    public static void H(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, cVar) == null) {
            d dVar = new d();
            dVar.f4223a = str;
            c.a.n0.a.m2.d.a.a();
            new c.a.n0.a.k0.a().e(dVar, c.a.n0.a.m2.d.a.d().getPath(), cVar);
        }
    }

    public static void I(d dVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, dVar, cVar) == null) {
            File c2 = b.c();
            new c.a.n0.a.k0.a().e(dVar, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
        }
    }

    public static boolean J(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, file, str)) == null) {
            File file2 = new File(file, str);
            if (file2.exists()) {
                return true;
            }
            boolean mkdirs = file2.mkdirs();
            c.a.n0.a.e0.d.h("SwanAppBundleHelper", "#tryMkdirs del: " + file2.getAbsolutePath());
            c.a.n0.t.d.K(file2);
            return mkdirs;
        }
        return invokeLL.booleanValue;
    }

    public static boolean K(File file, File file2, c.a.n0.a.f1.e.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, file, file2, bVar)) == null) ? L(file, file2, bVar, null) : invokeLLL.booleanValue;
    }

    public static boolean L(File file, File file2, c.a.n0.a.f1.e.b bVar, c.a.n0.a.v2.a1.b bVar2) {
        InterceptResult invokeLLLL;
        boolean T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, file, file2, bVar, bVar2)) == null) {
            int i2 = 0;
            if (file != null && file2 != null) {
                if (file.exists() && file.length() != 0) {
                    c.a.n0.a.r1.h.o().C(new UbcFlowEvent("package_start_unzip"));
                    long currentTimeMillis = System.currentTimeMillis();
                    a.b i3 = c.a.n0.a.a1.h.a.i(file);
                    int i4 = i3.f4249b;
                    if (i4 != -1) {
                        T = c.a.n0.a.a1.h.a.c(i3.f4248a, file2, i4).f4246a;
                        i2 = i3.f4249b;
                    } else {
                        T = c.a.n0.t.d.T(file.getPath(), file2.getPath());
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (f4218a) {
                        c.a.n0.a.a1.h.a.g((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (!T) {
                        c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
                        aVar.j(5L);
                        aVar.h(7L);
                        aVar.e("小程序bundle解压失败! PkgType=" + i2);
                        if (bVar2 != null) {
                            bVar2.f9015a = aVar;
                        }
                    }
                    HybridUbcFlow o = c.a.n0.a.r1.h.o();
                    o.C(new UbcFlowEvent("package_end_unzip"));
                    o.A("app_package_version", String.valueOf(i2));
                    return T;
                }
                c.a.n0.a.q2.a aVar2 = new c.a.n0.a.q2.a();
                aVar2.j(5L);
                aVar2.h(4L);
                aVar2.e("小程序bundle文件不存在或者空文件! ");
                if (bVar2 != null) {
                    bVar2.f9015a = aVar2;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static synchronized boolean M(@NonNull c.a.n0.a.a2.e eVar) {
        InterceptResult invokeL;
        boolean N;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, eVar)) == null) {
            synchronized (e.class) {
                N = N(eVar, u(eVar));
            }
            return N;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean N(@NonNull c.a.n0.a.a2.e eVar, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, eVar, file)) == null) {
            synchronized (e.class) {
                if (file != null) {
                    if (file.exists()) {
                        SwanAppConfigData b2 = c.a.n0.a.f1.c.a.b(file);
                        if (b2 != null) {
                            eVar.t0(b2);
                        }
                        c.a.n0.a.t1.b.a.f(b2, true);
                        c.a.n0.a.t1.g.b.l(b2);
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void c(c.a.n0.a.f1.e.b bVar, c.a.n0.a.a1.b bVar2) {
        JSONObject jSONObject;
        String H1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, bVar, bVar2) == null) {
            if (bVar == null || m.e(bVar.u1())) {
                jSONObject = new JSONObject();
                String y = q0.y();
                if (bVar == null) {
                    H1 = StringUtil.NULL_STRING;
                } else {
                    try {
                        H1 = bVar.H1();
                    } catch (JSONException e2) {
                        if (f4218a) {
                            e2.printStackTrace();
                        }
                    }
                }
                jSONObject.put("originLaunchInfo", H1);
                jSONObject.put("stackTraceBefore", y);
            } else {
                jSONObject = null;
            }
            f4219b.execute(new a(bVar, jSONObject, bVar2));
        }
    }

    @WorkerThread
    public static synchronized void d(Set<String> set, Map<String, PMSAppInfo> map) {
        File[] B;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, set, map) == null) {
            synchronized (e.class) {
                if (map != null) {
                    if (!map.isEmpty()) {
                        File o = c.a.n0.a.k2.b.o();
                        try {
                            for (Map.Entry<String, PMSAppInfo> entry : map.entrySet()) {
                                String key = entry.getKey();
                                if (!TextUtils.isEmpty(key)) {
                                    if (set != null && set.contains(key)) {
                                        c.a.n0.a.e0.d.h("SwanAppBundleHelper", "删历史版本包，排除id: " + key);
                                    } else {
                                        long j2 = entry.getValue().versionCode;
                                        File file = new File(o, key);
                                        if (file.exists() && file.isDirectory()) {
                                            for (File file2 : c.a.n0.t.d.B(file)) {
                                                if (file2 != null && Long.parseLong(file2.getName()) < j2) {
                                                    if (x(key)) {
                                                        break;
                                                    }
                                                    c.a.n0.t.d.K(file2);
                                                    c.a.n0.a.e0.d.h("SwanAppBundleHelper", "删历史版本包，file=" + file2.getAbsolutePath());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            c.a.n0.a.e0.d.i("SwanAppBundleHelper", "#删历史版本包, ex=", e2);
                        }
                    }
                }
            }
        }
    }

    public static synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            synchronized (e.class) {
                if (w()) {
                    c.a.n0.n.c.b().x("SwanAppBundleHelper", "hasDoneFallbackStrategy true");
                    D(str, MediaAEffect.AE_ANIM_REPEAT);
                    return;
                }
                boolean z = true;
                E(true);
                D(str, "start");
                File g2 = g();
                if (J(g2, str)) {
                    D(str, "canwrite");
                    return;
                }
                c.a.n0.n.a b2 = c.a.n0.n.c.b();
                b2.x("SwanAppBundleHelper", "tryMkdirs fail. Base folder: " + g2.getAbsolutePath() + " child file:" + str);
                if (g2.exists()) {
                    c.a.n0.a.e0.d.h("SwanAppBundleHelper", "#doSwanFolderFallback del: " + g2.getAbsolutePath());
                    c.a.n0.t.d.K(g2);
                }
                if (!g2.exists() && g2.mkdirs() && J(g2, str)) {
                    D(str, "delete");
                    return;
                }
                File h2 = h();
                if (h2.exists() || !h2.mkdirs() || !J(h2, str)) {
                    z = false;
                }
                D(str, "fail:" + z);
            }
        }
    }

    @NonNull
    public static Set<String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            LinkedHashSet<c.a.n0.a.v1.c.f.c> q = c.a.n0.a.v1.c.f.e.k().q();
            HashSet hashSet = new HashSet();
            for (c.a.n0.a.v1.c.f.c cVar : q) {
                if (cVar != null) {
                    String appId = cVar.getAppId();
                    Set<String> i2 = cVar.i();
                    if (!TextUtils.isEmpty(appId)) {
                        hashSet.add(appId);
                        if (f4218a) {
                            String str = "appId in running - " + appId;
                        }
                    }
                    if (i2.size() > 0) {
                        hashSet.addAll(i2);
                        if (f4218a) {
                            String str2 = "appId in prefetch - " + i2;
                        }
                    }
                }
            }
            if (f4218a) {
                String str3 = "active apps - " + hashSet;
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    public static File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
        }
        return (File) invokeV.objValue;
    }

    public static File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_folder_fallback");
        }
        return (File) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
        }
        return (String) invokeV.objValue;
    }

    public static File j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) ? new File(g(), str) : (File) invokeL.objValue;
    }

    public static File k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, str, str2)) == null) ? new File(j(str), str2) : (File) invokeLL.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_zip";
        }
        return (String) invokeV.objValue;
    }

    public static synchronized String m(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, file)) == null) {
            synchronized (e.class) {
                if (file == null) {
                    return "";
                }
                String path = file.getPath();
                if (f4218a) {
                    String str = "getConfigContent path: " + path;
                }
                String str2 = (String) c.a.n0.a.h0.u.f.b().a(path, "");
                if (TextUtils.isEmpty(str2)) {
                    if (f4218a) {
                        String str3 = "getConfigContent read start: " + path;
                    }
                    String D = c.a.n0.t.d.D(file);
                    c.a.n0.a.h0.u.f.b().c(path, D);
                    if (f4218a) {
                        String str4 = "getConfigContent read end: " + path;
                    }
                    return D;
                }
                return str2;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return i() + File.separator + "database";
        }
        return (String) invokeV.objValue;
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            return n() + File.separator + str;
        }
        return (String) invokeL.objValue;
    }

    public static File p(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65566, null, str, str2, str3)) == null) ? new File(k(str, str2), o0.g(str3)) : (File) invokeLLL.objValue;
    }

    public static File q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace") : (File) invokeV.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_plugin_workspace";
        }
        return (String) invokeV.objValue;
    }

    public static File s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (f4218a) {
                    throw new IllegalArgumentException("plugin name can't be empty");
                }
                return null;
            }
            return new File(q(), str);
        }
        return (File) invokeL.objValue;
    }

    public static File t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return new File(s(str), str2);
            }
            if (f4218a) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static File u(@NonNull c.a.n0.a.a2.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, eVar)) == null) {
            if (eVar == null) {
                return null;
            }
            b.a L = eVar.L();
            File v = v(eVar.getAppId(), L.u1(), L.n0(), L.h0(), null);
            if (f4218a) {
                String str = "sendLaunchEvent folderFile: " + v.getPath();
                String str2 = "sendLaunchEvent file exists: " + v.exists();
            }
            return v;
        }
        return (File) invokeL.objValue;
    }

    public static File v(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        InterceptResult invokeCommon;
        File j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, null, new Object[]{str, str2, Boolean.valueOf(z), str3, jSONObject})) == null) {
            if (c.a.n0.a.u1.a.a.G()) {
                j2 = b.e();
            } else if (c.a.n0.a.u1.a.a.C()) {
                j2 = c.a.n0.a.e0.f.d.b.d();
            } else {
                j2 = C0104e.j(str, str2, jSONObject);
            }
            return (!z || TextUtils.isEmpty(str3)) ? j2 : new File(j2, str3);
        }
        return (File) invokeCommon.objValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? h.a().getBoolean("swanapps_has_done_fallback_strategy_key", false) : invokeV.booleanValue;
    }

    public static boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) ? f().contains(str) : invokeL.booleanValue;
    }

    public static boolean y(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, file)) == null) {
            boolean z = false;
            if (file != null && file.exists()) {
                File file2 = new File(file, "app.js");
                boolean exists = file2.exists();
                c.a.n0.a.e0.d.h("SwanAppBundleHelper", "isAppJsExist = " + exists);
                long length = exists ? file2.length() : -1L;
                c.a.n0.a.e0.d.h("SwanAppBundleHelper", "appJsSize = " + length);
                if (exists && length > 0) {
                    z = true;
                }
                if (!z) {
                    c.a.n0.a.j2.p.d dVar = new c.a.n0.a.j2.p.d();
                    c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(51L);
                    dVar.p(aVar);
                    dVar.l("path", file2.getAbsolutePath());
                    dVar.l("appJs", "isAppJsExist =" + exists + ", appJsSize =" + length);
                    dVar.l("stack", q0.z(30));
                    k.L(dVar);
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean z(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, file)) == null) {
            if (file == null || !file.exists()) {
                return false;
            }
            boolean exists = new File(file, "app.json").exists();
            c.a.n0.a.e0.d.h("SwanAppBundleHelper", "isAppJsonExist = " + exists);
            return exists;
        }
        return invokeL.booleanValue;
    }
}
