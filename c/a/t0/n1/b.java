package c.a.t0.n1;

import c.a.t0.o1.d.d;
import c.a.t0.x1.p.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
/* loaded from: classes7.dex */
public class b implements c.a.t0.x1.s.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.InterfaceC1270d a;

    public b(d.InterfaceC1270d interfaceC1270d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC1270d};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = interfaceC1270d;
    }

    @Override // c.a.t0.x1.s.b
    public void a(boolean z, Message message, boolean z2, long j2, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j2), str, Integer.valueOf(i2)}) == null) {
            c.a.t0.n1.c.a aVar = new c.a.t0.n1.c.a();
            e eVar = new e();
            eVar.a = j2;
            eVar.f25253b = str;
            c.a.t0.x1.p.a a = c.a.t0.x1.r.b.d().a(eVar);
            if (a != null) {
                a.c(z, message, z2, i2);
            }
            aVar.b(a);
            d.InterfaceC1270d interfaceC1270d = this.a;
            if (interfaceC1270d != null) {
                interfaceC1270d.e(z, aVar, z2, "", str, true);
            }
        }
    }

    @Override // c.a.t0.x1.s.b
    public void b(long j2, String str, String str2, int i2) {
        d.InterfaceC1270d interfaceC1270d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), str, str2, Integer.valueOf(i2)}) == null) || (interfaceC1270d = this.a) == null) {
            return;
        }
        interfaceC1270d.c(str, str2, i2, true, 1);
    }

    @Override // c.a.t0.x1.s.b
    public void c(long j2, String str, Message message, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), str, message, Boolean.valueOf(z)}) == null) {
        }
    }
}
