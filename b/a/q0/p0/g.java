package b.a.q0.p0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Long f12808a;

    /* renamed from: b  reason: collision with root package name */
    public int f12809b;

    /* renamed from: c  reason: collision with root package name */
    public Long f12810c;

    /* renamed from: d  reason: collision with root package name */
    public int f12811d;

    /* renamed from: e  reason: collision with root package name */
    public String f12812e;

    /* renamed from: f  reason: collision with root package name */
    public String f12813f;

    /* renamed from: g  reason: collision with root package name */
    public int f12814g;

    /* renamed from: h  reason: collision with root package name */
    public Long f12815h;

    /* renamed from: i  reason: collision with root package name */
    public int f12816i;

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
            return "YYPayResult{amount=" + this.f12808a + ", appid=" + this.f12809b + ", currencyAmount=" + this.f12810c + ", currencyType=" + this.f12811d + ", expand='" + this.f12812e + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f12813f + ExtendedMessageFormat.QUOTE + ", status=" + this.f12814g + ", uid=" + this.f12815h + ", usedChannel=" + this.f12816i + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
