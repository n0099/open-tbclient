package com.baidu.swan.apps.alliance.login;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.zj1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/swan/apps/account/SwanAppAccountStatusChangedListener;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class SwanAppAllianceLoginHelper$loginStatusChangeCallbacks$2 extends Lambda implements Function0<List<zj1>> {
    public static /* synthetic */ Interceptable $ic;
    public static final SwanAppAllianceLoginHelper$loginStatusChangeCallbacks$2 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1720266841, "Lcom/baidu/swan/apps/alliance/login/SwanAppAllianceLoginHelper$loginStatusChangeCallbacks$2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1720266841, "Lcom/baidu/swan/apps/alliance/login/SwanAppAllianceLoginHelper$loginStatusChangeCallbacks$2;");
                return;
            }
        }
        INSTANCE = new SwanAppAllianceLoginHelper$loginStatusChangeCallbacks$2();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppAllianceLoginHelper$loginStatusChangeCallbacks$2() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function0
    public final List<zj1> invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ArrayList() : (List) invokeV.objValue;
    }
}
