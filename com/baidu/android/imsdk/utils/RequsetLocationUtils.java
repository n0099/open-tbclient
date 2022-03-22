package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class RequsetLocationUtils extends BaseUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RequsetLocationUtils() {
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

    public static Location getLocatioin(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                List<String> providers = locationManager.getProviders(true);
                String str = "gps";
                if (!providers.contains("gps")) {
                    if (providers.contains("network")) {
                        str = "network";
                    } else {
                        LogUtils.e("RequsetLocationUtils", "no available provider");
                    }
                }
                return locationManager.getLastKnownLocation(str);
            }
            return null;
        }
        return (Location) invokeL.objValue;
    }
}
