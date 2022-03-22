package c.a.n0.q.i.k;

import androidx.core.view.InputDeviceCompat;
import c.a.n0.q.e.i;
import c.a.n0.q.h.g;
import c.a.n0.q.i.m.h;
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
public class c extends c.a.n0.q.i.d<c.a.n0.q.i.l.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final String f9189d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, i iVar, h hVar) {
        super(iVar, hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iVar, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i) objArr2[0], (h) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9189d = str;
    }

    @Override // c.a.n0.q.i.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.q.i.d
    /* renamed from: v */
    public boolean f(c.a.n0.q.i.l.c cVar) {
        InterceptResult invokeL;
        List<c.a.n0.q.h.h> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            if (cVar.a == null && (((list = cVar.f9202b) == null || list.isEmpty()) && cVar.f9204d == null && cVar.f9206f == null && cVar.f9205e == null)) {
                return false;
            }
            g gVar = cVar.a;
            if (gVar == null || gVar.a()) {
                List<c.a.n0.q.h.h> list2 = cVar.f9202b;
                if (list2 != null) {
                    for (c.a.n0.q.h.h hVar : list2) {
                        if (!hVar.a()) {
                            return false;
                        }
                    }
                }
                c.a.n0.q.h.e eVar = cVar.f9204d;
                if (eVar == null || eVar.a()) {
                    c.a.n0.q.h.c cVar2 = cVar.f9206f;
                    if (cVar2 == null || cVar2.a()) {
                        PMSAppInfo pMSAppInfo = cVar.f9205e;
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
    @Override // c.a.n0.q.i.d
    /* renamed from: w */
    public boolean s(c.a.n0.q.i.l.c cVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, cVar, i)) == null) {
            if (cVar != null) {
                r(cVar.f9205e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.q.i.d
    /* renamed from: x */
    public c.a.n0.q.h.b t(c.a.n0.q.i.l.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
            this.a.F();
            c.a.n0.q.o.g gVar = new c.a.n0.q.o.g();
            o(cVar.a, gVar);
            p(cVar.f9202b, gVar);
            n(g(cVar.f9203c), gVar);
            m(cVar.f9204d, gVar);
            l(cVar.f9206f, gVar);
            r(cVar.f9205e);
            if (gVar.n() == 0) {
                this.a.G();
                return null;
            }
            this.a.H(gVar);
            c.a.n0.q.i.i.a.b(cVar, this.a);
            return null;
        }
        return (c.a.n0.q.h.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.q.i.d
    /* renamed from: y */
    public c.a.n0.q.i.l.c u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? c.a.n0.q.o.f.g(this.f9189d, jSONObject) : (c.a.n0.q.i.l.c) invokeL.objValue;
    }
}
