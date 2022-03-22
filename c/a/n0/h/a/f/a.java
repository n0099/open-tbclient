package c.a.n0.h.a.f;

import c.a.n0.a.s0.c.d;
import c.a.n0.a.s0.c.e;
import c.a.n0.h.a.f.b.c;
import c.a.n0.j.u.b.b;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@Autowired
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Inject(force = false)
    public static c.a.n0.h.a.f.b.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? b.a() : (c.a.n0.h.a.f.b.a) invokeV.objValue;
    }

    @Inject
    public static c.a.n0.h.a.f.b.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? d.a() : (c.a.n0.h.a.f.b.b) invokeV.objValue;
    }

    @Inject
    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new e() : (c) invokeV.objValue;
    }
}
