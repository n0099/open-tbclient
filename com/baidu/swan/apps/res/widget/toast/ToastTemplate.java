package com.baidu.swan.apps.res.widget.toast;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class ToastTemplate {
    public static final /* synthetic */ ToastTemplate[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ToastTemplate T1;
    public static final ToastTemplate T2;
    public static final ToastTemplate T3;
    public static final ToastTemplate T4;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1183389297, "Lcom/baidu/swan/apps/res/widget/toast/ToastTemplate;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1183389297, "Lcom/baidu/swan/apps/res/widget/toast/ToastTemplate;");
                return;
            }
        }
        T1 = new ToastTemplate("T1", 0);
        T2 = new ToastTemplate("T2", 1);
        T3 = new ToastTemplate("T3", 2);
        ToastTemplate toastTemplate = new ToastTemplate("T4", 3);
        T4 = toastTemplate;
        $VALUES = new ToastTemplate[]{T1, T2, T3, toastTemplate};
    }

    public ToastTemplate(String str, int i2) {
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

    public static ToastTemplate valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ToastTemplate) Enum.valueOf(ToastTemplate.class, str) : (ToastTemplate) invokeL.objValue;
    }

    public static ToastTemplate[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ToastTemplate[]) $VALUES.clone() : (ToastTemplate[]) invokeV.objValue;
    }
}
