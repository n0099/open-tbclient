package c.a.q0.p0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Long f13654a;

    /* renamed from: b  reason: collision with root package name */
    public int f13655b;

    /* renamed from: c  reason: collision with root package name */
    public Long f13656c;

    /* renamed from: d  reason: collision with root package name */
    public int f13657d;

    /* renamed from: e  reason: collision with root package name */
    public String f13658e;

    /* renamed from: f  reason: collision with root package name */
    public String f13659f;

    /* renamed from: g  reason: collision with root package name */
    public int f13660g;

    /* renamed from: h  reason: collision with root package name */
    public Long f13661h;

    /* renamed from: i  reason: collision with root package name */
    public int f13662i;

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
            return "YYPayResult{amount=" + this.f13654a + ", appid=" + this.f13655b + ", currencyAmount=" + this.f13656c + ", currencyType=" + this.f13657d + ", expand='" + this.f13658e + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f13659f + ExtendedMessageFormat.QUOTE + ", status=" + this.f13660g + ", uid=" + this.f13661h + ", usedChannel=" + this.f13662i + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
