package c.a.p0.e1;

import c.a.p0.f1.d.c;
import c.a.p0.o1.p.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
/* loaded from: classes3.dex */
public class b implements c.a.p0.o1.s.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.d f16666a;

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
        this.f16666a = dVar;
    }

    @Override // c.a.p0.o1.s.b
    public void a(boolean z, Message message, boolean z2, long j2, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j2), str, Integer.valueOf(i2)}) == null) {
            c.a.p0.e1.c.a aVar = new c.a.p0.e1.c.a();
            e eVar = new e();
            eVar.f22740a = j2;
            eVar.f22741b = str;
            c.a.p0.o1.p.a a2 = c.a.p0.o1.r.b.d().a(eVar);
            if (a2 != null) {
                a2.c(z, message, z2, i2);
            }
            aVar.b(a2);
            c.d dVar = this.f16666a;
            if (dVar != null) {
                dVar.e(z, aVar, z2, "", str, true);
            }
        }
    }

    @Override // c.a.p0.o1.s.b
    public void b(long j2, String str, String str2, int i2) {
        c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), str, str2, Integer.valueOf(i2)}) == null) || (dVar = this.f16666a) == null) {
            return;
        }
        dVar.c(str, str2, i2, true, 1);
    }

    @Override // c.a.p0.o1.s.b
    public void c(long j2, String str, Message message, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), str, message, Boolean.valueOf(z)}) == null) {
        }
    }
}
