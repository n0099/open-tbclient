package c.a.s0.q.j.k;

import androidx.core.view.InputDeviceCompat;
import c.a.s0.q.f.i;
import c.a.s0.q.i.g;
import c.a.s0.q.j.m.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends c.a.s0.q.j.d<c.a.s0.q.j.l.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f11787h;

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
        this.f11787h = str;
    }

    @Override // c.a.s0.q.j.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.q.j.d
    /* renamed from: v */
    public boolean f(c.a.s0.q.j.l.c cVar) {
        InterceptResult invokeL;
        List<c.a.s0.q.i.h> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            if (cVar.a == null && (((list = cVar.f11800b) == null || list.isEmpty()) && cVar.f11802d == null && cVar.f11804f == null && cVar.f11803e == null)) {
                return false;
            }
            g gVar = cVar.a;
            if (gVar == null || gVar.a()) {
                List<c.a.s0.q.i.h> list2 = cVar.f11800b;
                if (list2 != null) {
                    for (c.a.s0.q.i.h hVar : list2) {
                        if (!hVar.a()) {
                            return false;
                        }
                    }
                }
                c.a.s0.q.i.e eVar = cVar.f11802d;
                if (eVar == null || eVar.a()) {
                    c.a.s0.q.i.c cVar2 = cVar.f11804f;
                    if (cVar2 == null || cVar2.a()) {
                        PMSAppInfo pMSAppInfo = cVar.f11803e;
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
    @Override // c.a.s0.q.j.d
    /* renamed from: w */
    public boolean s(c.a.s0.q.j.l.c cVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, cVar, i2)) == null) {
            if (cVar != null) {
                r(cVar.f11803e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.q.j.d
    /* renamed from: x */
    public c.a.s0.q.i.b t(c.a.s0.q.j.l.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
            this.f11747e.F();
            c.a.s0.q.p.g gVar = new c.a.s0.q.p.g();
            o(cVar.a, gVar);
            p(cVar.f11800b, gVar);
            n(g(cVar.f11801c), gVar);
            m(cVar.f11802d, gVar);
            l(cVar.f11804f, gVar);
            r(cVar.f11803e);
            if (gVar.n() == 0) {
                this.f11747e.G();
                return null;
            }
            this.f11747e.H(gVar);
            c.a.s0.q.j.i.a.b(cVar, this.f11747e);
            return null;
        }
        return (c.a.s0.q.i.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.q.j.d
    /* renamed from: y */
    public c.a.s0.q.j.l.c u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? c.a.s0.q.p.f.g(this.f11787h, jSONObject) : (c.a.s0.q.j.l.c) invokeL.objValue;
    }
}
