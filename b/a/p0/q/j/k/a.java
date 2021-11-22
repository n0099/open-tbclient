package b.a.p0.q.j.k;

import androidx.core.view.InputDeviceCompat;
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
public class a extends b.a.p0.q.j.d<b.a.p0.q.j.l.a> {
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
    }

    @Override // b.a.p0.q.j.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.j.d
    /* renamed from: v */
    public b.a.p0.q.i.b e(String str, b.a.p0.q.j.l.a aVar) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, aVar)) == null) {
            if (aVar != null && (i2 = aVar.f11843a) != 0) {
                return new b.a.p0.q.i.b(i2, aVar.f11844b);
            }
            return super.e(str, aVar);
        }
        return (b.a.p0.q.i.b) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // b.a.p0.q.j.d
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(b.a.p0.q.j.l.a aVar) {
        InterceptResult invokeL;
        List<b.a.p0.q.i.i> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            if (aVar == null || (list = aVar.f11845c) == null || list.isEmpty()) {
                return false;
            }
            for (b.a.p0.q.i.i iVar : aVar.f11845c) {
                if (iVar == null || !iVar.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            h hVar = this.f11789f;
            return !(hVar instanceof b.a.p0.q.j.m.a) || ((b.a.p0.q.j.m.a) hVar).f().size() == aVar.f11845c.size();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.j.d
    /* renamed from: x */
    public b.a.p0.q.i.b t(b.a.p0.q.j.l.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            this.f11788e.E();
            g gVar = new g();
            n(aVar.f11845c, gVar);
            if (gVar.n() == 0) {
                this.f11788e.F();
                return null;
            }
            this.f11788e.G(gVar);
            b.a.p0.q.j.i.a.f(aVar.f11845c, this.f11788e);
            return null;
        }
        return (b.a.p0.q.i.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.j.d
    /* renamed from: y */
    public b.a.p0.q.j.l.a u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? b.a.p0.q.p.f.e(jSONObject) : (b.a.p0.q.j.l.a) invokeL.objValue;
    }
}
