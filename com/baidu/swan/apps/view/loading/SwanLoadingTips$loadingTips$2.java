package com.baidu.swan.apps.view.loading;

import android.app.Application;
import android.content.res.Resources;
import c.a.p0.a.s0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a*\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u0001 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "invoke", "()[Ljava/lang/String;"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public final class SwanLoadingTips$loadingTips$2 extends Lambda implements Function0<String[]> {
    public static /* synthetic */ Interceptable $ic;
    public static final SwanLoadingTips$loadingTips$2 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(590711082, "Lcom/baidu/swan/apps/view/loading/SwanLoadingTips$loadingTips$2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(590711082, "Lcom/baidu/swan/apps/view/loading/SwanLoadingTips$loadingTips$2;");
                return;
            }
        }
        INSTANCE = new SwanLoadingTips$loadingTips$2();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTips$loadingTips$2() {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function0
    public final String[] invoke() {
        InterceptResult invokeV;
        Resources resources;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (((int) (Math.random() * 2)) != 0) {
                Application c2 = a.c();
                if (c2 == null || (resources2 = c2.getResources()) == null) {
                    return null;
                }
                return resources2.getStringArray(R.array.aiapps_loading_tips_prepare);
            }
            Application c3 = a.c();
            if (c3 == null || (resources = c3.getResources()) == null) {
                return null;
            }
            return resources.getStringArray(R.array.aiapps_loading_tips_skill);
        }
        return (String[]) invokeV.objValue;
    }
}
