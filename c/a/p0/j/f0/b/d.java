package c.a.p0.j.f0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f10212b;

    /* renamed from: c  reason: collision with root package name */
    public String f10213c;

    /* renamed from: d  reason: collision with root package name */
    public String f10214d;

    /* renamed from: e  reason: collision with root package name */
    public String f10215e;

    /* renamed from: f  reason: collision with root package name */
    public String f10216f;

    /* renamed from: g  reason: collision with root package name */
    public String f10217g;

    /* renamed from: h  reason: collision with root package name */
    public String f10218h;

    /* renamed from: i  reason: collision with root package name */
    public int f10219i;

    /* renamed from: j  reason: collision with root package name */
    public String f10220j;

    /* renamed from: k  reason: collision with root package name */
    public String f10221k;
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
            return "{ clipMaxDuration=" + this.a + " , clipMinDuration=" + this.f10212b + " , topicSource=" + this.f10213c + " , publishURL=" + this.f10215e + " , publishType=" + this.f10221k + " , publishTitle=" + this.f10214d + " , atURL=" + this.f10217g + " , topicURL=" + this.f10218h + " , musicURL=" + this.f10216f + " , sourceFrom=" + this.f10220j + " , sourceType=" + this.f10219i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
