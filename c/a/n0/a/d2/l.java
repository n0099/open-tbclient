package c.a.n0.a.d2;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile l f4141b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1208399835, "Lc/a/n0/a/d2/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1208399835, "Lc/a/n0/a/d2/l;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
    }

    public l() {
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

    public static l a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f4141b == null) {
                synchronized (l.class) {
                    if (f4141b == null) {
                        f4141b = new l();
                    }
                }
            }
            return f4141b;
        }
        return (l) invokeV.objValue;
    }

    public void b(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (ProcessUtils.isMainProcess() && (aVar = this.a) != null) {
                aVar.a("swanLauncherTag", str);
            } else {
                c("swanLauncherTag", str);
            }
        }
    }

    public final void c(String str, String str2) {
        c.a.n0.a.o1.c.e.a z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || (z = c.a.n0.a.t1.d.J().z()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("statTag", str);
        bundle.putString("statisticData", str2);
        z.V(bundle, k.class);
    }
}
