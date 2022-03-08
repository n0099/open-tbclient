package c.a.b0.v.v0;

import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -2;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(745866233, "Lc/a/b0/v/v0/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(745866233, "Lc/a/b0/v/v0/c;");
        }
    }

    public static void a(ClarityUrlList clarityUrlList) {
        ClarityUrlList.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, clarityUrlList) == null) {
            Iterator it = clarityUrlList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (ClarityUrlList.c) it.next();
                if ("auto".equals(cVar.c())) {
                    break;
                }
            }
            if (cVar != null) {
                clarityUrlList.remove(cVar);
            }
        }
    }

    public static c.a.b0.v.m0.c b(ClarityUrlList clarityUrlList, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{clarityUrlList, Double.valueOf(d2)})) == null) {
            a(clarityUrlList);
            int f2 = n.f(a);
            a = f2;
            return n.g(clarityUrlList, f2, d2, false);
        }
        return (c.a.b0.v.m0.c) invokeCommon.objValue;
    }
}
