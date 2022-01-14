package c.a.r0.q.j.k;

import c.a.r0.q.f.i;
import c.a.r0.q.j.m.h;
import c.a.r0.q.p.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends c.a.r0.q.j.d<c.a.r0.q.j.l.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f11546h;

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
        this.f11546h = str;
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
    public boolean f(c.a.r0.q.j.l.e eVar) {
        InterceptResult invokeL;
        List<c.a.r0.q.i.h> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) {
            if (eVar == null || (list = eVar.a) == null) {
                return false;
            }
            for (c.a.r0.q.i.h hVar : list) {
                if (!hVar.a()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.q.j.d
    /* renamed from: w */
    public c.a.r0.q.i.b t(c.a.r0.q.j.l.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            this.f11505e.F();
            g gVar = new g();
            p(eVar.a, gVar);
            if (gVar.n() == 0) {
                this.f11505e.G();
                return null;
            }
            this.f11505e.H(gVar);
            c.a.r0.q.j.i.a.d(eVar, this.f11505e);
            return null;
        }
        return (c.a.r0.q.i.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.q.j.d
    /* renamed from: x */
    public c.a.r0.q.j.l.e u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? c.a.r0.q.p.f.i(this.f11546h, jSONObject) : (c.a.r0.q.j.l.e) invokeL.objValue;
    }
}
