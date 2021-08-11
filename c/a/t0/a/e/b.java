package c.a.t0.a.e;

import android.content.Context;
import c.a.t0.a.e.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29707a;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1387a f29708b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1387a f29709c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(974206, "Lc/a/t0/a/e/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(974206, "Lc/a/t0/a/e/b;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (b.class) {
                if (!f29707a) {
                    c.a.t0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    f29708b = new c();
                    f29709c = new m();
                    a.a().c();
                    a.a().d(f29709c);
                    a.a().d(f29708b);
                    a.a().e(context);
                    f29707a = true;
                    return;
                }
                c.a.t0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
