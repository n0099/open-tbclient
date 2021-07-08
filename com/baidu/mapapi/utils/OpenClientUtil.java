package com.baidu.mapapi.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class OpenClientUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OpenClientUtil() {
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

    public static int getBaiduMapVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            try {
                String str = context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 0).versionName;
                if (str != null && str.length() > 0) {
                    return Integer.valueOf(str.trim().replace(".", "").trim()).intValue();
                }
            } catch (Exception unused) {
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void getLatestBaiduMapApp(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, context) == null) || context == null) {
            return;
        }
        String b2 = b.b(context);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://map.baidu.com/zt/client/index/?fr=sdk_[" + b2 + PreferencesUtil.RIGHT_MOUNT));
        context.startActivity(intent);
    }
}
