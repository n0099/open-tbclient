package c.a.q0.q0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long a;

    /* renamed from: b  reason: collision with root package name */
    public int f12805b;

    /* renamed from: c  reason: collision with root package name */
    public Long f12806c;

    /* renamed from: d  reason: collision with root package name */
    public int f12807d;

    /* renamed from: e  reason: collision with root package name */
    public String f12808e;

    /* renamed from: f  reason: collision with root package name */
    public String f12809f;

    /* renamed from: g  reason: collision with root package name */
    public int f12810g;

    /* renamed from: h  reason: collision with root package name */
    public Long f12811h;

    /* renamed from: i  reason: collision with root package name */
    public int f12812i;

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
            return "YYPayResult{amount=" + this.a + ", appid=" + this.f12805b + ", currencyAmount=" + this.f12806c + ", currencyType=" + this.f12807d + ", expand='" + this.f12808e + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f12809f + ExtendedMessageFormat.QUOTE + ", status=" + this.f12810g + ", uid=" + this.f12811h + ", usedChannel=" + this.f12812i + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
