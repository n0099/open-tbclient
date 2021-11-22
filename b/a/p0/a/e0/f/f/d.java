package b.a.p0.a.e0.f.f;

import android.os.Bundle;
import b.a.p0.a.d2.e;
import b.a.p0.a.z2.f;
import b.a.p0.a.z2.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d implements b.a.p0.a.e0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f4657a;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    public static void d() {
        e L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (L = e.L()) == null) {
            return;
        }
        f.j(L.getActivity());
        System.exit(0);
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f4657a : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.e0.f.a
    public void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            f4657a = v.i(bundle, "extraWSUrl");
            b.a.p0.a.e0.f.b.i(v.i(bundle, PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD));
            b.a.p0.a.e0.f.b.j(v.i(bundle, "slavePreload"));
        }
    }

    @Override // b.a.p0.a.e0.f.a
    public void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            bundle.putString("extraWSUrl", f4657a);
            bundle.putString("slavePreload", b.a.p0.a.e0.f.b.c());
            bundle.putString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, b.a.p0.a.e0.f.b.a());
        }
    }

    @Override // b.a.p0.a.e0.f.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b.e().getPath() : (String) invokeV.objValue;
    }
}
