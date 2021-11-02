package b.a.v0.a.e;

import android.content.Context;
import b.a.v0.a.e.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29098a;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1404a f29099b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1404a f29100c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(974435583, "Lb/a/v0/a/e/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(974435583, "Lb/a/v0/a/e/b;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (b.class) {
                if (!f29098a) {
                    b.a.v0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    f29099b = new c();
                    f29100c = new m();
                    a.a().c();
                    a.a().d(f29100c);
                    a.a().d(f29099b);
                    a.a().e(context);
                    f29098a = true;
                    return;
                }
                b.a.v0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
