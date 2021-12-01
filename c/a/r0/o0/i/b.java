package c.a.r0.o0.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f20811b;

    /* renamed from: c  reason: collision with root package name */
    public float f20812c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20813d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20814e;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20811b = new ArrayList();
        this.f20813d = false;
        this.f20814e = false;
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
            for (int i2 = 0; i2 < dnsIpData.data.size(); i2++) {
                bVar.f20811b.add(dnsIpData.data.get(i2));
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
            for (Integer num : bVar.f20811b) {
                builder.data.add(Integer.valueOf(num.intValue()));
            }
            return builder.build(true);
        }
        return (DnsIpData) invokeL.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f20811b.add(0, Integer.valueOf(i2));
            while (this.f20811b.size() > 49) {
                List<Integer> list = this.f20811b;
                list.remove(list.size() - 1);
            }
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int size = this.f20811b.size();
            float f2 = 0.0f;
            if (size <= 0) {
                this.f20812c = 0.0f;
                return;
            }
            int i2 = 0;
            if (size == 1) {
                this.f20812c = this.f20811b.get(0).intValue();
                return;
            }
            float f3 = 1.0f;
            for (Integer num : this.f20811b) {
                int intValue = num.intValue();
                i2 += intValue;
                f3 *= 0.5f;
                f2 += intValue * f3;
            }
            float f4 = f2 + ((f3 * i2) / size);
            this.f20812c = f4;
            if (f4 < 0.05d) {
                if (this.f20813d) {
                    return;
                }
                c.a.r0.o0.d.c().b("ip_weight_lower", this.a, String.valueOf(this.f20812c));
                this.f20813d = true;
            } else if (this.f20813d && f4 > 0.5d && !this.f20814e) {
                c.a.r0.o0.d.c().b("ip_weight_lower_recover", this.a, String.valueOf(this.f20812c));
                this.f20814e = true;
            }
        }
    }
}
