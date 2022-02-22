package c.a.s0.q.j.k;

import androidx.annotation.Nullable;
import c.a.s0.q.f.i;
import c.a.s0.q.j.m.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends c.a.s0.q.j.d<c.a.s0.q.j.l.f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public i f11789h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public i f11790i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(i iVar, h hVar, @Nullable i iVar2, @Nullable i iVar3) {
        super(iVar, hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, hVar, iVar2, iVar3};
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
        this.f11789h = iVar2;
        this.f11790i = iVar3;
    }

    @Override // c.a.s0.q.j.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.q.j.d
    /* renamed from: v */
    public boolean f(c.a.s0.q.j.l.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) ? fVar != null : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.q.j.d
    /* renamed from: w */
    public c.a.s0.q.i.b t(c.a.s0.q.j.l.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fVar)) == null) {
            this.f11747e.F();
            c.a.s0.q.o.a.e(this.f11748f.a(), fVar.a);
            i iVar = this.f11747e;
            if (iVar == this.f11789h || iVar == this.f11790i) {
                iVar = null;
            }
            c.a.s0.q.k.f.c(fVar.f11805b, iVar, this.f11789h, this.f11790i);
            return null;
        }
        return (c.a.s0.q.i.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.q.j.d
    /* renamed from: x */
    public c.a.s0.q.j.l.f u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? c.a.s0.q.p.f.q(jSONObject) : (c.a.s0.q.j.l.f) invokeL.objValue;
    }
}
