package c.a.p0.b2.r;

import c.a.p0.b2.p.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<a> a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f12593b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1741723660, "Lc/a/p0/b2/r/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1741723660, "Lc/a/p0/b2/r/b;");
                return;
            }
        }
        a = new AtomicReference<>(null);
        f12593b = new b();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            a aVar = a.get();
            return aVar == null ? f12593b : aVar;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.p0.b2.r.a
    public c.a.p0.b2.p.a a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            BdLog.e("Card project loaded failed.");
            return null;
        }
        return (c.a.p0.b2.p.a) invokeL.objValue;
    }

    @Override // c.a.p0.b2.r.a
    public c.a.p0.b2.o.g.a b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, bdUniqueId, i)) == null) {
            BdLog.e("Card project loaded failed.");
            return null;
        }
        return (c.a.p0.b2.o.g.a) invokeLLI.objValue;
    }

    @Override // c.a.p0.b2.r.a
    public c.a.p0.b2.s.a c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, bdUniqueId)) == null) {
            BdLog.e("Card project loaded failed.");
            return null;
        }
        return (c.a.p0.b2.s.a) invokeLL.objValue;
    }
}
