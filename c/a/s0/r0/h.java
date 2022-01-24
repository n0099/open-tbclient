package c.a.s0.r0;

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
    public int f13122b;

    /* renamed from: c  reason: collision with root package name */
    public Long f13123c;

    /* renamed from: d  reason: collision with root package name */
    public int f13124d;

    /* renamed from: e  reason: collision with root package name */
    public String f13125e;

    /* renamed from: f  reason: collision with root package name */
    public String f13126f;

    /* renamed from: g  reason: collision with root package name */
    public int f13127g;

    /* renamed from: h  reason: collision with root package name */
    public Long f13128h;

    /* renamed from: i  reason: collision with root package name */
    public int f13129i;

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
            return "YYPayResult{amount=" + this.a + ", appid=" + this.f13122b + ", currencyAmount=" + this.f13123c + ", currencyType=" + this.f13124d + ", expand='" + this.f13125e + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f13126f + ExtendedMessageFormat.QUOTE + ", status=" + this.f13127g + ", uid=" + this.f13128h + ", usedChannel=" + this.f13129i + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
