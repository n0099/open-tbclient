package com.baidu.pass.face.platform;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class LicenseStatusEnum {
    public static final /* synthetic */ LicenseStatusEnum[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LicenseStatusEnum StateErrorAuthorized;
    public static final LicenseStatusEnum StateErrorBegin;
    public static final LicenseStatusEnum StateErrorExpired;
    public static final LicenseStatusEnum StateErrorNetwork;
    public static final LicenseStatusEnum StateErrorNotFindLicense;
    public static final LicenseStatusEnum StateInitializing;
    public static final LicenseStatusEnum StateNotInit;
    public static final LicenseStatusEnum StateSuccess;
    public static final LicenseStatusEnum StateUnknown;
    public static final LicenseStatusEnum StateWarningValidityComing;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1938428415, "Lcom/baidu/pass/face/platform/LicenseStatusEnum;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1938428415, "Lcom/baidu/pass/face/platform/LicenseStatusEnum;");
                return;
            }
        }
        StateSuccess = new LicenseStatusEnum("StateSuccess", 0);
        StateWarningValidityComing = new LicenseStatusEnum("StateWarningValidityComing", 1);
        StateErrorBegin = new LicenseStatusEnum("StateErrorBegin", 2);
        StateErrorNotFindLicense = new LicenseStatusEnum("StateErrorNotFindLicense", 3);
        StateErrorExpired = new LicenseStatusEnum("StateErrorExpired", 4);
        StateErrorAuthorized = new LicenseStatusEnum("StateErrorAuthorized", 5);
        StateErrorNetwork = new LicenseStatusEnum("StateErrorNetwork", 6);
        StateNotInit = new LicenseStatusEnum("StateNotInit", 7);
        StateInitializing = new LicenseStatusEnum("StateInitializing", 8);
        LicenseStatusEnum licenseStatusEnum = new LicenseStatusEnum("StateUnknown", 9);
        StateUnknown = licenseStatusEnum;
        $VALUES = new LicenseStatusEnum[]{StateSuccess, StateWarningValidityComing, StateErrorBegin, StateErrorNotFindLicense, StateErrorExpired, StateErrorAuthorized, StateErrorNetwork, StateNotInit, StateInitializing, licenseStatusEnum};
    }

    public LicenseStatusEnum(String str, int i2) {
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

    public static LicenseStatusEnum getLicenseStatus(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? StateUnknown : (LicenseStatusEnum) invokeI.objValue;
    }

    public static LicenseStatusEnum valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (LicenseStatusEnum) Enum.valueOf(LicenseStatusEnum.class, str) : (LicenseStatusEnum) invokeL.objValue;
    }

    public static LicenseStatusEnum[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (LicenseStatusEnum[]) $VALUES.clone() : (LicenseStatusEnum[]) invokeV.objValue;
    }
}
