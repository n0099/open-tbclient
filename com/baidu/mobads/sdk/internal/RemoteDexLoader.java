package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RemoteDexLoader {
    public static /* synthetic */ Interceptable $ic;
    public static volatile RemoteDexLoader mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public XAdContainerFactoryBuilder adContainerFactoryBuilder;

    public RemoteDexLoader() {
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

    public static RemoteDexLoader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (mInstance == null) {
                synchronized (RemoteDexLoader.class) {
                    if (mInstance == null) {
                        mInstance = new RemoteDexLoader();
                    }
                }
            }
            return mInstance;
        }
        return (RemoteDexLoader) invokeV.objValue;
    }

    public IXAdContainerFactory getContainerFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            XAdContainerFactoryBuilder xAdContainerFactoryBuilder = this.adContainerFactoryBuilder;
            if (xAdContainerFactoryBuilder != null) {
                try {
                    return xAdContainerFactoryBuilder.getXAdContainerFactoryInstance();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (IXAdContainerFactory) invokeV.objValue;
    }

    public void initRemoteDex(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) && this.adContainerFactoryBuilder == null) {
            this.adContainerFactoryBuilder = new XAdContainerFactoryBuilder(context);
        }
    }
}
