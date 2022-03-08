package c.a.p0.q.i.k;

import androidx.annotation.Nullable;
import c.a.p0.q.e.i;
import c.a.p0.q.i.m.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends c.a.p0.q.i.d<c.a.p0.q.i.l.f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public i f11014h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public i f11015i;

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
        this.f11014h = iVar2;
        this.f11015i = iVar3;
    }

    @Override // c.a.p0.q.i.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.q.i.d
    /* renamed from: v */
    public boolean f(c.a.p0.q.i.l.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) ? fVar != null : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.q.i.d
    /* renamed from: w */
    public c.a.p0.q.h.b t(c.a.p0.q.i.l.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fVar)) == null) {
            this.f10972e.F();
            c.a.p0.q.n.a.e(this.f10973f.a(), fVar.a);
            i iVar = this.f10972e;
            if (iVar == this.f11014h || iVar == this.f11015i) {
                iVar = null;
            }
            c.a.p0.q.j.f.c(fVar.f11030b, iVar, this.f11014h, this.f11015i);
            return null;
        }
        return (c.a.p0.q.h.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.q.i.d
    /* renamed from: x */
    public c.a.p0.q.i.l.f u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? c.a.p0.q.o.f.q(jSONObject) : (c.a.p0.q.i.l.f) invokeL.objValue;
    }
}
