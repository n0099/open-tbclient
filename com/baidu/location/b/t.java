package com.baidu.location.b;

import android.location.Location;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: b  reason: collision with root package name */
    public static com.baidu.location.c.a f35587b;

    /* renamed from: c  reason: collision with root package name */
    public static Location f35588c;

    /* renamed from: d  reason: collision with root package name */
    public static String f35589d;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f35589d : (String) invokeV.objValue;
    }

    public static void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, null, j2) == null) {
            a = j2;
        }
    }

    public static void a(Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, location) == null) {
            f35588c = location;
        }
    }

    public static void a(com.baidu.location.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            f35587b = aVar;
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            f35589d = str;
        }
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a : invokeV.longValue;
    }

    public static com.baidu.location.c.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f35587b : (com.baidu.location.c.a) invokeV.objValue;
    }

    public static Location d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f35588c : (Location) invokeV.objValue;
    }
}
