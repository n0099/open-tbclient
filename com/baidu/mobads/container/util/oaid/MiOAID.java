package com.baidu.mobads.container.util.oaid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class MiOAID {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MiOAID() {
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

    public static String getMIOAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                UniqueIdUtils.sendSDKTypeLog(context, "mi-start", "");
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                if (cls != null) {
                    Object newInstance = cls.newInstance();
                    Method method = cls.getMethod("getOAID", Context.class);
                    if (newInstance != null && method != null) {
                        String str = (String) method.invoke(newInstance, context);
                        if (TextUtils.isEmpty(str)) {
                            UniqueIdUtils.sendSDKTypeLog(context, "mi-empty", "");
                        } else {
                            UniqueIdUtils.sendSDKTypeLog(context, "mi-valid", str);
                            UniqueIdUtils.miitOAID = str;
                        }
                        return str;
                    }
                }
            } catch (Throwable th) {
                UniqueIdUtils.sendSDKTypeLog(context, "mi-error" + th.getMessage(), "");
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isXiaomiBrand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                String phoneOSBrand = DeviceUtils.getInstance().getPhoneOSBrand();
                if (TextUtils.isEmpty(phoneOSBrand)) {
                    return false;
                }
                if (!phoneOSBrand.equalsIgnoreCase(RomUtils.MANUFACTURER_XIAOMI)) {
                    if (!phoneOSBrand.equalsIgnoreCase("redmi")) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
