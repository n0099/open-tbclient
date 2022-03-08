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
/* loaded from: classes4.dex */
public class EnvironmentUtilities {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static String f33813b;

    /* renamed from: c  reason: collision with root package name */
    public static String f33814c;

    /* renamed from: d  reason: collision with root package name */
    public static int f33815d;

    /* renamed from: e  reason: collision with root package name */
    public static int f33816e;

    /* renamed from: f  reason: collision with root package name */
    public static int f33817f;

    /* renamed from: g  reason: collision with root package name */
    public static h f33818g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f33813b : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f33814c : (String) invokeV.objValue;
    }

    public static int getDomTmpStgMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f33816e : invokeV.intValue;
    }

    public static int getItsTmpStgMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f33817f : invokeV.intValue;
    }

    public static int getMapTmpStgMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f33815d : invokeV.intValue;
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
            if (f33818g == null) {
                h a2 = h.a();
                f33818g = a2;
                a2.a(context);
            }
            String str = a;
            if (str == null || str.length() <= 0) {
                a = f33818g.b().a();
                c2 = f33818g.b().c();
            } else {
                c2 = a + File.separator + "BaiduMapSDKNew" + File.separator + "cache";
            }
            f33813b = c2;
            f33814c = f33818g.b().d();
            f33815d = 20971520;
            f33816e = 52428800;
            f33817f = 5242880;
        }
    }

    public static void setSDCardPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            a = str;
        }
    }
}
