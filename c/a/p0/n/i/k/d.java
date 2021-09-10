package c.a.p0.n.i.k;

import c.a.p0.n.f.g;
import c.a.p0.n.o.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends c.a.p0.n.i.d<c.a.p0.n.i.l.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f11952h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, g gVar, c.a.p0.n.i.m.g gVar2) {
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
        this.f11952h = str;
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
    public boolean e(c.a.p0.n.i.l.d dVar) {
        InterceptResult invokeL;
        List<c.a.p0.n.h.g> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dVar)) == null) {
            if (dVar == null || (list = dVar.f11969a) == null) {
                return false;
            }
            for (c.a.p0.n.h.g gVar : list) {
                if (!gVar.a()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.n.i.d
    /* renamed from: p */
    public c.a.p0.n.h.a m(c.a.p0.n.i.l.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dVar)) == null) {
            this.f11902e.D();
            f fVar = new f();
            j(dVar.f11969a, fVar);
            if (fVar.l() == 0) {
                this.f11902e.E();
                return null;
            }
            this.f11902e.F(fVar);
            c.a.p0.n.i.i.a.d(dVar, this.f11902e);
            return null;
        }
        return (c.a.p0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.n.i.d
    /* renamed from: q */
    public c.a.p0.n.i.l.d n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? c.a.p0.n.o.e.h(this.f11952h, jSONObject) : (c.a.p0.n.i.l.d) invokeL.objValue;
    }
}
