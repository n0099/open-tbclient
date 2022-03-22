package c.a.n0.q.i.k;

import androidx.core.view.InputDeviceCompat;
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
public class a extends c.a.n0.q.i.d<c.a.n0.q.i.l.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(i iVar, h hVar) {
        super(iVar, hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, hVar};
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
    }

    @Override // c.a.n0.q.i.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.q.i.d
    /* renamed from: v */
    public c.a.n0.q.h.b e(String str, c.a.n0.q.i.l.a aVar) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, aVar)) == null) {
            if (aVar != null && (i = aVar.a) != 0) {
                return new c.a.n0.q.h.b(i, aVar.f9193b);
            }
            return super.e(str, aVar);
        }
        return (c.a.n0.q.h.b) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // c.a.n0.q.i.d
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(c.a.n0.q.i.l.a aVar) {
        InterceptResult invokeL;
        List<c.a.n0.q.h.i> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            if (aVar == null || (list = aVar.f9194c) == null || list.isEmpty()) {
                return false;
            }
            for (c.a.n0.q.h.i iVar : aVar.f9194c) {
                if (iVar == null || !iVar.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            h hVar = this.f9154b;
            return !(hVar instanceof c.a.n0.q.i.m.a) || ((c.a.n0.q.i.m.a) hVar).f().size() == aVar.f9194c.size();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.q.i.d
    /* renamed from: x */
    public c.a.n0.q.h.b t(c.a.n0.q.i.l.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            this.a.F();
            g gVar = new g();
            n(aVar.f9194c, gVar);
            if (gVar.n() == 0) {
                this.a.G();
                return null;
            }
            this.a.H(gVar);
            c.a.n0.q.i.i.a.f(aVar.f9194c, this.a);
            return null;
        }
        return (c.a.n0.q.h.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.q.i.d
    /* renamed from: y */
    public c.a.n0.q.i.l.a u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? c.a.n0.q.o.f.e(jSONObject) : (c.a.n0.q.i.l.a) invokeL.objValue;
    }
}
