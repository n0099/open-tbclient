package c.a.t0.r0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long a;

    /* renamed from: b  reason: collision with root package name */
    public int f13389b;

    /* renamed from: c  reason: collision with root package name */
    public Long f13390c;

    /* renamed from: d  reason: collision with root package name */
    public int f13391d;

    /* renamed from: e  reason: collision with root package name */
    public String f13392e;

    /* renamed from: f  reason: collision with root package name */
    public String f13393f;

    /* renamed from: g  reason: collision with root package name */
    public int f13394g;

    /* renamed from: h  reason: collision with root package name */
    public Long f13395h;

    /* renamed from: i  reason: collision with root package name */
    public int f13396i;

    public h() {
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
            return "YYPayResult{amount=" + this.a + ", appid=" + this.f13389b + ", currencyAmount=" + this.f13390c + ", currencyType=" + this.f13391d + ", expand='" + this.f13392e + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f13393f + ExtendedMessageFormat.QUOTE + ", status=" + this.f13394g + ", uid=" + this.f13395h + ", usedChannel=" + this.f13396i + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
