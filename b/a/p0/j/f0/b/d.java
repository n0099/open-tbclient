package b.a.p0.j.f0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f11143a;

    /* renamed from: b  reason: collision with root package name */
    public long f11144b;

    /* renamed from: c  reason: collision with root package name */
    public String f11145c;

    /* renamed from: d  reason: collision with root package name */
    public String f11146d;

    /* renamed from: e  reason: collision with root package name */
    public String f11147e;

    /* renamed from: f  reason: collision with root package name */
    public String f11148f;

    /* renamed from: g  reason: collision with root package name */
    public String f11149g;

    /* renamed from: h  reason: collision with root package name */
    public String f11150h;

    /* renamed from: i  reason: collision with root package name */
    public int f11151i;
    public String j;
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
            return "{ clipMaxDuration=" + this.f11143a + " , clipMinDuration=" + this.f11144b + " , topicSource=" + this.f11145c + " , publishURL=" + this.f11147e + " , publishType=" + this.k + " , publishTitle=" + this.f11146d + " , atURL=" + this.f11149g + " , topicURL=" + this.f11150h + " , musicURL=" + this.f11148f + " , sourceFrom=" + this.j + " , sourceType=" + this.f11151i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
