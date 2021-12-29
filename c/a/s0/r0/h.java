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
    public int f13298b;

    /* renamed from: c  reason: collision with root package name */
    public Long f13299c;

    /* renamed from: d  reason: collision with root package name */
    public int f13300d;

    /* renamed from: e  reason: collision with root package name */
    public String f13301e;

    /* renamed from: f  reason: collision with root package name */
    public String f13302f;

    /* renamed from: g  reason: collision with root package name */
    public int f13303g;

    /* renamed from: h  reason: collision with root package name */
    public Long f13304h;

    /* renamed from: i  reason: collision with root package name */
    public int f13305i;

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
            return "YYPayResult{amount=" + this.a + ", appid=" + this.f13298b + ", currencyAmount=" + this.f13299c + ", currencyType=" + this.f13300d + ", expand='" + this.f13301e + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f13302f + ExtendedMessageFormat.QUOTE + ", status=" + this.f13303g + ", uid=" + this.f13304h + ", usedChannel=" + this.f13305i + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
