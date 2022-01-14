package com.baidu.searchbox.aideviceperformanceboxproxy.data;

import android.content.Context;
import com.baidu.searchbox.aideviceperformance.data.UserStickinessSQLiteOpenHelper;
import com.baidu.searchbox.aideviceperformance.stickiness.IUserStickinessBusinessDataProvider;
import com.baidu.searchbox.aideviceperformanceboxproxy.stickiness.UserStickinessRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class UserStickinessSQLiteOpenSingleton extends UserStickinessSQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public static UserStickinessSQLiteOpenSingleton instance;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserStickinessSQLiteOpenSingleton(Context context) {
        super(context, UserStickinessRuntime.getDefaultHandler());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (IUserStickinessBusinessDataProvider) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static UserStickinessSQLiteOpenSingleton getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (instance == null) {
                synchronized (UserStickinessSQLiteOpenSingleton.class) {
                    if (instance == null) {
                        instance = new UserStickinessSQLiteOpenSingleton(context);
                    }
                }
            }
            return instance;
        }
        return (UserStickinessSQLiteOpenSingleton) invokeL.objValue;
    }
}
