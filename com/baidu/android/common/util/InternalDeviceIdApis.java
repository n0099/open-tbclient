package com.baidu.android.common.util;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.u00;
/* loaded from: classes.dex */
public class InternalDeviceIdApis {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static u00 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            DeviceId.getCUID(context);
            return DeviceId.a(context).c();
        }
        return (u00) invokeL.objValue;
    }

    public static String getSelfC270Ids(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            u00.a k = a(context).k();
            if (k != null) {
                return k.r();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static TargetPackageCuidV270Info getTargetPackageCuid270Info(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            u00 a = a(context);
            TargetPackageCuidV270Info targetPackageCuidV270Info = new TargetPackageCuidV270Info();
            u00.a b = a.b(str, "upc");
            if (b != null) {
                targetPackageCuidV270Info.upcChannelCuid = b.r();
            }
            u00.a b2 = a.b(str, "isc");
            if (b2 != null) {
                targetPackageCuidV270Info.iscChannelCuid = b2.r();
            }
            return targetPackageCuidV270Info;
        }
        return (TargetPackageCuidV270Info) invokeLL.objValue;
    }
}
