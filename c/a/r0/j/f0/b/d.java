package c.a.r0.j.f0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f11149b;

    /* renamed from: c  reason: collision with root package name */
    public String f11150c;

    /* renamed from: d  reason: collision with root package name */
    public String f11151d;

    /* renamed from: e  reason: collision with root package name */
    public String f11152e;

    /* renamed from: f  reason: collision with root package name */
    public String f11153f;

    /* renamed from: g  reason: collision with root package name */
    public String f11154g;

    /* renamed from: h  reason: collision with root package name */
    public String f11155h;

    /* renamed from: i  reason: collision with root package name */
    public int f11156i;

    /* renamed from: j  reason: collision with root package name */
    public String f11157j;
    public String k;
    public String l;
    public int m;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "{ clipMaxDuration=" + this.a + " , clipMinDuration=" + this.f11149b + " , topicSource=" + this.f11150c + " , publishURL=" + this.f11152e + " , publishType=" + this.k + " , publishTitle=" + this.f11151d + " , atURL=" + this.f11154g + " , topicURL=" + this.f11155h + " , musicURL=" + this.f11153f + " , sourceFrom=" + this.f11157j + " , sourceType=" + this.f11156i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
