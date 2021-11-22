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
    public Long f13558a;

    /* renamed from: b  reason: collision with root package name */
    public int f13559b;

    /* renamed from: c  reason: collision with root package name */
    public Long f13560c;

    /* renamed from: d  reason: collision with root package name */
    public int f13561d;

    /* renamed from: e  reason: collision with root package name */
    public String f13562e;

    /* renamed from: f  reason: collision with root package name */
    public String f13563f;

    /* renamed from: g  reason: collision with root package name */
    public int f13564g;

    /* renamed from: h  reason: collision with root package name */
    public Long f13565h;

    /* renamed from: i  reason: collision with root package name */
    public int f13566i;

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
            return "YYPayResult{amount=" + this.f13558a + ", appid=" + this.f13559b + ", currencyAmount=" + this.f13560c + ", currencyType=" + this.f13561d + ", expand='" + this.f13562e + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f13563f + ExtendedMessageFormat.QUOTE + ", status=" + this.f13564g + ", uid=" + this.f13565h + ", usedChannel=" + this.f13566i + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
