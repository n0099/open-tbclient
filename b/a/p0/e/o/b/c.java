package b.a.p0.e.o.b;

import android.text.TextUtils;
import b.a.p0.a.h0.s.e;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.p.d.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
@Service
/* loaded from: classes.dex */
public class c implements i1 {
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

    @Override // b.a.p0.a.p.d.i1
    public b.a.p0.n.l.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.b().a() : (b.a.p0.n.l.b) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.d.i1
    public void b(e eVar, b.a.p0.a.h0.s.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, cVar) == null) || cVar == null) {
            return;
        }
        if (eVar != null && !TextUtils.isEmpty(eVar.f5769a)) {
            String str = eVar.f5769a;
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
            } else if (eVar.f5770b) {
                b.b().b(false, cVar);
                return;
            } else {
                b.b().b(true, cVar);
                return;
            }
        }
        cVar.onFail();
    }

    @Override // b.a.p0.a.p.d.i1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d() || b.a.p0.a.n0.k.c.f6843d.w() || (b.a.p0.a.n0.k.c.f6843d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) && g.M().h0()) : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.p.d.i1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !b.b().c() : invokeV.booleanValue;
    }
}
