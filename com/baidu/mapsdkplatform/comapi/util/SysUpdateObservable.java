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
/* loaded from: classes3.dex */
public class SysUpdateObservable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile SysUpdateObservable f7968a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public List<SysUpdateObserver> f7969b;

    public SysUpdateObservable() {
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
        this.f7969b = null;
        this.f7969b = new ArrayList();
    }

    public static SysUpdateObservable getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f7968a == null) {
                synchronized (SysUpdateObservable.class) {
                    if (f7968a == null) {
                        f7968a = new SysUpdateObservable();
                    }
                }
            }
            return f7968a;
        }
        return (SysUpdateObservable) invokeV.objValue;
    }

    public void addObserver(SysUpdateObserver sysUpdateObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sysUpdateObserver) == null) {
            this.f7969b.add(sysUpdateObserver);
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (SysUpdateObserver sysUpdateObserver : this.f7969b) {
                if (sysUpdateObserver != null) {
                    sysUpdateObserver.init();
                }
            }
        }
    }

    public void updateNetworkInfo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            for (SysUpdateObserver sysUpdateObserver : this.f7969b) {
                if (sysUpdateObserver != null) {
                    sysUpdateObserver.updateNetworkInfo(context);
                }
            }
        }
    }

    public void updateNetworkProxy(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            for (SysUpdateObserver sysUpdateObserver : this.f7969b) {
                if (sysUpdateObserver != null) {
                    sysUpdateObserver.updateNetworkProxy(context);
                }
            }
        }
    }

    public void updatePhoneInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (SysUpdateObserver sysUpdateObserver : this.f7969b) {
                if (sysUpdateObserver != null) {
                    sysUpdateObserver.updatePhoneInfo();
                }
            }
        }
    }
}
