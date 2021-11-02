package b.a.p0.h.e0.b;

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
    public long f10396a;

    /* renamed from: b  reason: collision with root package name */
    public long f10397b;

    /* renamed from: c  reason: collision with root package name */
    public String f10398c;

    /* renamed from: d  reason: collision with root package name */
    public String f10399d;

    /* renamed from: e  reason: collision with root package name */
    public String f10400e;

    /* renamed from: f  reason: collision with root package name */
    public String f10401f;

    /* renamed from: g  reason: collision with root package name */
    public String f10402g;

    /* renamed from: h  reason: collision with root package name */
    public String f10403h;

    /* renamed from: i  reason: collision with root package name */
    public int f10404i;
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
            return "{ clipMaxDuration=" + this.f10396a + " , clipMinDuration=" + this.f10397b + " , topicSource=" + this.f10398c + " , publishURL=" + this.f10400e + " , publishType=" + this.k + " , publishTitle=" + this.f10399d + " , atURL=" + this.f10402g + " , topicURL=" + this.f10403h + " , musicURL=" + this.f10401f + " , sourceFrom=" + this.j + " , sourceType=" + this.f10404i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
