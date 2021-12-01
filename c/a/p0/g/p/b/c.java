package c.a.p0.g.p.b;

import android.text.TextUtils;
import c.a.p0.a.h0.s.e;
import c.a.p0.a.h0.u.g;
import c.a.p0.a.p.d.o1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
@Service
/* loaded from: classes5.dex */
public class c implements o1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // c.a.p0.a.p.d.o1
    public c.a.p0.q.m.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.b().a() : (c.a.p0.q.m.b) invokeV.objValue;
    }

    @Override // c.a.p0.a.p.d.o1
    public void b(e eVar, c.a.p0.a.h0.s.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, cVar) == null) || cVar == null) {
            return;
        }
        if (eVar != null && !TextUtils.isEmpty(eVar.a)) {
            String str = eVar.a;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 1195918653) {
                if (hashCode == 1825003424 && str.equals("by_click")) {
                    c2 = 0;
                }
            } else if (str.equals("by_silent")) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    cVar.onFail();
                    return;
                } else {
                    b.b().b(true, cVar);
                    return;
                }
            } else if (eVar.f5985b) {
                b.b().b(false, cVar);
                return;
            } else {
                b.b().b(true, cVar);
                return;
            }
        }
        cVar.onFail();
    }

    @Override // c.a.p0.a.p.d.o1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d() || c.a.p0.a.n0.k.c.f6926d.w() || (c.a.p0.a.n0.k.c.f6926d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) && g.U().s0()) : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.p.d.o1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !b.b().c() : invokeV.booleanValue;
    }
}
