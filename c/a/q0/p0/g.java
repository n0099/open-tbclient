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
    public Long f13658a;

    /* renamed from: b  reason: collision with root package name */
    public int f13659b;

    /* renamed from: c  reason: collision with root package name */
    public Long f13660c;

    /* renamed from: d  reason: collision with root package name */
    public int f13661d;

    /* renamed from: e  reason: collision with root package name */
    public String f13662e;

    /* renamed from: f  reason: collision with root package name */
    public String f13663f;

    /* renamed from: g  reason: collision with root package name */
    public int f13664g;

    /* renamed from: h  reason: collision with root package name */
    public Long f13665h;

    /* renamed from: i  reason: collision with root package name */
    public int f13666i;

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
            return "YYPayResult{amount=" + this.f13658a + ", appid=" + this.f13659b + ", currencyAmount=" + this.f13660c + ", currencyType=" + this.f13661d + ", expand='" + this.f13662e + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f13663f + ExtendedMessageFormat.QUOTE + ", status=" + this.f13664g + ", uid=" + this.f13665h + ", usedChannel=" + this.f13666i + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
