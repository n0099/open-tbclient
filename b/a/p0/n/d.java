package b.a.p0.n;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d implements Interpolator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11694a;

    /* renamed from: b  reason: collision with root package name */
    public final PointF f11695b;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f11696c;

    public d(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11694a = 0;
        this.f11695b = new PointF();
        PointF pointF = new PointF();
        this.f11696c = pointF;
        PointF pointF2 = this.f11695b;
        pointF2.x = f2;
        pointF2.y = f3;
        pointF.x = f4;
        pointF.y = f5;
    }

    public final double a(double d2, double d3, double d4, double d5, double d6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6)})) == null) {
            double d7 = 1.0d - d2;
            double d8 = d2 * d2;
            double d9 = d7 * d7;
            return (d9 * d7 * d3) + (d9 * 3.0d * d2 * d4) + (d7 * 3.0d * d8 * d5) + (d8 * d2 * d6);
        }
        return invokeCommon.doubleValue;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
            int i2 = this.f11694a;
            float f3 = f2;
            while (true) {
                if (i2 >= 4096) {
                    break;
                }
                f3 = (i2 * 1.0f) / 4096.0f;
                if (a(f3, 0.0d, this.f11695b.x, this.f11696c.x, 1.0d) >= f2) {
                    this.f11694a = i2;
                    break;
                }
                i2++;
            }
            double a2 = a(f3, 0.0d, this.f11695b.y, this.f11696c.y, 1.0d);
            if (a2 > 0.999d) {
                a2 = 1.0d;
                this.f11694a = 0;
            }
            return (float) a2;
        }
        return invokeF.floatValue;
    }
}
