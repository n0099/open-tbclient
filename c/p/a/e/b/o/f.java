package c.p.a.e.b.o;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final double f35215a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35216b;

    /* renamed from: c  reason: collision with root package name */
    public double f35217c;

    /* renamed from: d  reason: collision with root package name */
    public int f35218d;

    public f(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35217c = -1.0d;
        this.f35215a = d2;
        this.f35216b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35217c : invokeV.doubleValue;
    }

    public void b(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)}) == null) {
            double d3 = 1.0d - this.f35215a;
            int i2 = this.f35218d;
            if (i2 > this.f35216b) {
                this.f35217c = Math.exp((d3 * Math.log(this.f35217c)) + (this.f35215a * Math.log(d2)));
            } else if (i2 > 0) {
                double d4 = (d3 * i2) / (i2 + 1.0d);
                this.f35217c = Math.exp((d4 * Math.log(this.f35217c)) + ((1.0d - d4) * Math.log(d2)));
            } else {
                this.f35217c = d2;
            }
            this.f35218d++;
        }
    }
}
