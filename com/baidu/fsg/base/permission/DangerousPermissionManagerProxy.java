package com.baidu.fsg.base.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class DangerousPermissionManagerProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.fsg.base.permission.DangerousPermissionManagerProxy$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class SingleInstance {
        public static /* synthetic */ Interceptable $ic;
        public static DangerousPermissionManagerProxy mInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(24082991, "Lcom/baidu/fsg/base/permission/DangerousPermissionManagerProxy$SingleInstance;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(24082991, "Lcom/baidu/fsg/base/permission/DangerousPermissionManagerProxy$SingleInstance;");
                    return;
                }
            }
            mInstance = new DangerousPermissionManagerProxy(null);
        }

        public SingleInstance() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public DangerousPermissionManagerProxy() {
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

    public /* synthetic */ DangerousPermissionManagerProxy(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static DangerousPermissionManagerProxy getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? SingleInstance.mInstance : (DangerousPermissionManagerProxy) invokeV.objValue;
    }

    public boolean isPermissionGroupGranted(Context context, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, strArr)) == null) {
            if (context == null || strArr == null || strArr.length == 0) {
                return false;
            }
            for (String str : strArr) {
                if (Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission(str) != 0) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void requestPermissionsDialog(Activity activity, String[] strArr, RequestPermissionDialogCallBack requestPermissionDialogCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, strArr, requestPermissionDialogCallBack) == null) {
            requestPermissionDialogCallBack.isAllAgree(true);
        }
    }
}
