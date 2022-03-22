package c.a.n0.j.f0.b;

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
    public long f8757b;

    /* renamed from: c  reason: collision with root package name */
    public String f8758c;

    /* renamed from: d  reason: collision with root package name */
    public String f8759d;

    /* renamed from: e  reason: collision with root package name */
    public String f8760e;

    /* renamed from: f  reason: collision with root package name */
    public String f8761f;

    /* renamed from: g  reason: collision with root package name */
    public String f8762g;

    /* renamed from: h  reason: collision with root package name */
    public String f8763h;
    public int i;
    public String j;
    public String k;
    public String l;
    public int m;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "{ clipMaxDuration=" + this.a + " , clipMinDuration=" + this.f8757b + " , topicSource=" + this.f8758c + " , publishURL=" + this.f8760e + " , publishType=" + this.k + " , publishTitle=" + this.f8759d + " , atURL=" + this.f8762g + " , topicURL=" + this.f8763h + " , musicURL=" + this.f8761f + " , sourceFrom=" + this.j + " , sourceType=" + this.i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
