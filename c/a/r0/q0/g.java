package c.a.r0.q0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long a;

    /* renamed from: b  reason: collision with root package name */
    public int f12818b;

    /* renamed from: c  reason: collision with root package name */
    public Long f12819c;

    /* renamed from: d  reason: collision with root package name */
    public int f12820d;

    /* renamed from: e  reason: collision with root package name */
    public String f12821e;

    /* renamed from: f  reason: collision with root package name */
    public String f12822f;

    /* renamed from: g  reason: collision with root package name */
    public int f12823g;

    /* renamed from: h  reason: collision with root package name */
    public Long f12824h;

    /* renamed from: i  reason: collision with root package name */
    public int f12825i;

    public g() {
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
            return "YYPayResult{amount=" + this.a + ", appid=" + this.f12818b + ", currencyAmount=" + this.f12819c + ", currencyType=" + this.f12820d + ", expand='" + this.f12821e + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f12822f + ExtendedMessageFormat.QUOTE + ", status=" + this.f12823g + ", uid=" + this.f12824h + ", usedChannel=" + this.f12825i + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
