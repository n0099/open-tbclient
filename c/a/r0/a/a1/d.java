package c.a.r0.a.a1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.a1.g.a;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.k;
import c.a.r0.a.n2.c;
import c.a.r0.a.n2.n;
import c.a.r0.a.n2.p;
import c.a.r0.a.o2.g.h;
import c.a.r0.a.z2.o0;
import c.a.r0.a.z2.q0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f5138b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f5139e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5140f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.a1.b f5141g;

        public a(c.a.r0.a.f1.e.b bVar, JSONObject jSONObject, c.a.r0.a.a1.b bVar2) {
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
            this.f5139e = bVar;
            this.f5140f = jSONObject;
            this.f5141g = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            g l;
            SwanAppConfigData swanAppConfigData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.z2.b1.b bVar = new c.a.r0.a.z2.b1.b();
                if (c.a.r0.a.x1.a.a.B(this.f5139e)) {
                    l = c.a.r0.a.x1.a.a.c(this.f5139e, bVar);
                } else {
                    l = e.l(this.f5139e, bVar, this.f5140f);
                }
                if (l == null || (swanAppConfigData = l.f5142b) == null || swanAppConfigData.f39340b == null) {
                    c.a.r0.a.u2.a aVar = bVar.a;
                    if (aVar == null) {
                        aVar = new c.a.r0.a.u2.a();
                        aVar.k(5L);
                        aVar.i(20L);
                        aVar.f("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    c.a.r0.a.n2.s.d dVar = new c.a.r0.a.n2.s.d();
                    c.a.r0.a.f1.e.b bVar2 = this.f5139e;
                    dVar.q(n.n(bVar2 != null ? bVar2.G() : 0));
                    dVar.p(aVar);
                    dVar.s("appjson_config_invalid");
                    dVar.r(this.f5139e);
                    n.R(dVar);
                }
                this.f5141g.a(0, l);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static g a(c.a.r0.a.f1.e.b bVar, c.a.r0.a.z2.b1.b bVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bVar, bVar2)) == null) {
                File b2 = b(bVar2);
                if (b2 == null) {
                    return null;
                }
                c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
                if (L == null) {
                    if (!d.N(b2, e(), bVar, bVar2)) {
                        c.a.r0.a.c2.b.f.e.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                        c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                        aVar.k(5L);
                        aVar.i(7L);
                        aVar.f("小程序bundle解压失败! for debug");
                        c.a.r0.a.u2.e.a().f(aVar);
                        if (bVar2 != null && bVar2.a == null) {
                            bVar2.a = aVar;
                        }
                        return null;
                    }
                } else {
                    String q = L.d0().q("installed_debug_bundle_md5", "");
                    String b3 = c.a.r0.w.f.b(b2, false);
                    if (!TextUtils.equals(q, b3)) {
                        if (!d.N(b2, e(), bVar, bVar2)) {
                            c.a.r0.a.c2.b.f.e.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                            c.a.r0.a.u2.a aVar2 = new c.a.r0.a.u2.a();
                            aVar2.k(5L);
                            aVar2.i(7L);
                            aVar2.f("小程序bundle解压失败! for debug");
                            c.a.r0.a.u2.e.a().f(aVar2);
                            if (bVar2 != null && bVar2.a == null) {
                                bVar2.a = aVar2;
                            }
                            return null;
                        }
                        L.d0().B("installed_debug_bundle_md5", b3);
                    }
                }
                g gVar = new g();
                File g2 = g();
                File file = new File(g2, "app.json");
                SwanAppConfigData b4 = c.a.r0.a.d2.n.d.b(g2.getAbsolutePath());
                gVar.a = g2.getPath() + File.separator;
                gVar.f5142b = b4;
                c.a.r0.a.w1.c.a.m(b4, true);
                c.a.r0.a.w1.h.b.l(b4);
                c.a.r0.a.w1.a.a(b4);
                c.a.r0.a.e0.d.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
                return gVar;
            }
            return (g) invokeLL.objValue;
        }

        public static File b(c.a.r0.a.z2.b1.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
                File c2 = c();
                File[] listFiles = c2.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    return h(listFiles);
                }
                Context appContext = AppRuntime.getAppContext();
                c.a.r0.a.c2.b.f.e.g(appContext, c2.getPath() + " 没有测试程序包!").G();
                c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                aVar.k(5L);
                aVar.i(4L);
                aVar.f("没有小程序包! for debug, bundle files are empty");
                c.a.r0.a.u2.e.a().f(aVar);
                if (bVar != null) {
                    bVar.a = aVar;
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
                File file = new File(c.a.r0.a.f1.c.a.d().get(0).a, "/aiapps_debug/");
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new File(c.a.r0.a.f1.c.a.d().get(0).a, "/aiapps_debug/").getAbsolutePath() : (String) invokeV.objValue;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                return AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aiapps_bundle";
            }
            return (String) invokeV.objValue;
        }

        public static File g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? e() : (File) invokeV.objValue;
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

    /* renamed from: c.a.r0.a.a1.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0260d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public C0260d() {
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

    /* loaded from: classes.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @SuppressLint({"BDThrowableCheck"})
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
                    c.a.r0.a.e0.d.k("SwanAppBundleHelper", "#deleteLowerVersionFolder del：" + file.getAbsolutePath());
                    c.a.r0.q.g.a.i().d(str, file.getName());
                    c.a.r0.w.d.j(file);
                    c.a.r0.a.m1.d.c.b(str, file.getName());
                }
            }
        }

        public static void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, null) == null) {
                c.a.r0.w.d.L(d.q());
            }
        }

        public static void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            File f2 = f(str, false);
            if (f2 != null) {
                c.a.r0.w.d.L(f2);
            }
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str);
            c.a.r0.a.m1.d.c.a(str);
            c.a.r0.w.d.L(file);
            c.a.r0.w.d.L(new File(d.o(str)));
            int indexOf = str.indexOf("_dev");
            if (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                c.a.r0.w.d.L(new File(d.o(substring + "_dev")));
            }
        }

        @Nullable
        public static File f(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, str, z)) == null) ? g(str, z, null) : (File) invokeLZ.objValue;
        }

        @Nullable
        public static File g(@Nullable String str, boolean z, @Nullable c.a.r0.a.z2.b1.b bVar) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, Boolean.valueOf(z), bVar})) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File h2 = h();
                File file = new File(h2, str + ".aiapps");
                if (file.exists() && file.isFile()) {
                    return file;
                }
                if (d.a && z) {
                    Context appContext = AppRuntime.getAppContext();
                    c.a.r0.a.c2.b.f.e.g(appContext, h2.getPath() + " 没有小程序包!").G();
                }
                if (bVar != null) {
                    c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                    aVar.k(5L);
                    aVar.i(4L);
                    aVar.f("没有小程序包! for release, no such bundle file");
                    c.a.r0.a.u2.e.a().f(aVar);
                    bVar.a = aVar;
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
                if (p.e(str2)) {
                    p.f(str, str2, jSONObject);
                }
                return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
            }
            return (File) invokeLLL.objValue;
        }

        public static boolean k(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
                if (d.a) {
                    String str3 = "curVersion:" + str + ",targetVersion:" + str2;
                }
                try {
                    return a(str, str2) > 0;
                } catch (IllegalArgumentException e2) {
                    if (d.a) {
                        String str4 = "比较版本号Exception：" + e2.getMessage();
                    }
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static g l(c.a.r0.a.f1.e.b bVar, c.a.r0.a.z2.b1.b bVar2, @Nullable JSONObject jSONObject) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, bVar, bVar2, jSONObject)) == null) {
                if (bVar == null) {
                    return null;
                }
                File v = d.v(bVar.H(), bVar.v1(), bVar.o0(), bVar.h0(), jSONObject);
                if (!v.exists()) {
                    File g2 = g(bVar.H(), true, bVar2);
                    if (g2 == null) {
                        c.a.r0.a.y1.c.e.a.P().Z(8, new SwanAppDeleteInfo(bVar.H(), 1).setPurgerScenes(5));
                        c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                        aVar.k(5L);
                        aVar.i(31L);
                        aVar.f("小程序zip和bundle不存在，兜底重置");
                        c.a.r0.a.n2.s.d dVar = new c.a.r0.a.n2.s.d();
                        dVar.q(n.n(bVar.G()));
                        dVar.p(aVar);
                        dVar.r(bVar);
                        n.R(dVar);
                        boolean unused = d.a;
                        return null;
                    }
                    b(v);
                    if (!d.N(g2, v, bVar, bVar2)) {
                        c.a.r0.a.c2.b.f.e.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                        c.a.r0.a.u2.a aVar2 = new c.a.r0.a.u2.a();
                        aVar2.k(5L);
                        aVar2.i(7L);
                        aVar2.f("小程序bundle解压失败! for release");
                        c.a.r0.a.u2.e.a().f(aVar2);
                        if (bVar2 != null && bVar2.a == null) {
                            bVar2.a = aVar2;
                        }
                        return null;
                    }
                }
                c(bVar.H(), bVar.v1());
                g gVar = new g();
                File file = new File(v, "app.json");
                SwanAppConfigData b2 = c.a.r0.a.d2.n.d.b(v.getAbsolutePath());
                if (b2 == null) {
                    return null;
                }
                gVar.a = i(bVar.H(), bVar.v1()).getPath() + File.separator;
                gVar.f5142b = b2;
                c.a.r0.a.w1.c.a.m(b2, true);
                c.a.r0.a.w1.h.b.l(b2);
                c.a.r0.a.w1.a.a(b2);
                c.a.r0.a.e0.d.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
                return gVar;
            }
            return (g) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static g a(c.a.r0.a.f1.e.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bVar)) == null) {
                File e2 = e();
                c.a.r0.a.e0.f.e.d.g().h("unzipstart");
                d.M(b(), e2, bVar);
                c.a.r0.a.e0.f.e.d.g().h("unzipend");
                g gVar = new g();
                File file = new File(e2, "app.json");
                SwanAppConfigData b2 = c.a.r0.a.d2.n.d.b(e2.getAbsolutePath());
                gVar.a = e2.getPath() + File.separator;
                gVar.f5142b = b2;
                c.a.r0.a.w1.c.a.m(b2, true);
                c.a.r0.a.w1.h.b.l(b2);
                c.a.r0.a.w1.a.a(b2);
                c.a.r0.a.e0.d.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
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
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_remote_debug_folder";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class g extends c.a.r0.a.a1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public SwanAppConfigData f5142b;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(419545213, "Lc/a/r0/a/a1/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(419545213, "Lc/a/r0/a/a1/d;");
                return;
            }
        }
        a = k.a;
        f5138b = Executors.newSingleThreadExecutor();
    }

    public static boolean A(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            boolean exists = new File(k(str, str2), "app.json").exists();
            if (!exists) {
                c.a.r0.a.e0.d.k("SwanAppBundleHelper", "#isAppJsonExist#1 [not exist] app.json");
            }
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
            if (a) {
                String str3 = "pagePath - " + g2 + ", isExist - " + exists;
            }
            return exists;
        }
        return invokeLL.booleanValue;
    }

    public static Pair<Boolean, Long> D(@NonNull File file) {
        InterceptResult invokeL;
        long j2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            String name = file.getName();
            try {
                j2 = Long.parseLong(name);
                z = true;
            } catch (NumberFormatException e2) {
                c.a.r0.a.e0.d.l("SwanAppBundleHelper", "#parseBundleVersion ex=", e2);
                if (name.endsWith(".tmp")) {
                    c.a.r0.a.e0.d.k("SwanAppBundleHelper", "#parseBundleVersion deleteDir=" + file);
                    c.a.r0.w.d.j(file);
                }
                j2 = Long.MAX_VALUE;
                z = false;
            }
            return Pair.create(Boolean.valueOf(z), Long.valueOf(j2));
        }
        return (Pair) invokeL.objValue;
    }

    public static void E(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            c.b bVar = new c.b(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER);
            bVar.j(str);
            bVar.l(str2);
            bVar.m();
        }
    }

    public static void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            h.a().putBoolean("swanapps_has_done_fallback_strategy_key", z);
        }
    }

    public static void G(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, cVar) == null) {
            C0260d c0260d = new C0260d();
            c0260d.a = str;
            new c.a.r0.a.k0.b().e(c0260d, c.a.r0.a.p0.f.b.j().getPath(), cVar);
        }
    }

    public static void H(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, cVar) == null) {
            C0260d c0260d = new C0260d();
            c0260d.a = str;
            new c.a.r0.a.k0.b().e(c0260d, c.a.r0.a.p0.f.c.j().getPath(), cVar);
        }
    }

    public static void I(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, cVar) == null) {
            C0260d c0260d = new C0260d();
            c0260d.a = str;
            c.a.r0.a.p0.f.d.a();
            new c.a.r0.a.k0.b().e(c0260d, c.a.r0.a.p0.f.d.c().getPath(), cVar);
        }
    }

    public static void J(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, cVar) == null) {
            C0260d c0260d = new C0260d();
            c0260d.a = str;
            c.a.r0.a.q2.d.a.a();
            new c.a.r0.a.k0.b().e(c0260d, c.a.r0.a.q2.d.a.d().getPath(), cVar);
        }
    }

    public static void K(C0260d c0260d, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, c0260d, cVar) == null) {
            File c2 = b.c();
            new c.a.r0.a.k0.b().e(c0260d, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
        }
    }

    public static boolean L(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, file, str)) == null) {
            File file2 = new File(file, str);
            if (file2.exists()) {
                return true;
            }
            boolean mkdirs = file2.mkdirs();
            c.a.r0.a.e0.d.k("SwanAppBundleHelper", "#tryMkdirs del: " + file2.getAbsolutePath());
            c.a.r0.w.d.L(file2);
            return mkdirs;
        }
        return invokeLL.booleanValue;
    }

    public static boolean M(File file, File file2, c.a.r0.a.f1.e.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, file, file2, bVar)) == null) ? N(file, file2, bVar, null) : invokeLLL.booleanValue;
    }

    public static boolean N(File file, File file2, c.a.r0.a.f1.e.b bVar, c.a.r0.a.z2.b1.b bVar2) {
        InterceptResult invokeLLLL;
        boolean U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, file, file2, bVar, bVar2)) == null) {
            int i2 = 0;
            if (file != null && file2 != null) {
                if (file.exists() && file.length() != 0) {
                    c.a.r0.a.u1.h.o().F(new UbcFlowEvent("package_start_unzip"));
                    long currentTimeMillis = System.currentTimeMillis();
                    a.c j2 = c.a.r0.a.a1.g.a.j(file);
                    int i3 = j2.f5168b;
                    if (i3 != -1) {
                        U = c.a.r0.a.a1.g.a.d(j2.a, file2, i3).a;
                        i2 = j2.f5168b;
                    } else {
                        U = c.a.r0.w.d.U(file.getPath(), file2.getPath());
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (a) {
                        c.a.r0.a.a1.g.a.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (!U) {
                        c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                        aVar.k(5L);
                        aVar.i(7L);
                        aVar.f("小程序bundle解压失败! PkgType=" + i2);
                        if (bVar2 != null) {
                            bVar2.a = aVar;
                        }
                    }
                    HybridUbcFlow o = c.a.r0.a.u1.h.o();
                    o.F(new UbcFlowEvent("package_end_unzip"));
                    o.D("app_package_version", String.valueOf(i2));
                    return U;
                }
                c.a.r0.a.u2.a aVar2 = new c.a.r0.a.u2.a();
                aVar2.k(5L);
                aVar2.i(4L);
                aVar2.f("小程序bundle文件不存在或者空文件! ");
                if (bVar2 != null) {
                    bVar2.a = aVar2;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static synchronized boolean O(@NonNull c.a.r0.a.d2.e eVar) {
        InterceptResult invokeL;
        boolean P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, eVar)) == null) {
            synchronized (d.class) {
                P = P(eVar, u(eVar));
            }
            return P;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean P(@NonNull c.a.r0.a.d2.e eVar, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, eVar, file)) == null) {
            synchronized (d.class) {
                if (file != null) {
                    if (file.exists()) {
                        SwanAppConfigData b2 = c.a.r0.a.f1.c.a.b(file);
                        if (b2 != null) {
                            eVar.F0(b2);
                        }
                        c.a.r0.a.w1.c.a.m(b2, true);
                        c.a.r0.a.w1.h.b.l(b2);
                        c.a.r0.a.w1.a.a(b2);
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void c(c.a.r0.a.f1.e.b bVar, c.a.r0.a.a1.b bVar2) {
        JSONObject jSONObject;
        String I1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, bVar, bVar2) == null) {
            if (bVar == null || p.e(bVar.v1())) {
                jSONObject = new JSONObject();
                String y = q0.y();
                if (bVar == null) {
                    I1 = StringUtil.NULL_STRING;
                } else {
                    try {
                        I1 = bVar.I1();
                    } catch (JSONException e2) {
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                }
                jSONObject.put("originLaunchInfo", I1);
                jSONObject.put("stackTraceBefore", y);
            } else {
                jSONObject = null;
            }
            f5138b.execute(new a(bVar, jSONObject, bVar2));
        }
    }

    @WorkerThread
    public static synchronized void d(Set<String> set, Map<String, PMSAppInfo> map) {
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, set, map) == null) {
            synchronized (d.class) {
                if (map != null) {
                    if (!map.isEmpty()) {
                        File o = c.a.r0.a.o2.b.o();
                        try {
                            for (Map.Entry<String, PMSAppInfo> entry : map.entrySet()) {
                                String key = entry.getKey();
                                if (!TextUtils.isEmpty(key)) {
                                    if (set != null && set.contains(key)) {
                                        c.a.r0.a.e0.d.k("SwanAppBundleHelper", "删历史版本包，排除id: " + key);
                                    } else {
                                        long j2 = entry.getValue().versionCode;
                                        File file = new File(o, key);
                                        if (file.exists() && file.isDirectory()) {
                                            for (File file2 : c.a.r0.w.d.C(file)) {
                                                if (file2 != null) {
                                                    Pair<Boolean, Long> D = D(file2);
                                                    if (((Boolean) D.first).booleanValue() && ((Long) D.second).longValue() < j2) {
                                                        if (x(key)) {
                                                            break;
                                                        }
                                                        c.a.r0.w.d.L(file2);
                                                        c.a.r0.a.e0.d.k("SwanAppBundleHelper", "删历史版本包，file=" + file2.getAbsolutePath());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            c.a.r0.a.e0.d.l("SwanAppBundleHelper", "#删历史版本包, ex=", e2);
                        }
                    }
                }
            }
        }
    }

    public static synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            synchronized (d.class) {
                if (w()) {
                    c.a.r0.q.c.b().y("SwanAppBundleHelper", "hasDoneFallbackStrategy true");
                    E(str, "repeat");
                    return;
                }
                boolean z = true;
                F(true);
                E(str, "start");
                File g2 = g();
                if (L(g2, str)) {
                    E(str, "canwrite");
                    return;
                }
                c.a.r0.q.a b2 = c.a.r0.q.c.b();
                b2.y("SwanAppBundleHelper", "tryMkdirs fail. Base folder: " + g2.getAbsolutePath() + " child file:" + str);
                if (g2.exists()) {
                    c.a.r0.a.e0.d.k("SwanAppBundleHelper", "#doSwanFolderFallback del: " + g2.getAbsolutePath());
                    c.a.r0.w.d.L(g2);
                }
                if (!g2.exists() && g2.mkdirs() && L(g2, str)) {
                    E(str, "delete");
                    return;
                }
                File h2 = h();
                if (h2.exists() || !h2.mkdirs() || !L(h2, str)) {
                    z = false;
                }
                E(str, "fail:" + z);
            }
        }
    }

    @NonNull
    public static Set<String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            LinkedHashSet<c.a.r0.a.y1.c.f.c> q = c.a.r0.a.y1.c.f.e.k().q();
            HashSet hashSet = new HashSet();
            for (c.a.r0.a.y1.c.f.c cVar : q) {
                if (cVar != null) {
                    String appId = cVar.getAppId();
                    Set<String> L = cVar.L();
                    if (!TextUtils.isEmpty(appId)) {
                        hashSet.add(appId);
                        if (a) {
                            String str = "appId in running - " + appId;
                        }
                    }
                    if (L.size() > 0) {
                        hashSet.addAll(L);
                        if (a) {
                            String str2 = "appId in prefetch - " + L;
                        }
                    }
                }
            }
            if (a) {
                String str3 = "active apps - " + hashSet;
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    public static File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
        }
        return (File) invokeV.objValue;
    }

    public static File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_folder_fallback");
        }
        return (File) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
        }
        return (String) invokeV.objValue;
    }

    public static File j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) ? new File(g(), str) : (File) invokeL.objValue;
    }

    public static File k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, str, str2)) == null) ? new File(j(str), str2) : (File) invokeLL.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_zip";
        }
        return (String) invokeV.objValue;
    }

    public static synchronized String m(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, file)) == null) {
            synchronized (d.class) {
                if (file == null) {
                    return "";
                }
                String path = file.getPath();
                if (a) {
                    String str = "getConfigContent path: " + path;
                }
                String str2 = (String) c.a.r0.a.h0.u.f.b().a(path, "");
                if (TextUtils.isEmpty(str2)) {
                    if (a) {
                        String str3 = "getConfigContent read start: " + path;
                    }
                    String E = c.a.r0.w.d.E(file);
                    c.a.r0.a.h0.u.f.b().c(path, E);
                    if (a) {
                        String str4 = "getConfigContent read end: " + path;
                    }
                    return E;
                }
                return str2;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return i() + File.separator + "database";
        }
        return (String) invokeV.objValue;
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
            return n() + File.separator + str;
        }
        return (String) invokeL.objValue;
    }

    public static File p(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65568, null, str, str2, str3)) == null) ? new File(k(str, str2), o0.g(str3)) : (File) invokeLLL.objValue;
    }

    public static File q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace") : (File) invokeV.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_plugin_workspace";
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static File s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (a) {
                    throw new IllegalArgumentException("plugin name can't be empty");
                }
                return null;
            }
            return new File(q(), str);
        }
        return (File) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static File t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return new File(s(str), str2);
            }
            if (a) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static File u(@NonNull c.a.r0.a.d2.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, eVar)) == null) {
            if (eVar == null) {
                return null;
            }
            b.a V = eVar.V();
            File v = v(eVar.getAppId(), V.v1(), V.o0(), V.h0(), null);
            if (a) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65574, null, new Object[]{str, str2, Boolean.valueOf(z), str3, jSONObject})) == null) {
            if (c.a.r0.a.x1.a.a.H()) {
                j2 = b.e();
            } else if (c.a.r0.a.x1.a.a.D()) {
                j2 = c.a.r0.a.e0.f.d.b.d();
            } else {
                j2 = e.j(str, str2, jSONObject);
            }
            return (!z || TextUtils.isEmpty(str3)) ? j2 : new File(j2, str3);
        }
        return (File) invokeCommon.objValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? h.a().getBoolean("swanapps_has_done_fallback_strategy_key", false) : invokeV.booleanValue;
    }

    public static boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) ? f().contains(str) : invokeL.booleanValue;
    }

    public static boolean y(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, file)) == null) {
            boolean z = false;
            if (file != null && file.exists()) {
                File file2 = new File(file, "app.js");
                boolean exists = file2.exists();
                if (!exists) {
                    c.a.r0.a.e0.d.k("SwanAppBundleHelper", "#isAppJsValid [not exist] app.json");
                }
                long length = exists ? file2.length() : -1L;
                if (exists && length > 0) {
                    z = true;
                }
                if (!z) {
                    c.a.r0.a.n2.s.d dVar = new c.a.r0.a.n2.s.d();
                    c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                    aVar.k(5L);
                    aVar.i(51L);
                    dVar.p(aVar);
                    dVar.l("path", file2.getAbsolutePath());
                    dVar.l("appJs", "isAppJsExist =" + exists + ", appJsSize =" + length);
                    dVar.l("stack", q0.z(30));
                    n.R(dVar);
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean z(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, file)) == null) {
            if (file == null || !file.exists()) {
                return false;
            }
            boolean exists = new File(file, "app.json").exists();
            if (!exists) {
                c.a.r0.a.e0.d.k("SwanAppBundleHelper", "#isAppJsonExist#2 [not exist] app.json");
            }
            return exists;
        }
        return invokeL.booleanValue;
    }
}
