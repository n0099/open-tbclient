package b.a.r0.q1.r;

import b.a.r0.q1.p.e;
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
/* loaded from: classes5.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<a> f24289a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f24290b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2041687845, "Lb/a/r0/q1/r/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2041687845, "Lb/a/r0/q1/r/b;");
                return;
            }
        }
        f24289a = new AtomicReference<>(null);
        f24290b = new b();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            a aVar = f24289a.get();
            return aVar == null ? f24290b : aVar;
        }
        return (a) invokeV.objValue;
    }

    @Override // b.a.r0.q1.r.a
    public b.a.r0.q1.p.a a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            BdLog.e("Card project loaded failed.");
            return null;
        }
        return (b.a.r0.q1.p.a) invokeL.objValue;
    }

    @Override // b.a.r0.q1.r.a
    public b.a.r0.q1.o.g.a b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, bdUniqueId, i2)) == null) {
            BdLog.e("Card project loaded failed.");
            return null;
        }
        return (b.a.r0.q1.o.g.a) invokeLLI.objValue;
    }

    @Override // b.a.r0.q1.r.a
    public b.a.r0.q1.s.a c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, bdUniqueId)) == null) {
            BdLog.e("Card project loaded failed.");
            return null;
        }
        return (b.a.r0.q1.s.a) invokeLL.objValue;
    }
}
