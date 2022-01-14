package c.a.r0.q.j.k;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.q.f.i;
import c.a.r0.q.i.g;
import c.a.r0.q.j.m.h;
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
public class c extends c.a.r0.q.j.d<c.a.r0.q.j.l.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f11545h;

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
        this.f11545h = str;
    }

    @Override // c.a.r0.q.j.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.q.j.d
    /* renamed from: v */
    public boolean f(c.a.r0.q.j.l.c cVar) {
        InterceptResult invokeL;
        List<c.a.r0.q.i.h> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            if (cVar.a == null && (((list = cVar.f11558b) == null || list.isEmpty()) && cVar.f11560d == null && cVar.f11562f == null && cVar.f11561e == null)) {
                return false;
            }
            g gVar = cVar.a;
            if (gVar == null || gVar.a()) {
                List<c.a.r0.q.i.h> list2 = cVar.f11558b;
                if (list2 != null) {
                    for (c.a.r0.q.i.h hVar : list2) {
                        if (!hVar.a()) {
                            return false;
                        }
                    }
                }
                c.a.r0.q.i.e eVar = cVar.f11560d;
                if (eVar == null || eVar.a()) {
                    c.a.r0.q.i.c cVar2 = cVar.f11562f;
                    if (cVar2 == null || cVar2.a()) {
                        PMSAppInfo pMSAppInfo = cVar.f11561e;
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
    @Override // c.a.r0.q.j.d
    /* renamed from: w */
    public boolean s(c.a.r0.q.j.l.c cVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, cVar, i2)) == null) {
            if (cVar != null) {
                r(cVar.f11561e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.q.j.d
    /* renamed from: x */
    public c.a.r0.q.i.b t(c.a.r0.q.j.l.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
            this.f11505e.F();
            c.a.r0.q.p.g gVar = new c.a.r0.q.p.g();
            o(cVar.a, gVar);
            p(cVar.f11558b, gVar);
            n(g(cVar.f11559c), gVar);
            m(cVar.f11560d, gVar);
            l(cVar.f11562f, gVar);
            r(cVar.f11561e);
            if (gVar.n() == 0) {
                this.f11505e.G();
                return null;
            }
            this.f11505e.H(gVar);
            c.a.r0.q.j.i.a.b(cVar, this.f11505e);
            return null;
        }
        return (c.a.r0.q.i.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.q.j.d
    /* renamed from: y */
    public c.a.r0.q.j.l.c u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? c.a.r0.q.p.f.g(this.f11545h, jSONObject) : (c.a.r0.q.j.l.c) invokeL.objValue;
    }
}
