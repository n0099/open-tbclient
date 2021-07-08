package com.baidu.mobads.container.adrequest;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class AdTaskType {
    public static final /* synthetic */ AdTaskType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AdTaskType AD_CLICK;
    public static final AdTaskType AD_IMPRESSION;
    public static final AdTaskType HANDLE_EVENT;
    public static final AdTaskType UNSPECIFIED;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mAdTaskType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1860485463, "Lcom/baidu/mobads/container/adrequest/AdTaskType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1860485463, "Lcom/baidu/mobads/container/adrequest/AdTaskType;");
                return;
            }
        }
        AD_CLICK = new AdTaskType("AD_CLICK", 0, IAdInterListener.AdCommandType.AD_CLICK);
        AD_IMPRESSION = new AdTaskType("AD_IMPRESSION", 1, IAdInterListener.AdCommandType.AD_IMPRESSION);
        HANDLE_EVENT = new AdTaskType("HANDLE_EVENT", 2, IAdInterListener.AdCommandType.HANDLE_EVENT);
        AdTaskType adTaskType = new AdTaskType("UNSPECIFIED", 3, "");
        UNSPECIFIED = adTaskType;
        $VALUES = new AdTaskType[]{AD_CLICK, AD_IMPRESSION, HANDLE_EVENT, adTaskType};
    }

    public AdTaskType(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAdTaskType = str2;
    }

    public static AdTaskType getAdTaskType(String str) {
        InterceptResult invokeL;
        AdTaskType[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            for (AdTaskType adTaskType : values()) {
                if (adTaskType.mAdTaskType.equals(str)) {
                    return adTaskType;
                }
            }
            return UNSPECIFIED;
        }
        return (AdTaskType) invokeL.objValue;
    }

    public static AdTaskType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (AdTaskType) Enum.valueOf(AdTaskType.class, str) : (AdTaskType) invokeL.objValue;
    }

    public static AdTaskType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (AdTaskType[]) $VALUES.clone() : (AdTaskType[]) invokeV.objValue;
    }
}
