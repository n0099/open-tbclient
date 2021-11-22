package b.a.p0.q.j.k;

import b.a.p0.q.f.i;
import b.a.p0.q.j.m.h;
import b.a.p0.q.p.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e extends b.a.p0.q.j.d<b.a.p0.q.j.l.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f11840h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, i iVar, h hVar) {
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
        this.f11840h = str;
    }

    @Override // b.a.p0.q.j.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.j.d
    /* renamed from: v */
    public boolean f(b.a.p0.q.j.l.e eVar) {
        InterceptResult invokeL;
        List<b.a.p0.q.i.h> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) {
            if (eVar == null || (list = eVar.f11862a) == null) {
                return false;
            }
            for (b.a.p0.q.i.h hVar : list) {
                if (!hVar.a()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.j.d
    /* renamed from: w */
    public b.a.p0.q.i.b t(b.a.p0.q.j.l.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            this.f11788e.E();
            g gVar = new g();
            p(eVar.f11862a, gVar);
            if (gVar.n() == 0) {
                this.f11788e.F();
                return null;
            }
            this.f11788e.G(gVar);
            b.a.p0.q.j.i.a.d(eVar, this.f11788e);
            return null;
        }
        return (b.a.p0.q.i.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.j.d
    /* renamed from: x */
    public b.a.p0.q.j.l.e u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? b.a.p0.q.p.f.i(this.f11840h, jSONObject) : (b.a.p0.q.j.l.e) invokeL.objValue;
    }
}
