package com.baidu.mapsdkplatform.comjni.engine;

import android.content.Context;
import android.os.Bundle;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AppEngine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AppEngine() {
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

    public static void InitClass() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            JNIEngine.initClass(new Bundle(), 0);
        }
    }

    public static boolean InitEngine(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? JNIEngine.InitEngine(context) : invokeL.booleanValue;
    }

    public static void SetProxyInfo(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, str, i2) == null) {
            JNIEngine.SetProxyInfo(str, i2);
        }
    }

    public static boolean StartSocketProc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? JNIEngine.StartSocketProc() : invokeV.booleanValue;
    }

    public static boolean UnInitEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? JNIEngine.UnInitEngine() : invokeV.booleanValue;
    }

    public static void despatchMessage(int i2, int i3, int i4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) {
            a.a(i2, i3, i4, j);
        }
    }
}
