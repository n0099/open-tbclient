package b.a.r0.g1;

import b.a.r0.h1.d.c;
import b.a.r0.q1.p.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
/* loaded from: classes4.dex */
public class b implements b.a.r0.q1.s.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.d f18221a;

    public b(c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18221a = dVar;
    }

    @Override // b.a.r0.q1.s.b
    public void a(boolean z, Message message, boolean z2, long j, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i2)}) == null) {
            b.a.r0.g1.c.a aVar = new b.a.r0.g1.c.a();
            e eVar = new e();
            eVar.f24259a = j;
            eVar.f24260b = str;
            b.a.r0.q1.p.a a2 = b.a.r0.q1.r.b.d().a(eVar);
            if (a2 != null) {
                a2.d(z, message, z2, i2);
            }
            aVar.b(a2);
            c.d dVar = this.f18221a;
            if (dVar != null) {
                dVar.e(z, aVar, z2, "", str, true);
            }
        }
    }

    @Override // b.a.r0.q1.s.b
    public void b(long j, String str, String str2, int i2) {
        c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i2)}) == null) || (dVar = this.f18221a) == null) {
            return;
        }
        dVar.c(str, str2, i2, true, 1);
    }

    @Override // b.a.r0.q1.s.b
    public void c(long j, String str, Message message, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
        }
    }
}
