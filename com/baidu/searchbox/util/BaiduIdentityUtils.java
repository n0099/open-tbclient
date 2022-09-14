package com.baidu.searchbox.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.baidu.android.common.util.DeviceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes2.dex */
public class BaiduIdentityUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SYSTEM_APP = 1;
    public static final int SYSTEM_UPDATE_APP = 2;
    public static final int USER_APP = 0;
    public transient /* synthetic */ FieldHolder $fh;

    public BaiduIdentityUtils() {
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

    public static int getAppType(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
                if ((applicationInfo.flags & 128) == 128) {
                    return 2;
                }
                return (applicationInfo.flags & 1) == 1 ? 1 : 0;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static String getSoftwareUUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String deviceID = DeviceId.getDeviceID(context);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("10");
            stringBuffer.append(deviceID.substring(0, deviceID.length() / 2));
            int parseInt = Integer.parseInt(Character.toString(deviceID.charAt(2)), 16);
            for (int i = 0; i < 4; i++) {
                stringBuffer.append(deviceID.charAt((((i * 8) + parseInt) + 1) % deviceID.length()));
            }
            stringBuffer.append(deviceID.substring(deviceID.length() / 2));
            return stringBuffer.toString().toUpperCase(Locale.getDefault());
        }
        return (String) invokeL.objValue;
    }
}
