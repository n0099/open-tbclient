package c.a.p0.j.u.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
@Service
/* loaded from: classes2.dex */
public class m implements c.a.p0.a.f.b.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m() {
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

    @Override // c.a.p0.a.f.b.a.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.p0.j.c.f.g() : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.f.b.a.d
    public boolean b() {
        InterceptResult invokeV;
        c.a.p0.a.x.g.d m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (c.a.p0.a.t1.e.L() == null || !c.a.p0.a.t1.e.L().v0()) {
                return false;
            }
            c.a.p0.a.x.g.g V = c.a.p0.a.w0.f.U().V();
            if (V == null || (m = V.m()) == null || !(m instanceof c.a.p0.j.n.a)) {
                return true;
            }
            return ((c.a.p0.j.n.a) m).x3();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.f.b.a.d
    public String c(String str) throws MalformedURLException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? c.a.p0.j.c.f.d(str) : (String) invokeL.objValue;
    }
}
