package com.baidu.tbadk.core.util.httpNet;

import android.net.Proxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
/* loaded from: classes3.dex */
public class NetWorkUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NET_TYPE_NET = "1";
    public static final String NET_TYPE_WAP = "2";
    public static final String NET_TYPE_WIFI = "3";
    public transient /* synthetic */ FieldHolder $fh;

    public NetWorkUtil() {
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

    public static String getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                if (j.z()) {
                    if (j.H()) {
                        return "3";
                    }
                    String defaultHost = Proxy.getDefaultHost();
                    if (defaultHost != null) {
                        if (defaultHost.length() > 0) {
                            return "2";
                        }
                    }
                    return "1";
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
