package com.baidu.searchbox.aideviceperformanceboxproxy.stickiness;

import android.content.Context;
import com.baidu.searchbox.aideviceperformance.data.UserStickinessSQLiteOpenHelper;
import com.baidu.searchbox.aideviceperformance.stickiness.IStickinessScoreDataProvider;
import com.baidu.searchbox.aideviceperformance.stickiness.StickinessScoreManager;
import com.baidu.searchbox.aideviceperformanceboxproxy.data.UserStickinessSQLiteOpenSingleton;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class StickinessScoreManagerSingleton extends StickinessScoreManager {
    public static /* synthetic */ Interceptable $ic;
    public static StickinessScoreManagerSingleton sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1886679622, "Lcom/baidu/searchbox/aideviceperformanceboxproxy/stickiness/StickinessScoreManagerSingleton;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1886679622, "Lcom/baidu/searchbox/aideviceperformanceboxproxy/stickiness/StickinessScoreManagerSingleton;");
                return;
            }
        }
        sInstance = new StickinessScoreManagerSingleton();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickinessScoreManagerSingleton() {
        super(new IStickinessScoreDataProvider() { // from class: com.baidu.searchbox.aideviceperformanceboxproxy.stickiness.StickinessScoreManagerSingleton.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.searchbox.aideviceperformance.stickiness.IStickinessScoreDataProvider
            public UserStickinessSQLiteOpenHelper getUserStickinessSQLiteOpenHelper(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? UserStickinessSQLiteOpenSingleton.getInstance(context) : (UserStickinessSQLiteOpenHelper) invokeL.objValue;
            }
        });
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((IStickinessScoreDataProvider) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static StickinessScoreManagerSingleton getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sInstance : (StickinessScoreManagerSingleton) invokeV.objValue;
    }
}
