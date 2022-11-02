package com.baidu.mapapi.common;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapsdkplatform.comapi.util.g;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class EnvironmentUtilities {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static int d;
    public static int e;
    public static int f;
    public static int g;
    public static g h;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(691484419, "Lcom/baidu/mapapi/common/EnvironmentUtilities;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(691484419, "Lcom/baidu/mapapi/common/EnvironmentUtilities;");
        }
    }

    public EnvironmentUtilities() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getAppCachePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (String) invokeV.objValue;
    }

    public static String getAppSecondCachePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return c;
        }
        return (String) invokeV.objValue;
    }

    public static int getDomTmpStgMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return e;
        }
        return invokeV.intValue;
    }

    public static int getItsTmpStgMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return f;
        }
        return invokeV.intValue;
    }

    public static int getMapTmpStgMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return d;
        }
        return invokeV.intValue;
    }

    public static String getSDCardPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static int getSsgTmpStgMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return g;
        }
        return invokeV.intValue;
    }

    public static String getAppSDCardPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String str = a + "/BaiduMapSDKNew";
            if (str.length() != 0) {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void initAppDirectory(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            if (h == null) {
                g a2 = g.a();
                h = a2;
                a2.a(context);
            }
            String str = a;
            if (str != null && str.length() > 0) {
                b = a + File.separator + "BaiduMapSDKNew" + File.separator + "cache";
            } else {
                a = h.b().a();
                b = h.b().c();
            }
            c = h.b().d();
            d = 52428800;
            e = 52428800;
            f = 5242880;
            g = 52428800;
        }
    }

    public static void setSDCardPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            a = str;
        }
    }
}
