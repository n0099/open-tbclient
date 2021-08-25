package c.a.p0.n0;

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
    public Long f13655a;

    /* renamed from: b  reason: collision with root package name */
    public int f13656b;

    /* renamed from: c  reason: collision with root package name */
    public Long f13657c;

    /* renamed from: d  reason: collision with root package name */
    public int f13658d;

    /* renamed from: e  reason: collision with root package name */
    public String f13659e;

    /* renamed from: f  reason: collision with root package name */
    public String f13660f;

    /* renamed from: g  reason: collision with root package name */
    public int f13661g;

    /* renamed from: h  reason: collision with root package name */
    public Long f13662h;

    /* renamed from: i  reason: collision with root package name */
    public int f13663i;

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
            return "YYPayResult{amount=" + this.f13655a + ", appid=" + this.f13656b + ", currencyAmount=" + this.f13657c + ", currencyType=" + this.f13658d + ", expand='" + this.f13659e + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f13660f + ExtendedMessageFormat.QUOTE + ", status=" + this.f13661g + ", uid=" + this.f13662h + ", usedChannel=" + this.f13663i + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
