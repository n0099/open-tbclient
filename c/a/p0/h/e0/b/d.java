package c.a.p0.h.e0.b;

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
    public long f11189a;

    /* renamed from: b  reason: collision with root package name */
    public long f11190b;

    /* renamed from: c  reason: collision with root package name */
    public String f11191c;

    /* renamed from: d  reason: collision with root package name */
    public String f11192d;

    /* renamed from: e  reason: collision with root package name */
    public String f11193e;

    /* renamed from: f  reason: collision with root package name */
    public String f11194f;

    /* renamed from: g  reason: collision with root package name */
    public String f11195g;

    /* renamed from: h  reason: collision with root package name */
    public String f11196h;

    /* renamed from: i  reason: collision with root package name */
    public int f11197i;

    /* renamed from: j  reason: collision with root package name */
    public String f11198j;
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
            return "{ clipMaxDuration=" + this.f11189a + " , clipMinDuration=" + this.f11190b + " , topicSource=" + this.f11191c + " , publishURL=" + this.f11193e + " , publishType=" + this.k + " , publishTitle=" + this.f11192d + " , atURL=" + this.f11195g + " , topicURL=" + this.f11196h + " , musicURL=" + this.f11194f + " , sourceFrom=" + this.f11198j + " , sourceType=" + this.f11197i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
