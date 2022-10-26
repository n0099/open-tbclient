package com.baidu.swan.apps.optimization.quotasaver;

import com.baidu.android.imsdk.internal.Constants;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class QuotaSaver$shouldSuspendAnything$2 extends Lambda implements Function0 {
    public static /* synthetic */ Interceptable $ic;
    public static final QuotaSaver$shouldSuspendAnything$2 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2029285324, "Lcom/baidu/swan/apps/optimization/quotasaver/QuotaSaver$shouldSuspendAnything$2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2029285324, "Lcom/baidu/swan/apps/optimization/quotasaver/QuotaSaver$shouldSuspendAnything$2;");
                return;
            }
        }
        INSTANCE = new QuotaSaver$shouldSuspendAnything$2();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuotaSaver$shouldSuspendAnything$2() {
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

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(invoke());
    }

    @Override // kotlin.jvm.functions.Function0
    public final boolean invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!QuotaSaver.l.f() && !QuotaSaver.l.j() && !QuotaSaver.l.k() && !QuotaSaver.l.h() && !QuotaSaver.l.i()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
