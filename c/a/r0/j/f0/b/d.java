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
    public long f11256b;

    /* renamed from: c  reason: collision with root package name */
    public String f11257c;

    /* renamed from: d  reason: collision with root package name */
    public String f11258d;

    /* renamed from: e  reason: collision with root package name */
    public String f11259e;

    /* renamed from: f  reason: collision with root package name */
    public String f11260f;

    /* renamed from: g  reason: collision with root package name */
    public String f11261g;

    /* renamed from: h  reason: collision with root package name */
    public String f11262h;

    /* renamed from: i  reason: collision with root package name */
    public int f11263i;

    /* renamed from: j  reason: collision with root package name */
    public String f11264j;

    /* renamed from: k  reason: collision with root package name */
    public String f11265k;
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
            return "{ clipMaxDuration=" + this.a + " , clipMinDuration=" + this.f11256b + " , topicSource=" + this.f11257c + " , publishURL=" + this.f11259e + " , publishType=" + this.f11265k + " , publishTitle=" + this.f11258d + " , atURL=" + this.f11261g + " , topicURL=" + this.f11262h + " , musicURL=" + this.f11260f + " , sourceFrom=" + this.f11264j + " , sourceType=" + this.f11263i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
