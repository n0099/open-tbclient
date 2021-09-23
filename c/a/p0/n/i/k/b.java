package c.a.p0.n.i.k;

import c.a.p0.n.f.g;
import c.a.p0.n.h.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends c.a.p0.n.i.d<c.a.p0.n.i.l.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f11959h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, g gVar, c.a.p0.n.i.m.g gVar2) {
        super(gVar, gVar2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, gVar, gVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((g) objArr2[0], (c.a.p0.n.i.m.g) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11959h = str;
    }

    @Override // c.a.p0.n.i.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.n.i.d
    /* renamed from: o */
    public boolean e(c.a.p0.n.i.l.b bVar) {
        InterceptResult invokeL;
        List<c.a.p0.n.h.g> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            if (bVar.f11971a == null && (((list = bVar.f11972b) == null || list.isEmpty()) && bVar.f11973c == null && bVar.f11975e == null && bVar.f11974d == null)) {
                return false;
            }
            f fVar = bVar.f11971a;
            if (fVar == null || fVar.a()) {
                List<c.a.p0.n.h.g> list2 = bVar.f11972b;
                if (list2 != null) {
                    for (c.a.p0.n.h.g gVar : list2) {
                        if (!gVar.a()) {
                            return false;
                        }
                    }
                }
                c.a.p0.n.h.d dVar = bVar.f11973c;
                if (dVar == null || dVar.a()) {
                    c.a.p0.n.h.b bVar2 = bVar.f11975e;
                    if (bVar2 == null || bVar2.a()) {
                        PMSAppInfo pMSAppInfo = bVar.f11974d;
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
    @Override // c.a.p0.n.i.d
    /* renamed from: p */
    public c.a.p0.n.h.a m(c.a.p0.n.i.l.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            this.f11910e.D();
            c.a.p0.n.o.f fVar = new c.a.p0.n.o.f();
            i(bVar.f11971a, fVar);
            j(bVar.f11972b, fVar);
            h(bVar.f11973c, fVar);
            g(bVar.f11975e, fVar);
            l(bVar.f11974d);
            if (fVar.l() == 0) {
                this.f11910e.E();
                return null;
            }
            this.f11910e.F(fVar);
            c.a.p0.n.i.i.a.b(bVar, this.f11910e);
            return null;
        }
        return (c.a.p0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.n.i.d
    /* renamed from: q */
    public c.a.p0.n.i.l.b n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? c.a.p0.n.o.e.f(this.f11959h, jSONObject) : (c.a.p0.n.i.l.b) invokeL.objValue;
    }
}
