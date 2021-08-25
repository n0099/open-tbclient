package c.a.o0.a.p0.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.a.k;
import c.a.o0.a.p0.h.b;
import c.a.o0.a.p0.i.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class b<P extends c.a.o0.a.p0.h.b, R extends c.a.o0.a.p0.i.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f7877c;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public P f7878a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public R f7879b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-532208547, "Lc/a/o0/a/p0/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-532208547, "Lc/a/o0/a/p0/d/b;");
                return;
            }
        }
        f7877c = k.f7049a;
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
        this.f7878a = p;
        this.f7879b = r;
    }

    public <T extends c.a.o0.a.p0.g.a> Exception a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            if (t == null) {
                return new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo");
            }
            return this.f7879b.e(t);
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
            int c2 = this.f7878a.f7876a.c();
            if (c.a.o0.a.p0.j.a.f(c2)) {
                ExtensionCore extensionCore = new ExtensionCore();
                extensionCore.extensionCoreVersionCode = 0L;
                extensionCore.extensionCoreVersionName = "0";
                extensionCore.extensionCorePath = b(c2);
                extensionCore.extensionCoreType = 2;
                if (f7877c) {
                    String str = "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString();
                }
                return extensionCore;
            }
            ExtensionCore h2 = this.f7878a.h();
            ExtensionCore f2 = this.f7879b.f();
            if (h2.extensionCoreVersionCode < f2.extensionCoreVersionCode && f2.isAvailable()) {
                if (f7877c) {
                    String str2 = "getExtensionCoreInMainProcess: remote=>" + f2.toString();
                }
                return f2;
            }
            if (f7877c) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7878a : (P) invokeV.objValue;
    }

    @NonNull
    public R f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f7879b : (R) invokeV.objValue;
    }

    public void g(@Nullable c.a.o0.a.v2.e1.b<Exception> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f7878a.p(bVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f7878a.q();
        }
    }
}
