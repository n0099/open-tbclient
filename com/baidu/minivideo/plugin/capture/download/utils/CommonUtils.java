package com.baidu.minivideo.plugin.capture.download.utils;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
import java.text.DecimalFormat;
/* loaded from: classes10.dex */
public class CommonUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final DecimalFormat DF;
    public static String[] PERMISSIONS_STORAGE = null;
    public static final int REQUEST_EXTERNAL_STORAGE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1259881838, "Lcom/baidu/minivideo/plugin/capture/download/utils/CommonUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1259881838, "Lcom/baidu/minivideo/plugin/capture/download/utils/CommonUtils;");
                return;
            }
        }
        DF = new DecimalFormat("0.00");
        PERMISSIONS_STORAGE = new String[]{s.f55293i, "android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    public CommonUtils() {
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

    public static String getDownloadPerSize(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            return DF.format(((float) j2) / 1048576.0f) + "M/" + DF.format(((float) j3) / 1048576.0f) + "M";
        }
        return (String) invokeCommon.objValue;
    }

    public static void verifyStoragePermissions(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, activity) == null) || ContextCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, 1);
    }
}
