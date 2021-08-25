package c.a.o0.a.e0.f.c;

import android.os.Bundle;
import c.a.o0.a.v2.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b implements c.a.o0.a.e0.f.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f5162a = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1886863172, "Lc/a/o0/a/e0/f/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1886863172, "Lc/a/o0/a/e0/f/c/b;");
        }
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

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f5162a : (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.e0.f.a
    public void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            f5162a = v.i(bundle, "adb_debug_path");
            c.a.o0.a.e0.f.b.i(v.i(bundle, PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD));
            c.a.o0.a.e0.f.b.j(v.i(bundle, "slavePreload"));
        }
    }

    @Override // c.a.o0.a.e0.f.a
    public void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            bundle.putString("adb_debug_path", f5162a);
            bundle.putString("slavePreload", c.a.o0.a.e0.f.b.c());
            bundle.putString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, c.a.o0.a.e0.f.b.a());
        }
    }

    @Override // c.a.o0.a.e0.f.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a.b().getPath() : (String) invokeV.objValue;
    }
}
