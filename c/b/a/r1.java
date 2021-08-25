package c.b.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class r1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final LinkedList<p> f31310a;

    /* renamed from: b  reason: collision with root package name */
    public static final LinkedList<p> f31311b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2074072311, "Lc/b/a/r1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2074072311, "Lc/b/a/r1;");
                return;
            }
        }
        f31310a = new LinkedList<>();
        f31311b = new LinkedList<>();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            synchronized (f31310a) {
                linkedList.addAll(f31310a);
                linkedList2.addAll(f31311b);
                f31310a.clear();
                f31311b.clear();
            }
            while (!linkedList.isEmpty()) {
                j1.d((p) linkedList.poll());
            }
            while (!linkedList2.isEmpty()) {
                p pVar = (p) linkedList2.poll();
                x xVar = null;
                if (pVar instanceof x) {
                    xVar = (x) pVar;
                } else if (pVar instanceof r) {
                    r rVar = (r) pVar;
                    xVar = new x("" + rVar.q() + rVar.r(), Constants.VIA_REPORT_TYPE_START_WAP, 1);
                } else if (pVar instanceof t) {
                    xVar = new x(((t) pVar).r(), Constants.VIA_REPORT_TYPE_START_WAP, 1);
                }
                j1.d(xVar);
            }
        }
    }

    public static void b(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, pVar) == null) {
            synchronized (f31310a) {
                if (f31310a.size() > 200) {
                    h0.c("drop event in cache", null);
                    f31311b.add(f31310a.poll());
                }
                f31310a.add(pVar);
            }
        }
    }
}
