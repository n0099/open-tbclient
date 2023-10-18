package com.baidu.mobads.sdk.api.annotation;

import com.baidu.mobads.sdk.api.AdservRemoteLoaderImpl;
import com.baidu.mobads.sdk.api.RouteInfo;
import com.baidu.mobads.sdk.internal.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class remote_adserv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public remote_adserv() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static HashMap<String, RouteInfo> getRoutesMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            HashMap<String, RouteInfo> hashMap = new HashMap<>();
            hashMap.put(c.a.a, RouteInfo.build(AdservRemoteLoaderImpl.class, c.a.a));
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }
}
