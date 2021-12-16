package c.a.q0.j.f0.b;

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
    public long f10521b;

    /* renamed from: c  reason: collision with root package name */
    public String f10522c;

    /* renamed from: d  reason: collision with root package name */
    public String f10523d;

    /* renamed from: e  reason: collision with root package name */
    public String f10524e;

    /* renamed from: f  reason: collision with root package name */
    public String f10525f;

    /* renamed from: g  reason: collision with root package name */
    public String f10526g;

    /* renamed from: h  reason: collision with root package name */
    public String f10527h;

    /* renamed from: i  reason: collision with root package name */
    public int f10528i;

    /* renamed from: j  reason: collision with root package name */
    public String f10529j;

    /* renamed from: k  reason: collision with root package name */
    public String f10530k;
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
            return "{ clipMaxDuration=" + this.a + " , clipMinDuration=" + this.f10521b + " , topicSource=" + this.f10522c + " , publishURL=" + this.f10524e + " , publishType=" + this.f10530k + " , publishTitle=" + this.f10523d + " , atURL=" + this.f10526g + " , topicURL=" + this.f10527h + " , musicURL=" + this.f10525f + " , sourceFrom=" + this.f10529j + " , sourceType=" + this.f10528i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
