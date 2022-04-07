package com.baidu.ar;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class DuMixErrorType {
    public static final /* synthetic */ DuMixErrorType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DuMixErrorType AbilitySchemeFetchFail;
    public static final DuMixErrorType LibraryError;
    public static final DuMixErrorType LoadCaseError;
    public static final DuMixErrorType MMLLibraryError;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(199772948, "Lcom/baidu/ar/DuMixErrorType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(199772948, "Lcom/baidu/ar/DuMixErrorType;");
                return;
            }
        }
        LibraryError = new DuMixErrorType("LibraryError", 0);
        LoadCaseError = new DuMixErrorType("LoadCaseError", 1);
        AbilitySchemeFetchFail = new DuMixErrorType("AbilitySchemeFetchFail", 2);
        DuMixErrorType duMixErrorType = new DuMixErrorType("MMLLibraryError", 3);
        MMLLibraryError = duMixErrorType;
        $VALUES = new DuMixErrorType[]{LibraryError, LoadCaseError, AbilitySchemeFetchFail, duMixErrorType};
    }

    public DuMixErrorType(String str, int i) {
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

    public static DuMixErrorType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DuMixErrorType) Enum.valueOf(DuMixErrorType.class, str) : (DuMixErrorType) invokeL.objValue;
    }

    public static DuMixErrorType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DuMixErrorType[]) $VALUES.clone() : (DuMixErrorType[]) invokeV.objValue;
    }
}
