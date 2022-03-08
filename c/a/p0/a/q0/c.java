package c.a.p0.a.q0;

import android.os.Bundle;
import c.a.p0.a.q0.f;
import c.a.p0.a.v0.g.b;
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
public class c extends f.AbstractC0435f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f7110j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f7111h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.p0.q.e.f f7112i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(827318737, "Lc/a/p0/a/q0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(827318737, "Lc/a/p0/a/q0/c;");
                return;
            }
        }
        f7110j = c.a.p0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, c.a.p0.q.e.f fVar) {
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
        this.f7111h = str;
        this.f7112i = fVar;
    }

    @Override // c.a.p0.a.q0.f.AbstractC0435f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        c.a.p0.a.k2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            c.a.p0.a.v0.g.a d2 = c.a.p0.a.v0.g.a.d(bundle.getString("launch_id"));
            b.C0494b e2 = d2.e();
            e2.b("SignChecker");
            e2.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    aVar = c.a.p0.a.x.m.u.a.a(sourceChannel, this.f7111h, this.f7112i);
                } catch (IOException e3) {
                    if (f7110j) {
                        e3.printStackTrace();
                    }
                    c.a.p0.a.k2.a aVar2 = new c.a.p0.a.k2.a();
                    aVar2.k(11L);
                    aVar2.i(2300L);
                    aVar2.f("inputStream IOException:" + e3.toString());
                    c.a.p0.a.k2.e.a().f(aVar2);
                    d2.g("SignChecker", aVar2.toString());
                    c.a.p0.a.p2.e1.b.a(sourceChannel);
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
                c.a.p0.a.p2.e1.b.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
