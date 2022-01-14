package c.a.r0.a.a1;

import android.os.Bundle;
import c.a.r0.a.a1.f;
import c.a.r0.a.f1.g.b;
import c.a.r0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes.dex */
public class c extends f.AbstractC0261f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f5135j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f5136h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.r0.q.f.f f5137i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(419545182, "Lc/a/r0/a/a1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(419545182, "Lc/a/r0/a/a1/c;");
                return;
            }
        }
        f5135j = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, c.a.r0.q.f.f fVar) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5136h = str;
        this.f5137i = fVar;
    }

    @Override // c.a.r0.a.a1.f.AbstractC0261f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        c.a.r0.a.u2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            c.a.r0.a.f1.g.a d2 = c.a.r0.a.f1.g.a.d(bundle.getString("launch_id"));
            b.C0320b e2 = d2.e();
            e2.b("SignChecker");
            e2.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    aVar = c.a.r0.a.h0.m.u.a.a(sourceChannel, this.f5136h, this.f5137i);
                } catch (IOException e3) {
                    if (f5135j) {
                        e3.printStackTrace();
                    }
                    c.a.r0.a.u2.a aVar2 = new c.a.r0.a.u2.a();
                    aVar2.k(11L);
                    aVar2.i(2300L);
                    aVar2.f("inputStream IOException:" + e3.toString());
                    c.a.r0.a.u2.e.a().f(aVar2);
                    d2.g("SignChecker", aVar2.toString());
                    c.a.r0.a.z2.e1.b.a(sourceChannel);
                    aVar = aVar2;
                }
                d2.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                boolean z = aVar == null;
                if (aVar != null) {
                    d2.g("SignChecker", aVar.toString());
                    b().putLong("result_error_code", aVar.a());
                }
                d2.g("SignChecker", "done: " + z);
                return z;
            } finally {
                c.a.r0.a.z2.e1.b.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
