package com.baidu.fsg.base.utils.compact;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.baidu.fsg.base.utils.reflect.MethodUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BundleCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BundleCompat() {
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

    public static IBinder getBinder(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bundle, str)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return bundle.getBinder(str);
            }
            try {
                return (IBinder) MethodUtils.invokeMethod(bundle, "getIBinder", str);
            } catch (Exception e2) {
                throw new RuntimeException("Bundle putIBinder exception:", e2);
            }
        }
        return (IBinder) invokeLL.objValue;
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, bundle, str, iBinder) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                bundle.putBinder(str, iBinder);
                return;
            }
            try {
                MethodUtils.invokeMethod(bundle, "putIBinder", str, iBinder);
            } catch (Exception e2) {
                throw new RuntimeException("Bundle putIBinder exception:", e2);
            }
        }
    }
}
