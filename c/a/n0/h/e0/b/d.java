package c.a.n0.h.e0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f10915a;

    /* renamed from: b  reason: collision with root package name */
    public long f10916b;

    /* renamed from: c  reason: collision with root package name */
    public String f10917c;

    /* renamed from: d  reason: collision with root package name */
    public String f10918d;

    /* renamed from: e  reason: collision with root package name */
    public String f10919e;

    /* renamed from: f  reason: collision with root package name */
    public String f10920f;

    /* renamed from: g  reason: collision with root package name */
    public String f10921g;

    /* renamed from: h  reason: collision with root package name */
    public String f10922h;

    /* renamed from: i  reason: collision with root package name */
    public int f10923i;

    /* renamed from: j  reason: collision with root package name */
    public String f10924j;
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
            return "{ clipMaxDuration=" + this.f10915a + " , clipMinDuration=" + this.f10916b + " , topicSource=" + this.f10917c + " , publishURL=" + this.f10919e + " , publishType=" + this.k + " , publishTitle=" + this.f10918d + " , atURL=" + this.f10921g + " , topicURL=" + this.f10922h + " , musicURL=" + this.f10920f + " , sourceFrom=" + this.f10924j + " , sourceType=" + this.f10923i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
