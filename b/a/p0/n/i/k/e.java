package b.a.p0.n.i.k;

import androidx.annotation.Nullable;
import b.a.p0.n.f.g;
import b.a.p0.n.j.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e extends b.a.p0.n.i.d<b.a.p0.n.i.l.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public g f11142h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public g f11143i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar, b.a.p0.n.i.m.g gVar2, @Nullable g gVar3, @Nullable g gVar4) {
        super(gVar, gVar2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, gVar2, gVar3, gVar4};
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
        this.f11142h = gVar3;
        this.f11143i = gVar4;
    }

    @Override // b.a.p0.n.i.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.n.i.d
    /* renamed from: o */
    public boolean e(b.a.p0.n.i.l.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) ? eVar != null : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.n.i.d
    /* renamed from: p */
    public b.a.p0.n.h.a m(b.a.p0.n.i.l.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            this.f11092e.D();
            b.a.p0.n.n.a.e(this.f11093f.a(), eVar.f11159a);
            g gVar = this.f11092e;
            if (gVar == this.f11142h || gVar == this.f11143i) {
                gVar = null;
            }
            f.c(eVar.f11160b, gVar, this.f11142h, this.f11143i);
            return null;
        }
        return (b.a.p0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.n.i.d
    /* renamed from: q */
    public b.a.p0.n.i.l.e n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? b.a.p0.n.o.e.n(jSONObject) : (b.a.p0.n.i.l.e) invokeL.objValue;
    }
}
