package b.a.p0.j.t;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.d;
import b.a.p0.a.a1.g.a;
import b.a.p0.a.d2.e;
import b.a.p0.a.k;
import b.a.p0.a.u1.h;
import b.a.p0.w.f;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11458a;

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f11459b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.j.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class RunnableC0624a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f11460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a1.b f11461f;

        public RunnableC0624a(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11460e = bVar;
            this.f11461f = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.z2.b1.b bVar = new b.a.p0.a.z2.b1.b();
                if (this.f11460e.n0() && (b.a.p0.a.x1.a.a.x() || a.f11458a)) {
                    j = b.a(this.f11460e, bVar);
                } else {
                    j = d.j(this.f11460e, bVar);
                }
                this.f11461f.a(0, j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static c a(b.a.p0.a.f1.e.b bVar, b.a.p0.a.z2.b1.b bVar2) {
            InterceptResult invokeLL;
            File file;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bVar, bVar2)) == null) {
                File b2 = b(bVar2);
                if (b2 == null) {
                    return null;
                }
                e L = e.L();
                String b3 = f.b(b2, false);
                File d2 = d(b3);
                if (L == null) {
                    if (!a.i(b2, d2, bVar, bVar2)) {
                        b.a.p0.a.c2.b.f.e.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").G();
                        b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                        aVar.k(5L);
                        aVar.i(7L);
                        aVar.f("小游戏bundle解压失败! for debug");
                        b.a.p0.a.u2.e.a().f(aVar);
                        if (bVar2 != null && bVar2.f9733a == null) {
                            bVar2.f9733a = aVar;
                        }
                        return null;
                    }
                } else if (!TextUtils.equals(L.d0().q("installed_debug_game_bundle_md5", ""), b3)) {
                    if (!a.i(b2, d2, bVar, bVar2)) {
                        b.a.p0.a.c2.b.f.e.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").G();
                        b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                        aVar2.k(5L);
                        aVar2.i(7L);
                        aVar2.f("小游戏bundle解压失败! for debug");
                        b.a.p0.a.u2.e.a().f(aVar2);
                        if (bVar2 != null && bVar2.f9733a == null) {
                            bVar2.f9733a = aVar2;
                        }
                        return null;
                    }
                    L.d0().B("installed_debug_game_bundle_md5", b3);
                }
                c cVar = new c();
                b.a.p0.j.d0.a.a a2 = b.a.p0.j.d0.a.a.a(b.a.p0.w.d.E(new File(d2, "game.json")));
                if (a2 == null) {
                    return null;
                }
                cVar.f11462a = d2.getPath() + File.separator;
                cVar.f11464c = a2;
                if (!TextUtils.isEmpty(a2.f11056e)) {
                    cVar.f11463b = cVar.f11462a + a2.f11056e + File.separator;
                    b.a.p0.j.a0.f.a().d(true);
                    b.a.p0.j.a0.f.a().e(cVar.f11463b);
                    b.a.p0.j.a0.f.a().f(a2.f11056e);
                } else {
                    b.a.p0.j.a0.f.a().d(false);
                }
                if (a.f11458a) {
                    String str = "configFile path: " + file.getPath();
                    String str2 = "configFile exist: " + file.exists();
                    String str3 = "info.appBundlePath path: " + cVar.f11462a;
                    String str4 = "info.mAppOpenDataBundle path: " + cVar.f11463b;
                }
                return cVar;
            }
            return (c) invokeLL.objValue;
        }

        public static File b(b.a.p0.a.z2.b1.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
                File c2 = c();
                File[] listFiles = c2.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    return e(listFiles);
                }
                Context appContext = AppRuntime.getAppContext();
                b.a.p0.a.c2.b.f.e.g(appContext, c2.getPath() + " 没有测试程序包!").G();
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(5L);
                aVar.i(4L);
                aVar.f("没有小游戏包! for debug, bundle files are empty");
                b.a.p0.a.u2.e.a().f(aVar);
                if (bVar != null) {
                    bVar.f9733a = aVar;
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
                File e2 = a.e("aigames_debug");
                if (!e2.exists()) {
                    e2.mkdirs();
                }
                return e2;
            }
            return (File) invokeV.objValue;
        }

        public static File d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
                file.mkdirs();
                return file;
            }
            return (File) invokeL.objValue;
        }

        public static File e(File[] fileArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fileArr)) == null) {
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

    /* loaded from: classes4.dex */
    public static class c extends b.a.p0.a.a1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f11462a;

        /* renamed from: b  reason: collision with root package name */
        public String f11463b;

        /* renamed from: c  reason: collision with root package name */
        public b.a.p0.j.d0.a.a f11464c;

        public c() {
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

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b.a.p0.j.t.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0625a implements FileFilter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0625a() {
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
            File[] listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new C0625a());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                if (i(str2, file.getName())) {
                    if (a.f11458a) {
                        String str3 = "删除低版本文件夹：" + file.getAbsolutePath();
                    }
                    b.a.p0.q.g.a.i().d(str, file.getName());
                    b.a.p0.w.d.j(file);
                }
            }
        }

        public static void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            File e2 = e(str, false);
            if (e2 != null) {
                b.a.p0.w.d.L(e2);
            }
            b.a.p0.w.d.L(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
        }

        @Nullable
        public static File e(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, z)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return f(str, z, null);
            }
            return (File) invokeLZ.objValue;
        }

        public static File f(String str, boolean z, b.a.p0.a.z2.b1.b bVar) {
            InterceptResult invokeCommon;
            File g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, Boolean.valueOf(z), bVar})) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File[] listFiles = g().listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    if (a.f11458a && z) {
                        b.a.p0.a.c2.b.f.e.g(AppRuntime.getAppContext(), g2.getPath() + " 没有小游戏包!").G();
                    }
                    b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                    aVar.k(5L);
                    aVar.i(4L);
                    aVar.f("没有小游戏包! for release, bundle files are empty");
                    b.a.p0.a.u2.e.a().f(aVar);
                    if (bVar != null) {
                        bVar.f9733a = aVar;
                    }
                    return null;
                }
                for (File file : listFiles) {
                    if (TextUtils.equals(file.getName(), str + ".aigames")) {
                        return file;
                    }
                }
                if (a.f11458a && z) {
                    b.a.p0.a.c2.b.f.e.g(AppRuntime.getAppContext(), g2.getPath() + " 没有小游戏包!").G();
                }
                b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                aVar2.k(5L);
                aVar2.i(4L);
                aVar2.f("没有小游戏包! for release, no such bundle file");
                b.a.p0.a.u2.e.a().f(aVar2);
                if (bVar != null) {
                    bVar.f9733a = aVar2;
                }
                return null;
            }
            return (File) invokeCommon.objValue;
        }

        public static File g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static File h(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
                return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
            }
            return (File) invokeLL.objValue;
        }

        public static boolean i(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
                if (a.f11458a) {
                    String str3 = "curVersion:" + str + ",targetVersion:" + str2;
                }
                try {
                    return a(str, str2) > 0;
                } catch (IllegalArgumentException e2) {
                    if (a.f11458a) {
                        String str4 = "比较版本号Exception：" + e2.getMessage();
                    }
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static c j(b.a.p0.a.f1.e.b bVar, b.a.p0.a.z2.b1.b bVar2) {
            InterceptResult invokeLL;
            File file;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bVar, bVar2)) == null) {
                if (bVar == null) {
                    return null;
                }
                File h2 = h(bVar.H(), bVar.v1());
                if (!h2.exists()) {
                    File f2 = f(bVar.H(), true, bVar2);
                    if (f2 == null) {
                        b.a.p0.a.y1.c.e.a.P().Z(8, new SwanAppDeleteInfo(bVar.H(), 1).setPurgerScenes(5));
                        return null;
                    }
                    b(h2);
                    if (!a.i(f2, h2, bVar, bVar2)) {
                        b.a.p0.a.c2.b.f.e.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").G();
                        b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                        aVar.k(5L);
                        aVar.i(7L);
                        aVar.f("小游戏bundle解压失败! for release");
                        b.a.p0.a.u2.e.a().f(aVar);
                        if (bVar2 != null && bVar2.f9733a == null) {
                            bVar2.f9733a = aVar;
                        }
                        return null;
                    }
                }
                c(bVar.H(), bVar.v1());
                c cVar = new c();
                b.a.p0.j.d0.a.a a2 = b.a.p0.j.d0.a.a.a(b.a.p0.w.d.E(new File(h2, "game.json")));
                if (a2 == null) {
                    return null;
                }
                cVar.f11462a = h2.getPath() + File.separator;
                cVar.f11464c = a2;
                if (!TextUtils.isEmpty(a2.f11056e)) {
                    cVar.f11463b = cVar.f11462a + File.separator + a2.f11056e + File.separator;
                    b.a.p0.j.a0.f.a().d(true);
                    b.a.p0.j.a0.f.a().e(cVar.f11463b);
                    b.a.p0.j.a0.f.a().f(a2.f11056e);
                } else {
                    b.a.p0.j.a0.f.a().d(false);
                }
                if (a.f11458a) {
                    String str = "configFile path: " + file.getPath();
                    String str2 = "configFile exist: " + file.exists();
                    r0 = "info.appBundlePath path: " + cVar.f11462a;
                    String str3 = "info.mAppOpenDataBundle path: " + cVar.f11463b;
                }
                return cVar;
            }
            return (c) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-807630334, "Lb/a/p0/j/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-807630334, "Lb/a/p0/j/t/a;");
                return;
            }
        }
        f11458a = k.f6863a;
        f11459b = Executors.newSingleThreadExecutor();
    }

    public static void c(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, bVar, bVar2) == null) {
            f11459b.execute(new RunnableC0624a(bVar, bVar2));
        }
    }

    public static File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
        }
        return (File) invokeV.objValue;
    }

    public static File e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
            return TextUtils.isEmpty(str) ? file : new File(file, str);
        }
        return (File) invokeL.objValue;
    }

    public static void f(String str, d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, cVar) == null) {
            d.C0111d c0111d = new d.C0111d();
            c0111d.f3995a = str;
            b.a.p0.j.m.b.b.a();
            new b.a.p0.a.k0.b().e(c0111d, b.a.p0.j.m.b.b.c().getPath(), cVar);
        }
    }

    public static void g(String str, d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, cVar) == null) {
            d.C0111d c0111d = new d.C0111d();
            c0111d.f3995a = str;
            b.a.p0.j.p.a.b.a();
            new b.a.p0.a.k0.b().e(c0111d, b.a.p0.j.p.a.b.c().getPath(), cVar);
        }
    }

    public static void h(d.C0111d c0111d, d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, c0111d, cVar) == null) {
            File c2 = b.c();
            new b.a.p0.a.k0.b().e(c0111d, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
        }
    }

    public static boolean i(File file, File file2, b.a.p0.a.f1.e.b bVar, b.a.p0.a.z2.b1.b bVar2) {
        InterceptResult invokeLLLL;
        boolean U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, file, file2, bVar, bVar2)) == null) {
            int i2 = 0;
            if (file != null && file2 != null) {
                if (file.exists() && file.length() != 0) {
                    h.o().F(new UbcFlowEvent("package_start_unzip"));
                    long currentTimeMillis = System.currentTimeMillis();
                    a.c j = b.a.p0.a.a1.g.a.j(file);
                    int i3 = j.f4025b;
                    if (i3 != -1) {
                        U = b.a.p0.a.a1.g.a.d(j.f4024a, file2, i3).f4022a;
                        i2 = j.f4025b;
                    } else {
                        U = b.a.p0.w.d.U(file.getPath(), file2.getPath());
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (f11458a) {
                        b.a.p0.a.a1.g.a.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (!U) {
                        b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                        aVar.k(5L);
                        aVar.i(7L);
                        aVar.f("小游戏bundle解压失败! PkgType=" + i2);
                        if (bVar2 != null) {
                            bVar2.f9733a = aVar;
                        }
                    }
                    HybridUbcFlow o = h.o();
                    o.F(new UbcFlowEvent("package_end_unzip"));
                    o.D("app_package_version", String.valueOf(i2));
                    return U;
                }
                b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                aVar2.k(5L);
                aVar2.i(4L);
                aVar2.f("小游戏bundle文件不存在或者空文件! ");
                if (bVar2 != null) {
                    bVar2.f9733a = aVar2;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
