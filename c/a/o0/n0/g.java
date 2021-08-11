package c.a.o0.n0;

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
    public Long f13364a;

    /* renamed from: b  reason: collision with root package name */
    public int f13365b;

    /* renamed from: c  reason: collision with root package name */
    public Long f13366c;

    /* renamed from: d  reason: collision with root package name */
    public int f13367d;

    /* renamed from: e  reason: collision with root package name */
    public String f13368e;

    /* renamed from: f  reason: collision with root package name */
    public String f13369f;

    /* renamed from: g  reason: collision with root package name */
    public int f13370g;

    /* renamed from: h  reason: collision with root package name */
    public Long f13371h;

    /* renamed from: i  reason: collision with root package name */
    public int f13372i;

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
            return "YYPayResult{amount=" + this.f13364a + ", appid=" + this.f13365b + ", currencyAmount=" + this.f13366c + ", currencyType=" + this.f13367d + ", expand='" + this.f13368e + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f13369f + ExtendedMessageFormat.QUOTE + ", status=" + this.f13370g + ", uid=" + this.f13371h + ", usedChannel=" + this.f13372i + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
