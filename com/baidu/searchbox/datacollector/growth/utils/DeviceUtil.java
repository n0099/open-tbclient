package com.baidu.searchbox.datacollector.growth.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import c.a.r.b;
import c.a.r.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class DeviceUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1410460899, "Lcom/baidu/searchbox/datacollector/growth/utils/DeviceUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1410460899, "Lcom/baidu/searchbox/datacollector/growth/utils/DeviceUtil;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public DeviceUtil() {
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

    public static void generateOaid(Context context, IDeviceCallback iDeviceCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, iDeviceCallback) == null) {
            b e2 = b.e(context);
            if (e2 != null) {
                e2.m(new c<String>(iDeviceCallback) { // from class: com.baidu.searchbox.datacollector.growth.utils.DeviceUtil.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IDeviceCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {iDeviceCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$callback = iDeviceCallback;
                    }

                    @Override // c.a.r.c
                    public void onError(int i2, Throwable th, Bundle bundle) {
                        IDeviceCallback iDeviceCallback2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, th, bundle) == null) || (iDeviceCallback2 = this.val$callback) == null) {
                            return;
                        }
                        iDeviceCallback2.onFail();
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // c.a.r.c
                    public void onResult(String str, Bundle bundle) {
                        IDeviceCallback iDeviceCallback2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle) == null) || (iDeviceCallback2 = this.val$callback) == null) {
                            return;
                        }
                        iDeviceCallback2.onSuccess(str);
                    }
                });
            } else if (iDeviceCallback != null) {
                iDeviceCallback.onFail();
            }
        }
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                return "";
            }
            if (i2 < 23 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                String str = null;
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        str = telephonyManager.getDeviceId();
                    }
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
                return TextUtils.isEmpty(str) ? "" : str;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
