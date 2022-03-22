package c.a.n0.a.d0.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.e2.g.h;
import c.a.n0.q.h.j;
import c.a.n0.q.i.m.i;
import c.a.n0.q.l.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f4052b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, e> f4053c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f4054d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f4055b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Function1 f4056c;

        public a(String str, Ref.ObjectRef objectRef, Function1 function1) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, objectRef, function1};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f4055b = objectRef;
            this.f4056c = function1;
        }

        @Override // c.a.n0.q.l.b.a
        public final void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c cVar = c.f4054d;
                if (c.a) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.a);
                }
                if (z) {
                    c.f4054d.A(this.a, ((j) this.f4055b.element).i);
                    c cVar2 = c.f4054d;
                    String str = this.a;
                    String str2 = ((j) this.f4055b.element).j;
                    Intrinsics.checkNotNullExpressionValue(str2, "soPkg.versionName");
                    cVar2.B(str, str2);
                    c cVar3 = c.f4054d;
                    String str3 = this.a;
                    AbiType abiType = ((j) this.f4055b.element).q;
                    Intrinsics.checkNotNullExpressionValue(abiType, "soPkg.abi");
                    cVar3.y(str3, abiType);
                    c.f4054d.z(this.a, true);
                    this.f4056c.invoke(null);
                    return;
                }
                c.f4054d.z(this.a, false);
                this.f4056c.invoke(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b<MsgType> implements c.a.n0.a.p2.g1.c<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(569285100, "Lc/a/n0/a/d0/k/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(569285100, "Lc/a/n0/a/d0/k/c$b;");
                    return;
                }
            }
            a = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public final void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c cVar = c.f4054d;
                if (c.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("main updatePmsPkg pmsUpdateSo end with e: ");
                    sb.append(exc);
                    sb.append(" trace=");
                    if (exc == null) {
                        exc = new Exception();
                    }
                    sb.append(Log.getStackTraceString(exc));
                    Log.i("SoLibManager", sb.toString());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1573775018, "Lc/a/n0/a/d0/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1573775018, "Lc/a/n0/a/d0/k/c;");
                return;
            }
        }
        f4054d = new c();
        a = c.a.n0.a.a.a;
        f4052b = "swan" + File.separator + "libs" + File.separator + "so";
        f4053c = new LinkedHashMap();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void A(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            h.a().putLong(o(str), j);
        }
    }

    public final void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            h.a().putString(p(str), str2);
        }
    }

    public final void C(d config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            if (a) {
                Log.i("SoLibManager", "main updatePmsPkg start args: " + config);
            }
            config.e(b.a);
            f fVar = new f(new i(5), config);
            if (a) {
                Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo start requester: " + fVar);
            }
            c.a.n0.q.b.o(fVar);
        }
    }

    public final void f(String libName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, libName) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            f4053c.remove(libName);
        }
    }

    public final String g(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jVar)) == null) {
            if ((jVar != null ? jVar.q : null) == null) {
                return "";
            }
            String str = jVar.p;
            Intrinsics.checkNotNullExpressionValue(str, "so.libName");
            AbiType abiType = jVar.q;
            Intrinsics.checkNotNullExpressionValue(abiType, "so.abi");
            return h(str, abiType, jVar.i);
        }
        return (String) invokeL.objValue;
    }

    public final String h(String libName, AbiType abi, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{libName, abi, Long.valueOf(j)})) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            Intrinsics.checkNotNullParameter(abi, "abi");
            if (TextUtils.isEmpty(libName) || j < 1) {
                return "";
            }
            File i = i();
            File file = new File(i, libName + File.separator + j + File.separator + abi.id);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
        return (String) invokeCommon.objValue;
    }

    public final File i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            Intrinsics.checkNotNullExpressionValue(appContext, "AppRuntime.getAppContext()");
            return new File(appContext.getFilesDir(), f4052b);
        }
        return (File) invokeV.objValue;
    }

    public final e j(String libName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, libName)) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            return f4053c.get(libName);
        }
        return (e) invokeL.objValue;
    }

    public final boolean k(String libName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, libName)) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            return l(libName, s(libName));
        }
        return invokeL.booleanValue;
    }

    public final boolean l(String libName, long j) {
        InterceptResult invokeLJ;
        AbiType q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, libName, j)) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            c.a.n0.a.d0.k.a a2 = c.a.n0.a.d0.k.b.a(libName);
            if (a2 != null) {
                if (a2.f()) {
                    return true;
                }
                long s = s(libName);
                if (s > 0 && j <= s && (q = q(libName)) != null) {
                    return AbiType.currentAbi().compat(q);
                }
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return "swan_so_installed_abi_" + str;
        }
        return (String) invokeL.objValue;
    }

    public final String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            return "swan_so_installed_result_" + str;
        }
        return (String) invokeL.objValue;
    }

    public final String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return "swan_so_installed_version_code_" + str;
        }
        return (String) invokeL.objValue;
    }

    public final String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            return "swan_so_installed_version_name_" + str;
        }
        return (String) invokeL.objValue;
    }

    public final AbiType q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? AbiType.findById(h.a().getString(m(str), "")) : (AbiType) invokeL.objValue;
    }

    public final boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? h.a().getBoolean(n(str), true) : invokeL.booleanValue;
    }

    public final long s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? h.a().getLong(o(str), 0L) : invokeL.longValue;
    }

    public final e t(f updater, String libName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, updater, libName)) == null) {
            Intrinsics.checkNotNullParameter(updater, "updater");
            Intrinsics.checkNotNullParameter(libName, "libName");
            e j = j(libName);
            if (j == null) {
                e eVar = new e(updater, libName);
                f4053c.put(libName, eVar);
                return eVar;
            }
            return j;
        }
        return (e) invokeLL.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            z(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, true);
        }
    }

    public final void v(String libName, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048595, this, libName, j) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            SharedPreferences.Editor edit = c.a.n0.q.o.h.a().edit();
            edit.putLong("swan_so_latest_update_time_" + libName, j).apply();
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? !r(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) : invokeV.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [T, c.a.n0.q.h.j] */
    public final void x(String libName, Function1<? super c.a.n0.a.k2.a, Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, libName, callback) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (a) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: libName=" + libName);
            }
            c.a.n0.a.d0.k.a a2 = c.a.n0.a.d0.k.b.a(libName);
            if (a2 == null) {
                if (a) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + libName);
                }
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(16);
                aVar.b(2900);
                aVar.f("not available: so=" + a2);
                callback.invoke(aVar);
            } else if (a2.f()) {
                if (a) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + a2);
                }
                callback.invoke(null);
            } else {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? t = c.a.n0.q.f.a.i().t(libName);
                objectRef.element = t;
                if (((j) t) != null && ((j) t).a() && AbiType.currentAbi().compat(((j) objectRef.element).q)) {
                    AbiType q = q(libName);
                    if (l(libName, ((j) objectRef.element).i) && q != null && q.compat(((j) objectRef.element).q)) {
                        if (a) {
                            Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + libName + " soPkg=" + ((j) objectRef.element));
                        }
                        callback.invoke(null);
                        return;
                    }
                    a2.a(((j) objectRef.element).a, new a(libName, objectRef, callback));
                    return;
                }
                if (a) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + libName + " soPkg=" + ((j) objectRef.element));
                }
                c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
                aVar2.k(16);
                aVar2.b(2900);
                aVar2.f("invalid: pkg=" + ((j) objectRef.element));
                callback.invoke(aVar2);
            }
        }
    }

    public final void y(String str, AbiType abiType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, abiType) == null) {
            h.a().putString(m(str), abiType.id);
        }
    }

    public final void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048599, this, str, z) == null) {
            h.a().putBoolean(n(str), z);
        }
    }
}
