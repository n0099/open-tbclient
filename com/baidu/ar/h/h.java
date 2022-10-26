package com.baidu.ar.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Object xY;
    public volatile int xZ;
    public String ya;

    public h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.xZ = 0;
        this.ya = str;
    }

    public Object gA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.xY != null) {
                return this.xY;
            }
            if (isAvailable()) {
                synchronized (this) {
                    if (this.xY == null) {
                        this.xY = n.aV(this.ya);
                    }
                }
            }
            return this.xY;
        }
        return invokeV.objValue;
    }

    public Object gB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.xY : invokeV.objValue;
    }

    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.xZ == 1) {
                return true;
            }
            boolean z = false;
            if (this.xZ == -1) {
                return false;
            }
            try {
                Class.forName(this.ya);
                z = true;
            } catch (ClassNotFoundException unused) {
            }
            synchronized (this) {
                this.xZ = z ? 1 : -1;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.xY == null) {
            return;
        }
        this.xY = null;
    }
}
