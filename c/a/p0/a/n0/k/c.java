package c.a.p0.a.n0.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.k2.g.h;
import c.a.p0.n.h.i;
import c.a.p0.n.l.b;
import c.a.p0.n.o.g;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7527a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f7528b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, e> f7529c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f7530d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7531a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f7532b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Function1 f7533c;

        public a(String str, Ref.ObjectRef objectRef, Function1 function1) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, objectRef, function1};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7531a = str;
            this.f7532b = objectRef;
            this.f7533c = function1;
        }

        @Override // c.a.p0.n.l.b.a
        public final void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c cVar = c.f7530d;
                if (c.f7527a) {
                    String str = "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.f7531a;
                }
                if (z) {
                    c.f7530d.A(this.f7531a, ((i) this.f7532b.element).f11887i);
                    c cVar2 = c.f7530d;
                    String str2 = this.f7531a;
                    String str3 = ((i) this.f7532b.element).f11888j;
                    Intrinsics.checkNotNullExpressionValue(str3, "soPkg.versionName");
                    cVar2.B(str2, str3);
                    c cVar3 = c.f7530d;
                    String str4 = this.f7531a;
                    AbiType abiType = ((i) this.f7532b.element).q;
                    Intrinsics.checkNotNullExpressionValue(abiType, "soPkg.abi");
                    cVar3.y(str4, abiType);
                    c.f7530d.z(this.f7531a, true);
                    this.f7533c.invoke(null);
                    return;
                }
                c.f7530d.z(this.f7531a, false);
                this.f7533c.invoke(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b<MsgType> implements c.a.p0.a.v2.e1.b<Exception> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final b f7534e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1336507596, "Lc/a/p0/a/n0/k/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1336507596, "Lc/a/p0/a/n0/k/c$b;");
                    return;
                }
            }
            f7534e = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public final void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c cVar = c.f7530d;
                if (c.f7527a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("main updatePmsPkg pmsUpdateSo end with e: ");
                    sb.append(exc);
                    sb.append(" trace=");
                    if (exc == null) {
                        exc = new Exception();
                    }
                    sb.append(Log.getStackTraceString(exc));
                    sb.toString();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2117042674, "Lc/a/p0/a/n0/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2117042674, "Lc/a/p0/a/n0/k/c;");
                return;
            }
        }
        f7530d = new c();
        f7527a = k.f7077a;
        f7528b = "swan" + File.separator + "libs" + File.separator + "so";
        f7529c = new LinkedHashMap();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void A(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            h.a().putLong(o(str), j2);
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
            if (f7527a) {
                String str = "main updatePmsPkg start args: " + config;
            }
            config.e(b.f7534e);
            f fVar = new f(new c.a.p0.n.i.m.h(5), config);
            if (f7527a) {
                String str2 = "main updatePmsPkg pmsUpdateSo start requester: " + fVar;
            }
            c.a.p0.n.b.m(fVar);
        }
    }

    public final void f(String libName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, libName) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            f7529c.remove(libName);
        }
    }

    public final String g(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iVar)) == null) {
            if ((iVar != null ? iVar.q : null) == null) {
                return "";
            }
            String str = iVar.p;
            Intrinsics.checkNotNullExpressionValue(str, "so.libName");
            AbiType abiType = iVar.q;
            Intrinsics.checkNotNullExpressionValue(abiType, "so.abi");
            return h(str, abiType, iVar.f11887i);
        }
        return (String) invokeL.objValue;
    }

    public final String h(String libName, AbiType abi, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{libName, abi, Long.valueOf(j2)})) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            Intrinsics.checkNotNullParameter(abi, "abi");
            if (TextUtils.isEmpty(libName) || j2 < 1) {
                return "";
            }
            File i2 = i();
            File file = new File(i2, libName + File.separator + j2 + File.separator + abi.id);
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
            return new File(appContext.getFilesDir(), f7528b);
        }
        return (File) invokeV.objValue;
    }

    public final e j(String libName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, libName)) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            return f7529c.get(libName);
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

    public final boolean l(String libName, long j2) {
        InterceptResult invokeLJ;
        AbiType q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, libName, j2)) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            c.a.p0.a.n0.k.a a2 = c.a.p0.a.n0.k.b.a(libName);
            if (a2 != null) {
                if (a2.f()) {
                    return true;
                }
                long s = s(libName);
                if (s > 0 && j2 <= s && (q = q(libName)) != null) {
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
            e j2 = j(libName);
            if (j2 == null) {
                e eVar = new e(updater, libName);
                f7529c.put(libName, eVar);
                return eVar;
            }
            return j2;
        }
        return (e) invokeLL.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            z(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, true);
        }
    }

    public final void v(String libName, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048595, this, libName, j2) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            SharedPreferences.Editor edit = g.a().edit();
            edit.putLong("swan_so_latest_update_time_" + libName, j2).apply();
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? !r(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) : invokeV.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [c.a.p0.n.h.i, T] */
    public final void x(String libName, Function1<? super c.a.p0.a.q2.a, Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, libName, callback) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (f7527a) {
                r0 = "tryInstallUpdatePkg: libName=" + libName;
            }
            c.a.p0.a.n0.k.a a2 = c.a.p0.a.n0.k.b.a(libName);
            if (a2 == null) {
                if (f7527a) {
                    String str = "tryInstallUpdatePkg: return by soLib unavailable update libname=" + libName;
                }
                c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
                aVar.j(16);
                aVar.b(2900);
                aVar.e("not available: so=" + a2);
                callback.invoke(aVar);
            } else if (a2.f()) {
                if (f7527a) {
                    String str2 = "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + a2;
                }
                callback.invoke(null);
            } else {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? r = c.a.p0.n.g.a.h().r(libName);
                objectRef.element = r;
                if (((i) r) != null && ((i) r).a() && AbiType.currentAbi().compat(((i) objectRef.element).q)) {
                    AbiType q = q(libName);
                    if (l(libName, ((i) objectRef.element).f11887i) && q != null && q.compat(((i) objectRef.element).q)) {
                        if (f7527a) {
                            String str3 = "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + libName + " soPkg=" + ((i) objectRef.element);
                        }
                        callback.invoke(null);
                        return;
                    }
                    a2.a(((i) objectRef.element).f11879a, new a(libName, objectRef, callback));
                    return;
                }
                if (f7527a) {
                    String str4 = "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + libName + " soPkg=" + ((i) objectRef.element);
                }
                c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
                aVar2.j(16);
                aVar2.b(2900);
                aVar2.e("invalid: pkg=" + ((i) objectRef.element));
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
