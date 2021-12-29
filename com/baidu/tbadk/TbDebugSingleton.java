package com.baidu.tbadk;

import c.a.s0.m.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class TbDebugSingleton {
    public static /* synthetic */ Interceptable $ic;
    public static volatile TbDebugSingleton mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public d mUrlSwitchMap;

    public TbDebugSingleton() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public d getUrlSwitchMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mUrlSwitchMap : (d) invokeV.objValue;
    }

    public void setUrlSwitchMap(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.mUrlSwitchMap = dVar;
        }
    }
}
