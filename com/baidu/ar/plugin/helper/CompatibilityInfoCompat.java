package com.baidu.ar.plugin.helper;

import com.baidu.ar.plugin.reflect.FieldUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class CompatibilityInfoCompat {
    public static /* synthetic */ Interceptable $ic;
    public static Class sClass;
    public static Object sDefaultCompatibilityInfo;
    public transient /* synthetic */ FieldHolder $fh;

    public CompatibilityInfoCompat() {
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

    public static Object getDefaultCompatibilityInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sDefaultCompatibilityInfo == null) {
                sDefaultCompatibilityInfo = FieldUtils.readStaticField(getMyClass(), "DEFAULT_COMPATIBILITY_INFO");
            }
            return sDefaultCompatibilityInfo;
        }
        return invokeV.objValue;
    }

    public static Class getMyClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sClass == null) {
                sClass = Class.forName("android.content.res.CompatibilityInfo");
            }
            return sClass;
        }
        return (Class) invokeV.objValue;
    }
}
