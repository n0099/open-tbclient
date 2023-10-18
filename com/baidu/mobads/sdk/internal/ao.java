package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.RouteInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ao extends RouteInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v a;

    public ao(String str) {
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
        setPath(str);
        b();
    }

    private void b() {
        RouteInfo routeInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            try {
                Class<?> cls = Class.forName(w.at + getPath());
                if (cls != null) {
                    Method declaredMethod = cls.getDeclaredMethod("getRoutesMap", new Class[0]);
                    declaredMethod.setAccessible(true);
                    HashMap hashMap = (HashMap) declaredMethod.invoke(null, new Object[0]);
                    if (hashMap != null && hashMap.size() > 0 && (routeInfo = (RouteInfo) hashMap.get(getPath())) != null) {
                        this.a = (v) routeInfo.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.objValue;
    }
}
