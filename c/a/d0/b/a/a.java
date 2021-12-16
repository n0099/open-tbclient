package c.a.d0.b.a;

import android.app.Application;
import android.content.Context;
import c.a.d0.i.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Application application) {
        InterceptResult invokeL;
        Object e2;
        ClassLoader classLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, application)) == null) {
            try {
                Context baseContext = application.getBaseContext();
                if (baseContext == null || (e2 = h.e(baseContext, "mPackageInfo")) == null || (classLoader = (ClassLoader) h.e(e2, "mClassLoader")) == null) {
                    return false;
                }
                b bVar = new b(classLoader.getParent(), classLoader);
                h.j(e2, "mClassLoader", bVar);
                Thread.currentThread().setContextClassLoader(bVar);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
