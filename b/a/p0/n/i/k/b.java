package b.a.p0.n.i.k;

import b.a.p0.n.f.g;
import b.a.p0.n.h.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends b.a.p0.n.i.d<b.a.p0.n.i.l.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f11140h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, g gVar, b.a.p0.n.i.m.g gVar2) {
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
                super((g) objArr2[0], (b.a.p0.n.i.m.g) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11140h = str;
    }

    @Override // b.a.p0.n.i.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.n.i.d
    /* renamed from: o */
    public boolean e(b.a.p0.n.i.l.b bVar) {
        InterceptResult invokeL;
        List<b.a.p0.n.h.g> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            if (bVar.f11152a == null && (((list = bVar.f11153b) == null || list.isEmpty()) && bVar.f11154c == null && bVar.f11156e == null && bVar.f11155d == null)) {
                return false;
            }
            f fVar = bVar.f11152a;
            if (fVar == null || fVar.a()) {
                List<b.a.p0.n.h.g> list2 = bVar.f11153b;
                if (list2 != null) {
                    for (b.a.p0.n.h.g gVar : list2) {
                        if (!gVar.a()) {
                            return false;
                        }
                    }
                }
                b.a.p0.n.h.d dVar = bVar.f11154c;
                if (dVar == null || dVar.a()) {
                    b.a.p0.n.h.b bVar2 = bVar.f11156e;
                    if (bVar2 == null || bVar2.a()) {
                        PMSAppInfo pMSAppInfo = bVar.f11155d;
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
    @Override // b.a.p0.n.i.d
    /* renamed from: p */
    public b.a.p0.n.h.a m(b.a.p0.n.i.l.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            this.f11092e.D();
            b.a.p0.n.o.f fVar = new b.a.p0.n.o.f();
            i(bVar.f11152a, fVar);
            j(bVar.f11153b, fVar);
            h(bVar.f11154c, fVar);
            g(bVar.f11156e, fVar);
            l(bVar.f11155d);
            if (fVar.l() == 0) {
                this.f11092e.E();
                return null;
            }
            this.f11092e.F(fVar);
            b.a.p0.n.i.i.a.b(bVar, this.f11092e);
            return null;
        }
        return (b.a.p0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.n.i.d
    /* renamed from: q */
    public b.a.p0.n.i.l.b n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? b.a.p0.n.o.e.f(this.f11140h, jSONObject) : (b.a.p0.n.i.l.b) invokeL.objValue;
    }
}
