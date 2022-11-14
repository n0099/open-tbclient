package com.baidu.swan.apps.optimization.quotasaver;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class QuotaSaver$suspendDelayTime$2 extends Lambda implements Function0<Long> {
    public static /* synthetic */ Interceptable $ic;
    public static final QuotaSaver$suspendDelayTime$2 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1305771439, "Lcom/baidu/swan/apps/optimization/quotasaver/QuotaSaver$suspendDelayTime$2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1305771439, "Lcom/baidu/swan/apps/optimization/quotasaver/QuotaSaver$suspendDelayTime$2;");
                return;
            }
        }
        INSTANCE = new QuotaSaver$suspendDelayTime$2();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuotaSaver$suspendDelayTime$2() {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Return type fixed from 'long' to match base method */
    /* JADX WARN: Type inference failed for: r0v4, types: [long, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r1v0, types: [long, java.lang.Long] */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return QuotaSaver.l.b().l("suspend_delay_time", -1L);
        }
        return invokeV.longValue;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Long invoke2() {
        return Long.valueOf(invoke());
    }
}
