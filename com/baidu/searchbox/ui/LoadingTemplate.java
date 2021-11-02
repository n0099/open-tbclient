package com.baidu.searchbox.ui;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class LoadingTemplate {
    public static final /* synthetic */ LoadingTemplate[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LoadingTemplate T1;
    public static final LoadingTemplate T2;
    public static final LoadingTemplate T3;
    public static final LoadingTemplate T4;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1058268634, "Lcom/baidu/searchbox/ui/LoadingTemplate;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1058268634, "Lcom/baidu/searchbox/ui/LoadingTemplate;");
                return;
            }
        }
        T1 = new LoadingTemplate("T1", 0);
        T2 = new LoadingTemplate("T2", 1);
        T3 = new LoadingTemplate("T3", 2);
        LoadingTemplate loadingTemplate = new LoadingTemplate("T4", 3);
        T4 = loadingTemplate;
        $VALUES = new LoadingTemplate[]{T1, T2, T3, loadingTemplate};
    }

    public LoadingTemplate(String str, int i2) {
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

    public static LoadingTemplate valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LoadingTemplate) Enum.valueOf(LoadingTemplate.class, str) : (LoadingTemplate) invokeL.objValue;
    }

    public static LoadingTemplate[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LoadingTemplate[]) $VALUES.clone() : (LoadingTemplate[]) invokeV.objValue;
    }
}
