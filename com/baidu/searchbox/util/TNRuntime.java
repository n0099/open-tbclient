package com.baidu.searchbox.util;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Autowired
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/util/TNRuntime;", "Lcom/baidu/searchbox/util/ITNContext;", "getTNContext", "()Lcom/baidu/searchbox/util/ITNContext;", "mTNContext", "Lcom/baidu/searchbox/util/ITNContext;", "<init>", "()V", "lib_blc_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class TNRuntime {
    public static /* synthetic */ Interceptable $ic;
    public static final TNRuntime INSTANCE;
    public static final ITNContext mTNContext;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2039152144, "Lcom/baidu/searchbox/util/TNRuntime;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2039152144, "Lcom/baidu/searchbox/util/TNRuntime;");
                return;
            }
        }
        INSTANCE = new TNRuntime();
        mTNContext = new ITNContext() { // from class: com.baidu.searchbox.util.TNRuntime$mTNContext$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.searchbox.util.ITNContext
            public boolean isNeedReloadTN() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        };
    }

    public TNRuntime() {
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

    @Inject(force = false)
    public final ITNContext getTNContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return mTNContext;
        }
        return (ITNContext) invokeV.objValue;
    }
}
