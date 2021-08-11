package c.a.p0.w;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import c.a.p0.w.b;
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
    public double f27265a;

    /* renamed from: b  reason: collision with root package name */
    public double f27266b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27267c;

    /* renamed from: d  reason: collision with root package name */
    public double f27268d;

    /* renamed from: e  reason: collision with root package name */
    public double f27269e;

    /* renamed from: f  reason: collision with root package name */
    public double f27270f;

    /* renamed from: g  reason: collision with root package name */
    public double f27271g;

    /* renamed from: h  reason: collision with root package name */
    public double f27272h;

    /* renamed from: i  reason: collision with root package name */
    public double f27273i;

    /* renamed from: j  reason: collision with root package name */
    public final b.i f27274j;

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
        this.f27265a = Math.sqrt(1500.0d);
        this.f27266b = 0.5d;
        this.f27267c = false;
        this.f27273i = Double.MAX_VALUE;
        this.f27274j = new b.i();
        this.f27273i = f2;
    }

    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (float) this.f27273i : invokeV.floatValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f27267c) {
            return;
        }
        if (this.f27273i != Double.MAX_VALUE) {
            double d2 = this.f27266b;
            if (d2 > 1.0d) {
                double d3 = this.f27265a;
                this.f27270f = ((-d2) * d3) + (d3 * Math.sqrt((d2 * d2) - 1.0d));
                double d4 = this.f27266b;
                double d5 = this.f27265a;
                this.f27271g = ((-d4) * d5) - (d5 * Math.sqrt((d4 * d4) - 1.0d));
            } else if (d2 >= 0.0d && d2 < 1.0d) {
                this.f27272h = this.f27265a * Math.sqrt(1.0d - (d2 * d2));
            }
            this.f27267c = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? ((double) Math.abs(f3)) < this.f27269e && ((double) Math.abs(f2 - a())) < this.f27268d : invokeCommon.booleanValue;
    }

    public e d(@FloatRange(from = 0.0d) float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            if (f2 >= 0.0f) {
                this.f27266b = f2;
                this.f27267c = false;
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
            this.f27273i = f2;
            return this;
        }
        return (e) invokeF.objValue;
    }

    public e f(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
            if (f2 > 0.0f) {
                this.f27265a = Math.sqrt(f2);
                this.f27267c = false;
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
            this.f27268d = abs;
            this.f27269e = abs * 62.5d;
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
            double d6 = d2 - this.f27273i;
            double d7 = this.f27266b;
            if (d7 > 1.0d) {
                double d8 = this.f27271g;
                double d9 = this.f27270f;
                double d10 = d6 - (((d8 * d6) - d3) / (d8 - d9));
                double d11 = ((d6 * d8) - d3) / (d8 - d9);
                d4 = (Math.pow(2.718281828459045d, d8 * d5) * d10) + (Math.pow(2.718281828459045d, this.f27270f * d5) * d11);
                double d12 = this.f27271g;
                double pow = d10 * d12 * Math.pow(2.718281828459045d, d12 * d5);
                double d13 = this.f27270f;
                cos = pow + (d11 * d13 * Math.pow(2.718281828459045d, d13 * d5));
            } else if (d7 == 1.0d) {
                double d14 = this.f27265a;
                double d15 = d3 + (d14 * d6);
                double d16 = d6 + (d15 * d5);
                d4 = Math.pow(2.718281828459045d, (-d14) * d5) * d16;
                double pow2 = d16 * Math.pow(2.718281828459045d, (-this.f27265a) * d5);
                double d17 = this.f27265a;
                cos = (d15 * Math.pow(2.718281828459045d, (-d17) * d5)) + (pow2 * (-d17));
            } else {
                double d18 = 1.0d / this.f27272h;
                double d19 = this.f27265a;
                double d20 = d18 * ((d7 * d19 * d6) + d3);
                double pow3 = Math.pow(2.718281828459045d, (-d7) * d19 * d5) * ((Math.cos(this.f27272h * d5) * d6) + (Math.sin(this.f27272h * d5) * d20));
                double d21 = this.f27265a;
                double d22 = this.f27266b;
                double d23 = (-d21) * pow3 * d22;
                double pow4 = Math.pow(2.718281828459045d, (-d22) * d21 * d5);
                double d24 = this.f27272h;
                double sin = (-d24) * d6 * Math.sin(d24 * d5);
                double d25 = this.f27272h;
                cos = d23 + (pow4 * (sin + (d20 * d25 * Math.cos(d25 * d5))));
                d4 = pow3;
            }
            b.i iVar = this.f27274j;
            iVar.f27263a = (float) (d4 + this.f27273i);
            iVar.f27264b = (float) cos;
            return iVar;
        }
        return (b.i) invokeCommon.objValue;
    }
}
