package b.a.p0.q.j.k;

import androidx.annotation.Nullable;
import b.a.p0.q.f.i;
import b.a.p0.q.j.m.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f extends b.a.p0.q.j.d<b.a.p0.q.j.l.f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public i f11841h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public i f11842i;

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
        this.f11841h = iVar2;
        this.f11842i = iVar3;
    }

    @Override // b.a.p0.q.j.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.j.d
    /* renamed from: v */
    public boolean f(b.a.p0.q.j.l.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) ? fVar != null : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.j.d
    /* renamed from: w */
    public b.a.p0.q.i.b t(b.a.p0.q.j.l.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fVar)) == null) {
            this.f11788e.E();
            b.a.p0.q.o.a.e(this.f11789f.a(), fVar.f11863a);
            i iVar = this.f11788e;
            if (iVar == this.f11841h || iVar == this.f11842i) {
                iVar = null;
            }
            b.a.p0.q.k.f.c(fVar.f11864b, iVar, this.f11841h, this.f11842i);
            return null;
        }
        return (b.a.p0.q.i.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.j.d
    /* renamed from: x */
    public b.a.p0.q.j.l.f u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? b.a.p0.q.p.f.q(jSONObject) : (b.a.p0.q.j.l.f) invokeL.objValue;
    }
}
