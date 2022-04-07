package com.baidu.android.imsdk.internal;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class IMNetWorkFlowStatic {
    public static /* synthetic */ Interceptable $ic;
    public static IMNetWorkFlowStatic mStatic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mMobileFlow;
    public long mWifiFlow;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1391527040, "Lcom/baidu/android/imsdk/internal/IMNetWorkFlowStatic;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1391527040, "Lcom/baidu/android/imsdk/internal/IMNetWorkFlowStatic;");
        }
    }

    public IMNetWorkFlowStatic() {
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

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IMNetWorkFlowStatic iMNetWorkFlowStatic = mStatic;
            iMNetWorkFlowStatic.mMobileFlow = 0L;
            iMNetWorkFlowStatic.mMobileFlow = 0L;
        }
    }

    public IMNetWorkFlowStatic getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (mStatic == null) {
                mStatic = new IMNetWorkFlowStatic();
            }
            return mStatic;
        }
        return (IMNetWorkFlowStatic) invokeV.objValue;
    }

    public long getMobileFlow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? mStatic.mMobileFlow : invokeV.longValue;
    }

    public long getWifiFlow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? mStatic.mWifiFlow : invokeV.longValue;
    }
}
