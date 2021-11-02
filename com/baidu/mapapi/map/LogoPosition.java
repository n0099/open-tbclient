package com.baidu.mapapi.map;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class LogoPosition {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ LogoPosition[] f39377a;
    public static final LogoPosition logoPostionCenterBottom;
    public static final LogoPosition logoPostionCenterTop;
    public static final LogoPosition logoPostionRightBottom;
    public static final LogoPosition logoPostionRightTop;
    public static final LogoPosition logoPostionleftBottom;
    public static final LogoPosition logoPostionleftTop;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1675185, "Lcom/baidu/mapapi/map/LogoPosition;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1675185, "Lcom/baidu/mapapi/map/LogoPosition;");
                return;
            }
        }
        logoPostionleftBottom = new LogoPosition("logoPostionleftBottom", 0);
        logoPostionleftTop = new LogoPosition("logoPostionleftTop", 1);
        logoPostionCenterBottom = new LogoPosition("logoPostionCenterBottom", 2);
        logoPostionCenterTop = new LogoPosition("logoPostionCenterTop", 3);
        logoPostionRightBottom = new LogoPosition("logoPostionRightBottom", 4);
        LogoPosition logoPosition = new LogoPosition("logoPostionRightTop", 5);
        logoPostionRightTop = logoPosition;
        f39377a = new LogoPosition[]{logoPostionleftBottom, logoPostionleftTop, logoPostionCenterBottom, logoPostionCenterTop, logoPostionRightBottom, logoPosition};
    }

    public LogoPosition(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static LogoPosition valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LogoPosition) Enum.valueOf(LogoPosition.class, str) : (LogoPosition) invokeL.objValue;
    }

    public static LogoPosition[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LogoPosition[]) f39377a.clone() : (LogoPosition[]) invokeV.objValue;
    }
}
