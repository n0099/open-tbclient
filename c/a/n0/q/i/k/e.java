package c.a.n0.q.i.k;

import c.a.n0.q.e.i;
import c.a.n0.q.i.m.h;
import c.a.n0.q.o.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends c.a.n0.q.i.d<c.a.n0.q.i.l.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final String f9190d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, i iVar, h hVar) {
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
        this.f9190d = str;
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
    public boolean f(c.a.n0.q.i.l.e eVar) {
        InterceptResult invokeL;
        List<c.a.n0.q.h.h> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) {
            if (eVar == null || (list = eVar.a) == null) {
                return false;
            }
            for (c.a.n0.q.h.h hVar : list) {
                if (!hVar.a()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.q.i.d
    /* renamed from: w */
    public c.a.n0.q.h.b t(c.a.n0.q.i.l.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            this.a.F();
            g gVar = new g();
            p(eVar.a, gVar);
            if (gVar.n() == 0) {
                this.a.G();
                return null;
            }
            this.a.H(gVar);
            c.a.n0.q.i.i.a.d(eVar, this.a);
            return null;
        }
        return (c.a.n0.q.h.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.q.i.d
    /* renamed from: x */
    public c.a.n0.q.i.l.e u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? c.a.n0.q.o.f.i(this.f9190d, jSONObject) : (c.a.n0.q.i.l.e) invokeL.objValue;
    }
}
