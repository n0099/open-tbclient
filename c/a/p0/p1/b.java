package c.a.p0.p1;

import c.a.p0.b2.p.e;
import c.a.p0.q1.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
/* loaded from: classes2.dex */
public class b implements c.a.p0.b2.s.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.InterfaceC1293d a;

    public b(d.InterfaceC1293d interfaceC1293d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC1293d};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = interfaceC1293d;
    }

    @Override // c.a.p0.b2.s.b
    public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i)}) == null) {
            c.a.p0.p1.c.a aVar = new c.a.p0.p1.c.a();
            e eVar = new e();
            eVar.a = j;
            eVar.f12571b = str;
            c.a.p0.b2.p.a a = c.a.p0.b2.r.b.d().a(eVar);
            if (a != null) {
                a.c(z, message, z2, i);
            }
            aVar.b(a);
            d.InterfaceC1293d interfaceC1293d = this.a;
            if (interfaceC1293d != null) {
                interfaceC1293d.e(z, aVar, z2, "", str, true);
            }
        }
    }

    @Override // c.a.p0.b2.s.b
    public void b(long j, String str, String str2, int i) {
        d.InterfaceC1293d interfaceC1293d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) == null) || (interfaceC1293d = this.a) == null) {
            return;
        }
        interfaceC1293d.c(str, str2, i, true, 1);
    }

    @Override // c.a.p0.b2.s.b
    public void c(long j, String str, Message message, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
        }
    }
}
