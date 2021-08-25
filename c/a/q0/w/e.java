package c.a.q0.w;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import c.a.q0.w.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public double f27604a;

    /* renamed from: b  reason: collision with root package name */
    public double f27605b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27606c;

    /* renamed from: d  reason: collision with root package name */
    public double f27607d;

    /* renamed from: e  reason: collision with root package name */
    public double f27608e;

    /* renamed from: f  reason: collision with root package name */
    public double f27609f;

    /* renamed from: g  reason: collision with root package name */
    public double f27610g;

    /* renamed from: h  reason: collision with root package name */
    public double f27611h;

    /* renamed from: i  reason: collision with root package name */
    public double f27612i;

    /* renamed from: j  reason: collision with root package name */
    public final b.i f27613j;

    public e(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27604a = Math.sqrt(1500.0d);
        this.f27605b = 0.5d;
        this.f27606c = false;
        this.f27612i = Double.MAX_VALUE;
        this.f27613j = new b.i();
        this.f27612i = f2;
    }

    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (float) this.f27612i : invokeV.floatValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f27606c) {
            return;
        }
        if (this.f27612i != Double.MAX_VALUE) {
            double d2 = this.f27605b;
            if (d2 > 1.0d) {
                double d3 = this.f27604a;
                this.f27609f = ((-d2) * d3) + (d3 * Math.sqrt((d2 * d2) - 1.0d));
                double d4 = this.f27605b;
                double d5 = this.f27604a;
                this.f27610g = ((-d4) * d5) - (d5 * Math.sqrt((d4 * d4) - 1.0d));
            } else if (d2 >= 0.0d && d2 < 1.0d) {
                this.f27611h = this.f27604a * Math.sqrt(1.0d - (d2 * d2));
            }
            this.f27606c = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? ((double) Math.abs(f3)) < this.f27608e && ((double) Math.abs(f2 - a())) < this.f27607d : invokeCommon.booleanValue;
    }

    public e d(@FloatRange(from = 0.0d) float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            if (f2 >= 0.0f) {
                this.f27605b = f2;
                this.f27606c = false;
                return this;
            }
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        return (e) invokeF.objValue;
    }

    public e e(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) {
            this.f27612i = f2;
            return this;
        }
        return (e) invokeF.objValue;
    }

    public e f(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
            if (f2 > 0.0f) {
                this.f27604a = Math.sqrt(f2);
                this.f27606c = false;
                return this;
            }
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        return (e) invokeF.objValue;
    }

    public void g(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d2)}) == null) {
            double abs = Math.abs(d2);
            this.f27607d = abs;
            this.f27608e = abs * 62.5d;
        }
    }

    public b.i h(double d2, double d3, long j2) {
        InterceptResult invokeCommon;
        double cos;
        double d4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Long.valueOf(j2)})) == null) {
            b();
            double d5 = j2 / 1000.0d;
            double d6 = d2 - this.f27612i;
            double d7 = this.f27605b;
            if (d7 > 1.0d) {
                double d8 = this.f27610g;
                double d9 = this.f27609f;
                double d10 = d6 - (((d8 * d6) - d3) / (d8 - d9));
                double d11 = ((d6 * d8) - d3) / (d8 - d9);
                d4 = (Math.pow(2.718281828459045d, d8 * d5) * d10) + (Math.pow(2.718281828459045d, this.f27609f * d5) * d11);
                double d12 = this.f27610g;
                double pow = d10 * d12 * Math.pow(2.718281828459045d, d12 * d5);
                double d13 = this.f27609f;
                cos = pow + (d11 * d13 * Math.pow(2.718281828459045d, d13 * d5));
            } else if (d7 == 1.0d) {
                double d14 = this.f27604a;
                double d15 = d3 + (d14 * d6);
                double d16 = d6 + (d15 * d5);
                d4 = Math.pow(2.718281828459045d, (-d14) * d5) * d16;
                double pow2 = d16 * Math.pow(2.718281828459045d, (-this.f27604a) * d5);
                double d17 = this.f27604a;
                cos = (d15 * Math.pow(2.718281828459045d, (-d17) * d5)) + (pow2 * (-d17));
            } else {
                double d18 = 1.0d / this.f27611h;
                double d19 = this.f27604a;
                double d20 = d18 * ((d7 * d19 * d6) + d3);
                double pow3 = Math.pow(2.718281828459045d, (-d7) * d19 * d5) * ((Math.cos(this.f27611h * d5) * d6) + (Math.sin(this.f27611h * d5) * d20));
                double d21 = this.f27604a;
                double d22 = this.f27605b;
                double d23 = (-d21) * pow3 * d22;
                double pow4 = Math.pow(2.718281828459045d, (-d22) * d21 * d5);
                double d24 = this.f27611h;
                double sin = (-d24) * d6 * Math.sin(d24 * d5);
                double d25 = this.f27611h;
                cos = d23 + (pow4 * (sin + (d20 * d25 * Math.cos(d25 * d5))));
                d4 = pow3;
            }
            b.i iVar = this.f27613j;
            iVar.f27602a = (float) (d4 + this.f27612i);
            iVar.f27603b = (float) cos;
            return iVar;
        }
        return (b.i) invokeCommon.objValue;
    }
}
