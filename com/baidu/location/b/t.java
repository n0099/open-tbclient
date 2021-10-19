package com.baidu.location.b;

import android.location.Location;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f41200a;

    /* renamed from: b  reason: collision with root package name */
    public static com.baidu.location.c.a f41201b;

    /* renamed from: c  reason: collision with root package name */
    public static Location f41202c;

    /* renamed from: d  reason: collision with root package name */
    public static String f41203d;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f41203d : (String) invokeV.objValue;
    }

    public static void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, null, j2) == null) {
            f41200a = j2;
        }
    }

    public static void a(Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, location) == null) {
            f41202c = location;
        }
    }

    public static void a(com.baidu.location.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            f41201b = aVar;
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            f41203d = str;
        }
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f41200a : invokeV.longValue;
    }

    public static com.baidu.location.c.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f41201b : (com.baidu.location.c.a) invokeV.objValue;
    }

    public static Location d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f41202c : (Location) invokeV.objValue;
    }
}
