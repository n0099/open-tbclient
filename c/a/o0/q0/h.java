package c.a.o0.q0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long a;

    /* renamed from: b  reason: collision with root package name */
    public int f10484b;

    /* renamed from: c  reason: collision with root package name */
    public Long f10485c;

    /* renamed from: d  reason: collision with root package name */
    public int f10486d;

    /* renamed from: e  reason: collision with root package name */
    public String f10487e;

    /* renamed from: f  reason: collision with root package name */
    public String f10488f;

    /* renamed from: g  reason: collision with root package name */
    public int f10489g;

    /* renamed from: h  reason: collision with root package name */
    public Long f10490h;
    public int i;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "YYPayResult{amount=" + this.a + ", appid=" + this.f10484b + ", currencyAmount=" + this.f10485c + ", currencyType=" + this.f10486d + ", expand='" + this.f10487e + "', orderId='" + this.f10488f + "', status=" + this.f10489g + ", uid=" + this.f10490h + ", usedChannel=" + this.i + '}';
        }
        return (String) invokeV.objValue;
    }
}
