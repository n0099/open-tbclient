package b.a.p0.a.p0.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.k;
import b.a.p0.a.p0.h.b;
import b.a.p0.a.p0.i.a;
import b.a.p0.a.z2.g1.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class b<P extends b.a.p0.a.p0.h.b, R extends b.a.p0.a.p0.i.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f7621c;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public P f7622a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public R f7623b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(107408349, "Lb/a/p0/a/p0/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(107408349, "Lb/a/p0/a/p0/d/b;");
                return;
            }
        }
        f7621c = k.f6863a;
    }

    public b(@NonNull P p, @NonNull R r) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p, r};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7622a = p;
        this.f7623b = r;
    }

    public <T extends b.a.p0.a.p0.g.a> Exception a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            if (t == null) {
                return new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo");
            }
            return this.f7623b.e(t);
        }
        return (Exception) invokeL.objValue;
    }

    public abstract String b(int i2);

    @Nullable
    public abstract ExtensionCore c();

    @NonNull
    public ExtensionCore d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int c2 = this.f7622a.f7620a.c();
            if (b.a.p0.a.p0.j.a.f(c2)) {
                ExtensionCore extensionCore = new ExtensionCore();
                extensionCore.extensionCoreVersionCode = 0L;
                extensionCore.extensionCoreVersionName = "0";
                extensionCore.extensionCorePath = b(c2);
                extensionCore.extensionCoreType = 2;
                if (f7621c) {
                    String str = "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString();
                }
                return extensionCore;
            }
            ExtensionCore h2 = this.f7622a.h();
            ExtensionCore f2 = this.f7623b.f();
            if (h2.extensionCoreVersionCode < f2.extensionCoreVersionCode && f2.isAvailable()) {
                if (f7621c) {
                    String str2 = "getExtensionCoreInMainProcess: remote=>" + f2.toString();
                }
                return f2;
            }
            if (f7621c) {
                String str3 = "getExtensionCoreInMainProcess: preset=>" + h2.toString();
            }
            return h2;
        }
        return (ExtensionCore) invokeV.objValue;
    }

    @NonNull
    public P e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7622a : (P) invokeV.objValue;
    }

    @NonNull
    public R f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f7623b : (R) invokeV.objValue;
    }

    public void g(@Nullable c<Exception> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f7622a.p(cVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f7622a.q();
        }
    }
}
