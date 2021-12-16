package c.a.q0.h.i.n;

import c.a.q0.a.c1.c.d;
import c.a.q0.a.c1.c.e;
import c.a.q0.h.i.n.b.c;
import c.a.q0.j.u.b.b;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@Autowired
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Inject(force = false)
    public static c.a.q0.h.i.n.b.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? b.a() : (c.a.q0.h.i.n.b.a) invokeV.objValue;
    }

    @Inject
    public static c.a.q0.h.i.n.b.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? d.a() : (c.a.q0.h.i.n.b.b) invokeV.objValue;
    }

    @Inject
    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new e() : (c) invokeV.objValue;
    }
}
