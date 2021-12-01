package c.a.q0.q0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long a;

    /* renamed from: b  reason: collision with root package name */
    public int f12491b;

    /* renamed from: c  reason: collision with root package name */
    public Long f12492c;

    /* renamed from: d  reason: collision with root package name */
    public int f12493d;

    /* renamed from: e  reason: collision with root package name */
    public String f12494e;

    /* renamed from: f  reason: collision with root package name */
    public String f12495f;

    /* renamed from: g  reason: collision with root package name */
    public int f12496g;

    /* renamed from: h  reason: collision with root package name */
    public Long f12497h;

    /* renamed from: i  reason: collision with root package name */
    public int f12498i;

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
            return "YYPayResult{amount=" + this.a + ", appid=" + this.f12491b + ", currencyAmount=" + this.f12492c + ", currencyType=" + this.f12493d + ", expand='" + this.f12494e + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f12495f + ExtendedMessageFormat.QUOTE + ", status=" + this.f12496g + ", uid=" + this.f12497h + ", usedChannel=" + this.f12498i + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
