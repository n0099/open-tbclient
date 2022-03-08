package c.a.p0.q.i.k;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.q.e.i;
import c.a.p0.q.h.g;
import c.a.p0.q.i.m.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends c.a.p0.q.i.d<c.a.p0.q.i.l.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f11012h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, i iVar, h hVar) {
        super(iVar, hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iVar, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i) objArr2[0], (h) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11012h = str;
    }

    @Override // c.a.p0.q.i.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.q.i.d
    /* renamed from: v */
    public boolean f(c.a.p0.q.i.l.c cVar) {
        InterceptResult invokeL;
        List<c.a.p0.q.h.h> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            if (cVar.a == null && (((list = cVar.f11025b) == null || list.isEmpty()) && cVar.f11027d == null && cVar.f11029f == null && cVar.f11028e == null)) {
                return false;
            }
            g gVar = cVar.a;
            if (gVar == null || gVar.a()) {
                List<c.a.p0.q.h.h> list2 = cVar.f11025b;
                if (list2 != null) {
                    for (c.a.p0.q.h.h hVar : list2) {
                        if (!hVar.a()) {
                            return false;
                        }
                    }
                }
                c.a.p0.q.h.e eVar = cVar.f11027d;
                if (eVar == null || eVar.a()) {
                    c.a.p0.q.h.c cVar2 = cVar.f11029f;
                    if (cVar2 == null || cVar2.a()) {
                        PMSAppInfo pMSAppInfo = cVar.f11028e;
                        return pMSAppInfo == null || pMSAppInfo.checkValid();
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.q.i.d
    /* renamed from: w */
    public boolean s(c.a.p0.q.i.l.c cVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, cVar, i2)) == null) {
            if (cVar != null) {
                r(cVar.f11028e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.q.i.d
    /* renamed from: x */
    public c.a.p0.q.h.b t(c.a.p0.q.i.l.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
            this.f10972e.F();
            c.a.p0.q.o.g gVar = new c.a.p0.q.o.g();
            o(cVar.a, gVar);
            p(cVar.f11025b, gVar);
            n(g(cVar.f11026c), gVar);
            m(cVar.f11027d, gVar);
            l(cVar.f11029f, gVar);
            r(cVar.f11028e);
            if (gVar.n() == 0) {
                this.f10972e.G();
                return null;
            }
            this.f10972e.H(gVar);
            c.a.p0.q.i.i.a.b(cVar, this.f10972e);
            return null;
        }
        return (c.a.p0.q.h.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.q.i.d
    /* renamed from: y */
    public c.a.p0.q.i.l.c u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? c.a.p0.q.o.f.g(this.f11012h, jSONObject) : (c.a.p0.q.i.l.c) invokeL.objValue;
    }
}
