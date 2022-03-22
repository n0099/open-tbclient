package c.a.n0.a.f0.d;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.f0.h.b;
import c.a.n0.a.f0.i.a;
import c.a.n0.a.p2.g1.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class b<P extends c.a.n0.a.f0.h.b, R extends c.a.n0.a.f0.i.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f4348c;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public P a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public R f4349b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-946393484, "Lc/a/n0/a/f0/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-946393484, "Lc/a/n0/a/f0/d/b;");
                return;
            }
        }
        f4348c = c.a.n0.a.a.a;
    }

    public b(@NonNull P p, @NonNull R r) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p, r};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = p;
        this.f4349b = r;
    }

    public <T extends c.a.n0.a.f0.g.a> Exception a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            if (t == null) {
                return new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo");
            }
            return this.f4349b.e(t);
        }
        return (Exception) invokeL.objValue;
    }

    public abstract String b(int i);

    @Nullable
    public abstract ExtensionCore c();

    @NonNull
    public ExtensionCore d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int c2 = this.a.a.c();
            if (c.a.n0.a.f0.j.a.f(c2)) {
                ExtensionCore extensionCore = new ExtensionCore();
                extensionCore.extensionCoreVersionCode = 0L;
                extensionCore.extensionCoreVersionName = "0";
                extensionCore.extensionCorePath = b(c2);
                extensionCore.extensionCoreType = 2;
                if (f4348c) {
                    Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
                }
                return extensionCore;
            }
            ExtensionCore h2 = this.a.h();
            ExtensionCore f2 = this.f4349b.f();
            if (h2.extensionCoreVersionCode < f2.extensionCoreVersionCode && f2.isAvailable()) {
                if (f4348c) {
                    Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + f2.toString());
                }
                return f2;
            }
            if (f4348c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + h2.toString());
            }
            return h2;
        }
        return (ExtensionCore) invokeV.objValue;
    }

    @NonNull
    public P e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (P) invokeV.objValue;
    }

    @NonNull
    public R f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f4349b : (R) invokeV.objValue;
    }

    public void g(@Nullable c<Exception> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.a.p(cVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.q();
        }
    }
}
