package c.a.t0.b0;

import c.a.t0.b0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class d extends b<d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e t;
    public float u;
    public boolean v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <K> d(K k2, c<K> cVar) {
        super(k2, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k2, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(objArr2[0], (c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = null;
        this.u = Float.MAX_VALUE;
        this.v = false;
    }

    @Override // c.a.t0.b0.b
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l();
            this.t.g(e());
            super.h();
        }
    }

    @Override // c.a.t0.b0.b
    public boolean j(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (this.v) {
                float f2 = this.u;
                if (f2 != Float.MAX_VALUE) {
                    this.t.e(f2);
                    this.u = Float.MAX_VALUE;
                }
                this.f15464b = this.t.a();
                this.a = 0.0f;
                this.v = false;
                return true;
            }
            if (this.u != Float.MAX_VALUE) {
                this.t.a();
                long j3 = j2 / 2;
                b.i h2 = this.t.h(this.f15464b, this.a, j3);
                this.t.e(this.u);
                this.u = Float.MAX_VALUE;
                b.i h3 = this.t.h(h2.a, h2.f15474b, j3);
                this.f15464b = h3.a;
                this.a = h3.f15474b;
            } else {
                b.i h4 = this.t.h(this.f15464b, this.a, j2);
                this.f15464b = h4.a;
                this.a = h4.f15474b;
            }
            float max = Math.max(this.f15464b, this.f15470h);
            this.f15464b = max;
            float min = Math.min(max, this.f15469g);
            this.f15464b = min;
            if (k(min, this.a)) {
                this.f15464b = this.t.a();
                this.a = 0.0f;
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public boolean k(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.t.c(f2, f3) : invokeCommon.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e eVar = this.t;
            if (eVar != null) {
                double a = eVar.a();
                if (a <= this.f15469g) {
                    if (a < this.f15470h) {
                        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                    }
                    return;
                }
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            }
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public d m(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) {
            this.t = eVar;
            return this;
        }
        return (d) invokeL.objValue;
    }
}
