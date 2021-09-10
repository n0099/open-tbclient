package c.a.p0.h.t.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
@Service
/* loaded from: classes3.dex */
public class k implements c.a.p0.a.p.b.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k() {
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

    @Override // c.a.p0.a.p.b.a.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.p0.h.c.f.g() : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.p.b.a.d
    public boolean b() {
        InterceptResult invokeV;
        c.a.p0.a.h0.g.d m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (c.a.p0.a.a2.e.i() == null || !c.a.p0.a.a2.e.i().m0()) {
                return false;
            }
            c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
            if (W == null || (m = W.m()) == null || !(m instanceof c.a.p0.h.n.a)) {
                return true;
            }
            return ((c.a.p0.h.n.a) m).n3();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.p.b.a.d
    public String c(String str) throws MalformedURLException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? c.a.p0.h.c.f.d(str) : (String) invokeL.objValue;
    }
}
