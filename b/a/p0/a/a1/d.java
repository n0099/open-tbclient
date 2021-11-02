package b.a.p0.a.a1;

import android.os.Bundle;
import b.a.p0.a.a1.g;
import b.a.p0.a.f1.g.b;
import b.a.p0.a.k;
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
public class d extends g.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f3895h;

    /* renamed from: i  reason: collision with root package name */
    public final b.a.p0.n.f.d f3896i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1318130848, "Lb/a/p0/a/a1/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1318130848, "Lb/a/p0/a/a1/d;");
                return;
            }
        }
        j = k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, b.a.p0.n.f.d dVar) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, dVar};
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
        this.f3895h = str;
        this.f3896i = dVar;
    }

    @Override // b.a.p0.a.a1.g.f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        b.a.p0.a.q2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            b.a.p0.a.f1.g.a d2 = b.a.p0.a.f1.g.a.d(bundle.getString("launch_id"));
            b.C0183b e2 = d2.e();
            e2.b("SignChecker");
            e2.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    aVar = b.a.p0.a.h0.m.r.a.a(sourceChannel, this.f3895h, this.f3896i);
                } catch (IOException e3) {
                    if (j) {
                        e3.printStackTrace();
                    }
                    b.a.p0.a.q2.a aVar2 = new b.a.p0.a.q2.a();
                    aVar2.j(11L);
                    aVar2.h(2300L);
                    aVar2.e("inputStream IOException:" + e3.toString());
                    b.a.p0.a.q2.e.a().f(aVar2);
                    d2.g("SignChecker", aVar2.toString());
                    b.a.p0.a.v2.c1.b.a(sourceChannel);
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
                b.a.p0.a.v2.c1.b.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
