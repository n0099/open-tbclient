package com.baidu.android.common.util;

import android.content.Context;
import b.a.m.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class InternalDeviceIdApis {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class TargetPackageCuidV270Info {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String iscChannelCuid;
        public String upcChannelCuid;

        public TargetPackageCuidV270Info() {
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
    }

    public InternalDeviceIdApis() {
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

    public static l a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            DeviceId.getCUID(context);
            return DeviceId.a(context).a();
        }
        return (l) invokeL.objValue;
    }

    public static String getSelfC270Ids(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            l.a a2 = a(context).a();
            if (a2 != null) {
                return a2.y();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static TargetPackageCuidV270Info getTargetPackageCuid270Info(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            l a2 = a(context);
            TargetPackageCuidV270Info targetPackageCuidV270Info = new TargetPackageCuidV270Info();
            l.a d2 = a2.d(str, "upc");
            if (d2 != null) {
                targetPackageCuidV270Info.upcChannelCuid = d2.y();
            }
            l.a d3 = a2.d(str, "isc");
            if (d3 != null) {
                targetPackageCuidV270Info.iscChannelCuid = d3.y();
            }
            return targetPackageCuidV270Info;
        }
        return (TargetPackageCuidV270Info) invokeLL.objValue;
    }
}
