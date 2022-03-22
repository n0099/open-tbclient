package c.a.n0.a.o1.c.d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.o1.c.f.c;
import c.a.n0.a.o1.c.f.e;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-619027320, "Lc/a/n0/a/o1/c/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-619027320, "Lc/a/n0/a/o1/c/d/b;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static void a(@Nullable Bundle bundle, @NonNull Class<? extends c.a.n0.a.o1.a.a.a> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bundle, cls) == null) {
            Iterator<c> it = e.k().q().iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && next.S()) {
                    b(next.f5627b, bundle, cls, null);
                }
            }
        }
    }

    public static void b(SwanAppProcessInfo swanAppProcessInfo, @Nullable Bundle bundle, @NonNull Class<? extends c.a.n0.a.o1.a.a.a> cls, @Nullable c.a.n0.a.o1.a.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, swanAppProcessInfo, bundle, cls, cVar) == null) {
            if (a) {
                Log.d("SwanAppMessageChannel", "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 125);
            obtain.replyTo = e.k().f5636d;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (cVar != null) {
                bundle2.putString("ai_apps_observer_id", cVar.b());
                c.a.n0.a.o1.a.b.b.a.b().e(cVar);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            obtain.obj = bundle2;
            c.a.n0.a.o1.c.a e2 = c.a.n0.a.o1.c.a.e();
            c.a.n0.a.o1.c.c cVar2 = new c.a.n0.a.o1.c.c(obtain);
            cVar2.b(swanAppProcessInfo);
            e2.h(cVar2);
        }
    }

    public static void c(@Nullable Bundle bundle, @NonNull Class<? extends c.a.n0.a.o1.a.a.a> cls, @Nullable c.a.n0.a.o1.a.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, bundle, cls, cVar) == null) {
            c.a.n0.a.o1.c.e.a.P().W(bundle, cls, cVar);
        }
    }
}
