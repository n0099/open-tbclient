package com.baidu.mapapi.search.base;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class LanguageType {
    public static final /* synthetic */ LanguageType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LanguageType LanguageTypeChinese;
    public static final LanguageType LanguageTypeEnglish;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1096295471, "Lcom/baidu/mapapi/search/base/LanguageType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1096295471, "Lcom/baidu/mapapi/search/base/LanguageType;");
                return;
            }
        }
        LanguageTypeChinese = new LanguageType("LanguageTypeChinese", 0);
        LanguageType languageType = new LanguageType("LanguageTypeEnglish", 1);
        LanguageTypeEnglish = languageType;
        $VALUES = new LanguageType[]{LanguageTypeChinese, languageType};
    }

    public LanguageType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static LanguageType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (LanguageType) Enum.valueOf(LanguageType.class, str);
        }
        return (LanguageType) invokeL.objValue;
    }

    public static LanguageType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (LanguageType[]) $VALUES.clone();
        }
        return (LanguageType[]) invokeV.objValue;
    }
}
