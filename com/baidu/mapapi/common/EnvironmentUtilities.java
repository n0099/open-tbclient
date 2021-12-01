package com.baidu.mapapi.common;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapsdkplatform.comapi.util.h;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class EnvironmentUtilities {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static String f35725b;

    /* renamed from: c  reason: collision with root package name */
    public static String f35726c;

    /* renamed from: d  reason: collision with root package name */
    public static int f35727d;

    /* renamed from: e  reason: collision with root package name */
    public static int f35728e;

    /* renamed from: f  reason: collision with root package name */
    public static int f35729f;

    /* renamed from: g  reason: collision with root package name */
    public static h f35730g;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getAppCachePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f35725b : (String) invokeV.objValue;
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

    public static String getAppSecondCachePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f35726c : (String) invokeV.objValue;
    }

    public static int getDomTmpStgMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f35728e : invokeV.intValue;
    }

    public static int getItsTmpStgMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f35729f : invokeV.intValue;
    }

    public static int getMapTmpStgMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f35727d : invokeV.intValue;
    }

    public static String getSDCardPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a : (String) invokeV.objValue;
    }

    public static void initAppDirectory(Context context) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            if (f35730g == null) {
                h a2 = h.a();
                f35730g = a2;
                a2.a(context);
            }
            String str = a;
            if (str == null || str.length() <= 0) {
                a = f35730g.b().a();
                c2 = f35730g.b().c();
            } else {
                c2 = a + File.separator + "BaiduMapSDKNew" + File.separator + "cache";
            }
            f35725b = c2;
            f35726c = f35730g.b().d();
            f35727d = 20971520;
            f35728e = 52428800;
            f35729f = 5242880;
        }
    }

    public static void setSDCardPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            a = str;
        }
    }
}
