package c.a.p0.j.f0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f10474b;

    /* renamed from: c  reason: collision with root package name */
    public String f10475c;

    /* renamed from: d  reason: collision with root package name */
    public String f10476d;

    /* renamed from: e  reason: collision with root package name */
    public String f10477e;

    /* renamed from: f  reason: collision with root package name */
    public String f10478f;

    /* renamed from: g  reason: collision with root package name */
    public String f10479g;

    /* renamed from: h  reason: collision with root package name */
    public String f10480h;

    /* renamed from: i  reason: collision with root package name */
    public int f10481i;

    /* renamed from: j  reason: collision with root package name */
    public String f10482j;
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
            return "{ clipMaxDuration=" + this.a + " , clipMinDuration=" + this.f10474b + " , topicSource=" + this.f10475c + " , publishURL=" + this.f10477e + " , publishType=" + this.k + " , publishTitle=" + this.f10476d + " , atURL=" + this.f10479g + " , topicURL=" + this.f10480h + " , musicURL=" + this.f10478f + " , sourceFrom=" + this.f10482j + " , sourceType=" + this.f10481i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
