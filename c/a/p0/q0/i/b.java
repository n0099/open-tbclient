package c.a.p0.q0.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f17099b;

    /* renamed from: c  reason: collision with root package name */
    public float f17100c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f17101d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17102e;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17099b = new ArrayList();
        this.f17101d = false;
        this.f17102e = false;
    }

    public static final b c(DnsIpData dnsIpData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dnsIpData)) == null) {
            if (dnsIpData == null) {
                return null;
            }
            b bVar = new b();
            bVar.a = dnsIpData.address;
            for (int i = 0; i < dnsIpData.data.size(); i++) {
                bVar.f17099b.add(dnsIpData.data.get(i));
            }
            bVar.b();
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static final DnsIpData d(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            DnsIpData.Builder builder = new DnsIpData.Builder();
            builder.address = bVar.a;
            builder.data = new ArrayList();
            for (Integer num : bVar.f17099b) {
                builder.data.add(Integer.valueOf(num.intValue()));
            }
            return builder.build(true);
        }
        return (DnsIpData) invokeL.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.f17099b.add(0, Integer.valueOf(i));
            while (this.f17099b.size() > 49) {
                List<Integer> list = this.f17099b;
                list.remove(list.size() - 1);
            }
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int size = this.f17099b.size();
            float f2 = 0.0f;
            if (size <= 0) {
                this.f17100c = 0.0f;
                return;
            }
            int i = 0;
            if (size == 1) {
                this.f17100c = this.f17099b.get(0).intValue();
                return;
            }
            float f3 = 1.0f;
            for (Integer num : this.f17099b) {
                int intValue = num.intValue();
                i += intValue;
                f3 *= 0.5f;
                f2 += intValue * f3;
            }
            float f4 = f2 + ((f3 * i) / size);
            this.f17100c = f4;
            if (f4 < 0.05d) {
                if (this.f17101d) {
                    return;
                }
                c.a.p0.q0.d.c().b("ip_weight_lower", this.a, String.valueOf(this.f17100c));
                this.f17101d = true;
            } else if (this.f17101d && f4 > 0.5d && !this.f17102e) {
                c.a.p0.q0.d.c().b("ip_weight_lower_recover", this.a, String.valueOf(this.f17100c));
                this.f17102e = true;
            }
        }
    }
}
