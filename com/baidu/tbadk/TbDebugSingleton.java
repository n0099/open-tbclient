package com.baidu.tbadk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nt4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbDebugSingleton {
    public static /* synthetic */ Interceptable $ic;
    public static volatile TbDebugSingleton mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public nt4 mUrlSwitchMap;

    public TbDebugSingleton() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUrlSwitchMap = null;
    }

    public static TbDebugSingleton getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (mInstance == null) {
                synchronized (TbDebugSingleton.class) {
                    if (mInstance == null) {
                        mInstance = new TbDebugSingleton();
                    }
                }
            }
            return mInstance;
        }
        return (TbDebugSingleton) invokeV.objValue;
    }

    public nt4 getUrlSwitchMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mUrlSwitchMap;
        }
        return (nt4) invokeV.objValue;
    }

    public void setUrlSwitchMap(nt4 nt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nt4Var) == null) {
            this.mUrlSwitchMap = nt4Var;
        }
    }
}
