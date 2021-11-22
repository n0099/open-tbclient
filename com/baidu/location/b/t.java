package com.baidu.location.b;

import android.location.Location;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f39897a;

    /* renamed from: b  reason: collision with root package name */
    public static com.baidu.location.c.a f39898b;

    /* renamed from: c  reason: collision with root package name */
    public static Location f39899c;

    /* renamed from: d  reason: collision with root package name */
    public static String f39900d;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f39900d : (String) invokeV.objValue;
    }

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, null, j) == null) {
            f39897a = j;
        }
    }

    public static void a(Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, location) == null) {
            f39899c = location;
        }
    }

    public static void a(com.baidu.location.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            f39898b = aVar;
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            f39900d = str;
        }
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f39897a : invokeV.longValue;
    }

    public static com.baidu.location.c.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f39898b : (com.baidu.location.c.a) invokeV.objValue;
    }

    public static Location d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f39899c : (Location) invokeV.objValue;
    }
}
