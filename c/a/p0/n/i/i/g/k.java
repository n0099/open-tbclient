package c.a.p0.n.i.i.g;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class k extends c.a.p0.n.i.i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f11947a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f11948b;

    public k(f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11947a = fVar;
        this.f11948b = z;
    }

    @Override // c.a.p0.n.i.i.b
    public f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11947a : (f) invokeV.objValue;
    }

    @Override // c.a.p0.n.i.i.b
    public boolean b(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            f fVar2 = this.f11947a;
            if (fVar2 == fVar) {
                return true;
            }
            return fVar2.d(fVar);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.n.i.i.b
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f11948b) {
            return;
        }
        if (z) {
            f fVar = this.f11947a;
            fVar.f11928e.f11927b.f11880b = 0L;
            fVar.b(0);
        }
        d.b().f(this.f11947a);
    }

    @Override // c.a.p0.n.i.i.b
    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "isAttached=" + this.f11948b + " " + super.toString();
        }
        return (String) invokeV.objValue;
    }
}
