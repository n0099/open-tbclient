package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SysUpdateObservable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile SysUpdateObservable a;
    public transient /* synthetic */ FieldHolder $fh;
    public List<SysUpdateObserver> b;

    public SysUpdateObservable() {
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
        this.b = null;
        this.b = new ArrayList();
    }

    public static SysUpdateObservable getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (SysUpdateObservable.class) {
                    if (a == null) {
                        a = new SysUpdateObservable();
                    }
                }
            }
            return a;
        }
        return (SysUpdateObservable) invokeV.objValue;
    }

    public void addObserver(SysUpdateObserver sysUpdateObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sysUpdateObserver) == null) {
            this.b.add(sysUpdateObserver);
        }
    }

    public void init(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            for (SysUpdateObserver sysUpdateObserver : this.b) {
                if (sysUpdateObserver != null) {
                    sysUpdateObserver.init(str);
                }
            }
        }
    }

    public void updateNetworkInfo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            for (SysUpdateObserver sysUpdateObserver : this.b) {
                if (sysUpdateObserver != null) {
                    sysUpdateObserver.updateNetworkInfo(context);
                }
            }
        }
    }

    public void updateNetworkProxy(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            for (SysUpdateObserver sysUpdateObserver : this.b) {
                if (sysUpdateObserver != null) {
                    sysUpdateObserver.updateNetworkProxy(context);
                }
            }
        }
    }

    public void updatePhoneInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            for (SysUpdateObserver sysUpdateObserver : this.b) {
                if (sysUpdateObserver != null) {
                    sysUpdateObserver.updatePhoneInfo(str);
                }
            }
        }
    }
}
