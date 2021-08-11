package c.a.n0.a.m2;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a1.e;
import c.a.n0.a.e0.d;
import c.a.n0.a.h0.m.i;
import c.a.n0.a.h0.m.l;
import c.a.n0.a.j2.c;
import c.a.n0.a.k;
import c.a.n0.a.k2.g.h;
import c.a.n0.a.m2.f.b;
import c.a.n0.a.v1.b.f;
import c.a.n0.a.v2.l0;
import c.a.n0.a.v2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7103a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f7105f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7106g;

        public a(int i2, long j2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7104e = i2;
            this.f7105f = j2;
            this.f7106g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.b bVar = new c.b(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION);
                bVar.k(String.valueOf(this.f7104e));
                bVar.l(String.valueOf(this.f7105f));
                bVar.j(String.valueOf(this.f7106g));
                bVar.m();
            }
        }
    }

    /* renamed from: c.a.n0.a.m2.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0287b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0287b() {
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

        @Nullable
        public static SwanCoreVersion b(Bundle bundle, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bundle, i2)) == null) {
                if (bundle == null) {
                    return null;
                }
                bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
                if (i2 == 1) {
                    return (SwanCoreVersion) bundle.getParcelable("aiapps_game_core");
                }
                return (SwanCoreVersion) bundle.getParcelable("aiapps_swan_core");
            }
            return (SwanCoreVersion) invokeLI.objValue;
        }

        public SwanCoreVersion a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                SwanCoreVersion e2 = b.e(i2);
                if (e2.isAvailable()) {
                    return e2;
                }
                c.a.n0.a.m2.e.b.b().f(i2);
                return b.e(i2);
            }
            return (SwanCoreVersion) invokeI.objValue;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("aiapps_swan_core", a(0));
                bundle2.putParcelable("aiapps_game_core", a(1));
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1216711214, "Lc/a/n0/a/m2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1216711214, "Lc/a/n0/a/m2/b;");
                return;
            }
        }
        f7103a = k.f6803a;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            c.a.n0.a.m2.f.a.b(0);
            c.a.n0.a.m2.e.a.b(0);
            c.a.n0.a.m2.f.a.b(1);
            c.a.n0.a.m2.e.a.b(1);
        }
    }

    public static void b(File file, List<Long> list) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, file, list) == null) || file == null) {
            return;
        }
        d.h("SwanAppSwanCoreManager", "deleteOldSwanCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(list.toArray()));
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (f7103a) {
                    String str = "deleteOldSwanCores versionFolder: " + file2;
                }
                if (!k(file2, list)) {
                    if (f7103a) {
                        String str2 = "deleteOldSwanCores deleteFolder: " + file2;
                    }
                    c.a.n0.t.d.i(file2);
                }
            }
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.a.n0.a.m2.d.a.e() : invokeV.booleanValue;
    }

    public static File d(int i2) {
        InterceptResult invokeI;
        File b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (i2 == 1 && (b2 = c.a.n0.a.c1.b.g().b()) != null) {
                return new File(b2, "game_core");
            }
            return new File(e.g(), "swan_core");
        }
        return (File) invokeI.objValue;
    }

    public static SwanCoreVersion e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            boolean z = i2 == 0;
            if (j() && z) {
                SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
                swanCoreVersion.swanCorePath = c.a.n0.a.m2.d.a.c().getPath();
                swanCoreVersion.swanCoreType = 2;
                long b2 = c.a.n0.a.m2.d.a.b();
                swanCoreVersion.swanCoreVersionCode = b2;
                swanCoreVersion.swanCoreVersionName = l0.d(b2);
                boolean isAvailable = swanCoreVersion.isAvailable();
                if (f7103a) {
                    String str = "DebugSwanCoreMode-debugCoreAvailable:" + isAvailable;
                }
                if (isAvailable) {
                    return swanCoreVersion;
                }
                q(false);
            }
            SwanCoreVersion m = c.a.n0.a.m2.e.a.m(i2);
            SwanCoreVersion d2 = c.a.n0.a.m2.f.a.d(i2);
            if (f7103a) {
                String str2 = "getSwanCoreVersion presetVerName=" + m.swanCoreVersionName + ", presetVerCode=" + m.swanCoreVersionCode + ", remoteVerName=" + d2.swanCoreVersionName + ", remoteVerCode=" + d2.swanCoreVersionCode;
            }
            return (m.swanCoreVersionCode >= d2.swanCoreVersionCode || !d2.isAvailable()) ? m : d2;
        }
        return (SwanCoreVersion) invokeI.objValue;
    }

    public static long f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) {
            SwanCoreVersion e2 = e(i2);
            if (e2 != null) {
                return e2.swanCoreVersionCode;
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    @Nullable
    public static SwanCoreVersion g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return e(i2);
            }
            f b2 = c.a.n0.a.v1.b.d.b(C0287b.class, null);
            if (f7103a) {
                String str = "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + C0287b.b(b2.f8955a, i2);
            }
            return C0287b.b(b2.f8955a, i2);
        }
        return (SwanCoreVersion) invokeI.objValue;
    }

    public static String h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? i(null, i2) : (String) invokeI.objValue;
    }

    public static String i(SwanCoreVersion swanCoreVersion, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, swanCoreVersion, i2)) == null) {
            if (swanCoreVersion == null) {
                swanCoreVersion = e(i2);
            }
            if (swanCoreVersion.swanCoreVersionCode > 0) {
                return swanCoreVersion.swanCoreVersionName;
            }
            String e2 = c.a.n0.a.m2.e.a.k(i2).e();
            if (f7103a) {
                String str = "getSwanCoreVersionName preset config: " + e2;
            }
            return TextUtils.isEmpty(e2) ? "0" : e2;
        }
        return (String) invokeLI.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? h.a().getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false) : invokeV.booleanValue;
    }

    public static boolean k(File file, List<Long> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, file, list)) == null) {
            if (list == null) {
                return false;
            }
            String name = file.getName();
            for (Long l : list) {
                if (TextUtils.equals(name, String.valueOf(l.longValue()))) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65548, null, i2, i3) == null) {
            if (f7103a) {
                String str = "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3;
            }
            if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i2 != i3) {
                a();
                c.a.n0.a.m2.e.a.v(true, 0);
                c.a.n0.a.m2.e.a.v(true, 1);
                c.a.n0.a.m2.e.a.w(false, 0);
                e.E(false);
            }
        }
    }

    public static void m(int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            q.j(new a(i3, j2, i2), "reportZipFileCheckFailed");
        }
    }

    public static void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i2) == null) {
            o(i2, null);
        }
    }

    public static void o(int i2, c.a.n0.a.v2.e1.b<Exception> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65551, null, i2, bVar) == null) {
            b.C0291b b2 = b.C0291b.b();
            b2.c(true);
            b2.d("openSwanApp");
            p(b2.a(), i2, bVar);
        }
    }

    public static void p(c.a.n0.a.m2.f.b bVar, int i2, c.a.n0.a.v2.e1.b<Exception> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65552, null, bVar, i2, bVar2) == null) {
            c.a.n0.n.i.m.h hVar = new c.a.n0.n.i.m.h(i2);
            if (i2 == 0) {
                c.a.n0.n.b.j(hVar, new i(bVar2));
                return;
            }
            l p = c.a.n0.a.c1.b.i().p(bVar2);
            if (p != null) {
                c.a.n0.n.b.k(hVar, new i(null), p);
            } else if (bVar2 != null) {
                bVar2.onCallback(null);
            }
        }
    }

    public static void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, null, z) == null) {
            h.a().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z);
        }
    }
}
