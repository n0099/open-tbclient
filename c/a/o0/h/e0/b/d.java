package c.a.o0.h.e0.b;

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
    public long f11161a;

    /* renamed from: b  reason: collision with root package name */
    public long f11162b;

    /* renamed from: c  reason: collision with root package name */
    public String f11163c;

    /* renamed from: d  reason: collision with root package name */
    public String f11164d;

    /* renamed from: e  reason: collision with root package name */
    public String f11165e;

    /* renamed from: f  reason: collision with root package name */
    public String f11166f;

    /* renamed from: g  reason: collision with root package name */
    public String f11167g;

    /* renamed from: h  reason: collision with root package name */
    public String f11168h;

    /* renamed from: i  reason: collision with root package name */
    public int f11169i;

    /* renamed from: j  reason: collision with root package name */
    public String f11170j;
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
            return "{ clipMaxDuration=" + this.f11161a + " , clipMinDuration=" + this.f11162b + " , topicSource=" + this.f11163c + " , publishURL=" + this.f11165e + " , publishType=" + this.k + " , publishTitle=" + this.f11164d + " , atURL=" + this.f11167g + " , topicURL=" + this.f11168h + " , musicURL=" + this.f11166f + " , sourceFrom=" + this.f11170j + " , sourceType=" + this.f11169i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
