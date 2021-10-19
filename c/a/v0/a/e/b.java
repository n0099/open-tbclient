package c.a.v0.a.e;

import android.content.Context;
import c.a.v0.a.e.a;
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
    public static boolean f30372a;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1404a f30373b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1404a f30374c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(681032576, "Lc/a/v0/a/e/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(681032576, "Lc/a/v0/a/e/b;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (b.class) {
                if (!f30372a) {
                    c.a.v0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    f30373b = new c();
                    f30374c = new m();
                    a.a().c();
                    a.a().d(f30374c);
                    a.a().d(f30373b);
                    a.a().e(context);
                    f30372a = true;
                    return;
                }
                c.a.v0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
