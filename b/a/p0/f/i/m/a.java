package b.a.p0.f.i.m;

import b.a.p0.a.c1.c.d;
import b.a.p0.a.c1.c.e;
import b.a.p0.f.i.m.b.c;
import b.a.p0.h.t.b.b;
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
    public static b.a.p0.f.i.m.b.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? b.a() : (b.a.p0.f.i.m.b.a) invokeV.objValue;
    }

    @Inject
    public static b.a.p0.f.i.m.b.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? d.a() : (b.a.p0.f.i.m.b.b) invokeV.objValue;
    }

    @Inject
    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new e() : (c) invokeV.objValue;
    }
}
